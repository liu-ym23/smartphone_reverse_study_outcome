package com.obric.memorydata.utils.a;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.aiagent.product.platform.api.app.ObricFocusListener;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.utils.y;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000=\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t*\u0001\u0013\b\u0000\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0007H\u0002J\u0012\u0010\u0018\u001a\u00020\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\u001a\u001a\u00020\u0016H\u0002J\u0012\u0010\u001b\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0007H\u0002J\u0012\u0010\u001c\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\u001d\u001a\u00020\rH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0014¨\u0006\u001f"}, d2 = {"Lcom/obric/memorydata/utils/appstate/FocusAppStateRegistrationStrategy;", "Lcom/obric/memorydata/utils/appstate/AppStateRegistrationStrategy;", "callback", "Lcom/obric/memorydata/utils/appstate/AppStateRegistrationCallback;", "<init>", "(Lcom/obric/memorydata/utils/appstate/AppStateRegistrationCallback;)V", ActivityLifecycle.NAME, "", "getName", "()Ljava/lang/String;", "mainHandler", "Landroid/os/Handler;", "hasReceivedFocusForeground", "", "lastNotifiedFocusApp", "latestFocusApp", "notifyStableFocusRunnable", "Ljava/lang/Runnable;", "focusListener", "com/obric/memorydata/utils/appstate/FocusAppStateRegistrationStrategy$focusListener$1", "Lcom/obric/memorydata/utils/appstate/FocusAppStateRegistrationStrategy$focusListener$1;", "handleFocusForeground", "", ObricMemoryConstants.KEY_PACKAGE_NAME, "updateLatestFocusApp", "focusApp", "notifyStableFocusState", "notifyAppForeground", "notifyAppBackground", "register", "Companion", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class d implements com.obric.memorydata.utils.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f13149a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.obric.memorydata.utils.a.a f13150b;
    private final String c;
    private final Handler d;
    private boolean e;
    private String f;
    private String g;
    private final Runnable h;
    private final b i;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/utils/appstate/FocusAppStateRegistrationStrategy$Companion;", "", "<init>", "()V", "TAG", "", "FOCUS_STABLE_DELAY_MS", "", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\n"}, d2 = {"com/obric/memorydata/utils/appstate/FocusAppStateRegistrationStrategy$focusListener$1", "Lcom/obric/aiagent/product/platform/api/app/ObricFocusListener;", "onFocusForeground", "", ObricMemoryConstants.KEY_PACKAGE_NAME, "", "windowingMode", "", "onFreeformEntered", "onFreeformExited", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b extends ObricFocusListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f13151a;

        b(d r1) {
            this.f13151a = r1;
        }

        private static final void a(d r0, String r1) {
            d.a(r0, r1);
        }

        public static /* synthetic */ void lambda$5LIJP61WvM08r1U2K48X8Sqhwiw(d r0, String r1) {
            a(r0, r1);
        }

        @Override // com.obric.aiagent.product.platform.api.app.ObricFocusListener
        public void onFocusForeground(final String r8, int r9) {
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "FocusAppStateRegistrationStrategy", "onFocusForeground packageName=" + r8 + ", windowingMode=" + r9, false, 4, null);
            Handler r10 = d.a(this.f13151a);
            final d r7 = this.f13151a;
            r10.post(new $$Lambda$d$b$5LIJP61WvM08r1U2K48X8Sqhwiw(r7, r8));
        }

        @Override // com.obric.aiagent.product.platform.api.app.ObricFocusListener
        public void onFreeformEntered(String r7) {
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "FocusAppStateRegistrationStrategy", "onFreeformEntered packageName=" + r7, false, 4, null);
        }

        @Override // com.obric.aiagent.product.platform.api.app.ObricFocusListener
        public void onFreeformExited(String r7) {
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "FocusAppStateRegistrationStrategy", "onFreeformExited packageName=" + r7, false, 4, null);
        }
    }

    static {
        f13149a = new a(null);
    }

    public d(com.obric.memorydata.utils.a.a r3) {
        com.obric.memorydata.utils.a.a r4 = (com.obric.memorydata.utils.a.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.memorydata.utils.a.a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "callback");
        this.f13150b = r4;
        this.c = "focus";
        this.d = new Handler(Looper.getMainLooper());
        this.h = new $$Lambda$d$GJ7PH_P6RifNSsXuWxFMCVb0Mro(this);
        this.i = new b(this);
    }

    public static final /* synthetic */ Handler a(d r0) {
        return r0.d;
    }

    public static final /* synthetic */ void a(d r0, String r1) {
        r0.a(r1);
    }

    private final void a(String r2) {
        if (this.e == true) goto L6;
        this.e = true;
        this.f = r2;
        this.g = r2;
        c(r2);
        return;
    L6:
        b(r2);
    }

    private static final boolean a(Exception r7) {
        Intrinsics.checkNotNullParameter(r7, "e");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "FocusAppStateRegistrationStrategy", "registerFocusListener failed: " + r7.getMessage(), null, 4, null);
        return false;
    }

    private static final void b(d r0) {
        r0.c();
    }

    private final void b(String r3) {
        this.g = r3;
        this.d.removeCallbacks(this.h);
        this.d.postDelayed(this.h, 150);
    }

    private final void c() {
        String r0 = this.f;
        String r1 = this.g;
        if (Intrinsics.areEqual(r0, r1) == false) goto L5;
        return;
    L5:
        this.f = r1;
        if (r0 == null) goto L8;
        d(r0);
    L8:
        if (r1 == null) goto L11;
        c(r1);
        return;
    }

    private final void c(String r8) {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "FocusAppStateRegistrationStrategy", "notify onAppForeground packageName=" + r8, false, 4, null);
        this.f13150b.a(r8);
    }

    private static final boolean c(d r7) {
        boolean r8 = com.obric.aiagent.product.b.f5974a.a().activityTaskManager().registerFocusListener((ObricFocusListener) ZeusTransformUtils.preCheckCast(r7.i, ObricFocusListener.class, "com.obric.memorydata.plugin"));
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "FocusAppStateRegistrationStrategy", "registerFocusListener result=" + r8, false, 4, null);
        return r8;
    }

    private final void d(String r8) {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "FocusAppStateRegistrationStrategy", "notify onAppBackground packageName=" + r8, false, 4, null);
        this.f13150b.b(r8);
    }

    public static /* synthetic */ boolean lambda$FFq09Hmd8hG85WGG5UW6UWabU9c(d r0) {
        return c(r0);
    }

    public static /* synthetic */ boolean lambda$FO7NJJSUiR5MDR21gx_SA3Xta4c(Exception r0) {
        return a(r0);
    }

    public static /* synthetic */ void lambda$GJ7PH_P6RifNSsXuWxFMCVb0Mro(d r0) {
        b(r0);
    }

    @Override // com.obric.memorydata.utils.a.b
    public String a() {
        return this.c;
    }

    @Override // com.obric.memorydata.utils.a.b
    public boolean b() {
        Boolean r2 = (Boolean) ZeusTransformUtils.preCheckCast(y.a($$Lambda$d$FO7NJJSUiR5MDR21gx_SA3Xta4c.INSTANCE, new $$Lambda$d$FFq09Hmd8hG85WGG5UW6UWabU9c(this)), Boolean.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L7;
        return false;
    L7:
        return r2.booleanValue();
    }
}
