package com.obric.assistant.chat.component.bottom.core;

import com.larus.bmhome.chat.component.bottom.attachment.g1;
import com.obric.aivoice.core.data.NameKeys;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.b1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.chat.component.bottom.core.ObricChatInputComponent$observePhoneOperationAttachmentSendState$1", f = "ObricChatInputComponent.kt", i = {}, l = {473}, m = "invokeSuspend", n = {}, s = {})
final class ObricChatInputComponent$observePhoneOperationAttachmentSendState$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ObricChatInputComponent this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ ObricChatInputComponent a;

        public a(ObricChatInputComponent r1) {
            this.a = r1;
        }

        public final Object emit(Object r1, Continuation r2) {
            List r3 = (List) r1;
            ObricChatInputComponent r4 = this.a;
            int r5 = ObricChatInputComponent.L0;
            r4.a4("attachment_changed");
            return Unit.INSTANCE;
        }
    }

    public ObricChatInputComponent$observePhoneOperationAttachmentSendState$1(ObricChatInputComponent r1, Continuation<? super ObricChatInputComponent$observePhoneOperationAttachmentSendState$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ObricChatInputComponent$observePhoneOperationAttachmentSendState$1(this.this$0, r3);
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
        if (r1 != 1) goto L6;
        ResultKt.throwOnFailure(r5);
    L16:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        ObricChatInputComponent r6 = this.this$0;
        int r2 = ObricChatInputComponent.L0;
        g1 r7 = r6.f70();
        if (r7 == null) goto L18;
        b1 r8 = r7.YB();
        if (r8 == null) goto L18;
        a r3 = new a(this.this$0);
        this.label = 1;
        if (r8.collect(r3, this) != r0) goto L16;
        return r0;
    L18:
        return Unit.INSTANCE;
    }
}
