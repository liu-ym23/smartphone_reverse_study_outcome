package com.larus.audioplayer.impl.stream;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.audioplayer.impl.stream.AudioStreamPlayer", f = "AudioStreamPlayer.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2}, l = {744, 750, 779, 869}, m = "startSseChunk", n = {"url", "resourceId", "onHeaderParsed", "onMusicDataParsed", "needStop", "curIndex", "loopIndex", "seqNo", "startTime", "hasWavHeader", "url", "resourceId", "onHeaderParsed", "onMusicDataParsed", "needStop", "curIndex", "loopIndex", "seqNo", "startTime", "hasWavHeader", "url", "resourceId", "onMusicDataParsed", "needStop", "curIndex", "loopIndex", "seqNo", "startTime"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "I$1", "J$0", "I$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "I$1", "J$0", "I$2", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1", "J$0"})
public final class AudioStreamPlayer$startSseChunk$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AudioStreamPlayer this$0;

    public AudioStreamPlayer$startSseChunk$1(AudioStreamPlayer r1, Continuation<? super AudioStreamPlayer$startSseChunk$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r13) {
        this.result = r13;
        this.label |= LKBaseResponseModel.DEFAULT_ERROR_CODE;
        AudioStreamPlayer r0 = this.this$0;
        AudioStreamPlayer r14 = AudioStreamPlayer.a;
        return r0.z(null, null, null, null, null, 0, 0, 0, false, this);
    }
}
