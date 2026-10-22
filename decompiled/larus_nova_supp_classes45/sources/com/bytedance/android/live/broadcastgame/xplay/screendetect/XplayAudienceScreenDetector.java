package com.bytedance.android.live.broadcastgame.xplay.screendetect;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.view.SurfaceView;
import com.bytedance.android.live.platformplayer.LivePlatformPlayerManager;
import com.bytedance.android.livesdk.config.ik1;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.view.IRenderView;
import com.bytedance.android.livesdkapi.view.LivePlayerPixelCopy;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class XplayAudienceScreenDetector extends com.bytedance.android.live.broadcastgame.xplay.screendetect.a {
    public static final /* synthetic */ int f = 0;
    public b d;
    public Handler e;

    public static final class a {
    }

    public static final class b extends PthreadHandlerThreadV2 {
        public final /* synthetic */ XplayAudienceScreenDetector c;

        public final void onLooperPrepared() {
            XplayAudienceScreenDetector r0 = this.c;
            Looper r1 = getLooper();
            r0.getClass();
            r0.e = new g(r0, r1);
            Handler r2 = this.c.e;
            if (r2 == null) goto L6;
            r2.sendEmptyMessage(2);
            return;
        }

        public b(XplayAudienceScreenDetector r1) {
            this.c = r1;
            super("xplay_black_screen_detect");
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.broadcastgame.xplay.screendetect.a
    public final void f() {
        b("stop black screen detect");
        Handler r0 = this.e;
        if (r0 == null) goto L5;
        r0.removeCallbacksAndMessages(null);
    L5:
        this.e = null;
        b r1 = this.d;
        if (r1 == null) goto L8;
        r1.quit();
    L8:
        this.d = null;
        e.f.getClass();
        Bitmap r2 = e.c;
        if (r2 == null) goto L11;
        r2.recycle();
    L11:
        e.c = null;
        e.d = null;
        e.e = null;
    }

    public final ik1.b i() {
        return this.a.b();
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.bytedance.android.live.broadcastgame.xplay.screendetect.XplayAudienceScreenDetector$b, java.lang.Thread] */
    @Override // com.bytedance.android.live.broadcastgame.xplay.screendetect.a
    public final void e() {
        if (i().c() == true) goto L5;
        return;
    L5:
        b("start black screen detect");
        ?? r0 = new b(this);
        this.d = r0;
        ThreadMethodProxy.start(r0);
        e r1 = e.f;
        XplayAudienceScreenDetector$onStart$2 r2 = new XplayAudienceScreenDetector$onStart$2(this);
        r1.getClass();
        e.e = r2;
    }

    public XplayAudienceScreenDetector(c r1) {
        super(r1);
    }

    public static final void h(final XplayAudienceScreenDetector r8, Handler r9) {
        r8.getClass();
        ILivePlayerClient r0 = LivePlatformPlayerManager.f();
        if (r0 == null) goto L5;
        IRenderView r1 = r0.getRenderView();
    L7:
        if ((r1 instanceof SurfaceView) == true) goto L9;
        r8.b("not surface view");
        return;
    L9:
        r8.b("start detect");
        final long r2 = System.currentTimeMillis();
        e r4 = e.f;
        SurfaceView r3 = (SurfaceView) r1;
        float r5 = r8.i().b();
        boolean r6 = r8.i().f();
        Function1<Bitmap, Unit> r7 = new XplayAudienceScreenDetector$startDetectBlackScreen$1(r8, r2);
        Bitmap.Config r11 = e.b;
        r4.getClass();
        Intrinsics.checkNotNullParameter(r3, "surfaceView");
        Intrinsics.checkNotNullParameter(r11, "bitmapConfig");
        Intrinsics.checkNotNullParameter(r9, "handler");
        Intrinsics.checkNotNullParameter(r7, "callback");
        boolean r12 = e.a;
        if (r12 == false) goto L36;
        int r13 = (int) (r3.getWidth() * r5);
        int r14 = (int) (r3.getHeight() * r5);
        Bitmap r15 = e.c;
        if (r15 == null) goto L28;
        if (r6 == true) goto L15;
    L23:
        boolean r16 = false;
    L24:
        if (r16 == true) goto L27;
        r15 = null;
    L27:
        if (r15 == null) goto L28;
    L33:
        if (e.d(r3) == false) goto L35;
        LivePlayerPixelCopy.Companion.request(r3, r15, new d(r7, r15), r9);
        return;
    L35:
        r7.invoke(null);
        return;
    L15:
        if (r15.getWidth() != r13) goto L23;
        if (r15.getHeight() != r14) goto L23;
        if (r15.getConfig() != r11) goto L23;
        if (r15.isRecycled() == true) goto L23;
        r16 = true;
    L28:
        Bitmap r17 = e.c;
        if (r17 == null) goto L31;
        r17.recycle();
    L31:
        r15 = Bitmap.createBitmap(r13, r14, r11);
        e.c = r15;
        goto L33
    L36:
        Function1<? super String, Unit> r18 = e.e;
        if (r18 == null) goto L39;
        Unit r19 = (Unit) r18.invoke("capture failed, sdkEnable: " + r12 + ", surfaceValid: " + e.d(r3));
    L39:
        r7.invoke(null);
        return;
    L5:
        r1 = null;
        goto L7
    }
}
