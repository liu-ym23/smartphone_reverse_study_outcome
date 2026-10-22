package okio;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.work.WorkRequest;
import com.ttnet.org.chromium.base.TimeUtils;
import java.io.Closeable;
import java.io.EOFException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import kotlin.text.Typography;
import org.msgpack.core.MessagePack;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nBuffer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Buffer.kt\nokio/Buffer\n+ 2 Util.kt\nokio/-SegmentedByteString\n+ 3 Buffer.kt\nokio/internal/-Buffer\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,641:1\n89#2:642\n86#2:675\n86#2:677\n74#2:737\n74#2:763\n83#2:802\n77#2:813\n89#2:1003\n74#2:1018\n86#2:1122\n89#2:1615\n244#3,32:643\n279#3,10:678\n292#3,18:688\n414#3,2:706\n112#3:708\n416#3:709\n114#3,18:710\n313#3,9:728\n322#3,15:738\n340#3,10:753\n350#3,3:764\n348#3,25:767\n376#3,10:792\n386#3:803\n384#3,9:804\n393#3,7:814\n391#3,20:821\n682#3,60:841\n745#3,56:901\n803#3:957\n806#3:958\n807#3,6:960\n817#3,7:966\n827#3,6:973\n835#3,5:979\n867#3,6:984\n877#3:990\n878#3,11:992\n889#3,5:1004\n898#3,9:1009\n908#3,61:1019\n633#3:1080\n636#3:1081\n637#3,5:1083\n644#3:1088\n647#3,7:1089\n656#3,20:1096\n420#3:1116\n423#3,5:1117\n428#3,10:1123\n439#3,7:1133\n444#3,2:1140\n973#3:1142\n974#3,87:1144\n1064#3,48:1231\n603#3:1279\n610#3,21:1280\n1115#3,7:1301\n1125#3,7:1308\n1135#3,4:1315\n1142#3,8:1319\n1153#3,10:1327\n1166#3,14:1337\n449#3,91:1351\n543#3,40:1442\n586#3:1482\n588#3,13:1484\n1183#3:1497\n1234#3:1498\n1235#3,39:1500\n1276#3,2:1539\n1278#3,4:1542\n1285#3,3:1546\n1289#3,4:1550\n112#3:1554\n1293#3,22:1555\n114#3,18:1577\n1319#3,2:1595\n1321#3,3:1598\n112#3:1601\n1324#3,13:1602\n1337#3,13:1616\n114#3,18:1629\n1354#3,2:1647\n1357#3:1650\n112#3:1651\n1358#3,50:1652\n114#3,18:1702\n1417#3,14:1720\n1434#3,32:1734\n1469#3,12:1766\n1484#3,18:1778\n1506#3:1796\n1507#3:1798\n1512#3,34:1799\n1#4:676\n1#4:959\n1#4:991\n1#4:1082\n1#4:1143\n1#4:1483\n1#4:1499\n1#4:1541\n1#4:1549\n1#4:1597\n1#4:1649\n1#4:1797\n*S KotlinDebug\n*F\n+ 1 Buffer.kt\nokio/Buffer\n*L\n167#1:642\n197#1:675\n235#1:677\n261#1:737\n264#1:763\n267#1:802\n267#1:813\n335#1:1003\n338#1:1018\n374#1:1122\n483#1:1615\n181#1:643,32\n252#1:678,10\n255#1:688,18\n258#1:706,2\n258#1:708\n258#1:709\n258#1:710,18\n261#1:728,9\n261#1:738,15\n264#1:753,10\n264#1:764,3\n264#1:767,25\n267#1:792,10\n267#1:803\n267#1:804,9\n267#1:814,7\n267#1:821,20\n279#1:841,60\n282#1:901,56\n284#1:957\n287#1:958\n287#1:960,6\n289#1:966,7\n292#1:973,6\n295#1:979,5\n329#1:984,6\n335#1:990\n335#1:992,11\n335#1:1004,5\n338#1:1009,9\n338#1:1019,61\n340#1:1080\n343#1:1081\n343#1:1083,5\n345#1:1088\n348#1:1089,7\n351#1:1096,20\n371#1:1116\n374#1:1117,5\n374#1:1123,10\n376#1:1133,7\n379#1:1140,2\n384#1:1142\n384#1:1144,87\n387#1:1231,48\n410#1:1279\n416#1:1280,21\n437#1:1301,7\n441#1:1308,7\n443#1:1315,4\n445#1:1319,8\n449#1:1327,10\n453#1:1337,14\n457#1:1351,91\n460#1:1442,40\n463#1:1482\n463#1:1484,13\n465#1:1497\n465#1:1498\n465#1:1500,39\n467#1:1539,2\n467#1:1542,4\n477#1:1546,3\n477#1:1550,4\n477#1:1554\n477#1:1555,22\n477#1:1577,18\n483#1:1595,2\n483#1:1598,3\n483#1:1601\n483#1:1602,13\n483#1:1616,13\n483#1:1629,18\n488#1:1647,2\n488#1:1650\n488#1:1651\n488#1:1652,50\n488#1:1702,18\n498#1:1720,14\n568#1:1734,32\n570#1:1766,12\n578#1:1778,18\n586#1:1796\n586#1:1798\n588#1:1799,34\n287#1:959\n335#1:991\n343#1:1082\n384#1:1143\n463#1:1483\n465#1:1499\n467#1:1541\n477#1:1549\n483#1:1597\n488#1:1649\n586#1:1797\n*E\n"})
public final class d implements f, e, Cloneable, ByteChannel {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @JvmField
    public b0 f12197c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f12198g;

    @SourceDebugExtension({"SMAP\nBuffer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Buffer.kt\nokio/Buffer$UnsafeCursor\n+ 2 Buffer.kt\nokio/internal/-Buffer\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Util.kt\nokio/-SegmentedByteString\n*L\n1#1,641:1\n1567#2:642\n1568#2:644\n1572#2:645\n1573#2,68:647\n1644#2:715\n1645#2,32:717\n1677#2,18:750\n1698#2:768\n1699#2,18:770\n1721#2:788\n1723#2,7:790\n1#3:643\n1#3:646\n1#3:716\n1#3:769\n1#3:789\n86#4:749\n*S KotlinDebug\n*F\n+ 1 Buffer.kt\nokio/Buffer$UnsafeCursor\n*L\n628#1:642\n628#1:644\n630#1:645\n630#1:647,68\n632#1:715\n632#1:717,32\n632#1:750,18\n634#1:768\n634#1:770,18\n637#1:788\n637#1:790,7\n628#1:643\n630#1:646\n632#1:716\n634#1:769\n637#1:789\n632#1:749\n*E\n"})
    public static final class a implements Closeable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @JvmField
        public d f12199c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private b0 f12200g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @JvmField
        public long f12201h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @JvmField
        public byte[] f12202i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        @JvmField
        public int f12203j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        @JvmField
        public int f12204k;

        public a() {
            this.f12201h = -1;
            this.f12203j = -1;
            this.f12204k = -1;
        }

        public final void a(b0 r10) {
            this.f12200g = r10;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f12199c == null) goto L5;
            boolean r10 = true;
        L6:
            if (r10 == false) goto L10;
            this.f12199c = null;
            a(null);
            this.f12201h = -1;
            this.f12202i = null;
            this.f12203j = -1;
            this.f12204k = -1;
            return;
        L10:
            throw new IllegalStateException("not attached to a buffer".toString());
        L5:
            r10 = false;
            goto L6
        }
    }

    @SourceDebugExtension({"SMAP\nBuffer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Buffer.kt\nokio/Buffer$inputStream$1\n+ 2 Util.kt\nokio/-SegmentedByteString\n*L\n1#1,641:1\n74#2:642\n86#2:643\n*S KotlinDebug\n*F\n+ 1 Buffer.kt\nokio/Buffer$inputStream$1\n*L\n126#1:642\n136#1:643\n*E\n"})
    public static final class b extends InputStream {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ d f12205c;

        b(d r10) {
            this.f12205c = r10;
        }

        @Override // java.io.InputStream
        public int available() {
            return (int) Math.min(this.f12205c.M(), Integer.MAX_VALUE);
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.InputStream
        public int read() {
            if (this.f12205c.M() > 0) goto L7;
            return -1;
        L7:
            return this.f12205c.readByte() & 255;
        }

        @Override // java.io.InputStream
        public int read(byte[] r10, int r11, int r12) {
            Intrinsics.checkNotNullParameter(r10, "sink");
            return this.f12205c.read(r10, r11, r12);
        }

        public String toString() {
            return this.f12205c + ".inputStream()";
        }
    }

    public static final class c extends OutputStream {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ d f12206c;

        c(d r10) {
            this.f12206c = r10;
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() {
        }

        public String toString() {
            return this.f12206c + ".outputStream()";
        }

        @Override // java.io.OutputStream
        public void write(int r10) {
            this.f12206c.c0(r10);
        }

        @Override // java.io.OutputStream
        public void write(byte[] r10, int r11, int r12) {
            Intrinsics.checkNotNullParameter(r10, "data");
            this.f12206c.a0(r10, r11, r12);
        }
    }

    public d() {
    }

    public boolean A(long r10, ByteString r11) {
        Intrinsics.checkNotNullParameter(r11, "bytes");
        return B(r10, r11, 0, r11.size());
    }

    public boolean B(long r10, ByteString r11, int r12, int r13) {
        Intrinsics.checkNotNullParameter(r11, "bytes");
        if (r10 < 0) goto L21;
        if (r12 < 0) goto L22;
        if (r13 >= 0) goto L7;
        return false;
    L7:
        if ((M() - r10) >= r13) goto L9;
        return false;
    L9:
        if ((r11.size() - r12) < r13) goto L25;
        int r14 = 0;
    L12:
        if (r14 >= r13) goto L17;
        if (r(((long) r14) + r10) != r11.getByte(r12 + r14)) goto L26;
        r14 = r14 + 1;
        goto L12
    L26:
        return false;
    L17:
        return true;
    L25:
        return false;
    L22:
        return false;
    L21:
        return false;
    }

    public byte[] C() {
        return L(M());
    }

    public ByteString D() {
        return g(M());
    }

    @Override // okio.f
    public String E() {
        return q(Long.MAX_VALUE);
    }

    public void F(byte[] r10) {
        Intrinsics.checkNotNullParameter(r10, "sink");
        int r11 = 0;
    L4:
        if (r11 >= r10.length) goto L10;
        int r12 = read(r10, r11, r10.length - r11);
        if (r12 == (-1)) goto L9;
        r11 = r11 + r12;
        goto L4
    L9:
        throw new EOFException();
    }

    public long G() {
        if (M() < 8) goto L14;
        b0 r10 = this.f12197c;
        Intrinsics.checkNotNull(r10);
        int r11 = r10.f12173b;
        int r12 = r10.f12174c;
        if ((r12 - r11) < 8) goto L15;
        byte[] r13 = r10.f12172a;
        int r14 = r11 + 1;
        long r15 = (((long) r13[r11]) & 255) << 56;
        int r16 = r14 + 1;
        int r17 = r16 + 1;
        long r18 = (r15 | ((((long) r13[r14]) & 255) << 48)) | ((((long) r13[r16]) & 255) << 40);
        int r19 = r17 + 1;
        int r20 = r19 + 1;
        long r21 = (r18 | ((((long) r13[r17]) & 255) << 32)) | ((((long) r13[r19]) & 255) << 24);
        int r22 = r20 + 1;
        long r23 = r21 | ((((long) r13[r20]) & 255) << 16);
        int r24 = r22 + 1;
        long r25 = r23 | ((((long) r13[r22]) & 255) << 8);
        int r26 = r24 + 1;
        long r27 = r25 | (((long) r13[r24]) & 255);
        K(M() - 8);
        if (r26 != r12) goto L10;
        this.f12197c = r10.b();
        c0.b(r10);
    L12:
        return r27;
    L10:
        r10.f12173b = r26;
        goto L12
    L15:
        return ((((long) readInt()) & 4294967295L) << 32) | (4294967295L & ((long) readInt()));
    L14:
        throw new EOFException();
    }

    @Override // okio.f
    public int H() {
        return okio.b.f(readInt());
    }

    public String I(long r10, Charset r11) {
        Intrinsics.checkNotNullParameter(r11, "charset");
        if (r10 >= 0) goto L5;
    L7:
        boolean r12 = false;
    L8:
        if (r12 == false) goto L25;
        if (this.f12198g < r10) goto L23;
        if (r10 != 0) goto L14;
        return "";
    L14:
        b0 r13 = this.f12197c;
        Intrinsics.checkNotNull(r13);
        int r14 = r13.f12173b;
        if ((((long) r14) + r10) > r13.f12174c) goto L17;
        int r15 = (int) r10;
        String r16 = new String(r13.f12172a, r14, r15, r11);
        int r17 = r13.f12173b + r15;
        r13.f12173b = r17;
        this.f12198g -= r10;
        if (r17 != r13.f12174c) goto L21;
        this.f12197c = r13.b();
        c0.b(r13);
    L21:
        return r16;
    L17:
        return new String(L(r10), r11);
    L23:
        throw new EOFException();
    L25:
        throw new IllegalArgumentException(("byteCount: " + r10).toString());
    L5:
        if (r10 > 2147483647L) goto L7;
        r12 = true;
        goto L8
    }

    public String J() {
        return I(this.f12198g, Charsets.UTF_8);
    }

    public final void K(long r10) {
        this.f12198g = r10;
    }

    @Override // okio.f
    public byte[] L(long r10) {
        if (r10 >= 0) goto L5;
    L7:
        boolean r11 = false;
    L8:
        if (r11 == false) goto L16;
        if (M() < r10) goto L14;
        byte[] r12 = new byte[(int) r10];
        F(r12);
        return r12;
    L14:
        throw new EOFException();
    L16:
        throw new IllegalArgumentException(("byteCount: " + r10).toString());
    L5:
        if (r10 > 2147483647L) goto L7;
        r11 = true;
        goto L8
    }

    @JvmName(name = "size")
    public final long M() {
        return this.f12198g;
    }

    public final ByteString N() {
        if (M() > 2147483647L) goto L5;
        boolean r10 = true;
    L6:
        if (r10 == false) goto L10;
        return P((int) M());
    L10:
        throw new IllegalStateException(("size > Int.MAX_VALUE: " + M()).toString());
    L5:
        r10 = false;
        goto L6
    }

    @Override // okio.e
    public /* bridge */ /* synthetic */ e O(ByteString r10) {
        return V(r10);
    }

    public final ByteString P(int r10) {
        if (r10 == 0) goto L19;
        okio.b.b(M(), 0, r10);
        b0 r11 = this.f12197c;
        int r12 = 0;
        int r13 = 0;
        int r14 = 0;
    L5:
        if (r13 >= r10) goto L11;
        Intrinsics.checkNotNull(r11);
        int r15 = r11.f12174c;
        int r16 = r11.f12173b;
        if (r15 == r16) goto L10;
        r13 = r13 + (r15 - r16);
        r14 = r14 + 1;
        r11 = r11.f12177f;
        goto L5
    L10:
        throw new AssertionError("s.limit == s.pos");
    L11:
        byte[][] r17 = new byte[r14][];
        int[] r18 = new int[r14 * 2];
        b0 r19 = this.f12197c;
        int r20 = 0;
    L12:
        if (r12 >= r10) goto L15;
        Intrinsics.checkNotNull(r19);
        r17[r20] = r19.f12172a;
        r12 = r12 + (r19.f12174c - r19.f12173b);
        r18[r20] = Math.min(r12, r10);
        r18[r20 + r14] = r19.f12173b;
        r19.f12175d = true;
        r20 = r20 + 1;
        r19 = r19.f12177f;
        goto L12
    L15:
        return new SegmentedByteString(r17, r18);
    L19:
        return ByteString.EMPTY;
    }

    public final b0 Q(int r10) {
        boolean r11 = true;
        if (r10 < 1) goto L6;
        if (r10 > 8192) goto L6;
    L7:
        if (r11 == false) goto L19;
        b0 r12 = this.f12197c;
        if (r12 != null) goto L11;
        b0 r13 = c0.c();
        this.f12197c = r13;
        r13.f12178g = r13;
        r13.f12177f = r13;
        return r13;
    L11:
        Intrinsics.checkNotNull(r12);
        b0 r14 = r12.f12178g;
        Intrinsics.checkNotNull(r14);
        if ((r14.f12174c + r10) <= 8192) goto L14;
    L15:
        r14 = r14.c(c0.c());
    L17:
        return r14;
    L14:
        if (r14.f12176e == true) goto L17;
    L19:
        throw new IllegalArgumentException("unexpected capacity".toString());
    L6:
        r11 = false;
        goto L7
    }

    @Override // okio.f
    public short R() {
        return okio.b.h(readShort());
    }

    @Override // okio.f0
    public long S(d r10, long r11) {
        Intrinsics.checkNotNullParameter(r10, "sink");
        if (r11 < 0) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L16;
        if (M() != 0) goto L11;
        return -1;
    L11:
        if (r11 <= M()) goto L13;
        r11 = M();
    L13:
        r10.x(this, r11);
        return r11;
    L16:
        throw new IllegalArgumentException(("byteCount < 0: " + r11).toString());
    L5:
        r12 = false;
        goto L6
    }

    @Override // okio.f
    public long T() {
        return okio.b.g(G());
    }

    @Override // okio.f
    public void U(long r10) {
        if (this.f12198g < r10) goto L6;
        return;
    L6:
        throw new EOFException();
    }

    public d V(ByteString r10) {
        Intrinsics.checkNotNullParameter(r10, "byteString");
        r10.write$okio(this, 0, r10.size());
        return this;
    }

    @Override // okio.e
    public /* bridge */ /* synthetic */ e W(long r10) {
        return d0(r10);
    }

    public d X(byte[] r10) {
        Intrinsics.checkNotNullParameter(r10, "source");
        return a0(r10, 0, r10.length);
    }

    @Override // okio.e
    public OutputStream Y() {
        return new c(this);
    }

    @Override // okio.f
    public long Z() {
        if (M() == 0) goto L41;
        int r10 = 0;
        boolean r11 = false;
        long r12 = 0;
    L5:
        b0 r13 = this.f12197c;
        Intrinsics.checkNotNull(r13);
        byte[] r14 = r13.f12172a;
        int r15 = r13.f12173b;
        int r16 = r13.f12174c;
    L6:
        if (r15 >= r16) goto L32;
        byte r17 = r14[r15];
        if (r17 < 48) goto L13;
        if (r17 > 57) goto L13;
        int r18 = r17 + MessagePack.Code.INT8;
    L24:
        if (((-1152921504606846976L) & r12) != 0) goto L27;
        r12 = (r12 << 4) | ((long) r18);
        r15 = r15 + 1;
        r10 = r10 + 1;
        goto L6
    L27:
        throw new NumberFormatException("Number too large: " + new d().e0(r12).c0(r17).J());
    L13:
        if (r17 < 97) goto L19;
        if (r17 > 102) goto L19;
        int r19 = r17 - 97;
    L17:
        r18 = r19 + 10;
    L19:
        if (r17 < 65) goto L28;
        if (r17 > 70) goto L28;
        r19 = r17 - 65;
    L28:
        if (r10 == 0) goto L31;
        r11 = true;
        goto L32
    L31:
        throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x" + okio.b.i(r17));
    L32:
        if (r15 != r16) goto L34;
        this.f12197c = r13.b();
        c0.b(r13);
    L35:
        if (r11 == true) goto L38;
        if (this.f12197c != null) goto L5;
    L38:
        K(M() - ((long) r10));
        return r12;
    L34:
        r13.f12173b = r15;
        goto L35
    L41:
        throw new EOFException();
    }

    public d a0(byte[] r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "source");
        long r13 = r12;
        okio.b.b(r10.length, r11, r13);
        int r14 = r12 + r11;
    L3:
        if (r11 >= r14) goto L5;
        b0 r15 = Q(1);
        int r16 = Math.min(r14 - r11, 8192 - r15.f12174c);
        int r17 = r11 + r16;
        ArraysKt.copyInto(r10, r15.f12172a, r15.f12174c, r11, r17);
        r15.f12174c += r16;
        r11 = r17;
        goto L3
    L5:
        K(M() + r13);
        return this;
    }

    @Override // okio.f
    public d b() {
        return this;
    }

    @Override // okio.f
    public int b0(w r10) {
        Intrinsics.checkNotNullParameter(r10, "options");
        int r11 = okio.internal.a.d(this, r10, false, 2, null);
        if (r11 == (-1)) goto L7;
        skip(r10.c()[r11].size());
        return r11;
    L7:
        return -1;
    }

    public d c0(int r10) {
        b0 r11 = Q(1);
        byte[] r12 = r11.f12172a;
        int r13 = r11.f12174c;
        r11.f12174c = r13 + 1;
        r12[r13] = (byte) r10;
        K(M() + 1);
        return this;
    }

    public /* bridge */ /* synthetic */ Object clone() {
        return i();
    }

    @Override // okio.f0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // okio.f
    public InputStream d() {
        return new b(this);
    }

    public d d0(long r13) {
        if (r13 == 0) goto L77;
        boolean r10 = false;
        int r11 = 1;
        if (r13 >= 0) goto L12;
        r13 = -r13;
        if (r13 < 0) goto L78;
        r10 = true;
        goto L12
    L78:
        return l0("-9223372036854775808");
    L12:
        if (r13 >= 100000000) goto L36;
        if (r13 >= WorkRequest.MIN_BACKOFF_MILLIS) goto L26;
        if (r13 >= 100) goto L22;
        if (r13 < 10) goto L66;
        r11 = 2;
    L66:
        if (r10 == false) goto L68;
        r11 = r11 + 1;
    L68:
        b0 r12 = Q(r11);
        byte[] r14 = r12.f12172a;
        int r15 = r12.f12174c + r11;
    L70:
        if (r13 == 0) goto L72;
        long r16 = 10;
        r15 = r15 - 1;
        r14[r15] = okio.internal.a.a()[(int) (r13 % r16)];
        r13 = r13 / r16;
        goto L70
    L72:
        if (r10 == false) goto L74;
        r14[r15 - 1] = 45;
    L74:
        r12.f12174c += r11;
        K(M() + ((long) r11));
        return this;
    L22:
        if (r13 >= 1000) goto L24;
        r11 = 3;
        goto L66
    L24:
        r11 = 4;
        goto L66
    L26:
        if (r13 >= TimeUtils.NANOSECONDS_PER_MILLISECOND) goto L32;
        if (r13 >= 100000) goto L30;
        r11 = 5;
        goto L66
    L30:
        r11 = 6;
        goto L66
    L32:
        if (r13 >= 10000000) goto L34;
        r11 = 7;
        goto L66
    L34:
        r11 = 8;
        goto L66
    L36:
        if (r13 >= 1000000000000L) goto L48;
        if (r13 >= 10000000000L) goto L44;
        if (r13 >= 1000000000) goto L42;
        r11 = 9;
        goto L66
    L42:
        r11 = 10;
        goto L66
    L44:
        if (r13 >= 100000000000L) goto L46;
        r11 = 11;
        goto L66
    L46:
        r11 = 12;
        goto L66
    L48:
        if (r13 >= 1000000000000000L) goto L57;
        if (r13 >= 10000000000000L) goto L53;
        r11 = 13;
        goto L66
    L53:
        if (r13 >= 100000000000000L) goto L55;
        r11 = 14;
        goto L66
    L55:
        r11 = 15;
        goto L66
    L57:
        if (r13 >= 100000000000000000L) goto L63;
        if (r13 >= 10000000000000000L) goto L61;
        r11 = 16;
        goto L66
    L61:
        r11 = 17;
        goto L66
    L63:
        if (r13 >= 1000000000000000000L) goto L65;
        r11 = 18;
        goto L66
    L65:
        r11 = 19;
        goto L66
    L77:
        return c0(48);
    }

    @Override // okio.f
    public String e(long r10) {
        return I(r10, Charsets.UTF_8);
    }

    public d e0(long r13) {
        if (r13 == 0) goto L11;
        long r10 = (r13 >>> 1) | r13;
        long r11 = r10 | (r10 >>> 2);
        long r12 = r11 | (r11 >>> 4);
        long r14 = r12 | (r12 >>> 8);
        long r15 = r14 | (r14 >>> 16);
        long r16 = r15 | (r15 >>> 32);
        long r17 = r16 - ((r16 >>> 1) & 6148914691236517205L);
        long r18 = ((r17 >>> 2) & 3689348814741910323L) + (r17 & 3689348814741910323L);
        long r19 = ((r18 >>> 4) + r18) & 1085102592571150095L;
        long r20 = r19 + (r19 >>> 8);
        long r21 = r20 + (r20 >>> 16);
        int r22 = (int) ((((r21 & 63) + ((r21 >>> 32) & 63)) + ((long) 3)) / ((long) 4));
        b0 r23 = Q(r22);
        byte[] r24 = r23.f12172a;
        int r25 = r23.f12174c;
        int r26 = (r25 + r22) - 1;
    L6:
        if (r26 < r25) goto L8;
        r24[r26] = okio.internal.a.a()[(int) (15 & r13)];
        r13 = r13 >>> 4;
        r26 = r26 - 1;
        goto L6
    L8:
        r23.f12174c += r22;
        K(M() + ((long) r22));
        return this;
    L11:
        return c0(48);
    }

    public boolean equals(Object r21) {
        if (this != r21) goto L6;
    L31:
        return true;
    L6:
        if ((r21 instanceof d) == false) goto L37;
        d r10 = (d) r21;
        if (M() == r10.M()) goto L12;
        return false;
    L12:
        if (M() == 0) goto L31;
        b0 r11 = this.f12197c;
        Intrinsics.checkNotNull(r11);
        b0 r12 = r10.f12197c;
        Intrinsics.checkNotNull(r12);
        int r13 = r11.f12173b;
        int r14 = r12.f12173b;
        long r15 = 0;
    L16:
        if (r15 >= M()) goto L31;
        long r16 = Math.min(r11.f12174c - r13, r12.f12174c - r14);
        long r17 = 0;
    L19:
        if (r17 >= r16) goto L25;
        int r18 = r13 + 1;
        int r19 = r14 + 1;
        if (r11.f12172a[r13] != r12.f12172a[r14]) goto L39;
        r17 = r17 + 1;
        r13 = r18;
        r14 = r19;
        goto L19
    L39:
        return false;
    L25:
        if (r13 != r11.f12174c) goto L28;
        r11 = r11.f12177f;
        Intrinsics.checkNotNull(r11);
        r13 = r11.f12173b;
    L28:
        if (r14 != r12.f12174c) goto L30;
        r12 = r12.f12177f;
        Intrinsics.checkNotNull(r12);
        r14 = r12.f12173b;
    L30:
        r15 = r15 + r16;
        goto L16
    L37:
        return false;
    }

    public final void f() {
        skip(M());
    }

    public d f0(int r10) {
        b0 r11 = Q(4);
        byte[] r12 = r11.f12172a;
        int r13 = r11.f12174c;
        int r14 = r13 + 1;
        r12[r13] = (byte) ((r10 >>> 24) & 255);
        int r15 = r14 + 1;
        r12[r14] = (byte) ((r10 >>> 16) & 255);
        int r16 = r15 + 1;
        r12[r15] = (byte) ((r10 >>> 8) & 255);
        r12[r16] = (byte) (r10 & 255);
        r11.f12174c = r16 + 1;
        K(M() + 4);
        return this;
    }

    @Override // okio.e, okio.d0, java.io.Flushable
    public void flush() {
    }

    @Override // okio.f
    public ByteString g(long r10) {
        if (r10 >= 0) goto L5;
    L7:
        boolean r11 = false;
    L8:
        if (r11 == false) goto L19;
        if (M() < r10) goto L17;
        if (r10 < 4096) goto L15;
        ByteString r12 = P((int) r10);
        skip(r10);
        return r12;
    L15:
        return new ByteString(L(r10));
    L17:
        throw new EOFException();
    L19:
        throw new IllegalArgumentException(("byteCount: " + r10).toString());
    L5:
        if (r10 > 2147483647L) goto L7;
        r11 = true;
        goto L8
    }

    public d g0(int r10) {
        return f0(okio.b.f(r10));
    }

    @Override // okio.e
    public /* bridge */ /* synthetic */ e h() {
        return p();
    }

    public d h0(long r10) {
        b0 r11 = Q(8);
        byte[] r12 = r11.f12172a;
        int r13 = r11.f12174c;
        int r14 = r13 + 1;
        r12[r13] = (byte) ((r10 >>> 56) & 255);
        int r15 = r14 + 1;
        r12[r14] = (byte) ((r10 >>> 48) & 255);
        int r16 = r15 + 1;
        r12[r15] = (byte) ((r10 >>> 40) & 255);
        int r17 = r16 + 1;
        r12[r16] = (byte) ((r10 >>> 32) & 255);
        int r18 = r17 + 1;
        r12[r17] = (byte) ((r10 >>> 24) & 255);
        int r19 = r18 + 1;
        r12[r18] = (byte) ((r10 >>> 16) & 255);
        int r20 = r19 + 1;
        r12[r19] = (byte) ((r10 >>> 8) & 255);
        r12[r20] = (byte) (r10 & 255);
        r11.f12174c = r20 + 1;
        K(M() + 8);
        return this;
    }

    public int hashCode() {
        b0 r10 = this.f12197c;
        if (r10 != null) goto L5;
        return 0;
    L5:
        int r11 = 1;
    L6:
        int r12 = r10.f12173b;
        int r13 = r10.f12174c;
    L7:
        if (r12 >= r13) goto L9;
        r11 = (r11 * 31) + r10.f12172a[r12];
        r12 = r12 + 1;
        goto L7
    L9:
        r10 = r10.f12177f;
        Intrinsics.checkNotNull(r10);
        if (r10 != this.f12197c) goto L6;
        return r11;
    }

    public d i() {
        return l();
    }

    public d i0(long r10) {
        return h0(okio.b.g(r10));
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    @Override // okio.e
    public /* bridge */ /* synthetic */ e j(long r10) {
        return i0(r10);
    }

    public d j0(int r10) {
        b0 r11 = Q(2);
        byte[] r12 = r11.f12172a;
        int r13 = r11.f12174c;
        int r14 = r13 + 1;
        r12[r13] = (byte) ((r10 >>> 8) & 255);
        r12[r14] = (byte) (r10 & 255);
        r11.f12174c = r14 + 1;
        K(M() + 2);
        return this;
    }

    public final long k() {
        long r10 = M();
        if (r10 == 0) goto L12;
        b0 r11 = this.f12197c;
        Intrinsics.checkNotNull(r11);
        b0 r12 = r11.f12178g;
        Intrinsics.checkNotNull(r12);
        int r13 = r12.f12174c;
        if (r13 >= 8192) goto L11;
        if (r12.f12176e == false) goto L11;
        r10 = r10 - ((long) (r13 - r12.f12173b));
    L11:
        return r10;
    L12:
        return 0;
    }

    public d k0(String r10, int r11, int r12, Charset r13) {
        Intrinsics.checkNotNullParameter(r10, TypedValues.Custom.S_STRING);
        Intrinsics.checkNotNullParameter(r13, "charset");
        boolean r14 = true;
        if (r11 < 0) goto L5;
        boolean r15 = true;
    L6:
        if (r15 == false) goto L27;
        if (r12 < r11) goto L9;
        boolean r16 = true;
    L10:
        if (r16 == false) goto L25;
        if (r12 <= r10.length()) goto L15;
        r14 = false;
    L15:
        if (r14 == false) goto L23;
        if (Intrinsics.areEqual(r13, Charsets.UTF_8) == true) goto L19;
        String r17 = r10.substring(r11, r12);
        Intrinsics.checkNotNullExpressionValue(r17, "this as java.lang.String…ing(startIndex, endIndex)");
        byte[] r18 = r17.getBytes(r13);
        Intrinsics.checkNotNullExpressionValue(r18, "this as java.lang.String).getBytes(charset)");
        return a0(r18, 0, r18.length);
    L19:
        return m0(r10, r11, r12);
    L23:
        throw new IllegalArgumentException(("endIndex > string.length: " + r12 + " > " + r10.length()).toString());
    L25:
        throw new IllegalArgumentException(("endIndex < beginIndex: " + r12 + " < " + r11).toString());
    L9:
        r16 = false;
        goto L10
    L27:
        throw new IllegalArgumentException(("beginIndex < 0: " + r11).toString());
    L5:
        r15 = false;
        goto L6
    }

    public final d l() {
        d r10 = new d();
        if (M() == 0) goto L9;
        b0 r11 = this.f12197c;
        Intrinsics.checkNotNull(r11);
        b0 r12 = r11.d();
        r10.f12197c = r12;
        r12.f12178g = r12;
        r12.f12177f = r12;
        b0 r13 = r11.f12177f;
    L6:
        if (r13 == r11) goto L8;
        b0 r14 = r12.f12178g;
        Intrinsics.checkNotNull(r14);
        Intrinsics.checkNotNull(r13);
        r14.c(r13.d());
        r13 = r13.f12177f;
        goto L6
    L8:
        r10.K(M());
    L9:
        return r10;
    }

    public d l0(String r10) {
        Intrinsics.checkNotNullParameter(r10, TypedValues.Custom.S_STRING);
        return m0(r10, 0, r10.length());
    }

    @Override // okio.e
    public /* bridge */ /* synthetic */ e m(int r10) {
        return g0(r10);
    }

    public d m0(String r12, int r13, int r14) {
        Intrinsics.checkNotNullParameter(r12, TypedValues.Custom.S_STRING);
        if (r13 < 0) goto L5;
        boolean r10 = true;
    L6:
        if (r10 == false) goto L58;
        if (r14 < r13) goto L9;
        boolean r11 = true;
    L10:
        if (r11 == false) goto L56;
        if (r14 > r12.length()) goto L14;
        boolean r15 = true;
    L15:
        if (r15 == false) goto L54;
    L16:
        if (r13 >= r14) goto L52;
        char r16 = r12.charAt(r13);
        if (r16 < 128) goto L19;
        if (r16 < 2048) goto L28;
        if (r16 < 55296) goto L51;
        if (r16 > 57343) goto L51;
        int r17 = r13 + 1;
        if (r17 >= r14) goto L38;
        char r18 = r12.charAt(r17);
    L40:
        if (r16 > 56319) goto L50;
        if (56320 <= r18) goto L44;
    L46:
        boolean r19 = false;
    L47:
        if (r19 == false) goto L50;
        int r20 = (((r16 & 1023) << 10) | (r18 & 1023)) + 65536;
        b0 r21 = Q(4);
        byte[] r22 = r21.f12172a;
        int r23 = r21.f12174c;
        r22[r23] = (byte) ((r20 >> 18) | 240);
        r22[r23 + 1] = (byte) (((r20 >> 12) & 63) | 128);
        r22[r23 + 2] = (byte) (((r20 >> 6) & 63) | 128);
        r22[r23 + 3] = (byte) ((r20 & 63) | 128);
        r21.f12174c = r23 + 4;
        K(M() + 4);
        r13 = r13 + 2;
        goto L16
    L44:
        if (r18 >= 57344) goto L46;
        r19 = true;
    L50:
        c0(63);
        r13 = r17;
        goto L16
    L38:
        r18 = 0;
    L51:
        b0 r24 = Q(3);
        byte[] r25 = r24.f12172a;
        int r26 = r24.f12174c;
        r25[r26] = (byte) ((r16 >> '\f') | 224);
        r25[r26 + 1] = (byte) ((63 & (r16 >> 6)) | 128);
        r25[r26 + 2] = (byte) ((r16 & '?') | 128);
        r24.f12174c = r26 + 3;
        long r27 = M();
        long r28 = 3;
    L29:
        K(r27 + r28);
        r13 = r13 + 1;
        goto L16
    L28:
        b0 r29 = Q(2);
        byte[] r30 = r29.f12172a;
        int r31 = r29.f12174c;
        r30[r31] = (byte) ((r16 >> 6) | 192);
        r30[r31 + 1] = (byte) ((r16 & '?') | 128);
        r29.f12174c = r31 + 2;
        r27 = M();
        r28 = 2;
        goto L29
    L19:
        b0 r32 = Q(1);
        byte[] r33 = r32.f12172a;
        int r34 = r32.f12174c - r13;
        int r35 = Math.min(r14, 8192 - r34);
        int r36 = r13 + 1;
        r33[r13 + r34] = (byte) r16;
    L20:
        r13 = r36;
        if (r13 >= r35) goto L25;
        char r37 = r12.charAt(r13);
        if (r37 >= 128) goto L25;
        r36 = r13 + 1;
        r33[r13 + r34] = (byte) r37;
    L25:
        int r38 = r32.f12174c;
        int r39 = (r34 + r13) - r38;
        r32.f12174c = r38 + r39;
        K(M() + ((long) r39));
        goto L16
    L52:
        return this;
    L54:
        throw new IllegalArgumentException(("endIndex > string.length: " + r14 + " > " + r12.length()).toString());
    L14:
        r15 = false;
        goto L15
    L56:
        throw new IllegalArgumentException(("endIndex < beginIndex: " + r14 + " < " + r13).toString());
    L9:
        r11 = false;
        goto L10
    L58:
        throw new IllegalArgumentException(("beginIndex < 0: " + r13).toString());
    L5:
        r10 = false;
        goto L6
    }

    @Override // okio.f
    public boolean n() {
        if (this.f12198g != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public d n0(int r10) {
        if (r10 >= 128) goto L6;
        c0(r10);
    L22:
        return this;
    L6:
        if (r10 >= 2048) goto L9;
        b0 r11 = Q(2);
        byte[] r12 = r11.f12172a;
        int r13 = r11.f12174c;
        r12[r13] = (byte) ((r10 >> 6) | 192);
        r12[r13 + 1] = (byte) ((r10 & 63) | 128);
        r11.f12174c = r13 + 2;
        long r14 = M();
        long r15 = 2;
    L8:
        K(r14 + r15);
        goto L22
    L9:
        boolean r16 = false;
        if (55296 <= r10) goto L12;
    L14:
        if (r16 == false) goto L17;
        c0(63);
        goto L22
    L17:
        if (r10 >= 65536) goto L20;
        b0 r17 = Q(3);
        byte[] r18 = r17.f12172a;
        int r19 = r17.f12174c;
        r18[r19] = (byte) ((r10 >> 12) | 224);
        r18[r19 + 1] = (byte) (((r10 >> 6) & 63) | 128);
        r18[r19 + 2] = (byte) ((r10 & 63) | 128);
        r17.f12174c = r19 + 3;
        r14 = M();
        r15 = 3;
        goto L8
    L20:
        if (r10 > 1114111) goto L24;
        b0 r20 = Q(4);
        byte[] r21 = r20.f12172a;
        int r22 = r20.f12174c;
        r21[r22] = (byte) ((r10 >> 18) | 240);
        r21[r22 + 1] = (byte) (((r10 >> 12) & 63) | 128);
        r21[r22 + 2] = (byte) (((r10 >> 6) & 63) | 128);
        r21[r22 + 3] = (byte) ((r10 & 63) | 128);
        r20.f12174c = r22 + 4;
        r14 = M();
        r15 = 4;
        goto L8
    L24:
        throw new IllegalArgumentException("Unexpected code point: 0x" + okio.b.j(r10));
    L12:
        if (r10 >= 57344) goto L14;
        r16 = true;
        goto L14
    }

    public final d o(d r10, long r11, long r12) {
        Intrinsics.checkNotNullParameter(r10, "out");
        okio.b.b(M(), r11, r12);
        if (r12 == 0) goto L16;
        r10.K(r10.M() + r12);
        b0 r13 = this.f12197c;
    L6:
        Intrinsics.checkNotNull(r13);
        int r14 = r13.f12174c;
        int r15 = r13.f12173b;
        if (r11 < (r14 - r15)) goto L10;
        r11 = r11 - ((long) (r14 - r15));
        r13 = r13.f12177f;
    L10:
        if (r12 <= 0) goto L16;
        Intrinsics.checkNotNull(r13);
        b0 r16 = r13.d();
        int r17 = r16.f12173b + ((int) r11);
        r16.f12173b = r17;
        r16.f12174c = Math.min(r17 + ((int) r12), r16.f12174c);
        b0 r18 = r10.f12197c;
        if (r18 != null) goto L14;
        r16.f12178g = r16;
        r16.f12177f = r16;
        r10.f12197c = r16;
    L15:
        r12 = r12 - ((long) (r16.f12174c - r16.f12173b));
        r13 = r13.f12177f;
        r11 = 0;
        goto L10
    L14:
        Intrinsics.checkNotNull(r18);
        b0 r19 = r18.f12178g;
        Intrinsics.checkNotNull(r19);
        r19.c(r16);
    L16:
        return this;
    }

    public d p() {
        return this;
    }

    @Override // okio.f
    public String q(long r12) {
        if (r12 < 0) goto L5;
        boolean r10 = true;
    L6:
        if (r10 == false) goto L25;
        long r11 = Long.MAX_VALUE;
        if (r12 == Long.MAX_VALUE) goto L11;
        r11 = r12 + 1;
    L11:
        long r13 = s((byte) 10, 0, r11);
        if (r13 == (-1)) goto L15;
        return okio.internal.a.b(this, r13);
    L15:
        if (r11 < M()) goto L17;
    L22:
        d r14 = new d();
        o(r14, 0, Math.min(32, M()));
        throw new EOFException("\\n not found: limit=" + Math.min(M(), r12) + " content=" + r14.D().hex() + Typography.ellipsis);
    L17:
        if (r(r11 - 1) != 13) goto L22;
        if (r(r11) != 10) goto L22;
        return okio.internal.a.b(this, r11);
    L25:
        throw new IllegalArgumentException(("limit < 0: " + r12).toString());
    L5:
        r10 = false;
        goto L6
    }

    @JvmName(name = "getByte")
    public final byte r(long r10) {
        okio.b.b(M(), r10, 1);
        b0 r11 = this.f12197c;
        if (r11 != null) goto L5;
        Intrinsics.checkNotNull(null);
        throw null;
    L5:
        if ((M() - r10) >= r10) goto L11;
        long r12 = M();
    L8:
        if (r12 <= r10) goto L10;
        r11 = r11.f12178g;
        Intrinsics.checkNotNull(r11);
        r12 = r12 - ((long) (r11.f12174c - r11.f12173b));
        goto L8
    L10:
        Intrinsics.checkNotNull(r11);
        return r11.f12172a[(int) ((((long) r11.f12173b) + r10) - r12)];
    L11:
        long r13 = 0;
    L12:
        long r14 = ((long) (r11.f12174c - r11.f12173b)) + r13;
        if (r14 > r10) goto L15;
        r11 = r11.f12177f;
        Intrinsics.checkNotNull(r11);
        r13 = r14;
        goto L12
    L15:
        Intrinsics.checkNotNull(r11);
        return r11.f12172a[(int) ((((long) r11.f12173b) + r10) - r13)];
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer r10) {
        Intrinsics.checkNotNullParameter(r10, "sink");
        b0 r11 = this.f12197c;
        if (r11 != null) goto L6;
        return -1;
    L6:
        int r12 = Math.min(r10.remaining(), r11.f12174c - r11.f12173b);
        r10.put(r11.f12172a, r11.f12173b, r12);
        int r13 = r11.f12173b + r12;
        r11.f12173b = r13;
        this.f12198g -= (long) r12;
        if (r13 != r11.f12174c) goto L9;
        this.f12197c = r11.b();
        c0.b(r11);
    L9:
        return r12;
    }

    public int read(byte[] r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "sink");
        okio.b.b(r10.length, r11, r12);
        b0 r13 = this.f12197c;
        if (r13 != null) goto L5;
        return -1;
    L5:
        int r14 = Math.min(r12, r13.f12174c - r13.f12173b);
        byte[] r15 = r13.f12172a;
        int r16 = r13.f12173b;
        ArraysKt.copyInto(r15, r10, r11, r16, r16 + r14);
        r13.f12173b += r14;
        K(M() - ((long) r14));
        if (r13.f12173b != r13.f12174c) goto L9;
        this.f12197c = r13.b();
        c0.b(r13);
    L9:
        return r14;
    }

    @Override // okio.f
    public byte readByte() {
        if (M() == 0) goto L10;
        b0 r10 = this.f12197c;
        Intrinsics.checkNotNull(r10);
        int r11 = r10.f12173b;
        int r12 = r10.f12174c;
        int r13 = r11 + 1;
        byte r14 = r10.f12172a[r11];
        K(M() - 1);
        if (r13 != r12) goto L7;
        this.f12197c = r10.b();
        c0.b(r10);
    L8:
        return r14;
    L7:
        r10.f12173b = r13;
        goto L8
    L10:
        throw new EOFException();
    }

    @Override // okio.f
    public int readInt() {
        if (M() < 4) goto L14;
        b0 r10 = this.f12197c;
        Intrinsics.checkNotNull(r10);
        int r11 = r10.f12173b;
        int r12 = r10.f12174c;
        if ((r12 - r11) < 4) goto L15;
        byte[] r13 = r10.f12172a;
        int r14 = r11 + 1;
        int r15 = r14 + 1;
        int r16 = ((r13[r11] & 255) << 24) | ((r13[r14] & 255) << 16);
        int r17 = r15 + 1;
        int r18 = r16 | ((r13[r15] & 255) << 8);
        int r19 = r17 + 1;
        int r20 = r18 | (r13[r17] & 255);
        K(M() - 4);
        if (r19 != r12) goto L10;
        this.f12197c = r10.b();
        c0.b(r10);
    L12:
        return r20;
    L10:
        r10.f12173b = r19;
        goto L12
    L15:
        return (readByte() & 255) | ((((readByte() & 255) << 24) | ((readByte() & 255) << 16)) | ((readByte() & 255) << 8));
    L14:
        throw new EOFException();
    }

    @Override // okio.f
    public short readShort() {
        if (M() < 2) goto L14;
        b0 r10 = this.f12197c;
        Intrinsics.checkNotNull(r10);
        int r11 = r10.f12173b;
        int r12 = r10.f12174c;
        if ((r12 - r11) >= 2) goto L7;
        int r13 = (readByte() & 255) << 8;
        return (short) ((readByte() & 255) | r13);
    L7:
        byte[] r14 = r10.f12172a;
        int r15 = r11 + 1;
        int r16 = r15 + 1;
        int r17 = ((r14[r11] & 255) << 8) | (r14[r15] & 255);
        K(M() - 2);
        if (r16 != r12) goto L10;
        this.f12197c = r10.b();
        c0.b(r10);
    L12:
        return (short) r17;
    L10:
        r10.f12173b = r16;
        goto L12
    L14:
        throw new EOFException();
    }

    public long s(byte r10, long r11, long r13) {
        long r12 = 0;
        boolean r14 = false;
        if (0 <= r11) goto L5;
    L7:
        if (r14 == false) goto L46;
        if (r13 <= M()) goto L12;
        r13 = M();
    L12:
        if (r11 == r13) goto L55;
        b0 r15 = this.f12197c;
        if (r15 != null) goto L18;
        return -1;
    L18:
        if ((M() - r11) >= r11) goto L32;
        r12 = M();
    L21:
        if (r12 <= r11) goto L24;
        r15 = r15.f12178g;
        Intrinsics.checkNotNull(r15);
        r12 = r12 - ((long) (r15.f12174c - r15.f12173b));
    L24:
        if (r12 >= r13) goto L57;
        byte[] r16 = r15.f12172a;
        int r17 = (int) Math.min(r15.f12174c, (((long) r15.f12173b) + r13) - r12);
        int r18 = (int) ((((long) r15.f12173b) + r11) - r12);
    L26:
        if (r18 >= r17) goto L31;
        if (r16[r18] == r10) goto L44;
        r18 = r18 + 1;
    L44:
        return ((long) (r18 - r15.f12173b)) + r12;
    L31:
        r12 = r12 + ((long) (r15.f12174c - r15.f12173b));
        r15 = r15.f12177f;
        Intrinsics.checkNotNull(r15);
        r11 = r12;
        goto L24
    L57:
        return -1;
    L32:
        long r19 = ((long) (r15.f12174c - r15.f12173b)) + r12;
        if (r19 > r11) goto L36;
        r15 = r15.f12177f;
        Intrinsics.checkNotNull(r15);
        r12 = r19;
    L36:
        if (r12 >= r13) goto L58;
        byte[] r20 = r15.f12172a;
        int r21 = (int) Math.min(r15.f12174c, (((long) r15.f12173b) + r13) - r12);
        r18 = (int) ((((long) r15.f12173b) + r11) - r12);
    L38:
        if (r18 >= r21) goto L43;
        if (r20[r18] == r10) goto L44;
        r18 = r18 + 1;
        goto L38
    L43:
        r12 = r12 + ((long) (r15.f12174c - r15.f12173b));
        r15 = r15.f12177f;
        Intrinsics.checkNotNull(r15);
        r11 = r12;
        goto L36
    L58:
        return -1;
    L55:
        return -1;
    L46:
        throw new IllegalArgumentException(("size=" + M() + " fromIndex=" + r11 + " toIndex=" + r13).toString());
    L5:
        if (r11 > r13) goto L7;
        r14 = true;
        goto L7
    }

    @Override // okio.f
    public void skip(long r10) {
    L3:
        if (r10 <= 0) goto L11;
        b0 r11 = this.f12197c;
        if (r11 == null) goto L10;
        int r12 = (int) Math.min(r10, r11.f12174c - r11.f12173b);
        long r13 = r12;
        K(M() - r13);
        r10 = r10 - r13;
        int r14 = r11.f12173b + r12;
        r11.f12173b = r14;
        if (r14 != r11.f12174c) goto L3;
        this.f12197c = r11.b();
        c0.b(r11);
        goto L3
    L10:
        throw new EOFException();
    }

    @Override // okio.e
    public /* bridge */ /* synthetic */ e t(String r10) {
        return l0(r10);
    }

    @Override // okio.f0
    public g0 timeout() {
        return g0.f12214d;
    }

    public String toString() {
        return N().toString();
    }

    public long u(ByteString r10) {
        Intrinsics.checkNotNullParameter(r10, "targetBytes");
        return v(r10, 0);
    }

    public long v(ByteString r12, long r13) {
        Intrinsics.checkNotNullParameter(r12, "targetBytes");
        long r10 = 0;
        if (r13 < 0) goto L5;
        boolean r11 = true;
    L6:
        if (r11 == false) goto L74;
        b0 r14 = this.f12197c;
        if (r14 != null) goto L11;
        return -1;
    L11:
        if ((M() - r13) >= r13) goto L42;
        r10 = M();
    L14:
        if (r10 <= r13) goto L17;
        r14 = r14.f12178g;
        Intrinsics.checkNotNull(r14);
        r10 = r10 - ((long) (r14.f12174c - r14.f12173b));
        goto L14
    L17:
        if (r12.size() != 2) goto L29;
        byte r15 = r12.getByte(0);
        byte r16 = r12.getByte(1);
    L20:
        if (r10 >= M()) goto L94;
        byte[] r17 = r14.f12172a;
        int r18 = (int) ((((long) r14.f12173b) + r13) - r10);
        int r19 = r14.f12174c;
    L22:
        if (r18 >= r19) goto L28;
        byte r20 = r17[r18];
        if (r20 == r15) goto L72;
        if (r20 == r16) goto L72;
        r18 = r18 + 1;
    L72:
        return ((long) (r18 - r14.f12173b)) + r10;
    L28:
        r10 = r10 + ((long) (r14.f12174c - r14.f12173b));
        r14 = r14.f12177f;
        Intrinsics.checkNotNull(r14);
        r13 = r10;
        goto L20
    L94:
        return -1;
    L29:
        byte[] r110 = r12.internalArray$okio();
    L31:
        if (r10 >= M()) goto L95;
        byte[] r21 = r14.f12172a;
        r18 = (int) ((((long) r14.f12173b) + r13) - r10);
        int r111 = r14.f12174c;
    L33:
        if (r18 >= r111) goto L41;
        byte r22 = r21[r18];
        int r23 = r110.length;
        int r24 = 0;
    L35:
        if (r24 >= r23) goto L40;
        if (r22 == r110[r24]) goto L72;
        r24 = r24 + 1;
        goto L35
    L40:
        r18 = r18 + 1;
        goto L33
    L41:
        r10 = r10 + ((long) (r14.f12174c - r14.f12173b));
        r14 = r14.f12177f;
        Intrinsics.checkNotNull(r14);
        r13 = r10;
        goto L31
    L95:
        return -1;
    L42:
        long r25 = ((long) (r14.f12174c - r14.f12173b)) + r10;
        if (r25 > r13) goto L46;
        r14 = r14.f12177f;
        Intrinsics.checkNotNull(r14);
        r10 = r25;
        goto L42
    L46:
        if (r12.size() != 2) goto L59;
        byte r26 = r12.getByte(0);
        byte r112 = r12.getByte(1);
    L49:
        if (r10 >= M()) goto L96;
        byte[] r27 = r14.f12172a;
        r18 = (int) ((((long) r14.f12173b) + r13) - r10);
        int r113 = r14.f12174c;
    L51:
        if (r18 >= r113) goto L58;
        byte r28 = r27[r18];
        if (r28 == r26) goto L72;
        if (r28 == r112) goto L72;
        r18 = r18 + 1;
        goto L51
    L58:
        r10 = r10 + ((long) (r14.f12174c - r14.f12173b));
        r14 = r14.f12177f;
        Intrinsics.checkNotNull(r14);
        r13 = r10;
        goto L49
    L96:
        return -1;
    L59:
        byte[] r114 = r12.internalArray$okio();
    L61:
        if (r10 >= M()) goto L97;
        byte[] r29 = r14.f12172a;
        r18 = (int) ((((long) r14.f12173b) + r13) - r10);
        int r115 = r14.f12174c;
    L63:
        if (r18 >= r115) goto L71;
        byte r30 = r29[r18];
        int r31 = r114.length;
        int r32 = 0;
    L65:
        if (r32 >= r31) goto L70;
        if (r30 == r114[r32]) goto L72;
        r32 = r32 + 1;
        goto L65
    L70:
        r18 = r18 + 1;
        goto L63
    L71:
        r10 = r10 + ((long) (r14.f12174c - r14.f12173b));
        r14 = r14.f12177f;
        Intrinsics.checkNotNull(r14);
        r13 = r10;
        goto L61
    L97:
        return -1;
    L74:
        throw new IllegalArgumentException(("fromIndex < 0: " + r13).toString());
    L5:
        r11 = false;
        goto L6
    }

    @Override // okio.f
    public String w(Charset r10) {
        Intrinsics.checkNotNullParameter(r10, "charset");
        return I(this.f12198g, r10);
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer r10) {
        Intrinsics.checkNotNullParameter(r10, "source");
        int r11 = r10.remaining();
        int r12 = r11;
    L3:
        if (r12 <= 0) goto L5;
        b0 r13 = Q(1);
        int r14 = Math.min(r12, 8192 - r13.f12174c);
        r10.get(r13.f12172a, r13.f12174c, r14);
        r12 = r12 - r14;
        r13.f12174c += r14;
        goto L3
    L5:
        this.f12198g += (long) r11;
        return r11;
    }

    @Override // okio.e
    public /* bridge */ /* synthetic */ e write(byte[] r10) {
        return X(r10);
    }

    @Override // okio.e
    public /* bridge */ /* synthetic */ e write(byte[] r10, int r11, int r12) {
        return a0(r10, r11, r12);
    }

    @Override // okio.e
    public /* bridge */ /* synthetic */ e writeByte(int r10) {
        return c0(r10);
    }

    @Override // okio.e
    public /* bridge */ /* synthetic */ e writeInt(int r10) {
        return f0(r10);
    }

    @Override // okio.e
    public /* bridge */ /* synthetic */ e writeShort(int r10) {
        return j0(r10);
    }

    @Override // okio.d0
    public void x(d r10, long r11) {
        Intrinsics.checkNotNullParameter(r10, "source");
        if (r10 == this) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L34;
        okio.b.b(r10.M(), 0, r11);
    L9:
        if (r11 <= 0) goto L39;
        b0 r13 = r10.f12197c;
        Intrinsics.checkNotNull(r13);
        int r14 = r13.f12174c;
        b0 r15 = r10.f12197c;
        Intrinsics.checkNotNull(r15);
        if (r11 >= (r14 - r15.f12173b)) goto L27;
        b0 r16 = this.f12197c;
        if (r16 == null) goto L15;
        Intrinsics.checkNotNull(r16);
        b0 r17 = r16.f12178g;
    L16:
        if (r17 != null) goto L18;
    L26:
        b0 r18 = r10.f12197c;
        Intrinsics.checkNotNull(r18);
        r10.f12197c = r18.e((int) r11);
        goto L27
    L18:
        if (r17.f12176e == false) goto L26;
        long r19 = ((long) r17.f12174c) + r11;
        if (r17.f12175d == false) goto L22;
        int r20 = 0;
    L24:
        if ((r19 - ((long) r20)) > PlaybackStateCompat.ACTION_PLAY_FROM_URI) goto L26;
        b0 r21 = r10.f12197c;
        Intrinsics.checkNotNull(r21);
        r21.f(r17, (int) r11);
        r10.K(r10.M() - r11);
        K(M() + r11);
        return;
    L22:
        r20 = r17.f12173b;
        goto L24
    L15:
        r17 = null;
    L27:
        b0 r22 = r10.f12197c;
        Intrinsics.checkNotNull(r22);
        long r23 = r22.f12174c - r22.f12173b;
        r10.f12197c = r22.b();
        b0 r24 = this.f12197c;
        if (r24 != null) goto L30;
        this.f12197c = r22;
        r22.f12178g = r22;
        r22.f12177f = r22;
    L31:
        r10.K(r10.M() - r23);
        K(M() + r23);
        r11 = r11 - r23;
        goto L9
    L30:
        Intrinsics.checkNotNull(r24);
        b0 r25 = r24.f12178g;
        Intrinsics.checkNotNull(r25);
        r25.c(r22).a();
        goto L31
    L39:
        return;
    L34:
        throw new IllegalArgumentException("source == this".toString());
    L5:
        r12 = false;
        goto L6
    }

    @Override // okio.e
    public long y(f0 r10) {
        Intrinsics.checkNotNullParameter(r10, "source");
        long r11 = 0;
    L3:
        long r12 = r10.S(this, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
        if (r12 == (-1)) goto L6;
        r11 = r11 + r12;
        goto L3
    L6:
        return r11;
    }

    @Override // okio.e
    public /* bridge */ /* synthetic */ e z(long r10) {
        return e0(r10);
    }
}
