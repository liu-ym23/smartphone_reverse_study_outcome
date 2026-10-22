package com.larus.uaigc.chat.block.widget.video;

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
@DebugMetadata(c = "com.larus.uaigc.chat.block.widget.video.VideoSuccessViewBinder$requestNoWatermarkVideo$1", f = "VideoSuccessViewBinder.kt", i = {}, l = {337}, m = "invokeSuspend", n = {}, s = {})
final class VideoSuccessViewBinder$requestNoWatermarkVideo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $indexInMsg;
    final /* synthetic */ String $key;
    final /* synthetic */ String $messageId;
    final /* synthetic */ String $taskId;
    int label;
    final /* synthetic */ VideoSuccessViewBinder this$0;

    public VideoSuccessViewBinder$requestNoWatermarkVideo$1(VideoSuccessViewBinder r1, String r2, String r3, String r4, int r5, Continuation<? super VideoSuccessViewBinder$requestNoWatermarkVideo$1> r6) {
        this.this$0 = r1;
        this.$key = r2;
        this.$messageId = r3;
        this.$taskId = r4;
        this.$indexInMsg = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new VideoSuccessViewBinder$requestNoWatermarkVideo$1(this.this$0, this.$key, this.$messageId, this.$taskId, this.$indexInMsg, r9);
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
        this.this$0.k.remove(this.$key);
    L21:
        if (r9 == false) goto L24;
        this.this$0.l.remove(this.$key);
    L27:
        cz9.o r10 = this.this$0.f;
        if (r10 == null) goto L30;
        Message r0 = r10.e;
        if (r0 == null) goto L34;
        String r4 = r0.getMessageId();
    L36:
        if (Intrinsics.areEqual(r4, this.$messageId) == false) goto L46;
        CreationItem r5 = r10.d;
        if (r5 == null) goto L41;
        r3 = r5.id;
    L41:
        if (Intrinsics.areEqual(r3, this.$taskId) == false) goto L46;
        if (r10.f != this.$indexInMsg) goto L46;
        this.this$0.p2(r10);
    L46:
        return Unit.INSTANCE;
    L34:
        r4 = null;
        goto L36
    L30:
        return Unit.INSTANCE;
    L24:
        if (this.this$0.l.size() < 100) goto L26;
        ((LinkedHashMap) this.this$0.l).clear();
    L26:
        this.this$0.l.put(this.$key, Boxing.boxLong(System.currentTimeMillis()));
        goto L27
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L13:
        ResultKt.throwOnFailure(r8);
        VideoSuccessViewBinder$requestNoWatermarkVideo$1$hasNoWatermark$1 r11 = new VideoSuccessViewBinder$requestNoWatermarkVideo$1$hasNoWatermark$1(this.$key, null);     // Catch: Throwable -> L7 CancellationException -> L9
        this.label = 1;     // Catch: Throwable -> L7 CancellationException -> L9
        r8 = TimeoutKt.c(3000, r11, this);     // Catch: Throwable -> L7 CancellationException -> L9
        if (r8 != r1) goto L17;
        return r1;
    L48:
        th = move-exception;
        this.this$0.k.remove(this.$key);
        throw th;
    L7:
        th = move-exception;
        FLogger.a.w("VideoSuccessViewBinder", "request no watermark video failed, msg=" + th.getMessage());     // Catch: Throwable -> L48
        this.this$0.k.remove(this.$key);
        r9 = false;
    L9:
        e = move-exception;
        throw e;     // Catch: Throwable -> L48
    }
}
