package com.obric.memorydata.middleware.impl.settings;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.store.IStore;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\r\u001a\u00020\u000eJ\b\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0005H\u0002J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0005H\u0002J\u000e\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0005J\u0012\u0010\u0015\u001a\u00020\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/obric/memorydata/middleware/impl/settings/AppSettingsConfig;", "Lcom/bytedance/news/common/settings/SettingsUpdateListener;", "<init>", "()V", "TAG", "", "store", "Lcom/obric/memorydata/middleware/api/store/IStore;", "appSettingsMap", "Ljava/util/concurrent/ConcurrentHashMap;", "APP_SETTINGS", "IGNORED_CACHE_KEYS", "", CommonConsts.APM_INNER_EVENT_COST_INIT, "", "ensureStore", "configFromStore", ActivityLifecycle.NAME, "config", "getAppValueWith", "key", "onSettingsUpdate", "settingsData", "Lcom/bytedance/news/common/settings/api/SettingsData;", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b implements com.bytedance.news.common.settings.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f11853a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private IStore f11854b;
    private ConcurrentHashMap<String, String> c;
    private final String d;
    private final Set<String> e;

    public b() {
        this.f11853a = "AppSettingsConfig";
        this.c = new ConcurrentHashMap();
        this.d = "memory_settings";
        this.e = SetsKt.setOf("app_auto_memory_config");
    }

    private final String b(String r1) {
        b();
        IStore r0 = this.f11854b;
        if (r0 == null) goto L6;
        String r2 = r0.getString(r1);
        if (r2 == null) goto L6;
        return r2;
    L6:
        return "";
    }

    private final void b() {
        if (this.f11854b == null) goto L5;
        return;
    L5:
        monitor-enter(b.class);
    L14:
        th = move-exception;
        throw th;
    L7:
        if (this.f11854b == null) goto L9;
    L11:
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L14
        monitor-exit(b.class);
        return;
    L9:
        if (StoreManager.INSTANCE.hasInit() == false) goto L11;
        this.f11854b = IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), this.d, 0, 2, null);     // Catch: Throwable -> L14
        goto L11
    }

    private final String c(String r4) {
        String r0 = (String) ZeusTransformUtils.preCheckCast(this.c.get(r4), String.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L6;
        String r1 = b(r4);
        ((Map) ZeusTransformUtils.preCheckCast(this.c, Map.class, "com.obric.memorydata.plugin")).put(r4, r1);
        return r1;
    L6:
        return r0;
    }

    public final String a(String r9) {
        Intrinsics.checkNotNullParameter(r9, "key");
        String r0 = c(r9);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), this.f11853a, "getAppValueWith key = " + r9 + " : " + r0, false, 4, null);
        return r0;
    }

    public final void a() {
        com.bytedance.news.common.settings.e.a((com.bytedance.news.common.settings.f) ZeusTransformUtils.preCheckCast(this, com.bytedance.news.common.settings.f.class, "com.obric.memorydata.plugin"), false);
    }

    @Override // com.bytedance.news.common.settings.f
    public void a(com.bytedance.news.common.settings.api.e r11) {
        if (r11 == null) goto L40;
        JSONObject r12 = r11.a();
        if (r12 == null) goto L41;
        b();
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L10
        b r2 = (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        Object r13 = Result.m1421constructorimpl(new JSONObject(r12.toString()));     // Catch: Throwable -> L10
    L12:
        Throwable r3 = Result.m1424exceptionOrNullimpl(r13);
        if (r3 != null) goto L28;
        JSONObject r14 = (JSONObject) ZeusTransformUtils.preCheckCast(r13, JSONObject.class, "com.obric.memorydata.plugin");
        Iterator<String> r4 = r14.keys();
    L16:
        if (r4.hasNext() == false) goto L27;
        String r5 = (String) ZeusTransformUtils.preCheckCast(r4.next(), String.class, "com.obric.memorydata.plugin");
        Object r6 = r14.opt(r5);
        if (r6 == null) goto L16;
        String r7 = r6.toString();
        ((Map) ZeusTransformUtils.preCheckCast(this.c, Map.class, "com.obric.memorydata.plugin")).put(r5, r7);
        if (this.e.contains(r5) == true) goto L22;
        IStore r8 = this.f11854b;
        if (r8 == null) goto L26;
        Intrinsics.checkNotNull(r5);
        r8.save(r5, r7);
    L26:
        RunLog.INSTANCE.debug(this.f11853a, "onSettingsUpdate key = " + r5 + " : " + r7);
        goto L16
    L22:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), this.f11853a, "ignore cache settings key = " + r5, false, 4, null);
        goto L16
    L27:
        return;
    L28:
        RunLog.INSTANCE.warn(this.f11853a, "onSettingsUpdate: snapshot appSettings failed, skip update", r3);
        return;
    L10:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r13 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L12
    L41:
        return;
    }
}
