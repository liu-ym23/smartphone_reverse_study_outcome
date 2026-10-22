package com.obric.memorydata.screencapture;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import com.obric.aiagent.product.platform.api.IPlatformService;
import com.obric.aiagent.product.platform.api.notification.IObricNotificationManager;
import com.obric.aiagent.product.platform.api.notification.ObricNotificationListener;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.utils.am;
import com.obric.memorydata.utils.y;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\rJ\n\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002J\u000e\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u0016J\u000e\u0010!\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u0016J\u0006\u0010\"\u001a\u00020\u000bJ\b\u0010#\u001a\u00020\u000fH\u0002J\b\u0010$\u001a\u00020\u000fH\u0002J\u0010\u0010%\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u000bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001c¨\u0006'"}, d2 = {"Lcom/obric/memorydata/screencapture/NotificationPanelMonitor;", "", "<init>", "()V", "TAG", "", "KEY_NOTIFICATION_PANEL_SHOWN", "VALUE_SHOWN", "", "VALUE_HIDDEN", "isShowingCached", "", "appContext", "Landroid/content/Context;", "setContext", "", "context", "cachedNotificationManager", "Lcom/obric/aiagent/product/platform/api/notification/IObricNotificationManager;", "getNotificationManager", "listeners", "", "Lcom/obric/memorydata/screencapture/INotificationPanelStateChangeListener;", "mSdkNotificationListener", "Lcom/obric/aiagent/product/platform/api/notification/ObricNotificationListener;", "mainHandler", "Landroid/os/Handler;", "getMainHandler", "()Landroid/os/Handler;", "mainHandler$delegate", "Lkotlin/Lazy;", "addListener", "listener", "removeListener", "isShowing", "enable", "disable", "updateStateAndNotify", "shown", "screen_capture_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f12795a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f12796b;
    private static Context c;
    private static IObricNotificationManager d;
    private static final List<b> e = null;
    private static ObricNotificationListener f;
    private static final Lazy g = null;

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"com/obric/memorydata/screencapture/NotificationPanelMonitor$enable$2$1", "Lcom/obric/aiagent/product/platform/api/notification/ObricNotificationListener;", "onPanelShown", "", "onPanelHidden", "screen_capture_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a extends ObricNotificationListener {
        a() {
        }

        @Override // com.obric.aiagent.product.platform.api.notification.ObricNotificationListener
        public void onPanelHidden() {
            c.a(c.f12795a, false);
        }

        @Override // com.obric.aiagent.product.platform.api.notification.ObricNotificationListener
        public void onPanelShown() {
            c.a(c.f12795a, true);
        }
    }

    static {
        f12795a = new c();
        e = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        g = LazyKt.lazy($$Lambda$c$IJSijCyxLIaohAgOEnP9ReyMQY.INSTANCE);
    }

    private c() {
    }

    private static final IObricNotificationManager a(Exception r9) {
        Intrinsics.checkNotNullParameter(r9, "e");
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "NotificationPanelMonitor", "fail to get IObricNotificationManager: " + ExceptionsKt.stackTraceToString((Throwable) ZeusTransformUtils.preCheckCast(r9, Throwable.class, "com.obric.memorydata.plugin")), null, 4, null);
        return null;
    }

    private static final void a(b r2, boolean r3) {
        ((b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.memorydata.plugin")).a(r3);
    }

    public static final /* synthetic */ void a(c r0, boolean r1) {
        r0.a(r1);
    }

    private final void a(final boolean r6) {
        if (f12796b == r6) goto L11;
        f12796b = r6;
        RunLog.INSTANCE.debug("NotificationPanelMonitor", "notification panel show: " + r6);
        Iterator r0 = CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(e, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L6:
        if (r0.hasNext() == false) goto L18;
        final b r1 = (b) ZeusTransformUtils.preCheckCast(r0.next(), b.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L9;
        c().post(new $$Lambda$c$PhbLgtxLrDWHVyLj7JbB5IV5bU(r1, r6));
        goto L6
    L9:
        r1.a(r6);
        goto L6
    L18:
        return;
    }

    private final IObricNotificationManager b() {
        IObricNotificationManager r2 = d;
        if (r2 == null) goto L6;
        return r2;
    L6:
        return (IObricNotificationManager) ZeusTransformUtils.preCheckCast(y.a($$Lambda$c$TYAzHSAxEqbQyKY5rGKDCgspHCA.INSTANCE, $$Lambda$c$M_FERKoBgofI6fWhsMuZSN0Pp9Q.INSTANCE), IObricNotificationManager.class, "com.obric.memorydata.plugin");
    }

    private static final Unit b(Exception r3) {
        Intrinsics.checkNotNullParameter(r3, "e");
        RunLog.INSTANCE.error("NotificationPanelMonitor", "Failed to enable notification monitor: ", (Throwable) ZeusTransformUtils.preCheckCast(r3, Throwable.class, "com.obric.memorydata.plugin"));
        return Unit.INSTANCE;
    }

    private final Handler c() {
        return (Handler) ZeusTransformUtils.preCheckCast(g.getValue(), Handler.class, "com.obric.memorydata.plugin");
    }

    private final void d() {
        y.a($$Lambda$c$H7oCwmdRcQeXOGVmR7uAc8duydI.INSTANCE, $$Lambda$c$eV34ct8ESCH6TXk6rynHN3D0Acg.INSTANCE);
    }

    private final void e() {
        IObricNotificationManager r6 = b();     // Catch: Throwable -> L8 Exception -> L10
        if (r6 == null) goto L6;
        ObricNotificationListener r2 = f;     // Catch: Throwable -> L8 Exception -> L10
        Intrinsics.checkNotNull(r2);     // Catch: Throwable -> L8 Exception -> L10
        r6.unregisterNotificationListener(r2);     // Catch: Throwable -> L8 Exception -> L10
    L6:
        RunLog.INSTANCE.debug("NotificationPanelMonitor", "NotificationPanelMonitor disabled");     // Catch: Throwable -> L8 Exception -> L10
    L7:
        f = null;
        return;
    L10:
        e = move-exception;
        RunLog.INSTANCE.error("NotificationPanelMonitor", "Failed to disable notification monitor: ", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        f = null;
        throw th;
    }

    private static final IObricNotificationManager f() {
        IPlatformService r0 = am.f13169a.a();
        if (r0 == null) goto L7;
        IObricNotificationManager r1 = r0.notificationManager();
        if (r1 == null) goto L7;
        d = r1;
        return r1;
    L7:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "NotificationPanelMonitor", "IObricNotificationManager is not initialized", null, 4, null);
        return null;
    }

    private static final Handler g() {
        return new Handler(Looper.getMainLooper());
    }

    private static final Unit h() {
        c r0 = f12795a;
        IObricNotificationManager r1 = r0.b();
        if (r1 == null) goto L5;
        boolean r2 = r1.isPanelShown();
    L12:
        f12796b = r2;
        RunLog.INSTANCE.debug("NotificationPanelMonitor", "NotificationPanelMonitor enabled, initial state: " + f12796b);
        IObricNotificationManager r3 = r0.b();
        if (r3 == null) goto L15;
        ObricNotificationListener r4 = (ObricNotificationListener) ZeusTransformUtils.preCheckCast(new a(), ObricNotificationListener.class, "com.obric.memorydata.plugin");
        f = r4;
        Intrinsics.checkNotNull(r4);
        if (r3.registerNotificationListener(r4) == true) goto L20;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "NotificationPanelMonitor", "Failed to register SDK notification listener", null, 4, null);
    L20:
        return Unit.INSTANCE;
    L15:
        return Unit.INSTANCE;
    L5:
        Context r5 = c;
        if (r5 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("appContext");
        r5 = null;
    L9:
        if (Settings.Global.getInt(r5.getContentResolver(), "notification_panel_shown", 0) != 1) goto L11;
        r2 = true;
        goto L12
    L11:
        r2 = false;
        goto L12
    }

    public static /* synthetic */ Unit lambda$H7oCwmdRcQeXOGVmR7uAc8duydI(Exception r0) {
        return b(r0);
    }

    /* JADX INFO: renamed from: lambda$IJSijCyx-LIaohAgOEnP9ReyMQY, reason: not valid java name */
    public static /* synthetic */ Handler m1173lambda$IJSijCyxLIaohAgOEnP9ReyMQY() {
        return g();
    }

    public static /* synthetic */ IObricNotificationManager lambda$M_FERKoBgofI6fWhsMuZSN0Pp9Q() {
        return f();
    }

    /* JADX INFO: renamed from: lambda$PhbLgtxLrDWHVyLj7JbB5IV-5bU, reason: not valid java name */
    public static /* synthetic */ void m1174lambda$PhbLgtxLrDWHVyLj7JbB5IV5bU(b r0, boolean r1) {
        a(r0, r1);
    }

    public static /* synthetic */ IObricNotificationManager lambda$TYAzHSAxEqbQyKY5rGKDCgspHCA(Exception r0) {
        return a(r0);
    }

    public static /* synthetic */ Unit lambda$eV34ct8ESCH6TXk6rynHN3D0Acg() {
        return h();
    }

    public final void a(Context r2) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        c = r1;
    }

    public final synchronized void a(b r3) {
        monitor-enter(this);
        b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        Intrinsics.checkNotNullParameter(r4, "listener");     // Catch: Throwable -> L11
        List<b> r0 = e;     // Catch: Throwable -> L11
        if (r0.isEmpty() == false) goto L7;
        d();     // Catch: Throwable -> L11
    L7:
        if (r0.contains(r4) == true) goto L9;
        r0.add(r4);     // Catch: Throwable -> L11
        r4.a(f12796b);     // Catch: Throwable -> L11
    L9:
        monitor-exit(this);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public final boolean a() {
        return f12796b;
    }

    public final synchronized void b(b r3) {
        monitor-enter(this);
        b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L8
        Intrinsics.checkNotNullParameter(r4, "listener");     // Catch: Throwable -> L8
        List<b> r0 = e;     // Catch: Throwable -> L8
        r0.remove(r4);     // Catch: Throwable -> L8
        if (r0.isEmpty() == false) goto L6;
        e();     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
