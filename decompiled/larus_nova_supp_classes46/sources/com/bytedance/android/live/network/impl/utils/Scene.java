package com.bytedance.android.live.network.impl.utils;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006j\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/network/impl/utils/Scene;", "", "", "scene", "Ljava/lang/String;", "getScene", "()Ljava/lang/String;", "desc", "getDesc", "SCENE_INNER_DRAW", "livecore_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum Scene extends Enum<Scene> {
    public static final Scene SCENE_INNER_DRAW = null;
    public static final /* synthetic */ Scene[] a = null;
    private final String desc;
    private final String scene;

    static {
        Scene r1 = new Scene();
        SCENE_INNER_DRAW = r1;
        a = new Scene[]{r1};
    }

    public static Scene valueOf(String r1) {
        return (Scene) r27.a.a(Scene.class, r1);
    }

    public static Scene[] values() {
        return (Scene[]) a.clone();
    }

    public Scene() {
        super("SCENE_INNER_DRAW", 0);
        this.scene = "inner_draw";
        this.desc = "内流";
    }

    public final String getDesc() {
        return this.desc;
    }

    public final String getScene() {
        return this.scene;
    }
}
