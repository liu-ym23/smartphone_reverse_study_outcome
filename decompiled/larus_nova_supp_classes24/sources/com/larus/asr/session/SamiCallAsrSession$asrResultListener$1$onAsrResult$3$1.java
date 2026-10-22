package com.larus.asr.session;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.asr.session.SamiCallAsrSession$asrResultListener$1$onAsrResult$3$1", f = "SamiCallAsrSession.kt", i = {}, l = {281}, m = "invokeSuspend", n = {}, s = {})
public final class SamiCallAsrSession$asrResultListener$1$onAsrResult$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ maa.e $clickAbility;
    final /* synthetic */ pf9.a $result;
    final /* synthetic */ Function2<String, Boolean, Unit> $task;
    final /* synthetic */ String $taskId;
    int label;
    final /* synthetic */ SamiCallAsrSession this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public SamiCallAsrSession$asrResultListener$1$onAsrResult$3$1(maa.e r1, String r2, pf9.a r3, SamiCallAsrSession r4, Function2<? super String, ? super Boolean, Unit> r5, Continuation<? super SamiCallAsrSession$asrResultListener$1$onAsrResult$3$1> r6) {
        this.$clickAbility = r1;
        this.$taskId = r2;
        this.$result = r3;
        this.this$0 = r4;
        this.$task = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new SamiCallAsrSession$asrResultListener$1$onAsrResult$3$1(this.$clickAbility, this.$taskId, this.$result, this.this$0, this.$task, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r8);
    L11:
        maa.a r9 = (maa.a) r8;
        if (r9.a == true) goto L14;
        this.$task.invoke(this.$result.a, Boxing.boxBoolean(r9.d));
    L18:
        return Unit.INSTANCE;
    L14:
        if (r9.b == false) goto L18;
        this.$task.invoke(r9.c, Boxing.boxBoolean(r9.d));
        goto L18
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        maa.e r2 = this.$clickAbility;
        String r10 = this.$taskId;
        pf9.a r3 = this.$result;
        String r4 = r3.a;
        Map r5 = r3.d;
        boolean r6 = this.this$0.x;
        this.label = 1;
        r8 = r2.rP(r10, r4, r5, r6, this);
        if (r8 != r0) goto L11;
        return r0;
    }
}
