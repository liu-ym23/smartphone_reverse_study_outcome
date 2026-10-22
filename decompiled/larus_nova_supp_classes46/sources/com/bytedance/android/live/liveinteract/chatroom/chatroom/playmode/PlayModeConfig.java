package com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode;

import com.bytedance.android.live.liveinteract.playmode.SceneType;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/liveinteract/chatroom/chatroom/playmode/PlayModeConfig;", "", "", "PAID_LINK", "SELF_DISCIPLINE", "THEMED_COMPETITION", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public abstract enum PlayModeConfig extends Enum<PlayModeConfig> {
    public static final PlayModeConfig PAID_LINK = null;
    public static final PlayModeConfig SELF_DISCIPLINE = null;
    public static final PlayModeConfig THEMED_COMPETITION = null;
    public static final /* synthetic */ PlayModeConfig[] a = null;

    static {
        final String r2 = "PAID_LINK";
        final int r3 = 0;
        PlayModeConfig r1 = new PAID_LINK(r2, r3);
        PAID_LINK = r1;
        final String r4 = "SELF_DISCIPLINE";
        final int r5 = 1;
        PlayModeConfig r6 = new SELF_DISCIPLINE(r4, r5);
        SELF_DISCIPLINE = r6;
        final String r7 = "THEMED_COMPETITION";
        final int r8 = 2;
        PlayModeConfig r9 = new THEMED_COMPETITION(r7, r8);
        THEMED_COMPETITION = r9;
        a = new PlayModeConfig[]{r1, r6, r9};
    }

    public PlayModeConfig() {
        throw null;
    }

    public static PlayModeConfig valueOf(String r1) {
        return (PlayModeConfig) r27.a.a(PlayModeConfig.class, r1);
    }

    public static PlayModeConfig[] values() {
        return (PlayModeConfig[]) a.clone();
    }

    public abstract /* synthetic */ Widget createPlayModeWidget(SceneType r1);

    public abstract /* synthetic */ boolean isEnable(SceneType r1);

    public PlayModeConfig(String r1, int r2, DefaultConstructorMarker r3) {
        super(r1, r2);
    }
}
