package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.LivePreviewStreamSurfaceViewConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class xj0 extends SSettingKey<LivePreviewStreamSurfaceViewConfig> {
    public static final xj0 a = null;

    static {
        a = new xj0();
    }

    public xj0() {
        super("live_preview_surface_render", "预览流SurfaceView", new LivePreviewStreamSurfaceViewConfig(), new LivePreviewStreamSurfaceViewConfig());
    }
}
