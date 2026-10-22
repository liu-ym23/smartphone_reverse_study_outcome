package com.bytedance.ai.resource;

import com.byted.mgl.merge.service.api.aweme.BdpAwemeConstant;
import com.bytedance.ai.model.objects.AIPackage;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.AIManager$installAIPackageAwait$2$2", f = "AIManager.kt", i = {}, l = {1131}, m = "invokeSuspend", n = {}, s = {})
final class AIManager$installAIPackageAwait$2$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $appId;
    final /* synthetic */ AtomicReference<kotlinx.coroutines.i<AIManager.b>> $contRef;
    final /* synthetic */ String $packageName;
    final /* synthetic */ long $versionCode;
    int label;

    public static final class a implements AIPackageManager.b {
        public final /* synthetic */ AtomicReference<kotlinx.coroutines.i<AIManager.b>> a;

        public a(AtomicReference<kotlinx.coroutines.i<AIManager.b>> r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ai.resource.AIPackageManager.b
        public final void a(AIPackage r10, String r11, String r12, AIPackage.AIPackageType r13, int r14, String r15) {
            Intrinsics.checkNotNullParameter(r11, "packageName");
            Intrinsics.checkNotNullParameter(r12, BdpAwemeConstant.KEY_APP_ID);
            Intrinsics.checkNotNullParameter(r13, "packageType");
            AIManager.b r0 = new AIManager.b(r10, r11, r12, r13, r14, r15);
            kotlinx.coroutines.i<AIManager.b> r16 = this.a.getAndSet(null);
            if (r16 != null) goto L5;
            return;
        L5:
            if (r16.isActive() == false) goto L9;
            r16.resumeWith(Result.constructor-impl(r0));
            return;
        }
    }

    public AIManager$installAIPackageAwait$2$2(String r1, String r10, long r11, AtomicReference<kotlinx.coroutines.i<AIManager.b>> r12, Continuation<? super AIManager$installAIPackageAwait$2$2> r13) {
        this.$appId = r1;
        this.$packageName = r10;
        this.$versionCode = r11;
        this.$contRef = r12;
        super(2, r13);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new AIManager$installAIPackageAwait$2$2(this.$appId, this.$packageName, this.$versionCode, this.$contRef, r11);
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
        AIPackageManager r11 = AIPackageManager.a;
        AIPackageManager.a r12 = new AIPackageManager.a(this.$appId, this.$packageName);
        long r13 = this.$versionCode;
        a r14 = new a(this.$contRef);
        this.label = 1;
        if (r11.h(r12, r13, r14, this) != r0) goto L12;
        return r0;
    }
}
