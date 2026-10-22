package com.bytedance.android.live.liveinteract.plantform.core;

import android.view.SurfaceView;
import android.view.TextureView;
import com.bytedance.android.livesdk.live.extension.plugin.api.livepusher.ILiveWrappedLivePusher;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h0 implements Runnable {
    public final /* synthetic */ RtcManager a;

    public h0(RtcManager r1) {
        this.a = r1;
    }

    public final void a() {
        v r0 = this.a.c;
        if (r0 == null) goto L5;
        r0.o();
    L5:
        Iterator<eg6.c> r1 = this.a.e.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        r1.next().i(this.a.J.getInteractId());
        goto L7
    L9:
        Iterator r2 = ((LinkedHashMap) this.a.A).entrySet().iterator();
    L11:
        if (r2.hasNext() == false) goto L35;
        Map.Entry r3 = (Map.Entry) r2.next();
        String r4 = (String) r3.getKey();
        yb6.j r5 = (yb6.j) r3.getValue();
        Object r6 = r5.a;
        if ((r6 instanceof SurfaceView) == true) goto L14;
        if ((r6 instanceof TextureView) == true) goto L22;
        ILiveWrappedLivePusher.Companion.getClass();
        ILiveWrappedLivePusher r7 = ILiveWrappedLivePusher.a.b();
        if (r7 == null) goto L31;
        uf2.z.a r8 = r7.buildLayerControlLayer(r5.a);
    L32:
        v r9 = this.a.c;
        if (r9 == null) goto L11;
        r9.b4(r4, r8, r5.b, r5.c);
        goto L11
    L31:
        r8 = null;
        goto L32
    L22:
        v r10 = this.a.c;
        if (r10 == null) goto L11;
        if (r6 == null) goto L27;
        r10.L0(r4, (TextureView) r6, r5.b, r5.c);
        goto L11
    L27:
        throw new NullPointerException("null cannot be cast to non-null type android.view.TextureView");
    L14:
        v r11 = this.a.c;
        if (r11 == null) goto L11;
        if (r6 == null) goto L19;
        r11.h1(r4, (SurfaceView) r6, r5.b, r5.c);
        goto L11
    L19:
        throw new NullPointerException("null cannot be cast to non-null type android.view.SurfaceView");
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
