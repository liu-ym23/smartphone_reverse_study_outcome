package kotlin.reflect.jvm.internal.impl.load.kotlin;

import com.bytedance.crash.entity.EventBody;
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
        public AnnotationsContainerWithConstants(Map<MemberSignature, ? extends List<? extends A>> r10, Map<MemberSignature, ? extends C> r11, Map<MemberSignature, ? extends C> r12) {
            Intrinsics.checkNotNullParameter(r10, "memberAnnotations");
            Intrinsics.checkNotNullParameter(r11, "propertyConstants");
            Intrinsics.checkNotNullParameter(r12, "annotationParametersDefaultValues");
            this.memberAnnotations = r10;
            this.propertyConstants = r11;
            this.annotationParametersDefaultValues = r12;
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

    public AbstractBinaryClassAnnotationAndConstantLoader(StorageManager r10, KotlinClassFinder r11) {
        Intrinsics.checkNotNullParameter(r10, "storageManager");
        Intrinsics.checkNotNullParameter(r11, "kotlinClassFinder");
        super(r11);
        this.storage = r10.createMemoizedFunction(new AbstractBinaryClassAnnotationAndConstantLoader$storage$1(this));
    }

    public static final /* synthetic */ AnnotationsContainerWithConstants access$loadAnnotationsAndInitializers(AbstractBinaryClassAnnotationAndConstantLoader r10, KotlinJvmBinaryClass r11) {
        return r10.loadAnnotationsAndInitializers(r11);
    }

    private final AnnotationsContainerWithConstants<A, C> loadAnnotationsAndInitializers(final KotlinJvmBinaryClass r11) {
        final HashMap r10 = new HashMap();
        final HashMap r12 = new HashMap();
        final HashMap r13 = new HashMap();
        r11.visitMembers(new C04191(this, r10, r11, r13, r12), getCachedFileContent(r11));
        return new AnnotationsContainerWithConstants(r10, r12, r13);
    }

    private final C loadConstantFromProperty(ProtoContainer r11, ProtoBuf.Property r12, AnnotatedCallableKind r13, KotlinType r14, Function2<? super AnnotationsContainerWithConstants<? extends A, ? extends C>, ? super MemberSignature, ? extends C> r15) {
        KotlinJvmBinaryClass r10 = findClassWithAnnotationsAndInitializers(r11, getSpecialCaseContainerClass(r11, true, true, Flags.IS_CONST.get(r12.getFlags()), JvmProtoBufUtil.isMovedFromInterfaceCompanion(r12)));
        if (r10 != null) goto L5;
        return null;
    L5:
        boolean r16 = r10.getClassHeader().getMetadataVersion().isAtLeast(DeserializedDescriptorResolver.Companion.getKOTLIN_1_3_RC_METADATA_VERSION$descriptors_jvm());
        MemberSignature r17 = getCallableSignature(r12, r11.getNameResolver(), r11.getTypeTable(), r13, r16);
        if (r17 != null) goto L8;
        return null;
    L8:
        C r18 = r15.invoke(this.storage.invoke(r10), r17);
        if (r18 != null) goto L12;
        return null;
    L12:
        if (UnsignedTypes.isUnsignedType(r14) == true) goto L14;
        return r18;
    L14:
        return transformToUnsignedConstant(r18);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationLoader
    protected AnnotationsContainerWithConstants<A, C> getAnnotationsContainer(KotlinJvmBinaryClass r10) {
        Intrinsics.checkNotNullParameter(r10, "binaryClass");
        return this.storage.invoke(r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationLoader
    public /* bridge */ /* synthetic */ AbstractBinaryClassAnnotationLoader.AnnotationsContainer getAnnotationsContainer(KotlinJvmBinaryClass r10) {
        return getAnnotationsContainer(r10);
    }

    protected final boolean isRepeatableWithImplicitContainer(ClassId r10, Map<Name, ? extends ConstantValue<?>> r11) {
        Intrinsics.checkNotNullParameter(r10, "annotationClassId");
        Intrinsics.checkNotNullParameter(r11, "arguments");
        if (Intrinsics.areEqual(r10, SpecialJvmAnnotations.INSTANCE.getJAVA_LANG_ANNOTATION_REPEATABLE()) == true) goto L5;
        return false;
    L5:
        ConstantValue<?> r12 = r11.get(Name.identifier(EventBody.KEY_VALUE));
        KClassValue.Value.NormalClass r13 = null;
        if ((r12 instanceof KClassValue) == false) goto L8;
        KClassValue r14 = (KClassValue) r12;
    L9:
        if (r14 != null) goto L11;
        return false;
    L11:
        KClassValue.Value r15 = r14.getValue();
        if ((r15 instanceof KClassValue.Value.NormalClass) == false) goto L14;
        r13 = (KClassValue.Value.NormalClass) r15;
    L14:
        if (r13 != null) goto L17;
        return false;
    L17:
        return isImplicitRepeatableContainer(r13.getClassId());
    L8:
        r14 = null;
        goto L9
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    public C loadAnnotationDefaultValue(ProtoContainer r10, ProtoBuf.Property r11, KotlinType r12) {
        Intrinsics.checkNotNullParameter(r10, "container");
        Intrinsics.checkNotNullParameter(r11, "proto");
        Intrinsics.checkNotNullParameter(r12, "expectedType");
        return loadConstantFromProperty(r10, r11, AnnotatedCallableKind.PROPERTY_GETTER, r12, AnonymousClass1.INSTANCE);
    }

    protected abstract C loadConstant(String r10, Object r11);

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    public C loadPropertyConstant(ProtoContainer r10, ProtoBuf.Property r11, KotlinType r12) {
        Intrinsics.checkNotNullParameter(r10, "container");
        Intrinsics.checkNotNullParameter(r11, "proto");
        Intrinsics.checkNotNullParameter(r12, "expectedType");
        return loadConstantFromProperty(r10, r11, AnnotatedCallableKind.PROPERTY, r12, C04201.INSTANCE);
    }

    protected abstract C transformToUnsignedConstant(C r10);
}
