package com.bytedance.android.livesdk.chatroom.ui.framework.widget.util;

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
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.livesdk.chatroom.ui.framework.widget.util.BlackFrameDetectionUtil$isBitmapMostlyBlack$1$deferred$1", f = "BlackFrameDetectionUtil.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class BlackFrameDetectionUtil$isBitmapMostlyBlack$1$deferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ int $i;
    final /* synthetic */ int $j;
    final /* synthetic */ int $partHeight;
    final /* synthetic */ int $partWidth;
    final /* synthetic */ Ref.IntRef $sample;
    int label;
    final /* synthetic */ BlackFrameDetectionUtil$isBitmapMostlyBlack$1 this$0;

    public BlackFrameDetectionUtil$isBitmapMostlyBlack$1$deferred$1(BlackFrameDetectionUtil$isBitmapMostlyBlack$1 r1, int r2, int r3, int r4, int r5, Ref.IntRef r6, Continuation r7) {
        this.this$0 = r1;
        this.$i = r2;
        this.$partWidth = r3;
        this.$j = r4;
        this.$partHeight = r5;
        this.$sample = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        Intrinsics.checkNotNullParameter(r10, "completion");
        return new BlackFrameDetectionUtil$isBitmapMostlyBlack$1$deferred$1(this.this$0, this.$i, this.$partWidth, this.$j, this.$partHeight, this.$sample, r10);
    }

    public final Object invoke(Object r1, Object r2) {
        return create(r1, (Continuation) r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L19;
        ResultKt.throwOnFailure(r8);
        int r9 = this.$i;
        int r0 = this.$partWidth;
        int r1 = r9 * r0;
        int r10 = (r9 + 1) * r0;
        int r2 = this.$j;
        int r3 = this.$partHeight;
        int r4 = r2 * r3;
        int r5 = (r2 + 1) * r3;
        if (this.this$0.$bitmap.getPixel(r1, r4) != 0) goto L7;
        int r6 = 0;
    L8:
        if (r1 >= r10) goto L17;
    L9:
        if (r4 >= r5) goto L15;
        if (this.this$0.$bitmap.getPixel(r1, r4) != r6) goto L13;
        r4 = r4 + this.$sample.element;
        goto L9
    L13:
        return Boxing.boxBoolean(false);
    L15:
        r1 = r1 + this.$sample.element;
        goto L8
    L17:
        return Boxing.boxBoolean(true);
    L7:
        r6 = -16777216;
        goto L8
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
