package com.obric.memorydata.personalcontext.util.video;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.personalcontext.util.video.KeyframeExtractor", f = "KeyframeExtractor.kt", i = {0, 0, 0, 1, 1, 1, 1, 2, 2}, l = {157, 166, 182}, m = "doExtractKeyFrameTimeUs", n = {"this", "keyframes", "frameCount", "this", "keyframes", "startFrame", "frameCount", "this", "keyframes"}, s = {"L$0", "L$1", "J$0", "L$0", "L$1", "L$2", "J$0", "L$0", "L$1"})
final class KeyframeExtractor$doExtractKeyFrameTimeUs$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ d this$0;

    KeyframeExtractor$doExtractKeyFrameTimeUs$1(d r3, Continuation<? super KeyframeExtractor$doExtractKeyFrameTimeUs$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        super(r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r3) {
        this.result = r3;
        this.label |= Integer.MIN_VALUE;
        return d.a(this.this$0, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
    }
}
