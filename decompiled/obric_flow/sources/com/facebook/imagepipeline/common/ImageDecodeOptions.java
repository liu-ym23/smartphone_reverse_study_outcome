package com.facebook.imagepipeline.common;

import ai.j0;
import android.graphics.Bitmap;
import com.facebook.common.internal.Objects;
import com.facebook.imagepipeline.decoder.ImageDecoder;

/* JADX INFO: loaded from: classes2.dex */
public class ImageDecodeOptions {
    public static final ImageDecodeOptions e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f8042a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Bitmap.Config f8043b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageDecoder f8044c;
    public final boolean d;

    static {
        e = new ImageDecodeOptions(new ImageDecodeOptionsBuilder());
    }

    public ImageDecodeOptions(ImageDecodeOptionsBuilder r5) {
        this.f8042a = r5.f8045a;
        this.f8043b = r5.f8046b;
        this.f8044c = r5.f8047c;
        this.d = r5.d;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L20:
        return false;
    L8:
        if (getClass() != r5.getClass()) goto L20;
        ImageDecodeOptions r10 = (ImageDecodeOptions) r5;
        if (this.f8043b == r10.f8043b) goto L14;
        return false;
    L14:
        if (this.f8044c == r10.f8044c) goto L17;
        return false;
    L17:
        if (this.d == r10.d) goto L19;
        return false;
    L19:
        return true;
    }

    public final int hashCode() {
        int r5 = (this.f8043b.ordinal() + 674909381) * 31;
        ImageDecoder r10 = this.f8044c;
        if (r10 == null) goto L5;
        int r11 = r10.hashCode();
    L7:
        return (((r5 + r11) * 923521) + (this.d ? 1 : 0)) * 961;
    L5:
        r11 = 0;
        goto L7
    }

    public final String toString() {
        return j0.q(new StringBuilder("ImageDecodeOptions{"), new Objects.ToStringHelper(getClass().getSimpleName()).a("minDecodeIntervalMs", String.valueOf(100)).a("maxDimensionPx", String.valueOf(Integer.MAX_VALUE)).a("decodePreviewFrame", String.valueOf(false)).a("useLastFrameForPreview", String.valueOf(false)).a("decodeAllFrames", String.valueOf(false)).a("forceStaticImage", String.valueOf(false)).a("bitmapConfigName", this.f8043b.name()).a("customImageDecoder", this.f8044c).a("bitmapTransformation", null).a("colorSpace", null).toString(), "}");
    }
}
