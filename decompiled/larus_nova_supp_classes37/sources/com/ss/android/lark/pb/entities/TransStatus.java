package com.ss.android.lark.pb.entities;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum TransStatus extends Enum<TransStatus> implements WireEnum {
    private static final /* synthetic */ TransStatus[] $VALUES = null;
    public static final TransStatus ABORT_BY_RECEIVER = null;
    public static final TransStatus ABORT_BY_SENDER = null;
    public static final TransStatus ACCEPT = null;
    public static final ProtoAdapter<TransStatus> ADAPTER = null;
    public static final TransStatus CANCEL = null;
    public static final TransStatus CANCEL_BY_RECEIVER = null;
    public static final TransStatus OFFLINE_MODE = null;
    public static final TransStatus PENDING = null;
    public static final TransStatus REFUSE = null;
    public static final TransStatus TRANS_DONE = null;
    private final int value;

    static {
        TransStatus r0 = new TransStatus("PENDING", 0, 0);
        PENDING = r0;
        TransStatus r1 = new TransStatus("ACCEPT", 1, 1);
        ACCEPT = r1;
        TransStatus r3 = new TransStatus("REFUSE", 2, 2);
        REFUSE = r3;
        TransStatus r5 = new TransStatus("CANCEL", 3, 3);
        CANCEL = r5;
        TransStatus r7 = new TransStatus("CANCEL_BY_RECEIVER", 4, 8);
        CANCEL_BY_RECEIVER = r7;
        TransStatus r9 = new TransStatus("ABORT_BY_SENDER", 5, 4);
        ABORT_BY_SENDER = r9;
        TransStatus r12 = new TransStatus("ABORT_BY_RECEIVER", 6, 5);
        ABORT_BY_RECEIVER = r12;
        TransStatus r14 = new TransStatus("TRANS_DONE", 7, 6);
        TRANS_DONE = r14;
        TransStatus r13 = new TransStatus("OFFLINE_MODE", 8, 7);
        OFFLINE_MODE = r13;
        $VALUES = new TransStatus[]{r0, r1, r3, r5, r7, r9, r12, r14, r13};
        ADAPTER = ProtoAdapter.newEnumAdapter(TransStatus.class);
    }

    public static TransStatus[] values() {
        return (TransStatus[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static TransStatus fromValue(int r0) {
        switch(r0) {
            case 0: goto L22;
            case 1: goto L20;
            case 2: goto L18;
            case 3: goto L16;
            case 4: goto L14;
            case 5: goto L12;
            case 6: goto L10;
            case 7: goto L8;
            case 8: goto L6;
            default: goto L3;
        };
    L3:
        return null;
    L6:
        return CANCEL_BY_RECEIVER;
    L8:
        return OFFLINE_MODE;
    L10:
        return TRANS_DONE;
    L12:
        return ABORT_BY_RECEIVER;
    L14:
        return ABORT_BY_SENDER;
    L16:
        return CANCEL;
    L18:
        return REFUSE;
    L20:
        return ACCEPT;
    L22:
        return PENDING;
    }

    public static TransStatus valueOf(String r1) {
        return (TransStatus) a.a(TransStatus.class, r1);
    }

    private TransStatus(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
