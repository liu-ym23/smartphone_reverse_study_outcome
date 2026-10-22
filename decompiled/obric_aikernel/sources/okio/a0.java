package okio;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.CharsKt;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nRealBufferedSource.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RealBufferedSource.kt\nokio/RealBufferedSource\n+ 2 RealBufferedSource.kt\nokio/internal/-RealBufferedSource\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Util.kt\nokio/-SegmentedByteString\n*L\n1#1,185:1\n62#1:191\n62#1:201\n62#1:208\n62#1:214\n62#1:216\n62#1:220\n62#1:225\n62#1:240\n62#1:244\n62#1:251\n62#1:264\n62#1:272\n62#1:273\n62#1:274\n62#1:280\n62#1:288\n62#1:301\n62#1:305\n62#1:306\n62#1:307\n62#1:308\n62#1:313\n62#1:325\n62#1:341\n62#1:351\n62#1:354\n62#1:357\n62#1:360\n62#1:363\n62#1:366\n62#1:372\n62#1:389\n62#1:409\n62#1:424\n62#1:441\n62#1:454\n62#1:475\n62#1:482\n38#2:186\n39#2,3:188\n42#2,6:192\n51#2:198\n52#2:200\n56#2,2:202\n60#2:204\n61#2,2:206\n63#2,3:209\n69#2,2:212\n74#2:215\n75#2:217\n79#2,2:218\n84#2:221\n86#2,2:223\n88#2,13:226\n107#2:239\n108#2:241\n112#2,2:242\n117#2,6:245\n123#2,9:252\n134#2,3:261\n137#2,5:265\n142#2:271\n146#2,5:275\n151#2,5:281\n158#2,2:286\n160#2,11:289\n174#2:300\n175#2:302\n179#2,2:303\n184#2,4:309\n188#2,6:314\n198#2:320\n199#2,3:322\n202#2,8:326\n210#2,3:335\n217#2,3:338\n220#2,7:342\n230#2,2:349\n235#2,2:352\n240#2,2:355\n245#2,2:358\n250#2,2:361\n255#2,2:364\n260#2,5:367\n265#2,11:373\n279#2,5:384\n284#2,14:390\n301#2,2:404\n303#2,2:407\n305#2,7:410\n314#2,2:417\n316#2,4:420\n320#2,11:425\n334#2,2:436\n337#2,2:439\n339#2,7:442\n350#2,2:449\n353#2,2:452\n355#2,7:455\n371#2:462\n373#2,11:464\n385#2:476\n389#2:477\n393#2,4:478\n397#2:483\n399#2:484\n401#2:485\n1#3:187\n1#3:199\n1#3:205\n1#3:222\n1#3:321\n1#3:406\n1#3:419\n1#3:438\n1#3:451\n1#3:463\n89#4:270\n89#4:334\n*S KotlinDebug\n*F\n+ 1 RealBufferedSource.kt\nokio/RealBufferedSource\n*L\n66#1:191\n67#1:201\n69#1:208\n70#1:214\n71#1:216\n72#1:220\n73#1:225\n74#1:240\n75#1:244\n77#1:251\n79#1:264\n82#1:272\n83#1:273\n87#1:274\n90#1:280\n91#1:288\n92#1:301\n93#1:305\n96#1:306\n97#1:307\n102#1:308\n105#1:313\n107#1:325\n108#1:341\n109#1:351\n110#1:354\n111#1:357\n112#1:360\n113#1:363\n114#1:366\n115#1:372\n116#1:389\n117#1:409\n121#1:424\n124#1:441\n127#1:454\n141#1:475\n181#1:482\n66#1:186\n66#1:188,3\n66#1:192,6\n67#1:198\n67#1:200\n68#1:202,2\n69#1:204\n69#1:206,2\n69#1:209,3\n70#1:212,2\n71#1:215\n71#1:217\n72#1:218,2\n73#1:221\n73#1:223,2\n73#1:226,13\n74#1:239\n74#1:241\n75#1:242,2\n77#1:245,6\n77#1:252,9\n79#1:261,3\n79#1:265,5\n79#1:271\n90#1:275,5\n90#1:281,5\n91#1:286,2\n91#1:289,11\n92#1:300\n92#1:302\n93#1:303,2\n105#1:309,4\n105#1:314,6\n107#1:320\n107#1:322,3\n107#1:326,8\n107#1:335,3\n108#1:338,3\n108#1:342,7\n109#1:349,2\n110#1:352,2\n111#1:355,2\n112#1:358,2\n113#1:361,2\n114#1:364,2\n115#1:367,5\n115#1:373,11\n116#1:384,5\n116#1:390,14\n117#1:404,2\n117#1:407,2\n117#1:410,7\n121#1:417,2\n121#1:420,4\n121#1:425,11\n124#1:436,2\n124#1:439,2\n124#1:442,7\n127#1:449,2\n127#1:452,2\n127#1:455,7\n141#1:462\n141#1:464,11\n141#1:476\n143#1:477\n181#1:478,4\n181#1:483\n182#1:484\n183#1:485\n66#1:187\n67#1:199\n69#1:205\n73#1:222\n107#1:321\n117#1:406\n121#1:419\n124#1:438\n127#1:451\n141#1:463\n79#1:270\n107#1:334\n*E\n"})
public final class a0 implements f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @JvmField
    public final f0 f12166c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @JvmField
    public final d f12167g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @JvmField
    public boolean f12168h;

    @SourceDebugExtension({"SMAP\nRealBufferedSource.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RealBufferedSource.kt\nokio/RealBufferedSource$inputStream$1\n+ 2 RealBufferedSource.kt\nokio/RealBufferedSource\n+ 3 Util.kt\nokio/-SegmentedByteString\n*L\n1#1,185:1\n62#2:186\n62#2:187\n62#2:188\n62#2:190\n62#2:191\n62#2:192\n62#2:193\n74#3:189\n86#3:194\n*S KotlinDebug\n*F\n+ 1 RealBufferedSource.kt\nokio/RealBufferedSource$inputStream$1\n*L\n149#1:186\n150#1:187\n153#1:188\n160#1:190\n161#1:191\n165#1:192\n170#1:193\n153#1:189\n170#1:194\n*E\n"})
    public static final class a extends InputStream {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ a0 f12169c;

        a(a0 r10) {
            this.f12169c = r10;
        }

        @Override // java.io.InputStream
        public int available() {
            a0 r10 = this.f12169c;
            if (r10.f12168h == true) goto L7;
            return (int) Math.min(r10.f12167g.M(), Integer.MAX_VALUE);
        L7:
            throw new IOException("closed");
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f12169c.close();
        }

        @Override // java.io.InputStream
        public int read() {
            a0 r10 = this.f12169c;
            if (r10.f12168h == true) goto L13;
            if (r10.f12167g.M() != 0) goto L11;
            a0 r11 = this.f12169c;
            if (r11.f12166c.S(r11.f12167g, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != (-1)) goto L11;
            return -1;
        L11:
            return this.f12169c.f12167g.readByte() & 255;
        L13:
            throw new IOException("closed");
        }

        @Override // java.io.InputStream
        public int read(byte[] r10, int r11, int r12) {
            Intrinsics.checkNotNullParameter(r10, "data");
            if (this.f12169c.f12168h == true) goto L13;
            b.b(r10.length, r11, r12);
            if (this.f12169c.f12167g.M() != 0) goto L11;
            a0 r13 = this.f12169c;
            if (r13.f12166c.S(r13.f12167g, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != (-1)) goto L11;
            return -1;
        L11:
            return this.f12169c.f12167g.read(r10, r11, r12);
        L13:
            throw new IOException("closed");
        }

        public String toString() {
            return this.f12169c + ".inputStream()";
        }
    }

    public a0(f0 r10) {
        Intrinsics.checkNotNullParameter(r10, "source");
        this.f12166c = r10;
        this.f12167g = new d();
    }

    @Override // okio.f
    public String E() {
        return q(Long.MAX_VALUE);
    }

    @Override // okio.f
    public int H() {
        U(4);
        return this.f12167g.H();
    }

    @Override // okio.f
    public byte[] L(long r10) {
        U(r10);
        return this.f12167g.L(r10);
    }

    @Override // okio.f
    public short R() {
        U(2);
        return this.f12167g.R();
    }

    @Override // okio.f0
    public long S(d r10, long r11) {
        Intrinsics.checkNotNullParameter(r10, "sink");
        if (r11 < 0) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L19;
        if ((!this.f12168h) == false) goto L17;
        if (this.f12167g.M() != 0) goto L15;
        if (this.f12166c.S(this.f12167g, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != (-1)) goto L15;
        return -1;
    L15:
        return this.f12167g.S(r10, Math.min(r11, this.f12167g.M()));
    L17:
        throw new IllegalStateException("closed".toString());
    L19:
        throw new IllegalArgumentException(("byteCount < 0: " + r11).toString());
    L5:
        r12 = false;
        goto L6
    }

    @Override // okio.f
    public long T() {
        U(8);
        return this.f12167g.T();
    }

    @Override // okio.f
    public void U(long r10) {
        if (f(r10) == false) goto L6;
        return;
    L6:
        throw new EOFException();
    }

    @Override // okio.f
    public long Z() {
        U(1);
        int r10 = 0;
    L3:
        int r11 = r10 + 1;
        if (f(r11) == false) goto L24;
        byte r12 = this.f12167g.r(r10);
        if (r12 < 48) goto L10;
        if (r12 > 57) goto L10;
    L18:
        r10 = r11;
    L10:
        if (r12 < 97) goto L14;
        if (r12 <= 102) goto L18;
    L14:
        if (r12 < 65) goto L19;
        if (r12 <= 70) goto L18;
    L19:
        if (r10 != 0) goto L24;
        StringBuilder r13 = new StringBuilder();
        r13.append("Expected leading [0-9a-fA-F] character but was 0x");
        String r14 = Integer.toString(r12, CharsKt.checkRadix(CharsKt.checkRadix(16)));
        Intrinsics.checkNotNullExpressionValue(r14, "toString(this, checkRadix(radix))");
        r13.append(r14);
        throw new NumberFormatException(r13.toString());
    L24:
        return this.f12167g.Z();
    }

    public long a(byte r10) {
        return c(r10, 0, Long.MAX_VALUE);
    }

    @Override // okio.f
    public d b() {
        return this.f12167g;
    }

    @Override // okio.f
    public int b0(w r10) {
        Intrinsics.checkNotNullParameter(r10, "options");
        if ((!this.f12168h) == false) goto L14;
    L4:
        int r11 = okio.internal.a.c(this.f12167g, r10, true);
        if (r11 != (-2)) goto L6;
        if (this.f12166c.S(this.f12167g, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != (-1)) goto L4;
    L18:
        return -1;
    L6:
        if (r11 == (-1)) goto L18;
        this.f12167g.skip(r10.c()[r11].size());
        return r11;
    L14:
        throw new IllegalStateException("closed".toString());
    }

    public long c(byte r11, long r12, long r14) {
        boolean r10 = true;
        if ((!this.f12168h) == false) goto L26;
        if (0 <= r12) goto L7;
    L9:
        r10 = false;
    L10:
        if (r10 == false) goto L24;
    L12:
        if (r12 >= r14) goto L33;
        long r13 = this.f12167g.s(r11, r12, r14);
        if (r13 != (-1)) goto L22;
        long r15 = this.f12167g.M();
        if (r15 >= r14) goto L31;
        if (this.f12166c.S(this.f12167g, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == (-1)) goto L32;
        r12 = Math.max(r12, r15);
        goto L12
    L32:
        return -1;
    L31:
        return -1;
    L22:
        return r13;
    L33:
        return -1;
    L24:
        throw new IllegalArgumentException(("fromIndex=" + r12 + " toIndex=" + r14).toString());
    L7:
        if (r12 > r14) goto L9;
    L26:
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.f0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f12168h == true) goto L6;
        this.f12168h = true;
        this.f12166c.close();
        this.f12167g.f();
        return;
    }

    @Override // okio.f
    public InputStream d() {
        return new a(this);
    }

    @Override // okio.f
    public String e(long r10) {
        U(r10);
        return this.f12167g.e(r10);
    }

    public boolean f(long r10) {
        if (r10 < 0) goto L5;
        boolean r11 = true;
    L6:
        if (r11 == false) goto L19;
        if ((!this.f12168h) == false) goto L17;
    L10:
        if (this.f12167g.M() >= r10) goto L15;
        if (this.f12166c.S(this.f12167g, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != (-1)) goto L10;
        return false;
    L15:
        return true;
    L17:
        throw new IllegalStateException("closed".toString());
    L19:
        throw new IllegalArgumentException(("byteCount < 0: " + r10).toString());
    L5:
        r11 = false;
        goto L6
    }

    @Override // okio.f
    public ByteString g(long r10) {
        U(r10);
        return this.f12167g.g(r10);
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.f12168h;
    }

    @Override // okio.f
    public boolean n() {
        if ((!this.f12168h) == false) goto L12;
        if (this.f12167g.n() == true) goto L7;
    L9:
        return false;
    L7:
        if (this.f12166c.S(this.f12167g, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != (-1)) goto L9;
        return true;
    L12:
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.f
    public String q(long r14) {
        if (r14 < 0) goto L5;
        boolean r10 = true;
    L6:
        if (r10 == false) goto L29;
        if (r14 != Long.MAX_VALUE) goto L10;
        long r11 = Long.MAX_VALUE;
    L11:
        long r12 = c((byte) 10, 0, r11);
        if (r12 == (-1)) goto L15;
        return okio.internal.a.b(this.f12167g, r12);
    L15:
        if (r11 < Long.MAX_VALUE) goto L17;
    L26:
        d r13 = new d();
        d r15 = this.f12167g;
        r15.o(r13, 0, Math.min(32, r15.M()));
        throw new EOFException("\\n not found: limit=" + Math.min(this.f12167g.M(), r14) + " content=" + r13.D().hex() + Typography.ellipsis);
    L17:
        if (f(r11) == false) goto L26;
        if (this.f12167g.r(r11 - 1) != 13) goto L26;
        if (f(1 + r11) == false) goto L26;
        if (this.f12167g.r(r11) != 10) goto L26;
        return okio.internal.a.b(this.f12167g, r11);
    L10:
        r11 = r14 + 1;
        goto L11
    L29:
        throw new IllegalArgumentException(("limit < 0: " + r14).toString());
    L5:
        r10 = false;
        goto L6
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer r10) {
        Intrinsics.checkNotNullParameter(r10, "sink");
        if (this.f12167g.M() != 0) goto L9;
        if (this.f12166c.S(this.f12167g, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != (-1)) goto L9;
        return -1;
    L9:
        return this.f12167g.read(r10);
    }

    @Override // okio.f
    public byte readByte() {
        U(1);
        return this.f12167g.readByte();
    }

    @Override // okio.f
    public int readInt() {
        U(4);
        return this.f12167g.readInt();
    }

    @Override // okio.f
    public short readShort() {
        U(2);
        return this.f12167g.readShort();
    }

    @Override // okio.f
    public void skip(long r10) {
        if ((!this.f12168h) == false) goto L16;
    L5:
        if (r10 <= 0) goto L14;
        if (this.f12167g.M() != 0) goto L13;
        if (this.f12166c.S(this.f12167g, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != (-1)) goto L13;
        throw new EOFException();
    L13:
        long r11 = Math.min(r10, this.f12167g.M());
        this.f12167g.skip(r11);
        r10 = r10 - r11;
        goto L5
    L14:
        return;
    L16:
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.f0
    public g0 timeout() {
        return this.f12166c.timeout();
    }

    public String toString() {
        return "buffer(" + this.f12166c + ')';
    }

    @Override // okio.f
    public String w(Charset r10) {
        Intrinsics.checkNotNullParameter(r10, "charset");
        this.f12167g.y(this.f12166c);
        return this.f12167g.w(r10);
    }
}
