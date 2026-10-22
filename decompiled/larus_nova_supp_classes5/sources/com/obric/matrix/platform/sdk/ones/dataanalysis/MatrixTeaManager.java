package com.obric.matrix.platform.sdk.ones.dataanalysis;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class MatrixTeaManager {
    public static MatrixTeaManager o;
    public static final AtomicBoolean p = null;
    public static String q;
    public static String r;
    public final Context a;
    public final b b;
    public IDataService c;
    public IBinder d;
    public boolean e;
    public final CopyOnWriteArrayList<com.obric.matrix.platform.sdk.ones.dataanalysis.a> f;
    public final Handler g;
    public final CopyOnWriteArrayList<b> h;
    public final com.obric.matrix.platform.sdk.ones.dataanalysis.d i;
    public final c j;
    public final e k;
    public final Handler l;
    public final MatrixTeaManager$deviceInfoCallback$1 m;
    public final d n;

    public static final class a {
        public static MatrixTeaManager a() {
            MatrixTeaManager r0 = MatrixTeaManager.o;
            if (r0 == null) goto L7;
            Intrinsics.checkNotNull(r0);
            return r0;
        L7:
            throw new IllegalStateException("MatrixTeaManager还没初始化，请先调用init方法进行初始化~~~".toString());
        }

        public static void b(Context r2, b r3) {
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r3, "config");
            if (MatrixTeaManager.o == null) goto L5;
        L15:
            MatrixTeaManager r4 = MatrixTeaManager.o;
            Intrinsics.checkNotNull(r4);
            r4.bindService();
            return;
        L5:
            monitor-enter(MatrixTeaManager.class);
        L12:
            th = move-exception;
            throw th;
        L7:
            if (MatrixTeaManager.o != null) goto L9;
            MatrixTeaManager.o = new MatrixTeaManager(r2, r3);     // Catch: Throwable -> L12
        L9:
            Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L12
            monitor-exit(MatrixTeaManager.class);
            goto L15
        }
    }

    public static final class c implements IBinder.DeathRecipient {
        public final /* synthetic */ MatrixTeaManager a;

        @Override // android.os.IBinder.DeathRecipient
        public final void binderDied() {
            gka.b.b("MatrixTeaManager", "dataanalysis service binder died");
            this.a.d(false);
            this.a.h();
        }

        public c(MatrixTeaManager r1) {
            this.a = r1;
        }
    }

    public static final class d implements ServiceConnection {
        public final /* synthetic */ MatrixTeaManager a;

        public d(MatrixTeaManager r1) {
            this.a = r1;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName r1) {
            this.a.h();
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName r4, IBinder r5) {
            gka.b.c("MatrixTeaManager", "onServiceConnected: ");     // Catch: Exception -> L12
            this.a.g.removeCallbacksAndMessages(null);     // Catch: Exception -> L12
            if (r5 != null) goto L7;
            gka.b.b("MatrixTeaManager", "onServiceConnected error, binder is null");     // Catch: Exception -> L12
            this.a.h();     // Catch: Exception -> L12
            return;
        L7:
            this.a.d(true);     // Catch: Exception -> L12
            r5.linkToDeath(this.a.j, 0);     // Catch: Exception -> L12
            MatrixTeaManager r0 = this.a;     // Catch: Exception -> L12
            r0.d = r5;     // Catch: Exception -> L12
            r0.c = IDataService.Stub.asInterface(r5);     // Catch: Exception -> L12
            MatrixTeaManager r6 = this.a;     // Catch: Exception -> L12
            r6.e = true;     // Catch: Exception -> L12
            IDataService r1 = r6.c;     // Catch: Exception -> L12
            if (r1 == null) goto L10;
            r1.registerDeviceInfoListener(r6.m);     // Catch: Exception -> L12
        L10:
            MatrixTeaManager.a(this.a);     // Catch: Exception -> L12
            return;
        L12:
            gka.b.b("MatrixTeaManager", "onServiceConnected error");
            this.a.h();
        }
    }

    public static final class e implements Runnable {
        public final /* synthetic */ MatrixTeaManager a;

        @Override // java.lang.Runnable
        public final void run() {
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        L13:
            return;
        L3:
            if (this.a.e == true) goto L9;
            gka.b.c("MatrixTeaManager", "尝试重新绑定下载服务");     // Catch: Throwable -> L6
            this.a.c();     // Catch: Throwable -> L6
            this.a.g.postDelayed(this, 5000);     // Catch: Throwable -> L6
            return;
        }

        public e(MatrixTeaManager r1) {
            this.a = r1;
        }
    }

    public final void h() {
        d(true);     // Catch: Exception -> L5
        this.g.removeCallbacks(this.i);     // Catch: Exception -> L5
        this.g.postDelayed(this.i, 3000);     // Catch: Exception -> L5
        return;
    L5:
        gka.b.b("MatrixTeaManager", "rebindService error");
    }

    static {
        p = new AtomicBoolean(false);
    }

    public final void bindService() {
        if (p.compareAndSet(false, true) == true) goto L6;
        int r0 = gka.b.a;
        Intrinsics.checkNotNullParameter("tea has inited", "msg");
        gka.b.c("matrix_ones", "tea has inited");
        return;
    L6:
        c();
        this.g.postDelayed(this.k, 5000);
    }

    public final void c() {
        if (this.e == false) goto L6;
        gka.b.c("MatrixTeaManager", "bindServiceInternal: service is already bound");
        return;
    L6:
        Intent r0 = new Intent();
        r0.setAction("com.obric.matrix.dataanalysis.service");
        r0.setPackage("com.obric.matrix");
        this.a.bindService(r0, this.n, 1);
    }

    public final String e() {
        String r0 = q;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L10:
        if (r1 == true) goto L14;
        gka.b.c("MatrixTeaManager", "getDeviceId 有值，立即回调 " + q);
        return q;
    L14:
        if (this.e == true) goto L25;
        gka.b.b("MatrixTeaManager", "getDeviceId error,Service not bounded");
        return null;
    L25:
        IDataService r2 = this.c;     // Catch: Exception -> L21
        if (r2 == null) goto L18;
        String r3 = r2.getDeviceId();     // Catch: Exception -> L21
    L19:
        q = r3;     // Catch: Exception -> L21
        return r3;
    L18:
        r3 = null;
    L21:
        gka.b.b("MatrixTeaManager", "getDeviceId error");
        return null;
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L10
    }

    public static final void a(MatrixTeaManager r10) {
        if (r10.h.isEmpty() == false) goto L5;
        gka.b.c("MatrixTeaManager", "没有暂存的事件需要处理");
        return;
    L5:
        gka.b.c("MatrixTeaManager", "开始处理 " + r10.h.size() + " 个暂存事件");
        CopyOnWriteArrayList<b> r0 = r10.h;
        ArrayList r2 = new ArrayList();
        Iterator<b> r1 = r0.iterator();
    L7:
        if (r1.hasNext() == false) goto L18;
        b r3 = r1.next();
        b r4 = r3;
        boolean r5 = true;
        JSONObject r6 = new JSONObject(r4.b.toString());     // Catch: Exception -> L15
        r6.put("app_package_name", r10.b.a);     // Catch: Exception -> L15
        r6.put("app_version_code", r10.b.b);     // Catch: Exception -> L15
        r6.put("app_version_name", r10.b.c);     // Catch: Exception -> L15
        if (r10.b.d == false) goto L12;
        int r8 = 1;
    L13:
        r6.put("app_is_boe", r8);     // Catch: Exception -> L15
        r10.g(r4.a, r6);     // Catch: Exception -> L15
        gka.b.c("MatrixTeaManager", "成功发送暂存事件: " + r4.a);     // Catch: Exception -> L15
        r5 = false;
    L16:
        if (r5 == false) goto L7;
        r2.add(r3);
        goto L7
    L12:
        r8 = 0;
    L15:
        gka.b.b("MatrixTeaManager", "发送暂存事件 " + r4.a + " 失败");
        goto L16
    L18:
        r10.h.clear();
        r10.h.addAll(r2);
    }

    public final void b(com.obric.matrix.platform.sdk.ones.dataanalysis.a r6) {
        Intrinsics.checkNotNullParameter(r6, "listener");
        gka.b.c("MatrixTeaManager", "addDeviceInfoListener " + r6);
        if (this.f.contains(r6) == true) goto L5;
        this.f.add(r6);
        gka.b.c("MatrixTeaManager", "addDeviceInfoListener不包含，添加进listeners中,当前size = " + this.f.size());
    L5:
        String r0 = q;
        boolean r2 = true;
        if (r0 != null) goto L8;
    L11:
        boolean r1 = true;
    L12:
        if (r1 == true) goto L14;
        gka.b.c("MatrixTeaManager", "注册deviceInfoListener时did有值，立即回调 " + q);
        String r3 = q;
        Intrinsics.checkNotNull(r3);
        r6.a(r3);
    L14:
        String r4 = r;
        if (r4 != null) goto L17;
    L20:
        if (r2 == true) goto L23;
        gka.b.c("MatrixTeaManager", "注册deviceInfoListener时installId有值，立即回调 " + r);
        String r5 = r;
        Intrinsics.checkNotNull(r5);
        r6.b(r5);
        return;
    L23:
        return;
    L17:
        if (r4.length() == 0) goto L20;
        r2 = false;
        goto L20
    L8:
        if (r0.length() == 0) goto L11;
        r1 = false;
        goto L12
    }

    public final void d(boolean r4) {
        if (r4 == false) goto L13;
        IBinder r5 = this.d;
        if (r5 == null) goto L13;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L8
        Object r6 = Result.constructor-impl(Boolean.valueOf(r5.unlinkToDeath(this.j, 0)));     // Catch: Throwable -> L8
    L10:
        Throwable r7 = Result.exceptionOrNull-impl(r6);
        if (r7 == null) goto L13;
        gka.b.c("MatrixTeaManager", "unlinkToDeath skipped: " + r7.getMessage());
    L8:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
    L13:
        this.d = null;
        this.c = null;
        this.e = false;
    }

    public final void i(com.obric.matrix.platform.sdk.ones.dataanalysis.a r4) {
        Intrinsics.checkNotNullParameter(r4, "listener");
        this.f.remove(r4);     // Catch: Exception -> L5
        gka.b.c("MatrixTeaManager", "removeDeviceInfoListener " + r4 + ", size = " + this.f.size());     // Catch: Exception -> L5
        return;
    L5:
        gka.b.b("MatrixTeaManager", "removeDeviceInfoListener error");
    }

    /* JADX WARN: Type inference failed for: r1v4, types: [com.obric.matrix.platform.sdk.ones.dataanalysis.d] */
    /* JADX WARN: Type inference failed for: r1v9, types: [com.obric.matrix.platform.sdk.ones.dataanalysis.MatrixTeaManager$deviceInfoCallback$1] */
    public MatrixTeaManager(Context r1, b r2) {
        this.a = r1;
        this.b = r2;
        this.f = new CopyOnWriteArrayList();
        this.g = new Handler(Looper.getMainLooper());
        this.h = new CopyOnWriteArrayList();
        this.i = new com.obric.matrix.platform.sdk.ones.dataanalysis.d(this);
        this.j = new c(this);
        this.k = new e(this);
        PthreadHandlerThreadV2 r3 = new PthreadHandlerThreadV2("MatrixTeaBackgroundThread");
        ThreadMethodProxy.start(r3);
        this.l = new Handler(r3.getLooper());
        this.m = new MatrixTeaManager$deviceInfoCallback$1(this);
        this.n = new d(this);
    }

    public final void f(String r5, JSONObject r6) {
        Intrinsics.checkNotNullParameter(r5, "eventName");
        Intrinsics.checkNotNullParameter(r6, "jsonObject");
        int r2 = r6.toString().getBytes(Charsets.UTF_8).length;     // Catch: Throwable -> L21
        if (r2 <= 204800) goto L9;
        gka.b.b("MatrixTeaManager", "事件 " + r5 + " 数据大小 " + r2 + " 字节超过200KB限制，已丢弃");
        return;
    L9:
        if (this.e == false) goto L25;
        r6.put("app_package_name", this.b.a);     // Catch: Exception -> L16
        r6.put("app_version_code", this.b.b);     // Catch: Exception -> L16
        r6.put("app_version_name", this.b.c);     // Catch: Exception -> L16
        if (this.b.d == false) goto L13;
        int r3 = 1;
    L14:
        r6.put("app_is_boe", r3);     // Catch: Exception -> L16
        g(r5, r6);     // Catch: Exception -> L16
        return;
    L13:
        r3 = 0;
    L16:
        gka.b.b("MatrixTeaManager", "onEvent error");
        return;
    L25:
        this.h.add(new b(r5, new JSONObject(r6.toString())));     // Catch: Exception -> L19
        gka.b.c("MatrixTeaManager", "服务未绑定，暂存事件: " + r5 + " 成功，当前暂存数量: " + this.h.size());     // Catch: Exception -> L19
        return;
    L19:
        gka.b.b("MatrixTeaManager", "服务未绑定，暂存事件 " + r5 + " 失败");
        return;
    L21:
        gka.b.b("MatrixTeaManager", "计算事件大小失败，已丢弃事件 ".concat(r5));
    }

    public final void g(String r4, JSONObject r5) {
        LinkedList r0 = new LinkedList();
        Iterator<String> r1 = r5.keys();
    L4:
        if (r1.hasNext() == false) goto L21;
        r0.add(r1.next());
        goto L4
    L21:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L11
        Object[] r3 = r0.toArray(new String[0]);     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        Object r6 = Result.constructor-impl(new JSONObject(r5, (String[]) r3));     // Catch: Throwable -> L11
    L14:
        if (Result.exceptionOrNull-impl(r6) == null) goto L17;
        gka.b.b("MatrixTeaManager", "copyJson error");
    L17:
        if (Result.isFailure-impl(r6) == false) goto L19;
        r6 = r5;
    L19:
        this.l.post(new com.obric.matrix.platform.sdk.ones.dataanalysis.c(this, r4, (JSONObject) r6, r5));
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    }
}
