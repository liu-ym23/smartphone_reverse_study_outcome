package com.larus.audio.trace;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.im.bean.message.Message;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.audio.trace.AudioTraceService$wrapRootSpanTraceInfoFromReceived$1", f = "AudioTraceService.kt", i = {}, l = {124, 128}, m = "invokeSuspend", n = {}, s = {})
public final class AudioTraceService$wrapRootSpanTraceInfoFromReceived$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $receiveMsgId;
    final /* synthetic */ Ref.ObjectRef<String> $sendLocalMsgId;
    final /* synthetic */ String $sendMsgId;
    final /* synthetic */ Function2<String, String, Unit> $traceInfoAction;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public AudioTraceService$wrapRootSpanTraceInfoFromReceived$1(String r1, String r2, Ref.ObjectRef<String> r3, Function2<? super String, ? super String, Unit> r4, Continuation<? super AudioTraceService$wrapRootSpanTraceInfoFromReceived$1> r5) {
        this.$sendMsgId = r1;
        this.$receiveMsgId = r2;
        this.$sendLocalMsgId = r3;
        this.$traceInfoAction = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new AudioTraceService$wrapRootSpanTraceInfoFromReceived$1(this.$sendMsgId, this.$receiveMsgId, this.$sendLocalMsgId, this.$traceInfoAction, r8);
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
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        Function2<String, String, Unit> r2 = (Function2) this.L$3;
        String r3 = (String) this.L$2;
        Ref.ObjectRef<String> r4 = (Ref.ObjectRef) this.L$1;
        String r5 = (String) this.L$0;
        ResultKt.throwOnFailure(r7);
    L30:
        Message r8 = (Message) r7;
        if (r8 == null) goto L37;
        String r9 = r8.getLocalMessageId();
        if (r9 == null) goto L37;
        r4.element = r9;
        c.a.g(r3, r9);
        AudioTraceService.a.i((String) r4.element, r2);
    L39:
        return Unit.INSTANCE;
    L37:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r7);
    L21:
        Message r10 = (Message) r7;
        if (r10 == null) goto L24;
        String r11 = r10.getReplyId();
    L25:
        if (r11 == null) goto L39;
        Ref.ObjectRef<String> r6 = this.$sendLocalMsgId;
        String r12 = this.$receiveMsgId;
        Function2<String, String, Unit> r13 = this.$traceInfoAction;
        IChatRepoService r14 = RepoDispatcherDelegate.b.e();
        this.L$0 = r11;
        this.L$1 = r6;
        this.L$2 = r12;
        this.L$3 = r13;
        this.label = 2;
        r7 = r14.E1(r11, this);
        if (r7 != r0) goto L29;
        return r0;
    L29:
        r4 = r6;
        r3 = r12;
        r2 = r13;
        goto L30
    L24:
        r11 = null;
        goto L25
    L10:
        ResultKt.throwOnFailure(r7);
        r11 = this.$sendMsgId;
        if (r11 != null) goto L13;
    L16:
        boolean r15 = true;
    L17:
        if (r15 == false) goto L25;
        IChatRepoService r16 = RepoDispatcherDelegate.b.e();
        String r17 = this.$receiveMsgId;
        this.label = 1;
        r7 = r16.E1(r17, this);
        if (r7 != r0) goto L21;
        return r0;
    L13:
        if (r11.length() == 0) goto L16;
        r15 = false;
        goto L17
    }
}
