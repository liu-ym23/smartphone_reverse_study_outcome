package com.larus.camera.impl.ui.component.capture;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.component.capture.CaptureControlComponent", f = "CaptureControlComponent.kt", i = {0}, l = {542}, m = "interceptResultPageOpen", n = {"intercept"}, s = {"I$0"})
final class CaptureControlComponent$interceptResultPageOpen$1 extends ContinuationImpl {
    int I$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CaptureControlComponent this$0;

    public CaptureControlComponent$interceptResultPageOpen$1(CaptureControlComponent r1, Continuation<? super CaptureControlComponent$interceptResultPageOpen$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r3) {
        this.result = r3;
        this.label |= Integer.MIN_VALUE;
        return CaptureControlComponent.r(this.this$0, null, false, this);
    }
}
