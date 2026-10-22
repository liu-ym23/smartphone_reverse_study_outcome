package com.bytedance.ai.resource;

import com.byted.mgl.merge.service.api.aweme.BdpAwemeConstant;
import com.bytedance.ai.model.objects.AIPackage;
import com.bytedance.ai.resource.core.AIPackageDeployment;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.AIPackageManager$loadBuiltInAIPackages$3$1", f = "AIPackageManager.kt", i = {0}, l = {738, 750}, m = "invokeSuspend", n = {"deferred"}, s = {"L$0"})
final class AIPackageManager$loadBuiltInAIPackages$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AIPackageDeployment.AIPackageDeploymentItem $deploymentItem;
    Object L$0;
    int label;

    public static final class a implements AIPackageManager.b {
        public final /* synthetic */ CompletableDeferred<Unit> a;

        public a(CompletableDeferred<Unit> r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ai.resource.AIPackageManager.b
        public final void a(AIPackage r1, String r10, String r11, AIPackage.AIPackageType r12, int r13, String r14) {
            Intrinsics.checkNotNullParameter(r10, "packageName");
            Intrinsics.checkNotNullParameter(r11, BdpAwemeConstant.KEY_APP_ID);
            Intrinsics.checkNotNullParameter(r12, "packageType");
            this.a.complete(Unit.INSTANCE);
        }
    }

    public AIPackageManager$loadBuiltInAIPackages$3$1(AIPackageDeployment.AIPackageDeploymentItem r1, Continuation<? super AIPackageManager$loadBuiltInAIPackages$3$1> r10) {
        this.$deploymentItem = r1;
        super(2, r10);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new AIPackageManager$loadBuiltInAIPackages$3$1(this.$deploymentItem, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
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
    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r12);
    L17:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        CompletableDeferred r10 = (CompletableDeferred) this.L$0;
        ResultKt.throwOnFailure(r12);
    L13:
        this.L$0 = null;
        this.label = 2;
        if (r10.await(this) != r0) goto L17;
        return r0;
    L10:
        ResultKt.throwOnFailure(r12);
        com.bytedance.ai.utils.g.a.i("AIPackageManager", "loadBuiltInAIPackages: packageName: " + this.$deploymentItem.getPackageName() + ", appId: " + this.$deploymentItem.getAppId() + ", versionCode: " + this.$deploymentItem.getVersionCode());
        r10 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        AIPackageManager r11 = AIPackageManager.a;
        AIPackageDeployment.AIPackageDeploymentItem r13 = this.$deploymentItem;
        long r14 = r13.getVersionCode();
        a r15 = new a(r10);
        this.L$0 = r10;
        this.label = 1;
        if (r11.h(r13, r14, r15, this) != r0) goto L13;
        return r0;
    }
}
