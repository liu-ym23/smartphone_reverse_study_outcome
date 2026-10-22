package com.obric.audio.enroll.ui;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.audio.enroll.ui.VoicePrintEnrollActivity", f = "VoicePrintEnrollActivity.kt", i = {}, l = {253}, m = "awaitHelpImproveVoiceWakeupEnabled", n = {}, s = {})
public final class VoicePrintEnrollActivity$awaitHelpImproveVoiceWakeupEnabled$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ VoicePrintEnrollActivity this$0;

    public VoicePrintEnrollActivity$awaitHelpImproveVoiceWakeupEnabled$1(VoicePrintEnrollActivity r1, Continuation<? super VoicePrintEnrollActivity$awaitHelpImproveVoiceWakeupEnabled$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.A1(this);
    }
}
