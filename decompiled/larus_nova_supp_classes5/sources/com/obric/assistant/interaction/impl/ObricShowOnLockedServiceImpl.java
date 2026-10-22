package com.obric.assistant.interaction.impl;

import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.core.content.ContextCompat;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.larus.common.apphost.AppHost;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.obric.ObricRealtimeCallServiceDelegate;
import com.obric.assistant.DoraAuthTrustType;
import com.obric.assistant.IDoraAuthTrustService;
import com.obric.assistant.SessionAuthenticationServiceDelegate;
import com.obric.assistant.interaction.api.IKeyguardStateKt;
import com.obric.assistant.interaction.api.service.CheckActivityAuthenticationCallback;
import com.obric.assistant.interaction.api.service.IObricShowOnLockedService;
import com.obric.assistant.settings.LockedUseAuthSettingItem;
import com.obric.assistant.t1;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u0000 72\u00020\u0001:\u00017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\rH\u0016J\u0010\u0010\u001e\u001a\u00020\b2\u0006\u0010 \u001a\u00020\nH\u0016J,\u0010!\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\b2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\b0\tH\u0016J\u0010\u0010%\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u0006H\u0016J\u0010\u0010&\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\rH\u0016J\u0010\u0010'\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\rH\u0016J\u0018\u0010(\u001a\u00020\u001d2\u0006\u0010)\u001a\u00020\n2\u0006\u0010*\u001a\u00020+H\u0016J\b\u0010,\u001a\u00020\u001dH\u0002J\u0018\u0010\u001e\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\nH\u0002J\f\u0010-\u001a\u00020\b*\u00020\rH\u0002J\u0010\u0010.\u001a\u00020\b2\u0006\u0010)\u001a\u00020\nH\u0002J\u0018\u0010/\u001a\u00020\b2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\bH\u0002J\u0018\u00103\u001a\u0002042\u000e\u00105\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001aH\u0002J\f\u00103\u001a\u000204*\u00020\u001bH\u0002J\u0016\u00106\u001a\u00020\b2\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0002R2\u0010\u0004\u001a&\u0012\u0004\u0012\u00020\u0006\u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00020\b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\b0\t0\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001a0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Lcom/obric/assistant/interaction/impl/ObricShowOnLockedServiceImpl;", "Lcom/obric/assistant/interaction/api/service/IObricShowOnLockedService;", "<init>", "()V", "allowShowOnLockedActivities", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lkotlin/Pair;", "", "Lkotlin/Function1;", "Landroid/content/Intent;", "lockShowActivities", "Ljava/util/WeakHashMap;", "Landroid/app/Activity;", "", "mUiHandler", "Landroid/os/Handler;", "isInited", "Ljava/util/concurrent/atomic/AtomicBoolean;", "delayCancelShowOnLock", "Ljava/lang/Runnable;", "mainScope", "Lkotlinx/coroutines/CoroutineScope;", "workScope", "activityNameToSceneMap", "", "", "Lcom/obric/assistant/settings/LockedUseAuthSettingItem;", "init", "", "isAllowShowOnLocked", "activity", "intent", "addShowOnLockedClazz", "clazzName", "appMustInForeground", "checkIntent", "removeShowOnLockedClazz", "setShowOnLocked", "cancelShowOnLock", "checkActivityAuthenticationOnLockAsync", "activityIntent", "callback", "Lcom/obric/assistant/interaction/api/service/CheckActivityAuthenticationCallback;", "cancelAllShowOnLock", "isAlive", "computeCheckActivityAuthenticationOnLock", "shouldAllowByDoraDowngrade", "originAuthType", "Lcom/obric/assistant/DoraAuthTrustType;", "voicePassed", "getAuthenticationTypeOnLockScreen", "", "switchTypes", "canShowRealtimeCallOnLock", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricShowOnLockedServiceImpl implements IObricShowOnLockedService {
    public static final Companion Companion = null;
    private static final long MIN_KEEP_SHOW_ON_LOCK_TIME = 1500;
    private static final String TAG = "ObricShowOnLockedServiceImpl";
    private final Map<String, List<LockedUseAuthSettingItem>> activityNameToSceneMap;
    private final ConcurrentHashMap<String, Pair<Boolean, Function1<Intent, Boolean>>> allowShowOnLockedActivities;
    private final Runnable delayCancelShowOnLock;
    private final AtomicBoolean isInited;
    private final WeakHashMap<Activity, Long> lockShowActivities;
    private final Handler mUiHandler;
    private final CoroutineScope mainScope;
    private final CoroutineScope workScope;

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ void a(ObricShowOnLockedServiceImpl r0) {
        delayCancelShowOnLock$lambda$0(r0);
    }

    private final void cancelAllShowOnLock() {
        Iterator r0 = CollectionsKt.toList(this.lockShowActivities.keySet()).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Activity r1 = (Activity) r0.next();
        Intrinsics.checkNotNull(r1);
        cancelShowOnLock(r1);
        goto L4
    }

    public void init() {
        if (this.isInited.compareAndSet(false, true) == true) goto L6;
        FLogger.a.i(TAG, "init: already inited");
        return;
    L6:
        FLogger.a.i(TAG, "init");
        AppHost.Companion r0 = AppHost.a;
        r0.getApplication().registerActivityLifecycleCallbacks(new init.1(this));
        r0.a().j(new AnonymousClass2(this));
        Application r1 = r0.getApplication();
        init.3 r2 = new init.3(this);
        IntentFilter r3 = new IntentFilter();
        r3.addAction("android.intent.action.SCREEN_OFF");
        Unit r4 = Unit.INSTANCE;
        INVOKEVIRTUAL_com_obric_assistant_interaction_impl_ObricShowOnLockedServiceImpl_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(r1, r2, r3);
    }

    public ObricShowOnLockedServiceImpl() {
        this.allowShowOnLockedActivities = new ConcurrentHashMap();
        this.lockShowActivities = new WeakHashMap();
        this.mUiHandler = new Handler(Looper.getMainLooper());
        this.isInited = new AtomicBoolean(false);
        this.delayCancelShowOnLock = new f0(this);
        this.mainScope = CoroutineScopeKt.MainScope();
        this.workScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        this.activityNameToSceneMap = MapsKt.mapOf(TuplesKt.to(ObricRealtimeCallServiceDelegate.b.u(), CollectionsKt.listOf(new LockedUseAuthSettingItem[]{LockedUseAuthSettingItem.LOCAL_APP_DATA, LockedUseAuthSettingItem.CHAT_HISTORY})));
    }

    public static final /* synthetic */ void access$cancelAllShowOnLock(ObricShowOnLockedServiceImpl r0) {
        r0.cancelAllShowOnLock();
    }

    public static final /* synthetic */ Runnable access$getDelayCancelShowOnLock$p(ObricShowOnLockedServiceImpl r0) {
        return r0.delayCancelShowOnLock;
    }

    public static final /* synthetic */ WeakHashMap access$getLockShowActivities$p(ObricShowOnLockedServiceImpl r0) {
        return r0.lockShowActivities;
    }

    public static final /* synthetic */ Handler access$getMUiHandler$p(ObricShowOnLockedServiceImpl r0) {
        return r0.mUiHandler;
    }

    public static final /* synthetic */ CoroutineScope access$getMainScope$p(ObricShowOnLockedServiceImpl r0) {
        return r0.mainScope;
    }

    private final boolean canShowRealtimeCallOnLock(List<? extends LockedUseAuthSettingItem> r5) {
        if (t1.a.i() == false) goto L26;
        List<? extends LockedUseAuthSettingItem> r6 = r5;
        if ((r6 instanceof Collection) == true) goto L7;
    L9:
        Iterator<T> r7 = r6.iterator();
    L11:
        if (r7.hasNext() == false) goto L8;
        if (getAuthenticationTypeOnLockScreen((LockedUseAuthSettingItem) r7.next()) != 2) goto L15;
        boolean r0 = true;
    L16:
        if (r0 == true) goto L11;
        boolean r8 = false;
    L18:
        if (r8 == false) goto L27;
        return true;
    L27:
        return false;
    L15:
        r0 = false;
    L8:
        r8 = true;
        goto L18
    L7:
        if (r6.isEmpty() == false) goto L9;
    L26:
        return false;
    }

    private final boolean computeCheckActivityAuthenticationOnLock(Intent r12) {
        FLogger r0 = FLogger.a;
        r0.i(TAG, "checkActivityAuthenticationOnLock: start");
        Map<String, List<LockedUseAuthSettingItem>> r1 = this.activityNameToSceneMap;
        ComponentName r3 = r12.getComponent();
        String r4 = null;
        if (r3 == null) goto L5;
        String r5 = r3.getClassName();
    L6:
        if (r5 != null) goto L8;
        r5 = "";
    L8:
        List<LockedUseAuthSettingItem> r2 = r1.get(r5);
        int r6 = getAuthenticationTypeOnLockScreen(r2);
        boolean r7 = IKeyguardStateKt.getKeyguardState().isDeviceLocked();
        if (r7 == true) goto L11;
        return true;
    L11:
        SessionAuthenticationServiceDelegate r8 = SessionAuthenticationServiceDelegate.b;
        boolean r9 = ((Boolean) r8.k().getValue()).booleanValue();
        boolean r10 = ((Boolean) r8.o().getValue()).booleanValue();
        StringBuilder r11 = new StringBuilder("checkActivityAuthenticationOnLock: switchTypes=");
        r11.append(r2);
        r11.append(" authType=");
        r11.append(r6);
        r11.append(" locked=");
        r11.append(r7);
        r11.append(" voicePassed=");
        r11.append(r9);
        r11.append(" bioPassed=");
        r11.append(r10);
        r11.append(" className=");
        ComponentName r13 = r12.getComponent();
        if (r13 == null) goto L14;
        r4 = r13.getClassName();
    L14:
        r11.append(r4);
        r11.append(" intent=");
        r11.append(r12);
        r0.i(TAG, r11.toString());
        if (r6 != 0) goto L17;
        if (r10 == false) goto L26;
        return true;
    L26:
        return shouldAllowByDoraDowngrade(DoraAuthTrustType.SYSTEM_AUTHENTICATION, r9);
    L17:
        if (r6 == 2) goto L22;
        if (r10 == false) goto L21;
        return true;
    L21:
        return shouldAllowByDoraDowngrade(DoraAuthTrustType.SYSTEM_AUTHENTICATION, r9);
    L22:
        return true;
    L5:
        r5 = null;
        goto L6
    }

    private static final void delayCancelShowOnLock$lambda$0(ObricShowOnLockedServiceImpl r3) {
        FLogger.a.i(TAG, "cancelShowOnLock after delay");
        r3.cancelAllShowOnLock();
    }

    private final int getAuthenticationTypeOnLockScreen(LockedUseAuthSettingItem r2) {
        switch(WhenMappings.$EnumSwitchMapping$0[r2.ordinal()]) {
            case 1: goto L12;
            case 2: goto L17;
            case 3: goto L16;
            case 4: goto L15;
            case 5: goto L14;
            case 6: goto L13;
            default: goto L5;
        };
    L5:
        throw new NoWhenBranchMatchedException();
    L13:
        return t1.a.Q1();
    L14:
        return t1.a.e1();
    L15:
        return t1.a.v0();
    L16:
        return t1.a.v0();
    L17:
        return t1.a.W();
    L12:
        return t1.a.k1();
    }

    private final boolean isAlive(Activity r2) {
        if (r2.isFinishing() == false) goto L5;
    L7:
        return false;
    L5:
        if (r2.isDestroyed() == true) goto L7;
        return true;
    }

    public synchronized void cancelShowOnLock(Activity r5) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r5, "activity");     // Catch: Throwable -> L13
        if (this.lockShowActivities.remove(r5) != null) goto L7;
    L11:
        monitor-exit(this);
        return;
    L7:
        if (isAlive(r5) == false) goto L11;
        if (Build.VERSION.SDK_INT < 27) goto L11;
        FLogger.a.i(TAG, "cancelShowOnLock " + r5);     // Catch: Throwable -> L13
        r5.setShowWhenLocked(false);     // Catch: Throwable -> L13
        r5.setTurnScreenOn(false);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    public synchronized boolean isAllowShowOnLocked(Intent r2) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r2, "intent");     // Catch: Throwable -> L12
        ComponentName r0 = r2.getComponent();     // Catch: Throwable -> L12
        if (r0 == null) goto L6;
        String r1 = r0.getClassName();     // Catch: Throwable -> L12
    L7:
        if (r1 != null) goto L9;
        r1 = "";
    L9:
        boolean r3 = isAllowShowOnLocked(r1, r2);     // Catch: Throwable -> L12
        monitor-exit(this);
        return r3;
    L6:
        r1 = null;
    L12:
        th = move-exception;
        throw th;
    }

    public synchronized void removeShowOnLockedClazz(String r5) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r5, "clazzName");     // Catch: Throwable -> L7
        FLogger.a.i(TAG, "removeShowOnLockedClazz: clazzName = " + r5);     // Catch: Throwable -> L7
        this.allowShowOnLockedActivities.remove(r5);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized void setShowOnLocked(Activity r5) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r5, "activity");     // Catch: Throwable -> L24
        if (IKeyguardStateKt.getKeyguardState().isKeyguardLocked() == true) goto L10;
        FLogger.a.i(TAG, "setShowWhenLocked: keyguard not locked");     // Catch: Throwable -> L24
        monitor-exit(this);
        return;
    L10:
        if (AccountService.a.isLogin().booleanValue() == true) goto L15;
        FLogger.a.w(TAG, "setShowWhenLocked: not login");     // Catch: Throwable -> L24
        monitor-exit(this);
        return;
    L15:
        if (isAlive(r5) == true) goto L20;
        FLogger.a.i(TAG, "setShowWhenLocked: activity not alive");     // Catch: Throwable -> L24
        monitor-exit(this);
        return;
    L20:
        if (Build.VERSION.SDK_INT < 27) goto L22;
        FLogger.a.i(TAG, "setShowWhenLocked " + r5);     // Catch: Throwable -> L24
        r5.setShowWhenLocked(true);     // Catch: Throwable -> L24
        r5.setTurnScreenOn(true);     // Catch: Throwable -> L24
        this.lockShowActivities.put(r5, Long.valueOf(SystemClock.elapsedRealtime()));     // Catch: Throwable -> L24
    L22:
        monitor-exit(this);
        return;
    L24:
        th = move-exception;
        throw th;
    }

    private final int getAuthenticationTypeOnLockScreen(List<? extends LockedUseAuthSettingItem> r4) {
        if (r4 != null) goto L5;
        r4 = CollectionsKt.emptyList();
    L5:
        if (r4.isEmpty() == false) goto L8;
        return 0;
    L8:
        if (r4.size() != 1) goto L12;
        return getAuthenticationTypeOnLockScreen((LockedUseAuthSettingItem) CollectionsKt.first(r4));
    L12:
        if (canShowRealtimeCallOnLock(r4) == false) goto L15;
        return 2;
    L15:
        return 0;
    }

    public synchronized boolean isAllowShowOnLocked(Activity r2) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r2, "activity");     // Catch: Throwable -> L6
        boolean r3 = isAllowShowOnLocked(r2.getClass().getName(), r2.getIntent());     // Catch: Throwable -> L6
        monitor-exit(this);
        return r3;
    L6:
        th = move-exception;
        throw th;
    }

    public static final /* synthetic */ boolean access$computeCheckActivityAuthenticationOnLock(ObricShowOnLockedServiceImpl r0, Intent r1) {
        return r0.computeCheckActivityAuthenticationOnLock(r1);
    }

    private final boolean isAllowShowOnLocked(String r3, Intent r4) {
        Pair<Boolean, Function1<Intent, Boolean>> r5 = this.allowShowOnLockedActivities.get(r3);
        if (r5 != null) goto L5;
        return false;
    L5:
        boolean r1 = ((Boolean) r5.component1()).booleanValue();
        Function1 r6 = (Function1) r5.component2();
        if (r1 == false) goto L13;
        if (AppHost.a.a().isAppBackground() == false) goto L10;
        return false;
    L10:
        if (((Boolean) r6.invoke(r4)).booleanValue() == false) goto L15;
        return true;
    L15:
        return false;
    L13:
        return ((Boolean) r6.invoke(r4)).booleanValue();
    }

    private final boolean shouldAllowByDoraDowngrade(DoraAuthTrustType r7, boolean r8) {
        IDoraAuthTrustService r0 = (IDoraAuthTrustService) ServiceManager.get().getService(IDoraAuthTrustService.class);
        if (r0 != null) goto L6;
        FLogger.a.i(TAG, "checkActivityAuthenticationOnLock: doraService is null, skip downgrade");
        return false;
    L6:
        AtomicBoolean r3 = new AtomicBoolean(false);
        CountDownLatch r4 = new CountDownLatch(1);
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L9
        r0.b(r7, new shouldAllowByDoraDowngrade.1.1(r3, r4, r8));     // Catch: Throwable -> L9
        Object r9 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L9
    L11:
        Throwable r10 = Result.exceptionOrNull-impl(r9);
        if (r10 == null) goto L20;
        FLogger.a.w(TAG, "checkActivityAuthenticationOnLock: shouldDowngradeAuthForDora failed " + r10.getMessage(), r10);
        r3.set(false);
        r4.countDown();
    L20:
        Result.constructor-impl(Boolean.valueOf(r4.await(3, TimeUnit.SECONDS)));     // Catch: Throwable -> L16
    L19:
        return r3.get();
    L16:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L9:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }

    public void checkActivityAuthenticationOnLockAsync(Intent r8, CheckActivityAuthenticationCallback r9) {
        Intrinsics.checkNotNullParameter(r8, "activityIntent");
        Intrinsics.checkNotNullParameter(r9, "callback");
        BuildersKt.launch$default(this.workScope, null, null, new checkActivityAuthenticationOnLockAsync.1(this, r8, r9, null), 3, null);
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static Intent INVOKEVIRTUAL_com_obric_assistant_interaction_impl_ObricShowOnLockedServiceImpl_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Application r8, BroadcastReceiver r9, IntentFilter r10) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L42;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L42:
    L36:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L40;
        throw e;
    L40:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r9, r10);
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L25;
        if (r10 == null) goto L25;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r10) == false) goto L25;
        ReceiverRegisterAnrOptimizer.ResultWrapper r0 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r9, r10, 0, null, null, 2, r8);     // Catch: Exception -> L36
        int r1 = r0.result;     // Catch: Exception -> L36
        if (r1 == 1) goto L23;
        if (r1 == 2) goto L21;
        if (r1 == 3) goto L19;
        return r8.registerReceiver(r9, r10);
    L19:
        return r0.intent;
    L21:
        return new Intent();
    L23:
        return r8.registerReceiver(r9, r10);
    L25:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L29;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L36
        return r8.registerReceiver(r9, r10, null, ReceiverRegisterLancet.sReceiverHandler);
    L29:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() == null) goto L35;
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r10) == false) goto L35;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L36
        return ContextCompat.registerReceiver(r8, r9, r10, null, ReceiverRegisterLancet.sProxyHandler, 2);
    L35:
        return r8.registerReceiver(r9, r10);
    }

    public synchronized void addShowOnLockedClazz(String r5, boolean r6, Function1<? super Intent, Boolean> r7) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r5, "clazzName");     // Catch: Throwable -> L7
        Intrinsics.checkNotNullParameter(r7, "checkIntent");     // Catch: Throwable -> L7
        FLogger.a.i(TAG, "addShowOnLockedClazz: clazzName = " + r5 + ", appMustInForeground = " + r6);     // Catch: Throwable -> L7
        this.allowShowOnLockedActivities.put(r5, new Pair(Boolean.valueOf(r6), r7));     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
