package com.ss.android.socialbase.downloader.a;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Application f15245a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<InterfaceC0809a> f15246b;
    private int c;
    private WeakReference<Activity> d;
    private volatile int e;
    private volatile boolean f;
    private final Application.ActivityLifecycleCallbacks g;

    /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.a.a$a, reason: collision with other inner class name */
    public interface InterfaceC0809a {
        void a();

        void b();
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final a f15248a = null;

        static {
            f15248a = new a(null);
        }

        static /* synthetic */ a a() {
            return f15248a;
        }
    }

    private a() {
        this.f15246b = new ArrayList();
        this.e = -1;
        this.f = false;
        this.g = new AnonymousClass1(this);
    }

    /* synthetic */ a(AnonymousClass1 r1) {
        this();
    }

    static /* synthetic */ int a(a r0) {
        return r0.c;
    }

    static /* synthetic */ int a(a r0, int r1) {
        r0.c = r1;
        return r1;
    }

    public static a a() {
        return b.a();
    }

    static /* synthetic */ WeakReference a(a r0, WeakReference r1) {
        r0.d = r1;
        return r1;
    }

    static /* synthetic */ boolean a(a r0, boolean r1) {
        r0.f = r1;
        return r1;
    }

    static /* synthetic */ void b(a r0) {
        r0.f();
    }

    static /* synthetic */ void c(a r0) {
        r0.g();
    }

    private int d() {
        int r0 = this.e;
        if (r0 != (-1)) goto L6;
        boolean r1 = h();
        this.e = r1 ? 1 : 0;
        return r1 ? 1 : 0;
    L6:
        return r0;
    }

    private Object[] e() {
        List<InterfaceC0809a> r0 = this.f15246b;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.f15246b.size() <= 0) goto L7;
        Object[] r2 = this.f15246b.toArray();     // Catch: Throwable -> L10
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r2;
    L7:
        r2 = null;
        goto L8
    }

    private void f() {
        this.e = 1;
        Object[] r5 = e();
        if (r5 == null) goto L7;
        int r0 = r5.length;
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L9;
        ((InterfaceC0809a) ZeusTransformUtils.preCheckCast(r5[r1], InterfaceC0809a.class, "com.obric.memorydata.plugin")).a();
        r1 = r1 + 1;
        goto L5
    L9:
        return;
    }

    private void g() {
        int r0 = 0;
        this.e = 0;
        Object[] r5 = e();
        if (r5 == null) goto L7;
        int r1 = r5.length;
    L5:
        if (r0 >= r1) goto L9;
        ((InterfaceC0809a) ZeusTransformUtils.preCheckCast(r5[r0], InterfaceC0809a.class, "com.obric.memorydata.plugin")).b();
        r0 = r0 + 1;
        goto L5
    L9:
        return;
    }

    private boolean h() {
        Application r6 = this.f15245a;     // Catch: Throwable -> L21
        if (r6 != null) goto L6;
        return false;
    L6:
        ActivityManager r2 = (ActivityManager) ZeusTransformUtils.preCheckCast(r6.getSystemService("activity"), ActivityManager.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
        String r7 = r6.getPackageName();     // Catch: Throwable -> L21
        List<ActivityManager.RunningAppProcessInfo> r3 = r2.getRunningAppProcesses();     // Catch: Throwable -> L21
        if (r3 != null) goto L9;
    L20:
        return false;
    L9:
        if (r3.isEmpty() == true) goto L20;
        Iterator<ActivityManager.RunningAppProcessInfo> r4 = r3.iterator();     // Catch: Throwable -> L21
    L13:
        if (r4.hasNext() == false) goto L20;
        ActivityManager.RunningAppProcessInfo r5 = (ActivityManager.RunningAppProcessInfo) ZeusTransformUtils.preCheckCast(r4.next(), ActivityManager.RunningAppProcessInfo.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
        if (r5.importance != 100) goto L13;
        if (TextUtils.equals(r5.processName, r7) == false) goto L13;
        return true;
    L21:
        th = move-exception;
        th.printStackTrace();
        return false;
    }

    public void a(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (this.f15245a == null) goto L5;
        return;
    L5:
        if (ZeusTransformUtils.instanceOf(r4, Application.class) == false) goto L18;
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L8:
        if (this.f15245a != null) goto L10;
        Application r5 = (Application) ZeusTransformUtils.preCheckCast(r4, Application.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
        this.f15245a = r5;     // Catch: Throwable -> L12
        r5.registerActivityLifecycleCallbacks(this.g);     // Catch: Throwable -> L12
    L10:
        monitor-exit(this);     // Catch: Throwable -> L12
        return;
    }

    public void a(InterfaceC0809a r3) {
        InterfaceC0809a r4 = (InterfaceC0809a) ZeusTransformUtils.wrapperContextForParams(r3, InterfaceC0809a.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
        return;
    L5:
        List<InterfaceC0809a> r0 = this.f15246b;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L8:
        if (this.f15246b.contains(r4) == true) goto L10;
        this.f15246b.add(r4);     // Catch: Throwable -> L12
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L12
    }

    public boolean b() {
        if (d() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean c() {
        if (d() != 0) goto L5;
        return true;
    L5:
        return false;
    }
}
