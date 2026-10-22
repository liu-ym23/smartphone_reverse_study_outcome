package com.obric.memorydata.memory.a;

import android.content.ComponentName;
import android.content.Context;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.obric.memorydata.memory.ui.settings.l;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.app.b;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00009\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000*\u0001\u000f\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0011\u001a\u00020\u0012J\u0018\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0005H\u0002J\u0018\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0014\u001a\u00020\fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\rR\u0010\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010¨\u0006\u0019"}, d2 = {"Lcom/obric/memorydata/memory/account/EnterpriseAccountController;", "", "<init>", "()V", "TAG", "", "MEMORY_SHARE_ACTIVITY", "MEMORY_ACCESSIBILITY_SERVICE", "initialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "stateLock", "lastEnterpriseState", "", "Ljava/lang/Boolean;", "accountListener", "com/obric/memorydata/memory/account/EnterpriseAccountController$accountListener$1", "Lcom/obric/memorydata/memory/account/EnterpriseAccountController$accountListener$1;", CommonConsts.APM_INNER_EVENT_COST_INIT, "", "syncEnterpriseAccountState", "isEnterprise", AILabCheckPermissionTask.KEY_SOURCE, "syncComponentEntries", "context", "Landroid/content/Context;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f10046a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final AtomicBoolean f10047b = null;
    private static final Object c = null;
    private static volatile Boolean d;
    private static final C0488a e = null;

    /* JADX INFO: renamed from: com.obric.memorydata.memory.a.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"com/obric/memorydata/memory/account/EnterpriseAccountController$accountListener$1", "Lcom/obric/memorydata/middleware/api/app/EnterpriseAccountListener;", "onEnterEnterprise", "", "onExitEnterprise", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C0488a implements b {
        C0488a() {
        }

        @Override // com.obric.memorydata.middleware.api.app.b
        public void a() {
            a.a(a.f10046a, true, "listener");
        }

        @Override // com.obric.memorydata.middleware.api.app.b
        public void b() {
            a.a(a.f10046a, false, "listener");
        }
    }

    static {
        f10046a = new a();
        f10047b = new AtomicBoolean(false);
        c = new Object();
        e = new C0488a();
    }

    private a() {
    }

    private final void a(Context r10, boolean r11) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        if (r11 == false) goto L5;
        int r12 = 2;
    L6:
        Iterator r13 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.listOf(new String[]{"com.obric.memorydata.plugin_api.stub.activity.MemoryShareActivity", "com.obric.assist.service.MemoryAccessibilityService"}), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L8:
        if (r13.hasNext() == false) goto L17;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r13.next(), String.class, "com.obric.memorydata.plugin");
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L12
        ZeusTransformUtils.setComponentEnabledSetting(r9.getPackageManager(), new ComponentName(r9.getPackageName(), r1), r12, 1);     // Catch: Throwable -> L12
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EnterpriseAccountController", "sync component entry: className=" + r1 + ", state=" + r12, false, 4, null);     // Catch: Throwable -> L12
        Object r3 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L12
    L14:
        Throwable r4 = Result.m1424exceptionOrNullimpl(r3);
        if (r4 == null) goto L8;
        RunLog.INSTANCE.warn("EnterpriseAccountController", "sync component entry failed: className=" + r1, r4);
    L12:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r3 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L14
    L17:
        return;
    L5:
        r12 = 0;
        goto L6
    }

    public static final /* synthetic */ void a(a r0, boolean r1, String r2) {
        r0.a(r1, r2);
    }

    private final void a(boolean r9, String r10) {
        Object r0 = c;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (Intrinsics.areEqual(d, Boolean.valueOf(r9)) == false) goto L8;
        monitor-exit(r0);
        return;
    L8:
        d = Boolean.valueOf(r9);     // Catch: Throwable -> L12
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(r0);
        Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EnterpriseAccountController", "sync enterprise account state: isEnterprise=" + r9 + ", source=" + r10, false, 4, null);
        a(r2, r9);
        l.f11479a.a().e(r2, r9);
    }

    public final void a() {
        if (f10047b.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        UserSettings.INSTANCE.registerEnterpriseAccountListener((b) ZeusTransformUtils.preCheckCast(e, b.class, "com.obric.memorydata.plugin"));
        a(UserSettings.INSTANCE.isEnterpriseAccount(), "initial");
    }
}
