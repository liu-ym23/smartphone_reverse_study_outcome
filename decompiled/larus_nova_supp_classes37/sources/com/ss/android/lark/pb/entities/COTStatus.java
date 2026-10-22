package com.ss.android.lark.pb.entities;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum COTStatus extends Enum<COTStatus> implements WireEnum {
    private static final /* synthetic */ COTStatus[] $VALUES = null;
    public static final ProtoAdapter<COTStatus> ADAPTER = null;
    public static final COTStatus COT_STATUS_DONE = null;
    public static final COTStatus COT_STATUS_ERROR = null;
    public static final COTStatus COT_STATUS_NONE = null;
    public static final COTStatus COT_STATUS_RUNNING = null;
    public static final COTStatus COT_STATUS_TIMEOUT = null;
    private final int value;

    static {
        COTStatus r0 = new COTStatus("COT_STATUS_NONE", 0, 0);
        COT_STATUS_NONE = r0;
        COTStatus r1 = new COTStatus("COT_STATUS_RUNNING", 1, 1);
        COT_STATUS_RUNNING = r1;
        COTStatus r3 = new COTStatus("COT_STATUS_DONE", 2, 2);
        COT_STATUS_DONE = r3;
        COTStatus r5 = new COTStatus("COT_STATUS_ERROR", 3, 3);
        COT_STATUS_ERROR = r5;
        COTStatus r7 = new COTStatus("COT_STATUS_TIMEOUT", 4, 4);
        COT_STATUS_TIMEOUT = r7;
        $VALUES = new COTStatus[]{r0, r1, r3, r5, r7};
        ADAPTER = ProtoAdapter.newEnumAdapter(COTStatus.class);
    }

    public static COTStatus[] values() {
        return (COTStatus[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static COTStatus fromValue(int r1) {
        if (r1 == 0) goto L22;
        if (r1 == 1) goto L20;
        if (r1 == 2) goto L18;
        if (r1 == 3) goto L16;
        if (r1 == 4) goto L14;
        return null;
    L14:
        return COT_STATUS_TIMEOUT;
    L16:
        return COT_STATUS_ERROR;
    L18:
        return COT_STATUS_DONE;
    L20:
        return COT_STATUS_RUNNING;
    L22:
        return COT_STATUS_NONE;
    }

    public static COTStatus valueOf(String r1) {
        return (COTStatus) a.a(COTStatus.class, r1);
    }

    private COTStatus(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
