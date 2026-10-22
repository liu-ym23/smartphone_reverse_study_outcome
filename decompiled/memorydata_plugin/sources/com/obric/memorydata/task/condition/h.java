package com.obric.memorydata.task.condition;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.PowerManager;
import com.bytedance.common.utility.NetworkUtils;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.settings.BackgroundNetworkMode;
import com.obric.memorydata.middleware.api.settings.BackgroundOsResourceOptimizeSettings;
import com.obric.memorydata.middleware.api.settings.SettingsChangeListener;
import com.obric.memorydata.middleware.api.settings.SettingsManager;
import com.obric.memorydata.utils.GsonUtil;
import com.obric.memorydata.utils.af;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b*\u0002\u000e\u0011\u0018\u0000  2\u00020\u00012\u00020\u0002:\u0001 B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0013\u001a\u00020\fH\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0006H\u0016J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0019H\u0007J\b\u0010\u001a\u001a\u00020\u0006H\u0002J\u0010\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\fH\u0016J\b\u0010\u001d\u001a\u00020\u0015H\u0002J\b\u0010\u001e\u001a\u00020\u0006H\u0002J\b\u0010\u001f\u001a\u00020\u0015H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u0010\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012¨\u0006!"}, d2 = {"Lcom/obric/memorydata/task/condition/NetWindowCondition;", "Lcom/obric/memorydata/task/condition/BaseCondition;", "Lcom/obric/memorydata/middleware/api/settings/SettingsChangeListener;", "<init>", "()V", "networkAvailable", "", "windowOpen", "screenOn", "backgroundNetworkMode", "", "foregroundPackageName", "", "appSwitchListener", "com/obric/memorydata/task/condition/NetWindowCondition$appSwitchListener$1", "Lcom/obric/memorydata/task/condition/NetWindowCondition$appSwitchListener$1;", "receiver", "com/obric/memorydata/task/condition/NetWindowCondition$receiver$1", "Lcom/obric/memorydata/task/condition/NetWindowCondition$receiver$1;", "getUnsatisfiedReason", "register", "", "isSatisfied", "isCharging", "context", "Landroid/content/Context;", "isNetworkAllowed", "onSettingsChanged", "key", "refreshBackgroundNetworkMode", "isMemoryAppForeground", "updateNetworkWindowStatus", "Companion", "task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class h extends com.obric.memorydata.task.condition.b implements SettingsChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12885a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f12886b;
    private boolean c;
    private boolean d;
    private int e;
    private String f;
    private final b g;
    private final c h;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/memorydata/task/condition/NetWindowCondition$Companion;", "", "<init>", "()V", "TAG", "", "ACTION_NET_WINDOW_ALLOW", "task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\b"}, d2 = {"com/obric/memorydata/task/condition/NetWindowCondition$appSwitchListener$1", "Lcom/obric/memorydata/utils/MemoryAppStateListener$AppSwitchListener;", "onAppOpen", "", "appName", "", ObricMemoryConstants.KEY_PACKAGE_NAME, "onAppClose", "task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements af.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ h f12887a;

        b(h r1) {
            this.f12887a = r1;
        }

        @Override // com.obric.memorydata.utils.af.a
        public void a(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "appName");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            if (Intrinsics.areEqual(h.a(this.f12887a), r3) == false) goto L5;
            return;
        L5:
            h.a(this.f12887a, r3);
            h.b(this.f12887a);
        }

        @Override // com.obric.memorydata.utils.af.a
        public void b(String r1, String r2) {
            Intrinsics.checkNotNullParameter(r1, "appName");
            Intrinsics.checkNotNullParameter(r2, ObricMemoryConstants.KEY_PACKAGE_NAME);
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/obric/memorydata/task/condition/NetWindowCondition$receiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c extends PluginBroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ h f12888a;

        c(h r1) {
            this.f12888a = r1;
        }

        public void onReceive(Context r7, Intent r8) {
            Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
            if (r8 == null) goto L32;
            String r0 = r8.getAction();
            if (r0 == null) goto L33;
            boolean r3 = true;
            switch(r0.hashCode()) {
                case -2128145023: goto L27;
                case -1454123155: goto L23;
                case -1379558268: goto L19;
                case -1172645946: goto L11;
                default: goto L30;
            };
        L30:
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "NetWindowCondition", "network window status: " + h.c(this.f12888a) + ", screenOn: " + h.d(this.f12888a) + ", networkAvailable: " + h.e(this.f12888a), false, 4, null);
            h.b(this.f12888a);
            return;
        L11:
            if (r0.equals("android.net.conn.CONNECTIVITY_CHANGE") == false) goto L30;
            h r10 = this.f12888a;
            if (UserSettings.INSTANCE.hasAgreePrivacy() == false) goto L17;
            r3 = NetworkUtils.b(r9);
        L17:
            h.c(r10, r3);
            goto L30
        L19:
            if (r0.equals("com.android.server.power.NET_WINDOW_ALLOW") == false) goto L30;
            h.a(this.f12888a, r8.getBooleanExtra("allow", false));
            RunLog.INSTANCE.debug("NetWindowCondition", "windowOpen status: " + h.c(this.f12888a));
            goto L30
        L23:
            if (r0.equals("android.intent.action.SCREEN_ON") == false) goto L30;
            h.b(this.f12888a, true);
            goto L30
        L27:
            if (r0.equals("android.intent.action.SCREEN_OFF") == false) goto L30;
            h.b(this.f12888a, false);
            goto L30
        L33:
            return;
        }
    }

    static {
        f12885a = new a(null);
    }

    public h() {
        this.c = true;
        this.e = 1;
        this.f = "";
        this.g = new b(this);
        this.h = new c(this);
    }

    public static final /* synthetic */ String a(h r0) {
        return r0.f;
    }

    public static final /* synthetic */ void a(h r0, String r1) {
        r0.f = r1;
    }

    public static final /* synthetic */ void a(h r0, boolean r1) {
        r0.c = r1;
    }

    private final boolean a() {
        if (UserSettings.INSTANCE.hasAgreePrivacy() == true) goto L6;
        return true;
    L6:
        if (this.f12886b == true) goto L9;
        return false;
    L9:
        if (this.d == true) goto L12;
        return false;
    L12:
        if (this.e != 2) goto L18;
        if (e() == true) goto L18;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "NetWindowCondition", "network window not allowed by strict background network policy", false, 4, null);
        return false;
    L18:
        if (a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) == false) goto L21;
        return true;
    L21:
        if (this.e != 2) goto L24;
        return true;
    L24:
        return this.c;
    }

    public static final /* synthetic */ void b(h r0) {
        r0.f();
    }

    public static final /* synthetic */ void b(h r0, boolean r1) {
        r0.d = r1;
    }

    public static final /* synthetic */ void c(h r0, boolean r1) {
        r0.f12886b = r1;
    }

    public static final /* synthetic */ boolean c(h r0) {
        return r0.c;
    }

    private final void d() {
        SettingsManager r0 = SettingsManager.INSTANCE;
        Object r7 = new BackgroundOsResourceOptimizeSettings(false, null, null, 7, null);
        String r1 = r0.getSettingsStr(SettingsManager.KEY_BACKGROUND_OS_RESOURCE_OPTIMIZE);
        Object r2 = null;
        if (r1 != null) goto L18;
    L9:
        if (r2 == null) goto L12;
        r7 = r2;
    L12:
        BackgroundOsResourceOptimizeSettings r3 = (BackgroundOsResourceOptimizeSettings) ZeusTransformUtils.preCheckCast(r7, BackgroundOsResourceOptimizeSettings.class, "com.obric.memorydata.plugin");
        if (r3.getEnable() == false) goto L15;
        int r4 = BackgroundNetworkMode.INSTANCE.normalize(r3.getBackgroundNetworkModeConfig().getMode());
    L16:
        this.e = r4;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "NetWindowCondition", "backgroundNetworkMode: " + this.e, false, 4, null);
        return;
    L15:
        r4 = 0;
        goto L16
    L18:
        r2 = r0.getGSON().fromJson(r1, BackgroundOsResourceOptimizeSettings.class);     // Catch: Exception -> L7
    L7:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), GsonUtil.TAG, "json error ：" + e, null, 4, null);
        goto L9
    }

    public static final /* synthetic */ boolean d(h r0) {
        return r0.d;
    }

    private final boolean e() {
        return Intrinsics.areEqual(this.f, AppContext.INSTANCE.getPackageName());
    }

    public static final /* synthetic */ boolean e(h r0) {
        return r0.f12886b;
    }

    private final void f() {
        boolean r0 = a();
        if (r0 == i()) goto L8;
        b(r0);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "NetWindowCondition", "network window allow status => " + i(), false, 4, null);
        d r8 = h();
        if (r8 == null) goto L9;
        r8.onConditionChange(Condition.NETWORK_WINDOW, r0);
        return;
    L9:
        return;
    }

    public final boolean a(Context r4) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        Object r5 = r3.getSystemService("batterymanager");     // Catch: Exception -> L5
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type android.os.BatteryManager");     // Catch: Exception -> L5
        return ((BatteryManager) ZeusTransformUtils.preCheckCast(r5, BatteryManager.class, "com.obric.memorydata.plugin")).isCharging();
    L5:
        e = move-exception;
        RunLog.INSTANCE.error("NetWindowCondition", "isCharging error: " + e.getMessage(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return false;
    }

    @Override // com.obric.memorydata.task.condition.b
    public void b() {
        Object r0 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService("power");
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.os.PowerManager");
        this.d = ((PowerManager) ZeusTransformUtils.preCheckCast(r0, PowerManager.class, "com.obric.memorydata.plugin")).isInteractive();
        if (UserSettings.INSTANCE.hasAgreePrivacy() == false) goto L5;
        boolean r1 = NetworkUtils.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
    L6:
        this.f12886b = r1;
        this.f = af.f13160a.b();
        d();
        b(a());
        af.f13160a.a((af.a) ZeusTransformUtils.preCheckCast(this.g, af.a.class, "com.obric.memorydata.plugin"));
        SettingsManager.INSTANCE.registerChangeListener(SettingsManager.KEY_BACKGROUND_OS_RESOURCE_OPTIMIZE, (SettingsChangeListener) ZeusTransformUtils.preCheckCast(this, SettingsChangeListener.class, "com.obric.memorydata.plugin"));
        IntentFilter r2 = new IntentFilter();
        r2.addAction("com.android.server.power.NET_WINDOW_ALLOW");
        r2.addAction("android.intent.action.SCREEN_ON");
        r2.addAction("android.intent.action.SCREEN_OFF");
        r2.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        ZeusTransformUtils.registerReceiver((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), (PluginBroadcastReceiver) ZeusTransformUtils.preCheckCast(this.h, PluginBroadcastReceiver.class, "com.obric.memorydata.plugin"), r2, 2, "com.obric.memorydata.plugin");
        return;
    L5:
        r1 = true;
        goto L6
    }

    @Override // com.obric.memorydata.task.condition.b
    public boolean c() {
        return a();
    }

    @Override // com.obric.memorydata.task.condition.b
    public String g() {
        if (c() == false) goto L7;
        return "";
    L7:
        return "NetWindowCondition(isInWindow=" + i() + ')';
    }

    @Override // com.obric.memorydata.middleware.api.settings.SettingsChangeListener
    public void onSettingsChanged(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        if (Intrinsics.areEqual(r2, SettingsManager.KEY_BACKGROUND_OS_RESOURCE_OPTIMIZE) == false) goto L6;
        d();
        f();
        return;
    }
}
