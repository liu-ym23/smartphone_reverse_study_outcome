package com.bytedance.lego.init;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static IdleTaskConfig f6734a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ArrayList f6735b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ArrayList f6736c = null;
    public static volatile AtomicInteger d;
    public static int e;
    public static final Handler f = null;
    public static volatile boolean g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final h f6737h = null;

    static {
        IdleTaskConfig.Companion.getClass();
        f6734a = IdleTaskConfig.access$getDEFAULT_IDLETASK_CONFIG$cp();
        f6735b = new ArrayList();
        f6736c = new ArrayList();
        d = new AtomicInteger(0);
        f = new Handler(Looper.getMainLooper());
        f6737h = new h();
    }

    public static void a() {
        if (InitScheduler.INSTANCE.getConfig$initscheduler_release().isMainProcess() == true) goto L6;
        return;
    L6:
        if (g == false) goto L8;
        return;
    L8:
        g = true;
        ArrayList r5 = f6735b;
        LinkedList r10 = o.f6771i;
        boolean r11 = r10.isEmpty();
        LinkedList r12 = o.f6770h;
        if (r11 == false) goto L11;
        r12.isEmpty();
    L11:
        r5.addAll(r12);
        ArrayList r13 = f6736c;
        if (r10.isEmpty() == false) goto L14;
        r12.isEmpty();
    L14:
        r13.addAll(r10);
        int r14 = r5.size();
        int r15 = r13.size() + r14;
        e = r15;
        if (r15 != 0) goto L17;
        return;
    L17:
        Looper.myQueue().addIdleHandler(f6737h);
    }
}
