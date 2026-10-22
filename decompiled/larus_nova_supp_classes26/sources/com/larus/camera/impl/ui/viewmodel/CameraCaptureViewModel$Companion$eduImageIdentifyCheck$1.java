package com.larus.camera.impl.ui.viewmodel;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.viewmodel.CameraCaptureViewModel$Companion", f = "CameraCaptureViewModel.kt", i = {0, 0, 0, 0, 1, 1, 1}, l = {124, 137}, m = "eduImageIdentifyCheck", n = {"ability", "context", "albumUri", "imagePath", "ability", "context", "albumUri"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2"})
public final class CameraCaptureViewModel$Companion$eduImageIdentifyCheck$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CameraCaptureViewModel.Companion this$0;

    public CameraCaptureViewModel$Companion$eduImageIdentifyCheck$1(CameraCaptureViewModel.Companion r1, Continuation<? super CameraCaptureViewModel$Companion$eduImageIdentifyCheck$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r7) {
        this.result = r7;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, null, null, null, this);
    }
}
