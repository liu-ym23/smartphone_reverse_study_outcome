package kotlin.reflect.jvm.internal.impl.types.checker;

import androidx.core.app.NotificationCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
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
@SourceDebugExtension({"SMAP\nNewCapturedType.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NewCapturedType.kt\norg/jetbrains/kotlin/types/checker/NewCapturedTypeKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,290:1\n1#2:291\n1#2:310\n1655#3,8:292\n1603#3,9:300\n1855#3:309\n1856#3:311\n1612#3:312\n1726#3,3:313\n1549#3:316\n1620#3,3:317\n1620#3,3:320\n1549#3:323\n1620#3,3:324\n*S KotlinDebug\n*F\n+ 1 NewCapturedType.kt\norg/jetbrains/kotlin/types/checker/NewCapturedTypeKt\n*L\n122#1:310\n117#1:292,8\n122#1:300,9\n122#1:309\n122#1:311\n122#1:312\n154#1:313,3\n156#1:316\n156#1:317,3\n176#1:320,3\n81#1:323\n81#1:324,3\n*E\n"})
public final class NewCapturedTypeKt {
    private static final List<TypeProjection> captureArguments(UnwrappedType r11, CaptureStatus r12) {
        if (r11.getArguments().size() == r11.getConstructor().getParameters().size()) goto L5;
        return null;
    L5:
        List<TypeProjection> r5 = r11.getArguments();
        if (r5 != null) goto L8;
    L10:
        Iterator<T> r10 = r5.iterator();
    L12:
        if (r10.hasNext() == false) goto L46;
        if (((TypeProjection) r10.next()).getProjectionKind() == Variance.INVARIANT) goto L12;
        List r13 = CollectionsKt.zip(r5, r11.getConstructor().getParameters());
        ArrayList r14 = new ArrayList(CollectionsKt.h(r13));
        Iterator r15 = r13.iterator();
    L18:
        if (r15.hasNext() == false) goto L30;
        Pair r16 = (Pair) r15.next();
        TypeProjection r17 = (TypeProjection) r16.component1();
        TypeParameterDescriptor r18 = (TypeParameterDescriptor) r16.component2();
        if (r17.getProjectionKind() == Variance.INVARIANT) goto L29;
        if (r17.isStarProjection() == false) goto L25;
    L27:
        UnwrappedType r19 = null;
    L28:
        r17 = TypeUtilsKt.asTypeProjection(new NewCapturedType(r12, r19, r17, r18));
        goto L29
    L25:
        if (r17.getProjectionKind() != Variance.IN_VARIANCE) goto L27;
        r19 = r17.getType().unwrap();
    L29:
        r14.add(r17);
        goto L18
    L30:
        TypeSubstitutor r110 = TypeConstructorSubstitution.Companion.create(r11.getConstructor(), r14).buildSubstitutor();
        int r20 = r5.size();
        int r21 = 0;
    L31:
        if (r21 >= r20) goto L45;
        TypeProjection r22 = r5.get(r21);
        TypeProjection r23 = (TypeProjection) r14.get(r21);
        if (r22.getProjectionKind() == Variance.INVARIANT) goto L44;
        List<KotlinType> r24 = r11.getConstructor().getParameters().get(r21).getUpperBounds();
        ArrayList r25 = new ArrayList();
        Iterator<T> r26 = r24.iterator();
    L36:
        if (r26.hasNext() == false) goto L39;
        r25.add(KotlinTypePreparator.Default.INSTANCE.prepareType(r110.safeSubstitute((KotlinType) r26.next(), Variance.INVARIANT).unwrap()));
        goto L36
    L39:
        if (r22.isStarProjection() == false) goto L41;
    L43:
        KotlinType r27 = r23.getType();
        Intrinsics.checkNotNull(r27, "null cannot be cast to non-null type org.jetbrains.kotlin.types.checker.NewCapturedType");
        ((NewCapturedType) r27).getConstructor().initializeSupertypes(r25);
        goto L44
    L41:
        if (r22.getProjectionKind() != Variance.OUT_VARIANCE) goto L43;
        r25.add(KotlinTypePreparator.Default.INSTANCE.prepareType(r22.getType().unwrap()));
    L44:
        r21 = r21 + 1;
        goto L31
    L45:
        return r14;
    L46:
        return null;
    L8:
        if (r5.isEmpty() == false) goto L10;
        goto L10
    }

    public static final SimpleType captureFromArguments(SimpleType r5, CaptureStatus r10) {
        Intrinsics.checkNotNullParameter(r5, "type");
        Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_STATUS);
        List<TypeProjection> r11 = captureArguments(r5, r10);
        if (r11 != null) goto L7;
        return null;
    L7:
        return replaceArguments(r5, r11);
    }

    private static final SimpleType replaceArguments(UnwrappedType r10, List<? extends TypeProjection> r11) {
        return KotlinTypeFactory.simpleType$default(r10.getAttributes(), r10.getConstructor(), r11, r10.isMarkedNullable(), null, 16, null);
    }
}
