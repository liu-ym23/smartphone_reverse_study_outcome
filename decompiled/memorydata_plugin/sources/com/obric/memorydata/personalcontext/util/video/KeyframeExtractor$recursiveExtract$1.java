package com.obric.memorydata.personalcontext.util.video;

import androidx.constraintlayout.motion.widget.Key;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.cae.userAware.WifiScanSceneType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.personalcontext.util.video.KeyframeExtractor", f = "KeyframeExtractor.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {251, 275, WifiScanSceneType.ELEVATOR_END}, m = "recursiveExtract", n = {"this", "keyframes", "startKeyFrame", "endKeyFrame", "extractor", "codec", "colorFormat", "width", "height", Key.ROTATION, CommonConsts.APM_INNER_EVENT_COST_START, "end", "mid", "this", "keyframes", "endKeyFrame", "extractor", "codec", "midKeyFrame", "colorFormat", "width", "height", Key.ROTATION, "end", "mid"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "I$1", "I$2", "I$3", "I$4", "I$5", "I$6", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "I$1", "I$2", "I$3", "I$4", "I$5"})
final class KeyframeExtractor$recursiveExtract$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    int I$4;
    int I$5;
    int I$6;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ d this$0;

    KeyframeExtractor$recursiveExtract$1(d r3, Continuation<? super KeyframeExtractor$recursiveExtract$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        super(r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r12) {
        this.result = r12;
        this.label |= Integer.MIN_VALUE;
        return d.a(this.this$0, null, null, null, null, null, 0, 0, 0, 0, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
    }
}
