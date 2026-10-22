package com.larus.chat.gallery.impl.preview.input;

import java.util.Set;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.chat.gallery.impl.preview.input.PreviewCameraParamProvider", f = "PreviewCameraParamProvider.kt", i = {0, 1}, l = {653, 656, 670}, m = "resolveMessageVideoPath", n = {"video", "video"}, s = {"L$0", "L$0"})
public final class PreviewCameraParamProvider$resolveMessageVideoPath$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PreviewCameraParamProvider this$0;

    public PreviewCameraParamProvider$resolveMessageVideoPath$1(PreviewCameraParamProvider r1, Continuation<? super PreviewCameraParamProvider$resolveMessageVideoPath$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        PreviewCameraParamProvider r3 = this.this$0;
        Set<String> r0 = PreviewCameraParamProvider.s;
        return r3.q(null, this);
    }
}
