package com.larus.bmhome.chat.component.bottom.core.inputtext;

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
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"<anonymous>", "Landroid/graphics/Bitmap;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.core.inputtext.ChatInputWithMentionDelegate$loadReferenceIcon$loadBitmap$4", f = "ChatInputWithMentionDelegate.kt", i = {}, l = {330, 334}, m = "invokeSuspend", n = {}, s = {})
final class ChatInputWithMentionDelegate$loadReferenceIcon$loadBitmap$4 extends SuspendLambda implements Function1<Continuation<? super Bitmap>, Object> {
    final /* synthetic */ i0 $documentIcon;
    final /* synthetic */ String $documentUrl;
    final /* synthetic */ Integer $objType;
    final /* synthetic */ d0 $reference;
    int label;
    final /* synthetic */ ChatInputWithMentionDelegate this$0;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.component.bottom.core.inputtext.ChatInputWithMentionDelegate$loadReferenceIcon$loadBitmap$4$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"<anonymous>", "Landroid/graphics/Bitmap;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.core.inputtext.ChatInputWithMentionDelegate$loadReferenceIcon$loadBitmap$4$2", f = "ChatInputWithMentionDelegate.kt", i = {}, l = {335}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Bitmap>, Object> {
        final /* synthetic */ String $documentUrl;
        final /* synthetic */ Integer $objType;
        final /* synthetic */ d0 $reference;
        int label;
        final /* synthetic */ ChatInputWithMentionDelegate this$0;

        public AnonymousClass2(ChatInputWithMentionDelegate r1, d0 r2, String r3, Integer r4, Continuation<? super AnonymousClass2> r5) {
            this.this$0 = r1;
            this.$reference = r2;
            this.$documentUrl = r3;
            this.$objType = r4;
            super(1, r5);
        }

        public final Continuation<Unit> create(Continuation<?> r8) {
            return new AnonymousClass2(this.this$0, this.$reference, this.$documentUrl, this.$objType, r8);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((Continuation) r1);
        }

        public final Object invoke(Continuation<? super Bitmap> r2) {
            return create(r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r6);
        L11:
            return r6;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            ChatInputWithMentionDelegate r7 = this.this$0;
            d0 r2 = this.$reference;
            String r3 = this.$documentUrl;
            Integer r4 = this.$objType;
            this.label = 1;
            r6 = ChatInputWithMentionDelegate.d(r7, r2, r3, r4, this);
            if (r6 != r0) goto L11;
            return r0;
        }
    }

    public ChatInputWithMentionDelegate$loadReferenceIcon$loadBitmap$4(i0 r1, ChatInputWithMentionDelegate r2, d0 r3, String r4, Integer r5, Continuation<? super ChatInputWithMentionDelegate$loadReferenceIcon$loadBitmap$4> r6) {
        this.$documentIcon = r1;
        this.this$0 = r2;
        this.$reference = r3;
        this.$documentUrl = r4;
        this.$objType = r5;
        super(1, r6);
    }

    public final Continuation<Unit> create(Continuation<?> r9) {
        return new ChatInputWithMentionDelegate$loadReferenceIcon$loadBitmap$4(this.$documentIcon, this.this$0, this.$reference, this.$documentUrl, this.$objType, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super Bitmap> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r11);
    L43:
        return (Bitmap) r11;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r11);
    L25:
        Bitmap r12 = (Bitmap) r11;
        if (r12 == null) goto L38;
        String r2 = this.$documentUrl;
        MessageReferenceIconStore r3 = MessageReferenceIconStore.a;
        Intrinsics.checkNotNullParameter(r2, "documentUrl");
        Intrinsics.checkNotNullParameter(r12, "bitmap");
        String r4 = MessageReferenceIconStore.b(r2);
        if (r12.isRecycled() == true) goto L47;
        Object r5 = MessageReferenceIconStore.b;
        monitor-enter(r5);
        Bitmap r6 = (Bitmap) MessageReferenceIconStore.c.put(r4, r12);     // Catch: Throwable -> L35
        monitor-exit(r5);
        return r12;
    L35:
        th = move-exception;
        throw th;
    L47:
        return r12;
    L38:
        return null;
    L10:
        ResultKt.throwOnFailure(r11);
        i0 r13 = this.$documentIcon;
        boolean r7 = false;
        if (r13 != null) goto L13;
    L21:
        if (r7 == false) goto L39;
        ChatInputWithMentionDelegate r14 = this.this$0;
        d0 r8 = this.$reference;
        String r9 = this.$documentUrl;
        Integer r10 = this.$objType;
        this.label = 1;
        r11 = ChatInputWithMentionDelegate.d(r14, r8, r9, r10, this);
        if (r11 != r0) goto L25;
        return r0;
    L39:
        MessageReferenceIconStore r15 = MessageReferenceIconStore.a;
        String r16 = this.$documentUrl;
        AnonymousClass2 r17 = new AnonymousClass2(this.this$0, this.$reference, r16, this.$objType, null);
        this.label = 2;
        r11 = r15.h(MessageReferenceIconStore.b(r16), r17, this);
        if (r11 != r0) goto L43;
        return r0;
    L13:
        if (r13.b == 0) goto L15;
    L18:
        boolean r18 = true;
    L19:
        if (r18 != true) goto L21;
        r7 = true;
        goto L21
    L15:
        if ((!StringsKt.isBlank(r13.d)) == true) goto L18;
        r18 = false;
        goto L19
    }
}
