package com.lark.kmp.rustclient.internal;

import com.lark.kmp.logger.LarkLogger;
import com.lark.kmp.pb.basic.v1.Command;
import com.lark.kmp.pb.basic.v1.Packet;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.lark.kmp.rustclient.internal.RustReceiverRegistry$dispatchPushCallback$1", f = "RustReceiverRegistry.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class RustReceiverRegistry$dispatchPushCallback$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ byte[] $data;
    int label;
    final /* synthetic */ RustReceiverRegistry this$0;

    public RustReceiverRegistry$dispatchPushCallback$1(byte[] r1, RustReceiverRegistry r2, Continuation<? super RustReceiverRegistry$dispatchPushCallback$1> r3) {
        this.$data = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new RustReceiverRegistry$dispatchPushCallback$1(this.$data, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L36;
        ResultKt.throwOnFailure(r6);
        rpc.c.a r7 = null;
        Packet r0 = Packet.ADAPTER.e(this.$data);     // Catch: Exception -> L7
    L10:
        if (r0 != null) goto L14;
        LarkLogger r8 = LarkLogger.a;
        LarkLogger.b("RustReceiverRegistry", "onPush: packet is null");
        return Unit.INSTANCE;
    L14:
        if (r0.getCmd() == Command.PASS_THROUGH_PUSH) goto L39;
    L30:
        Command r1 = r0.getCmd();
        if (r1 != null) goto L33;
        r1 = Command.UNKNOWN_COMMAND;
    L33:
        this.this$0.i(new rpc.c(r1, r0, r7));
        return Unit.INSTANCE;
    L39:
        ByteString r2 = r0.getPayload();     // Catch: Exception -> L28
        if (r2 != null) goto L18;
        r2 = ByteString.EMPTY;     // Catch: Exception -> L28
    L18:
        com.lark.kmp.server.pb.improto.Packet r3 = com.lark.kmp.server.pb.improto.Packet.ADAPTER.d(r2);     // Catch: Exception -> L28
        com.lark.kmp.server.pb.improto.Command.b r4 = com.lark.kmp.server.pb.improto.Command.Companion;     // Catch: Exception -> L28
        Integer r5 = r3.getCommand();     // Catch: Exception -> L28
        if (r5 == null) goto L21;
        int r9 = r5.intValue();     // Catch: Exception -> L28
    L22:
        r4.getClass();     // Catch: Exception -> L28
        com.lark.kmp.server.pb.improto.Command r10 = com.lark.kmp.server.pb.improto.Command.b.a(r9);     // Catch: Exception -> L28
        if (r10 != null) goto L27;
        return Unit.INSTANCE;
    L27:
        r7 = new rpc.c.a(r10, r3);     // Catch: Exception -> L28
        goto L30
    L21:
        r9 = 0;
    L28:
        e = move-exception;
        LarkLogger r11 = LarkLogger.a;
        LarkLogger.b("RustReceiverRegistry", e.toString());
    L7:
        e = move-exception;
        e.printStackTrace();
        r0 = null;
        goto L10
    L36:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
