package okio;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nRealBufferedSink.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RealBufferedSink.kt\nokio/RealBufferedSink\n+ 2 RealBufferedSink.kt\nokio/internal/-RealBufferedSink\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,142:1\n51#1:146\n51#1:152\n51#1:157\n51#1:162\n51#1:167\n51#1:172\n51#1:175\n51#1:176\n51#1:180\n51#1:185\n51#1:188\n51#1:192\n51#1:201\n51#1:210\n51#1:215\n51#1:220\n51#1:225\n51#1:230\n51#1:235\n51#1:240\n51#1:245\n51#1:250\n51#1:255\n51#1:261\n51#1:267\n51#1:279\n34#2:143\n35#2:145\n36#2,2:147\n40#2:149\n41#2:151\n42#2:153\n50#2:154\n51#2:156\n52#2:158\n56#2:159\n57#2:161\n58#2:163\n66#2:164\n67#2:166\n68#2:168\n72#2:169\n73#2:171\n74#2:173\n78#2:177\n79#2:179\n80#2:181\n88#2:182\n89#2:184\n90#2:186\n94#2,3:189\n97#2,5:193\n105#2,3:198\n108#2,5:202\n116#2:207\n117#2:209\n118#2:211\n122#2:212\n123#2:214\n124#2:216\n128#2:217\n129#2:219\n130#2:221\n134#2:222\n135#2:224\n136#2:226\n140#2:227\n141#2:229\n142#2:231\n146#2:232\n147#2:234\n148#2:236\n152#2:237\n153#2:239\n154#2:241\n158#2:242\n159#2:244\n160#2:246\n164#2:247\n165#2:249\n166#2:251\n170#2:252\n171#2:254\n172#2,2:256\n177#2:258\n178#2:260\n179#2,2:262\n184#2:264\n185#2:266\n186#2,4:268\n192#2,7:272\n199#2,16:280\n216#2:296\n218#2:297\n1#3:144\n1#3:150\n1#3:155\n1#3:160\n1#3:165\n1#3:170\n1#3:174\n1#3:178\n1#3:183\n1#3:187\n1#3:208\n1#3:213\n1#3:218\n1#3:223\n1#3:228\n1#3:233\n1#3:238\n1#3:243\n1#3:248\n1#3:253\n1#3:259\n1#3:265\n*S KotlinDebug\n*F\n+ 1 RealBufferedSink.kt\nokio/RealBufferedSink\n*L\n55#1:146\n56#1:152\n58#1:157\n59#1:162\n61#1:167\n63#1:172\n67#1:175\n78#1:176\n82#1:180\n84#1:185\n88#1:188\n93#1:192\n94#1:201\n95#1:210\n96#1:215\n97#1:220\n98#1:225\n99#1:230\n100#1:235\n101#1:240\n102#1:245\n103#1:250\n104#1:255\n105#1:261\n134#1:267\n138#1:279\n55#1:143\n55#1:145\n55#1:147,2\n56#1:149\n56#1:151\n56#1:153\n58#1:154\n58#1:156\n58#1:158\n59#1:159\n59#1:161\n59#1:163\n61#1:164\n61#1:166\n61#1:168\n63#1:169\n63#1:171\n63#1:173\n82#1:177\n82#1:179\n82#1:181\n84#1:182\n84#1:184\n84#1:186\n93#1:189,3\n93#1:193,5\n94#1:198,3\n94#1:202,5\n95#1:207\n95#1:209\n95#1:211\n96#1:212\n96#1:214\n96#1:216\n97#1:217\n97#1:219\n97#1:221\n98#1:222\n98#1:224\n98#1:226\n99#1:227\n99#1:229\n99#1:231\n100#1:232\n100#1:234\n100#1:236\n101#1:237\n101#1:239\n101#1:241\n102#1:242\n102#1:244\n102#1:246\n103#1:247\n103#1:249\n103#1:251\n104#1:252\n104#1:254\n104#1:256,2\n105#1:258\n105#1:260\n105#1:262,2\n134#1:264\n134#1:266\n134#1:268,4\n138#1:272,7\n138#1:280,16\n139#1:296\n140#1:297\n55#1:144\n56#1:150\n58#1:155\n59#1:160\n61#1:165\n63#1:170\n82#1:178\n84#1:183\n95#1:208\n96#1:213\n97#1:218\n98#1:223\n99#1:228\n100#1:233\n101#1:238\n102#1:243\n103#1:248\n104#1:253\n105#1:259\n134#1:265\n*E\n"})
public final class z implements e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @JvmField
    public final d0 f12277c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @JvmField
    public final d f12278g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @JvmField
    public boolean f12279h;

    @SourceDebugExtension({"SMAP\nRealBufferedSink.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RealBufferedSink.kt\nokio/RealBufferedSink$outputStream$1\n+ 2 RealBufferedSink.kt\nokio/RealBufferedSink\n*L\n1#1,142:1\n51#2:143\n51#2:144\n*S KotlinDebug\n*F\n+ 1 RealBufferedSink.kt\nokio/RealBufferedSink$outputStream$1\n*L\n111#1:143\n117#1:144\n*E\n"})
    public static final class a extends OutputStream {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ z f12280c;

        a(z r10) {
            this.f12280c = r10;
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f12280c.close();
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() {
            z r10 = this.f12280c;
            if (r10.f12279h == true) goto L6;
            r10.flush();
            return;
        }

        public String toString() {
            return this.f12280c + ".outputStream()";
        }

        @Override // java.io.OutputStream
        public void write(int r10) {
            z r11 = this.f12280c;
            if (r11.f12279h == true) goto L7;
            r11.f12278g.c0((byte) r10);
            this.f12280c.a();
            return;
        L7:
            throw new IOException("closed");
        }

        @Override // java.io.OutputStream
        public void write(byte[] r10, int r11, int r12) {
            Intrinsics.checkNotNullParameter(r10, "data");
            z r13 = this.f12280c;
            if (r13.f12279h == true) goto L7;
            r13.f12278g.a0(r10, r11, r12);
            this.f12280c.a();
            return;
        L7:
            throw new IOException("closed");
        }
    }

    public z(d0 r10) {
        Intrinsics.checkNotNullParameter(r10, "sink");
        this.f12277c = r10;
        this.f12278g = new d();
    }

    @Override // okio.e
    public e O(ByteString r10) {
        Intrinsics.checkNotNullParameter(r10, "byteString");
        if ((!this.f12279h) == false) goto L7;
        this.f12278g.V(r10);
        return a();
    L7:
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.e
    public e W(long r10) {
        if ((!this.f12279h) == false) goto L7;
        this.f12278g.d0(r10);
        return a();
    L7:
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.e
    public OutputStream Y() {
        return new a(this);
    }

    public e a() {
        if ((!this.f12279h) == false) goto L9;
        long r10 = this.f12278g.k();
        if (r10 <= 0) goto L7;
        this.f12277c.x(this.f12278g, r10);
    L7:
        return this;
    L9:
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.e
    public d b() {
        return this.f12278g;
    }

    @Override // okio.d0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f12279h == true) goto L19;
        Throwable th = null;
    L9:
        th = th;
    L20:
        this.f12277c.close();     // Catch: Throwable -> L12
    L15:
        this.f12279h = true;
        if (th == null) goto L24;
        throw th;
    L24:
        return;
    L12:
        th = move-exception;
        if (th != null) goto L15;
        th = th;
        goto L15
    L6:
        if (this.f12278g.M() <= 0) goto L20;
        d0 r10 = this.f12277c;     // Catch: Throwable -> L9
        d r11 = this.f12278g;     // Catch: Throwable -> L9
        r10.x(r11, r11.M());     // Catch: Throwable -> L9
        goto L20
    }

    @Override // okio.e, okio.d0, java.io.Flushable
    public void flush() {
        if ((!this.f12279h) == false) goto L10;
        if (this.f12278g.M() <= 0) goto L7;
        d0 r10 = this.f12277c;
        d r11 = this.f12278g;
        r10.x(r11, r11.M());
    L7:
        this.f12277c.flush();
        return;
    L10:
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.e
    public e h() {
        if ((!this.f12279h) == false) goto L9;
        long r10 = this.f12278g.M();
        if (r10 <= 0) goto L7;
        this.f12277c.x(this.f12278g, r10);
    L7:
        return this;
    L9:
        throw new IllegalStateException("closed".toString());
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.f12279h;
    }

    @Override // okio.e
    public e j(long r10) {
        if ((!this.f12279h) == false) goto L7;
        this.f12278g.i0(r10);
        return a();
    L7:
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.e
    public e m(int r10) {
        if ((!this.f12279h) == false) goto L7;
        this.f12278g.g0(r10);
        return a();
    L7:
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.e
    public e t(String r10) {
        Intrinsics.checkNotNullParameter(r10, TypedValues.Custom.S_STRING);
        if ((!this.f12279h) == false) goto L7;
        this.f12278g.l0(r10);
        return a();
    L7:
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.d0
    public g0 timeout() {
        return this.f12277c.timeout();
    }

    public String toString() {
        return "buffer(" + this.f12277c + ')';
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer r10) {
        Intrinsics.checkNotNullParameter(r10, "source");
        if ((!this.f12279h) == false) goto L7;
        int r11 = this.f12278g.write(r10);
        a();
        return r11;
    L7:
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.e
    public e write(byte[] r10) {
        Intrinsics.checkNotNullParameter(r10, "source");
        if ((!this.f12279h) == false) goto L7;
        this.f12278g.X(r10);
        return a();
    L7:
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.e
    public e write(byte[] r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "source");
        if ((!this.f12279h) == false) goto L7;
        this.f12278g.a0(r10, r11, r12);
        return a();
    L7:
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.e
    public e writeByte(int r10) {
        if ((!this.f12279h) == false) goto L7;
        this.f12278g.c0(r10);
        return a();
    L7:
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.e
    public e writeInt(int r10) {
        if ((!this.f12279h) == false) goto L7;
        this.f12278g.f0(r10);
        return a();
    L7:
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.e
    public e writeShort(int r10) {
        if ((!this.f12279h) == false) goto L7;
        this.f12278g.j0(r10);
        return a();
    L7:
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.d0
    public void x(d r10, long r11) {
        Intrinsics.checkNotNullParameter(r10, "source");
        if ((!this.f12279h) == false) goto L7;
        this.f12278g.x(r10, r11);
        a();
        return;
    L7:
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.e
    public long y(f0 r10) {
        Intrinsics.checkNotNullParameter(r10, "source");
        long r11 = 0;
    L3:
        long r12 = r10.S(this.f12278g, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
        if (r12 == (-1)) goto L6;
        r11 = r11 + r12;
        a();
        goto L3
    L6:
        return r11;
    }

    @Override // okio.e
    public e z(long r10) {
        if ((!this.f12279h) == false) goto L7;
        this.f12278g.e0(r10);
        return a();
    L7:
        throw new IllegalStateException("closed".toString());
    }
}
