package com.lynx.tasm.image;

import android.os.Handler;
import com.lynx.tasm.behavior.LayoutNodeManager;
import com.lynx.tasm.behavior.c0;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import wn.a;

/* JADX INFO: loaded from: classes2.dex */
public class AutoSizeImage extends ShadowNode {
    public a A;
    public String B;
    public final Object C;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f10884v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f10885w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f10886x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f10887y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Handler f10888z;

    public AutoSizeImage() {
        this.f10884v = false;
        this.f10887y = true;
        this.C = new Object();
        this.f = this;
        LayoutNodeManager r5 = this.f10334a;
        if (r5 == null) goto L6;
        this.f10336c = true;
        r5.d(this.f10335b, this);
        return;
    }

    public static void t(AutoSizeImage r5, boolean r10, int r11, int r12, int r13, int r14) {
        boolean r15 = r5.f10884v;
        r5.f10884v = r10;
        r5.f10885w = r11;
        r5.f10886x = r12;
        if (r11 != 0) goto L6;
        if (r12 != 0) goto L6;
        return;
    L6:
        if (r15 == r10) goto L10;
        r5.n();
        return;
    L10:
        if (r5.f10887y == true) goto L26;
        if (r10 == false) goto L21;
        if (r11 <= 0) goto L22;
        if (r12 <= 0) goto L23;
        if (r13 == 0) goto L19;
        if (r14 == 0) goto L19;
        if (Math.abs((r13 / r14) - (r11 / r12)) > 0.05d) goto L19;
        return;
    L19:
        r5.n();
        return;
    L23:
        return;
    L22:
        return;
    L21:
        return;
    }

    public final void s(int r13, int r14, int r15, int r16, boolean r17) {
        Object r10 = this.C;
        monitor-enter(r10);
        Handler r11 = this.f10888z;     // Catch: Throwable -> L7
        if (r11 != null) goto L9;
        this.A = new a(this, r17, r13, r14, r15, r16, 0);     // Catch: Throwable -> L7
    L10:
        monitor-exit(r10);     // Catch: Throwable -> L7
        return;
    L9:
        r11.post(new a(this, r17, r13, r14, r15, r16, 1));     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    @c0(name = "src")
    public void setSrc(String r5) {
        this.B = r5;
    }
}
