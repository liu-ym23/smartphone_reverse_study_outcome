package com.larus.bmhome.chat.list.cell.generate_image;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.layout.holder.image.bean.ImageContentData;
import com.larus.uaigc.nowatermark.CreationNoWatermarkManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.list.cell.generate_image.GenerateImageCell$requestNoWatermarkImage$1$hasNoWatermark$1", f = "GenerateImageCell.kt", i = {}, l = {296}, m = "invokeSuspend", n = {}, s = {})
public final class GenerateImageCell$requestNoWatermarkImage$1$hasNoWatermark$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ ImageContentData $imageData;
    int label;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.list.cell.generate_image.GenerateImageCell$requestNoWatermarkImage$1$hasNoWatermark$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.list.cell.generate_image.GenerateImageCell$requestNoWatermarkImage$1$hasNoWatermark$1$1", f = "GenerateImageCell.kt", i = {}, l = {297}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        final /* synthetic */ ImageContentData $imageData;
        int label;

        public AnonymousClass1(ImageContentData r1, Continuation<? super AnonymousClass1> r2) {
            this.$imageData = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.$imageData, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r4);
        L11:
            return r4;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            CreationNoWatermarkManager r5 = CreationNoWatermarkManager.a;
            ImageContentData r2 = this.$imageData;
            this.label = 1;
            r4 = r5.p(r2, "message_image_explain", this);
            if (r4 != r0) goto L11;
            return r0;
        }
    }

    public GenerateImageCell$requestNoWatermarkImage$1$hasNoWatermark$1(ImageContentData r1, Continuation<? super GenerateImageCell$requestNoWatermarkImage$1$hasNoWatermark$1> r2) {
        this.$imageData = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new GenerateImageCell$requestNoWatermarkImage$1$hasNoWatermark$1(this.$imageData, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
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
        CoroutineDispatcher r7 = Dispatchers.getIO();
        AnonymousClass1 r2 = new AnonymousClass1(this.$imageData, null);
        this.label = 1;
        r6 = BuildersKt.withContext(r7, r2, this);
        if (r6 != r0) goto L11;
        return r0;
    }
}
