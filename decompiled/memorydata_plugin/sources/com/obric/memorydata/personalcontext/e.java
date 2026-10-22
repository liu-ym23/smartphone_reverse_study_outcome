package com.obric.memorydata.personalcontext;

import android.app.Application;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.obric.capabilitykit.apphost.AppHost;
import com.obric.capabilitykit.entity.app.EntityType;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.device.DeviceInfoState;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.personalcontext.task.EntityConsistencyCheckTask;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.cu;
import kotlinx.coroutines.w;
import kotlinx.coroutines.y;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0012H\u0007J\u000e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0003J\u0006\u0010\u001a\u001a\u00020\u000fJ\u0010\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u0005H\u0002J\u0010\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u0005H\u0002J\u0018\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00112\u0006\u0010\"\u001a\u00020#H\u0002J\u0010\u0010$\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020#H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u001f\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110 X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/obric/memorydata/personalcontext/DomainLocalDataSearchManager;", "", "<init>", "()V", "AUTHORITY", "", "PATH_LOCAL_DATA_SEARCH_DOMAIN", "CONTENT_URI", "Landroid/net/Uri;", "COLUMN_ENABLED_DOMAIN", "TAG", "scope", "Lkotlinx/coroutines/CoroutineScope;", "initDeferred", "Lkotlinx/coroutines/CompletableDeferred;", "", "enabledEntityTypes", "", "", "observer", "Landroid/database/ContentObserver;", "isControl", "", "isAllowDonate", "entityType", "getEnabledEntityTypes", CommonConsts.APM_INNER_EVENT_COST_INIT, "realInit", "initReason", "refreshPermissionState", InfoRequestQPSOptTraceLogger.REASON, "DOMAIN_TO_ENTITY_TYPES", "", "queryEnabledEntityTypes", "context", "Landroid/content/Context;", "stopObserving", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f12095a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Uri f12096b = null;
    private static final al c = null;
    private static final w<Unit> d = null;
    private static volatile Set<Integer> e;
    private static volatile ContentObserver f;
    private static final boolean g = false;
    private static final Map<String, Set<Integer>> h = null;

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"com/obric/memorydata/personalcontext/DomainLocalDataSearchManager$init$listener$1", "Lcom/obric/memorydata/middleware/api/app/AgreePrivacyListener;", "onAgree", "", "onDisagree", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements com.obric.memorydata.middleware.api.app.a {
        a() {
        }

        @Override // com.obric.memorydata.middleware.api.app.a
        public void a() {
            e.a(e.f12095a, "init_sync_agree_privacy");
        }

        @Override // com.obric.memorydata.middleware.api.app.a
        public void b() {
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/memorydata/personalcontext/DomainLocalDataSearchManager$realInit$observer$1", "Landroid/database/ContentObserver;", "onChange", "", "selfChange", "", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b extends ContentObserver {
        b() {
            super(null);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean r7) {
            kotlinx.coroutines.i.a(e.c(), null, null, (Function2) ZeusTransformUtils.preCheckCast(new DomainLocalDataSearchManager$realInit$observer$1$onChange$1(null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        }
    }

    static {
        f12095a = new e();
        f12096b = Uri.parse("content://com.obric.assistant.provider.ObricLocalDataSearchDomainProvider/local_data_search_domain");
        c = am.a(cu.a(null, 1, null).plus((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin")));
        d = y.a(null, 1, null);
        e = SetsKt.emptySet();
        g = Intrinsics.areEqual(DeviceInfoState.INSTANCE.getDeviceModel(), "Genesis-R");
        h = MapsKt.mapOf(new Pair[]{TuplesKt.to("call_logs", SetsKt.setOf(202)), TuplesKt.to("contacts", SetsKt.setOf(201)), TuplesKt.to("message", SetsKt.setOf(101)), TuplesKt.to("clock", SetsKt.setOf(701)), TuplesKt.to("notes", SetsKt.setOf(601)), TuplesKt.to("album", SetsKt.setOf(new Integer[]{301, 302, 303})), TuplesKt.to("record", SetsKt.setOf(new Integer[]{501, 502})), TuplesKt.to("file_management", SetsKt.setOf(Integer.valueOf(EntityType.FILE))), TuplesKt.to("calendar", SetsKt.setOf(new Integer[]{401, 402}))});
    }

    private e() {
    }

    private final Set<Integer> a(Context r10) {
        Cursor r11 = ZeusProviderTransform.query(((Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin")).getContentResolver(), f12096b, new String[]{"enabled_domain"}, null, null, null, "com.obric.memorydata.plugin");     // Catch: Throwable -> L32
        if (r11 != null) goto L7;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "DomainLocalDataSearchManager", "queryEnabledEntityTypes cursor is null", null, 4, null);     // Catch: Throwable -> L32
        return null;
    L7:
        Closeable r12 = (Closeable) ZeusTransformUtils.preCheckCast(r11, Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L32
        Cursor r2 = (Cursor) ZeusTransformUtils.preCheckCast(r12, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L27
        int r9 = r2.getColumnIndex("enabled_domain");     // Catch: Throwable -> L27
        if (r9 >= 0) goto L11;
        Set<Integer> r13 = SetsKt.emptySet();     // Catch: Throwable -> L27
    L25:
        CloseableKt.closeFinally(r12, null);     // Catch: Throwable -> L32
        return r13;
    L11:
        Set<Integer> r3 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L27
    L13:
        if (r2.moveToNext() == false) goto L22;
        String r4 = r2.getString(r9);     // Catch: Throwable -> L27
        if (r4 == null) goto L13;
        Set r5 = (Set) ZeusTransformUtils.preCheckCast(h.get(r4), Set.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L27
        if (r5 == null) goto L13;
        r3.addAll((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L27
        goto L13
    L22:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L24;
        r3.add(902);     // Catch: Throwable -> L27
        r3.add(901);     // Catch: Throwable -> L27
    L24:
        r13 = r3;
    L27:
        th = move-exception;
        throw th;     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        CloseableKt.closeFinally(r12, th);     // Catch: Throwable -> L32
        throw th;     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        RunLog.INSTANCE.warn("DomainLocalDataSearchManager", "queryEnabledEntityTypes failed", th);
        return null;
    }

    public static final /* synthetic */ void a(e r0, String r1) {
        r0.a(r1);
    }

    private final void a(String r8) {
        kotlinx.coroutines.i.a(c, null, null, (Function2) ZeusTransformUtils.preCheckCast(new DomainLocalDataSearchManager$realInit$1(r8, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        Context r7 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppHost.Companion.getApplication(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin")).getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        b r9 = new b();
        ZeusProviderTransform.registerContentObserver(r7.getContentResolver(), f12096b, false, (ContentObserver) ZeusTransformUtils.preCheckCast(r9, ContentObserver.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        f = (ContentObserver) ZeusTransformUtils.preCheckCast(r9, ContentObserver.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ w b() {
        return d;
    }

    public static final /* synthetic */ void b(e r0, String r1) {
        r0.b(r1);
    }

    private final synchronized void b(String r9) {
        monitor-enter(this);
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppHost.Companion.getApplication(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin")).getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L18
        Intrinsics.checkNotNull(r0);     // Catch: Throwable -> L18
        Set<Integer> r1 = a(r0);     // Catch: Throwable -> L18
        if (r1 != null) goto L9;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "DomainLocalDataSearchManager", "refreshPermissionState query failed, keep last value, reason=" + r9, null, 4, null);     // Catch: Throwable -> L18
        monitor-exit(this);
        return;
    L9:
        if (Intrinsics.areEqual(r1, e) == false) goto L13;
        RunLog.INSTANCE.debug("DomainLocalDataSearchManager", "refreshPermissionState unchanged, reason=" + r9);     // Catch: Throwable -> L18
        monitor-exit(this);
        return;
    L13:
        e = r1;     // Catch: Throwable -> L18
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "DomainLocalDataSearchManager", "refreshPermissionState changed, reason=" + r9 + ", enabled=" + r1, false, 4, null);     // Catch: Throwable -> L18
        if (Intrinsics.areEqual(r9, "init_sync") == true) goto L16;
        EntityConsistencyCheckTask.Companion.triggerTask(true, true, true);     // Catch: Throwable -> L18
    L16:
        monitor-exit(this);
        return;
    L18:
        th = move-exception;
        throw th;
    }

    public static final /* synthetic */ al c() {
        return c;
    }

    private final Set<Integer> d() {
        kotlinx.coroutines.i.a(null, (Function2) ZeusTransformUtils.preCheckCast(new DomainLocalDataSearchManager$getEnabledEntityTypes$1(null), Function2.class, "com.obric.memorydata.plugin"), 1, null);
        RunLog.INSTANCE.debug("DomainLocalDataSearchManager", "getEnabledEntityTypes: result=" + e);
        return e;
    }

    public final void a() {
        if (g == true) goto L7;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "DomainLocalDataSearchManager", "not allow control, method return", false, 4, null);
        return;
    L7:
        if (UserSettings.INSTANCE.hasAgreePrivacy() == true) goto L9;
        a r6 = new a();
        UserSettings.INSTANCE.registerAgreePrivacyListener((com.obric.memorydata.middleware.api.app.a) ZeusTransformUtils.preCheckCast(r6, com.obric.memorydata.middleware.api.app.a.class, "com.obric.memorydata.plugin"));
        return;
    L9:
        a("init_sync");
    }

    public final boolean a(int r2) {
        if (g == true) goto L7;
        return true;
    L7:
        if (UserSettings.INSTANCE.hasAgreePrivacy() == true) goto L11;
        return false;
    L11:
        return d().contains(Integer.valueOf(r2));
    }
}
