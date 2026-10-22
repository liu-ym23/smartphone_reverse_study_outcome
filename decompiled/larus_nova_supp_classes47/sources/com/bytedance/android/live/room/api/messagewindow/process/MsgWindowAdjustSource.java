package com.bytedance.android.live.room.api.messagewindow.process;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/room/api/messagewindow/process/MsgWindowAdjustSource;", "", "", "description", "Ljava/lang/String;", "getDescription", "()Ljava/lang/String;", "UNKNOWN", "VS_LANDSCAPE_MSG_BOARD", "experience-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum MsgWindowAdjustSource extends Enum<MsgWindowAdjustSource> {
    public static final MsgWindowAdjustSource UNKNOWN = null;
    public static final MsgWindowAdjustSource VS_LANDSCAPE_MSG_BOARD = null;
    public static final /* synthetic */ MsgWindowAdjustSource[] a = null;
    private final String description;

    static {
        MsgWindowAdjustSource r1 = new MsgWindowAdjustSource("UNKNOWN", 0, "unknown");
        UNKNOWN = r1;
        MsgWindowAdjustSource r2 = new MsgWindowAdjustSource("VS_LANDSCAPE_MSG_BOARD", 1, "vsLandscapeMessageBoard");
        VS_LANDSCAPE_MSG_BOARD = r2;
        a = new MsgWindowAdjustSource[]{r1, r2};
    }

    public static MsgWindowAdjustSource valueOf(String r1) {
        return (MsgWindowAdjustSource) a.a(MsgWindowAdjustSource.class, r1);
    }

    public static MsgWindowAdjustSource[] values() {
        return (MsgWindowAdjustSource[]) a.clone();
    }

    public final String getDescription() {
        return this.description;
    }

    public MsgWindowAdjustSource(String r1, int r2, String r3) {
        super(r1, r2);
        this.description = r3;
    }
}
