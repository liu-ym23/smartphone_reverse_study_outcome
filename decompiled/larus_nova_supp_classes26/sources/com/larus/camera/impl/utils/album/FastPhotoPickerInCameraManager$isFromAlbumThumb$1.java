package com.larus.camera.impl.utils.album;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.utils.album.FastPhotoPickerInCameraManager", f = "FastPhotoPickerInCameraManager.kt", i = {0}, l = {77}, m = "isFromAlbumThumb", n = {"conversationId"}, s = {"L$0"})
public final class FastPhotoPickerInCameraManager$isFromAlbumThumb$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FastPhotoPickerInCameraManager this$0;

    public FastPhotoPickerInCameraManager$isFromAlbumThumb$1(FastPhotoPickerInCameraManager r1, Continuation<? super FastPhotoPickerInCameraManager$isFromAlbumThumb$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(null, null, null, this);
    }
}
