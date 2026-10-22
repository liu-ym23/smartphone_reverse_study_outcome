package com.facebook.imagepipeline.decoder;

import com.facebook.common.internal.Throwables;
import com.facebook.common.memory.ByteArrayPool;
import com.facebook.common.memory.PooledByteArrayBufferedInputStream;
import com.facebook.common.util.StreamUtil;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class ProgressiveJpegParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f8163a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f8164b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f8165c;
    public int d;
    public int e;
    public int f;
    public boolean g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ByteArrayPool f8166h;

    public ProgressiveJpegParser(ByteArrayPool r5) {
        r5.getClass();
        this.f8166h = r5;
        this.f8165c = 0;
        this.f8164b = 0;
        this.d = 0;
        this.f = 0;
        this.e = 0;
        this.f8163a = 0;
    }

    public final boolean a(PooledByteArrayBufferedInputStream r11) {
        int r5 = this.e;
    L73:
    L11:
        e = move-exception;
        Throwables.a(e, Error.class);
        Throwables.a(e, RuntimeException.class);
        throw new RuntimeException(e);
    L4:
        if (this.f8163a == 6) goto L66;
        int r10 = r11.read();     // Catch: IOException -> L11
        if (r10 == (-1)) goto L66;
        int r12 = this.f8165c;     // Catch: IOException -> L11
        this.f8165c = r12 + 1;     // Catch: IOException -> L11
        if (this.g == true) goto L9;
        int r13 = this.f8163a;     // Catch: IOException -> L11
        if (r13 != 0) goto L16;
        if (r10 != 255) goto L62;
        this.f8163a = 1;     // Catch: IOException -> L11
    L63:
        this.f8164b = r10;     // Catch: IOException -> L11
        goto L73
    L62:
        this.f8163a = 6;     // Catch: IOException -> L11
        goto L63
    L16:
        if (r13 != 1) goto L18;
        if (r10 != 216) goto L59;
        this.f8163a = 2;     // Catch: IOException -> L11
        goto L63
    L59:
        this.f8163a = 6;     // Catch: IOException -> L11
        goto L63
    L18:
        if (r13 != 2) goto L20;
        if (r10 != 255) goto L63;
        this.f8163a = 3;     // Catch: IOException -> L11
        goto L63
    L20:
        if (r13 != 3) goto L22;
        if (r10 != 255) goto L30;
        this.f8163a = 3;     // Catch: IOException -> L11
        goto L63
    L30:
        if (r10 != 0) goto L33;
        this.f8163a = 2;     // Catch: IOException -> L11
        goto L63
    L33:
        if (r10 != 217) goto L39;
        this.g = true;     // Catch: IOException -> L11
        int r14 = r12 - 1;     // Catch: IOException -> L11
        int r15 = this.d;     // Catch: IOException -> L11
        if (r15 <= 0) goto L37;
        this.f = r14;     // Catch: IOException -> L11
    L37:
        this.d = r15 + 1;     // Catch: IOException -> L11
        this.e = r15;     // Catch: IOException -> L11
        this.f8163a = 2;     // Catch: IOException -> L11
        goto L63
    L39:
        if (r10 != 218) goto L44;
        int r16 = r12 - 1;     // Catch: IOException -> L11
        int r17 = this.d;     // Catch: IOException -> L11
        if (r17 <= 0) goto L43;
        this.f = r16;     // Catch: IOException -> L11
    L43:
        this.d = r17 + 1;     // Catch: IOException -> L11
        this.e = r17;     // Catch: IOException -> L11
    L44:
        if (r10 != 1) goto L47;
    L54:
        this.f8163a = 2;     // Catch: IOException -> L11
        goto L63
    L47:
        if (r10 >= 208) goto L49;
    L51:
        if (r10 == 217) goto L54;
        if (r10 == 216) goto L54;
        this.f8163a = 4;     // Catch: IOException -> L11
        goto L63
    L49:
        if (r10 > 215) goto L51;
    L22:
        if (r13 == 4) goto L27;
        if (r13 != 5) goto L26;
        int r18 = ((this.f8164b << 8) + r10) - 2;     // Catch: IOException -> L11
        StreamUtil.a(r11, r18);     // Catch: IOException -> L11
        this.f8165c += r18;     // Catch: IOException -> L11
        this.f8163a = 2;     // Catch: IOException -> L11
        goto L63
    L26:
        throw new IllegalStateException();     // Catch: IOException -> L11
    L27:
        this.f8163a = 5;     // Catch: IOException -> L11
        goto L63
    L9:
        this.f8163a = 6;     // Catch: IOException -> L11
        this.g = false;     // Catch: IOException -> L11
        return false;
    L66:
        if (this.f8163a != 6) goto L68;
    L70:
        return false;
    L68:
        if (this.e == r5) goto L70;
        return true;
    }
}
