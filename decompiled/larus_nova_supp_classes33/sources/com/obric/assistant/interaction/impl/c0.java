package com.obric.assistant.interaction.impl;

import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class c0 implements Runnable {
    public final /* synthetic */ ObricRealtimeCallExtServiceImpl a;
    public final /* synthetic */ ViewTreeObserver b;
    public final /* synthetic */ ObricRealtimeCallExtServiceImpl$bindRealtimeCallStartupReadyIfNeeded$listener$1 c;

    public /* synthetic */ c0(ObricRealtimeCallExtServiceImpl r1, ViewTreeObserver r2, ObricRealtimeCallExtServiceImpl$bindRealtimeCallStartupReadyIfNeeded$listener$1 r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ObricRealtimeCallExtServiceImpl.c(this.a, this.b, this.c);
    }
}
