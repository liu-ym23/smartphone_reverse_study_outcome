package com.bytedance.android.live.effect;

import com.bytedance.android.live.effect.api.IMiddlewareEffectServiceDelegate;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.beauty.filter.LiveComposerFilterHelper;
import com.bytedance.android.live.effect.beauty.presets.LiveBeautyPresetsHelper;
import com.bytedance.android.live.effect.soundeffect.LiveSoundEffectHelper;
import com.bytedance.android.live.effect.sticker.presenter.x;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class j implements com.bytedance.android.live.effect.api.j {
    public com.bytedance.android.live.effect.api.k a;
    public com.bytedance.android.live.effect.sticker.presenter.o b;
    public LiveSmallItemBeautyHelper c;
    public com.bytedance.android.live.effect.avadjust.l d;
    public com.bytedance.android.live.effect.beauty.smallitem.d e;
    public com.bytedance.android.live.effect.beauty.newtemp.c f;
    public com.bytedance.android.live.effect.api.d g;
    public com.bytedance.android.live.effect.beauty.makeups.d h;
    public LiveSoundEffectHelper i;
    public com.bytedance.android.live.effect.beauty.body.g j;
    public LiveComposerFilterHelper k;
    public LiveBeautyPresetsHelper l;
    public x m;
    public com.bytedance.android.live.effect.sticker.presenter.s n;
    public com.bytedance.android.live.effect.sticker.presenter.n o;
    public com.bytedance.android.live.effect.beauty.smallitem.c p;
    public com.bytedance.android.live.effect.cameramovement.c q;
    public com.bytedance.android.live.effect.api.l r;
    public final LiveEffectContextFactoryDelegate$Type s;

    @Override // com.bytedance.android.live.effect.api.j
    public final com.bytedance.android.live.effect.api.d a() {
        if (this.g != null) goto L6;
        this.g = ((IMiddlewareEffectServiceDelegate) jc1.k.f(IMiddlewareEffectServiceDelegate.class)).baseEffectService(this.s).d();
    L6:
        return this.g;
    }

    @Override // com.bytedance.android.live.effect.api.j
    public final com.bytedance.android.live.effect.beauty.smallitem.c b() {
        if (this.p != null) goto L6;
        this.p = new com.bytedance.android.live.effect.beauty.smallitem.c(this.s);
    L6:
        return this.p;
    }

    @Override // com.bytedance.android.live.effect.api.j
    public final com.bytedance.android.live.effect.beauty.newtemp.c c() {
        if (this.f != null) goto L6;
        this.f = new com.bytedance.android.live.effect.beauty.newtemp.c(this.s);
    L6:
        return this.f;
    }

    @Override // com.bytedance.android.live.effect.api.j
    public final com.bytedance.android.live.effect.sticker.presenter.o d() {
        if (this.b != null) goto L6;
        this.b = ((IMiddlewareEffectServiceDelegate) jc1.k.f(IMiddlewareEffectServiceDelegate.class)).baseEffectService(this.s).a();
    L6:
        return this.b;
    }

    @Override // com.bytedance.android.live.effect.api.j
    public final LiveBeautyPresetsHelper e() {
        if (this.l != null) goto L6;
        this.l = new LiveBeautyPresetsHelper(this.s);
    L6:
        return this.l;
    }

    @Override // com.bytedance.android.live.effect.api.j
    public final com.bytedance.android.live.effect.beauty.makeups.a f() {
        if (this.h != null) goto L6;
        this.h = new com.bytedance.android.live.effect.beauty.makeups.d(this.s);
    L6:
        return this.h;
    }

    @Override // com.bytedance.android.live.effect.api.j
    public final LiveSmallItemBeautyHelper g() {
        if (this.c != null) goto L6;
        this.c = new LiveSmallItemBeautyHelper(this.s);
    L6:
        return this.c;
    }

    @Override // com.bytedance.android.live.effect.api.j
    public final com.bytedance.android.live.effect.sticker.presenter.n h() {
        if (this.o != null) goto L6;
        this.o = ((IMiddlewareEffectServiceDelegate) jc1.k.f(IMiddlewareEffectServiceDelegate.class)).baseEffectService(this.s).e();
    L6:
        return this.o;
    }

    @Override // com.bytedance.android.live.effect.api.j
    public final com.bytedance.android.live.effect.sticker.presenter.s i() {
        if (this.n != null) goto L6;
        this.n = new com.bytedance.android.live.effect.sticker.presenter.s();
    L6:
        return this.n;
    }

    @Override // com.bytedance.android.live.effect.api.j
    public final com.bytedance.android.live.effect.api.l j() {
        if (this.r != null) goto L6;
        this.r = ((IMiddlewareEffectServiceDelegate) jc1.k.f(IMiddlewareEffectServiceDelegate.class)).baseEffectService(this.s).f();
    L6:
        return this.r;
    }

    @Override // com.bytedance.android.live.effect.api.j
    public final com.bytedance.android.live.effect.cameramovement.a k() {
        if (this.q != null) goto L6;
        this.q = new com.bytedance.android.live.effect.cameramovement.c(this.s);
    L6:
        return this.q;
    }

    @Override // com.bytedance.android.live.effect.api.j
    public final com.bytedance.android.live.effect.beauty.smallitem.d l() {
        if (this.e != null) goto L6;
        this.e = new com.bytedance.android.live.effect.beauty.smallitem.d(this.s);
    L6:
        return this.e;
    }

    @Override // com.bytedance.android.live.effect.api.j
    public final LiveComposerFilterHelper m() {
        if (this.k != null) goto L6;
        this.k = new LiveComposerFilterHelper(this.s);
    L6:
        return this.k;
    }

    @Override // com.bytedance.android.live.effect.api.j
    public final com.bytedance.android.live.effect.avadjust.l n() {
        if (this.d != null) goto L6;
        this.d = new com.bytedance.android.live.effect.avadjust.l(this.s);
    L6:
        return this.d;
    }

    @Override // com.bytedance.android.live.effect.api.j
    public final LiveSoundEffectHelper o() {
        if (this.i != null) goto L6;
        this.i = new LiveSoundEffectHelper(this.s);
    L6:
        return this.i;
    }

    @Override // com.bytedance.android.live.effect.api.j
    public final com.bytedance.android.live.effect.beauty.body.g p() {
        if (this.j != null) goto L6;
        this.j = new com.bytedance.android.live.effect.beauty.body.g(this.s);
    L6:
        return this.j;
    }

    @Override // com.bytedance.android.live.effect.api.j
    public final x q() {
        if (this.m != null) goto L6;
        this.m = new x();
    L6:
        return this.m;
    }

    @Override // com.bytedance.android.live.effect.api.j
    public final com.bytedance.android.live.effect.api.k r() {
        if (this.a != null) goto L6;
        this.a = ((IMiddlewareEffectServiceDelegate) jc1.k.f(IMiddlewareEffectServiceDelegate.class)).baseEffectService(this.s).b();
    L6:
        return this.a;
    }

    public j(LiveEffectContextFactoryDelegate$Type r2) {
        new HashMap();
        this.s = r2;
    }
}
