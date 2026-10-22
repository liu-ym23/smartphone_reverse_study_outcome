package com.larus.bmhome.chat.component.bottom.core.inputtext;

import android.content.Context;
import android.graphics.Bitmap;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.referenceicon.MessageReferenceIconStore;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"<anonymous>", "Landroid/graphics/Bitmap;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.core.inputtext.ChatInputWithMentionDelegate$loadReferenceIcon$loadBitmap$1", f = "ChatInputWithMentionDelegate.kt", i = {}, l = {317}, m = "invokeSuspend", n = {}, s = {})
final class ChatInputWithMentionDelegate$loadReferenceIcon$loadBitmap$1 extends SuspendLambda implements Function1<Continuation<? super Bitmap>, Object> {
    final /* synthetic */ d0 $reference;
    int label;
    final /* synthetic */ ChatInputWithMentionDelegate this$0;

    public ChatInputWithMentionDelegate$loadReferenceIcon$loadBitmap$1(ChatInputWithMentionDelegate r1, d0 r2, Continuation<? super ChatInputWithMentionDelegate$loadReferenceIcon$loadBitmap$1> r3) {
        this.this$0 = r1;
        this.$reference = r2;
        super(1, r3);
    }

    public final Continuation<Unit> create(Continuation<?> r4) {
        return new ChatInputWithMentionDelegate$loadReferenceIcon$loadBitmap$1(this.this$0, this.$reference, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super Bitmap> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r8);
    L11:
        return r8;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        MessageReferenceIconStore r2 = MessageReferenceIconStore.a;
        Context r9 = this.this$0.e.getContext();
        String r3 = this.$reference.getType().name();
        d0 r4 = this.$reference;
        String r5 = r4.i;
        String r6 = r4.j;
        this.label = 1;
        r8 = r2.i(r9, r3, r5, r6, this);
        if (r8 != r0) goto L11;
        return r0;
    }
}
