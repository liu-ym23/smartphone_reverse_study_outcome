package com.bytedance.ies.bullet.lynx.resource.forest;

import com.bytedance.forest.model.Scene;
import com.bytedance.forest.model.w;
import java.util.concurrent.Callable;
import kotlin.Unit;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ w f5750a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ln.a f5751b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ b f5752c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;

    public a(w r5, ln.a r10, b r11, String r12, String r13) {
        this.f5750a = r5;
        this.f5751b = r10;
        this.f5752c = r11;
        this.d = r12;
        this.e = r13;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        w r5 = this.f5750a;
        b r10 = this.f5752c;
        ln.a r11 = this.f5751b;
        byte[] r12 = r5.k();     // Catch: Throwable -> L12
        if (r12 != null) goto L6;
    L14:
        r10.getClass();     // Catch: Throwable -> L12
        if (u8.a.a(r5) == null) goto L17;
        String r13 = this.d;     // Catch: Throwable -> L12
        String r14 = this.e;     // Catch: Throwable -> L12
        r10.getClass();     // Catch: Throwable -> L12
        zm.c r15 = com.bytedance.ies.bullet.forest.f.f5397a;     // Catch: Throwable -> L12
        com.bytedance.ies.bullet.forest.f.e(r13, r10.f5753a, Scene.f4347c, r10.f5754b, null, null, new ForestDynamicComponentProvider$loadResource$1(r14, r11, r10, r13), 225);     // Catch: Throwable -> L12
        int r16 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;     // Catch: Throwable -> L12
        r10.getClass();     // Catch: Throwable -> L12
        com.bytedance.ies.bullet.base.utils.logger.a.g("ForestDynamicComponentProvider", "reload dynamic resource", null, 12);     // Catch: Throwable -> L12
    L22:
    L21:
        return Unit.INSTANCE;
    L17:
        ((zm.c) r11).m(null, new Throwable("Forest stream empty"));     // Catch: Throwable -> L12
        goto L22
    L6:
        if (r12.length != 0) goto L8;
        boolean r17 = true;
    L10:
        if ((!r17) != true) goto L14;
        ((zm.c) r11).m(r12, null);     // Catch: Throwable -> L12
        goto L22
    L8:
        r17 = false;
    L12:
        th = move-exception;
        ((zm.c) r11).m(null, th);
        goto L21
    }
}
