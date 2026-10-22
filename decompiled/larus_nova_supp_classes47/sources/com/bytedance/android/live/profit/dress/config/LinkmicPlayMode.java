package com.bytedance.android.live.profit.dress.config;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/profit/dress/config/LinkmicPlayMode;", "", "", "value", "I", "getValue", "()I", "Companion", "a", "Default", "StarWish", "VIDEO_CHAT_FLOAT_WINDOW_LAYOUT", "DYNAMIC_WINDOW_LAYOUT", "C_POSITION_LAYOUT", "VIDEO_TEAM_FIGHT_LAYOUT", "LINK_ROOM_FIGHT", "RealTimeChorus", "REALTIME_CHORUS_CONCERT", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum LinkmicPlayMode extends Enum<LinkmicPlayMode> {
    public static final LinkmicPlayMode C_POSITION_LAYOUT = null;
    public static final a Companion = null;
    public static final LinkmicPlayMode DYNAMIC_WINDOW_LAYOUT = null;
    public static final LinkmicPlayMode Default = null;
    public static final LinkmicPlayMode LINK_ROOM_FIGHT = null;
    public static final LinkmicPlayMode REALTIME_CHORUS_CONCERT = null;
    public static final LinkmicPlayMode RealTimeChorus = null;
    public static final LinkmicPlayMode StarWish = null;
    public static final LinkmicPlayMode VIDEO_CHAT_FLOAT_WINDOW_LAYOUT = null;
    public static final LinkmicPlayMode VIDEO_TEAM_FIGHT_LAYOUT = null;
    public static final /* synthetic */ LinkmicPlayMode[] a = null;
    private final int value;

    public static LinkmicPlayMode valueOf(String r1) {
        return (LinkmicPlayMode) r27.a.a(LinkmicPlayMode.class, r1);
    }

    public static LinkmicPlayMode[] values() {
        return (LinkmicPlayMode[]) a.clone();
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.live.profit.dress.config.LinkmicPlayMode$a] */
    static {
        LinkmicPlayMode r1 = new LinkmicPlayMode("Default", 0, 0);
        Default = r1;
        LinkmicPlayMode r2 = new LinkmicPlayMode("StarWish", 1, 1);
        StarWish = r2;
        LinkmicPlayMode r3 = new LinkmicPlayMode("VIDEO_CHAT_FLOAT_WINDOW_LAYOUT", 2, 2);
        VIDEO_CHAT_FLOAT_WINDOW_LAYOUT = r3;
        LinkmicPlayMode r4 = new LinkmicPlayMode("DYNAMIC_WINDOW_LAYOUT", 3, 4);
        DYNAMIC_WINDOW_LAYOUT = r4;
        LinkmicPlayMode r5 = new LinkmicPlayMode("C_POSITION_LAYOUT", 4, 13);
        C_POSITION_LAYOUT = r5;
        LinkmicPlayMode r6 = new LinkmicPlayMode("VIDEO_TEAM_FIGHT_LAYOUT", 5, 14);
        VIDEO_TEAM_FIGHT_LAYOUT = r6;
        LinkmicPlayMode r7 = new LinkmicPlayMode("LINK_ROOM_FIGHT", 6, 16);
        LINK_ROOM_FIGHT = r7;
        LinkmicPlayMode r8 = new LinkmicPlayMode("RealTimeChorus", 7, 36);
        RealTimeChorus = r8;
        LinkmicPlayMode r9 = new LinkmicPlayMode("REALTIME_CHORUS_CONCERT", 8, 39);
        REALTIME_CHORUS_CONCERT = r9;
        a = new LinkmicPlayMode[]{r1, r2, r3, r4, r5, r6, r7, r8, r9};
        Companion = new a();
    }

    public final int getValue() {
        return this.value;
    }

    public LinkmicPlayMode(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
