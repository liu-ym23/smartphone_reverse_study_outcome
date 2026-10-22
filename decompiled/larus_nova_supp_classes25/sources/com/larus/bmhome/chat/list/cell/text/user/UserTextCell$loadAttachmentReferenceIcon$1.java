package com.larus.bmhome.chat.list.cell.text.user;

import android.graphics.Bitmap;
import android.widget.TextView;
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
@DebugMetadata(c = "com.larus.bmhome.chat.list.cell.text.user.UserTextCell$loadAttachmentReferenceIcon$1", f = "UserTextCell.kt", i = {1}, l = {922, 925}, m = "invokeSuspend", n = {"visual"}, s = {"L$0"})
final class UserTextCell$loadAttachmentReferenceIcon$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $bindKey;
    final /* synthetic */ a $iconSpan;
    final /* synthetic */ UserTextCell$a $knownTarget;
    final /* synthetic */ String $resourceUri;
    final /* synthetic */ Message $sourceMessage;
    final /* synthetic */ TextView $textView;
    Object L$0;
    int label;
    final /* synthetic */ UserTextCell this$0;

    public UserTextCell$loadAttachmentReferenceIcon$1(UserTextCell$a r1, UserTextCell r2, Message r3, String r4, TextView r5, String r6, a r7, Continuation<? super UserTextCell$loadAttachmentReferenceIcon$1> r8) {
        this.$knownTarget = r1;
        this.this$0 = r2;
        this.$sourceMessage = r3;
        this.$resourceUri = r4;
        this.$textView = r5;
        this.$bindKey = r6;
        this.$iconSpan = r7;
        super(2, r8);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new UserTextCell$loadAttachmentReferenceIcon$1(this.$knownTarget, this.this$0, this.$sourceMessage, this.$resourceUri, this.$textView, this.$bindKey, this.$iconSpan, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        com.larus.bmhome.chat.referenceicon.b r2 = (com.larus.bmhome.chat.referenceicon.b) this.L$0;
        ResultKt.throwOnFailure(r9);
        final com.larus.bmhome.chat.referenceicon.b r5 = r2;
    L23:
        final Bitmap r6 = (Bitmap) r9;
        final TextView r10 = this.$textView;
        final UserTextCell r3 = this.this$0;
        final String r4 = this.$bindKey;
        final a r7 = this.$iconSpan;
        r10.post(new m0(r3, r4, r10, r7, r5, r6));
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r9);
    L15:
        UserTextCell$a r11 = (UserTextCell$a) r9;
        if (r11 == null) goto L18;
    L19:
        com.larus.bmhome.chat.referenceicon.b r12 = com.larus.bmhome.chat.referenceicon.c.a(r11.c);
        UserTextCell r8 = this.this$0;
        this.L$0 = r12;
        this.label = 2;
        Object r13 = UserTextCell.s(r8, r12, this);
        if (r13 != r0) goto L22;
        return r0;
    L22:
        r5 = r12;
        r9 = r13;
        goto L23
    L18:
        return Unit.INSTANCE;
    L10:
        ResultKt.throwOnFailure(r9);
        r11 = this.$knownTarget;
        if (r11 != null) goto L19;
        UserTextCell r14 = this.this$0;
        Message r15 = this.$sourceMessage;
        String r16 = this.$resourceUri;
        this.label = 1;
        r9 = UserTextCell.r(r14, r15, r16, this);
        if (r9 != r0) goto L15;
        return r0;
    }
}
