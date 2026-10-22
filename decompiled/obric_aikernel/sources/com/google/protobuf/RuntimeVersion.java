package com.google.protobuf;

import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
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
        public ProtobufRuntimeVersionException(String r10) {
            super(r10);
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

        private RuntimeDomain(String r10, int r11) {
            super(r10, r11);
        }

        public static RuntimeDomain valueOf(String r10) {
            return (RuntimeDomain) java.lang.Enum.valueOf(RuntimeDomain.class, r10);
        }

        public static RuntimeDomain[] values() {
            return (RuntimeDomain[]) $VALUES.clone();
        }
    }

    static {
        RuntimeDomain r10 = RuntimeDomain.PUBLIC;
        OSS_DOMAIN = r10;
        DOMAIN = r10;
        majorWarningLoggedCount = 0;
        minorWarningLoggedCount = 0;
        VERSION_STRING = versionString(4, 31, 1, "");
        logger = Logger.getLogger(RuntimeVersion.class.getName());
    }

    private RuntimeVersion() {
    }

    private static boolean checkDisabled() {
        String r10 = System.getenv("TEMPORARILY_DISABLE_PROTOBUF_VERSION_CHECK");
        if (r10 != null) goto L5;
        return false;
    L5:
        if (r10.equals("true") == false) goto L10;
        return true;
    L10:
        return false;
    }

    public static void validateProtobufGencodeVersion(RuntimeDomain r10, int r11, int r12, int r13, String r14, String r15) {
        validateProtobufGencodeVersionImpl(r10, r11, r12, r13, r14, r15);
    }

    private static void validateProtobufGencodeVersionImpl(RuntimeDomain r10, int r11, int r12, int r13, String r14, String r15) {
        if (checkDisabled() == false) goto L5;
        return;
    L5:
        if (r11 < 0) goto L37;
        if (r12 < 0) goto L37;
        if (r13 < 0) goto L37;
        RuntimeDomain r16 = DOMAIN;
        if (r10 != r16) goto L35;
        String r17 = null;
        if (r11 == 4) goto L19;
        if (r11 != 3) goto L17;
        if (majorWarningLoggedCount >= 20) goto L17;
        r17 = versionString(r11, r12, r13, r14);
        logger.warning(String.format(" Protobuf gencode version %s is exactly one major version older than the runtime version %s at %s. Please update the gencode to avoid compatibility violations in the next runtime release.", new Object[]{r17, VERSION_STRING, r15}));
        majorWarningLoggedCount++;
    L17:
        throw new ProtobufRuntimeVersionException(String.format("Detected mismatched Protobuf Gencode/Runtime major versions when loading %s: gencode %s, runtime %s. Same major version is required.", new Object[]{r15, versionString(r11, r12, r13, r14), VERSION_STRING}));
    L19:
        if (31 < r12) goto L30;
        if (r12 != 31) goto L24;
        if (1 < r13) goto L30;
    L24:
        if (r14.equals("") == true) goto L29;
        if (r17 != null) goto L28;
        r17 = versionString(r11, r12, r13, r14);
    L28:
        throw new ProtobufRuntimeVersionException(String.format("Detected mismatched Protobuf Gencode/Runtime version suffixes when loading %s: gencode %s, runtime %s. Version suffixes must be the same.", new Object[]{r15, r17, VERSION_STRING}));
    L29:
        return;
    L30:
        if (r17 != null) goto L33;
        r17 = versionString(r11, r12, r13, r14);
    L33:
        throw new ProtobufRuntimeVersionException(String.format("Detected incompatible Protobuf Gencode/Runtime versions when loading %s: gencode %s, runtime %s. Runtime version cannot be older than the linked gencode version.", new Object[]{r15, r17, VERSION_STRING}));
    L35:
        throw new ProtobufRuntimeVersionException(String.format("Detected mismatched Protobuf Gencode/Runtime domains when loading %s: gencode %s, runtime %s. Cross-domain usage of Protobuf is not supported.", new Object[]{r15, r10, r16}));
    L37:
        throw new ProtobufRuntimeVersionException("Invalid gencode version: " + versionString(r11, r12, r13, r14));
    }

    private static String versionString(int r10, int r11, int r12, String r13) {
        return String.format("%d.%d.%d%s", new Object[]{Integer.valueOf(r10), Integer.valueOf(r11), Integer.valueOf(r12), r13});
    }
}
