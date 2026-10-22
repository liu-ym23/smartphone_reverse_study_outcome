package com.facebook.imageformat;

import com.facebook.common.internal.ByteStreams;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public class ImageFormatChecker {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static ImageFormatChecker f7974c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f7975a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DefaultImageFormatChecker f7976b;

    public ImageFormatChecker() {
        DefaultImageFormatChecker r5 = new DefaultImageFormatChecker();
        this.f7976b = r5;
        this.f7975a = r5.f7961a;
    }

    public static ImageFormat a(InputStream r5) {
        monitor-enter(ImageFormatChecker.class);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (f7974c != null) goto L9;
        f7974c = new ImageFormatChecker();     // Catch: Throwable -> L7
    L9:
        ImageFormatChecker r10 = f7974c;     // Catch: Throwable -> L7
        monitor-exit(ImageFormatChecker.class);     // Catch: Throwable -> L7
        r10.getClass();
        r5.getClass();
        int r11 = r10.f7975a;
        byte[] r12 = new byte[r11];
        if (r5.markSupported() == true) goto L25;
        int r13 = ByteStreams.a(r5, r12, r11);
    L19:
        ImageFormat r14 = r10.f7976b.a(r12, r13);
        ImageFormat r15 = ImageFormat.f7971c;
        if (r14 == r15) goto L22;
        return r14;
    L22:
        return r15;
    L25:
        r5.mark(r11);     // Catch: Throwable -> L15
        r13 = ByteStreams.a(r5, r12, r11);     // Catch: Throwable -> L15
        r5.reset();
    L15:
        th = move-exception;
        r5.reset();
        throw th;
    }
}
