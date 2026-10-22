package com.obric.memorydata.datacollect;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.memorydata.ability.data.p;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.store.IStore;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.obric.memorydata.utils.threadpool.ThreadPoolContainer;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0017\u001a\u00020\u0018J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0018\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\bH\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001f"}, d2 = {"Lcom/obric/memorydata/datacollect/AppActivityCollect;", "Lcom/obric/memorydata/ability/IAbilityDataReceiver;", "<init>", "()V", "TAG", "", "PRE_TIMESTAMP_KEY", "QUERY_DATA_MIN_INTERVAL", "", "EVENT_DATA_AUTHORITY_URI", "Landroid/net/Uri;", "DATA_KEY_DATA_ID", "DATA_KEY_CONTENT", "DATA_KEY_TIMESTAMP", "preTimeStamp", "isQuerying", "", "store", "Lcom/obric/memorydata/middleware/api/store/IStore;", "getStore", "()Lcom/obric/memorydata/middleware/api/store/IStore;", "store$delegate", "Lkotlin/Lazy;", "startCollect", "", "onDataReceive", "data", "Lcom/obric/memorydata/ability/data/IStandardData;", "collectDataFromOsTracker", "startTime", "currentTime", "data_collect_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c implements com.obric.memorydata.ability.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f9683a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Uri f9684b = null;
    private static long c;
    private static volatile boolean d;
    private static final Lazy e = null;

    static {
        f9683a = new c();
        Uri r0 = Uri.parse("content://os.teatracker/event_data");
        Intrinsics.checkNotNullExpressionValue(r0, "parse(...)");
        f9684b = r0;
        c = -1;
        e = LazyKt.lazy($$Lambda$c$81xgXM3_ukuyRwOifq_J7ZuS45U.INSTANCE);
    }

    private c() {
    }

    private static final void a(long r9) {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AppActivityCollect", "begin to query from tracker", false, 4, null);
        c r0 = f9683a;
        r0.a(c, r9);
        c = r9;
        r0.c().save("preQueryAppActivityTime", c);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AppActivityCollect", "query end of : " + c, false, 4, null);
        d = false;
    }

    private final synchronized void a(long r26, long r28) {
        monitor-enter(this);
        long r0 = r26;
    L5:
        if (r0 >= r28) goto L56;
    L50:
        th = move-exception;
        RunLog.INSTANCE.error("AppActivityCollect", "collectDataFromOsTracker error", th);     // Catch: Throwable -> L53
    L53:
        th = move-exception;
        throw th;
    L7:
        if ((TimeUnit.HOURS.toMillis(2) + r0) <= r28) goto L9;
        long r2 = r28;
    L10:
        Closeable r5 = (Closeable) ZeusTransformUtils.preCheckCast(ZeusProviderTransform.query(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver(), f9684b, new String[]{"timestamp", Params.CONTENT}, "data_id = ? AND timestamp >= ? AND timestamp < ?", new String[]{"ACTIVITY_SWITCH", String.valueOf(r0), String.valueOf(r2)}, "timestamp ASC", "com.obric.memorydata.plugin"), Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L50
        Cursor r6 = (Cursor) ZeusTransformUtils.preCheckCast(r5, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L43
        if (r6 != null) goto L15;
    L17:
        boolean r7 = false;
    L18:
        if (r7 == true) goto L20;
    L40:
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L43
        CloseableKt.closeFinally(r5, null);     // Catch: Throwable -> L50
        r0 = r2;
    L20:
        if (r6.moveToNext() == false) goto L40;
        long r16 = r6.getLong(r6.getColumnIndex("timestamp"));     // Catch: Throwable -> L43
        String r8 = r6.getString(r6.getColumnIndex(Params.CONTENT));     // Catch: Throwable -> L43
        if (r8 != null) goto L24;
        r8 = "";
    L24:
        JSONObject r9 = new JSONObject(r8);     // Catch: Throwable -> L43
        int r10 = r9.optInt("EventType", 0);     // Catch: Throwable -> L43
        String r11 = r9.optString("PACKAGE_NAME");     // Catch: Throwable -> L43
        String r12 = r9.optString("ACTIVITY_NAME");     // Catch: Throwable -> L43
        if (r16 < 0) goto L20;
        if (r10 == 1) goto L28;
        if (r10 != 2) goto L20;
    L28:
        Intrinsics.checkNotNull(r11);     // Catch: Throwable -> L43
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L31;
        boolean r13 = true;
    L32:
        if (r13 == true) goto L20;
        Intrinsics.checkNotNull(r12);     // Catch: Throwable -> L43
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L36;
        boolean r14 = true;
    L37:
        if (r14 == true) goto L20;
        MemoryDbEngine.INSTANCE.getGlobalDbEngine().getAppActivityDao().insert(new com.obric.memorydata.database.entity.l(100001001, 1, r16, r10, r11, r12, 0, 64, null));     // Catch: Throwable -> L43
        goto L20
    L36:
        r14 = false;
        goto L37
    L31:
        r13 = false;
        goto L32
    L15:
        if (r6.moveToFirst() != true) goto L17;
        r7 = true;
        goto L18
    L43:
        th = move-exception;
        throw th;     // Catch: Throwable -> L46
    L46:
        th = move-exception;
        CloseableKt.closeFinally(r5, th);     // Catch: Throwable -> L50
        throw th;     // Catch: Throwable -> L50
    L9:
        r2 = TimeUnit.HOURS.toMillis(2) + r0;     // Catch: Throwable -> L50
    L56:
        monitor-exit(this);
    }

    private final IStore c() {
        return (IStore) ZeusTransformUtils.preCheckCast(e.getValue(), IStore.class, "com.obric.memorydata.plugin");
    }

    private static final IStore d() {
        return IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null);
    }

    public static /* synthetic */ IStore lambda$81xgXM3_ukuyRwOifq_J7ZuS45U() {
        return d();
    }

    public static /* synthetic */ void lambda$IlpkRfjs7JVyOiD7NeAdGFLffRU(long r0) {
        a(r0);
    }

    @Override // com.obric.memorydata.ability.k
    public void a(com.obric.memorydata.ability.data.h r6) {
        com.obric.memorydata.ability.data.h r5 = (com.obric.memorydata.ability.data.h) ZeusTransformUtils.wrapperContextForParams(r6, com.obric.memorydata.ability.data.h.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "data");
        if (ZeusTransformUtils.instanceOf(r5, p.class) == false) goto L12;
        final long r1 = System.currentTimeMillis();
        if (Intrinsics.areEqual(((p) ZeusTransformUtils.preCheckCast(r5, p.class, "com.obric.memorydata.plugin")).a(), com.tom_roush.pdfbox.pdmodel.a.d.f.g) == true) goto L7;
        return;
    L7:
        if ((r1 - c) > TimeUnit.HOURS.toMillis(2)) goto L9;
        return;
    L9:
        if (d == true) goto L15;
        d = true;
        ThreadPoolContainer.Companion.getInstance().execute(new $$Lambda$c$IlpkRfjs7JVyOiD7NeAdGFLffRU(r1));
        return;
    L15:
        return;
    }

    public final void b() {
        long r0 = IStore.a.a(c(), "preQueryAppActivityTime", 0, 2, null);
        if (r0 <= 0) goto L5;
        c = r0;
    L6:
        new com.obric.memorydata.ability.d().a(new com.obric.memorydata.ability.f(100000005, MapsKt.mapOf(TuplesKt.to("mode", com.tom_roush.pdfbox.pdmodel.a.d.f.g))), (com.obric.memorydata.ability.k) ZeusTransformUtils.preCheckCast(this, com.obric.memorydata.ability.k.class, "com.obric.memorydata.plugin"));
        return;
    L5:
        c = System.currentTimeMillis();
        c().save("preQueryAppActivityTime", c);
        goto L6
    }

    @Override // com.obric.memorydata.ability.k
    public String g_() {
        return com.obric.memorydata.ability.k.a.a(this);
    }
}
