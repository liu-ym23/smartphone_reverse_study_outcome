package com.bytedance.android.live.room.api.messagewindow.container;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/room/api/messagewindow/container/MsgWindowPosition;", "", "BOTTOM_RIGHT", "TOP_LEFT", "TOP_RIGHT", "experience-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum MsgWindowPosition extends Enum<MsgWindowPosition> {
    public static final MsgWindowPosition BOTTOM_RIGHT = null;
    public static final MsgWindowPosition TOP_LEFT = null;
    public static final MsgWindowPosition TOP_RIGHT = null;
    public static final /* synthetic */ MsgWindowPosition[] a = null;

    static {
        MsgWindowPosition r1 = new MsgWindowPosition("BOTTOM_RIGHT", 0);
        BOTTOM_RIGHT = r1;
        MsgWindowPosition r2 = new MsgWindowPosition("TOP_LEFT", 1);
        TOP_LEFT = r2;
        MsgWindowPosition r3 = new MsgWindowPosition("TOP_RIGHT", 2);
        TOP_RIGHT = r3;
        a = new MsgWindowPosition[]{r1, r2, r3};
    }

    public static MsgWindowPosition valueOf(String r1) {
        return (MsgWindowPosition) a.a(MsgWindowPosition.class, r1);
    }

    public static MsgWindowPosition[] values() {
        return (MsgWindowPosition[]) a.clone();
    }

    public MsgWindowPosition(String r1, int r2) {
        super(r1, r2);
    }
}
