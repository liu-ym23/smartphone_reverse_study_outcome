package com.bumptech.glide.load.resource.bitmap;

import ai.j0;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
public final class i implements z.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f1609a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f1610b = null;

    static {
        f1609a = "Exif\u0000\u0000".getBytes(Charset.forName("UTF-8"));
        f1610b = new int[]{0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};
    }

    public static ImageHeaderParser$ImageType d(h r5) {
        int r10 = r5.b();     // Catch: DefaultImageHeaderParser$Reader$EndOfFileException -> L48
        if (r10 == 65496) goto L5;
        int r11 = (r10 << 8) | r5.d();     // Catch: DefaultImageHeaderParser$Reader$EndOfFileException -> L48
        if (r11 == 4671814) goto L9;
        int r12 = (r11 << 8) | r5.d();     // Catch: DefaultImageHeaderParser$Reader$EndOfFileException -> L48
        if (r12 != (-1991225785)) goto L21;
        r5.skip(21);     // Catch: DefaultImageHeaderParser$Reader$EndOfFileException -> L48
        if (r5.d() < 3) goto L17;
        return ImageHeaderParser$ImageType.PNG_A;
    L17:
        return ImageHeaderParser$ImageType.PNG;
    L19:
        return ImageHeaderParser$ImageType.PNG;
    L21:
        if (r12 != 1380533830) goto L23;
        r5.skip(4);     // Catch: DefaultImageHeaderParser$Reader$EndOfFileException -> L48
        if (((r5.b() << 16) | r5.b()) != 1464156752) goto L27;
        int r13 = (r5.b() << 16) | r5.b();     // Catch: DefaultImageHeaderParser$Reader$EndOfFileException -> L48
        if ((r13 & InputDeviceCompat.SOURCE_ANY) != 1448097792) goto L31;
        int r14 = r13 & 255;     // Catch: DefaultImageHeaderParser$Reader$EndOfFileException -> L48
        if (r14 != 88) goto L40;
        r5.skip(4);     // Catch: DefaultImageHeaderParser$Reader$EndOfFileException -> L48
        if ((r5.d() & 16) == 0) goto L38;
        return ImageHeaderParser$ImageType.WEBP_A;
    L38:
        return ImageHeaderParser$ImageType.WEBP;
    L40:
        if (r14 != 76) goto L47;
        r5.skip(4);     // Catch: DefaultImageHeaderParser$Reader$EndOfFileException -> L48
        if ((r5.d() & 8) == 0) goto L45;
        return ImageHeaderParser$ImageType.WEBP_A;
    L45:
        return ImageHeaderParser$ImageType.WEBP;
    L47:
        return ImageHeaderParser$ImageType.WEBP;
    L31:
        return ImageHeaderParser$ImageType.UNKNOWN;
    L27:
        return ImageHeaderParser$ImageType.UNKNOWN;
    L23:
        return ImageHeaderParser$ImageType.UNKNOWN;
    L9:
        return ImageHeaderParser$ImageType.GIF;
    L5:
        return ImageHeaderParser$ImageType.JPEG;
    L49:
        return ImageHeaderParser$ImageType.UNKNOWN;
    }

    public static int e(android.support.v4.media.c r10) {
    L2:
        short r5 = r10.d();
        if (r5 != 255) goto L5;
        short r11 = r10.d();
        if (r11 == 218) goto L10;
        if (r11 == 217) goto L14;
        int r12 = r10.b() - 2;
        if (r11 == 225) goto L25;
        long r13 = r12;
        long r14 = r10.skip(r13);
        if (r14 == r13) goto L2;
        if (Log.isLoggable("DfltImageHeaderParser", 3) == false) goto L24;
        StringBuilder r15 = j0.v("Unable to skip enough data, type: ", r11, r12, ", wanted to skip: ", ", but actually skipped: ");
        r15.append(r14);
        Log.d("DfltImageHeaderParser", r15.toString());
    L24:
        return -1;
    L25:
        return r12;
    L14:
        if (Log.isLoggable("DfltImageHeaderParser", 3) == false) goto L16;
        Log.d("DfltImageHeaderParser", "Found MARKER_EOI in exif segment");
    L16:
        return -1;
    L10:
        return -1;
    L5:
        if (Log.isLoggable("DfltImageHeaderParser", 3) == false) goto L7;
        Log.d("DfltImageHeaderParser", "Unknown segmentId=" + r5);
    L7:
        return -1;
    }

    public static int f(android.support.v4.media.c r16, byte[] r17, int r18) {
        int r5 = 0;
        int r10 = 0;
        int r11 = 0;
    L4:
        if (r10 >= r18) goto L8;
        r11 = ((InputStream) r16.f367a).read(r17, r10, r18 - r10);
        if (r11 == (-1)) goto L8;
        r10 = r10 + r11;
    L8:
        if (r10 != 0) goto L14;
        if (r11 != (-1)) goto L14;
        throw new DefaultImageHeaderParser$Reader$EndOfFileException();
    L14:
        if (r10 != r18) goto L16;
        short r12 = 1;
        byte[] r13 = f1609a;
        if (r17 != null) goto L22;
    L24:
        boolean r14 = false;
    L25:
        if (r14 == false) goto L33;
        int r15 = 0;
    L28:
        if (r15 >= r13.length) goto L33;
        if (r17[r15] != r13[r15]) goto L31;
        r15 = r15 + 1;
        goto L28
    L31:
        r14 = false;
    L33:
        if (r14 == false) goto L96;
        mn.i r19 = new mn.i(r17, r18);
        short r20 = r19.k(6);
        if (r20 != 18761) goto L37;
        ByteOrder r21 = ByteOrder.LITTLE_ENDIAN;
    L44:
        ByteBuffer r22 = (ByteBuffer) r19.f20153a;
        r22.order(r21);
        if ((r22.remaining() - 10) < 4) goto L47;
        int r23 = r22.getInt(10);
    L48:
        short r24 = r19.k(r23 + 6);
    L49:
        if (r5 >= r24) goto L116;
        int r110 = (r5 * 12) + (r23 + 8);
        short r111 = r19.k(r110);
        if (r111 != 274) goto L93;
        short r112 = r19.k(r110 + 2);
        if (r112 < r12) goto L91;
        if (r112 > 12) goto L91;
        int r113 = r110 + 4;
        if ((r22.remaining() - r113) < 4) goto L61;
        int r114 = r22.getInt(r113);
    L62:
        if (r114 >= 0) goto L67;
        if (Log.isLoggable("DfltImageHeaderParser", 3) == false) goto L93;
        Log.d("DfltImageHeaderParser", "Negative tiff component count");
        goto L93
    L67:
        if (Log.isLoggable("DfltImageHeaderParser", 3) == false) goto L69;
        StringBuilder r25 = j0.v("Got tagIndex=", r5, r111, " tagType=", " formatCode=");
        r25.append(r112);
        r25.append(" componentCount=");
        r25.append(r114);
        Log.d("DfltImageHeaderParser", r25.toString());
    L69:
        int r115 = r114 + f1610b[r112];
        if (r115 > 4) goto L72;
        int r116 = r110 + 8;
        if (r116 < 0) goto L88;
        if (r116 > r22.remaining()) goto L88;
        if (r115 < 0) goto L85;
        if ((r115 + r116) > r22.remaining()) goto L85;
        return r19.k(r116);
    L85:
        if (Log.isLoggable("DfltImageHeaderParser", 3) == false) goto L93;
        Log.d("DfltImageHeaderParser", "Illegal number of bytes for TI tag data tagType=" + r111);
    L88:
        if (Log.isLoggable("DfltImageHeaderParser", 3) == false) goto L93;
        Log.d("DfltImageHeaderParser", "Illegal tagValueOffset=" + r116 + " tagType=" + r111);
        goto L93
    L72:
        if (Log.isLoggable("DfltImageHeaderParser", 3) == false) goto L93;
        Log.d("DfltImageHeaderParser", "Got byte count > 4, not orientation, continuing, formatCode=" + r112);
        goto L93
    L61:
        r114 = -1;
    L91:
        if (Log.isLoggable("DfltImageHeaderParser", 3) == false) goto L93;
        Log.d("DfltImageHeaderParser", "Got invalid format code = " + r112);
    L93:
        r5 = r5 + 1;
        r12 = 1;
        goto L49
    L116:
        return -1;
    L47:
        r23 = -1;
        goto L48
    L37:
        if (r20 != 19789) goto L39;
        r21 = ByteOrder.BIG_ENDIAN;
        goto L44
    L39:
        if (Log.isLoggable("DfltImageHeaderParser", 3) == false) goto L41;
        Log.d("DfltImageHeaderParser", "Unknown endianness = " + r20);
    L41:
        r21 = ByteOrder.BIG_ENDIAN;
        goto L44
    L96:
        if (Log.isLoggable("DfltImageHeaderParser", 3) == false) goto L98;
        Log.d("DfltImageHeaderParser", "Missing jpeg exif preamble");
    L98:
        return -1;
    L22:
        if (r18 <= r13.length) goto L24;
        r14 = true;
        goto L25
    L16:
        if (Log.isLoggable("DfltImageHeaderParser", 3) == false) goto L18;
        Log.d("DfltImageHeaderParser", "Unable to read exif segment data, length: " + r18 + ", actually read: " + r10);
    L18:
        return -1;
    }

    @Override // z.b
    public final int a(InputStream r10, com.bumptech.glide.load.engine.bitmap_recycle.f r11) {
        android.support.v4.media.c r5 = new android.support.v4.media.c(r10);
        io.reactivex.internal.observers.h.h(r11, "Argument must not be null");
        int r12 = r5.b();     // Catch: DefaultImageHeaderParser$Reader$EndOfFileException -> L30
        if ((r12 & 65496) != 65496) goto L7;
    L12:
        boolean r13 = true;
    L14:
        if (r13 == false) goto L16;
        int r14 = e(r5);     // Catch: DefaultImageHeaderParser$Reader$EndOfFileException -> L30
        if (r14 == (-1)) goto L21;
        byte[] r15 = (byte[]) r11.c(r14, byte[].class);     // Catch: DefaultImageHeaderParser$Reader$EndOfFileException -> L30
        int r16 = f(r5, r15, r14);     // Catch: Throwable -> L26
        r11.h(r15);     // Catch: DefaultImageHeaderParser$Reader$EndOfFileException -> L30
        return r16;
    L26:
        th = move-exception;
        r11.h(r15);     // Catch: DefaultImageHeaderParser$Reader$EndOfFileException -> L30
        throw th;     // Catch: DefaultImageHeaderParser$Reader$EndOfFileException -> L30
    L21:
        if (Log.isLoggable("DfltImageHeaderParser", 3) == false) goto L35;
        Log.d("DfltImageHeaderParser", "Failed to parse exif segment length, or exif segment not found");     // Catch: DefaultImageHeaderParser$Reader$EndOfFileException -> L30
        return -1;
    L35:
        return -1;
    L16:
        if (Log.isLoggable("DfltImageHeaderParser", 3) == false) goto L29;
        Log.d("DfltImageHeaderParser", "Parser doesn't handle magic number: " + r12);     // Catch: DefaultImageHeaderParser$Reader$EndOfFileException -> L30
        return -1;
    L29:
        return -1;
    L7:
        if (r12 == 19789) goto L12;
        if (r12 == 18761) goto L12;
        r13 = false;
    L38:
        return -1;
    }

    @Override // z.b
    public final ImageHeaderParser$ImageType b(ByteBuffer r5) {
        io.reactivex.internal.observers.h.h(r5, "Argument must not be null");
        k6.a r10 = new k6.a();
        r10.f18623a = r5;
        r5.order(ByteOrder.BIG_ENDIAN);
        return d(r10);
    }

    @Override // z.b
    public final ImageHeaderParser$ImageType c(InputStream r5) {
        return d(new android.support.v4.media.c(r5));
    }
}
