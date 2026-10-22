package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.Set;
import kotlin.Pair;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
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
import kotlin.reflect.jvm.internal.impl.utils.DeserializationHelpersKt;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nDeserializedDescriptorResolver.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DeserializedDescriptorResolver.kt\norg/jetbrains/kotlin/load/kotlin/DeserializedDescriptorResolver\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,154:1\n126#1,14:155\n126#1,14:169\n1#2:183\n*S KotlinDebug\n*F\n+ 1 DeserializedDescriptorResolver.kt\norg/jetbrains/kotlin/load/kotlin/DeserializedDescriptorResolver\n*L\n56#1:155,14\n68#1:169,14\n*E\n"})
public final class DeserializedDescriptorResolver {
    public static final Companion Companion = null;
    private static final JvmMetadataVersion KOTLIN_1_1_EAP_METADATA_VERSION = null;
    private static final JvmMetadataVersion KOTLIN_1_3_M1_METADATA_VERSION = null;
    private static final JvmMetadataVersion KOTLIN_1_3_RC_METADATA_VERSION = null;
    private static final Set<KotlinClassHeader.Kind> KOTLIN_CLASS = null;
    private static final Set<KotlinClassHeader.Kind> KOTLIN_FILE_FACADE_OR_MULTIFILE_CLASS_PART = null;
    public DeserializationComponents components;

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public final JvmMetadataVersion getKOTLIN_1_3_RC_METADATA_VERSION$descriptors_jvm() {
            return DeserializedDescriptorResolver.access$getKOTLIN_1_3_RC_METADATA_VERSION$cp();
        }

        private Companion() {
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

    private final DeserializedContainerAbiStability getAbiStability(KotlinJvmBinaryClass r5) {
        if (getComponents().getConfiguration().getAllowUnstableDependencies() == false) goto L6;
        return DeserializedContainerAbiStability.STABLE;
    L6:
        if (r5.getClassHeader().isUnstableFirBinary() == false) goto L9;
        return DeserializedContainerAbiStability.FIR_UNSTABLE;
    L9:
        if (r5.getClassHeader().isUnstableJvmIrBinary() == false) goto L12;
        return DeserializedContainerAbiStability.IR_UNSTABLE;
    L12:
        return DeserializedContainerAbiStability.STABLE;
    }

    private final IncompatibleVersionErrorData<JvmMetadataVersion> getIncompatibility(KotlinJvmBinaryClass r10) {
        if (getSkipMetadataVersionCheck() == false) goto L5;
        return null;
    L5:
        if (r10.getClassHeader().getMetadataVersion().isCompatible(getOwnMetadataVersion()) == false) goto L8;
        return null;
    L8:
        return new IncompatibleVersionErrorData(r10.getClassHeader().getMetadataVersion(), JvmMetadataVersion.INSTANCE, getOwnMetadataVersion(), getOwnMetadataVersion().lastSupportedVersionWithThisLanguageVersion(r10.getClassHeader().getMetadataVersion().isStrictSemantics()), r10.getLocation(), r10.getClassId());
    }

    private final JvmMetadataVersion getOwnMetadataVersion() {
        return DeserializationHelpersKt.jvmMetadataVersionOrDefault(getComponents().getConfiguration());
    }

    private final boolean getSkipMetadataVersionCheck() {
        return getComponents().getConfiguration().getSkipMetadataVersionCheck();
    }

    private final boolean isCompiledWith13M1(KotlinJvmBinaryClass r5) {
        if (getComponents().getConfiguration().getSkipPrereleaseCheck() == false) goto L5;
    L9:
        return false;
    L5:
        if (r5.getClassHeader().isPreRelease() == false) goto L9;
        if (Intrinsics.areEqual(r5.getClassHeader().getMetadataVersion(), KOTLIN_1_3_M1_METADATA_VERSION) == false) goto L9;
        return true;
    }

    private final boolean isPreReleaseInvisible(KotlinJvmBinaryClass r5) {
        if (getComponents().getConfiguration().getReportErrorsOnPreReleaseDependencies() == false) goto L9;
        if (r5.getClassHeader().isPreRelease() == false) goto L7;
    L10:
        return true;
    L7:
        if (Intrinsics.areEqual(r5.getClassHeader().getMetadataVersion(), KOTLIN_1_1_EAP_METADATA_VERSION) == true) goto L10;
    L9:
        if (isCompiledWith13M1(r5) == true) goto L10;
        return false;
    }

    private final String[] readData(KotlinJvmBinaryClass r5, Set<? extends KotlinClassHeader.Kind> r10) {
        KotlinClassHeader r11 = r5.getClassHeader();
        String[] r12 = r11.getData();
        if (r12 != null) goto L6;
        r12 = r11.getIncompatibleData();
    L6:
        if (r12 == null) goto L11;
        if (r10.contains(r11.getKind()) == false) goto L11;
        return r12;
    L11:
        return null;
    }

    public final MemberScope createKotlinPackagePartScope(PackageFragmentDescriptor r13, KotlinJvmBinaryClass r14) {
        Intrinsics.checkNotNullParameter(r13, "descriptor");
        Intrinsics.checkNotNullParameter(r14, "kotlinClass");
        String[] r5 = readData(r14, KOTLIN_FILE_FACADE_OR_MULTIFILE_CLASS_PART);
        if (r5 != null) goto L5;
        return null;
    L5:
        String[] r10 = r14.getClassHeader().getStrings();
        if (r10 != null) goto L25;
        return null;
    L25:
        Pair<JvmNameResolver, ProtoBuf.Package> r11 = JvmProtoBufUtil.readPackageDataFrom(r5, r10);     // Catch: Throwable -> L10 InvalidProtocolBufferException -> L12
    L20:
        if (r11 != null) goto L22;
        return null;
    L22:
        JvmNameResolver r12 = r11.component1();
        ProtoBuf.Package r15 = r11.component2();
        JvmPackagePartSource r16 = new JvmPackagePartSource(r14, r15, r12, getIncompatibility(r14), isPreReleaseInvisible(r14), getAbiStability(r14));
        return new DeserializedPackageMemberScope(r13, r15, r12, r14.getClassHeader().getMetadataVersion(), r16, getComponents(), "scope for " + r16 + " in " + r13, AnonymousClass2.INSTANCE);
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
        r11 = null;
        goto L20
    }

    public final DeserializationComponents getComponents() {
        DeserializationComponents r5 = this.components;
        if (r5 == null) goto L5;
        return r5;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("components");
        return null;
    }

    public final ClassData readClassData$descriptors_jvm(KotlinJvmBinaryClass r10) {
        Intrinsics.checkNotNullParameter(r10, "kotlinClass");
        String[] r5 = readData(r10, KOTLIN_CLASS);
        if (r5 != null) goto L5;
        return null;
    L5:
        String[] r11 = r10.getClassHeader().getStrings();
        if (r11 != null) goto L26;
        return null;
    L26:
        Pair<JvmNameResolver, ProtoBuf.Class> r12 = JvmProtoBufUtil.readClassDataFrom(r5, r11);     // Catch: Throwable -> L10 InvalidProtocolBufferException -> L12
    L20:
        if (r12 != null) goto L23;
        return null;
    L23:
        return new ClassData(r12.component1(), r12.component2(), r10.getClassHeader().getMetadataVersion(), new KotlinJvmBinarySourceElement(r10, getIncompatibility(r10), isPreReleaseInvisible(r10), getAbiStability(r10)));
    L12:
        e = move-exception;
        throw new IllegalStateException("Could not read data from " + r10.getLocation(), e);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        if (getSkipMetadataVersionCheck() == false) goto L18;
    L24:
        throw th;
    L18:
        if (r10.getClassHeader().getMetadataVersion().isCompatible(getOwnMetadataVersion()) == true) goto L24;
        r12 = null;
        goto L20
    }

    public final ClassDescriptor resolveClass(KotlinJvmBinaryClass r5) {
        Intrinsics.checkNotNullParameter(r5, "kotlinClass");
        ClassData r10 = readClassData$descriptors_jvm(r5);
        if (r10 != null) goto L7;
        return null;
    L7:
        return getComponents().getClassDeserializer().deserializeClass(r5.getClassId(), r10);
    }

    public final void setComponents(DeserializationComponents r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.components = r5;
    }

    public final void setComponents(DeserializationComponentsForJava r5) {
        Intrinsics.checkNotNullParameter(r5, "components");
        setComponents(r5.getComponents());
    }
}
