package com.bytedance.android.live.profit.dress.config;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/profit/dress/config/MvpEffectScene;", "", "", "value", "I", "getValue", "()I", "Companion", "a", "Unknown", "LinkMic", "AudioChat", "VideoChat", "GridVideoChat", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum MvpEffectScene extends Enum<MvpEffectScene> {
    public static final MvpEffectScene AudioChat = null;
    public static final a Companion = null;
    public static final MvpEffectScene GridVideoChat = null;
    public static final MvpEffectScene LinkMic = null;
    public static final MvpEffectScene Unknown = null;
    public static final MvpEffectScene VideoChat = null;
    public static final /* synthetic */ MvpEffectScene[] a = null;
    private final int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.live.profit.dress.config.MvpEffectScene$a] */
    static {
        MvpEffectScene r1 = new MvpEffectScene("Unknown", 0, 0);
        Unknown = r1;
        MvpEffectScene r2 = new MvpEffectScene("LinkMic", 1, 1);
        LinkMic = r2;
        MvpEffectScene r3 = new MvpEffectScene("AudioChat", 2, 2);
        AudioChat = r3;
        MvpEffectScene r4 = new MvpEffectScene("VideoChat", 3, 3);
        VideoChat = r4;
        MvpEffectScene r5 = new MvpEffectScene("GridVideoChat", 4, 4);
        GridVideoChat = r5;
        a = new MvpEffectScene[]{r1, r2, r3, r4, r5};
        Companion = new a();
    }

    public static MvpEffectScene valueOf(String r1) {
        return (MvpEffectScene) r27.a.a(MvpEffectScene.class, r1);
    }

    public static MvpEffectScene[] values() {
        return (MvpEffectScene[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public MvpEffectScene(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
