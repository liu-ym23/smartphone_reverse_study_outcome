package com.bytedance.android.live.broadcastgame.opengame.utils;

import android.graphics.Bitmap;
import com.bytedance.android.live.broadcastgame.opengame.runtime.PluginContext;
import com.bytedance.bdp.serviceapi.hostimpl.hostmethod.BdpInteractHostMethodService;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h {
    public static final /* synthetic */ int a = 0;

    public interface a {
        void onFail();

        void onSuccess(Bitmap r1);
    }

    static {
    }

    public static void a(String r0, int r1, int r2, final PluginContext.b r3) {
        Intrinsics.checkNotNullParameter(r0, "appid");
        Intrinsics.checkNotNullParameter(r3, "processorListener");
        BdpInteractHostMethodService r4 = com.bytedance.bdp.live.livecontainer.sonicgame.f.a;
        new ImageUtils$getBlurBackground$1(r3);
        Function1<Throwable, Unit> r5 = new ImageUtils$getBlurBackground$2(r3);
        BdpInteractHostMethodService r6 = com.bytedance.bdp.live.livecontainer.sonicgame.f.a;
        if (r6 != null) goto L5;
        r5.invoke(new IllegalStateException("BdpInteractHostMethodService is null"));
        return;
    L5:
        r6.p();
    }
}
