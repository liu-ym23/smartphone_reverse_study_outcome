package com.bytedance.ai.resource;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import com.bytedance.ai.model.objects.AIPackage;
import com.bytedance.ai.resource.core.AIPackageDeployment;
import com.bytedance.ai.resource.core.AIPackageOperationGroup;
import com.bytedance.ai.resource.core.AIPackagePreInstall;
import com.bytedance.ai.resource.core.AIPackageStorage;
import com.bytedance.ai.resource.core.bean.AIPackageAppList;
import com.bytedance.ai.resource.core.bean.AIPackageGeckoInfoItem;
import com.bytedance.ai.resource.core.bean.AIPackageGeckoInfoList;
import com.bytedance.ai.resource.core.bean.AIPackageGeckoInfoRequest;
import com.bytedance.ai.resource.core.bean.AIPackageNetworkRequest;
import com.bytedance.ai.resource.core.bean.AIPackageNetworkResponse;
import com.bytedance.ai.resource.core.bean.AIPackageResponseItem;
import com.bytedance.ai.resource.core.bean.PackageRequestItem;
import com.bytedance.ai.resource.core.net.AIPackageTTNET;
import com.google.gson.Gson;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.DownloaderBuilder;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.service.DownloadComponentManagerService;
import com.ss.android.socialbase.downloader.service.DownloadGlobalThrottleService;
import com.ss.android.socialbase.downloader.service.DownloadIdGeneratorService;
import com.ss.android.socialbase.downloader.service.DownloadMonitorHelperService;
import com.ss.android.socialbase.downloader.service.DownloadMultiProcService;
import com.ss.android.socialbase.downloader.service.DownloadNetTrafficManagerService;
import com.ss.android.socialbase.downloader.service.DownloadNetworkService;
import com.ss.android.socialbase.downloader.service.DownloadNotificationManagerService;
import com.ss.android.socialbase.downloader.service.DownloadProcessDispatcherService;
import com.ss.android.socialbase.downloader.service.DownloadRetrySchedulerService;
import com.ss.android.socialbase.downloader.service.DownloadServiceLoader;
import com.ss.android.socialbase.downloader.service.DownloadServiceManager;
import com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService;
import com.ss.android.socialbase.downloader.service.IDownloadGlobalThrottleService;
import com.ss.android.socialbase.downloader.service.IDownloadIdGeneratorService;
import com.ss.android.socialbase.downloader.service.IDownloadMonitorHelperService;
import com.ss.android.socialbase.downloader.service.IDownloadMultiProcService;
import com.ss.android.socialbase.downloader.service.IDownloadNetTrafficManagerService;
import com.ss.android.socialbase.downloader.service.IDownloadNetworkService;
import com.ss.android.socialbase.downloader.service.IDownloadNotificationManagerService;
import com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService;
import com.ss.android.socialbase.downloader.service.IDownloadRetrySchedulerService;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.j0;

/* JADX INFO: loaded from: classes2.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r f2752a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AIPackagePreInstall f2753b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap f2754c = null;
    public static List d;

    static {
        f2752a = new r();
        f2753b = new AIPackagePreInstall();
        f2754c = new ConcurrentHashMap();
    }

    public static AIPackageAppList a(ArrayList r10) {
        Intrinsics.checkNotNullParameter(r10, "appRequestList");
        AIPackageNetworkRequest r5 = new AIPackageNetworkRequest(r10, null, null, 6, null);
        Lazy r11 = AIPackageTTNET.f2669a;
        Intrinsics.checkNotNullParameter(r5, "request");
        AIPackageNetworkResponse<AIPackageAppList> r12 = ((IAIPackageNetService) AIPackageTTNET.f2669a.getValue()).requestUpdateInfo(r5);
        if (r12.getCode() != 0) goto L8;
        AIPackageAppList r13 = r12.getData();
        String r14 = "Succeeded to obtain the update list : " + r13;
        Intrinsics.checkNotNullParameter("AIPackageManager", "tag");
        t0.d r15 = com.bytedance.ai.utils.c.f2846a;
        if (r15 == null) goto L7;
        r15.i("AIPackageManager", r14);
    L7:
        return r13;
    L8:
        String r16 = "Failed to obtain the update list : code = " + r12.getCode() + ", msg = " + r12.getMsg();
        Intrinsics.checkNotNullParameter("AIPackageManager", "tag");
        t0.d r17 = com.bytedance.ai.utils.c.f2846a;
        if (r17 == null) goto L13;
        r17.e("AIPackageManager", r16);
        return null;
    L13:
        return null;
    }

    public static Object d(k r14, long r15, l r17, ContinuationImpl r18) {
        String r5 = r14.getPackageName();
        String r10 = "packageName: " + r14.getPackageName() + ", appId: " + r14.getAppId() + ", onlyInMemory: false ===> installAIPackage start";
        Intrinsics.checkNotNullParameter("AIPackageManager", "tag");
        t0.d r11 = com.bytedance.ai.utils.c.f2846a;
        if (r11 == null) goto L6;
        r11.i("AIPackageManager", r10);
    L6:
        if ((r14 instanceof AIPackageDeployment.AIPackageDeploymentItem) == false) goto L8;
        AIPackageDeployment.AIPackageDeploymentItem r12 = (AIPackageDeployment.AIPackageDeploymentItem) r14;
    L9:
        if (r12 != null) goto L11;
        r12 = new AIPackageDeployment.AIPackageDeploymentItem(r14.getAppId(), r14.getPackageName(), r15, null, null, null, false, 120, null);
    L11:
        ConcurrentHashMap r13 = f2754c;
        Object r16 = r13.get(r5);
        if (r16 != null) goto L17;
        r16 = new AIPackageOperationGroup();
        Object r19 = r13.putIfAbsent(r5, r16);
        if (r19 == null) goto L17;
        r16 = r19;
    L17:
        Object r20 = AIPackageOperationGroup.a((AIPackageOperationGroup) r16, r12, r17, r18);
        if (r20 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L22;
        r20 = Unit.INSTANCE;
    L22:
        if (r20 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L25;
        return r20;
    L25:
        return Unit.INSTANCE;
    L8:
        r12 = null;
        goto L9
    }

    public static String i() {
        StringBuilder r5 = new StringBuilder();
        StringBuilder r10 = new StringBuilder("  builtInListSize=");
        List r11 = d;
        if (r11 == null) goto L5;
        int r12 = r11.size();
    L6:
        r10.append(r12);
        r5.append(r10.toString());
        r5.append('\n');
        StringBuilder r13 = new StringBuilder("  operationGroupCount=");
        ConcurrentHashMap r14 = f2754c;
        r13.append(r14.size());
        r5.append(r13.toString());
        r5.append('\n');
        if (r14.isEmpty() == false) goto L9;
        r5.append("  operationGroups=<none>");
    L14:
        return r5.toString();
    L9:
        Iterator r15 = MapsKt.toSortedMap(r14).entrySet().iterator();
    L11:
        if (r15.hasNext() == false) goto L14;
        Map.Entry r16 = (Map.Entry) r15.next();
        String r17 = (String) r16.getKey();
        AIPackageOperationGroup r18 = (AIPackageOperationGroup) r16.getValue();
        r5.append("  operationGroup[" + r17 + "]:");
        r5.append('\n');
        r5.append(StringsKt.x(r18.a()));
        r5.append('\n');
        goto L11
    L5:
        r12 = -1;
        goto L6
    }

    public static final String j(String r10) {
        String r5 = e0.o(r10);
        if (r5 != null) goto L5;
    L8:
        String r11 = "try to get baseUrl from remote. packageName: ".concat(r10);
        Intrinsics.checkNotNullParameter("AIPackageManager", "tag");
        t0.d r12 = com.bytedance.ai.utils.c.f2846a;
        if (r12 == null) goto L11;
        r12.i("AIPackageManager", r11);
    L11:
        Lazy r13 = AIPackageTTNET.f2669a;
        String r14 = null;
        AIPackageGeckoInfoRequest r15 = new AIPackageGeckoInfoRequest(CollectionsKt.listOf(new PackageRequestItem(r10, null, 2, null)), null, 2, null);
        Intrinsics.checkNotNullParameter(r15, "request");
        AIPackageNetworkResponse<AIPackageGeckoInfoList> r16 = ((IAIPackageNetService) AIPackageTTNET.f2669a.getValue()).requestGeckoInfo(r15);
        if (r16.getCode() != 0) goto L22;
        AIPackageGeckoInfoList r17 = r16.getData();
        if (r17 == null) goto L25;
        List<AIPackageGeckoInfoItem> r18 = r17.getAppList();
        if (r18 == null) goto L25;
        AIPackageGeckoInfoItem r19 = (AIPackageGeckoInfoItem) CollectionsKt.firstOrNull(r18);
        if (r19 == null) goto L25;
        List<String> r20 = r19.getBaseUrls();
        if (r20 == null) goto L25;
        r14 = (String) CollectionsKt.firstOrNull(r20);
    L25:
        if (r14 != null) goto L27;
    L30:
        return r14;
    L27:
        if (r14.length() == 0) goto L30;
        Intrinsics.checkNotNullParameter(r10, "packageName");
        Intrinsics.checkNotNullParameter(r14, "baseUrl");
        e0.f2711a.put(r10, r14);
        e0.p().storeString(r10, r14);
        goto L30
    L22:
        String r21 = "failed to get remote baseUrl. packageName: ".concat(r10);
        Intrinsics.checkNotNullParameter("AIPackageManager", "tag");
        t0.d r22 = com.bytedance.ai.utils.c.f2846a;
        if (r22 == null) goto L25;
        r22.e("AIPackageManager", r21);
        goto L25
    L5:
        if (r5.length() == 0) goto L8;
        return r5;
    }

    public final Object b(Application r14, ContinuationImpl r15) {
        if ((r15 instanceof AIPackageManager$loadBuiltInAIPackages$1) == false) goto L7;
        AIPackageManager$loadBuiltInAIPackages$1 r5 = (AIPackageManager$loadBuiltInAIPackages$1) r15;
        int r10 = r5.f2522c;
        if ((r10 & Integer.MIN_VALUE) == 0) goto L7;
        r5.f2522c = r10 - Integer.MIN_VALUE;
    L8:
        Object r13 = r5.f2520a;
        Object r16 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = r5.f2522c;
        if (r11 == 0) goto L16;
        if (r11 == 1) goto L15;
        if (r11 != 2) goto L14;
        ResultKt.throwOnFailure(r13);
    L89:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r13);
    L60:
        List r17 = (List) r13;
        List r18 = d;
        if (r18 == null) goto L91;
        ArrayList r12 = new ArrayList();
        Iterator r19 = r18.iterator();
    L64:
        if (r19.hasNext() == false) goto L81;
        Object r20 = r19.next();
        AIPackageDeployment.AIPackageDeploymentItem r21 = (AIPackageDeployment.AIPackageDeploymentItem) r20;
        if (r17 != null) goto L68;
    L70:
        Iterator r22 = r17.iterator();
    L72:
        if (r22.hasNext() == false) goto L80;
        AIPackage r23 = (AIPackage) r22.next();
        if (Intrinsics.areEqual(r23.f2259b, r21.getPackageName()) == false) goto L72;
        if (Intrinsics.areEqual(r23.c(), r21.getAppId()) == false) goto L72;
        if (r23.f2260c < r21.getVersionCode()) goto L72;
    L80:
        r12.add(r20);
        goto L64
    L68:
        if (r17.isEmpty() == false) goto L70;
    L81:
        ArrayList r110 = new ArrayList(CollectionsKt.h(r12));
        Iterator r111 = r12.iterator();
    L83:
        if (r111.hasNext() == false) goto L85;
        AIPackageDeployment.AIPackageDeploymentItem r24 = (AIPackageDeployment.AIPackageDeploymentItem) r111.next();
        r24.setResourceUrl("local://urlPlaceHolder/");
        r110.add(BuildersKt.async$default(h0.a(t2.b.f22089a), null, null, new AIPackageManager$loadBuiltInAIPackages$4$1(r24, null), 3, null));
        goto L83
    L85:
        r5.f2522c = 2;
        if (j0.c(r110, r5) != r16) goto L89;
    L87:
        return r16;
    L91:
        return Unit.INSTANCE;
    L16:
        ResultKt.throwOnFailure(r13);
        y r112 = y.f2766a;
        Intrinsics.checkNotNullParameter("READ_BUILT_IN_PACKAGE_LIST", "stage");
        y.f.set(new x("READ_BUILT_IN_PACKAGE_LIST", null, 6));
        InputStream r113 = r14.getAssets().open("pre-install_info.json");     // Catch: Exception -> L31
        Intrinsics.checkNotNull(r113);     // Catch: Throwable -> L26
        BufferedReader r25 = new BufferedReader(new InputStreamReader(r113, Charsets.UTF_8), 8192);     // Catch: Throwable -> L26
        String r26 = TextStreamsKt.readText(r25);     // Catch: Throwable -> L33
        CloseableKt.closeFinally(r25, null);     // Catch: Throwable -> L26
        List r27 = (List) new Gson().fromJson(r26, new o().getType());     // Catch: Throwable -> L26
        if (r27 == null) goto L28;
        String r114 = "Loaded local pre-install list: " + r27 + " items";     // Catch: Throwable -> L26
        Intrinsics.checkNotNullParameter("AIPackageManager", "tag");     // Catch: Throwable -> L26
        t0.d r28 = com.bytedance.ai.utils.c.f2846a;     // Catch: Throwable -> L26
        if (r28 == null) goto L29;
        r28.d("AIPackageManager", r114);     // Catch: Throwable -> L26
    L29:
        CloseableKt.closeFinally(r113, null);     // Catch: Exception -> L31
    L46:
        if (r27 == null) goto L93;
        if (r27.isEmpty() == false) goto L51;
        r27 = null;
    L51:
        if (r27 == null) goto L93;
        d = r27;
        y r115 = y.f2766a;
        StringBuilder r116 = new StringBuilder("builtInCount=");
        List r117 = d;
        if (r117 == null) goto L56;
        int r118 = r117.size();
    L57:
        r116.append(r118);
        String r119 = r116.toString();
        Intrinsics.checkNotNullParameter("QUERY_INSTALLED_PACKAGES_FOR_BUILT_IN", "stage");
        y.f.set(new x("QUERY_INSTALLED_PACKAGES_FOR_BUILT_IN", r119, 6));
        AIPackageStorage r120 = AIPackageStorage.f2618a;
        r5.f2522c = 1;
        r13 = r120.a(AIPackage.AIPackageType.f2281c, r5);
        if (r13 != r16) goto L60;
    L56:
        r118 = 0;
    L93:
        return Unit.INSTANCE;
    L28:
        r27 = null;
        goto L29
    L33:
        th = move-exception;
        throw th;     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        CloseableKt.closeFinally(r25, th);     // Catch: Throwable -> L26
        throw th;     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        throw th;     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        CloseableKt.closeFinally(r113, th);     // Catch: Exception -> L31
        throw th;     // Catch: Exception -> L31
    L31:
        e = move-exception;
        String r121 = com.lynx.tasm.ui.image.f0.d(e, new StringBuilder("Failed to load local pre-install list: "), "AIPackageManager");
        t0.d r122 = com.bytedance.ai.utils.c.f2846a;
        if (r122 == null) goto L45;
        r122.e("AIPackageManager", r121);
    L45:
        r27 = null;
    L7:
        r5 = new AIPackageManager$loadBuiltInAIPackages$1(this, r15);
        goto L8
    }

    public final Object c(Application r15, boolean r16, boolean r17, Set r18, ContinuationImpl r19) {
        r r5 = this;
        Context r10 = r15;
        if ((r19 instanceof AIPackageManager$init$1) == false) goto L7;
        AIPackageManager$init$1 r11 = (AIPackageManager$init$1) r19;
        int r12 = r11.f;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r11.f = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r11.d;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r20 = r11.f;
        if (r20 == 0) goto L16;
        if (r20 == 1) goto L15;
        if (r20 != 2) goto L14;
        Context r21 = (Context) r11.f2511a;
        ResultKt.throwOnFailure(r13);
    L51:
        y r22 = y.f2766a;
        Intrinsics.checkNotNullParameter("PACKAGE_UPDATE_MANAGER_INIT", "stage");
        AtomicReference r23 = y.f;
        r23.set(new x("PACKAGE_UPDATE_MANAGER_INIT", null, 6));
        Log.i("AIPackageManager", "AIPackageUpdateManager start");
        s r24 = s.f2755a;
        Intrinsics.checkNotNullParameter(r21, "context");
        BuildersKt.launch$default(h0.a(t2.b.f22089a), null, null, new AIPackageUpdateManager$scheduleUpdate$1(null), 3, null);
        Log.i("AIPackageManager", "AIPackageUpdateManager init end");
        Intrinsics.checkNotNullParameter("AI_PACKAGE_MANAGER_INIT_COMPLETE", "stage");
        r23.set(new x("AI_PACKAGE_MANAGER_INIT_COMPLETE", null, 6));
    L55:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        Set r25 = r11.f2513c;
        r10 = r11.f2512b;
        r r26 = (r) r11.f2511a;
        ResultKt.throwOnFailure(r13);
        Set r27 = r25;
        r5 = r26;
    L47:
        y r28 = y.f2766a;
        Intrinsics.checkNotNullParameter("CLEAN_PACKAGES_TO_DELETE", "stage");
        y.f.set(new x("CLEAN_PACKAGES_TO_DELETE", null, 6));
        Log.i("AIPackageManager", "cleanPackagesToDelete start");
        r11.f2511a = r10;
        r11.f2512b = null;
        r11.f2513c = null;
        r11.f = 2;
        if (r5.h(r27, r11) != r14) goto L50;
    L49:
        return r14;
    L50:
        r21 = r10;
        goto L51
    L16:
        ResultKt.throwOnFailure(r13);
        if (r16 == false) goto L55;
        if (r17 == true) goto L55;
        y r29 = y.f2766a;
        Intrinsics.checkNotNullParameter("PACKAGE_PRE_INSTALL_INIT", "stage");
        AtomicReference r30 = y.f;
        r30.set(new x("PACKAGE_PRE_INSTALL_INIT", null, 6));
        AIPackagePreInstall r31 = f2753b;
        r31.getClass();
        Intrinsics.checkNotNullParameter(r15, "context");
        boolean r110 = false;
        r31.f2617b = r15.getSharedPreferences("AIPackagePreList", 0);
        Intrinsics.checkNotNullParameter("PACKAGE_DEPLOYMENT_INIT", "stage");
        r30.set(new x("PACKAGE_DEPLOYMENT_INIT", null, 6));
        ConcurrentHashMap r32 = AIPackageDeployment.f2573a;
        Intrinsics.checkNotNullParameter(r15, "context");
        Intrinsics.checkNotNullParameter("DOWNLOAD_MANAGER_INIT", "stage");
        r30.set(new x("DOWNLOAD_MANAGER_INIT", null, 6));
        Downloader r33 = Downloader.f15566c;
        ConcurrentHashMap r34 = DownloadServiceManager.f16100a;
        monitor-enter(DownloadServiceManager.class);
    L25:
        th = move-exception;
        throw th;
    L22:
        if (DownloadServiceLoader.f16099a == false) goto L27;
        monitor-exit(DownloadServiceManager.class);     // Catch: Throwable -> L25
    L35:
        String r35 = DownloadServiceManager.f16101b;
        if (r35 != null) goto L39;
        r110 = true;
    L39:
        if (Logger.b() == false) goto L41;
        Logger.b("DownloadServiceLoader", "defaultLoadCallback", "Load status:" + r110 + " errorMsg:" + r35);
    L41:
        Downloader.a(new DownloaderBuilder(s0.c.a()));
        Intrinsics.checkNotNullParameter("AIDownloadManager", "tag");
        t0.d r111 = com.bytedance.ai.utils.c.f2846a;
        if (r111 == null) goto L44;
        r111.d("AIDownloadManager", "init");
    L44:
        Intrinsics.checkNotNullParameter("LOAD_BUILT_IN_PACKAGES", "stage");
        r30.set(new x("LOAD_BUILT_IN_PACKAGES", null, 6));
        Log.i("AIPackageManager", "loadBuiltInAIPackages start");
        r11.f2511a = r5;
        r11.f2512b = r10;
        r27 = r18;
        r11.f2513c = r27;
        r11.f = 1;
        if (b(r15, r11) != r14) goto L47;
    L27:
        DownloadServiceLoader.f16099a = true;     // Catch: Throwable -> L25
        if (Logger.b() == false) goto L30;
        Logger.b("DownloadServiceLoader", "load", "Load download service start");     // Catch: Throwable -> L25
    L30:
        DownloadMonitorHelperService r112 = new DownloadMonitorHelperService();     // Catch: Throwable -> L25
        ConcurrentHashMap r113 = DownloadServiceManager.f16100a;     // Catch: Throwable -> L25
        r113.put(IDownloadMonitorHelperService.class, r112);     // Catch: Throwable -> L25
        r113.put(IDownloadIdGeneratorService.class, new DownloadIdGeneratorService());     // Catch: Throwable -> L25
        r113.put(IDownloadComponentManagerService.class, new DownloadComponentManagerService());     // Catch: Throwable -> L25
        r113.put(IDownloadProcessDispatcherService.class, new DownloadProcessDispatcherService());     // Catch: Throwable -> L25
        r113.put(IDownloadNetTrafficManagerService.class, new DownloadNetTrafficManagerService());     // Catch: Throwable -> L25
        r113.put(IDownloadNotificationManagerService.class, new DownloadNotificationManagerService());     // Catch: Throwable -> L25
        r113.put(IDownloadNetworkService.class, new DownloadNetworkService());     // Catch: Throwable -> L25
        r113.put(IDownloadRetrySchedulerService.class, new DownloadRetrySchedulerService());     // Catch: Throwable -> L25
        r113.put(IDownloadMultiProcService.class, new DownloadMultiProcService());     // Catch: Throwable -> L25
        r113.put(IDownloadGlobalThrottleService.class, new DownloadGlobalThrottleService());     // Catch: Throwable -> L25
        DownloadServiceManager.f16102c = true;     // Catch: Throwable -> L25
        monitor-exit(DownloadServiceManager.class);     // Catch: Throwable -> L25
        if (Logger.b() == false) goto L35;
        Logger.b("DownloadServiceLoader", "load", "Load download service end");
    L7:
        r11 = new AIPackageManager$init$1(this, r19);
        goto L8
    }

    public final Object e(AIPackageAppList r10, q r11, ContinuationImpl r12) {
        if ((r12 instanceof AIPackageManager$onUpdateAIPackages$1) == false) goto L7;
        AIPackageManager$onUpdateAIPackages$1 r5 = (AIPackageManager$onUpdateAIPackages$1) r12;
        int r13 = r5.e;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r5.e = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r5.f2528c;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r5.e;
        if (r16 == 0) goto L14;
        if (r16 != 1) goto L13;
        Iterator<AIPackageResponseItem> r17 = r5.f2527b;
        l r18 = r5.f2526a;
        ResultKt.throwOnFailure(r14);
        l r19 = r18;
    L18:
        if (r17.hasNext() == false) goto L68;
        AIPackageDeployment.AIPackageDeploymentItem r20 = AIPackageDeployment.a(r17.next());
        if (r20 == null) goto L18;
        List r21 = d;
        if (r21 == null) goto L33;
        Iterator r22 = r21.iterator();
    L25:
        if (r22.hasNext() == false) goto L31;
        Object r23 = r22.next();
        AIPackageDeployment.AIPackageDeploymentItem r24 = (AIPackageDeployment.AIPackageDeploymentItem) r23;
        if (Intrinsics.areEqual(r24.getPackageName(), r20.getPackageName()) == false) goto L25;
        if (Intrinsics.areEqual(r24.getAppId(), r20.getAppId()) == false) goto L25;
    L32:
        AIPackageDeployment.AIPackageDeploymentItem r25 = (AIPackageDeployment.AIPackageDeploymentItem) r23;
    L35:
        if (r25 != null) goto L37;
    L39:
        if (r20 == null) goto L18;
        r5.f2526a = r19;
        r5.f2527b = r17;
        r5.e = 1;
        String r26 = r20.getPackageName();
        String r27 = "packageName: " + r20.getPackageName() + ", appId: " + r20.getAppId() + " ===> updateAIPackage start";
        Intrinsics.checkNotNullParameter("AIPackageManager", "tag");
        t0.d r28 = com.bytedance.ai.utils.c.f2846a;
        if (r28 == null) goto L43;
        r28.d("AIPackageManager", r27);
    L43:
        long r29 = r20.getVersionCode();
        ConcurrentHashMap r30 = f2754c;
        if (r29 != (-1)) goto L55;
        Object r31 = r30.get(r26);
        if (r31 != null) goto L51;
        r31 = new AIPackageOperationGroup();
        Object r32 = r30.putIfAbsent(r26, r31);
        if (r32 == null) goto L51;
        r31 = r32;
    L51:
        Object r33 = ((AIPackageOperationGroup) r31).a(r20, r19, r5);
        if (r33 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L65;
        r33 = Unit.INSTANCE;
    L65:
        if (r33 != r15) goto L18;
        return r15;
    L55:
        Object r34 = r30.get(r26);
        if (r34 != null) goto L61;
        r34 = new AIPackageOperationGroup();
        Object r35 = r30.putIfAbsent(r26, r34);
        if (r35 == null) goto L61;
        r34 = r35;
    L61:
        r33 = ((AIPackageOperationGroup) r34).b(r20, r19, r5);
        if (r33 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L65;
        r33 = Unit.INSTANCE;
        goto L65
    L37:
        if (r20.getVersionCode() != (-1)) goto L39;
        r20 = null;
        goto L39
    L31:
        r23 = null;
        goto L32
    L33:
        r25 = null;
    L68:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r14);
        if (r10 == null) goto L68;
        r17 = r10.getAppList().iterator();
        r19 = r11;
    L7:
        r5 = new AIPackageManager$onUpdateAIPackages$1(this, r12);
        goto L8
    }

    public final Object f(String r5, ContinuationImpl r10) {
        if ((r10 instanceof AIPackageManager$installPackageFromGecko$1) == false) goto L7;
        AIPackageManager$installPackageFromGecko$1 r11 = (AIPackageManager$installPackageFromGecko$1) r10;
        int r12 = r11.f2519c;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r11.f2519c = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r11.f2517a;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r11.f2519c;
        String r16 = null;
        if (r15 == 0) goto L17;
        if (r15 != 1) goto L16;
        ResultKt.throwOnFailure(r13);     // Catch: Throwable -> L13
    L21:
        Object r17 = Result.m124constructorimpl((f0) r13);     // Catch: Throwable -> L13
    L25:
        if (Result.m130isFailureimpl(r17) == false) goto L27;
        Object r18 = null;
    L28:
        Throwable r19 = Result.m127exceptionOrNullimpl(r17);
        if (r19 == null) goto L32;
        r16 = r19.getMessage();
    L32:
        return TuplesKt.to(r18, r16);
    L27:
        r18 = r17;
        goto L28
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r13);
        Result.Companion r20 = Result.Companion;     // Catch: Throwable -> L13
        r11.f2519c = 1;     // Catch: Throwable -> L13
        r13 = BuildersKt.withContext(t2.b.f22089a, new AIPackageManager$getInstallPackageFromGeckoJob$2(r5, null), r11);     // Catch: Throwable -> L13
        if (r13 != r14) goto L21;
        return r14;
    L13:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r17 = Result.m124constructorimpl(ResultKt.createFailure(th));
    L7:
        r11 = new AIPackageManager$installPackageFromGecko$1(this, r10);
        goto L8
    }

    public final Object g(ArrayList r10, g r11, ContinuationImpl r12) {
        if ((r12 instanceof AIPackageManager$installAIPackages$1) == false) goto L7;
        AIPackageManager$installAIPackages$1 r5 = (AIPackageManager$installAIPackages$1) r12;
        int r13 = r5.e;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r5.e = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r5.f2516c;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r5.e;
        if (r16 == 0) goto L14;
        if (r16 != 1) goto L13;
        Iterator r17 = r5.f2515b;
        l r18 = r5.f2514a;
        ResultKt.throwOnFailure(r14);
        l r19 = r18;
    L16:
        if (r17.hasNext() == false) goto L21;
        k r20 = (k) r17.next();
        r5.f2514a = r19;
        r5.f2515b = r17;
        r5.e = 1;
        if (d(r20, 0, r19, r5) != r15) goto L16;
        return r15;
    L21:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r14);
        r17 = r10.iterator();
        r19 = r11;
    L7:
        r5 = new AIPackageManager$installAIPackages$1(this, r12);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x0095 -> B:30:0x0098). Please report as a decompilation issue!!! */
    public final Object h(Set r10, ContinuationImpl r11) {
        if ((r11 instanceof AIPackageManager$cleanPackagesToDelete$1) == false) goto L7;
        AIPackageManager$cleanPackagesToDelete$1 r5 = (AIPackageManager$cleanPackagesToDelete$1) r11;
        int r12 = r5.f;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r5.f = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r5.d;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r5.f;
        if (r15 == 0) goto L19;
        if (r15 == 1) goto L18;
        if (r15 != 2) goto L13;
        Iterator r16 = r5.f2507c;
        List r17 = r5.f2506b;
        Set r18 = r5.f2505a;
        ResultKt.throwOnFailure(r13);
    L30:
        r17.addAll((List) r13);
    L24:
        if (r16.hasNext() == false) goto L31;
        AIPackage r19 = (AIPackage) r16.next();
        if (r18.contains(r19.f2259b) == true) goto L24;
        AIPackageStorage r20 = AIPackageStorage.f2618a;
        r5.f2505a = r18;
        r5.f2506b = r17;
        r5.f2507c = r16;
        r5.f = 2;
        r13 = r20.a(r19, r5);
        if (r13 != r14) goto L30;
    L29:
        return r14;
    L31:
        List r21 = r17;
    L33:
        if (r21.isEmpty() == true) goto L36;
        BuildersKt.launch$default(h0.a(t2.b.f22089a), null, null, new AIPackageManager$cleanPackagesToDelete$4(r21, null), 3, null);
    L36:
        return Unit.INSTANCE;
    L13:
        if (r15 != 3) goto L16;
        List r22 = r5.f2506b;
        r21 = (List) r5.f2505a;
        ResultKt.throwOnFailure(r13);
        Boxing.boxBoolean(r22.addAll((Collection) r13));
        goto L33
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        r10 = r5.f2505a;
        ResultKt.throwOnFailure(r13);
    L22:
        r17 = new ArrayList();
        r18 = r10;
        r16 = ((List) r13).iterator();
        goto L24
    L19:
        ResultKt.throwOnFailure(r13);
        AIPackageStorage r23 = AIPackageStorage.f2618a;
        r5.f2505a = r10;
        r5.f = 1;
        r13 = r23.b(r5);
        if (r13 != r14) goto L22;
    L7:
        r5 = new AIPackageManager$cleanPackagesToDelete$1(this, r11);
        goto L8
    }
}
