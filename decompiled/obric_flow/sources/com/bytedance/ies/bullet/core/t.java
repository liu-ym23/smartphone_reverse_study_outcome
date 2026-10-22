package com.bytedance.ies.bullet.core;

import android.content.Context;
import javax.xml.transform.Transformer;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class t extends vc.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f5355a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.bytedance.ies.bullet.lynx.h f5356b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f5357c;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f5358h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f5359i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f5360j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public com.bytedance.salamander.anniex.n f5361k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f5362l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f5363m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f5364n;

    @Override // vc.c
    public final void b(com.bytedance.ies.bullet.lynx.h r5) {
        this.e = true;
    }

    @Override // vc.b, vc.c
    public final void d(com.bytedance.ies.bullet.lynx.h r5) {
        this.f5364n = true;
    }

    @Override // vc.b, vc.c
    public final void e(com.bytedance.ies.bullet.lynx.h r5, com.bytedance.salamander.anniex.n r10) {
        this.f5360j = true;
        this.f5361k = r10;
    }

    @Override // vc.b, vc.c
    public final void g(com.bytedance.ies.bullet.lynx.h r5, String r10) {
        this.f5355a = true;
        this.f5356b = r5;
        this.f5357c = r10;
    }

    @Override // vc.b, vc.c
    public final void h(com.bytedance.ies.bullet.lynx.h r5) {
        this.f5359i = true;
    }

    @Override // vc.b, vc.c
    public final void j(com.bytedance.ies.bullet.lynx.h r5, String r10) {
        this.g = true;
        this.f5358h = r10;
    }

    @Override // vc.b, vc.c
    public final void l(com.bytedance.ies.bullet.lynx.h r5) {
        this.f = true;
    }

    @Override // vc.b, vc.c
    public final void m(com.bytedance.ies.bullet.lynx.h r5) {
        this.d = true;
    }

    @Override // vc.b, vc.c
    public final void n(com.bytedance.ies.bullet.lynx.h r5) {
        this.f5363m = true;
    }

    @Override // vc.b, vc.c
    public final void o(com.bytedance.ies.bullet.lynx.h r5) {
        this.f5362l = true;
    }

    @Override // vc.b, vc.c
    public final void p(com.bytedance.ies.bullet.lynx.h r5, Context r10, String r11, String r12, float r13, float r14, Transformer r15, Function2 r16) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r16, "handler");
    }

    @Override // vc.b, vc.c
    public final String shouldRedirectImageUrl(String r5) {
        return null;
    }
}
