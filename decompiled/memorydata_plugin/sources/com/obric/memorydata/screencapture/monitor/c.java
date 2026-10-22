package com.obric.memorydata.screencapture.monitor;

import android.database.ContentObserver;
import android.os.Handler;
import android.os.Looper;
import com.obric.aiagent.product.platform.api.IPlatformService;
import com.obric.aiagent.product.platform.api.inputmethod.ObricInputMethodListener;
import com.obric.aiagent.product.platform.api.view.IObricWindowManager;
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
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000S\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0013\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0017J\u000e\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0017J\u0006\u0010\u001c\u001a\u00020\u000bJ\b\u0010\u001d\u001a\u00020\u0019H\u0002J\b\u0010\u001e\u001a\u00020\u0019H\u0002J\u0010\u0010%\u001a\u00020\u00192\u0006\u0010&\u001a\u00020\u000bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0014R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u001f\u001a\u00020 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b!\u0010\"¨\u0006'"}, d2 = {"Lcom/obric/memorydata/screencapture/monitor/InputMethodMonitor;", "", "<init>", "()V", "TAG", "", "KEY_INPUT_METHOD_SHOWN", "VALUE_SHOWN", "", "VALUE_HIDDEN", "mIsInputMethodShown", "", "Ljava/lang/Boolean;", "mSdkInputMethodListener", "Lcom/obric/aiagent/product/platform/api/inputmethod/ObricInputMethodListener;", "cachedWindowManager", "Lcom/obric/aiagent/product/platform/api/view/IObricWindowManager;", "getWindowManager", "inputObserver", "com/obric/memorydata/screencapture/monitor/InputMethodMonitor$inputObserver$1", "Lcom/obric/memorydata/screencapture/monitor/InputMethodMonitor$inputObserver$1;", "listeners", "", "Lcom/obric/memorydata/screencapture/monitor/IInputMethodStateChangeListener;", "addListener", "", "listener", "removeListener", "isShowing", "enableSdkMonitor", "disableSdkMonitor", "mainHandler", "Landroid/os/Handler;", "getMainHandler", "()Landroid/os/Handler;", "mainHandler$delegate", "Lkotlin/Lazy;", "notifyAllListeners", "shown", "screen_capture_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f12803a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Boolean f12804b;
    private static ObricInputMethodListener c;
    private static IObricWindowManager d;
    private static final b e = null;
    private static final List<com.obric.memorydata.screencapture.monitor.a> f = null;
    private static final Lazy g = null;

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"com/obric/memorydata/screencapture/monitor/InputMethodMonitor$enableSdkMonitor$1", "Lcom/obric/aiagent/product/platform/api/inputmethod/ObricInputMethodListener;", "onInputMethodShown", "", "onInputMethodHidden", "screen_capture_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a extends ObricInputMethodListener {
        a() {
        }

        @Override // com.obric.aiagent.product.platform.api.inputmethod.ObricInputMethodListener
        public void onInputMethodHidden() {
            c r6 = c.f12803a;
            c.a(false);
            c.a(c.f12803a, false);
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "InputMethodMonitor", "ime show: false", false, 4, null);
        }

        @Override // com.obric.aiagent.product.platform.api.inputmethod.ObricInputMethodListener
        public void onInputMethodShown() {
            c r6 = c.f12803a;
            c.a(true);
            c.a(c.f12803a, true);
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "InputMethodMonitor", "ime show: true", false, 4, null);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/memorydata/screencapture/monitor/InputMethodMonitor$inputObserver$1", "Landroid/database/ContentObserver;", "onChange", "", "selfChange", "", "screen_capture_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b extends ContentObserver {
        b(Handler r1) {
            super(r1);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean r7) {
            super.onChange(r7);
            Iterator r6 = c.b().iterator();
        L4:
            if (r6.hasNext() == false) goto L6;
            ((com.obric.memorydata.screencapture.monitor.a) ZeusTransformUtils.preCheckCast(r6.next(), com.obric.memorydata.screencapture.monitor.a.class, "com.obric.memorydata.plugin")).a(c.f12803a.a());
            goto L4
        L6:
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "InputMethodMonitor", "ime show: " + c.f12803a.a(), false, 4, null);
        }
    }

    static {
        f12803a = new c();
        e = new b(new Handler(Looper.getMainLooper()));
        f = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        g = LazyKt.lazy($$Lambda$c$eO93t0oGB_JBiQ6amE7CAxIYXs.INSTANCE);
    }

    private c() {
    }

    private static final IObricWindowManager a(Exception r9) {
        Intrinsics.checkNotNullParameter(r9, "e");
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "InputMethodMonitor", "fail to get IObricWindowManager: " + ExceptionsKt.stackTraceToString((Throwable) ZeusTransformUtils.preCheckCast(r9, Throwable.class, "com.obric.memorydata.plugin")), null, 4, null);
        return null;
    }

    private static final void a(com.obric.memorydata.screencapture.monitor.a r2, boolean r3) {
        ((com.obric.memorydata.screencapture.monitor.a) ZeusTransformUtils.wrapperContextForParams(r2, com.obric.memorydata.screencapture.monitor.a.class, "com.obric.memorydata.plugin")).a(r3);
    }

    public static final /* synthetic */ void a(c r0, boolean r1) {
        r0.a(r1);
    }

    public static final /* synthetic */ void a(Boolean r0) {
        f12804b = r0;
    }

    private final void a(final boolean r10) {
        if (Intrinsics.areEqual(f12804b, Boolean.valueOf(r10)) == true) goto L11;
        f12804b = Boolean.valueOf(r10);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "InputMethodMonitor", "ime show: " + r10, false, 4, null);
        Iterator r0 = CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(f, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L6:
        if (r0.hasNext() == false) goto L18;
        final com.obric.memorydata.screencapture.monitor.a r1 = (com.obric.memorydata.screencapture.monitor.a) ZeusTransformUtils.preCheckCast(r0.next(), com.obric.memorydata.screencapture.monitor.a.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L9;
        f().post(new $$Lambda$c$BnnaC11m9nzWV9p7J5tVwiVO9hY(r1, r10));
        goto L6
    L9:
        r1.a(r10);
        goto L6
    L18:
        return;
    }

    public static final /* synthetic */ List b() {
        return f;
    }

    private static final boolean b(Exception r3) {
        Intrinsics.checkNotNullParameter(r3, "e");
        RunLog.INSTANCE.error("InputMethodMonitor", "Failed to get input method state", (Throwable) ZeusTransformUtils.preCheckCast(r3, Throwable.class, "com.obric.memorydata.plugin"));
        return false;
    }

    private final IObricWindowManager c() {
        IObricWindowManager r2 = d;
        if (r2 == null) goto L6;
        return r2;
    L6:
        return (IObricWindowManager) ZeusTransformUtils.preCheckCast(y.a($$Lambda$c$7B62dPvCOX4GxBFjwMuEQ3Db0jk.INSTANCE, $$Lambda$c$z7ZBxyi9uDgKrGNkFRPAFgayrI4.INSTANCE), IObricWindowManager.class, "com.obric.memorydata.plugin");
    }

    private final void d() {
        IObricWindowManager r6 = c();
        if (r6 != null) goto L5;
        return;
    L5:
        ObricInputMethodListener r0 = (ObricInputMethodListener) ZeusTransformUtils.preCheckCast(new a(), ObricInputMethodListener.class, "com.obric.memorydata.plugin");
        c = r0;
        Intrinsics.checkNotNull(r0);
        if (r6.registerInputMethodListener(r0) == true) goto L8;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "InputMethodMonitor", "Failed to register SDK input method listener", null, 4, null);
        return;
    L8:
        f12804b = Boolean.valueOf(r6.isInputMethodShown());
    }

    private final void e() {
        IObricWindowManager r6 = c();
        if (r6 != null) goto L5;
        return;
    L5:
        ObricInputMethodListener r0 = c;
        if (r0 != null) goto L8;
    L10:
        c = null;
        f12804b = null;
        return;
    L8:
        if (r6.unregisterInputMethodListener(r0) == true) goto L10;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "InputMethodMonitor", "Failed to unregister SDK input method listener", null, 4, null);
        goto L10
    }

    private final Handler f() {
        return (Handler) ZeusTransformUtils.preCheckCast(g.getValue(), Handler.class, "com.obric.memorydata.plugin");
    }

    private static final IObricWindowManager g() {
        IPlatformService r0 = am.f13169a.a();
        if (r0 == null) goto L7;
        IObricWindowManager r1 = r0.windowManager();
        if (r1 == null) goto L7;
        d = r1;
        return r1;
    L7:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "InputMethodMonitor", "IObricWindowManager is not initialized", null, 4, null);
        return null;
    }

    private static final boolean h() {
        IObricWindowManager r0 = f12803a.c();
        if (r0 == null) goto L5;
        boolean r1 = r0.isInputMethodShown();
    L6:
        f12804b = Boolean.valueOf(r1);
        RunLog.INSTANCE.debug("InputMethodMonitor", "Query input method state: " + r1);
        return r1;
    L5:
        r1 = false;
        goto L6
    }

    private static final Handler i() {
        return new Handler(Looper.getMainLooper());
    }

    public static /* synthetic */ IObricWindowManager lambda$7B62dPvCOX4GxBFjwMuEQ3Db0jk(Exception r0) {
        return a(r0);
    }

    public static /* synthetic */ void lambda$BnnaC11m9nzWV9p7J5tVwiVO9hY(com.obric.memorydata.screencapture.monitor.a r0, boolean r1) {
        a(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$eO93t-0oGB_JBiQ6amE7CAxIYXs, reason: not valid java name */
    public static /* synthetic */ Handler m1176lambda$eO93t0oGB_JBiQ6amE7CAxIYXs() {
        return i();
    }

    public static /* synthetic */ boolean lambda$iKNJP1tyw7303Er7SS5p7j1oLIw(Exception r0) {
        return b(r0);
    }

    /* JADX INFO: renamed from: lambda$phxrxbJOQeCLOdrvt-jWcTHXLxA, reason: not valid java name */
    public static /* synthetic */ boolean m1177lambda$phxrxbJOQeCLOdrvtjWcTHXLxA() {
        return h();
    }

    public static /* synthetic */ IObricWindowManager lambda$z7ZBxyi9uDgKrGNkFRPAFgayrI4() {
        return g();
    }

    public final synchronized void a(com.obric.memorydata.screencapture.monitor.a r3) {
        monitor-enter(this);
        com.obric.memorydata.screencapture.monitor.a r4 = (com.obric.memorydata.screencapture.monitor.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.memorydata.screencapture.monitor.a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17
        Intrinsics.checkNotNullParameter(r4, "listener");     // Catch: Throwable -> L17
        List<com.obric.memorydata.screencapture.monitor.a> r0 = f;     // Catch: Throwable -> L17
        if (r0.isEmpty() == false) goto L10;
        r0.add(r4);     // Catch: Throwable -> L17
        d();     // Catch: Throwable -> L17
        Boolean r1 = f12804b;     // Catch: Throwable -> L17
        if (r1 == null) goto L15;
        boolean r2 = r1.booleanValue();     // Catch: Throwable -> L17
    L8:
        r4.a(r2);     // Catch: Throwable -> L17
    L15:
        monitor-exit(this);
        return;
    L10:
        if (r0.contains(r4) == true) goto L15;
        r0.add(r4);     // Catch: Throwable -> L17
        Boolean r5 = f12804b;     // Catch: Throwable -> L17
        if (r5 == null) goto L15;
        r2 = r5.booleanValue();     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    }

    public final boolean a() {
        Boolean r2 = f12804b;
        if (r2 != null) goto L5;
        Boolean r3 = (Boolean) ZeusTransformUtils.preCheckCast(y.a($$Lambda$c$iKNJP1tyw7303Er7SS5p7j1oLIw.INSTANCE, $$Lambda$c$phxrxbJOQeCLOdrvtjWcTHXLxA.INSTANCE), Boolean.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L11;
        return false;
    L11:
        return r3.booleanValue();
    L5:
        return r2.booleanValue();
    }

    public final synchronized void b(com.obric.memorydata.screencapture.monitor.a r3) {
        monitor-enter(this);
        com.obric.memorydata.screencapture.monitor.a r4 = (com.obric.memorydata.screencapture.monitor.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.memorydata.screencapture.monitor.a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        Intrinsics.checkNotNullParameter(r4, "listener");     // Catch: Throwable -> L10
        List<com.obric.memorydata.screencapture.monitor.a> r0 = f;     // Catch: Throwable -> L10
        if (r0.remove(r4) == true) goto L6;
    L8:
        monitor-exit(this);
        return;
    L6:
        if (r0.isEmpty() == false) goto L8;
        e();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }
}
