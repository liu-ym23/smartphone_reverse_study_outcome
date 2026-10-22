package com.bytedance.android.live.effect.sticker.ui.aigc;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/effect/sticker/ui/aigc/AigcTaskPanelStatusBundleKey;", "", "", "keyName", "Ljava/lang/String;", "getKeyName", "()Ljava/lang/String;", "Keyword", "ShowAnimation", "CanApplyBackgroundImage", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum AigcTaskPanelStatusBundleKey extends Enum<AigcTaskPanelStatusBundleKey> {
    public static final AigcTaskPanelStatusBundleKey CanApplyBackgroundImage = null;
    public static final AigcTaskPanelStatusBundleKey Keyword = null;
    public static final AigcTaskPanelStatusBundleKey ShowAnimation = null;
    public static final /* synthetic */ AigcTaskPanelStatusBundleKey[] a = null;
    private final String keyName;

    static {
        AigcTaskPanelStatusBundleKey r1 = new AigcTaskPanelStatusBundleKey("Keyword", 0, "keyword");
        Keyword = r1;
        AigcTaskPanelStatusBundleKey r2 = new AigcTaskPanelStatusBundleKey("ShowAnimation", 1, "show_animation");
        ShowAnimation = r2;
        AigcTaskPanelStatusBundleKey r3 = new AigcTaskPanelStatusBundleKey("CanApplyBackgroundImage", 2, "can_apply_background_image");
        CanApplyBackgroundImage = r3;
        a = new AigcTaskPanelStatusBundleKey[]{r1, r2, r3};
    }

    public static AigcTaskPanelStatusBundleKey valueOf(String r1) {
        return (AigcTaskPanelStatusBundleKey) r27.a.a(AigcTaskPanelStatusBundleKey.class, r1);
    }

    public static AigcTaskPanelStatusBundleKey[] values() {
        return (AigcTaskPanelStatusBundleKey[]) a.clone();
    }

    public final String getKeyName() {
        return this.keyName;
    }

    public AigcTaskPanelStatusBundleKey(String r1, int r2, String r3) {
        super(r1, r2);
        this.keyName = r3;
    }
}
