package com.facebook.imagepipeline.transcoder;

import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.MemoryPooledByteBufferOutputStream;

/* JADX INFO: loaded from: classes2.dex */
public abstract class SimpleImageTranscoder implements ImageTranscoder {
    public abstract ImageTranscodeResult a(EncodedImage r5, MemoryPooledByteBufferOutputStream r10, RotationOptions r11, ResizeOptions r12);
}
