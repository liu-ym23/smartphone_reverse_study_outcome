package com.larus.bmhome.chat.list.cell.text.user;

import android.content.Context;
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
@DebugMetadata(c = "com.larus.bmhome.chat.list.cell.text.user.UserTextCell$buildMarkdownDisplayText$2$3", f = "UserTextCell.kt", i = {}, l = {815}, m = "invokeSuspend", n = {}, s = {})
public final class UserTextCell$buildMarkdownDisplayText$2$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $avatarCacheKey;
    final /* synthetic */ String $bindKey;
    final /* synthetic */ a $iconSpan;
    final /* synthetic */ com.larus.bmhome.chat.markdown.richtext.h $mention;
    final /* synthetic */ TextView $textView;
    final /* synthetic */ String $type;
    int label;
    final /* synthetic */ UserTextCell this$0;

    public UserTextCell$buildMarkdownDisplayText$2$3(TextView r1, String r2, com.larus.bmhome.chat.markdown.richtext.h r3, UserTextCell r4, String r5, String r6, a r7, Continuation<? super UserTextCell$buildMarkdownDisplayText$2$3> r8) {
        this.$textView = r1;
        this.$type = r2;
        this.$mention = r3;
        this.this$0 = r4;
        this.$bindKey = r5;
        this.$avatarCacheKey = r6;
        this.$iconSpan = r7;
        super(2, r8);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new UserTextCell$buildMarkdownDisplayText$2$3(this.$textView, this.$type, this.$mention, this.this$0, this.$bindKey, this.$avatarCacheKey, this.$iconSpan, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L11;
        if (r1 != 1) goto L10;
        ResultKt.throwOnFailure(r11);     // Catch: CancellationException -> L7 Throwable -> L17
    L15:
        Bitmap r12 = (Bitmap) r11;     // Catch: CancellationException -> L7 Throwable -> L17
    L18:
        final Bitmap r8 = r12;
        if (r8 == null) goto L21;
        final TextView r13 = this.$textView;
        final UserTextCell r2 = this.this$0;
        final String r3 = this.$bindKey;
        final String r4 = this.$avatarCacheKey;
        final String r5 = this.$type;
        final com.larus.bmhome.chat.markdown.richtext.h r6 = this.$mention;
        final a r7 = this.$iconSpan;
        r13.post(new i0(r2, r3, r4, r5, r6, r13, r7, r8));
        return Unit.INSTANCE;
    L21:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        ResultKt.throwOnFailure(r11);
        MessageReferenceIconStore r9 = MessageReferenceIconStore.a;     // Catch: CancellationException -> L7 Throwable -> L17
        Context r14 = this.$textView.getContext();     // Catch: CancellationException -> L7 Throwable -> L17
        String r10 = this.$type;     // Catch: CancellationException -> L7 Throwable -> L17
        com.larus.bmhome.chat.markdown.richtext.h r15 = this.$mention;     // Catch: CancellationException -> L7 Throwable -> L17
        String r16 = r15.f;     // Catch: CancellationException -> L7 Throwable -> L17
        String r17 = r15.g;     // Catch: CancellationException -> L7 Throwable -> L17
        this.label = 1;     // Catch: CancellationException -> L7 Throwable -> L17
        r11 = r9.i(r14, r10, r16, r17, this);     // Catch: CancellationException -> L7 Throwable -> L17
        if (r11 != r0) goto L15;
        return r0;
    L7:
        e = move-exception;
        throw e;
    L17:
        FLogger r18 = FLogger.a;
        int r19 = UserTextCell.z;
        r18.w("UserTextCell", "load mention avatar failed");
        r12 = null;
        goto L18
    }
}
