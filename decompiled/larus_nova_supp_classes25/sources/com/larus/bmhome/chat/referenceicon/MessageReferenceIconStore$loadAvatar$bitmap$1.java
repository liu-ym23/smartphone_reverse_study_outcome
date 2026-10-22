package com.larus.bmhome.chat.referenceicon;

import android.content.Context;
import android.graphics.Bitmap;
import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
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
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"<anonymous>", "Landroid/graphics/Bitmap;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.referenceicon.MessageReferenceIconStore$loadAvatar$bitmap$1", f = "MessageReferenceIconStore.kt", i = {}, l = {DoraCallStateCode.DOUBAO_CMD_5}, m = "invokeSuspend", n = {}, s = {})
public final class MessageReferenceIconStore$loadAvatar$bitmap$1 extends SuspendLambda implements Function1<Continuation<? super Bitmap>, Object> {
    final /* synthetic */ String $avatarKey;
    final /* synthetic */ String $cacheKey;
    final /* synthetic */ Context $context;
    final /* synthetic */ String $entityId;
    final /* synthetic */ String $type;
    int label;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.referenceicon.MessageReferenceIconStore$loadAvatar$bitmap$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/graphics/Bitmap;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.referenceicon.MessageReferenceIconStore$loadAvatar$bitmap$1$1", f = "MessageReferenceIconStore.kt", i = {}, l = {DoraCallStateCode.DOUBAO_CMD_13}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Bitmap>, Object> {
        final /* synthetic */ String $avatarKey;
        final /* synthetic */ String $cacheKey;
        final /* synthetic */ Context $context;
        final /* synthetic */ String $entityId;
        final /* synthetic */ String $type;
        int label;

        public AnonymousClass1(String r1, String r2, String r3, String r4, Context r5, Continuation<? super AnonymousClass1> r6) {
            this.$cacheKey = r1;
            this.$type = r2;
            this.$avatarKey = r3;
            this.$entityId = r4;
            this.$context = r5;
            super(2, r6);
        }

        public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
            return new AnonymousClass1(this.$cacheKey, this.$type, this.$avatarKey, this.$entityId, this.$context, r9);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Bitmap> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r7);
        L14:
            Bitmap r8 = (Bitmap) r7;
            if (r8 == null) goto L20;
            String r2 = this.$cacheKey;
            String r3 = this.$type;
            String r4 = this.$avatarKey;
            String r5 = this.$entityId;
            MessageReferenceIconStore r6 = MessageReferenceIconStore.a;
            if (Intrinsics.areEqual(r2, MessageReferenceIconStore.a(r3, r4, r5)) == true) goto L19;
            return null;
        L19:
            return r8;
        L20:
            return null;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r7);
            String r9 = this.$cacheKey;
            MessageReferenceIconStore r10 = MessageReferenceIconStore.a;
            if (Intrinsics.areEqual(r9, MessageReferenceIconStore.a(this.$type, this.$avatarKey, this.$entityId)) == true) goto L11;
            return null;
        L11:
            int r11 = ImageViewBitmapLoader.a;
            Context r12 = this.$context;
            final String r13 = this.$avatarKey;
            final String r14 = this.$entityId;
            Function1 r15 = new g(r13, r14);
            this.label = 1;
            r7 = ImageViewBitmapLoader.a(r12, true, r15, this);
            if (r7 != r0) goto L14;
            return r0;
        }
    }

    public MessageReferenceIconStore$loadAvatar$bitmap$1(String r1, String r2, String r3, String r4, Context r5, Continuation<? super MessageReferenceIconStore$loadAvatar$bitmap$1> r6) {
        this.$cacheKey = r1;
        this.$type = r2;
        this.$avatarKey = r3;
        this.$entityId = r4;
        this.$context = r5;
        super(1, r6);
    }

    public final Continuation<Unit> create(Continuation<?> r9) {
        return new MessageReferenceIconStore$loadAvatar$bitmap$1(this.$cacheKey, this.$type, this.$avatarKey, this.$entityId, this.$context, r9);
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
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r11);
    L11:
        return r11;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        MainCoroutineDispatcher r12 = Dispatchers.getMain().getImmediate();
        AnonymousClass1 r2 = new AnonymousClass1(this.$cacheKey, this.$type, this.$avatarKey, this.$entityId, this.$context, null);
        this.label = 1;
        r11 = BuildersKt.withContext(r12, r2, this);
        if (r11 != r0) goto L11;
        return r0;
    }
}
