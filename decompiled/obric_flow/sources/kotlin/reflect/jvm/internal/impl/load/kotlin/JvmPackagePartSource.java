package kotlin.reflect.jvm.internal.impl.load.kotlin;

import androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.deserialization.JvmProtoBufUtil;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceFile;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoBufUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMetadataVersion;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.IncompatibleVersionErrorData;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerAbiStability;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nJvmPackagePartSource.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JvmPackagePartSource.kt\norg/jetbrains/kotlin/load/kotlin/JvmPackagePartSource\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,67:1\n1#2:68\n*E\n"})
public final class JvmPackagePartSource implements DeserializedContainerSource {
    private final DeserializedContainerAbiStability abiStability;
    private final JvmClassName className;
    private final JvmClassName facadeClassName;
    private final IncompatibleVersionErrorData<JvmMetadataVersion> incompatibility;
    private final boolean isPreReleaseInvisible;
    private final KotlinJvmBinaryClass knownJvmBinaryClass;
    private final String moduleName;

    public JvmPackagePartSource(JvmClassName r5, JvmClassName r10, ProtoBuf.Package r11, NameResolver r12, IncompatibleVersionErrorData<JvmMetadataVersion> r13, boolean r14, DeserializedContainerAbiStability r15, KotlinJvmBinaryClass r16) {
        Intrinsics.checkNotNullParameter(r5, "className");
        Intrinsics.checkNotNullParameter(r11, "packageProto");
        Intrinsics.checkNotNullParameter(r12, "nameResolver");
        Intrinsics.checkNotNullParameter(r15, "abiStability");
        this.className = r5;
        this.facadeClassName = r10;
        this.incompatibility = r13;
        this.isPreReleaseInvisible = r14;
        this.abiStability = r15;
        this.knownJvmBinaryClass = r16;
        Integer r17 = (Integer) ProtoBufUtilKt.getExtensionOrNull(r11, JvmProtoBuf.packageModuleName);
        if (r17 == null) goto L6;
        String r18 = r12.getString(r17.intValue());
        if (r18 == null) goto L6;
    L7:
        this.moduleName = r18;
        return;
    L6:
        r18 = JvmProtoBufUtil.DEFAULT_MODULE_NAME;
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
        return SourceFile.NO_SOURCE_FILE;
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
        return Name.identifier(StringsKt.U(getClassName().getInternalName(), '/'));
    }

    public String toString() {
        return "JvmPackagePartSource: " + getClassName();
    }

    public JvmPackagePartSource(KotlinJvmBinaryClass r11, ProtoBuf.Package r12, NameResolver r13, IncompatibleVersionErrorData<JvmMetadataVersion> r14, boolean r15, DeserializedContainerAbiStability r16) {
        Intrinsics.checkNotNullParameter(r11, "kotlinClass");
        Intrinsics.checkNotNullParameter(r12, "packageProto");
        Intrinsics.checkNotNullParameter(r13, "nameResolver");
        Intrinsics.checkNotNullParameter(r16, "abiStability");
        JvmClassName r5 = JvmClassName.byClassId(r11.getClassId());
        String r10 = r11.getClassHeader().getMultifileClassName();
        JvmClassName r17 = null;
        if (r10 != null) goto L5;
    L7:
        this(r5, r17, r12, r13, r14, r15, r16, r11);
        return;
    L5:
        if (r10.length() <= 0) goto L7;
        r17 = JvmClassName.byInternalName(r10);
        goto L7
    }
}
