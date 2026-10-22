package com.google.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes3.dex */
public final class RuntimeVersion {
    public static final RuntimeDomain DOMAIN = null;
    public static final int MAJOR = 4;
    private static final int MAX_WARNING_COUNT = 20;
    public static final int MINOR = 31;
    public static final RuntimeDomain OSS_DOMAIN = null;
    public static final int OSS_MAJOR = 4;
    public static final int OSS_MINOR = 31;
    public static final int OSS_PATCH = 1;
    public static final String OSS_SUFFIX = "";
    public static final int PATCH = 1;
    public static final String SUFFIX = "";
    private static final String VERSION_STRING = null;
    private static final Logger logger = null;
    static int majorWarningLoggedCount;
    static int minorWarningLoggedCount;

    public static final class ProtobufRuntimeVersionException extends RuntimeException {
        public ProtobufRuntimeVersionException(String r1) {
            super(r1);
        }
    }

    public static final enum RuntimeDomain extends java.lang.Enum<RuntimeDomain> {
        private static final /* synthetic */ RuntimeDomain[] $VALUES = null;
        public static final RuntimeDomain GOOGLE_INTERNAL = null;
        public static final RuntimeDomain PUBLIC = null;

        private static /* synthetic */ RuntimeDomain[] $values() {
            return new RuntimeDomain[]{GOOGLE_INTERNAL, PUBLIC};
        }

        static {
            GOOGLE_INTERNAL = new RuntimeDomain("GOOGLE_INTERNAL", 0);
            PUBLIC = new RuntimeDomain("PUBLIC", 1);
            $VALUES = $values();
        }

        private RuntimeDomain(String r1, int r2) {
            super(r1, r2);
        }

        public static RuntimeDomain valueOf(String r2) {
            return (RuntimeDomain) ZeusTransformUtils.preCheckCast(java.lang.Enum.valueOf(RuntimeDomain.class, r2), RuntimeDomain.class, "com.obric.memorydata.plugin");
        }

        public static RuntimeDomain[] values() {
            return (RuntimeDomain[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), RuntimeDomain[].class, "com.obric.memorydata.plugin");
        }
    }

    static {
        RuntimeDomain r0 = RuntimeDomain.PUBLIC;
        OSS_DOMAIN = r0;
        DOMAIN = r0;
        majorWarningLoggedCount = 0;
        minorWarningLoggedCount = 0;
        VERSION_STRING = versionString(4, 31, 1, "");
        logger = Logger.getLogger(RuntimeVersion.class.getName());
    }

    private RuntimeVersion() {
    }

    private static boolean checkDisabled() {
        String r0 = System.getenv("TEMPORARILY_DISABLE_PROTOBUF_VERSION_CHECK");
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.equals("true") == false) goto L10;
        return true;
    L10:
        return false;
    }

    public static void validateProtobufGencodeVersion(RuntimeDomain r0, int r1, int r2, int r3, String r4, String r5) {
        validateProtobufGencodeVersionImpl(r0, r1, r2, r3, r4, r5);
    }

    private static void validateProtobufGencodeVersionImpl(RuntimeDomain r7, int r8, int r9, int r10, String r11, String r12) {
        if (checkDisabled() == false) goto L5;
        return;
    L5:
        if (r8 < 0) goto L37;
        if (r9 < 0) goto L37;
        if (r10 < 0) goto L37;
        RuntimeDomain r0 = DOMAIN;
        if (r7 != r0) goto L35;
        String r13 = null;
        if (r8 == 4) goto L19;
        if (r8 != 3) goto L17;
        if (majorWarningLoggedCount >= 20) goto L17;
        r13 = versionString(r8, r9, r10, r11);
        logger.warning(String.format(" Protobuf gencode version %s is exactly one major version older than the runtime version %s at %s. Please update the gencode to avoid compatibility violations in the next runtime release.", new Object[]{r13, VERSION_STRING, r12}));
        majorWarningLoggedCount++;
    L17:
        throw new ProtobufRuntimeVersionException(String.format("Detected mismatched Protobuf Gencode/Runtime major versions when loading %s: gencode %s, runtime %s. Same major version is required.", new Object[]{r12, versionString(r8, r9, r10, r11), VERSION_STRING}));
    L19:
        if (31 < r9) goto L30;
        if (r9 != 31) goto L24;
        if (1 < r10) goto L30;
    L24:
        if (r11.equals("") == true) goto L29;
        if (r13 != null) goto L28;
        r13 = versionString(r8, r9, r10, r11);
    L28:
        throw new ProtobufRuntimeVersionException(String.format("Detected mismatched Protobuf Gencode/Runtime version suffixes when loading %s: gencode %s, runtime %s. Version suffixes must be the same.", new Object[]{r12, r13, VERSION_STRING}));
    L29:
        return;
    L30:
        if (r13 != null) goto L33;
        r13 = versionString(r8, r9, r10, r11);
    L33:
        throw new ProtobufRuntimeVersionException(String.format("Detected incompatible Protobuf Gencode/Runtime versions when loading %s: gencode %s, runtime %s. Runtime version cannot be older than the linked gencode version.", new Object[]{r12, r13, VERSION_STRING}));
    L35:
        throw new ProtobufRuntimeVersionException(String.format("Detected mismatched Protobuf Gencode/Runtime domains when loading %s: gencode %s, runtime %s. Cross-domain usage of Protobuf is not supported.", new Object[]{r12, r7, r0}));
    L37:
        throw new ProtobufRuntimeVersionException("Invalid gencode version: " + versionString(r8, r9, r10, r11));
    }

    private static String versionString(int r2, int r3, int r4, String r5) {
        return String.format("%d.%d.%d%s", new Object[]{Integer.valueOf(r2), Integer.valueOf(r3), Integer.valueOf(r4), r5});
    }
}
