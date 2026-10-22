package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
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
@SourceDebugExtension({"SMAP\nKotlinTypePreparator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 KotlinTypePreparator.kt\norg/jetbrains/kotlin/types/checker/KotlinTypePreparator\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 IntersectionTypeConstructor.kt\norg/jetbrains/kotlin/types/IntersectionTypeConstructorKt\n+ 5 IntersectionTypeConstructor.kt\norg/jetbrains/kotlin/types/IntersectionTypeConstructorKt$transformComponents$1\n*L\n1#1,76:1\n1#2:77\n1549#3:78\n1620#3,3:79\n1549#3:82\n1620#3,3:83\n1549#3:92\n1620#3,2:93\n1622#3:101\n98#4,6:86\n104#4:95\n105#4,4:97\n112#4,7:102\n99#5:96\n*S KotlinDebug\n*F\n+ 1 KotlinTypePreparator.kt\norg/jetbrains/kotlin/types/checker/KotlinTypePreparator\n*L\n27#1:78\n27#1:79,3\n37#1:82\n37#1:83,3\n48#1:92\n48#1:93,2\n48#1:101\n48#1:86,6\n48#1:95\n48#1:97,4\n48#1:102,7\n48#1:96\n*E\n"})
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
    public /* synthetic */ class AnonymousClass1 extends FunctionReference implements Function1<KotlinTypeMarker, UnwrappedType> {
        public AnonymousClass1(Object r5) {
            super(1, r5);
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
        public /* bridge */ /* synthetic */ UnwrappedType invoke(KotlinTypeMarker r5) {
            return invoke2(r5);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final UnwrappedType invoke2(KotlinTypeMarker r5) {
            Intrinsics.checkNotNullParameter(r5, "p0");
            return ((KotlinTypePreparator) this.receiver).prepareType(r5);
        }
    }

    public KotlinTypePreparator() {
    }

    private final SimpleType transformToNewType(SimpleType r13) {
        TypeConstructor r12 = r13.getConstructor();
        IntersectionTypeConstructor r5 = null;
        UnwrappedType r10 = null;
        r10 = null;
        KotlinType r11 = null;
        if ((r12 instanceof CapturedTypeConstructorImpl) == false) goto L21;
        CapturedTypeConstructorImpl r14 = (CapturedTypeConstructorImpl) r12;
        TypeProjection r15 = r14.getProjection();
        if (r15.getProjectionKind() == Variance.IN_VARIANCE) goto L8;
        r15 = null;
    L8:
        if (r15 == null) goto L12;
        KotlinType r16 = r15.getType();
        if (r16 == null) goto L12;
        r10 = r16.unwrap();
    L12:
        UnwrappedType r17 = r10;
        if (r14.getNewTypeConstructor() != null) goto L19;
        TypeProjection r18 = r14.getProjection();
        Collection<KotlinType> r19 = r14.mo1403getSupertypes();
        ArrayList r20 = new ArrayList(CollectionsKt.h(r19));
        Iterator<T> r21 = r19.iterator();
    L16:
        if (r21.hasNext() == false) goto L18;
        r20.add(((KotlinType) r21.next()).unwrap());
        goto L16
    L18:
        r14.setNewTypeConstructor(new NewCapturedTypeConstructor(r18, r20, null, 4, null));
    L19:
        CaptureStatus r22 = CaptureStatus.FOR_SUBTYPING;
        NewCapturedTypeConstructor r23 = r14.getNewTypeConstructor();
        Intrinsics.checkNotNull(r23);
        return new NewCapturedType(r22, r23, r17, r13.getAttributes(), r13.isMarkedNullable(), false, 32, null);
    L21:
        boolean r24 = false;
        if ((r12 instanceof IntegerValueTypeConstructor) == false) goto L30;
        Collection<KotlinType> r110 = ((IntegerValueTypeConstructor) r12).mo1403getSupertypes();
        ArrayList r25 = new ArrayList(CollectionsKt.h(r110));
        Iterator<T> r111 = r110.iterator();
    L25:
        if (r111.hasNext() == false) goto L28;
        r25.add(TypeUtils.makeNullableAsSpecified((KotlinType) r111.next(), r13.isMarkedNullable()));
        goto L25
    L28:
        return KotlinTypeFactory.simpleTypeWithNonTrivialMemberScope(r13.getAttributes(), new IntersectionTypeConstructor(r25), CollectionsKt.emptyList(), false, r13.getMemberScope());
    L30:
        if ((r12 instanceof IntersectionTypeConstructor) == true) goto L32;
    L48:
        return r13;
    L32:
        if (r13.isMarkedNullable() == false) goto L48;
        IntersectionTypeConstructor r112 = (IntersectionTypeConstructor) r12;
        Collection<KotlinType> r113 = r112.mo1403getSupertypes();
        ArrayList r26 = new ArrayList(CollectionsKt.h(r113));
        Iterator<T> r114 = r113.iterator();
    L35:
        if (r114.hasNext() == false) goto L37;
        r26.add(TypeUtilsKt.makeNullable((KotlinType) r114.next()));
        r24 = true;
        goto L35
    L37:
        if (r24 == false) goto L43;
        KotlinType r115 = r112.getAlternativeType();
        if (r115 == null) goto L42;
        r11 = TypeUtilsKt.makeNullable(r115);
    L42:
        r5 = new IntersectionTypeConstructor(r26).setAlternative(r11);
    L43:
        if (r5 == null) goto L47;
        r112 = r5;
    L47:
        return r112.createType();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypePreparator
    public /* bridge */ /* synthetic */ KotlinTypeMarker prepareType(KotlinTypeMarker r5) {
        return prepareType(r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypePreparator
    public UnwrappedType prepareType(KotlinTypeMarker r5) {
        Intrinsics.checkNotNullParameter(r5, "type");
        if ((r5 instanceof KotlinType) == false) goto L21;
        UnwrappedType r10 = ((KotlinType) r5).unwrap();
        if ((r10 instanceof SimpleType) == false) goto L8;
        UnwrappedType r11 = transformToNewType((SimpleType) r10);
    L17:
        return TypeWithEnhancementKt.inheritEnhancement(r11, r10, new AnonymousClass1(this));
    L8:
        if ((r10 instanceof FlexibleType) == false) goto L19;
        FlexibleType r12 = (FlexibleType) r10;
        SimpleType r13 = transformToNewType(r12.getLowerBound());
        SimpleType r14 = transformToNewType(r12.getUpperBound());
        if (r13 == r12.getLowerBound()) goto L12;
    L15:
        r11 = KotlinTypeFactory.flexibleType(r13, r14);
        goto L17
    L12:
        if (r14 != r12.getUpperBound()) goto L15;
        r11 = r10;
        goto L17
    L19:
        throw new NoWhenBranchMatchedException();
    L21:
        throw new IllegalArgumentException("Failed requirement.");
    }
}
