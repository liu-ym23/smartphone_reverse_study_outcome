package com.larus.bmhome.chat.component.trace;

import com.larus.bmhome.auth.ConversationMode;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.mode.e;
import de8.c;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.trace.ChatTraceComponent$reportChatEnter$1", f = "ChatTraceComponent.kt", i = {}, l = {1219}, m = "invokeSuspend", n = {}, s = {})
final class ChatTraceComponent$reportChatEnter$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $botId;
    final /* synthetic */ e $modeAbility;
    int label;
    final /* synthetic */ ChatTraceComponent this$0;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.component.trace.ChatTraceComponent$reportChatEnter$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/bmhome/auth/ConversationMode;", "Lcom/larus/bmhome/chat/model/api/ConversationMode;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.component.trace.ChatTraceComponent$reportChatEnter$1$1", f = "ChatTraceComponent.kt", i = {}, l = {1220}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ConversationMode>, Object> {
        final /* synthetic */ e $modeAbility;
        int label;

        public AnonymousClass1(e r1, Continuation<? super AnonymousClass1> r2) {
            this.$modeAbility = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.$modeAbility, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super ConversationMode> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r4);
        L11:
            return r4;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            FlowKt__TransformKt$filterNotNull$.inlined.unsafeTransform.1 r2 = new FlowKt__TransformKt$filterNotNull$.inlined.unsafeTransform.1(this.$modeAbility.Si());
            this.label = 1;
            r4 = kotlinx.coroutines.flow.e.s(r2, this);
            if (r4 != r0) goto L11;
            return r0;
        }
    }

    public ChatTraceComponent$reportChatEnter$1(ChatTraceComponent r1, String r2, e r3, Continuation<? super ChatTraceComponent$reportChatEnter$1> r4) {
        this.this$0 = r1;
        this.$botId = r2;
        this.$modeAbility = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ChatTraceComponent$reportChatEnter$1(this.this$0, this.$botId, this.$modeAbility, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L11:
        ChatTraceComponent r2 = this.this$0;
        String r3 = this.$botId;
        int r11 = ChatTraceComponent.L;
        c r12 = r2.f1();
        if (r12 == null) goto L14;
        boolean r6 = r12.B();
    L15:
        z$a.a(r2, r3, null, null, null, r6, false, 94);
        return Unit.INSTANCE;
    L14:
        r6 = false;
        goto L15
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        AnonymousClass1 r13 = new AnonymousClass1(this.$modeAbility, null);
        this.label = 1;
        if (TimeoutKt.c(8000, r13, this) != r0) goto L11;
        return r0;
    }
}
