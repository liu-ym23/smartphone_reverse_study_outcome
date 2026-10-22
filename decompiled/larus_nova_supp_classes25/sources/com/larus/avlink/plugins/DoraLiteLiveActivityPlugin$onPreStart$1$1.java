package com.larus.avlink.plugins;

import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.plugins.DoraLiteLiveActivityPlugin$onPreStart$1$1", f = "DoraLiteLiveActivityPlugin.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DoraLiteLiveActivityPlugin$onPreStart$1$1 extends SuspendLambda implements Function2<Integer, Continuation<? super Unit>, Object> {
    /* synthetic */ int I$0;
    int label;
    final /* synthetic */ DoraLiteLiveActivityPlugin this$0;

    public DoraLiteLiveActivityPlugin$onPreStart$1$1(DoraLiteLiveActivityPlugin r1, Continuation<? super DoraLiteLiveActivityPlugin$onPreStart$1$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        DoraLiteLiveActivityPlugin$onPreStart$1$1 r0 = new DoraLiteLiveActivityPlugin$onPreStart$1$1(this.this$0, r4);
        r0.I$0 = ((Number) r3).intValue();
        return r0;
    }

    public final Object invoke(int r1, Continuation<? super Unit> r2) {
        return create(Integer.valueOf(r1), r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke(((Number) r1).intValue(), (Continuation) r2);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L17;
        ResultKt.throwOnFailure(r4);
        int r5 = this.I$0;
        if (r5 != 1) goto L7;
        ((n4) this.this$0.getContext()).mute();
        DoraLiteLiveActivityPlugin r6 = this.this$0;
        r6.f = true;
        r6.getClass();
        com.larus.avlink.n1.d("DoraLiveActivityPlugin", "call mute");
        DoraLiteLiveActivityPlugin r7 = this.this$0;
        r7.l3(((n4) r7.getContext()).a().s1());
    L15:
        return Unit.INSTANCE;
    L7:
        if (r5 != 2) goto L9;
        ((n4) this.this$0.getContext()).unmute();
        DoraLiteLiveActivityPlugin r8 = this.this$0;
        r8.f = false;
        r8.getClass();
        com.larus.avlink.n1.d("DoraLiveActivityPlugin", "call unmute");
        DoraLiteLiveActivityPlugin r9 = this.this$0;
        r9.l3(((n4) r9.getContext()).a().s1());
        goto L15
    L9:
        if (r5 != 3) goto L15;
        ((n4) this.this$0.getContext()).d(false, 11, DoraCallStateCode.DOUBAO_CMD_5);
        goto L15
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
