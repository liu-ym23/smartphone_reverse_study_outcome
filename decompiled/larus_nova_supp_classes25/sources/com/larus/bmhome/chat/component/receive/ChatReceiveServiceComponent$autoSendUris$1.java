package com.larus.bmhome.chat.component.receive;

import android.net.Uri;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.component.bottom.p1;
import com.larus.bmhome.chat.model.j1;
import com.larus.bmhome.chat.model.n;
import com.larus.platform.service.z2;
import java.util.List;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.receive.ChatReceiveServiceComponent$autoSendUris$1", f = "ChatReceiveServiceComponent.kt", i = {}, l = {662}, m = "invokeSuspend", n = {}, s = {})
public final class ChatReceiveServiceComponent$autoSendUris$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $replaceModeDraftAfterValidation;
    final /* synthetic */ String $replacementToken;
    final /* synthetic */ List<Uri> $sendUris;
    int label;
    final /* synthetic */ ChatReceiveServiceComponent this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public ChatReceiveServiceComponent$autoSendUris$1(ChatReceiveServiceComponent r1, List<? extends Uri> r2, boolean r3, String r4, Continuation<? super ChatReceiveServiceComponent$autoSendUris$1> r5) {
        this.this$0 = r1;
        this.$sendUris = r2;
        this.$replaceModeDraftAfterValidation = r3;
        this.$replacementToken = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new ChatReceiveServiceComponent$autoSendUris$1(this.this$0, this.$sendUris, this.$replaceModeDraftAfterValidation, this.$replacementToken, r8);
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
        if (((Boolean) r5).booleanValue() == true) goto L14;
        ChatReceiveServiceComponent r6 = this.this$0;
        List<Uri> r2 = this.$sendUris;
        boolean r3 = this.$replaceModeDraftAfterValidation;
        String r4 = this.$replacementToken;
        int r7 = ChatReceiveServiceComponent.x;
        r6.U2(r2, r3, r4);
        return Unit.INSTANCE;
    L14:
        if (this.$replaceModeDraftAfterValidation == false) goto L30;
        z2 r8 = z2.a;
        if (z2.c4() == false) goto L30;
        ChatReceiveServiceComponent r9 = this.this$0;
        int r10 = ChatReceiveServiceComponent.x;
        p1 r11 = r9.cr();
        n r12 = null;
        if (r11 == null) goto L20;
        j1 r13 = r11.Y3();
    L22:
        if ((r13 instanceof n) == false) goto L24;
        r12 = (n) r13;
    L24:
        if (r12 == null) goto L26;
        r12.d = true;
    L26:
        p1 r14 = this.this$0.cr();
        if (r14 == null) goto L30;
        r14.cb(false);
        Boxing.boxBoolean(true);
        goto L30
    L20:
        r13 = null;
    L30:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        ChatReceiveServiceComponent r15 = this.this$0;
        List<Uri> r16 = this.$sendUris;
        this.label = 1;
        r5 = ChatReceiveServiceComponent.F2(r15, r16, this);
        if (r5 != r0) goto L12;
        return r0;
    }
}
