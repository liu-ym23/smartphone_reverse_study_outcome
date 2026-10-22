package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.SpecialJvmAnnotations;
import kotlin.reflect.jvm.internal.impl.builtins.UnsignedTypes;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractBinaryClassAnnotationAndConstantLoader<A, C> extends AbstractBinaryClassAnnotationLoader<A, AnnotationsContainerWithConstants<? extends A, ? extends C>> implements AnnotationAndConstantLoader<A, C> {
    private final MemoizedFunctionToNotNull<KotlinJvmBinaryClass, AnnotationsContainerWithConstants<A, C>> storage;

    public static final class AnnotationsContainerWithConstants<A, C> extends AbstractBinaryClassAnnotationLoader.AnnotationsContainer<A> {
        private final Map<MemberSignature, C> annotationParametersDefaultValues;
        private final Map<MemberSignature, List<A>> memberAnnotations;
        private final Map<MemberSignature, C> propertyConstants;

        /* JADX WARN: Multi-variable type inference failed */
        public AnnotationsContainerWithConstants(Map<MemberSignature, ? extends List<? extends A>> r5, Map<MemberSignature, ? extends C> r10, Map<MemberSignature, ? extends C> r11) {
            Intrinsics.checkNotNullParameter(r5, "memberAnnotations");
            Intrinsics.checkNotNullParameter(r10, "propertyConstants");
            Intrinsics.checkNotNullParameter(r11, "annotationParametersDefaultValues");
            this.memberAnnotations = r5;
            this.propertyConstants = r10;
            this.annotationParametersDefaultValues = r11;
        }

        public final Map<MemberSignature, C> getAnnotationParametersDefaultValues() {
            return this.annotationParametersDefaultValues;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationLoader.AnnotationsContainer
        public Map<MemberSignature, List<A>> getMemberAnnotations() {
            return this.memberAnnotations;
        }

        public final Map<MemberSignature, C> getPropertyConstants() {
            return this.propertyConstants;
        }
    }

    public AbstractBinaryClassAnnotationAndConstantLoader(StorageManager r5, KotlinClassFinder r10) {
        Intrinsics.checkNotNullParameter(r5, "storageManager");
        Intrinsics.checkNotNullParameter(r10, "kotlinClassFinder");
        super(r10);
        this.storage = r5.createMemoizedFunction(new AbstractBinaryClassAnnotationAndConstantLoader$storage$1(this));
    }

    public static final /* synthetic */ AnnotationsContainerWithConstants access$loadAnnotationsAndInitializers(AbstractBinaryClassAnnotationAndConstantLoader r5, KotlinJvmBinaryClass r10) {
        return r5.loadAnnotationsAndInitializers(r10);
    }

    private final AnnotationsContainerWithConstants<A, C> loadAnnotationsAndInitializers(final KotlinJvmBinaryClass r11) {
        final HashMap r10 = new HashMap();
        final HashMap r12 = new HashMap();
        final HashMap r13 = new HashMap();
        r11.visitMembers(new C02291(this, r10, r11, r13, r12), getCachedFileContent(r11));
        return new AnnotationsContainerWithConstants(r10, r12, r13);
    }

    private final C loadConstantFromProperty(ProtoContainer r11, ProtoBuf.Property r12, AnnotatedCallableKind r13, KotlinType r14, Function2<? super AnnotationsContainerWithConstants<? extends A, ? extends C>, ? super MemberSignature, ? extends C> r15) {
        KotlinJvmBinaryClass r5 = findClassWithAnnotationsAndInitializers(r11, getSpecialCaseContainerClass(r11, true, true, Flags.IS_CONST.get(r12.getFlags()), JvmProtoBufUtil.isMovedFromInterfaceCompanion(r12)));
        if (r5 != null) goto L5;
        return null;
    L5:
        boolean r10 = r5.getClassHeader().getMetadataVersion().isAtLeast(DeserializedDescriptorResolver.Companion.getKOTLIN_1_3_RC_METADATA_VERSION$descriptors_jvm());
        MemberSignature r16 = getCallableSignature(r12, r11.getNameResolver(), r11.getTypeTable(), r13, r10);
        if (r16 != null) goto L8;
        return null;
    L8:
        C r17 = r15.mo2invoke(this.storage.invoke(r5), r16);
        if (r17 != null) goto L12;
        return null;
    L12:
        if (UnsignedTypes.isUnsignedType(r14) == true) goto L14;
        return r17;
    L14:
        return transformToUnsignedConstant(r17);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationLoader
    public /* bridge */ /* synthetic */ AbstractBinaryClassAnnotationLoader.AnnotationsContainer getAnnotationsContainer(KotlinJvmBinaryClass r5) {
        return getAnnotationsContainer(r5);
    }

    public final boolean isRepeatableWithImplicitContainer(ClassId r5, Map<Name, ? extends ConstantValue<?>> r10) {
        Intrinsics.checkNotNullParameter(r5, "annotationClassId");
        Intrinsics.checkNotNullParameter(r10, "arguments");
        if (Intrinsics.areEqual(r5, SpecialJvmAnnotations.INSTANCE.getJAVA_LANG_ANNOTATION_REPEATABLE()) == true) goto L5;
        return false;
    L5:
        ConstantValue<?> r11 = r10.get(Name.identifier("value"));
        KClassValue.Value.NormalClass r12 = null;
        if ((r11 instanceof KClassValue) == false) goto L8;
        KClassValue r13 = (KClassValue) r11;
    L9:
        if (r13 != null) goto L11;
        return false;
    L11:
        KClassValue.Value r14 = r13.getValue();
        if ((r14 instanceof KClassValue.Value.NormalClass) == false) goto L14;
        r12 = (KClassValue.Value.NormalClass) r14;
    L14:
        if (r12 != null) goto L17;
        return false;
    L17:
        return isImplicitRepeatableContainer(r12.getClassId());
    L8:
        r13 = null;
        goto L9
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    public C loadAnnotationDefaultValue(ProtoContainer r10, ProtoBuf.Property r11, KotlinType r12) {
        Intrinsics.checkNotNullParameter(r10, "container");
        Intrinsics.checkNotNullParameter(r11, "proto");
        Intrinsics.checkNotNullParameter(r12, "expectedType");
        return loadConstantFromProperty(r10, r11, AnnotatedCallableKind.PROPERTY_GETTER, r12, AnonymousClass1.INSTANCE);
    }

    public abstract C loadConstant(String r5, Object r10);

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    public C loadPropertyConstant(ProtoContainer r10, ProtoBuf.Property r11, KotlinType r12) {
        Intrinsics.checkNotNullParameter(r10, "container");
        Intrinsics.checkNotNullParameter(r11, "proto");
        Intrinsics.checkNotNullParameter(r12, "expectedType");
        return loadConstantFromProperty(r10, r11, AnnotatedCallableKind.PROPERTY, r12, C02301.INSTANCE);
    }

    public abstract C transformToUnsignedConstant(C r5);

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationLoader
    public AnnotationsContainerWithConstants<A, C> getAnnotationsContainer(KotlinJvmBinaryClass r5) {
        Intrinsics.checkNotNullParameter(r5, "binaryClass");
        return this.storage.invoke(r5);
    }
}
