package com.bytedance.awemeopen.infra.plugs.lotties;

import android.graphics.drawable.Drawable;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.bytedance.awemeopen.infra.base.anim.lottie.AoAnimConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class j implements com.bytedance.awemeopen.servicesapi.ui.d {
    public final LottieDrawable a;

    public j() {
        LottieDrawable r0 = new LottieDrawable();
        Intrinsics.checkNotNullParameter(r0, "lottieDrawable");
        this.a = r0;
    }

    @Override // com.bytedance.awemeopen.servicesapi.ui.d
    public final void b() {
        LottieDrawable r0 = this.a;
        u0.c r1 = r0.c;
        if (r1.k == false) goto L5;
        r1.cancel();
    L5:
        r0.b = null;
        r0.o = null;
        r0.i = null;
        u0.c r2 = r0.c;
        r2.j = null;
        r2.h = -2.1474836E9f;
        r2.i = 2.1474836E9f;
        r0.invalidateSelf();
    }

    @Override // com.bytedance.awemeopen.servicesapi.ui.d
    public final void cancelAnimation() {
        this.a.c();
    }

    @Override // com.bytedance.awemeopen.servicesapi.ui.d
    public final void e() {
        this.a.c.removeAllListeners();
    }

    @Override // com.bytedance.awemeopen.servicesapi.ui.d
    public final float getScale() {
        return this.a.d;
    }

    @Override // com.bytedance.awemeopen.servicesapi.ui.d
    public final boolean isRunning() {
        return this.a.h();
    }

    @Override // com.bytedance.awemeopen.servicesapi.ui.d
    public final void start() {
        this.a.start();
    }

    @Override // com.bytedance.awemeopen.servicesapi.ui.d
    public final void stop() {
        this.a.d();
    }

    @Override // com.bytedance.awemeopen.servicesapi.ui.d
    public final LottieDrawable getDrawable() {
        return this.a;
    }

    @Override // com.bytedance.awemeopen.servicesapi.ui.d
    public final void a(AoAnimConfig.b r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.a.c.addListener(r2);
    }

    @Override // com.bytedance.awemeopen.servicesapi.ui.d
    public final void c(String r2) {
        Intrinsics.checkNotNullParameter(r2, "str");
        this.a.j = r2;
    }

    @Override // com.bytedance.awemeopen.servicesapi.ui.d
    public final void d(Drawable.Callback r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.a.setCallback(r2);
    }

    @Override // com.bytedance.awemeopen.servicesapi.ui.d
    public final void g(int r2) {
        this.a.c.setRepeatMode(r2);
    }

    @Override // com.bytedance.awemeopen.servicesapi.ui.d
    public final void h(com.bytedance.awemeopen.servicesapi.ui.a r2) {
        Intrinsics.checkNotNullParameter(r2, "lottieWrapperDrawable");
        LottieComposition r3 = r2.getComposition();
        if ((r3 instanceof LottieComposition) == false) goto L7;
        this.a.m(r3);
        return;
    L7:
        throw new IllegalStateException("illegal state");
    }

    @Override // com.bytedance.awemeopen.servicesapi.ui.d
    public final void setFrame(int r2) {
        this.a.o(r2);
    }

    @Override // com.bytedance.awemeopen.servicesapi.ui.d
    public final void setRepeatCount(int r2) {
        this.a.w(r2);
    }

    @Override // com.bytedance.awemeopen.servicesapi.ui.d
    public final void setScale(float r2) {
        LottieDrawable r0 = this.a;
        r0.d = r2;
        r0.x();
    }

    @Override // com.bytedance.awemeopen.servicesapi.ui.d
    public final void f(int r2, int r3) {
        this.a.r(r2, r3);
    }
}
