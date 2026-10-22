package com.obric.memorydata.personalcontext.storage;

import android.content.Context;
import android.content.Intent;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.obric.memorydata.utils.handler.AbstractHandlerInstance;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000K\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0003*\u0001\u001f\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\u00122\u0006\u0010\u0013\u001a\u00020\nJ\u000e\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0005J\u0016\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0018J\u0016\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0018J\u0016\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0018J\u001c\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\t2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0012J\b\u0010\u001c\u001a\u00020\u000fH\u0002J\u0006\u0010\u001d\u001a\u00020\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R&\u0010\u0007\u001a\u001a\u0012\u0004\u0012\u00020\t\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\b0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010 ¨\u0006!"}, d2 = {"Lcom/obric/memorydata/personalcontext/storage/AppEntityStorageReceiver;", "", "<init>", "()V", "TAG", "", "KEVA_KEY_OF_OBSERVER_APPS", "listeners", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/obric/memorydata/personalcontext/storage/AppEntityStorageListener;", "observerAppPackages", "Ljava/util/concurrent/ConcurrentHashMap$KeySetView;", "", "register", "", "appPkgName", "entityTypes", "", "listener", "unregister", "receiveInsertAppEntity", "entityType", "rawAppEntity", "Lcom/obric/memorydata/database/entity/AbstractRawDbEntity;", "receiveUpdateAppEntity", "receiveDeleteAppEntity", "receiveBulkDeleteAppEntity", "saveObserverAppPackages", "recoverRegisterInfoWhenAppStart", "handler", "com/obric/memorydata/personalcontext/storage/AppEntityStorageReceiver$handler$1", "Lcom/obric/memorydata/personalcontext/storage/AppEntityStorageReceiver$handler$1;", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f12343a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap<Integer, ConcurrentHashMap<String, d>> f12344b = null;
    private static final ConcurrentHashMap.KeySetView<String, Boolean> c = null;
    private static final a d = null;

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0014¨\u0006\u0004"}, d2 = {"com/obric/memorydata/personalcontext/storage/AppEntityStorageReceiver$handler$1", "Lcom/obric/memorydata/utils/handler/AbstractHandlerInstance;", "getHandlerThreadName", "", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a extends AbstractHandlerInstance {
        a() {
        }

        @Override // com.obric.memorydata.utils.handler.AbstractHandlerInstance
        public String getHandlerThreadName() {
            return "AppEntityStorageReceiverHandler";
        }
    }

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001¨\u0006\u0003¸\u0006\u0000"}, d2 = {"com/obric/memorydata/utils/GsonExtKt$toListObj$1", "Lcom/google/gson/reflect/TypeToken;", "", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b extends TypeToken<List<? extends String>> {
        public b() {
        }
    }

    static {
        f12343a = new e();
        f12344b = new ConcurrentHashMap();
        ConcurrentHashMap.KeySetView<String, Boolean> r0 = ConcurrentHashMap.newKeySet();
        Intrinsics.checkNotNullExpressionValue(r0, "newKeySet(...)");
        c = r0;
        d = new a();
    }

    private e() {
    }

    private final void b() {
        IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).save("app_entity_storage_observer_apps", com.obric.memorydata.utils.u.a(c));
    }

    private static final void b(int r6, List r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        ConcurrentHashMap r9 = (ConcurrentHashMap) ZeusTransformUtils.preCheckCast(f12344b.get(Integer.valueOf(r6)), ConcurrentHashMap.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L16;
        Iterator r10 = ((Map) ZeusTransformUtils.preCheckCast(r9, Map.class, "com.obric.memorydata.plugin")).entrySet().iterator();
    L6:
        if (r10.hasNext() == false) goto L27;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r10.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin");
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r4 = r2.iterator();
    L9:
        if (r4.hasNext() == false) goto L13;
        AppEntity r5 = ((com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast(r4.next(), com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin")).convertToAppEntity();
        if (r5 == null) goto L9;
        r3.add(r5);
        goto L9
    L13:
        List<? extends AppEntity> r11 = (List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin");
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r11, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L6;
        ((d) ZeusTransformUtils.preCheckCast(r0.getValue(), d.class, "com.obric.memorydata.plugin")).a(3, r11);
        goto L6
    L27:
        return;
    }

    private static final void d(int r4, com.obric.memorydata.database.entity.d r5) {
        ConcurrentHashMap r6 = (ConcurrentHashMap) ZeusTransformUtils.preCheckCast(f12344b.get(Integer.valueOf(r4)), ConcurrentHashMap.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L10;
        Iterator r7 = ((Map) ZeusTransformUtils.preCheckCast(r6, Map.class, "com.obric.memorydata.plugin")).entrySet().iterator();
    L6:
        if (r7.hasNext() == false) goto L16;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        AppEntity r2 = r5.convertToAppEntity();
        if (r2 == null) goto L6;
        ((d) ZeusTransformUtils.preCheckCast(r0.getValue(), d.class, "com.obric.memorydata.plugin")).a(1, CollectionsKt.listOf(r2));
        goto L6
    L16:
        return;
    }

    private static final void e(int r4, com.obric.memorydata.database.entity.d r5) {
        ConcurrentHashMap r6 = (ConcurrentHashMap) ZeusTransformUtils.preCheckCast(f12344b.get(Integer.valueOf(r4)), ConcurrentHashMap.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L10;
        Iterator r7 = ((Map) ZeusTransformUtils.preCheckCast(r6, Map.class, "com.obric.memorydata.plugin")).entrySet().iterator();
    L6:
        if (r7.hasNext() == false) goto L16;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        AppEntity r2 = r5.convertToAppEntity();
        if (r2 == null) goto L6;
        ((d) ZeusTransformUtils.preCheckCast(r0.getValue(), d.class, "com.obric.memorydata.plugin")).a(2, CollectionsKt.listOf(r2));
        goto L6
    L16:
        return;
    }

    private static final void f(int r4, com.obric.memorydata.database.entity.d r5) {
        ConcurrentHashMap r6 = (ConcurrentHashMap) ZeusTransformUtils.preCheckCast(f12344b.get(Integer.valueOf(r4)), ConcurrentHashMap.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L10;
        Iterator r7 = ((Map) ZeusTransformUtils.preCheckCast(r6, Map.class, "com.obric.memorydata.plugin")).entrySet().iterator();
    L6:
        if (r7.hasNext() == false) goto L16;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        AppEntity r2 = r5.convertToAppEntity();
        if (r2 == null) goto L6;
        ((d) ZeusTransformUtils.preCheckCast(r0.getValue(), d.class, "com.obric.memorydata.plugin")).a(3, CollectionsKt.listOf(r2));
        goto L6
    L16:
        return;
    }

    public static /* synthetic */ void lambda$OU57Eyyk6CiO4p5HAcKBmuvXXOY(int r0, com.obric.memorydata.database.entity.d r1) {
        f(r0, r1);
    }

    public static /* synthetic */ void lambda$VjefomF9QKgo539beO3xNJqCGSU(int r0, com.obric.memorydata.database.entity.d r1) {
        d(r0, r1);
    }

    public static /* synthetic */ void lambda$fEF7HFfk1RLhjI8zjxHZfhk8i5w(int r0, List r1) {
        b(r0, r1);
    }

    public static /* synthetic */ void lambda$hSwEAcjCMz6RqcHf4lIPUNPD05c(int r0, com.obric.memorydata.database.entity.d r1) {
        e(r0, r1);
    }

    public final void a() {
        List r5 = null;
        r5 = (List) ZeusTransformUtils.preCheckCast(com.obric.memorydata.utils.u.a().fromJson(IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).getString("app_entity_storage_observer_apps"), new b().getType()), List.class, "com.obric.memorydata.plugin");     // Catch: JsonParseException -> L5 JsonSyntaxException -> L7
    L10:
        if (r5 == null) goto L15;
        Iterator r12 = ((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L13:
        if (r12.hasNext() == false) goto L19;
        String r0 = (String) ZeusTransformUtils.preCheckCast(r12.next(), String.class, "com.obric.memorydata.plugin");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AppEntityStorageReceiver", "recover register info for " + r0, false, 4, null);
        Intent r1 = new Intent("com.obric.memorydata.appentity.restart");
        r1.setPackage(r0);
        ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).sendBroadcast(r1);
        goto L13
    L19:
        return;
    L15:
        return;
    L7:
        e = e;
        IRunLog r6 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r2 = new StringBuilder();
    L9:
        IRunLog.a.b(r6, "GsonExt", r2.append("toListObj error : ").append(e).toString(), null, 4, null);
    L5:
        e = e;
        r6 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r2 = new StringBuilder();
        goto L9
    }

    public final void a(final int r2, final com.obric.memorydata.database.entity.d r3) {
        Intrinsics.checkNotNullParameter(r3, "rawAppEntity");
        d.sendMsg(new $$Lambda$e$VjefomF9QKgo539beO3xNJqCGSU(r2, r3));
    }

    public final void a(final int r2, List<? extends com.obric.memorydata.database.entity.d> r3) {
        final List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "rawAppEntity");
        d.sendMsg(new $$Lambda$e$fEF7HFfk1RLhjI8zjxHZfhk8i5w(r2, r1));
    }

    public final void a(String r7) {
        Intrinsics.checkNotNullParameter(r7, "appPkgName");
        Iterator r0 = ((Map) ZeusTransformUtils.preCheckCast(f12344b, Map.class, "com.obric.memorydata.plugin")).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r0.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (((ConcurrentHashMap) ZeusTransformUtils.preCheckCast(r1.getValue(), ConcurrentHashMap.class, "com.obric.memorydata.plugin")).containsKey(r7) == false) goto L4;
        ((ConcurrentHashMap) ZeusTransformUtils.preCheckCast(r1.getValue(), ConcurrentHashMap.class, "com.obric.memorydata.plugin")).remove(r7);
        goto L4
    L8:
        c.remove(r7);
        b();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AppEntityStorageReceiver", "unregister for " + r7, false, 4, null);
    }

    public final void a(String r8, List<Integer> r9, d r10) {
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        d r12 = (d) ZeusTransformUtils.wrapperContextForParams(r10, d.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "appPkgName");
        Intrinsics.checkNotNullParameter(r11, "entityTypes");
        Intrinsics.checkNotNullParameter(r12, "listener");
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        int r2 = ((Number) ZeusTransformUtils.preCheckCast(r0.next(), Number.class, "com.obric.memorydata.plugin")).intValue();
        ConcurrentHashMap<Integer, ConcurrentHashMap<String, d>> r3 = f12344b;
        if (r3.get(Integer.valueOf(r2)) != null) goto L8;
        ((Map) ZeusTransformUtils.preCheckCast(r3, Map.class, "com.obric.memorydata.plugin")).put(Integer.valueOf(r2), new ConcurrentHashMap());
    L8:
        ConcurrentHashMap r4 = (ConcurrentHashMap) ZeusTransformUtils.preCheckCast(r3.get(Integer.valueOf(r2)), ConcurrentHashMap.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L4;
        d r5 = (d) ZeusTransformUtils.preCheckCast(r4.put(r8, r12), d.class, "com.obric.memorydata.plugin");
        goto L4
    L11:
        c.add(r8);
        b();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AppEntityStorageReceiver", "register " + r11 + " for " + r8, false, 4, null);
    }

    public final void b(final int r2, final com.obric.memorydata.database.entity.d r3) {
        Intrinsics.checkNotNullParameter(r3, "rawAppEntity");
        d.sendMsg(new $$Lambda$e$hSwEAcjCMz6RqcHf4lIPUNPD05c(r2, r3));
    }

    public final void c(final int r2, final com.obric.memorydata.database.entity.d r3) {
        Intrinsics.checkNotNullParameter(r3, "rawAppEntity");
        d.sendMsg(new $$Lambda$e$OU57Eyyk6CiO4p5HAcKBmuvXXOY(r2, r3));
    }
}
