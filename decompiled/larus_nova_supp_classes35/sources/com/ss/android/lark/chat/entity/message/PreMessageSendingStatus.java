package com.ss.android.lark.chat.entity.message;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final enum PreMessageSendingStatus extends Enum<PreMessageSendingStatus> {
    public static final PreMessageSendingStatus FAILED = null;
    public static final PreMessageSendingStatus PENDING = null;
    public static final PreMessageSendingStatus UNKNOWN = null;
    public static final /* synthetic */ PreMessageSendingStatus[] a = null;
    private int value;

    static {
        PreMessageSendingStatus r0 = new PreMessageSendingStatus("UNKNOWN", 0, 0);
        UNKNOWN = r0;
        PreMessageSendingStatus r1 = new PreMessageSendingStatus("PENDING", 1, 1);
        PENDING = r1;
        PreMessageSendingStatus r3 = new PreMessageSendingStatus("FAILED", 2, 2);
        FAILED = r3;
        a = new PreMessageSendingStatus[]{r0, r1, r3};
    }

    public static PreMessageSendingStatus[] values() {
        return (PreMessageSendingStatus[]) a.clone();
    }

    public int getNumber() {
        return this.value;
    }

    public static PreMessageSendingStatus forNumber(int r1) {
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L9;
        return UNKNOWN;
    L9:
        return FAILED;
    L11:
        return PENDING;
    }

    public static PreMessageSendingStatus valueOf(String r1) {
        return (PreMessageSendingStatus) r27.a.a(PreMessageSendingStatus.class, r1);
    }

    public PreMessageSendingStatus(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
