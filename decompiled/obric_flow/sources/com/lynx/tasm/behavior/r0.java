package com.lynx.tasm.behavior;

import com.lynx.react.bridge.mapbuffer.ReadableMapBuffer;
import com.lynx.tasm.behavior.ui.PropBundle;

/* JADX INFO: loaded from: classes2.dex */
public final class r0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10324a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f10325b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ PropBundle f10326c;
    public final /* synthetic */ ReadableMapBuffer d;
    public final /* synthetic */ boolean e;
    public final /* synthetic */ int f;
    public final /* synthetic */ PaintingContext g;

    public r0(PaintingContext r5, int r10, String r11, PropBundle r12, ReadableMapBuffer r13, boolean r14, int r15) {
        this.g = r5;
        this.f10324a = r10;
        this.f10325b = r11;
        this.f10326c = r12;
        this.d = r13;
        this.e = r14;
        this.f = r15;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean r5 = this.e;
        int r10 = this.f;
        this.g.createPaintingNodeSync(this.f10324a, this.f10325b, this.f10326c, this.d, r5, r10);
    }
}
