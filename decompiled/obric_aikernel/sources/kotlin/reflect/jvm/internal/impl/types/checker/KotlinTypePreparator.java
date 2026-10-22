package kotlin.reflect.jvm.internal.impl.types.checker;

import com.bytedance.common.wschannel.WsConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorImpl;
import kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerValueTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypePreparator;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancementKt;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* JADX INFO: loaded from: classes3.dex */
public abstract class KotlinTypePreparator extends AbstractTypePreparator {

    public static final class Default extends KotlinTypePreparator {
        public static final Default INSTANCE = null;

        static {
            INSTANCE = new Default();
        }

        private Default() {
        }
    }

    /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypePreparator$prepareType$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 extends FunctionReference implements Function1<KotlinTypeMarker, UnwrappedType> {
        AnonymousClass1(Object r10) {
            super(1, r10);
        }

        @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
        public final String getName() {
            return "prepareType";
        }

        @Override // kotlin.jvm.internal.CallableReference
        public final KDeclarationContainer getOwner() {
            return Reflection.getOrCreateKotlinClass(KotlinTypePreparator.class);
        }

        @Override // kotlin.jvm.internal.CallableReference
        public final String getSignature() {
            return "prepareType(Lorg/jetbrains/kotlin/types/model/KotlinTypeMarker;)Lorg/jetbrains/kotlin/types/UnwrappedType;";
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ UnwrappedType invoke(KotlinTypeMarker r10) {
            return invoke2(r10);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final UnwrappedType invoke2(KotlinTypeMarker r10) {
            Intrinsics.checkNotNullParameter(r10, "p0");
            return ((KotlinTypePreparator) this.receiver).prepareType(r10);
        }
    }

    public KotlinTypePreparator() {
    }

    private final SimpleType transformToNewType(SimpleType r17) {
        TypeConstructor r10 = r17.getConstructor();
        boolean r11 = true;
        boolean r12 = false;
        IntersectionTypeConstructor r13 = null;
        UnwrappedType r14 = null;
        r14 = null;
        KotlinType r15 = null;
        if ((r10 instanceof CapturedTypeConstructorImpl) == false) goto L25;
        CapturedTypeConstructorImpl r16 = (CapturedTypeConstructorImpl) r10;
        TypeProjection r18 = r16.getProjection();
        if (r18.getProjectionKind() == Variance.IN_VARIANCE) goto L8;
        r11 = false;
    L8:
        if (r11 == true) goto L11;
        r18 = null;
    L11:
        if (r18 == null) goto L15;
        KotlinType r19 = r18.getType();
        if (r19 == null) goto L15;
        r14 = r19.unwrap();
    L15:
        UnwrappedType r20 = r14;
        if (r16.getNewTypeConstructor() != null) goto L22;
        TypeProjection r110 = r16.getProjection();
        Collection<KotlinType> r21 = r16.mo1324getSupertypes();
        ArrayList r111 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r21, 10));
        Iterator<T> r22 = r21.iterator();
    L19:
        if (r22.hasNext() == false) goto L21;
        r111.add(((KotlinType) r22.next()).unwrap());
        goto L19
    L21:
        r16.setNewTypeConstructor(new NewCapturedTypeConstructor(r110, r111, null, 4, null));
    L22:
        CaptureStatus r23 = CaptureStatus.FOR_SUBTYPING;
        NewCapturedTypeConstructor r24 = r16.getNewTypeConstructor();
        Intrinsics.checkNotNull(r24);
        return new NewCapturedType(r23, r24, r20, r17.getAttributes(), r17.isMarkedNullable(), false, 32, null);
    L25:
        if ((r10 instanceof IntegerValueTypeConstructor) == false) goto L33;
        Collection<KotlinType> r25 = ((IntegerValueTypeConstructor) r10).mo1324getSupertypes();
        ArrayList r26 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r25, 10));
        Iterator<T> r27 = r25.iterator();
    L28:
        if (r27.hasNext() == false) goto L31;
        KotlinType r28 = TypeUtils.makeNullableAsSpecified((KotlinType) r27.next(), r17.isMarkedNullable());
        Intrinsics.checkNotNullExpressionValue(r28, "makeNullableAsSpecified(it, type.isMarkedNullable)");
        r26.add(r28);
        goto L28
    L31:
        return KotlinTypeFactory.simpleTypeWithNonTrivialMemberScope(r17.getAttributes(), new IntersectionTypeConstructor(r26), CollectionsKt.emptyList(), false, r17.getMemberScope());
    L33:
        if ((r10 instanceof IntersectionTypeConstructor) == true) goto L35;
    L51:
        return r17;
    L35:
        if (r17.isMarkedNullable() == false) goto L51;
        IntersectionTypeConstructor r29 = (IntersectionTypeConstructor) r10;
        Collection<KotlinType> r30 = r29.mo1324getSupertypes();
        ArrayList r31 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r30, 10));
        Iterator<T> r32 = r30.iterator();
    L38:
        if (r32.hasNext() == false) goto L40;
        r31.add(TypeUtilsKt.makeNullable((KotlinType) r32.next()));
        r12 = true;
        goto L38
    L40:
        if (r12 == false) goto L46;
        KotlinType r33 = r29.getAlternativeType();
        if (r33 == null) goto L45;
        r15 = TypeUtilsKt.makeNullable(r33);
    L45:
        r13 = new IntersectionTypeConstructor(r31).setAlternative(r15);
    L46:
        if (r13 == null) goto L50;
        r29 = r13;
    L50:
        return r29.createType();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypePreparator
    public UnwrappedType prepareType(KotlinTypeMarker r10) {
        Intrinsics.checkNotNullParameter(r10, WsConstants.KEY_CONNECTION_TYPE);
        if ((r10 instanceof KotlinType) == false) goto L21;
        UnwrappedType r11 = ((KotlinType) r10).unwrap();
        if ((r11 instanceof SimpleType) == false) goto L8;
        UnwrappedType r12 = transformToNewType((SimpleType) r11);
    L17:
        return TypeWithEnhancementKt.inheritEnhancement(r12, r11, new AnonymousClass1(this));
    L8:
        if ((r11 instanceof FlexibleType) == false) goto L19;
        FlexibleType r13 = (FlexibleType) r11;
        SimpleType r14 = transformToNewType(r13.getLowerBound());
        SimpleType r15 = transformToNewType(r13.getUpperBound());
        if (r14 == r13.getLowerBound()) goto L12;
    L15:
        r12 = KotlinTypeFactory.flexibleType(r14, r15);
        goto L17
    L12:
        if (r15 != r13.getUpperBound()) goto L15;
        r12 = r11;
        goto L17
    L19:
        throw new NoWhenBranchMatchedException();
    L21:
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypePreparator
    public /* bridge */ /* synthetic */ KotlinTypeMarker prepareType(KotlinTypeMarker r10) {
        return prepareType(r10);
    }
}
