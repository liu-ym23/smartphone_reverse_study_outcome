package com.larus.chat.gallery.impl.preview.input;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.chat.gallery.impl.preview.input.PreviewCameraParamProvider", f = "PreviewCameraParamProvider.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {511}, m = "startCamera", n = {"activity", "camera", "snapshot", "snapshotId", "returnAlbumNodeId", "resultRoute", "forceNewCaptureActivity"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0"})
public final class PreviewCameraParamProvider$startCamera$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PreviewCameraParamProvider this$0;

    public PreviewCameraParamProvider$startCamera$1(PreviewCameraParamProvider r1, Continuation<? super PreviewCameraParamProvider$startCamera$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.t(null, null, null, this);
    }
}
