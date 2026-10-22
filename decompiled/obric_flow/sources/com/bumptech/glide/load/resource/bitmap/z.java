package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.util.Log;
import com.bumptech.glide.load.engine.d0;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class z implements z.g {
    public static final z.e d = null;
    public static final z.e e = null;
    public static final com.bytedance.sdk.xbridge.cn.auth.g f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final y f1640a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bumptech.glide.load.engine.bitmap_recycle.a f1641b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.sdk.xbridge.cn.auth.g f1642c;

    static {
        d = new z.e("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.TargetFrame", -1L, new r6.a(2, false));
        sg.a r5 = new sg.a();
        r5.f21902a = ByteBuffer.allocate(4);
        e = new z.e("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.FrameOption", 2, r5);
        f = new com.bytedance.sdk.xbridge.cn.auth.g(3);
    }

    public z(com.bumptech.glide.load.engine.bitmap_recycle.a r5, y r10) {
        this.f1641b = r5;
        this.f1640a = r10;
        this.f1642c = f;
    }

    public static Bitmap c(MediaMetadataRetriever r10, long r11, int r13, int r14, int r15, j r16) {
        Bitmap r12 = null;
        if (r14 == Integer.MIN_VALUE) goto L19;
        if (r15 == Integer.MIN_VALUE) goto L19;
        if (r16 == j.e) goto L19;
        int r5 = Integer.parseInt(r10.extractMetadata(18));     // Catch: Throwable -> L15
        int r17 = Integer.parseInt(r10.extractMetadata(19));     // Catch: Throwable -> L15
        int r18 = Integer.parseInt(r10.extractMetadata(24));     // Catch: Throwable -> L15
        if (r18 != 90) goto L11;
    L12:
        r17 = r5;
        r5 = r17;
    L13:
        float r19 = r16.b(r5, r17, r14, r15);     // Catch: Throwable -> L15
        r12 = r10.getScaledFrameAtTime(r11, r13, Math.round(r5 * r19), Math.round(r19 * r17));     // Catch: Throwable -> L15
        goto L19
    L11:
        if (r18 != 270) goto L13;
    L15:
        th = move-exception;
        if (Log.isLoggable("VideoDecoder", 3) == false) goto L19;
        Log.d("VideoDecoder", "Exception trying to decode frame on oreo+", th);
    L19:
        if (r12 == null) goto L21;
        return r12;
    L21:
        return r10.getFrameAtTime(r11, r13);
    }

    @Override // z.g
    public final boolean a(Object r5, z.f r10) {
        return true;
    }

    @Override // z.g
    public final d0 b(Object r10, int r11, int r12, z.f r13) {
        long r5 = ((Long) r13.c(d)).longValue();
        if (r5 < 0) goto L5;
    L9:
        Integer r14 = (Integer) r13.c(e);
        if (r14 != null) goto L12;
        r14 = 2;
    L12:
        j r15 = (j) r13.c(j.g);
        if (r15 != null) goto L15;
        r15 = j.f;
    L15:
        j r16 = r15;
        this.f1642c.getClass();
        MediaMetadataRetriever r17 = new MediaMetadataRetriever();
        this.f1640a.c(r17, r10);     // Catch: Throwable -> L19 RuntimeException -> L21
        Bitmap r18 = c(r17, r5, r14.intValue(), r11, r12, r16);     // Catch: Throwable -> L19 RuntimeException -> L21
        r17.release();
        return c.b(r18, this.f1641b);
    L21:
        e = move-exception;
        throw new IOException(e);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        r17.release();
        throw th;
    L5:
        if (r5 == (-1)) goto L9;
        throw new IllegalArgumentException(androidx.constraintlayout.motion.widget.a.j(r5, "Requested frame must be non-negative, or DEFAULT_FRAME, given: "));
    }
}
