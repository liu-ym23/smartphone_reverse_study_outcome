package com.ss.android.lark.passport.flow.mfa;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.passport.flow.mfa.FlowMfaEngine$startFirstParty$4", f = "FlowMfaEngine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class FlowMfaEngine$startFirstParty$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ FlowMfaFlowSession $session;
    int label;

    public FlowMfaEngine$startFirstParty$4(Activity r1, FlowMfaFlowSession r2, Continuation<? super FlowMfaEngine$startFirstParty$4> r3) {
        this.$activity = r1;
        this.$session = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new FlowMfaEngine$startFirstParty$4(this.$activity, this.$session, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r5);
        int r6 = FlowMfaTransparentActivity.d;
        Activity r7 = this.$activity;
        String r0 = this.$session.a;
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r0, "flowId");
        Intent r1 = new Intent(r7, FlowMfaTransparentActivity.class);
        if (Build.VERSION.SDK_INT >= 34) goto L7;
        r1.addFlags(268435456);
    L7:
        r1.addFlags(67108864);
        r1.addFlags(536870912);
        p.a(r1);
        r1.putExtra("flow_mfa_flow_id", r0);
        r7.startActivity(r1);
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
