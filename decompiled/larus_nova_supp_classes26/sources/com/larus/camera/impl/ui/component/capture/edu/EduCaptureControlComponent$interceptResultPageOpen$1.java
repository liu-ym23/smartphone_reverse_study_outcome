package com.larus.camera.impl.ui.component.capture.edu;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.component.capture.edu.EduCaptureControlComponent", f = "EduCaptureControlComponent.kt", i = {}, l = {40}, m = "interceptResultPageOpen", n = {}, s = {})
final class EduCaptureControlComponent$interceptResultPageOpen$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ EduCaptureControlComponent this$0;

    public EduCaptureControlComponent$interceptResultPageOpen$1(EduCaptureControlComponent r1, Continuation<? super EduCaptureControlComponent$interceptResultPageOpen$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return EduCaptureControlComponent.B(this.this$0, null, this);
    }
}
