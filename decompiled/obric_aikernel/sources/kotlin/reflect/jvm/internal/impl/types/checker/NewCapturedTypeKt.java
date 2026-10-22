package kotlin.reflect.jvm.internal.impl.types.checker;

import com.bytedance.common.wschannel.WsConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class NewCapturedTypeKt {
    private static final List<TypeProjection> captureArguments(UnwrappedType r11, CaptureStatus r12) {
        if (r11.getArguments().size() == r11.getConstructor().getParameters().size()) goto L5;
        return null;
    L5:
        List<TypeProjection> r10 = r11.getArguments();
        int r13 = 0;
        boolean r14 = true;
        if ((r10 instanceof Collection) == true) goto L8;
    L10:
        Iterator<T> r15 = r10.iterator();
    L12:
        if (r15.hasNext() == false) goto L19;
        if (((TypeProjection) r15.next()).getProjectionKind() != Variance.INVARIANT) goto L16;
        boolean r16 = true;
    L17:
        if (r16 == true) goto L12;
        r14 = false;
        goto L19
    L16:
        r16 = false;
    L19:
        if (r14 == false) goto L21;
        return null;
    L21:
        List<TypeParameterDescriptor> r17 = r11.getConstructor().getParameters();
        Intrinsics.checkNotNullExpressionValue(r17, "type.constructor.parameters");
        List r18 = CollectionsKt.zip(r10, r17);
        ArrayList r19 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r18, 10));
        Iterator r20 = r18.iterator();
    L23:
        if (r20.hasNext() == false) goto L35;
        Pair r21 = (Pair) r20.next();
        TypeProjection r22 = (TypeProjection) r21.component1();
        TypeParameterDescriptor r23 = (TypeParameterDescriptor) r21.component2();
        if (r22.getProjectionKind() == Variance.INVARIANT) goto L34;
        if (r22.isStarProjection() == false) goto L30;
    L32:
        UnwrappedType r24 = null;
    L33:
        Intrinsics.checkNotNullExpressionValue(r23, "parameter");
        r22 = TypeUtilsKt.asTypeProjection(new NewCapturedType(r12, r24, r22, r23));
        goto L34
    L30:
        if (r22.getProjectionKind() != Variance.IN_VARIANCE) goto L32;
        r24 = r22.getType().unwrap();
    L34:
        r19.add(r22);
        goto L23
    L35:
        TypeSubstitutor r110 = TypeConstructorSubstitution.Companion.create(r11.getConstructor(), r19).buildSubstitutor();
        int r25 = r10.size();
    L36:
        if (r13 >= r25) goto L50;
        TypeProjection r26 = r10.get(r13);
        TypeProjection r27 = (TypeProjection) r19.get(r13);
        if (r26.getProjectionKind() == Variance.INVARIANT) goto L49;
        List<KotlinType> r28 = r11.getConstructor().getParameters().get(r13).getUpperBounds();
        Intrinsics.checkNotNullExpressionValue(r28, "type.constructor.parameters[index].upperBounds");
        ArrayList r29 = new ArrayList();
        Iterator<T> r30 = r28.iterator();
    L41:
        if (r30.hasNext() == false) goto L44;
        r29.add(KotlinTypePreparator.Default.INSTANCE.prepareType(r110.safeSubstitute((KotlinType) r30.next(), Variance.INVARIANT).unwrap()));
        goto L41
    L44:
        if (r26.isStarProjection() == false) goto L46;
    L48:
        KotlinType r31 = r27.getType();
        Intrinsics.checkNotNull(r31, "null cannot be cast to non-null type org.jetbrains.kotlin.types.checker.NewCapturedType");
        ((NewCapturedType) r31).getConstructor().initializeSupertypes(r29);
        goto L49
    L46:
        if (r26.getProjectionKind() != Variance.OUT_VARIANCE) goto L48;
        r29.add(KotlinTypePreparator.Default.INSTANCE.prepareType(r26.getType().unwrap()));
    L49:
        r13 = r13 + 1;
        goto L36
    L50:
        return r19;
    L8:
        if (r10.isEmpty() == false) goto L10;
        goto L10
    }

    public static final SimpleType captureFromArguments(SimpleType r10, CaptureStatus r11) {
        Intrinsics.checkNotNullParameter(r10, WsConstants.KEY_CONNECTION_TYPE);
        Intrinsics.checkNotNullParameter(r11, "status");
        List<TypeProjection> r12 = captureArguments(r10, r11);
        if (r12 != null) goto L7;
        return null;
    L7:
        return replaceArguments(r10, r12);
    }

    private static final SimpleType replaceArguments(UnwrappedType r10, List<? extends TypeProjection> r11) {
        return KotlinTypeFactory.simpleType$default(r10.getAttributes(), r10.getConstructor(), r11, r10.isMarkedNullable(), null, 16, null);
    }
}
