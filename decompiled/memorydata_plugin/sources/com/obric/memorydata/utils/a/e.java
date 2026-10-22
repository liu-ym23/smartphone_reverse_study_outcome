package com.obric.memorydata.utils.a;

import android.content.ComponentName;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.aiagent.product.platform.api.app.ObricActivitySwitchListener;
import com.obric.aiagent.product.platform.api.app.ObricAppSwitchListener;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.utils.y;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u000b\b\u0000\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/utils/appstate/LegacyAppStateRegistrationStrategy;", "Lcom/obric/memorydata/utils/appstate/AppStateRegistrationStrategy;", "callback", "Lcom/obric/memorydata/utils/appstate/AppStateRegistrationCallback;", "<init>", "(Lcom/obric/memorydata/utils/appstate/AppStateRegistrationCallback;)V", ActivityLifecycle.NAME, "", "getName", "()Ljava/lang/String;", "appSwitchListener", "com/obric/memorydata/utils/appstate/LegacyAppStateRegistrationStrategy$appSwitchListener$1", "Lcom/obric/memorydata/utils/appstate/LegacyAppStateRegistrationStrategy$appSwitchListener$1;", "activitySwitchListener", "Lcom/obric/aiagent/product/platform/api/app/ObricActivitySwitchListener;", "register", "", "registerActivitySwitchListener", "", "registerActivitySwitchListenerSafely", "Companion", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class e implements com.obric.memorydata.utils.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f13152a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.obric.memorydata.utils.a.a f13153b;
    private final String c;
    private final b d;
    private ObricActivitySwitchListener e;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/utils/appstate/LegacyAppStateRegistrationStrategy$Companion;", "", "<init>", "()V", "TAG", "", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/obric/memorydata/utils/appstate/LegacyAppStateRegistrationStrategy$appSwitchListener$1", "Lcom/obric/aiagent/product/platform/api/app/ObricAppSwitchListener;", "onAppForeground", "", ObricMemoryConstants.KEY_PACKAGE_NAME, "", "onAppBackground", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b extends ObricAppSwitchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ e f13154a;

        b(e r1) {
            this.f13154a = r1;
        }

        @Override // com.obric.aiagent.product.platform.api.app.ObricAppSwitchListener
        public void onAppBackground(String r4) {
            RunLog.INSTANCE.debug("LegacyAppStateRegistrationStrategy", "onAppBackground packageName=" + r4);
            e.a(this.f13154a).b(r4);
        }

        @Override // com.obric.aiagent.product.platform.api.app.ObricAppSwitchListener
        public void onAppForeground(String r4) {
            RunLog.INSTANCE.debug("LegacyAppStateRegistrationStrategy", "onAppForeground packageName=" + r4);
            e.a(this.f13154a).a(r4);
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/obric/memorydata/utils/appstate/LegacyAppStateRegistrationStrategy$registerActivitySwitchListenerSafely$2$listener$1", "Lcom/obric/aiagent/product/platform/api/app/ObricActivitySwitchListener;", "onActivityBackground", "", "componentName", "Landroid/content/ComponentName;", "onActivityForeground", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c extends ObricActivitySwitchListener {
        c() {
        }

        @Override // com.obric.aiagent.product.platform.api.app.ObricActivitySwitchListener
        public void onActivityBackground(ComponentName r7) {
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "LegacyAppStateRegistrationStrategy", "onActivityBackground " + r7, false, 4, null);
        }

        @Override // com.obric.aiagent.product.platform.api.app.ObricActivitySwitchListener
        public void onActivityForeground(ComponentName r7) {
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "LegacyAppStateRegistrationStrategy", "onActivityForeground " + r7, false, 4, null);
        }
    }

    static {
        f13152a = new a(null);
    }

    public e(com.obric.memorydata.utils.a.a r3) {
        com.obric.memorydata.utils.a.a r4 = (com.obric.memorydata.utils.a.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.memorydata.utils.a.a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "callback");
        this.f13153b = r4;
        this.c = "legacy";
        this.d = new b(this);
    }

    public static final /* synthetic */ com.obric.memorydata.utils.a.a a(e r0) {
        return r0.f13153b;
    }

    private static final boolean a(Exception r7) {
        Intrinsics.checkNotNullParameter(r7, "e");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "LegacyAppStateRegistrationStrategy", "registerAppSwitchListener failed: " + r7.getMessage(), null, 4, null);
        return false;
    }

    private static final boolean b(e r8) {
        boolean r0 = com.obric.aiagent.product.b.f5974a.a().activityTaskManager().registerAppSwitchListener((ObricAppSwitchListener) ZeusTransformUtils.preCheckCast(r8.d, ObricAppSwitchListener.class, "com.obric.memorydata.plugin"));
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "LegacyAppStateRegistrationStrategy", "registerAppSwitchListener result=" + r0, false, 4, null);
        if (r0 == false) goto L5;
        r8.c();
    L5:
        return r0;
    }

    private static final boolean b(Exception r7) {
        Intrinsics.checkNotNullParameter(r7, "e");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "LegacyAppStateRegistrationStrategy", "registerActivitySwitchListener failed: " + r7.getMessage(), null, 4, null);
        return false;
    }

    private final void c() {
        d();     // Catch: NoClassDefFoundError -> L4
        return;
    L4:
        e = move-exception;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "LegacyAppStateRegistrationStrategy", "ObricActivitySwitchListener not supported on this system: " + e.getMessage(), null, 4, null);
    }

    private static final boolean c(e r8) {
        c r0 = new c();
        boolean r1 = com.obric.aiagent.product.b.f5974a.a().activityTaskManager().registerActivitySwitchListener((ObricActivitySwitchListener) ZeusTransformUtils.preCheckCast(r0, ObricActivitySwitchListener.class, "com.obric.memorydata.plugin"));
        if (r1 == false) goto L5;
        r8.e = (ObricActivitySwitchListener) ZeusTransformUtils.preCheckCast(r0, ObricActivitySwitchListener.class, "com.obric.memorydata.plugin");
    L5:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "LegacyAppStateRegistrationStrategy", "registerActivitySwitchListener result=" + r1, false, 4, null);
        return r1;
    }

    private final void d() {
        y.a($$Lambda$e$RxHFnO3XhLo1Qlt8qM9tcl4sy2A.INSTANCE, new $$Lambda$e$vo20i6bYe5lHnSyNA9t389uOyYk(this));
    }

    public static /* synthetic */ boolean lambda$5G2LcmYQCFVkGAzlvJyn0snqEe8(Exception r0) {
        return a(r0);
    }

    public static /* synthetic */ boolean lambda$EDBBRC9VmuFqxagpZl22u91F10E(e r0) {
        return b(r0);
    }

    public static /* synthetic */ boolean lambda$RxHFnO3XhLo1Qlt8qM9tcl4sy2A(Exception r0) {
        return b(r0);
    }

    public static /* synthetic */ boolean lambda$vo20i6bYe5lHnSyNA9t389uOyYk(e r0) {
        return c(r0);
    }

    @Override // com.obric.memorydata.utils.a.b
    public String a() {
        return this.c;
    }

    @Override // com.obric.memorydata.utils.a.b
    public boolean b() {
        Boolean r2 = (Boolean) ZeusTransformUtils.preCheckCast(y.a($$Lambda$e$5G2LcmYQCFVkGAzlvJyn0snqEe8.INSTANCE, new $$Lambda$e$EDBBRC9VmuFqxagpZl22u91F10E(this)), Boolean.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L7;
        return false;
    L7:
        return r2.booleanValue();
    }
}
