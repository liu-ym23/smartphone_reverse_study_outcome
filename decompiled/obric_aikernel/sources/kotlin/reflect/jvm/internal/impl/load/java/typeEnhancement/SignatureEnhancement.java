package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import com.bytedance.common.wschannel.WsConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
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
import kotlin.reflect.jvm.internal.impl.resolve.deprecation.DescriptorBasedDeprecationInfoKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class SignatureEnhancement {
    private final JavaTypeEnhancement typeEnhancement;

    public SignatureEnhancement(JavaTypeEnhancement r10) {
        Intrinsics.checkNotNullParameter(r10, "typeEnhancement");
        this.typeEnhancement = r10;
    }

    private final boolean containsFunctionN(KotlinType r10) {
        return TypeUtils.contains(r10, AnonymousClass1.INSTANCE);
    }

    private final KotlinType enhance(CallableMemberDescriptor r11, Annotated r12, boolean r13, LazyJavaResolverContext r14, AnnotationQualifierApplicabilityType r15, TypeEnhancementInfo r16, boolean r17, Function1<? super CallableMemberDescriptor, ? extends KotlinType> r18) {
        SignatureParts r10 = new SignatureParts(r12, r13, r14, r15, false, 16, null);
        KotlinType r19 = r18.invoke(r11);
        Collection<? extends CallableMemberDescriptor> r20 = r11.getOverriddenDescriptors();
        Intrinsics.checkNotNullExpressionValue(r20, "overriddenDescriptors");
        ArrayList r21 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r20, 10));
        Iterator<T> r22 = r20.iterator();
    L4:
        if (r22.hasNext() == false) goto L7;
        CallableMemberDescriptor r23 = (CallableMemberDescriptor) r22.next();
        Intrinsics.checkNotNullExpressionValue(r23, "it");
        r21.add(r18.invoke(r23));
        goto L4
    L7:
        return enhance(r10, r19, r21, r16, r17);
    }

    private final KotlinType enhance(SignatureParts r10, KotlinType r11, List<? extends KotlinType> r12, TypeEnhancementInfo r13, boolean r14) {
        return this.typeEnhancement.enhance(r11, r10.computeIndexedQualifiers(r11, r12, r13, r14), r10.getSkipRawTypeArguments());
    }

    static /* synthetic */ KotlinType enhance$default(SignatureEnhancement r10, CallableMemberDescriptor r11, Annotated r12, boolean r13, LazyJavaResolverContext r14, AnnotationQualifierApplicabilityType r15, TypeEnhancementInfo r16, boolean r17, Function1 r18, int r19, Object r20) {
        if ((r19 & 32) == 0) goto L5;
        boolean r21 = false;
    L7:
        return r10.enhance(r11, r12, r13, r14, r15, r16, r21, r18);
    L5:
        r21 = r17;
        goto L7
    }

    static /* synthetic */ KotlinType enhance$default(SignatureEnhancement r10, SignatureParts r11, KotlinType r12, List r13, TypeEnhancementInfo r14, boolean r15, int r16, Object r17) {
        if ((r16 & 4) == 0) goto L5;
        r14 = null;
    L5:
        TypeEnhancementInfo r18 = r14;
        if ((r16 & 8) == 0) goto L9;
        r15 = false;
    L9:
        return r10.enhance(r11, r12, r13, r18, r15);
    }

    private final <D extends CallableMemberDescriptor> D enhanceSignature(D r21, LazyJavaResolverContext r22) {
        if ((r21 instanceof JavaCallableMemberDescriptor) == true) goto L5;
        return r21;
    L5:
        JavaCallableMemberDescriptor r13 = (JavaCallableMemberDescriptor) r21;
        boolean r14 = true;
        if (r13.getKind() == CallableMemberDescriptor.Kind.FAKE_OVERRIDE) goto L8;
    L10:
        LazyJavaResolverContext r10 = ContextKt.copyWithNewDefaultTypeQualifiers(r22, getDefaultAnnotations(r21, r22));
        if ((r21 instanceof JavaPropertyDescriptor) == false) goto L20;
        JavaPropertyDescriptor r11 = (JavaPropertyDescriptor) r21;
        PropertyGetterDescriptorImpl r12 = r11.getGetter();
        if (r12 != null) goto L15;
    L17:
        boolean r15 = false;
    L18:
        if (r15 == false) goto L20;
        PropertyGetterDescriptorImpl r16 = r11.getGetter();
        Intrinsics.checkNotNull(r16);
        D r17 = r16;
    L22:
        if (r13.getExtensionReceiverParameter() != null) goto L24;
        KotlinType r18 = null;
    L34:
        if ((r21 instanceof JavaMethodDescriptor) == false) goto L36;
        JavaMethodDescriptor r19 = (JavaMethodDescriptor) r21;
    L37:
        if (r19 == null) goto L41;
        SignatureBuildingComponents r20 = SignatureBuildingComponents.INSTANCE;
        DeclarationDescriptor r23 = r19.getContainingDeclaration();
        Intrinsics.checkNotNull(r23, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        String r24 = MethodSignatureBuildingUtilsKt.signature(r20, (ClassDescriptor) r23, MethodSignatureMappingKt.computeJvmDescriptor$default(r19, false, false, 3, null));
        if (r24 == null) goto L41;
        PredefinedFunctionEnhancementInfo r110 = PredefinedEnhancementInfoKt.getPREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE().get(r24);
    L42:
        if (r110 == null) goto L45;
        r110.getParametersInfo().size();
        r13.getValueParameters().size();
    L45:
        if (UtilsKt.isJspecifyEnabledInStrictMode(r22.getComponents().getJavaTypeEnhancementState()) == true) goto L49;
        if (r10.getComponents().getSettings().getIgnoreNullabilityForErasedValueParameters() == true) goto L49;
    L51:
        boolean r25 = false;
    L52:
        List<ValueParameterDescriptor> r26 = r17.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(r26, "annotationOwnerForMember.valueParameters");
        char r27 = '\n';
        ArrayList r28 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r26, 10));
        Iterator<T> r111 = r26.iterator();
    L54:
        if (r111.hasNext() == false) goto L62;
        final ValueParameterDescriptor r29 = (ValueParameterDescriptor) r111.next();
        if (r110 == null) goto L60;
        List<TypeEnhancementInfo> r30 = r110.getParametersInfo();
        if (r30 == null) goto L60;
        TypeEnhancementInfo r31 = (TypeEnhancementInfo) CollectionsKt.getOrNull(r30, r29.getIndex());
    L61:
        ArrayList r112 = r28;
        r112.add(enhanceValueParameter(r21, r29, r10, r31, r25, new SignatureEnhancement$enhanceSignature$valueParameterEnhancements$1$1(r29)));
        r28 = r112;
        r27 = '\n';
    L60:
        r31 = null;
        goto L61
    L62:
        ArrayList r113 = r28;
        if ((r21 instanceof PropertyDescriptor) == true) goto L65;
        D r32 = null;
    L66:
        PropertyDescriptor r33 = (PropertyDescriptor) r32;
        if (r33 != null) goto L69;
    L71:
        boolean r34 = false;
    L72:
        if (r34 == false) goto L74;
        AnnotationQualifierApplicabilityType r35 = AnnotationQualifierApplicabilityType.FIELD;
    L75:
        AnnotationQualifierApplicabilityType r36 = r35;
        if (r110 == null) goto L78;
        TypeEnhancementInfo r37 = r110.getReturnTypeInfo();
    L79:
        KotlinType r38 = enhance$default(this, r21, r17, true, r10, r36, r37, false, SignatureEnhancement$enhanceSignature$returnTypeEnhancement$1.INSTANCE, 32, null);
        KotlinType r39 = r13.getReturnType();
        Intrinsics.checkNotNull(r39);
        if (containsFunctionN(r39) == true) goto L102;
        ReceiverParameterDescriptor r40 = r13.getExtensionReceiverParameter();
        if (r40 == null) goto L86;
        KotlinType r41 = r40.getType();
        if (r41 == null) goto L86;
        boolean r42 = containsFunctionN(r41);
    L87:
        if (r42 == true) goto L102;
        List<ValueParameterDescriptor> r43 = r13.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(r43, "valueParameters");
        if ((r43 instanceof Collection) == true) goto L91;
    L93:
        Iterator<T> r44 = r43.iterator();
    L95:
        if (r44.hasNext() == false) goto L92;
        KotlinType r45 = ((ValueParameterDescriptor) r44.next()).getType();
        Intrinsics.checkNotNullExpressionValue(r45, "it.type");
        if (containsFunctionN(r45) == false) goto L95;
        boolean r46 = true;
    L99:
        if (r46 == true) goto L102;
        boolean r47 = false;
    L103:
        if (r47 == false) goto L105;
        Pair<CallableDescriptor.UserDataKey<?>, ?> r114 = TuplesKt.to(DescriptorBasedDeprecationInfoKt.getDEPRECATED_FUNCTION_KEY(), new DeprecationCausedByFunctionNInfo(r21));
    L106:
        if (r18 != null) goto L123;
        if (r38 != null) goto L123;
        if (r113.isEmpty() == false) goto L111;
    L110:
        r14 = false;
    L119:
        if (r14 == true) goto L123;
        if (r114 != null) goto L123;
        return r21;
    L111:
        Iterator r48 = r113.iterator();
    L113:
        if (r48.hasNext() == false) goto L110;
        if (((KotlinType) r48.next()) == null) goto L117;
        boolean r49 = true;
    L118:
        if (r49 == false) goto L113;
    L117:
        r49 = false;
    L123:
        if (r18 != null) goto L128;
        ReceiverParameterDescriptor r50 = r13.getExtensionReceiverParameter();
        if (r50 == null) goto L127;
        KotlinType r51 = r50.getType();
    L129:
        ArrayList r52 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r113, 10));
        Iterator r53 = r113.iterator();
        int r115 = 0;
    L131:
        if (r53.hasNext() == false) goto L139;
        Object r54 = r53.next();
        int r55 = r115 + 1;
        if (r115 >= 0) goto L135;
        CollectionsKt.throwIndexOverflow();
    L135:
        KotlinType r56 = (KotlinType) r54;
        if (r56 != null) goto L138;
        r56 = r13.getValueParameters().get(r115).getType();
        Intrinsics.checkNotNullExpressionValue(r56, "valueParameters[index].type");
    L138:
        r52.add(r56);
        r115 = r55;
        goto L131
    L139:
        if (r38 != null) goto L141;
        r38 = r13.getReturnType();
        Intrinsics.checkNotNull(r38);
    L141:
        JavaCallableMemberDescriptor r57 = r13.enhance(r51, r52, r38, r114);
        Intrinsics.checkNotNull(r57, "null cannot be cast to non-null type D of org.jetbrains.kotlin.load.java.typeEnhancement.SignatureEnhancement.enhanceSignature");
        return r57;
    L127:
        r51 = null;
        goto L129
    L128:
        r51 = r18;
        goto L129
    L105:
        r114 = null;
    L92:
        r46 = false;
        goto L99
    L91:
        if (r43.isEmpty() == false) goto L93;
    L86:
        r42 = false;
    L102:
        r47 = true;
        goto L103
    L78:
        r37 = null;
        goto L79
    L74:
        r35 = AnnotationQualifierApplicabilityType.METHOD_RETURN_TYPE;
        goto L75
    L69:
        if (JavaDescriptorUtilKt.isJavaField(r33) != true) goto L71;
        r34 = true;
        goto L72
    L65:
        r32 = r21;
    L49:
        if (UtilsKt.hasErasedValueParameters(r21) == false) goto L51;
        r25 = true;
    L41:
        r110 = null;
        goto L42
    L36:
        r19 = null;
        goto L37
    L24:
        if ((r17 instanceof FunctionDescriptor) == true) goto L26;
        D r58 = null;
    L27:
        FunctionDescriptor r59 = (FunctionDescriptor) r58;
        if (r59 == null) goto L30;
        ValueParameterDescriptor r60 = (ValueParameterDescriptor) r59.getUserData(JavaMethodDescriptor.ORIGINAL_VALUE_PARAMETER_FOR_EXTENSION_RECEIVER);
    L31:
        r18 = enhanceValueParameter(r21, r60, r10, null, false, SignatureEnhancement$enhanceSignature$receiverTypeEnhancement$1.INSTANCE);
        goto L34
    L30:
        r60 = null;
        goto L31
    L26:
        r58 = r17;
        goto L27
    L15:
        if (r12.isDefault() == true) goto L17;
        r15 = true;
    L20:
        r17 = r21;
        goto L22
    L8:
        if (r13.getOriginal().getOverriddenDescriptors().size() != 1) goto L10;
        return r21;
    }

    private final KotlinType enhanceValueParameter(CallableMemberDescriptor r10, ValueParameterDescriptor r11, LazyJavaResolverContext r12, TypeEnhancementInfo r13, boolean r14, Function1<? super CallableMemberDescriptor, ? extends KotlinType> r15) {
        if (r11 == null) goto L7;
        LazyJavaResolverContext r16 = ContextKt.copyWithNewDefaultTypeQualifiers(r12, r11.getAnnotations());
        if (r16 == null) goto L7;
        LazyJavaResolverContext r17 = r16;
    L9:
        return enhance(r10, r11, false, r17, AnnotationQualifierApplicabilityType.VALUE_PARAMETER, r13, r14, r15);
    L7:
        r17 = r12;
        goto L9
    }

    private final <D extends CallableMemberDescriptor> Annotations getDefaultAnnotations(D r10, LazyJavaResolverContext r11) {
        ClassifierDescriptor r12 = DescriptorUtilKt.getTopLevelContainingClassifier(r10);
        if (r12 == null) goto L5;
        List<JavaAnnotation> r13 = null;
        if ((r12 instanceof LazyJavaClassDescriptor) == false) goto L9;
        LazyJavaClassDescriptor r14 = (LazyJavaClassDescriptor) r12;
    L10:
        if (r14 == null) goto L13;
        r13 = r14.getModuleAnnotations();
    L13:
        if (r13 != null) goto L15;
    L18:
        boolean r15 = true;
    L19:
        if (r15 == true) goto L21;
        ArrayList r16 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10));
        Iterator<T> r17 = r13.iterator();
    L24:
        if (r17.hasNext() == false) goto L27;
        r16.add(new LazyJavaAnnotationDescriptor(r11, (JavaAnnotation) r17.next(), true));
        goto L24
    L27:
        return Annotations.Companion.create(CollectionsKt.plus(r10.getAnnotations(), r16));
    L21:
        return r10.getAnnotations();
    L15:
        if (r13.isEmpty() == true) goto L18;
        r15 = false;
        goto L19
    L9:
        r14 = null;
        goto L10
    L5:
        return r10.getAnnotations();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <D extends CallableMemberDescriptor> Collection<D> enhanceSignatures(LazyJavaResolverContext r10, Collection<? extends D> r11) {
        Intrinsics.checkNotNullParameter(r10, "c");
        Intrinsics.checkNotNullParameter(r11, "platformSignatures");
        ArrayList r12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10));
        Iterator<T> r13 = r11.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        r12.add(enhanceSignature((CallableMemberDescriptor) r13.next(), r10));
        goto L4
    L6:
        return r12;
    }

    public final KotlinType enhanceSuperType(KotlinType r10, LazyJavaResolverContext r11) {
        Intrinsics.checkNotNullParameter(r10, WsConstants.KEY_CONNECTION_TYPE);
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
        ArrayList r10 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10));
        Iterator<T> r16 = r14.iterator();
    L4:
        if (r16.hasNext() == false) goto L13;
        KotlinType r11 = (KotlinType) r16.next();
        if (TypeUtilsKt.contains(r11, SignatureEnhancement$enhanceTypeParameterBounds$1$1.INSTANCE) == true) goto L12;
        KotlinType r12 = enhance$default(this, new SignatureParts(r13, false, r15, AnnotationQualifierApplicabilityType.TYPE_PARAMETER_BOUNDS, false, 16, null), r11, CollectionsKt.emptyList(), null, false, 12, null);
        if (r12 == null) goto L12;
        r11 = r12;
    L12:
        r10.add(r11);
        goto L4
    L13:
        return r10;
    }
}
