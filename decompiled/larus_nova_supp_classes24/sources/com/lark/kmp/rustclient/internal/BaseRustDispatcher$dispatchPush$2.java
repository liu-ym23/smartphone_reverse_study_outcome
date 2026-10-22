package com.lark.kmp.rustclient.internal;

import com.bytedance.larksuite.wire.CommandScope;
import com.lark.kmp.pb.basic.v1.Command;
import com.lark.kmp.pb.basic.v1.Packet;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.lark.kmp.rustclient.internal.BaseRustDispatcher$dispatchPush$2", f = "BaseRustDispatcher.kt", i = {}, l = {71}, m = "invokeSuspend", n = {}, s = {})
public final class BaseRustDispatcher$dispatchPush$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ rpc.c $pushData;
    int label;
    final /* synthetic */ BaseRustDispatcher this$0;

    public BaseRustDispatcher$dispatchPush$2(BaseRustDispatcher r1, rpc.c r2, Continuation<? super BaseRustDispatcher$dispatchPush$2> r3) {
        this.this$0 = r1;
        this.$pushData = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new BaseRustDispatcher$dispatchPush$2(this.this$0, this.$pushData, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L26:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        MutableSharedFlow<Pair<rpc.c, com.lark.kmp.rustclient.api.model.j>> r8 = this.this$0.d;
        rpc.c r2 = this.$pushData;
        Packet r3 = r2.b;
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Command r4 = r3.getCmd();
        if (r4 != null) goto L11;
        r4 = Command.UNKNOWN_COMMAND;
    L11:
        CommandScope r5 = c.a(r4);
        int r6 = c.a.a[r5.ordinal()];
        if (r6 != 1) goto L14;
        Object r9 = com.lark.kmp.rustclient.api.model.d.a;
    L22:
        Pair r10 = TuplesKt.to(r2, r9);
        this.label = 1;
        if (r8.emit(r10, this) != r0) goto L26;
        return r0;
    L14:
        if (r6 != 2) goto L20;
        String r11 = r3.getUser_id();
        if (r11 != null) goto L18;
        r11 = "";
    L18:
        r9 = new com.lark.kmp.rustclient.api.model.l(r11, r3.getUser_container_id());
        goto L22
    L20:
        throw new NoWhenBranchMatchedException();
    }
}
