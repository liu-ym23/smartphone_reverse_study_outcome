package com.obric.memorydata.intelligence.b;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u0006\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u0011J\u0006\u0010\u0015\u001a\u00020\u0011J\b\u0010\u001a\u001a\u00020\u0011H\u0002J\b\u0010\u001b\u001a\u00020\u0011H\u0002J\u0016\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\u00050\fj\b\u0012\u0004\u0012\u00020\u0005`\rJ\u0018\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020$H\u0002J\u001c\u0010%\u001a\u00020\u00112\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020(0'H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00050\fj\b\u0012\u0004\u0012\u00020\u0005`\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00050\fj\b\u0012\u0004\u0012\u00020\u0005`\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00050\fj\b\u0012\u0004\u0012\u00020\u0005`\rX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\t8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u0003\u001a\u0004\b\u0018\u0010\u0019R \u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\t8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u0003\u001a\u0004\b\u001e\u0010\u0019¨\u0006)"}, d2 = {"Lcom/obric/memorydata/intelligence/predict/DataCollector;", "", "<init>", "()V", "TAG", "", "mStatNetwork", "Lcom/obric/memorydata/intelligence/predict/StatisticsNetwork;", "mAllInstalled3rdPartyAppList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "mAllSystemAppListWithIcon", "mAllSystemAppListWithoutIcon", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "mAllLauncherAppList", "NEED_SKIP_BLACK_LIST", CommonConsts.APM_INNER_EVENT_COST_INIT, "", "context", "Landroid/content/Context;", "requestNetworkStat", "clearAllData", "allInstalled3rdPartyAppName", "getAllInstalled3rdPartyAppName$annotations", "getAllInstalled3rdPartyAppName", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "updateLauncherAppInfo", "updateAllInstalledAppInfo", "allInstalledSystemAppNameWithIcon", "getAllInstalledSystemAppNameWithIcon$annotations", "getAllInstalledSystemAppNameWithIcon", "getAllInstallAppWithIcon", "appHasIcon", "", "pkgName", "pm", "Landroid/content/pm/PackageManager;", "filterWithAllInstalledPkg", "input", "", "", "intelligence_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f9939a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final i f9940b = null;
    private static final CopyOnWriteArrayList<String> c = null;
    private static final CopyOnWriteArrayList<String> d = null;
    private static final ArrayList<String> e = null;
    private static final ArrayList<String> f = null;
    private static final ArrayList<String> g = null;

    static {
        f9939a = new b();
        f9940b = new i();
        c = new CopyOnWriteArrayList();
        d = new CopyOnWriteArrayList();
        e = new ArrayList();
        f = new ArrayList();
        g = CollectionsKt.arrayListOf(new String[]{"android", LocationInfoConst.SYSTEM, "com.google.android.gms", "cn.wps.moffice.lite.smartison_larg"});
    }

    private b() {
    }

    private final boolean a(String r3, PackageManager r4) {
        Intent r2 = new Intent("android.intent.action.MAIN", null);
        r2.addCategory("android.intent.category.LAUNCHER");
        r2.setPackage(r3);
        List<ResolveInfo> r5 = r4.queryIntentActivities(r2, 0);
        Intrinsics.checkNotNullExpressionValue(r5, "queryIntentActivities(...)");
        if (r5.size() <= 0) goto L6;
        return true;
    L6:
        return false;
    }

    public static final CopyOnWriteArrayList<String> c() {
        CopyOnWriteArrayList<String> r0 = c;
        if (r0.size() != 0) goto L5;
        f9939a.f();
    L5:
        return r0;
    }

    public static final CopyOnWriteArrayList<String> d() {
        CopyOnWriteArrayList<String> r0 = d;
        if (r0.size() != 0) goto L5;
        f9939a.f();
    L5:
        return r0;
    }

    private final void e() {
        f.clear();
        Intent r8 = new Intent("android.intent.action.MAIN", null);
        r8.addCategory("android.intent.category.HOME");
        if (((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getPackageManager() != null) goto L5;
        return;
    L5:
        int r2 = 0;
        List<ResolveInfo> r9 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getPackageManager().queryIntentActivities(r8, 0);
        Intrinsics.checkNotNullExpressionValue(r9, "queryIntentActivities(...)");
        int r0 = ((Collection) ZeusTransformUtils.preCheckCast(r9, Collection.class, "com.obric.memorydata.plugin")).size();
    L6:
        if (r2 >= r0) goto L8;
        String r3 = ((ResolveInfo) ZeusTransformUtils.preCheckCast(r9.get(r2), ResolveInfo.class, "com.obric.memorydata.plugin")).activityInfo.name;
        String r4 = ((ResolveInfo) ZeusTransformUtils.preCheckCast(r9.get(r2), ResolveInfo.class, "com.obric.memorydata.plugin")).activityInfo.packageName;
        RunLog.INSTANCE.debug("appappinfo", r2 + " -- launcherActivityName: " + r3);
        RunLog.INSTANCE.debug("appappinfo", r2 + " -- packageName: " + r4);
        f.add(r4);
        r2 = r2 + 1;
        goto L6
    }

    private final synchronized void f() {
        monitor-enter(this);
        c.clear();     // Catch: Throwable -> L24
        d.clear();     // Catch: Throwable -> L24
        e.clear();     // Catch: Throwable -> L24
        e();     // Catch: Throwable -> L24
        PackageManager r0 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getPackageManager();     // Catch: Throwable -> L24
        if (r0 != null) goto L7;
        monitor-exit(this);
        return;
    L7:
        int r1 = 0;
        List<PackageInfo> r2 = r0.getInstalledPackages(0);     // Catch: Throwable -> L24
        Intrinsics.checkNotNullExpressionValue(r2, "getInstalledPackages(...)");     // Catch: Throwable -> L24
        int r3 = ((Collection) ZeusTransformUtils.preCheckCast(r2, Collection.class, "com.obric.memorydata.plugin")).size();     // Catch: Throwable -> L24
    L9:
        if (r1 >= r3) goto L22;
        PackageInfo r4 = r2.get(r1);     // Catch: Throwable -> L24
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.content.pm.PackageInfo");     // Catch: Throwable -> L24
        PackageInfo r5 = (PackageInfo) ZeusTransformUtils.preCheckCast(r4, PackageInfo.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L24
        if (g.contains(r5.packageName) == false) goto L14;
        RunLog.INSTANCE.debug("DataCollector", "### found black package.");     // Catch: Throwable -> L24
    L21:
        r1 = r1 + 1;
        goto L9
    L14:
        if ((r5.applicationInfo.flags & 1) > 0) goto L17;
        CopyOnWriteArrayList<String> r6 = c;     // Catch: Throwable -> L24
        String r7 = r5.packageName;     // Catch: Throwable -> L24
    L16:
        r6.add(r7);     // Catch: Throwable -> L24
        goto L21
    L17:
        String r8 = r5.packageName;     // Catch: Throwable -> L24
        Intrinsics.checkNotNullExpressionValue(r8, ObricMemoryConstants.KEY_PACKAGE_NAME);     // Catch: Throwable -> L24
        if (a(r8, r0) == false) goto L20;
        r6 = d;     // Catch: Throwable -> L24
        r7 = r5.packageName;     // Catch: Throwable -> L24
        goto L16
    L20:
        e.add(r5.packageName);     // Catch: Throwable -> L24
        goto L21
    L22:
        monitor-exit(this);
        return;
    L24:
        th = move-exception;
        throw th;
    }

    public final void a() {
        f9940b.a();
    }

    public final void a(Context r2) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        f9940b.a(r1);
        com.obric.memorydata.intelligence.b.a.a.f9938b.b();
    }

    public final void b() {
        RunLog.INSTANCE.debug("DataCollector", "### clear all data...");
        f();
    }
}
