package kotlin.reflect.jvm.internal.impl.load.kotlin;

import androidx.exifinterface.media.ExifInterface;
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
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMetadataVersion;
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
    private JvmMetadataVersion jvmMetadataVersion;
    private final ModuleDescriptor module;
    private final NotFoundClasses notFoundClasses;

    public abstract class AbstractAnnotationArgumentVisitor implements KotlinJvmBinaryClass.AnnotationArgumentVisitor {
        final /* synthetic */ BinaryClassAnnotationAndConstantLoaderImpl this$0;

        public AbstractAnnotationArgumentVisitor(BinaryClassAnnotationAndConstantLoaderImpl r5) {
            this.this$0 = r5;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visit(Name r5, Object r10) {
            visitConstantValue(r5, BinaryClassAnnotationAndConstantLoaderImpl.access$createConstant(this.this$0, r5, r10));
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(final Name r5, ClassId r10) {
            Intrinsics.checkNotNullParameter(r10, "classId");
            final ArrayList r11 = new ArrayList();
            final KotlinJvmBinaryClass.AnnotationArgumentVisitor r12 = this.this$0.loadAnnotation(r10, SourceElement.NO_SOURCE, r11);
            Intrinsics.checkNotNull(r12);
            return new BinaryClassAnnotationAndConstantLoaderImpl$AbstractAnnotationArgumentVisitor$visitAnnotation$1(r12, this, r5, r11);
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor visitArray(Name r5) {
            return new BinaryClassAnnotationAndConstantLoaderImpl$AbstractAnnotationArgumentVisitor$visitArray$1(this.this$0, r5, this);
        }

        public abstract void visitArrayValue(Name r5, ArrayList<ConstantValue<?>> r10);

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visitClassLiteral(Name r5, ClassLiteralValue r10) {
            Intrinsics.checkNotNullParameter(r10, "value");
            visitConstantValue(r5, new KClassValue(r10));
        }

        public abstract void visitConstantValue(Name r5, ConstantValue<?> r10);

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visitEnum(Name r5, ClassId r10, Name r11) {
            Intrinsics.checkNotNullParameter(r10, "enumClassId");
            Intrinsics.checkNotNullParameter(r11, "enumEntryName");
            visitConstantValue(r5, new EnumValue(r10, r11));
        }
    }

    public BinaryClassAnnotationAndConstantLoaderImpl(ModuleDescriptor r5, NotFoundClasses r10, StorageManager r11, KotlinClassFinder r12) {
        Intrinsics.checkNotNullParameter(r5, "module");
        Intrinsics.checkNotNullParameter(r10, "notFoundClasses");
        Intrinsics.checkNotNullParameter(r11, "storageManager");
        Intrinsics.checkNotNullParameter(r12, "kotlinClassFinder");
        super(r11, r12);
        this.module = r5;
        this.notFoundClasses = r10;
        this.annotationDeserializer = new AnnotationDeserializer(r5, r10);
        this.jvmMetadataVersion = JvmMetadataVersion.INSTANCE;
    }

    public static final /* synthetic */ ConstantValue access$createConstant(BinaryClassAnnotationAndConstantLoaderImpl r5, Name r10, Object r11) {
        return r5.createConstant(r10, r11);
    }

    private final ConstantValue<?> createConstant(Name r5, Object r10) {
        ConstantValue<?> r11 = ConstantValueFactory.INSTANCE.createConstantValue(r10, this.module);
        if (r11 == null) goto L5;
        return r11;
    L5:
        return ErrorValue.Companion.create("Unsupported annotation argument: " + r5);
    }

    private final ClassDescriptor resolveClass(ClassId r5) {
        return FindClassInModuleKt.findNonGenericClassAcrossDependencies(this.module, r5, this.notFoundClasses);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationLoader
    public JvmMetadataVersion getJvmMetadataVersion() {
        return this.jvmMetadataVersion;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationLoader
    public KotlinJvmBinaryClass.AnnotationArgumentVisitor loadAnnotation(final ClassId r10, final SourceElement r11, final List<AnnotationDescriptor> r12) {
        Intrinsics.checkNotNullParameter(r10, "annotationClassId");
        Intrinsics.checkNotNullParameter(r11, "source");
        Intrinsics.checkNotNullParameter(r12, "result");
        final ClassDescriptor r5 = resolveClass(r10);
        return new AnonymousClass1(this, r5, r10, r12, r11);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationAndConstantLoader
    public /* bridge */ /* synthetic */ ConstantValue<?> loadConstant(String r5, Object r10) {
        return loadConstant2(r5, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationLoader
    public /* bridge */ /* synthetic */ Object loadTypeAnnotation(ProtoBuf.Annotation r5, NameResolver r10) {
        return loadTypeAnnotation(r5, r10);
    }

    public void setJvmMetadataVersion(JvmMetadataVersion r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.jvmMetadataVersion = r5;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationAndConstantLoader
    public /* bridge */ /* synthetic */ ConstantValue<?> transformToUnsignedConstant(ConstantValue<?> r5) {
        return transformToUnsignedConstant2(r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationAndConstantLoader
    /* JADX INFO: renamed from: loadConstant, reason: avoid collision after fix types in other method */
    public ConstantValue<?> loadConstant2(String r5, Object r10) {
        Intrinsics.checkNotNullParameter(r5, "desc");
        Intrinsics.checkNotNullParameter(r10, "initializer");
        if (StringsKt.g("ZBCS", r5) == false) goto L30;
        int r11 = ((Integer) r10).intValue();
        int r12 = r5.hashCode();
        if (r12 == 66) goto L25;
        if (r12 == 67) goto L22;
        if (r12 == 83) goto L19;
        if (r12 != 90) goto L28;
        if (r5.equals("Z") == false) goto L28;
        if (r11 == 0) goto L16;
        boolean r13 = true;
    L17:
        r10 = Boolean.valueOf(r13);
        goto L30
    L16:
        r13 = false;
    L28:
        throw new AssertionError(r5);
    L19:
        if (r5.equals(ExifInterface.LATITUDE_SOUTH) == false) goto L28;
        r10 = Short.valueOf((short) r11);
        goto L30
    L22:
        if (r5.equals("C") == false) goto L28;
        r10 = Character.valueOf((char) r11);
        goto L30
    L25:
        if (r5.equals("B") == false) goto L28;
        r10 = Byte.valueOf((byte) r11);
    L30:
        return ConstantValueFactory.INSTANCE.createConstantValue(r10, this.module);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationLoader
    public AnnotationDescriptor loadTypeAnnotation(ProtoBuf.Annotation r5, NameResolver r10) {
        Intrinsics.checkNotNullParameter(r5, "proto");
        Intrinsics.checkNotNullParameter(r10, "nameResolver");
        return this.annotationDeserializer.deserializeAnnotation(r5, r10);
    }

    /* JADX INFO: renamed from: transformToUnsignedConstant, reason: avoid collision after fix types in other method */
    public ConstantValue<?> transformToUnsignedConstant2(ConstantValue<?> r5) {
        Intrinsics.checkNotNullParameter(r5, "constant");
        if ((r5 instanceof ByteValue) == false) goto L7;
        ConstantValue<?> r10 = new UByteValue(((ByteValue) r5).getValue().byteValue());
    L15:
        return r10;
    L7:
        if ((r5 instanceof ShortValue) == false) goto L10;
        r10 = new UShortValue(((ShortValue) r5).getValue().shortValue());
        goto L15
    L10:
        if ((r5 instanceof IntValue) == false) goto L13;
        r10 = new UIntValue(((IntValue) r5).getValue().intValue());
        goto L15
    L13:
        if ((r5 instanceof LongValue) == false) goto L16;
        r10 = new ULongValue(((LongValue) r5).getValue().longValue());
        goto L15
    L16:
        return r5;
    }
}
