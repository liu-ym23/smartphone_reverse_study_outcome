package com.ss.android.cert.manager.constants;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class BytedCertConstant {
    public static final int H5_COMPRESS_RATE = 85;
    public static final String[] SENSITIVE_KEY_SETS = null;
    public static final String VERSION = "4.7.7-rc.13";

    public BytedCertConstant() {
    }

    static {
        SENSITIVE_KEY_SETS = new String[]{"phone_number", "bank_card_number", "children_identity_name", "children_birthday", "identity_name", "identity_code", "mobile", "guardian_identity_name", "guardian_identity_code", "guardian_mobile"};
    }
}
