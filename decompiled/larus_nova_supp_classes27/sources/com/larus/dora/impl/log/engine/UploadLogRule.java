package com.larus.dora.impl.log.engine;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/dora/impl/log/engine/UploadLogRule;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "ERROR_RULE", "COPY_SN", "OTA_FAIL", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum UploadLogRule extends Enum<UploadLogRule> {
    public static final UploadLogRule COPY_SN = null;
    public static final UploadLogRule ERROR_RULE = null;
    public static final UploadLogRule OTA_FAIL = null;
    public static final /* synthetic */ UploadLogRule[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static EnumEntries<UploadLogRule> getEntries() {
        return b;
    }

    static {
        UploadLogRule r0 = new UploadLogRule("ERROR_RULE", 0, 0);
        ERROR_RULE = r0;
        UploadLogRule r1 = new UploadLogRule("COPY_SN", 1, 1);
        COPY_SN = r1;
        UploadLogRule r3 = new UploadLogRule("OTA_FAIL", 2, 2);
        OTA_FAIL = r3;
        UploadLogRule[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static UploadLogRule[] values() {
        return (UploadLogRule[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static UploadLogRule valueOf(String r1) {
        return (UploadLogRule) a.a(UploadLogRule.class, r1);
    }

    public UploadLogRule(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
