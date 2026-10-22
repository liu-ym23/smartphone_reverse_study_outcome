package com.bumptech.glide.load.resource.bitmap;

import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bytedance.rpc.internal.RpcUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
public final class DefaultImageHeaderParser implements ImageHeaderParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final byte[] f835a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int[] f836b = null;

    private interface Reader {

        public static final class EndOfFileException extends IOException {
            private static final long serialVersionUID = 1;

            EndOfFileException() {
                super("Unexpectedly reached end of a file");
            }
        }

        int a(byte[] r1, int r2);

        long a(long r1);

        short a();

        int b();
    }

    private static final class a implements Reader {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ByteBuffer f837a;

        a(ByteBuffer r1) {
            this.f837a = r1;
            r1.order(ByteOrder.BIG_ENDIAN);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public int a(byte[] r2, int r3) {
            int r4 = Math.min(r3, this.f837a.remaining());
            if (r4 != 0) goto L6;
            return -1;
        L6:
            this.f837a.get(r2, 0, r4);
            return r4;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public long a(long r3) {
            int r4 = (int) Math.min(this.f837a.remaining(), r3);
            ByteBuffer r2 = this.f837a;
            r2.position(r2.position() + r4);
            return r4;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public short a() {
            if (this.f837a.remaining() < 1) goto L7;
            return (short) (this.f837a.get() & 255);
        L7:
            throw new Reader.EndOfFileException();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public int b() {
            int r0 = a() << 8;
            return a() | r0;
        }
    }

    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ByteBuffer f838a;

        b(byte[] r2, int r3) {
            this.f838a = (ByteBuffer) ZeusTransformUtils.preCheckCast(ByteBuffer.wrap(r2).order(ByteOrder.BIG_ENDIAN).limit(r3), ByteBuffer.class, "com.obric.memorydata.plugin");
        }

        private boolean a(int r1, int r2) {
            if ((this.f838a.remaining() - r1) < r2) goto L5;
            return true;
        L5:
            return false;
        }

        int a() {
            return this.f838a.remaining();
        }

        int a(int r2) {
            if (a(r2, 4) == true) goto L7;
            return -1;
        L7:
            return this.f838a.getInt(r2);
        }

        void a(ByteOrder r1) {
            this.f838a.order(r1);
        }

        short b(int r2) {
            if (a(r2, 2) == true) goto L7;
            return -1;
        L7:
            return this.f838a.getShort(r2);
        }
    }

    private static final class c implements Reader {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final InputStream f839a;

        c(InputStream r1) {
            this.f839a = r1;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public int a(byte[] r5, int r6) {
            int r0 = 0;
            int r1 = 0;
        L4:
            if (r0 >= r6) goto L8;
            r1 = this.f839a.read(r5, r0, r6 - r0);
            if (r1 == (-1)) goto L8;
            r0 = r0 + r1;
        L8:
            if (r0 != 0) goto L13;
            if (r1 != (-1)) goto L13;
            throw new Reader.EndOfFileException();
        L13:
            return r0;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public long a(long r8) {
            if (r8 >= 0) goto L5;
            return 0;
        L5:
            long r2 = r8;
        L7:
            if (r2 <= 0) goto L16;
            long r4 = this.f839a.skip(r2);
            if (r4 > 0) goto L10;
            if (this.f839a.read() == (-1)) goto L16;
            r4 = 1;
        L10:
            r2 = r2 - r4;
        L16:
            return r8 - r2;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public short a() {
            int r1 = this.f839a.read();
            if (r1 == (-1)) goto L7;
            return (short) r1;
        L7:
            throw new Reader.EndOfFileException();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public int b() {
            int r0 = a() << 8;
            return a() | r0;
        }
    }

    static {
        f835a = "Exif\u0000\u0000".getBytes(Charset.forName(RpcUtils.CHARSET_UTF8));
        f836b = new int[]{0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};
    }

    public DefaultImageHeaderParser() {
    }

    private static int a(int r0, int r1) {
        return (r0 + 2) + (r1 * 12);
    }

    private int a(Reader r9) {
        Reader r8 = (Reader) ZeusTransformUtils.wrapperContextForParams(r9, Reader.class, "com.obric.memorydata.plugin");
    L3:
        short r10 = r8.a();
        if (r10 != 255) goto L6;
        short r11 = r8.a();
        if (r11 == 218) goto L11;
        if (r11 == 217) goto L15;
        int r0 = r8.b() - 2;
        if (r11 == 225) goto L26;
        long r4 = r0;
        long r6 = r8.a(r4);
        if (r6 == r4) goto L3;
        if (Log.isLoggable("DfltImageHeaderParser", 3) == false) goto L25;
        Log.d("DfltImageHeaderParser", "Unable to skip enough data, type: " + r11 + ", wanted to skip: " + r0 + ", but actually skipped: " + r6);
    L25:
        return -1;
    L26:
        return r0;
    L15:
        if (Log.isLoggable("DfltImageHeaderParser", 3) == false) goto L17;
        Log.d("DfltImageHeaderParser", "Found MARKER_EOI in exif segment");
    L17:
        return -1;
    L11:
        return -1;
    L6:
        if (Log.isLoggable("DfltImageHeaderParser", 3) == false) goto L8;
        Log.d("DfltImageHeaderParser", "Unknown segmentId=" + r10);
    L8:
        return -1;
    }

    private int a(Reader r8, com.bumptech.glide.load.engine.bitmap_recycle.b r9) {
        Reader r10 = (Reader) ZeusTransformUtils.wrapperContextForParams(r8, Reader.class, "com.obric.memorydata.plugin");
        com.bumptech.glide.load.engine.bitmap_recycle.b r11 = (com.bumptech.glide.load.engine.bitmap_recycle.b) ZeusTransformUtils.wrapperContextForParams(r9, com.bumptech.glide.load.engine.bitmap_recycle.b.class, "com.obric.memorydata.plugin");
        int r3 = r10.b();     // Catch: Reader.EndOfFileException -> L23
        if (a(r3) == false) goto L7;
        int r4 = a(r10);     // Catch: Reader.EndOfFileException -> L23
        if (r4 == (-1)) goto L13;
        byte[] r0 = (byte[]) ZeusTransformUtils.preCheckCast(r11.a(r4, byte[].class), byte[].class, "com.obric.memorydata.plugin");     // Catch: Reader.EndOfFileException -> L23
        int r7 = a(r10, r0, r4);     // Catch: Throwable -> L20
        r11.a(r0);     // Catch: Reader.EndOfFileException -> L23
        return r7;
    L20:
        th = move-exception;
        r11.a(r0);     // Catch: Reader.EndOfFileException -> L23
        throw th;     // Catch: Reader.EndOfFileException -> L23
    L13:
        if (Log.isLoggable("DfltImageHeaderParser", 3) == false) goto L15;
        Log.d("DfltImageHeaderParser", "Failed to parse exif segment length, or exif segment not found");     // Catch: Reader.EndOfFileException -> L23
    L15:
        return -1;
    L7:
        if (Log.isLoggable("DfltImageHeaderParser", 3) == false) goto L9;
        Log.d("DfltImageHeaderParser", "Parser doesn't handle magic number: " + r3);     // Catch: Reader.EndOfFileException -> L23
    L9:
        return -1;
    L23:
        return -1;
    }

    private int a(Reader r4, byte[] r5, int r6) {
        int r7 = ((Reader) ZeusTransformUtils.wrapperContextForParams(r4, Reader.class, "com.obric.memorydata.plugin")).a(r5, r6);
        if (r7 == r6) goto L9;
        if (Log.isLoggable("DfltImageHeaderParser", 3) == false) goto L7;
        Log.d("DfltImageHeaderParser", "Unable to read exif segment data, length: " + r6 + ", actually read: " + r7);
    L7:
        return -1;
    L9:
        if (a(r5, r6) == false) goto L13;
        return a(new b(r5, r6));
    L13:
        if (Log.isLoggable("DfltImageHeaderParser", 3) == false) goto L15;
        Log.d("DfltImageHeaderParser", "Missing jpeg exif preamble");
    L15:
        return -1;
    }

    private static int a(b r12) {
        short r1 = r12.b(6);
        if (r1 != 18761) goto L5;
        ByteOrder r2 = ByteOrder.LITTLE_ENDIAN;
    L11:
        r12.a(r2);
        int r3 = r12.a(10) + 6;
        short r0 = r12.b(r3);
        int r4 = 0;
    L12:
        if (r4 >= r0) goto L59;
        int r5 = a(r3, r4);
        short r6 = r12.b(r5);
        if (r6 != 274) goto L58;
        short r7 = r12.b(r5 + 2);
        if (r7 < 1) goto L53;
        if (r7 > 12) goto L53;
        int r8 = r12.a(r5 + 4);
        if (r8 >= 0) goto L27;
        if (Log.isLoggable("DfltImageHeaderParser", 3) == false) goto L58;
        String r9 = "Negative tiff component count";
    L57:
        Log.d("DfltImageHeaderParser", r9);
        goto L58
    L27:
        if (Log.isLoggable("DfltImageHeaderParser", 3) == false) goto L29;
        Log.d("DfltImageHeaderParser", "Got tagIndex=" + r4 + " tagType=" + r6 + " formatCode=" + r7 + " componentCount=" + r8);
    L29:
        int r10 = r8 + f836b[r7];
        if (r10 > 4) goto L32;
        int r11 = r5 + 8;
        if (r11 < 0) goto L49;
        if (r11 > r12.a()) goto L49;
        if (r10 < 0) goto L46;
        if ((r10 + r11) > r12.a()) goto L46;
        return r12.b(r11);
    L46:
        if (Log.isLoggable("DfltImageHeaderParser", 3) == false) goto L58;
        StringBuilder r13 = new StringBuilder().append("Illegal number of bytes for TI tag data tagType=");
    L51:
        StringBuilder r14 = r13.append(r6);
    L56:
        r9 = r14.toString();
    L49:
        if (Log.isLoggable("DfltImageHeaderParser", 3) == false) goto L58;
        r13 = new StringBuilder().append("Illegal tagValueOffset=").append(r11).append(" tagType=");
        goto L51
    L32:
        if (Log.isLoggable("DfltImageHeaderParser", 3) == false) goto L58;
        StringBuilder r15 = new StringBuilder();
        String r16 = "Got byte count > 4, not orientation, continuing, formatCode=";
    L55:
        r14 = r15.append(r16).append(r7);
    L53:
        if (Log.isLoggable("DfltImageHeaderParser", 3) == false) goto L58;
        r15 = new StringBuilder();
        r16 = "Got invalid format code = ";
    L58:
        r4 = r4 + 1;
        goto L12
    L59:
        return -1;
    L5:
        if (r1 != 19789) goto L7;
    L9:
        r2 = ByteOrder.BIG_ENDIAN;
        goto L11
    L7:
        if (Log.isLoggable("DfltImageHeaderParser", 3) == false) goto L9;
        Log.d("DfltImageHeaderParser", "Unknown endianness = " + r1);
        goto L9
    }

    private ImageHeaderParser.ImageType a(Reader r7, int r8) {
        Reader r6 = (Reader) ZeusTransformUtils.wrapperContextForParams(r7, Reader.class, "com.obric.memorydata.plugin");
        if (((r6.b() << 16) | r6.b()) != 1718909296) goto L5;
        int r9 = (r6.b() << 16) | r6.b();
        if (r9 == 1635150195) goto L9;
        int r1 = 0;
        if (r9 != 1635150182) goto L13;
        boolean r10 = true;
    L14:
        r6.a(4);
        int r11 = r8 - 16;
        if ((r11 % 4) == 0) goto L17;
    L26:
        if (r10 == false) goto L29;
        return ImageHeaderParser.ImageType.AVIF;
    L29:
        return ImageHeaderParser.ImageType.UNKNOWN;
    L17:
        if (r1 >= 5) goto L26;
        if (r11 <= 0) goto L26;
        int r4 = (r6.b() << 16) | r6.b();
        if (r4 == 1635150195) goto L22;
        if (r4 != 1635150182) goto L25;
        r10 = true;
    L25:
        r1 = r1 + 1;
        r11 = r11 - 4;
        goto L17
    L22:
        return ImageHeaderParser.ImageType.ANIMATED_AVIF;
    L13:
        r10 = false;
        goto L14
    L9:
        return ImageHeaderParser.ImageType.ANIMATED_AVIF;
    L5:
        return ImageHeaderParser.ImageType.UNKNOWN;
    }

    private static boolean a(int r2) {
        if ((r2 & 65496) != 65496) goto L5;
    L10:
        return true;
    L5:
        if (r2 == 19789) goto L10;
        if (r2 == 18761) goto L10;
        return false;
    }

    private boolean a(byte[] r4, int r5) {
        if (r4 != null) goto L5;
    L7:
        boolean r6 = false;
    L8:
        if (r6 == false) goto L17;
        int r0 = 0;
    L10:
        byte[] r1 = f835a;
        if (r0 >= r1.length) goto L17;
        if (r4[r0] != r1[r0]) goto L20;
        r0 = r0 + 1;
        goto L10
    L20:
        return false;
    L17:
        return r6;
    L5:
        if (r5 <= f835a.length) goto L7;
        r6 = true;
        goto L8
    }

    private ImageHeaderParser.ImageType getType(Reader r5) {
        Reader r6 = (Reader) ZeusTransformUtils.wrapperContextForParams(r5, Reader.class, "com.obric.memorydata.plugin");
        int r0 = r6.b();     // Catch: Reader.EndOfFileException -> L54
        if (r0 == 65496) goto L6;
        int r1 = (r0 << 8) | r6.a();     // Catch: Reader.EndOfFileException -> L54
        if (r1 == 4671814) goto L10;
        int r2 = (r1 << 8) | r6.a();     // Catch: Reader.EndOfFileException -> L54
        if (r2 != (-1991225785)) goto L22;
        r6.a(21);     // Catch: Reader.EndOfFileException -> L54
        if (r6.a() < 3) goto L18;
        return ImageHeaderParser.ImageType.PNG_A;
    L18:
        return ImageHeaderParser.ImageType.PNG;
    L20:
        return ImageHeaderParser.ImageType.PNG;
    L22:
        if (r2 != 1380533830) goto L24;
        r6.a(4);     // Catch: Reader.EndOfFileException -> L54
        if (((r6.b() << 16) | r6.b()) != 1464156752) goto L28;
        int r4 = (r6.b() << 16) | r6.b();     // Catch: Reader.EndOfFileException -> L54
        if ((r4 & InputDeviceCompat.SOURCE_ANY) != 1448097792) goto L32;
        int r7 = r4 & 255;     // Catch: Reader.EndOfFileException -> L54
        if (r7 != 88) goto L46;
        r6.a(4);     // Catch: Reader.EndOfFileException -> L54
        short r8 = r6.a();     // Catch: Reader.EndOfFileException -> L54
        if ((r8 & 2) == 0) goto L40;
        return ImageHeaderParser.ImageType.ANIMATED_WEBP;
    L40:
        if ((r8 & 16) == 0) goto L44;
        return ImageHeaderParser.ImageType.WEBP_A;
    L44:
        return ImageHeaderParser.ImageType.WEBP;
    L46:
        if (r7 != 76) goto L53;
        r6.a(4);     // Catch: Reader.EndOfFileException -> L54
        if ((r6.a() & 8) == 0) goto L51;
        return ImageHeaderParser.ImageType.WEBP_A;
    L51:
        return ImageHeaderParser.ImageType.WEBP;
    L53:
        return ImageHeaderParser.ImageType.WEBP;
    L32:
        return ImageHeaderParser.ImageType.UNKNOWN;
    L28:
        return ImageHeaderParser.ImageType.UNKNOWN;
    L24:
        return a(r6, r2);
    L10:
        return ImageHeaderParser.ImageType.GIF;
    L6:
        return ImageHeaderParser.ImageType.JPEG;
    L55:
        return ImageHeaderParser.ImageType.UNKNOWN;
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public int a(InputStream r4, com.bumptech.glide.load.engine.bitmap_recycle.b r5) {
        com.bumptech.glide.load.engine.bitmap_recycle.b r6 = (com.bumptech.glide.load.engine.bitmap_recycle.b) ZeusTransformUtils.wrapperContextForParams(r5, com.bumptech.glide.load.engine.bitmap_recycle.b.class, "com.obric.memorydata.plugin");
        return a(new c((InputStream) ZeusTransformUtils.preCheckCast(com.bumptech.glide.util.j.a(r4), InputStream.class, "com.obric.memorydata.plugin")), (com.bumptech.glide.load.engine.bitmap_recycle.b) ZeusTransformUtils.preCheckCast(com.bumptech.glide.util.j.a(r6), com.bumptech.glide.load.engine.bitmap_recycle.b.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public int a(ByteBuffer r4, com.bumptech.glide.load.engine.bitmap_recycle.b r5) {
        com.bumptech.glide.load.engine.bitmap_recycle.b r6 = (com.bumptech.glide.load.engine.bitmap_recycle.b) ZeusTransformUtils.wrapperContextForParams(r5, com.bumptech.glide.load.engine.bitmap_recycle.b.class, "com.obric.memorydata.plugin");
        return a(new a((ByteBuffer) ZeusTransformUtils.preCheckCast(com.bumptech.glide.util.j.a(r4), ByteBuffer.class, "com.obric.memorydata.plugin")), (com.bumptech.glide.load.engine.bitmap_recycle.b) ZeusTransformUtils.preCheckCast(com.bumptech.glide.util.j.a(r6), com.bumptech.glide.load.engine.bitmap_recycle.b.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public ImageHeaderParser.ImageType getType(InputStream r4) {
        return getType(new c((InputStream) ZeusTransformUtils.preCheckCast(com.bumptech.glide.util.j.a(r4), InputStream.class, "com.obric.memorydata.plugin")));
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public ImageHeaderParser.ImageType getType(ByteBuffer r4) {
        return getType(new a((ByteBuffer) ZeusTransformUtils.preCheckCast(com.bumptech.glide.util.j.a(r4), ByteBuffer.class, "com.obric.memorydata.plugin")));
    }
}
