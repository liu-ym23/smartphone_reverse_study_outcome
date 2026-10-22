package com.obric.oui.animation.easy;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements uq.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f11943a;

    public c(d r5) {
        this.f11943a = r5;
    }

    @Override // uq.c
    public final void a(uq.d r5, float r10, float r11) {
        uq.c r12 = this.f11943a.g;
        if (r12 == null) goto L7;
        r12.a(r5, r10, r11);
        return;
    }
}
