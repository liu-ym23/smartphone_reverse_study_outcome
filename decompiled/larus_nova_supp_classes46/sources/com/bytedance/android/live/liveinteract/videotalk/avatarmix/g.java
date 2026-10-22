package com.bytedance.android.live.liveinteract.videotalk.avatarmix;

import android.graphics.Matrix;
import com.bytedance.android.livesdk.live.extension.plugin.api.livepusher.ILiveWrappedLivePusher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g {
    public static final /* synthetic */ int a = 0;

    static {
        Matrix r0 = new Matrix();
        r0.preTranslate(0.5f, 0.5f);
        r0.preScale(1.0f, -1.0f);
        r0.preTranslate(-0.5f, -0.5f);
        ILiveWrappedLivePusher.Companion.getClass();
        ILiveWrappedLivePusher r1 = ILiveWrappedLivePusher.a.b();
        if (r1 == null) goto L6;
        r1.getRendererCommon();
        return;
    }
}
