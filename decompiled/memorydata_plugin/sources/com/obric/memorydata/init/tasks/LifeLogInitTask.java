package com.obric.memorydata.init.tasks;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Binder;
import com.bytedance.lego.init.model.IInitTask;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.memorydata.memory.api.MemoryService;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.obric.memorydata.utils.threadpool.ThreadPoolContainer;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\b\u0005*\u0002\u0005\u0014\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0002\u0016\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0018\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\fH\u0002J\b\u0010\u0012\u001a\u00020\bH\u0002R\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/obric/memorydata/init/tasks/LifeLogInitTask;", "Lcom/bytedance/lego/init/model/IInitTask;", "<init>", "()V", "enterpriseAccountListener", "com/obric/memorydata/init/tasks/LifeLogInitTask$enterpriseAccountListener$1", "Lcom/obric/memorydata/init/tasks/LifeLogInitTask$enterpriseAccountListener$1;", "run", "", "registerScreenMemoryObserver", "syncLifelogLauncherEntries", "isEnterprise", "", AILabCheckPermissionTask.KEY_SOURCE, "", "setLauncherComponentEnabled", "className", "enabled", "registerAppInstallListener", "appInstallReceiver", "com/obric/memorydata/init/tasks/LifeLogInitTask$appInstallReceiver$1", "Lcom/obric/memorydata/init/tasks/LifeLogInitTask$appInstallReceiver$1;", "Companion", "LauncherMode", "lifelog_data_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LifeLogInitTask extends IInitTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f9893a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d f9894b;
    private final c c;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/memorydata/init/tasks/LifeLogInitTask$LauncherMode;", "", "<init>", "(Ljava/lang/String;I)V", "HIDDEN", "NORMAL", "ENTERPRISE_DISABLED", "lifelog_data_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final enum LauncherMode extends Enum<LauncherMode> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ LauncherMode[] $VALUES = null;
        public static final LauncherMode ENTERPRISE_DISABLED = null;
        public static final LauncherMode HIDDEN = null;
        public static final LauncherMode NORMAL = null;

        private static final /* synthetic */ LauncherMode[] $values() {
            return new LauncherMode[]{HIDDEN, NORMAL, ENTERPRISE_DISABLED};
        }

        static {
            HIDDEN = new LauncherMode("HIDDEN", 0);
            NORMAL = new LauncherMode("NORMAL", 1);
            ENTERPRISE_DISABLED = new LauncherMode("ENTERPRISE_DISABLED", 2);
            LauncherMode[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
        }

        private LauncherMode(String r1, int r2) {
            super(r1, r2);
        }

        public static EnumEntries<LauncherMode> getEntries() {
            return $ENTRIES;
        }

        public static LauncherMode valueOf(String r2) {
            return (LauncherMode) ZeusTransformUtils.preCheckCast(Enum.valueOf(LauncherMode.class, r2), LauncherMode.class, "com.obric.memorydata.plugin");
        }

        public static LauncherMode[] values() {
            return (LauncherMode[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), LauncherMode[].class, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/obric/memorydata/init/tasks/LifeLogInitTask$Companion;", "", "<init>", "()V", "TAG", "", "LIFE_LOG_PACKAGE_NAME", "NORMAL_STARTUP_ALIAS", "ENTERPRISE_STARTUP_ALIAS", "lifelog_data_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f9895a = null;

        static {
            int[] r0 = new int[LauncherMode.values().length];
            r0[LauncherMode.HIDDEN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[LauncherMode.NORMAL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[LauncherMode.ENTERPRISE_DISABLED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f9895a = r0;
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/obric/memorydata/init/tasks/LifeLogInitTask$appInstallReceiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "lifelog_data_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c extends PluginBroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ LifeLogInitTask f9896a;

        c(LifeLogInitTask r1) {
            this.f9896a = r1;
        }

        public void onReceive(Context r7, Intent r8) {
            Intrinsics.checkNotNullParameter((Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin"), "context");
            Intrinsics.checkNotNullParameter(r8, MemorySourceLinkType.INTENT);
            String r9 = r8.getAction();
            if (r9 != null) goto L5;
            return;
        L5:
            if (r9.hashCode() == 1544582882) goto L8;
            return;
        L8:
            if (r9.equals("android.intent.action.PACKAGE_ADDED") == false) goto L19;
            Uri r10 = r8.getData();
            if (r10 == null) goto L12;
            String r11 = r10.getSchemeSpecificPart();
        L13:
            if (r11 != null) goto L15;
            return;
        L15:
            if (Intrinsics.areEqual(r11, "com.obric.lifelog") == false) goto L21;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "LifeLogInitTask", "New app installed: " + r11, false, 4, null);
            LifeLogInitTask.a(this.f9896a, UserSettings.INSTANCE.isEnterpriseAccount(), "package_added");
            return;
        L21:
            return;
        L12:
            r11 = null;
            goto L13
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"com/obric/memorydata/init/tasks/LifeLogInitTask$enterpriseAccountListener$1", "Lcom/obric/memorydata/middleware/api/app/EnterpriseAccountListener;", "onEnterEnterprise", "", "onExitEnterprise", "lifelog_data_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class d implements com.obric.memorydata.middleware.api.app.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ LifeLogInitTask f9897a;

        d(LifeLogInitTask r1) {
            this.f9897a = r1;
        }

        @Override // com.obric.memorydata.middleware.api.app.b
        public void a() {
            LifeLogInitTask.a(this.f9897a, true, "enter_enterprise");
        }

        @Override // com.obric.memorydata.middleware.api.app.b
        public void b() {
            LifeLogInitTask.a(this.f9897a, false, "exit_enterprise");
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/memorydata/init/tasks/LifeLogInitTask$registerScreenMemoryObserver$1", "Landroid/database/ContentObserver;", "onChange", "", "selfChange", "", "lifelog_data_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class e extends ContentObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ LifeLogInitTask f9898a;

        e(LifeLogInitTask r1) {
            this.f9898a = r1;
            super(null);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean r7) {
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "LifeLogInitTask", "screen memory changed", false, 4, null);
            long r0 = Binder.clearCallingIdentity();
            LifeLogInitTask.a(this.f9898a, UserSettings.INSTANCE.isEnterpriseAccount(), "screen_memory_changed");     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(r0);
            return;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(r0);
            throw th;
        }
    }

    static {
        f9893a = new a(null);
    }

    public LifeLogInitTask() {
        this.f9894b = new d(this);
        this.c = new c(this);
    }

    private final void a() {
        ZeusProviderTransform.registerContentObserver(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver(), Uri.parse("content://com.obric.memorydata.memory.ailabprovider/screen_memory"), false, (ContentObserver) ZeusTransformUtils.preCheckCast(new e(this), ContentObserver.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
    }

    private static final void a(LifeLogInitTask r7) {
        UserSettings.INSTANCE.registerEnterpriseAccountListener((com.obric.memorydata.middleware.api.app.b) ZeusTransformUtils.preCheckCast(r7.f9894b, com.obric.memorydata.middleware.api.app.b.class, "com.obric.memorydata.plugin"));
        r7.a(UserSettings.INSTANCE.isEnterpriseAccount(), "initial");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "LifeLogInitTask", "registerScreenMemoryObserver", false, 4, null);
        r7.a();
        com.obric.lifelog.data.b.f8050a.b();
        com.obric.lifelog.data.a.f8049a.a();
        r7.b();
    }

    public static final /* synthetic */ void a(LifeLogInitTask r0, boolean r1, String r2) {
        r0.a(r1, r2);
    }

    private final void a(String r7, boolean r8) {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L9
        LifeLogInitTask r6 = (LifeLogInitTask) ZeusTransformUtils.preCheckCast(this, LifeLogInitTask.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        PackageManager r9 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getPackageManager();     // Catch: Throwable -> L9
        ComponentName r2 = new ComponentName("com.obric.lifelog", r7);     // Catch: Throwable -> L9
        if (r8 == false) goto L6;
        int r3 = 1;
    L7:
        ZeusTransformUtils.setComponentEnabledSetting(r9, r2, r3, 1);     // Catch: Throwable -> L9
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "LifeLogInitTask", "sync launcher component: className=" + r7 + ", enabled=" + r8, false, 4, null);     // Catch: Throwable -> L9
        Object r10 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L9
    L11:
        Throwable r11 = Result.m1424exceptionOrNullimpl(r10);
        if (r11 == null) goto L17;
        RunLog.INSTANCE.warn("LifeLogInitTask", "sync launcher component failed: className=" + r7, r11);
        return;
    L17:
        return;
    L6:
        r3 = 2;
    L9:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r10 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    private final void a(boolean r14, String r15) {
        boolean r0 = MemoryService.INSTANCE.isAILabScreenMemoryEnabled();
        if (IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).getInt("is_lifelog_startup_component_enabled", 1) != 1) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == true) goto L8;
    L7:
        LauncherMode r2 = LauncherMode.HIDDEN;
    L12:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "LifeLogInitTask", "sync launcher entries: mode=" + r2 + ", isEnterprise=" + r14 + ", isWhitelisted=" + r0 + ", userEnabled=" + r1 + ", source=" + r15, false, 4, null);
        int r16 = b.f9895a[r2.ordinal()];
        if (r16 == 1) goto L21;
        if (r16 != 2) goto L16;
        a("com.obric.lifelog.ui.startup.LifelogEnterpriseStartupActivity", false);
        a("com.obric.lifelog.ui.startup.LifelogStartupActivity", true);
        return;
    L16:
        if (r16 != 3) goto L19;
        a("com.obric.lifelog.ui.startup.LifelogStartupActivity", false);
        a("com.obric.lifelog.ui.startup.LifelogEnterpriseStartupActivity", true);
        return;
    L19:
        throw new NoWhenBranchMatchedException();
    L21:
        a("com.obric.lifelog.ui.startup.LifelogStartupActivity", false);
        a("com.obric.lifelog.ui.startup.LifelogEnterpriseStartupActivity", false);
        return;
    L8:
        if (r14 == false) goto L10;
        r2 = LauncherMode.ENTERPRISE_DISABLED;
        goto L12
    L10:
        if (r0 == false) goto L7;
        r2 = LauncherMode.NORMAL;
        goto L12
    L5:
        r1 = false;
        goto L6
    }

    private final void b() {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        IntentFilter r2 = new IntentFilter();
        r2.addAction("android.intent.action.PACKAGE_ADDED");
        r2.addDataScheme("package");
        ZeusTransformUtils.registerReceiver(r0, (PluginBroadcastReceiver) ZeusTransformUtils.preCheckCast(this.c, PluginBroadcastReceiver.class, "com.obric.memorydata.plugin"), r2, "com.obric.memorydata.plugin");
    }

    public static /* synthetic */ void lambda$UeLABE2h88DFhuvNe7esM8UnubE(LifeLogInitTask r0) {
        a(r0);
    }

    @Override // java.lang.Runnable
    public void run() {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "LifeLogInitTask", "run", false, 4, null);
        ThreadPoolContainer.Companion.getInstance().execute(new $$Lambda$LifeLogInitTask$UeLABE2h88DFhuvNe7esM8UnubE(this));
    }
}
