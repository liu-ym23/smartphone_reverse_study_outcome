package com.bytedance.android.live.effect.api;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/effect/api/LiveEffectScene;", "", "", "page", "Ljava/lang/String;", "getPage", "()Ljava/lang/String;", "Preview", "Live", "GiftMenuPreview", "GiftMenuLive", "Vr", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveEffectScene extends Enum<LiveEffectScene> {
    public static final LiveEffectScene GiftMenuLive = null;
    public static final LiveEffectScene GiftMenuPreview = null;
    public static final LiveEffectScene Live = null;
    public static final LiveEffectScene Preview = null;
    public static final LiveEffectScene Vr = null;
    public static final /* synthetic */ LiveEffectScene[] a = null;
    private final String page;

    static {
        LiveEffectScene r1 = new LiveEffectScene("Preview", 0, "live_take_page");
        Preview = r1;
        LiveEffectScene r2 = new LiveEffectScene("Live", 1, "live_take_detail");
        Live = r2;
        LiveEffectScene r3 = new LiveEffectScene("GiftMenuPreview", 2, "live_take_page_gift_menu");
        GiftMenuPreview = r3;
        LiveEffectScene r4 = new LiveEffectScene("GiftMenuLive", 3, "live_take_detail_gift_menu");
        GiftMenuLive = r4;
        LiveEffectScene r5 = new LiveEffectScene("Vr", 4, "live_vr");
        Vr = r5;
        a = new LiveEffectScene[]{r1, r2, r3, r4, r5};
    }

    public static LiveEffectScene valueOf(String r1) {
        return (LiveEffectScene) r27.a.a(LiveEffectScene.class, r1);
    }

    public static LiveEffectScene[] values() {
        return (LiveEffectScene[]) a.clone();
    }

    public final String getPage() {
        return this.page;
    }

    public LiveEffectScene(String r1, int r2, String r3) {
        super(r1, r2);
        this.page = r3;
    }
}
