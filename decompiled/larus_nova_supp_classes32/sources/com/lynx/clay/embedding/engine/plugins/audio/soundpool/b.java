package com.lynx.clay.embedding.engine.plugins.audio.soundpool;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTrack;
import android.media.MediaCodec;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.larus.apm.impl.protector.RunnableProtector;
import fna.g;
import java.io.Closeable;
import java.io.FileDescriptor;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b implements Closeable {
    public final int a;
    public final RunnableC0039b b;
    public final Object c;
    public AudioTrack d;
    public byte[] e;
    public int f;
    public MediaExtractor g;
    public MediaCodec h;
    public MediaFormat i;
    public boolean j;
    public boolean k;
    public volatile int l;
    public int m;
    public volatile int n;
    public float o;
    public float p;
    public float q;
    public volatile boolean r;
    public int s;

    public static class a {
        public final int a;
        public final int b;
        public final String c;

        public a(int r1, String r2) {
            this.a = r1;
            this.b = 0;
            this.c = r2;
        }
    }

    /* JADX INFO: renamed from: com.lynx.clay.embedding.engine.plugins.audio.soundpool.b$b, reason: collision with other inner class name */
    public final class RunnableC0039b implements Runnable {
        public final /* synthetic */ b a;

        public final void a() {
            if (this.a.d != null) goto L5;
            return;
        L5:
            if (this.a.l <= 0) goto L48;
            c5a.c.c("SoundSample", "PlayRunnable#run:playCount:" + this.a.l);
            if (this.a.r == true) goto L8;
            AudioTrack r0 = this.a.d;
            if (g.d() == true) goto L12;
            r0.play();
        L13:
            b r1 = this.a;
            if (r1.e == null) goto L21;
            if (r1.j == false) goto L18;
        L19:
            int r2 = this.a.n;
            this.a.n = 0;
            b r3 = this.a;
            r3.d.write(r3.e, r2, r3.f);
            goto L21
        L18:
            if (r1.n == 0) goto L19;
        L21:
            if (this.a.r == true) goto L47;
            if (this.a.d.getPlayState() != 3) goto L59;
            Object r4 = this.a.c;
            monitor-enter(r4);
            b r5 = this.a;     // Catch: Throwable -> L44
            if (r5.j == false) goto L30;
            boolean r6 = false;
        L34:
            monitor-exit(r4);     // Catch: Throwable -> L44
            if (r6 == false) goto L38;
            r5.b(false);
        L38:
            if (this.a.r == true) goto L43;
            if (this.a.d.getPlayState() != 3) goto L58;
            this.a.l--;
            goto L5
        L58:
            return;
        L43:
            return;
        L30:
            if (r5.k == true) goto L32;
            r5.e = null;     // Catch: Throwable -> L44
        L32:
            r6 = true;
        L44:
            th = move-exception;
            throw th;
        L59:
            return;
        L47:
            return;
        L12:
            r0.play();
            gna.a.c(r0.hashCode());
            goto L13
        L8:
            return;
        L48:
            this.a.j();
            this.a.n = 0;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public RunnableC0039b(b r1) {
            this.a = r1;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.r = true;
        Object r1 = this.c;
        monitor-enter(r1);
        AudioTrack r2 = this.d;     // Catch: Throwable -> L13
        if (r2 != null) goto L7;
    L10:
        e();     // Catch: Throwable -> L13
        this.e = null;     // Catch: Throwable -> L13
        monitor-exit(r1);     // Catch: Throwable -> L13
        return;
    L7:
        if (r2.getPlayState() == 1) goto L9;
        h();     // Catch: Throwable -> L13
    L9:
        this.d.release();     // Catch: Throwable -> L13
        this.d = null;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    public final void c() {
        c5a.c.c("SoundSample", "pause");
        AudioTrack r0 = this.d;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getPlayState() != 3) goto L24;
        Object r1 = this.c;
        monitor-enter(r1);
        d();     // Catch: Throwable -> L18
        int r2 = this.d.getPlaybackHeadPosition();     // Catch: Throwable -> L18
        if (r2 <= 0) goto L12;
        int r3 = r2 * this.m;     // Catch: Throwable -> L18
    L13:
        this.n = r3;     // Catch: Throwable -> L18
        if (this.e == null) goto L16;
        this.d.flush();     // Catch: Throwable -> L18
    L16:
        monitor-exit(r1);     // Catch: Throwable -> L18
        return;
    L12:
        r3 = 0;
    L18:
        th = move-exception;
        throw th;
    }

    public final void d() {
        c5a.c.c("SoundSample", "pauseTrackSafely");
        AudioTrack r0 = this.d;     // Catch: IllegalStateException -> L10
        if (r0 != null) goto L6;
    L13:
        return;
    L6:
        if (g.d() == true) goto L8;
        r0.pause();     // Catch: IllegalStateException -> L10
        goto L13
    L8:
        r0.pause();     // Catch: IllegalStateException -> L10
        gna.a.a(r0.hashCode());     // Catch: IllegalStateException -> L10
    L10:
        e = move-exception;
        e.printStackTrace();
    }

    public final void e() {
        c5a.c.c("SoundSample", "releaseCodec");
        c5a.c.c("SoundSample", "stopCodec");
        MediaCodec r0 = this.h;
        if (r0 != null) goto L5;
    L9:
        MediaCodec r1 = this.h;
        if (r1 == null) goto L12;
        r1.release();
        this.h = null;
        this.s = 3;
    L12:
        MediaExtractor r2 = this.g;
        if (r2 == null) goto L15;
        r2.release();
        this.g = null;
    L15:
        this.i = null;
        return;
    L5:
        if (this.s != 2) goto L9;
        r0.stop();     // Catch: IllegalStateException -> L8
        this.s = 0;     // Catch: IllegalStateException -> L8
    L8:
        this.s = -1;
        goto L9
    }

    public final boolean g() {
        if (this.h != null) goto L5;
        return false;
    L5:
        int r0 = this.s;
        if (r0 != (-1)) goto L8;
        c5a.c.c("SoundSample", "codecState:ERROR");
        this.h.reset();
        this.s = 0;
        return g();
    L8:
        if (r0 != 0) goto L10;
        c5a.c.c("SoundSample", "codecState:UNINITIALIZED");
        this.h.configure(this.i, null, null, 0);     // Catch: IllegalStateException -> L24
        this.s = 1;     // Catch: IllegalStateException -> L24
    L26:
        return g();
    L24:
        this.s = -1;
        goto L26
    L10:
        if (r0 == 1) goto L15;
        if (r0 == 2) goto L13;
        return false;
    L13:
        c5a.c.c("SoundSample", "codecState:EXECUTING");
        return true;
    L15:
        c5a.c.c("SoundSample", "codecState:CONFIGURED");
        this.h.start();     // Catch: IllegalStateException -> L18
        this.s = 2;     // Catch: IllegalStateException -> L18
        return true;
    L18:
        e = move-exception;
        e.printStackTrace();
        this.s = -1;
        return false;
    }

    public final void h() {
        c5a.c.c("SoundSample", "stop");
        AudioTrack r0 = this.d;
        if (r0 != null) goto L5;
        return;
    L5:
        int r1 = r0.getPlayState();
        if (r1 != 1) goto L8;
        return;
    L8:
        if (r1 != 3) goto L11;
        d();
    L13:
        Object r2 = this.c;
        monitor-enter(r2);
        this.n = 0;     // Catch: Throwable -> L19
        this.d.flush();     // Catch: Throwable -> L19
        j();     // Catch: Throwable -> L19
        monitor-exit(r2);     // Catch: Throwable -> L19
        return;
    L19:
        th = move-exception;
        throw th;
    L11:
        if (r1 != 2) goto L13;
        i();
        goto L13
    }

    public final void i() {
        c5a.c.c("SoundSample", "stopCodecAndSeek0");
        Object r0 = this.c;
        monitor-enter(r0);
        c5a.c.c("SoundSample", "stopCodec");     // Catch: Throwable -> L16
        MediaCodec r1 = this.h;     // Catch: Throwable -> L16
        if (r1 != null) goto L8;
    L13:
        this.g.seekTo(0, 0);     // Catch: Throwable -> L16
        monitor-exit(r0);     // Catch: Throwable -> L16
        return;
    L8:
        if (this.s != 2) goto L13;
        r1.stop();     // Catch: IllegalStateException -> L11 Throwable -> L16
        this.s = 0;     // Catch: IllegalStateException -> L11 Throwable -> L16
    L12:
        this.s = -1;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    }

    public final void j() {
        c5a.c.c("SoundSample", "stopTrackSafely");
        AudioTrack r0 = this.d;     // Catch: IllegalStateException -> L10
        if (r0 != null) goto L6;
    L13:
        return;
    L6:
        if (g.d() == true) goto L8;
        r0.stop();     // Catch: IllegalStateException -> L10
        goto L13
    L8:
        r0.stop();     // Catch: IllegalStateException -> L10
        gna.a.a(r0.hashCode());     // Catch: IllegalStateException -> L10
    L10:
        e = move-exception;
        e.printStackTrace();
    }

    public b() {
        this.b = new RunnableC0039b(this);
        this.c = new Object();
        this.j = true;
        this.l = 1;
        this.o = -1.0f;
        this.p = -1.0f;
        this.q = -1.0f;
        this.r = true;
        this.s = 0;
        this.a = 4194304;
        this.k = false;
    }

    public final void b(boolean r22) {
        if (g() == true) goto L5;
        return;
    L5:
        ByteBuffer[] r0 = this.h.getOutputBuffers();
        MediaCodec.BufferInfo r2 = new MediaCodec.BufferInfo();
        long r4 = 0;
        boolean r6 = false;
        boolean r7 = false;
    L6:
        if (r6 == true) goto L70;
    L68:
        this.s = -1;
        goto L70
    L8:
        if (this.r == true) goto L9;
        Object r9 = this.c;     // Catch: Exception -> L68
        monitor-enter(r9);     // Catch: Exception -> L68
        if (r7 == false) goto L87;
    L27:
        monitor-exit(r9);     // Catch: Throwable -> L65
        Object r8 = this.c;     // Catch: Exception -> L68
        monitor-enter(r8);     // Catch: Exception -> L68
        int r10 = this.h.dequeueOutputBuffer(r2, 1000);     // Catch: Throwable -> L62
        c5a.c.c("SoundSample", "dequeueOutputBuffer:" + r10);     // Catch: Throwable -> L62
        if (r10 < 0) goto L58;
        ByteBuffer r11 = r0[r10];     // Catch: Throwable -> L62
        if (r22 == false) goto L41;
        int r13 = this.f + r2.size;     // Catch: Throwable -> L62
        byte[] r12 = this.e;     // Catch: Throwable -> L62
        if (r13 <= r12.length) goto L37;
        this.e = Arrays.copyOf(r12, r12.length + (r12.length / 8));     // Catch: Throwable -> L62
    L37:
        r11.get(this.e, this.f, r2.size);     // Catch: Throwable -> L62
        int r14 = this.f + r2.size;     // Catch: Throwable -> L62
        this.f = r14;     // Catch: Throwable -> L62
        if (r14 <= this.a) goto L53;
        this.j = false;     // Catch: Throwable -> L62
    L52:
        r6 = true;
    L53:
        r11.clear();     // Catch: Throwable -> L62
        this.h.releaseOutputBuffer(r10, false);     // Catch: Throwable -> L62
        if ((r2.flags & 4) == 0) goto L56;
        r6 = true;
    L56:
        c5a.c.c("SoundSample", "sawOutputEOS:" + r6);     // Catch: Throwable -> L62
    L60:
        monitor-exit(r8);     // Catch: Throwable -> L62
        goto L6
    L41:
        if (this.r == true) goto L52;
        int r15 = r2.size;     // Catch: Throwable -> L62
        byte[] r16 = new byte[r15];     // Catch: Throwable -> L62
        r11.get(r16);     // Catch: Throwable -> L62
        AudioTrack r17 = this.d;     // Catch: Throwable -> L62
        if (r17 == null) goto L52;
        if (r17.getPlayState() != 3) goto L52;
        this.d.write(r16, 0, r15);     // Catch: Throwable -> L62
        if (this.k == false) goto L53;
        int r18 = this.f + r15;     // Catch: Throwable -> L62
        byte[] r19 = this.e;     // Catch: Throwable -> L62
        if (r18 <= r19.length) goto L51;
        this.e = Arrays.copyOf(r19, r19.length + (r19.length / 8));     // Catch: Throwable -> L62
    L51:
        System.arraycopy(r16, 0, this.e, this.f, r15);     // Catch: Throwable -> L62
        this.f += r15;     // Catch: Throwable -> L62
        goto L53
    L58:
        if (r10 != (-3)) goto L60;
        r0 = this.h.getOutputBuffers();     // Catch: Throwable -> L62
        goto L60
    L62:
        th = move-exception;
        throw th;     // Catch: Exception -> L68
    L87:
        int r110 = this.h.dequeueInputBuffer(1000);     // Catch: Throwable -> L65
        c5a.c.c("SoundSample", "dequeueInputBuffer:" + r110);     // Catch: Throwable -> L65
        if (r110 < 0) goto L27;
        int r20 = this.g.readSampleData(this.h.getInputBuffers()[r110], 0);     // Catch: Throwable -> L65
        if (r20 > 0) goto L19;
        r7 = true;
        int r111 = 0;
    L20:
        MediaCodec r112 = this.h;     // Catch: Throwable -> L65
        if (r7 == false) goto L23;
        int r21 = 4;
    L24:
        r112.queueInputBuffer(r110, 0, r111, r4, r21);     // Catch: Throwable -> L65
        if (r7 == true) goto L27;
        this.g.advance();     // Catch: Throwable -> L65
        goto L27
    L23:
        r21 = 0;
        goto L24
    L19:
        r4 = this.g.getSampleTime();     // Catch: Throwable -> L65
        r111 = r20;
        goto L20
    L65:
        th = move-exception;
        throw th;     // Catch: Exception -> L68
    L9:
        return;
    L70:
        if (this.j == false) goto L72;
        e();
        return;
    L72:
        if (r22 == true) goto L92;
        AudioTrack r1 = this.d;
        if (r1 != null) goto L76;
        return;
    L76:
        if (r1.getPlayState() != 2) goto L78;
        return;
    L78:
        if (this.k == true) goto L80;
        i();
        return;
    L80:
        if (this.d.getPlayState() == 1) goto L95;
        this.j = true;
        e();
        return;
    L95:
        return;
    }

    public final void f(float r3, float r4) {
        AudioTrack r0 = this.d;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.o == r3) goto L7;
    L8:
        this.o = r3;
        this.p = r4;
        r0.setStereoVolume(r3, r4);
        return;
    L7:
        if (this.p != r4) goto L8;
    }

    public final boolean a(FileDescriptor r23, long r24, long r26) {
        this.r = false;
        Object r12 = this.c;
        monitor-enter(r12);
    L82:
        th = move-exception;
        throw th;
    L5:
        if (this.k == true) goto L7;
    L9:
        boolean r0 = false;
    L10:
        this.k = r0;     // Catch: Throwable -> L82
        int r14 = 12;
        if (r0 == false) goto L13;
        byte[] r1 = new byte[((int) r26) * 12];     // Catch: Throwable -> L82
    L14:
        this.e = r1;     // Catch: Throwable -> L82
        MediaExtractor r2 = new MediaExtractor();     // Catch: Throwable -> L82
        this.g = r2;     // Catch: Throwable -> L82
        r2.setDataSource(r23, r24, r26);     // Catch: IOException -> L18 Throwable -> L82
    L21:
        this.i = null;     // Catch: Throwable -> L82
        int r3 = 44100;
        MediaFormat r4 = this.g.getTrackFormat(0);     // Catch: Exception -> L31 Throwable -> L82
        this.i = r4;     // Catch: Exception -> L31 Throwable -> L82
        if (r4 == null) goto L30;
        r4.setInteger("max-input-size", 0);     // Catch: Exception -> L31 Throwable -> L82
        String r5 = this.i.getString("mime");     // Catch: Exception -> L31 Throwable -> L82
        r3 = this.i.getInteger("sample-rate");     // Catch: Exception -> L28 Throwable -> L82
        int r6 = this.i.getInteger("channel-count");     // Catch: Exception -> L28 Throwable -> L82
        String r7 = r5;
        int r8 = r3;
    L36:
        if (this.i == null) goto L79;
        if (r7 == null) goto L79;
        if (r7.startsWith("audio/") == false) goto L79;
        this.h = MediaCodec.createDecoderByType(r7);     // Catch: Exception -> L43 Throwable -> L82
    L46:
        if (this.h != null) goto L48;
    L76:
        close();     // Catch: Throwable -> L82
        monitor-exit(r12);     // Catch: Throwable -> L82
        return false;
    L48:
        if (this.i == null) goto L76;
        this.s = 0;     // Catch: Throwable -> L82
        this.g.selectTrack(0);     // Catch: Throwable -> L82
        b(true);     // Catch: Throwable -> L82
        if (this.r == false) goto L54;
        monitor-exit(r12);     // Catch: Throwable -> L82
        return false;
    L54:
        if (r6 != 1) goto L56;
        r14 = 4;
    L56:
        int r9 = AudioTrack.getMinBufferSize(r8, r14, 2);     // Catch: Throwable -> L82
        if (this.j == true) goto L59;
    L61:
        r9 = r9 * 2;     // Catch: Throwable -> L82
    L62:
        this.d = new AudioTrack(new AudioAttributes.Builder().setUsage(1).setContentType(2).build(), new AudioFormat.Builder().setSampleRate(r8).setEncoding(2).setChannelMask(r14).build(), r9, 1, 0);     // Catch: Throwable -> L82
        this.m = r6 * 2;     // Catch: Throwable -> L82
        StringBuilder r10 = new StringBuilder(" fileSize(Kb): ");     // Catch: Throwable -> L82
        r10.append(r26 / 1024);     // Catch: Throwable -> L82
        r10.append(", loadedSize(Kb): ");     // Catch: Throwable -> L82
        if (this.e != null) goto L65;
        Object r11 = "0";
    L66:
        r10.append(r11);     // Catch: Throwable -> L82
        r10.append(", writeBuffSize(Bytes): ");     // Catch: Throwable -> L82
        r10.append(r9);     // Catch: Throwable -> L82
        r10.append(", mIsFullyLoaded: ");     // Catch: Throwable -> L82
        r10.append(this.j);     // Catch: Throwable -> L82
        r10.append(", isStatic: ");     // Catch: Throwable -> L82
        r10.append(this.k);     // Catch: Throwable -> L82
        c5a.c.c("SoundSample", r10.toString());     // Catch: Throwable -> L82
        monitor-exit(r12);     // Catch: Throwable -> L82
        AudioTrack r13 = this.d;
        if (r13 != null) goto L71;
    L74:
        close();
        return false;
    L71:
        if (r13.getState() == 0) goto L74;
        return true;
    L65:
        r11 = Integer.valueOf(this.f / 1024);     // Catch: Throwable -> L82
        goto L66
    L59:
        if (r26 >= 20480) goto L61;
    L43:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L82
        this.h = null;     // Catch: Throwable -> L82
    L79:
        close();     // Catch: Throwable -> L82
        monitor-exit(r12);     // Catch: Throwable -> L82
        return false;
    L28:
        e = e;
    L33:
        e.printStackTrace();     // Catch: Throwable -> L82
    L34:
        r7 = r5;
        r8 = r3;
        r6 = 1;
        goto L36
    L30:
        r5 = null;
    L31:
        e = e;
        r5 = null;
        goto L33
    L18:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L82
        goto L21
    L13:
        r1 = new byte[this.a * 14];     // Catch: Throwable -> L82
        goto L14
    L7:
        if (r26 >= 204800) goto L9;
        r0 = true;
        goto L10
    }
}
