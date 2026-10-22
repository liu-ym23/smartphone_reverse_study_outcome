package com.obric.memorydata.middleware.api.logging;

import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.settings.SettingsChangeListener;
import com.obric.memorydata.middleware.api.settings.SettingsManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000/\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\f\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u000e\u001a\u00020\u0007J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0007H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\r¨\u0006\u0012"}, d2 = {"Lcom/obric/memorydata/middleware/api/logging/MainTraceReportGate;", "", "<init>", "()V", "ENABLE_KEY", "", "cachedEnabled", "", "Ljava/lang/Boolean;", "listenerRegistered", "Ljava/util/concurrent/atomic/AtomicBoolean;", "settingsChangeListener", "com/obric/memorydata/middleware/api/logging/MainTraceReportGate$settingsChangeListener$1", "Lcom/obric/memorydata/middleware/api/logging/MainTraceReportGate$settingsChangeListener$1;", "isEnabled", "ensureListenerRegistered", "", "loadReleaseEnabled", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f11621a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile Boolean f11622b;
    private static final AtomicBoolean c = null;
    private static final a d = null;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/memorydata/middleware/api/logging/MainTraceReportGate$settingsChangeListener$1", "Lcom/obric/memorydata/middleware/api/settings/SettingsChangeListener;", "onSettingsChanged", "", "key", "", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements SettingsChangeListener {
        a() {
        }

        @Override // com.obric.memorydata.middleware.api.settings.SettingsChangeListener
        public void onSettingsChanged(String r1) {
            Intrinsics.checkNotNullParameter(r1, "key");
            if (Intrinsics.areEqual(r1, SettingsManager.KEY_MAIN_TRACE_REPORT_SETTINGS) == false) goto L6;
            i r0 = i.f11621a;
            i.a(Boolean.valueOf(i.a(i.f11621a)));
            return;
        }
    }

    static {
        f11621a = new i();
        c = new AtomicBoolean(false);
        d = new a();
    }

    private i() {
    }

    public static final /* synthetic */ void a(Boolean r0) {
        f11622b = r0;
    }

    public static final /* synthetic */ boolean a(i r0) {
        return r0.c();
    }

    private final void b() {
        if (c.compareAndSet(false, true) == true) goto L13;
        return;
    L13:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L7
        i r5 = (i) ZeusTransformUtils.preCheckCast(this, i.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        SettingsManager.INSTANCE.registerChangeListener(SettingsManager.KEY_MAIN_TRACE_REPORT_SETTINGS, (SettingsChangeListener) ZeusTransformUtils.preCheckCast(d, SettingsChangeListener.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L7
        Object r6 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L10:
        if (Result.m1424exceptionOrNullimpl(r6) == null) goto L15;
        c.set(false);
        return;
    L15:
        return;
    L7:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        r6 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    private final boolean c() {
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L5
        i r4 = (i) ZeusTransformUtils.preCheckCast(this, i.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
        Object r5 = Result.m1421constructorimpl(SettingsManager.INSTANCE.getJson(SettingsManager.KEY_MAIN_TRACE_REPORT_SETTINGS));     // Catch: Throwable -> L5
    L7:
        Boolean r3 = null;
        if (Result.m1427isFailureimpl(r5) == false) goto L10;
        r5 = null;
    L10:
        JSONObject r6 = (JSONObject) ZeusTransformUtils.preCheckCast(r5, JSONObject.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L13;
        return false;
    L13:
        JSONObject r0 = r6.optJSONObject(SettingsManager.KEY_MAIN_TRACE_REPORT_SETTINGS);
        if (r0 == null) goto L17;
        r6 = r0;
    L17:
        Object r7 = r6.opt("enable");
        if (ZeusTransformUtils.instanceOf(r7, Boolean.class) == false) goto L20;
        r3 = (Boolean) ZeusTransformUtils.preCheckCast(r7, Boolean.class, "com.obric.memorydata.plugin");
    L20:
        if (r3 != null) goto L22;
        return false;
    L22:
        return r3.booleanValue();
    L5:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r5 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public final boolean a() {
        if (AppContext.INSTANCE.isDebug() == false) goto L5;
        return true;
    L5:
        if (AppContext.INSTANCE.isLocalTest() == true) goto L24;
        b();
        Boolean r0 = f11622b;
        if (r0 != null) goto L10;
        monitor-enter(this);
        Boolean r1 = f11622b;     // Catch: Throwable -> L18
        if (r1 == null) goto L15;
        boolean r2 = r1.booleanValue();     // Catch: Throwable -> L18
    L16:
        monitor-exit(this);
        return r2;
    L15:
        r2 = f11621a.c();     // Catch: Throwable -> L18
        f11622b = Boolean.valueOf(r2);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    L10:
        return r0.booleanValue();
    L24:
        return true;
    }
}
