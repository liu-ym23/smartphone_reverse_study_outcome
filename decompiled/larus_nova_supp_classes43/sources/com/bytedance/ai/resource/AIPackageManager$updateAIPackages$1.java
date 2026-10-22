package com.bytedance.ai.resource;

import com.bytedance.ai.resource.core.AIPackageDeployment;
import com.bytedance.ai.resource.core.bean.AppRequestItem;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.AIPackageManager", f = "AIPackageManager.kt", i = {0}, l = {287}, m = "updateAIPackages", n = {"listener"}, s = {"L$0"})
final class AIPackageManager$updateAIPackages$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AIPackageManager this$0;

    public AIPackageManager$updateAIPackages$1(AIPackageManager r1, Continuation<? super AIPackageManager$updateAIPackages$1> r10) {
        this.this$0 = r1;
        super(r10);
    }

    public final Object invokeSuspend(Object r13) {
        this.result = r13;
        this.label |= Integer.MIN_VALUE;
        AIPackageManager r14 = this.this$0;
        r14.getClass();
        int r1 = this.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r1 - Integer.MIN_VALUE;
        AIPackageManager$updateAIPackages$1 r0 = this;
    L6:
        Object r15 = r0.result;
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = r0.label;
        if (r11 != 0) goto L9;
        ResultKt.throwOnFailure(r15);
        throw null;
    L9:
        if (r11 != 1) goto L26;
        Iterator r12 = (Iterator) r0.L$1;
        AIPackageManager.b r16 = (AIPackageManager.b) r0.L$0;
        ResultKt.throwOnFailure(r15);
    L12:
        if (r12.hasNext() == false) goto L24;
        AIPackageDeployment.AIPackageDeploymentItem r17 = (AIPackageDeployment.AIPackageDeploymentItem) r12.next();
        AIPackageManager r18 = AIPackageManager.a;
        r0.L$0 = r16;
        r0.L$1 = r12;
        r0.label = 1;
        r18.getClass();
        AIPackageUpdateManager r19 = AIPackageUpdateManager.a;
        ArrayList r20 = new ArrayList();
        r20.add(new AppRequestItem(r17.getAppId(), r17.getPackageName(), String.valueOf(r17.getVersionCode())));
        r18.getClass();
        Object r110 = r18.m(AIPackageManager.g(r20), r16, r0);
        if (r110 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L18;
        r110 = Unit.INSTANCE;
    L18:
        if (r110 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L21;
        r110 = Unit.INSTANCE;
    L21:
        if (r110 != r10) goto L12;
        return r10;
    L24:
        return Unit.INSTANCE;
    L26:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L5:
        r0 = new AIPackageManager$updateAIPackages$1(r14, this);
        goto L6
    }
}
