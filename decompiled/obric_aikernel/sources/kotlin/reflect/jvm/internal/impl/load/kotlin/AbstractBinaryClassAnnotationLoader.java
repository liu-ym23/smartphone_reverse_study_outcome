package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.SpecialJvmAnnotations;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationLoader.AnnotationsContainer;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoBufUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.ClassMapperLite;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractBinaryClassAnnotationLoader<A, S extends AnnotationsContainer<? extends A>> implements AnnotationLoader<A> {
    private final KotlinClassFinder kotlinClassFinder;

    public static abstract class AnnotationsContainer<A> {
        public AnnotationsContainer() {
        }

        public abstract Map<MemberSignature, List<A>> getMemberAnnotations();
    }

    private static final enum PropertyRelatedElement extends Enum<PropertyRelatedElement> {
        private static final /* synthetic */ PropertyRelatedElement[] $VALUES = null;
        public static final PropertyRelatedElement BACKING_FIELD = null;
        public static final PropertyRelatedElement DELEGATE_FIELD = null;
        public static final PropertyRelatedElement PROPERTY = null;

        private static final /* synthetic */ PropertyRelatedElement[] $values() {
            return new PropertyRelatedElement[]{PROPERTY, BACKING_FIELD, DELEGATE_FIELD};
        }

        static {
            PROPERTY = new PropertyRelatedElement("PROPERTY", 0);
            BACKING_FIELD = new PropertyRelatedElement("BACKING_FIELD", 1);
            DELEGATE_FIELD = new PropertyRelatedElement("DELEGATE_FIELD", 2);
            $VALUES = $values();
        }

        private PropertyRelatedElement(String r10, int r11) {
            super(r10, r11);
        }

        public static PropertyRelatedElement valueOf(String r10) {
            return (PropertyRelatedElement) Enum.valueOf(PropertyRelatedElement.class, r10);
        }

        public static PropertyRelatedElement[] values() {
            return (PropertyRelatedElement[]) $VALUES.clone();
        }
    }

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r10 = new int[AnnotatedCallableKind.values().length];
            r10[AnnotatedCallableKind.PROPERTY_GETTER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r10[AnnotatedCallableKind.PROPERTY_SETTER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r10[AnnotatedCallableKind.PROPERTY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r10;
        }
    }

    public AbstractBinaryClassAnnotationLoader(KotlinClassFinder r10) {
        Intrinsics.checkNotNullParameter(r10, "kotlinClassFinder");
        this.kotlinClassFinder = r10;
    }

    private final int computeJvmParameterIndexShift(ProtoContainer r10, MessageLite r11) {
        if ((r11 instanceof ProtoBuf.Function) == false) goto L9;
        if (ProtoTypeTableUtilKt.hasReceiver((ProtoBuf.Function) r11) == false) goto L20;
        return 1;
    L20:
        return 0;
    L9:
        if ((r11 instanceof ProtoBuf.Property) == false) goto L14;
        if (ProtoTypeTableUtilKt.hasReceiver((ProtoBuf.Property) r11) == false) goto L20;
        return 1;
    L14:
        if ((r11 instanceof ProtoBuf.Constructor) == false) goto L22;
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type org.jetbrains.kotlin.serialization.deserialization.ProtoContainer.Class");
        ProtoContainer.Class r12 = (ProtoContainer.Class) r10;
        if (r12.getKind() != ProtoBuf.Class.Kind.ENUM_CLASS) goto L19;
        return 2;
    L19:
        if (r12.isInner() == false) goto L20;
        return 1;
    L22:
        throw new UnsupportedOperationException("Unsupported message: " + r11.getClass());
    }

    private final List<A> findClassAndLoadMemberAnnotations(ProtoContainer r10, MemberSignature r11, boolean r12, boolean r13, Boolean r14, boolean r15) {
        KotlinJvmBinaryClass r16 = findClassWithAnnotationsAndInitializers(r10, getSpecialCaseContainerClass(r10, r12, r13, r14, r15));
        if (r16 == null) goto L5;
        List<A> r17 = getAnnotationsContainer(r16).getMemberAnnotations().get(r11);
        if (r17 == null) goto L9;
        return r17;
    L9:
        return CollectionsKt.emptyList();
    L5:
        return CollectionsKt.emptyList();
    }

    static /* synthetic */ List findClassAndLoadMemberAnnotations$default(AbstractBinaryClassAnnotationLoader r10, ProtoContainer r11, MemberSignature r12, boolean r13, boolean r14, Boolean r15, boolean r16, int r17, Object r18) {
        if (r18 != null) goto L22;
        if ((r17 & 4) == 0) goto L6;
        boolean r19 = false;
    L8:
        if ((r17 & 8) == 0) goto L10;
        boolean r20 = false;
    L12:
        if ((r17 & 16) == 0) goto L14;
        Boolean r21 = null;
    L16:
        if ((r17 & 32) == 0) goto L18;
        boolean r22 = false;
    L20:
        return r10.findClassAndLoadMemberAnnotations(r11, r12, r19, r20, r21, r22);
    L18:
        r22 = r16;
        goto L20
    L14:
        r21 = r15;
        goto L16
    L10:
        r20 = r14;
        goto L12
    L6:
        r19 = r13;
        goto L8
    L22:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: findClassAndLoadMemberAnnotations");
    }

    public static /* synthetic */ MemberSignature getCallableSignature$default(AbstractBinaryClassAnnotationLoader r10, MessageLite r11, NameResolver r12, TypeTable r13, AnnotatedCallableKind r14, boolean r15, int r16, Object r17) {
        if (r17 != null) goto L9;
        if ((r16 & 16) == 0) goto L7;
        r15 = false;
    L7:
        return r10.getCallableSignature(r11, r12, r13, r14, r15);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getCallableSignature");
    }

    private final List<A> loadPropertyAnnotations(ProtoContainer r18, ProtoBuf.Property r19, PropertyRelatedElement r20) {
        Boolean r10 = Flags.IS_CONST.get(r19.getFlags());
        Intrinsics.checkNotNullExpressionValue(r10, "IS_CONST.get(proto.flags)");
        boolean r11 = r10.booleanValue();
        boolean r12 = JvmProtoBufUtil.isMovedFromInterfaceCompanion(r19);
        PropertyRelatedElement r13 = PropertyRelatedElement.PROPERTY;
        NameResolver r14 = r18.getNameResolver();
        TypeTable r15 = r18.getTypeTable();
        if (r20 != r13) goto L10;
        MemberSignature r16 = AbstractBinaryClassAnnotationLoaderKt.getPropertySignature$default(r19, r14, r15, false, true, false, 40, null);
        if (r16 != null) goto L9;
        return CollectionsKt.emptyList();
    L9:
        return findClassAndLoadMemberAnnotations$default(this, r18, r16, true, false, Boolean.valueOf(r11), r12, 8, null);
    L10:
        MemberSignature r17 = AbstractBinaryClassAnnotationLoaderKt.getPropertySignature$default(r19, r14, r15, true, false, false, 48, null);
        if (r17 == null) goto L13;
        boolean r21 = false;
        boolean r22 = StringsKt.contains$default(r17.getSignature(), "$delegate", false, 2, null);
        if (r20 != PropertyRelatedElement.DELEGATE_FIELD) goto L17;
        r21 = true;
    L17:
        if (r22 == r21) goto L21;
        return CollectionsKt.emptyList();
    L21:
        return findClassAndLoadMemberAnnotations(r18, r17, true, true, Boolean.valueOf(r11), r12);
    L13:
        return CollectionsKt.emptyList();
    }

    private final KotlinJvmBinaryClass toBinaryClass(ProtoContainer.Class r10) {
        SourceElement r11 = r10.getSource();
        if ((r11 instanceof KotlinJvmBinarySourceElement) == false) goto L5;
        KotlinJvmBinarySourceElement r12 = (KotlinJvmBinarySourceElement) r11;
    L6:
        if (r12 != null) goto L8;
        return null;
    L8:
        return r12.getBinaryClass();
    L5:
        r12 = null;
        goto L6
    }

    protected final KotlinJvmBinaryClass findClassWithAnnotationsAndInitializers(ProtoContainer r10, KotlinJvmBinaryClass r11) {
        Intrinsics.checkNotNullParameter(r10, "container");
        if (r11 == null) goto L5;
        return r11;
    L5:
        if ((r10 instanceof ProtoContainer.Class) == true) goto L10;
        return null;
    L10:
        return toBinaryClass((ProtoContainer.Class) r10);
    }

    protected abstract S getAnnotationsContainer(KotlinJvmBinaryClass r10);

    protected byte[] getCachedFileContent(KotlinJvmBinaryClass r10) {
        Intrinsics.checkNotNullParameter(r10, "kotlinClass");
        return null;
    }

    protected final MemberSignature getCallableSignature(MessageLite r10, NameResolver r11, TypeTable r12, AnnotatedCallableKind r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r10, "proto");
        Intrinsics.checkNotNullParameter(r11, "nameResolver");
        Intrinsics.checkNotNullParameter(r12, "typeTable");
        Intrinsics.checkNotNullParameter(r13, "kind");
        if ((r10 instanceof ProtoBuf.Constructor) == false) goto L9;
        MemberSignature.Companion r15 = MemberSignature.Companion;
        JvmMemberSignature.Method r16 = JvmProtoBufUtil.INSTANCE.getJvmConstructorSignature((ProtoBuf.Constructor) r10, r11, r12);
        if (r16 != null) goto L34;
        return null;
    L34:
        return r15.fromJvmMemberSignature(r16);
    L9:
        if ((r10 instanceof ProtoBuf.Function) == false) goto L14;
        r15 = MemberSignature.Companion;
        r16 = JvmProtoBufUtil.INSTANCE.getJvmMethodSignature((ProtoBuf.Function) r10, r11, r12);
        if (r16 != null) goto L34;
        return null;
    L14:
        if ((r10 instanceof ProtoBuf.Property) == false) goto L35;
        GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, JvmProtoBuf.JvmPropertySignature> r17 = JvmProtoBuf.propertySignature;
        Intrinsics.checkNotNullExpressionValue(r17, "propertySignature");
        JvmProtoBuf.JvmPropertySignature r18 = (JvmProtoBuf.JvmPropertySignature) ProtoBufUtilKt.getExtensionOrNull((GeneratedMessageLite.ExtendableMessage) r10, r17);
        if (r18 != null) goto L18;
        return null;
    L18:
        int r19 = WhenMappings.$EnumSwitchMapping$0[r13.ordinal()];
        if (r19 == 1) goto L30;
        if (r19 == 2) goto L27;
        if (r19 == 3) goto L36;
        return null;
    L36:
        return AbstractBinaryClassAnnotationLoaderKt.getPropertySignature((ProtoBuf.Property) r10, r11, r12, true, true, r14);
    L27:
        if (r18.hasSetter() == false) goto L37;
        MemberSignature.Companion r20 = MemberSignature.Companion;
        JvmProtoBuf.JvmMethodSignature r21 = r18.getSetter();
        String r110 = "signature.setter";
    L32:
        Intrinsics.checkNotNullExpressionValue(r21, r110);
        return r20.fromMethod(r11, r21);
    L37:
        return null;
    L30:
        if (r18.hasGetter() == false) goto L38;
        r20 = MemberSignature.Companion;
        r21 = r18.getGetter();
        r110 = "signature.getter";
        goto L32
    L38:
        return null;
    L35:
        return null;
    }

    protected final KotlinJvmBinaryClass getSpecialCaseContainerClass(ProtoContainer r10, boolean r11, boolean r12, Boolean r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r10, "container");
        if (r11 == false) goto L27;
        if (r13 == null) goto L26;
        if ((r10 instanceof ProtoContainer.Class) == false) goto L13;
        ProtoContainer.Class r15 = (ProtoContainer.Class) r10;
        if (r15.getKind() != ProtoBuf.Class.Kind.INTERFACE) goto L13;
        KotlinClassFinder r16 = this.kotlinClassFinder;
        ClassId r17 = r15.getClassId().createNestedClassId(Name.identifier("DefaultImpls"));
        String r18 = "container.classId.create…EFAULT_IMPLS_CLASS_NAME))";
    L10:
        Intrinsics.checkNotNullExpressionValue(r17, r18);
        return KotlinClassFinderKt.findKotlinClass(r16, r17);
    L13:
        if (r13.booleanValue() == false) goto L27;
        if ((r10 instanceof ProtoContainer.Package) == false) goto L27;
        SourceElement r19 = r10.getSource();
        if ((r19 instanceof JvmPackagePartSource) == false) goto L19;
        JvmPackagePartSource r20 = (JvmPackagePartSource) r19;
    L20:
        if (r20 == null) goto L22;
        JvmClassName r21 = r20.getFacadeClassName();
    L23:
        if (r21 == null) goto L27;
        r16 = this.kotlinClassFinder;
        String r22 = r21.getInternalName();
        Intrinsics.checkNotNullExpressionValue(r22, "facadeClassName.internalName");
        r17 = ClassId.topLevel(new FqName(StringsKt.replace$default(r22, '/', '.', false, 4, null)));
        r18 = "topLevel(FqName(facadeCl…lName.replace('/', '.')))";
        goto L10
    L22:
        r21 = null;
        goto L23
    L19:
        r20 = null;
        goto L20
    L26:
        throw new IllegalStateException(("isConst should not be null for property (container=" + r10 + ')').toString());
    L27:
        if (r12 == false) goto L46;
        if ((r10 instanceof ProtoContainer.Class) == false) goto L46;
        ProtoContainer.Class r23 = (ProtoContainer.Class) r10;
        if (r23.getKind() != ProtoBuf.Class.Kind.COMPANION_OBJECT) goto L46;
        ProtoContainer.Class r24 = r23.getOuterClass();
        if (r24 == null) goto L46;
        if (r24.getKind() == ProtoBuf.Class.Kind.CLASS) goto L44;
        if (r24.getKind() == ProtoBuf.Class.Kind.ENUM_CLASS) goto L44;
        if (r14 == false) goto L46;
        if (r24.getKind() == ProtoBuf.Class.Kind.INTERFACE) goto L44;
        if (r24.getKind() != ProtoBuf.Class.Kind.ANNOTATION_CLASS) goto L46;
    L44:
        return toBinaryClass(r24);
    L46:
        if ((r10 instanceof ProtoContainer.Package) == true) goto L48;
    L53:
        return null;
    L48:
        if ((r10.getSource() instanceof JvmPackagePartSource) == false) goto L53;
        SourceElement r25 = r10.getSource();
        Intrinsics.checkNotNull(r25, "null cannot be cast to non-null type org.jetbrains.kotlin.load.kotlin.JvmPackagePartSource");
        JvmPackagePartSource r26 = (JvmPackagePartSource) r25;
        KotlinJvmBinaryClass r27 = r26.getKnownJvmBinaryClass();
        if (r27 == null) goto L52;
        return r27;
    L52:
        return KotlinClassFinderKt.findKotlinClass(this.kotlinClassFinder, r26.getClassId());
    }

    protected final boolean isImplicitRepeatableContainer(ClassId r10) {
        Intrinsics.checkNotNullParameter(r10, "classId");
        if (r10.getOuterClassId() != null) goto L5;
        return false;
    L5:
        if (Intrinsics.areEqual(r10.getShortClassName().asString(), "Container") == false) goto L16;
        KotlinJvmBinaryClass r11 = KotlinClassFinderKt.findKotlinClass(this.kotlinClassFinder, r10);
        if (r11 != null) goto L10;
        return false;
    L10:
        if (SpecialJvmAnnotations.INSTANCE.isAnnotatedWithContainerMetaAnnotation(r11) == false) goto L15;
        return true;
    L15:
        return false;
    L16:
        return false;
    }

    protected abstract KotlinJvmBinaryClass.AnnotationArgumentVisitor loadAnnotation(ClassId r10, SourceElement r11, List<A> r12);

    protected final KotlinJvmBinaryClass.AnnotationArgumentVisitor loadAnnotationIfNotSpecial(ClassId r10, SourceElement r11, List<A> r12) {
        Intrinsics.checkNotNullParameter(r10, "annotationClassId");
        Intrinsics.checkNotNullParameter(r11, "source");
        Intrinsics.checkNotNullParameter(r12, "result");
        if (SpecialJvmAnnotations.INSTANCE.getSPECIAL_ANNOTATIONS().contains(r10) == false) goto L7;
        return null;
    L7:
        return loadAnnotation(r10, r11, r12);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<A> loadCallableAnnotations(ProtoContainer r11, MessageLite r12, AnnotatedCallableKind r13) {
        Intrinsics.checkNotNullParameter(r11, "container");
        Intrinsics.checkNotNullParameter(r12, "proto");
        Intrinsics.checkNotNullParameter(r13, "kind");
        if (r13 == AnnotatedCallableKind.PROPERTY) goto L5;
        MemberSignature r10 = getCallableSignature$default(this, r12, r11.getNameResolver(), r11.getTypeTable(), r13, false, 16, null);
        if (r10 != null) goto L11;
        return CollectionsKt.emptyList();
    L11:
        return findClassAndLoadMemberAnnotations$default(this, r11, r10, false, false, null, false, 60, null);
    L5:
        return loadPropertyAnnotations(r11, (ProtoBuf.Property) r12, PropertyRelatedElement.PROPERTY);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<A> loadClassAnnotations(ProtoContainer.Class r10) {
        Intrinsics.checkNotNullParameter(r10, "container");
        KotlinJvmBinaryClass r11 = toBinaryClass(r10);
        if (r11 == null) goto L7;
        final ArrayList r12 = new ArrayList(1);
        r11.loadClassAnnotations(new AnonymousClass1(this, r12), getCachedFileContent(r11));
        return r12;
    L7:
        throw new IllegalStateException(("Class for loading annotations is not found: " + r10.debugFqName()).toString());
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<A> loadEnumEntryAnnotations(ProtoContainer r12, ProtoBuf.EnumEntry r13) {
        Intrinsics.checkNotNullParameter(r12, "container");
        Intrinsics.checkNotNullParameter(r13, "proto");
        MemberSignature.Companion r10 = MemberSignature.Companion;
        String r14 = r12.getNameResolver().getString(r13.getName());
        String r11 = ((ProtoContainer.Class) r12).getClassId().asString();
        Intrinsics.checkNotNullExpressionValue(r11, "container as ProtoContai…Class).classId.asString()");
        return findClassAndLoadMemberAnnotations$default(this, r12, r10.fromFieldNameAndDesc(r14, ClassMapperLite.mapClass(r11)), false, false, null, false, 60, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<A> loadExtensionReceiverParameterAnnotations(ProtoContainer r11, MessageLite r12, AnnotatedCallableKind r13) {
        Intrinsics.checkNotNullParameter(r11, "container");
        Intrinsics.checkNotNullParameter(r12, "proto");
        Intrinsics.checkNotNullParameter(r13, "kind");
        MemberSignature r14 = getCallableSignature$default(this, r12, r11.getNameResolver(), r11.getTypeTable(), r13, false, 16, null);
        if (r14 == null) goto L7;
        return findClassAndLoadMemberAnnotations$default(this, r11, MemberSignature.Companion.fromMethodSignatureAndParameterIndex(r14, 0), false, false, null, false, 60, null);
    L7:
        return CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<A> loadPropertyBackingFieldAnnotations(ProtoContainer r10, ProtoBuf.Property r11) {
        Intrinsics.checkNotNullParameter(r10, "container");
        Intrinsics.checkNotNullParameter(r11, "proto");
        return loadPropertyAnnotations(r10, r11, PropertyRelatedElement.BACKING_FIELD);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<A> loadPropertyDelegateFieldAnnotations(ProtoContainer r10, ProtoBuf.Property r11) {
        Intrinsics.checkNotNullParameter(r10, "container");
        Intrinsics.checkNotNullParameter(r11, "proto");
        return loadPropertyAnnotations(r10, r11, PropertyRelatedElement.DELEGATE_FIELD);
    }

    protected abstract A loadTypeAnnotation(ProtoBuf.Annotation r10, NameResolver r11);

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<A> loadTypeAnnotations(ProtoBuf.Type r10, NameResolver r11) {
        Intrinsics.checkNotNullParameter(r10, "proto");
        Intrinsics.checkNotNullParameter(r11, "nameResolver");
        Object r12 = r10.getExtension(JvmProtoBuf.typeAnnotation);
        Intrinsics.checkNotNullExpressionValue(r12, "proto.getExtension(JvmProtoBuf.typeAnnotation)");
        Iterable r13 = (Iterable) r12;
        ArrayList r14 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10));
        Iterator r15 = r13.iterator();
    L4:
        if (r15.hasNext() == false) goto L6;
        ProtoBuf.Annotation r16 = (ProtoBuf.Annotation) r15.next();
        Intrinsics.checkNotNullExpressionValue(r16, "it");
        r14.add(loadTypeAnnotation(r16, r11));
        goto L4
    L6:
        return r14;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<A> loadTypeParameterAnnotations(ProtoBuf.TypeParameter r10, NameResolver r11) {
        Intrinsics.checkNotNullParameter(r10, "proto");
        Intrinsics.checkNotNullParameter(r11, "nameResolver");
        Object r12 = r10.getExtension(JvmProtoBuf.typeParameterAnnotation);
        Intrinsics.checkNotNullExpressionValue(r12, "proto.getExtension(JvmPr….typeParameterAnnotation)");
        Iterable r13 = (Iterable) r12;
        ArrayList r14 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10));
        Iterator r15 = r13.iterator();
    L4:
        if (r15.hasNext() == false) goto L6;
        ProtoBuf.Annotation r16 = (ProtoBuf.Annotation) r15.next();
        Intrinsics.checkNotNullExpressionValue(r16, "it");
        r14.add(loadTypeAnnotation(r16, r11));
        goto L4
    L6:
        return r14;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<A> loadValueParameterAnnotations(ProtoContainer r10, MessageLite r11, AnnotatedCallableKind r12, int r13, ProtoBuf.ValueParameter r14) {
        Intrinsics.checkNotNullParameter(r10, "container");
        Intrinsics.checkNotNullParameter(r11, "callableProto");
        Intrinsics.checkNotNullParameter(r12, "kind");
        Intrinsics.checkNotNullParameter(r14, "proto");
        MemberSignature r15 = getCallableSignature$default(this, r11, r10.getNameResolver(), r10.getTypeTable(), r12, false, 16, null);
        if (r15 == null) goto L7;
        int r16 = r13 + computeJvmParameterIndexShift(r10, r11);
        return findClassAndLoadMemberAnnotations$default(this, r10, MemberSignature.Companion.fromMethodSignatureAndParameterIndex(r15, r16), false, false, null, false, 60, null);
    L7:
        return CollectionsKt.emptyList();
    }
}
