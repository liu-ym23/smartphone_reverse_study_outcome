package kotlin.reflect.jvm.internal.impl.types.typeUtil;

import com.bytedance.common.wschannel.WsConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.types.AbstractStubType;
import kotlin.reflect.jvm.internal.impl.types.DefinitelyNotNullType;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.StubTypeForBuilderInference;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributesKt;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutionKt;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancementKt;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorType;

/* JADX INFO: loaded from: classes3.dex */
public final class TypeUtilsKt {
    public static final TypeProjection asTypeProjection(KotlinType r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return new TypeProjectionImpl(r10);
    }

    public static final boolean contains(KotlinType r10, Function1<? super UnwrappedType, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        return TypeUtils.contains(r10, r11);
    }

    private static final boolean containsSelfTypeParameter(KotlinType r10, TypeConstructor r11, Set<? extends TypeParameterDescriptor> r12) {
        if (Intrinsics.areEqual(r10.getConstructor(), r11) == false) goto L5;
        return true;
    L5:
        ClassifierDescriptor r13 = r10.getConstructor().mo1323getDeclarationDescriptor();
        if ((r13 instanceof ClassifierDescriptorWithTypeParameters) == false) goto L8;
        ClassifierDescriptorWithTypeParameters r14 = (ClassifierDescriptorWithTypeParameters) r13;
    L9:
        if (r14 == null) goto L11;
        List<TypeParameterDescriptor> r15 = r14.getDeclaredTypeParameters();
    L12:
        Iterable r16 = CollectionsKt.withIndex(r10.getArguments());
        if ((r16 instanceof Collection) == true) goto L15;
    L17:
        Iterator r17 = r16.iterator();
    L19:
        if (r17.hasNext() == false) goto L37;
        IndexedValue r18 = (IndexedValue) r17.next();
        int r19 = r18.component1();
        TypeProjection r20 = (TypeProjection) r18.component2();
        if (r15 == null) goto L23;
        TypeParameterDescriptor r21 = (TypeParameterDescriptor) CollectionsKt.getOrNull(r15, r19);
    L24:
        if (r21 == null) goto L29;
        if (r12 == null) goto L29;
        if (r12.contains(r21) == false) goto L29;
        boolean r22 = true;
    L30:
        if (r22 == false) goto L32;
    L35:
        boolean r23 = false;
    L36:
        if (r23 == false) goto L19;
        return true;
    L32:
        if (r20.isStarProjection() == true) goto L35;
        KotlinType r24 = r20.getType();
        Intrinsics.checkNotNullExpressionValue(r24, "argument.type");
        r23 = containsSelfTypeParameter(r24, r11, r12);
    L29:
        r22 = false;
        goto L30
    L23:
        r21 = null;
    L37:
        return false;
    L15:
        if (((Collection) r16).isEmpty() == false) goto L17;
    L11:
        r15 = null;
        goto L12
    L8:
        r14 = null;
        goto L9
    }

    public static final boolean containsTypeAliasParameters(KotlinType r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return contains(r10, AnonymousClass1.INSTANCE);
    }

    public static final boolean containsTypeParameter(KotlinType r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return TypeUtils.contains(r10, C04331.INSTANCE);
    }

    public static final TypeProjection createProjection(KotlinType r10, Variance r11, TypeParameterDescriptor r12) {
        Intrinsics.checkNotNullParameter(r10, WsConstants.KEY_CONNECTION_TYPE);
        Intrinsics.checkNotNullParameter(r11, "projectionKind");
        if (r12 == null) goto L5;
        Variance r13 = r12.getVariance();
    L6:
        if (r13 != r11) goto L9;
        r11 = Variance.INVARIANT;
    L9:
        return new TypeProjectionImpl(r11, r10);
    L5:
        r13 = null;
        goto L6
    }

    public static final Set<TypeParameterDescriptor> extractTypeParametersFromUpperBounds(KotlinType r10, Set<? extends TypeParameterDescriptor> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        LinkedHashSet r12 = new LinkedHashSet();
        extractTypeParametersFromUpperBounds(r10, r10, r12, r11);
        return r12;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final void extractTypeParametersFromUpperBounds(KotlinType r10, KotlinType r11, Set<TypeParameterDescriptor> r12, Set<? extends TypeParameterDescriptor> r13) {
        ClassifierDescriptor r14 = r10.getConstructor().mo1323getDeclarationDescriptor();
        if ((r14 instanceof TypeParameterDescriptor) == true) goto L5;
        ClassifierDescriptor r15 = r10.getConstructor().mo1323getDeclarationDescriptor();
        if ((r15 instanceof ClassifierDescriptorWithTypeParameters) == false) goto L14;
        ClassifierDescriptorWithTypeParameters r16 = (ClassifierDescriptorWithTypeParameters) r15;
    L15:
        if (r16 == null) goto L17;
        List<TypeParameterDescriptor> r17 = r16.getDeclaredTypeParameters();
    L18:
        Iterator<TypeProjection> r18 = r10.getArguments().iterator();
        int r19 = 0;
    L20:
        if (r18.hasNext() == false) goto L51;
        int r20 = r19 + 1;
        TypeProjection r21 = r18.next();
        if (r17 == null) goto L24;
        TypeParameterDescriptor r22 = (TypeParameterDescriptor) CollectionsKt.getOrNull(r17, r19);
    L25:
        if (r22 == null) goto L30;
        if (r13 == null) goto L30;
        if (r13.contains(r22) == false) goto L30;
        boolean r23 = true;
    L31:
        if (r23 == true) goto L41;
        if (r21.isStarProjection() == true) goto L41;
        if (CollectionsKt.contains(r12, r21.getType().getConstructor().mo1323getDeclarationDescriptor()) == true) goto L41;
        if (Intrinsics.areEqual(r21.getType().getConstructor(), r11.getConstructor()) == true) goto L41;
        KotlinType r24 = r21.getType();
        Intrinsics.checkNotNullExpressionValue(r24, "argument.type");
        extractTypeParametersFromUpperBounds(r24, r11, r12, r13);
    L41:
        r19 = r20;
    L30:
        r23 = false;
        goto L31
    L24:
        r22 = null;
        goto L25
    L51:
        return;
    L17:
        r17 = null;
        goto L18
    L14:
        r16 = null;
        goto L15
    L5:
        if (Intrinsics.areEqual(r10.getConstructor(), r11.getConstructor()) == true) goto L7;
        r12.add(r14);
        return;
    L7:
        Iterator<KotlinType> r25 = ((TypeParameterDescriptor) r14).getUpperBounds().iterator();
    L9:
        if (r25.hasNext() == false) goto L50;
        KotlinType r26 = r25.next();
        Intrinsics.checkNotNullExpressionValue(r26, "upperBound");
        extractTypeParametersFromUpperBounds(r26, r11, r12, r13);
        goto L9
    }

    public static final KotlinBuiltIns getBuiltIns(KotlinType r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        KotlinBuiltIns r11 = r10.getConstructor().getBuiltIns();
        Intrinsics.checkNotNullExpressionValue(r11, "constructor.builtIns");
        return r11;
    }

    public static final KotlinType getRepresentativeUpperBound(TypeParameterDescriptor r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        List<KotlinType> r11 = r10.getUpperBounds();
        Intrinsics.checkNotNullExpressionValue(r11, "upperBounds");
        r11.isEmpty();
        List<KotlinType> r12 = r10.getUpperBounds();
        Intrinsics.checkNotNullExpressionValue(r12, "upperBounds");
        Iterator<T> r13 = r12.iterator();
    L3:
        Object r14 = null;
        ClassDescriptor r15 = null;
        if (r13.hasNext() == false) goto L18;
        Object r16 = r13.next();
        ClassifierDescriptor r17 = ((KotlinType) r16).getConstructor().mo1323getDeclarationDescriptor();
        if ((r17 instanceof ClassDescriptor) == false) goto L8;
        r15 = (ClassDescriptor) r17;
    L8:
        boolean r18 = false;
        if (r15 == null) goto L16;
        if (r15.getKind() == ClassKind.INTERFACE) goto L16;
        if (r15.getKind() == ClassKind.ANNOTATION_CLASS) goto L16;
        r18 = true;
    L16:
        if (r18 == false) goto L3;
        r14 = r16;
    L18:
        KotlinType r19 = (KotlinType) r14;
        if (r19 != null) goto L29;
        List<KotlinType> r20 = r10.getUpperBounds();
        Intrinsics.checkNotNullExpressionValue(r20, "upperBounds");
        Object r21 = CollectionsKt.first(r20);
        Intrinsics.checkNotNullExpressionValue(r21, "upperBounds.first()");
        return (KotlinType) r21;
    L29:
        return r19;
    }

    @JvmOverloads
    public static final boolean hasTypeParameterRecursiveBounds(TypeParameterDescriptor r10) {
        Intrinsics.checkNotNullParameter(r10, "typeParameter");
        return hasTypeParameterRecursiveBounds$default(r10, null, null, 6, null);
    }

    @JvmOverloads
    public static final boolean hasTypeParameterRecursiveBounds(TypeParameterDescriptor r10, TypeConstructor r11, Set<? extends TypeParameterDescriptor> r12) {
        Intrinsics.checkNotNullParameter(r10, "typeParameter");
        List<KotlinType> r13 = r10.getUpperBounds();
        Intrinsics.checkNotNullExpressionValue(r13, "typeParameter.upperBounds");
        if ((r13 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r14 = r13.iterator();
    L9:
        if (r14.hasNext() == false) goto L18;
        KotlinType r15 = (KotlinType) r14.next();
        Intrinsics.checkNotNullExpressionValue(r15, "upperBound");
        if (containsSelfTypeParameter(r15, r10.getDefaultType().getConstructor(), r12) == false) goto L16;
        if (r11 != null) goto L14;
    L15:
        boolean r16 = true;
    L17:
        if (r16 == false) goto L9;
        return true;
    L14:
        if (Intrinsics.areEqual(r15.getConstructor(), r11) == true) goto L15;
    L16:
        r16 = false;
    L18:
        return false;
    L5:
        if (r13.isEmpty() == false) goto L7;
        goto L7
    }

    public static /* synthetic */ boolean hasTypeParameterRecursiveBounds$default(TypeParameterDescriptor r10, TypeConstructor r11, Set r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L9;
        r12 = null;
    L9:
        return hasTypeParameterRecursiveBounds(r10, r11, r12);
    }

    public static final boolean isStubType(KotlinType r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if ((r10 instanceof AbstractStubType) == true) goto L12;
        if ((r10 instanceof DefinitelyNotNullType) == true) goto L7;
    L9:
        boolean r11 = false;
    L10:
        if (r11 == true) goto L12;
        return false;
    L7:
        if ((((DefinitelyNotNullType) r10).getOriginal() instanceof AbstractStubType) == false) goto L9;
        r11 = true;
    L12:
        return true;
    }

    public static final boolean isStubTypeForBuilderInference(KotlinType r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if ((r10 instanceof StubTypeForBuilderInference) == true) goto L12;
        if ((r10 instanceof DefinitelyNotNullType) == true) goto L7;
    L9:
        boolean r11 = false;
    L10:
        if (r11 == true) goto L12;
        return false;
    L7:
        if ((((DefinitelyNotNullType) r10).getOriginal() instanceof StubTypeForBuilderInference) == false) goto L9;
        r11 = true;
    L12:
        return true;
    }

    public static final boolean isSubtypeOf(KotlinType r10, KotlinType r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "superType");
        return KotlinTypeChecker.DEFAULT.isSubtypeOf(r10, r11);
    }

    public static final boolean isTypeAliasParameter(ClassifierDescriptor r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if ((r10 instanceof TypeParameterDescriptor) == true) goto L5;
    L7:
        return false;
    L5:
        if ((((TypeParameterDescriptor) r10).getContainingDeclaration() instanceof TypeAliasDescriptor) == false) goto L7;
        return true;
    }

    public static final boolean isTypeParameter(KotlinType r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return TypeUtils.isTypeParameter(r10);
    }

    public static final boolean isUnresolvedType(KotlinType r10) {
        Intrinsics.checkNotNullParameter(r10, WsConstants.KEY_CONNECTION_TYPE);
        if ((r10 instanceof ErrorType) == true) goto L5;
    L7:
        return false;
    L5:
        if (((ErrorType) r10).getKind().isUnresolved() == false) goto L7;
        return true;
    }

    public static final KotlinType makeNotNullable(KotlinType r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        KotlinType r11 = TypeUtils.makeNotNullable(r10);
        Intrinsics.checkNotNullExpressionValue(r11, "makeNotNullable(this)");
        return r11;
    }

    public static final KotlinType makeNullable(KotlinType r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        KotlinType r11 = TypeUtils.makeNullable(r10);
        Intrinsics.checkNotNullExpressionValue(r11, "makeNullable(this)");
        return r11;
    }

    public static final KotlinType replaceAnnotations(KotlinType r10, Annotations r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "newAnnotations");
        if (r10.getAnnotations().isEmpty() == false) goto L8;
        if (r11.isEmpty() == false) goto L8;
        return r10;
    L8:
        return r10.unwrap().replaceAttributes(TypeAttributesKt.replaceAnnotations(r10.getAttributes(), r11));
    }

    public static final KotlinType replaceArgumentsWithStarProjections(KotlinType r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        UnwrappedType r11 = r10.unwrap();
        if ((r11 instanceof FlexibleType) == false) goto L26;
        FlexibleType r12 = (FlexibleType) r11;
        SimpleType r13 = r12.getLowerBound();
        if (r13.getConstructor().getParameters().isEmpty() == false) goto L7;
    L14:
        SimpleType r14 = r12.getUpperBound();
        if (r14.getConstructor().getParameters().isEmpty() == false) goto L17;
    L24:
        UnwrappedType r15 = KotlinTypeFactory.flexibleType(r13, r14);
    L38:
        return TypeWithEnhancementKt.inheritEnhancement(r15, r11);
    L17:
        if (r14.getConstructor().mo1323getDeclarationDescriptor() == null) goto L24;
        List<TypeParameterDescriptor> r16 = r14.getConstructor().getParameters();
        Intrinsics.checkNotNullExpressionValue(r16, "constructor.parameters");
        ArrayList r17 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r16, 10));
        Iterator<T> r18 = r16.iterator();
    L21:
        if (r18.hasNext() == false) goto L23;
        r17.add(new StarProjectionImpl((TypeParameterDescriptor) r18.next()));
        goto L21
    L23:
        r14 = TypeSubstitutionKt.replace$default(r14, r17, null, 2, null);
        goto L24
    L7:
        if (r13.getConstructor().mo1323getDeclarationDescriptor() == null) goto L14;
        List<TypeParameterDescriptor> r19 = r13.getConstructor().getParameters();
        Intrinsics.checkNotNullExpressionValue(r19, "constructor.parameters");
        ArrayList r20 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r19, 10));
        Iterator<T> r21 = r19.iterator();
    L11:
        if (r21.hasNext() == false) goto L13;
        r20.add(new StarProjectionImpl((TypeParameterDescriptor) r21.next()));
        goto L11
    L13:
        r13 = TypeSubstitutionKt.replace$default(r13, r20, null, 2, null);
        goto L14
    L26:
        if ((r11 instanceof SimpleType) == false) goto L40;
        SimpleType r22 = (SimpleType) r11;
        boolean r23 = r22.getConstructor().getParameters().isEmpty();
        r15 = r22;
        if (r23 == true) goto L38;
        ClassifierDescriptor r24 = r22.getConstructor().mo1323getDeclarationDescriptor();
        r15 = r22;
        if (r24 == null) goto L38;
        List<TypeParameterDescriptor> r25 = r22.getConstructor().getParameters();
        Intrinsics.checkNotNullExpressionValue(r25, "constructor.parameters");
        ArrayList r26 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r25, 10));
        Iterator<T> r27 = r25.iterator();
    L34:
        if (r27.hasNext() == false) goto L36;
        r26.add(new StarProjectionImpl((TypeParameterDescriptor) r27.next()));
        goto L34
    L36:
        r15 = TypeSubstitutionKt.replace$default(r22, r26, null, 2, null);
        goto L38
    L40:
        throw new NoWhenBranchMatchedException();
    }

    public static final boolean requiresTypeAliasExpansion(KotlinType r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return contains(r10, C04341.INSTANCE);
    }

    public static final boolean shouldBeUpdated(KotlinType r10) {
        if (r10 != null) goto L4;
    L7:
        return true;
    L4:
        if (contains(r10, C04351.INSTANCE) == true) goto L7;
        return false;
    }
}
