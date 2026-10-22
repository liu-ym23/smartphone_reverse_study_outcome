package com.larus.bmhome.chat.outerinput;

import androidx.fragment.app.Fragment;
import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.input.impl.databinding.LarusWidgetInputOuterBinding;
import com.larus.platform.spi.IAIChatService;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import tx9.c3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.outerinput.OuterChatInputController$onRealtimeCallEntranceShow$1", f = "OuterChatInputController.kt", i = {}, l = {DoraCallStateCode.DOUBAO_CMD_13}, m = "invokeSuspend", n = {}, s = {})
public final class OuterChatInputController$onRealtimeCallEntranceShow$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ OuterChatInputController this$0;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.outerinput.OuterChatInputController$onRealtimeCallEntranceShow$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/larus/im/bean/conversation/Conversation;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.outerinput.OuterChatInputController$onRealtimeCallEntranceShow$1$1", f = "OuterChatInputController.kt", i = {}, l = {116}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<wc9.e, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ OuterChatInputController this$0;

        public AnonymousClass1(OuterChatInputController r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, r4);
            r0.L$0 = r3;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((wc9.e) r1, (Continuation) r2);
        }

        public final Object invoke(wc9.e r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r10) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            by7.e r2 = null;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r10);
        L28:
            List r11 = (List) r10;
            if (r11 == null) goto L31;
            String r3 = (String) CollectionsKt.firstOrNull(r11);
        L32:
            Fragment r12 = this.this$0.a;
            if ((r12 instanceof by7.e) == false) goto L35;
            r2 = (by7.e) r12;
        L35:
            c3.b(r3, "input", null, null, r2, 58);
        L37:
            return Unit.INSTANCE;
        L31:
            r3 = null;
            goto L32
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r10);
            wc9.e r13 = (wc9.e) this.L$0;
            OuterChatInput r4 = this.this$0.c;
            boolean r5 = false;
            if (r4 != null) goto L11;
        L24:
            if (r5 == false) goto L37;
            IAIChatService.Companion r6 = IAIChatService.a;
            this.label = 1;
            r10 = r6.s7(r13, this);
            if (r10 != r0) goto L28;
            return r0;
        L11:
            if (r4.f != 4) goto L21;
            LarusWidgetInputOuterBinding r7 = r4.a;
            if (r7 != null) goto L16;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            r7 = null;
        L16:
            if (r7.b.getVisibility() != 0) goto L18;
            boolean r8 = true;
        L19:
            if (r8 == false) goto L21;
            boolean r9 = true;
        L22:
            if (r9 != true) goto L24;
            r5 = true;
            goto L24
        L18:
            r8 = false;
        L21:
            r9 = false;
            goto L22
        }
    }

    public OuterChatInputController$onRealtimeCallEntranceShow$1(OuterChatInputController r1, Continuation<? super OuterChatInputController$onRealtimeCallEntranceShow$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new OuterChatInputController$onRealtimeCallEntranceShow$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        OuterChatInputController r6 = this.this$0;
        AnonymousClass1 r2 = new AnonymousClass1(r6, null);
        this.label = 1;
        if (OuterChatInputController.d(r6, r2, this) != r0) goto L12;
        return r0;
    }
}
