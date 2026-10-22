package com.bytedance.crypto.e2eetrans;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class CryptoException extends Exception {
    public final Code code;

    public static final enum Code extends Enum<Code> {
        private static final /* synthetic */ Code[] $VALUES = null;
        public static final Code APPID_MISMATCH = null;
        public static final Code CERT_INVALID = null;
        public static final Code CHALLENGE_FAILED = null;
        public static final Code HANDSHAKE_FAILED = null;
        public static final Code INVALID_PARAMS = null;
        public static final Code SESSION_EXPIRED = null;
        public static final Code SESSION_NOT_READY = null;
        public static final Code TAMPERED = null;
        public static final Code UNWRAP_FAILED = null;

        private static /* synthetic */ Code[] $values() {
            return new Code[]{CERT_INVALID, APPID_MISMATCH, CHALLENGE_FAILED, HANDSHAKE_FAILED, TAMPERED, UNWRAP_FAILED, SESSION_NOT_READY, SESSION_EXPIRED, INVALID_PARAMS};
        }

        static {
            CERT_INVALID = new Code("CERT_INVALID", 0);
            APPID_MISMATCH = new Code("APPID_MISMATCH", 1);
            CHALLENGE_FAILED = new Code("CHALLENGE_FAILED", 2);
            HANDSHAKE_FAILED = new Code("HANDSHAKE_FAILED", 3);
            TAMPERED = new Code("TAMPERED", 4);
            UNWRAP_FAILED = new Code("UNWRAP_FAILED", 5);
            SESSION_NOT_READY = new Code("SESSION_NOT_READY", 6);
            SESSION_EXPIRED = new Code("SESSION_EXPIRED", 7);
            INVALID_PARAMS = new Code("INVALID_PARAMS", 8);
            $VALUES = $values();
        }

        private Code(String r1, int r2) {
            super(r1, r2);
        }

        public static Code valueOf(String r2) {
            return (Code) ZeusTransformUtils.preCheckCast(Enum.valueOf(Code.class, r2), Code.class, "com.obric.memorydata.plugin");
        }

        public static Code[] values() {
            return (Code[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Code[].class, "com.obric.memorydata.plugin");
        }
    }

    public CryptoException(Code r1, String r2) {
        super(r2);
        this.code = r1;
    }

    public CryptoException(Code r1, String r2, Throwable r3) {
        super(r2, r3);
        this.code = r1;
    }
}
