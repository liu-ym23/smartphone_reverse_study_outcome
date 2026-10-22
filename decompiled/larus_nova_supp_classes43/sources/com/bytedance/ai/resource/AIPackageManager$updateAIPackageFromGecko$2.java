package com.bytedance.ai.resource;

import android.util.Pair;
import com.bytedance.forest.chain.fetchers.GeckoXAdapter;
import com.bytedance.geckox.GeckoClient;
import com.bytedance.geckox.listener.GeckoUpdateListener;
import com.bytedance.geckox.model.CheckRequestBodyModel;
import com.bytedance.geckox.model.LocalPackageModel;
import com.bytedance.geckox.model.UpdatePackage;
import com.bytedance.geckox.settings.model.GlobalConfigSettings;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.List;
import java.util.Map;
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
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.AIPackageManager$updateAIPackageFromGecko$2", f = "AIPackageManager.kt", i = {0, 0, 0, 0}, l = {810}, m = "invokeSuspend", n = {"$this$withContext", "manifestPath", "path", "$completion$iv"}, s = {"L$0", "L$1", "L$3", "L$4"})
final class AIPackageManager$updateAIPackageFromGecko$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ String $packageName;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;

    public static final class a extends GeckoUpdateListener {
        public final /* synthetic */ String a;
        public final /* synthetic */ kotlinx.coroutines.i<Boolean> b;

        public final void onLocalNewestVersion(LocalPackageModel r10) {
            super.onLocalNewestVersion(r10);
            com.bytedance.ai.utils.g.a.d("AIPackageManager", "local version is latest. packageName: " + this.a);
            kotlinx.coroutines.i<Boolean> r11 = this.b;
            Result.Companion r0 = Result.Companion;
            r11.resumeWith(Result.constructor-impl(Boolean.TRUE));
        }

        public a(String r1, kotlinx.coroutines.j r10) {
            this.a = r1;
            this.b = r10;
        }

        public final void onCheckServerVersionFail(Map<String, List<Pair<String, Long>>> r10, Throwable r11) {
            super.onCheckServerVersionFail(r10, r11);
            com.bytedance.ai.utils.g.a.e("AIPackageManager", "onCheckServerVersionFail. packageName: " + this.a);
        }

        public final void onCheckServerVersionSuccess(Map<String, List<Pair<String, Long>>> r10, Map<String, List<UpdatePackage>> r11) {
            super.onCheckServerVersionSuccess(r10, r11);
            com.bytedance.ai.utils.g.a.d("AIPackageManager", "onCheckServerVersionSuccess. packageName: " + this.a);
        }

        public final void onUpdateFailed(UpdatePackage r10, Throwable r11) {
            com.bytedance.ai.utils.g.a.e("AIPackageManager", "failed to update package: " + this.a + ", " + r11);
            kotlinx.coroutines.i<Boolean> r12 = this.b;
            Result.Companion r0 = Result.Companion;
            if (r11 != null) goto L5;
            r11 = new Throwable("failed to update package: " + this.a);
        L5:
            r12.resumeWith(Result.constructor-impl(ResultKt.createFailure(r11)));
        }

        public final void onUpdateSuccess(UpdatePackage r10, long r11) {
            super.onUpdateSuccess(r10, r11);
            com.bytedance.ai.utils.g.a.d("AIPackageManager", "onUpdateSuccess. packageName: " + this.a + ", version: " + r11);
            kotlinx.coroutines.i<Boolean> r12 = this.b;
            Result.Companion r13 = Result.Companion;
            r12.resumeWith(Result.constructor-impl(Boolean.TRUE));
        }
    }

    public AIPackageManager$updateAIPackageFromGecko$2(String r1, Continuation<? super AIPackageManager$updateAIPackageFromGecko$2> r10) {
        this.$packageName = r1;
        super(2, r10);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        AIPackageManager$updateAIPackageFromGecko$2 r0 = new AIPackageManager$updateAIPackageFromGecko$2(this.$packageName, r11);
        r0.L$0 = r10;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        AIPackageManager$updateAIPackageFromGecko$2 r11 = (AIPackageManager$updateAIPackageFromGecko$2) this.L$4;
        String r12 = (String) this.L$3;
        String r13 = (String) this.L$2;
        String r14 = (String) this.L$1;
        CoroutineScope r15 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r10);
    L45:
        return r10;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        CoroutineScope r16 = (CoroutineScope) this.L$0;
        String r17 = AIPackageManager.b(AIPackageManager.a, this.$packageName);
        if (r17 != null) goto L11;
    L14:
        boolean r18 = true;
    L16:
        if (r18 == false) goto L19;
        com.bytedance.ai.utils.g.a.e("AIPackageManager", "baseUrl is empty. packageName: " + this.$packageName);
        return Boxing.boxBoolean(false);
    L19:
        AppletResourceTool r19 = AppletResourceTool.a;
        String r20 = this.$packageName;
        r19.getClass();
        String r21 = AppletResourceTool.k(r20, r17, true);
        String r22 = UriProtector.parse(r21).getPath();
        if (r22 == null) goto L46;
        String r23 = this.$packageName;
        this.L$0 = r16;
        this.L$1 = r21;
        this.L$2 = r23;
        this.L$3 = r22;
        this.L$4 = this;
        this.label = 1;
        kotlinx.coroutines.j r110 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(this), 1);
        r110.C();
        String r24 = GeckoXAdapter.Companion.getPrefixAsGeckoCDN(r22);
        com.bytedance.geckox.b r25 = com.bytedance.geckox.b.a.a;
        GlobalConfigSettings r26 = com.bytedance.geckox.b.b();
        String r27 = null;
        if (r26 == null) goto L24;
        GlobalConfigSettings.ResourceMeta r28 = r26.getResourceMeta();
    L25:
        if (r28 != null) goto L27;
        com.bytedance.ai.utils.g.a.e("AIPackageManager", "could not get any valid resource meta. packageName: " + r23);
        Result.Companion r29 = Result.Companion;
        r110.resumeWith(Result.constructor-impl(Boxing.boxBoolean(false)));
    L40:
        r10 = r110.B();
        if (r10 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L43;
        DebugProbesKt.probeCoroutineSuspended(this);
    L43:
        if (r10 != r0) goto L45;
        return r0;
    L27:
        GlobalConfigSettings.CurrentLevelConfig r30 = r28.getConfig();
        if (r30 == null) goto L30;
        r27 = (String) r30.getPrefix2AccessKey().get(r24);
    L30:
        GeckoClient r31 = com.bytedance.geckox.a.a(r27);
        if (r31 == null) goto L39;
        com.bytedance.forest.model.j r32 = com.bytedance.forest.utils.r.a(r21, r24);
        if (r32 == null) goto L38;
        String r33 = r32.b;
        if (com.bytedance.ai.utils.f.g(r33) == false) goto L37;
        r31.checkUpdateMulti(MapsKt.mapOf(TuplesKt.to(r27, CollectionsKt.listOf(new CheckRequestBodyModel.TargetChannel(r33)))), new a(r23, r110));
        goto L40
    L37:
        com.bytedance.ai.utils.g.a.e("AIPackageManager", "failed to parse channel from url: " + r21 + ". packageName: " + r23);
        Result.Companion r34 = Result.Companion;
        r110.resumeWith(Result.constructor-impl(Boxing.boxBoolean(false)));
        goto L40
    L38:
        com.bytedance.ai.utils.g.a.e("AIPackageManager", "gecko model is null. packageName: " + r23);
        Result.Companion r35 = Result.Companion;
        r110.resumeWith(Result.constructor-impl(Boxing.boxBoolean(false)));
        goto L40
    L39:
        com.bytedance.ai.utils.g.a.e("AIPackageManager", "could not get any valid gecko client. packageName: " + r23);
        Result.Companion r36 = Result.Companion;
        r110.resumeWith(Result.constructor-impl(Boxing.boxBoolean(false)));
        goto L40
    L24:
        r28 = null;
        goto L25
    L46:
        String r111 = this.$packageName;
        com.bytedance.ai.utils.g.a.e("AIPackageManager", "UriPath is NULL. packageName: " + r111);
        return Boxing.boxBoolean(false);
    L11:
        if (r17.length() == 0) goto L14;
        r18 = false;
        goto L16
    }
}
