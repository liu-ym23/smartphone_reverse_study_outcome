package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;
import com.bytedance.android.livesdkapi.model.EnterLeaveSurfaceRenderOpt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h1 extends SSettingKey<EnterLeaveSurfaceRenderOpt> {
    public static final h1 a = null;

    static {
        a = new h1();
    }

    public h1() {
        super("live_enter_leave_switch_surface_render_opt", "直播进退房切换surface渲染优化", new EnterLeaveSurfaceRenderOpt(), new EnterLeaveSurfaceRenderOpt());
    }
}
