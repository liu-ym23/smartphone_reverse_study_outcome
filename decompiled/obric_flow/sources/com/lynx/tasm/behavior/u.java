package com.lynx.tasm.behavior;

import android.view.View;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.tasm.core.JSProxy;
import com.obric.common.oea.style.scene.alpha.alphaplayer.widget.AlphaVideoGLSurfaceView;
import com.obric.common.oea.style.scene.alpha.alphaplayer.widget.AlphaVideoGLTextureView;

/* JADX INFO: loaded from: classes2.dex */
public final class u implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10377a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f10378b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f10379c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ Object e;

    public /* synthetic */ u(xp.b r5, int r10, int r11, View r12, int r13) {
        this.f10377a = r13;
        this.d = r5;
        this.f10378b = r10;
        this.f10379c = r11;
        this.e = r12;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f10377a) {
            case 0: goto L8;
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        float r5 = this.f10378b;
        float r10 = this.f10379c;
        AlphaVideoGLTextureView r11 = (AlphaVideoGLTextureView) this.e;
        ((xp.c) ((xp.b) this.d)).c(r5, r10, r11.f11357l, r11.f11358m);
        return;
    L6:
        float r12 = this.f10378b;
        float r13 = this.f10379c;
        AlphaVideoGLSurfaceView r14 = (AlphaVideoGLSurfaceView) this.e;
        ((xp.c) ((xp.b) this.d)).c(r12, r13, r14.getMVideoWidth(), r14.getMVideoHeight());
        return;
    L8:
        JSProxy r15 = (JSProxy) ((w) this.e).f10807x.get();
        if (r15 == null) goto L12;
        r15.b(this.f10378b, this.f10379c, (JavaOnlyMap) this.d);
        return;
    }

    public u(w r5, int r10, int r11, JavaOnlyMap r12) {
        this.f10377a = 0;
        this.e = r5;
        this.f10378b = r10;
        this.f10379c = r11;
        this.d = r12;
    }
}
