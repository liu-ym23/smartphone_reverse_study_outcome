package com.larus.bmhome.chat.list.cell.text.user;

import android.view.View;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.message.Message;
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
@DebugMetadata(c = "com.larus.bmhome.chat.list.cell.text.user.UserTextCell$openAttachmentReference$2", f = "UserTextCell.kt", i = {}, l = {1367}, m = "invokeSuspend", n = {}, s = {})
final class UserTextCell$openAttachmentReference$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.larus.bmhome.chat.markdown.richtext.r.a $attachment;
    final /* synthetic */ String $boundKey;
    final /* synthetic */ Message $sourceMessage;
    final /* synthetic */ View $widget;
    int label;
    final /* synthetic */ UserTextCell this$0;

    public UserTextCell$openAttachmentReference$2(UserTextCell r1, Message r2, com.larus.bmhome.chat.markdown.richtext.r.a r3, View r4, String r5, Continuation<? super UserTextCell$openAttachmentReference$2> r6) {
        this.this$0 = r1;
        this.$sourceMessage = r2;
        this.$attachment = r3;
        this.$widget = r4;
        this.$boundKey = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new UserTextCell$openAttachmentReference$2(this.this$0, this.$sourceMessage, this.$attachment, this.$widget, this.$boundKey, r9);
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
    L11:
        UserTextCell$a r6 = (UserTextCell$a) r5;
        if (r6 != null) goto L16;
        return Unit.INSTANCE;
    L16:
        if (this.$widget.isAttachedToWindow() == false) goto L23;
        UserTextCell r2 = this.this$0;
        String r3 = this.$boundKey;
        int r4 = UserTextCell.z;
        if (r2.G(r3) == false) goto L23;
        this.this$0.J(this.$widget, r6);
        return Unit.INSTANCE;
    L23:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        UserTextCell r7 = this.this$0;
        Message r8 = this.$sourceMessage;
        String r9 = this.$attachment.a;
        this.label = 1;
        r5 = UserTextCell.r(r7, r8, r9, this);
        if (r5 != r0) goto L11;
        return r0;
    }
}
