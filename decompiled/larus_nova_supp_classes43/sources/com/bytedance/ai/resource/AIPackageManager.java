package com.bytedance.ai.resource;

import android.content.Context;
import com.byted.mgl.merge.service.api.aweme.BdpAwemeConstant;
import com.bytedance.ai.debug.IAISDKDebugService;
import com.bytedance.ai.debug.IAISDKDebugService$DebugMode;
import com.bytedance.ai.model.objects.AIPackage;
import com.bytedance.ai.resource.core.AIPackageDeployment;
import com.bytedance.ai.resource.core.AIPackageOperationGroup;
import com.bytedance.ai.resource.core.AIPackageStorage;
import com.bytedance.ai.resource.core.bean.AIPackageAppList;
import com.bytedance.ai.resource.core.bean.AIPackageGeckoInfoItem;
import com.bytedance.ai.resource.core.bean.AIPackageGeckoInfoList;
import com.bytedance.ai.resource.core.bean.AIPackageGeckoInfoRequest;
import com.bytedance.ai.resource.core.bean.AIPackageNetworkRequest;
import com.bytedance.ai.resource.core.bean.AIPackageNetworkResponse;
import com.bytedance.ai.resource.core.bean.AIPackageResponseItem;
import com.bytedance.ai.resource.core.bean.PackageRequestItem;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Charsets;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class AIPackageManager {
    public static final AIPackageManager a = null;
    public static final com.bytedance.ai.resource.core.d b = null;
    public static final ConcurrentHashMap<String, AIPackageOperationGroup> c = null;

    public static class a {
        private String appId;
        private String packageName;

        public a() {
            String r0 = null;
            this(r0, r0, 3, r0);
        }

        public int hashCode() {
            return (this.appId.hashCode() * 31) + this.packageName.hashCode();
        }

        public final String getAppId() {
            return this.appId;
        }

        public final String getPackageName() {
            return this.packageName;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L5;
            return true;
        L5:
            Class<?> r1 = getClass();
            if (r10 == null) goto L8;
            Class<?> r11 = r10.getClass();
        L10:
            if (Intrinsics.areEqual(r1, r11) == true) goto L12;
            return false;
        L12:
            Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type com.bytedance.ai.resource.AIPackageManager.AIPackageItem");
            a r12 = (a) r10;
            if (Intrinsics.areEqual(this.appId, r12.appId) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.packageName, r12.packageName) == true) goto L18;
            return false;
        L18:
            return true;
        L8:
            r11 = null;
            goto L10
        }

        public final void setAppId(String r10) {
            Intrinsics.checkNotNullParameter(r10, "<set-?>");
            this.appId = r10;
        }

        public final void setPackageName(String r10) {
            Intrinsics.checkNotNullParameter(r10, "<set-?>");
            this.packageName = r10;
        }

        public a(String r10, String r11) {
            Intrinsics.checkNotNullParameter(r10, BdpAwemeConstant.KEY_APP_ID);
            Intrinsics.checkNotNullParameter(r11, "packageName");
            this.appId = r10;
            this.packageName = r11;
        }

        public /* synthetic */ a(String r10, String r11, int r12, DefaultConstructorMarker r13) {
            if ((r12 & 1) == 0) goto L6;
            r10 = "";
        L6:
            if ((r12 & 2) == 0) goto L8;
            r11 = "";
        L8:
            this(r10, r11);
        }
    }

    public interface b {
        void a(AIPackage r1, String r10, String r11, AIPackage.AIPackageType r12, int r13, String r14);
    }

    public AIPackageManager() {
    }

    static {
        a = new AIPackageManager();
        b = new com.bytedance.ai.resource.core.d();
        c = new ConcurrentHashMap();
    }

    public static AIPackageAppList g(List r10) {
        Intrinsics.checkNotNullParameter(r10, "appRequestList");
        AIPackageNetworkRequest r0 = new AIPackageNetworkRequest(r10, null, null, 6, null);
        Lazy r11 = o5.b.a;
        Intrinsics.checkNotNullParameter(r0, "request");
        AIPackageNetworkResponse<AIPackageAppList> r12 = o5.b.a().requestUpdateInfo(r0);
        if (r12.getCode() != 0) goto L5;
        boolean r1 = true;
    L7:
        if (r1 == true) goto L10;
        com.bytedance.ai.utils.g.a.e("AIPackageManager", "Failed to obtain the update list : code = " + r12.getCode() + ", msg = " + r12.getMsg());
        return null;
    L10:
        AIPackageAppList r13 = r12.getData();
        com.bytedance.ai.utils.g.a.i("AIPackageManager", "Succeeded to obtain the update list : " + r13);
        return r13;
    L5:
        r1 = false;
        goto L7
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0085 -> B:21:0x0086). Please report as a decompilation issue!!! */
    public final Object e(Continuation<? super List<d0>> r10) {
        if ((r10 instanceof AIPackageManager$getAllInstalledPackageListFromGecko$1) == false) goto L7;
        AIPackageManager$getAllInstalledPackageListFromGecko$1 r0 = (AIPackageManager$getAllInstalledPackageListFromGecko$1) r10;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r11 = r0.result;
        Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r13 = r0.label;
        if (r13 == 0) goto L14;
        if (r13 != 1) goto L13;
        List r14 = (List) r0.L$3;
        Iterator r15 = (Iterator) r0.L$2;
        List r16 = (List) r0.L$1;
        List r17 = (List) r0.L$0;
        ResultKt.throwOnFailure(r11);
    L21:
        r14.add(r11);
        r14 = r16;
    L16:
        if (r15.hasNext() == false) goto L22;
        String r18 = (String) r15.next();
        AIPackageManager r19 = a;
        r0.L$0 = r17;
        r0.L$1 = r14;
        r0.L$2 = r15;
        r0.L$3 = r14;
        r0.label = 1;
        r11 = r19.l(r18, r0);
        if (r11 != r12) goto L20;
        return r12;
    L20:
        r16 = r14;
        goto L21
    L22:
        Iterator r20 = r14.iterator();
    L24:
        if (r20.hasNext() == false) goto L28;
        d0 r21 = (d0) ((Pair) r20.next()).getFirst();
        if (r21 == null) goto L24;
        r17.add(r21);
        goto L24
    L28:
        return r17;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r11);
        ArrayList r22 = new ArrayList();
        r14 = new ArrayList();
        AppletResourceTool.a.getClass();
        r15 = AppletResourceTool.i().getAll().keySet().iterator();
        r17 = r22;
    L7:
        r0 = new AIPackageManager$getAllInstalledPackageListFromGecko$1(this, r10);
        goto L8
    }

    public static final String b(AIPackageManager r10, String r11) {
        r10.getClass();
        AppletResourceTool.a.getClass();
        String r12 = AppletResourceTool.h(r11);
        boolean r0 = false;
        if (r12 != null) goto L5;
    L8:
        boolean r13 = true;
    L9:
        if (r13 == false) goto L32;
        com.bytedance.ai.utils.g r14 = com.bytedance.ai.utils.g.a;
        r14.i("AIPackageManager", "try to get baseUrl from remote. packageName: ".concat(r11));
        Lazy r15 = o5.b.a;
        AIPackageGeckoInfoRequest r16 = new AIPackageGeckoInfoRequest(CollectionsKt.listOf(new PackageRequestItem(r11, null, 2, null)), null, 2, null);
        Intrinsics.checkNotNullParameter(r16, "request");
        AIPackageNetworkResponse<AIPackageGeckoInfoList> r17 = o5.b.a().requestGeckoInfo(r16);
        if (r17.getCode() != 0) goto L13;
        boolean r18 = true;
    L14:
        if (r18 == false) goto L24;
        AIPackageGeckoInfoList r19 = r17.getData();
        if (r19 == null) goto L25;
        List<AIPackageGeckoInfoItem> r20 = r19.getAppList();
        if (r20 == null) goto L25;
        AIPackageGeckoInfoItem r21 = (AIPackageGeckoInfoItem) CollectionsKt.firstOrNull(r20);
        if (r21 == null) goto L25;
        List<String> r22 = r21.getBaseUrls();
        if (r22 == null) goto L25;
        r12 = (String) CollectionsKt.firstOrNull(r22);
    L26:
        if (r12 != null) goto L28;
    L29:
        r0 = true;
    L30:
        if (r0 == true) goto L32;
        Intrinsics.checkNotNullParameter(r11, "packageName");
        Intrinsics.checkNotNullParameter(r12, "baseUrl");
        AppletResourceTool.b.put(r11, r12);
        AppletResourceTool.i().storeString(r11, r12);
        goto L32
    L28:
        if (r12.length() != 0) goto L30;
    L25:
        r12 = null;
        goto L26
    L24:
        r14.e("AIPackageManager", "failed to get remote baseUrl. packageName: ".concat(r11));
        goto L25
    L13:
        r18 = false;
    L32:
        return r12;
    L5:
        if (r12.length() == 0) goto L8;
        r13 = false;
        goto L9
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x0102 -> B:36:0x0103). Please report as a decompilation issue!!! */
    public final Object f(List<? extends AIPackage> r18, Continuation<? super List<String>> r19) {
        if ((r19 instanceof AIPackageManager$getFileListToRemoved$1) == false) goto L7;
        AIPackageManager$getFileListToRemoved$1 r1 = (AIPackageManager$getFileListToRemoved$1) r19;
        int r10 = r1.label;
        if ((r10 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r10 - Integer.MIN_VALUE;
    L8:
        Object r0 = r1.result;
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = r1.label;
        if (r12 == 0) goto L18;
        if (r12 == 1) goto L17;
        if (r12 == 2) goto L16;
        if (r12 != 3) goto L15;
        Iterator r13 = (Iterator) r1.L$1;
        List r14 = (List) r1.L$0;
        ResultKt.throwOnFailure(r0);
    L36:
        Boxing.boxBoolean(r14.addAll((List) r0));
        List r15 = r14;
    L20:
        if (r13.hasNext() == false) goto L38;
        AIPackage r16 = (AIPackage) r13.next();
        AIPackageStorage r17 = AIPackageStorage.a;
        a r110 = new a(r16.a(), r16.b);
        AIPackage.AIPackageType r111 = r16.c();
        long r112 = r16.c;
        r1.L$0 = r15;
        r1.L$1 = r13;
        r1.L$2 = r16;
        r1.L$3 = null;
        r1.label = 1;
        Object r20 = r17.k(r110, r111, false, r112, r1);
        if (r20 != r11) goto L24;
        return r11;
    L24:
        List r113 = r15;
        Iterator r114 = r13;
        r0 = r20;
        AIPackage r21 = r16;
    L25:
        AIPackage r22 = (AIPackage) r0;
        AIPackageStorage r23 = AIPackageStorage.a;
        a r115 = new a(r21.a(), r21.b);
        AIPackage.AIPackageType r116 = r21.c();
        long r117 = r21.c;
        r1.L$0 = r113;
        r1.L$1 = r114;
        r1.L$2 = r21;
        r1.L$3 = r22;
        r1.label = 2;
        List r118 = r113;
        Object r24 = r23.h(r115, r116, r117, r1);
        if (r24 != r11) goto L28;
        return r11;
    L28:
        AIPackage r119 = r21;
        AIPackage r25 = r22;
        r0 = r24;
        r14 = r118;
    L29:
        AIPackage r26 = (AIPackage) r0;
        if (r25 != null) goto L37;
        if (r26 != null) goto L37;
        AIPackageStorage r27 = AIPackageStorage.a;
        r1.L$0 = r14;
        r1.L$1 = r114;
        r1.L$2 = null;
        r1.L$3 = null;
        r1.label = 3;
        r0 = r27.c(r119, r1);
        if (r0 != r11) goto L35;
        return r11;
    L35:
        r13 = r114;
        goto L36
    L37:
        com.bytedance.ai.utils.g.a.w("AIPackageManager", "current package is installed in local. ignore to remove it: packageName: " + r119.b + ", versionCode: " + r119.c);
        r15 = r14;
        r13 = r114;
        goto L20
    L39:
        com.bytedance.ai.utils.g.a.w("AIPackageManager", "current package is installed in local. ignore to remove it: packageName: " + r119.b + ", versionCode: " + r119.c);
        r15 = r14;
        r13 = r114;
        goto L20
    L38:
        return r15;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        r25 = (AIPackage) r1.L$3;
        AIPackage r28 = (AIPackage) r1.L$2;
        Iterator r120 = (Iterator) r1.L$1;
        List r121 = (List) r1.L$0;
        ResultKt.throwOnFailure(r0);
        r114 = r120;
        r119 = r28;
        r14 = r121;
        goto L29
    L17:
        r21 = (AIPackage) r1.L$2;
        Iterator r29 = (Iterator) r1.L$1;
        List r122 = (List) r1.L$0;
        ResultKt.throwOnFailure(r0);
        r114 = r29;
        r113 = r122;
        goto L25
    L18:
        ResultKt.throwOnFailure(r0);
        r15 = new ArrayList();
        r13 = r18.iterator();
    L7:
        r1 = new AIPackageManager$getFileListToRemoved$1(this, r19);
        goto L8
    }

    public final Object l(String r10, Continuation<? super Pair<d0, String>> r11) {
        if ((r11 instanceof AIPackageManager$installPackageFromGecko$1) == false) goto L7;
        AIPackageManager$installPackageFromGecko$1 r0 = (AIPackageManager$installPackageFromGecko$1) r11;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r12 = r0.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r14 = r0.label;
        String r15 = null;
        if (r14 == 0) goto L15;
        if (r14 != 1) goto L14;
        ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L21
    L19:
        Object r16 = Result.constructor-impl((d0) r12);     // Catch: Throwable -> L21
    L24:
        if (Result.isFailure-impl(r16) == false) goto L26;
        Object r17 = null;
    L27:
        Throwable r18 = Result.exceptionOrNull-impl(r16);
        if (r18 == null) goto L31;
        r15 = r18.getMessage();
    L31:
        return TuplesKt.to(r17, r15);
    L26:
        r17 = r16;
        goto L27
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r12);
        Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L21
        r0.label = 1;     // Catch: Throwable -> L21
        r12 = BuildersKt.withContext(com.bytedance.ai.infra.thread_pool.b.a, new AIPackageManager$getInstallPackageFromGeckoJob$2(r10, null), r0);     // Catch: Throwable -> L21
        if (r12 != r13) goto L19;
        return r13;
    L21:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r0 = new AIPackageManager$installPackageFromGecko$1(this, r11);
        goto L8
    }

    public final Object n(List<? extends AIPackage> r11, Continuation<? super Boolean> r12) {
        if ((r12 instanceof AIPackageManager$uninstallAIPackagesWithVersionCodeInMemory$1) == false) goto L7;
        AIPackageManager$uninstallAIPackagesWithVersionCodeInMemory$1 r0 = (AIPackageManager$uninstallAIPackagesWithVersionCodeInMemory$1) r12;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r13 = r0.result;
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r14 = r0.label;
        if (r14 == 0) goto L16;
        if (r14 == 1) goto L15;
        if (r14 != 2) goto L14;
        List r15 = (List) r0.L$0;
        ResultKt.throwOnFailure(r13);
    L26:
        return r13;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r13);
    L19:
        List r16 = (List) r13;
        if ((!r16.isEmpty()) == false) goto L28;
        r0.L$0 = r16;
        r0.label = 2;
        kotlinx.coroutines.j r17 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r0), 1);
        r17.C();
        Ref.BooleanRef r18 = new Ref.BooleanRef();
        r18.element = true;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(com.bytedance.ai.infra.thread_pool.b.a), null, null, new AIPackageManager$uninstallAIPackagesWithVersionCodeInMemory$2$1(r16, r17, r18, null), 3, null);
        r13 = r17.B();
        if (r13 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L24;
        DebugProbesKt.probeCoroutineSuspended(r0);
    L24:
        if (r13 != r10) goto L26;
        return r10;
    L28:
        return Boxing.boxBoolean(true);
    L16:
        ResultKt.throwOnFailure(r13);
        r0.label = 1;
        r13 = f(r11, r0);
        if (r13 != r10) goto L19;
        return r10;
    L7:
        r0 = new AIPackageManager$uninstallAIPackagesWithVersionCodeInMemory$1(this, r12);
        goto L8
    }

    public static final Object c(AIPackageManager r17, Context r18, Continuation r19) {
        r17.getClass();
        if ((r19 instanceof AIPackageManager$loadBuiltInAIPackages$1) == false) goto L7;
        AIPackageManager$loadBuiltInAIPackages$1 r1 = (AIPackageManager$loadBuiltInAIPackages$1) r19;
        int r10 = r1.label;
        if ((r10 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r10 - Integer.MIN_VALUE;
    L8:
        Object r0 = r1.result;
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = r1.label;
        if (r12 == 0) goto L16;
        if (r12 == 1) goto L15;
        if (r12 != 2) goto L14;
        ResultKt.throwOnFailure(r0);
    L110:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        List r13 = (List) r1.L$0;
        ResultKt.throwOnFailure(r0);
    L57:
        List r14 = (List) r0;
        ArrayList r15 = new ArrayList();
        Iterator r16 = r13.iterator();
    L59:
        if (r16.hasNext() == false) goto L81;
        Object r20 = r16.next();
        AIPackageDeployment.AIPackageDeploymentItem r21 = (AIPackageDeployment.AIPackageDeploymentItem) r20;
        List r110 = r14;
        if ((r110 instanceof Collection) == true) goto L63;
    L65:
        Iterator r111 = r110.iterator();
    L67:
        if (r111.hasNext() == false) goto L78;
        AIPackage r112 = (AIPackage) r111.next();
        boolean r113 = false;
        if (Intrinsics.areEqual(r112.b, r21.getPackageName()) == true) goto L71;
    L75:
        boolean r114 = false;
    L76:
        if (r114 == false) goto L67;
    L79:
        if (r113 == false) goto L59;
        r15.add(r20);
        goto L59
    L71:
        if (Intrinsics.areEqual(r112.a(), r21.getAppId()) == false) goto L75;
        if (r112.c < r21.getVersionCode()) goto L75;
        r114 = true;
    L78:
        r113 = true;
        goto L79
    L63:
        if (r110.isEmpty() == false) goto L65;
    L81:
        ArrayList r22 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r15, 10));
        Iterator r23 = r15.iterator();
    L83:
        if (r23.hasNext() == false) goto L85;
        AIPackageDeployment.AIPackageDeploymentItem r24 = (AIPackageDeployment.AIPackageDeploymentItem) r23.next();
        r24.setResourceUrl("local://urlPlaceHolder/");
        r22.add(BuildersKt.async$default(CoroutineScopeKt.CoroutineScope(com.bytedance.ai.infra.thread_pool.b.a), null, null, new AIPackageManager$loadBuiltInAIPackages$3$1(r24, null), 3, null));
        goto L83
    L85:
        r1.L$0 = null;
        r1.label = 2;
        if (AwaitKt.a(r22, r1) != r11) goto L110;
        return r11;
    L16:
        ResultKt.throwOnFailure(r0);
        InputStream r25 = r18.getAssets().open("pre-install_info.json");     // Catch: Exception -> L45
        Intrinsics.checkNotNull(r25);     // Catch: Throwable -> L38
        Reader r26 = new InputStreamReader(r25, Charsets.UTF_8);     // Catch: Throwable -> L38
        if ((r26 instanceof BufferedReader) == false) goto L22;
        BufferedReader r27 = (BufferedReader) r26;     // Catch: Throwable -> L38
    L95:
        String r28 = TextStreamsKt.readText(r27);     // Catch: Throwable -> L31
        CloseableKt.closeFinally(r27, null);     // Catch: Throwable -> L38
        List r29 = (List) new Gson().fromJson(r28, new h().getType());     // Catch: Throwable -> L38
        if (r29 == null) goto L28;
        com.bytedance.ai.utils.g.a.d("AIPackageManager", "Loaded local pre-install list: " + r29 + " items");     // Catch: Throwable -> L38
    L29:
        CloseableKt.closeFinally(r25, null);     // Catch: Exception -> L45
    L47:
        if (r29 == null) goto L90;
        if ((!r29.isEmpty()) == false) goto L51;
        r13 = r29;
    L52:
        if (r13 == null) goto L90;
        AIPackageStorage r30 = AIPackageStorage.a;
        r1.L$0 = r13;
        r1.label = 1;
        r0 = r30.o(AIPackage.AIPackageType.UNKNOWN, r1);
        if (r0 != r11) goto L57;
        return r11;
    L51:
        r13 = null;
    L90:
        return Unit.INSTANCE;
    L28:
        r29 = null;
        goto L29
    L31:
        th = move-exception;
        throw th;     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        CloseableKt.closeFinally(r27, th);     // Catch: Throwable -> L38
        throw th;     // Catch: Throwable -> L38
    L22:
        r27 = new BufferedReader(r26, 8192);     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        throw th;     // Catch: Throwable -> L41
    L41:
        th = move-exception;
        CloseableKt.closeFinally(r25, th);     // Catch: Exception -> L45
        throw th;     // Catch: Exception -> L45
    L45:
        e = move-exception;
        com.bytedance.ai.utils.g.a.e("AIPackageManager", "Failed to load local pre-install list: " + e.getMessage());
        r29 = null;
    L7:
        r1 = new AIPackageManager$loadBuiltInAIPackages$1(r17, r19);
        goto L8
    }

    public static final String d(AIPackageManager r0, int r1, List r10) {
        r0.getClass();
        if (r1 != IAISDKDebugService$DebugMode.SCAN_PREVIEW.getValue()) goto L11;
        if (r10 == null) goto L8;
        boolean r11 = true;
        if ((!r10.isEmpty()) != true) goto L8;
    L9:
        if (r11 == false) goto L11;
        return "scan";
    L8:
        r11 = false;
    L11:
        return "normal";
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final Object k(List r11, AIManager$loadPermanentAIPackages$1.a r12, Continuation r13) {
        if ((r13 instanceof AIPackageManager$installAIPackages$1) == false) goto L7;
        AIPackageManager$installAIPackages$1 r0 = (AIPackageManager$installAIPackages$1) r13;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r14 = r0.result;
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r0.label;
        if (r15 == 0) goto L16;
        if (r15 == 1) goto L15;
        if (r15 == 2) goto L15;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        Iterator r16 = (Iterator) r0.L$1;
        b r17 = (b) r0.L$0;
        ResultKt.throwOnFailure(r14);
        b r18 = r17;
    L18:
        if (r16.hasNext() == false) goto L35;
        a r19 = (a) r16.next();
        if (Intrinsics.areEqual(r19.getPackageName(), "db_YzR3DO") == true) goto L21;
        AIPackageManager r20 = a;
        r0.L$0 = r18;
        r0.L$1 = r16;
        r0.label = 2;
        if (r20.h(r19, 0, r18, r0) != r10) goto L18;
        return r10;
    L21:
        AIPackageManager r21 = a;
        if ((r19 instanceof AIPackageDeployment.AIPackageDeploymentItem) == false) goto L24;
        AIPackageDeployment.AIPackageDeploymentItem r110 = (AIPackageDeployment.AIPackageDeploymentItem) r19;
    L25:
        if (r110 == null) goto L27;
        long r22 = r110.getVersionCode();
    L28:
        r0.L$0 = r18;
        r0.L$1 = r16;
        r0.label = 1;
        if (r21.h(r19, r22, r18, r0) != r10) goto L18;
        return r10;
    L27:
        r22 = 0;
        goto L28
    L24:
        r110 = null;
        goto L25
    L35:
        return Unit.INSTANCE;
    L16:
        ResultKt.throwOnFailure(r14);
        r16 = r11.iterator();
        r18 = r12;
    L7:
        r0 = new AIPackageManager$installAIPackages$1(this, r13);
        goto L8
    }

    public final Object m(AIPackageAppList r10, b r11, Continuation<? super Unit> r12) {
        if ((r12 instanceof AIPackageManager$onUpdateAIPackages$1) == false) goto L7;
        AIPackageManager$onUpdateAIPackages$1 r0 = (AIPackageManager$onUpdateAIPackages$1) r12;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r13 = r0.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r0.label;
        if (r15 == 0) goto L14;
        if (r15 != 1) goto L13;
        AIPackageDeployment.AIPackageDeploymentItem r16 = (AIPackageDeployment.AIPackageDeploymentItem) r0.L$2;
        Iterator<AIPackageResponseItem> r17 = (Iterator) r0.L$1;
        r11 = (b) r0.L$0;
        ResultKt.throwOnFailure(r13);
    L18:
        if (r17.hasNext() == false) goto L46;
        AIPackageDeployment.AIPackageDeploymentItem r18 = AIPackageDeployment.c(r17.next());
        if (r18 == null) goto L18;
        AIPackageManager r19 = a;
        r0.L$0 = r11;
        r0.L$1 = r17;
        r0.L$2 = r18;
        r0.label = 1;
        r19.getClass();
        String r20 = r18.getPackageName();
        com.bytedance.ai.utils.g.a.d("AIPackageManager", "packageName: " + r18.getPackageName() + ", appId: " + r18.getAppId() + " ===> updateAIPackage start");
        if (r18.getVersionCode() != (-1)) goto L33;
        ConcurrentHashMap<String, AIPackageOperationGroup> r21 = c;
        AIPackageOperationGroup r22 = r21.get(r20);
        if (r22 != null) goto L29;
        r22 = new AIPackageOperationGroup();
        AIPackageOperationGroup r23 = r21.putIfAbsent(r20, r22);
        if (r23 == null) goto L29;
        r22 = r23;
    L29:
        Object r110 = r22.l(r18, r11, r0);
        if (r110 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L43;
        r110 = Unit.INSTANCE;
    L43:
        if (r110 != r14) goto L18;
        return r14;
    L33:
        ConcurrentHashMap<String, AIPackageOperationGroup> r24 = c;
        AIPackageOperationGroup r25 = r24.get(r20);
        if (r25 != null) goto L39;
        r25 = new AIPackageOperationGroup();
        AIPackageOperationGroup r26 = r24.putIfAbsent(r20, r25);
        if (r26 == null) goto L39;
        r25 = r26;
    L39:
        r110 = r25.m(r18, r11, r0);
        if (r110 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L43;
        r110 = Unit.INSTANCE;
    L46:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r13);
        if (r10 == null) goto L46;
        r17 = r10.getAppList().iterator();
    L7:
        r0 = new AIPackageManager$onUpdateAIPackages$1(this, r12);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x00b7 -> B:30:0x00bb). Please report as a decompilation issue!!! */
    public static final Object a(AIPackageManager r10, CompletableDeferred r11, Set r12, Continuation r13) {
        r10.getClass();
        if ((r13 instanceof AIPackageManager$cleanPackagesToDelete$1) == false) goto L7;
        AIPackageManager$cleanPackagesToDelete$1 r0 = (AIPackageManager$cleanPackagesToDelete$1) r13;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r14 = r0.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r0.label;
        if (r16 == 0) goto L18;
        if (r16 == 1) goto L17;
        if (r16 == 2) goto L16;
        if (r16 != 3) goto L15;
        List r17 = (List) r0.L$2;
        List r18 = (List) r0.L$1;
        CompletableDeferred r19 = (CompletableDeferred) r0.L$0;
        ResultKt.throwOnFailure(r14);
    L37:
        Boxing.boxBoolean(r17.addAll((Collection) r14));
        List r20 = r18;
    L38:
        r19.complete(Boxing.boxBoolean(true));
        if ((!r20.isEmpty()) == false) goto L42;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(com.bytedance.ai.infra.thread_pool.b.a), null, null, new AIPackageManager$cleanPackagesToDelete$4(r20, null), 3, null);
    L42:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        Iterator r110 = (Iterator) r0.L$3;
        List r111 = (List) r0.L$2;
        Set r21 = (Set) r0.L$1;
        CompletableDeferred r22 = (CompletableDeferred) r0.L$0;
        ResultKt.throwOnFailure(r14);
        r20 = r111;
        r12 = r21;
    L30:
        r20.addAll((List) r14);
        Object r112 = r15;
        r19 = r22;
    L23:
        if (r110.hasNext() == false) goto L31;
        AIPackage r23 = (AIPackage) r110.next();
        if (r12.contains(r23.b) == true) goto L23;
        AIPackageStorage r24 = AIPackageStorage.a;
        r0.L$0 = r19;
        r0.L$1 = r12;
        r0.L$2 = r20;
        r0.L$3 = r110;
        r0.label = 2;
        Object r25 = r24.a(r23, r0);
        if (r25 == r112) goto L47;
        CompletableDeferred r26 = r19;
        r15 = r112;
        r14 = r25;
        r22 = r26;
    L47:
        return r112;
    L31:
        List<? extends AIPackage> r113 = IAISDKDebugService.a.a();
        if (r113 == null) goto L38;
        AIPackageManager r114 = a;
        r0.L$0 = r19;
        r0.L$1 = r20;
        r0.L$2 = r20;
        r0.L$3 = null;
        r0.label = 3;
        Object r115 = r114.f(r113, r0);
        if (r115 == r112) goto L47;
        r14 = r115;
        r17 = r20;
        r18 = r17;
        goto L37
    L17:
        r12 = (Set) r0.L$1;
        r11 = (CompletableDeferred) r0.L$0;
        ResultKt.throwOnFailure(r14);
    L21:
        r20 = new ArrayList();
        CompletableDeferred r27 = r11;
        r110 = ((List) r14).iterator();
        r112 = r15;
        r19 = r27;
        goto L23
    L18:
        ResultKt.throwOnFailure(r14);
        AIPackageStorage r116 = AIPackageStorage.a;
        r0.L$0 = r11;
        r0.L$1 = r12;
        r0.label = 1;
        r14 = r116.p(r0);
        if (r14 != r15) goto L21;
        return r15;
    L7:
        r0 = new AIPackageManager$cleanPackagesToDelete$1(r10, r13);
        goto L8
    }

    public final Object h(a r10, long r11, b r12, Continuation<? super Unit> r13) {
        Object r14 = i(r10, r11, r12, false, r13);
        if (r14 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r14;
    L6:
        return Unit.INSTANCE;
    }

    public static Object i(a r19, long r20, b r22, boolean r23, Continuation r24) {
        String r10 = r19.getPackageName();
        com.bytedance.ai.utils.g.a.i("AIPackageManager", "packageName: " + r19.getPackageName() + ", appId: " + r19.getAppId() + ", onlyInMemory: " + r23 + " ===> installAIPackage start");
        if ((r19 instanceof AIPackageDeployment.AIPackageDeploymentItem) == false) goto L5;
        AIPackageDeployment.AIPackageDeploymentItem r11 = (AIPackageDeployment.AIPackageDeploymentItem) r19;
    L6:
        if (r11 != null) goto L8;
        r11 = new AIPackageDeployment.AIPackageDeploymentItem(r19.getAppId(), r19.getPackageName(), r20, null, null, null, false, null, null, 504, null);
    L8:
        if (r23 == false) goto L20;
        ConcurrentHashMap<String, AIPackageOperationGroup> r0 = c;
        AIPackageOperationGroup r12 = r0.get(r10);
        if (r12 != null) goto L15;
        r12 = new AIPackageOperationGroup();
        AIPackageOperationGroup r1 = r0.putIfAbsent(r10, r12);
        if (r1 == null) goto L15;
        r12 = r1;
    L15:
        Object r13 = AIPackageOperationGroup.h(r12, r11, r22, r24);
        if (r13 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L19;
        return r13;
    L19:
        return Unit.INSTANCE;
    L20:
        ConcurrentHashMap<String, AIPackageOperationGroup> r14 = c;
        AIPackageOperationGroup r15 = r14.get(r10);
        if (r15 != null) goto L26;
        r15 = new AIPackageOperationGroup();
        AIPackageOperationGroup r16 = r14.putIfAbsent(r10, r15);
        if (r16 == null) goto L26;
        r15 = r16;
    L26:
        Object r17 = AIPackageOperationGroup.g(r15, r11, r22, r24);
        if (r17 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L30;
        return r17;
    L30:
        return Unit.INSTANCE;
    L5:
        r11 = null;
        goto L6
    }

    public static /* synthetic */ Object j(AIPackageManager r10, a r11, long r12, b r13, Continuation r14) {
        r10.getClass();
        return i(r11, r12, r13, false, r14);
    }
}
