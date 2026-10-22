package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.MultiSceneOpt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class kc0 extends SSettingKey<MultiSceneOpt> {
    public static final kc0 a = null;

    static {
        a = new kc0();
    }

    public kc0() {
        super("live_multi_scene_opt", "多人场景的体验优化开关", new MultiSceneOpt(), new MultiSceneOpt(), true);
    }
}
