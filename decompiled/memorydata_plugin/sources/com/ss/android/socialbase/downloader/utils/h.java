package com.ss.android.socialbase.downloader.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import com.ss.android.socialbase.downloader.constants.ListenerType;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.IDownloadMonitorDepend;
import com.ss.android.socialbase.downloader.depend.aa;
import com.ss.android.socialbase.downloader.depend.ag;
import com.ss.android.socialbase.downloader.depend.ah;
import com.ss.android.socialbase.downloader.depend.aj;
import com.ss.android.socialbase.downloader.depend.ak;
import com.ss.android.socialbase.downloader.depend.k;
import com.ss.android.socialbase.downloader.depend.l;
import com.ss.android.socialbase.downloader.depend.n;
import com.ss.android.socialbase.downloader.depend.o;
import com.ss.android.socialbase.downloader.depend.p;
import com.ss.android.socialbase.downloader.depend.q;
import com.ss.android.socialbase.downloader.depend.r;
import com.ss.android.socialbase.downloader.depend.t;
import com.ss.android.socialbase.downloader.depend.u;
import com.ss.android.socialbase.downloader.depend.v;
import com.ss.android.socialbase.downloader.depend.w;
import com.ss.android.socialbase.downloader.depend.x;
import com.ss.android.socialbase.downloader.depend.y;
import com.ss.android.socialbase.downloader.depend.z;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes6.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Handler f15660a;

    static {
        f15660a = new Handler(Looper.getMainLooper());
    }

    static /* synthetic */ Handler a() {
        return f15660a;
    }

    public static IDownloadListener a(com.ss.android.socialbase.downloader.depend.g r2) {
        final com.ss.android.socialbase.downloader.depend.g r3 = (com.ss.android.socialbase.downloader.depend.g) ZeusTransformUtils.wrapperContextForParams(r2, com.ss.android.socialbase.downloader.depend.g.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L7;
        return null;
    L7:
        return new AnonymousClass20(r3);
    }

    public static IDownloadMonitorDepend a(com.ss.android.socialbase.downloader.depend.h r2) {
        final com.ss.android.socialbase.downloader.depend.h r3 = (com.ss.android.socialbase.downloader.depend.h) ZeusTransformUtils.wrapperContextForParams(r2, com.ss.android.socialbase.downloader.depend.h.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L7;
        return null;
    L7:
        return new AnonymousClass10(r3);
    }

    public static aa a(z r2) {
        final z r3 = (z) ZeusTransformUtils.wrapperContextForParams(r2, z.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L7;
        return null;
    L7:
        return new AnonymousClass5(r3);
    }

    public static ag a(ah r2) {
        final ah r3 = (ah) ZeusTransformUtils.wrapperContextForParams(r2, ah.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L7;
        return null;
    L7:
        return new AnonymousClass22(r3);
    }

    public static ah a(ag r2) {
        final ag r3 = (ag) ZeusTransformUtils.wrapperContextForParams(r2, ag.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L7;
        return null;
    L7:
        return new AnonymousClass8(r3);
    }

    public static aj a(ak r2) {
        final ak r3 = (ak) ZeusTransformUtils.wrapperContextForParams(r2, ak.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L7;
        return null;
    L7:
        return new AnonymousClass14(r3);
    }

    public static ak a(aj r2) {
        final aj r3 = (aj) ZeusTransformUtils.wrapperContextForParams(r2, aj.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L7;
        return null;
    L7:
        return new AnonymousClass15(r3);
    }

    public static com.ss.android.socialbase.downloader.depend.d a(n r2) {
        final n r3 = (n) ZeusTransformUtils.wrapperContextForParams(r2, n.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L7;
        return null;
    L7:
        return new AnonymousClass2(r3);
    }

    public static com.ss.android.socialbase.downloader.depend.e a(t r2) {
        final t r3 = (t) ZeusTransformUtils.wrapperContextForParams(r2, t.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L7;
        return null;
    L7:
        return new AnonymousClass24(r3);
    }

    public static com.ss.android.socialbase.downloader.depend.f a(y r2) {
        final y r3 = (y) ZeusTransformUtils.wrapperContextForParams(r2, y.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L7;
        return null;
    L7:
        return new AnonymousClass4(r3);
    }

    public static com.ss.android.socialbase.downloader.depend.g a(IDownloadListener r2, final boolean r3) {
        final IDownloadListener r4 = (IDownloadListener) ZeusTransformUtils.wrapperContextForParams(r2, IDownloadListener.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L7;
        return null;
    L7:
        return new AnonymousClass12(r4, r3);
    }

    public static com.ss.android.socialbase.downloader.depend.h a(IDownloadMonitorDepend r2) {
        final IDownloadMonitorDepend r3 = (IDownloadMonitorDepend) ZeusTransformUtils.wrapperContextForParams(r2, IDownloadMonitorDepend.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L7;
        return null;
    L7:
        return new AnonymousClass3(r3);
    }

    public static k a(l r2) {
        final l r3 = (l) ZeusTransformUtils.wrapperContextForParams(r2, l.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L7;
        return null;
    L7:
        return new AnonymousClass7(r3);
    }

    public static l a(k r2) {
        final k r3 = (k) ZeusTransformUtils.wrapperContextForParams(r2, k.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L7;
        return null;
    L7:
        return new AnonymousClass6(r3);
    }

    public static n a(com.ss.android.socialbase.downloader.depend.d r2) {
        final com.ss.android.socialbase.downloader.depend.d r3 = (com.ss.android.socialbase.downloader.depend.d) ZeusTransformUtils.wrapperContextForParams(r2, com.ss.android.socialbase.downloader.depend.d.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L7;
        return null;
    L7:
        return new AnonymousClass9(r3);
    }

    public static o a(q r2) {
        final q r3 = (q) ZeusTransformUtils.wrapperContextForParams(r2, q.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L7;
        return null;
    L7:
        return new AnonymousClass17(r3);
    }

    public static p a(r r2) {
        final r r3 = (r) ZeusTransformUtils.wrapperContextForParams(r2, r.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L7;
        return null;
    L7:
        return new AnonymousClass26(r3);
    }

    public static q a(o r2) {
        final o r3 = (o) ZeusTransformUtils.wrapperContextForParams(r2, o.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L7;
        return null;
    L7:
        return new AnonymousClass27(r3);
    }

    public static r a(p r2) {
        final p r3 = (p) ZeusTransformUtils.wrapperContextForParams(r2, p.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L7;
        return null;
    L7:
        return new AnonymousClass16(r3);
    }

    public static t a(com.ss.android.socialbase.downloader.depend.e r2) {
        final com.ss.android.socialbase.downloader.depend.e r3 = (com.ss.android.socialbase.downloader.depend.e) ZeusTransformUtils.wrapperContextForParams(r2, com.ss.android.socialbase.downloader.depend.e.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L7;
        return null;
    L7:
        return new AnonymousClass19(r3);
    }

    public static u a(w r2) {
        final w r3 = (w) ZeusTransformUtils.wrapperContextForParams(r2, w.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L7;
        return null;
    L7:
        return new AnonymousClass13(r3);
    }

    public static v a(x r2) {
        final x r3 = (x) ZeusTransformUtils.wrapperContextForParams(r2, x.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L7;
        return null;
    L7:
        return new AnonymousClass23(r3);
    }

    public static w a(u r2) {
        final u r3 = (u) ZeusTransformUtils.wrapperContextForParams(r2, u.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L7;
        return null;
    L7:
        return new AnonymousClass25(r3);
    }

    public static x a(v r2) {
        final v r3 = (v) ZeusTransformUtils.wrapperContextForParams(r2, v.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L7;
        return null;
    L7:
        return new AnonymousClass11(r3);
    }

    public static y a(com.ss.android.socialbase.downloader.depend.f r2) {
        final com.ss.android.socialbase.downloader.depend.f r3 = (com.ss.android.socialbase.downloader.depend.f) ZeusTransformUtils.wrapperContextForParams(r2, com.ss.android.socialbase.downloader.depend.f.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L7;
        return null;
    L7:
        return new AnonymousClass18(r3);
    }

    public static z a(aa r2) {
        final aa r3 = (aa) ZeusTransformUtils.wrapperContextForParams(r2, aa.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L7;
        return null;
    L7:
        return new AnonymousClass21(r3);
    }

    public static DownloadTask a(com.ss.android.socialbase.downloader.model.a r4) {
        com.ss.android.socialbase.downloader.model.a r5 = (com.ss.android.socialbase.downloader.model.a) ZeusTransformUtils.wrapperContextForParams(r4, com.ss.android.socialbase.downloader.model.a.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L19;
        return null;
    L19:
        DownloadTask r1 = new DownloadTask(r5.a());     // Catch: RemoteException -> L16
        r1.notificationEventListener(a(r5.b())).interceptor(a(r5.d())).depend(a(r5.e())).monitorDepend(a(r5.h())).forbiddenHandler(a(r5.f())).diskSpaceHandler(a(r5.g())).fileUriProvider(a(r5.i())).notificationClickCallback(a(r5.c()));     // Catch: RemoteException -> L16
        com.ss.android.socialbase.downloader.depend.g r2 = r5.b(ListenerType.MAIN.ordinal());     // Catch: RemoteException -> L16
        if (r2 == null) goto L8;
        r1.mainThreadListenerWithHashCode(r2.hashCode(), a(r2));     // Catch: RemoteException -> L16
    L8:
        com.ss.android.socialbase.downloader.depend.g r3 = r5.b(ListenerType.SUB.ordinal());     // Catch: RemoteException -> L16
        if (r3 == null) goto L11;
        r1.subThreadListenerWithHashCode(r3.hashCode(), a(r3));     // Catch: RemoteException -> L16
    L11:
        com.ss.android.socialbase.downloader.depend.g r6 = r5.b(ListenerType.NOTIFICATION.ordinal());     // Catch: RemoteException -> L16
        if (r6 == null) goto L14;
        r1.notificationListenerWithHashCode(r6.hashCode(), a(r6));     // Catch: RemoteException -> L16
    L14:
        a(r1, r5, ListenerType.MAIN);     // Catch: RemoteException -> L16
        a(r1, r5, ListenerType.SUB);     // Catch: RemoteException -> L16
        a(r1, r5, ListenerType.NOTIFICATION);     // Catch: RemoteException -> L16
        a(r1, r5);     // Catch: RemoteException -> L16
        return r1;
    L16:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static com.ss.android.socialbase.downloader.model.a a(final DownloadTask r1) {
        if (r1 != null) goto L6;
        return null;
    L6:
        return new AnonymousClass1(r1);
    }

    private static void a(DownloadTask r2, com.ss.android.socialbase.downloader.model.a r3) {
        com.ss.android.socialbase.downloader.model.a r4 = (com.ss.android.socialbase.downloader.model.a) ZeusTransformUtils.wrapperContextForParams(r3, com.ss.android.socialbase.downloader.model.a.class, "com.obric.memorydata.plugin");
        int r0 = 0;
    L4:
        if (r0 >= r4.j()) goto L9;
        k r1 = r4.c(r0);
        if (r1 == null) goto L8;
        r2.addDownloadCompleteHandler(a(r1));
    L8:
        r0 = r0 + 1;
        goto L4
    }

    private static void a(DownloadTask r5, com.ss.android.socialbase.downloader.model.a r6, ListenerType r7) {
        com.ss.android.socialbase.downloader.model.a r8 = (com.ss.android.socialbase.downloader.model.a) ZeusTransformUtils.wrapperContextForParams(r6, com.ss.android.socialbase.downloader.model.a.class, "com.obric.memorydata.plugin");
        ConcurrentHashMap r0 = new ConcurrentHashMap();
        int[] r1 = r8.a(r7.ordinal());
        if (r1 != null) goto L5;
    L13:
        r5.setDownloadListeners(r0, r7);
        return;
    L5:
        if (r1.length <= 0) goto L13;
        int r2 = 0;
    L8:
        if (r2 >= r1.length) goto L13;
        com.ss.android.socialbase.downloader.depend.g r3 = r8.a(r7.ordinal(), r1[r2]);
        if (r3 == null) goto L12;
        r0.put(Integer.valueOf(r3.a()), a(r3));
    L12:
        r2 = r2 + 1;
        goto L8
    }
}
