package com.bytedance.android.livesdk.chatroom.ui.framework.widget.util;

import android.graphics.Bitmap;
import com.bytedance.android.live.core.log.ALogger;
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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.livesdk.chatroom.ui.framework.widget.util.BlackFrameDetectionUtil$isBitmapMostlyBlack$1", f = "BlackFrameDetectionUtil.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {171}, m = "invokeSuspend", n = {"$this$runBlocking", "sample", "splitLines", "partWidth", "partHeight", "i", "j"}, s = {"L$0", "L$1", "I$0", "I$1", "I$2", "I$3", "I$5"})
final class BlackFrameDetectionUtil$isBitmapMostlyBlack$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ Bitmap $bitmap;
    final /* synthetic */ int $sampleSize;
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    int I$4;
    int I$5;
    int I$6;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    public BlackFrameDetectionUtil$isBitmapMostlyBlack$1(Bitmap r1, int r2, Continuation r3) {
        this.$bitmap = r1;
        this.$sampleSize = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        Intrinsics.checkNotNullParameter(r5, "completion");
        BlackFrameDetectionUtil$isBitmapMostlyBlack$1 r0 = new BlackFrameDetectionUtil$isBitmapMostlyBlack$1(this.$bitmap, this.$sampleSize, r5);
        r0.L$0 = r4;
        return r0;
    }

    public final Object invoke(Object r1, Object r2) {
        return create(r1, (Continuation) r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x006f -> B:22:0x0079). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00cf -> B:27:0x00d4). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r27) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L12;
        if (r2 != 1) goto L11;
        int r3 = this.I$6;
        int r5 = this.I$5;
        int r6 = this.I$4;
        int r7 = this.I$3;
        int r8 = this.I$2;
        int r9 = this.I$1;
        int r10 = this.I$0;
        Ref.IntRef r11 = (Ref.IntRef) this.L$1;
        CoroutineScope r12 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r27);     // Catch: Exception -> L8
        BlackFrameDetectionUtil$isBitmapMostlyBlack$1 r4 = this;
        int r14 = r6;
        int r13 = r8;
        int r15 = r9;
        int r16 = r10;
        Ref.IntRef r17 = r11;
        CoroutineScope r18 = r12;
        int r19 = r5;
        Object r20 = r27;
    L28:
        if (((Boolean) r20).booleanValue() == true) goto L31;
        return Boxing.boxBoolean(false);
    L31:
        int r110 = r19 + 1;
        int r21 = r14;
        BlackFrameDetectionUtil$isBitmapMostlyBlack$1 r111 = r4;
    L22:
        if (r110 >= r3) goto L34;
        CoroutineDispatcher r22 = Dispatchers.getDefault();     // Catch: Exception -> L8
        r4 = r111;
        int r23 = r16;
        BlackFrameDetectionUtil$isBitmapMostlyBlack$1$deferred$1 r24 = new BlackFrameDetectionUtil$isBitmapMostlyBlack$1$deferred$1(r111, r7, r15, r110, r13, r17, null);     // Catch: Exception -> L8
        r14 = r21;
        int r112 = r13;
        int r25 = r7;
        int r26 = r15;
        Ref.IntRef r28 = r17;
        r19 = r110;
        Deferred r29 = BuildersKt.async$default(r18, r22, null, r24, 2, null);     // Catch: Exception -> L8
        r4.L$0 = r18;     // Catch: Exception -> L8
        r4.L$1 = r28;     // Catch: Exception -> L8
        r4.I$0 = r23;     // Catch: Exception -> L8
        r4.I$1 = r26;     // Catch: Exception -> L8
        r4.I$2 = r112;     // Catch: Exception -> L8
        r4.I$3 = r25;     // Catch: Exception -> L8
        r4.I$4 = r14;     // Catch: Exception -> L8
        r4.I$5 = r19;     // Catch: Exception -> L8
        r4.I$6 = r3;     // Catch: Exception -> L8
        r4.label = 1;     // Catch: Exception -> L8
        r20 = r29.await(r4);     // Catch: Exception -> L8
        if (r20 != r0) goto L26;
        return r0;
    L26:
        r17 = r28;
        r15 = r26;
        r7 = r25;
        r13 = r112;
        r16 = r23;
        goto L28
    L34:
        BlackFrameDetectionUtil$isBitmapMostlyBlack$1 r30 = r111;
        int r31 = r16;
        int r113 = r21;
        int r114 = r13;
        Ref.IntRef r32 = r17;
        int r115 = r7 + 1;
        int r33 = r31;
        Ref.IntRef r34 = r32;
        int r35 = r15;
        CoroutineScope r36 = r18;
        int r37 = r113;
        int r38 = r114;
        BlackFrameDetectionUtil$isBitmapMostlyBlack$1 r116 = r30;
    L20:
        if (r115 >= r37) goto L36;
        r16 = r33;
        r111 = r116;
        r18 = r36;
        r17 = r34;
        r21 = r37;
        r3 = r16;
        r15 = r35;
        r13 = r38;
        r7 = r115;
        r110 = 0;
        goto L22
    L36:
        return Boxing.boxBoolean(true);
    L8:
        e = move-exception;
        ALogger.e("BlackFrameDetectionUtil", "Scan Bitmap Exception: " + e);
        return Boxing.boxBoolean(false);
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r27);
        r36 = (CoroutineScope) this.L$0;
        if (this.$bitmap == null) goto L15;
        r34 = new Ref.IntRef();
        r34.element = 1;
        int r39 = this.$sampleSize;
        if (r39 <= 0) goto L19;
        r34.element = r39;
    L19:
        r37 = 4;
        r35 = this.$bitmap.getWidth() / 4;
        r38 = this.$bitmap.getHeight() / 4;
        r116 = this;
        r33 = 4;
        r115 = 0;
        goto L20
    L15:
        return Boxing.boxBoolean(false);
    }
}
