package com.obric.memorydata.personalcontext.util.video;

import androidx.constraintlayout.motion.widget.Key;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.personalcontext.util.video.KeyframeExtractor", f = "KeyframeExtractor.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {583, 586}, m = "extractFrameAtTimeUs", n = {"this", "extractor", "codec", "bufferInfo", "colorFormat", "width", "height", Key.ROTATION, "timeUs", "this", "extractor", "codec", "bufferInfo", "colorFormat", "width", "height", Key.ROTATION, "timeUs"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "I$2", "I$3", "J$0", "L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "I$2", "I$3", "J$0"})
final class KeyframeExtractor$extractFrameAtTimeUs$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ d this$0;

    KeyframeExtractor$extractFrameAtTimeUs$1(d r3, Continuation<? super KeyframeExtractor$extractFrameAtTimeUs$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        super(r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r11) {
        this.result = r11;
        this.label |= Integer.MIN_VALUE;
        return d.b(this.this$0, null, null, 0, 0, 0, 0, 0, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
    }
}
