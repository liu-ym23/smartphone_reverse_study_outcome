package com.larus.bmhome.upload.instant;

import com.larus.bmhome.music.applet.MusicAppletPage;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.upload.instant.ImageInstantUploadStrategy", f = "ImageInstantUploadStrategy.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, l = {102, 132, 138, 167}, m = "tryHit", n = {"param", "uploadScene", "sceneId", "config", "policyId", "currentStage", "preQueryPath", "$this$tryHit_u24lambda_u243", "maxFileSize", "param", "uploadScene", "config", "policyId", "currentStage", "preQueryPath", "$this$tryHit_u24lambda_u243", "sourceDigest", "param", "uploadScene", "config", "policyId", "currentStage", "preQueryPath", "$this$tryHit_u24lambda_u243", "request", MusicAppletPage.KEY_PATH, "sourceDigest", "param", "uploadScene", "config", "policyId", "currentStage", "preQueryPath", "$this$tryHit_u24lambda_u243", "request", MusicAppletPage.KEY_PATH, "response", "registerInfo", "sourceDigest"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "J$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11"})
public final class ImageInstantUploadStrategy$tryHit$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$10;
    Object L$11;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    Object L$9;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ImageInstantUploadStrategy this$0;

    public ImageInstantUploadStrategy$tryHit$1(ImageInstantUploadStrategy r1, Continuation<? super ImageInstantUploadStrategy$tryHit$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r7) {
        this.result = r7;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.o(null, null, null, null, this);
    }
}
