package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceFile;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoBufUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMetadataVersion;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.IncompatibleVersionErrorData;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerAbiStability;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class JvmPackagePartSource implements DeserializedContainerSource {
    private final DeserializedContainerAbiStability abiStability;
    private final JvmClassName className;
    private final JvmClassName facadeClassName;
    private final IncompatibleVersionErrorData<JvmMetadataVersion> incompatibility;
    private final boolean isPreReleaseInvisible;
    private final KotlinJvmBinaryClass knownJvmBinaryClass;
    private final String moduleName;

    public JvmPackagePartSource(KotlinJvmBinaryClass r11, ProtoBuf.Package r12, NameResolver r13, IncompatibleVersionErrorData<JvmMetadataVersion> r14, boolean r15, DeserializedContainerAbiStability r16) {
        Intrinsics.checkNotNullParameter(r11, "kotlinClass");
        Intrinsics.checkNotNullParameter(r12, "packageProto");
        Intrinsics.checkNotNullParameter(r13, "nameResolver");
        Intrinsics.checkNotNullParameter(r16, "abiStability");
        JvmClassName r10 = JvmClassName.byClassId(r11.getClassId());
        Intrinsics.checkNotNullExpressionValue(r10, "byClassId(kotlinClass.classId)");
        String r17 = r11.getClassHeader().getMultifileClassName();
        JvmClassName r18 = null;
        if (r17 != null) goto L5;
    L10:
        this(r10, r18, r12, r13, r14, r15, r16, r11);
        return;
    L5:
        if (r17.length() <= 0) goto L7;
        boolean r19 = true;
    L8:
        if (r19 == false) goto L10;
        r18 = JvmClassName.byInternalName(r17);
        goto L10
    L7:
        r19 = false;
        goto L8
    }

    public JvmPackagePartSource(JvmClassName r10, JvmClassName r11, ProtoBuf.Package r12, NameResolver r13, IncompatibleVersionErrorData<JvmMetadataVersion> r14, boolean r15, DeserializedContainerAbiStability r16, KotlinJvmBinaryClass r17) {
        Intrinsics.checkNotNullParameter(r10, "className");
        Intrinsics.checkNotNullParameter(r12, "packageProto");
        Intrinsics.checkNotNullParameter(r13, "nameResolver");
        Intrinsics.checkNotNullParameter(r16, "abiStability");
        this.className = r10;
        this.facadeClassName = r11;
        this.incompatibility = r14;
        this.isPreReleaseInvisible = r15;
        this.abiStability = r16;
        this.knownJvmBinaryClass = r17;
        GeneratedMessageLite.GeneratedExtension<ProtoBuf.Package, Integer> r18 = JvmProtoBuf.packageModuleName;
        Intrinsics.checkNotNullExpressionValue(r18, "packageModuleName");
        Integer r19 = (Integer) ProtoBufUtilKt.getExtensionOrNull(r12, r18);
        if (r19 == null) goto L6;
        String r20 = r13.getString(r19.intValue());
        if (r20 == null) goto L6;
    L7:
        this.moduleName = r20;
        return;
    L6:
        r20 = "main";
        goto L7
    }

    public final ClassId getClassId() {
        return new ClassId(getClassName().getPackageFqName(), getSimpleName());
    }

    public JvmClassName getClassName() {
        return this.className;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.SourceElement
    public SourceFile getContainingFile() {
        SourceFile r10 = SourceFile.NO_SOURCE_FILE;
        Intrinsics.checkNotNullExpressionValue(r10, "NO_SOURCE_FILE");
        return r10;
    }

    public JvmClassName getFacadeClassName() {
        return this.facadeClassName;
    }

    public final KotlinJvmBinaryClass getKnownJvmBinaryClass() {
        return this.knownJvmBinaryClass;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource
    public String getPresentableString() {
        return "Class '" + getClassId().asSingleFqName().asString() + '\'';
    }

    public final Name getSimpleName() {
        String r10 = getClassName().getInternalName();
        Intrinsics.checkNotNullExpressionValue(r10, "className.internalName");
        Name r11 = Name.identifier(StringsKt.substringAfterLast$default(r10, '/', null, 2, null));
        Intrinsics.checkNotNullExpressionValue(r11, "identifier(className.int….substringAfterLast('/'))");
        return r11;
    }

    public String toString() {
        return JvmPackagePartSource.class.getSimpleName() + ": " + getClassName();
    }
}
