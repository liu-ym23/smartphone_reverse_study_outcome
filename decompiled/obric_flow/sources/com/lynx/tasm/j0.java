package com.lynx.tasm;

import java.util.HashMap;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes2.dex */
public final class j0 implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10889a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f10890b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f10891c;

    public j0(int r5, int r10, boolean r11) {
        this.f10889a = r5;
        this.f10890b = r10;
        this.f10891c = r11;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        HashMap r5 = new HashMap();
        r5.put("widthMeasureSpec", String.valueOf(this.f10889a));
        r5.put("heightMeasureSpec", String.valueOf(this.f10890b));
        r5.put("needLayout", String.valueOf(this.f10891c));
        return r5;
    }
}
