package com.bytedance.ai.resource;

import com.byted.mgl.merge.service.api.aweme.BdpAwemeConstant;
import com.bytedance.ai.model.objects.AIPackage;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.AIManager$installAIPackagesWithVersionCode$1", f = "AIManager.kt", i = {}, l = {584}, m = "invokeSuspend", n = {}, s = {})
final class AIManager$installAIPackagesWithVersionCode$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<Boolean, String, Unit> $callback;
    final /* synthetic */ String $packageName;
    final /* synthetic */ long $versionCode;
    int label;

    public static final class a implements AIPackageManager.b {
        public final /* synthetic */ Function2<Boolean, String, Unit> a;

        /* JADX WARN: Multi-variable type inference failed */
        public a(Function2<? super Boolean, ? super String, Unit> r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ai.resource.AIPackageManager.b
        public final void a(AIPackage r1, String r10, String r11, AIPackage.AIPackageType r12, int r13, String r14) {
            Intrinsics.checkNotNullParameter(r10, "packageName");
            Intrinsics.checkNotNullParameter(r11, BdpAwemeConstant.KEY_APP_ID);
            Intrinsics.checkNotNullParameter(r12, "packageType");
            if (r13 != 0) goto L9;
            if (r1 == null) goto L9;
            String r15 = "install package success: packageName: " + r10 + ", appId = " + r11;
            Function2<Boolean, String, Unit> r16 = this.a;
            if (r16 == null) goto L8;
            r16.invoke(Boolean.TRUE, r15);
        L8:
            com.bytedance.ai.utils.g.a.d("AIManager", r15);
            return;
        L9:
            String r17 = "install package failed: packageName: " + r10 + ", appId = " + r11;
            Function2<Boolean, String, Unit> r18 = this.a;
            if (r18 == null) goto L12;
            r18.invoke(Boolean.TRUE, r17);
        L12:
            com.bytedance.ai.utils.g.a.d("AIManager", r17);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AIManager$installAIPackagesWithVersionCode$1(String r1, long r10, Function2<? super Boolean, ? super String, Unit> r11, Continuation<? super AIManager$installAIPackagesWithVersionCode$1> r12) {
        this.$packageName = r1;
        this.$versionCode = r10;
        this.$callback = r11;
        super(2, r12);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new AIManager$installAIPackagesWithVersionCode$1(this.$packageName, this.$versionCode, this.$callback, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        com.bytedance.ai.utils.g.a.d("AIManager", "install AIPackage with packageName: " + this.$packageName + ", versionCode: " + this.$versionCode);
        AIPackageManager r11 = AIPackageManager.a;
        String r12 = this.$packageName;
        long r13 = this.$versionCode;
        a r14 = new a(this.$callback);
        this.label = 1;
        r11.getClass();
        if (BuildersKt.withContext(com.bytedance.ai.infra.thread_pool.b.a, new AIPackageManager$installAIPackagesWithVersionCode$2(r12, r13, r14, null), this) != r0) goto L12;
        return r0;
    }
}
