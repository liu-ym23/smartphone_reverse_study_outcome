package com.larus.bmhome.chat.list.cell.text.user;

import android.graphics.Bitmap;
import android.widget.TextView;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.referenceicon.MessageReferenceIconStore;
import com.larus.utils.logger.FLogger;
import java.util.concurrent.CancellationException;
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
@DebugMetadata(c = "com.larus.bmhome.chat.list.cell.text.user.UserTextCell$loadDocumentReferenceIcon$1", f = "UserTextCell.kt", i = {}, l = {999}, m = "invokeSuspend", n = {}, s = {})
final class UserTextCell$loadDocumentReferenceIcon$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $bindKey;
    final /* synthetic */ String $documentUrl;
    final /* synthetic */ a $iconSpan;
    final /* synthetic */ TextView $textView;
    int label;
    final /* synthetic */ UserTextCell this$0;

    public UserTextCell$loadDocumentReferenceIcon$1(String r1, UserTextCell r2, String r3, TextView r4, a r5, Continuation<? super UserTextCell$loadDocumentReferenceIcon$1> r6) {
        this.$documentUrl = r1;
        this.this$0 = r2;
        this.$bindKey = r3;
        this.$textView = r4;
        this.$iconSpan = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new UserTextCell$loadDocumentReferenceIcon$1(this.$documentUrl, this.this$0, this.$bindKey, this.$textView, this.$iconSpan, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L15 CancellationException -> L17
    L13:
        Bitmap r13 = (Bitmap) r12;     // Catch: Throwable -> L15 CancellationException -> L17
    L20:
        final Bitmap r8 = r13;
        if (r8 == null) goto L23;
        FLogger r14 = FLogger.a;
        int r2 = UserTextCell.z;
        r14.i("UserTextCell", "[ReferenceIconTrace] path=drive_span stage=docs_icon_resolved bindHash=" + UserTextCell.o(this.this$0, this.$bindKey) + ", urlHash=" + UserTextCell.o(this.this$0, this.$documentUrl));
        final TextView r15 = this.$textView;
        final UserTextCell r4 = this.this$0;
        final String r5 = this.$bindKey;
        final a r7 = this.$iconSpan;
        final String r9 = this.$documentUrl;
        r15.post(new n0(r4, r5, r15, r7, r8, r9));
        return Unit.INSTANCE;
    L23:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r12);
        MessageReferenceIconStore r16 = MessageReferenceIconStore.a;     // Catch: Throwable -> L15 CancellationException -> L17
        String r3 = this.$documentUrl;     // Catch: Throwable -> L15 CancellationException -> L17
        UserTextCell$loadDocumentReferenceIcon$1$bitmap$1 r10 = new UserTextCell$loadDocumentReferenceIcon$1$bitmap$1(this.$textView, r3, this.this$0, this.$bindKey, null);     // Catch: Throwable -> L15 CancellationException -> L17
        this.label = 1;     // Catch: Throwable -> L15 CancellationException -> L17
        r12 = r16.h(MessageReferenceIconStore.b(r3), r10, this);     // Catch: Throwable -> L15 CancellationException -> L17
        if (r12 != r0) goto L13;
        return r0;
    L17:
        e = move-exception;
        throw e;
    L15:
        th = move-exception;
        FLogger r6 = FLogger.a;
        int r11 = UserTextCell.z;
        r6.w("UserTextCell", "load document reference icon failed: " + th.getMessage());
        r13 = null;
        goto L20
    }
}
