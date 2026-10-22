package com.obric.memorydata.personalcontext.util;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.obric.memorydata.personalcontext.storage.q;
import com.obric.memorydata.utils.threadpool.ThreadPoolContainer;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000)\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\n\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\f\u001a\u00020\rJ\b\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u000f\u001a\u00020\rH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/obric/memorydata/personalcontext/util/TimeZoneChangeReceiver;", "", "<init>", "()V", "TAG", "", "KEY_TIMEZONE", "receiverInitialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "timeZoneChangeReceiver", "com/obric/memorydata/personalcontext/util/TimeZoneChangeReceiver$timeZoneChangeReceiver$1", "Lcom/obric/memorydata/personalcontext/util/TimeZoneChangeReceiver$timeZoneChangeReceiver$1;", "initializeTimeZoneChangeReceiver", "", "checkTimeZoneChange", "onTimeZoneChange", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f12380a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final AtomicBoolean f12381b = null;
    private static final a c = null;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/obric/memorydata/personalcontext/util/TimeZoneChangeReceiver$timeZoneChangeReceiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a extends PluginBroadcastReceiver {
        a() {
        }

        public void onReceive(Context r2, Intent r3) {
            Intrinsics.checkNotNullParameter((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), "context");
            Intrinsics.checkNotNullParameter(r3, MemorySourceLinkType.INTENT);
            RunLog.INSTANCE.debug("TimeZoneChangeReceiver", "PersonalContext TimeZoneChangeReceiver: " + r3.getAction());
            String r1 = r3.getAction();
            if (r1 != null) goto L5;
            return;
        L5:
            if (r1.hashCode() == 502473491) goto L8;
            return;
        L8:
            if (r1.equals("android.intent.action.TIMEZONE_CHANGED") == false) goto L12;
            k.a(k.f12380a);
            return;
        }
    }

    static {
        f12380a = new k();
        f12381b = new AtomicBoolean(false);
        c = new a();
    }

    private k() {
    }

    public static final /* synthetic */ void a(k r0) {
        r0.b();
    }

    private final void b() {
        boolean r3 = false;
        String r7 = "";
        String r0 = IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).getString("KEY_TIMEZONE", "");
        String r8 = TimeZone.getDefault().getID();
        if (r8 == null) goto L7;
        r7 = r8;
    L7:
        if (Intrinsics.areEqual(r0, r7) == true) goto L19;
        IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).save("KEY_TIMEZONE", r7);
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L11;
        boolean r1 = true;
    L12:
        if (r1 == true) goto L14;
        return;
    L14:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L16;
        r3 = true;
    L16:
        if (r3 == false) goto L21;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "TimeZoneChangeReceiver", "TimeZoneChangeReceiver time zone changed from " + r0 + " to " + r7, false, 4, null);
        c();
        return;
    L21:
        return;
    L11:
        r1 = false;
        goto L12
    }

    private final void c() {
        RunLog.INSTANCE.debug("TimeZoneChangeReceiver", "PersonalContext onTimeZoneChange");
        ThreadPoolContainer.Companion.execute($$Lambda$k$ZT6Nk6cTHoh2uJXi7Ca_Et0a100.INSTANCE);
    }

    private static final void d() {
        q r4 = null;
        com.obric.memorydata.personalcontext.storage.a r0 = com.obric.memorydata.personalcontext.q.a(com.obric.memorydata.personalcontext.q.f12255a, 402, false, 2, null);
        if (ZeusTransformUtils.instanceOf(r0, q.class) == false) goto L5;
        r4 = (q) ZeusTransformUtils.preCheckCast(r0, q.class, "com.obric.memorydata.plugin");
    L5:
        if (r4 == null) goto L8;
        r4.b();
        return;
    }

    public static /* synthetic */ void lambda$ZT6Nk6cTHoh2uJXi7Ca_Et0a100() {
        d();
    }

    public final void a() {
        if (f12381b.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "TimeZoneChangeReceiver", "initializeTimeZoneChangeReceiver", false, 4, null);
        IntentFilter r0 = new IntentFilter();     // Catch: Exception -> L8
        r0.addAction("android.intent.action.TIMEZONE_CHANGED");     // Catch: Exception -> L8
        ZeusTransformUtils.registerReceiver((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), (PluginBroadcastReceiver) ZeusTransformUtils.preCheckCast(c, PluginBroadcastReceiver.class, "com.obric.memorydata.plugin"), r0, "com.obric.memorydata.plugin");     // Catch: Exception -> L8
    L10:
        b();
        return;
    L8:
        e = move-exception;
        RunLog.INSTANCE.error("TimeZoneChangeReceiver", "failed to initializeTimeZoneChangeReceiver", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        goto L10
    }
}
