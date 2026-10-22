package com.obric.memorydata.memory.ui.automemory.create;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.settings.AppSettingsManager;
import com.obric.memorydata.middleware.api.store.IStore;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H\u0002J\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00078F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/obric/memorydata/memory/ui/automemory/create/MemoryEnableAppUtils;", "", "<init>", "()V", "PENDING_QUERY_APPS", "", "ignorePackages", "", "blackPackages", "allHidePackages", "store", "Lcom/obric/memorydata/middleware/api/store/IStore;", "enableApps", "getEnableApps", "()Ljava/util/Set;", "getLauncherApps", "getPendingPackages", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f10670a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f10671b = null;
    private static final Set<String> c = null;
    private static final Set<String> d = null;
    private static final Set<String> e = null;
    private static final IStore f = null;

    static {
        f10670a = new g();
        f10671b = "pending_query_apps";
        Set<String> r0 = CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast(AppSettingsManager.INSTANCE.getRecommendSettings().getIgnorePackages(), Iterable.class, "com.obric.memorydata.plugin"));
        c = r0;
        Set<String> r1 = CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast(AppSettingsManager.INSTANCE.getRecommendSettings().getBlackPackages(), Iterable.class, "com.obric.memorydata.plugin"));
        d = r1;
        e = CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast(SetsKt.plus(r0, (Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin"));
        f = IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), "recommend_store", 0, 2, null);
    }

    private g() {
    }

    private final Set<String> c() {
        PackageManager r4 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getPackageManager();
        Intent r1 = new Intent("android.intent.action.MAIN");
        r1.addCategory("android.intent.category.LAUNCHER");
        List<ResolveInfo> r5 = r4.queryIntentActivities(r1, 0);
        Intrinsics.checkNotNullExpressionValue(r5, "queryIntentActivities(...)");
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L7;
        r2.add(((ResolveInfo) ZeusTransformUtils.preCheckCast(r7.next(), ResolveInfo.class, "com.obric.memorydata.plugin")).activityInfo.packageName);
        goto L4
    L7:
        return CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin"));
    }

    public final Set<String> a() {
        Set<String> r0 = c();
        Set<String> r4 = b();
        return CollectionsKt.toMutableSet((Iterable) ZeusTransformUtils.preCheckCast(SetsKt.minus(SetsKt.minus(r0, (Iterable) ZeusTransformUtils.preCheckCast(e, Iterable.class, "com.obric.memorydata.plugin")), (Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin"));
    }

    public final Set<String> b() {
        Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast(f.getStringSet(f10671b, SetsKt.emptySet()), Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r13 = r12.iterator();
    L4:
        if (r13.hasNext() == false) goto L11;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r13.next(), String.class, "com.obric.memorydata.plugin");
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("|", CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == false) goto L8;
        r2 = (String) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin"), new String[]{"|"}, false, 0, 6, null)), String.class, "com.obric.memorydata.plugin");
    L8:
        if (r2 == null) goto L4;
        r0.add(r2);
        goto L4
    L11:
        return CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
    }
}
