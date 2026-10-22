package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMetadataVersion;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ByteValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValueFactory;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ErrorValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.IntValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.LongValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ShortValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.UByteValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.UIntValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ULongValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.UShortValue;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationDeserializer;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class BinaryClassAnnotationAndConstantLoaderImpl extends AbstractBinaryClassAnnotationAndConstantLoader<AnnotationDescriptor, ConstantValue<?>> {
    private final AnnotationDeserializer annotationDeserializer;
    private JvmMetadataVersion jvmMetadataVersion;
    private final ModuleDescriptor module;
    private final NotFoundClasses notFoundClasses;

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationLoader
    public JvmMetadataVersion getJvmMetadataVersion() {
        return this.jvmMetadataVersion;
    }

    private final ClassDescriptor resolveClass(ClassId r3) {
        return FindClassInModuleKt.findNonGenericClassAcrossDependencies(this.module, r3, this.notFoundClasses);
    }

    public void setJvmMetadataVersion(JvmMetadataVersion r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.jvmMetadataVersion = r2;
    }

    /* JADX INFO: renamed from: transformToUnsignedConstant, reason: avoid collision after fix types in other method */
    public ConstantValue<?> transformToUnsignedConstant2(ConstantValue<?> r4) {
        Intrinsics.checkNotNullParameter(r4, "constant");
        if ((r4 instanceof ByteValue) == false) goto L7;
        UByteValue r0 = new UByteValue(((Number) ((ByteValue) r4).getValue()).byteValue());
    L15:
        return r0;
    L7:
        if ((r4 instanceof ShortValue) == false) goto L10;
        r0 = new UShortValue(((Number) ((ShortValue) r4).getValue()).shortValue());
        goto L15
    L10:
        if ((r4 instanceof IntValue) == false) goto L13;
        r0 = new UIntValue(((Number) ((IntValue) r4).getValue()).intValue());
        goto L15
    L13:
        if ((r4 instanceof LongValue) == false) goto L16;
        r0 = new ULongValue(((Number) ((LongValue) r4).getValue()).longValue());
        goto L15
    L16:
        return r4;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationAndConstantLoader
    public /* bridge */ /* synthetic */ ConstantValue<?> transformToUnsignedConstant(ConstantValue<?> r1) {
        return transformToUnsignedConstant2(r1);
    }

    private final ConstantValue<?> createConstant(Name r3, Object r4) {
        ConstantValue<?> r5 = ConstantValueFactory.INSTANCE.createConstantValue(r4, this.module);
        if (r5 == null) goto L5;
        return r5;
    L5:
        return ErrorValue.Companion.create("Unsupported annotation argument: " + r3);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationLoader, kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public AnnotationDescriptor loadAnnotation(ProtoBuf$Annotation r2, NameResolver r3) {
        Intrinsics.checkNotNullParameter(r2, "proto");
        Intrinsics.checkNotNullParameter(r3, "nameResolver");
        return this.annotationDeserializer.deserializeAnnotation(r2, r3);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationAndConstantLoader
    /* JADX INFO: renamed from: loadConstant, reason: avoid collision after fix types in other method */
    public ConstantValue<?> loadConstant2(String r5, Object r6) {
        Intrinsics.checkNotNullParameter(r5, "desc");
        Intrinsics.checkNotNullParameter(r6, "initializer");
        boolean r3 = false;
        if (StringsKt.contains$default("ZBCS", r5, false, 2, null) == false) goto L29;
        int r7 = ((Integer) r6).intValue();
        int r0 = r5.hashCode();
        if (r0 == 66) goto L24;
        if (r0 == 67) goto L21;
        if (r0 == 83) goto L18;
        if (r0 != 90) goto L27;
        if (r5.equals("Z") == false) goto L27;
        if (r7 == 0) goto L16;
        r3 = true;
    L16:
        r6 = Boolean.valueOf(r3);
    L27:
        throw new AssertionError(r5);
    L18:
        if (r5.equals("S") == false) goto L27;
        r6 = Short.valueOf((short) r7);
        goto L29
    L21:
        if (r5.equals("C") == false) goto L27;
        r6 = Character.valueOf((char) r7);
        goto L29
    L24:
        if (r5.equals("B") == false) goto L27;
        r6 = Byte.valueOf((byte) r7);
    L29:
        return ConstantValueFactory.INSTANCE.createConstantValue(r6, this.module);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationLoader, kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public /* bridge */ /* synthetic */ Object loadAnnotation(ProtoBuf$Annotation r1, NameResolver r2) {
        return loadAnnotation(r1, r2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationAndConstantLoader
    public /* bridge */ /* synthetic */ ConstantValue<?> loadConstant(String r1, Object r2) {
        return loadConstant2(r1, r2);
    }

    public static final /* synthetic */ ConstantValue access$createConstant(BinaryClassAnnotationAndConstantLoaderImpl r0, Name r1, Object r2) {
        return r0.createConstant(r1, r2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationLoader
    public KotlinJvmBinaryClass.AnnotationArgumentVisitor loadAnnotation(ClassId r8, SourceElement r9, List<AnnotationDescriptor> r10) {
        Intrinsics.checkNotNullParameter(r8, "annotationClassId");
        Intrinsics.checkNotNullParameter(r9, "source");
        Intrinsics.checkNotNullParameter(r10, "result");
        return new loadAnnotation.1(this, resolveClass(r8), r8, r10, r9);
    }

    public BinaryClassAnnotationAndConstantLoaderImpl(ModuleDescriptor r2, NotFoundClasses r3, StorageManager r4, KotlinClassFinder r5) {
        Intrinsics.checkNotNullParameter(r2, "module");
        Intrinsics.checkNotNullParameter(r3, "notFoundClasses");
        Intrinsics.checkNotNullParameter(r4, "storageManager");
        Intrinsics.checkNotNullParameter(r5, "kotlinClassFinder");
        super(r4, r5);
        this.module = r2;
        this.notFoundClasses = r3;
        this.annotationDeserializer = new AnnotationDeserializer(r2, r3);
        this.jvmMetadataVersion = JvmMetadataVersion.INSTANCE;
    }
}
