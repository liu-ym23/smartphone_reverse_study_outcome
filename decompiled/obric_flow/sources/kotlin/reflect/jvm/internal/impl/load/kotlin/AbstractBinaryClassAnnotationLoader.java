package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
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
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMetadataVersion;
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
@SourceDebugExtension({"SMAP\nAbstractBinaryClassAnnotationLoader.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AbstractBinaryClassAnnotationLoader.kt\norg/jetbrains/kotlin/load/kotlin/AbstractBinaryClassAnnotationLoader\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,329:1\n1549#2:330\n1620#2,3:331\n1549#2:334\n1620#2,3:335\n1#3:338\n*S KotlinDebug\n*F\n+ 1 AbstractBinaryClassAnnotationLoader.kt\norg/jetbrains/kotlin/load/kotlin/AbstractBinaryClassAnnotationLoader\n*L\n196#1:330\n196#1:331,3\n200#1:334\n200#1:335,3\n*E\n"})
public abstract class AbstractBinaryClassAnnotationLoader<A, S extends AnnotationsContainer<? extends A>> implements AnnotationLoader<A> {
    private final KotlinClassFinder kotlinClassFinder;

    public static abstract class AnnotationsContainer<A> {
        public AnnotationsContainer() {
        }

        public abstract Map<MemberSignature, List<A>> getMemberAnnotations();
    }

    public static final enum PropertyRelatedElement extends Enum<PropertyRelatedElement> {
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

        private PropertyRelatedElement(String r5, int r10) {
            super(r5, r10);
        }

        public static PropertyRelatedElement valueOf(String r5) {
            return (PropertyRelatedElement) Enum.valueOf(PropertyRelatedElement.class, r5);
        }

        public static PropertyRelatedElement[] values() {
            return (PropertyRelatedElement[]) $VALUES.clone();
        }
    }

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r5 = new int[AnnotatedCallableKind.values().length];
            r5[AnnotatedCallableKind.PROPERTY_GETTER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r5[AnnotatedCallableKind.PROPERTY_SETTER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r5[AnnotatedCallableKind.PROPERTY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r5;
        }
    }

    public AbstractBinaryClassAnnotationLoader(KotlinClassFinder r5) {
        Intrinsics.checkNotNullParameter(r5, "kotlinClassFinder");
        this.kotlinClassFinder = r5;
    }

    private final int computeJvmParameterIndexShift(ProtoContainer r5, MessageLite r10) {
        if ((r10 instanceof ProtoBuf.Function) == false) goto L8;
        if (ProtoTypeTableUtilKt.hasReceiver((ProtoBuf.Function) r10) == true) goto L23;
        return 0;
    L23:
        return 1;
    L8:
        if ((r10 instanceof ProtoBuf.Property) == false) goto L13;
        if (ProtoTypeTableUtilKt.hasReceiver((ProtoBuf.Property) r10) == true) goto L23;
        return 0;
    L13:
        if ((r10 instanceof ProtoBuf.Constructor) == false) goto L22;
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type org.jetbrains.kotlin.serialization.deserialization.ProtoContainer.Class");
        ProtoContainer.Class r11 = (ProtoContainer.Class) r5;
        if (r11.getKind() != ProtoBuf.Class.Kind.ENUM_CLASS) goto L18;
        return 2;
    L18:
        if (r11.isInner() == true) goto L23;
        return 0;
    L22:
        throw new UnsupportedOperationException("Unsupported message: " + r10.getClass());
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

    public static /* synthetic */ List findClassAndLoadMemberAnnotations$default(AbstractBinaryClassAnnotationLoader r10, ProtoContainer r11, MemberSignature r12, boolean r13, boolean r14, Boolean r15, boolean r16, int r17, Object r18) {
        if (r18 != null) goto L22;
        if ((r17 & 4) == 0) goto L6;
        boolean r5 = false;
    L8:
        if ((r17 & 8) == 0) goto L10;
        boolean r19 = false;
    L12:
        if ((r17 & 16) == 0) goto L14;
        Boolean r20 = null;
    L16:
        if ((r17 & 32) == 0) goto L18;
        boolean r21 = false;
    L20:
        return r10.findClassAndLoadMemberAnnotations(r11, r12, r5, r19, r20, r21);
    L18:
        r21 = r16;
        goto L20
    L14:
        r20 = r15;
        goto L16
    L10:
        r19 = r14;
        goto L12
    L6:
        r5 = r13;
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

    private final List<A> loadPropertyAnnotations(ProtoContainer r19, ProtoBuf.Property r20, PropertyRelatedElement r21) {
        Boolean r10 = Flags.IS_CONST.get(r20.getFlags());
        r10.getClass();
        boolean r11 = JvmProtoBufUtil.isMovedFromInterfaceCompanion(r20);
        if (r21 != PropertyRelatedElement.PROPERTY) goto L10;
        MemberSignature r5 = AbstractBinaryClassAnnotationLoaderKt.getPropertySignature$default(r20, r19.getNameResolver(), r19.getTypeTable(), false, true, false, 40, null);
        if (r5 != null) goto L9;
        return CollectionsKt.emptyList();
    L9:
        return findClassAndLoadMemberAnnotations$default(this, r19, r5, true, false, r10, r11, 8, null);
    L10:
        MemberSignature r12 = AbstractBinaryClassAnnotationLoaderKt.getPropertySignature$default(r20, r19.getNameResolver(), r19.getTypeTable(), true, false, false, 48, null);
        if (r12 == null) goto L13;
        boolean r13 = StringsKt.g(r12.getSignature(), "$delegate");
        if (r21 != PropertyRelatedElement.DELEGATE_FIELD) goto L17;
        boolean r14 = true;
    L18:
        if (r13 == r14) goto L22;
        return CollectionsKt.emptyList();
    L22:
        return findClassAndLoadMemberAnnotations(r19, r12, true, true, r10, r11);
    L17:
        r14 = false;
        goto L18
    L13:
        return CollectionsKt.emptyList();
    }

    private final KotlinJvmBinaryClass toBinaryClass(ProtoContainer.Class r5) {
        SourceElement r10 = r5.getSource();
        if ((r10 instanceof KotlinJvmBinarySourceElement) == false) goto L5;
        KotlinJvmBinarySourceElement r11 = (KotlinJvmBinarySourceElement) r10;
    L6:
        if (r11 != null) goto L8;
        return null;
    L8:
        return r11.getBinaryClass();
    L5:
        r11 = null;
        goto L6
    }

    public final KotlinJvmBinaryClass findClassWithAnnotationsAndInitializers(ProtoContainer r5, KotlinJvmBinaryClass r10) {
        Intrinsics.checkNotNullParameter(r5, "container");
        if (r10 == null) goto L5;
        return r10;
    L5:
        if ((r5 instanceof ProtoContainer.Class) == true) goto L10;
        return null;
    L10:
        return toBinaryClass((ProtoContainer.Class) r5);
    }

    public abstract S getAnnotationsContainer(KotlinJvmBinaryClass r5);

    public byte[] getCachedFileContent(KotlinJvmBinaryClass r5) {
        Intrinsics.checkNotNullParameter(r5, "kotlinClass");
        return null;
    }

    public final MemberSignature getCallableSignature(MessageLite r10, NameResolver r11, TypeTable r12, AnnotatedCallableKind r13, boolean r14) {
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
        if ((r10 instanceof ProtoBuf.Function) == false) goto L15;
        MemberSignature.Companion r17 = MemberSignature.Companion;
        JvmMemberSignature.Method r18 = JvmProtoBufUtil.INSTANCE.getJvmMethodSignature((ProtoBuf.Function) r10, r11, r12);
        if (r18 != null) goto L35;
        return null;
    L35:
        return r17.fromJvmMemberSignature(r18);
    L15:
        if ((r10 instanceof ProtoBuf.Property) == false) goto L36;
        JvmProtoBuf.JvmPropertySignature r19 = (JvmProtoBuf.JvmPropertySignature) ProtoBufUtilKt.getExtensionOrNull((GeneratedMessageLite.ExtendableMessage) r10, JvmProtoBuf.propertySignature);
        if (r19 != null) goto L19;
        return null;
    L19:
        int r110 = WhenMappings.$EnumSwitchMapping$0[r13.ordinal()];
        if (r110 == 1) goto L31;
        if (r110 == 2) goto L28;
        if (r110 == 3) goto L37;
        return null;
    L37:
        return AbstractBinaryClassAnnotationLoaderKt.getPropertySignature((ProtoBuf.Property) r10, r11, r12, true, true, r14);
    L28:
        if (r19.hasSetter() == true) goto L39;
        return null;
    L39:
        return MemberSignature.Companion.fromMethod(r11, r19.getSetter());
    L31:
        if (r19.hasGetter() == true) goto L33;
        return null;
    L33:
        return MemberSignature.Companion.fromMethod(r11, r19.getGetter());
    L36:
        return null;
    }

    public abstract JvmMetadataVersion getJvmMetadataVersion();

    public final KotlinJvmBinaryClass getSpecialCaseContainerClass(ProtoContainer r5, boolean r10, boolean r11, Boolean r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r5, "container");
        if (r10 == false) goto L27;
        if (r12 == null) goto L26;
        if ((r5 instanceof ProtoContainer.Class) == false) goto L12;
        ProtoContainer.Class r14 = (ProtoContainer.Class) r5;
        if (r14.getKind() != ProtoBuf.Class.Kind.INTERFACE) goto L12;
        return KotlinClassFinderKt.findKotlinClass(this.kotlinClassFinder, r14.getClassId().createNestedClassId(Name.identifier("DefaultImpls")), getJvmMetadataVersion());
    L12:
        if (r12.booleanValue() == false) goto L27;
        if ((r5 instanceof ProtoContainer.Package) == false) goto L27;
        SourceElement r15 = r5.getSource();
        if ((r15 instanceof JvmPackagePartSource) == false) goto L18;
        JvmPackagePartSource r16 = (JvmPackagePartSource) r15;
    L19:
        if (r16 == null) goto L21;
        JvmClassName r17 = r16.getFacadeClassName();
    L22:
        if (r17 == null) goto L27;
        return KotlinClassFinderKt.findKotlinClass(this.kotlinClassFinder, ClassId.topLevel(new FqName(StringsKt.E(r17.getInternalName(), '/', '.'))), getJvmMetadataVersion());
    L21:
        r17 = null;
        goto L22
    L18:
        r16 = null;
        goto L19
    L26:
        throw new IllegalStateException(("isConst should not be null for property (container=" + r5 + ')').toString());
    L27:
        if (r11 == false) goto L46;
        if ((r5 instanceof ProtoContainer.Class) == false) goto L46;
        ProtoContainer.Class r18 = (ProtoContainer.Class) r5;
        if (r18.getKind() != ProtoBuf.Class.Kind.COMPANION_OBJECT) goto L46;
        ProtoContainer.Class r19 = r18.getOuterClass();
        if (r19 == null) goto L46;
        if (r19.getKind() == ProtoBuf.Class.Kind.CLASS) goto L44;
        if (r19.getKind() == ProtoBuf.Class.Kind.ENUM_CLASS) goto L44;
        if (r13 == false) goto L46;
        if (r19.getKind() == ProtoBuf.Class.Kind.INTERFACE) goto L44;
        if (r19.getKind() != ProtoBuf.Class.Kind.ANNOTATION_CLASS) goto L46;
    L44:
        return toBinaryClass(r19);
    L46:
        if ((r5 instanceof ProtoContainer.Package) == true) goto L48;
    L53:
        return null;
    L48:
        if ((r5.getSource() instanceof JvmPackagePartSource) == false) goto L53;
        SourceElement r20 = r5.getSource();
        Intrinsics.checkNotNull(r20, "null cannot be cast to non-null type org.jetbrains.kotlin.load.kotlin.JvmPackagePartSource");
        JvmPackagePartSource r21 = (JvmPackagePartSource) r20;
        KotlinJvmBinaryClass r22 = r21.getKnownJvmBinaryClass();
        if (r22 == null) goto L52;
        return r22;
    L52:
        return KotlinClassFinderKt.findKotlinClass(this.kotlinClassFinder, r21.getClassId(), getJvmMetadataVersion());
    }

    public final boolean isImplicitRepeatableContainer(ClassId r5) {
        Intrinsics.checkNotNullParameter(r5, "classId");
        if (r5.getOuterClassId() != null) goto L5;
        return false;
    L5:
        if (Intrinsics.areEqual(r5.getShortClassName().asString(), "Container") == false) goto L16;
        KotlinJvmBinaryClass r10 = KotlinClassFinderKt.findKotlinClass(this.kotlinClassFinder, r5, getJvmMetadataVersion());
        if (r10 != null) goto L10;
        return false;
    L10:
        if (SpecialJvmAnnotations.INSTANCE.isAnnotatedWithContainerMetaAnnotation(r10) == false) goto L15;
        return true;
    L15:
        return false;
    L16:
        return false;
    }

    public abstract KotlinJvmBinaryClass.AnnotationArgumentVisitor loadAnnotation(ClassId r5, SourceElement r10, List<A> r11);

    public final KotlinJvmBinaryClass.AnnotationArgumentVisitor loadAnnotationIfNotSpecial(ClassId r5, SourceElement r10, List<A> r11) {
        Intrinsics.checkNotNullParameter(r5, "annotationClassId");
        Intrinsics.checkNotNullParameter(r10, "source");
        Intrinsics.checkNotNullParameter(r11, "result");
        if (SpecialJvmAnnotations.INSTANCE.getSPECIAL_ANNOTATIONS().contains(r5) == false) goto L7;
        return null;
    L7:
        return loadAnnotation(r5, r10, r11);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<A> loadCallableAnnotations(ProtoContainer r11, MessageLite r12, AnnotatedCallableKind r13) {
        Intrinsics.checkNotNullParameter(r11, "container");
        Intrinsics.checkNotNullParameter(r12, "proto");
        Intrinsics.checkNotNullParameter(r13, "kind");
        if (r13 == AnnotatedCallableKind.PROPERTY) goto L5;
        MemberSignature r5 = getCallableSignature$default(this, r12, r11.getNameResolver(), r11.getTypeTable(), r13, false, 16, null);
        if (r5 != null) goto L11;
        return CollectionsKt.emptyList();
    L11:
        return findClassAndLoadMemberAnnotations$default(this, r11, r5, false, false, null, false, 60, null);
    L5:
        return loadPropertyAnnotations(r11, (ProtoBuf.Property) r12, PropertyRelatedElement.PROPERTY);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<A> loadClassAnnotations(ProtoContainer.Class r5) {
        Intrinsics.checkNotNullParameter(r5, "container");
        KotlinJvmBinaryClass r10 = toBinaryClass(r5);
        if (r10 == null) goto L7;
        final ArrayList r11 = new ArrayList(1);
        r10.loadClassAnnotations(new AnonymousClass1(this, r11), getCachedFileContent(r10));
        return r11;
    L7:
        throw new IllegalStateException(("Class for loading annotations is not found: " + r5.debugFqName()).toString());
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<A> loadEnumEntryAnnotations(ProtoContainer r12, ProtoBuf.EnumEntry r13) {
        Intrinsics.checkNotNullParameter(r12, "container");
        Intrinsics.checkNotNullParameter(r13, "proto");
        return findClassAndLoadMemberAnnotations$default(this, r12, MemberSignature.Companion.fromFieldNameAndDesc(r12.getNameResolver().getString(r13.getName()), ClassMapperLite.mapClass(((ProtoContainer.Class) r12).getClassId().asString())), false, false, null, false, 60, null);
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
    public List<A> loadPropertyBackingFieldAnnotations(ProtoContainer r5, ProtoBuf.Property r10) {
        Intrinsics.checkNotNullParameter(r5, "container");
        Intrinsics.checkNotNullParameter(r10, "proto");
        return loadPropertyAnnotations(r5, r10, PropertyRelatedElement.BACKING_FIELD);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<A> loadPropertyDelegateFieldAnnotations(ProtoContainer r5, ProtoBuf.Property r10) {
        Intrinsics.checkNotNullParameter(r5, "container");
        Intrinsics.checkNotNullParameter(r10, "proto");
        return loadPropertyAnnotations(r5, r10, PropertyRelatedElement.DELEGATE_FIELD);
    }

    public abstract A loadTypeAnnotation(ProtoBuf.Annotation r5, NameResolver r10);

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<A> loadTypeAnnotations(ProtoBuf.Type r5, NameResolver r10) {
        Intrinsics.checkNotNullParameter(r5, "proto");
        Intrinsics.checkNotNullParameter(r10, "nameResolver");
        Iterable r11 = (Iterable) r5.getExtension(JvmProtoBuf.typeAnnotation);
        ArrayList r12 = new ArrayList(CollectionsKt.h(r11));
        Iterator r13 = r11.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        r12.add(loadTypeAnnotation((ProtoBuf.Annotation) r13.next(), r10));
        goto L4
    L6:
        return r12;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<A> loadTypeParameterAnnotations(ProtoBuf.TypeParameter r5, NameResolver r10) {
        Intrinsics.checkNotNullParameter(r5, "proto");
        Intrinsics.checkNotNullParameter(r10, "nameResolver");
        Iterable r11 = (Iterable) r5.getExtension(JvmProtoBuf.typeParameterAnnotation);
        ArrayList r12 = new ArrayList(CollectionsKt.h(r11));
        Iterator r13 = r11.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        r12.add(loadTypeAnnotation((ProtoBuf.Annotation) r13.next(), r10));
        goto L4
    L6:
        return r12;
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
