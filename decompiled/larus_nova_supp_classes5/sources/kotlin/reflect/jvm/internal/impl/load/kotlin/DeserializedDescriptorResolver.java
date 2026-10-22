package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.Collection;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package;
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
import kotlin.reflect.jvm.internal.impl.utils.DeserializationHelpersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
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

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final JvmMetadataVersion getKOTLIN_1_3_RC_METADATA_VERSION$descriptors_jvm() {
            return DeserializedDescriptorResolver.access$getKOTLIN_1_3_RC_METADATA_VERSION$cp();
        }
    }

    public DeserializedDescriptorResolver() {
    }

    public static /* synthetic */ Collection accessor$DeserializedDescriptorResolver$lambda0() {
        return createKotlinPackagePartScope$lambda$2();
    }

    static {
        Companion = new Companion(null);
        KOTLIN_CLASS = SetsKt.setOf(KotlinClassHeader.Kind.CLASS);
        KOTLIN_FILE_FACADE_OR_MULTIFILE_CLASS_PART = SetsKt.setOf(new KotlinClassHeader.Kind[]{KotlinClassHeader.Kind.FILE_FACADE, KotlinClassHeader.Kind.MULTIFILE_CLASS_PART});
        KOTLIN_1_1_EAP_METADATA_VERSION = new JvmMetadataVersion(new int[]{1, 1, 2});
        KOTLIN_1_3_M1_METADATA_VERSION = new JvmMetadataVersion(new int[]{1, 1, 11});
        KOTLIN_1_3_RC_METADATA_VERSION = new JvmMetadataVersion(new int[]{1, 1, 13});
    }

    public final DeserializationComponents getComponents() {
        DeserializationComponents r0 = this.components;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("components");
        return null;
    }

    private static final Collection createKotlinPackagePartScope$lambda$2() {
        return CollectionsKt.emptyList();
    }

    private final JvmMetadataVersion getOwnMetadataVersion() {
        return DeserializationHelpersKt.jvmMetadataVersionOrDefault(getComponents().getConfiguration());
    }

    private final boolean getSkipMetadataVersionCheck() {
        return getComponents().getConfiguration().getSkipMetadataVersionCheck();
    }

    public static final /* synthetic */ JvmMetadataVersion access$getKOTLIN_1_3_RC_METADATA_VERSION$cp() {
        return KOTLIN_1_3_RC_METADATA_VERSION;
    }

    private final DeserializedContainerAbiStability getAbiStability(KotlinJvmBinaryClass r2) {
        if (getComponents().getConfiguration().getAllowUnstableDependencies() == false) goto L6;
        return DeserializedContainerAbiStability.STABLE;
    L6:
        if (r2.getClassHeader().isUnstableJvmIrBinary() == false) goto L9;
        return DeserializedContainerAbiStability.UNSTABLE;
    L9:
        return DeserializedContainerAbiStability.STABLE;
    }

    private final IncompatibleVersionErrorData<JvmMetadataVersion> getIncompatibility(KotlinJvmBinaryClass r9) {
        if (getSkipMetadataVersionCheck() == false) goto L5;
        return null;
    L5:
        if (r9.getClassHeader().getMetadataVersion().isCompatible(getOwnMetadataVersion()) == false) goto L8;
        return null;
    L8:
        return new IncompatibleVersionErrorData(r9.getClassHeader().getMetadataVersion(), JvmMetadataVersion.INSTANCE, getOwnMetadataVersion(), getOwnMetadataVersion().lastSupportedVersionWithThisLanguageVersion(r9.getClassHeader().getMetadataVersion().isStrictSemantics()), r9.getLocation(), r9.getClassId());
    }

    private final boolean isCompiledWith13M1(KotlinJvmBinaryClass r2) {
        if (getComponents().getConfiguration().getSkipPrereleaseCheck() == false) goto L5;
    L9:
        return false;
    L5:
        if (r2.getClassHeader().isPreRelease() == false) goto L9;
        if (Intrinsics.areEqual(r2.getClassHeader().getMetadataVersion(), KOTLIN_1_3_M1_METADATA_VERSION) == false) goto L9;
        return true;
    }

    private final boolean isPreReleaseInvisible(KotlinJvmBinaryClass r3) {
        if (getComponents().getConfiguration().getReportErrorsOnPreReleaseDependencies() == false) goto L9;
        if (r3.getClassHeader().isPreRelease() == false) goto L7;
    L10:
        return true;
    L7:
        if (Intrinsics.areEqual(r3.getClassHeader().getMetadataVersion(), KOTLIN_1_1_EAP_METADATA_VERSION) == true) goto L10;
    L9:
        if (isCompiledWith13M1(r3) == true) goto L10;
        return false;
    }

    public final ClassData readClassData$descriptors_jvm(KotlinJvmBinaryClass r7) {
        Intrinsics.checkNotNullParameter(r7, "kotlinClass");
        String[] r1 = readData(r7, KOTLIN_CLASS);
        if (r1 != null) goto L5;
        return null;
    L5:
        String[] r3 = r7.getClassHeader().getStrings();
        if (r3 != null) goto L26;
        return null;
    L26:
        Pair<JvmNameResolver, ProtoBuf$Class> r0 = JvmProtoBufUtil.readClassDataFrom(r1, r3);     // Catch: Throwable -> L10 InvalidProtocolBufferException -> L12
    L20:
        if (r0 != null) goto L23;
        return null;
    L23:
        return new ClassData((JvmNameResolver) r0.component1(), (ProtoBuf$Class) r0.component2(), r7.getClassHeader().getMetadataVersion(), new KotlinJvmBinarySourceElement(r7, getIncompatibility(r7), isPreReleaseInvisible(r7), getAbiStability(r7)));
    L12:
        e = move-exception;
        throw new IllegalStateException("Could not read data from " + r7.getLocation(), e);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        if (getSkipMetadataVersionCheck() == false) goto L18;
    L24:
        throw th;
    L18:
        if (r7.getClassHeader().getMetadataVersion().isCompatible(getOwnMetadataVersion()) == true) goto L24;
        r0 = null;
        goto L20
    }

    public final ClassDescriptor resolveClass(KotlinJvmBinaryClass r3) {
        Intrinsics.checkNotNullParameter(r3, "kotlinClass");
        ClassData r0 = readClassData$descriptors_jvm(r3);
        if (r0 != null) goto L7;
        return null;
    L7:
        return getComponents().getClassDeserializer().deserializeClass(r3.getClassId(), r0);
    }

    public final void setComponents(DeserializationComponentsForJava r2) {
        Intrinsics.checkNotNullParameter(r2, "components");
        setComponents(r2.getComponents());
    }

    public final void setComponents(DeserializationComponents r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.components = r2;
    }

    private final String[] readData(KotlinJvmBinaryClass r3, Set<? extends KotlinClassHeader.Kind> r4) {
        KotlinClassHeader r5 = r3.getClassHeader();
        String[] r0 = r5.getData();
        if (r0 != null) goto L6;
        r0 = r5.getIncompatibleData();
    L6:
        if (r0 == null) goto L11;
        if (r4.contains(r5.getKind()) == false) goto L11;
        return r0;
    L11:
        return null;
    }

    public final MemberScope createKotlinPackagePartScope(PackageFragmentDescriptor r13, KotlinJvmBinaryClass r14) {
        Intrinsics.checkNotNullParameter(r13, "descriptor");
        Intrinsics.checkNotNullParameter(r14, "kotlinClass");
        String[] r1 = readData(r14, KOTLIN_FILE_FACADE_OR_MULTIFILE_CLASS_PART);
        if (r1 != null) goto L5;
        return null;
    L5:
        String[] r3 = r14.getClassHeader().getStrings();
        if (r3 != null) goto L25;
        return null;
    L25:
        Pair<JvmNameResolver, ProtoBuf$Package> r0 = JvmProtoBufUtil.readPackageDataFrom(r1, r3);     // Catch: Throwable -> L10 InvalidProtocolBufferException -> L12
    L20:
        if (r0 != null) goto L22;
        return null;
    L22:
        JvmNameResolver r2 = (JvmNameResolver) r0.component1();
        ProtoBuf$Package r4 = (ProtoBuf$Package) r0.component2();
        JvmPackagePartSource r9 = new JvmPackagePartSource(r14, r4, r2, getIncompatibility(r14), isPreReleaseInvisible(r14), getAbiStability(r14));
        return new DeserializedPackageMemberScope(r13, r4, r2, r14.getClassHeader().getMetadataVersion(), r9, getComponents(), "scope for " + r9 + " in " + r13, DeserializedDescriptorResolver$.Lambda.0.INSTANCE);
    L12:
        e = move-exception;
        throw new IllegalStateException("Could not read data from " + r14.getLocation(), e);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        if (getSkipMetadataVersionCheck() == false) goto L18;
    L24:
        throw th;
    L18:
        if (r14.getClassHeader().getMetadataVersion().isCompatible(getOwnMetadataVersion()) == true) goto L24;
        r0 = null;
        goto L20
    }
}
