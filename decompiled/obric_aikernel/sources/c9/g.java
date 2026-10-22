package c9;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import com.bytedance.common.wschannel.WsConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final a f656l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static g f657m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static String f658n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f659a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final c9.d f660b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private c9.b f661c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f662d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final CopyOnWriteArrayList<c9.a> f663e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Handler f664f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final CopyOnWriteArrayList<b> f665g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final e f666h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Handler f667i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final d f668j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final c f669k;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final g a() {
            if (g.e() == null) goto L7;
            g r10 = g.e();
            Intrinsics.checkNotNull(r10);
            return r10;
        L7:
            throw new IllegalStateException("MatrixTeaManager还没初始化，请先调用init方法进行初始化~~~".toString());
        }

        public final void b(Context r10, c9.d r11) {
            Intrinsics.checkNotNullParameter(r10, "context");
            Intrinsics.checkNotNullParameter(r11, "config");
            if (g.e() == null) goto L5;
        L15:
            g r12 = g.e();
            Intrinsics.checkNotNull(r12);
            r12.o();
            return;
        L5:
            monitor-enter(g.class);
        L12:
            th = move-exception;
            throw th;
        L7:
            if (g.e() != null) goto L9;
            a r13 = g.f656l;     // Catch: Throwable -> L12
            g.l(new g(r10, r11, null));     // Catch: Throwable -> L12
        L9:
            Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L12
            monitor-exit(g.class);
            goto L15
        }
    }

    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f670a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final JSONObject f671b;

        public b(String r10, JSONObject r11) {
            Intrinsics.checkNotNullParameter(r10, "eventName");
            Intrinsics.checkNotNullParameter(r11, "jsonObject");
            this.f670a = r10;
            this.f671b = r11;
        }

        public final String a() {
            return this.f670a;
        }

        public final JSONObject b() {
            return this.f671b;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof b) == true) goto L8;
            return false;
        L8:
            b r11 = (b) r10;
            if (Intrinsics.areEqual(this.f670a, r11.f670a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f671b, r11.f671b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f670a.hashCode() * 31) + this.f671b.hashCode();
        }

        public String toString() {
            return "PendingEvent(eventName=" + this.f670a + ", jsonObject=" + this.f671b + ')';
        }
    }

    public static final class c implements ServiceConnection {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ g f672c;

        c(g r10) {
            this.f672c = r10;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName r10, IBinder r11) {
            e9.b.f("MatrixTeaManager", "onServiceConnected: ", null, 4, null);     // Catch: Exception -> L8
            g.d(this.f672c).removeCallbacksAndMessages(null);     // Catch: Exception -> L8
            g.n(this.f672c, c9.b.a.U0(r11));     // Catch: Exception -> L8
            g.j(this.f672c, true);     // Catch: Exception -> L8
            c9.b r12 = g.g(this.f672c);     // Catch: Exception -> L8
            if (r12 == null) goto L6;
            r12.o1(g.c(this.f672c));     // Catch: Exception -> L8
        L6:
            g.i(this.f672c);     // Catch: Exception -> L8
            return;
        L8:
            e = move-exception;
            e9.b.c("MatrixTeaManager", "onServiceConnected error", e);
            this.f672c.x();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName r10) {
            this.f672c.x();
        }
    }

    public static final class d extends c9.c.a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ g f673c;

        d(g r10) {
            this.f673c = r10;
        }

        @Override // c9.c
        public void O1(String r10) {
            Intrinsics.checkNotNullParameter(r10, "installId");
            a r11 = g.f656l;
            g.m(r10);
            Iterator r12 = g.f(this.f673c).iterator();
        L4:
            if (r12.hasNext() == false) goto L6;
            ((c9.a) r12.next()).b(r10);
            goto L4
        }

        @Override // c9.c
        public void b1(String r10) {
            Intrinsics.checkNotNullParameter(r10, "deviceId");
            e9.b.f("MatrixTeaManager", "回调deviceId: " + r10 + "， listeners.size = " + g.f(this.f673c).size(), null, 4, null);
            a r11 = g.f656l;
            g.k(r10);
            Iterator r12 = g.f(this.f673c).iterator();
        L4:
            if (r12.hasNext() == false) goto L6;
            c9.a r13 = (c9.a) r12.next();
            e9.b.f("MatrixTeaManager", "回调deviceId了，开始回调listener: " + r10 + " , listener = " + r13, null, 4, null);
            r13.a(r10);
            goto L4
        }
    }

    public static final class e implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ g f674c;

        e(g r10) {
            this.f674c = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (g.h(this.f674c) == true) goto L6;
            e9.b.f("MatrixTeaManager", "尝试重新绑定下载服务", null, 4, null);
            this.f674c.p();
            g.d(this.f674c).postDelayed(this, 5000);
            return;
        }
    }

    static {
        f656l = new a(null);
    }

    private g(Context r10, c9.d r11) {
        this.f659a = r10;
        this.f660b = r11;
        this.f663e = new CopyOnWriteArrayList();
        this.f664f = new Handler(Looper.getMainLooper());
        this.f665g = new CopyOnWriteArrayList();
        this.f666h = new e(this);
        HandlerThread r12 = new HandlerThread("MatrixTeaBackgroundThread");
        r12.start();
        this.f667i = new Handler(r12.getLooper());
        this.f668j = new d(this);
        this.f669k = new c(this);
    }

    public /* synthetic */ g(Context r10, c9.d r11, DefaultConstructorMarker r12) {
        this(r10, r11);
    }

    public static /* synthetic */ void a(g r10, String r11, JSONObject r12, JSONObject r13) {
        v(r10, r11, r12, r13);
    }

    public static /* synthetic */ void b(g r10) {
        y(r10);
    }

    public static final /* synthetic */ d c(g r10) {
        return r10.f668j;
    }

    public static final /* synthetic */ Handler d(g r10) {
        return r10.f664f;
    }

    public static final /* synthetic */ g e() {
        return f657m;
    }

    public static final /* synthetic */ CopyOnWriteArrayList f(g r10) {
        return r10.f663e;
    }

    public static final /* synthetic */ c9.b g(g r10) {
        return r10.f661c;
    }

    public static final /* synthetic */ boolean h(g r10) {
        return r10.f662d;
    }

    public static final /* synthetic */ void i(g r10) {
        r10.w();
    }

    public static final /* synthetic */ void j(g r10, boolean r11) {
        r10.f662d = r11;
    }

    public static final /* synthetic */ void k(String r10) {
        f658n = r10;
    }

    public static final /* synthetic */ void l(g r10) {
        f657m = r10;
    }

    public static final /* synthetic */ void m(String r10) {
    }

    public static final /* synthetic */ void n(g r10, c9.b r11) {
        r10.f661c = r11;
    }

    private final JSONObject q(JSONObject r10) {
        LinkedList r11 = new LinkedList();
        Iterator<String> r12 = r10.keys();
    L4:
        if (r12.hasNext() == false) goto L22;
        String r13 = r12.next();
        Intrinsics.checkNotNullExpressionValue(r13, "keysIterable.next()");
        r11.add(r13);
        goto L4
    L22:
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L11
        Object[] r15 = r11.toArray(new String[0]);     // Catch: Throwable -> L11
        if (r15 == null) goto L10;
        Object r16 = Result.m32constructorimpl(new JSONObject(r10, (String[]) r15));     // Catch: Throwable -> L11
    L13:
        Throwable r17 = Result.m35exceptionOrNullimpl(r16);
        if (r17 == null) goto L16;
        e9.b.c("MatrixTeaManager", "copyJson error", r17);
    L16:
        Object r18 = r10;
        if (Result.m38isFailureimpl(r16) == true) goto L21;
        r18 = r16;
    L21:
        return (JSONObject) r18;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r16 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L13
    }

    private final void u(final String r10, final JSONObject r11) {
        final JSONObject r12 = q(r11);
        this.f667i.post(new f(this, r10, r12, r11));
    }

    private static final void v(g r10, String r11, JSONObject r12, JSONObject r13) {
        Intrinsics.checkNotNullParameter(r10, "this$0");
        Intrinsics.checkNotNullParameter(r11, "$eventName");
        Intrinsics.checkNotNullParameter(r12, "$copyJson");
        Intrinsics.checkNotNullParameter(r13, "$jsonObject");
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L9
        c9.b r15 = r10.f661c;     // Catch: Throwable -> L9
        if (r15 == null) goto L6;
        r15.onEvent(r11, r12.toString());     // Catch: Throwable -> L9
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L9
    L7:
        Object r17 = Result.m32constructorimpl(r16);     // Catch: Throwable -> L9
    L11:
        Throwable r18 = Result.m35exceptionOrNullimpl(r17);
        if (r18 == null) goto L17;
        r10.f665g.add(new b(r11, r13));
        e9.b.c("MatrixTeaManager", "onEvent error", r18);
        return;
    L17:
        return;
    L6:
        r16 = null;
    L9:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r17 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    private final void w() {
        if (this.f665g.isEmpty() == false) goto L6;
        e9.b.f("MatrixTeaManager", "没有暂存的事件需要处理", null, 4, null);
        return;
    L6:
        e9.b.f("MatrixTeaManager", "开始处理 " + this.f665g.size() + " 个暂存事件", null, 4, null);
        CopyOnWriteArrayList<b> r10 = this.f665g;
        ArrayList r11 = new ArrayList();
        Iterator<T> r12 = r10.iterator();
    L8:
        if (r12.hasNext() == false) goto L20;
        Object r13 = r12.next();
        b r14 = (b) r13;
        boolean r15 = false;
        JSONObject r16 = new JSONObject(r14.b().toString());     // Catch: Exception -> L16
        r16.put("app_package_name", this.f660b.a());     // Catch: Exception -> L16
        r16.put("app_version_code", this.f660b.b());     // Catch: Exception -> L16
        r16.put("app_version_name", this.f660b.c());     // Catch: Exception -> L16
        if (this.f660b.d() == false) goto L13;
        int r17 = 1;
    L14:
        r16.put("app_is_boe", r17);     // Catch: Exception -> L16
        u(r14.a(), r16);     // Catch: Exception -> L16
        e9.b.f("MatrixTeaManager", "成功发送暂存事件: " + r14.a(), null, 4, null);     // Catch: Exception -> L16
    L18:
        if (r15 == false) goto L8;
        r11.add(r13);
        goto L8
    L13:
        r17 = 0;
    L16:
        e = move-exception;
        e9.b.c("MatrixTeaManager", "发送暂存事件 " + r14.a() + " 失败", e);
        r15 = true;
        goto L18
    L20:
        this.f665g.clear();
        this.f665g.addAll(r11);
    }

    private static final void y(g r10) {
        Intrinsics.checkNotNullParameter(r10, "this$0");
        r10.o();
    }

    public final void o() {
        p();
        this.f664f.postDelayed(this.f666h, 5000);
    }

    public final void p() {
        if (this.f662d == false) goto L6;
        e9.b.f("MatrixTeaManager", "bindServiceInternal: service is already bound", null, 4, null);
        return;
    L6:
        Intent r10 = new Intent();
        r10.setAction("com.obric.matrix.dataanalysis.service");
        r10.setPackage("com.obric.matrix");
        this.f659a.bindService(r10, this.f669k, 1);
    }

    public final String r() {
        String r10 = f658n;
        if (r10 != null) goto L5;
    L8:
        boolean r11 = true;
    L10:
        if (r11 == true) goto L14;
        e9.b.f("MatrixTeaManager", "getDeviceId 有值，立即回调 " + f658n, null, 4, null);
        return f658n;
    L14:
        if (this.f662d == true) goto L26;
        e9.b.d("MatrixTeaManager", "getDeviceId error,Service not bounded", null, 4, null);
        return null;
    L26:
        c9.b r12 = this.f661c;     // Catch: Exception -> L21
        if (r12 == null) goto L18;
        String r13 = r12.getDeviceId();     // Catch: Exception -> L21
    L19:
        f658n = r13;     // Catch: Exception -> L21
        return r13;
    L18:
        r13 = null;
    L21:
        e = move-exception;
        e9.b.c("MatrixTeaManager", "getDeviceId error", e);
        return null;
    L5:
        if (r10.length() == 0) goto L8;
        r11 = false;
        goto L10
    }

    public final void s(String r10, float r11, JSONObject r12) {
        Intrinsics.checkNotNullParameter(r10, "pageName");
        if (r12 != null) goto L5;
        r12 = new JSONObject();
    L5:
        r12.put("page_name", r10);
        r12.put("fps", Float.valueOf(r11));
        t("apm_event_fps", r12);
    }

    public final void t(String r10, JSONObject r11) {
        Intrinsics.checkNotNullParameter(r10, "eventName");
        Intrinsics.checkNotNullParameter(r11, "jsonObject");
        String r12 = r11.toString();     // Catch: Throwable -> L24
        Intrinsics.checkNotNullExpressionValue(r12, "jsonObject.toString()");     // Catch: Throwable -> L24
        byte[] r13 = r12.getBytes(Charsets.UTF_8);     // Catch: Throwable -> L24
        Intrinsics.checkNotNullExpressionValue(r13, "this as java.lang.String).getBytes(charset)");     // Catch: Throwable -> L24
        int r14 = r13.length;     // Catch: Throwable -> L24
        if (r14 <= 204800) goto L9;
        e9.b.d("MatrixTeaManager", "事件 " + r10 + " 数据大小 " + r14 + " 字节超过200KB限制，已丢弃", null, 4, null);
        return;
    L9:
        if (this.f662d == true) goto L31;
        this.f665g.add(new b(r10, new JSONObject(r11.toString())));     // Catch: Exception -> L20
        e9.b.f("MatrixTeaManager", "服务未绑定，暂存事件: " + r10 + " 成功，当前暂存数量: " + this.f665g.size(), null, 4, null);     // Catch: Exception -> L20
        return;
    L20:
        e = e;
        String r15 = "服务未绑定，暂存事件 " + r10 + " 失败";
    L22:
        e9.b.c("MatrixTeaManager", r15, e);
        return;
    L31:
        r11.put("app_package_name", this.f660b.a());     // Catch: Exception -> L16
        r11.put("app_version_code", this.f660b.b());     // Catch: Exception -> L16
        r11.put("app_version_name", this.f660b.c());     // Catch: Exception -> L16
        if (this.f660b.d() == false) goto L13;
        int r16 = 1;
    L14:
        r11.put("app_is_boe", r16);     // Catch: Exception -> L16
        u(r10, r11);     // Catch: Exception -> L16
        return;
    L13:
        r16 = 0;
    L16:
        e = e;
        r15 = "onEvent error";
    L24:
        th = move-exception;
        e9.b.c("MatrixTeaManager", "计算事件大小失败，已丢弃事件 " + r10, th);
    }

    public final void x() {
        this.f662d = false;     // Catch: Exception -> L5
        this.f661c = null;     // Catch: Exception -> L5
        this.f664f.postDelayed(new c9.e(this), WsConstants.EXIT_DELAY_TIME);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e9.b.c("MatrixTeaManager", "rebindService error", e);
    }
}
