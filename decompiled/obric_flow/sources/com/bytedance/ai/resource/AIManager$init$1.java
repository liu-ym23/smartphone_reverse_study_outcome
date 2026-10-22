package com.bytedance.ai.resource;

import android.app.Application;
import android.util.Log;
import android.util.LruCache;
import com.bytedance.ai.resource.core.AIPackageConfig;
import com.bytedance.ai.settings.AISDKSettingConfigManager;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
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
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.h0;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.AIManager$init$1", f = "AIManager.kt", i = {0, 1, 2}, l = {139, 148, 163}, m = "invokeSuspend", n = {"isClient", "isClient", "isClient"}, s = {"Z$0", "Z$0", "Z$0"})
@SourceDebugExtension({"SMAP\nAIManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AIManager.kt\ncom/bytedance/ai/resource/AIManager$init$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,1162:1\n1863#2,2:1163\n*S KotlinDebug\n*F\n+ 1 AIManager.kt\ncom/bytedance/ai/resource/AIManager$init$1\n*L\n128#1:1163,2\n*E\n"})
final class AIManager$init$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f2465a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2466b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ul.d f2467c;
    public final /* synthetic */ boolean d;
    public final /* synthetic */ Application e;

    public AIManager$init$1(ul.d r5, boolean r10, Application r11, Continuation r12) {
        this.f2467c = r5;
        this.d = r10;
        this.e = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object r5, Continuation r10) {
        return new AIManager$init$1(this.f2467c, this.d, this.e, r10);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
        return ((AIManager$init$1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Removed unreachable split cross block B:122:0x0156 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r17) {
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = this.f2466b;
        if (r5 == 0) goto L24;
        if (r5 == 1) goto L17;
        if (r5 == 2) goto L16;
        if (r5 != 3) goto L15;
        boolean r11 = this.f2465a;
        ResultKt.throwOnFailure(r17);     // Catch: Throwable -> L10 Exception -> L12
    L98:
        if (j.f2739j == false) goto L101;
        if (r11 == true) goto L101;
        y r12 = y.f2766a;     // Catch: Throwable -> L10 Exception -> L12
        Intrinsics.checkNotNullParameter("LOAD_PERMANENT_AI_PACKAGES", "stage");     // Catch: Throwable -> L10 Exception -> L12
        y.f.set(new x("LOAD_PERMANENT_AI_PACKAGES", null, 6));     // Catch: Throwable -> L10 Exception -> L12
        BuildersKt.launch$default(h0.a(t2.b.f22089a), null, null, new AIManager$loadPermanentAIPackages$1(null), 3, null);     // Catch: Throwable -> L10 Exception -> L12
    L101:
        y r13 = y.f2766a;     // Catch: Throwable -> L10 Exception -> L12
        Intrinsics.checkNotNullParameter("AI_MANAGER_INIT_COMPLETE", "stage");     // Catch: Throwable -> L10 Exception -> L12
        y.f.set(new x("AI_MANAGER_INIT_COMPLETE", null, 6));     // Catch: Throwable -> L10 Exception -> L12
        Intrinsics.checkNotNullParameter("AIManager", "tag");
        t0.d r14 = com.bytedance.ai.utils.c.f2846a;
        if (r14 == null) goto L105;
        r14.i("AIManager", "initialize finally");
    L105:
        Log.i("AIManager", "initialize finally");
        j.f.N(Boxing.boxBoolean(true));
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        r11 = this.f2465a;
        ResultKt.throwOnFailure(r17);
    L74:
        if (j.f2738i == true) goto L76;
    L85:
        boolean r15 = true;
    L86:
        j.f2739j = r15;
        y r16 = y.f2766a;
        String r18 = "enableGecko=" + j.f2738i + ", enableCustom=" + j.f2739j + ", isClient=" + r11;
        Intrinsics.checkNotNullParameter("INITIALIZE_RESOURCES", "stage");
        AtomicReference r19 = y.f;
        r19.set(new x("INITIALIZE_RESOURCES", r18, 6));
        String r20 = "enableGecko: " + j.f2738i + ", enableCustom: " + j.f2739j + ", isClient: " + r11;
        Intrinsics.checkNotNullParameter("AIManager", "tag");
        t0.d r110 = com.bytedance.ai.utils.c.f2846a;
        if (r110 == null) goto L89;
        r110.i("AIManager", r20);
    L89:
        Log.i("AIManager", "enableGecko: " + j.f2738i + ", enableCustom: " + j.f2739j + ", isClient: " + r11);
        Intrinsics.checkNotNullParameter("AI_PACKAGE_CONFIG_INIT", "stage");     // Catch: Throwable -> L10 Exception -> L12
        r19.set(new x("AI_PACKAGE_CONFIG_INIT", null, 6));     // Catch: Throwable -> L10 Exception -> L12
        String r21 = AIPackageConfig.f2571a;     // Catch: Throwable -> L10 Exception -> L12
        AIPackageConfig.a(this.e);     // Catch: Throwable -> L10 Exception -> L12
        Intrinsics.checkNotNullParameter("APPLET_RESOURCE_TOOL_INIT", "stage");     // Catch: Throwable -> L10 Exception -> L12
        r19.set(new x("APPLET_RESOURCE_TOOL_INIT", null, 6));     // Catch: Throwable -> L10 Exception -> L12
        LruCache r22 = e0.f2711a;     // Catch: Throwable -> L10 Exception -> L12
        Application r23 = this.e;     // Catch: Throwable -> L10 Exception -> L12
        String r24 = AIPackageConfig.f2571a;     // Catch: Throwable -> L10 Exception -> L12
        ul.d r25 = this.f2467c;     // Catch: Throwable -> L10 Exception -> L12
        if (r25 == null) goto L93;
        u r26 = j.a(r25);     // Catch: Throwable -> L10 Exception -> L12
    L94:
        e0.i(r23, r24, r26, j.g);     // Catch: Throwable -> L10 Exception -> L12
        Intrinsics.checkNotNullParameter("AI_PACKAGE_MANAGER_INIT", "stage");     // Catch: Throwable -> L10 Exception -> L12
        r19.set(new x("AI_PACKAGE_MANAGER_INIT", null, 6));     // Catch: Throwable -> L10 Exception -> L12
        r r27 = r.f2752a;     // Catch: Throwable -> L10 Exception -> L12
        Application r28 = this.e;     // Catch: Throwable -> L10 Exception -> L12
        boolean r29 = j.f2739j;     // Catch: Throwable -> L10 Exception -> L12
        Set r30 = j.d.keySet();     // Catch: Throwable -> L10 Exception -> L12
        this.f2465a = r11;     // Catch: Throwable -> L10 Exception -> L12
        this.f2466b = 3;     // Catch: Throwable -> L10 Exception -> L12
        if (r27.c(r28, r29, r11, r30, this) != r10) goto L98;
    L96:
        return r10;
    L93:
        r26 = null;
        goto L94
    L76:
        if (j.f2740k.isEmpty() == false) goto L85;
        com.bytedance.ai.multiprocess.a r31 = com.bytedance.ai.multiprocess.d.f2406a;
        if (r31 != null) goto L80;
    L84:
        r15 = false;
        goto L86
    L80:
        if (r31.f2402c == true) goto L85;
        if (r31.d.isEmpty() == true) goto L84;
    L17:
        boolean r32 = this.f2465a;
        ResultKt.throwOnFailure(r17);     // Catch: Throwable -> L20 Exception -> L22
    L118:
    L69:
        kotlinx.coroutines.s r33 = j.f2737h;
        r33.N(Boxing.boxBoolean(true));
        this.f2465a = r32;
        this.f2466b = 2;
        if (r33.d(this) == r10) goto L96;
        r11 = r32;
        goto L74
    L24:
        ResultKt.throwOnFailure(r17);
        y r34 = y.f2766a;
        StringBuilder r35 = new StringBuilder("storeDir=null, hasGeckoConfigs=");
        if (this.f2467c == null) goto L27;
        boolean r36 = true;
    L28:
        r35.append(r36);
        String r37 = r35.toString();
        Intrinsics.checkNotNullParameter("AI_MANAGER_INIT_STARTED", "stage");
        AtomicReference r38 = y.f;
        r38.set(new x("AI_MANAGER_INIT_STARTED", r37, 6));
        j r39 = j.f2734a;
        com.bytedance.ai.multiprocess.a r40 = com.bytedance.ai.multiprocess.d.f2406a;
        if (r40 != null) goto L31;
    L33:
        r32 = false;
    L34:
        if (r32 == true) goto L59;
        Intrinsics.checkNotNullParameter("READ_DOWNLOAD_SETTINGS", "stage");
        r38.set(new x("READ_DOWNLOAD_SETTINGS", "isClient=" + r32, 6));
        AISDKSettingConfigManager r41 = AISDKSettingConfigManager.INSTANCE;
        if (r41.getPACKAGE_DOWNLOAD_TYPE().getValue().intValue() != 0) goto L38;
        boolean r42 = true;
    L39:
        j.f2738i = r42;
        Iterator r43 = CollectionsKt.toSet(r41.getCUSTOM_DOWNLOAD_PACKAGE_LIST().getValue()).iterator();
    L41:
        if (r43.hasNext() == false) goto L58;
        String r44 = (String) r43.next();
        com.bytedance.ai.multiprocess.a r45 = com.bytedance.ai.multiprocess.d.f2406a;
        if (r45 != null) goto L45;
    L55:
        boolean r46 = false;
    L56:
        if (r46 == true) goto L41;
        j.f2740k.add(r44);
        goto L41
    L45:
        if (r45.f2402c == false) goto L47;
        boolean r47 = true;
    L53:
        if (r47 != true) goto L55;
        r46 = true;
        goto L56
    L47:
        if (r44 != null) goto L49;
    L52:
        r47 = false;
        goto L53
    L49:
        if (r44.length() == 0) goto L52;
        r47 = r45.d.contains(r44);
        goto L53
    L58:
        j.f2741l.addAll(CollectionsKt.toSet(AISDKSettingConfigManager.INSTANCE.getFIRST_APP_PACKAGE_LIST().getValue()));
        goto L59
    L38:
        r42 = false;
    L59:
        if (r32 == true) goto L69;
        y r48 = y.f2766a;     // Catch: Throwable -> L20 Exception -> L22
        Intrinsics.checkNotNullParameter("RESTORE_USE_COUNT", "stage");     // Catch: Throwable -> L20 Exception -> L22
        y.f.set(new x("RESTORE_USE_COUNT", null, 6));     // Catch: Throwable -> L20 Exception -> L22
        Application r49 = this.e;     // Catch: Throwable -> L20 Exception -> L22
        this.f2465a = r32;     // Catch: Throwable -> L20 Exception -> L22
        this.f2466b = 1;     // Catch: Throwable -> L20 Exception -> L22
        if (com.bytedance.ai.multiprocess.d.a(r49, this) != r10) goto L118;
    L31:
        if (r40.f2402c != true) goto L33;
        r32 = true;
        goto L34
    L27:
        r36 = false;
    L20:
        th = move-exception;
        j.f2737h.N(Boxing.boxBoolean(true));
        throw th;
    L10:
        th = move-exception;
        Intrinsics.checkNotNullParameter("AIManager", "tag");
        t0.d r50 = com.bytedance.ai.utils.c.f2846a;
        if (r50 == null) goto L116;
        r50.i("AIManager", "initialize finally");
    L116:
        Log.i("AIManager", "initialize finally");
        j.f.N(Boxing.boxBoolean(true));
        throw th;
    L12:
        e = move-exception;
        y r51 = y.f2766a;     // Catch: Throwable -> L10
        String r52 = e.getClass().getName() + ": " + e.getMessage();     // Catch: Throwable -> L10
        Intrinsics.checkNotNullParameter("AI_MANAGER_INIT_FAILED", "stage");     // Catch: Throwable -> L10
        y.f.set(new x("AI_MANAGER_INIT_FAILED", r52, 6));     // Catch: Throwable -> L10
        Intrinsics.checkNotNullParameter("AIManager", "tag");     // Catch: Throwable -> L10
        t0.d r53 = com.bytedance.ai.utils.c.f2846a;     // Catch: Throwable -> L10
        if (r53 == null) goto L111;
        r53.e("AIManager", "initialize failed", e);     // Catch: Throwable -> L10
    L111:
        Log.e("AIManager", "initialize failed", e);     // Catch: Throwable -> L10
        throw e;     // Catch: Throwable -> L10
    L22:
        e = move-exception;
        String r54 = "restoreUseCountIfNeeded exception: " + e;     // Catch: Throwable -> L20
        Intrinsics.checkNotNullParameter("AIManager", "tag");     // Catch: Throwable -> L20
        t0.d r55 = com.bytedance.ai.utils.c.f2846a;     // Catch: Throwable -> L20
        if (r55 == null) goto L118;
        r55.e("AIManager", r54);     // Catch: Throwable -> L20
        goto L118
    }
}
