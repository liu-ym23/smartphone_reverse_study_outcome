package com.bytedance.android.live.broadcastgame.opengame.runtime;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/runtime/LaunchMode;", "", "FROM_PANEL", "FROM_DEBUG", "FROM_PREVIEW", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LaunchMode extends Enum<LaunchMode> {
    public static final LaunchMode FROM_DEBUG = null;
    public static final LaunchMode FROM_PANEL = null;
    public static final LaunchMode FROM_PREVIEW = null;
    public static final /* synthetic */ LaunchMode[] a = null;

    static {
        LaunchMode r1 = new LaunchMode("FROM_PANEL", 0);
        FROM_PANEL = r1;
        LaunchMode r2 = new LaunchMode("FROM_DEBUG", 1);
        FROM_DEBUG = r2;
        LaunchMode r3 = new LaunchMode("FROM_PREVIEW", 2);
        FROM_PREVIEW = r3;
        a = new LaunchMode[]{r1, r2, r3};
    }

    public static LaunchMode valueOf(String r1) {
        return (LaunchMode) r27.a.a(LaunchMode.class, r1);
    }

    public static LaunchMode[] values() {
        return (LaunchMode[]) a.clone();
    }

    public LaunchMode(String r1, int r2) {
        super(r1, r2);
    }
}
