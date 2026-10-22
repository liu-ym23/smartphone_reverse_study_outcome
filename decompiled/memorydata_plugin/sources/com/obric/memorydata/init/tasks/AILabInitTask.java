package com.obric.memorydata.init.tasks;

import android.content.ComponentName;
import android.content.Context;
import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.bytedance.lego.init.model.IInitTask;
import com.obric.memorydata.ability.data.h;
import com.obric.memorydata.ability.data.p;
import com.obric.memorydata.ability.f;
import com.obric.memorydata.ability.k;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.obric.memorydata.memory.lab.AILabPermissionRepository;
import com.obric.memorydata.memory.ui.lab.AILabActivity;
import com.obric.memorydata.memory.ui.settings.l;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.bdtracker.MemoryAppLogSettings;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.task.TaskRegister;
import com.obric.memorydata.task.condition.Condition;
import com.obric.memorydata.task.impl.TaskRequest;
import com.obric.memorydata.task.scheduler.impl.ExistingTaskPolicy;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.bx;
import kotlinx.coroutines.cu;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000O\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0014\b\u0007\u0018\u0000 +2\u00020\u0001:\u0001+B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0002J\b\u0010\u0019\u001a\u00020\u0017H\u0002J\b\u0010\u001a\u001a\u00020\u0017H\u0002J\u0010\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u000eH\u0002J\u001c\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u000e2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u000eH\u0002J\b\u0010\u001f\u001a\u00020\u0017H\u0002J\b\u0010 \u001a\u00020\u0017H\u0002J\b\u0010!\u001a\u00020\u0017H\u0002J\u001a\u0010\"\u001a\u00020\u00172\b\u0010#\u001a\u0004\u0018\u00010\u00052\u0006\u0010$\u001a\u00020\u0005H\u0002J\u0010\u0010%\u001a\u00020\u00172\u0006\u0010&\u001a\u00020\u0005H\u0002J\u0010\u0010'\u001a\u00020\u00172\u0006\u0010(\u001a\u00020)H\u0002J\u0010\u0010*\u001a\u00020\u00172\u0006\u0010(\u001a\u00020)H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0015¨\u0006,"}, d2 = {"Lcom/obric/memorydata/init/tasks/AILabInitTask;", "Lcom/bytedance/lego/init/model/IInitTask;", "<init>", "()V", "lastPermissionState", "Lcom/obric/memorydata/memory/lab/AILabPermissionState;", "accountEventScope", "Lkotlinx/coroutines/CoroutineScope;", "accountEventLock", "", "accountRefreshJob", "Lkotlinx/coroutines/Job;", "accountLogoutJob", "pendingLogoutUserId", "", "screenStateAbilityManager", "Lcom/obric/memorydata/ability/AbilityManager;", "screenUnlockAbilityParams", "Lcom/obric/memorydata/ability/AbilityParams;", "screenUnlockReceiver", "com/obric/memorydata/init/tasks/AILabInitTask$screenUnlockReceiver$1", "Lcom/obric/memorydata/init/tasks/AILabInitTask$screenUnlockReceiver$1;", "run", "", "registerAccountListenerForAILab", "registerLoginStateListener", "registerDidListenerForAILab", "scheduleAccountPermissionRefresh", InfoRequestQPSOptTraceLogger.REASON, "scheduleAccountLogout", "lastUserId", "observeAILabPermissionState", "subscribeScreenUnlockAbility", "refreshPermissionIfNeededAfterUnlock", "sendApprovalNotificationsIfNeeded", "previousState", "currentState", "applyAILabPermissionState", "state", "enableMemoryTileService", "enable", "", "enableAlwaysOnTileService", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AILabInitTask extends IInitTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f9881a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile com.obric.memorydata.memory.lab.d f9882b;
    private final al c;
    private final Object d;
    private bx e;
    private bx f;
    private String g;
    private final com.obric.memorydata.ability.d h;
    private final f i;
    private final c j;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/obric/memorydata/init/tasks/AILabInitTask$Companion;", "", "<init>", "()V", "TAG", "", "UNLOCK_PERMISSION_REFRESH_INTERVAL_MS", "", "ACCOUNT_EVENT_COALESCE_MS", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¨\u0006\b"}, d2 = {"com/obric/memorydata/init/tasks/AILabInitTask$registerLoginStateListener$1", "Lcom/obric/memorydata/middleware/api/app/LoginStateListener;", "onLogin", "", "userId", "", "onLogout", "lastUserId", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements com.obric.memorydata.middleware.api.app.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AILabInitTask f9883a;

        b(AILabInitTask r1) {
            this.f9883a = r1;
        }

        @Override // com.obric.memorydata.middleware.api.app.d
        public void a(String r10) {
            Intrinsics.checkNotNullParameter(r10, "userId");
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AILabInitTask", "UserSettings login, loginUserId: " + r10, false, 4, null);
            if (AILabPermissionRepository.f10236a.a(r10) == false) goto L5;
            AILabInitTask.a(this.f9883a, "user_settings_login");
            return;
        L5:
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AILabInitTask", "skip UserSettings login, uid not ready", false, 4, null);
        }

        @Override // com.obric.memorydata.middleware.api.app.d
        public void b(String r8) {
            Intrinsics.checkNotNullParameter(r8, "lastUserId");
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AILabInitTask", "UserSettings logout, logoutUserId: " + r8, false, 4, null);
            l.f11479a.a().B();
            AILabInitTask.a(this.f9883a, "user_settings_logout", r8);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/memorydata/init/tasks/AILabInitTask$screenUnlockReceiver$1", "Lcom/obric/memorydata/ability/IAbilityDataReceiver;", "onDataReceive", "", "data", "Lcom/obric/memorydata/ability/data/IStandardData;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AILabInitTask f9884a;

        c(AILabInitTask r1) {
            this.f9884a = r1;
        }

        @Override // com.obric.memorydata.ability.k
        public void a(h r9) {
            h r10 = (h) ZeusTransformUtils.wrapperContextForParams(r9, h.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r10, "data");
            if (ZeusTransformUtils.instanceOf(r10, p.class) == true) goto L5;
            return;
        L5:
            if (Intrinsics.areEqual(((p) ZeusTransformUtils.preCheckCast(r10, p.class, "com.obric.memorydata.plugin")).a(), "unlock") == false) goto L9;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AILabInitTask", "unlock refreshPermissionIfNeededAfterUnlock", false, 4, null);
            i.a(am.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin")), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AILabInitTask$screenUnlockReceiver$1$onDataReceive$1(this.f9884a, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
            return;
        }

        @Override // com.obric.memorydata.ability.k
        public String g_() {
            return k.a.a(this);
        }
    }

    static {
        f9881a = new a(null);
    }

    public AILabInitTask() {
        this.c = am.a(cu.a(null, 1, null).plus((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin")));
        this.d = new Object();
        this.h = new com.obric.memorydata.ability.d();
        this.i = new f(100000005, MapsKt.mapOf(TuplesKt.to("mode", "unlock")));
        this.j = new c(this);
    }

    public static final /* synthetic */ com.obric.memorydata.memory.lab.d a(AILabInitTask r0) {
        return r0.f9882b;
    }

    private final void a() {
        i.a(am.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin")), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AILabInitTask$registerAccountListenerForAILab$1(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    public static final /* synthetic */ void a(AILabInitTask r0, com.obric.memorydata.memory.lab.d r1) {
        r0.f9882b = r1;
    }

    public static final /* synthetic */ void a(AILabInitTask r0, com.obric.memorydata.memory.lab.d r1, com.obric.memorydata.memory.lab.d r2) {
        r0.a(r1, r2);
    }

    public static final /* synthetic */ void a(AILabInitTask r0, String r1) {
        r0.a(r1);
    }

    public static final /* synthetic */ void a(AILabInitTask r0, String r1, String r2) {
        r0.a(r1, r2);
    }

    static /* synthetic */ void a(AILabInitTask r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        r0.a(r1, r2);
    }

    private final void a(com.obric.memorydata.memory.lab.d r16) {
        boolean r1 = AILabPermissionRepository.f10236a.a(r16.g().e());
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AILabInitTask", "apply ai proactive state enabled=" + r1 + " status=" + r16.g().b() + " providerStatus=" + r16.g().e(), false, 4, null);
        boolean r13 = true;
        if (r1 == true) goto L5;
        l.f11479a.a().e((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
    L6:
        boolean r2 = AILabPermissionRepository.f10236a.b(r16);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AILabInitTask", "apply screen memory state enabled=" + r2 + " status=" + r16.d().b() + " providerStatus=" + r16.d().e(), false, 4, null);
        l.f11479a.a().d(r2);
        a(r2);
        boolean r3 = AILabPermissionRepository.f10236a.c(r16);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AILabInitTask", "apply voice memory state enabled=" + r3 + " status=" + r16.e().b() + " providerStatus=" + r16.e().e(), false, 4, null);
        l.f11479a.a().e(r3);
        b(r3);
        l.f11479a.a().C();
        com.obric.memorydata.memory.ui.settings.contextawareness.c.f11448a.b(r16.c());
        boolean r14 = AILabPermissionRepository.f10236a.a(r16.f().e());
        boolean r0 = AILabPermissionRepository.a(AILabPermissionRepository.f10236a, r16, null, null, null, null, null, 62, null);
        IRunLog r4 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r5 = new StringBuilder().append("apply auto memory state enabled=").append(r0).append(" providerEnabled=").append(r14).append(" whitelistEnabled=");
        if (r0 == false) goto L10;
        if (r14 == true) goto L10;
    L11:
        IRunLog.a.a(r4, "AILabInitTask", r5.append(r13).append(" status=").append(r16.f().b()).append(" providerStatus=").append(r16.f().e()).toString(), false, 4, null);
        l.f11479a.a().f(r0);
        if (r0 == true) goto L14;
        l.f11479a.a().d((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), false);
        return;
    L14:
        l.f11479a.a().f((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        com.obric.memorydata.utils.h.a($$Lambda$AILabInitTask$K6Ydz9fju_PFffcsjAx1B8tR_oc.INSTANCE);
        return;
    L10:
        r13 = false;
        goto L11
    L5:
        l.f11479a.a().c((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), true);
        goto L6
    }

    private final void a(com.obric.memorydata.memory.lab.d r7, com.obric.memorydata.memory.lab.d r8) {
        List r6 = AILabPermissionRepository.a(AILabPermissionRepository.f10236a, AILabPermissionRepository.f10236a.a(r7, r8), null, 2, null);
        if (r6.isEmpty() == false) goto L5;
        return;
    L5:
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin");
        AILabPermissionRepository r0 = AILabPermissionRepository.f10236a;
        Iterator r10 = r9.iterator();
    L7:
        if (r10.hasNext() == false) goto L10;
        r0.e((String) ZeusTransformUtils.preCheckCast(r10.next(), String.class, "com.obric.memorydata.plugin"));
        goto L7
    L10:
        if (AILabActivity.Companion.a() == false) goto L13;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AILabInitTask", "skip approval notification, AILabActivity is foreground, permissions=" + r6, false, 4, null);
        return;
    L13:
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L15:
        if (r11.hasNext() == false) goto L17;
        com.obric.memorydata.memory.lab.b.f10245a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(r11.next(), String.class, "com.obric.memorydata.plugin"));
        goto L15
    }

    private final void a(String r8) {
        Object r0 = this.d;
        monitor-enter(r0);
        bx r1 = this.f;     // Catch: Throwable -> L13
        if (r1 == null) goto L7;
        bx.a.a(r1, null, 1, null);     // Catch: Throwable -> L13
    L7:
        this.g = null;     // Catch: Throwable -> L13
        bx r2 = this.e;     // Catch: Throwable -> L13
        if (r2 == null) goto L10;
        bx.a.a(r2, null, 1, null);     // Catch: Throwable -> L13
    L10:
        this.e = i.a(this.c, null, null, (Function2) ZeusTransformUtils.preCheckCast(new AILabInitTask$scheduleAccountPermissionRefresh$1$1(r8, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);     // Catch: Throwable -> L13
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L13
        monitor-exit(r0);
        return;
    L13:
        th = move-exception;
        throw th;
    }

    private final void a(String r8, String r9) {
        Object r0 = this.d;
        monitor-enter(r0);
        bx r1 = this.e;     // Catch: Throwable -> L16
        if (r1 == null) goto L8;
        bx.a.a(r1, null, 1, null);     // Catch: Throwable -> L16
    L8:
        if (AILabPermissionRepository.f10236a.a(r9) == false) goto L10;
        this.g = r9;     // Catch: Throwable -> L16
    L10:
        bx r10 = this.f;     // Catch: Throwable -> L16
        if (r10 == null) goto L13;
        bx.a.a(r10, null, 1, null);     // Catch: Throwable -> L16
    L13:
        this.f = i.a(this.c, null, null, (Function2) ZeusTransformUtils.preCheckCast(new AILabInitTask$scheduleAccountLogout$1$1(this, r8, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);     // Catch: Throwable -> L16
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L16
        monitor-exit(r0);
        return;
    L16:
        th = move-exception;
        throw th;
    }

    private final void a(boolean r9) {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AILabInitTask", "enableMemoryTileService, enable: " + r9, false, 4, null);
        if (r9 == true) goto L5;
    L16:
        ComponentName r8 = new ComponentName("com.larus.nova", "com.obric.memorydata.recommend.tile.ScreenObservationTileService");     // Catch: Exception -> L13
        if (r9 == false) goto L11;
        ZeusTransformUtils.setComponentEnabledSetting(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getPackageManager(), r8, 1, 1);     // Catch: Exception -> L13
        return;
    L11:
        ZeusTransformUtils.setComponentEnabledSetting(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getPackageManager(), r8, 2, 1);     // Catch: Exception -> L13
        return;
    L13:
        e = move-exception;
        RunLog.INSTANCE.error("AILabInitTask", "enableMemoryTileService error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return;
    L5:
        if (UserSettings.INSTANCE.hasAgreePrivacyAndLogin() == true) goto L16;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AILabInitTask", "enableMemoryTileService, not login", false, 4, null);
    }

    public static final /* synthetic */ Object b(AILabInitTask r0) {
        return r0.d;
    }

    private final void b() {
        UserSettings.INSTANCE.registerLoginStateListener((com.obric.memorydata.middleware.api.app.d) ZeusTransformUtils.preCheckCast(new b(this), com.obric.memorydata.middleware.api.app.d.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ void b(AILabInitTask r0, com.obric.memorydata.memory.lab.d r1) {
        r0.a(r1);
    }

    public static final /* synthetic */ void b(AILabInitTask r0, String r1) {
        r0.g = r1;
    }

    private final void b(boolean r9) {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AILabInitTask", "enableAlwaysOnTileService, enable: " + r9, false, 4, null);
        if (r9 == true) goto L5;
    L16:
        ComponentName r8 = new ComponentName("com.obric.recorder", "com.bytedanceos.recorder.alwayson.tile.AlwaysOnTileService");     // Catch: Exception -> L13
        if (r9 == false) goto L11;
        ZeusTransformUtils.setComponentEnabledSetting(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getPackageManager(), r8, 1, 1);     // Catch: Exception -> L13
        return;
    L11:
        ZeusTransformUtils.setComponentEnabledSetting(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getPackageManager(), r8, 2, 1);     // Catch: Exception -> L13
        return;
    L13:
        e = move-exception;
        RunLog.INSTANCE.error("AILabInitTask", "enableAlwaysOnTileService error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return;
    L5:
        if (UserSettings.INSTANCE.hasAgreePrivacyAndLogin() == true) goto L16;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AILabInitTask", "enableAlwaysOnTileService, not login", false, 4, null);
    }

    public static final /* synthetic */ String c(AILabInitTask r0) {
        return r0.g;
    }

    private static final Unit c(AILabInitTask r6, String r7) {
        Intrinsics.checkNotNullParameter(r7, "it");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AILabInitTask", "did changed, schedule account permission refresh", false, 4, null);
        r6.a("app_log_did_changed");
        return Unit.INSTANCE;
    }

    private final void c() {
        MemoryAppLogSettings.INSTANCE.registerDidListener(new $$Lambda$AILabInitTask$Vu1ABfmlMw8Hyu9zh4o3LhfbUg(this), new $$Lambda$AILabInitTask$GK9Efxlzu9YGhxlb0g7LwtuPtTw(this), new $$Lambda$AILabInitTask$A0rjLO98Sky5OKQPcJH4t85Cbo(this));
    }

    private static final Unit d(AILabInitTask r6, String r7) {
        Intrinsics.checkNotNullParameter(r7, "it");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AILabInitTask", "did loaded, schedule account permission refresh", false, 4, null);
        r6.a("app_log_did_loaded");
        return Unit.INSTANCE;
    }

    private final void d() {
        i.a(am.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin")), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AILabInitTask$observeAILabPermissionState$1(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    public static final /* synthetic */ void d(AILabInitTask r0) {
        r0.f();
    }

    private static final Unit e(AILabInitTask r9) {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AILabInitTask", "AILab init task run", false, 4, null);
        TaskRegister.f12863a.a(AILabCheckPermissionTask.NAME, AILabCheckPermissionTask.class);
        r9.d();
        AILabPermissionRepository.f10236a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        r9.a();
        r9.b();
        r9.c();
        r9.e();
        return Unit.INSTANCE;
    }

    private static final Unit e(AILabInitTask r1, String r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        r1.a("has_app_log_did");
        return Unit.INSTANCE;
    }

    private final void e() {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AILabInitTask", "subscribe screen unlock ability result=" + this.h.a(this.i, (k) ZeusTransformUtils.preCheckCast(this.j, k.class, "com.obric.memorydata.plugin")), false, 4, null);
    }

    private final void f() {
        if (UserSettings.INSTANCE.hasAgreePrivacyAndLogin() == true) goto L7;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AILabInitTask", "skip unlock permission refresh, user not login", false, 4, null);
        return;
    L7:
        if (AILabPermissionRepository.f10236a.a(AppContext.INSTANCE.getUserId()) == true) goto L10;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AILabInitTask", "skip unlock permission refresh, uid empty", null, 4, null);
        return;
    L10:
        com.obric.memorydata.memory.lab.d r11 = (com.obric.memorydata.memory.lab.d) ZeusTransformUtils.preCheckCast(AILabPermissionRepository.f10236a.a().c(), com.obric.memorydata.memory.lab.d.class, "com.obric.memorydata.plugin");
        long r9 = AILabPermissionRepository.f10236a.b();
        boolean r1 = AILabPermissionRepository.f10236a.a(r11, r9, System.currentTimeMillis(), 1800000);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AILabInitTask", "unlock permission refresh, hasWaiting=" + AILabPermissionRepository.f10236a.d(r11) + ", lastUnlockGetPermissionTime=" + r9 + ", shouldRefresh=" + r1, false, 4, null);
        if (r1 == false) goto L14;
        com.obric.memorydata.memory.lab.a.f10241a.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "screen_unlock_waiting_permission");
        return;
    }

    private static final Unit g() {
        if (MemoryDbEngine.INSTANCE.getPersonalDbEngine().getMemoryRuleDao().hasPendingRuleGenerator() == false) goto L6;
        ((TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(new TaskRequest.Builder("auto_memory_pro_rule_generator").setConditions(new Condition[]{Condition.NETWORK_AVAILABLE, Condition.SCREEN_ON_OR_CHARGE}), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setExistingTaskPolicy(ExistingTaskPolicy.KEEP_IN_QUEUE), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin")).enqueue();
    L6:
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: lambda$A0rjLO98-Sky5OKQPcJH4t85Cbo, reason: not valid java name */
    public static /* synthetic */ Unit m661lambda$A0rjLO98Sky5OKQPcJH4t85Cbo(AILabInitTask r0, String r1) {
        return e(r0, r1);
    }

    public static /* synthetic */ Unit lambda$GK9Efxlzu9YGhxlb0g7LwtuPtTw(AILabInitTask r0, String r1) {
        return d(r0, r1);
    }

    public static /* synthetic */ Unit lambda$K6Ydz9fju_PFffcsjAx1B8tR_oc() {
        return g();
    }

    /* JADX INFO: renamed from: lambda$Vu1ABfmlMw8Hyu9zh4o3Lh-fbUg, reason: not valid java name */
    public static /* synthetic */ Unit m662lambda$Vu1ABfmlMw8Hyu9zh4o3LhfbUg(AILabInitTask r0, String r1) {
        return c(r0, r1);
    }

    public static /* synthetic */ Unit lambda$k_sPLb6Sc1pCIoCOxWzOhaizU_k(AILabInitTask r0) {
        return e(r0);
    }

    @Override // java.lang.Runnable
    public void run() {
        com.obric.memorydata.utils.h.a(new $$Lambda$AILabInitTask$k_sPLb6Sc1pCIoCOxWzOhaizU_k(this));
    }
}
