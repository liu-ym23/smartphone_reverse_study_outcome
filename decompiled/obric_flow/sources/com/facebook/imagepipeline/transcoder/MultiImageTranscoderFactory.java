package com.facebook.imagepipeline.transcoder;

import com.facebook.imageformat.ImageFormat;
import java.lang.reflect.Constructor;

/* JADX INFO: loaded from: classes2.dex */
public class MultiImageTranscoderFactory implements ImageTranscoderFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f8447a;

    public MultiImageTranscoderFactory(boolean r5) {
        this.f8447a = r5;
    }

    public final ImageTranscoder a(ImageFormat r5, boolean r10) {
        return b(r5, r10);
    }

    public final ImageTranscoder b(ImageFormat r5, boolean r10) {
        boolean r11 = this.f8447a;
        Class<?> r12 = Class.forName("com.facebook.imagepipeline.nativecode.NativeJpegTranscoderFactory");     // Catch: Throwable -> L6
        Class r13 = Integer.TYPE;     // Catch: Throwable -> L6
        Class r14 = Boolean.TYPE;     // Catch: Throwable -> L6
        Constructor<?> r15 = r12.getConstructor(new Class[]{r13, r14, r14});     // Catch: Throwable -> L6
        Boolean r16 = Boolean.valueOf(r11);     // Catch: Throwable -> L6
        return ((MultiImageTranscoderFactory) ((ImageTranscoderFactory) r15.newInstance(new Object[]{2048, Boolean.FALSE, r16}))).a(r5, r10);
    L6:
        e = move-exception;
        throw new RuntimeException("Dependency ':native-imagetranscoder' is needed to use the default native image transcoder.", e);
    }
}
