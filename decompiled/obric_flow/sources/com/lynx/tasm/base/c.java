package com.lynx.tasm.base;

import android.os.Looper;
import android.os.Message;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends PhantomReference {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ReferenceQueue f10120c = null;
    public static final Object d = null;
    public static final HashSet e = null;
    public static final ConcurrentHashMap.KeySetView f = null;
    public static final ConcurrentLinkedQueue g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f10121a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Runnable f10122b;

    static {
        f10120c = new ReferenceQueue();
        d = new Object();
        am.a r5 = new am.a("CleanupReference", 1);
        r5.setDaemon(true);
        r5.start();
        e = new HashSet();
        f = ConcurrentHashMap.newKeySet();
        g = new ConcurrentLinkedQueue();
    }

    public c(com.lynx.tasm.g r5, Runnable r10) {
        super(r5, f10120c);
        this.f10122b = r10;
        this.f10121a = true;
        Message r11 = Message.obtain(b.f10119a, 1, this);
        if (Looper.myLooper() != r11.getTarget().getLooper()) goto L6;
        r11.getTarget().handleMessage(r11);
        r11.recycle();
        return;
    L6:
        r11.sendToTarget();
    }
}
