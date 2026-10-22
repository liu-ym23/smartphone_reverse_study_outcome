package com.obric.assistant.interaction.impl;

import android.app.Activity;
import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class k implements Runnable {
    public final /* synthetic */ ObricCameraServiceDiffImpl a;
    public final /* synthetic */ Activity b;
    public final /* synthetic */ String c;
    public final /* synthetic */ ViewTreeObserver d;
    public final /* synthetic */ ObricCameraServiceDiffImpl$bindCameraStartupReadyIfNeeded$listener$1 e;

    public /* synthetic */ k(ObricCameraServiceDiffImpl r1, Activity r2, String r3, ViewTreeObserver r4, ObricCameraServiceDiffImpl$bindCameraStartupReadyIfNeeded$listener$1 r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ObricCameraServiceDiffImpl.a(this.a, this.b, this.c, this.d, this.e);
    }
}
