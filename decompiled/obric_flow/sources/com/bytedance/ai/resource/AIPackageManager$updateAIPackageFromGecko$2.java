package com.bytedance.ai.resource;

import android.net.Uri;
import android.util.LruCache;
import com.bytedance.forest.chain.fetchers.GeckoXAdapter;
import com.bytedance.geckox.OptionCheckUpdateParams;
import com.bytedance.geckox.model.CheckRequestBodyModel;
import com.bytedance.geckox.settings.model.GlobalConfigSettings;
import com.lynx.serval.svg.SVGRenderEngine;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.AIPackageManager$updateAIPackageFromGecko$2", f = "AIPackageManager.kt", i = {0, 0, 0, 0}, l = {730}, m = "invokeSuspend", n = {"$this$withContext", "manifestPath", SVGRenderEngine.PATH, "$completion$iv"}, s = {"L$0", "L$1", "L$3", "L$4"})
@SourceDebugExtension({"SMAP\nAIPackageManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AIPackageManager.kt\ncom/bytedance/ai/resource/AIPackageManager$updateAIPackageFromGecko$2\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,729:1\n318#2,11:730\n*S KotlinDebug\n*F\n+ 1 AIPackageManager.kt\ncom/bytedance/ai/resource/AIPackageManager$updateAIPackageFromGecko$2\n*L\n349#1:730,11\n*E\n"})
final class AIPackageManager$updateAIPackageFromGecko$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f2529a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2530b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f2531c;
    public final /* synthetic */ String d;

    public AIPackageManager$updateAIPackageFromGecko$2(String r5, Continuation r10) {
        this.d = r5;
        super(2, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object r5, Continuation r10) {
        AIPackageManager$updateAIPackageFromGecko$2 r11 = new AIPackageManager$updateAIPackageFromGecko$2(this.d, r10);
        r11.f2531c = r5;
        return r11;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo2invoke(CoroutineScope r5, Continuation<? super Boolean> r10) {
        String r11 = this.d;
        AIPackageManager$updateAIPackageFromGecko$2 r12 = new AIPackageManager$updateAIPackageFromGecko$2(r11, r10);
        r12.f2531c = r5;
        return r12.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r11) {
        int r5 = 0;
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = this.f2530b;
        if (r12 == 0) goto L9;
        if (r12 != 1) goto L8;
        CoroutineScope r13 = (CoroutineScope) this.f2531c;
        ResultKt.throwOnFailure(r11);
        return r11;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r11);
        CoroutineScope r14 = (CoroutineScope) this.f2531c;
        r r15 = r.f2752a;
        String r16 = r.j(this.d);
        if (r16 != null) goto L12;
    L58:
        String r17 = "baseUrl is empty. packageName: ".concat(this.d);
        Intrinsics.checkNotNullParameter("AIPackageManager", "tag");
        t0.d r18 = com.bytedance.ai.utils.c.f2846a;
        if (r18 == null) goto L62;
        r18.e("AIPackageManager", r17);
    L62:
        return Boxing.boxBoolean(false);
    L12:
        if (r16.length() == 0) goto L58;
        LruCache r19 = e0.f2711a;
        String r20 = e0.g(this.d, r16, true);
        String r21 = Uri.parse(r20).getPath();
        if (r21 == null) goto L53;
        String r22 = this.d;
        this.f2531c = r14;
        this.f2529a = this;
        this.f2530b = 1;
        kotlinx.coroutines.l r110 = new kotlinx.coroutines.l(1, IntrinsicsKt.intercepted(this));
        r110.w();
        String r23 = GeckoXAdapter.Companion.getPrefixAsGeckoCDN(r21);
        GlobalConfigSettings r24 = df.c.f16652i.d();
        String r25 = null;
        if (r24 == null) goto L19;
        GlobalConfigSettings.ResourceMeta r26 = r24.getResourceMeta();
    L20:
        if (r26 != null) goto L25;
        String r27 = "could not get any valid resource meta. packageName: ".concat(r22);
        Intrinsics.checkNotNullParameter("AIPackageManager", "tag");
        t0.d r28 = com.bytedance.ai.utils.c.f2846a;
        if (r28 == null) goto L24;
        r28.e("AIPackageManager", r27);
    L24:
        Result.Companion r29 = Result.Companion;
        r110.resumeWith(Result.m124constructorimpl(Boxing.boxBoolean(false)));
    L47:
        Object r111 = r110.v();
        if (r111 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L50;
        DebugProbesKt.probeCoroutineSuspended(this);
    L50:
        if (r111 != r10) goto L52;
        return r10;
    L52:
        return r111;
    L25:
        GlobalConfigSettings.CurrentLevelConfig r30 = r26.getConfig();
        if (r30 == null) goto L28;
        r25 = r30.getPrefix2AccessKey().get(r23);
    L28:
        com.bytedance.geckox.g r31 = com.bytedance.geckox.h.a(r25);
        if (r31 == null) goto L43;
        com.bytedance.forest.model.m r32 = com.lynx.tasm.utils.a.c(r20, r23);
        if (r32 == null) goto L39;
        String r33 = r32.f4390b;
        if (com.bytedance.ai.utils.c.l(r33) == false) goto L35;
        r31.b(MapsKt.mapOf(TuplesKt.to(r25, CollectionsKt.listOf(new CheckRequestBodyModel.TargetChannel(r33)))), new OptionCheckUpdateParams().setListener(new p(r22, r110, r5)));
        goto L47
    L35:
        String r34 = com.lynx.tasm.utils.b.j("failed to parse channel from url: ", r20, ". packageName: ", r22);
        Intrinsics.checkNotNullParameter("AIPackageManager", "tag");
        t0.d r35 = com.bytedance.ai.utils.c.f2846a;
        if (r35 == null) goto L38;
        r35.e("AIPackageManager", r34);
    L38:
        Result.Companion r36 = Result.Companion;
        r110.resumeWith(Result.m124constructorimpl(Boxing.boxBoolean(false)));
        goto L47
    L39:
        String r37 = "gecko model is null. packageName: ".concat(r22);
        Intrinsics.checkNotNullParameter("AIPackageManager", "tag");
        t0.d r38 = com.bytedance.ai.utils.c.f2846a;
        if (r38 == null) goto L42;
        r38.e("AIPackageManager", r37);
    L42:
        Result.Companion r39 = Result.Companion;
        r110.resumeWith(Result.m124constructorimpl(Boxing.boxBoolean(false)));
        goto L47
    L43:
        String r40 = "could not get any valid gecko client. packageName: ".concat(r22);
        Intrinsics.checkNotNullParameter("AIPackageManager", "tag");
        t0.d r41 = com.bytedance.ai.utils.c.f2846a;
        if (r41 == null) goto L46;
        r41.e("AIPackageManager", r40);
    L46:
        Result.Companion r42 = Result.Companion;
        r110.resumeWith(Result.m124constructorimpl(Boxing.boxBoolean(false)));
        goto L47
    L19:
        r26 = null;
        goto L20
    L53:
        String r112 = "UriPath is NULL. packageName: ".concat(this.d);
        Intrinsics.checkNotNullParameter("AIPackageManager", "tag");
        t0.d r113 = com.bytedance.ai.utils.c.f2846a;
        if (r113 == null) goto L57;
        r113.e("AIPackageManager", r112);
    L57:
        return Boxing.boxBoolean(false);
    }
}
