package w8;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import androidx.work.WorkRequest;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.download.base.DownloadInfo;
import com.obric.download.base.DownloadTask;
import com.obric.download.base.TaskOperateResult;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Predicate;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static f f13429p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final a f13430q = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f13431a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f13432b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private x8.b f13433c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final CopyOnWriteArrayList<w8.e> f13434d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final CopyOnWriteArrayList<w8.b> f13435e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final CopyOnWriteArrayList<w8.h> f13436f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final CopyOnWriteArrayList<DownloadInfo> f13437g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private w8.c f13438h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Handler f13439i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final h f13440j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final BinderC0313f f13441k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final c f13442l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final d f13443m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Context f13444n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final w8.d f13445o;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final f a() {
            if (f.f() == null) goto L7;
            f r10 = f.f();
            Intrinsics.checkNotNull(r10);
            return r10;
        L7:
            throw new IllegalStateException("AppUpgradeManager 还未初始化，请先调用 init 方法。".toString());
        }

        @JvmStatic
        public final void b(Context r10, w8.d r11) {
            Intrinsics.checkNotNullParameter(r10, "context");
            Intrinsics.checkNotNullParameter(r11, "config");
            if (f.f() == null) goto L5;
            return;
        L5:
            monitor-enter(f.class);
        L12:
            th = move-exception;
            throw th;
        L7:
            if (f.f() != null) goto L9;
            Context r12 = r10.getApplicationContext();     // Catch: Throwable -> L12
            Intrinsics.checkNotNullExpressionValue(r12, "context.applicationContext");     // Catch: Throwable -> L12
            f.r(new f(r12, r11, null));     // Catch: Throwable -> L12
            w8.g.c("DownloadManager", "init DownloadManager success");     // Catch: Throwable -> L12
        L9:
            Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L12
            monitor-exit(f.class);
        }
    }

    static final class b<T> implements Predicate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ DownloadInfo f13446a;

        b(DownloadInfo r10) {
            this.f13446a = r10;
        }

        public final boolean a(DownloadInfo r10) {
            if (r10 == null) goto L4;
            String r11 = r10.getUrl();
        L6:
            return Intrinsics.areEqual(r11, this.f13446a.getUrl());
        L4:
            r11 = null;
            goto L6
        }

        @Override // java.util.function.Predicate
        public /* bridge */ /* synthetic */ boolean test(Object r10) {
            return a((DownloadInfo) r10);
        }
    }

    public static final class c extends x8.a.AbstractBinderC0318a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ f f13447c;

        c(f r10) {
            this.f13447c = r10;
        }

        @Override // x8.a
        public void F(DownloadInfo r10, int r11, String r12) {
            Intrinsics.checkNotNullParameter(r10, "info");
            Intrinsics.checkNotNullParameter(r12, "errorMsg");
            this.f13447c.C(r10);
            w8.g.c("DownloadManager", "onDownloadFailed " + r10.getId() + ',' + r11 + " , " + r12 + ' ' + r10.getUrl());
            Iterator r13 = f.h(this.f13447c).iterator();
        L4:
            if (r13.hasNext() == false) goto L6;
            ((w8.e) r13.next()).F(r10, r11, r12);
            goto L4
        }

        @Override // x8.a
        public void G0(DownloadInfo r10) {
            Intrinsics.checkNotNullParameter(r10, "info");
            this.f13447c.C(r10);
            w8.g.c("DownloadManager", "onDownloadCancel " + r10.getId() + ' ' + r10.getUrl());
            Iterator r11 = f.h(this.f13447c).iterator();
        L4:
            if (r11.hasNext() == false) goto L6;
            ((w8.e) r11.next()).G0(r10);
            goto L4
        }

        @Override // x8.a
        public void K(DownloadInfo r10) {
            if (r10 == null) goto L7;
            w8.g.c("DownloadManager", "onExtraInfoUpdate " + r10.getId() + ',' + r10.getExtraInfo());
            Iterator r11 = f.h(this.f13447c).iterator();
        L5:
            if (r11.hasNext() == false) goto L9;
            ((w8.e) r11.next()).K(r10);
            goto L5
        L9:
            return;
        }

        @Override // x8.a
        public void S0(DownloadInfo r10, int r11, String r12) {
        }

        @Override // x8.a
        public void V1(DownloadInfo r10, int r11, String r12) {
        }

        @Override // x8.a
        public void X(DownloadInfo r10) {
            Intrinsics.checkNotNullParameter(r10, "info");
            this.f13447c.t(r10);
            w8.g.c("DownloadManager", "onDownloadPending " + r10.getId() + ' ' + r10.getUrl());
            Iterator r11 = f.h(this.f13447c).iterator();
        L4:
            if (r11.hasNext() == false) goto L6;
            ((w8.e) r11.next()).X(r10);
            goto L4
        }

        @Override // x8.a
        public void a0(DownloadInfo r10) {
            Intrinsics.checkNotNullParameter(r10, "info");
            this.f13447c.t(r10);
            w8.g.c("DownloadManager", "onDownloadPause " + r10.getId() + ' ' + r10.getUrl());
            Iterator r11 = f.h(this.f13447c).iterator();
        L4:
            if (r11.hasNext() == false) goto L6;
            ((w8.e) r11.next()).a0(r10);
            goto L4
        }

        @Override // x8.a
        public void e2(DownloadInfo r10) {
        }

        @Override // x8.a
        public void h0(DownloadInfo r10) {
            Intrinsics.checkNotNullParameter(r10, "info");
            this.f13447c.t(r10);
            w8.g.c("DownloadManager", "onDownloadStart " + r10.getId() + ' ' + r10.getUrl());
            Iterator r11 = f.h(this.f13447c).iterator();
        L4:
            if (r11.hasNext() == false) goto L6;
            ((w8.e) r11.next()).h0(r10);
            goto L4
        }

        @Override // x8.a
        public void i2(DownloadInfo r10) {
        }

        @Override // x8.a
        public void u0(DownloadInfo r10) {
            Intrinsics.checkNotNullParameter(r10, "info");
            this.f13447c.t(r10);
            Iterator r11 = f.h(this.f13447c).iterator();
        L4:
            if (r11.hasNext() == false) goto L6;
            ((w8.e) r11.next()).u0(r10);
            goto L4
        }

        @Override // x8.a
        public void z0(DownloadInfo r10) {
            Intrinsics.checkNotNullParameter(r10, "info");
            this.f13447c.C(r10);
            w8.g.c("DownloadManager", "onDownloadFinish " + r10.getId() + ' ' + r10.getUrl());
            if (f.h(this.f13447c).isEmpty() == false) goto L5;
            w8.g.c("DownloadManager", "没有callback，通过广播通知");
            Intent r11 = new Intent();
            r11.setComponent(new ComponentName(f.c(this.f13447c).d(), f.c(this.f13447c).e()));
            r11.putExtra("extra_downloadinfo", r10);
            r11.setAction("com.obric.downloader.action.DOWNLOAD_COMPLETE");
            f.d(this.f13447c).sendBroadcast(r11);
            return;
        L5:
            Iterator r12 = f.h(this.f13447c).iterator();
        L7:
            if (r12.hasNext() == false) goto L11;
            ((w8.e) r12.next()).z0(r10);
            goto L7
        }
    }

    public static final class d implements ServiceConnection {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ f f13448c;

        d(f r10) {
            this.f13448c = r10;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName r10, IBinder r11) {
            w8.g.c("DownloadManager", "下载服务绑定上了 config = " + f.c(this.f13448c).toString());     // Catch: Exception -> L27
            f.e(this.f13448c).removeCallbacksAndMessages(null);     // Catch: Exception -> L27
            f.s(this.f13448c, x8.b.a.U0(r11));     // Catch: Exception -> L27
            f.p(this.f13448c, true);     // Catch: Exception -> L27
            w8.c r12 = f.m(this.f13448c);     // Catch: Exception -> L27
            if (r12 == null) goto L6;
            r12.b();     // Catch: Exception -> L27
        L6:
            x8.b r13 = f.l(this.f13448c);     // Catch: Exception -> L27
            if (r13 == null) goto L9;
            r13.h1(f.c(this.f13448c).d(), f.c(this.f13448c).a(), f.c(this.f13448c).b(), f.c(this.f13448c).e());     // Catch: Exception -> L27
        L9:
            x8.b r14 = f.l(this.f13448c);     // Catch: Exception -> L27
            if (r14 == null) goto L12;
            r14.Q1(f.c(this.f13448c).d(), f.c(this.f13448c).a(), f.c(this.f13448c).c());     // Catch: Exception -> L27
        L12:
            x8.b r15 = f.l(this.f13448c);     // Catch: Exception -> L27
            if (r15 == null) goto L15;
            r15.l1(f.c(this.f13448c).d(), f.c(this.f13448c).a(), f.b(this.f13448c));     // Catch: Exception -> L27
        L15:
            w8.g.c("DownloadManager", "设置noti class " + f.c(this.f13448c).c());     // Catch: Exception -> L27
            x8.b r16 = f.l(this.f13448c);     // Catch: Exception -> L27
            if (r16 == null) goto L19;
            r16.x1(f.c(this.f13448c).d(), f.c(this.f13448c).a(), f.k(this.f13448c));     // Catch: Exception -> L27
        L19:
            if (f.o(this.f13448c) == false) goto L23;
            f.q(this.f13448c, false);     // Catch: Exception -> L27
            w8.g.c("DownloadManager", "下载服务断开又自动重连上了，resume所有任务");     // Catch: Exception -> L27
            x8.b r17 = f.l(this.f13448c);     // Catch: Exception -> L27
            if (r17 == null) goto L31;
            r17.I1(f.c(this.f13448c).d(), true);     // Catch: Exception -> L27
            return;
        L31:
            return;
        L23:
            w8.g.c("DownloadManager", "下载服务连接上了，自动继续所有任务");     // Catch: Exception -> L27
            x8.b r18 = f.l(this.f13448c);     // Catch: Exception -> L27
            if (r18 == null) goto L33;
            r18.I1(f.c(this.f13448c).d(), false);     // Catch: Exception -> L27
            return;
        L33:
            return;
        L27:
            e = move-exception;
            e.printStackTrace();
            w8.g.a("DownloadManager", "onServiceConnected下载服务绑定失败", e);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName r10) {
            f.p(this.f13448c, false);     // Catch: Exception -> L23
            CopyOnWriteArrayList r11 = null;
            f.s(this.f13448c, null);     // Catch: Exception -> L23
            w8.g.c("DownloadManager", "下载服务断开了");     // Catch: Exception -> L23
            w8.c r12 = f.m(this.f13448c);     // Catch: Exception -> L23
            if (r12 == null) goto L6;
            r12.a();     // Catch: Exception -> L23
        L6:
            CopyOnWriteArrayList r13 = f.h(this.f13448c);     // Catch: Exception -> L23
            if ((!r13.isEmpty()) == false) goto L9;
            r11 = r13;
        L9:
            if (r11 == null) goto L17;
            Iterator r14 = r11.iterator();     // Catch: Exception -> L23
        L12:
            if (r14.hasNext() == false) goto L21;
            w8.e r15 = (w8.e) r14.next();     // Catch: Exception -> L23
            w8.g.c("DownloadManager", "下载服务断开了，通过callback通知异常");     // Catch: Exception -> L23
            Iterator r16 = f.g(this.f13448c).iterator();     // Catch: Exception -> L23
        L15:
            if (r16.hasNext() == false) goto L12;
            DownloadInfo r17 = (DownloadInfo) r16.next();     // Catch: Exception -> L23
            Intrinsics.checkNotNullExpressionValue(r17, "downloadInfo");     // Catch: Exception -> L23
            r15.F(r17, WsConstants.APP_STATE_CHANGE_SERVICE, "下载服务进程断开了");     // Catch: Exception -> L23
        L21:
            f.q(this.f13448c, true);     // Catch: Exception -> L23
            f r18 = this.f13448c;     // Catch: Exception -> L23
            r18.u(f.m(r18));     // Catch: Exception -> L23
            return;
        L17:
            w8.g.c("DownloadManager", "下载服务断开了，使用广播通知");     // Catch: Exception -> L23
            Iterator r19 = f.g(this.f13448c).iterator();     // Catch: Exception -> L23
        L19:
            if (r19.hasNext() == false) goto L21;
            DownloadInfo r20 = (DownloadInfo) r19.next();     // Catch: Exception -> L23
            Intent r21 = new Intent();     // Catch: Exception -> L23
            r21.setComponent(new ComponentName(f.c(this.f13448c).d(), f.c(this.f13448c).e()));     // Catch: Exception -> L23
            r21.putExtra("extra_downloadinfo", r20);     // Catch: Exception -> L23
            r21.setAction("com.obric.downloader.action.DOWNLOAD_CORE_ERROR");     // Catch: Exception -> L23
            f.d(this.f13448c).sendBroadcast(r21);     // Catch: Exception -> L23
        L23:
            e = move-exception;
            e.printStackTrace();
            w8.g.a("DownloadManager", "onServiceDisconnected下载服务绑定失败", e);
        }
    }

    public static final class e extends x8.c.a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ f f13449c;

        e(f r10) {
            this.f13449c = r10;
        }

        @Override // x8.c
        public void h2(List<DownloadInfo> r10) {
            Iterator r11 = f.i(this.f13449c).iterator();
        L4:
            if (r11.hasNext() == false) goto L6;
            ((w8.b) r11.next()).a(r10);
            goto L4
        L6:
            f.i(this.f13449c).clear();
        }
    }

    /* JADX INFO: renamed from: w8.f$f, reason: collision with other inner class name */
    public static final class BinderC0313f extends x8.d.a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ f f13450c;

        BinderC0313f(f r10) {
            this.f13450c = r10;
        }

        @Override // x8.d
        public void M0(int r10) {
            Iterator r11 = f.j(this.f13450c).iterator();
        L4:
            if (r11.hasNext() == false) goto L6;
            ((w8.h) r11.next()).M0(r10);
            goto L4
        }
    }

    static final class g<T> implements Predicate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ DownloadInfo f13451a;

        g(DownloadInfo r10) {
            this.f13451a = r10;
        }

        public final boolean a(DownloadInfo r10) {
            if (r10 == null) goto L4;
            String r11 = r10.getUrl();
        L6:
            return Intrinsics.areEqual(r11, this.f13451a.getUrl());
        L4:
            r11 = null;
            goto L6
        }

        @Override // java.util.function.Predicate
        public /* bridge */ /* synthetic */ boolean test(Object r10) {
            return a((DownloadInfo) r10);
        }
    }

    public static final class h implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ f f13452c;

        h(f r10) {
            this.f13452c = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (f.n(this.f13452c) == true) goto L6;
            w8.g.c("DownloadManager", "尝试重新绑定下载服务");
            f r10 = this.f13452c;
            f.a(r10, f.m(r10));
            f.e(this.f13452c).postDelayed(this, WorkRequest.MIN_BACKOFF_MILLIS);
            return;
        }
    }

    static {
        f13430q = new a(null);
    }

    private f(Context r10, w8.d r11) {
        this.f13444n = r10;
        this.f13445o = r11;
        this.f13434d = new CopyOnWriteArrayList();
        this.f13435e = new CopyOnWriteArrayList();
        this.f13436f = new CopyOnWriteArrayList();
        this.f13437g = new CopyOnWriteArrayList();
        this.f13439i = new Handler(Looper.getMainLooper());
        this.f13440j = new h(this);
        new e(this);
        this.f13441k = new BinderC0313f(this);
        this.f13442l = new c(this);
        this.f13443m = new d(this);
    }

    public /* synthetic */ f(Context r10, w8.d r11, DefaultConstructorMarker r12) {
        this(r10, r11);
    }

    public static final /* synthetic */ void a(f r10, w8.c r11) {
        r10.v(r11);
    }

    public static final /* synthetic */ c b(f r10) {
        return r10.f13442l;
    }

    public static final /* synthetic */ w8.d c(f r10) {
        return r10.f13445o;
    }

    public static final /* synthetic */ Context d(f r10) {
        return r10.f13444n;
    }

    public static final /* synthetic */ Handler e(f r10) {
        return r10.f13439i;
    }

    public static final /* synthetic */ f f() {
        return f13429p;
    }

    public static final /* synthetic */ CopyOnWriteArrayList g(f r10) {
        return r10.f13437g;
    }

    public static final /* synthetic */ CopyOnWriteArrayList h(f r10) {
        return r10.f13434d;
    }

    public static final /* synthetic */ CopyOnWriteArrayList i(f r10) {
        return r10.f13435e;
    }

    public static final /* synthetic */ CopyOnWriteArrayList j(f r10) {
        return r10.f13436f;
    }

    public static final /* synthetic */ BinderC0313f k(f r10) {
        return r10.f13441k;
    }

    public static final /* synthetic */ x8.b l(f r10) {
        return r10.f13433c;
    }

    public static final /* synthetic */ w8.c m(f r10) {
        return r10.f13438h;
    }

    public static final /* synthetic */ boolean n(f r10) {
        return r10.f13431a;
    }

    public static final /* synthetic */ boolean o(f r10) {
        return r10.f13432b;
    }

    public static final /* synthetic */ void p(f r10, boolean r11) {
        r10.f13431a = r11;
    }

    public static final /* synthetic */ void q(f r10, boolean r11) {
        r10.f13432b = r11;
    }

    public static final /* synthetic */ void r(f r10) {
        f13429p = r10;
    }

    public static final /* synthetic */ void s(f r10, x8.b r11) {
        r10.f13433c = r11;
    }

    private final void v(w8.c r10) {
        w8.g.c("DownloadManager", "执行bindServiceInternal");     // Catch: Exception -> L11
        this.f13438h = r10;     // Catch: Exception -> L11
        if (this.f13431a == false) goto L9;
        if (r10 == null) goto L7;
        r10.b();     // Catch: Exception -> L11
    L7:
        this.f13439i.removeCallbacksAndMessages(null);     // Catch: Exception -> L11
        return;
    L9:
        Intent r11 = new Intent();     // Catch: Exception -> L11
        r11.setAction("com.obric.download.DownloadService.action");     // Catch: Exception -> L11
        r11.setComponent(new ComponentName("com.obric.downloadserver", "com.obric.downloadcore.DownloadService"));     // Catch: Exception -> L11
        this.f13444n.bindService(r11, this.f13443m, 1);     // Catch: Exception -> L11
        return;
    L11:
        e = move-exception;
        e.printStackTrace();
        w8.g.a("DownloadManager", "bindServiceInternal下载服务绑定失败", e);
    }

    private final TaskOperateResult x(int r10, int r11, String r12) {
        return new TaskOperateResult(r10, r11, r12);
    }

    private final TaskOperateResult y(DownloadTask r10, int r11, String r12) {
        return new TaskOperateResult(y8.b.f13719a.a(r10.getUrl(), r10.getSavePath()), r11, r12);
    }

    public final TaskOperateResult A(int r10) {
        w8.g.c("DownloadManager", "pauseTaskById " + r10);
        if (this.f13431a == true) goto L14;
        w8.g.c("DownloadManager", "pauseTaskById " + r10 + " 失败，服务还未绑定上");
        String r11 = "pauseTaskById " + r10 + " 失败，服务还未绑定上";
    L12:
        return x(r10, -1, r11);
    L14:
        x8.b r12 = this.f13433c;     // Catch: Exception -> L9
        if (r12 == null) goto L7;
        r12.d2(r10);     // Catch: Exception -> L9
    L7:
        return x(r10, 0, "pauseTaskById时成功");
    L9:
        e = move-exception;
        w8.g.a("DownloadManager", "pauseTaskById " + r10 + " 失败", e);
        r11 = "pauseTaskById时发生异常";
        goto L12
    }

    public final void B(w8.e r10) {
        Intrinsics.checkNotNullParameter(r10, "listener");
        if (this.f13434d.contains(r10) == false) goto L15;
        return;
    L15:
    L11:
        e = move-exception;
        w8.g.a("DownloadManager", "registerDownloadListener 失败", e);
    L13:
        this.f13434d.add(r10);
        return;
    L6:
        if (this.f13434d.isEmpty() == false) goto L13;
        w8.g.c("DownloadManager", "registerDownloadListener时, mDownloadProgressCallbacks为空，往service中注册callback");     // Catch: Exception -> L11
        x8.b r11 = this.f13433c;     // Catch: Exception -> L11
        if (r11 == null) goto L13;
        r11.l1(this.f13445o.d(), this.f13445o.a(), this.f13442l);     // Catch: Exception -> L11
        goto L13
    }

    public final void C(DownloadInfo r10) {
        Intrinsics.checkNotNullParameter(r10, "info");
        this.f13437g.removeIf(new g(r10));
    }

    public final TaskOperateResult D(int r10) {
        w8.g.c("DownloadManager", "resumeTaskById " + r10);
        if (this.f13431a == true) goto L14;
        w8.g.c("DownloadManager", "resumeTaskById " + r10 + " 失败，服务还未绑定上");
        String r11 = "resumeTaskById " + r10 + " 失败，服务还未绑定上";
    L12:
        return x(r10, -1, r11);
    L14:
        x8.b r12 = this.f13433c;     // Catch: Exception -> L9
        if (r12 == null) goto L7;
        r12.X1(r10);     // Catch: Exception -> L9
    L7:
        return x(r10, 0, "resumeTaskById时成功");
    L9:
        e = move-exception;
        w8.g.a("DownloadManager", "resumeTaskById " + r10 + " 失败", e);
        r11 = "resumeTaskById时发生异常";
        goto L12
    }

    public final void E(DownloadTask r10) {
        Intrinsics.checkNotNullParameter(r10, "task");
        String r11 = r10.getHostPkgName();
        if (r11 != null) goto L5;
    L8:
        boolean r12 = true;
    L9:
        if (r12 == false) goto L12;
        r10.setHostPkgName(this.f13445o.d());
        return;
    L12:
        return;
    L5:
        if (r11.length() == 0) goto L8;
        r12 = false;
        goto L9
    }

    public final TaskOperateResult F(DownloadTask r10) {
        Intrinsics.checkNotNullParameter(r10, "task");
        E(r10);
        w8.g.c("DownloadManager", "submitTask " + r10);
        if (this.f13431a == true) goto L11;
        w8.g.c("DownloadManager", "submitTask " + r10 + " 失败，服务还未绑定上");
        String r11 = "提交任务失败，服务还未绑定上";
    L9:
        return y(r10, -1, r11);
    L11:
        x8.b r12 = this.f13433c;     // Catch: Exception -> L6
        Intrinsics.checkNotNull(r12);     // Catch: Exception -> L6
        TaskOperateResult r13 = r12.f1(r10);     // Catch: Exception -> L6
        Intrinsics.checkNotNullExpressionValue(r13, "this.service!!.submitTask(task)");     // Catch: Exception -> L6
        return r13;
    L6:
        e = move-exception;
        w8.g.a("DownloadManager", "submitTask " + r10 + " 失败", e);
        r11 = "提交任务时发生异常";
        goto L9
    }

    public final void t(DownloadInfo r10) {
        Intrinsics.checkNotNullParameter(r10, "newInfo");
        this.f13437g.removeIf(new b(r10));
        this.f13437g.add(r10);
    }

    public final void u(w8.c r10) {
        w8.g.c("DownloadManager", "执行bindService");
        v(r10);
        this.f13439i.postDelayed(this.f13440j, WorkRequest.MIN_BACKOFF_MILLIS);
    }

    public final TaskOperateResult w(int r10) {
        w8.g.c("DownloadManager", "cancelTaskById " + r10);
        if (this.f13431a == true) goto L14;
        w8.g.c("DownloadManager", "cancelTaskById " + r10 + " 失败，服务还未绑定上");
        String r11 = "cancelTaskById " + r10 + " 失败，服务还未绑定上";
    L12:
        return x(r10, -1, r11);
    L14:
        x8.b r12 = this.f13433c;     // Catch: Exception -> L9
        if (r12 == null) goto L7;
        r12.j1(r10);     // Catch: Exception -> L9
    L7:
        return x(r10, 0, "cancelTaskById时成功");
    L9:
        e = move-exception;
        w8.g.a("DownloadManager", "cancelTaskById " + r10 + " 失败", e);
        r11 = "cancelTaskById时发生异常";
        goto L12
    }

    public final DownloadInfo z(int r10) {
        w8.g.c("DownloadManager", "getTaskInfo " + r10);
        if (this.f13431a == true) goto L12;
        w8.g.c("DownloadManager", "getTaskInfo " + r10 + " 失败，服务还未绑定上");
    L11:
        return null;
    L12:
        x8.b r11 = this.f13433c;     // Catch: Exception -> L8
        if (r11 == null) goto L14;
        return r11.a(r10);
    L14:
        return null;
    L8:
        e = move-exception;
        w8.g.a("DownloadManager", "getTaskInfo " + r10 + " 失败", e);
        goto L11
    }
}
