package com.lynx.tasm.fontface;

import com.bytedance.salamander.anniex.b0;
import com.lynx.tasm.behavior.LynxContext;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends fo.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String[] f10860a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f10861b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ LynxContext f10862c;
    public final /* synthetic */ g d;

    public d(g r5, String[] r10, String r11, LynxContext r12) {
        this.d = r5;
        this.f10860a = r10;
        this.f10861b = r11;
        this.f10862c = r12;
    }

    @Override // fo.g
    public final void a(b0 r5) {
        Object r10 = r5.d;
        String r11 = (String) r10;
        if (r10 == null) goto L6;
        this.f10860a[0] = r11;
        return;
    L6:
        String r12 = ((Throwable) r5.f7247c).getMessage();
        this.d.getClass();
        LynxContext r13 = this.f10862c;
        g.c(30202, r12, this.f10861b, null, r13);
    }
}
