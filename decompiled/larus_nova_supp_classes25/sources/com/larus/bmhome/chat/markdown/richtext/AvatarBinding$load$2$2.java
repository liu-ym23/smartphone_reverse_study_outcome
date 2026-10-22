package com.larus.bmhome.chat.markdown.richtext;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.Spanned;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.referenceicon.MessageReferenceIconStore;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.markdown.richtext.AvatarBinding$load$2$2", f = "MentionAvatarMarkdownPlugin.kt", i = {}, l = {97}, m = "invokeSuspend", n = {}, s = {})
public final class AvatarBinding$load$2$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ p $avatar;
    final /* synthetic */ String $cacheKey;
    final /* synthetic */ List<d> $targets;
    int label;
    final /* synthetic */ AvatarBinding this$0;

    public AvatarBinding$load$2$2(AvatarBinding r1, p r2, String r3, List<d> r4, Continuation<? super AvatarBinding$load$2$2> r5) {
        this.this$0 = r1;
        this.$avatar = r2;
        this.$cacheKey = r3;
        this.$targets = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new AvatarBinding$load$2$2(this.this$0, this.$avatar, this.$cacheKey, this.$targets, r8);
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
        List r3 = null;
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r11);     // Catch: Throwable -> L15 CancellationException -> L48
    L13:
        Bitmap r12 = (Bitmap) r11;     // Catch: Throwable -> L15 CancellationException -> L48
    L16:
        if (r12 == null) goto L18;
        Object r2 = this.this$0.a.getTag(2131377343);
        AvatarBinding r4 = this.this$0;
        if (r2 != r4) goto L47;
        if (r4.a.isAttachedToWindow() == false) goto L47;
        p r5 = this.$avatar;
        r5.getClass();
        MessageReferenceIconStore r6 = MessageReferenceIconStore.a;
        if (Intrinsics.areEqual(MessageReferenceIconStore.a(r5.a, r5.b, r5.c), this.$cacheKey) == false) goto L47;
        CharSequence r7 = this.this$0.a.getText();
        if ((r7 instanceof Spanned) == false) goto L29;
        Spanned r8 = (Spanned) r7;
    L30:
        if (r8 == null) goto L32;
        r3 = fh8.o.c(r8, d.class);
    L32:
        if (r3 != null) goto L34;
        r3 = CollectionsKt.emptyList();
    L34:
        List<d> r9 = this.$targets;
        ArrayList r10 = new ArrayList();
        Iterator<T> r13 = r9.iterator();
    L36:
        if (r13.hasNext() == false) goto L40;
        Object r14 = r13.next();
        if (r3.contains((d) r14) == false) goto L36;
        r10.add(r14);
        goto L36
    L40:
        String r15 = this.$cacheKey;
        Iterator r16 = r10.iterator();
    L42:
        if (r16.hasNext() == false) goto L44;
        d r17 = (d) r16.next();
        r17.getClass();
        Intrinsics.checkNotNullParameter(r15, "cacheKey");
        Intrinsics.checkNotNullParameter(r12, "bitmap");
        r17.e = r15;
        RoundedBitmapDrawable r18 = RoundedBitmapDrawableFactory.create(r17.a, r12);
        r18.setCircular(true);
        r17.f = r18;
        goto L42
    L44:
        this.this$0.a.invalidate();
        return Unit.INSTANCE;
    L29:
        r8 = null;
    L47:
        return Unit.INSTANCE;
    L18:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r11);
        MessageReferenceIconStore r19 = MessageReferenceIconStore.a;     // Catch: Throwable -> L15 CancellationException -> L48
        Context r20 = this.this$0.a.getContext();     // Catch: Throwable -> L15 CancellationException -> L48
        String r21 = this.$avatar.getType();     // Catch: Throwable -> L15 CancellationException -> L48
        p r110 = this.$avatar;     // Catch: Throwable -> L15 CancellationException -> L48
        String r22 = r110.b;     // Catch: Throwable -> L15 CancellationException -> L48
        String r23 = r110.c;     // Catch: Throwable -> L15 CancellationException -> L48
        this.label = 1;     // Catch: Throwable -> L15 CancellationException -> L48
        r11 = r19.i(r20, r21, r22, r23, this);     // Catch: Throwable -> L15 CancellationException -> L48
        if (r11 != r0) goto L13;
        return r0;
    L48:
        e = move-exception;
        throw e;
    L15:
        FLogger.a.w("MentionAvatar", "downstream avatar load failed");
        r12 = null;
        goto L16
    }
}
