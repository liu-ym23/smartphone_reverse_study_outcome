package com.larus.suggest.impl.popup;

import ae8.a;
import ae8.c;
import com.larus.bmhome.chat.bean.NexPulseCandidate;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
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
import kotlinx.coroutines.flow.b1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.suggest.impl.popup.ChatNexPulseDialogComponent$onCreate$2", f = "ChatNexPulseDialogComponent.kt", i = {}, l = {90}, m = "invokeSuspend", n = {}, s = {})
public final class ChatNexPulseDialogComponent$onCreate$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ChatNexPulseDialogComponent this$0;

    /* JADX INFO: renamed from: com.larus.suggest.impl.popup.ChatNexPulseDialogComponent$onCreate$2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "state", "Lcom/larus/bmhome/chat/component/minor/MinorDialogShowState;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.suggest.impl.popup.ChatNexPulseDialogComponent$onCreate$2$1", f = "ChatNexPulseDialogComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<c, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ ChatNexPulseDialogComponent this$0;

        public AnonymousClass1(ChatNexPulseDialogComponent r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, r4);
            r0.L$0 = r3;
            return r0;
        }

        public final Object invoke(c r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((c) r1, (Continuation) r2);
        }

        public final Object invokeSuspend(Object r6) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L38;
            ResultKt.throwOnFailure(r6);
            c r7 = (c) this.L$0;
            boolean r0 = false;
            if (r7 != null) goto L7;
        L9:
            boolean r8 = false;
        L11:
            if (r8 == true) goto L13;
            FLogger.a.d("NexPulseDialogComponent", "minor dialog not checked");
        L36:
            return Unit.INSTANCE;
        L13:
            Object r9 = q.c.getValue();
            ChatNexPulseDialogComponent r3 = this.this$0;
            e r10 = (e) r9;
            if (r10 != null) goto L16;
        L23:
            if (r0 == true) goto L34;
            FLogger r1 = FLogger.a;
            StringBuilder r2 = new StringBuilder("minor checked but data not ready, data=");
            Boolean r4 = null;
            if (r10 == null) goto L29;
            NexPulseCandidate r5 = r10.a;
            if (r5 == null) goto L29;
            String r11 = r5.getGid();
        L30:
            r2.append(r11);
            r2.append(" mediaReady=");
            if (r10 == null) goto L33;
            r4 = Boxing.boxBoolean(r10.b);
        L33:
            r2.append(r4);
            r1.e("NexPulseDialogComponent", r2.toString());
        L29:
            r11 = null;
            goto L30
        L34:
            ChatNexPulseDialogComponent.F2(r3, r10.a, "minorShowState");
            goto L36
        L16:
            if (r10.a != null) goto L18;
        L20:
            boolean r12 = false;
        L21:
            if (r12 != true) goto L23;
            r0 = true;
            goto L23
        L18:
            if (r10.b == false) goto L20;
            r12 = true;
            goto L21
        L7:
            if (r7.a != true) goto L9;
            r8 = true;
            goto L11
        L38:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public ChatNexPulseDialogComponent$onCreate$2(ChatNexPulseDialogComponent r1, Continuation<? super ChatNexPulseDialogComponent$onCreate$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ChatNexPulseDialogComponent$onCreate$2(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L16:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        ChatNexPulseDialogComponent r7 = this.this$0;
        int r2 = ChatNexPulseDialogComponent.r;
        a r8 = (a) r7.k.getValue();
        if (r8 == null) goto L16;
        b1 r9 = r8.Ce();
        if (r9 == null) goto L16;
        AnonymousClass1 r3 = new AnonymousClass1(this.this$0, null);
        this.label = 1;
        if (kotlinx.coroutines.flow.e.i(r9, r3, this) != r0) goto L16;
        return r0;
    }
}
