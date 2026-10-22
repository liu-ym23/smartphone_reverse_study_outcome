package mn;

import android.util.Log;
import com.bytedance.env.api.EnvManager;
import com.bytedance.env.api.EnvManagerApi;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostALogDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostExternalStorageDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostHeadSetDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostLocationPermissionDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostLogDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostLogDependV2;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostMediaDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostMediaDependV2;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostMemoryWaringDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostNetworkDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostOpenDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostPermissionDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostPureNetworkDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostRouterDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostStyleUIDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostThreadPoolExecutorDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostUserDepend;
import com.lynx.tasm.p;
import com.obric.android.alog.Alog;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import t.o;

/* JADX INFO: loaded from: classes2.dex */
public abstract class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile Executor f20133a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile Executor f20134b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile Executor f20135c;
    public static volatile Executor d;
    public static volatile Executor e;
    public static Alog f;
    public static IHostLogDepend g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static IHostMediaDepend f20136h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static IHostMediaDependV2 f20137i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static IHostOpenDepend f20138j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static IHostContextDepend f20139k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static IHostStyleUIDepend f20140l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static IHostRouterDepend f20141m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static IHostUserDepend f20142n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static IHostNetworkDepend f20143o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static IHostPureNetworkDepend f20144p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static IHostPermissionDepend f20145q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static IHostLocationPermissionDepend f20146r;
    public static IHostThreadPoolExecutorDepend s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static IHostExternalStorageDepend f20147t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static IHostHeadSetDepend f20148u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static IHostALogDepend f20149v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static IHostMemoryWaringDepend f20150w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static IHostLogDependV2 f20151x;

    public static com.bytedance.android.anniex.scene.core.j a() {
        if (com.bytedance.android.anniex.scene.core.j.f3400n != null) goto L5;
        com.bytedance.android.anniex.scene.core.j.f3400n = new com.bytedance.android.anniex.scene.core.j();
    L5:
        com.bytedance.android.anniex.scene.core.j r5 = com.bytedance.android.anniex.scene.core.j.f3400n;
        Intrinsics.checkNotNull(r5);
        return r5;
    }

    public static com.bytedance.env.api.e b() {
        if (com.bytedance.ies.bullet.base.utils.b.f5231a != null) goto L21;
        monitor-enter(com.bytedance.ies.bullet.base.utils.b.class);
    L13:
        th = move-exception;
        throw th;
    L7:
        if (com.bytedance.ies.bullet.base.utils.b.f5231a == null) goto L25;
    L15:
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L13
        monitor-exit(com.bytedance.ies.bullet.base.utils.b.class);
        goto L21
    L25:
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L10
        Object r11 = Result.m124constructorimpl(Class.forName("com.bytedance.env.core.impl.EnvManagerApiImpl"));     // Catch: Throwable -> L10
    L12:
        com.bytedance.ies.bullet.base.utils.b.f5231a = Boolean.valueOf(Result.m131isSuccessimpl(r11));     // Catch: Throwable -> L13
        goto L15
    L10:
        th = move-exception;
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L13
        r11 = Result.m124constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L13
    L21:
        if (Intrinsics.areEqual(com.bytedance.ies.bullet.base.utils.b.f5231a, Boolean.TRUE) == false) goto L23;
        EnvManager.Companion.getClass();
        return ((EnvManagerApi) EnvManager.access$getApiImpl$cp().getValue()).getGeckoConfig();
    L23:
        return null;
    }

    public static ClassCastException c(Iterator r5) {
        return androidx.constraintlayout.motion.widget.a.g(r5);
    }

    public static Executor d() {
        if (f20134b != null) goto L16;
        monitor-enter(h.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f20134b != null) goto L11;
        f20134b = e(10, 2, "lynx-card-service-thread");     // Catch: Throwable -> L9
    L11:
        monitor-exit(h.class);     // Catch: Throwable -> L9
    L16:
        return f20134b;
    }

    public static Executor e(int r5, int r10, String r11) {
        return Executors.newFixedThreadPool(r10, new g(r11, r5));
    L4:
        th = move-exception;
        Log.e("lynx_LynxThreadPool", th.toString());
        return new h.a(1);
    }

    public static oi.d f(boolean r5, ib.d r10) {
        Intrinsics.checkNotNullParameter(r10, "permissionConfigProvider");
        p.f10926c = r10;
        if (r5 == false) goto L5;
        List r11 = oi.d.d;
    L6:
        ArrayList r12 = new ArrayList(CollectionsKt.h(r11));
        Iterator r13 = r11.iterator();
    L8:
        if (r13.hasNext() == false) goto L11;
        oi.a r14 = (oi.a) ((Class) r13.next()).newInstance();
        r14.b(r10);
        r12.add(r14);
        goto L8
    L11:
        return new oi.d(r12);
    L5:
        r11 = oi.d.f20583c;
        goto L6
    }

    public static void g(String r5, Throwable r10) {
        HashMap r11 = new HashMap();
        StringWriter r12 = new StringWriter();
        r10.printStackTrace(new PrintWriter(r12));
        r11.put("error_error_msg", r12.toString());
        r11.put("error_desc", r5);
        com.bytedance.android.monitorV2.i.b(r11, null, "internal_error");
        com.bytedance.android.monitorV2.h.e().getClass();
    }

    public static void h() {
        Alog r5 = f;
        if (r5 == null) goto L6;
        r5.asyncFlush();
        return;
    }

    public static Executor i() {
        if (f20133a != null) goto L16;
        monitor-enter(h.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f20133a != null) goto L11;
        f20133a = e(3, 2, "lynx-brief-io-thread");     // Catch: Throwable -> L9
    L11:
        monitor-exit(h.class);     // Catch: Throwable -> L9
    L16:
        return f20133a;
    }

    public static Executor j() {
        if (f20135c != null) goto L16;
        monitor-enter(h.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f20135c != null) goto L11;
        f20135c = e(10, 1, "lynx-image-request-thread");     // Catch: Throwable -> L9
    L11:
        monitor-exit(h.class);     // Catch: Throwable -> L9
    L16:
        return f20135c;
    }

    public static Executor k() {
        if (d != null) goto L16;
        monitor-enter(h.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (d != null) goto L11;
        d = e(3, 1, "lynx-svg-thread");     // Catch: Throwable -> L9
    L11:
        monitor-exit(h.class);     // Catch: Throwable -> L9
    L16:
        return d;
    }

    public static void l(int r5, String r10, String r11) {
        Alog r12 = f;
        if (r12 == null) goto L6;
        r12.write(r5, r10, r11);
        return;
    }

    public static p.a m(com.airbnb.lottie.parser.moshi.b r5, com.airbnb.lottie.h r10) {
        return new p.a(o.a(r5, r10, 1.0f, t.e.f22021b), 0);
    }

    public static p.b n(com.airbnb.lottie.parser.moshi.a r5, com.airbnb.lottie.h r10, boolean r11) {
        if (r11 == false) goto L5;
        float r12 = u.f.c();
    L7:
        return new p.b(o.a(r5, r10, r12, t.e.f22022c), 7);
    L5:
        r12 = 1.0f;
        goto L7
    }

    public static p.a o(com.airbnb.lottie.parser.moshi.b r5, com.airbnb.lottie.h r10) {
        return new p.a(o.a(r5, r10, 1.0f, t.e.d), 2);
    }

    public static p.a p(com.airbnb.lottie.parser.moshi.b r5, com.airbnb.lottie.h r10) {
        return new p.a(o.a(r5, r10, u.f.c(), t.e.f), 3);
    }

    public static void q(int r5, String r10, String r11) {
        Alog r12 = f;
        if (r12 == null) goto L6;
        r12.write(r5, r10, r11);
        return;
    }
}
