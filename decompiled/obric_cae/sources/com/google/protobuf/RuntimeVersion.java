package com.google.protobuf;

import java.util.Locale;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
public final class RuntimeVersion {
    public static final RuntimeDomain DOMAIN = null;
    public static final int MAJOR = 4;
    private static final int MAX_WARNING_COUNT = 20;
    public static final int MINOR = 33;
    public static final RuntimeDomain OSS_DOMAIN = null;
    public static final int OSS_MAJOR = 4;
    public static final int OSS_MINOR = 33;
    public static final int OSS_PATCH = 4;
    public static final String OSS_SUFFIX = "";
    public static final int PATCH = 4;
    public static final String SUFFIX = "";
    private static final String VERSION_STRING = null;
    private static final Logger logger = null;
    static int majorWarningLoggedCount;
    static int minorWarningLoggedCount;
    static boolean preleaseRuntimeWarningLogged;

    public static final class ProtobufRuntimeVersionException extends RuntimeException {
        public ProtobufRuntimeVersionException(String r8) {
            super(r8);
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

        private RuntimeDomain(String r8, int r10) {
            super(r8, r10);
        }

        public static RuntimeDomain valueOf(String r8) {
            return (RuntimeDomain) java.lang.Enum.valueOf(RuntimeDomain.class, r8);
        }

        public static RuntimeDomain[] values() {
            return (RuntimeDomain[]) $VALUES.clone();
        }
    }

    static {
        RuntimeDomain r8 = RuntimeDomain.PUBLIC;
        OSS_DOMAIN = r8;
        DOMAIN = r8;
        majorWarningLoggedCount = 0;
        minorWarningLoggedCount = 0;
        preleaseRuntimeWarningLogged = false;
        VERSION_STRING = versionString(4, 33, 4, "");
        logger = Logger.getLogger(RuntimeVersion.class.getName());
    }

    private RuntimeVersion() {
    }

    private static boolean checkDisabled() {
        String r8 = System.getenv("TEMPORARILY_DISABLE_PROTOBUF_VERSION_CHECK");
        if (r8 != null) goto L5;
        return false;
    L5:
        if (r8.equals("true") == false) goto L10;
        return true;
    L10:
        return false;
    }

    public static void validateProtobufGencodeVersion(RuntimeDomain r8, int r10, int r11, int r12, String r13, String r14) {
        validateProtobufGencodeVersionImpl(r8, r10, r11, r12, r13, r14);
    }

    private static void validateProtobufGencodeVersionImpl(RuntimeDomain r8, int r10, int r11, int r12, String r13, String r14) {
        if (checkDisabled() == false) goto L5;
        return;
    L5:
        if (r10 < 0) goto L54;
        if (r11 < 0) goto L54;
        if (r12 < 0) goto L54;
        RuntimeDomain r15 = DOMAIN;
        if (r8 != r15) goto L52;
        if (r10 != 4) goto L17;
        if (r11 != 33) goto L17;
        if (r12 != 4) goto L17;
        if (r13.equals("") == false) goto L17;
        return;
    L17:
        if (r10 != 4) goto L19;
        String r16 = null;
    L26:
        if (33 < r11) goto L47;
        if (r11 != 33) goto L31;
        if (4 < r12) goto L47;
    L31:
        if (r13.isEmpty() == false) goto L34;
        return;
    L34:
        if (r13.isEmpty() == true) goto L39;
        if (r16 != null) goto L38;
        r16 = versionString(r10, r11, r12, r13);
    L38:
        throw new ProtobufRuntimeVersionException(String.format(Locale.US, "Detected mismatched Protobuf Gencode/Runtime version suffixes when loading %s: gencode %s, runtime %s. Prerelease gencode must be used with the same runtime.", new Object[]{r14, r16, VERSION_STRING}));
    L39:
        if (r10 != 4) goto L46;
        if (r11 != 33) goto L55;
        if (r12 != 4) goto L56;
        if (r16 != null) goto L45;
        r16 = versionString(r10, r11, r12, r13);
    L45:
        throw new ProtobufRuntimeVersionException(String.format(Locale.US, "Detected mismatched Protobuf Gencode/Runtime version suffixes when loading %s: gencode %s, runtime %s. Prelease runtimes must only be used with exact match gencode (including suffix) or non-prerelease gencode versions of a lower version.", new Object[]{r14, r16, VERSION_STRING}));
    L56:
        return;
    L55:
        return;
    L46:
        return;
    L47:
        if (r16 != null) goto L50;
        r16 = versionString(r10, r11, r12, r13);
    L50:
        throw new ProtobufRuntimeVersionException(String.format(Locale.US, "Detected incompatible Protobuf Gencode/Runtime versions when loading %s: gencode %s, runtime %s. Runtime version cannot be older than the linked gencode version.", new Object[]{r14, r16, VERSION_STRING}));
    L19:
        if (r10 != 3) goto L24;
        if (majorWarningLoggedCount >= 20) goto L24;
        r16 = versionString(r10, r11, r12, r13);
        logger.warning(String.format(Locale.US, " Protobuf gencode version %s is exactly one major version older than the runtime version %s at %s. Please update the gencode to avoid compatibility violations in the next runtime release.", new Object[]{r16, VERSION_STRING, r14}));
        majorWarningLoggedCount++;
    L24:
        throw new ProtobufRuntimeVersionException(String.format(Locale.US, "Detected mismatched Protobuf Gencode/Runtime major versions when loading %s: gencode %s, runtime %s. Same major version is required.", new Object[]{r14, versionString(r10, r11, r12, r13), VERSION_STRING}));
    L52:
        throw new ProtobufRuntimeVersionException(String.format(Locale.US, "Detected mismatched Protobuf Gencode/Runtime domains when loading %s: gencode %s, runtime %s. Cross-domain usage of Protobuf is not supported.", new Object[]{r14, r8, r15}));
    L54:
        throw new ProtobufRuntimeVersionException("Invalid gencode version: " + versionString(r10, r11, r12, r13));
    }

    private static String versionString(int r8, int r10, int r11, String r12) {
        return String.format(Locale.US, "%d.%d.%d%s", new Object[]{Integer.valueOf(r8), Integer.valueOf(r10), Integer.valueOf(r11), r12});
    }
}
