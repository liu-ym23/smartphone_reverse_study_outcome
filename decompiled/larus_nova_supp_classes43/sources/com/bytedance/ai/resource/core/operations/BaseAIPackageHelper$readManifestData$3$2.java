package com.bytedance.ai.resource.core.operations;

import com.bytedance.ai.resource.AppletResourceTool;
import com.bytedance.ai.resource.core.AIPackageDeployment;
import com.bytedance.ai.utils.g;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.core.operations.BaseAIPackageHelper$readManifestData$3$2", f = "BaseAIPackageHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class BaseAIPackageHelper$readManifestData$3$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AtomicReference<i<String>> $contRef;
    final /* synthetic */ AIPackageDeployment.AIPackageDeploymentItem $deployment;
    int label;
    final /* synthetic */ BaseAIPackageHelper this$0;

    public static final class a implements Function1<IIvyAIPackageResourceService.a, Unit> {
        public final /* synthetic */ AtomicReference<i<String>> a;

        public a(AtomicReference<i<String>> r1) {
            this.a = r1;
        }

        public final Object invoke(Object r10) {
            IIvyAIPackageResourceService.a r11 = (IIvyAIPackageResourceService.a) r10;
            Intrinsics.checkNotNullParameter(r11, "it");
            i<String> r0 = this.a.getAndSet(null);
            if (r0 == null) goto L8;
            if (r0.isActive() == false) goto L8;
            Result.Companion r1 = Result.Companion;
            r0.resumeWith(Result.constructor-impl(r11.a));
        L8:
            return Unit.INSTANCE;
        }
    }

    public static final class b implements Function1<Throwable, Unit> {
        public final /* synthetic */ BaseAIPackageHelper a;
        public final /* synthetic */ AtomicReference<i<String>> b;

        public b(BaseAIPackageHelper r1, AtomicReference<i<String>> r10) {
            this.a = r1;
            this.b = r10;
        }

        public final Object invoke(Object r10) {
            Throwable r11 = (Throwable) r10;
            Intrinsics.checkNotNullParameter(r11, "it");
            g.a.e("AIPackageManager", "packageName: " + this.a.a.getPackageName() + ", appId: " + this.a.a.getAppId() + " ===> read manifest data exception: " + r11);
            i<String> r12 = this.b.getAndSet(null);
            if (r12 == null) goto L8;
            if (r12.isActive() == false) goto L8;
            r12.resumeWith(Result.constructor-impl(""));
        L8:
            return Unit.INSTANCE;
        }
    }

    public BaseAIPackageHelper$readManifestData$3$2(AIPackageDeployment.AIPackageDeploymentItem r1, AtomicReference<i<String>> r10, BaseAIPackageHelper r11, Continuation<? super BaseAIPackageHelper$readManifestData$3$2> r12) {
        this.$deployment = r1;
        this.$contRef = r10;
        this.this$0 = r11;
        super(2, r12);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new BaseAIPackageHelper$readManifestData$3$2(this.$deployment, this.$contRef, this.this$0, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r11);
        AppletResourceTool r1 = AppletResourceTool.a;
        AIPackageDeployment.AIPackageDeploymentItem r12 = this.$deployment;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r12, "<this>");
        String r13 = AppletResourceTool.e(r1, r12.getPackageName(), "base", "base_" + r12.getVersionCode() + "/base", "manifest.json", 0, 0, 0);
        AtomicReference<i<String>> r10 = this.$contRef;
        AppletResourceTool.q("", r13, new a(r10), new b(this.this$0, r10), true);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
