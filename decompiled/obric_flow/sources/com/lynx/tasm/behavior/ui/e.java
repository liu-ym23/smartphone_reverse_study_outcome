package com.lynx.tasm.behavior.ui;

import android.graphics.Rect;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LynxBaseUI f10449a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f10450b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Rect f10451c;
    public boolean d;

    public e(LynxBaseUI r5, Rect r10) {
        this.f10449a = r5;
        this.f10450b = null;
        this.f10451c = r10;
    }

    public e(View r5, Rect r10) {
        this.f10449a = null;
        this.f10450b = r5;
        this.f10451c = r10;
    }
}
