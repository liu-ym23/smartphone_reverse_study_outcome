package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.SpecialJvmAnnotations;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationLoader.AnnotationsContainer;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$EnumEntry;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public abstract class AbstractBinaryClassAnnotationLoader<A, S extends AnnotationsContainer<? extends A>> implements AnnotationLoader<A> {
    public static final Companion Companion = null;
    private final KotlinClassFinder kotlinClassFinder;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final KotlinJvmBinaryClass getSpecialCaseContainerClass(ProtoContainer r7, boolean r8, boolean r9, Boolean r10, boolean r11, KotlinClassFinder r12, JvmMetadataVersion r13) {
            Intrinsics.checkNotNullParameter(r7, "container");
            Intrinsics.checkNotNullParameter(r12, "kotlinClassFinder");
            Intrinsics.checkNotNullParameter(r13, "jvmMetadataVersion");
            if (r8 == false) goto L27;
            if (r10 == null) goto L26;
            if ((r7 instanceof ProtoContainer.Class) == false) goto L12;
            ProtoContainer.Class r14 = (ProtoContainer.Class) r7;
            if (r14.getKind() != ProtoBuf$Class.Kind.INTERFACE) goto L12;
            return KotlinClassFinderKt.findKotlinClass(r12, r14.getClassId().createNestedClassId(Name.identifier("DefaultImpls")), r13);
        L12:
            if (r10.booleanValue() == false) goto L27;
            if ((r7 instanceof ProtoContainer.Package) == false) goto L27;
            JvmPackagePartSource r15 = r7.getSource();
            if ((r15 instanceof JvmPackagePartSource) == false) goto L18;
            JvmPackagePartSource r16 = r15;
        L19:
            if (r16 == null) goto L21;
            JvmClassName r17 = r16.getFacadeClassName();
        L22:
            if (r17 == null) goto L27;
            return KotlinClassFinderKt.findKotlinClass(r12, ClassId.Companion.topLevel(new FqName(StringsKt.replace$default(r17.getInternalName(), '/', '.', false, 4, null))), r13);
        L21:
            r17 = null;
            goto L22
        L18:
            r16 = null;
            goto L19
        L26:
            throw new IllegalStateException(("isConst should not be null for property (container=" + r7 + ')').toString());
        L27:
            if (r9 == false) goto L51;
            if ((r7 instanceof ProtoContainer.Class) == false) goto L51;
            ProtoContainer.Class r18 = (ProtoContainer.Class) r7;
            if (r18.getKind() != ProtoBuf$Class.Kind.COMPANION_OBJECT) goto L51;
            ProtoContainer.Class r19 = r18.getOuterClass();
            if (r19 == null) goto L51;
            if (r19.getKind() != ProtoBuf$Class.Kind.CLASS) goto L37;
        L43:
            SourceElement r20 = r19.getSource();
            if ((r20 instanceof KotlinJvmBinarySourceElement) == false) goto L46;
            KotlinJvmBinarySourceElement r21 = (KotlinJvmBinarySourceElement) r20;
        L47:
            if (r21 != null) goto L49;
            return null;
        L49:
            return r21.getBinaryClass();
        L46:
            r21 = null;
            goto L47
        L37:
            if (r19.getKind() == ProtoBuf$Class.Kind.ENUM_CLASS) goto L43;
            if (r11 == false) goto L51;
            if (r19.getKind() == ProtoBuf$Class.Kind.INTERFACE) goto L43;
            if (r19.getKind() == ProtoBuf$Class.Kind.ANNOTATION_CLASS) goto L43;
        L51:
            if ((r7 instanceof ProtoContainer.Package) == true) goto L53;
        L58:
            return null;
        L53:
            if ((r7.getSource() instanceof JvmPackagePartSource) == false) goto L58;
            JvmPackagePartSource r22 = r7.getSource();
            Intrinsics.checkNotNull(r22, "null cannot be cast to non-null type org.jetbrains.kotlin.load.kotlin.JvmPackagePartSource");
            JvmPackagePartSource r23 = r22;
            KotlinJvmBinaryClass r24 = r23.getKnownJvmBinaryClass();
            if (r24 == null) goto L57;
            return r24;
        L57:
            return KotlinClassFinderKt.findKotlinClass(r12, r23.getClassId(), r13);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public abstract S getAnnotationsContainer(KotlinJvmBinaryClass r1);

    public byte[] getCachedFileContent(KotlinJvmBinaryClass r2) {
        Intrinsics.checkNotNullParameter(r2, "kotlinClass");
        return null;
    }

    public abstract JvmMetadataVersion getJvmMetadataVersion();

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public abstract A loadAnnotation(ProtoBuf$Annotation r1, NameResolver r2);

    public abstract KotlinJvmBinaryClass.AnnotationArgumentVisitor loadAnnotation(ClassId r1, SourceElement r2, List<A> r3);

    public final KotlinClassFinder getKotlinClassFinder() {
        return this.kotlinClassFinder;
    }

    public AbstractBinaryClassAnnotationLoader(KotlinClassFinder r2) {
        Intrinsics.checkNotNullParameter(r2, "kotlinClassFinder");
        this.kotlinClassFinder = r2;
    }

    private final KotlinJvmBinaryClass toBinaryClass(ProtoContainer.Class r3) {
        SourceElement r4 = r3.getSource();
        if ((r4 instanceof KotlinJvmBinarySourceElement) == false) goto L5;
        KotlinJvmBinarySourceElement r5 = (KotlinJvmBinarySourceElement) r4;
    L6:
        if (r5 != null) goto L8;
        return null;
    L8:
        return r5.getBinaryClass();
    L5:
        r5 = null;
        goto L6
    }

    public final boolean isImplicitRepeatableContainer(ClassId r4) {
        Intrinsics.checkNotNullParameter(r4, "classId");
        if (r4.getOuterClassId() != null) goto L5;
        return false;
    L5:
        if (Intrinsics.areEqual(r4.getShortClassName().asString(), "Container") == false) goto L16;
        KotlinJvmBinaryClass r5 = KotlinClassFinderKt.findKotlinClass(this.kotlinClassFinder, r4, getJvmMetadataVersion());
        if (r5 != null) goto L10;
        return false;
    L10:
        if (SpecialJvmAnnotations.INSTANCE.isAnnotatedWithContainerMetaAnnotation(r5) == false) goto L15;
        return true;
    L15:
        return false;
    L16:
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<A> loadClassAnnotations(ProtoContainer.Class r4) {
        Intrinsics.checkNotNullParameter(r4, "container");
        KotlinJvmBinaryClass r0 = toBinaryClass(r4);
        if (r0 == null) goto L7;
        ArrayList r5 = new ArrayList(1);
        r0.loadClassAnnotations(new loadClassAnnotations.1(this, r5), getCachedFileContent(r0));
        return r5;
    L7:
        throw new IllegalStateException(("Class for loading annotations is not found: " + r4.debugFqName()).toString());
    }

    private final int computeJvmParameterIndexShift(ProtoContainer r4, MessageLite r5) {
        if ((r5 instanceof ProtoBuf$Function) == false) goto L9;
        if (ProtoTypeTableUtilKt.hasReceiver((ProtoBuf$Function) r5) == true) goto L25;
    L7:
        return 0;
    L25:
        return 1;
    L9:
        if ((r5 instanceof ProtoBuf$Property) == false) goto L14;
        if (ProtoTypeTableUtilKt.hasReceiver((ProtoBuf$Property) r5) == false) goto L7;
        return 1;
    L14:
        if ((r5 instanceof ProtoBuf$Constructor) == false) goto L22;
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type org.jetbrains.kotlin.serialization.deserialization.ProtoContainer.Class");
        ProtoContainer.Class r6 = (ProtoContainer.Class) r4;
        if (r6.getKind() != ProtoBuf$Class.Kind.ENUM_CLASS) goto L19;
        return 2;
    L19:
        if (r6.isInner() == false) goto L7;
        return 1;
    L22:
        throw new UnsupportedOperationException("Unsupported message: " + r5.getClass());
    }

    public final KotlinJvmBinaryClass findClassWithAnnotationsAndInitializers(ProtoContainer r2, KotlinJvmBinaryClass r3) {
        Intrinsics.checkNotNullParameter(r2, "container");
        if (r3 == null) goto L5;
        return r3;
    L5:
        if ((r2 instanceof ProtoContainer.Class) == true) goto L10;
        return null;
    L10:
        return toBinaryClass((ProtoContainer.Class) r2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<A> loadEnumEntryAnnotations(ProtoContainer r12, ProtoBuf$EnumEntry r13) {
        Intrinsics.checkNotNullParameter(r12, "container");
        Intrinsics.checkNotNullParameter(r13, "proto");
        return findClassAndLoadMemberAnnotations$default(this, r12, MemberSignature.Companion.fromFieldNameAndDesc(r12.getNameResolver().getString(r13.getName()), ClassMapperLite.mapClass(((ProtoContainer.Class) r12).getClassId().asString())), false, false, null, false, 60, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<A> loadPropertyBackingFieldAnnotations(ProtoContainer r2, ProtoBuf$Property r3) {
        Intrinsics.checkNotNullParameter(r2, "container");
        Intrinsics.checkNotNullParameter(r3, "proto");
        return loadPropertyAnnotations(r2, r3, PropertyRelatedElement.BACKING_FIELD);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<A> loadPropertyDelegateFieldAnnotations(ProtoContainer r2, ProtoBuf$Property r3) {
        Intrinsics.checkNotNullParameter(r2, "container");
        Intrinsics.checkNotNullParameter(r3, "proto");
        return loadPropertyAnnotations(r2, r3, PropertyRelatedElement.DELEGATE_FIELD);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<A> loadTypeAnnotations(ProtoBuf$Type r3, NameResolver r4) {
        Intrinsics.checkNotNullParameter(r3, "proto");
        Intrinsics.checkNotNullParameter(r4, "nameResolver");
        Iterable r5 = (Iterable) r3.getExtension(JvmProtoBuf.typeAnnotation);
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        ProtoBuf$Annotation r1 = (ProtoBuf$Annotation) r6.next();
        Intrinsics.checkNotNull(r1);
        r0.add(loadAnnotation(r1, r4));
        goto L4
    L6:
        return r0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<A> loadTypeParameterAnnotations(ProtoBuf$TypeParameter r3, NameResolver r4) {
        Intrinsics.checkNotNullParameter(r3, "proto");
        Intrinsics.checkNotNullParameter(r4, "nameResolver");
        Iterable r5 = (Iterable) r3.getExtension(JvmProtoBuf.typeParameterAnnotation);
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        ProtoBuf$Annotation r1 = (ProtoBuf$Annotation) r6.next();
        Intrinsics.checkNotNull(r1);
        r0.add(loadAnnotation(r1, r4));
        goto L4
    L6:
        return r0;
    }

    private final List<A> loadPropertyAnnotations(ProtoContainer r18, ProtoBuf$Property r19, PropertyRelatedElement r20) {
        boolean r1 = Flags.IS_CONST.get(r19.getFlags()).booleanValue();
        boolean r8 = JvmProtoBufUtil.isMovedFromInterfaceCompanion(r19);
        if (r20 != PropertyRelatedElement.PROPERTY) goto L10;
        MemberSignature r4 = AbstractBinaryClassAnnotationLoaderKt.getPropertySignature$default(r19, r18.getNameResolver(), r18.getTypeTable(), false, true, false, 40, null);
        if (r4 != null) goto L9;
        return CollectionsKt.emptyList();
    L9:
        return findClassAndLoadMemberAnnotations$default(this, r18, r4, true, false, Boolean.valueOf(r1), r8, 8, null);
    L10:
        MemberSignature r5 = AbstractBinaryClassAnnotationLoaderKt.getPropertySignature$default(r19, r18.getNameResolver(), r18.getTypeTable(), true, false, false, 48, null);
        if (r5 == null) goto L13;
        boolean r7 = false;
        boolean r2 = StringsKt.contains$default(r5.getSignature(), "$delegate", false, 2, null);
        if (r20 != PropertyRelatedElement.DELEGATE_FIELD) goto L17;
        r7 = true;
    L17:
        if (r2 == r7) goto L21;
        return CollectionsKt.emptyList();
    L21:
        return findClassAndLoadMemberAnnotations(r18, r5, true, true, Boolean.valueOf(r1), r8);
    L13:
        return CollectionsKt.emptyList();
    }

    public final KotlinJvmBinaryClass.AnnotationArgumentVisitor loadAnnotationIfNotSpecial(ClassId r2, SourceElement r3, List<A> r4) {
        Intrinsics.checkNotNullParameter(r2, "annotationClassId");
        Intrinsics.checkNotNullParameter(r3, "source");
        Intrinsics.checkNotNullParameter(r4, "result");
        if (SpecialJvmAnnotations.INSTANCE.getSPECIAL_ANNOTATIONS().contains(r2) == false) goto L7;
        return null;
    L7:
        return loadAnnotation(r2, r3, r4);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<A> loadCallableAnnotations(ProtoContainer r11, MessageLite r12, AnnotatedCallableKind r13) {
        Intrinsics.checkNotNullParameter(r11, "container");
        Intrinsics.checkNotNullParameter(r12, "proto");
        Intrinsics.checkNotNullParameter(r13, "kind");
        if (r13 == AnnotatedCallableKind.PROPERTY) goto L5;
        MemberSignature r2 = getCallableSignature$default(this, r12, r11.getNameResolver(), r11.getTypeTable(), r13, false, 16, null);
        if (r2 != null) goto L11;
        return CollectionsKt.emptyList();
    L11:
        return findClassAndLoadMemberAnnotations$default(this, r11, r2, false, false, null, false, 60, null);
    L5:
        return loadPropertyAnnotations(r11, (ProtoBuf$Property) r12, PropertyRelatedElement.PROPERTY);
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

    public final MemberSignature getCallableSignature(MessageLite r9, NameResolver r10, TypeTable r11, AnnotatedCallableKind r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r9, "proto");
        Intrinsics.checkNotNullParameter(r10, "nameResolver");
        Intrinsics.checkNotNullParameter(r11, "typeTable");
        Intrinsics.checkNotNullParameter(r12, "kind");
        if ((r9 instanceof ProtoBuf$Constructor) == false) goto L9;
        MemberSignature.Companion r14 = MemberSignature.Companion;
        JvmMemberSignature.Method r15 = JvmProtoBufUtil.INSTANCE.getJvmConstructorSignature((ProtoBuf$Constructor) r9, r10, r11);
        if (r15 != null) goto L34;
        return null;
    L34:
        return r14.fromJvmMemberSignature(r15);
    L9:
        if ((r9 instanceof ProtoBuf$Function) == false) goto L15;
        MemberSignature.Companion r16 = MemberSignature.Companion;
        JvmMemberSignature.Method r17 = JvmProtoBufUtil.INSTANCE.getJvmMethodSignature((ProtoBuf$Function) r9, r10, r11);
        if (r17 != null) goto L35;
        return null;
    L35:
        return r16.fromJvmMemberSignature(r17);
    L15:
        if ((r9 instanceof ProtoBuf$Property) == false) goto L36;
        JvmProtoBuf.JvmPropertySignature r0 = (JvmProtoBuf.JvmPropertySignature) ProtoBufUtilKt.getExtensionOrNull((GeneratedMessageLite.ExtendableMessage) r9, JvmProtoBuf.propertySignature);
        if (r0 != null) goto L19;
        return null;
    L19:
        int r18 = WhenMappings.$EnumSwitchMapping$0[r12.ordinal()];
        if (r18 == 1) goto L31;
        if (r18 == 2) goto L28;
        if (r18 == 3) goto L37;
        return null;
    L37:
        return AbstractBinaryClassAnnotationLoaderKt.getPropertySignature((ProtoBuf$Property) r9, r10, r11, true, true, r13);
    L28:
        if (r0.hasSetter() == true) goto L39;
        return null;
    L39:
        return MemberSignature.Companion.fromMethod(r10, r0.getSetter());
    L31:
        if (r0.hasGetter() == true) goto L33;
        return null;
    L33:
        return MemberSignature.Companion.fromMethod(r10, r0.getGetter());
    L36:
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<A> loadValueParameterAnnotations(ProtoContainer r10, MessageLite r11, AnnotatedCallableKind r12, int r13, ProtoBuf$ValueParameter r14) {
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

    private final List<A> findClassAndLoadMemberAnnotations(ProtoContainer r9, MemberSignature r10, boolean r11, boolean r12, Boolean r13, boolean r14) {
        KotlinJvmBinaryClass r15 = findClassWithAnnotationsAndInitializers(r9, Companion.getSpecialCaseContainerClass(r9, r11, r12, r13, r14, this.kotlinClassFinder, getJvmMetadataVersion()));
        if (r15 == null) goto L5;
        List<A> r16 = (List) getAnnotationsContainer(r15).getMemberAnnotations().get(r10);
        if (r16 == null) goto L9;
        return r16;
    L9:
        return CollectionsKt.emptyList();
    L5:
        return CollectionsKt.emptyList();
    }

    public static /* synthetic */ MemberSignature getCallableSignature$default(AbstractBinaryClassAnnotationLoader r6, MessageLite r7, NameResolver r8, TypeTable r9, AnnotatedCallableKind r10, boolean r11, int r12, Object r13) {
        if (r13 != null) goto L10;
        if ((r12 & 16) == 0) goto L6;
        boolean r5 = false;
    L8:
        return r6.getCallableSignature(r7, r8, r9, r10, r5);
    L6:
        r5 = r11;
        goto L8
    L10:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getCallableSignature");
    }

    public static /* synthetic */ List findClassAndLoadMemberAnnotations$default(AbstractBinaryClassAnnotationLoader r9, ProtoContainer r10, MemberSignature r11, boolean r12, boolean r13, Boolean r14, boolean r15, int r16, Object r17) {
        if (r17 != null) goto L22;
        if ((r16 & 4) == 0) goto L6;
        boolean r5 = false;
    L8:
        if ((r16 & 8) == 0) goto L10;
        boolean r6 = false;
    L12:
        if ((r16 & 16) == 0) goto L14;
        Boolean r7 = null;
    L16:
        if ((r16 & 32) == 0) goto L18;
        boolean r8 = false;
    L20:
        return r9.findClassAndLoadMemberAnnotations(r10, r11, r5, r6, r7, r8);
    L18:
        r8 = r15;
        goto L20
    L14:
        r7 = r14;
        goto L16
    L10:
        r6 = r13;
        goto L12
    L6:
        r5 = r12;
        goto L8
    L22:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: findClassAndLoadMemberAnnotations");
    }
}
