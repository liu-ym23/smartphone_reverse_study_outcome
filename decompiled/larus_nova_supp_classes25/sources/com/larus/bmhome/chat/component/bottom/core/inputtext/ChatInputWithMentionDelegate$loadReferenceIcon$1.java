package com.larus.bmhome.chat.component.bottom.core.inputtext;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.core.inputtext.ChatInputWithMentionDelegate$loadReferenceIcon$1", f = "ChatInputWithMentionDelegate.kt", i = {}, l = {355, 362}, m = "invokeSuspend", n = {}, s = {})
final class ChatInputWithMentionDelegate$loadReferenceIcon$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $avatarCacheKey;
    final /* synthetic */ Editable $editable;
    final /* synthetic */ j0 $iconSpan;
    final /* synthetic */ Function1<Continuation<? super Bitmap>, Object> $loadBitmap;
    final /* synthetic */ d0 $reference;
    int label;
    final /* synthetic */ ChatInputWithMentionDelegate this$0;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.component.bottom.core.inputtext.ChatInputWithMentionDelegate$loadReferenceIcon$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.core.inputtext.ChatInputWithMentionDelegate$loadReferenceIcon$1$1", f = "ChatInputWithMentionDelegate.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $avatarCacheKey;
        final /* synthetic */ Bitmap $bitmap;
        final /* synthetic */ Editable $editable;
        final /* synthetic */ j0 $iconSpan;
        final /* synthetic */ d0 $reference;
        int label;
        final /* synthetic */ ChatInputWithMentionDelegate this$0;

        public AnonymousClass1(ChatInputWithMentionDelegate r1, Editable r2, String r3, d0 r4, j0 r5, Bitmap r6, Continuation<? super AnonymousClass1> r7) {
            this.this$0 = r1;
            this.$editable = r2;
            this.$avatarCacheKey = r3;
            this.$reference = r4;
            this.$iconSpan = r5;
            this.$bitmap = r6;
            super(2, r7);
        }

        public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
            return new AnonymousClass1(this.this$0, this.$editable, this.$avatarCacheKey, this.$reference, this.$iconSpan, this.$bitmap, r10);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r8) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L33;
            ResultKt.throwOnFailure(r8);
            if (this.this$0.e.getEditableText() != this.$editable) goto L7;
            String r9 = this.$avatarCacheKey;
            if (r9 == null) goto L14;
            MessageReferenceIconStore r0 = MessageReferenceIconStore.a;
            String r1 = this.$reference.getType().name();
            d0 r2 = this.$reference;
            if (Intrinsics.areEqual(r9, MessageReferenceIconStore.a(r1, r2.i, r2.j)) == true) goto L14;
            return Unit.INSTANCE;
        L14:
            int r10 = this.$editable.getSpanStart(this.$iconSpan);
            int r3 = this.$editable.getSpanEnd(this.$iconSpan);
            if (r10 < 0) goto L31;
            if (r3 <= r10) goto L31;
            int r4 = this.$editable.getSpanFlags(this.$iconSpan);
            j0 r5 = this.$iconSpan;
            if (this.$reference.getType() != InputReferenceType.ATTACHMENT) goto L22;
            Drawable r6 = new com.larus.bmhome.chat.referenceicon.a(this.$bitmap);
        L28:
            r5.getClass();
            Intrinsics.checkNotNullParameter(r6, "icon");
            r5.f = r6;
            r5.e = true;
            this.$editable.setSpan(this.$iconSpan, r10, r3, r4);
            this.this$0.e.invalidate();
            return Unit.INSTANCE;
        L22:
            if (this.$reference.getType() != InputReferenceType.CONTACT) goto L24;
        L27:
            r6 = RoundedBitmapDrawableFactory.create(this.this$0.e.getResources(), this.$bitmap);
            r6.setCircular(true);
            Intrinsics.checkNotNull(r6);
            goto L28
        L24:
            if (this.$reference.getType() == InputReferenceType.GROUP) goto L27;
            r6 = new BitmapDrawable(this.this$0.e.getResources(), this.$bitmap);
        L31:
            return Unit.INSTANCE;
        L7:
            return Unit.INSTANCE;
        L33:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public ChatInputWithMentionDelegate$loadReferenceIcon$1(Function1<? super Continuation<? super Bitmap>, ? extends Object> r1, d0 r2, ChatInputWithMentionDelegate r3, Editable r4, String r5, j0 r6, Continuation<? super ChatInputWithMentionDelegate$loadReferenceIcon$1> r7) {
        this.$loadBitmap = r1;
        this.$reference = r2;
        this.this$0 = r3;
        this.$editable = r4;
        this.$avatarCacheKey = r5;
        this.$iconSpan = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        return new ChatInputWithMentionDelegate$loadReferenceIcon$1(this.$loadBitmap, this.$reference, this.this$0, this.$editable, this.$avatarCacheKey, this.$iconSpan, r10);
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
        if (r1 == 0) goto L15;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r12);
    L30:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L11 CancellationException -> L13
    L19:
        Bitmap r13 = (Bitmap) r12;     // Catch: Throwable -> L11 CancellationException -> L13
    L22:
        Bitmap r9 = r13;
        if (r9 == null) goto L25;
        MainCoroutineDispatcher r14 = Dispatchers.getMain().getImmediate();
        AnonymousClass1 r2 = new AnonymousClass1(this.this$0, this.$editable, this.$avatarCacheKey, this.$reference, this.$iconSpan, r9, null);
        this.label = 2;
        if (BuildersKt.withContext(r14, r2, this) != r0) goto L30;
        return r0;
    L25:
        return Unit.INSTANCE;
    L15:
        ResultKt.throwOnFailure(r12);
        Function1<Continuation<? super Bitmap>, Object> r15 = this.$loadBitmap;     // Catch: Throwable -> L11 CancellationException -> L13
        this.label = 1;     // Catch: Throwable -> L11 CancellationException -> L13
        r12 = r15.invoke(this);     // Catch: Throwable -> L11 CancellationException -> L13
        if (r12 != r0) goto L19;
        return r0;
    L13:
        e = move-exception;
        throw e;
    L11:
        th = move-exception;
        FLogger.a.w("ChatInputWithMentionDelegate", "load reference icon failed, type=" + this.$reference.getType() + ": " + th.getMessage());
        r13 = null;
        goto L22
    }
}
