package com.obric.memorydata.memory;

import android.content.Context;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.settings.SettingsChangeListener;
import com.obric.memorydata.middleware.api.settings.SettingsManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.cu;
import kotlinx.coroutines.flow.ae;
import kotlinx.coroutines.flow.ar;
import kotlinx.coroutines.flow.at;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0018\u001a\u00020\u0019J\b\u0010\u001a\u001a\u00020\u0019H\u0002J\u0006\u0010\u001b\u001a\u00020\u0016J\u0006\u0010\u001c\u001a\u00020\u0016J\u000e\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u0007J\u000e\u0010\u001f\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u0007J\b\u0010 \u001a\u00020\u0019H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/obric/memorydata/memory/AutoMemoryRuntimeCoordinator;", "", "<init>", "()V", "log", "Lcom/obric/memorydata/middleware/api/logging/ModuleLogger;", "lastDecision", "", "initialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "refreshVersion", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "_mode", "Lcom/obric/memorydata/memory/AutoMemoryRuntimeMode;", "mode", "Lkotlinx/coroutines/flow/StateFlow;", "getMode", "()Lkotlinx/coroutines/flow/StateFlow;", "legacyInitialized", "", "activeUser", CommonConsts.APM_INNER_EVENT_COST_INIT, "", "refresh", "isAccessibilityMode", "requiresAccessibilityWhenEnabled", "isInAppAllowed", ObricMemoryConstants.KEY_PACKAGE_NAME, "isLegacyAllowed", "reconcile", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f10076a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final com.obric.memorydata.middleware.api.logging.o f10077b = null;
    private static String c;
    private static final AtomicBoolean d = null;
    private static final al e = null;
    private static final ae<Long> f = null;
    private static final ae<AutoMemoryRuntimeMode> g = null;
    private static final ar<AutoMemoryRuntimeMode> h = null;
    private static boolean i;
    private static volatile String j;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/memorydata/memory/AutoMemoryRuntimeCoordinator$init$1", "Lcom/obric/memorydata/middleware/api/settings/SettingsChangeListener;", "onSettingsChanged", "", "key", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements SettingsChangeListener {
        a() {
        }

        @Override // com.obric.memorydata.middleware.api.settings.SettingsChangeListener
        public void onSettingsChanged(String r1) {
            Intrinsics.checkNotNullParameter(r1, "key");
            b.a(b.f10076a);
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.b$b, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/memorydata/memory/AutoMemoryRuntimeCoordinator$init$2", "Lcom/obric/memorydata/middleware/api/settings/SettingsChangeListener;", "onSettingsChanged", "", "key", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C0493b implements SettingsChangeListener {
        C0493b() {
        }

        @Override // com.obric.memorydata.middleware.api.settings.SettingsChangeListener
        public void onSettingsChanged(String r3) {
            Intrinsics.checkNotNullParameter(r3, "key");
            y.a(y.f11594a, null, false, 3, null);
            com.obric.memorydata.memory.ui.settings.l.f11479a.a().w();
            com.obric.memorydata.memory.inapprule.b.f10150a.c();
            b.a(b.f10076a);
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¨\u0006\b"}, d2 = {"com/obric/memorydata/memory/AutoMemoryRuntimeCoordinator$init$3", "Lcom/obric/memorydata/middleware/api/app/LoginStateListener;", "onLogin", "", "userId", "", "onLogout", "lastUserId", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c implements com.obric.memorydata.middleware.api.app.d {
        c() {
        }

        @Override // com.obric.memorydata.middleware.api.app.d
        public void a(String r1) {
            Intrinsics.checkNotNullParameter(r1, "userId");
            b.a(b.f10076a);
        }

        @Override // com.obric.memorydata.middleware.api.app.d
        public void b(String r1) {
            Intrinsics.checkNotNullParameter(r1, "lastUserId");
            b.a(b.f10076a);
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"com/obric/memorydata/memory/AutoMemoryRuntimeCoordinator$init$4", "Lcom/obric/memorydata/middleware/api/app/EnterpriseAccountListener;", "onEnterEnterprise", "", "onExitEnterprise", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class d implements com.obric.memorydata.middleware.api.app.b {
        d() {
        }

        @Override // com.obric.memorydata.middleware.api.app.b
        public void a() {
            b.a(b.f10076a);
        }

        @Override // com.obric.memorydata.middleware.api.app.b
        public void b() {
            b.a(b.f10076a);
        }
    }

    static {
        f10076a = new b();
        f10077b = com.obric.memorydata.middleware.api.logging.t.f11635a.a("AutoMemoryRuntime");
        c = "";
        d = new AtomicBoolean(false);
        e = am.a(cu.a(null, 1, null).plus((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin")));
        f = at.a(0L);
        ae<AutoMemoryRuntimeMode> r1 = at.a(AutoMemoryRuntimeMode.DISABLED);
        g = r1;
        h = kotlinx.coroutines.flow.k.a(r1);
        j = "";
    }

    private b() {
    }

    private static final Unit a(AutoMemoryRuntimeMode r1, boolean r2, com.obric.memorydata.middleware.api.logging.g r3) {
        Intrinsics.checkNotNullParameter(r3, "$this$mainTrace");
        r3.a("mode", r1.name());
        r3.a("cloud_enabled", Boolean.valueOf(r2));
        r3.a("in_app_supported", Boolean.valueOf(e.f10115a.c()));
        r3.a("rules_ready", com.obric.memorydata.memory.inapprule.b.f10150a.a().c());
        r3.a("master_enabled", com.obric.memorydata.memory.ui.settings.l.f11479a.a().a().c());
        r3.a("user_eligible", Boolean.valueOf(e.f10115a.b()));
        r3.a("accessibility_enabled", Boolean.valueOf(com.obric.memorydata.screencapture.accessibility.c.f12773a.b()));
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ void a(b r0) {
        r0.e();
    }

    private static final Unit b(AutoMemoryRuntimeMode r3, boolean r4, com.obric.memorydata.middleware.api.logging.g r5) {
        Intrinsics.checkNotNullParameter(r5, "$this$mainTrace");
        r5.a("from", ((AutoMemoryRuntimeMode) ZeusTransformUtils.preCheckCast(g.c(), AutoMemoryRuntimeMode.class, "com.obric.memorydata.plugin")).name());
        r5.a(TypedValues.TransitionType.S_TO, r3.name());
        r5.a("account_changed", Boolean.valueOf(r4));
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ void b(b r0) {
        r0.f();
    }

    public static final /* synthetic */ ae d() {
        return f;
    }

    private final synchronized void e() {
        monitor-enter(this);
        ae<Long> r0 = f;     // Catch: Throwable -> L6
        r0.b(Long.valueOf(((Number) ZeusTransformUtils.preCheckCast(r0.c(), Number.class, "com.obric.memorydata.plugin")).longValue() + 1));     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private final synchronized void f() {
        monitor-enter(this);
        final boolean r0 = e.f10115a.a();     // Catch: Throwable -> L59
        String r1 = AppContext.INSTANCE.getUserId();     // Catch: Throwable -> L59
        boolean r3 = false;
        if (Intrinsics.areEqual(r1, j) == true) goto L6;
        final boolean r2 = true;
    L7:
        j = r1;     // Catch: Throwable -> L59
        if (r0 == true) goto L10;
    L12:
        boolean r4 = false;
    L13:
        com.obric.memorydata.memory.ui.settings.l.f11479a.a().a(r4, com.obric.memorydata.screencapture.accessibility.c.f12773a.b());     // Catch: Throwable -> L59
        if (r4 == true) goto L16;
    L20:
        boolean r5 = false;
    L21:
        com.obric.memorydata.memory.inapprule.b.f10150a.a(r5);     // Catch: Throwable -> L59
        if (((Boolean) ZeusTransformUtils.preCheckCast(com.obric.memorydata.memory.ui.settings.l.f11479a.a().a().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L24;
    L29:
        final AutoMemoryRuntimeMode r6 = AutoMemoryRuntimeMode.DISABLED;     // Catch: Throwable -> L59
    L30:
        String r7 = "mode=" + r6 + " cloud=" + r0 + " inAppSupported=" + e.f10115a.c() + " rulesReady=" + ((Boolean) ZeusTransformUtils.preCheckCast(com.obric.memorydata.memory.inapprule.b.f10150a.a().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() + " master=" + ((Boolean) ZeusTransformUtils.preCheckCast(com.obric.memorydata.memory.ui.settings.l.f11479a.a().a().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() + " eligible=" + e.f10115a.b() + " accessibility=" + com.obric.memorydata.screencapture.accessibility.c.f12773a.b();     // Catch: Throwable -> L59
        if (Intrinsics.areEqual(r7, c) == true) goto L33;
        com.obric.memorydata.middleware.api.logging.o.a(f10077b, "自动记忆方案已判定", "runtime_mode_decided", null, new $$Lambda$b$y2NQnEQUKNyyRtrRu984S8H96cw(r6, r0), null, 20, null);     // Catch: Throwable -> L59
        c = r7;     // Catch: Throwable -> L59
    L33:
        ae<AutoMemoryRuntimeMode> r8 = g;     // Catch: Throwable -> L59
        if (r8.c() != r6) goto L36;
        if (r2 == true) goto L36;
    L42:
        if (r6 != AutoMemoryRuntimeMode.DISABLED) goto L46;
        monitor-exit(this);
        return;
    L46:
        if (r6 == AutoMemoryRuntimeMode.IN_APP) goto L48;
    L50:
        com.obric.memorydata.memory.d.f10110a.b();     // Catch: Throwable -> L59
        if (r8.c() != AutoMemoryRuntimeMode.IN_APP) goto L53;
        com.obric.memorydata.memory.inapprule.b.f10150a.c();     // Catch: Throwable -> L59
    L53:
        y r9 = y.f11594a;     // Catch: Throwable -> L59
        if (i == true) goto L56;
        r3 = true;
    L56:
        r9.a(r3);     // Catch: Throwable -> L59
        i = true;     // Catch: Throwable -> L59
        monitor-exit(this);
        return;
    L48:
        if (((Boolean) ZeusTransformUtils.preCheckCast(com.obric.memorydata.memory.inapprule.b.f10150a.a().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L50;
        com.obric.memorydata.memory.inapprule.b.f10150a.d();     // Catch: Throwable -> L59
    L36:
        com.obric.memorydata.middleware.api.logging.o.a(f10077b, "自动记忆方案已切换", "runtime_mode_changed", null, new $$Lambda$b$qARnStbX02cc7geoDbRUfVli60(r6, r2), null, 20, null);     // Catch: Throwable -> L59
        r8.b(AutoMemoryRuntimeMode.DISABLED);     // Catch: Throwable -> L59
        com.obric.memorydata.memory.inapprule.b r10 = com.obric.memorydata.memory.inapprule.b.f10150a;     // Catch: Throwable -> L59
        if (r5 == true) goto L39;
        boolean r11 = true;
    L40:
        r10.b(r11);     // Catch: Throwable -> L59
        com.obric.memorydata.memory.d.f10110a.b();     // Catch: Throwable -> L59
        y.f11594a.d();     // Catch: Throwable -> L59
        r8.b(r6);     // Catch: Throwable -> L59
        goto L42
    L39:
        r11 = false;
        goto L40
    L24:
        if (e.f10115a.b() == false) goto L29;
        if (r4 == false) goto L28;
        r6 = AutoMemoryRuntimeMode.IN_APP;     // Catch: Throwable -> L59
        goto L30
    L28:
        r6 = AutoMemoryRuntimeMode.ACCESSIBILITY;     // Catch: Throwable -> L59
        goto L30
    L16:
        if (((Boolean) ZeusTransformUtils.preCheckCast(com.obric.memorydata.memory.ui.settings.l.f11479a.a().a().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L20;
        if (e.f10115a.b() == false) goto L20;
        r5 = true;
        goto L21
    L10:
        if (e.f10115a.c() == false) goto L12;
        r4 = true;
        goto L13
    L6:
        r2 = false;
    L59:
        th = move-exception;
        throw th;
    }

    /* JADX INFO: renamed from: lambda$qARnStbX0-2cc7geoDbRUfVli60, reason: not valid java name */
    public static /* synthetic */ Unit m690lambda$qARnStbX02cc7geoDbRUfVli60(AutoMemoryRuntimeMode r0, boolean r1, com.obric.memorydata.middleware.api.logging.g r2) {
        return b(r0, r1, r2);
    }

    public static /* synthetic */ Unit lambda$y2NQnEQUKNyyRtrRu984S8H96cw(AutoMemoryRuntimeMode r0, boolean r1, com.obric.memorydata.middleware.api.logging.g r2) {
        return a(r0, r1, r2);
    }

    public final void a() {
        if (d.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        com.obric.memorydata.screencapture.accessibility.c.f12773a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        y.a(y.f11594a, null, false, 3, null);
        com.obric.memorydata.memory.inapprule.b.f10150a.b();
        SettingsManager.INSTANCE.registerChangeListener("obric_memd_in_app_settings", (SettingsChangeListener) ZeusTransformUtils.preCheckCast(new a(), SettingsChangeListener.class, "com.obric.memorydata.plugin"));
        SettingsManager.INSTANCE.registerChangeListener("app_auto_memory_config", (SettingsChangeListener) ZeusTransformUtils.preCheckCast(new C0493b(), SettingsChangeListener.class, "com.obric.memorydata.plugin"));
        UserSettings.INSTANCE.registerLoginStateListener((com.obric.memorydata.middleware.api.app.d) ZeusTransformUtils.preCheckCast(new c(), com.obric.memorydata.middleware.api.app.d.class, "com.obric.memorydata.plugin"));
        UserSettings.INSTANCE.registerEnterpriseAccountListener((com.obric.memorydata.middleware.api.app.b) ZeusTransformUtils.preCheckCast(new d(), com.obric.memorydata.middleware.api.app.b.class, "com.obric.memorydata.plugin"));
        kotlinx.coroutines.i.a(e, null, null, (Function2) ZeusTransformUtils.preCheckCast(new AutoMemoryRuntimeCoordinator$init$5(null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    public final boolean a(String r6) {
        Intrinsics.checkNotNullParameter(r6, ObricMemoryConstants.KEY_PACKAGE_NAME);
        if (g.c() != AutoMemoryRuntimeMode.IN_APP) goto L33;
        if (((Boolean) ZeusTransformUtils.preCheckCast(com.obric.memorydata.memory.ui.settings.l.f11479a.a().a().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L33;
        if (e.f10115a.a() == false) goto L33;
        if (e.f10115a.b() == false) goto L33;
        if (Intrinsics.areEqual(j, AppContext.INSTANCE.getUserId()) == false) goto L33;
        if (((Set) ZeusTransformUtils.preCheckCast(com.obric.memorydata.memory.ui.settings.l.f11479a.a().i().c(), Set.class, "com.obric.memorydata.plugin")).contains(r6) == false) goto L33;
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(y.f11594a.a().getSmartMemoryPackages(), Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r5, Collection.class) == true) goto L17;
    L19:
        Iterator r7 = r5.iterator();
    L21:
        if (r7.hasNext() == false) goto L18;
        AutoMemoryConfig.SmartMemoryPackage r0 = (AutoMemoryConfig.SmartMemoryPackage) ZeusTransformUtils.preCheckCast(r7.next(), AutoMemoryConfig.SmartMemoryPackage.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r0.getPackageName(), r6) == true) goto L25;
    L27:
        boolean r1 = false;
    L28:
        if (r1 == false) goto L21;
        boolean r8 = true;
    L30:
        if (r8 == false) goto L33;
        return true;
    L25:
        if (r0.getNoNeedA11y() == true) goto L27;
        r1 = true;
    L18:
        r8 = false;
        goto L30
    L17:
        if (((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L19;
    L33:
        return false;
    }

    public final boolean b() {
        if (g.c() != AutoMemoryRuntimeMode.ACCESSIBILITY) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean b(String r6) {
        Intrinsics.checkNotNullParameter(r6, ObricMemoryConstants.KEY_PACKAGE_NAME);
        if (g.c() != AutoMemoryRuntimeMode.DISABLED) goto L5;
        return false;
    L5:
        if (((Boolean) ZeusTransformUtils.preCheckCast(com.obric.memorydata.memory.ui.settings.l.f11479a.a().a().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L7;
        return false;
    L7:
        if (e.f10115a.b() == false) goto L37;
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(y.f11594a.a().getSmartMemoryPackages(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L11:
        if (r0.hasNext() == false) goto L15;
        Object r1 = r0.next();
        if (Intrinsics.areEqual(((AutoMemoryConfig.SmartMemoryPackage) ZeusTransformUtils.preCheckCast(r1, AutoMemoryConfig.SmartMemoryPackage.class, "com.obric.memorydata.plugin")).getPackageName(), r6) == false) goto L11;
    L16:
        AutoMemoryConfig.SmartMemoryPackage r2 = (AutoMemoryConfig.SmartMemoryPackage) ZeusTransformUtils.preCheckCast(r1, AutoMemoryConfig.SmartMemoryPackage.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L20;
        return false;
    L20:
        if (((Set) ZeusTransformUtils.preCheckCast(com.obric.memorydata.memory.ui.settings.l.f11479a.a().i().c(), Set.class, "com.obric.memorydata.plugin")).contains(r6) == true) goto L22;
        return false;
    L22:
        if (r2.getNoNeedA11y() == false) goto L24;
    L27:
        return true;
    L24:
        if (b() == true) goto L26;
        return false;
    L26:
        if (com.obric.memorydata.screencapture.accessibility.c.f12773a.b() == true) goto L27;
        return false;
    L15:
        r1 = null;
        goto L16
    L37:
        return false;
    }

    public final boolean c() {
        if (e.f10115a.a() == true) goto L5;
    L8:
        return true;
    L5:
        if (e.f10115a.c() == false) goto L8;
        return false;
    }
}
