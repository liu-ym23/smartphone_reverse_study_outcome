package com.larus.bmhome.metadata;

import android.content.res.AssetManager;
import android.media.MediaDataSource;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.system.Os;
import android.system.OsConstants;
import android.util.Pair;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.services.apm.api.EnsureManager;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.CRC32;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class ExifInterface2 {
    public static final byte[] A = null;
    public static final byte[] B = null;
    public static final byte[] C = null;
    public static final byte[] D = null;
    public static final byte[] E = null;
    public static final byte[] F = null;
    public static final byte[] G = null;
    public static final byte[] H = null;
    public static final byte[] I = null;
    public static final byte[] J = null;
    public static final byte[] K = null;
    public static final byte[] L = null;
    public static final byte[] M = null;
    public static final byte[] N = null;
    public static final byte[] O = null;
    public static final String[] P = null;
    public static final int[] Q = null;
    public static final byte[] R = null;
    public static final e S = null;
    public static final e[][] T = null;
    public static final e[] U = null;
    public static final e V = null;
    public static final e W = null;
    public static final HashMap<Integer, e>[] X = null;
    public static final HashMap<String, e>[] Y = null;
    public static final HashSet<String> Z = null;
    public static final HashMap<Integer, Integer> a0 = null;
    public static final Charset b0 = null;
    public static final byte[] c0 = null;
    public static final Pattern d0 = null;
    public static final Pattern e0 = null;
    public static final Pattern f0 = null;
    public static final boolean r = false;
    public static final List<Integer> s = null;
    public static final List<Integer> t = null;
    public static final int[] u = null;
    public static final int[] v = null;
    public static final byte[] w = null;
    public static final byte[] x = null;
    public static final byte[] y = null;
    public static final byte[] z = null;
    public String a;
    public FileDescriptor b;
    public AssetManager.AssetInputStream c;
    public int d;
    public final HashMap<String, d>[] e;
    public final Set<Integer> f;
    public ByteOrder g;
    public boolean h;
    public boolean i;
    public int j;
    public int k;
    public byte[] l;
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ExifStreamType {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface IfdType {
    }

    public class a extends MediaDataSource {
        public long a;
        public final /* synthetic */ b b;

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() throws IOException {
        }

        @Override // android.media.MediaDataSource
        public final long getSize() throws IOException {
            return -1;
        }

        public a(b r1) {
            this.b = r1;
        }

        @Override // android.media.MediaDataSource
        public final int readAt(long r7, byte[] r9, int r10, int r11) throws IOException {
            if (r11 != 0) goto L6;
            return 0;
        L6:
            if (r7 >= 0) goto L26;
            return -1;
        L26:
            long r3 = this.a;     // Catch: IOException -> L25
            if (r3 == r7) goto L17;
            if (r3 >= 0) goto L13;
        L15:
            this.b.a(r7);     // Catch: IOException -> L25
            this.a = r7;     // Catch: IOException -> L25
            goto L17
        L13:
            if (r7 < (r3 + ((long) this.b.available()))) goto L15;
            return -1;
        L17:
            if (r11 <= this.b.available()) goto L19;
            r11 = this.b.available();     // Catch: IOException -> L25
        L19:
            int r8 = this.b.read(r9, r10, r11);     // Catch: IOException -> L25
            if (r8 < 0) goto L23;
            this.a += (long) r8;     // Catch: IOException -> L25
            return r8;
        L23:
            this.a = -1;
            return -1;
        }
    }

    public static class b extends InputStream implements DataInput {
        public static final ByteOrder e = null;
        public static final ByteOrder f = null;
        public final DataInputStream a;
        public ByteOrder b;
        public final int c;
        public int d;

        static {
            e = ByteOrder.LITTLE_ENDIAN;
            f = ByteOrder.BIG_ENDIAN;
        }

        @Override // java.io.InputStream
        public final int available() throws IOException {
            return this.a.available();
        }

        @Override // java.io.InputStream
        public final int read() throws IOException {
            this.d++;
            return this.a.read();
        }

        @Override // java.io.DataInput
        public final boolean readBoolean() throws IOException {
            this.d++;
            return this.a.readBoolean();
        }

        @Override // java.io.DataInput
        public final byte readByte() throws IOException {
            int r0 = this.d + 1;
            this.d = r0;
            if (r0 > this.c) goto L11;
            int r1 = this.a.read();
            if (r1 < 0) goto L9;
            return (byte) r1;
        L9:
            throw new EOFException();
        L11:
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public final char readChar() throws IOException {
            this.d += 2;
            return this.a.readChar();
        }

        @Override // java.io.DataInput
        public final int readInt() throws IOException {
            int r0 = this.d + 4;
            this.d = r0;
            if (r0 > this.c) goto L19;
            int r1 = this.a.read();
            int r2 = this.a.read();
            int r3 = this.a.read();
            int r4 = this.a.read();
            if ((((r1 | r2) | r3) | r4) < 0) goto L17;
            ByteOrder r5 = this.b;
            if (r5 != e) goto L11;
            return (((r4 << 24) + (r3 << 16)) + (r2 << 8)) + r1;
        L11:
            if (r5 != f) goto L15;
            return (((r1 << 24) + (r2 << 16)) + (r3 << 8)) + r4;
        L15:
            throw new IOException("Invalid byte order: " + this.b);
        L17:
            throw new EOFException();
        L19:
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public final String readLine() throws IOException {
            FLogger.a.d("ExifInterface", "Currently unsupported");
            return null;
        }

        @Override // java.io.DataInput
        public final long readLong() throws IOException {
            int r1 = this.d + 8;
            this.d = r1;
            if (r1 > this.c) goto L19;
            int r2 = this.a.read();
            int r3 = this.a.read();
            int r4 = this.a.read();
            int r5 = this.a.read();
            int r6 = this.a.read();
            int r7 = this.a.read();
            int r8 = this.a.read();
            int r9 = this.a.read();
            if ((((((((r2 | r3) | r4) | r5) | r6) | r7) | r8) | r9) < 0) goto L17;
            ByteOrder r10 = this.b;
            if (r10 != e) goto L11;
            return (((((((((long) r9) << 56) + (((long) r8) << 48)) + (((long) r7) << 40)) + (((long) r6) << 32)) + (((long) r5) << 24)) + (((long) r4) << 16)) + (((long) r3) << 8)) + ((long) r2);
        L11:
            if (r10 != f) goto L15;
            return (((((((((long) r2) << 56) + (((long) r3) << 48)) + (((long) r4) << 40)) + (((long) r5) << 32)) + (((long) r6) << 24)) + (((long) r7) << 16)) + (((long) r8) << 8)) + ((long) r9);
        L15:
            throw new IOException("Invalid byte order: " + this.b);
        L17:
            throw new EOFException();
        L19:
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public final short readShort() throws IOException {
            int r0 = this.d + 2;
            this.d = r0;
            if (r0 > this.c) goto L19;
            int r1 = this.a.read();
            int r2 = this.a.read();
            if ((r1 | r2) < 0) goto L17;
            ByteOrder r3 = this.b;
            if (r3 != e) goto L11;
            return (short) ((r2 << 8) + r1);
        L11:
            if (r3 != f) goto L15;
            return (short) ((r1 << 8) + r2);
        L15:
            throw new IOException("Invalid byte order: " + this.b);
        L17:
            throw new EOFException();
        L19:
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public final String readUTF() throws IOException {
            this.d += 2;
            return this.a.readUTF();
        }

        @Override // java.io.DataInput
        public final int readUnsignedByte() throws IOException {
            this.d++;
            return this.a.readUnsignedByte();
        }

        @Override // java.io.DataInput
        public final int readUnsignedShort() throws IOException {
            int r0 = this.d + 2;
            this.d = r0;
            if (r0 > this.c) goto L19;
            int r1 = this.a.read();
            int r2 = this.a.read();
            if ((r1 | r2) < 0) goto L17;
            ByteOrder r3 = this.b;
            if (r3 != e) goto L11;
            return (r2 << 8) + r1;
        L11:
            if (r3 != f) goto L15;
            return (r1 << 8) + r2;
        L15:
            throw new IOException("Invalid byte order: " + this.b);
        L17:
            throw new EOFException();
        L19:
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public final double readDouble() throws IOException {
            return Double.longBitsToDouble(readLong());
        }

        @Override // java.io.DataInput
        public final float readFloat() throws IOException {
            return Float.intBitsToFloat(readInt());
        }

        public b(byte[] r2) throws IOException {
            this(new ByteArrayInputStream(r2));
        }

        public final void a(long r5) throws IOException {
            int r0 = this.d;
            if (r0 <= r5) goto L5;
            this.d = 0;
            this.a.reset();
            this.a.mark(this.c);
        L6:
            int r6 = (int) r5;
            if (skipBytes(r6) != r6) goto L10;
            return;
        L10:
            throw new IOException("Couldn't seek up to the byteCount");
        L5:
            r5 = r5 - ((long) r0);
            goto L6
        }

        @Override // java.io.InputStream
        public final synchronized void mark(int r2) {
            monitor-enter(this);
            this.a.mark(r2);     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        @Override // java.io.DataInput
        public final void readFully(byte[] r4) throws IOException {
            int r0 = this.d + r4.length;
            this.d = r0;
            if (r0 > this.c) goto L10;
            if (this.a.read(r4, 0, r4.length) != r4.length) goto L8;
            return;
        L8:
            throw new IOException("Couldn't read up to the length of buffer");
        L10:
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public final int skipBytes(int r4) throws IOException {
            int r5 = Math.min(r4, this.c - this.d);
            int r0 = 0;
        L3:
            if (r0 >= r5) goto L5;
            r0 = r0 + this.a.skipBytes(r5 - r0);
            goto L3
        L5:
            this.d += r0;
            return r0;
        }

        public b(InputStream r2) throws IOException {
            this(r2, ByteOrder.BIG_ENDIAN);
        }

        public b(InputStream r3, ByteOrder r4) throws IOException {
            this.b = ByteOrder.BIG_ENDIAN;
            DataInputStream r0 = new DataInputStream(r3);
            this.a = r0;
            int r5 = r0.available();
            this.c = r5;
            this.d = 0;
            r0.mark(r5);
            this.b = r4;
        }

        @Override // java.io.InputStream
        public final int read(byte[] r2, int r3, int r4) throws IOException {
            int r5 = this.a.read(r2, r3, r4);
            this.d += r5;
            return r5;
        }

        @Override // java.io.DataInput
        public final void readFully(byte[] r3, int r4, int r5) throws IOException {
            int r0 = this.d + r5;
            this.d = r0;
            if (r0 > this.c) goto L10;
            if (this.a.read(r3, r4, r5) != r5) goto L8;
            return;
        L8:
            throw new IOException("Couldn't read up to the length of buffer");
        L10:
            throw new EOFException();
        }
    }

    public static class c extends FilterOutputStream {
        public final OutputStream a;
        public ByteOrder b;

        public final void a(int r2) throws IOException {
            this.a.write(r2);
        }

        public final void b(int r3) throws IOException {
            ByteOrder r0 = this.b;
            if (r0 != ByteOrder.LITTLE_ENDIAN) goto L6;
            this.a.write((r3 >>> 0) & 255);
            this.a.write((r3 >>> 8) & 255);
            this.a.write((r3 >>> 16) & 255);
            this.a.write((r3 >>> 24) & 255);
            return;
        L6:
            if (r0 != ByteOrder.BIG_ENDIAN) goto L10;
            this.a.write((r3 >>> 24) & 255);
            this.a.write((r3 >>> 16) & 255);
            this.a.write((r3 >>> 8) & 255);
            this.a.write((r3 >>> 0) & 255);
            return;
        }

        public final void c(short r3) throws IOException {
            ByteOrder r0 = this.b;
            if (r0 != ByteOrder.LITTLE_ENDIAN) goto L6;
            this.a.write((r3 >>> 0) & 255);
            this.a.write((r3 >>> 8) & 255);
            return;
        L6:
            if (r0 != ByteOrder.BIG_ENDIAN) goto L10;
            this.a.write((r3 >>> 8) & 255);
            this.a.write((r3 >>> 0) & 255);
            return;
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public final void write(byte[] r2) throws IOException {
            this.a.write(r2);
        }

        public c(OutputStream r1, ByteOrder r2) {
            super(r1);
            this.a = r1;
            this.b = r2;
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public final void write(byte[] r2, int r3, int r4) throws IOException {
            this.a.write(r2, r3, r4);
        }
    }

    public static class d {
        public final int a;
        public final int b;
        public final long c;
        public final byte[] d;

        public final String toString() {
            return "(" + ExifInterface2.P[this.a] + ", data length:" + this.d.length + ")";
        }

        public static d a(String r3) {
            byte[] r4 = r3.concat("\u0000").getBytes(ExifInterface2.b0);
            return new d(2, r4.length, r4);
        }

        public final double g(ByteOrder r5) {
            Object r6 = j(r5);
            if (r6 == null) goto L43;
            if ((r6 instanceof String) == false) goto L9;
            return CastDoubleProtector.parseDouble((String) r6);
        L9:
            if ((r6 instanceof long[]) == false) goto L17;
            long[] r7 = (long[]) r6;
            if (r7.length != 1) goto L15;
            return r7[0];
        L15:
            throw new NumberFormatException("There are more than one component");
        L17:
            if ((r6 instanceof int[]) == false) goto L25;
            int[] r8 = (int[]) r6;
            if (r8.length != 1) goto L23;
            return r8[0];
        L23:
            throw new NumberFormatException("There are more than one component");
        L25:
            if ((r6 instanceof double[]) == false) goto L33;
            double[] r9 = (double[]) r6;
            if (r9.length != 1) goto L31;
            return r9[0];
        L31:
            throw new NumberFormatException("There are more than one component");
        L33:
            if ((r6 instanceof f[]) == false) goto L41;
            f[] r10 = (f[]) r6;
            if (r10.length != 1) goto L39;
            f r11 = r10[0];
            return r11.a / r11.b;
        L39:
            throw new NumberFormatException("There are more than one component");
        L41:
            throw new NumberFormatException("Couldn't find a double value");
        L43:
            throw new NumberFormatException("NULL can't be converted to a double value");
        }

        public final int h(ByteOrder r5) {
            Object r6 = j(r5);
            if (r6 == null) goto L27;
            if ((r6 instanceof String) == false) goto L9;
            return CastIntegerProtector.parseInt((String) r6);
        L9:
            if ((r6 instanceof long[]) == false) goto L17;
            long[] r7 = (long[]) r6;
            if (r7.length != 1) goto L15;
            return (int) r7[0];
        L15:
            throw new NumberFormatException("There are more than one component");
        L17:
            if ((r6 instanceof int[]) == false) goto L25;
            int[] r8 = (int[]) r6;
            if (r8.length != 1) goto L23;
            return r8[0];
        L23:
            throw new NumberFormatException("There are more than one component");
        L25:
            throw new NumberFormatException("Couldn't find a integer value");
        L27:
            throw new NumberFormatException("NULL can't be converted to a integer value");
        }

        public final String i(ByteOrder r8) {
            Object r9 = j(r8);
            if (r9 != null) goto L6;
            return null;
        L6:
            if ((r9 instanceof String) == true) goto L8;
            StringBuilder r1 = new StringBuilder();
            int r4 = 0;
            if ((r9 instanceof long[]) == false) goto L20;
            long[] r10 = (long[]) r9;
        L13:
            if (r4 >= r10.length) goto L18;
            r1.append(r10[r4]);
            r4 = r4 + 1;
            if (r4 == r10.length) goto L13;
            r1.append(",");
            goto L13
        L18:
            return r1.toString();
        L20:
            if ((r9 instanceof int[]) == false) goto L30;
            int[] r11 = (int[]) r9;
        L23:
            if (r4 >= r11.length) goto L28;
            r1.append(r11[r4]);
            r4 = r4 + 1;
            if (r4 == r11.length) goto L23;
            r1.append(",");
            goto L23
        L28:
            return r1.toString();
        L30:
            if ((r9 instanceof double[]) == false) goto L40;
            double[] r12 = (double[]) r9;
        L33:
            if (r4 >= r12.length) goto L38;
            r1.append(r12[r4]);
            r4 = r4 + 1;
            if (r4 == r12.length) goto L33;
            r1.append(",");
            goto L33
        L38:
            return r1.toString();
        L40:
            if ((r9 instanceof f[]) == false) goto L49;
            f[] r13 = (f[]) r9;
        L43:
            if (r4 >= r13.length) goto L48;
            r1.append(r13[r4].a);
            r1.append('/');
            r1.append(r13[r4].b);
            r4 = r4 + 1;
            if (r4 == r13.length) goto L43;
            r1.append(",");
            goto L43
        L48:
            return r1.toString();
        L49:
            return null;
        L8:
            return (String) r9;
        }

        /* JADX WARN: Not initialized variable reg: 3, insn: 0x01bf: MOVE (r2 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]) (LINE:16777663), block:B:151:0x01bf */
        public final Object j(ByteOrder r13) {
            InputStream r2 = null;
            b r3 = new b(this.d);     // Catch: Throwable -> L139 IOException -> L141
            r3.b = r13;     // Catch: IOException -> L62 Throwable -> L150
            int r6 = 0;
            boolean r7 = true;
            switch(this.a) {
                case 1: goto L117;
                case 2: goto L90;
                case 3: goto L79;
                case 4: goto L69;
                case 5: goto L57;
                case 6: goto L117;
                case 7: goto L90;
                case 8: goto L47;
                case 9: goto L37;
                case 10: goto L27;
                case 11: goto L17;
                case 12: goto L7;
                default: goto L183;
            };     // Catch: IOException -> L62 Throwable -> L150
        L7:
            double[] r14 = new double[this.b];     // Catch: IOException -> L62 Throwable -> L150
        L9:
            if (r6 >= this.b) goto L172;
            r14[r6] = r3.readDouble();     // Catch: IOException -> L62 Throwable -> L150
            r6 = r6 + 1;
            goto L9
        L172:
            r3.close();     // Catch: IOException -> L14
        L16:
            return r14;
        L14:
            e = move-exception;
            FLogger.a.e("ExifInterface", "IOException occurred while closing InputStream", e);
            goto L16
        L17:
            double[] r15 = new double[this.b];     // Catch: IOException -> L62 Throwable -> L150
        L19:
            if (r6 >= this.b) goto L177;
            r15[r6] = r3.readFloat();     // Catch: IOException -> L62 Throwable -> L150
            r6 = r6 + 1;
            goto L19
        L177:
            r3.close();     // Catch: IOException -> L24
        L26:
            return r15;
        L24:
            e = move-exception;
            FLogger.a.e("ExifInterface", "IOException occurred while closing InputStream", e);
            goto L26
        L27:
            f[] r16 = new f[this.b];     // Catch: IOException -> L62 Throwable -> L150
        L29:
            if (r6 >= this.b) goto L164;
            r16[r6] = new f(r3.readInt(), r3.readInt());     // Catch: IOException -> L62 Throwable -> L150
            r6 = r6 + 1;
            goto L29
        L164:
            r3.close();     // Catch: IOException -> L34
        L36:
            return r16;
        L34:
            e = move-exception;
            FLogger.a.e("ExifInterface", "IOException occurred while closing InputStream", e);
            goto L36
        L37:
            int[] r17 = new int[this.b];     // Catch: IOException -> L62 Throwable -> L150
        L39:
            if (r6 >= this.b) goto L170;
            r17[r6] = r3.readInt();     // Catch: IOException -> L62 Throwable -> L150
            r6 = r6 + 1;
            goto L39
        L170:
            r3.close();     // Catch: IOException -> L44
        L46:
            return r17;
        L44:
            e = move-exception;
            FLogger.a.e("ExifInterface", "IOException occurred while closing InputStream", e);
            goto L46
        L47:
            int[] r18 = new int[this.b];     // Catch: IOException -> L62 Throwable -> L150
        L49:
            if (r6 >= this.b) goto L175;
            r18[r6] = r3.readShort();     // Catch: IOException -> L62 Throwable -> L150
            r6 = r6 + 1;
            goto L49
        L175:
            r3.close();     // Catch: IOException -> L54
        L56:
            return r18;
        L54:
            e = move-exception;
            FLogger.a.e("ExifInterface", "IOException occurred while closing InputStream", e);
            goto L56
        L57:
            f[] r19 = new f[this.b];     // Catch: IOException -> L62 Throwable -> L150
        L59:
            if (r6 >= this.b) goto L158;
            r19[r6] = new f(((long) r3.readInt()) & 4294967295L, ((long) r3.readInt()) & 4294967295L);     // Catch: IOException -> L62 Throwable -> L150
            r6 = r6 + 1;
            goto L59
        L158:
            r3.close();     // Catch: IOException -> L66
        L68:
            return r19;
        L66:
            e = move-exception;
            FLogger.a.e("ExifInterface", "IOException occurred while closing InputStream", e);
            goto L68
        L69:
            long[] r110 = new long[this.b];     // Catch: IOException -> L62 Throwable -> L150
        L71:
            if (r6 >= this.b) goto L162;
            r110[r6] = ((long) r3.readInt()) & 4294967295L;     // Catch: IOException -> L62 Throwable -> L150
            r6 = r6 + 1;
            goto L71
        L162:
            r3.close();     // Catch: IOException -> L76
        L78:
            return r110;
        L76:
            e = move-exception;
            FLogger.a.e("ExifInterface", "IOException occurred while closing InputStream", e);
            goto L78
        L79:
            int[] r111 = new int[this.b];     // Catch: IOException -> L62 Throwable -> L150
        L81:
            if (r6 >= this.b) goto L166;
            r111[r6] = r3.readUnsignedShort();     // Catch: IOException -> L62 Throwable -> L150
            r6 = r6 + 1;
            goto L81
        L166:
            r3.close();     // Catch: IOException -> L86
        L88:
            return r111;
        L86:
            e = move-exception;
            FLogger.a.e("ExifInterface", "IOException occurred while closing InputStream", e);
            goto L88
        L117:
            byte[] r112 = this.d;     // Catch: IOException -> L62 Throwable -> L150
            if (r112.length != 1) goto L128;
            byte r4 = r112[0];     // Catch: IOException -> L62 Throwable -> L150
            if (r4 < 0) goto L128;
            if (r4 > 1) goto L128;
            String r113 = new String(new char[]{(char) (r4 + 48)});     // Catch: IOException -> L62 Throwable -> L150
            r3.close();     // Catch: IOException -> L125
        L127:
            return r113;
        L125:
            e = move-exception;
            FLogger.a.e("ExifInterface", "IOException occurred while closing InputStream", e);
        L128:
            String r5 = new String(r112, ExifInterface2.b0);     // Catch: IOException -> L62 Throwable -> L150
            r3.close();     // Catch: IOException -> L131
        L133:
            return r5;
        L131:
            e = move-exception;
            FLogger.a.e("ExifInterface", "IOException occurred while closing InputStream", e);
            goto L133
        L183:
            r3.close();     // Catch: IOException -> L136
        L138:
            return null;
        L136:
            e = move-exception;
            FLogger.a.e("ExifInterface", "IOException occurred while closing InputStream", e);
            goto L138
        L90:
            if (this.b < ExifInterface2.R.length) goto L100;
            int r114 = 0;
        L92:
            byte[] r8 = ExifInterface2.R;     // Catch: IOException -> L62 Throwable -> L150
            if (r114 >= r8.length) goto L98;
            if (this.d[r114] != r8[r114]) goto L96;
            r114 = r114 + 1;     // Catch: IOException -> L62 Throwable -> L150
            goto L92
        L96:
            r7 = false;
        L98:
            if (r7 == false) goto L100;
            r6 = r8.length;     // Catch: IOException -> L62 Throwable -> L150
        L100:
            StringBuilder r115 = new StringBuilder();     // Catch: IOException -> L62 Throwable -> L150
        L102:
            if (r6 >= this.b) goto L111;
            byte r9 = this.d[r6];     // Catch: IOException -> L62 Throwable -> L150
            if (r9 == 0) goto L111;
            if (r9 < 32) goto L109;
            r115.append((char) r9);     // Catch: IOException -> L62 Throwable -> L150
        L110:
            r6 = r6 + 1;     // Catch: IOException -> L62 Throwable -> L150
            goto L102
        L109:
            r115.append('?');     // Catch: IOException -> L62 Throwable -> L150
        L111:
            String r116 = r115.toString();     // Catch: IOException -> L62 Throwable -> L150
            r3.close();     // Catch: IOException -> L114
        L116:
            return r116;
        L114:
            e = move-exception;
            FLogger.a.e("ExifInterface", "IOException occurred while closing InputStream", e);
        L62:
            e = e;
        L143:
            FLogger.a.w("ExifInterface", "IOException occurred during reading a value", e);     // Catch: Throwable -> L150
            if (r3 != null) goto L160;
        L149:
            return null;
        L160:
            r3.close();     // Catch: IOException -> L147
        L147:
            e = move-exception;
            FLogger.a.e("ExifInterface", "IOException occurred while closing InputStream", e);
            goto L149
        L150:
            th = th;
            r2 = r3;
        L152:
            if (r2 != null) goto L179;
        L157:
            throw th;
        L179:
            r2.close();     // Catch: IOException -> L155
        L155:
            e = move-exception;
            FLogger.a.e("ExifInterface", "IOException occurred while closing InputStream", e);
        L141:
            e = e;
            r3 = null;
        L139:
            th = th;
            goto L152
        }

        public static d b(long r2, ByteOrder r4) {
            return c(new long[]{r2}, r4);
        }

        public static d c(long[] r5, ByteOrder r6) {
            ByteBuffer r0 = ByteBuffer.wrap(new byte[ExifInterface2.Q[4] * r5.length]);
            r0.order(r6);
            int r7 = r5.length;
            int r2 = 0;
        L3:
            if (r2 >= r7) goto L6;
            r0.putInt((int) r5[r2]);
            r2 = r2 + 1;
            goto L3
        L6:
            return new d(4, r5.length, r0.array());
        }

        public static d d(f[] r6, ByteOrder r7) {
            ByteBuffer r0 = ByteBuffer.wrap(new byte[ExifInterface2.Q[5] * r6.length]);
            r0.order(r7);
            int r8 = r6.length;
            int r2 = 0;
        L3:
            if (r2 >= r8) goto L6;
            f r3 = r6[r2];
            r0.putInt((int) r3.a);
            r0.putInt((int) r3.b);
            r2 = r2 + 1;
            goto L3
        L6:
            return new d(5, r6.length, r0.array());
        }

        public static d e(int r2, ByteOrder r3) {
            return f(new int[]{r2}, r3);
        }

        public static d f(int[] r4, ByteOrder r5) {
            ByteBuffer r0 = ByteBuffer.wrap(new byte[ExifInterface2.Q[3] * r4.length]);
            r0.order(r5);
            int r6 = r4.length;
            int r2 = 0;
        L3:
            if (r2 >= r6) goto L6;
            r0.putShort((short) r4[r2]);
            r2 = r2 + 1;
            goto L3
        L6:
            return new d(3, r4.length, r0.array());
        }

        public d(int r7, int r8, byte[] r9) {
            this(r7, r8, -1, r9);
        }

        public d(int r1, int r2, long r3, byte[] r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r5;
        }
    }

    public static class e {
        public final int a;
        public final String b;
        public final int c;
        public final int d;

        public e(String r1, int r2, int r3) {
            this.b = r1;
            this.a = r2;
            this.c = r3;
            this.d = -1;
        }

        public e(String r1, int r2, int r3, int r4) {
            this.b = r1;
            this.a = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public static class f {
        public final long a;
        public final long b;

        public final String toString() {
            return this.a + "/" + this.b;
        }

        public f(long r4, long r6) {
            if (r6 != 0) goto L6;
            this.a = 0;
            this.b = 1;
            return;
        L6:
            this.a = r4;
            this.b = r6;
        }
    }

    public final void B() {
        int r0 = 0;
    L4:
        if (r0 >= this.e.length) goto L10;
        FLogger.a.d("ExifInterface", "The size of tag group[" + r0 + "]: " + this.e[r0].size());
        Iterator<Map.Entry<String, d>> r1 = this.e[r0].entrySet().iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        Map.Entry<String, d> r2 = r1.next();
        d r4 = r2.getValue();
        FLogger.a.d("ExifInterface", "tagName: " + r2.getKey() + ", tagType: " + r4.toString() + ", tagValue: '" + r4.i(this.g) + "'");
        goto L7
    L9:
        r0 = r0 + 1;
        goto L4
    }

    public final void O() throws IOException {
        M(0, 5);
        M(0, 4);
        M(5, 4);
        d r3 = this.e[1].get("PixelXDimension");
        d r4 = this.e[1].get("PixelYDimension");
        if (r3 == null) goto L7;
        if (r4 == null) goto L7;
        this.e[0].put("ImageWidth", r3);
        this.e[0].put("ImageLength", r4);
    L7:
        if (this.e[4].isEmpty() == false) goto L12;
        if (y(this.e[5]) == false) goto L12;
        HashMap<String, d>[] r0 = this.e;
        r0[4] = r0[5];
        r0[5] = new HashMap();
    L12:
        if (y(this.e[4]) == true) goto L15;
        FLogger.a.d("ExifInterface", "No image meets the size requirements of a thumbnail image.");
        return;
    }

    static {
        r = AppHost.a.isDebug();
        s = Arrays.asList(new Integer[]{1, 6, 3, 8});
        t = Arrays.asList(new Integer[]{2, 7, 4, 5});
        u = new int[]{8, 8, 8};
        v = new int[]{8};
        w = new byte[]{-1, -40, -1};
        x = new byte[]{102, 116, 121, 112};
        y = new byte[]{109, 105, 102, 49};
        z = new byte[]{104, 101, 105, 99};
        A = new byte[]{79, 76, 89, 77, 80, 0};
        B = new byte[]{79, 76, 89, 77, 80, 85, 83, 0, 73, 73};
        C = new byte[]{-119, 80, 78, 71, 13, 10, 26, 10};
        D = new byte[]{101, 88, 73, 102};
        E = new byte[]{73, 72, 68, 82};
        F = new byte[]{73, 69, 78, 68};
        G = new byte[]{82, 73, 70, 70};
        H = new byte[]{87, 69, 66, 80};
        I = new byte[]{69, 88, 73, 70};
        J = new byte[]{-99, 1, 42};
        K = "VP8X".getBytes(Charset.defaultCharset());
        L = "VP8L".getBytes(Charset.defaultCharset());
        M = "VP8 ".getBytes(Charset.defaultCharset());
        N = "ANIM".getBytes(Charset.defaultCharset());
        O = "ANMF".getBytes(Charset.defaultCharset());
        P = new String[]{"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE", "IFD"};
        Q = new int[]{0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};
        R = new byte[]{65, 83, 67, 73, 73, 0, 0, 0};
        e[] r12 = {new e("NewSubfileType", 254, 4), new e("SubfileType", 255, 4), new e("ImageWidth", 256, 3, 4), new e("ImageLength", 257, 3, 4), new e("BitsPerSample", 258, 3), new e("Compression", 259, 3), new e("PhotometricInterpretation", 262, 3), new e("ImageDescription", 270, 2), new e("Make", 271, 2), new e("Model", 272, 2), new e("StripOffsets", 273, 3, 4), new e("Orientation", 274, 3), new e("SamplesPerPixel", 277, 3), new e("RowsPerStrip", 278, 3, 4), new e("StripByteCounts", 279, 3, 4), new e("XResolution", 282, 5), new e("YResolution", 283, 5), new e("PlanarConfiguration", 284, 3), new e("ResolutionUnit", 296, 3), new e("TransferFunction", 301, 3), new e("Software", 305, 2), new e("DateTime", 306, 2), new e("Artist", 315, 2), new e("WhitePoint", 318, 5), new e("PrimaryChromaticities", 319, 5), new e("SubIFDPointer", 330, 4), new e("JPEGInterchangeFormat", 513, 4), new e("JPEGInterchangeFormatLength", 514, 4), new e("YCbCrCoefficients", 529, 5), new e("YCbCrSubSampling", 530, 3), new e("YCbCrPositioning", 531, 3), new e("ReferenceBlackWhite", 532, 5), new e("Copyright", 33432, 2), new e("ExifIFDPointer", 34665, 4), new e("GPSInfoIFDPointer", 34853, 4), new e("SensorTopBorder", 4, 4), new e("SensorLeftBorder", 5, 4), new e("SensorBottomBorder", 6, 4), new e("SensorRightBorder", 7, 4), new e("ISO", 23, 3), new e("JpgFromRaw", 46, 7), new e("Xmp", 700, 1)};
        e[] r1 = {new e("ExposureTime", 33434, 5), new e("FNumber", 33437, 5), new e("ExposureProgram", 34850, 3), new e("SpectralSensitivity", 34852, 2), new e("PhotographicSensitivity", 34855, 3), new e("OECF", 34856, 7), new e("SensitivityType", 34864, 3), new e("StandardOutputSensitivity", 34865, 4), new e("RecommendedExposureIndex", 34866, 4), new e("ISOSpeed", 34867, 4), new e("ISOSpeedLatitudeyyy", 34868, 4), new e("ISOSpeedLatitudezzz", 34869, 4), new e("ExifVersion", 36864, 2), new e("DateTimeOriginal", 36867, 2), new e("DateTimeDigitized", 36868, 2), new e("OffsetTime", 36880, 2), new e("OffsetTimeOriginal", 36881, 2), new e("OffsetTimeDigitized", 36882, 2), new e("ComponentsConfiguration", 37121, 7), new e("CompressedBitsPerPixel", 37122, 5), new e("ShutterSpeedValue", 37377, 10), new e("ApertureValue", 37378, 5), new e("BrightnessValue", 37379, 10), new e("ExposureBiasValue", 37380, 10), new e("MaxApertureValue", 37381, 5), new e("SubjectDistance", 37382, 5), new e("MeteringMode", 37383, 3), new e("LightSource", 37384, 3), new e("Flash", 37385, 3), new e("FocalLength", 37386, 5), new e("SubjectArea", 37396, 3), new e("MakerNote", 37500, 7), new e("UserComment", 37510, 7), new e("SubSecTime", 37520, 2), new e("SubSecTimeOriginal", 37521, 2), new e("SubSecTimeDigitized", 37522, 2), new e("FlashpixVersion", 40960, 7), new e("ColorSpace", 40961, 3), new e("PixelXDimension", 40962, 3, 4), new e("PixelYDimension", 40963, 3, 4), new e("RelatedSoundFile", 40964, 2), new e("InteroperabilityIFDPointer", 40965, 4), new e("FlashEnergy", 41483, 5), new e("SpatialFrequencyResponse", 41484, 7), new e("FocalPlaneXResolution", 41486, 5), new e("FocalPlaneYResolution", 41487, 5), new e("FocalPlaneResolutionUnit", 41488, 3), new e("SubjectLocation", 41492, 3), new e("ExposureIndex", 41493, 5), new e("SensingMethod", 41495, 3), new e("FileSource", 41728, 7), new e("SceneType", 41729, 7), new e("CFAPattern", 41730, 7), new e("CustomRendered", 41985, 3), new e("ExposureMode", 41986, 3), new e("WhiteBalance", 41987, 3), new e("DigitalZoomRatio", 41988, 5), new e("FocalLengthIn35mmFilm", 41989, 3), new e("SceneCaptureType", 41990, 3), new e("GainControl", 41991, 3), new e("Contrast", 41992, 3), new e("Saturation", 41993, 3), new e("Sharpness", 41994, 3), new e("DeviceSettingDescription", 41995, 7), new e("SubjectDistanceRange", 41996, 3), new e("ImageUniqueID", 42016, 2), new e("CameraOwnerName", 42032, 2), new e("BodySerialNumber", 42033, 2), new e("LensSpecification", 42034, 5), new e("LensMake", 42035, 2), new e("LensModel", 42036, 2), new e("Gamma", 42240, 5), new e("DNGVersion", 50706, 1), new e("DefaultCropSize", 50720, 3, 4)};
        e[] r2 = {new e("GPSVersionID", 0, 1), new e("GPSLatitudeRef", 1, 2), new e("GPSLatitude", 2, 5, 10), new e("GPSLongitudeRef", 3, 2), new e("GPSLongitude", 4, 5, 10), new e("GPSAltitudeRef", 5, 1), new e("GPSAltitude", 6, 5), new e("GPSTimeStamp", 7, 5), new e("GPSSatellites", 8, 2), new e("GPSStatus", 9, 2), new e("GPSMeasureMode", 10, 2), new e("GPSDOP", 11, 5), new e("GPSSpeedRef", 12, 2), new e("GPSSpeed", 13, 5), new e("GPSTrackRef", 14, 2), new e("GPSTrack", 15, 5), new e("GPSImgDirectionRef", 16, 2), new e("GPSImgDirection", 17, 5), new e("GPSMapDatum", 18, 2), new e("GPSDestLatitudeRef", 19, 2), new e("GPSDestLatitude", 20, 5), new e("GPSDestLongitudeRef", 21, 2), new e("GPSDestLongitude", 22, 5), new e("GPSDestBearingRef", 23, 2), new e("GPSDestBearing", 24, 5), new e("GPSDestDistanceRef", 25, 2), new e("GPSDestDistance", 26, 5), new e("GPSProcessingMethod", 27, 7), new e("GPSAreaInformation", 28, 7), new e("GPSDateStamp", 29, 2), new e("GPSDifferential", 30, 3), new e("GPSHPositioningError", 31, 5)};
        e[] r4 = {new e("InteroperabilityIndex", 1, 2)};
        e[] r5 = {new e("NewSubfileType", 254, 4), new e("SubfileType", 255, 4), new e("ThumbnailImageWidth", 256, 3, 4), new e("ThumbnailImageLength", 257, 3, 4), new e("BitsPerSample", 258, 3), new e("Compression", 259, 3), new e("PhotometricInterpretation", 262, 3), new e("ImageDescription", 270, 2), new e("Make", 271, 2), new e("Model", 272, 2), new e("StripOffsets", 273, 3, 4), new e("ThumbnailOrientation", 274, 3), new e("SamplesPerPixel", 277, 3), new e("RowsPerStrip", 278, 3, 4), new e("StripByteCounts", 279, 3, 4), new e("XResolution", 282, 5), new e("YResolution", 283, 5), new e("PlanarConfiguration", 284, 3), new e("ResolutionUnit", 296, 3), new e("TransferFunction", 301, 3), new e("Software", 305, 2), new e("DateTime", 306, 2), new e("Artist", 315, 2), new e("WhitePoint", 318, 5), new e("PrimaryChromaticities", 319, 5), new e("SubIFDPointer", 330, 4), new e("JPEGInterchangeFormat", 513, 4), new e("JPEGInterchangeFormatLength", 514, 4), new e("YCbCrCoefficients", 529, 5), new e("YCbCrSubSampling", 530, 3), new e("YCbCrPositioning", 531, 3), new e("ReferenceBlackWhite", 532, 5), new e("Copyright", 33432, 2), new e("ExifIFDPointer", 34665, 4), new e("GPSInfoIFDPointer", 34853, 4), new e("DNGVersion", 50706, 1), new e("DefaultCropSize", 50720, 3, 4)};
        S = new e("StripOffsets", 273, 3);
        T = new e[][]{r12, r1, r2, r4, r5, r12, new e[]{new e("ThumbnailImage", 256, 7), new e("CameraSettingsIFDPointer", 8224, 4), new e("ImageProcessingIFDPointer", 8256, 4)}, new e[]{new e("PreviewImageStart", 257, 4), new e("PreviewImageLength", 258, 4)}, new e[]{new e("AspectFrame", 4371, 3)}, new e[]{new e("ColorSpace", 55, 3)}};
        U = new e[]{new e("SubIFDPointer", 330, 4), new e("ExifIFDPointer", 34665, 4), new e("GPSInfoIFDPointer", 34853, 4), new e("InteroperabilityIFDPointer", 40965, 4), new e("CameraSettingsIFDPointer", 8224, 1), new e("ImageProcessingIFDPointer", 8256, 1)};
        V = new e("JPEGInterchangeFormat", 513, 4);
        W = new e("JPEGInterchangeFormatLength", 514, 4);
        X = new HashMap[10];
        Y = new HashMap[10];
        Z = new HashSet(Arrays.asList(new String[]{"FNumber", "DigitalZoomRatio", "ExposureTime", "SubjectDistance", "GPSTimeStamp"}));
        a0 = new HashMap();
        Charset r0 = Charset.forName("US-ASCII");
        b0 = r0;
        c0 = "Exif\u0000\u0000".getBytes(r0);
        Locale r3 = Locale.US;
        new SimpleDateFormat("yyyy:MM:dd HH:mm:ss", r3).setTimeZone(TimeZone.getTimeZone("UTC"));
        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", r3).setTimeZone(TimeZone.getTimeZone("UTC"));
        int r6 = 0;
    L3:
        e[][] r7 = T;
        if (r6 >= r7.length) goto L9;
        X[r6] = new HashMap();
        Y[r6] = new HashMap();
        e[] r8 = r7[r6];
        int r9 = r8.length;
        int r10 = 0;
    L6:
        if (r10 >= r9) goto L8;
        e r11 = r8[r10];
        X[r6].put(Integer.valueOf(r11.a), r11);
        Y[r6].put(r11.b, r11);
        r10 = r10 + 1;
        goto L6
    L8:
        r6 = r6 + 1;
        goto L3
    L9:
        HashMap<Integer, Integer> r13 = a0;
        e[] r14 = U;
        r13.put(Integer.valueOf(r14[0].a), 5);
        r13.put(Integer.valueOf(r14[1].a), 1);
        r13.put(Integer.valueOf(r14[2].a), 2);
        r13.put(Integer.valueOf(r14[3].a), 3);
        r13.put(Integer.valueOf(r14[4].a), 7);
        r13.put(Integer.valueOf(r14[5].a), 8);
        PatternProtector.compile(".*[1-9].*");
        d0 = PatternProtector.compile("^(\\d{2}):(\\d{2}):(\\d{2})$");
        e0 = PatternProtector.compile("^(\\d{4}):(\\d{2}):(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
        f0 = PatternProtector.compile("^(\\d{4})-(\\d{2})-(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
    }

    public final void G() throws IOException {
        int r1 = this.d;
        boolean r2 = true;
        boolean r3 = false;
        if (r1 == 4) goto L8;
        if (r1 == 13) goto L8;
        if (r1 == 14) goto L8;
        boolean r4 = false;
    L9:
        if (r4 == false) goto L111;
        if (this.b == null) goto L13;
    L17:
        int r5 = this.m;
        PolarisFileInputStreamWrapper r8 = null;
        if (r5 != 6) goto L20;
    L23:
        byte[] r6 = t();
    L24:
        this.l = r6;
        File r7 = File.createTempFile("temp", "tmp");     // Catch: Throwable -> L101 Exception -> L103
        if (this.a == null) goto L28;
        PolarisFileInputStreamWrapper r9 = new PolarisFileInputStreamWrapper(this.a);     // Catch: Throwable -> L101 Exception -> L103
    L124:
        PolarisFileInputStreamWrapper r11 = new PolarisFileOutputStreamWrapper(r7);     // Catch: Throwable -> L97 Exception -> L99
    L131:
        g(r9, r11);     // Catch: Throwable -> L93 Exception -> L95
        d(r9);
        d(r11);
        PolarisFileInputStreamWrapper r10 = new PolarisFileInputStreamWrapper(r7);     // Catch: Throwable -> L60 Exception -> L62
    L56:
        e = e;
        PolarisFileOutputStreamWrapper r12 = null;
    L58:
        PolarisFileInputStreamWrapper r13 = null;
        BufferedOutputStream r14 = null;
    L59:
        PolarisFileOutputStreamWrapper r15 = r12;
        r8 = r10;
    L126:
        PolarisFileInputStreamWrapper r16 = new PolarisFileInputStreamWrapper(r7);     // Catch: Throwable -> L78 Exception -> L80
    L128:
    L76:
        e = e;
        r8 = r16;
    L114:
    L83:
        th = th;
    L118:
        d(r8);     // Catch: Throwable -> L86
        d(r15);     // Catch: Throwable -> L86
        throw th;     // Catch: Throwable -> L86
    L86:
        th = th;
        r3 = r2;
    L88:
        r8 = r13;
    L89:
        d(r8);
        d(r14);
        if (r3 == true) goto L92;
        r7.delete();
    L92:
        throw th;
    L82:
        throw new IOException("Failed to save new file. Original file is stored in " + r7.getAbsolutePath(), e);     // Catch: Throwable -> L83
    L74:
        th = th;
        r8 = r16;
    L79:
        r2 = false;
        goto L118
    L66:
        if (this.a != null) goto L68;
        Os.lseek(this.b, 0, OsConstants.SEEK_SET);     // Catch: Throwable -> L74 Exception -> L76
        PolarisFileOutputStreamWrapper r17 = new PolarisFileOutputStreamWrapper(this.b);     // Catch: Throwable -> L74 Exception -> L76
    L69:
        r15 = r17;
        g(r16, r15);     // Catch: Throwable -> L74 Exception -> L76
        d(r16);     // Catch: Throwable -> L72
        d(r15);     // Catch: Throwable -> L72
        throw new IOException("Failed to save new file", e);     // Catch: Throwable -> L72
    L68:
        r17 = new PolarisFileOutputStreamWrapper(this.a);     // Catch: Throwable -> L74 Exception -> L76
    L80:
        e = e;
    L78:
        th = th;
        goto L79
    L34:
        if (this.a == null) goto L36;
        r12 = new PolarisFileOutputStreamWrapper(this.a);     // Catch: Exception -> L56 Throwable -> L60
    L120:
        r13 = new BufferedInputStream(r10);     // Catch: Exception -> L54 Throwable -> L60
    L133:
        r14 = new BufferedOutputStream(r12);     // Catch: Throwable -> L50 Exception -> L52
        int r18 = this.d;     // Catch: Exception -> L48 Throwable -> L72
        if (r18 != 4) goto L42;
        H(r13, r14);     // Catch: Exception -> L48 Throwable -> L72
    L46:
        d(r13);
        d(r14);
        r7.delete();
        this.l = null;
        return;
    L42:
        if (r18 != 13) goto L44;
        I(r13, r14);     // Catch: Exception -> L48 Throwable -> L72
        goto L46
    L44:
        if (r18 != 14) goto L46;
        J(r13, r14);     // Catch: Exception -> L48 Throwable -> L72
    L48:
        e = e;
        goto L59
    L52:
        e = e;
        r14 = null;
    L50:
        th = th;
        r14 = null;
    L54:
        e = e;
        goto L58
    L36:
        Os.lseek(this.b, 0, OsConstants.SEEK_SET);     // Catch: Exception -> L56 Throwable -> L60
        r12 = new PolarisFileOutputStreamWrapper(this.b);     // Catch: Exception -> L56 Throwable -> L60
    L72:
        th = th;
    L62:
        e = e;
        r15 = null;
        r13 = null;
        r14 = null;
    L60:
        th = th;
        r14 = null;
        goto L89
    L95:
        e = e;
        r8 = r11;
    L100:
        PolarisFileInputStreamWrapper r19 = r8;
        r8 = r9;
    L121:
    L107:
        th = th;
    L108:
        d(r8);
        d(r19);
        throw th;
    L106:
        throw new IOException("Failed to copy original file to temp file", e);     // Catch: Throwable -> L107
    L93:
        th = th;
        r8 = r11;
    L98:
        r19 = r8;
        r8 = r9;
    L99:
        e = e;
    L97:
        th = th;
        goto L98
    L28:
        Os.lseek(this.b, 0, OsConstants.SEEK_SET);     // Catch: Throwable -> L101 Exception -> L103
        r9 = new PolarisFileInputStreamWrapper(this.b);     // Catch: Throwable -> L101 Exception -> L103
    L103:
        e = e;
        r19 = null;
    L101:
        th = th;
        r19 = null;
        goto L108
    L20:
        if (r5 == 7) goto L23;
        r6 = null;
        goto L24
    L13:
        if (this.a != null) goto L17;
        throw new IOException("ExifInterface does not support saving attributes for the current input.");
    L111:
        throw new IOException("ExifInterface only supports saving attributes on JPEG, PNG, or WebP formats.");
    L8:
        r4 = true;
        goto L9
    }

    public final void a() {
        String r0 = j("DateTimeOriginal");
        if (r0 == null) goto L8;
        if (j("DateTime") != null) goto L8;
        this.e[0].put("DateTime", d.a(r0));
    L8:
        if (j("ImageWidth") != null) goto L11;
        this.e[0].put("ImageWidth", d.b(0, this.g));
    L11:
        if (j("ImageLength") != null) goto L14;
        this.e[0].put("ImageLength", d.b(0, this.g));
    L14:
        if (j("Orientation") != null) goto L17;
        this.e[0].put("Orientation", d.b(0, this.g));
    L17:
        if (j("LightSource") != null) goto L20;
        this.e[1].put("LightSource", d.b(0, this.g));
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v5, types: [android.content.res.AssetManager$AssetInputStream, java.io.Closeable, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.io.Closeable, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r3v3 */
    public final byte[] t() {
        ?? r3 = 0;
        r3 = 0;
        if (this.h == true) goto L5;
        return null;
    L5:
        ?? r2 = this.l;
        if (r2 == 0) goto L65;
        return r2;
    L65:
        r2 = this.c;     // Catch: Throwable -> L47 Exception -> L49
        if (r2 == 0) goto L22;
    L19:
        e = move-exception;
        Exception e2 = e;
        FileDescriptor r4 = null;
    L51:
        FLogger.a.d("ExifInterface", "Encountered exception while getting thumbnail. Exception message: " + e2.getMessage());     // Catch: Throwable -> L56
        d(r2);
        if (r4 == null) goto L55;
        c(r4);
    L55:
        return null;
    L17:
        th = th;
        FileDescriptor r5 = null;
    L57:
        r3 = r2;
    L58:
        d(r3);
        if (r5 == null) goto L61;
        c(r5);
    L61:
        throw th;
    L11:
        if (r2.markSupported() == false) goto L14;
        r2.reset();     // Catch: Throwable -> L17 Exception -> L19
        ?? r6 = r2;
    L13:
        r4 = null;
        r2 = r6;
    L62:
    L41:
        e2 = e;
        goto L51
    L29:
        if (r2.skip(this.j + this.n) != (this.j + this.n)) goto L40;
        byte[] r7 = new byte[this.k];     // Catch: Exception -> L41 Throwable -> L56
        if (r2.read(r7) != this.k) goto L38;
        this.l = r7;     // Catch: Exception -> L41 Throwable -> L56
        d(r2);
        if (r4 == null) goto L36;
        c(r4);
    L36:
        return r7;
    L38:
        throw new IOException("Corrupted image");     // Catch: Exception -> L41 Throwable -> L56
    L40:
        throw new IOException("Corrupted image");     // Catch: Exception -> L41 Throwable -> L56
    L14:
        FLogger.a.d("ExifInterface", "Cannot read thumbnail from inputstream without mark/reset support");     // Catch: Throwable -> L17 Exception -> L19
        d(r2);
        return null;
    L22:
        if (this.a == null) goto L24;
        r6 = new PolarisFileInputStreamWrapper(this.a);     // Catch: Throwable -> L47 Exception -> L49
        goto L13
    L24:
        FileDescriptor r8 = Os.dup(this.b);     // Catch: Throwable -> L47 Exception -> L49
        Os.lseek(r8, 0, OsConstants.SEEK_SET);     // Catch: Throwable -> L43 Exception -> L45
        r4 = r8;
        r2 = new PolarisFileInputStreamWrapper(r8);     // Catch: Throwable -> L43 Exception -> L45
        goto L62
    L45:
        e = move-exception;
        e2 = e;
        r4 = r8;
        r2 = 0;
    L43:
        th = th;
        r5 = r8;
    L49:
        e = move-exception;
        r2 = 0;
        e2 = e;
        r4 = null;
    L47:
        th = th;
        r5 = null;
    L56:
        th = th;
        goto L57
    }

    public ExifInterface2(FileDescriptor r5) throws IOException {
        e[][] r0 = T;
        this.e = new HashMap[r0.length];
        this.f = new HashSet(r0.length);
        this.g = ByteOrder.BIG_ENDIAN;
        if (r5 == null) goto L28;
        this.c = null;
        this.a = null;
        if (x(r5) == false) goto L12;
        this.b = r5;
        r5 = Os.dup(r5);     // Catch: Exception -> L9
        boolean r1 = true;
    L33:
        PolarisFileInputStreamWrapper r2 = new PolarisFileInputStreamWrapper(r5);     // Catch: Throwable -> L21
        z(r2);     // Catch: Throwable -> L19
        d(r2);
        if (r1 == false) goto L35;
        c(r5);
        return;
    L35:
        return;
    L19:
        Throwable th = th;
    L23:
        d(r2);
        if (r1 == false) goto L26;
        c(r5);
    L26:
        throw th;
    L21:
        th = move-exception;
        r2 = null;
        th = th;
    L9:
        e = move-exception;
        throw new IOException("Failed to duplicate file descriptor", e);
    L12:
        this.b = null;
        r1 = false;
        goto L33
    L28:
        throw new NullPointerException("fileDescriptor cannot be null");
    }

    public static ByteOrder C(b r3) throws IOException {
        short r4 = r3.readShort();
        if (r4 == 18761) goto L14;
        if (r4 != 19789) goto L12;
        if (r == false) goto L10;
        FLogger.a.d("ExifInterface", "readExifSegment: Byte Align MM");
    L10:
        return ByteOrder.BIG_ENDIAN;
    L12:
        throw new IOException("Invalid byte order: " + Integer.toHexString(r4));
    L14:
        if (r == false) goto L17;
        FLogger.a.d("ExifInterface", "readExifSegment: Byte Align II");
    L17:
        return ByteOrder.LITTLE_ENDIAN;
    }

    public static String b(byte[] r5) {
        StringBuilder r0 = new StringBuilder(r5.length * 2);
        int r2 = 0;
    L4:
        if (r2 >= r5.length) goto L7;
        r0.append(String.format("%02x", new Object[]{Byte.valueOf(r5[r2])}));
        r2 = r2 + 1;
        goto L4
    L7:
        return r0.toString();
    }

    public static void c(FileDescriptor r2) {
        Os.close(r2);     // Catch: Exception -> L4
        return;
    L4:
        FLogger.a.e("ExifInterface", "Error closing fd.");
    }

    public static void d(Closeable r0) {
        if (r0 != null) goto L9;
        return;
    L9:
        r0.close();     // Catch: RuntimeException -> L5 Exception -> L8
        goto L12
    L11:
        return;
    L5:
        e = move-exception;
        throw e;
    }

    public static long[] f(Object r4) {
        if ((r4 instanceof int[]) == false) goto L10;
        int[] r5 = (int[]) r4;
        long[] r0 = new long[r5.length];
        int r1 = 0;
    L6:
        if (r1 >= r5.length) goto L8;
        r0[r1] = r5[r1];
        r1 = r1 + 1;
        goto L6
    L8:
        return r0;
    L10:
        if ((r4 instanceof long[]) == true) goto L12;
        return null;
    L12:
        return (long[]) r4;
    }

    public static Pair<Integer, Integer> v(String r12) {
        int r3 = 1;
        if (r12.contains(",") == false) goto L35;
        String[] r13 = r12.split(",", -1);
        Pair<Integer, Integer> r0 = v(r13[0]);
        if (((Integer) r0.first).intValue() != 2) goto L8;
        return r0;
    L8:
        if (r3 >= r13.length) goto L33;
        Pair<Integer, Integer> r1 = v(r13[r3]);
        if (((Integer) r1.first).equals(r0.first) == false) goto L12;
    L15:
        int r2 = ((Integer) r0.first).intValue();
    L17:
        if (((Integer) r0.second).intValue() != (-1)) goto L19;
    L23:
        int r4 = -1;
    L24:
        if (r2 != (-1)) goto L28;
        if (r4 != (-1)) goto L28;
        return new Pair(2, -1);
    L28:
        if (r2 != (-1)) goto L30;
        r0 = new Pair(Integer.valueOf(r4), -1);
    L32:
        r3 = r3 + 1;
        goto L8
    L30:
        if (r4 != (-1)) goto L32;
        r0 = new Pair(Integer.valueOf(r2), -1);
        goto L32
    L19:
        if (((Integer) r1.first).equals(r0.second) == false) goto L21;
    L22:
        r4 = ((Integer) r0.second).intValue();
        goto L24
    L21:
        if (((Integer) r1.second).equals(r0.second) == false) goto L23;
    L12:
        if (((Integer) r1.second).equals(r0.first) == true) goto L15;
        r2 = -1;
        goto L17
    L33:
        return r0;
    L35:
        if (r12.contains("/") == false) goto L73;
        String[] r14 = r12.split("/", -1);
        if (r14.length != 2) goto L55;
        long r5 = (long) CastDoubleProtector.parseDouble(r14[0]);     // Catch: NumberFormatException -> L72
        long r6 = (long) CastDoubleProtector.parseDouble(r14[1]);     // Catch: NumberFormatException -> L72
        if (r5 < 0) goto L53;
        if (r6 < 0) goto L53;
        if (r5 > 2147483647L) goto L51;
        if (r6 > 2147483647L) goto L51;
        return new Pair(10, 5);
    L51:
        return new Pair(5, -1);
    L53:
        return new Pair(10, -1);
    L55:
        return new Pair(2, -1);
    L73:
        Long r7 = Long.valueOf(CastLongProtector.parseLong(r12));     // Catch: NumberFormatException -> L68
        if (r7.longValue() < 0) goto L63;
        if (r7.longValue() > 65535) goto L63;
        return new Pair(3, 4);
    L63:
        if (r7.longValue() >= 0) goto L67;
        return new Pair(9, -1);
    L67:
        return new Pair(4, -1);
    L68:
        CastDoubleProtector.parseDouble(r12);     // Catch: NumberFormatException -> L70
        return new Pair(12, -1);
    L71:
        return new Pair(2, -1);
    }

    public static boolean x(FileDescriptor r3) {
        Os.lseek(r3, 0, OsConstants.SEEK_CUR);     // Catch: Exception -> L5
        return true;
    L6:
        if (r == false) goto L12;
        FLogger.a.d("ExifInterface", "The file descriptor for the given input is not seekable");
        return false;
    L12:
        return false;
    }

    public final void F(String r3) {
        int r0 = 0;
    L4:
        if (r0 >= T.length) goto L6;
        this.e[r0].remove(r3);
        r0 = r0 + 1;
        goto L4
    }

    public final void L(b r21) throws IOException {
        HashMap<String, d> r2 = this.e[4];
        d r3 = r2.get("Compression");
        if (r3 == null) goto L74;
        int r4 = r3.h(this.g);
        this.m = r4;
        int r5 = 1;
        if (r4 == 1) goto L11;
        if (r4 != 6) goto L8;
        w(r21, r2);
        return;
    L8:
        if (r4 == 7) goto L11;
        return;
    L11:
        d r6 = r2.get("BitsPerSample");
        if (r6 == null) goto L29;
        int[] r7 = (int[]) r6.j(this.g);
        int[] r8 = u;
        if (Arrays.equals(r8, r7) == false) goto L17;
    L27:
        boolean r9 = true;
    L32:
        if (r9 == false) goto L82;
        d r10 = r2.get("StripOffsets");
        d r11 = r2.get("StripByteCounts");
        if (r10 == null) goto L83;
        if (r11 == null) goto L84;
        long[] r12 = f(r10.j(this.g));
        long[] r13 = f(r11.j(this.g));
        if (r12 != null) goto L39;
    L73:
        FLogger.a.w("ExifInterface", "stripOffsets should not be null or have zero length.");
        return;
    L39:
        if (r12.length == 0) goto L73;
        if (r13 != null) goto L43;
    L72:
        FLogger.a.w("ExifInterface", "stripByteCounts should not be null or have zero length.");
        return;
    L43:
        if (r13.length == 0) goto L72;
        if (r12.length == r13.length) goto L48;
        FLogger.a.w("ExifInterface", "stripOffsets and stripByteCounts should have same length.");
        return;
    L48:
        int r14 = r13.length;
        long r15 = 0;
        int r16 = 0;
    L49:
        if (r16 >= r14) goto L51;
        r15 = r15 + r13[r16];
        r16 = r16 + 1;
        goto L49
    L51:
        int r17 = (int) r15;
        byte[] r18 = new byte[r17];
        this.i = true;
        this.h = true;
        int r19 = 0;
        int r110 = 0;
        int r111 = 0;
    L53:
        if (r19 >= r12.length) goto L69;
        int r112 = (int) r12[r19];
        int r113 = (int) r13[r19];
        if (r19 < (r12.length - r5)) goto L57;
    L59:
        int r114 = r112 - r110;
        if (r114 < 0) goto L61;
        long r115 = r114;
        if (r21.skip(r115) != r115) goto L64;
        int r116 = r110 + r114;
        byte[] r117 = new byte[r113];
        if (r21.read(r117) != r113) goto L67;
        r110 = r116 + r113;
        System.arraycopy(r117, 0, r18, r111, r113);
        r111 = r111 + r113;
        r19 = r19 + 1;
        r5 = 1;
        goto L53
    L67:
        FLogger.a.d("ExifInterface", "Failed to read " + r113 + " bytes.");
        return;
    L64:
        FLogger.a.d("ExifInterface", "Failed to skip " + r114 + " bytes.");
        return;
    L61:
        FLogger.a.d("ExifInterface", "Invalid strip offset value");
        return;
    L57:
        if ((r112 + r113) == r12[r19 + 1]) goto L59;
        this.i = false;
        goto L59
    L69:
        this.l = r18;
        if (this.i == false) goto L89;
        this.j = (int) r12[0];
        this.k = r17;
        return;
    L89:
        return;
    L84:
        return;
    L83:
        return;
    L82:
        return;
    L17:
        if (this.d != 3) goto L29;
        d r20 = r2.get("PhotometricInterpretation");
        if (r20 == null) goto L29;
        int r22 = r20.h(this.g);
        if (r22 == 1) goto L23;
    L24:
        if (r22 != 6) goto L29;
        if (Arrays.equals(r7, r8) == false) goto L29;
    L23:
        if (Arrays.equals(r7, v) == true) goto L27;
    L29:
        if (r == false) goto L31;
        FLogger.a.d("ExifInterface", "Unsupported data type value");
    L31:
        r9 = false;
        goto L32
    L74:
        this.m = 6;
        w(r21, r2);
    }

    public final void P(c r17) throws IOException {
        e[][] r2 = T;
        int[] r3 = new int[r2.length];
        int[] r4 = new int[r2.length];
        e[] r5 = U;
        int r6 = r5.length;
        int r7 = 0;
    L3:
        if (r7 >= r6) goto L5;
        F(r5[r7].b);
        r7 = r7 + 1;
        goto L3
    L5:
        F(V.b);
        F(W.b);
        int r8 = 0;
    L7:
        if (r8 >= T.length) goto L16;
        Object[] r9 = this.e[r8].entrySet().toArray();
        int r10 = r9.length;
        int r11 = 0;
    L9:
        if (r11 >= r10) goto L14;
        Map.Entry r12 = (Map.Entry) r9[r11];
        if (r12.getValue() != null) goto L13;
        this.e[r8].remove(r12.getKey());
    L13:
        r11 = r11 + 1;
        goto L9
    L14:
        r8 = r8 + 1;
        goto L7
    L16:
        if (this.e[1].isEmpty() == true) goto L19;
        this.e[0].put(U[1].b, d.b(0, this.g));
    L19:
        if (this.e[2].isEmpty() == true) goto L22;
        this.e[0].put(U[2].b, d.b(0, this.g));
    L22:
        if (this.e[3].isEmpty() == true) goto L25;
        this.e[1].put(U[3].b, d.b(0, this.g));
    L25:
        if (this.h == false) goto L27;
        this.e[4].put(V.b, d.b(0, this.g));
        this.e[4].put(W.b, d.b(this.k, this.g));
    L27:
        int r13 = 0;
    L29:
        if (r13 >= T.length) goto L38;
        Iterator<Map.Entry<String, d>> r14 = this.e[r13].entrySet().iterator();
        int r15 = 0;
    L32:
        if (r14.hasNext() == false) goto L37;
        d r16 = r14.next().getValue();
        r16.getClass();
        int r18 = Q[r16.a] * r16.b;
        if (r18 <= 4) goto L32;
        r15 = r15 + r18;
        goto L32
    L37:
        r4[r13] = r4[r13] + r15;
        r13 = r13 + 1;
        goto L29
    L38:
        int r19 = 8;
        int r20 = 0;
    L40:
        if (r20 >= T.length) goto L46;
        if (this.e[r20].isEmpty() == true) goto L44;
        r3[r20] = r19;
        r19 = r19 + ((((this.e[r20].size() * 12) + 2) + 4) + r4[r20]);
    L44:
        r20 = r20 + 1;
        goto L40
    L46:
        if (this.h == false) goto L49;
        this.e[4].put(V.b, d.b(r19, this.g));
        this.j = r19;
        r19 = r19 + this.k;
    L49:
        if (this.d != 4) goto L52;
        r19 = r19 + 8;
    L52:
        if (r == false) goto L58;
        int r21 = 0;
    L55:
        if (r21 >= T.length) goto L58;
        FLogger.a.d("ExifInterface", String.format("index: %d, offsets: %d, tag count: %d, data sizes: %d, total size: %d", new Object[]{Integer.valueOf(r21), Integer.valueOf(r3[r21]), Integer.valueOf(this.e[r21].size()), Integer.valueOf(r4[r21]), Integer.valueOf(r19)}));
        r21 = r21 + 1;
    L58:
        if (this.e[1].isEmpty() == true) goto L61;
        this.e[0].put(U[1].b, d.b(r3[1], this.g));
    L61:
        if (this.e[2].isEmpty() == true) goto L64;
        this.e[0].put(U[2].b, d.b(r3[2], this.g));
    L64:
        if (this.e[3].isEmpty() == true) goto L66;
        this.e[1].put(U[3].b, d.b(r3[3], this.g));
    L66:
        int r22 = this.d;
        if (r22 != 4) goto L69;
        r17.c((short) r19);
        r17.write(c0);
    L76:
        if (this.g != ByteOrder.BIG_ENDIAN) goto L78;
        short r23 = 19789;
    L79:
        r17.c(r23);
        r17.b = this.g;
        r17.c((short) 42);
        r17.b((int) 8);
        int r24 = 0;
    L81:
        if (r24 >= T.length) goto L108;
        if (this.e[r24].isEmpty() == true) goto L106;
        r17.c((short) this.e[r24].size());
        int r25 = ((r3[r24] + 2) + (this.e[r24].size() * 12)) + 4;
        Iterator<Map.Entry<String, d>> r110 = this.e[r24].entrySet().iterator();
    L86:
        if (r110.hasNext() == false) goto L94;
        Map.Entry<String, d> r111 = r110.next();
        int r112 = Y[r24].get(r111.getKey()).a;
        d r113 = r111.getValue();
        r113.getClass();
        int r114 = Q[r113.a] * r113.b;
        r17.c((short) r112);
        r17.c((short) r113.a);
        r17.b(r113.b);
        if (r114 > 4) goto L89;
        r17.write(r113.d);
        if (r114 >= 4) goto L86;
    L92:
        if (r114 >= 4) goto L86;
        r17.a(0);
        r114 = r114 + 1;
        goto L92
    L89:
        r17.b(r25);
        r25 = r25 + r114;
        goto L86
    L94:
        if (r24 == 0) goto L96;
    L98:
        r17.b((int) 0);
    L99:
        Iterator<Map.Entry<String, d>> r26 = this.e[r24].entrySet().iterator();
    L101:
        if (r26.hasNext() == false) goto L106;
        byte[] r115 = r26.next().getValue().d;
        if (r115.length <= 4) goto L101;
        r17.write(r115, 0, r115.length);
        goto L101
    L96:
        if (this.e[4].isEmpty() == true) goto L98;
        r17.b(r3[4]);
    L106:
        r24 = r24 + 1;
        goto L81
    L108:
        if (this.h == false) goto L111;
        r17.write(t());
    L111:
        if (this.d == 14) goto L113;
    L115:
        r17.b = ByteOrder.BIG_ENDIAN;
        return;
    L113:
        if ((r19 % 2) != 1) goto L115;
        r17.a(0);
        goto L115
    L78:
        r23 = 18761;
        goto L79
    L69:
        if (r22 == 13) goto L73;
        if (r22 != 14) goto L76;
        r17.write(I);
        r17.b(r19);
        goto L76
    L73:
        r17.b(r19);
        r17.write(D);
        goto L76
    }

    public final String j(String r7) {
        d r0 = k(r7);
        if (r0 != null) goto L5;
    L27:
        return null;
    L5:
        if (Z.contains(r7) == true) goto L9;
        return r0.i(this.g);
    L9:
        if (r7.equals("GPSTimeStamp") == false) goto L29;
        int r8 = r0.a;
        if (r8 != 5) goto L13;
    L16:
        f[] r9 = (f[]) r0.j(this.g);
        if (r9 != null) goto L19;
    L23:
        FLogger.a.w("ExifInterface", "Invalid GPS Timestamp array. array=" + Arrays.toString(r9));
        return null;
    L19:
        if (r9.length != 3) goto L23;
        f r2 = r9[0];
        f r3 = r9[1];
        f r10 = r9[2];
        return String.format("%02d:%02d:%02d", new Object[]{Integer.valueOf((int) (r2.a / r2.b)), Integer.valueOf((int) (r3.a / r3.b)), Integer.valueOf((int) (r10.a / r10.b))});
    L13:
        if (r8 == 10) goto L16;
        FLogger.a.w("ExifInterface", "GPS Timestamp format is not rational. format=" + r0.a);
        return null;
    L29:
        return Double.toString(r0.g(this.g));
    }

    public final d k(String r3) {
        if ("ISOSpeedRatings".equals(r3) == true) goto L5;
    L8:
        int r0 = 0;
    L10:
        if (r0 >= T.length) goto L15;
        d r1 = this.e[r0].get(r3);
        if (r1 != null) goto L13;
        r0 = r0 + 1;
        goto L10
    L13:
        return r1;
    L15:
        return null;
    L5:
        if (r == false) goto L7;
        FLogger.a.d("ExifInterface", "getExifAttribute: Replacing TAG_ISO_SPEED_RATINGS with TAG_PHOTOGRAPHIC_SENSITIVITY.");
    L7:
        r3 = "PhotographicSensitivity";
        goto L8
    }

    public final void l(b r14) throws IOException {
        MediaMetadataRetriever r2 = new MediaMetadataRetriever();
        int r3 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L74
        if (r3 < 23) goto L6;
        r2.setDataSource(new a(r14));     // Catch: Throwable -> L74
    L12:
        String r5 = null;
        if (r3 < 29) goto L15;
        String r6 = e(r2, 33);     // Catch: Throwable -> L74
    L16:
        if (r3 < 29) goto L18;
        String r7 = e(r2, 34);     // Catch: Throwable -> L74
    L20:
        if (r3 < 28) goto L22;
        String r4 = e(r2, 26);     // Catch: Throwable -> L74
    L23:
        String r8 = e(r2, 17);     // Catch: Throwable -> L74
        if ("yes".equals(r4) == false) goto L27;
        r5 = e(r2, 29);     // Catch: Throwable -> L74
        String r0 = e(r2, 30);     // Catch: Throwable -> L74
        String r9 = e(r2, 31);     // Catch: Throwable -> L74
    L31:
        if (r5 == null) goto L33;
        this.e[0].put("ImageWidth", d.e(Integer.parseInt(r5), this.g));     // Catch: Throwable -> L74
    L33:
        if (r0 == null) goto L36;
        this.e[0].put("ImageLength", d.e(Integer.parseInt(r0), this.g));     // Catch: Throwable -> L74
    L36:
        if (r9 == null) goto L48;
        int r10 = Integer.parseInt(r9);     // Catch: Throwable -> L74
        if (r10 != 90) goto L40;
        int r11 = 6;
    L47:
        this.e[0].put("Orientation", d.e(r11, this.g));     // Catch: Throwable -> L74
        goto L48
    L40:
        if (r10 != 180) goto L42;
        r11 = 3;
        goto L47
    L42:
        if (r10 == 270) goto L44;
        r11 = 1;
        goto L47
    L44:
        r11 = 8;
    L48:
        if (r6 == null) goto L68;
        if (r7 == null) goto L68;
        int r12 = Integer.parseInt(r6);     // Catch: Throwable -> L74
        int r13 = Integer.parseInt(r7);     // Catch: Throwable -> L74
        if (r13 <= 6) goto L66;
        r14.a(r12);     // Catch: Throwable -> L74
        byte[] r15 = new byte[6];     // Catch: Throwable -> L74
        if (r14.read(r15) != 6) goto L64;
        int r16 = r12 + 6;     // Catch: Throwable -> L74
        int r17 = r13 - 6;     // Catch: Throwable -> L74
        if (Arrays.equals(r15, c0) == false) goto L62;
        byte[] r18 = new byte[r17];     // Catch: Throwable -> L74
        if (r14.read(r18) != r17) goto L60;
        this.n = r16;     // Catch: Throwable -> L74
        D(r18, 0);     // Catch: Throwable -> L74
        goto L68
    L60:
        throw new IOException("Can't read exif");     // Catch: Throwable -> L74
    L62:
        throw new IOException("Invalid identifier");     // Catch: Throwable -> L74
    L64:
        throw new IOException("Can't read identifier");     // Catch: Throwable -> L74
    L66:
        throw new IOException("Invalid exif length");     // Catch: Throwable -> L74
    L68:
        if (r == false) goto L70;
        FLogger.a.d("ExifInterface", "Heif meta: " + r5 + "x" + r0 + ", rotation " + r9);     // Catch: Throwable -> L74
    L70:
        r2.release();
        return;
    L27:
        if ("yes".equals(r8) == false) goto L29;
        r5 = e(r2, 18);     // Catch: Throwable -> L74
        r0 = e(r2, 19);     // Catch: Throwable -> L74
        r9 = e(r2, 24);     // Catch: Throwable -> L74
        goto L31
    L29:
        r0 = null;
        r9 = null;
        goto L31
    L22:
        r4 = null;
        goto L23
    L18:
        r7 = null;
        goto L20
    L15:
        r6 = null;
        goto L16
    L6:
        FileDescriptor r19 = this.b;     // Catch: Throwable -> L74
        if (r19 == null) goto L9;
        r2.setDataSource(r19);     // Catch: Throwable -> L74
        goto L12
    L9:
        String r20 = this.a;     // Catch: Throwable -> L74
        if (r20 == null) goto L72;
        r2.setDataSource(r20);     // Catch: Throwable -> L74
        goto L12
    L72:
        r2.release();
        return;
    L74:
        th = move-exception;
        r2.release();
        throw th;
    }

    public final int n(BufferedInputStream r18) throws IOException {
        r18.mark(5000);
        byte[] r3 = new byte[5000];
        r18.read(r3);
        r18.reset();
        int r0 = 0;
    L3:
        byte[] r5 = w;
        if (r0 >= r5.length) goto L9;
        if (r3[r0] != r5[r0]) goto L7;
        r0 = r0 + 1;
        goto L3
    L7:
        boolean r1 = false;
    L11:
        if (r1 == false) goto L13;
        return 4;
    L13:
        byte[] r2 = "FUJIFILMCCD-RAW".getBytes(Charset.defaultCharset());
        int r6 = 0;
    L15:
        if (r6 >= r2.length) goto L20;
        if (r3[r6] != r2[r6]) goto L18;
        r6 = r6 + 1;
        goto L15
    L18:
        boolean r4 = false;
    L21:
        if (r4 == false) goto L171;
        return 9;
    L171:
        b r8 = new b(r3);     // Catch: Throwable -> L63 Exception -> L65
        long r9 = r8.readInt();     // Catch: Throwable -> L59 Exception -> L61
        byte[] r7 = new byte[4];     // Catch: Throwable -> L59 Exception -> L61
        r8.read(r7);     // Catch: Throwable -> L59 Exception -> L61
        if (Arrays.equals(r7, x) == true) goto L29;
    L71:
        r8.close();
    L72:
        boolean r10 = false;
    L73:
        if (r10 == false) goto L167;
        return 12;
    L167:
        b r11 = new b(r3);     // Catch: Throwable -> L89 Exception -> L94
        ByteOrder r12 = C(r11);     // Catch: Throwable -> L86 Exception -> L88
        this.g = r12;     // Catch: Throwable -> L86 Exception -> L88
        r11.b = r12;     // Catch: Throwable -> L86 Exception -> L88
        short r13 = r11.readShort();     // Catch: Throwable -> L86 Exception -> L88
        goto L95
    L79:
        if (r13 != 20306) goto L81;
    L84:
        boolean r14 = true;
    L85:
        r11.close();
    L98:
        if (r14 == false) goto L163;
        return 7;
    L163:
        b r15 = new b(r3);     // Catch: Throwable -> L111 Exception -> L116
        ByteOrder r16 = C(r15);     // Catch: Throwable -> L108 Exception -> L110
        this.g = r16;     // Catch: Throwable -> L108 Exception -> L110
        r15.b = r16;     // Catch: Throwable -> L108 Exception -> L110
    L104:
        if (r15.readShort() != 85) goto L106;
        boolean r17 = true;
    L107:
        r15.close();
    L120:
        if (r17 == false) goto L123;
        return 10;
    L123:
        int r19 = 0;
    L124:
        byte[] r20 = C;
        if (r19 >= r20.length) goto L130;
        if (r3[r19] != r20[r19]) goto L128;
        r19 = r19 + 1;
        goto L124
    L128:
        boolean r21 = false;
    L131:
        if (r21 == false) goto L134;
        return 13;
    L134:
        int r22 = 0;
    L135:
        byte[] r23 = G;
        if (r22 >= r23.length) goto L141;
        if (r3[r22] != r23[r22]) goto L146;
        r22 = r22 + 1;
    L146:
        boolean r24 = false;
    L149:
        if (r24 == false) goto L152;
        return 14;
    L152:
        return 0;
    L141:
        int r25 = 0;
    L142:
        byte[] r26 = H;
        if (r25 >= r26.length) goto L148;
        if (r3[(G.length + r25) + 4] != r26[r25]) goto L146;
        r25 = r25 + 1;
        goto L142
    L148:
        r24 = true;
        goto L149
    L130:
        r21 = true;
        goto L131
    L106:
        r17 = false;
    L110:
        b r27 = r15;
    L117:
        if (r27 == null) goto L119;
        r27.close();
    L119:
        r17 = false;
    L108:
        th = th;
        b r28 = r15;
    L113:
        if (r28 == null) goto L115;
        r28.close();
    L115:
        throw th;
    L116:
        r27 = null;
    L111:
        th = th;
        r28 = null;
        goto L113
    L81:
        if (r13 == 21330) goto L84;
        r14 = false;
    L86:
        th = th;
        b r29 = r11;
    L91:
        if (r29 == null) goto L93;
        r29.close();
    L93:
        throw th;
    L95:
        if (r11 == null) goto L97;
        r11.close();
    L97:
        r14 = false;
        goto L98
    L94:
        r11 = null;
    L89:
        th = th;
        r29 = null;
        goto L91
    L29:
        if (r9 != 1) goto L33;
        r9 = r8.readLong();     // Catch: Throwable -> L59 Exception -> L61
        long r110 = 16;
        if (r9 < 16) goto L71;
    L34:
        long r30 = 5000;
        if (r9 <= r30) goto L37;
        r9 = r30;
    L37:
        long r31 = r9 - r110;     // Catch: Throwable -> L59 Exception -> L61
        if (r31 < 8) goto L71;
        byte[] r32 = new byte[4];     // Catch: Throwable -> L59 Exception -> L61
        long r33 = 0;
        boolean r34 = false;
        boolean r111 = false;
    L41:
        if (r33 >= (r31 / 4)) goto L71;
        if (r8.read(r32) != 4) goto L71;
        if (r33 != 1) goto L50;
    L58:
        r33 = r33 + 1;
        goto L41
    L50:
        if (Arrays.equals(r32, y) == false) goto L53;
        r34 = true;
    L55:
        if (r34 == false) goto L58;
        if (r111 == false) goto L58;
        r8.close();
        r10 = true;
        goto L73
    L53:
        if (Arrays.equals(r32, z) == false) goto L55;
        r111 = true;
        goto L55
    L33:
        r110 = 8;
    L61:
        e = e;
    L159:
    L153:
        th = th;
        b r35 = r8;
    L155:
        r8 = r35;
    L156:
        if (r8 == null) goto L158;
        r8.close();
    L158:
        throw th;
    L68:
        if (r == false) goto L70;
        FLogger.a.d("ExifInterface", "Exception parsing HEIF file type box. Exception message: " + e.getMessage());     // Catch: Throwable -> L153
    L70:
        if (r8 == null) goto L72;
    L59:
        th = th;
        goto L156
    L65:
        e = e;
        r8 = null;
    L63:
        th = th;
        r35 = null;
        goto L155
    L20:
        r4 = true;
        goto L21
    L9:
        r1 = true;
        goto L11
    }

    public final void o(b r6) throws IOException {
        r(r6);
        d r7 = this.e[1].get("MakerNote");
        if (r7 == null) goto L31;
        b r1 = new b(r7.d);
        r1.b = this.g;
        byte[] r8 = A;
        byte[] r2 = new byte[r8.length];
        r1.readFully(r2);
        r1.a(0);
        byte[] r3 = B;
        byte[] r4 = new byte[r3.length];
        r1.readFully(r4);
        if (Arrays.equals(r2, r8) == false) goto L8;
        r1.a(8);
    L10:
        E(r1, 6);
        d r9 = this.e[7].get("PreviewImageStart");
        d r5 = this.e[7].get("PreviewImageLength");
        if (r9 == null) goto L14;
        if (r5 == null) goto L14;
        this.e[5].put("JPEGInterchangeFormat", r9);
        this.e[5].put("JPEGInterchangeFormatLength", r5);
    L14:
        d r10 = this.e[8].get("AspectFrame");
        if (r10 == null) goto L32;
        int[] r11 = (int[]) r10.j(this.g);
        if (r11 != null) goto L19;
    L29:
        FLogger.a.w("ExifInterface", "Invalid aspect frame values. frame=" + Arrays.toString(r11));
        return;
    L19:
        if (r11.length != 4) goto L29;
        int r12 = r11[2];
        int r13 = r11[0];
        if (r12 <= r13) goto L33;
        int r14 = r11[3];
        int r15 = r11[1];
        if (r14 <= r15) goto L34;
        int r16 = (r12 - r13) + 1;
        int r17 = (r14 - r15) + 1;
        if (r16 >= r17) goto L28;
        int r18 = r16 + r17;
        r17 = r18 - r17;
        r16 = r18 - r17;
    L28:
        d r19 = d.e(r16, this.g);
        d r0 = d.e(r17, this.g);
        this.e[0].put("ImageWidth", r19);
        this.e[0].put("ImageLength", r0);
        return;
    L34:
        return;
    L33:
        return;
    L32:
        return;
    L8:
        if (Arrays.equals(r4, r3) == false) goto L10;
        r1.a(12);
        goto L10
    }

    public final void p(b r7) throws IOException {
        if (r == false) goto L5;
        FLogger.a.d("ExifInterface", "getPngAttributes starting with: " + r7);
    L5:
        r7.mark(0);
        r7.b = ByteOrder.BIG_ENDIAN;
        byte[] r1 = C;
        r7.skipBytes(r1.length);
        int r2 = r1.length + 0;
    L35:
        int r3 = r7.readInt();     // Catch: EOFException -> L33
        int r4 = r2 + 4;     // Catch: EOFException -> L33
        byte[] r5 = new byte[4];     // Catch: EOFException -> L33
        if (r7.read(r5) != 4) goto L32;
        int r6 = r4 + 4;     // Catch: EOFException -> L33
        if (r6 != 16) goto L16;
        if (Arrays.equals(r5, E) == true) goto L16;
        throw new IOException("Encountered invalid PNG file--IHDR chunk should appearas the first chunk");     // Catch: EOFException -> L33
    L16:
        if (Arrays.equals(r5, F) == true) goto L40;
        if (Arrays.equals(r5, D) == true) goto L20;
        int r8 = r3 + 4;     // Catch: EOFException -> L33
        r7.skipBytes(r8);     // Catch: EOFException -> L33
        r2 = r6 + r8;     // Catch: EOFException -> L33
        goto L35
    L20:
        byte[] r9 = new byte[r3];     // Catch: EOFException -> L33
        if (r7.read(r9) != r3) goto L29;
        int r10 = r7.readInt();     // Catch: EOFException -> L33
        CRC32 r11 = new CRC32();     // Catch: EOFException -> L33
        r11.update(r5);     // Catch: EOFException -> L33
        r11.update(r9);     // Catch: EOFException -> L33
        if (((int) r11.getValue()) != r10) goto L27;
        this.n = r6;     // Catch: EOFException -> L33
        D(r9, 0);     // Catch: EOFException -> L33
        O();     // Catch: EOFException -> L33
        L(new b(r9));     // Catch: EOFException -> L33
        return;
    L27:
        throw new IOException("Encountered invalid CRC value for PNG-EXIF chunk.\n recorded CRC value: " + r10 + ", calculated CRC value: " + r11.getValue());     // Catch: EOFException -> L33
    L29:
        throw new IOException("Failed to read given length for given PNG chunk type: " + b(r5));     // Catch: EOFException -> L33
    L40:
        return;
    L32:
        throw new IOException("Encountered invalid length while parsing PNG chunktype");     // Catch: EOFException -> L33
    L34:
        throw new IOException("Encountered corrupt PNG file.");
    }

    public final void q(b r9) throws IOException {
        boolean r0 = r;
        if (r0 == false) goto L5;
        FLogger.a.d("ExifInterface", "getRafAttributes starting with: " + r9);
    L5:
        r9.mark(0);
        r9.skipBytes(84);
        byte[] r4 = new byte[4];
        byte[] r5 = new byte[4];
        byte[] r3 = new byte[4];
        r9.read(r4);
        r9.read(r5);
        r9.read(r3);
        int r6 = ByteBuffer.wrap(r4).getInt();
        int r7 = ByteBuffer.wrap(r5).getInt();
        int r8 = ByteBuffer.wrap(r3).getInt();
        byte[] r10 = new byte[r7];
        r9.a(r6);
        r9.read(r10);
        m(new b(r10), r6, 5);
        r9.a(r8);
        r9.b = ByteOrder.BIG_ENDIAN;
        int r11 = r9.readInt();
        if (r0 == false) goto L8;
        FLogger.a.d("ExifInterface", "numberOfDirectoryEntry: " + r11);
    L8:
        int r1 = 0;
    L9:
        if (r1 >= r11) goto L17;
        int r12 = r9.readUnsignedShort();
        int r13 = r9.readUnsignedShort();
        if (r12 == S.a) goto L12;
        r9.skipBytes(r13);
        r1 = r1 + 1;
        goto L9
    L12:
        short r2 = r9.readShort();
        short r14 = r9.readShort();
        d r15 = d.e(r2, this.g);
        d r16 = d.e(r14, this.g);
        this.e[0].put("ImageLength", r15);
        this.e[0].put("ImageWidth", r16);
        if (r == false) goto L20;
        FLogger.a.d("ExifInterface", "Updated to length: " + r2 + ", width: " + r14);
        return;
    L20:
        return;
    }

    public final void r(b r5) throws IOException {
        A(r5, r5.available());
        E(r5, 0);
        N(r5, 0);
        N(r5, 5);
        N(r5, 4);
        O();
        if (this.d != 8) goto L10;
        d r6 = this.e[1].get("MakerNote");
        if (r6 == null) goto L11;
        b r1 = new b(r6.d);
        r1.b = this.g;
        r1.a(6);
        E(r1, 9);
        d r7 = this.e[9].get("ColorSpace");
        if (r7 == null) goto L12;
        this.e[1].put("ColorSpace", r7);
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void s(b r5) throws IOException {
        if (r == false) goto L5;
        FLogger.a.d("ExifInterface", "getRw2Attributes starting with: " + r5);
    L5:
        r(r5);
        d r6 = this.e[0].get("JpgFromRaw");
        if (r6 == null) goto L8;
        m(new b(r6.d), (int) r6.c, 5);
    L8:
        d r7 = this.e[0].get("ISO");
        d r0 = this.e[1].get("PhotographicSensitivity");
        if (r7 == null) goto L13;
        if (r0 != null) goto L14;
        this.e[1].put("PhotographicSensitivity", r7);
        return;
    L14:
        return;
    }

    public final void u(b r7) throws IOException {
        if (r == false) goto L5;
        FLogger.a.d("ExifInterface", "getWebpAttributes starting with: " + r7);
    L5:
        r7.mark(0);
        r7.b = ByteOrder.LITTLE_ENDIAN;
        r7.skipBytes(G.length);
        int r1 = r7.readInt() + 8;
        int r2 = r7.skipBytes(H.length) + 8;
    L36:
        byte[] r4 = new byte[4];     // Catch: EOFException -> L34
        if (r7.read(r4) != 4) goto L33;
        int r5 = r7.readInt();     // Catch: EOFException -> L34
        int r3 = (r2 + 4) + 4;     // Catch: EOFException -> L34
        if (Arrays.equals(I, r4) == true) goto L11;
        if ((r5 % 2) != 1) goto L20;
        r5 = r5 + 1;
    L20:
        int r6 = r3 + r5;
        if (r6 == r1) goto L42;
        if (r6 > r1) goto L31;
        int r8 = r7.skipBytes(r5);     // Catch: EOFException -> L34
        if (r8 != r5) goto L29;
        r2 = r3 + r8;     // Catch: EOFException -> L34
        goto L36
    L29:
        throw new IOException("Encountered WebP file with invalid chunk size");     // Catch: EOFException -> L34
    L31:
        throw new IOException("Encountered WebP file with invalid chunk size");     // Catch: EOFException -> L34
    L42:
        return;
    L11:
        byte[] r9 = new byte[r5];     // Catch: EOFException -> L34
        if (r7.read(r9) != r5) goto L15;
        this.n = r3;     // Catch: EOFException -> L34
        D(r9, 0);     // Catch: EOFException -> L34
        L(new b(r9));     // Catch: EOFException -> L34
        return;
    L15:
        throw new IOException("Failed to read given length for given PNG chunk type: " + b(r4));     // Catch: EOFException -> L34
    L33:
        throw new IOException("Encountered invalid length while parsing WebP chunktype");     // Catch: EOFException -> L34
    L35:
        throw new IOException("Encountered corrupt WebP file.");
    }

    public final boolean y(HashMap r3) throws IOException {
        d r0 = (d) r3.get("ImageLength");
        d r4 = (d) r3.get("ImageWidth");
        if (r0 == null) goto L10;
        if (r4 == null) goto L12;
        int r1 = r0.h(this.g);
        int r5 = r4.h(this.g);
        if (r1 > 512) goto L13;
        if (r5 > 512) goto L14;
        return true;
    L14:
        return false;
    L13:
        return false;
    L12:
        return false;
    L10:
        return false;
    }

    public final void z(InputStream r5) {
        int r1 = 0;
    L57:
    L43:
        th = move-exception;
        a();
        if (r == false) goto L56;
        B();
    L56:
        throw th;
    L45:
        e = move-exception;
        boolean r0 = r;     // Catch: Throwable -> L43
        if (r0 == false) goto L49;
        FLogger.a.w("ExifInterface", "Invalid image: ExifInterface got an unsupported image format file(ExifInterface supports JPEG and some RAW image formats only) or a corrupted JPEG file to ExifInterface.", e);     // Catch: Throwable -> L43
    L49:
        a();
        if (r0 == false) goto L65;
    L51:
        B();
        return;
    L65:
        return;
    L4:
        if (r1 >= T.length) goto L6;
        this.e[r1] = new HashMap();     // Catch: Throwable -> L43 IOException -> L45
        r1 = r1 + 1;     // Catch: Throwable -> L43 IOException -> L45
        goto L57
    L6:
        BufferedInputStream r2 = new BufferedInputStream(r5, 5000);     // Catch: Throwable -> L43 IOException -> L45
        this.d = n(r2);     // Catch: Throwable -> L43 IOException -> L45
        b r6 = new b(r2);     // Catch: Throwable -> L43 IOException -> L45
        switch(this.d) {
            case 0: goto L38;
            case 1: goto L38;
            case 2: goto L38;
            case 3: goto L38;
            case 4: goto L33;
            case 5: goto L38;
            case 6: goto L38;
            case 7: goto L32;
            case 8: goto L38;
            case 9: goto L27;
            case 10: goto L22;
            case 11: goto L38;
            case 12: goto L20;
            case 13: goto L14;
            case 14: goto L9;
            default: goto L39;
        };     // Catch: Throwable -> L43 IOException -> L45
    L9:
        u(r6);     // Catch: Throwable -> L43 IOException -> L45
        a();
        if (r == false) goto L59;
        B();
        return;
    L59:
        return;
    L14:
        p(r6);     // Catch: Throwable -> L43 IOException -> L45
        a();
        if (r == false) goto L60;
        B();
        return;
    L60:
        return;
    L22:
        s(r6);     // Catch: Throwable -> L43 IOException -> L45
        a();
        if (r == false) goto L61;
        B();
        return;
    L61:
        return;
    L27:
        q(r6);     // Catch: Throwable -> L43 IOException -> L45
        a();
        if (r == false) goto L62;
        B();
        return;
    L62:
        return;
    L32:
        o(r6);     // Catch: Throwable -> L43 IOException -> L45
        goto L39
    L33:
        m(r6, 0, 0);     // Catch: Throwable -> L43 IOException -> L45
        a();
        if (r == false) goto L63;
        B();
        return;
    L63:
        return;
    L38:
        r(r6);     // Catch: Throwable -> L43 IOException -> L45
    L39:
        r6.a(this.n);     // Catch: Throwable -> L43 IOException -> L45
        L(r6);     // Catch: Throwable -> L43 IOException -> L45
        a();
        if (r == true) goto L51;
        return;
    L20:
        if (Build.VERSION.SDK_INT < 28) goto L39;
        l(r6);     // Catch: Throwable -> L43 IOException -> L45
        goto L39
    }

    public ExifInterface2(String r3) throws IOException {
        e[][] r0 = T;
        this.e = new HashMap[r0.length];
        this.f = new HashSet(r0.length);
        this.g = ByteOrder.BIG_ENDIAN;
        if (r3 == null) goto L26;
        PolarisFileInputStreamWrapper r1 = null;
        this.c = null;
        this.a = r3;
        PolarisFileInputStreamWrapper r2 = new PolarisFileInputStreamWrapper(r3);     // Catch: Throwable -> L16 Exception -> L18
    L14:
        e = e;
        r1 = r2;
    L19:
        EnsureManager.ensureNotReachHere(e);     // Catch: Throwable -> L16
        d(r1);
    L27:
        return;
    L12:
        th = th;
    L23:
        d(r2);
        throw th;
    L7:
        if (x(r2.getFD()) == false) goto L9;
        this.b = r2.getFD();     // Catch: Throwable -> L12 Exception -> L14
    L10:
        z(r2);     // Catch: Throwable -> L12 Exception -> L14
        d(r2);
        goto L27
    L9:
        this.b = null;     // Catch: Throwable -> L12 Exception -> L14
    L16:
        th = th;
        r2 = r1;
    L18:
        e = e;
        goto L19
    L26:
        throw new NullPointerException("filename cannot be null");
    }

    public ExifInterface2(InputStream r4) throws IOException {
        e[][] r0 = T;
        this.e = new HashMap[r0.length];
        this.f = new HashSet(r0.length);
        this.g = ByteOrder.BIG_ENDIAN;
        this.a = null;
        if ((r4 instanceof AssetManager.AssetInputStream) == false) goto L6;
        this.c = (AssetManager.AssetInputStream) r4;
        this.b = null;
    L11:
        z(r4);
        return;
    L6:
        if ((r4 instanceof FileInputStream) == false) goto L10;
        FileInputStream r1 = (FileInputStream) r4;
        if (x(r1.getFD()) == false) goto L10;
        this.c = null;
        this.b = r1.getFD();
    L10:
        this.c = null;
        this.b = null;
        goto L11
    }

    public static String e(MediaMetadataRetriever r18, int r19) throws IOException {
        ArrayList r0 = new ArrayList();
        Object[] r1 = {Integer.valueOf(r19)};
        f06.b r11 = new f06.b();
        g06.a r2 = (g06.a) ApiHookConfig.b.get(100023);
        if (r2 == null) goto L5;
        f06.a[] r3 = r2.i;
    L6:
        f06.a[] r15 = r3;
        int r9 = r15.length;
        int r8 = 0;
    L8:
        if (r8 >= r9) goto L15;
        f06.a r7 = r15[r8];
        int r16 = r8;
        int r17 = r9;
        f06.d r4 = r7.preInvoke(100023, "android/media/MediaMetadataRetriever", "extractMetadata", r18, r1, "java.lang.String", r11);     // Catch: Exception -> L22
        if (r4.a == true) goto L17;
        r0.add(r7);     // Catch: Exception -> L22
    L17:
        if (r4.a == false) goto L21;
        return (String) r4.b;
    L21:
        return r18.extractMetadata(r19);
    L14:
        r8 = r16 + 1;
        r9 = r17;
        goto L8
    L15:
        r4 = new f06.d(false, null);
        goto L17
    L5:
        r3 = ApiHookConfig.d;
        goto L6
    }

    public static void g(InputStream r3, OutputStream r4) throws IOException {
        byte[] r0 = new byte[8192];
    L3:
        int r1 = r3.read(r0);
        if (r1 == (-1)) goto L6;
        r4.write(r0, 0, r1);
        goto L3
    }

    public final void A(b r4, int r5) throws IOException {
        ByteOrder r0 = C(r4);
        this.g = r0;
        r4.b = r0;
        int r1 = r4.readUnsignedShort();
        int r2 = this.d;
        if (r2 != 7) goto L5;
    L11:
        int r3 = r4.readInt();
        if (r3 < 8) goto L23;
        if (r3 >= r5) goto L23;
        int r6 = r3 - 8;
        if (r6 > 0) goto L17;
        return;
    L17:
        if (r4.skipBytes(r6) != r6) goto L20;
        return;
    L20:
        throw new IOException("Couldn't jump to first Ifd: " + r6);
    L23:
        throw new IOException("Invalid first Ifd offset: " + r3);
    L5:
        if (r2 == 10) goto L11;
        if (r1 == 42) goto L11;
        throw new IOException("Invalid start code: " + Integer.toHexString(r1));
    }

    public final void D(byte[] r2, int r3) throws IOException {
        b r0 = new b(r2);
        A(r0, r2.length);
        E(r0, r3);
    }

    public final void E(b r31, int r32) throws IOException {
        ((HashSet) this.f).add(Integer.valueOf(r31.d));
        if ((r31.d + 2) <= r31.c) goto L5;
        return;
    L5:
        short r3 = r31.readShort();
        if (r == false) goto L9;
        FLogger.a.d("ExifInterface", "numberOfDirectoryEntry: " + r3);
    L9:
        if ((r31.d + (r3 * 12)) > r31.c) goto L188;
        if (r3 <= 0) goto L196;
        char r5 = 0;
        short r7 = 0;
    L14:
        if (r7 >= r3) goto L162;
        int r13 = r31.readUnsignedShort();
        int r14 = r31.readUnsignedShort();
        int r15 = r31.readInt();
        long r8 = ((long) r31.d) + 4;
        e r4 = X[r32].get(Integer.valueOf(r13));
        boolean r11 = r;
        if (r11 == false) goto L22;
        FLogger r10 = FLogger.a;
        Object[] r12 = new Object[5];
        r12[r5] = Integer.valueOf(r32);
        r12[1] = Integer.valueOf(r13);
        if (r4 == null) goto L20;
        String r6 = r4.b;
    L21:
        r12[2] = r6;
        r12[3] = Integer.valueOf(r14);
        r12[4] = Integer.valueOf(r15);
        r10.d("ExifInterface", String.format("ifdType: %d, tagNumber: %d, tagName: %s, dataFormat: %d, numberOfComponents: %d", r12));
        goto L22
    L20:
        r6 = null;
    L22:
        if (r4 != null) goto L26;
        if (r11 == false) goto L25;
        FLogger.a.d("ExifInterface", "Skip the tag entry since tag number is not defined: " + r13);
    L25:
        short r26 = r3;
    L62:
        int r16 = r13;
    L77:
        long r2 = 0;
    L78:
        boolean r9 = false;
    L79:
        if (r9 == true) goto L82;
        r31.a(r8);
        r7 = r7;
    L160:
        r7 = (short) (r7 + 1);
        r3 = r26;
        r5 = 0;
        goto L14
    L82:
        if (r2 <= 4) goto L105;
        int r17 = r31.readInt();
        if (r11 == false) goto L88;
        FLogger.a.d("ExifInterface", "seek to data offset: " + r17);
    L88:
        if (this.d != 7) goto L98;
        if ("MakerNote".equals(r4.b) == false) goto L93;
        this.o = r17;
        goto L98
    L93:
        if (r32 != 6) goto L98;
        if ("ThumbnailImage".equals(r4.b) == false) goto L98;
        this.p = r17;
        this.q = r15;
        d r18 = d.e(6, this.g);
        d r19 = d.b(this.p, this.g);
        d r20 = d.b(this.q, this.g);
        this.e[4].put("Compression", r18);
        this.e[4].put("JPEGInterchangeFormat", r19);
        this.e[4].put("JPEGInterchangeFormatLength", r20);
    L98:
        long r110 = r17;
        if ((r110 + r2) > r31.c) goto L101;
        r31.a(r110);
    L106:
        Integer r21 = a0.get(Integer.valueOf(r16));
        if (r11 == false) goto L109;
        FLogger.a.d("ExifInterface", "nextIfdType: " + r21 + " byteCount: " + r2);
    L109:
        if (r21 == null) goto L141;
        int r111 = r14;
        if (r111 != 3) goto L113;
        int r22 = r31.readUnsignedShort();
    L125:
        long r23 = r22;
    L126:
        if (r11 == false) goto L130;
        FLogger.a.d("ExifInterface", String.format("Offset: %d, tagName: %s", new Object[]{Long.valueOf(r23), r4.b}));
    L130:
        if (r23 > 0) goto L132;
    L138:
        if (r11 == false) goto L140;
        FLogger.a.d("ExifInterface", "Skip jump into the IFD since its offset is invalid: " + r23);
    L140:
        r31.a(r8);
        goto L160
    L132:
        if (r23 >= r31.c) goto L138;
        if (((HashSet) this.f).contains(Integer.valueOf((int) r23)) == true) goto L136;
        r31.a(r23);
        E(r31, r21.intValue());
        goto L140
    L136:
        if (r11 == false) goto L140;
        FLogger.a.d("ExifInterface", "Skip jump into the IFD since it has already been read: IfdType " + r21 + " (at " + r23 + ")");
        goto L140
    L113:
        if (r111 != 4) goto L115;
        r23 = ((long) r31.readInt()) & 4294967295L;
        goto L126
    L115:
        if (r111 != 8) goto L117;
        r22 = r31.readShort();
        goto L125
    L117:
        if (r111 != 9) goto L119;
    L121:
        r22 = r31.readInt();
        goto L125
    L119:
        if (r111 == 13) goto L121;
        r23 = -1;
        goto L126
    L141:
        e r112 = r4;
        int r24 = r31.d + this.n;
        byte[] r25 = new byte[(int) r2];
        r31.readFully(r25);
        d r27 = new d(r14, r15, r24, r25);
        this.e[r32].put(r112.b, r27);
        if ("DNGVersion".equals(r112.b) == false) goto L145;
        this.d = 3;
    L145:
        if ("Make".equals(r112.b) == true) goto L149;
        if ("Model".equals(r112.b) == true) goto L149;
    L153:
        if ("Compression".equals(r112.b) == false) goto L158;
        if (r27.h(this.g) != 65535) goto L158;
    L156:
        this.d = 8;
    L158:
        if (r31.d == r8) goto L160;
        r31.a(r8);
    L149:
        if (r27.i(this.g) == null) goto L153;
        if (r27.i(this.g).contains("PENTAX") == true) goto L156;
    L101:
        if (r11 == false) goto L103;
        FLogger.a.d("ExifInterface", "Skip the tag entry since data offset is invalid: " + r17);
    L103:
        r31.a(r8);
        goto L160
    L105:
        r4 = r4;
        r7 = r7;
        r14 = r14;
        r15 = r15;
        goto L106
    L26:
        if (r14 <= 0) goto L74;
        int[] r28 = Q;
        if (r14 >= r28.length) goto L74;
        int r113 = r4.c;
        if (r113 == 7) goto L57;
        if (r14 == 7) goto L57;
        if (r113 == r14) goto L57;
        int r114 = r4.d;
        if (r114 == r14) goto L57;
        r26 = r3;
        if (r113 == 4) goto L42;
        if (r114 == 4) goto L42;
    L45:
        if (r113 == 9) goto L48;
        if (r114 == 9) goto L48;
    L51:
        if (r113 == 12) goto L54;
        if (r114 == 12) goto L54;
    L56:
        boolean r29 = false;
    L59:
        if (r29 == true) goto L64;
        if (r11 == false) goto L62;
        FLogger.a.d("ExifInterface", "Skip the tag entry since data format (" + P[r14] + ") is unexpected for tag: " + r4.b);
        goto L62
    L64:
        if (r14 != 7) goto L66;
        r14 = r113;
    L66:
        r16 = r13;
        r2 = ((long) r28[r14]) * ((long) r15);
        if (r2 >= 0) goto L69;
    L72:
        if (r11 == false) goto L78;
        FLogger.a.d("ExifInterface", "Skip the tag entry since the number of components is invalid: " + r15);
        goto L78
    L69:
        if (r2 > 2147483647L) goto L72;
        r9 = true;
    L54:
        if (r14 != 11) goto L56;
    L58:
        r29 = true;
    L48:
        if (r14 != 8) goto L51;
    L42:
        if (r14 != 3) goto L45;
    L57:
        r26 = r3;
    L74:
        r26 = r3;
        r16 = r13;
        if (r11 == false) goto L77;
        FLogger.a.d("ExifInterface", "Skip the tag entry since data format is invalid: " + r14);
        goto L77
    L162:
        if ((r31.d + 4) > r31.c) goto L189;
        int r30 = r31.readInt();
        boolean r33 = r;
        if (r33 == false) goto L166;
        FLogger.a.d("ExifInterface", String.format("nextIfdOffset: %d", new Object[]{Integer.valueOf(r30)}));
    L166:
        long r34 = r30;
        if (r34 > 0) goto L169;
    L180:
        if (r33 == false) goto L195;
        FLogger.a.d("ExifInterface", "Stop reading file since a wrong offset may cause an infinite loop: " + r30);
        return;
    L195:
        return;
    L169:
        if (r30 >= r31.c) goto L180;
        if (((HashSet) this.f).contains(Integer.valueOf(r30)) == true) goto L178;
        r31.a(r34);
        if (this.e[4].isEmpty() == false) goto L176;
        E(r31, 4);
        return;
    L176:
        if (this.e[5].isEmpty() == false) goto L191;
        E(r31, 5);
        return;
    L191:
        return;
    L178:
        if (r33 == false) goto L193;
        FLogger.a.d("ExifInterface", "Stop reading file since re-reading an IFD may cause an infinite loop: " + r30);
        return;
    L193:
        return;
    L189:
        return;
    L196:
        return;
    }

    public final void H(InputStream r13, OutputStream r14) throws IOException {
        if (r == false) goto L5;
        FLogger.a.d("ExifInterface", "saveJpegAttributes starting with (inputStream: " + r13 + ", outputStream: " + r14 + ")");
    L5:
        DataInputStream r0 = new DataInputStream(r13);
        c r15 = new c(r14, ByteOrder.BIG_ENDIAN);
        if (r0.readByte() != (-1)) goto L57;
        r15.a(-1);
        if (r0.readByte() != (-40)) goto L55;
        r15.a(-40);
        j("Xmp");
        r15.a(-1);
        r15.a(-31);
        P(r15);
        byte[] r4 = new byte[4096];
    L11:
        if (r0.readByte() != (-1)) goto L53;
        byte r5 = r0.readByte();
        if (r5 == (-39)) goto L50;
        if (r5 == (-38)) goto L50;
        if (r5 != (-31)) goto L18;
        int r8 = r0.readUnsignedShort() - 2;
        if (r8 < 0) goto L49;
        byte[] r10 = new byte[6];
        if (r8 < 6) goto L41;
        if (r0.read(r10) != 6) goto L40;
        if (Arrays.equals(r10, c0) == false) goto L41;
        int r9 = r8 - 6;
        if (r0.skipBytes(r9) == r9) goto L11;
        throw new IOException("Invalid length");
    L40:
        throw new IOException("Invalid exif");
    L41:
        r15.a(-1);
        r15.a(r5);
        r15.c((short) (r8 + 2));
        if (r8 < 6) goto L44;
        r8 = r8 - 6;
        r15.write(r10);
    L44:
        if (r8 <= 0) goto L11;
        int r6 = r0.read(r4, 0, Math.min(r8, 4096));
        if (r6 < 0) goto L11;
        r15.write(r4, 0, r6);
        r8 = r8 - r6;
        goto L44
    L49:
        throw new IOException("Invalid length");
    L18:
        r15.a(-1);
        r15.a(r5);
        int r7 = r0.readUnsignedShort();
        r15.c((short) r7);
        int r11 = r7 - 2;
        if (r11 < 0) goto L25;
    L20:
        if (r11 <= 0) goto L11;
        int r12 = r0.read(r4, 0, Math.min(r11, 4096));
        if (r12 < 0) goto L11;
        r15.write(r4, 0, r12);
        r11 = r11 - r12;
        goto L20
    L25:
        throw new IOException("Invalid length");
    L50:
        r15.a(-1);
        r15.a(r5);
        g(r0, r15);
        return;
    L53:
        throw new IOException("Invalid marker");
    L55:
        throw new IOException("Invalid marker");
    L57:
        throw new IOException("Invalid marker");
    }

    public final void I(InputStream r6, OutputStream r7) throws IOException {
        if (r == false) goto L5;
        FLogger.a.d("ExifInterface", "savePngAttributes starting with (inputStream: " + r6 + ", outputStream: " + r7 + ")");
    L5:
        DataInputStream r0 = new DataInputStream(r6);
        ByteOrder r1 = ByteOrder.BIG_ENDIAN;
        c r8 = new c(r7, r1);
        byte[] r9 = C;
        h(r0, r8, r9.length);
        int r2 = this.n;
        if (r2 != 0) goto L8;
        int r10 = r0.readInt();
        r8.b(r10);
        h(r0, r8, (r10 + 4) + 4);
    L21:
        ByteArrayOutputStream r11 = new ByteArrayOutputStream();     // Catch: Throwable -> L15
        c r3 = new c(r11, r1);     // Catch: Throwable -> L13
        P(r3);     // Catch: Throwable -> L13
        byte[] r4 = ((ByteArrayOutputStream) r3.a).toByteArray();     // Catch: Throwable -> L13
        r8.write(r4);     // Catch: Throwable -> L13
        CRC32 r5 = new CRC32();     // Catch: Throwable -> L13
        r5.update(r4, 4, r4.length - 4);     // Catch: Throwable -> L13
        r8.b((int) r5.getValue());     // Catch: Throwable -> L13
        d(r11);
        g(r0, r8);
        return;
    L13:
        th = th;
    L17:
        d(r11);
        throw th;
    L15:
        th = th;
        r11 = null;
        goto L17
    L8:
        h(r0, r8, ((r2 - r9.length) - 4) - 4);
        r0.skipBytes((r0.readInt() + 4) + 4);
        goto L21
    }

    public final void J(InputStream r20, OutputStream r21) throws IOException {
        if (r == false) goto L5;
        FLogger.a.d("ExifInterface", "saveWebpAttributes starting with (inputStream: " + r20 + ", outputStream: " + r21 + ")");
    L5:
        ByteOrder r4 = ByteOrder.LITTLE_ENDIAN;
        b r3 = new b(r20, r4);
        c r5 = new c(r21, r4);
        byte[] r2 = G;
        h(r3, r5, r2.length);
        byte[] r6 = H;
        r3.skipBytes(r6.length + 4);
        ByteArrayOutputStream r7 = null;
        ByteArrayOutputStream r9 = new ByteArrayOutputStream();     // Catch: Throwable -> L74 Exception -> L76
        c r10 = new c(r9, r4);     // Catch: Throwable -> L31 Exception -> L72
        int r8 = this.n;     // Catch: Throwable -> L31 Exception -> L72
        if (r8 == 0) goto L10;
        h(r3, r10, ((r8 - ((r2.length + 4) + r6.length)) - 4) - 4);     // Catch: Throwable -> L31 Exception -> L72
        r3.skipBytes(4);     // Catch: Throwable -> L31 Exception -> L72
        r3.skipBytes(r3.readInt());     // Catch: Throwable -> L31 Exception -> L72
        P(r10);     // Catch: Throwable -> L31 Exception -> L72
    L67:
        g(r3, r10);     // Catch: Throwable -> L31 Exception -> L72
        int r0 = r9.size();     // Catch: Throwable -> L31 Exception -> L72
        byte[] r11 = H;     // Catch: Throwable -> L31 Exception -> L72
        r5.b(r0 + r11.length);     // Catch: Throwable -> L31 Exception -> L72
        r5.write(r11);     // Catch: Throwable -> L31 Exception -> L72
        r9.writeTo(r5);     // Catch: Throwable -> L31 Exception -> L72
        d(r9);
        return;
    L10:
        byte[] r12 = new byte[4];     // Catch: Throwable -> L31 Exception -> L72
        if (r3.read(r12) != 4) goto L71;
        byte[] r13 = K;     // Catch: Throwable -> L31 Exception -> L72
        boolean r14 = false;
        if (Arrays.equals(r12, r13) == false) goto L34;
        int r15 = r3.readInt();     // Catch: Throwable -> L31 Exception -> L72
        if ((r15 % 2) != 1) goto L17;
        int r16 = r15 + 1;     // Catch: Throwable -> L31 Exception -> L72
    L18:
        byte[] r17 = new byte[r16];     // Catch: Throwable -> L31 Exception -> L72
        r3.read(r17);     // Catch: Throwable -> L31 Exception -> L72
        byte r18 = (byte) (8 | r17[0]);     // Catch: Throwable -> L31 Exception -> L72
        r17[0] = r18;     // Catch: Throwable -> L31 Exception -> L72
        if (((r18 >> 1) & 1) != 1) goto L21;
        r14 = true;
    L21:
        r10.write(r13);     // Catch: Throwable -> L31 Exception -> L72
        r10.b(r15);     // Catch: Throwable -> L31 Exception -> L72
        r10.write(r17);     // Catch: Throwable -> L31 Exception -> L72
        if (r14 == false) goto L33;
        i(r3, r10, N, null);     // Catch: Throwable -> L31 Exception -> L72
    L24:
        byte[] r19 = new byte[4];     // Catch: Throwable -> L31 Exception -> L72
        r20.read(r19);     // Catch: Throwable -> L31 Exception -> L72
        if (Arrays.equals(r19, O) == false) goto L26;
        int r22 = r3.readInt();     // Catch: Throwable -> L31 Exception -> L72
        r10.write(r19);     // Catch: Throwable -> L31 Exception -> L72
        r10.b(r22);     // Catch: Throwable -> L31 Exception -> L72
        if ((r22 % 2) != 1) goto L30;
        r22 = r22 + 1;     // Catch: Throwable -> L31 Exception -> L72
    L30:
        h(r3, r10, r22);     // Catch: Throwable -> L31 Exception -> L72
        goto L24
    L26:
        P(r10);     // Catch: Throwable -> L31 Exception -> L72
        goto L67
    L33:
        i(r3, r10, M, L);     // Catch: Throwable -> L31 Exception -> L72
        P(r10);     // Catch: Throwable -> L31 Exception -> L72
        goto L67
    L17:
        r16 = r15;
        goto L18
    L34:
        byte[] r1 = M;     // Catch: Throwable -> L31 Exception -> L72
        if (Arrays.equals(r12, r1) == false) goto L37;
    L38:
        int r23 = r3.readInt();     // Catch: Throwable -> L31 Exception -> L72
        if ((r23 % 2) != 1) goto L41;
        int r24 = r23 + 1;     // Catch: Throwable -> L31 Exception -> L72
    L42:
        byte[] r110 = new byte[3];     // Catch: Throwable -> L31 Exception -> L72
        if (Arrays.equals(r12, r1) == false) goto L52;
        r3.read(r110);     // Catch: Throwable -> L31 Exception -> L72
        byte[] r111 = new byte[3];     // Catch: Throwable -> L31 Exception -> L72
        if (r3.read(r111) != 3) goto L50;
        if (Arrays.equals(J, r111) == false) goto L50;
        int r112 = r3.readInt();     // Catch: Throwable -> L31 Exception -> L72
        int r113 = (r112 << 18) >> 18;     // Catch: Throwable -> L31 Exception -> L72
        int r114 = (r112 << 2) >> 18;     // Catch: Throwable -> L31 Exception -> L72
        r24 = r24 - 10;     // Catch: Throwable -> L31 Exception -> L72
    L59:
        int r115 = r114;
        int r116 = r113;
        int r117 = 0;
    L60:
        r10.write(r13);     // Catch: Throwable -> L31 Exception -> L72
        r10.b(10);     // Catch: Throwable -> L31 Exception -> L72
        byte[] r25 = new byte[10];     // Catch: Throwable -> L31 Exception -> L72
        byte r26 = (byte) (r25[0] | 8);     // Catch: Throwable -> L31 Exception -> L72
        r25[0] = r26;     // Catch: Throwable -> L31 Exception -> L72
        r25[0] = (byte) (r26 | (r117 << 4));     // Catch: Throwable -> L31 Exception -> L72
        int r118 = r116 - 1;     // Catch: Throwable -> L31 Exception -> L72
        int r27 = r115 - 1;     // Catch: Throwable -> L31 Exception -> L72
        r25[4] = (byte) r118;     // Catch: Throwable -> L31 Exception -> L72
        r25[5] = (byte) (r118 >> 8);     // Catch: Throwable -> L31 Exception -> L72
        r25[6] = (byte) (r118 >> 16);     // Catch: Throwable -> L31 Exception -> L72
        r25[7] = (byte) r27;     // Catch: Throwable -> L31 Exception -> L72
        r25[8] = (byte) (r27 >> 8);     // Catch: Throwable -> L31 Exception -> L72
        r25[9] = (byte) (r27 >> 16);     // Catch: Throwable -> L31 Exception -> L72
        r10.write(r25);     // Catch: Throwable -> L31 Exception -> L72
        r10.write(r12);     // Catch: Throwable -> L31 Exception -> L72
        r10.b(r23);     // Catch: Throwable -> L31 Exception -> L72
        if (Arrays.equals(r12, r1) == false) goto L64;
        r10.write(r110);     // Catch: Throwable -> L31 Exception -> L72
        r10.write(J);     // Catch: Throwable -> L31 Exception -> L72
        r10.b(r112);     // Catch: Throwable -> L31 Exception -> L72
    L66:
        h(r3, r10, r24);     // Catch: Throwable -> L31 Exception -> L72
        P(r10);     // Catch: Throwable -> L31 Exception -> L72
        goto L67
    L64:
        if (Arrays.equals(r12, L) == false) goto L66;
        r10.write(47);     // Catch: Throwable -> L31 Exception -> L72
        r10.b(r112);     // Catch: Throwable -> L31 Exception -> L72
    L50:
        throw new IOException("Encountered error while checking VP8 signature");     // Catch: Throwable -> L31 Exception -> L72
    L52:
        if (Arrays.equals(r12, L) == true) goto L54;
        r112 = 0;
        r113 = 0;
        r114 = 0;
        goto L59
    L54:
        if (r3.readByte() != 47) goto L57;
        r112 = r3.readInt();     // Catch: Throwable -> L31 Exception -> L72
        r116 = ((r112 << 18) >> 18) + 1;     // Catch: Throwable -> L31 Exception -> L72
        r115 = ((r112 << 4) >> 18) + 1;     // Catch: Throwable -> L31 Exception -> L72
        r117 = r112 & 8;     // Catch: Throwable -> L31 Exception -> L72
        r24 = r24 - 5;     // Catch: Throwable -> L31 Exception -> L72
        goto L60
    L57:
        throw new IOException("Encountered error while checking VP8L signature");     // Catch: Throwable -> L31 Exception -> L72
    L41:
        r24 = r23;
        goto L42
    L37:
        if (Arrays.equals(r12, L) == false) goto L67;
    L71:
        throw new IOException("Encountered invalid length while parsing WebP chunk type");     // Catch: Throwable -> L31 Exception -> L72
    L72:
        e = e;
        r7 = r9;
    L78:
        throw new IOException("Failed to save WebP file", e);     // Catch: Throwable -> L74
    L31:
        th = th;
    L80:
        d(r9);
        throw th;
    L76:
        e = e;
    L74:
        th = th;
        r9 = r7;
        goto L80
    }

    public final void K(String r19, String r20) {
        String r1 = r19;
        String r2 = r20;
        if (r1 == null) goto L147;
        if ("DateTime".equals(r1) == false) goto L7;
    L10:
        if (r2 == null) goto L21;
        boolean r3 = e0.matcher(r2).find();
        boolean r7 = f0.matcher(r2).find();
        if (r20.length() != 19) goto L18;
        if (r3 == true) goto L16;
        if (r7 == false) goto L18;
    L16:
        if (r7 == false) goto L21;
        r2 = r2.replaceAll("-", ":");
    L18:
        FLogger.a.w("ExifInterface", "Invalid value for " + r1 + " : " + r2);
        return;
    L21:
        if ("ISOSpeedRatings".equals(r1) == true) goto L23;
    L26:
        int r4 = 2;
        int r8 = 1;
        if (r2 != null) goto L29;
    L44:
        int r5 = 0;
    L46:
        if (r5 >= T.length) goto L145;
        if (r5 == 4) goto L50;
    L52:
        e r9 = Y[r5].get(r1);
        if (r9 == null) goto L144;
        if (r2 != null) goto L56;
        this.e[r5].remove(r1);
        goto L144
    L56:
        Pair<Integer, Integer> r10 = v(r2);
        int r14 = -1;
        if (r9.c != ((Integer) r10.first).intValue()) goto L59;
    L85:
        int r11 = r9.c;
    L87:
        switch(r11) {
            case 1: goto L134;
            case 2: goto L131;
            case 3: goto L125;
            case 4: goto L120;
            case 5: goto L115;
            case 6: goto L89;
            case 7: goto L131;
            case 8: goto L89;
            case 9: goto L107;
            case 10: goto L99;
            case 11: goto L89;
            case 12: goto L91;
            default: goto L89;
        };
    L91:
        String[] r6 = r2.split(",", -1);
        int r12 = r6.length;
        double[] r13 = new double[r12];
        int r15 = 0;
    L93:
        if (r15 >= r6.length) goto L95;
        r13[r15] = CastDoubleProtector.parseDouble(r6[r15]);
        r15 = r15 + 1;
        goto L93
    L95:
        HashMap<String, d> r16 = this.e[r5];
        ByteOrder r17 = this.g;
        ByteBuffer r18 = ByteBuffer.wrap(new byte[Q[12] * r12]);
        r18.order(r17);
        int r110 = 0;
    L96:
        if (r110 >= r12) goto L98;
        r18.putDouble(r13[r110]);
        r110 = r110 + 1;
        goto L96
    L98:
        r16.put(r1, new d(12, r12, r18.array()));
        goto L144
    L99:
        String[] r21 = r2.split(",", -1);
        int r22 = r21.length;
        f[] r111 = new f[r22];
        int r112 = 0;
    L101:
        if (r112 >= r21.length) goto L103;
        String[] r113 = r21[r112].split("/", r14);
        r111[r112] = new f((long) CastDoubleProtector.parseDouble(r113[0]), (long) CastDoubleProtector.parseDouble(r113[r8]));
        r112 = r112 + 1;
        r22 = r22;
        r8 = 1;
        r14 = -1;
        goto L101
    L103:
        int r114 = r22;
        HashMap<String, d> r23 = this.e[r5];
        ByteOrder r24 = this.g;
        ByteBuffer r25 = ByteBuffer.wrap(new byte[Q[10] * r114]);
        r25.order(r24);
        int r115 = 0;
    L104:
        if (r115 >= r114) goto L106;
        f r116 = r111[r115];
        r25.putInt((int) r116.a);
        r25.putInt((int) r116.b);
        r115 = r115 + 1;
        goto L104
    L106:
        r23.put(r1, new d(10, r114, r25.array()));
        goto L144
    L107:
        String[] r26 = r2.split(",", -1);
        int r27 = r26.length;
        int[] r28 = new int[r27];
        int r117 = 0;
    L109:
        if (r117 >= r26.length) goto L111;
        r28[r117] = CastIntegerProtector.parseInt(r26[r117]);
        r117 = r117 + 1;
        goto L109
    L111:
        HashMap<String, d> r29 = this.e[r5];
        ByteOrder r118 = this.g;
        ByteBuffer r119 = ByteBuffer.wrap(new byte[Q[9] * r27]);
        r119.order(r118);
        int r120 = 0;
    L112:
        if (r120 >= r27) goto L114;
        r119.putInt(r28[r120]);
        r120 = r120 + 1;
        goto L112
    L114:
        r29.put(r1, new d(9, r27, r119.array()));
        goto L144
    L115:
        int r30 = -1;
        String[] r31 = r2.split(",", -1);
        f[] r32 = new f[r31.length];
        int r121 = 0;
    L117:
        if (r121 >= r31.length) goto L119;
        String[] r122 = r31[r121].split("/", r30);
        r32[r121] = new f((long) CastDoubleProtector.parseDouble(r122[0]), (long) CastDoubleProtector.parseDouble(r122[1]));
        r121 = r121 + 1;
        r30 = -1;
        goto L117
    L119:
        this.e[r5].put(r1, d.d(r32, this.g));
        goto L144
    L120:
        String[] r33 = r2.split(",", -1);
        long[] r34 = new long[r33.length];
        int r35 = 0;
    L122:
        if (r35 >= r33.length) goto L124;
        r34[r35] = CastLongProtector.parseLong(r33[r35]);
        r35 = r35 + 1;
        goto L122
    L124:
        this.e[r5].put(r1, d.c(r34, this.g));
        goto L144
    L125:
        String[] r36 = r2.split(",", -1);
        int[] r37 = new int[r36.length];
        int r38 = 0;
    L127:
        if (r38 >= r36.length) goto L129;
        r37[r38] = CastIntegerProtector.parseInt(r36[r38]);
        r38 = r38 + 1;
        goto L127
    L129:
        this.e[r5].put(r1, d.f(r37, this.g));
        goto L144
    L134:
        HashMap<String, d> r39 = this.e[r5];
        if (r2.length() == 1) goto L137;
    L141:
        byte[] r40 = r2.getBytes(b0);
        d r41 = new d(1, r40.length, r40);
    L142:
        r39.put(r1, r41);
        goto L144
    L137:
        if (r2.charAt(0) < '0') goto L141;
        if (r2.charAt(0) > '1') goto L141;
        r41 = new d(1, 1, new byte[]{(byte) (r2.charAt(0) - '0')});
        goto L142
    L89:
        if (r == false) goto L144;
        FLogger.a.d("ExifInterface", "Data format isn't one of expected formats: " + r11);
        goto L144
    L131:
        if (r1.equals("UserComment") == false) goto L133;
        HashMap<String, d> r42 = this.e[r5];
        byte[] r43 = r2.concat("\u0000").getBytes(b0);
        byte[] r44 = R;
        int r123 = r44.length + r43.length;
        byte[] r124 = new byte[r123];
        System.arraycopy(r44, 0, r124, 0, r44.length);
        System.arraycopy(r43, 0, r124, r44.length, r43.length);
        r42.put(r1, new d(7, r123, r124));
        goto L144
    L133:
        this.e[r5].put(r1, d.a(r2));
        goto L144
    L59:
        if (r9.c == ((Integer) r10.second).intValue()) goto L85;
        int r125 = r9.d;
        if (r125 != (-1)) goto L64;
    L68:
        int r126 = r9.c;
        if (r126 == r8) goto L84;
        if (r126 == 7) goto L84;
        if (r126 == r4) goto L84;
        if (r == false) goto L144;
        FLogger r127 = FLogger.a;
        StringBuilder r128 = new StringBuilder("Given tag (");
        r128.append(r1);
        r128.append(") value didn't match with one of expected formats: ");
        String[] r129 = P;
        r128.append(r129[r9.c]);
        String r130 = "";
        if (r9.d != (-1)) goto L78;
        String r45 = "";
    L79:
        r128.append(r45);
        r128.append(" (guess: ");
        r128.append(r129[((Integer) r10.first).intValue()]);
        if (((Integer) r10.second).intValue() == (-1)) goto L83;
        r130 = ", " + r129[((Integer) r10.second).intValue()];
    L83:
        r128.append(r130);
        r128.append(")");
        r127.d("ExifInterface", r128.toString());
        goto L144
    L78:
        r45 = ", " + r129[r9.d];
    L84:
        r11 = r126;
        goto L87
    L64:
        if (r125 != ((Integer) r10.first).intValue()) goto L66;
    L67:
        r11 = r9.d;
        goto L87
    L66:
        if (r9.d != ((Integer) r10.second).intValue()) goto L68;
    L144:
        r5 = r5 + 1;
        r4 = 2;
        r8 = 1;
        goto L46
    L50:
        if (this.h == true) goto L52;
    L145:
        return;
    L29:
        if (Z.contains(r1) == false) goto L44;
        if (r1.equals("GPSTimeStamp") == false) goto L148;
        Matcher r46 = d0.matcher(r2);
        if (r46.find() == true) goto L36;
        FLogger.a.w("ExifInterface", "Invalid value for " + r1 + " : " + r2);
        return;
    L36:
        r2 = CastIntegerProtector.parseInt(r46.group(1)) + "/1," + CastIntegerProtector.parseInt(r46.group(2)) + "/1," + CastIntegerProtector.parseInt(r46.group(3)) + "/1";
        goto L44
    L148:
        long r47 = (long) (CastDoubleProtector.parseDouble(r2) * 10000.0d);     // Catch: NumberFormatException -> L42
        long r131 = 10000;
        if (10000 != 0) goto L40;
        r131 = 1;
        r47 = 0;
    L40:
        r2 = r47 + "/" + r131;     // Catch: NumberFormatException -> L42
    L42:
        FLogger.a.w("ExifInterface", "Invalid value for " + r1 + " : " + r2);
        return;
    L23:
        if (r == false) goto L25;
        FLogger.a.d("ExifInterface", "setAttribute: Replacing TAG_ISO_SPEED_RATINGS with TAG_PHOTOGRAPHIC_SENSITIVITY.");
    L25:
        r1 = "PhotographicSensitivity";
        goto L26
    L7:
        if ("DateTimeOriginal".equals(r1) == true) goto L10;
        if ("DateTimeDigitized".equals(r1) == false) goto L21;
    L147:
        throw new NullPointerException("tag shouldn't be null");
    }

    public final void M(int r7, int r8) throws IOException {
        if (this.e[r7].isEmpty() == true) goto L26;
        if (this.e[r8].isEmpty() == true) goto L26;
        d r0 = this.e[r7].get("ImageLength");
        d r3 = this.e[r7].get("ImageWidth");
        d r2 = this.e[r8].get("ImageLength");
        d r4 = this.e[r8].get("ImageWidth");
        if (r0 == null) goto L22;
        if (r3 == null) goto L22;
        if (r2 == null) goto L19;
        if (r4 == null) goto L19;
        int r1 = r0.h(this.g);
        int r5 = r3.h(this.g);
        int r6 = r2.h(this.g);
        int r9 = r4.h(this.g);
        if (r1 >= r6) goto L29;
        if (r5 >= r9) goto L30;
        HashMap<String, d>[] r10 = this.e;
        HashMap<String, d> r11 = r10[r7];
        r10[r7] = r10[r8];
        r10[r8] = r11;
        return;
    L30:
        return;
    L29:
        return;
    L19:
        if (r == false) goto L32;
        FLogger.a.d("ExifInterface", "Second image does not contain valid size information");
        return;
    L32:
        return;
    L22:
        if (r == false) goto L34;
        FLogger.a.d("ExifInterface", "First image does not contain valid size information");
        return;
    L34:
        return;
    L26:
        if (r == false) goto L35;
        FLogger.a.d("ExifInterface", "Cannot perform swap since only one image data exists");
        return;
    }

    public final void N(b r10, int r11) throws IOException {
        d r0 = this.e[r11].get("DefaultCropSize");
        d r1 = this.e[r11].get("SensorTopBorder");
        d r2 = this.e[r11].get("SensorLeftBorder");
        d r3 = this.e[r11].get("SensorBottomBorder");
        d r4 = this.e[r11].get("SensorRightBorder");
        if (r0 != null) goto L5;
        if (r1 == null) goto L31;
        if (r2 == null) goto L31;
        if (r3 == null) goto L31;
        if (r4 == null) goto L31;
        int r12 = r1.h(this.g);
        int r5 = r3.h(this.g);
        int r6 = r4.h(this.g);
        int r7 = r2.h(this.g);
        if (r5 <= r12) goto L40;
        if (r6 <= r7) goto L41;
        d r13 = d.e(r5 - r12, this.g);
        d r8 = d.e(r6 - r7, this.g);
        this.e[r11].put("ImageLength", r13);
        this.e[r11].put("ImageWidth", r8);
        return;
    L41:
        return;
    L40:
        return;
    L31:
        d r9 = this.e[r11].get("ImageLength");
        d r14 = this.e[r11].get("ImageWidth");
        if (r9 == null) goto L34;
        if (r14 == null) goto L34;
        return;
    L34:
        d r15 = this.e[r11].get("JPEGInterchangeFormat");
        d r16 = this.e[r11].get("JPEGInterchangeFormatLength");
        if (r15 == null) goto L44;
        if (r16 == null) goto L45;
        int r17 = r15.h(this.g);
        int r18 = r15.h(this.g);
        r10.a(r17);
        byte[] r19 = new byte[r18];
        r10.read(r19);
        m(new b(r19), r17, r11);
        return;
    L45:
        return;
    L44:
        return;
    L5:
        if (r0.a != 5) goto L14;
        f[] r110 = (f[]) r0.j(this.g);
        if (r110 != null) goto L9;
    L12:
        FLogger.a.w("ExifInterface", "Invalid crop size values. cropSize=" + Arrays.toString(r110));
        return;
    L9:
        if (r110.length != 2) goto L12;
        d r20 = d.d(new f[]{r110[0]}, this.g);
        d r111 = d.d(new f[]{r110[1]}, this.g);
    L20:
        this.e[r11].put("ImageWidth", r20);
        this.e[r11].put("ImageLength", r111);
        return;
    L14:
        int[] r112 = (int[]) r0.j(this.g);
        if (r112 != null) goto L17;
    L21:
        FLogger.a.w("ExifInterface", "Invalid crop size values. cropSize=" + Arrays.toString(r112));
        return;
    L17:
        if (r112.length != 2) goto L21;
        r20 = d.e(r112[0], this.g);
        r111 = d.e(r112[1], this.g);
        goto L20
    }

    public final void w(b r5, HashMap r6) throws IOException {
        d r0 = (d) r6.get("JPEGInterchangeFormat");
        d r7 = (d) r6.get("JPEGInterchangeFormatLength");
        if (r0 == null) goto L23;
        if (r7 == null) goto L24;
        int r1 = r0.h(this.g);
        int r8 = r7.h(this.g);
        if (this.d != 7) goto L8;
        r1 = r1 + this.o;
    L8:
        int r9 = Math.min(r8, r5.c - r1);
        if (r1 <= 0) goto L20;
        if (r9 <= 0) goto L20;
        this.h = true;
        if (this.a == null) goto L14;
    L18:
        this.j = r1;
        this.k = r9;
        goto L20
    L14:
        if (this.c != null) goto L18;
        if (this.b != null) goto L18;
        byte[] r2 = new byte[r9];
        r5.skip(r1);
        r5.read(r2);
        this.l = r2;
    L20:
        if (r == false) goto L25;
        FLogger.a.d("ExifInterface", "Setting thumbnail attributes with offset: " + r1 + ", length: " + r9);
        return;
    L25:
        return;
    L24:
        return;
    }

    public static void h(InputStream r5, OutputStream r6, int r7) throws IOException {
        byte[] r1 = new byte[8192];
    L3:
        if (r7 <= 0) goto L9;
        int r2 = Math.min(r7, 8192);
        int r4 = r5.read(r1, 0, r2);
        if (r4 != r2) goto L8;
        r7 = r7 - r4;
        r6.write(r1, 0, r4);
        goto L3
    L8:
        throw new IOException("Failed to copy the given amount of bytes from the inputstream to the output stream.");
    }

    public final void m(b r17, int r18, int r19) throws IOException {
        if (r == false) goto L5;
        FLogger.a.d("ExifInterface", "getJpegAttributes starting with: " + r17);
    L5:
        r17.mark(0);
        r17.b = ByteOrder.BIG_ENDIAN;
        byte r5 = r17.readByte();
        if (r5 != (-1)) goto L80;
        if (r17.readByte() != (-40)) goto L78;
        int r6 = 2;
    L10:
        byte r8 = r17.readByte();
        if (r8 != (-1)) goto L76;
        boolean r9 = true;
        int r7 = r6 + 1;
        byte r10 = r17.readByte();
        boolean r11 = r;
        if (r11 == false) goto L15;
        FLogger.a.d("ExifInterface", "Found JPEG segment indicator: " + Integer.toHexString(r10 & 255));
    L15:
        int r12 = r7 + 1;
        if (r10 == (-39)) goto L73;
        if (r10 == (-38)) goto L73;
        int r13 = r17.readUnsignedShort() - 2;
        int r14 = r12 + 2;
        if (r11 == false) goto L24;
        FLogger.a.d("ExifInterface", "JPEG segment: " + Integer.toHexString(r10 & 255) + " (length: " + (r13 + 2) + ")");
    L24:
        if (r13 < 0) goto L72;
        if (r10 != (-31)) goto L28;
        byte[] r15 = new byte[r13];
        r17.readFully(r15);
        int r16 = r14 + r13;
        byte[] r110 = c0;
        if (r110 != null) goto L50;
    L57:
        r9 = false;
    L59:
        if (r9 == false) goto L61;
        byte[] r3 = c0;
        byte[] r20 = Arrays.copyOfRange(r15, r3.length, r13);
        this.n = (r18 + r14) + r3.length;
        D(r20, r19);
        L(new b(r20));
    L61:
        r14 = r16;
    L62:
        r13 = 0;
    L63:
        if (r13 < 0) goto L70;
        if (r17.skipBytes(r13) != r13) goto L68;
        r6 = r14 + r13;
        goto L10
    L68:
        throw new IOException("Invalid JPEG segment");
    L70:
        throw new IOException("Invalid length");
    L50:
        if (r13 < r110.length) goto L57;
        int r111 = 0;
    L54:
        if (r111 >= r110.length) goto L59;
        if (r15[r111] != r110[r111]) goto L57;
        r111 = r111 + 1;
        goto L54
    L28:
        if (r10 == (-2)) goto L39;
        switch(r10) {
            case -64: goto L35;
            case -63: goto L35;
            case -62: goto L35;
            case -61: goto L35;
            default: goto L30;
        };
    L30:
        switch(r10) {
            case -59: goto L35;
            case -58: goto L35;
            case -57: goto L35;
            default: goto L31;
        };
    L31:
        switch(r10) {
            case -55: goto L35;
            case -54: goto L35;
            case -53: goto L35;
            default: goto L32;
        };
    L32:
        switch(r10) {
            case -51: goto L35;
            case -50: goto L35;
            case -49: goto L35;
            default: goto L63;
        };
    L35:
        if (r17.skipBytes(1) != 1) goto L38;
        this.e[r19].put("ImageLength", d.b(r17.readUnsignedShort(), this.g));
        this.e[r19].put("ImageWidth", d.b(r17.readUnsignedShort(), this.g));
        r13 = r13 - 5;
        goto L63
    L38:
        throw new IOException("Invalid SOFx");
    L39:
        byte[] r21 = new byte[r13];
        if (r17.read(r21) != r13) goto L45;
        if (j("UserComment") != null) goto L62;
        this.e[1].put("UserComment", d.a(new String(r21, b0)));
        goto L62
    L45:
        throw new IOException("Invalid exif");
    L72:
        throw new IOException("Invalid length");
    L73:
        r17.b = this.g;
        return;
    L76:
        throw new IOException("Invalid marker:" + Integer.toHexString(r8 & 255));
    L78:
        throw new IOException("Invalid marker: " + Integer.toHexString(r5 & 255));
    L80:
        throw new IOException("Invalid marker: " + Integer.toHexString(r5 & 255));
    }

    public static void i(b r4, c r5, byte[] r6, byte[] r7) throws IOException {
    L2:
        byte[] r1 = new byte[4];
        if (r4.read(r1) != 4) goto L4;
        int r0 = r4.readInt();
        r5.write(r1);
        r5.b(r0);
        if ((r0 % 2) != 1) goto L13;
        r0 = r0 + 1;
    L13:
        h(r4, r5, r0);
        if (Arrays.equals(r1, r6) == true) goto L18;
        if (r7 == null) goto L2;
        if (Arrays.equals(r1, r7) == false) goto L2;
        return;
    L18:
        return;
    L4:
        StringBuilder r8 = new StringBuilder("Encountered invalid length while copying WebP chunks up tochunk type ");
        Charset r2 = b0;
        r8.append(new String(r6, r2));
        if (r7 != null) goto L7;
        String r9 = "";
    L8:
        r8.append(r9);
        throw new IOException(r8.toString());
    L7:
        r9 = " or ".concat(new String(r7, r2));
        goto L8
    }
}
