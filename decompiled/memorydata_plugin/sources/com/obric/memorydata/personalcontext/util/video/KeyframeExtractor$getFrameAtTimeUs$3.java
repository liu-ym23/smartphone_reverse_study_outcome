package com.obric.memorydata.personalcontext.util.video;

import android.graphics.Bitmap;
import android.media.MediaCodec;
import android.media.MediaExtractor;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
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
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.personalcontext.util.video.KeyframeExtractor$getFrameAtTimeUs$3", f = "KeyframeExtractor.kt", i = {}, l = {472}, m = "invokeSuspend", n = {}, s = {})
final class KeyframeExtractor$getFrameAtTimeUs$3 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ MediaCodec $codec;
    final /* synthetic */ int $colorFormat;
    final /* synthetic */ MediaExtractor $extractor;
    final /* synthetic */ int $height;
    final /* synthetic */ Ref.ObjectRef<d.b> $result;
    final /* synthetic */ int $rotation;
    final /* synthetic */ long $timeUs;
    final /* synthetic */ int $width;
    Object L$0;
    int label;
    final /* synthetic */ d this$0;

    KeyframeExtractor$getFrameAtTimeUs$3(Ref.ObjectRef<d.b> r3, d r4, MediaExtractor r5, MediaCodec r6, int r7, int r8, int r9, int r10, long r11, Continuation<? super KeyframeExtractor$getFrameAtTimeUs$3> r13) {
        Continuation r14 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r13, Continuation.class, "com.obric.memorydata.plugin");
        this.$result = r3;
        this.this$0 = r4;
        this.$extractor = r5;
        this.$codec = r6;
        this.$colorFormat = r7;
        this.$width = r8;
        this.$height = r9;
        this.$rotation = r10;
        this.$timeUs = r11;
        super(2, r14);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r14, Continuation<?> r15) {
        Continuation r12 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r15, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new KeyframeExtractor$getFrameAtTimeUs$3(this.$result, this.this$0, this.$extractor, this.$codec, this.$colorFormat, this.$width, this.$height, this.$rotation, this.$timeUs, r12), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((KeyframeExtractor$getFrameAtTimeUs$3) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), KeyframeExtractor$getFrameAtTimeUs$3.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r15) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        Ref.ObjectRef<d.b> r2 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(this.L$0, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r15);
        T r16 = r15;
    L12:
        r2.element = r16;
        Map r17 = d.a(this.this$0);
        Long r3 = Boxing.boxLong(this.$timeUs);
        Bitmap r14 = ((d.b) ZeusTransformUtils.preCheckCast(this.$result.element, d.b.class, "com.obric.memorydata.plugin")).a();
        Intrinsics.checkNotNull(r14);
        r17.put(r3, r14);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r15);
        Ref.ObjectRef<d.b> r18 = this.$result;
        d r4 = this.this$0;
        MediaExtractor r5 = this.$extractor;
        MediaCodec r6 = this.$codec;
        int r7 = this.$colorFormat;
        int r8 = this.$width;
        int r9 = this.$height;
        int r10 = this.$rotation;
        long r11 = this.$timeUs;
        Continuation r13 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.L$0 = r18;
        this.label = 1;
        Object r12 = d.b(r4, r5, r6, r7, r8, r9, r10, r11, r13);
        if (r12 != r0) goto L11;
        return r0;
    L11:
        r2 = r18;
        r16 = r12;
        goto L12
    }
}
