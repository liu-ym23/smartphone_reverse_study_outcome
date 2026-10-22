package kotlin.reflect.jvm.internal.impl.types;

import com.bytedance.common.wschannel.WsConstants;
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
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* JADX INFO: loaded from: classes3.dex */
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

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }

        public final KotlinType replaceArgumentsOfUpperBound(KotlinType r17, TypeSubstitutor r18, Set<? extends TypeParameterDescriptor> r19, boolean r20) {
            Intrinsics.checkNotNullParameter(r17, "<this>");
            Intrinsics.checkNotNullParameter(r18, "substitutor");
            UnwrappedType r10 = r17.unwrap();
            if ((r10 instanceof FlexibleType) == false) goto L68;
            FlexibleType r11 = (FlexibleType) r10;
            SimpleType r13 = r11.getLowerBound();
            if (r13.getConstructor().getParameters().isEmpty() == false) goto L7;
        L35:
            SimpleType r12 = r11.getUpperBound();
            if (r12.getConstructor().getParameters().isEmpty() == false) goto L38;
        L66:
            UnwrappedType r14 = KotlinTypeFactory.flexibleType(r13, r12);
        L101:
            KotlinType r15 = r18.safeSubstitute(TypeWithEnhancementKt.inheritEnhancement(r14, r10), Variance.OUT_VARIANCE);
            Intrinsics.checkNotNullExpressionValue(r15, "substitutor.safeSubstitu…s, Variance.OUT_VARIANCE)");
            return r15;
        L38:
            if (r12.getConstructor().mo1323getDeclarationDescriptor() == null) goto L66;
            List<TypeParameterDescriptor> r16 = r12.getConstructor().getParameters();
            Intrinsics.checkNotNullExpressionValue(r16, "constructor.parameters");
            ArrayList r21 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r16, 10));
            Iterator<T> r22 = r16.iterator();
        L42:
            if (r22.hasNext() == false) goto L65;
            TypeParameterDescriptor r23 = (TypeParameterDescriptor) r22.next();
            TypeProjection r110 = (TypeProjection) CollectionsKt.getOrNull(r17.getArguments(), r23.getIndex());
            if (r20 == false) goto L54;
            if (r110 == null) goto L51;
            KotlinType r111 = r110.getType();
            if (r111 == null) goto L51;
            Intrinsics.checkNotNullExpressionValue(r111, WsConstants.KEY_CONNECTION_TYPE);
            if (TypeUtilsKt.containsTypeParameter(r111) == true) goto L51;
            boolean r112 = true;
        L52:
            if (r112 == false) goto L54;
        L64:
            r21.add(r110);
        L51:
            r112 = false;
        L54:
            if (r19 != null) goto L56;
        L58:
            boolean r113 = false;
        L59:
            if (r110 == null) goto L63;
            if (r113 == true) goto L63;
            TypeSubstitution r114 = r18.getSubstitution();
            KotlinType r115 = r110.getType();
            Intrinsics.checkNotNullExpressionValue(r115, "argument.type");
            if (r114.mo1328get(r115) != null) goto L64;
        L63:
            r110 = new StarProjectionImpl(r23);
            goto L64
        L56:
            if (r19.contains(r23) == false) goto L58;
            r113 = true;
            goto L59
        L65:
            r12 = TypeSubstitutionKt.replace$default(r12, r21, null, 2, null);
            goto L66
        L7:
            if (r13.getConstructor().mo1323getDeclarationDescriptor() == null) goto L35;
            List<TypeParameterDescriptor> r116 = r13.getConstructor().getParameters();
            Intrinsics.checkNotNullExpressionValue(r116, "constructor.parameters");
            ArrayList r117 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r116, 10));
            Iterator<T> r118 = r116.iterator();
        L11:
            if (r118.hasNext() == false) goto L34;
            TypeParameterDescriptor r119 = (TypeParameterDescriptor) r118.next();
            TypeProjection r24 = (TypeProjection) CollectionsKt.getOrNull(r17.getArguments(), r119.getIndex());
            if (r20 == false) goto L23;
            if (r24 == null) goto L20;
            KotlinType r120 = r24.getType();
            if (r120 == null) goto L20;
            Intrinsics.checkNotNullExpressionValue(r120, WsConstants.KEY_CONNECTION_TYPE);
            if (TypeUtilsKt.containsTypeParameter(r120) == true) goto L20;
            boolean r121 = true;
        L21:
            if (r121 == false) goto L23;
        L33:
            r117.add(r24);
        L20:
            r121 = false;
        L23:
            if (r19 != null) goto L25;
        L27:
            boolean r122 = false;
        L28:
            if (r24 == null) goto L32;
            if (r122 == true) goto L32;
            TypeSubstitution r123 = r18.getSubstitution();
            KotlinType r25 = r24.getType();
            Intrinsics.checkNotNullExpressionValue(r25, "argument.type");
            if (r123.mo1328get(r25) != null) goto L33;
        L32:
            r24 = new StarProjectionImpl(r119);
            goto L33
        L25:
            if (r19.contains(r119) == false) goto L27;
            r122 = true;
            goto L28
        L34:
            r13 = TypeSubstitutionKt.replace$default(r13, r117, null, 2, null);
            goto L35
        L68:
            if ((r10 instanceof SimpleType) == false) goto L104;
            SimpleType r26 = (SimpleType) r10;
            if (r26.getConstructor().getParameters().isEmpty() == false) goto L72;
        L100:
            r14 = r26;
            goto L101
        L72:
            if (r26.getConstructor().mo1323getDeclarationDescriptor() == null) goto L100;
            List<TypeParameterDescriptor> r27 = r26.getConstructor().getParameters();
            Intrinsics.checkNotNullExpressionValue(r27, "constructor.parameters");
            ArrayList r28 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r27, 10));
            Iterator<T> r29 = r27.iterator();
        L76:
            if (r29.hasNext() == false) goto L99;
            TypeParameterDescriptor r30 = (TypeParameterDescriptor) r29.next();
            TypeProjection r124 = (TypeProjection) CollectionsKt.getOrNull(r17.getArguments(), r30.getIndex());
            if (r20 == false) goto L88;
            if (r124 == null) goto L85;
            KotlinType r125 = r124.getType();
            if (r125 == null) goto L85;
            Intrinsics.checkNotNullExpressionValue(r125, WsConstants.KEY_CONNECTION_TYPE);
            if (TypeUtilsKt.containsTypeParameter(r125) == true) goto L85;
            boolean r126 = true;
        L86:
            if (r126 == false) goto L88;
        L98:
            r28.add(r124);
        L85:
            r126 = false;
        L88:
            if (r19 != null) goto L90;
        L92:
            boolean r127 = false;
        L93:
            if (r124 == null) goto L97;
            if (r127 == true) goto L97;
            TypeSubstitution r128 = r18.getSubstitution();
            KotlinType r129 = r124.getType();
            Intrinsics.checkNotNullExpressionValue(r129, "argument.type");
            if (r128.mo1328get(r129) != null) goto L98;
        L97:
            r124 = new StarProjectionImpl(r30);
            goto L98
        L90:
            if (r19.contains(r30) == false) goto L92;
            r127 = true;
            goto L93
        L99:
            r14 = TypeSubstitutionKt.replace$default(r26, r28, null, 2, null);
            goto L101
        L104:
            throw new NoWhenBranchMatchedException();
        }
    }

    private static final class DataToEraseUpperBound {
        private final ErasureTypeAttributes typeAttr;
        private final TypeParameterDescriptor typeParameter;

        public DataToEraseUpperBound(TypeParameterDescriptor r10, ErasureTypeAttributes r11) {
            Intrinsics.checkNotNullParameter(r10, "typeParameter");
            Intrinsics.checkNotNullParameter(r11, "typeAttr");
            this.typeParameter = r10;
            this.typeAttr = r11;
        }

        public boolean equals(Object r10) {
            if ((r10 instanceof DataToEraseUpperBound) == true) goto L5;
            return false;
        L5:
            DataToEraseUpperBound r11 = (DataToEraseUpperBound) r10;
            if (Intrinsics.areEqual(r11.typeParameter, this.typeParameter) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(r11.typeAttr, this.typeAttr) == false) goto L12;
            return true;
        L12:
            return false;
        }

        public final ErasureTypeAttributes getTypeAttr() {
            return this.typeAttr;
        }

        public final TypeParameterDescriptor getTypeParameter() {
            return this.typeParameter;
        }

        public int hashCode() {
            int r10 = this.typeParameter.hashCode();
            return r10 + ((r10 * 31) + this.typeAttr.hashCode());
        }

        public String toString() {
            return "DataToEraseUpperBound(typeParameter=" + this.typeParameter + ", typeAttr=" + this.typeAttr + ')';
        }
    }

    static {
        Companion = new Companion(null);
    }

    public TypeParameterUpperBoundEraser(ErasureProjectionComputer r10, TypeParameterErasureOptions r11) {
        Intrinsics.checkNotNullParameter(r10, "projectionComputer");
        Intrinsics.checkNotNullParameter(r11, "options");
        this.projectionComputer = r10;
        this.options = r11;
        LockBasedStorageManager r12 = new LockBasedStorageManager("Type parameter upper bound erasure results");
        this.storage = r12;
        this.erroneousErasedBound$delegate = LazyKt.lazy(new TypeParameterUpperBoundEraser$erroneousErasedBound$2(this));
        MemoizedFunctionToNotNull<DataToEraseUpperBound, KotlinType> r13 = r12.createMemoizedFunction(new AnonymousClass1(this));
        Intrinsics.checkNotNullExpressionValue(r13, "storage.createMemoizedFu…ameter, typeAttr) }\n    }");
        this.getErasedUpperBound = r13;
    }

    public /* synthetic */ TypeParameterUpperBoundEraser(ErasureProjectionComputer r10, TypeParameterErasureOptions r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = new TypeParameterErasureOptions(false, false);
    L5:
        this(r10, r11);
    }

    public static final /* synthetic */ KotlinType access$getErasedUpperBoundInternal(TypeParameterUpperBoundEraser r10, TypeParameterDescriptor r11, ErasureTypeAttributes r12) {
        return r10.getErasedUpperBoundInternal(r11, r12);
    }

    private final KotlinType getDefaultType(ErasureTypeAttributes r10) {
        SimpleType r11 = r10.getDefaultType();
        if (r11 == null) goto L7;
        KotlinType r12 = TypeUtilsKt.replaceArgumentsWithStarProjections(r11);
        if (r12 == null) goto L7;
        return r12;
    L7:
        return getErroneousErasedBound();
    }

    private final KotlinType getErasedUpperBoundInternal(TypeParameterDescriptor r10, ErasureTypeAttributes r11) {
        Set<TypeParameterDescriptor> r12 = r11.getVisitedTypeParameters();
        if (r12 != null) goto L5;
    L8:
        SimpleType r13 = r10.getDefaultType();
        Intrinsics.checkNotNullExpressionValue(r13, "typeParameter.defaultType");
        Set<TypeParameterDescriptor> r14 = TypeUtilsKt.extractTypeParametersFromUpperBounds(r13, r12);
        LinkedHashMap r15 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r14, 10)), 16));
        Iterator<T> r16 = r14.iterator();
    L10:
        if (r16.hasNext() == false) goto L19;
        TypeParameterDescriptor r17 = (TypeParameterDescriptor) r16.next();
        if (r12 != null) goto L14;
    L17:
        TypeProjection r18 = this.projectionComputer.computeProjection(r17, r11, this, getErasedUpperBound(r17, r11.withNewVisitedTypeParameter(r10)));
    L18:
        Pair r19 = TuplesKt.to(r17.getTypeConstructor(), r18);
        r15.put(r19.getFirst(), r19.getSecond());
        goto L10
    L14:
        if (r12.contains(r17) == false) goto L17;
        r18 = TypeUtils.makeStarProjection(r17, r11);
        Intrinsics.checkNotNullExpressionValue(r18, "makeStarProjection(it, typeAttr)");
        goto L18
    L19:
        boolean r20 = false;
        TypeSubstitutor r21 = TypeSubstitutor.create(TypeConstructorSubstitution.Companion.createByConstructorsMap$default(TypeConstructorSubstitution.Companion, r15, false, 2, null));
        Intrinsics.checkNotNullExpressionValue(r21, "create(TypeConstructorSu…ap(erasedTypeParameters))");
        List<KotlinType> r22 = r10.getUpperBounds();
        Intrinsics.checkNotNullExpressionValue(r22, "typeParameter.upperBounds");
        Set<KotlinType> r23 = substituteErasedUpperBounds(r21, r22, r11);
        if ((!r23.isEmpty()) == false) goto L38;
        if (this.options.getIntersectUpperBounds() == false) goto L24;
        List r24 = CollectionsKt.toList(r23);
        ArrayList r25 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r24, 10));
        Iterator r26 = r24.iterator();
    L33:
        if (r26.hasNext() == false) goto L36;
        r25.add(((KotlinType) r26.next()).unwrap());
        goto L33
    L36:
        return IntersectionTypeKt.intersectTypes(r25);
    L24:
        if (r23.size() != 1) goto L26;
        r20 = true;
    L26:
        if (r20 == false) goto L30;
        return (KotlinType) CollectionsKt.single(r23);
    L30:
        throw new IllegalArgumentException("Should only be one computed upper bound if no need to intersect all bounds".toString());
    L38:
        return getDefaultType(r11);
    L5:
        if (r12.contains(r10.getOriginal()) == false) goto L8;
        return getDefaultType(r11);
    }

    private final ErrorType getErroneousErasedBound() {
        return (ErrorType) this.erroneousErasedBound$delegate.getValue();
    }

    private final Set<KotlinType> substituteErasedUpperBounds(TypeSubstitutor r10, List<? extends KotlinType> r11, ErasureTypeAttributes r12) {
        Set r13 = SetsKt.createSetBuilder();
        Iterator<? extends KotlinType> r14 = r11.iterator();
    L4:
        if (r14.hasNext() == false) goto L23;
        KotlinType r15 = r14.next();
        ClassifierDescriptor r16 = r15.getConstructor().mo1323getDeclarationDescriptor();
        if ((r16 instanceof ClassDescriptor) == false) goto L10;
        KotlinType r17 = Companion.replaceArgumentsOfUpperBound(r15, r10, r12.getVisitedTypeParameters(), this.options.getLeaveNonTypeParameterTypes());
    L8:
        r13.add(r17);
    L21:
        if (this.options.getIntersectUpperBounds() == true) goto L4;
    L10:
        if ((r16 instanceof TypeParameterDescriptor) == false) goto L21;
        Set<TypeParameterDescriptor> r18 = r12.getVisitedTypeParameters();
        boolean r19 = true;
        if (r18 != null) goto L14;
    L16:
        r19 = false;
    L17:
        if (r19 == false) goto L19;
        r17 = getDefaultType(r12);
        goto L8
    L19:
        List<KotlinType> r20 = ((TypeParameterDescriptor) r16).getUpperBounds();
        Intrinsics.checkNotNullExpressionValue(r20, "declaration.upperBounds");
        r13.addAll(substituteErasedUpperBounds(r10, r20, r12));
        goto L21
    L14:
        if (r18.contains(r16) != true) goto L16;
    L23:
        return SetsKt.build(r13);
    }

    public final KotlinType getErasedUpperBound(TypeParameterDescriptor r10, ErasureTypeAttributes r11) {
        Intrinsics.checkNotNullParameter(r10, "typeParameter");
        Intrinsics.checkNotNullParameter(r11, "typeAttr");
        KotlinType r12 = this.getErasedUpperBound.invoke(new DataToEraseUpperBound(r10, r11));
        Intrinsics.checkNotNullExpressionValue(r12, "getErasedUpperBound(Data…typeParameter, typeAttr))");
        return r12;
    }
}
