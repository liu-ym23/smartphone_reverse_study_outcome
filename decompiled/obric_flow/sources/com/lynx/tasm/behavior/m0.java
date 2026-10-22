package com.lynx.tasm.behavior;

import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.mapbuffer.ReadableMapBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class m0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10281a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f10282b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ReadableMap f10283c;
    public final /* synthetic */ ReadableMapBuffer d;
    public final /* synthetic */ ReadableArray e;
    public final /* synthetic */ boolean f;
    public final /* synthetic */ int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ ReadableArray f10284h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ n0 f10285i;

    public m0(n0 r5, int r10, String r11, ReadableMap r12, ReadableMapBuffer r13, ReadableArray r14, boolean r15, int r16, ReadableArray r17) {
        this.f10285i = r5;
        this.f10281a = r10;
        this.f10282b = r11;
        this.f10283c = r12;
        this.d = r13;
        this.e = r14;
        this.f = r15;
        this.g = r16;
        this.f10284h = r17;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r10 = this.g;
        ReadableArray r11 = this.f10284h;
        this.f10285i.l(this.f10281a, this.f10282b, this.f10283c, this.d, this.e, this.f, r10, r11);
    }
}
