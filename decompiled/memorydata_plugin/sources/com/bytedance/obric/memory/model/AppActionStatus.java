package com.bytedance.obric.memory.model;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum AppActionStatus extends Enum<AppActionStatus> {
    private static final /* synthetic */ AppActionStatus[] $VALUES = null;

    @SerializedName("5")
    public static final AppActionStatus ExeFailed = null;

    @SerializedName("4")
    public static final AppActionStatus ExeSuccess = null;

    @SerializedName("3")
    public static final AppActionStatus Failed = null;

    @SerializedName("6")
    public static final AppActionStatus NotReturned = null;

    @SerializedName("1")
    public static final AppActionStatus NotSend = null;

    @SerializedName("2")
    public static final AppActionStatus Sended = null;

    @SerializedName("7")
    public static final AppActionStatus Timeout_Returned = null;
    private final int value;

    static {
        AppActionStatus r0 = new AppActionStatus("NotSend", 0, 1);
        NotSend = r0;
        AppActionStatus r1 = new AppActionStatus("Sended", 1, 2);
        Sended = r1;
        AppActionStatus r4 = new AppActionStatus("Failed", 2, 3);
        Failed = r4;
        AppActionStatus r6 = new AppActionStatus("ExeSuccess", 3, 4);
        ExeSuccess = r6;
        AppActionStatus r8 = new AppActionStatus("ExeFailed", 4, 5);
        ExeFailed = r8;
        AppActionStatus r10 = new AppActionStatus("NotReturned", 5, 6);
        NotReturned = r10;
        AppActionStatus r12 = new AppActionStatus("Timeout_Returned", 6, 7);
        Timeout_Returned = r12;
        $VALUES = new AppActionStatus[]{r0, r1, r4, r6, r8, r10, r12};
    }

    private AppActionStatus(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static AppActionStatus findByValue(int r0) {
        switch(r0) {
            case 1: goto L18;
            case 2: goto L16;
            case 3: goto L14;
            case 4: goto L12;
            case 5: goto L10;
            case 6: goto L8;
            case 7: goto L6;
            default: goto L3;
        };
    L3:
        return null;
    L6:
        return Timeout_Returned;
    L8:
        return NotReturned;
    L10:
        return ExeFailed;
    L12:
        return ExeSuccess;
    L14:
        return Failed;
    L16:
        return Sended;
    L18:
        return NotSend;
    }

    public static AppActionStatus valueOf(String r2) {
        return (AppActionStatus) ZeusTransformUtils.preCheckCast(Enum.valueOf(AppActionStatus.class, r2), AppActionStatus.class, "com.obric.memorydata.plugin");
    }

    public static AppActionStatus[] values() {
        return (AppActionStatus[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), AppActionStatus[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.value;
    }
}
