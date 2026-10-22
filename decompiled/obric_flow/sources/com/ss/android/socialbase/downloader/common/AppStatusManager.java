package com.ss.android.socialbase.downloader.common;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class AppStatusManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Application f15258a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f15259b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f15260c;
    public volatile int d;
    public final Application.ActivityLifecycleCallbacks e;

    public interface AppStatusChangeListener {
        void a();

        void b();
    }

    public static class Holder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final AppStatusManager f15262a = null;

        static {
            f15262a = new AppStatusManager();
        }
    }

    public AppStatusManager() {
        this.f15259b = new ArrayList();
        this.d = -1;
        this.e = new AnonymousClass1(this);
    }

    public static AppStatusManager b() {
        return Holder.f15262a;
    }

    public final void a(Context r5) {
        if (this.f15258a == null) goto L5;
        return;
    L5:
        if ((r5 instanceof Application) == false) goto L19;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L8:
        if (this.f15258a != null) goto L12;
        Application r10 = (Application) r5;     // Catch: Throwable -> L10
        this.f15258a = r10;     // Catch: Throwable -> L10
        r10.registerActivityLifecycleCallbacks(this.e);     // Catch: Throwable -> L10
    L12:
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    }

    public final int c() {
        int r5 = this.d;
        if (r5 != (-1)) goto L24;
        r5 = 0;
        Application r10 = this.f15258a;     // Catch: Throwable -> L21
        if (r10 == null) goto L23;
        ActivityManager r11 = (ActivityManager) r10.getSystemService("activity");     // Catch: Throwable -> L21
        String r12 = r10.getPackageName();     // Catch: Throwable -> L21
        List<ActivityManager.RunningAppProcessInfo> r13 = r11.getRunningAppProcesses();     // Catch: Throwable -> L21
        if (r13 == null) goto L23;
        if (r13.isEmpty() == true) goto L23;
        Iterator<ActivityManager.RunningAppProcessInfo> r14 = r13.iterator();     // Catch: Throwable -> L21
    L15:
        if (r14.hasNext() == false) goto L23;
        ActivityManager.RunningAppProcessInfo r15 = r14.next();     // Catch: Throwable -> L21
        if (r15.importance != 100) goto L15;
        if (TextUtils.equals(r15.processName, r12) == false) goto L15;
        r5 = 1;
    L23:
        this.d = r5;
    L21:
        th = move-exception;
        th.printStackTrace();
    L24:
        return r5;
    }

    public final void a(AppStatusChangeListener r5) {
        ArrayList r10 = this.f15259b;
        monitor-enter(r10);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.f15259b.contains(r5) == true) goto L9;
        this.f15259b.add(r5);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r10);     // Catch: Throwable -> L7
    }

    public final Object[] a() {
        ArrayList r5 = this.f15259b;
        monitor-enter(r5);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.f15259b.size() <= 0) goto L9;
        Object[] r10 = this.f15259b.toArray();     // Catch: Throwable -> L7
    L10:
        monitor-exit(r5);     // Catch: Throwable -> L7
        return r10;
    L9:
        r10 = null;
        goto L10
    }
}
