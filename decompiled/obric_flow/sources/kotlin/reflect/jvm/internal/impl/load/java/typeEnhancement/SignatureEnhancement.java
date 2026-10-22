package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
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
@SourceDebugExtension({"SMAP\nsignatureEnhancement.kt\nKotlin\n*S Kotlin\n*F\n+ 1 signatureEnhancement.kt\norg/jetbrains/kotlin/load/java/typeEnhancement/SignatureEnhancement\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,282:1\n1549#2:283\n1620#2,3:284\n1549#2:287\n1620#2,3:288\n1549#2:292\n1620#2,3:293\n1747#2,3:296\n1747#2,3:299\n1559#2:302\n1590#2,4:303\n1549#2:307\n1620#2,3:308\n1549#2:311\n1620#2,3:312\n1#3:291\n*S KotlinDebug\n*F\n+ 1 signatureEnhancement.kt\norg/jetbrains/kotlin/load/java/typeEnhancement/SignatureEnhancement\n*L\n55#1:283\n55#1:284,3\n66#1:287\n66#1:288,3\n117#1:292\n117#1:293,3\n138#1:296,3\n144#1:299,3\n150#1:302\n150#1:303,4\n164#1:307\n164#1:308,3\n214#1:311\n214#1:312,3\n*E\n"})
public final class SignatureEnhancement {
    private final JavaTypeEnhancement typeEnhancement;

    public SignatureEnhancement(JavaTypeEnhancement r5) {
        Intrinsics.checkNotNullParameter(r5, "typeEnhancement");
        this.typeEnhancement = r5;
    }

    private final boolean containsFunctionN(KotlinType r5) {
        return TypeUtils.contains(r5, AnonymousClass1.INSTANCE);
    }

    private final KotlinType enhance(CallableMemberDescriptor r11, Annotated r12, boolean r13, LazyJavaResolverContext r14, AnnotationQualifierApplicabilityType r15, TypeEnhancementInfo r16, boolean r17, Function1<? super CallableMemberDescriptor, ? extends KotlinType> r18) {
        boolean r10 = false;
        int r19 = 16;
        SignatureParts r20 = new SignatureParts(r12, r13, r14, r15, r10, r19, null);
        KotlinType r5 = r18.invoke(r11);
        Collection<? extends CallableMemberDescriptor> r21 = r11.getOverriddenDescriptors();
        ArrayList r22 = new ArrayList(CollectionsKt.h(r21));
        Iterator<T> r23 = r21.iterator();
    L4:
        if (r23.hasNext() == false) goto L7;
        r22.add(r18.invoke((CallableMemberDescriptor) r23.next()));
        goto L4
    L7:
        return enhance(r20, r5, r22, r16, r17);
    }

    public static /* synthetic */ KotlinType enhance$default(SignatureEnhancement r10, CallableMemberDescriptor r11, Annotated r12, boolean r13, LazyJavaResolverContext r14, AnnotationQualifierApplicabilityType r15, TypeEnhancementInfo r16, boolean r17, Function1 r18, int r19, Object r20) {
        if ((r19 & 32) == 0) goto L5;
        boolean r21 = false;
    L7:
        return r10.enhance(r11, r12, r13, r14, r15, r16, r21, r18);
    L5:
        r21 = r17;
        goto L7
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
        if ((r21 instanceof JavaPropertyDescriptor) == false) goto L17;
        JavaPropertyDescriptor r5 = (JavaPropertyDescriptor) r21;
        PropertyGetterDescriptorImpl r11 = r5.getGetter();
        if (r11 == null) goto L17;
        if (r11.isDefault() == true) goto L17;
        PropertyGetterDescriptorImpl r12 = r5.getGetter();
        Intrinsics.checkNotNull(r12);
        D r15 = r12;
    L18:
        TypeEnhancementInfo r16 = null;
        if (r13.getExtensionReceiverParameter() != null) goto L21;
        KotlinType r17 = null;
    L30:
        if ((r21 instanceof JavaMethodDescriptor) == false) goto L32;
        JavaMethodDescriptor r18 = (JavaMethodDescriptor) r21;
    L34:
        if (r18 == null) goto L38;
        SignatureBuildingComponents r19 = SignatureBuildingComponents.INSTANCE;
        DeclarationDescriptor r20 = r18.getContainingDeclaration();
        Intrinsics.checkNotNull(r20, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        String r23 = MethodSignatureBuildingUtilsKt.signature(r19, (ClassDescriptor) r20, MethodSignatureMappingKt.computeJvmDescriptor$default(r18, false, false, 3, null));
        if (r23 == null) goto L38;
        PredefinedFunctionEnhancementInfo r110 = PredefinedEnhancementInfoKt.getPREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE().get(r23);
    L39:
        if (r110 == null) goto L42;
        r110.getParametersInfo().size();
        r13.getValueParameters().size();
    L42:
        if (UtilsKt.isJspecifyEnabledInStrictMode(r22.getComponents().getJavaTypeEnhancementState()) == true) goto L46;
        if (r10.getComponents().getSettings().getIgnoreNullabilityForErasedValueParameters() == true) goto L46;
    L48:
        boolean r24 = false;
    L49:
        List<ValueParameterDescriptor> r25 = r15.getValueParameters();
        ArrayList r26 = new ArrayList(CollectionsKt.h(r25));
        Iterator<T> r111 = r25.iterator();
    L51:
        if (r111.hasNext() == false) goto L59;
        final ValueParameterDescriptor r27 = (ValueParameterDescriptor) r111.next();
        if (r110 == null) goto L57;
        List<TypeEnhancementInfo> r28 = r110.getParametersInfo();
        if (r28 == null) goto L57;
        TypeEnhancementInfo r29 = (TypeEnhancementInfo) CollectionsKt.getOrNull(r28, r27.getIndex());
    L58:
        ArrayList r112 = r26;
        r112.add(enhanceValueParameter(r21, r27, r10, r29, r24, new SignatureEnhancement$enhanceSignature$valueParameterEnhancements$1$1(r27)));
        r26 = r112;
        r16 = null;
    L57:
        r29 = r16;
        goto L58
    L59:
        ArrayList r113 = r26;
        if ((r21 instanceof PropertyDescriptor) == false) goto L62;
        PropertyDescriptor r30 = (PropertyDescriptor) r21;
    L63:
        if (r30 != null) goto L65;
    L68:
        AnnotationQualifierApplicabilityType r31 = AnnotationQualifierApplicabilityType.METHOD_RETURN_TYPE;
    L67:
        AnnotationQualifierApplicabilityType r32 = r31;
        if (r110 == null) goto L71;
        TypeEnhancementInfo r33 = r110.getReturnTypeInfo();
    L72:
        KotlinType r34 = enhance$default(this, r21, r15, true, r10, r32, r33, false, SignatureEnhancement$enhanceSignature$returnTypeEnhancement$1.INSTANCE, 32, null);
        KotlinType r35 = r13.getReturnType();
        Intrinsics.checkNotNull(r35);
        if (containsFunctionN(r35) == true) goto L95;
        ReceiverParameterDescriptor r36 = r13.getExtensionReceiverParameter();
        if (r36 == null) goto L79;
        KotlinType r37 = r36.getType();
        if (r37 == null) goto L79;
        boolean r114 = containsFunctionN(r37);
    L80:
        if (r114 == true) goto L95;
        List<ValueParameterDescriptor> r38 = r13.getValueParameters();
        if (r38 != null) goto L84;
    L86:
        Iterator<T> r39 = r38.iterator();
    L88:
        if (r39.hasNext() == false) goto L85;
        if (containsFunctionN(((ValueParameterDescriptor) r39.next()).getType()) == false) goto L88;
        boolean r115 = true;
    L92:
        if (r115 == true) goto L95;
        boolean r116 = false;
    L96:
        if (r116 == false) goto L98;
        Pair<CallableDescriptor.UserDataKey<?>, ?> r40 = TuplesKt.to(DescriptorBasedDeprecationInfoKt.getDEPRECATED_FUNCTION_KEY(), new DeprecationCausedByFunctionNInfo(r21));
    L99:
        if (r17 != null) goto L116;
        if (r34 != null) goto L116;
        if (r113.isEmpty() == false) goto L104;
    L103:
        r14 = false;
    L112:
        if (r14 == true) goto L116;
        if (r40 != null) goto L116;
        return r21;
    L104:
        Iterator r41 = r113.iterator();
    L106:
        if (r41.hasNext() == false) goto L103;
        if (((KotlinType) r41.next()) == null) goto L110;
        boolean r117 = true;
    L111:
        if (r117 == false) goto L106;
    L110:
        r117 = false;
    L116:
        if (r17 != null) goto L121;
        ReceiverParameterDescriptor r42 = r13.getExtensionReceiverParameter();
        if (r42 == null) goto L120;
        KotlinType r43 = r42.getType();
    L122:
        ArrayList r44 = new ArrayList(CollectionsKt.h(r113));
        Iterator r45 = r113.iterator();
        int r118 = 0;
    L124:
        if (r45.hasNext() == false) goto L132;
        Object r46 = r45.next();
        int r47 = r118 + 1;
        if (r118 >= 0) goto L128;
        CollectionsKt.throwIndexOverflow();
    L128:
        KotlinType r48 = (KotlinType) r46;
        if (r48 != null) goto L131;
        r48 = r13.getValueParameters().get(r118).getType();
    L131:
        r44.add(r48);
        r118 = r47;
        goto L124
    L132:
        if (r34 != null) goto L134;
        r34 = r13.getReturnType();
        Intrinsics.checkNotNull(r34);
    L134:
        JavaCallableMemberDescriptor r49 = r13.enhance(r43, r44, r34, r40);
        Intrinsics.checkNotNull(r49, "null cannot be cast to non-null type D of org.jetbrains.kotlin.load.java.typeEnhancement.SignatureEnhancement.enhanceSignature");
        return r49;
    L120:
        r43 = null;
        goto L122
    L121:
        r43 = r17;
        goto L122
    L98:
        r40 = null;
    L85:
        r115 = false;
        goto L92
    L84:
        if (r38.isEmpty() == false) goto L86;
    L79:
        r114 = false;
    L95:
        r116 = true;
        goto L96
    L71:
        r33 = null;
        goto L72
    L65:
        if (JavaDescriptorUtilKt.isJavaField(r30) != true) goto L68;
        r31 = AnnotationQualifierApplicabilityType.FIELD;
        goto L67
    L62:
        r30 = null;
    L46:
        if (UtilsKt.hasErasedValueParameters(r21) == false) goto L48;
        r24 = true;
    L38:
        r110 = null;
        goto L39
    L32:
        r18 = null;
        goto L34
    L21:
        if ((r15 instanceof FunctionDescriptor) == false) goto L23;
        FunctionDescriptor r50 = (FunctionDescriptor) r15;
    L24:
        if (r50 == null) goto L26;
        ValueParameterDescriptor r51 = (ValueParameterDescriptor) r50.getUserData(JavaMethodDescriptor.ORIGINAL_VALUE_PARAMETER_FOR_EXTENSION_RECEIVER);
    L27:
        r17 = enhanceValueParameter(r21, r51, r10, null, false, SignatureEnhancement$enhanceSignature$receiverTypeEnhancement$1.INSTANCE);
        goto L30
    L26:
        r51 = null;
        goto L27
    L23:
        r50 = null;
    L17:
        r15 = r21;
        goto L18
    L8:
        if (r13.getOriginal().getOverriddenDescriptors().size() != 1) goto L10;
        return r21;
    }

    private final KotlinType enhanceValueParameter(CallableMemberDescriptor r10, ValueParameterDescriptor r11, LazyJavaResolverContext r12, TypeEnhancementInfo r13, boolean r14, Function1<? super CallableMemberDescriptor, ? extends KotlinType> r15) {
        if (r11 == null) goto L7;
        LazyJavaResolverContext r5 = ContextKt.copyWithNewDefaultTypeQualifiers(r12, r11.getAnnotations());
        if (r5 == null) goto L7;
        LazyJavaResolverContext r16 = r5;
    L9:
        return enhance(r10, r11, false, r16, AnnotationQualifierApplicabilityType.VALUE_PARAMETER, r13, r14, r15);
    L7:
        r16 = r12;
        goto L9
    }

    private final <D extends CallableMemberDescriptor> Annotations getDefaultAnnotations(D r5, LazyJavaResolverContext r10) {
        ClassifierDescriptor r11 = DescriptorUtilKt.getTopLevelContainingClassifier(r5);
        if (r11 == null) goto L5;
        List<JavaAnnotation> r12 = null;
        if ((r11 instanceof LazyJavaClassDescriptor) == false) goto L9;
        LazyJavaClassDescriptor r13 = (LazyJavaClassDescriptor) r11;
    L10:
        if (r13 == null) goto L12;
        r12 = r13.getModuleAnnotations();
    L12:
        if (r12 == null) goto L23;
        if (r12.isEmpty() == true) goto L23;
        ArrayList r14 = new ArrayList(CollectionsKt.h(r12));
        Iterator<T> r15 = r12.iterator();
    L18:
        if (r15.hasNext() == false) goto L21;
        r14.add(new LazyJavaAnnotationDescriptor(r10, (JavaAnnotation) r15.next(), true));
        goto L18
    L21:
        return Annotations.Companion.create(CollectionsKt.plus(r5.getAnnotations(), r14));
    L23:
        return r5.getAnnotations();
    L9:
        r13 = null;
        goto L10
    L5:
        return r5.getAnnotations();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <D extends CallableMemberDescriptor> Collection<D> enhanceSignatures(LazyJavaResolverContext r5, Collection<? extends D> r10) {
        Intrinsics.checkNotNullParameter(r5, "c");
        Intrinsics.checkNotNullParameter(r10, "platformSignatures");
        Collection<? extends D> r11 = r10;
        ArrayList r12 = new ArrayList(CollectionsKt.h(r11));
        Iterator<T> r13 = r11.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        r12.add(enhanceSignature((CallableMemberDescriptor) r13.next(), r5));
        goto L4
    L6:
        return r12;
    }

    public final KotlinType enhanceSuperType(KotlinType r10, LazyJavaResolverContext r11) {
        Intrinsics.checkNotNullParameter(r10, "type");
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
        ArrayList r5 = new ArrayList(CollectionsKt.h(r14));
        Iterator<T> r16 = r14.iterator();
    L4:
        if (r16.hasNext() == false) goto L13;
        KotlinType r10 = (KotlinType) r16.next();
        if (TypeUtilsKt.contains(r10, SignatureEnhancement$enhanceTypeParameterBounds$1$1.INSTANCE) == true) goto L12;
        boolean r11 = false;
        KotlinType r12 = enhance$default(this, new SignatureParts(r13, r11, r15, AnnotationQualifierApplicabilityType.TYPE_PARAMETER_BOUNDS, false, 16, null), r10, CollectionsKt.emptyList(), null, false, 12, null);
        if (r12 == null) goto L12;
        r10 = r12;
    L12:
        r5.add(r10);
        goto L4
    L13:
        return r5;
    }

    public static /* synthetic */ KotlinType enhance$default(SignatureEnhancement r10, SignatureParts r11, KotlinType r12, List r13, TypeEnhancementInfo r14, boolean r15, int r16, Object r17) {
        if ((r16 & 4) == 0) goto L5;
        r14 = null;
    L5:
        TypeEnhancementInfo r5 = r14;
        if ((r16 & 8) == 0) goto L9;
        r15 = false;
    L9:
        return r10.enhance(r11, r12, r13, r5, r15);
    }

    private final KotlinType enhance(SignatureParts r5, KotlinType r10, List<? extends KotlinType> r11, TypeEnhancementInfo r12, boolean r13) {
        return this.typeEnhancement.enhance(r10, r5.computeIndexedQualifiers(r10, r11, r12, r13), r5.getSkipRawTypeArguments());
    }
}
