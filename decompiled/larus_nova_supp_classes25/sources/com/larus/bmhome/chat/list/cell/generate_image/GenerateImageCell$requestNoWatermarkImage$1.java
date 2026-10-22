package com.larus.bmhome.chat.list.cell.generate_image;

import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.layout.holder.image.bean.ImageContentData;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;
import lf8.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.list.cell.generate_image.GenerateImageCell$requestNoWatermarkImage$1", f = "GenerateImageCell.kt", i = {}, l = {295}, m = "invokeSuspend", n = {}, s = {})
final class GenerateImageCell$requestNoWatermarkImage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ImageContentData $imageData;
    final /* synthetic */ Message $message;
    final /* synthetic */ String $pendingKey;
    int label;
    final /* synthetic */ GenerateImageCell this$0;

    public GenerateImageCell$requestNoWatermarkImage$1(String r1, GenerateImageCell r2, Message r3, ImageContentData r4, Continuation<? super GenerateImageCell$requestNoWatermarkImage$1> r5) {
        this.$pendingKey = r1;
        this.this$0 = r2;
        this.$message = r3;
        this.$imageData = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new GenerateImageCell$requestNoWatermarkImage$1(this.$pendingKey, this.this$0, this.$message, this.$imageData, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        String r3 = null;
        if (r2 == 0) goto L13;
        if (r2 != 1) goto L12;
        ResultKt.throwOnFailure(r8);     // Catch: Throwable -> L7 CancellationException -> L9
    L17:
        boolean r9 = Intrinsics.areEqual(r8, Boxing.boxBoolean(true));     // Catch: Throwable -> L7 CancellationException -> L9
        GenerateImageCell.A.remove(this.$pendingKey);
    L21:
        if (r9 == false) goto L23;
        GenerateImageCell.B.remove(this.$pendingKey);
    L27:
        Message r10 = this.this$0.o;
        if (r10 == null) goto L31;
        r3 = r10.getMessageId();
    L31:
        if (Intrinsics.areEqual(r3, this.$message.getMessageId()) == false) goto L39;
        q0 r11 = a.b(this.this$0);
        if (r11 == null) goto L39;
        String r0 = this.$message.getMessageId();
        if (r0 != null) goto L37;
        r0 = "";
    L37:
        Boxing.boxBoolean(r11.x7(r0, this.$message.getContentType()));
    L39:
        return Unit.INSTANCE;
    L23:
        ConcurrentHashMap r12 = GenerateImageCell.B;
        if (r12.size() < 300) goto L26;
        r12.clear();
    L26:
        r12.put(this.$pendingKey, Boxing.boxLong(System.currentTimeMillis()));
        goto L27
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L13:
        ResultKt.throwOnFailure(r8);
        GenerateImageCell$requestNoWatermarkImage$1$hasNoWatermark$1 r13 = new GenerateImageCell$requestNoWatermarkImage$1$hasNoWatermark$1(this.$imageData, null);     // Catch: Throwable -> L7 CancellationException -> L9
        this.label = 1;     // Catch: Throwable -> L7 CancellationException -> L9
        r8 = TimeoutKt.c(3000, r13, this);     // Catch: Throwable -> L7 CancellationException -> L9
        if (r8 != r1) goto L17;
        return r1;
    L41:
        th = move-exception;
        GenerateImageCell.A.remove(this.$pendingKey);
        throw th;
    L7:
        th = move-exception;
        FLogger.a.w("Image4OrScrollHolder", "request content type image no watermark failed, msg=" + th.getMessage());     // Catch: Throwable -> L41
        GenerateImageCell.A.remove(this.$pendingKey);
        r9 = false;
    L9:
        e = move-exception;
        throw e;     // Catch: Throwable -> L41
    }
}
