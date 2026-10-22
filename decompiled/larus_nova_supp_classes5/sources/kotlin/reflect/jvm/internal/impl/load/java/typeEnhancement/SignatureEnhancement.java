package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorUtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyGetterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType;
import kotlin.reflect.jvm.internal.impl.load.java.DeprecationCausedByFunctionNInfo;
import kotlin.reflect.jvm.internal.impl.load.java.UtilsKt;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaCallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaPropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.JavaDescriptorUtilKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureBuildingUtilsKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.deprecation.DescriptorBasedDeprecationInfoKt;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.RawType;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class SignatureEnhancement {
    private final JavaTypeEnhancement typeEnhancement;

    public static /* synthetic */ KotlinType accessor$SignatureEnhancement$lambda0(CallableMemberDescriptor r0) {
        return enhanceSignature$lambda$2(r0);
    }

    public static /* synthetic */ KotlinType accessor$SignatureEnhancement$lambda1(ValueParameterDescriptor r0, CallableMemberDescriptor r1) {
        return enhanceSignature$lambda$8$lambda$7(r0, r1);
    }

    public static /* synthetic */ KotlinType accessor$SignatureEnhancement$lambda2(CallableMemberDescriptor r0) {
        return enhanceSignature$lambda$9(r0);
    }

    public static /* synthetic */ boolean accessor$SignatureEnhancement$lambda3(UnwrappedType r0) {
        return enhanceTypeParameterBounds$lambda$14$lambda$13(r0);
    }

    public static /* synthetic */ Boolean accessor$SignatureEnhancement$lambda4(UnwrappedType r0) {
        return containsFunctionN$lambda$15(r0);
    }

    public SignatureEnhancement(JavaTypeEnhancement r2) {
        Intrinsics.checkNotNullParameter(r2, "typeEnhancement");
        this.typeEnhancement = r2;
    }

    private final boolean containsFunctionN(KotlinType r2) {
        return TypeUtils.contains(r2, SignatureEnhancement$.Lambda.4.INSTANCE);
    }

    private static final Boolean containsFunctionN$lambda$15(UnwrappedType r3) {
        ClassifierDescriptor r4 = r3.getConstructor().getDeclarationDescriptor();
        if (r4 == null) goto L5;
        Name r0 = r4.getName();
        JavaToKotlinClassMap r1 = JavaToKotlinClassMap.INSTANCE;
        if (Intrinsics.areEqual(r0, r1.getFUNCTION_N_FQ_NAME().shortName()) == true) goto L9;
    L11:
        boolean r5 = false;
    L13:
        return Boolean.valueOf(r5);
    L9:
        if (Intrinsics.areEqual(DescriptorUtilsKt.fqNameOrNull(r4), r1.getFUNCTION_N_FQ_NAME()) == false) goto L11;
        r5 = true;
        goto L13
    L5:
        return Boolean.FALSE;
    }

    private static final KotlinType enhanceSignature$lambda$2(CallableMemberDescriptor r1) {
        Intrinsics.checkNotNullParameter(r1, "it");
        ReceiverParameterDescriptor r2 = r1.getExtensionReceiverParameter();
        Intrinsics.checkNotNull(r2);
        return r2.getType();
    }

    private static final KotlinType enhanceSignature$lambda$9(CallableMemberDescriptor r1) {
        Intrinsics.checkNotNullParameter(r1, "it");
        KotlinType r2 = r1.getReturnType();
        Intrinsics.checkNotNull(r2);
        return r2;
    }

    private static final boolean enhanceTypeParameterBounds$lambda$14$lambda$13(UnwrappedType r1) {
        Intrinsics.checkNotNullParameter(r1, "it");
        return r1 instanceof RawType;
    }

    private final <D extends CallableMemberDescriptor> D enhanceSignature(D r20, LazyJavaResolverContext r21) {
        if ((r20 instanceof JavaCallableMemberDescriptor) == true) goto L5;
        return r20;
    L5:
        boolean r13 = true;
        if (r20.getKind() == CallableMemberDescriptor.Kind.FAKE_OVERRIDE) goto L8;
    L10:
        LazyJavaResolverContext r8 = ContextKt.copyWithNewDefaultTypeQualifiers(r21, getDefaultAnnotations(r20, r21));
        if ((r20 instanceof JavaPropertyDescriptor) == false) goto L20;
        PropertyDescriptorImpl r0 = (PropertyDescriptorImpl) r20;
        PropertyGetterDescriptorImpl r1 = r0.getGetter();
        if (r1 != null) goto L15;
    L17:
        boolean r2 = false;
    L18:
        if (r2 == false) goto L20;
        PropertyGetterDescriptorImpl r3 = r0.getGetter();
        Intrinsics.checkNotNull(r3);
        D r9 = r3;
    L21:
        TypeEnhancementInfo r15 = null;
        if (r20.getExtensionReceiverParameter() != null) goto L24;
        KotlinType r16 = null;
    L33:
        if ((r20 instanceof JavaMethodDescriptor) == false) goto L35;
        JavaMethodDescriptor r4 = (JavaMethodDescriptor) r20;
    L36:
        if (r4 == null) goto L40;
        SignatureBuildingComponents r5 = SignatureBuildingComponents.INSTANCE;
        DeclarationDescriptor r6 = r4.getContainingDeclaration();
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        String r7 = MethodSignatureBuildingUtilsKt.signature(r5, (ClassDescriptor) r6, MethodSignatureMappingKt.computeJvmDescriptor$default(r4, false, false, 3, null));
        if (r7 == null) goto L40;
        PredefinedFunctionEnhancementInfo r10 = (PredefinedFunctionEnhancementInfo) PredefinedEnhancementInfoKt.getPREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE().get(r7);
    L41:
        if (r10 == null) goto L44;
        r10.getParametersInfo().size();
        ((JavaMethodDescriptor) r20).getValueParameters().size();
    L44:
        if (UtilsKt.isJspecifyEnabledInStrictMode(r21.getComponents().getJavaTypeEnhancementState()) == true) goto L48;
        if (r8.getComponents().getSettings().getIgnoreNullabilityForErasedValueParameters() == true) goto L48;
    L50:
        boolean r11 = false;
    L51:
        List<ValueParameterDescriptor> r12 = r9.getValueParameters();
        ArrayList r14 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10));
        Iterator<T> r17 = r12.iterator();
    L53:
        if (r17.hasNext() == false) goto L61;
        ValueParameterDescriptor r18 = (ValueParameterDescriptor) r17.next();
        if (r10 == null) goto L59;
        List r19 = r10.getParametersInfo();
        if (r19 == null) goto L59;
        TypeEnhancementInfo r22 = (TypeEnhancementInfo) CollectionsKt.getOrNull(r19, r18.getIndex());
    L60:
        ArrayList r110 = r14;
        r110.add(enhanceValueParameter(r20, r18, r8, r22, r11, new SignatureEnhancement$.Lambda.1(r18)));
        r14 = r110;
        r15 = null;
    L59:
        r22 = r15;
        goto L60
    L61:
        ArrayList r111 = r14;
        if ((r20 instanceof PropertyDescriptor) == false) goto L64;
        PropertyDescriptor r23 = (PropertyDescriptor) r20;
    L65:
        if (r23 != null) goto L67;
    L69:
        boolean r24 = false;
    L70:
        if (r24 == false) goto L72;
        AnnotationQualifierApplicabilityType r25 = AnnotationQualifierApplicabilityType.FIELD;
    L73:
        AnnotationQualifierApplicabilityType r26 = r25;
        if (r10 == null) goto L76;
        TypeEnhancementInfo r27 = r10.getReturnTypeInfo();
    L77:
        KotlinType r28 = enhance$default(this, r20, r9, true, r8, r26, r27, false, SignatureEnhancement$.Lambda.2.INSTANCE, 32, null);
        KotlinType r29 = r20.getReturnType();
        Intrinsics.checkNotNull(r29);
        if (containsFunctionN(r29) == true) goto L100;
        ReceiverParameterDescriptor r30 = r20.getExtensionReceiverParameter();
        if (r30 == null) goto L84;
        KotlinType r31 = r30.getType();
        if (r31 == null) goto L84;
        boolean r32 = containsFunctionN(r31);
    L85:
        if (r32 == true) goto L100;
        List<ValueParameterDescriptor> r33 = r20.getValueParameters();
        if ((r33 instanceof Collection) == true) goto L89;
    L91:
        Iterator<T> r34 = r33.iterator();
    L93:
        if (r34.hasNext() == false) goto L90;
        if (containsFunctionN(((ValueParameterDescriptor) r34.next()).getType()) == false) goto L93;
        boolean r35 = true;
    L97:
        if (r35 == true) goto L100;
        boolean r36 = false;
    L101:
        if (r36 == false) goto L103;
        Pair r37 = TuplesKt.to(DescriptorBasedDeprecationInfoKt.getDEPRECATED_FUNCTION_KEY(), new DeprecationCausedByFunctionNInfo(r20));
    L104:
        if (r16 != null) goto L121;
        if (r28 != null) goto L121;
        if (r111.isEmpty() == false) goto L109;
    L108:
        r13 = false;
    L117:
        if (r13 == true) goto L121;
        if (r37 != null) goto L121;
        return r20;
    L109:
        Iterator r38 = r111.iterator();
    L111:
        if (r38.hasNext() == false) goto L108;
        if (((KotlinType) r38.next()) == null) goto L115;
        boolean r39 = true;
    L116:
        if (r39 == false) goto L111;
    L115:
        r39 = false;
    L121:
        JavaCallableMemberDescriptor r40 = (JavaCallableMemberDescriptor) r20;
        if (r16 != null) goto L127;
        ReceiverParameterDescriptor r41 = r20.getExtensionReceiverParameter();
        if (r41 == null) goto L126;
        KotlinType r42 = r41.getType();
    L128:
        ArrayList r43 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r111, 10));
        Iterator r44 = r111.iterator();
        int r112 = 0;
    L130:
        if (r44.hasNext() == false) goto L138;
        Object r45 = r44.next();
        int r46 = r112 + 1;
        if (r112 >= 0) goto L134;
        CollectionsKt.throwIndexOverflow();
    L134:
        KotlinType r47 = (KotlinType) r45;
        if (r47 != null) goto L137;
        r47 = ((ValueParameterDescriptor) ListProtector.get(r20.getValueParameters(), r112)).getType();
    L137:
        r43.add(r47);
        r112 = r46;
        goto L130
    L138:
        if (r28 != null) goto L140;
        r28 = r20.getReturnType();
        Intrinsics.checkNotNull(r28);
    L140:
        JavaCallableMemberDescriptor r48 = r40.enhance(r42, r43, r28, r37);
        Intrinsics.checkNotNull(r48, "null cannot be cast to non-null type D of org.jetbrains.kotlin.load.java.typeEnhancement.SignatureEnhancement.enhanceSignature");
        return r48;
    L126:
        r42 = null;
        goto L128
    L127:
        r42 = r16;
        goto L128
    L103:
        r37 = null;
    L90:
        r35 = false;
        goto L97
    L89:
        if (r33.isEmpty() == false) goto L91;
    L84:
        r32 = false;
    L100:
        r36 = true;
        goto L101
    L76:
        r27 = null;
        goto L77
    L72:
        r25 = AnnotationQualifierApplicabilityType.METHOD_RETURN_TYPE;
        goto L73
    L67:
        if (JavaDescriptorUtilKt.isJavaField(r23) != true) goto L69;
        r24 = true;
        goto L70
    L64:
        r23 = null;
    L48:
        if (UtilsKt.hasErasedValueParameters(r20) == false) goto L50;
        r11 = true;
    L40:
        r10 = null;
        goto L41
    L35:
        r4 = null;
        goto L36
    L24:
        if ((r9 instanceof FunctionDescriptor) == false) goto L26;
        FunctionDescriptor r49 = (FunctionDescriptor) r9;
    L27:
        if (r49 == null) goto L29;
        ValueParameterDescriptor r50 = (ValueParameterDescriptor) r49.getUserData(JavaMethodDescriptor.ORIGINAL_VALUE_PARAMETER_FOR_EXTENSION_RECEIVER);
    L30:
        r16 = enhanceValueParameter(r20, r50, r8, null, false, SignatureEnhancement$.Lambda.0.INSTANCE);
        goto L33
    L29:
        r50 = null;
        goto L30
    L26:
        r49 = null;
        goto L27
    L15:
        if (r1.isDefault() == true) goto L17;
        r2 = true;
    L20:
        r9 = r20;
        goto L21
    L8:
        if (r20.getOriginal().getOverriddenDescriptors().size() != 1) goto L10;
        return r20;
    }

    private static final KotlinType enhanceSignature$lambda$8$lambda$7(ValueParameterDescriptor r1, CallableMemberDescriptor r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return ((ValueParameterDescriptor) ListProtector.get(r2.getValueParameters(), r1.getIndex())).getType();
    }

    private final <D extends CallableMemberDescriptor> Annotations getDefaultAnnotations(D r6, LazyJavaResolverContext r7) {
        LazyJavaClassDescriptor r0 = DescriptorUtilKt.getTopLevelContainingClassifier(r6);
        if (r0 == null) goto L5;
        List r2 = null;
        if ((r0 instanceof LazyJavaClassDescriptor) == false) goto L9;
        LazyJavaClassDescriptor r1 = r0;
    L10:
        if (r1 == null) goto L12;
        r2 = r1.getModuleAnnotations();
    L12:
        List r3 = r2;
        if (r3 != null) goto L15;
    L18:
        boolean r4 = true;
    L19:
        if (r4 == true) goto L21;
        List r5 = r2;
        ArrayList r8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator r9 = r5.iterator();
    L24:
        if (r9.hasNext() == false) goto L27;
        r8.add(new LazyJavaAnnotationDescriptor(r7, (JavaAnnotation) r9.next(), true));
        goto L24
    L27:
        return Annotations.Companion.create(CollectionsKt.plus(r6.getAnnotations(), r8));
    L21:
        return r6.getAnnotations();
    L15:
        if (r3.isEmpty() == true) goto L18;
        r4 = false;
        goto L19
    L9:
        r1 = null;
        goto L10
    L5:
        return r6.getAnnotations();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <D extends CallableMemberDescriptor> Collection<D> enhanceSignatures(LazyJavaResolverContext r3, Collection<? extends D> r4) {
        Intrinsics.checkNotNullParameter(r3, "c");
        Intrinsics.checkNotNullParameter(r4, "platformSignatures");
        Collection<? extends D> r5 = r4;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator<T> r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        r0.add(enhanceSignature((CallableMemberDescriptor) r6.next(), r3));
        goto L4
    L6:
        return r0;
    }

    public final KotlinType enhanceSuperType(KotlinType r10, LazyJavaResolverContext r11) {
        Intrinsics.checkNotNullParameter(r10, EffectConfiguration.KEY_TYPE);
        Intrinsics.checkNotNullParameter(r11, "context");
        KotlinType r12 = enhance$default(this, new SignatureParts(null, false, r11, AnnotationQualifierApplicabilityType.TYPE_USE, true), r10, CollectionsKt.emptyList(), null, false, 12, null);
        if (r12 != null) goto L6;
        return r10;
    L6:
        return r12;
    }

    public final List<KotlinType> enhanceTypeParameterBounds(TypeParameterDescriptor r13, List<? extends KotlinType> r14, LazyJavaResolverContext r15) {
        Intrinsics.checkNotNullParameter(r13, "typeParameter");
        Intrinsics.checkNotNullParameter(r14, "bounds");
        Intrinsics.checkNotNullParameter(r15, "context");
        List<? extends KotlinType> r16 = r14;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r16, 10));
        Iterator<T> r17 = r16.iterator();
    L4:
        if (r17.hasNext() == false) goto L13;
        KotlinType r1 = (KotlinType) r17.next();
        if (TypeUtilsKt.contains(r1, SignatureEnhancement$.Lambda.3.INSTANCE) == true) goto L12;
        KotlinType r2 = enhance$default(this, new SignatureParts(r13, false, r15, AnnotationQualifierApplicabilityType.TYPE_PARAMETER_BOUNDS, false, 16, null), r1, CollectionsKt.emptyList(), null, false, 12, null);
        if (r2 == null) goto L12;
        r1 = r2;
    L12:
        r0.add(r1);
        goto L4
    L13:
        return r0;
    }

    private final KotlinType enhance(SignatureParts r2, KotlinType r3, List<? extends KotlinType> r4, TypeEnhancementInfo r5, boolean r6) {
        return this.typeEnhancement.enhance(r3, r2.computeIndexedQualifiers(r3, r4, r5, r6), r2.getSkipRawTypeArguments());
    }

    private final KotlinType enhanceValueParameter(CallableMemberDescriptor r10, ValueParameterDescriptor r11, LazyJavaResolverContext r12, TypeEnhancementInfo r13, boolean r14, Function1<? super CallableMemberDescriptor, ? extends KotlinType> r15) {
        if (r11 == null) goto L8;
        LazyJavaResolverContext r0 = ContextKt.copyWithNewDefaultTypeQualifiers(r12, r11.getAnnotations());
        if (r0 == null) goto L8;
        LazyJavaResolverContext r4 = r0;
    L10:
        return enhance(r10, r11, false, r4, AnnotationQualifierApplicabilityType.VALUE_PARAMETER, r13, r14, r15);
    L8:
        r4 = r12;
        goto L10
    }

    private final KotlinType enhance(CallableMemberDescriptor r11, Annotated r12, boolean r13, LazyJavaResolverContext r14, AnnotationQualifierApplicabilityType r15, TypeEnhancementInfo r16, boolean r17, Function1<? super CallableMemberDescriptor, ? extends KotlinType> r18) {
        SignatureParts r9 = new SignatureParts(r12, r13, r14, r15, false, 16, null);
        KotlinType r2 = (KotlinType) r18.invoke(r11);
        Collection<? extends CallableMemberDescriptor> r1 = r11.getOverriddenDescriptors();
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator<T> r4 = r1.iterator();
    L4:
        if (r4.hasNext() == false) goto L7;
        CallableMemberDescriptor r5 = (CallableMemberDescriptor) r4.next();
        Intrinsics.checkNotNull(r5);
        r3.add((KotlinType) r18.invoke(r5));
        goto L4
    L7:
        return enhance(r9, r2, r3, r16, r17);
    }

    public static /* synthetic */ KotlinType enhance$default(SignatureEnhancement r6, SignatureParts r7, KotlinType r8, List r9, TypeEnhancementInfo r10, boolean r11, int r12, Object r13) {
        if ((r12 & 4) == 0) goto L5;
        r10 = null;
    L5:
        TypeEnhancementInfo r4 = r10;
        if ((r12 & 8) == 0) goto L8;
        boolean r5 = false;
    L10:
        return r6.enhance(r7, r8, r9, r4, r5);
    L8:
        r5 = r11;
        goto L10
    }

    public static /* synthetic */ KotlinType enhance$default(SignatureEnhancement r10, CallableMemberDescriptor r11, Annotated r12, boolean r13, LazyJavaResolverContext r14, AnnotationQualifierApplicabilityType r15, TypeEnhancementInfo r16, boolean r17, Function1 r18, int r19, Object r20) {
        if ((r19 & 32) == 0) goto L5;
        boolean r8 = false;
    L7:
        return r10.enhance(r11, r12, r13, r14, r15, r16, r8, r18);
    L5:
        r8 = r17;
        goto L7
    }
}
