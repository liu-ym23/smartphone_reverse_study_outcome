package com.obric.memorydata.memory;

import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.settings.SettingsChangeListener;
import com.obric.memorydata.middleware.api.settings.SettingsManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00009\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u0010\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J>\u0010\u0012\u001a\u00020\u000e26\u0010\u0013\u001a2\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u000e0\rJ\u0006\u0010\u0018\u001a\u00020\u000bJ\u0010\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u0005H\u0002J\b\u0010\u001b\u001a\u00020\u000bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/obric/memorydata/memory/InAppSignalSettings;", "", "<init>", "()V", "TAG", "", "CONFIG_KEY", "TRACE_COLLECT_ENABLED_KEY", "initialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "traceCollectEnabled", "", "enabledChangeListener", "Lkotlin/Function2;", "", "settingsChangeListener", "com/obric/memorydata/memory/InAppSignalSettings$settingsChangeListener$1", "Lcom/obric/memorydata/memory/InAppSignalSettings$settingsChangeListener$1;", "initialize", "listener", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "oldEnabled", "newEnabled", "isTraceCollectEnabled", "refresh", InfoRequestQPSOptTraceLogger.REASON, "readTraceCollectEnabled", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q f10368a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final AtomicBoolean f10369b = null;
    private static volatile boolean c;
    private static volatile Function2<? super Boolean, ? super Boolean, Unit> d;
    private static final a e = null;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/memorydata/memory/InAppSignalSettings$settingsChangeListener$1", "Lcom/obric/memorydata/middleware/api/settings/SettingsChangeListener;", "onSettingsChanged", "", "key", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements SettingsChangeListener {
        a() {
        }

        @Override // com.obric.memorydata.middleware.api.settings.SettingsChangeListener
        public void onSettingsChanged(String r1) {
            Intrinsics.checkNotNullParameter(r1, "key");
            if (Intrinsics.areEqual(r1, "obric_memd_in_app_settings") == true) goto L5;
            return;
        L5:
            q.a(q.f10368a, "settings_changed");
        }
    }

    static {
        f10368a = new q();
        f10369b = new AtomicBoolean(false);
        c = true;
        e = new a();
    }

    private q() {
    }

    public static final /* synthetic */ void a(q r0, String r1) {
        r0.a(r1);
    }

    private final void a(String r11) {
        boolean r0 = b();
        boolean r1 = c;
        if (r1 != r0) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "InAppSignalSettings", "ignore unchanged setting, reason=" + r11 + " enabled=" + r0, false, 4, null);
        return;
    L6:
        c = r0;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "InAppSignalSettings", "trace collect setting changed: " + r1 + " -> " + r0 + ", reason=" + r11, false, 4, null);
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L13
        q r10 = (q) ZeusTransformUtils.preCheckCast(this, q.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
        Function2<? super Boolean, ? super Boolean, Unit> r13 = d;     // Catch: Throwable -> L13
        if (r13 == null) goto L10;
        r13.invoke(Boolean.valueOf(r1), Boolean.valueOf(r0));     // Catch: Throwable -> L13
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L13
    L11:
        Object r15 = Result.m1421constructorimpl(r14);     // Catch: Throwable -> L13
    L15:
        Throwable r16 = Result.m1424exceptionOrNullimpl(r15);
        if (r16 == null) goto L21;
        RunLog.INSTANCE.warn("InAppSignalSettings", "notify settings change failed", r16);
        return;
    L21:
        return;
    L10:
        r14 = null;
    L13:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r15 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L15
    }

    private final boolean b() {
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L5
        q r9 = (q) ZeusTransformUtils.preCheckCast(this, q.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
        Object r10 = Result.m1421constructorimpl(SettingsManager.INSTANCE.getJson("obric_memd_in_app_settings"));     // Catch: Throwable -> L5
    L7:
        Throwable r3 = Result.m1424exceptionOrNullimpl(r10);
        if (r3 == null) goto L11;
        RunLog.INSTANCE.warn("InAppSignalSettings", "read settings failed, fallback true", r3);
    L11:
        if (Result.m1427isFailureimpl(r10) == false) goto L13;
        r10 = null;
    L13:
        JSONObject r11 = (JSONObject) ZeusTransformUtils.preCheckCast(r10, JSONObject.class, "com.obric.memorydata.plugin");
        if (r11 != null) goto L16;
        return true;
    L16:
        JSONObject r0 = r11.optJSONObject("obric_memd_in_app_settings");
        if (r0 == null) goto L20;
        r11 = r0;
    L20:
        Object r12 = r11.opt("trace_collect_enabled");
        if (ZeusTransformUtils.instanceOf(r12, Boolean.class) == true) goto L25;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "InAppSignalSettings", "missing boolean trace_collect_enabled, fallback true", null, 4, null);
        return true;
    L25:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r12, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L5:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r10 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public final void a(Function2<? super Boolean, ? super Boolean, Unit> r7) {
        Function2<? super Boolean, ? super Boolean, Unit> r8 = (Function2) ZeusTransformUtils.wrapperContextForParams(r7, Function2.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "listener");
        d = r8;
        if (f10369b.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        c = b();
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L8
        q r6 = (q) ZeusTransformUtils.preCheckCast(this, q.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L8
        SettingsManager.INSTANCE.registerChangeListener("obric_memd_in_app_settings", (SettingsChangeListener) ZeusTransformUtils.preCheckCast(e, SettingsChangeListener.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L8
        Object r10 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r11 = Result.m1424exceptionOrNullimpl(r10);
        if (r11 == null) goto L13;
        f10369b.set(false);
        RunLog.INSTANCE.warn("InAppSignalSettings", "register settings listener failed", r11);
    L13:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "InAppSignalSettings", "initialized, traceCollectEnabled=" + c, false, 4, null);
        return;
    L8:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r10 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    public final boolean a() {
        return c;
    }
}
