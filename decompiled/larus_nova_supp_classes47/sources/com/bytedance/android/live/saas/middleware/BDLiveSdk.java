package com.bytedance.android.live.saas.middleware;

import android.app.Application;
import android.content.Context;
import com.bytedance.android.dy.saas.utuid.d;
import com.bytedance.android.live.saas.middleware.alog.ILogProtocol;
import com.bytedance.android.live.saas.middleware.applog.IAppLog;
import com.bytedance.android.live.saas.middleware.base.BaseFunction;
import com.bytedance.android.live.saas.middleware.base.ISdkInitTask;
import com.bytedance.android.live.saas.middleware.console.Console;
import com.bytedance.android.live.saas.middleware.monitor.IMonitorReport;
import com.bytedance.android.live.saas.middleware.npth.INpthHelper;
import com.bytedance.android.live.saas.middleware.sec.ISecSdk;
import com.bytedance.android.live.saas.middleware.store.IFileUtils;
import com.bytedance.android.live.saas.middleware.store.IMiddlewareSharedPref;
import com.bytedance.android.live.saas.middleware.store.SPHelper;
import com.bytedance.android.live.saas.middleware.store.StoreManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import rf2.a;
import ry.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b@\u00101J*\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\bH\u0007J\b\u0010\f\u001a\u00020\nH\u0007J/\u0010\u0011\u001a\u00020\n\"\u0004\b\u0000\u0010\r2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00018\u0000H\u0007¢\u0006\u0004\b\u0011\u0010\u0012J%\u0010\u0013\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0007¢\u0006\u0004\b\u0013\u0010\u0014J%\u0010\u0015\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0007¢\u0006\u0004\b\u0015\u0010\u0014J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0007J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0007J\n\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0007J\n\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0007J\n\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0007J\b\u0010!\u001a\u00020 H\u0007J\u0014\u0010%\u001a\u00020$2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\"H\u0007J\n\u0010'\u001a\u0004\u0018\u00010&H\u0007J\n\u0010)\u001a\u0004\u0018\u00010(H\u0007R\u0014\u0010*\u001a\u00020\"8\u0006X\u0086T¢\u0006\u0006\n\u0004\b*\u0010+R*\u0010\u0007\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\u00068\u0006@BX\u0087\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010-\u0012\u0004\b0\u00101\u001a\u0004\b.\u0010/R(\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087.¢\u0006\u0018\n\u0004\b\u0003\u00102\u0012\u0004\b7\u00101\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u00108R&\u0010;\u001a\u0012\u0012\u000e\u0012\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u00010:098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010<R$\u0010>\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00010=8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010?¨\u0006A"}, d2 = {"Lcom/bytedance/android/live/saas/middleware/BDLiveSdk;", "", "Landroid/content/Context;", "context", "Lcom/bytedance/android/live/saas/middleware/BDLiveSdkConfig;", "sdkConfig", "Lcom/bytedance/android/live/saas/middleware/IAppInfo;", "appInfo", "", "async", "", "initialize", "doInitTask", "T", "Ljava/lang/Class;", "cls", "inst", "addFeature", "(Ljava/lang/Class;Ljava/lang/Object;)V", "getFeature", "(Ljava/lang/Class;)Ljava/lang/Object;", "getImp", "Lcom/bytedance/android/live/saas/middleware/applog/IAppLog;", "appLog", "Lcom/bytedance/android/live/saas/middleware/alog/ILogProtocol;", "getALog", "Lcom/bytedance/android/live/saas/middleware/monitor/IMonitorReport;", "getMonitor", "Lcom/bytedance/android/live/saas/middleware/sec/ISecSdk;", "getSec", "Lcom/bytedance/android/dy/saas/utuid/d;", "getUtUid", "Lcom/bytedance/android/live/saas/middleware/store/IFileUtils;", "fileUtils", "", "tableName", "Lcom/bytedance/android/live/saas/middleware/store/IMiddlewareSharedPref;", "sp", "Lry/e;", "getHostPermission", "Lcom/bytedance/android/live/saas/middleware/npth/INpthHelper;", "getNpthHelper", "TAG", "Ljava/lang/String;", "<set-?>", "Lcom/bytedance/android/live/saas/middleware/IAppInfo;", "getAppInfo", "()Lcom/bytedance/android/live/saas/middleware/IAppInfo;", "getAppInfo$annotations", "()V", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "getContext$annotations", "Lcom/bytedance/android/live/saas/middleware/BDLiveSdkConfig;", "", "Lcom/bytedance/android/live/saas/middleware/base/BaseFunction;", "functionList", "Ljava/util/List;", "", "extFeatureMap", "Ljava/util/Map;", "<init>", "middleware_release"}, k = 1, mv = {1, 4, 3})
public final class BDLiveSdk {
    public static final BDLiveSdk INSTANCE = null;
    public static final String TAG = "BDLiveSdk";
    private static IAppInfo appInfo;
    public static Context context;
    private static Map<Object, Object> extFeatureMap;
    private static List<BaseFunction<?, Object>> functionList;
    private static BDLiveSdkConfig sdkConfig;

    private BDLiveSdk() {
    }

    @JvmStatic
    public static /* synthetic */ void getAppInfo$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getContext$annotations() {
    }

    @JvmStatic
    public static final IMiddlewareSharedPref sp() {
        return sp$default(null, 1, null);
    }

    static {
        INSTANCE = new BDLiveSdk();
        appInfo = IAppInfo.Companion.getSTUB();
        sdkConfig = BDLiveSdkConfig.Companion.getSTUB();
        functionList = new ArrayList();
        extFeatureMap = new LinkedHashMap();
    }

    @JvmStatic
    public static final IAppLog appLog() {
        return (IAppLog) sdkConfig.getFunctionImp(IAppLog.class);
    }

    @JvmStatic
    public static final void doInitTask() {
        Iterator<T> r0 = functionList.iterator();
    L4:
        if (r0.hasNext() == false) goto L18;
        BaseFunction r1 = (BaseFunction) r0.next();
        ISdkInitTask r2 = r1.getTask();
        if (r2 == null) goto L4;
        r1.getMParams();
        Context r3 = context;
        if (r3 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("context");
    L10:
        if (r3 == null) goto L17;
        Application r4 = (Application) r3;
        Object r5 = r1.getMParams();
        if (r5 == null) goto L15;
        r2.init(r4, r5);
        goto L4
    L15:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Any");
    L17:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Application");
    }

    @JvmStatic
    public static final ILogProtocol getALog() {
        return (ILogProtocol) sdkConfig.getFunctionImp(ILogProtocol.class);
    }

    public static final Context getContext() {
        Context r0 = context;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("context");
    L5:
        return r0;
    }

    @JvmStatic
    public static final e getHostPermission() {
        return sdkConfig.getHostPermission();
    }

    @JvmStatic
    public static final IMonitorReport getMonitor() {
        return (IMonitorReport) sdkConfig.getFunctionImp(IMonitorReport.class);
    }

    @JvmStatic
    public static final INpthHelper getNpthHelper() {
        return (INpthHelper) sdkConfig.getFunctionImp(INpthHelper.class);
    }

    @JvmStatic
    public static final ISecSdk getSec() {
        return (ISecSdk) sdkConfig.getFunctionImp(ISecSdk.class);
    }

    @JvmStatic
    public static final d getUtUid() {
        return (d) sdkConfig.getFunctionImp(d.class);
    }

    @JvmStatic
    public static final IFileUtils fileUtils() {
        return StoreManager.INSTANCE;
    }

    public static final IAppInfo getAppInfo() {
        return appInfo;
    }

    @JvmStatic
    public static final <T> T getFeature(Class<T> r1) {
        Intrinsics.checkNotNullParameter(r1, "cls");
        T r2 = (T) extFeatureMap.get(r1);
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2;
    }

    @JvmStatic
    public static final <T> T getImp(Class<T> r1) {
        Intrinsics.checkNotNullParameter(r1, "cls");
        return (T) sdkConfig.getFunctionImp(r1);
    }

    public static final void setContext(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        context = r1;
    }

    @JvmStatic
    public static final IMiddlewareSharedPref sp(String r1) {
        if (r1 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == false) goto L12;
        return SPHelper.Companion.getDefaultSpHelper();
    L12:
        return new SPHelper(r1);
    L4:
        if (r1.length() == 0) goto L7;
        r0 = false;
        goto L8
    }

    @JvmStatic
    public static final <T> void addFeature(Class<T> r1, T r2) {
        if (r2 == null) goto L6;
        if (r1 == null) goto L7;
        extFeatureMap.put(r1, r2);
        return;
    L7:
        return;
    }

    public static /* synthetic */ IMiddlewareSharedPref sp$default(String r0, int r1, Object r2) {
        if ((r1 & 1) == 0) goto L6;
        r0 = "";
    L6:
        return sp(r0);
    }

    @JvmStatic
    public static final void initialize(Context r0, BDLiveSdkConfig r1, IAppInfo r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r0, "context");
        Intrinsics.checkNotNullParameter(r1, "sdkConfig");
        Intrinsics.checkNotNullParameter(r2, "appInfo");
        context = r0;
        appInfo = r2;
        sdkConfig = r1;
        boolean r4 = a.a;
        a.a = r1.getDisableBroadcast();
        Console.init(r2.isDebug());
        Iterator<T> r5 = r1.getMTaskList().iterator();
    L4:
        if (r5.hasNext() == false) goto L10;
        BaseFunction<?, Object> r6 = (BaseFunction) r5.next();
        List<BaseFunction<?, Object>> r7 = functionList;
        if (r6 == null) goto L9;
        r7.add(r6);
        goto L4
    L9:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.saas.middleware.base.BaseFunction<*, kotlin.Any>");
    }

    public static /* synthetic */ void initialize$default(Context r0, BDLiveSdkConfig r1, IAppInfo r2, boolean r3, int r4, Object r5) {
        if ((r4 & 8) == 0) goto L5;
        r3 = false;
    L5:
        initialize(r0, r1, r2, r3);
    }
}
