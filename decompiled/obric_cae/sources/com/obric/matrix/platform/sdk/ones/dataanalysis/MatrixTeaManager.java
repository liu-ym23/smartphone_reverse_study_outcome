package com.obric.matrix.platform.sdk.ones.dataanalysis;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import androidx.activity.k;
import he.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;
import xd.e;
import xd.j;

/* JADX INFO: loaded from: classes2.dex */
public final class MatrixTeaManager {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static MatrixTeaManager f6122l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static String f6123m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f6124a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.obric.matrix.platform.sdk.ones.dataanalysis.b f6125b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public IDataService f6126c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f6127d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CopyOnWriteArrayList<com.obric.matrix.platform.sdk.ones.dataanalysis.a> f6128e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Handler f6129f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final CopyOnWriteArrayList<b> f6130g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final d f6131h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Handler f6132i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final MatrixTeaManager$deviceInfoCallback$1 f6133j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final c f6134k;

    public static final class a {
        public static void a(Context r8, com.obric.matrix.platform.sdk.ones.dataanalysis.b r10) {
            i.f(r8, "context");
            if (MatrixTeaManager.f6122l == null) goto L5;
        L15:
            MatrixTeaManager r11 = MatrixTeaManager.f6122l;
            i.c(r11);
            r11.b();
            r11.f6129f.postDelayed(r11.f6131h, 5000);
            return;
        L5:
            monitor-enter(MatrixTeaManager.class);
        L12:
            th = move-exception;
            throw th;
        L7:
            if (MatrixTeaManager.f6122l != null) goto L9;
            MatrixTeaManager.f6122l = new MatrixTeaManager(r8, r10);     // Catch: Throwable -> L12
        L9:
            j r12 = j.f13877a;     // Catch: Throwable -> L12
            monitor-exit(MatrixTeaManager.class);
            goto L15
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f6135a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final JSONObject f6136b;

        public b(String r8, JSONObject r10) {
            this.f6135a = r8;
            this.f6136b = r10;
        }

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof b) == true) goto L8;
            return false;
        L8:
            b r10 = (b) r8;
            String r11 = r10.f6135a;
            if (i.a(this.f6135a, r11) == true) goto L12;
            return false;
        L12:
            if (i.a(this.f6136b, r10.f6136b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r8 = this.f6135a.hashCode() * 31;
            return this.f6136b.hashCode() + r8;
        }

        public final String toString() {
            return "PendingEvent(eventName=" + this.f6135a + ", jsonObject=" + this.f6136b + ')';
        }
    }

    public static final class c implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MatrixTeaManager f6137a;

        public c(MatrixTeaManager r8) {
            this.f6137a = r8;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName r8, IBinder r10) {
            MatrixTeaManager r11 = this.f6137a;
            IDataService r12 = null;
            r11.f6129f.removeCallbacksAndMessages(null);     // Catch: Exception -> L17
            int r13 = IDataService.Stub.f6119a;     // Catch: Exception -> L17
            if (r10 == null) goto L12;
            IInterface r14 = r10.queryLocalInterface("com.obric.matrix.platform.sdk.ones.dataanalysis.IDataService");     // Catch: Exception -> L17
            if (r14 != null) goto L9;
        L11:
            r12 = new IDataService.Stub.Proxy(r10);     // Catch: Exception -> L17
            goto L12
        L9:
            if ((r14 instanceof IDataService) == false) goto L11;
            r12 = (IDataService) r14;     // Catch: Exception -> L17
        L12:
            r11.f6126c = r12;     // Catch: Exception -> L17
            r11.f6127d = true;     // Catch: Exception -> L17
            if (r12 == null) goto L15;
            r12.V0(r11.f6133j);     // Catch: Exception -> L17
        L15:
            MatrixTeaManager.a(r11);     // Catch: Exception -> L17
            return;
        L17:
            r11.e();
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName r8) {
            this.f6137a.e();
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MatrixTeaManager f6138a;

        public d(MatrixTeaManager r8) {
            this.f6138a = r8;
        }

        @Override // java.lang.Runnable
        public final void run() {
            MatrixTeaManager r8 = this.f6138a;
            if (r8.f6127d == true) goto L6;
            r8.b();
            r8.f6129f.postDelayed(this, 5000);
            return;
        }
    }

    public MatrixTeaManager(Context r8, com.obric.matrix.platform.sdk.ones.dataanalysis.b r10) {
        this.f6124a = r8;
        this.f6125b = r10;
        this.f6128e = new CopyOnWriteArrayList();
        this.f6129f = new Handler(Looper.getMainLooper());
        this.f6130g = new CopyOnWriteArrayList();
        this.f6131h = new d(this);
        HandlerThread r11 = new HandlerThread("MatrixTeaBackgroundThread");
        r11.start();
        this.f6132i = new Handler(r11.getLooper());
        this.f6133j = new MatrixTeaManager$deviceInfoCallback$1(this);
        this.f6134k = new c(this);
    }

    public static final void a(MatrixTeaManager r13) {
        com.obric.matrix.platform.sdk.ones.dataanalysis.b r8 = r13.f6125b;
        CopyOnWriteArrayList<b> r10 = r13.f6130g;
        if (r10.isEmpty() == true) goto L29;
        i.f("开始处理 " + r10.size() + " 个暂存事件", "msg");
        ArrayList r11 = new ArrayList();
        Iterator<b> r12 = r10.iterator();
    L7:
        if (r12.hasNext() == false) goto L20;
        b r14 = r12.next();
        b r15 = r14;
        boolean r16 = true;
        JSONObject r17 = r15.f6136b;     // Catch: Exception -> L17
        String r18 = r15.f6135a;
        JSONObject r19 = new JSONObject(r17.toString());     // Catch: Exception -> L17
        r19.put("app_package_name", r8.f6140a);     // Catch: Exception -> L17
        r19.put("app_version_code", r8.f6141b);     // Catch: Exception -> L17
        r19.put("app_version_name", r8.f6142c);     // Catch: Exception -> L17
        if (r8.f6143d == false) goto L14;
        int r110 = 1;
    L15:
        r19.put("app_is_boe", r110);     // Catch: Exception -> L17
        r13.d(r18, r19);     // Catch: Exception -> L17
        i.f("成功发送暂存事件: " + r18, "msg");     // Catch: Exception -> L17
        r16 = false;
    L18:
        if (r16 == false) goto L7;
        r11.add(r14);
        goto L7
    L14:
        r110 = 0;
    L17:
        i.f("发送暂存事件 " + r15.f6135a + " 失败", "msg");
        goto L18
    L20:
        r10.clear();
        r10.addAll(r11);
        return;
    }

    public final void b() {
        if (this.f6127d == false) goto L5;
        return;
    L5:
        Intent r8 = new Intent();
        r8.setAction("com.obric.matrix.dataanalysis.service");
        r8.setPackage("com.obric.matrix");
        this.f6124a.bindService(r8, this.f6134k, 1);
    }

    public final String c() {
        String r8 = f6123m;
        if (r8 != null) goto L5;
    L8:
        boolean r10 = true;
    L9:
        if (r10 == true) goto L13;
        i.f("getDeviceId 有值，立即回调 " + f6123m, "msg");
        return f6123m;
    L13:
        if (this.f6127d == true) goto L22;
    L20:
        return null;
    L22:
        IDataService r11 = this.f6126c;     // Catch: Exception -> L21
        if (r11 == null) goto L17;
        String r12 = r11.getDeviceId();     // Catch: Exception -> L21
    L18:
        f6123m = r12;     // Catch: Exception -> L21
        return r12;
    L17:
        r12 = null;
        goto L18
    L5:
        if (r8.length() == 0) goto L8;
        r10 = false;
        goto L9
    }

    public final void d(final String r8, final JSONObject r10) {
        LinkedList r11 = new LinkedList();
        Iterator<String> r12 = r10.keys();
    L4:
        if (r12.hasNext() == false) goto L18;
        String r13 = r12.next();
        i.e(r13, "keysIterable.next()");
        r11.add(r13);
        goto L4
    L18:
        Object[] r14 = r11.toArray(new String[0]);     // Catch: Throwable -> L11
        if (r14 == null) goto L10;
        Object r15 = new JSONObject(r10, (String[]) r14);     // Catch: Throwable -> L11
    L13:
        e.a(r15);
        if ((r15 instanceof e.a) == false) goto L16;
        r15 = r10;
    L16:
        final JSONObject r16 = (JSONObject) r15;
        this.f6132i.post(new com.obric.matrix.platform.sdk.ones.dataanalysis.c(this, r8, r16, r10));
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        r15 = defpackage.c.D(th);
        goto L13
    }

    public final void e() {
        this.f6127d = false;     // Catch: Exception -> L5
        this.f6126c = null;     // Catch: Exception -> L5
        this.f6129f.postDelayed(new k(this, 28), 3000);     // Catch: Exception -> L5
        return;
    }
}
