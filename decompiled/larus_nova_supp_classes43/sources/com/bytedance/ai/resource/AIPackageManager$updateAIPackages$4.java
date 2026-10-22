package com.bytedance.ai.resource;

import com.byted.mgl.merge.service.api.aweme.BdpAwemeConstant;
import com.bytedance.ai.model.objects.AIPackage;
import com.bytedance.ai.resource.core.AIPackageStorage;
import com.bytedance.ai.resource.core.bean.AIPackageAppList;
import com.bytedance.ai.resource.core.bean.AppRequestItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.AIPackageManager$updateAIPackages$4", f = "AIPackageManager.kt", i = {1}, l = {467, 490, 508}, m = "invokeSuspend", n = {com.bytedance.android.ec.core.event.a.KEY_RESULT}, s = {"L$0"})
final class AIPackageManager$updateAIPackages$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ String $packageName;
    Object L$0;
    int label;

    public static final class a implements AIPackageManager.b {
        public final /* synthetic */ AtomicInteger a;
        public final /* synthetic */ Ref.BooleanRef b;
        public final /* synthetic */ CompletableDeferred<Boolean> c;

        public a(AtomicInteger r1, Ref.BooleanRef r10, CompletableDeferred<Boolean> r11) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
        }

        @Override // com.bytedance.ai.resource.AIPackageManager.b
        public final void a(AIPackage r1, String r10, String r11, AIPackage.AIPackageType r12, int r13, String r14) {
            Intrinsics.checkNotNullParameter(r10, "packageName");
            Intrinsics.checkNotNullParameter(r11, BdpAwemeConstant.KEY_APP_ID);
            Intrinsics.checkNotNullParameter(r12, "packageType");
            int r15 = this.a.decrementAndGet();
            if (r13 == 0) goto L5;
            this.b.element = true;
        L5:
            if (r15 != 0) goto L8;
            this.c.complete(Boolean.valueOf(true ^ this.b.element));
            return;
        }
    }

    public AIPackageManager$updateAIPackages$4(String r1, Continuation<? super AIPackageManager$updateAIPackages$4> r10) {
        this.$packageName = r1;
        super(2, r10);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new AIPackageManager$updateAIPackages$4(this.$packageName, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L12;
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L10;
        if (r1 != 3) goto L9;
        ResultKt.throwOnFailure(r12);
    L36:
        return Boxing.boxBoolean(((Boolean) r12).booleanValue());
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        CompletableDeferred r10 = (CompletableDeferred) this.L$0;
        ResultKt.throwOnFailure(r12);
    L32:
        this.L$0 = null;
        this.label = 3;
        r12 = r10.await(this);
        if (r12 != r0) goto L36;
        return r0;
    L11:
        ResultKt.throwOnFailure(r12);
    L15:
        ArrayList r11 = new ArrayList();
        Iterator r13 = ((List) r12).iterator();
    L17:
        if (r13.hasNext() == false) goto L20;
        AIPackage r14 = (AIPackage) r13.next();
        r11.add(new AppRequestItem(r14.a(), r14.b, String.valueOf(r14.c)));
        goto L17
    L20:
        if (r11.isEmpty() == false) goto L23;
        com.bytedance.ai.utils.g.a.d("AIPackageManager", "The AIPackage is not installed. packageName: " + this.$packageName);
        return Boxing.boxBoolean(false);
    L23:
        AIPackageManager r15 = AIPackageManager.a;
        r15.getClass();
        AIPackageAppList r16 = AIPackageManager.g(r11);
        if (r16 != null) goto L26;
    L37:
        com.bytedance.ai.utils.g.a.d("AIPackageManager", "The package is the latest. packageName: " + this.$packageName);
        return Boxing.boxBoolean(true);
    L26:
        if (r16.getAppList().isEmpty() == true) goto L37;
        CompletableDeferred r17 = CompletableDeferredKt.CompletableDeferred(Boxing.boxBoolean(false));
        a r18 = new a(new AtomicInteger(r16.getAppList().size()), new Ref.BooleanRef(), r17);
        this.L$0 = r17;
        this.label = 2;
        if (r15.m(r16, r18, this) != r0) goto L31;
        return r0;
    L31:
        r10 = r17;
        goto L32
    L12:
        ResultKt.throwOnFailure(r12);
        AIPackageStorage r19 = AIPackageStorage.a;
        String r20 = this.$packageName;
        this.label = 1;
        r12 = r19.n(r20, this);
        if (r12 != r0) goto L15;
        return r0;
    }
}
