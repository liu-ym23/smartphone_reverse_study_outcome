package kotlin.reflect.jvm.internal.impl.load.kotlin;

import com.bytedance.crash.entity.EventBody;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ByteValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ClassLiteralValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValueFactory;
import kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ErrorValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.IntValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.LongValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ShortValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.UByteValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.UIntValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ULongValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.UShortValue;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationDeserializer;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class BinaryClassAnnotationAndConstantLoaderImpl extends AbstractBinaryClassAnnotationAndConstantLoader<AnnotationDescriptor, ConstantValue<?>> {
    private final AnnotationDeserializer annotationDeserializer;
    private final ModuleDescriptor module;
    private final NotFoundClasses notFoundClasses;

    private abstract class AbstractAnnotationArgumentVisitor implements KotlinJvmBinaryClass.AnnotationArgumentVisitor {
        final /* synthetic */ BinaryClassAnnotationAndConstantLoaderImpl this$0;

        public AbstractAnnotationArgumentVisitor(BinaryClassAnnotationAndConstantLoaderImpl r10) {
            this.this$0 = r10;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visit(Name r10, Object r11) {
            visitConstantValue(r10, BinaryClassAnnotationAndConstantLoaderImpl.access$createConstant(this.this$0, r10, r11));
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(final Name r10, ClassId r11) {
            Intrinsics.checkNotNullParameter(r11, "classId");
            final ArrayList r12 = new ArrayList();
            BinaryClassAnnotationAndConstantLoaderImpl r13 = this.this$0;
            SourceElement r14 = SourceElement.NO_SOURCE;
            Intrinsics.checkNotNullExpressionValue(r14, "NO_SOURCE");
            final KotlinJvmBinaryClass.AnnotationArgumentVisitor r15 = r13.loadAnnotation(r11, r14, r12);
            Intrinsics.checkNotNull(r15);
            return new BinaryClassAnnotationAndConstantLoaderImpl$AbstractAnnotationArgumentVisitor$visitAnnotation$1(r15, this, r10, r12);
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor visitArray(Name r10) {
            return new BinaryClassAnnotationAndConstantLoaderImpl$AbstractAnnotationArgumentVisitor$visitArray$1(this.this$0, r10, this);
        }

        public abstract void visitArrayValue(Name r10, ArrayList<ConstantValue<?>> r11);

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visitClassLiteral(Name r10, ClassLiteralValue r11) {
            Intrinsics.checkNotNullParameter(r11, EventBody.KEY_VALUE);
            visitConstantValue(r10, new KClassValue(r11));
        }

        public abstract void visitConstantValue(Name r10, ConstantValue<?> r11);

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visitEnum(Name r10, ClassId r11, Name r12) {
            Intrinsics.checkNotNullParameter(r11, "enumClassId");
            Intrinsics.checkNotNullParameter(r12, "enumEntryName");
            visitConstantValue(r10, new EnumValue(r11, r12));
        }
    }

    public BinaryClassAnnotationAndConstantLoaderImpl(ModuleDescriptor r10, NotFoundClasses r11, StorageManager r12, KotlinClassFinder r13) {
        Intrinsics.checkNotNullParameter(r10, "module");
        Intrinsics.checkNotNullParameter(r11, "notFoundClasses");
        Intrinsics.checkNotNullParameter(r12, "storageManager");
        Intrinsics.checkNotNullParameter(r13, "kotlinClassFinder");
        super(r12, r13);
        this.module = r10;
        this.notFoundClasses = r11;
        this.annotationDeserializer = new AnnotationDeserializer(r10, r11);
    }

    public static final /* synthetic */ ConstantValue access$createConstant(BinaryClassAnnotationAndConstantLoaderImpl r10, Name r11, Object r12) {
        return r10.createConstant(r11, r12);
    }

    private final ConstantValue<?> createConstant(Name r10, Object r11) {
        ConstantValue<?> r12 = ConstantValueFactory.INSTANCE.createConstantValue(r11);
        if (r12 == null) goto L5;
        return r12;
    L5:
        return ErrorValue.Companion.create("Unsupported annotation argument: " + r10);
    }

    private final ClassDescriptor resolveClass(ClassId r10) {
        return FindClassInModuleKt.findNonGenericClassAcrossDependencies(this.module, r10, this.notFoundClasses);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationLoader
    protected KotlinJvmBinaryClass.AnnotationArgumentVisitor loadAnnotation(final ClassId r10, final SourceElement r11, final List<AnnotationDescriptor> r12) {
        Intrinsics.checkNotNullParameter(r10, "annotationClassId");
        Intrinsics.checkNotNullParameter(r11, "source");
        Intrinsics.checkNotNullParameter(r12, "result");
        final ClassDescriptor r13 = resolveClass(r10);
        return new AnonymousClass1(this, r13, r10, r12, r11);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationAndConstantLoader
    public /* bridge */ /* synthetic */ ConstantValue<?> loadConstant(String r10, Object r11) {
        return loadConstant2(r10, r11);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationAndConstantLoader
    /* JADX INFO: renamed from: loadConstant, reason: avoid collision after fix types in other method */
    protected ConstantValue<?> loadConstant2(String r10, Object r11) {
        Intrinsics.checkNotNullParameter(r10, "desc");
        Intrinsics.checkNotNullParameter(r11, "initializer");
        boolean r12 = false;
        if (StringsKt.contains$default("ZBCS", r10, false, 2, null) == false) goto L29;
        int r13 = ((Integer) r11).intValue();
        int r14 = r10.hashCode();
        if (r14 == 66) goto L24;
        if (r14 == 67) goto L21;
        if (r14 == 83) goto L18;
        if (r14 != 90) goto L27;
        if (r10.equals("Z") == false) goto L27;
        if (r13 == 0) goto L16;
        r12 = true;
    L16:
        r11 = Boolean.valueOf(r12);
    L27:
        throw new AssertionError(r10);
    L18:
        if (r10.equals("S") == false) goto L27;
        r11 = Short.valueOf((short) r13);
        goto L29
    L21:
        if (r10.equals("C") == false) goto L27;
        r11 = Character.valueOf((char) r13);
        goto L29
    L24:
        if (r10.equals("B") == false) goto L27;
        r11 = Byte.valueOf((byte) r13);
    L29:
        return ConstantValueFactory.INSTANCE.createConstantValue(r11);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationLoader
    public /* bridge */ /* synthetic */ Object loadTypeAnnotation(ProtoBuf.Annotation r10, NameResolver r11) {
        return loadTypeAnnotation(r10, r11);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationLoader
    protected AnnotationDescriptor loadTypeAnnotation(ProtoBuf.Annotation r10, NameResolver r11) {
        Intrinsics.checkNotNullParameter(r10, "proto");
        Intrinsics.checkNotNullParameter(r11, "nameResolver");
        return this.annotationDeserializer.deserializeAnnotation(r10, r11);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationAndConstantLoader
    public /* bridge */ /* synthetic */ ConstantValue<?> transformToUnsignedConstant(ConstantValue<?> r10) {
        return transformToUnsignedConstant2(r10);
    }

    /* JADX INFO: renamed from: transformToUnsignedConstant, reason: avoid collision after fix types in other method */
    protected ConstantValue<?> transformToUnsignedConstant2(ConstantValue<?> r10) {
        Intrinsics.checkNotNullParameter(r10, "constant");
        if ((r10 instanceof ByteValue) == false) goto L7;
        ConstantValue<?> r11 = new UByteValue(((ByteValue) r10).getValue().byteValue());
    L15:
        return r11;
    L7:
        if ((r10 instanceof ShortValue) == false) goto L10;
        r11 = new UShortValue(((ShortValue) r10).getValue().shortValue());
        goto L15
    L10:
        if ((r10 instanceof IntValue) == false) goto L13;
        r11 = new UIntValue(((IntValue) r10).getValue().intValue());
        goto L15
    L13:
        if ((r10 instanceof LongValue) == false) goto L16;
        r11 = new ULongValue(((LongValue) r10).getValue().longValue());
        goto L15
    L16:
        return r10;
    }
}
