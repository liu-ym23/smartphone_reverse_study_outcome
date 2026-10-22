package com.bumptech.glide.load.resource.gif;

import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import com.bumptech.glide.load.engine.d0;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class k implements z.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f1662a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f1663b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bumptech.glide.load.engine.bitmap_recycle.f f1664c;

    public k(ArrayList r5, b r10, com.bumptech.glide.load.engine.bitmap_recycle.f r11) {
        this.f1662a = r5;
        this.f1663b = r10;
        this.f1664c = r11;
    }

    @Override // z.g
    public final boolean a(Object r5, z.f r10) {
        InputStream r11 = (InputStream) r5;
        if (((Boolean) r10.c(j.f1661b)).booleanValue() == true) goto L7;
        ArrayList r12 = this.f1662a;
        if (f4.b.j(this.f1664c, r11, r12) != ImageHeaderParser$ImageType.GIF) goto L7;
        return true;
    L7:
        return false;
    }

    @Override // z.g
    public final d0 b(Object r10, int r11, int r12, z.f r13) {
        InputStream r14 = (InputStream) r10;
        ByteArrayOutputStream r5 = new ByteArrayOutputStream(16384);
        byte[] r15 = new byte[16384];     // Catch: IOException -> L7
    L4:
        int r16 = r14.read(r15);     // Catch: IOException -> L7
        if (r16 == (-1)) goto L9;
        r5.write(r15, 0, r16);     // Catch: IOException -> L7
        goto L4
    L9:
        r5.flush();     // Catch: IOException -> L7
        byte[] r17 = r5.toByteArray();
    L15:
        if (r17 != null) goto L18;
        return null;
    L18:
        return this.f1663b.b(ByteBuffer.wrap(r17), r11, r12, r13);
    L7:
        e = move-exception;
        if (Log.isLoggable("StreamGifDecoder", 5) == false) goto L14;
        Log.w("StreamGifDecoder", "Error reading data from stream", e);
    L14:
        r17 = null;
        goto L15
    }
}
