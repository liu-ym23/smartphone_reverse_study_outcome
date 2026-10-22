package com.lynx.tasm.ui.image;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes2.dex */
public final class d0 extends HandlerThread {
    public static volatile d0 e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LinkedList f11036a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LinkedList f11037b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Handler f11038c;
    public Handler d;

    public static d0 a() {
        if (e != null) goto L16;
        monitor-enter(d0.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (e != null) goto L11;
        d0 r5 = new d0("Lynx_image");     // Catch: Throwable -> L9
        r5.start();     // Catch: Throwable -> L9
        e = r5;     // Catch: Throwable -> L9
    L11:
        monitor-exit(d0.class);     // Catch: Throwable -> L9
    L16:
        return e;
    }

    @Override // android.os.HandlerThread
    public final void onLooperPrepared() {
        super.onLooperPrepared();
        new Handler(Looper.getMainLooper()).post(new h(this, 4));
    }
}
