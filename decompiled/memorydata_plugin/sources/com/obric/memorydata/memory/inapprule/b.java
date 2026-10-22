package com.obric.memorydata.memory.inapprule;

import android.os.Bundle;
import android.support.v4.media.session.PlaybackStateCompat;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.database.entity.ca;
import com.obric.memorydata.memory.AutoMemoryConfig;
import com.obric.memorydata.memory.g;
import com.obric.memorydata.memory.ui.settings.l;
import com.obric.memorydata.memory.y;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.logging.e;
import com.obric.memorydata.middleware.api.logging.f;
import com.obric.memorydata.middleware.api.logging.o;
import com.obric.memorydata.middleware.api.logging.t;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.bx;
import kotlinx.coroutines.cu;
import kotlinx.coroutines.flow.ae;
import kotlinx.coroutines.flow.ar;
import kotlinx.coroutines.flow.at;
import kotlinx.coroutines.flow.k;
import kotlinx.coroutines.i;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000u\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000*\u0001\u001f\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010!\u001a\u00020\"J\u000e\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\fJ\u0006\u0010%\u001a\u00020\"J\u0016\u0010&\u001a\u00020\"2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(H\u0002J\u0006\u0010*\u001a\u00020\fJ\u0010\u0010+\u001a\u00020\"2\b\b\u0002\u0010,\u001a\u00020\fJ\b\u0010-\u001a\u00020\fH\u0002J\b\u0010.\u001a\u00020\"H\u0002J\u0010\u0010/\u001a\u00020\f2\u0006\u00100\u001a\u00020\u001bH\u0002J\u0010\u00101\u001a\u00020\"2\u0006\u00102\u001a\u000203H\u0002J\u0010\u00104\u001a\u00020\"2\u0006\u00102\u001a\u000203H\u0002J\u0010\u00105\u001a\u0002032\u0006\u00106\u001a\u000207H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010 ¨\u00068"}, d2 = {"Lcom/obric/memorydata/memory/inapprule/InAppRuleManager;", "", "<init>", "()V", "log", "Lcom/obric/memorydata/middleware/api/logging/ModuleLogger;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "started", "Ljava/util/concurrent/atomic/AtomicBoolean;", "ready", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "available", "Lkotlinx/coroutines/flow/StateFlow;", "getAvailable", "()Lkotlinx/coroutines/flow/StateFlow;", "cacheGeneration", "", "nextCacheGeneration", "desired", "Lcom/obric/memorydata/memory/InAppL1LocalRuleCatalog;", "published", "previous", "enabled", "callbackRegistered", "lastIndexVersion", "", "retryJob", "Lkotlinx/coroutines/Job;", "callback", "com/obric/memorydata/memory/inapprule/InAppRuleManager$callback$1", "Lcom/obric/memorydata/memory/inapprule/InAppRuleManager$callback$1;", CommonConsts.APM_INNER_EVENT_COST_START, "", "setCacheEnabled", "needed", "refresh", "rebuild", "rows", "", "Lcom/obric/memorydata/database/entity/InAppL1RuleEntity;", "enable", "disable", "releaseCache", "publish", "scheduleRetry", "allowed", ObricMemoryConstants.KEY_PACKAGE_NAME, "dispatch", "extras", "Landroid/os/Bundle;", "respond", "ownerAction", "action", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f10150a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final o f10151b = null;
    private static final al c = null;
    private static final AtomicBoolean d = null;
    private static final ae<Boolean> e = null;
    private static final ar<Boolean> f = null;
    private static final ae<Long> g = null;
    private static long h;
    private static volatile g i;
    private static volatile g j;
    private static volatile g k;
    private static volatile boolean l;
    private static boolean m;
    private static String n;
    private static bx o;
    private static final InAppRuleManager$callback$1 p = null;

    /* JADX WARN: Type inference failed for: r0v5, types: [com.obric.memorydata.memory.inapprule.InAppRuleManager$callback$1] */
    static {
        f10150a = new b();
        f10151b = t.f11635a.a("InAppRuleManager");
        c = am.a(cu.a(null, 1, null).plus((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin")));
        d = new AtomicBoolean(false);
        ae<Boolean> r1 = at.a(false);
        e = r1;
        f = k.a(r1);
        g = at.a(null);
        p = new InAppRuleManager$callback$1();
    }

    private b() {
    }

    private final Bundle a(int r2) {
        Bundle r1 = new Bundle();
        r1.putInt(ObricMemoryConstants.IN_APP_KEY_ACTION, r2);
        r1.putInt(ObricMemoryConstants.IN_APP_KEY_PROTOCOL_VERSION, 1);
        return r1;
    }

    private static final Unit a(boolean r1, g r2, com.obric.memorydata.middleware.api.logging.g r3) {
        Intrinsics.checkNotNullParameter(r3, "$this$mainTrace");
        r3.a("accepted", Boolean.valueOf(r1));
        if (r2 == null) goto L7;
        ArrayList<Bundle> r4 = r2.b();
        if (r4 == null) goto L7;
        int r5 = r4.size();
    L8:
        r3.a("activity_count", Integer.valueOf(r5));
        return Unit.INSTANCE;
    L7:
        r5 = 0;
        goto L8
    }

    private final void a(Bundle r7) {
        String r8 = r7.getString(ObricMemoryConstants.IN_APP_KEY_L1_EVENT_JSON);
        if (r8 != null) goto L18;
        return;
    L18:
        JSONObject r1 = new JSONObject(r8);     // Catch: JSONException -> L16
        String r2 = r1.optString(ObricMemoryConstants.KEY_PACKAGE_NAME);     // Catch: JSONException -> L16
        Intrinsics.checkNotNull(r2);     // Catch: JSONException -> L16
        if (a(r2) == true) goto L8;
        return;
    L8:
        g r6 = i;     // Catch: JSONException -> L16
        if (r6 == null) goto L15;
        String r3 = r1.optString("activityName");     // Catch: JSONException -> L16
        Intrinsics.checkNotNullExpressionValue(r3, "optString(...)");     // Catch: JSONException -> L16
        String r4 = r1.optString("ruleId");     // Catch: JSONException -> L16
        Intrinsics.checkNotNullExpressionValue(r4, "optString(...)");     // Catch: JSONException -> L16
        String r5 = r1.optString("eventType");     // Catch: JSONException -> L16
        Intrinsics.checkNotNullExpressionValue(r5, "optString(...)");     // Catch: JSONException -> L16
        g.e r9 = r6.a(r2, r3, r4, r5);     // Catch: JSONException -> L16
        if (r9 == null) goto L20;
        com.obric.memorydata.memory.d.f10110a.a(r8, r9);     // Catch: JSONException -> L16
        return;
    L20:
        return;
    L15:
        return;
    L16:
        f10151b.a("invalid_event", "规则事件解析失败", new e(null, null, null, 7, null), new com.obric.memorydata.middleware.api.logging.g().a());
    }

    public static final /* synthetic */ void a(b r0, Bundle r1) {
        r0.b(r1);
    }

    public static final /* synthetic */ void a(b r2, List r3) {
        r2.a((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    public static /* synthetic */ void a(b r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = true;
    L5:
        r0.b(r1);
    }

    private final synchronized void a(List<ca> r15) {
        monitor-enter(this);
        List r16 = (List) ZeusTransformUtils.wrapperContextForParams(r15, List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L50
        Set r0 = (Set) ZeusTransformUtils.preCheckCast(l.f11479a.a().i().c(), Set.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L50
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(y.f11594a.a().getSmartMemoryPackages(), Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L50
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L50
        Iterator r3 = r1.iterator();     // Catch: Throwable -> L50
    L4:
        boolean r4 = true;
        if (r3.hasNext() == false) goto L9;
        Object r5 = r3.next();     // Catch: Throwable -> L50
        if ((true ^ ((AutoMemoryConfig.SmartMemoryPackage) ZeusTransformUtils.preCheckCast(r5, AutoMemoryConfig.SmartMemoryPackage.class, "com.obric.memorydata.plugin")).getNoNeedA11y()) == false) goto L4;
        r2.add(r5);     // Catch: Throwable -> L50
        goto L4
    L9:
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L50
        Collection r7 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10)), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L50
        Iterator r8 = r6.iterator();     // Catch: Throwable -> L50
    L11:
        if (r8.hasNext() == false) goto L13;
        r7.add(((AutoMemoryConfig.SmartMemoryPackage) ZeusTransformUtils.preCheckCast(r8.next(), AutoMemoryConfig.SmartMemoryPackage.class, "com.obric.memorydata.plugin")).getPackageName());     // Catch: Throwable -> L50
        goto L11
    L13:
        Set r9 = CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L50
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(r16, Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L50
        Collection r11 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L50
        Iterator r12 = r10.iterator();     // Catch: Throwable -> L50
    L14:
        boolean r13 = false;
        g r14 = null;
        if (r12.hasNext() == false) goto L25;
        Object r17 = r12.next();     // Catch: Throwable -> L50
        ca r18 = (ca) ZeusTransformUtils.preCheckCast(r17, ca.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L50
        if (r9.contains(r18.a()) == true) goto L19;
    L23:
        if (r13 == false) goto L14;
        r11.add(r17);     // Catch: Throwable -> L50
        goto L14
    L19:
        if (r0.contains(r18.a()) == false) goto L23;
        String r19 = new JSONArray(r18.h()).toString();     // Catch: Throwable -> L50
        Intrinsics.checkNotNullExpressionValue(r19, "toString(...)");     // Catch: Throwable -> L50
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r19, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("\"auto_memory\"", CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == false) goto L23;
        r13 = true;
        goto L23
    L25:
        List<ca> r20 = (List) ZeusTransformUtils.preCheckCast(r11, List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L50
    L31:
        o r21 = f10151b;     // Catch: Throwable -> L50
        String r22 = "invalid_schema";
        e r23 = new e(null, null, null, 7, null);     // Catch: Throwable -> L50
        f r24 = new com.obric.memorydata.middleware.api.logging.g().a();     // Catch: Throwable -> L50
        String r25 = "规则快照校验失败";
    L32:
        r21.a(r22, r25, r23, r24);     // Catch: Throwable -> L50
    L34:
        i = r14;     // Catch: Throwable -> L50
        o r26 = f10151b;     // Catch: Throwable -> L50
        e r27 = new e(null, null, null, 7, null);     // Catch: Throwable -> L50
        if (AppContext.INSTANCE.isDebug() == false) goto L41;
        com.obric.memorydata.middleware.api.logging.g r28 = new com.obric.memorydata.middleware.api.logging.g();     // Catch: Throwable -> L50
        r28.a("row_count", Integer.valueOf(r16.size()));     // Catch: Throwable -> L50
        r28.a("selected_count", Integer.valueOf(r20.size()));     // Catch: Throwable -> L50
        r28.a("enabled_app_count", Integer.valueOf(r0.size()));     // Catch: Throwable -> L50
        if (i == null) goto L39;
        boolean r29 = true;
    L40:
        r28.a("ready", Boolean.valueOf(r29));     // Catch: Throwable -> L50
        Unit r110 = Unit.INSTANCE;     // Catch: Throwable -> L50
        r26.a("InApp 规则快照已刷新", r27, r28.a());     // Catch: Throwable -> L50
        goto L41
    L39:
        r29 = false;
    L41:
        ae<Boolean> r111 = e;     // Catch: Throwable -> L50
        if (i != null) goto L45;
        r4 = false;
    L45:
        r111.b(Boolean.valueOf(r4));     // Catch: Throwable -> L50
        if (l == false) goto L48;
        f();     // Catch: Throwable -> L50
    L48:
        monitor-exit(this);
        return;
    L33:
        r21 = f10151b;     // Catch: Throwable -> L50
        r22 = "invalid_json";
        r23 = new e(null, null, null, 7, null);     // Catch: Throwable -> L50
        r24 = new com.obric.memorydata.middleware.api.logging.g().a();     // Catch: Throwable -> L50
        r25 = "规则快照解析失败";
        goto L32
    L27:
        if (r20.isEmpty() == true) goto L34;
        r14 = g.f10124a.a(a.f10149a.b(r20));     // Catch: IllegalArgumentException -> L31 JSONException -> L33 Throwable -> L50
    L50:
        th = move-exception;
        throw th;
    }

    public static final /* synthetic */ boolean a(b r0) {
        return r0.f();
    }

    private final boolean a(String r1) {
        if (l == true) goto L5;
    L7:
        return false;
    L5:
        if (com.obric.memorydata.memory.b.f10076a.a(r1) == false) goto L7;
        return true;
    }

    private final void b(Bundle r22) {
        String r3 = r22.getString(ObricMemoryConstants.IN_APP_KEY_REQUEST_ID);
        String r4 = "";
        if (r3 != null) goto L6;
        r3 = "";
    L6:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L8;
        boolean r5 = true;
    L9:
        if (r5 == false) goto L11;
        return;
    L11:
        String r8 = r22.getString(ObricMemoryConstants.IN_APP_KEY_PACKAGE_NAME);
        if (r8 != null) goto L14;
        r8 = "";
    L14:
        String r9 = r22.getString(ObricMemoryConstants.IN_APP_KEY_ACTIVITY_NAME);
        if (r9 != null) goto L17;
        String r15 = "";
    L18:
        String r10 = r22.getString(ObricMemoryConstants.IN_APP_KEY_ACTIVITY_RULE_VERSION);
        if (r10 == null) goto L22;
        r4 = r10;
    L22:
        int r11 = r22.getInt(ObricMemoryConstants.IN_APP_KEY_ENGINE_VERSION, -1);
        long r17 = r22.getLong(ObricMemoryConstants.IN_APP_KEY_APP_VERSION_CODE, -1);
        if (a(r8) == false) goto L33;
        g r12 = j;
        if (r12 == null) goto L29;
        int r1 = r11;
        String r7 = ObricMemoryConstants.IN_APP_KEY_ACTIVITY_RULE_VERSION;
        String r20 = ObricMemoryConstants.IN_APP_KEY_ENGINE_VERSION;
        String r6 = ObricMemoryConstants.IN_APP_KEY_ACTIVITY_NAME;
        String r19 = r15;
        String r13 = r12.a(r8, r15, r1, r4, r17);
        if (r13 == null) goto L30;
    L35:
        int r14 = 2;
        if (r13 != null) goto L38;
    L43:
        r13 = null;
    L44:
        com.obric.memorydata.utils.c.c r16 = com.obric.memorydata.utils.c.c.f13202a;
        Bundle r0 = a(4);
        r0.putString(ObricMemoryConstants.IN_APP_KEY_REQUEST_ID, r3);
        if (r13 == null) goto L48;
        r14 = 1;
    L48:
        r0.putInt(ObricMemoryConstants.IN_APP_KEY_RESULT_CODE, r14);
        if (r13 == null) goto L51;
        Bundle r2 = new Bundle();
        r2.putString(ObricMemoryConstants.IN_APP_KEY_PACKAGE_NAME, r8);
        r2.putString(r6, r19);
        r2.putString(r7, r4);
        r2.putInt(r20, r1);
        r2.putString(ObricMemoryConstants.IN_APP_KEY_ACTIVITY_RULE_JSON, r13);
        Unit r18 = Unit.INSTANCE;
        r0.putBundle(ObricMemoryConstants.IN_APP_KEY_RULE_BUNDLE, r2);
    L51:
        Unit r21 = Unit.INSTANCE;
        r16.a(3, r0);
        return;
    L38:
        if ((((long) r13.length()) * ((long) 2)) > PlaybackStateCompat.ACTION_SET_REPEAT_MODE) goto L40;
        boolean r110 = true;
    L41:
        if (r110 == false) goto L43;
    L40:
        r110 = false;
    L30:
        g r23 = k;
        if (r23 == null) goto L34;
        r13 = r23.a(r8, r19, r1, r4, r17);
    L34:
        r13 = null;
        goto L35
    L29:
        r1 = r11;
        r20 = ObricMemoryConstants.IN_APP_KEY_ENGINE_VERSION;
        r7 = ObricMemoryConstants.IN_APP_KEY_ACTIVITY_RULE_VERSION;
        r6 = ObricMemoryConstants.IN_APP_KEY_ACTIVITY_NAME;
        r19 = r15;
        goto L30
    L33:
        r1 = r11;
        r20 = ObricMemoryConstants.IN_APP_KEY_ENGINE_VERSION;
        r7 = ObricMemoryConstants.IN_APP_KEY_ACTIVITY_RULE_VERSION;
        r6 = ObricMemoryConstants.IN_APP_KEY_ACTIVITY_NAME;
        r19 = r15;
        goto L34
    L17:
        r15 = r9;
        goto L18
    L8:
        r5 = false;
        goto L9
    }

    public static final /* synthetic */ void b(b r0, Bundle r1) {
        r0.a(r1);
    }

    public static final /* synthetic */ ae e() {
        return g;
    }

    private final synchronized boolean f() {
        monitor-enter(this);
    L39:
        th = move-exception;
        throw th;
    L4:
        if (m == true) goto L16;
        if (l == true) goto L9;
        monitor-exit(this);
        return true;
    L9:
        boolean r0 = com.obric.memorydata.utils.c.c.f13202a.a(3, (com.obric.memorydata.utils.c.c.a) ZeusTransformUtils.preCheckCast(p, com.obric.memorydata.utils.c.c.a.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L39
        m = r0;     // Catch: Throwable -> L39
        if (r0 == true) goto L16;
        g();     // Catch: Throwable -> L39
        monitor-exit(this);
        return false;
    L16:
        if (l == false) goto L18;
        final g r1 = i;     // Catch: Throwable -> L39
    L19:
        if (r1 == null) goto L22;
        String r3 = r1.a();     // Catch: Throwable -> L39
        if (r3 == null) goto L22;
    L24:
        if (Intrinsics.areEqual(n, r3) == false) goto L27;
        monitor-exit(this);
        return true;
    L27:
        g r4 = j;     // Catch: Throwable -> L39
        k = r4;     // Catch: Throwable -> L39
        j = r1;     // Catch: Throwable -> L39
        com.obric.memorydata.utils.c.c r5 = com.obric.memorydata.utils.c.c.f13202a;     // Catch: Throwable -> L39
        Bundle r2 = a(1);     // Catch: Throwable -> L39
        r2.putString(ObricMemoryConstants.IN_APP_KEY_GLOBAL_VERSION, r3);     // Catch: Throwable -> L39
        if (r1 == null) goto L31;
        ArrayList<Bundle> r7 = r1.b();     // Catch: Throwable -> L39
        if (r7 == null) goto L31;
    L32:
        r2.putParcelableArrayList(ObricMemoryConstants.IN_APP_KEY_ACTIVITY_INDEX, r7);     // Catch: Throwable -> L39
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L39
        final boolean r8 = r5.a(3, r2);     // Catch: Throwable -> L39
        if (r8 == false) goto L35;
        n = r3;     // Catch: Throwable -> L39
    L36:
        o.a(f10151b, "InApp 规则索引下发完成", "rule_index_dispatched", null, new $$Lambda$b$bod0IpEF8JKWt8sJtDJ9Y6KGix0(r8, r1), null, 20, null);     // Catch: Throwable -> L39
        monitor-exit(this);
        return r8;
    L35:
        j = r4;     // Catch: Throwable -> L39
        g();     // Catch: Throwable -> L39
    L31:
        r7 = new ArrayList();     // Catch: Throwable -> L39
    L22:
        r3 = "empty";
        goto L24
    L18:
        r1 = null;
        goto L19
    }

    private final synchronized void g() {
        monitor-enter(this);
        bx r0 = o;     // Catch: Throwable -> L15
        boolean r1 = true;
        if (r0 != null) goto L6;
    L8:
        r1 = false;
    L9:
        if (r1 == false) goto L12;
        monitor-exit(this);
        return;
    L12:
        o = i.a(c, null, null, (Function2) ZeusTransformUtils.preCheckCast(new InAppRuleManager$scheduleRetry$1(null), Function2.class, "com.obric.memorydata.plugin"), 3, null);     // Catch: Throwable -> L15
        monitor-exit(this);
        return;
    L6:
        if (r0.a() != true) goto L8;
    L15:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ Unit lambda$bod0IpEF8JKWt8sJtDJ9Y6KGix0(boolean r0, g r1, com.obric.memorydata.middleware.api.logging.g r2) {
        return a(r0, r1, r2);
    }

    public final ar<Boolean> a() {
        return f;
    }

    public final synchronized void a(boolean r5) {
        monitor-enter(this);
        if (r5 == false) goto L7;
        ae<Long> r6 = g;     // Catch: Throwable -> L10
        if (r6.c() != null) goto L8;
        long r0 = h + 1;     // Catch: Throwable -> L10
        h = r0;     // Catch: Throwable -> L10
        r6.b(Long.valueOf(r0));     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);
        return;
    L7:
        a(this, false, 1, null);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public final void b() {
        if (d.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        i.a(c, null, null, (Function2) ZeusTransformUtils.preCheckCast(new InAppRuleManager$start$1(null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    public final synchronized void b(boolean r3) {
        monitor-enter(this);
        l = false;     // Catch: Throwable -> L12
        if (r3 == false) goto L8;
        g.b(null);     // Catch: Throwable -> L12
        i = null;     // Catch: Throwable -> L12
        j = null;     // Catch: Throwable -> L12
        k = null;     // Catch: Throwable -> L12
        e.b(false);     // Catch: Throwable -> L12
        com.obric.memorydata.memory.d.f10110a.a();     // Catch: Throwable -> L12
    L8:
        if (m == false) goto L10;
        f();     // Catch: Throwable -> L12
    L10:
        monitor-exit(this);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public final void c() {
        Long r10 = (Long) ZeusTransformUtils.preCheckCast(g.c(), Long.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L6;
        long r2 = r10.longValue();
        i.a(c, null, null, (Function2) ZeusTransformUtils.preCheckCast(new InAppRuleManager$refresh$1(r2, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        return;
    }

    public final synchronized boolean d() {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (i != null) goto L9;
        monitor-exit(this);
        return false;
    L9:
        l = true;     // Catch: Throwable -> L12
        f();     // Catch: Throwable -> L12
        monitor-exit(this);
        return true;
    }
}
