package kotlin.reflect.jvm.internal.impl.types.typeUtil;

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
import kotlin.jvm.internal.SourceDebugExtension;
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
@SourceDebugExtension({"SMAP\nTypeUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TypeUtils.kt\norg/jetbrains/kotlin/types/typeUtil/TypeUtilsKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,406:1\n261#1,14:433\n276#1:451\n265#1,12:452\n261#1,14:464\n276#1:482\n265#1,12:483\n272#1,3:501\n276#1:508\n272#1,3:509\n276#1:516\n272#1,3:517\n276#1:524\n397#1:550\n397#1:551\n397#1:552\n1747#2,3:407\n1549#2:410\n1620#2,3:411\n1855#2,2:414\n1603#2,9:417\n1855#2:426\n1856#2:428\n1612#2:429\n766#2:430\n857#2,2:431\n1549#2:447\n1620#2,3:448\n1549#2:478\n1620#2,3:479\n1747#2,3:495\n1747#2,3:498\n1549#2:504\n1620#2,3:505\n1549#2:512\n1620#2,3:513\n1549#2:520\n1620#2,3:521\n1549#2:525\n1620#2,3:526\n1549#2:529\n1620#2,3:530\n1747#2,3:533\n288#2,2:536\n1549#2:538\n1620#2,3:539\n1549#2:542\n1620#2,3:543\n1549#2:546\n1620#2,3:547\n1#3:416\n1#3:427\n*S KotlinDebug\n*F\n+ 1 TypeUtils.kt\norg/jetbrains/kotlin/types/typeUtil/TypeUtilsKt\n*L\n200#1:433,14\n200#1:451\n200#1:452,12\n201#1:464,14\n201#1:482\n201#1:483,12\n264#1:501,3\n264#1:508\n265#1:509,3\n265#1:516\n267#1:517,3\n267#1:524\n389#1:550\n392#1:551\n395#1:552\n90#1:407,3\n141#1:410\n141#1:411,3\n157#1:414,2\n183#1:417,9\n183#1:426\n183#1:428\n183#1:429\n189#1:430\n189#1:431,2\n200#1:447\n200#1:448,3\n201#1:478\n201#1:479,3\n239#1:495,3\n251#1:498,3\n264#1:504\n264#1:505,3\n265#1:512\n265#1:513,3\n267#1:520\n267#1:521,3\n274#1:525\n274#1:526,3\n281#1:529\n281#1:530,3\n307#1:533,3\n314#1:536,2\n324#1:538\n324#1:539,3\n343#1:542\n343#1:543,3\n351#1:546\n351#1:547,3\n183#1:427\n*E\n"})
public final class TypeUtilsKt {
    public static final TypeProjection asTypeProjection(KotlinType r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return new TypeProjectionImpl(r5);
    }

    public static final boolean contains(KotlinType r5, Function1<? super UnwrappedType, Boolean> r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "predicate");
        return TypeUtils.contains(r5, r10);
    }

    private static final boolean containsSelfTypeParameter(KotlinType r10, TypeConstructor r11, Set<? extends TypeParameterDescriptor> r12) {
        if (Intrinsics.areEqual(r10.getConstructor(), r11) == false) goto L5;
        return true;
    L5:
        ClassifierDescriptor r5 = r10.getConstructor().mo1402getDeclarationDescriptor();
        if ((r5 instanceof ClassifierDescriptorWithTypeParameters) == false) goto L8;
        ClassifierDescriptorWithTypeParameters r13 = (ClassifierDescriptorWithTypeParameters) r5;
    L9:
        if (r13 == null) goto L11;
        List<TypeParameterDescriptor> r14 = r13.getDeclaredTypeParameters();
    L12:
        Iterable r15 = CollectionsKt.withIndex(r10.getArguments());
        if ((r15 instanceof Collection) == true) goto L15;
    L17:
        Iterator r16 = r15.iterator();
    L19:
        if (r16.hasNext() == false) goto L34;
        IndexedValue r17 = (IndexedValue) r16.next();
        int r18 = r17.component1();
        TypeProjection r19 = (TypeProjection) r17.component2();
        if (r14 == null) goto L23;
        TypeParameterDescriptor r20 = (TypeParameterDescriptor) CollectionsKt.getOrNull(r14, r18);
    L24:
        if (r20 == null) goto L30;
        if (r12 == null) goto L30;
        if (r12.contains(r20) == false) goto L30;
    L31:
        boolean r21 = false;
    L33:
        if (r21 == false) goto L19;
        return true;
    L30:
        if (r19.isStarProjection() == true) goto L31;
        r21 = containsSelfTypeParameter(r19.getType(), r11, r12);
        goto L33
    L23:
        r20 = null;
    L34:
        return false;
    L15:
        if (((Collection) r15).isEmpty() == false) goto L17;
    L11:
        r14 = null;
        goto L12
    L8:
        r13 = null;
        goto L9
    }

    public static final boolean containsTypeAliasParameters(KotlinType r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return contains(r5, AnonymousClass1.INSTANCE);
    }

    public static final boolean containsTypeParameter(KotlinType r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return TypeUtils.contains(r5, C02421.INSTANCE);
    }

    public static final TypeProjection createProjection(KotlinType r5, Variance r10, TypeParameterDescriptor r11) {
        Intrinsics.checkNotNullParameter(r5, "type");
        Intrinsics.checkNotNullParameter(r10, "projectionKind");
        if (r11 == null) goto L5;
        Variance r12 = r11.getVariance();
    L6:
        if (r12 != r10) goto L9;
        r10 = Variance.INVARIANT;
    L9:
        return new TypeProjectionImpl(r10, r5);
    L5:
        r12 = null;
        goto L6
    }

    public static final Set<TypeParameterDescriptor> extractTypeParametersFromUpperBounds(KotlinType r5, Set<? extends TypeParameterDescriptor> r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        LinkedHashSet r11 = new LinkedHashSet();
        extractTypeParametersFromUpperBounds(r5, r5, r11, r10);
        return r11;
    }

    public static final KotlinBuiltIns getBuiltIns(KotlinType r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return r5.getConstructor().getBuiltIns();
    }

    public static final KotlinType getRepresentativeUpperBound(TypeParameterDescriptor r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        r5.getUpperBounds().isEmpty();
        Iterator<T> r10 = r5.getUpperBounds().iterator();
    L3:
        Object r11 = null;
        ClassDescriptor r12 = null;
        if (r10.hasNext() == false) goto L15;
        Object r13 = r10.next();
        ClassifierDescriptor r14 = ((KotlinType) r13).getConstructor().mo1402getDeclarationDescriptor();
        if ((r14 instanceof ClassDescriptor) == false) goto L8;
        r12 = (ClassDescriptor) r14;
    L8:
        if (r12 == null) goto L3;
        if (r12.getKind() == ClassKind.INTERFACE) goto L3;
        if (r12.getKind() == ClassKind.ANNOTATION_CLASS) goto L3;
        r11 = r13;
    L15:
        KotlinType r15 = (KotlinType) r11;
        if (r15 == null) goto L18;
        return r15;
    L18:
        return (KotlinType) CollectionsKt.first(r5.getUpperBounds());
    }

    @JvmOverloads
    public static final boolean hasTypeParameterRecursiveBounds(TypeParameterDescriptor r5) {
        Intrinsics.checkNotNullParameter(r5, "typeParameter");
        return hasTypeParameterRecursiveBounds$default(r5, null, null, 6, null);
    }

    public static /* synthetic */ boolean hasTypeParameterRecursiveBounds$default(TypeParameterDescriptor r5, TypeConstructor r10, Set r11, int r12, Object r13) {
        if ((r12 & 2) == 0) goto L6;
        r10 = null;
    L6:
        if ((r12 & 4) == 0) goto L9;
        r11 = null;
    L9:
        return hasTypeParameterRecursiveBounds(r5, r10, r11);
    }

    public static final boolean isBoolean(KotlinType r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return KotlinBuiltIns.isBoolean(r5);
    }

    public static final boolean isNothing(KotlinType r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return KotlinBuiltIns.isNothing(r5);
    }

    public static final boolean isStubType(KotlinType r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if ((r5 instanceof AbstractStubType) == false) goto L5;
    L10:
        return true;
    L5:
        if ((r5 instanceof DefinitelyNotNullType) == true) goto L7;
    L9:
        return false;
    L7:
        if ((((DefinitelyNotNullType) r5).getOriginal() instanceof AbstractStubType) == false) goto L9;
        goto L9
    }

    public static final boolean isStubTypeForBuilderInference(KotlinType r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if ((r5 instanceof StubTypeForBuilderInference) == false) goto L5;
    L10:
        return true;
    L5:
        if ((r5 instanceof DefinitelyNotNullType) == true) goto L7;
    L9:
        return false;
    L7:
        if ((((DefinitelyNotNullType) r5).getOriginal() instanceof StubTypeForBuilderInference) == false) goto L9;
        goto L9
    }

    public static final boolean isSubtypeOf(KotlinType r5, KotlinType r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "superType");
        return KotlinTypeChecker.DEFAULT.isSubtypeOf(r5, r10);
    }

    public static final boolean isTypeAliasParameter(ClassifierDescriptor r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if ((r5 instanceof TypeParameterDescriptor) == true) goto L5;
    L7:
        return false;
    L5:
        if ((((TypeParameterDescriptor) r5).getContainingDeclaration() instanceof TypeAliasDescriptor) == false) goto L7;
        return true;
    }

    public static final boolean isTypeParameter(KotlinType r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return TypeUtils.isTypeParameter(r5);
    }

    public static final boolean isUnresolvedType(KotlinType r5) {
        Intrinsics.checkNotNullParameter(r5, "type");
        if ((r5 instanceof ErrorType) == true) goto L5;
    L7:
        return false;
    L5:
        if (((ErrorType) r5).getKind().isUnresolved() == false) goto L7;
        return true;
    }

    public static final KotlinType makeNotNullable(KotlinType r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return TypeUtils.makeNotNullable(r5);
    }

    public static final KotlinType makeNullable(KotlinType r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return TypeUtils.makeNullable(r5);
    }

    public static final KotlinType replaceAnnotations(KotlinType r5, Annotations r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "newAnnotations");
        if (r5.getAnnotations().isEmpty() == false) goto L8;
        if (r10.isEmpty() == false) goto L8;
        return r5;
    L8:
        return r5.unwrap().replaceAttributes(TypeAttributesKt.replaceAnnotations(r5.getAttributes(), r10));
    }

    public static final KotlinType replaceArgumentsWithStarProjections(KotlinType r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        UnwrappedType r11 = r10.unwrap();
        if ((r11 instanceof FlexibleType) == false) goto L26;
        FlexibleType r5 = (FlexibleType) r11;
        SimpleType r12 = r5.getLowerBound();
        if (r12.getConstructor().getParameters().isEmpty() == false) goto L7;
    L14:
        SimpleType r13 = r5.getUpperBound();
        if (r13.getConstructor().getParameters().isEmpty() == false) goto L17;
    L24:
        UnwrappedType r14 = KotlinTypeFactory.flexibleType(r12, r13);
    L38:
        return TypeWithEnhancementKt.inheritEnhancement(r14, r11);
    L17:
        if (r13.getConstructor().mo1402getDeclarationDescriptor() == null) goto L24;
        List<TypeParameterDescriptor> r15 = r13.getConstructor().getParameters();
        ArrayList r16 = new ArrayList(CollectionsKt.h(r15));
        Iterator<T> r17 = r15.iterator();
    L21:
        if (r17.hasNext() == false) goto L23;
        r16.add(new StarProjectionImpl((TypeParameterDescriptor) r17.next()));
        goto L21
    L23:
        r13 = TypeSubstitutionKt.replace$default(r13, r16, null, 2, null);
        goto L24
    L7:
        if (r12.getConstructor().mo1402getDeclarationDescriptor() == null) goto L14;
        List<TypeParameterDescriptor> r18 = r12.getConstructor().getParameters();
        ArrayList r19 = new ArrayList(CollectionsKt.h(r18));
        Iterator<T> r20 = r18.iterator();
    L11:
        if (r20.hasNext() == false) goto L13;
        r19.add(new StarProjectionImpl((TypeParameterDescriptor) r20.next()));
        goto L11
    L13:
        r12 = TypeSubstitutionKt.replace$default(r12, r19, null, 2, null);
        goto L14
    L26:
        if ((r11 instanceof SimpleType) == false) goto L40;
        SimpleType r21 = (SimpleType) r11;
        boolean r22 = r21.getConstructor().getParameters().isEmpty();
        r14 = r21;
        if (r22 == true) goto L38;
        ClassifierDescriptor r23 = r21.getConstructor().mo1402getDeclarationDescriptor();
        r14 = r21;
        if (r23 == null) goto L38;
        List<TypeParameterDescriptor> r24 = r21.getConstructor().getParameters();
        ArrayList r25 = new ArrayList(CollectionsKt.h(r24));
        Iterator<T> r26 = r24.iterator();
    L34:
        if (r26.hasNext() == false) goto L36;
        r25.add(new StarProjectionImpl((TypeParameterDescriptor) r26.next()));
        goto L34
    L36:
        r14 = TypeSubstitutionKt.replace$default(r21, r25, null, 2, null);
        goto L38
    L40:
        throw new NoWhenBranchMatchedException();
    }

    public static final boolean requiresTypeAliasExpansion(KotlinType r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return contains(r5, C02431.INSTANCE);
    }

    public static final boolean shouldBeUpdated(KotlinType r5) {
        if (r5 != null) goto L4;
    L7:
        return true;
    L4:
        if (contains(r5, C02441.INSTANCE) == true) goto L7;
        return false;
    }

    private static final void extractTypeParametersFromUpperBounds(KotlinType r10, KotlinType r11, Set<TypeParameterDescriptor> r12, Set<? extends TypeParameterDescriptor> r13) {
        ClassifierDescriptor r5 = r10.getConstructor().mo1402getDeclarationDescriptor();
        if ((r5 instanceof TypeParameterDescriptor) == true) goto L5;
        ClassifierDescriptor r14 = r10.getConstructor().mo1402getDeclarationDescriptor();
        if ((r14 instanceof ClassifierDescriptorWithTypeParameters) == false) goto L14;
        ClassifierDescriptorWithTypeParameters r15 = (ClassifierDescriptorWithTypeParameters) r14;
    L15:
        if (r15 == null) goto L17;
        List<TypeParameterDescriptor> r16 = r15.getDeclaredTypeParameters();
    L18:
        Iterator<TypeProjection> r17 = r10.getArguments().iterator();
        int r18 = 0;
    L20:
        if (r17.hasNext() == false) goto L49;
        int r19 = r18 + 1;
        TypeProjection r20 = r17.next();
        if (r16 == null) goto L24;
        TypeParameterDescriptor r21 = (TypeParameterDescriptor) CollectionsKt.getOrNull(r16, r18);
    L25:
        if (r21 == null) goto L31;
        if (r13 == null) goto L31;
        if (r13.contains(r21) == false) goto L31;
    L39:
        r18 = r19;
    L31:
        if (r20.isStarProjection() == true) goto L39;
        if (CollectionsKt.contains(r12, r20.getType().getConstructor().mo1402getDeclarationDescriptor()) == true) goto L39;
        if (Intrinsics.areEqual(r20.getType().getConstructor(), r11.getConstructor()) == true) goto L39;
        extractTypeParametersFromUpperBounds(r20.getType(), r11, r12, r13);
        goto L39
    L24:
        r21 = null;
        goto L25
    L49:
        return;
    L17:
        r16 = null;
        goto L18
    L14:
        r15 = null;
        goto L15
    L5:
        if (Intrinsics.areEqual(r10.getConstructor(), r11.getConstructor()) == true) goto L7;
        r12.add(r5);
        return;
    L7:
        Iterator<KotlinType> r22 = ((TypeParameterDescriptor) r5).getUpperBounds().iterator();
    L9:
        if (r22.hasNext() == false) goto L48;
        extractTypeParametersFromUpperBounds(r22.next(), r11, r12, r13);
        goto L9
    }

    @JvmOverloads
    public static final boolean hasTypeParameterRecursiveBounds(TypeParameterDescriptor r5, TypeConstructor r10, Set<? extends TypeParameterDescriptor> r11) {
        Intrinsics.checkNotNullParameter(r5, "typeParameter");
        List<KotlinType> r12 = r5.getUpperBounds();
        if (r12 != null) goto L5;
    L7:
        Iterator<T> r13 = r12.iterator();
    L9:
        if (r13.hasNext() == false) goto L25;
        KotlinType r14 = (KotlinType) r13.next();
        if (containsSelfTypeParameter(r14, r5.getDefaultType().getConstructor(), r11) == false) goto L9;
        if (r10 == null) goto L15;
        if (Intrinsics.areEqual(r14.getConstructor(), r10) == false) goto L9;
    L15:
        return true;
    L25:
        return false;
    L5:
        if (r12.isEmpty() == false) goto L7;
        return false;
    }
}
