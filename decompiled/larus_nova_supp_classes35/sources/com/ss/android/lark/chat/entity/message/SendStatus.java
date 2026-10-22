package com.ss.android.lark.chat.entity.message;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final enum SendStatus extends Enum<SendStatus> {
    public static final SendStatus DRAFT = null;
    public static final SendStatus FAIL = null;
    public static final SendStatus SENDING = null;
    public static final SendStatus SUCCESS = null;
    public static final /* synthetic */ SendStatus[] a = null;
    private int value;

    static {
        SendStatus r0 = new SendStatus("SUCCESS", 0, 0);
        SUCCESS = r0;
        SendStatus r1 = new SendStatus("SENDING", 1, 1);
        SENDING = r1;
        SendStatus r3 = new SendStatus("FAIL", 2, 2);
        FAIL = r3;
        SendStatus r5 = new SendStatus("DRAFT", 3, 3);
        DRAFT = r5;
        a = new SendStatus[]{r0, r1, r3, r5};
    }

    public static SendStatus[] values() {
        return (SendStatus[]) a.clone();
    }

    public int getNumber() {
        return this.value;
    }

    public static SendStatus forNumber(int r1) {
        if (r1 == 0) goto L18;
        if (r1 == 1) goto L16;
        if (r1 == 2) goto L14;
        if (r1 == 3) goto L12;
        return null;
    L12:
        return DRAFT;
    L14:
        return FAIL;
    L16:
        return SENDING;
    L18:
        return SUCCESS;
    }

    public static SendStatus valueOf(String r1) {
        return (SendStatus) r27.a.a(SendStatus.class, r1);
    }

    public SendStatus(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
