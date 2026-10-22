package com.larus.uaigc.worldcup.component;

import android.view.View;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.worldcup.component.WorldCupLynxComponent$initLynx$3", f = "WorldCupLynxComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class WorldCupLynxComponent$initLynx$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ View $containerView;
    final /* synthetic */ String $pageDataJson;
    int label;
    final /* synthetic */ WorldCupLynxComponent this$0;

    public WorldCupLynxComponent$initLynx$3(WorldCupLynxComponent r1, View r2, String r3, Continuation<? super WorldCupLynxComponent$initLynx$3> r4) {
        this.this$0 = r1;
        this.$containerView = r2;
        this.$pageDataJson = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new WorldCupLynxComponent$initLynx$3(this.this$0, this.$containerView, this.$pageDataJson, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r4);
        WorldCupLynxComponent r5 = this.this$0;
        View r0 = this.$containerView;
        String r1 = this.$pageDataJson;
        int r2 = WorldCupLynxComponent.E;
        r5.D3(r0, r1, true);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
