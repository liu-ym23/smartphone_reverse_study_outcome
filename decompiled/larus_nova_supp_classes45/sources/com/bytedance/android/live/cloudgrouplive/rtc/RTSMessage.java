package com.bytedance.android.live.cloudgrouplive.rtc;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/cloudgrouplive/rtc/RTSMessage;", "", "", "des", "Ljava/lang/String;", "getDes", "()Ljava/lang/String;", "UPDATE_AUDIO", "SYNC_VIEW_DISPLAY", "TRANSFER_VIEW", "UPDATE_VIEW_DISPLAY", "SYNC_STICKER", "multilink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum RTSMessage extends Enum<RTSMessage> {
    public static final RTSMessage SYNC_STICKER = null;
    public static final RTSMessage SYNC_VIEW_DISPLAY = null;
    public static final RTSMessage TRANSFER_VIEW = null;
    public static final RTSMessage UPDATE_AUDIO = null;
    public static final RTSMessage UPDATE_VIEW_DISPLAY = null;
    public static final /* synthetic */ RTSMessage[] a = null;
    private final String des;

    static {
        RTSMessage r1 = new RTSMessage("UPDATE_AUDIO", 0, "update_audio");
        UPDATE_AUDIO = r1;
        RTSMessage r2 = new RTSMessage("SYNC_VIEW_DISPLAY", 1, "sync_view_display");
        SYNC_VIEW_DISPLAY = r2;
        RTSMessage r3 = new RTSMessage("TRANSFER_VIEW", 2, "transfer_view");
        TRANSFER_VIEW = r3;
        RTSMessage r4 = new RTSMessage("UPDATE_VIEW_DISPLAY", 3, "update_view_display");
        UPDATE_VIEW_DISPLAY = r4;
        RTSMessage r5 = new RTSMessage("SYNC_STICKER", 4, "sync_sticker");
        SYNC_STICKER = r5;
        a = new RTSMessage[]{r1, r2, r3, r4, r5};
    }

    public static RTSMessage valueOf(String r1) {
        return (RTSMessage) r27.a.a(RTSMessage.class, r1);
    }

    public static RTSMessage[] values() {
        return (RTSMessage[]) a.clone();
    }

    public final String getDes() {
        return this.des;
    }

    public RTSMessage(String r1, int r2, String r3) {
        super(r1, r2);
        this.des = r3;
    }
}
