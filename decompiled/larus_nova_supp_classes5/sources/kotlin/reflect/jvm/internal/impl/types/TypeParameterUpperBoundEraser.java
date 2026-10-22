package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.types.checker.IntersectionTypeKt;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorType;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class TypeParameterUpperBoundEraser {
    public static final Companion Companion = null;
    private final Lazy erroneousErasedBound$delegate;
    private final MemoizedFunctionToNotNull<DataToEraseUpperBound, KotlinType> getErasedUpperBound;
    private final TypeParameterErasureOptions options;
    private final ErasureProjectionComputer projectionComputer;
    private final LockBasedStorageManager storage;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final KotlinType replaceArgumentsOfUpperBound(KotlinType r17, TypeSubstitutor r18, Set<? extends TypeParameterDescriptor> r19, boolean r20) {
            Intrinsics.checkNotNullParameter(r17, "<this>");
            Intrinsics.checkNotNullParameter(r18, "substitutor");
            FlexibleType r2 = r17.unwrap();
            if ((r2 instanceof FlexibleType) == false) goto L68;
            FlexibleType r4 = r2;
            SimpleType r10 = r4.getLowerBound();
            if (r10.getConstructor().getParameters().isEmpty() == false) goto L7;
        L35:
            SimpleType r5 = r4.getUpperBound();
            if (r5.getConstructor().getParameters().isEmpty() == false) goto L38;
        L66:
            UnwrappedType r1 = KotlinTypeFactory.flexibleType(r10, r5);
        L102:
            return r18.safeSubstitute(TypeWithEnhancementKt.inheritEnhancement(r1, r2), Variance.OUT_VARIANCE);
        L38:
            if (r5.getConstructor().getDeclarationDescriptor() == null) goto L66;
            List<TypeParameterDescriptor> r7 = r5.getConstructor().getParameters();
            ArrayList r11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
            Iterator<T> r6 = r7.iterator();
        L42:
            if (r6.hasNext() == false) goto L65;
            TypeParameterDescriptor r8 = (TypeParameterDescriptor) r6.next();
            StarProjectionImpl r12 = (TypeProjection) CollectionsKt.getOrNull(r17.getArguments(), r8.getIndex());
            if (r20 == false) goto L54;
            if (r12 == null) goto L51;
            KotlinType r13 = r12.getType();
            if (r13 == null) goto L51;
            if (TypeUtilsKt.containsTypeParameter(r13) == true) goto L51;
            boolean r14 = true;
        L52:
            if (r14 == false) goto L54;
        L64:
            r11.add(r12);
        L51:
            r14 = false;
        L54:
            if (r19 != null) goto L56;
        L58:
            boolean r15 = false;
        L59:
            if (r12 == null) goto L63;
            if (r15 == true) goto L63;
            if (r18.getSubstitution().mo385get(r12.getType()) != null) goto L64;
        L63:
            r12 = new StarProjectionImpl(r8);
            goto L64
        L56:
            if (r19.contains(r8) == false) goto L58;
            r15 = true;
            goto L59
        L65:
            r5 = TypeSubstitutionKt.replace$default(r5, r11, null, 2, null);
            goto L66
        L7:
            if (r10.getConstructor().getDeclarationDescriptor() == null) goto L35;
            List<TypeParameterDescriptor> r16 = r10.getConstructor().getParameters();
            ArrayList r110 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r16, 10));
            Iterator<T> r111 = r16.iterator();
        L11:
            if (r111.hasNext() == false) goto L34;
            TypeParameterDescriptor r112 = (TypeParameterDescriptor) r111.next();
            StarProjectionImpl r113 = (TypeProjection) CollectionsKt.getOrNull(r17.getArguments(), r112.getIndex());
            if (r20 == false) goto L23;
            if (r113 == null) goto L20;
            KotlinType r114 = r113.getType();
            if (r114 == null) goto L20;
            if (TypeUtilsKt.containsTypeParameter(r114) == true) goto L20;
            boolean r115 = true;
        L21:
            if (r115 == false) goto L23;
        L33:
            r110.add(r113);
        L20:
            r115 = false;
        L23:
            if (r19 != null) goto L25;
        L27:
            boolean r116 = false;
        L28:
            if (r113 == null) goto L32;
            if (r116 == true) goto L32;
            if (r18.getSubstitution().mo385get(r113.getType()) != null) goto L33;
        L32:
            r113 = new StarProjectionImpl(r112);
            goto L33
        L25:
            if (r19.contains(r112) == false) goto L27;
            r116 = true;
            goto L28
        L34:
            r10 = TypeSubstitutionKt.replace$default(r10, r110, null, 2, null);
            goto L35
        L68:
            if ((r2 instanceof SimpleType) == false) goto L104;
            SimpleType r9 = (SimpleType) r2;
            if (r9.getConstructor().getParameters().isEmpty() == false) goto L72;
        L100:
            r1 = r9;
            goto L102
        L72:
            if (r9.getConstructor().getDeclarationDescriptor() == null) goto L100;
            List<TypeParameterDescriptor> r21 = r9.getConstructor().getParameters();
            ArrayList r117 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r21, 10));
            Iterator<T> r22 = r21.iterator();
        L76:
            if (r22.hasNext() == false) goto L99;
            TypeParameterDescriptor r23 = (TypeParameterDescriptor) r22.next();
            StarProjectionImpl r118 = (TypeProjection) CollectionsKt.getOrNull(r17.getArguments(), r23.getIndex());
            if (r20 == false) goto L88;
            if (r118 == null) goto L85;
            KotlinType r119 = r118.getType();
            if (r119 == null) goto L85;
            if (TypeUtilsKt.containsTypeParameter(r119) == true) goto L85;
            boolean r120 = true;
        L86:
            if (r120 == false) goto L88;
        L98:
            r117.add(r118);
        L85:
            r120 = false;
        L88:
            if (r19 != null) goto L90;
        L92:
            boolean r121 = false;
        L93:
            if (r118 == null) goto L97;
            if (r121 == true) goto L97;
            if (r18.getSubstitution().mo385get(r118.getType()) != null) goto L98;
        L97:
            r118 = new StarProjectionImpl(r23);
            goto L98
        L90:
            if (r19.contains(r23) == false) goto L92;
            r121 = true;
            goto L93
        L99:
            r1 = TypeSubstitutionKt.replace$default(r9, r117, null, 2, null);
            goto L102
        L104:
            throw new NoWhenBranchMatchedException();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ ErrorType accessor$TypeParameterUpperBoundEraser$lambda0(TypeParameterUpperBoundEraser r0) {
        return erroneousErasedBound_delegate$lambda$0(r0);
    }

    public static /* synthetic */ KotlinType accessor$TypeParameterUpperBoundEraser$lambda1(TypeParameterUpperBoundEraser r0, DataToEraseUpperBound r1) {
        return getErasedUpperBound$lambda$2(r0, r1);
    }

    private final ErrorType getErroneousErasedBound() {
        return (ErrorType) this.erroneousErasedBound$delegate.getValue();
    }

    private static final ErrorType erroneousErasedBound_delegate$lambda$0(TypeParameterUpperBoundEraser r3) {
        Intrinsics.checkNotNullParameter(r3, "this$0");
        return ErrorUtils.createErrorType(ErrorTypeKind.CANNOT_COMPUTE_ERASED_BOUND, new String[]{r3.toString()});
    }

    private final KotlinType getDefaultType(ErasureTypeAttributes r1) {
        SimpleType r2 = r1.getDefaultType();
        if (r2 == null) goto L7;
        KotlinType r3 = TypeUtilsKt.replaceArgumentsWithStarProjections(r2);
        if (r3 == null) goto L7;
        return r3;
    L7:
        return getErroneousErasedBound();
    }

    public TypeParameterUpperBoundEraser(ErasureProjectionComputer r2, TypeParameterErasureOptions r3) {
        Intrinsics.checkNotNullParameter(r2, "projectionComputer");
        Intrinsics.checkNotNullParameter(r3, "options");
        this.projectionComputer = r2;
        this.options = r3;
        LockBasedStorageManager r4 = new LockBasedStorageManager("Type parameter upper bound erasure results");
        this.storage = r4;
        this.erroneousErasedBound$delegate = LazyKt.lazy(new TypeParameterUpperBoundEraser$$Lambda$0(this));
        this.getErasedUpperBound = r4.createMemoizedFunction(new TypeParameterUpperBoundEraser$$Lambda$1(this));
    }

    private static final KotlinType getErasedUpperBound$lambda$2(TypeParameterUpperBoundEraser r1, DataToEraseUpperBound r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        return r1.getErasedUpperBoundInternal(r2.getTypeParameter(), r2.getTypeAttr());
    }

    private final KotlinType getErasedUpperBoundInternal(TypeParameterDescriptor r8, ErasureTypeAttributes r9) {
        Set r0 = r9.getVisitedTypeParameters();
        if (r0 != null) goto L5;
    L8:
        Set r1 = TypeUtilsKt.extractTypeParametersFromUpperBounds(r8.getDefaultType(), r0);
        LinkedHashMap r4 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r1, 10)), 16));
        Iterator r2 = r1.iterator();
    L10:
        if (r2.hasNext() == false) goto L19;
        TypeParameterDescriptor r3 = (TypeParameterDescriptor) r2.next();
        if (r0 != null) goto L14;
    L17:
        TypeProjection r5 = this.projectionComputer.computeProjection(r3, r9, this, getErasedUpperBound(r3, r9.withNewVisitedTypeParameter(r8)));
    L18:
        Pair r6 = TuplesKt.to(r3.getTypeConstructor(), r5);
        r4.put(r6.getFirst(), r6.getSecond());
        goto L10
    L14:
        if (r0.contains(r3) == false) goto L17;
        r5 = TypeUtils.makeStarProjection(r3, r9);
        goto L18
    L19:
        boolean r7 = false;
        Set<KotlinType> r10 = substituteErasedUpperBounds(TypeSubstitutor.create(TypeConstructorSubstitution.Companion.createByConstructorsMap$default(TypeConstructorSubstitution.Companion, r4, false, 2, null)), r8.getUpperBounds(), r9);
        if ((!r10.isEmpty()) == false) goto L38;
        if (this.options.getIntersectUpperBounds() == false) goto L24;
        List r11 = CollectionsKt.toList(r10);
        ArrayList r12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10));
        Iterator r13 = r11.iterator();
    L33:
        if (r13.hasNext() == false) goto L36;
        r12.add(((KotlinType) r13.next()).unwrap());
        goto L33
    L36:
        return IntersectionTypeKt.intersectTypes(r12);
    L24:
        if (r10.size() != 1) goto L26;
        r7 = true;
    L26:
        if (r7 == false) goto L30;
        return (KotlinType) CollectionsKt.single(r10);
    L30:
        throw new IllegalArgumentException("Should only be one computed upper bound if no need to intersect all bounds".toString());
    L38:
        return getDefaultType(r9);
    L5:
        if (r0.contains(r8.getOriginal()) == false) goto L8;
        return getDefaultType(r9);
    }

    public final KotlinType getErasedUpperBound(TypeParameterDescriptor r3, ErasureTypeAttributes r4) {
        Intrinsics.checkNotNullParameter(r3, "typeParameter");
        Intrinsics.checkNotNullParameter(r4, "typeAttr");
        return (KotlinType) this.getErasedUpperBound.invoke(new DataToEraseUpperBound(r3, r4));
    }

    private final Set<KotlinType> substituteErasedUpperBounds(TypeSubstitutor r6, List<? extends KotlinType> r7, ErasureTypeAttributes r8) {
        Set r0 = SetsKt.createSetBuilder();
        Iterator<? extends KotlinType> r9 = r7.iterator();
    L4:
        if (r9.hasNext() == false) goto L21;
        KotlinType r1 = r9.next();
        ClassifierDescriptor r2 = r1.getConstructor().getDeclarationDescriptor();
        if ((r2 instanceof ClassDescriptor) == false) goto L9;
        r0.add(Companion.replaceArgumentsOfUpperBound(r1, r6, r8.getVisitedTypeParameters(), this.options.getLeaveNonTypeParameterTypes()));
    L19:
        if (this.options.getIntersectUpperBounds() == true) goto L4;
    L9:
        if ((r2 instanceof TypeParameterDescriptor) == false) goto L19;
        Set r3 = r8.getVisitedTypeParameters();
        boolean r4 = false;
        if (r3 != null) goto L13;
    L15:
        if (r4 == false) goto L17;
        r0.add(getDefaultType(r8));
        goto L19
    L17:
        r0.addAll(substituteErasedUpperBounds(r6, ((TypeParameterDescriptor) r2).getUpperBounds(), r8));
        goto L19
    L13:
        if (r3.contains(r2) != true) goto L15;
        r4 = true;
    L21:
        return SetsKt.build(r0);
    }

    public /* synthetic */ TypeParameterUpperBoundEraser(ErasureProjectionComputer r1, TypeParameterErasureOptions r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = new TypeParameterErasureOptions(false, false);
    L5:
        this(r1, r2);
    }
}
