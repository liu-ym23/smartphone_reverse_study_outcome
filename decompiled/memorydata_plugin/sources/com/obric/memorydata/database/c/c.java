package com.obric.memorydata.database.c;

import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
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
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00009\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0013\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u001eB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0015\u001a\u00020\u0016J\u0006\u0010\u0017\u001a\u00020\fJ\u0006\u0010\u0018\u001a\u00020\u0019J\b\u0010\u001a\u001a\u00020\u0019H\u0002J\b\u0010\u001b\u001a\u00020\u0019H\u0002J\b\u0010\u001c\u001a\u00020\u0019H\u0002J\b\u0010\u001d\u001a\u00020\u0019H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u000e\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0014¨\u0006\u001f"}, d2 = {"Lcom/obric/memorydata/database/review/MemoryReviewEntrySettings;", "", "<init>", "()V", "TAG", "", "CONFIG_KEY", "ENABLE_KEY", "SOURCE_CONFIG", "SOURCE_MEMORY_CACHE", "SOURCE_UNKNOWN", "cachedEnabled", "", "Ljava/lang/Boolean;", "cachedSource", "cacheLock", "listenerRegistered", "Ljava/util/concurrent/atomic/AtomicBoolean;", "settingsChangeListener", "com/obric/memorydata/database/review/MemoryReviewEntrySettings$settingsChangeListener$1", "Lcom/obric/memorydata/database/review/MemoryReviewEntrySettings$settingsChangeListener$1;", "initialize", "", "isEnabled", "refresh", "Lcom/obric/memorydata/database/review/MemoryReviewEntrySettings$EntryEnabledResult;", "resolveAndUpdateCache", "readFromSettings", "fallbackToMemoryCache", "unresolvedResult", "EntryEnabledResult", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f8852a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile Boolean f8853b;
    private static volatile String c;
    private static final Object d = null;
    private static final AtomicBoolean e = null;
    private static final b f = null;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/obric/memorydata/database/review/MemoryReviewEntrySettings$EntryEnabledResult;", "", "enabled", "", "resolved", AILabCheckPermissionTask.KEY_SOURCE, "", "<init>", "(ZZLjava/lang/String;)V", "getEnabled", "()Z", "getResolved", "getSource", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f8854a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f8855b;
        private final String c;

        public a(boolean r2, boolean r3, String r4) {
            Intrinsics.checkNotNullParameter(r4, AILabCheckPermissionTask.KEY_SOURCE);
            this.f8854a = r2;
            this.f8855b = r3;
            this.c = r4;
        }

        public final boolean a() {
            return this.f8854a;
        }

        public final boolean b() {
            return this.f8855b;
        }

        public final String c() {
            return this.c;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (this.f8854a == r6.f8854a) goto L12;
            return false;
        L12:
            if (this.f8855b == r6.f8855b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((Boolean.hashCode(this.f8854a) * 31) + Boolean.hashCode(this.f8855b)) * 31) + this.c.hashCode();
        }

        public String toString() {
            return "EntryEnabledResult(enabled=" + this.f8854a + ", resolved=" + this.f8855b + ", source=" + this.c + ')';
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/memorydata/database/review/MemoryReviewEntrySettings$settingsChangeListener$1", "Lcom/obric/memorydata/middleware/api/settings/SettingsChangeListener;", "onSettingsChanged", "", "key", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements SettingsChangeListener {
        b() {
        }

        @Override // com.obric.memorydata.middleware.api.settings.SettingsChangeListener
        public void onSettingsChanged(String r7) {
            Intrinsics.checkNotNullParameter(r7, "key");
            if (Intrinsics.areEqual(r7, "obric_feature_cocreation_review_support") == true) goto L5;
            return;
        L5:
            a r6 = c.f8852a.c();
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryReviewEntrySettings", "entry setting changed: enabled=" + r6.a() + ", resolved=" + r6.b() + ", source=" + r6.c(), false, 4, null);
            com.obric.memorydata.database.c.b.f8850a.a();
        }
    }

    static {
        f8852a = new c();
        c = "unknown";
        d = new Object();
        e = new AtomicBoolean(false);
        f = new b();
    }

    private c() {
    }

    private final a d() {
        a r0 = e();
        if (r0.b() == false) goto L7;
        f8853b = Boolean.valueOf(r0.a());
        c = r0.c();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryReviewEntrySettings", "update entry cache: enabled=" + r0.a() + ", source=" + r0.c(), false, 4, null);
        return r0;
    L7:
        return f();
    }

    private final a e() {
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L5
        c r3 = (c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
        Object r4 = Result.m1421constructorimpl(SettingsManager.INSTANCE.getJson("obric_feature_cocreation_review_support"));     // Catch: Throwable -> L5
    L7:
        Throwable r5 = Result.m1424exceptionOrNullimpl(r4);
        if (r5 == null) goto L11;
        RunLog.INSTANCE.warn("MemoryReviewEntrySettings", "read entry setting failed", r5);
    L11:
        if (Result.m1427isFailureimpl(r4) == false) goto L13;
        r4 = null;
    L13:
        JSONObject r6 = (JSONObject) ZeusTransformUtils.preCheckCast(r4, JSONObject.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L16;
        JSONObject r0 = r6.optJSONObject("obric_feature_cocreation_review_support");
        if (r0 == null) goto L21;
        r6 = r0;
    L21:
        Object r1 = r6.opt("enable");
        if (ZeusTransformUtils.instanceOf(r1, Boolean.class) == true) goto L26;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryReviewEntrySettings", "entry setting has no boolean enable field", null, 4, null);
        return g();
    L26:
        return new a(((Boolean) ZeusTransformUtils.preCheckCast(r1, Boolean.class, "com.obric.memorydata.plugin")).booleanValue(), true, "config");
    L16:
        return g();
    L5:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r4 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    private final a f() {
        Boolean r0 = f8853b;
        if (r0 == null) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryReviewEntrySettings", "keep entry memory cache: enabled=" + r0 + ", source=" + c, false, 4, null);
        return new a(r0.booleanValue(), true, "memory_cache");
    L6:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryReviewEntrySettings", "entry setting unresolved without cache, fallback false", false, 4, null);
        return g();
    }

    private final a g() {
        return new a(false, false, "unknown");
    }

    public final void a() {
        if (e.compareAndSet(false, true) == true) goto L13;
        return;
    L13:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L7
        c r5 = (c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        SettingsManager.INSTANCE.registerChangeListener("obric_feature_cocreation_review_support", (SettingsChangeListener) ZeusTransformUtils.preCheckCast(f, SettingsChangeListener.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L7
        Object r6 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L9:
        Throwable r7 = Result.m1424exceptionOrNullimpl(r6);
        if (r7 == null) goto L15;
        e.set(false);
        RunLog.INSTANCE.warn("MemoryReviewEntrySettings", "register settings listener failed", r7);
        return;
    L15:
        return;
    L7:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        r6 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L9
    }

    public final boolean b() {
        a();
        Boolean r1 = f8853b;
        if (r1 != null) goto L5;
        Object r2 = d;
        monitor-enter(r2);
        Boolean r0 = f8853b;     // Catch: Throwable -> L14
        if (r0 == null) goto L11;
        boolean r3 = r0.booleanValue();     // Catch: Throwable -> L14
    L12:
        monitor-exit(r2);
        return r3;
    L11:
        r3 = f8852a.d().a();     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    L5:
        return r1.booleanValue();
    }

    public final a c() {
        a();
        Object r1 = d;
        monitor-enter(r1);
        a r0 = f8852a.d();     // Catch: Throwable -> L7
        monitor-exit(r1);
        return r0;
    L7:
        th = move-exception;
        throw th;
    }
}
