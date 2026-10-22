package com.larus.bmhome.chat.model.repo;

import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.im.bean.message.Message;
import com.larus.im.callback.IIMError;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.model.repo.ChatSender$sendAudioTextNew$sendAction$1$1", f = "ChatSender.kt", i = {0, 1}, l = {906, 912}, m = "invokeSuspend", n = {"localMessageId", "cvs"}, s = {"L$0", "L$2"})
public final class ChatSender$sendAudioTextNew$sendAction$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<Message, IIMError, Unit> $callback;
    final /* synthetic */ String $cvsId;
    final /* synthetic */ boolean $needInterrupt;
    final /* synthetic */ ic8.w $strategy;
    Object L$0;
    Object L$1;
    Object L$2;
    boolean Z$0;
    int label;
    final /* synthetic */ ChatSender this$0;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.model.repo.ChatSender$sendAudioTextNew$sendAction$1$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.model.repo.ChatSender$sendAudioTextNew$sendAction$1$1$1", f = "ChatSender.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ChatSender this$0;

        public AnonymousClass1(ChatSender r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r3);
            this.this$0.a.d.d.i6("sendAudioTextNew", false);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public ChatSender$sendAudioTextNew$sendAction$1$1(ic8.w r1, String r2, ChatSender r3, Function2<? super Message, ? super IIMError, Unit> r4, boolean r5, Continuation<? super ChatSender$sendAudioTextNew$sendAction$1$1> r6) {
        this.$strategy = r1;
        this.$cvsId = r2;
        this.this$0 = r3;
        this.$callback = r4;
        this.$needInterrupt = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new ChatSender$sendAudioTextNew$sendAction$1$1(this.$strategy, this.$cvsId, this.this$0, this.$callback, this.$needInterrupt, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r18) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        boolean r4 = false;
        if (r2 == 0) goto L10;
        if (r2 == 1) goto L9;
        if (r2 != 2) goto L8;
        boolean r3 = this.Z$0;
        wc9.e r5 = (wc9.e) this.L$2;
        Function2<Message, IIMError, Unit> r6 = (Function2) this.L$1;
        ic8.w r7 = (ic8.w) this.L$0;
        ResultKt.throwOnFailure(r18);
        Function2<Message, IIMError, Unit> r8 = r6;
        wc9.e r9 = r5;
        Object r10 = r18;
    L48:
        ((com.larus.bmhome.chat.model.strategy.g0) r10).b(r9, r7, r8, r3);
    L50:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        String r11 = (String) this.L$0;
        ResultKt.throwOnFailure(r18);
        Object r12 = r18;
    L33:
        r9 = (wc9.e) r12;
        if (r9 == null) goto L50;
        ic8.w r13 = this.$strategy;
        ChatSender r14 = this.this$0;
        r8 = this.$callback;
        boolean r15 = this.$needInterrupt;
        if (r11.length() <= 0) goto L38;
        r4 = true;
    L38:
        if (r4 == false) goto L44;
        Map<String, String> r16 = r13.a();
        if (r16 == null) goto L44;
        String r17 = r16.get("enter_method_trace");
        if (r17 == null) goto L44;
        ChatControlTrace.b.getClass();
        String r19 = (String) ChatControlTrace.G.put(r11, r17);
    L44:
        this.L$0 = r13;
        this.L$1 = r8;
        this.L$2 = r9;
        this.Z$0 = r15;
        this.label = 2;
        int r20 = ChatSender.j;
        r10 = r14.C(r9, this);
        if (r10 != r1) goto L47;
        return r1;
    L47:
        r7 = r13;
        r3 = r15;
        goto L48
    L10:
        ResultKt.throwOnFailure(r18);
        r11 = this.$strategy.b();
        if (r11 != null) goto L13;
        r11 = "";
    L13:
        String r21 = ChatControlTrace.b.Ia(r11);
        if (r21.length() != 0) goto L16;
        boolean r22 = true;
    L17:
        if (r22 == false) goto L19;
        r21 = "speak";
    L19:
        String r23 = r21;
        com.larus.bmhome.chat.trace.appreciable.f r24 = com.larus.bmhome.chat.trace.appreciable.f.a;
        String r25 = this.$cvsId;
        int r110 = this.$strategy.contentType();
        ic8.w r26 = this.$strategy;
        if ((r26 instanceof ai8.b) == false) goto L22;
        ai8.b r27 = (ai8.b) r26;
    L23:
        if (r27 == null) goto L25;
        Long r111 = r27.h;
    L26:
        com.larus.bmhome.chat.trace.appreciable.f.l(r24, r11, r25, r23, r110, null, null, null, r111, DoraCallStateCode.DOUBAO_CMD_12);
        if (com.larus.platform.exp.s.e == false) goto L29;
        ChatSender r28 = this.this$0;
        BuildersKt.launch$default(r28.b, null, null, new AnonymousClass1(r28, null), 3, null);
    L30:
        ChatSender r29 = this.this$0;
        String r30 = this.$cvsId;
        this.L$0 = r11;
        this.label = 1;
        r12 = ChatSender.y(r29, r30, this);
        if (r12 != r1) goto L33;
        return r1;
    L29:
        this.this$0.a.d.d.i6("sendAudioTextNew", false);
        goto L30
    L25:
        r111 = null;
        goto L26
    L22:
        r27 = null;
        goto L23
    L16:
        r22 = false;
        goto L17
    }
}
