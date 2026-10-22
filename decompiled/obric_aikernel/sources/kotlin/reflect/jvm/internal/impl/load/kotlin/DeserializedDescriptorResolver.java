package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.Set;
import kotlin.Pair;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMetadataVersion;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmNameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassData;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.IncompatibleVersionErrorData;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerAbiStability;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPackageMemberScope;

/* JADX INFO: loaded from: classes3.dex */
public final class DeserializedDescriptorResolver {
    public static final Companion Companion = null;
    private static final JvmMetadataVersion KOTLIN_1_1_EAP_METADATA_VERSION = null;
    private static final JvmMetadataVersion KOTLIN_1_3_M1_METADATA_VERSION = null;
    private static final JvmMetadataVersion KOTLIN_1_3_RC_METADATA_VERSION = null;
    private static final Set<KotlinClassHeader.Kind> KOTLIN_CLASS = null;
    private static final Set<KotlinClassHeader.Kind> KOTLIN_FILE_FACADE_OR_MULTIFILE_CLASS_PART = null;
    public DeserializationComponents components;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }

        public final JvmMetadataVersion getKOTLIN_1_3_RC_METADATA_VERSION$descriptors_jvm() {
            return DeserializedDescriptorResolver.access$getKOTLIN_1_3_RC_METADATA_VERSION$cp();
        }
    }

    static {
        Companion = new Companion(null);
        KOTLIN_CLASS = SetsKt.setOf(KotlinClassHeader.Kind.CLASS);
        KOTLIN_FILE_FACADE_OR_MULTIFILE_CLASS_PART = SetsKt.setOf(new KotlinClassHeader.Kind[]{KotlinClassHeader.Kind.FILE_FACADE, KotlinClassHeader.Kind.MULTIFILE_CLASS_PART});
        KOTLIN_1_1_EAP_METADATA_VERSION = new JvmMetadataVersion(new int[]{1, 1, 2});
        KOTLIN_1_3_M1_METADATA_VERSION = new JvmMetadataVersion(new int[]{1, 1, 11});
        KOTLIN_1_3_RC_METADATA_VERSION = new JvmMetadataVersion(new int[]{1, 1, 13});
    }

    public DeserializedDescriptorResolver() {
    }

    public static final /* synthetic */ JvmMetadataVersion access$getKOTLIN_1_3_RC_METADATA_VERSION$cp() {
        return KOTLIN_1_3_RC_METADATA_VERSION;
    }

    private final DeserializedContainerAbiStability getAbiStability(KotlinJvmBinaryClass r10) {
        if (getComponents().getConfiguration().getAllowUnstableDependencies() == false) goto L6;
    L12:
        return DeserializedContainerAbiStability.STABLE;
    L6:
        if (r10.getClassHeader().isUnstableFirBinary() == false) goto L9;
        return DeserializedContainerAbiStability.FIR_UNSTABLE;
    L9:
        if (r10.getClassHeader().isUnstableJvmIrBinary() == false) goto L12;
        return DeserializedContainerAbiStability.IR_UNSTABLE;
    }

    private final IncompatibleVersionErrorData<JvmMetadataVersion> getIncompatibility(KotlinJvmBinaryClass r10) {
        if (getSkipMetadataVersionCheck() == false) goto L5;
        return null;
    L5:
        if (r10.getClassHeader().getMetadataVersion().isCompatible() == false) goto L8;
        return null;
    L8:
        return new IncompatibleVersionErrorData(r10.getClassHeader().getMetadataVersion(), JvmMetadataVersion.INSTANCE, r10.getLocation(), r10.getClassId());
    }

    private final boolean getSkipMetadataVersionCheck() {
        return getComponents().getConfiguration().getSkipMetadataVersionCheck();
    }

    private final boolean isCompiledWith13M1(KotlinJvmBinaryClass r10) {
        if (getComponents().getConfiguration().getSkipPrereleaseCheck() == false) goto L5;
    L9:
        return false;
    L5:
        if (r10.getClassHeader().isPreRelease() == false) goto L9;
        if (Intrinsics.areEqual(r10.getClassHeader().getMetadataVersion(), KOTLIN_1_3_M1_METADATA_VERSION) == false) goto L9;
        return true;
    }

    private final boolean isPreReleaseInvisible(KotlinJvmBinaryClass r10) {
        if (getComponents().getConfiguration().getReportErrorsOnPreReleaseDependencies() == false) goto L9;
        if (r10.getClassHeader().isPreRelease() == false) goto L7;
    L10:
        return true;
    L7:
        if (Intrinsics.areEqual(r10.getClassHeader().getMetadataVersion(), KOTLIN_1_1_EAP_METADATA_VERSION) == true) goto L10;
    L9:
        if (isCompiledWith13M1(r10) == true) goto L10;
        return false;
    }

    private final String[] readData(KotlinJvmBinaryClass r10, Set<? extends KotlinClassHeader.Kind> r11) {
        KotlinClassHeader r12 = r10.getClassHeader();
        String[] r13 = r12.getData();
        if (r13 != null) goto L6;
        r13 = r12.getIncompatibleData();
    L6:
        if (r13 == null) goto L11;
        if (r11.contains(r12.getKind()) == false) goto L11;
        return r13;
    L11:
        return null;
    }

    public final MemberScope createKotlinPackagePartScope(PackageFragmentDescriptor r13, KotlinJvmBinaryClass r14) {
        Intrinsics.checkNotNullParameter(r13, "descriptor");
        Intrinsics.checkNotNullParameter(r14, "kotlinClass");
        String[] r10 = readData(r14, KOTLIN_FILE_FACADE_OR_MULTIFILE_CLASS_PART);
        if (r10 != null) goto L5;
        return null;
    L5:
        String[] r11 = r14.getClassHeader().getStrings();
        if (r11 != null) goto L25;
        return null;
    L25:
        Pair<JvmNameResolver, ProtoBuf.Package> r12 = JvmProtoBufUtil.readPackageDataFrom(r10, r11);     // Catch: Throwable -> L10 InvalidProtocolBufferException -> L12
    L20:
        if (r12 != null) goto L22;
        return null;
    L22:
        JvmNameResolver r15 = r12.component1();
        ProtoBuf.Package r16 = r12.component2();
        JvmPackagePartSource r17 = new JvmPackagePartSource(r14, r16, r15, getIncompatibility(r14), isPreReleaseInvisible(r14), getAbiStability(r14));
        return new DeserializedPackageMemberScope(r13, r16, r15, r14.getClassHeader().getMetadataVersion(), r17, getComponents(), "scope for " + r17 + " in " + r13, AnonymousClass2.INSTANCE);
    L12:
        e = move-exception;
        throw new IllegalStateException("Could not read data from " + r14.getLocation(), e);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        if (getSkipMetadataVersionCheck() == false) goto L18;
    L24:
        throw th;
    L18:
        if (r14.getClassHeader().getMetadataVersion().isCompatible() == true) goto L24;
        r12 = null;
        goto L20
    }

    public final DeserializationComponents getComponents() {
        DeserializationComponents r10 = this.components;
        if (r10 == null) goto L5;
        return r10;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("components");
        return null;
    }

    public final ClassData readClassData$descriptors_jvm(KotlinJvmBinaryClass r10) {
        Intrinsics.checkNotNullParameter(r10, "kotlinClass");
        String[] r11 = readData(r10, KOTLIN_CLASS);
        if (r11 != null) goto L5;
        return null;
    L5:
        String[] r12 = r10.getClassHeader().getStrings();
        if (r12 != null) goto L25;
        return null;
    L25:
        Pair<JvmNameResolver, ProtoBuf.Class> r13 = JvmProtoBufUtil.readClassDataFrom(r11, r12);     // Catch: Throwable -> L10 InvalidProtocolBufferException -> L12
    L20:
        if (r13 != null) goto L23;
        return null;
    L23:
        return new ClassData(r13.component1(), r13.component2(), r10.getClassHeader().getMetadataVersion(), new KotlinJvmBinarySourceElement(r10, getIncompatibility(r10), isPreReleaseInvisible(r10), getAbiStability(r10)));
    L12:
        e = move-exception;
        throw new IllegalStateException("Could not read data from " + r10.getLocation(), e);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        if (getSkipMetadataVersionCheck() == false) goto L18;
    L24:
        throw th;
    L18:
        if (r10.getClassHeader().getMetadataVersion().isCompatible() == true) goto L24;
        r13 = null;
        goto L20
    }

    public final ClassDescriptor resolveClass(KotlinJvmBinaryClass r10) {
        Intrinsics.checkNotNullParameter(r10, "kotlinClass");
        ClassData r11 = readClassData$descriptors_jvm(r10);
        if (r11 != null) goto L7;
        return null;
    L7:
        return getComponents().getClassDeserializer().deserializeClass(r10.getClassId(), r11);
    }

    public final void setComponents(DeserializationComponentsForJava r10) {
        Intrinsics.checkNotNullParameter(r10, "components");
        setComponents(r10.getComponents());
    }

    public final void setComponents(DeserializationComponents r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.components = r10;
    }
}
