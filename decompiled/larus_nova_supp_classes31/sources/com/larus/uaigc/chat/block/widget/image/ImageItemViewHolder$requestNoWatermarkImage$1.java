package com.larus.uaigc.chat.block.widget.image;

import com.larus.im.bean.message.CreationItem;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.util.LinkedHashMap;
import java.util.concurrent.CancellationException;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.chat.block.widget.image.ImageItemViewHolder$requestNoWatermarkImage$1", f = "ImageItemViewHolder.kt", i = {}, l = {273}, m = "invokeSuspend", n = {}, s = {})
final class ImageItemViewHolder$requestNoWatermarkImage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $keepProgressLoading;
    final /* synthetic */ String $key;
    final /* synthetic */ String $messageId;
    final /* synthetic */ String $taskId;
    int label;
    final /* synthetic */ ImageItemViewHolder this$0;

    public ImageItemViewHolder$requestNoWatermarkImage$1(ImageItemViewHolder r1, String r2, String r3, String r4, boolean r5, Continuation<? super ImageItemViewHolder$requestNoWatermarkImage$1> r6) {
        this.this$0 = r1;
        this.$key = r2;
        this.$messageId = r3;
        this.$taskId = r4;
        this.$keepProgressLoading = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new ImageItemViewHolder$requestNoWatermarkImage$1(this.this$0, this.$key, this.$messageId, this.$taskId, this.$keepProgressLoading, r9);
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
        if (r2 != 0) goto L51;
        ResultKt.throwOnFailure(r8);
        ImageItemViewHolder$requestNoWatermarkImage$1$hasNoWatermark$1 r9 = new ImageItemViewHolder$requestNoWatermarkImage$1$hasNoWatermark$1(this.$key, null);     // Catch: Throwable -> L15 CancellationException -> L46
        this.label = 1;     // Catch: Throwable -> L15 CancellationException -> L46
        r8 = TimeoutKt.c(3000, r9, this);     // Catch: Throwable -> L15 CancellationException -> L46
        if (r8 != r1) goto L13;
        return r1;
    L13:
        boolean r10 = Intrinsics.areEqual(r8, Boxing.boxBoolean(true));     // Catch: Throwable -> L15 CancellationException -> L46
        this.this$0.s.remove(this.$key);
    L18:
        if (r10 == false) goto L21;
        this.this$0.u.remove(this.$key);
    L24:
        cz9.h r11 = this.this$0.q;
        if (r11 == null) goto L27;
        Message r0 = r11.e;
        if (r0 == null) goto L31;
        String r4 = r0.getMessageId();
    L33:
        if (Intrinsics.areEqual(r4, this.$messageId) == false) goto L45;
        CreationItem r5 = r11.d;
        if (r5 == null) goto L38;
        r3 = r5.id;
    L38:
        if (Intrinsics.areEqual(r3, this.$taskId) == false) goto L45;
        if (this.$keepProgressLoading == false) goto L42;
        this.this$0.t.add(ImageItemViewHolder.V3(r11));
    L43:
        this.this$0.p2(r11);
        goto L45
    L42:
        this.this$0.t.remove(ImageItemViewHolder.V3(r11));
    L45:
        return Unit.INSTANCE;
    L31:
        r4 = null;
        goto L33
    L27:
        return Unit.INSTANCE;
    L21:
        if (this.this$0.u.size() < 100) goto L23;
        ((LinkedHashMap) this.this$0.u).clear();
    L23:
        this.this$0.u.put(this.$key, Boxing.boxLong(System.currentTimeMillis()));
        goto L24
    L51:
        if (r2 != 1) goto L8;
        ResultKt.throwOnFailure(r8);     // Catch: Throwable -> L15 CancellationException -> L46
        goto L13
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L48:
        th = move-exception;
        this.this$0.s.remove(this.$key);
        throw th;
    L46:
        e = move-exception;
        throw e;     // Catch: Throwable -> L48
    L15:
        th = move-exception;
        FLogger.a.w("ImageItemViewHolder", "request no watermark image failed, msg=" + th.getMessage());     // Catch: Throwable -> L48
        this.this$0.s.remove(this.$key);
        r10 = false;
        goto L18
    }
}
