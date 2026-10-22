package com.larus.bmhome.chat.list.cell.text.user;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.TextView;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.referenceicon.ImageViewBitmapLoader;
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
@DebugMetadata(c = "com.larus.bmhome.chat.list.cell.text.user.UserTextCell$loadDocumentReferenceIcon$1$bitmap$1", f = "UserTextCell.kt", i = {}, l = {1000}, m = "invokeSuspend", n = {}, s = {})
public final class UserTextCell$loadDocumentReferenceIcon$1$bitmap$1 extends SuspendLambda implements Function1<Continuation<? super Bitmap>, Object> {
    final /* synthetic */ String $bindKey;
    final /* synthetic */ String $documentUrl;
    final /* synthetic */ TextView $textView;
    int label;
    final /* synthetic */ UserTextCell this$0;

    public UserTextCell$loadDocumentReferenceIcon$1$bitmap$1(TextView r1, String r2, UserTextCell r3, String r4, Continuation<? super UserTextCell$loadDocumentReferenceIcon$1$bitmap$1> r5) {
        this.$textView = r1;
        this.$documentUrl = r2;
        this.this$0 = r3;
        this.$bindKey = r4;
        super(1, r5);
    }

    public final Continuation<Unit> create(Continuation<?> r8) {
        return new UserTextCell$loadDocumentReferenceIcon$1$bitmap$1(this.$textView, this.$documentUrl, this.this$0, this.$bindKey, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super Bitmap> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L11:
        return r7;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        int r8 = ImageViewBitmapLoader.a;
        Context r9 = this.$textView.getContext();
        final String r2 = this.$documentUrl;
        final UserTextCell r3 = this.this$0;
        final String r4 = this.$bindKey;
        Function1 r5 = new o0(r2, r3, r4);
        this.label = 1;
        r7 = ImageViewBitmapLoader.a(r9, false, r5, this);
        if (r7 != r0) goto L11;
        return r0;
    }
}
