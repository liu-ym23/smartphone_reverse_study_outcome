package com.obric.memorydata.middleware.impl.settings;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import android.util.Log;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.news.common.settings.SettingsConfigProvider;
import com.obric.memorydata.awareness.api.AwarenessManager;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00009\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\n\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u000f\u001a\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0005H\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/obric/memorydata/middleware/impl/settings/SettingsConfigProviderImpl;", "Lcom/bytedance/news/common/settings/SettingsConfigProvider;", "<init>", "()V", "lastNetworkAvailable", "", "lastForegroundSettingsUpdateTime", "", "hasRegisteredSettingsUpdateTrigger", "foregroundAppListener", "com/obric/memorydata/middleware/impl/settings/SettingsConfigProviderImpl$foregroundAppListener$1", "Lcom/obric/memorydata/middleware/impl/settings/SettingsConfigProviderImpl$foregroundAppListener$1;", "registerSettingsUpdateTrigger", "", "scheduleForegroundSettingsUpdate", "scheduleSettingsUpdate", "getConfig", "Lcom/bytedance/news/common/settings/SettingsConfig;", "supportSettingsStack", "getLazyConfig", "Lcom/bytedance/news/common/settings/SettingsLazyConfig;", "Companion", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SettingsConfigProviderImpl implements SettingsConfigProvider {
    private static final a Companion = null;
    private static final String DEVICE_FOREGROUND_APP = "device_foreground_app";
    private static final long FOREGROUND_SETTINGS_UPDATE_INTERVAL_MS = 600000;
    private static final String TAG = "SettingsConfigProviderImpl";
    private final b foregroundAppListener;
    private boolean hasRegisteredSettingsUpdateTrigger;
    private long lastForegroundSettingsUpdateTime;
    private boolean lastNetworkAvailable;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/obric/memorydata/middleware/impl/settings/SettingsConfigProviderImpl$Companion;", "", "<init>", "()V", "TAG", "", "DEVICE_FOREGROUND_APP", "FOREGROUND_SETTINGS_UPDATE_INTERVAL_MS", "", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007H\u0016J<\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\b2\b\u0010\f\u001a\u0004\u0018\u00010\b2\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007H\u0016¨\u0006\r"}, d2 = {"com/obric/memorydata/middleware/impl/settings/SettingsConfigProviderImpl$foregroundAppListener$1", "Lcom/obric/memorydata/awareness/api/EventListener;", "onEvent", "", "eventName", "", WsConstants.KEY_EXTRA, "", "", "onFeatureChanged", "feature", "oldValue", "newValue", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements com.obric.memorydata.awareness.api.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ SettingsConfigProviderImpl f11850a;

        b(SettingsConfigProviderImpl r1) {
            this.f11850a = r1;
        }

        @Override // com.obric.memorydata.awareness.api.a
        public void a(String r2, Object r3, Object r4, Map<String, ? extends Object> r5) {
            Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r2, "feature");
            if (Intrinsics.areEqual(r2, SettingsConfigProviderImpl.DEVICE_FOREGROUND_APP) == true) goto L5;
            return;
        L5:
            if (Intrinsics.areEqual(r4, AppContext.INSTANCE.getPackageName()) == false) goto L9;
            SettingsConfigProviderImpl.access$scheduleForegroundSettingsUpdate(this.f11850a);
            return;
        }

        @Override // com.obric.memorydata.awareness.api.a
        public void a(String r2, Map<String, ? extends Object> r3) {
            Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r2, "eventName");
        }

        @Override // com.obric.memorydata.awareness.api.a
        public boolean a() {
            return com.obric.memorydata.awareness.api.a.C0430a.a(this);
        }

        @Override // com.obric.memorydata.awareness.api.a
        public void b(String r3, Object r4, Object r5, Map<String, ? extends Object> r6) {
            com.obric.memorydata.awareness.api.a.C0430a.a(this, r3, r4, r5, (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/obric/memorydata/middleware/impl/settings/SettingsConfigProviderImpl$registerSettingsUpdateTrigger$1", "Landroid/net/ConnectivityManager$NetworkCallback;", "onCapabilitiesChanged", "", "network", "Landroid/net/Network;", "networkCapabilities", "Landroid/net/NetworkCapabilities;", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c extends ConnectivityManager.NetworkCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ SettingsConfigProviderImpl f11851a;

        c(SettingsConfigProviderImpl r1) {
            this.f11851a = r1;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network r7, NetworkCapabilities r8) {
            Intrinsics.checkNotNullParameter(r7, "network");
            Intrinsics.checkNotNullParameter(r8, "networkCapabilities");
            if (r8.hasCapability(12) == true) goto L5;
        L7:
            boolean r9 = false;
        L9:
            if (r9 != SettingsConfigProviderImpl.access$getLastNetworkAvailable$p(this.f11851a)) goto L11;
            return;
        L11:
            SettingsConfigProviderImpl.access$setLastNetworkAvailable$p(this.f11851a, r9);
            if (r9 == false) goto L15;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), SettingsConfigProviderImpl.TAG, "onCapabilitiesChanged: network available", false, 4, null);
            SettingsConfigProviderImpl.access$scheduleSettingsUpdate(this.f11851a);
            return;
        L15:
            return;
        L5:
            if (r8.hasCapability(16) == false) goto L7;
            r9 = true;
            goto L9
        }
    }

    static {
        Companion = new a(null);
    }

    public SettingsConfigProviderImpl() {
        this.foregroundAppListener = new b(this);
    }

    public static final /* synthetic */ boolean access$getLastNetworkAvailable$p(SettingsConfigProviderImpl r0) {
        return r0.lastNetworkAvailable;
    }

    public static final /* synthetic */ void access$scheduleForegroundSettingsUpdate(SettingsConfigProviderImpl r0) {
        r0.scheduleForegroundSettingsUpdate();
    }

    public static final /* synthetic */ void access$scheduleSettingsUpdate(SettingsConfigProviderImpl r0) {
        r0.scheduleSettingsUpdate();
    }

    public static final /* synthetic */ void access$setLastNetworkAvailable$p(SettingsConfigProviderImpl r0, boolean r1) {
        r0.lastNetworkAvailable = r1;
    }

    private final void registerSettingsUpdateTrigger() {
        if (this.hasRegisteredSettingsUpdateTrigger == false) goto L5;
        return;
    L5:
        this.hasRegisteredSettingsUpdateTrigger = true;
        AwarenessManager.INSTANCE.registerAwarenessEvent(DEVICE_FOREGROUND_APP, (com.obric.memorydata.awareness.api.a) ZeusTransformUtils.preCheckCast(this.foregroundAppListener, com.obric.memorydata.awareness.api.a.class, "com.obric.memorydata.plugin"));
        Object r0 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService("connectivity");
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.net.ConnectivityManager");
        ((ConnectivityManager) ZeusTransformUtils.preCheckCast(r0, ConnectivityManager.class, "com.obric.memorydata.plugin")).registerNetworkCallback(new NetworkRequest.Builder().addCapability(12).build(), (ConnectivityManager.NetworkCallback) ZeusTransformUtils.preCheckCast(new c(this), ConnectivityManager.NetworkCallback.class, "com.obric.memorydata.plugin"));
    }

    private final void scheduleForegroundSettingsUpdate() {
        long r0 = System.currentTimeMillis();
        if ((r0 - this.lastForegroundSettingsUpdateTime) >= 600000) goto L5;
        return;
    L5:
        this.lastForegroundSettingsUpdateTime = r0;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "scheduleForegroundSettingsUpdate", false, 4, null);
        scheduleSettingsUpdate();
    }

    private final void scheduleSettingsUpdate() {
        if (UserSettings.INSTANCE.hasAgreePrivacy() == true) goto L6;
        return;
    L6:
        if (AppSettingsManager.INSTANCE.hasInited() == false) goto L12;
        com.bytedance.news.common.settings.e.a(true);
        return;
    L12:
        return;
    }

    private final boolean supportSettingsStack() {
        return false;
    }

    @Override // com.bytedance.news.common.settings.SettingsConfigProvider
    public com.bytedance.news.common.settings.b getConfig() {
        registerSettingsUpdateTrigger();
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Log.d(TAG, "getConfig context = " + r0);
        com.bytedance.news.common.settings.b r4 = new com.bytedance.news.common.settings.b.a().a(r0).a((com.bytedance.news.common.settings.api.b) ZeusTransformUtils.preCheckCast(new k(), com.bytedance.news.common.settings.api.b.class, "com.obric.memorydata.plugin")).c(supportSettingsStack()).a(true).b(false).a();
        Intrinsics.checkNotNullExpressionValue(r4, "build(...)");
        return r4;
    }

    @Override // com.bytedance.news.common.settings.SettingsConfigProvider
    public com.bytedance.news.common.settings.d getLazyConfig() {
        com.bytedance.news.common.settings.d r1 = new com.bytedance.news.common.settings.d.a().a(String.valueOf(AppContext.INSTANCE.getVersionCode())).a();
        Intrinsics.checkNotNullExpressionValue(r1, "build(...)");
        return r1;
    }
}
