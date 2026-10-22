package com.bytedance.android.live.recharge.panel;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/recharge/panel/RechargeBizScene;", "", "", "scene", "I", "getScene", "()I", "SCENE_NORMAL", "SCENE_PK_NOPASSWORD", "SCENE_FANS_NOPASSWORD", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum RechargeBizScene extends Enum<RechargeBizScene> {
    public static final RechargeBizScene SCENE_FANS_NOPASSWORD = null;
    public static final RechargeBizScene SCENE_NORMAL = null;
    public static final RechargeBizScene SCENE_PK_NOPASSWORD = null;
    public static final /* synthetic */ RechargeBizScene[] a = null;
    private final int scene;

    static {
        RechargeBizScene r1 = new RechargeBizScene("SCENE_NORMAL", 0, 0);
        SCENE_NORMAL = r1;
        RechargeBizScene r2 = new RechargeBizScene("SCENE_PK_NOPASSWORD", 1, 1);
        SCENE_PK_NOPASSWORD = r2;
        RechargeBizScene r3 = new RechargeBizScene("SCENE_FANS_NOPASSWORD", 2, 2);
        SCENE_FANS_NOPASSWORD = r3;
        a = new RechargeBizScene[]{r1, r2, r3};
    }

    public static RechargeBizScene valueOf(String r1) {
        return (RechargeBizScene) r27.a.a(RechargeBizScene.class, r1);
    }

    public static RechargeBizScene[] values() {
        return (RechargeBizScene[]) a.clone();
    }

    public final int getScene() {
        return this.scene;
    }

    public RechargeBizScene(String r1, int r2, int r3) {
        super(r1, r2);
        this.scene = r3;
    }
}
