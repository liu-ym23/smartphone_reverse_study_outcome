package com.facebook.imagepipeline.nativecode;

/* JADX INFO: loaded from: classes2.dex */
public abstract class WebpTranscoderFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f8250a = 0;

    static {
        if (Class.forName("com.facebook.imagepipeline.nativecode.WebpTranscoderImpl").newInstance() != null) goto L6;
        return;
    L6:
        throw new ClassCastException();     // Catch: Throwable -> L8
    }
}
