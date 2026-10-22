package com.obric.memorydata.personalcontext.collector;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Build;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.obric.memorydata.personalcontext.api.EntityManager;
import com.obric.memorydata.personalcontext.api.PersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.cu;
import kotlinx.coroutines.flow.ad;
import kotlinx.coroutines.flow.ak;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010 \u001a\u00020!H\u0002J\u001a\u0010\"\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\n0\u0016H\u0002J\u000e\u0010#\u001a\u00020!2\u0006\u0010$\u001a\u00020%J\b\u0010&\u001a\u00020!H\u0002J\u0018\u0010'\u001a\u00020!2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0003J\u000e\u0010,\u001a\u00020!H\u0082@¢\u0006\u0002\u0010-J \u0010.\u001a\u00020!2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00050\n2\b\b\u0002\u0010$\u001a\u00020%H\u0002J\b\u00100\u001a\u00020%H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R-\u0010\u0015\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\n0\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018R!\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00050\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u001a\u001a\u0004\b\u001d\u0010\u001e¨\u00061"}, d2 = {"Lcom/obric/memorydata/personalcontext/collector/PermissionChangeWatcher;", "", "<init>", "()V", "TAG", "", "LAST_INITIALIZED_COLLECTOR_TYPES", "INIT_SYNC_DELAY_WINDOW_MS", "", "donateCollectorTags", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "eventFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "listeners", "Ljava/util/concurrent/ConcurrentHashMap;", "Landroid/app/AppOpsManager$OnOpChangedListener;", "cachedPermissions", "hasInitializedTypes", "startedAtMs", "opToPermission", "", "getOpToPermission", "()Ljava/util/Map;", "opToPermission$delegate", "Lkotlin/Lazy;", "needPermissions", "", "getNeedPermissions", "()Ljava/util/List;", "needPermissions$delegate", "setupEventProcessing", "", "createOpToPermissionMap", CommonConsts.APM_INNER_EVENT_COST_START, "needSyncConfig", "", "refreshCache", "syncWatchers", "context", "Landroid/content/Context;", "appOps", "Landroid/app/AppOpsManager;", "processPermissionChange", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "syncDataIfNeed", "last", "shouldDelayInitSync", "obric_entity_data_collector_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f12076a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Set<String> f12077b = null;
    private static final al c = null;
    private static final ad<String> d = null;
    private static final ConcurrentHashMap<String, AppOpsManager.OnOpChangedListener> e = null;
    private static volatile Set<String> f;
    private static volatile Set<String> g;
    private static volatile long h;
    private static final Lazy i = null;
    private static final Lazy j = null;

    static {
        l r0 = new l();
        f12076a = r0;
        f12077b = SetsKt.setOf(new String[]{"obric_sms_wrapper", "obric_sub_call_log", "obric_sub_message", "obric_sub_contact", "obric_file"});
        c = am.a(cu.a(null, 1, null).plus((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin")));
        d = ak.a(0, 64, null, 5, null);
        e = new ConcurrentHashMap();
        f = SetsKt.emptySet();
        g = SetsKt.emptySet();
        i = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, $$Lambda$l$MCjitJJjq_o2J1aFI7k4E7PZj0.INSTANCE);
        j = LazyKt.lazy(LazyThreadSafetyMode.NONE, $$Lambda$l$h_p4GspkyjNN0C6iyoeRN0JyqSo.INSTANCE);
        r0.e();
    }

    private l() {
    }

    public static final /* synthetic */ Object a(l r2, Continuation r3) {
        return r2.a((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    private final Object a(Continuation<? super Unit> r11) {
        Continuation r12 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT >= 23) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PermissionChangeWatcher", "processPermissionChange failed: build version=" + Build.VERSION.SDK_INT, null, 4, null);
        return Unit.INSTANCE;
    L6:
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        AppOpsManager r2 = (AppOpsManager) ZeusTransformUtils.preCheckCast(r0.getSystemService(AppOpsManager.class), AppOpsManager.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L9;
        com.obric.memorydata.utils.ak r3 = com.obric.memorydata.utils.ak.f13164a;
        String r4 = r0.getPackageName();
        Intrinsics.checkNotNullExpressionValue(r4, "getPackageName(...)");
        Set<String> r5 = CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast(r3.g(r4), Iterable.class, "com.obric.memorydata.plugin"));
        Set r6 = SetsKt.minus(r5, (Iterable) ZeusTransformUtils.preCheckCast(f, Iterable.class, "com.obric.memorydata.plugin"));
        f = r5;
        boolean r7 = true;
        if (g.contains("external_photo") == true) goto L13;
    L17:
        boolean r8 = false;
    L18:
        a(r0, r2);
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(d(), Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r10, Collection.class) == true) goto L21;
    L23:
        Iterator r13 = r10.iterator();
    L25:
        if (r13.hasNext() == false) goto L22;
        if (r6.contains((String) ZeusTransformUtils.preCheckCast(r13.next(), String.class, "com.obric.memorydata.plugin")) == false) goto L25;
    L28:
        if (r7 == false) goto L35;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PermissionChangeWatcher", "permission changed, start init", false, 4, null);
        Object r14 = kotlinx.coroutines.i.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.b(), CoroutineContext.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new PermissionChangeWatcher$processPermissionChange$3(r0, r8, null), Function2.class, "com.obric.memorydata.plugin"), r12);
        if (r14 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L33;
        return r14;
    L33:
        return Unit.INSTANCE;
    L35:
        return Unit.INSTANCE;
    L22:
        r7 = false;
        goto L28
    L21:
        if (((Collection) ZeusTransformUtils.preCheckCast(r10, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L23;
    L13:
        if (r6.contains("android.permission.READ_MEDIA_IMAGES") == false) goto L15;
    L16:
        r8 = true;
        goto L18
    L15:
        if (r6.contains("android.permission.READ_MEDIA_VIDEO") == false) goto L17;
    L9:
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ ad a() {
        return d;
    }

    private final void a(Context r8, AppOpsManager r9) {
        final String r10 = ((Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin")).getPackageName();
        Iterator<Map.Entry<String, Set<String>>> r7 = c().entrySet().iterator();
    L4:
        if (r7.hasNext() == false) goto L18;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        final String r2 = (String) ZeusTransformUtils.preCheckCast(r0.getKey(), String.class, "com.obric.memorydata.plugin");
        Set r1 = (Set) ZeusTransformUtils.preCheckCast(r0.getValue(), Set.class, "com.obric.memorydata.plugin");
        ConcurrentHashMap<String, AppOpsManager.OnOpChangedListener> r3 = e;
        boolean r4 = r3.containsKey(r2);
        boolean r5 = f.containsAll((Collection) ZeusTransformUtils.preCheckCast(r1, Collection.class, "com.obric.memorydata.plugin"));
        if (r5 == true) goto L13;
        if (r4 == true) goto L13;
        AppOpsManager.OnOpChangedListener r6 = new $$Lambda$l$5Rs5B9YiANuYgqLjQucGGVwrRNQ(r10, r2);
        r9.startWatchingMode(r2, r10, r6);     // Catch: Exception -> L11
        ((Map) ZeusTransformUtils.preCheckCast(r3, Map.class, "com.obric.memorydata.plugin")).put(r2, r6);     // Catch: Exception -> L11
    L11:
        e = move-exception;
        RunLog.INSTANCE.error("PermissionChangeWatcher", "Failed to watch op: " + r2, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    L13:
        if (r5 == false) goto L4;
        if (r4 == false) goto L4;
        AppOpsManager.OnOpChangedListener r11 = (AppOpsManager.OnOpChangedListener) ZeusTransformUtils.preCheckCast(r3.remove(r2), AppOpsManager.OnOpChangedListener.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L4;
        r9.stopWatchingMode(r11);
        goto L4
    }

    public static final /* synthetic */ void a(l r0) {
        r0.g();
    }

    public static final /* synthetic */ void a(l r2, Context r3, AppOpsManager r4) {
        r2.a((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), r4);
    }

    static /* synthetic */ void a(l r1, Set r2, boolean r3, int r4, Object r5) {
        Set<String> r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r2, Set.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L5;
        r3 = true;
    L5:
        r1.a(r6, r3);
    }

    private static final void a(String r0, String r1, String r2, String r3) {
        if (Intrinsics.areEqual(r0, r3) == true) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r2, r1) == false) goto L9;
        d.a(r2);
        return;
    }

    private final void a(Set<String> r14, boolean r15) {
        Set r13 = (Set) ZeusTransformUtils.wrapperContextForParams(r14, Set.class, "com.obric.memorydata.plugin");
        Set<String> r16 = CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast(EntityCollectorServiceImpl.INSTANCE.getInitializedCollectorTypes(), Iterable.class, "com.obric.memorydata.plugin"));
        Set r17 = SetsKt.minus(r16, (Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.memorydata.plugin"));
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r17, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, Collection.class) == true) goto L5;
    L7:
        Iterator r2 = r1.iterator();
    L9:
        if (r2.hasNext() == false) goto L6;
        if (f12077b.contains((String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.memorydata.plugin")) == false) goto L9;
        boolean r3 = true;
    L13:
        boolean r4 = EntityManager.INSTANCE.isAllEntityDonated();
        if (r3 == false) goto L18;
        if (r4 == false) goto L18;
        if (r15 == false) goto L18;
        boolean r5 = true;
    L19:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PermissionChangeWatcher", "current=" + r16 + ",newAdded=" + r17 + ",needSync=" + r5 + ":[config=" + r15 + ",changed=" + r3 + ",donated=" + r4 + ']', false, 4, null);
        if (r5 == false) goto L22;
        PersonalContextAPI.INSTANCE.triggerEntityConsistencyCheckTask(true, true, false);
    L22:
        g = r16;
        IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).save("last_initialized_collector_types", r16);
        return;
    L18:
        r5 = false;
    L6:
        r3 = false;
        goto L13
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r1, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L7;
        goto L6
    }

    public static final /* synthetic */ Set b() {
        return g;
    }

    public static final /* synthetic */ boolean b(l r0) {
        return r0.h();
    }

    private final Map<String, Set<String>> c() {
        return (Map) ZeusTransformUtils.preCheckCast(i.getValue(), Map.class, "com.obric.memorydata.plugin");
    }

    private final List<String> d() {
        return (List) ZeusTransformUtils.preCheckCast(j.getValue(), List.class, "com.obric.memorydata.plugin");
    }

    private final void e() {
        kotlinx.coroutines.i.a(c, null, null, (Function2) ZeusTransformUtils.preCheckCast(new PermissionChangeWatcher$setupEventProcessing$1(null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    private final Map<String, Set<String>> f() {
        Map<String, Set<String>> r2 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        r2.put("android:read_contacts", SetsKt.setOf("android.permission.READ_CONTACTS"));
        r2.put("android:read_call_log", SetsKt.setOf("android.permission.READ_CALL_LOG"));
        r2.put("android:read_sms", SetsKt.setOf("android.permission.READ_SMS"));
        r2.put("android:read_calendar", SetsKt.setOf("android.permission.READ_CALENDAR"));
        if (Build.VERSION.SDK_INT < 33) goto L5;
        r2.put("android:read_media_images", SetsKt.setOf("android.permission.READ_MEDIA_IMAGES"));
        Set<String> r0 = SetsKt.setOf("android.permission.READ_MEDIA_VIDEO");
        String r1 = "android:read_media_video";
    L6:
        r2.put(r1, r0);
        if (Build.VERSION.SDK_INT < 30) goto L10;
        r2.put("android:manage_external_storage", SetsKt.setOf("android.permission.MANAGE_EXTERNAL_STORAGE"));
    L10:
        if (Build.VERSION.SDK_INT < 34) goto L12;
        r2.put("android:read_media_visual_user_selected", SetsKt.setOf("android.permission.READ_MEDIA_VISUAL_USER_SELECTED"));
    L12:
        return r2;
    L5:
        r0 = SetsKt.mutableSetOf(new String[]{"android.permission.READ_EXTERNAL_STORAGE"});
        r1 = "android:read_external_storage";
        goto L6
    }

    private final void g() {
        com.obric.memorydata.utils.ak r3 = com.obric.memorydata.utils.ak.f13164a;
        String r0 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getPackageName();
        Intrinsics.checkNotNullExpressionValue(r0, "getPackageName(...)");
        f = CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast(r3.g(r0), Iterable.class, "com.obric.memorydata.plugin"));
    }

    private final boolean h() {
        long r0 = h;
        if (r0 > 0) goto L5;
    L8:
        return true;
    L5:
        if ((System.currentTimeMillis() - r0) <= 60000) goto L8;
        return false;
    }

    private static final Map i() {
        return f12076a.f();
    }

    private static final List j() {
        return CollectionsKt.flatten((Iterable) ZeusTransformUtils.preCheckCast(f12076a.c().values(), Iterable.class, "com.obric.memorydata.plugin"));
    }

    public static /* synthetic */ void lambda$5Rs5B9YiANuYgqLjQucGGVwrRNQ(String r0, String r1, String r2, String r3) {
        a(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: lambda$MC-jitJJjq_o2J1aFI7k4E7PZj0, reason: not valid java name */
    public static /* synthetic */ Map m1063lambda$MCjitJJjq_o2J1aFI7k4E7PZj0() {
        return i();
    }

    public static /* synthetic */ List lambda$h_p4GspkyjNN0C6iyoeRN0JyqSo() {
        return j();
    }

    public final void a(boolean r13) {
        if (h != 0) goto L5;
        h = System.currentTimeMillis();
    L5:
        a(IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).getStringSet("last_initialized_collector_types", SetsKt.emptySet()), r13);
        if (Build.VERSION.SDK_INT >= 23) goto L9;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PermissionChangeWatcher", "start failed: build version=" + Build.VERSION.SDK_INT, null, 4, null);
        return;
    L9:
        kotlinx.coroutines.i.a(c, null, null, (Function2) ZeusTransformUtils.preCheckCast(new PermissionChangeWatcher$start$1(null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }
}
