package com.larus.avlink.record.util;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.message.Message;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.record.util.RecordMinutesSettingManager$handleMessageArrived$1", f = "RecordMinutesSettingManager.kt", i = {0}, l = {866}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv"}, s = {"L$0"})
final class RecordMinutesSettingManager$handleMessageArrived$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $cid;
    final /* synthetic */ Map<String, String> $ext;
    final /* synthetic */ Message $msg;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    public RecordMinutesSettingManager$handleMessageArrived$1(String r1, Message r2, Map<String, String> r3, Continuation<? super RecordMinutesSettingManager$handleMessageArrived$1> r4) {
        this.$cid = r1;
        this.$msg = r2;
        this.$ext = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new RecordMinutesSettingManager$handleMessageArrived$1(this.$cid, this.$msg, this.$ext, r5);
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
        Map r2 = (Map) this.L$3;
        Message r3 = (Message) this.L$2;
        String r4 = (String) this.L$1;
        kotlinx.coroutines.sync.a r5 = (kotlinx.coroutines.sync.a) this.L$0;
        ResultKt.throwOnFailure(r7);
    L18:
        RecordMinutesSettingManager.a(RecordMinutesSettingManager.a, r3);     // Catch: Throwable -> L15
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L15
        r5.unlock(null);
        return Unit.INSTANCE;
    L15:
        th = move-exception;
        r5.unlock(null);
        throw th;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        r5 = RecordMinutesSettingManager.e;
        String r9 = this.$cid;
        Message r6 = this.$msg;
        Map<String, String> r10 = this.$ext;
        this.L$0 = r5;
        this.L$1 = r9;
        this.L$2 = r6;
        this.L$3 = r10;
        this.label = 1;
        if (r5.a(null, this) != r0) goto L11;
        return r0;
    L11:
        r3 = r6;
        goto L18
    }
}
