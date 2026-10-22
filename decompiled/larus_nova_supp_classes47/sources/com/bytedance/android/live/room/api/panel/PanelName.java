package com.bytedance.android.live.room.api.panel;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/room/api/panel/PanelName;", "", "", "panelName", "Ljava/lang/String;", "getPanelName", "()Ljava/lang/String;", "Companion", "a", "UnKnown", "Profile", "LongPress", "More", "AudienceList", "RightCard", "GameCp", "Predictor", "PublicScreenOperatePanel", "experience-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PanelName extends Enum<PanelName> {
    public static final PanelName AudienceList = null;
    public static final a Companion = null;
    public static final PanelName GameCp = null;
    public static final PanelName LongPress = null;
    public static final PanelName More = null;
    public static final PanelName Predictor = null;
    public static final PanelName Profile = null;
    public static final PanelName PublicScreenOperatePanel = null;
    public static final PanelName RightCard = null;
    public static final PanelName UnKnown = null;
    public static final /* synthetic */ PanelName[] a = null;
    private final String panelName;

    public static PanelName valueOf(String r1) {
        return (PanelName) r27.a.a(PanelName.class, r1);
    }

    public static PanelName[] values() {
        return (PanelName[]) a.clone();
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.live.room.api.panel.PanelName$a] */
    static {
        PanelName r1 = new PanelName("UnKnown", 0, "unknown");
        UnKnown = r1;
        PanelName r2 = new PanelName("Profile", 1, "profile");
        Profile = r2;
        PanelName r3 = new PanelName("LongPress", 2, "long_press");
        LongPress = r3;
        PanelName r4 = new PanelName("More", 3, "more");
        More = r4;
        PanelName r5 = new PanelName("AudienceList", 4, "audience_list");
        AudienceList = r5;
        PanelName r6 = new PanelName("RightCard", 5, "right_card");
        RightCard = r6;
        PanelName r7 = new PanelName("GameCp", 6, "game_cp");
        GameCp = r7;
        PanelName r8 = new PanelName("Predictor", 7, "predictor");
        Predictor = r8;
        PanelName r9 = new PanelName("PublicScreenOperatePanel", 8, "public_screen_operate_panel");
        PublicScreenOperatePanel = r9;
        a = new PanelName[]{r1, r2, r3, r4, r5, r6, r7, r8, r9};
        Companion = new a();
    }

    public final String getPanelName() {
        return this.panelName;
    }

    public PanelName(String r1, int r2, String r3) {
        super(r1, r2);
        this.panelName = r3;
    }
}
