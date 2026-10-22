package com.obric.memorydata;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.obric.aiproactive.api.ProactiveShortcutCompletion;
import com.obric.aiproactive.api.ProactiveShortcutState;
import com.obric.aiproactive.api.af;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.memorydata.memory.ui.settings.l;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.LocalBroadcastManager;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00007\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\f\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u000fJ\u000e\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\r¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/ProactiveShortcutCompletionOwner;", "", "<init>", "()V", "TAG", "", "receiverLock", "receiverRegistered", "", "hub", "Lcom/obric/memorydata/ProactiveShortcutCompletionHub;", "shortcutResultReceiver", "com/obric/memorydata/ProactiveShortcutCompletionOwner$shortcutResultReceiver$1", "Lcom/obric/memorydata/ProactiveShortcutCompletionOwner$shortcutResultReceiver$1;", "ensureRegistered", "", "registerListener", "listener", "Lcom/obric/aiproactive/api/ProactiveShortcutResultListener;", "notifyCurrentState", "unregisterListener", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f9872a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Object f9873b = null;
    private static volatile boolean c;
    private static final g d = null;
    private static final a e = null;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/obric/memorydata/ProactiveShortcutCompletionOwner$shortcutResultReceiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a extends PluginBroadcastReceiver {
        a() {
        }

        public void onReceive(Context r9, Intent r10) {
            Intrinsics.checkNotNullParameter((Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin"), "context");
            Intrinsics.checkNotNullParameter(r10, MemorySourceLinkType.INTENT);
            if (Intrinsics.areEqual(r10.getStringExtra("extra_shortcut_id"), "proactive_home_shortcut") == true) goto L5;
            return;
        L5:
            long r3 = r10.getLongExtra("extra_request_generation", -1);
            if (r3 != (-1)) goto L8;
            return;
        L8:
            h.c().a(r3, r10.getBooleanExtra("extra_notify_ui", true), r10.getBooleanExtra("extra_reconcile_off", false), r10.getBooleanExtra("extra_persist_user_optout_if_inactive", false));
        }
    }

    static {
        f9872a = new h();
        f9873b = new Object();
        d = new g($$Lambda$h$m9CGcXmTx1BkJ1oQNP6c9vu46U.INSTANCE, $$Lambda$h$6XWl_MdsLvy1uoawfu3NoatggxE.INSTANCE, $$Lambda$h$uWaidexFPRE6UGUTkR8JdRJN0.INSTANCE);
        e = new a();
    }

    private h() {
    }

    private static final ProactiveShortcutCompletion a(long r4) {
        return l.f11479a.a().a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r4);
    }

    private static final ProactiveShortcutCompletion a(boolean r4) {
        if (l.f11479a.a().b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r4) != ProactiveShortcutState.ACTIVE) goto L6;
        return ProactiveShortcutCompletion.PINNED;
    L6:
        return ProactiveShortcutCompletion.NOT_PINNED;
    }

    private static final Unit a(Throwable r7) {
        Intrinsics.checkNotNullParameter(r7, "error");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ProactiveShortcutOwner", "notify shortcut result listener failed: " + r7.getClass().getSimpleName(), null, 4, null);
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ g c() {
        return d;
    }

    public static /* synthetic */ ProactiveShortcutCompletion lambda$6XWl_MdsLvy1uoawfu3NoatggxE(boolean r0) {
        return a(r0);
    }

    /* JADX INFO: renamed from: lambda$m9CGcXmTx1BkJ1oQNP6-c9vu46U, reason: not valid java name */
    public static /* synthetic */ ProactiveShortcutCompletion m659lambda$m9CGcXmTx1BkJ1oQNP6c9vu46U(long r0) {
        return a(r0);
    }

    /* JADX INFO: renamed from: lambda$uWa-idexFPRE6UGUTkR8-JdRJN0, reason: not valid java name */
    public static /* synthetic */ Unit m660lambda$uWaidexFPRE6UGUTkR8JdRJN0(Throwable r0) {
        return a(r0);
    }

    public final void a() {
        Object r4 = f9873b;
        monitor-enter(r4);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (c == false) goto L8;
        monitor-exit(r4);
        return;
    L8:
        LocalBroadcastManager.getInstance((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).registerReceiver((PluginBroadcastReceiver) ZeusTransformUtils.preCheckCast(e, PluginBroadcastReceiver.class, "com.obric.memorydata.plugin"), new IntentFilter("com.obric.memorydata.action.SHORTCUT_RESULT"));     // Catch: Throwable -> L11
        c = true;     // Catch: Throwable -> L11
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r4);
    }

    public final void a(af r3) {
        af r4 = (af) ZeusTransformUtils.wrapperContextForParams(r3, af.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "listener");
        a();
        d.a(r4);
    }

    public final void b() {
        ProactiveShortcutState r3 = l.f11479a.a().b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        g r0 = d;
        if (r3 != ProactiveShortcutState.ACTIVE) goto L5;
        ProactiveShortcutCompletion r4 = ProactiveShortcutCompletion.PINNED;
    L6:
        r0.a(r4);
        return;
    L5:
        r4 = ProactiveShortcutCompletion.NOT_PINNED;
        goto L6
    }

    public final void b(af r2) {
        af r1 = (af) ZeusTransformUtils.wrapperContextForParams(r2, af.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "listener");
        d.b(r1);
    }
}
