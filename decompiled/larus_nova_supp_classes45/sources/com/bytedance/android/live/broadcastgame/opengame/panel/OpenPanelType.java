package com.bytedance.android.live.broadcastgame.opengame.panel;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/panel/OpenPanelType;", "", "OPEN_PANEL", "FULL_SCREEN_OPEN_PANEL", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum OpenPanelType extends Enum<OpenPanelType> {
    public static final OpenPanelType FULL_SCREEN_OPEN_PANEL = null;
    public static final OpenPanelType OPEN_PANEL = null;
    public static final /* synthetic */ OpenPanelType[] a = null;

    static {
        OpenPanelType r1 = new OpenPanelType("OPEN_PANEL", 0);
        OPEN_PANEL = r1;
        OpenPanelType r2 = new OpenPanelType("FULL_SCREEN_OPEN_PANEL", 1);
        FULL_SCREEN_OPEN_PANEL = r2;
        a = new OpenPanelType[]{r1, r2};
    }

    public static OpenPanelType valueOf(String r1) {
        return (OpenPanelType) r27.a.a(OpenPanelType.class, r1);
    }

    public static OpenPanelType[] values() {
        return (OpenPanelType[]) a.clone();
    }

    public OpenPanelType(String r1, int r2) {
        super(r1, r2);
    }
}
