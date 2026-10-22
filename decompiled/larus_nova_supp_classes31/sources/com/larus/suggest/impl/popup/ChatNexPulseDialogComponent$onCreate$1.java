package com.larus.suggest.impl.popup;

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
@DebugMetadata(c = "com.larus.suggest.impl.popup.ChatNexPulseDialogComponent$onCreate$1", f = "ChatNexPulseDialogComponent.kt", i = {}, l = {80}, m = "invokeSuspend", n = {}, s = {})
public final class ChatNexPulseDialogComponent$onCreate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ChatNexPulseDialogComponent this$0;

    /* JADX INFO: renamed from: com.larus.suggest.impl.popup.ChatNexPulseDialogComponent$onCreate$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "state", "Lcom/larus/suggest/impl/popup/DialogReadyState;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.suggest.impl.popup.ChatNexPulseDialogComponent$onCreate$1$1", f = "ChatNexPulseDialogComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<e, Continuation<? super Unit>, Object> {
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

        public final Object invoke(e r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((e) r1, (Continuation) r2);
        }

        public final Object invokeSuspend(Object r7) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L31;
            ResultKt.throwOnFailure(r7);
            e r8 = (e) this.L$0;
            boolean r0 = false;
            if (r8 != null) goto L7;
        L14:
            if (r0 == true) goto L25;
            FLogger r1 = FLogger.a;
            StringBuilder r2 = new StringBuilder("dialog data not ready, data=");
            Boolean r3 = null;
            if (r8 == null) goto L20;
            NexPulseCandidate r4 = r8.a;
            if (r4 == null) goto L20;
            String r5 = r4.getGid();
        L21:
            r2.append(r5);
            r2.append(" mediaReady=");
            if (r8 == null) goto L24;
            r3 = Boxing.boxBoolean(r8.b);
        L24:
            r2.append(r3);
            r1.e("NexPulseDialogComponent", r2.toString());
        L29:
            return Unit.INSTANCE;
        L20:
            r5 = null;
            goto L21
        L25:
            ChatNexPulseDialogComponent r6 = this.this$0;
            if (r6.m <= 0) goto L29;
            ChatNexPulseDialogComponent.F2(r6, r8.a, "dialogReadyState");
            goto L29
        L7:
            if (r8.a != null) goto L9;
        L11:
            boolean r9 = false;
        L12:
            if (r9 != true) goto L14;
            r0 = true;
            goto L14
        L9:
            if (r8.b == false) goto L11;
            r9 = true;
            goto L12
        L31:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public ChatNexPulseDialogComponent$onCreate$1(ChatNexPulseDialogComponent r1, Continuation<? super ChatNexPulseDialogComponent$onCreate$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ChatNexPulseDialogComponent$onCreate$1(this.this$0, r3);
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
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        b1 r7 = q.c;
        AnonymousClass1 r2 = new AnonymousClass1(this.this$0, null);
        this.label = 1;
        if (kotlinx.coroutines.flow.e.i(r7, r2, this) != r0) goto L12;
        return r0;
    }
}
