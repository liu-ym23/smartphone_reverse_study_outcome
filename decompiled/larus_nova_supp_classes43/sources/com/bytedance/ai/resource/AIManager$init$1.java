package com.bytedance.ai.resource;

import android.content.Context;
import com.bytedance.ai.resource.core.AIPackageDeployment;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.DownloaderBuilder;
import com.ss.android.socialbase.downloader.service.DownloadServiceLoader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.AIManager$init$1", f = "AIManager.kt", i = {0, 1}, l = {168, 177, 184}, m = "invokeSuspend", n = {"isClient", "isClient"}, s = {"Z$0", "Z$0"})
final class AIManager$init$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ rx7.g $geckoConfigs;
    final /* synthetic */ boolean $isDebug;
    final /* synthetic */ String $storeDir;
    boolean Z$0;
    int label;

    public AIManager$init$1(boolean r1, Context r10, String r11, rx7.g r12, Continuation<? super AIManager$init$1> r13) {
        this.$isDebug = r1;
        this.$context = r10;
        this.$storeDir = r11;
        this.$geckoConfigs = r12;
        super(2, r13);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new AIManager$init$1(this.$isDebug, this.$context, this.$storeDir, this.$geckoConfigs, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r4v10, types: [com.bytedance.ai.resource.u, java.lang.Object] */
    public final Object invokeSuspend(Object r25) {
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L18;
        if (r0 == 1) goto L11;
        if (r0 == 2) goto L10;
        if (r0 != 3) goto L9;
        ResultKt.throwOnFailure(r25);
    L111:
        AIManager r1 = AIManager.a;
        if (AIManager.x() == false) goto L114;
        com.bytedance.ai.utils.g.a.i("AIManager", "Skip permanent AIPackage preload for oversea host");
    L116:
        return Unit.INSTANCE;
    L114:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(com.bytedance.ai.infra.thread_pool.b.a), null, null, new AIManager$loadPermanentAIPackages$1(null), 3, null);
        goto L116
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        boolean r11 = this.Z$0;
        ResultKt.throwOnFailure(r25);
    L47:
        if (AIManager.l == true) goto L49;
    L51:
        boolean r12 = true;
    L52:
        AIManager.m = r12;
        com.bytedance.ai.utils.g r13 = com.bytedance.ai.utils.g.a;
        r13.i("AIManager", "enableGecko: " + AIManager.l + ", enableCustom: " + AIManager.m + ", isClient: " + r11);
        AIPackageManager r14 = AIPackageManager.a;
        Context r15 = this.$context;
        String r16 = this.$storeDir;
        boolean r17 = AIManager.m;
        Set<String> r18 = AIManager.g.keySet();
        CompletableDeferred<Boolean> r19 = AIManager.i;
        r14.getClass();
        Intrinsics.checkNotNullParameter(r15, "context");
        Intrinsics.checkNotNullParameter(r18, "exclusionList");
        Intrinsics.checkNotNullParameter(r19, "customInit");
        String r110 = com.bytedance.ai.resource.core.a.a;
        Intrinsics.checkNotNullParameter(r15, "context");
        if (r16 != null) goto L55;
    L58:
        boolean r111 = true;
    L59:
        if (r111 == false) goto L61;
        r16 = r15.getFilesDir().getPath() + "/ai-sdk-apps";
    L61:
        com.bytedance.ai.resource.core.a.a = r16;
        if (r17 == false) goto L65;
        if (r11 == true) goto L65;
        com.bytedance.ai.resource.core.d r112 = AIPackageManager.b;
        r112.getClass();
        Intrinsics.checkNotNullParameter(r15, "context");
        r112.b = r15.getSharedPreferences("AIPackagePreList", 0);
        ConcurrentHashMap<String, AIPackageDeployment.AIPackageDeploymentItem> r113 = AIPackageDeployment.a;
        Intrinsics.checkNotNullParameter(r15, "context");
        int r114 = a.a;
        Downloader.loadService(new DownloadServiceLoader());
        Downloader.init(new DownloaderBuilder(f2.k.a()));
        r13.d("AIDownloadManager", "init");
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(com.bytedance.ai.infra.thread_pool.b.a), null, null, new AIPackageManager$init$1(r15, r19, r18, null), 3, null);
    L66:
        AppletResourceTool r20 = AppletResourceTool.a;
        final Context r115 = this.$context;
        final String r116 = com.bytedance.ai.resource.core.a.a;
        rx7.g r117 = this.$geckoConfigs;
        if (r117 == null) goto L72;
        r117.c();
        k r118 = new k("gecko.doubao.com");
        Iterator r119 = r117.a().iterator();
    L70:
        if (r119.hasNext() == false) goto L73;
        rx7.f r120 = (rx7.f) r119.next();
        String r121 = r120.a(rx7.h.a());
        ((ArrayList) r118.a).add(new j(r121, r120.d()));
    L73:
        CompletableDeferred<Boolean> r122 = AIManager.j;
        r20.getClass();
        Intrinsics.checkNotNullParameter(r115, "context");
        Intrinsics.checkNotNullParameter(r116, "saveDir");
        Intrinsics.checkNotNullParameter(r122, "geckoInit");
        AppletResourceTool.i = r116;
        ?? r21 = new u(r115, r116);
        n5.a.a.getClass();
        Intrinsics.checkNotNullParameter(r21, "task");
        r21.invoke();
        if (AIManager.m == false) goto L77;
        AppletResourceTool.b(r116);
    L77:
        if (AIManager.l == false) goto L102;
        int r22 = AppletResourceTool.i().getInt("geckoHostVersion", 0);
        int r23 = AppletResourceTool.e;
        if (r22 == r23) goto L81;
        com.bytedance.ai.utils.g.a.i("AppletResourceLoader", "GeckoHostVersion has been changed. clear all hosts in local.");
        AppletResourceTool.i().clear();
        AppletResourceTool.i().storeInt("geckoHostVersion", r23);
    L81:
        if (r118 == null) goto L101;
        AppletResourceTool.a.getClass();
        int r24 = AppletResourceTool.i().getInt("offlineFileVersion", 0);
        int r123 = com.bytedance.ai.settings.b.n.a().intValue();
        if (r24 == r123) goto L100;
        Iterator r26 = AppletResourceTool.i().getAll().keySet().iterator();
    L86:
        if (r26.hasNext() == false) goto L95;
        Object r27 = r26.next();
        String r28 = (String) r27;
        if (Intrinsics.areEqual(r28, "offlineFileVersion") == false) goto L90;
    L92:
        boolean r29 = false;
    L93:
        if (r29 == false) goto L86;
    L97:
        if (com.bytedance.ai.utils.f.g((String) r27) == false) goto L99;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(com.bytedance.ai.infra.thread_pool.b.a), null, null, new AppletResourceTool$forceGeckoUpdate$1(r122, r118, r123, r115, null), 3, null);
    L103:
        AppletResourceTool.h.complete(Boolean.TRUE);
        if (AIManager.m == false) goto L116;
        if (r11 == true) goto L116;
        CompletableDeferred<Boolean> r30 = AIManager.i;
        if (r30.isCompleted() == true) goto L111;
        this.label = 3;
        if (r30.await(this) != r10) goto L111;
        return r10;
    L99:
        AppletResourceTool.i().storeInt("offlineFileVersion", r123);
        r122.complete(Boolean.TRUE);
        goto L103
    L90:
        if (Intrinsics.areEqual(r28, "offlineFileVersion") == true) goto L92;
        r29 = true;
        goto L93
    L95:
        r27 = null;
        goto L97
    L100:
        r122.complete(Boolean.TRUE);
        goto L103
    L101:
        r122.complete(Boolean.TRUE);
        goto L103
    L102:
        r122.complete(Boolean.TRUE);
        goto L103
    L72:
        r118 = null;
    L65:
        r19.complete(Boolean.TRUE);
        goto L66
    L55:
        if (r16.length() == 0) goto L58;
        r111 = false;
        goto L59
    L49:
        if ((!AIManager.n.isEmpty()) == true) goto L51;
        n5.a.a.getClass();
        r12 = false;
        goto L52
    L11:
        boolean r31 = this.Z$0;
        ResultKt.throwOnFailure(r25);     // Catch: Throwable -> L14 Exception -> L16
    L13:
        r11 = r31;
    L43:
        CompletableDeferred<Boolean> r32 = AIManager.k;
        r32.complete(Boxing.boxBoolean(true));
        this.Z$0 = r11;
        this.label = 2;
        if (r32.await(this) != r10) goto L47;
        return r10;
    L16:
        e = e;
    L41:
        com.bytedance.ai.utils.g.a.e("AIManager", "restoreUseCountIfNeeded exception: " + e);     // Catch: Throwable -> L14
        goto L13
    L18:
        ResultKt.throwOnFailure(r25);
        AIManager r33 = AIManager.a;
        AIManager.e = this.$isDebug;
        n5.a.a.getClass();
        AIManager r34 = AIManager.a;
        if (AIManager.x() == true) goto L22;
        com.bytedance.ai.resource.security.h.a.getClass();
        com.bytedance.ai.resource.security.h.b("global_package", "", false);
    L22:
        if (com.bytedance.ai.settings.b.a.a().intValue() != 0) goto L24;
        boolean r35 = true;
    L25:
        AIManager.l = r35;
        Iterator r36 = CollectionsKt.toSet(com.bytedance.ai.settings.b.l.a()).iterator();
    L27:
        if (r36.hasNext() == false) goto L34;
        String r37 = (String) r36.next();
        n5.a.a.getClass();
        if (Intrinsics.areEqual(r37, "com.flow.music.auth") == true) goto L30;
        Boxing.boxBoolean(AIManager.n.add(r37));
        goto L27
    L30:
        AIManager r124 = AIManager.a;
        if (AIManager.w() == false) goto L27;
        AIManager.n.add(r37);
        goto L27
    L34:
        AIManager.o.addAll(CollectionsKt.toSet(com.bytedance.ai.settings.b.p.a()));
        n5.a.C0181a r38 = n5.a.a;     // Catch: Throwable -> L14 Exception -> L39
        this.Z$0 = false;     // Catch: Throwable -> L14 Exception -> L39
        this.label = 1;     // Catch: Throwable -> L14 Exception -> L39
        r38.getClass();     // Catch: Throwable -> L14 Exception -> L39
        if (Unit.INSTANCE != r10) goto L38;
        return r10;
    L38:
        r11 = false;
    L39:
        e = e;
        r31 = false;
        goto L41
    L24:
        r35 = false;
    L14:
        th = move-exception;
        AIManager.k.complete(Boxing.boxBoolean(true));
        throw th;
    }
}
