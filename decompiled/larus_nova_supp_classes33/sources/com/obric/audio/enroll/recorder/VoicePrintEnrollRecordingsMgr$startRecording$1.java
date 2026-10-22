package com.obric.audio.enroll.recorder;

import com.obric.capabilitykit.common.ErrorCode;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.audio.enroll.recorder.VoicePrintEnrollRecordingsMgr", f = "VoicePrintEnrollRecordingsMgr.kt", i = {1, 1, 2, 2, 2, 3}, l = {70, ErrorCode.APP_VERSION_TOO_LOW, 135, 165, 166}, m = "startRecording", n = {"recorderChannelConfig", "audioFormat", "recorderChannelConfig", "audioFormat", "index", "index"}, s = {"I$0", "I$1", "I$0", "I$1", "I$2", "I$0"})
public final class VoicePrintEnrollRecordingsMgr$startRecording$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ VoicePrintEnrollRecordingsMgr this$0;

    public VoicePrintEnrollRecordingsMgr$startRecording$1(VoicePrintEnrollRecordingsMgr r1, Continuation<? super VoicePrintEnrollRecordingsMgr$startRecording$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(this);
    }
}
