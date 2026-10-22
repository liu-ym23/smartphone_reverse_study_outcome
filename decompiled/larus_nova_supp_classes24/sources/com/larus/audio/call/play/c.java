package com.larus.audio.call.play;

import android.media.AudioTrack;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.audio.call.RealtimeCallParam;
import com.larus.audio.call.play.abs.TtsPlayEndType;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import kotlin.collections.ArraysKt;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class c extends AbsAudioPlayManager {
    public final RealtimeCallParam f;
    public final int g;
    public final int h;
    public volatile boolean i;
    public volatile float j;
    public final String k;
    public final LinkedBlockingQueue<h> l;
    public volatile b m;
    public volatile AudioTrack n;
    public volatile boolean o;
    public volatile AbsAudioPlayManager.Wait p;
    public volatile boolean q;
    public volatile int r;
    public int s;
    public final int t;
    public volatile boolean u;
    public final String v;
    public volatile boolean w;

    public static final class a {
    }

    public static final class b extends PthreadThreadV2 {
        public final /* synthetic */ c v;

        public final void l() {
            super.run();
            com.larus.audio.call.util.e.a.i(this.v.t(), "StartLoop: isInterrupted:" + isInterrupted() + ",  callFinished:" + this.v.w);
        L4:
            if (isInterrupted() == true) goto L37;
            if (this.v.w == true) goto L37;
            this.v.q = false;     // Catch: Exception -> L10 InterruptedException -> L35
            c.o(this.v);     // Catch: Exception -> L10 InterruptedException -> L35
        L12:
            c r1 = this.v;
            r1.getClass();
            if (com.larus.audio.call.f.d().v == true) goto L15;
            if (r1.l.size() != 0) goto L4;
            if (r1.o == false) goto L4;
            com.larus.audio.call.util.e r2 = com.larus.audio.call.util.e.a;
            r2.i(r1.t(), "onPlayEnd fixAudioPlayManagerPlayEnd(false)");
            r1.o = false;
            u68.a.b.C0131a.a(r1.e);
            if (r1.p != AbsAudioPlayManager.Wait.DATA_END) goto L4;
            r2.i(r1.t(), "onPlayComplete fixAudioPlayManagerPlayEnd(false)");
            r1.w(AbsAudioPlayManager.Wait.COMPLETE);
            r1.e.onPlayComplete();
            goto L4
        L15:
            if (r1.l.size() != 0) goto L4;
            if (r1.o == false) goto L4;
            if (r1.p == AbsAudioPlayManager.Wait.DATA_END) goto L20;
            if (r1.p == AbsAudioPlayManager.Wait.STOPPED) goto L23;
            if (r1.s >= r1.t) goto L26;
            com.larus.audio.call.util.e.a.i(r1.t(), "waitForPlayEndCount = " + r1.s);
            r1.s = r1.s + 1;
            goto L4
        L26:
            com.larus.audio.call.util.e.a.i(r1.t(), "onPlayEnd, waitForPlayEndCount = " + r1.s);
            r1.e.f(TtsPlayEndType.TIMEOUT);
            r1.s = 0;
            r1.o = false;
            goto L4
        L23:
            r1.o = false;
            com.larus.audio.call.util.e.a.i(r1.t(), "onPlayEnd Wait.STOPPED");
            u68.a.b.C0131a.a(r1.e);
            goto L4
        L20:
            com.larus.audio.call.util.e r3 = com.larus.audio.call.util.e.a;
            r3.i(r1.t(), "onPlayEnd Wait.DATA_END");
            r1.o = false;
            u68.a.b.C0131a.a(r1.e);
            r1.w(AbsAudioPlayManager.Wait.COMPLETE);
            r3.i(r1.t(), "onPlayComplete Wait.DATA_END");
            r1.e.onPlayComplete();
            goto L4
        L35:
            e = move-exception;
            com.larus.audio.call.util.e.a.e(this.v.t(), "InterruptedException.", e);
        L10:
            e = move-exception;
            com.larus.audio.call.util.e.a.e(this.v.t(), "unknown exception.", e);
        L37:
            com.larus.audio.call.util.e.a.e(this.v.t(), "OutLoop: isInterrupted:" + isInterrupted() + ",  callFinished:" + this.v.w);
        }

        public final void run() {
            l();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(c r1, String r2) {
            this.v = r1;
            super(r2);
        }
    }

    static {
    }

    public int p() {
        return 1;
    }

    @Override // u68.a
    public final void a() {
        w(AbsAudioPlayManager.Wait.WAIT);
    }

    @Override // u68.a
    public void b() {
        com.larus.audio.call.util.e.a.i(t(), "audio play interrupt");
        this.e.e(this.o);
        d(true, true, "client_interrupt");
        u68.a.C0130a.a(this, false, "client_interrupt", 3);
        this.q = true;
    }

    @Override // u68.a
    public final void h() {
        com.larus.audio.call.util.e.a.i(t(), "audio play clearTTS");
        this.l.clear();
    }

    @Override // u68.c
    public void init() {
        if (Intrinsics.areEqual(this.f.k.o, "dora_si") == true) goto L5;
    L8:
        e(true);
        this.m = new b(this, this.v);
        PthreadThreadV2 r0 = this.m;     // Catch: Exception -> L16
        if (r0 == null) goto L12;
        ThreadMethodProxy.setPriority(r0, 10);     // Catch: Exception -> L16
    L12:
        PthreadThreadV2 r1 = this.m;     // Catch: Exception -> L16
        if (r1 == null) goto L21;
        ThreadMethodProxy.start(r1);     // Catch: Exception -> L16
        return;
    L21:
        return;
    L16:
        e = move-exception;
        com.larus.audio.call.util.e.a.e(t(), "AudioPlayManager start thread failed.", e);
        return;
    L5:
        if (this.h != 1) goto L8;
        com.larus.audio.call.util.e.a.i(t(), "no init in Lite si");
    }

    public boolean q() {
        if (this.p != AbsAudioPlayManager.Wait.STOPPED) goto L5;
    L7:
        return false;
    L5:
        if (this.p == AbsAudioPlayManager.Wait.COMPLETE) goto L7;
        return true;
    }

    public int r() {
        int r0 = AudioTrack.getMinBufferSize(l().c, l().d, l().e);
        if (r0 <= 0) goto L5;
        return r0;
    L5:
        return l().b;
    }

    @Override // u68.a
    public boolean isPlaying() {
        return this.o;
    }

    public String t() {
        return this.k;
    }

    public static void m(AudioTrack r1) {
        if (fna.g.d() == true) goto L6;
        r1.pause();
        return;
    L6:
        r1.pause();
        gna.a.a(r1.hashCode());
    }

    public static void n(AudioTrack r1) {
        if (fna.g.d() == true) goto L6;
        r1.stop();
        return;
    L6:
        r1.stop();
        gna.a.a(r1.hashCode());
    }

    public static final void o(c r4) {
        r4.getClass();
        if (com.larus.audio.call.f.d().v == false) goto L7;
        h r0 = r4.l.poll(10, TimeUnit.MILLISECONDS);
        if (r0 == null) goto L11;
        r4.u(r0);
        return;
    L11:
        return;
    L7:
        h r1 = r4.l.take();
        if (r1 == null) goto L13;
        r4.u(r1);
        return;
    }

    @Override // com.larus.audio.call.play.AbsAudioPlayManager, u68.a
    public final void c(boolean r5) {
        com.larus.audio.call.util.e.a.i(t(), "mutePlay: enable=" + r5 + ", previousMuted=" + this.i + ", lastGain=" + this.j);
        if (this.i != r5) goto L5;
        return;
    L5:
        this.i = r5;
        AudioTrack r0 = this.n;     // Catch: Throwable -> L13
        if (r0 == null) goto L18;
        if (r5 == false) goto L10;
        float r6 = 0.0f;
    L11:
        r0.setVolume(r6);     // Catch: Throwable -> L13
        return;
    L10:
        r6 = this.j;     // Catch: Throwable -> L13
        goto L11
    L18:
        return;
    L13:
        th = move-exception;
        com.larus.audio.call.util.e.a.e(t(), "mutePlay setVolume error: " + th.getMessage(), th);
    }

    @Override // u68.a
    public final void e(boolean r12) {
        if (this.n == null) goto L7;
        if (r12 == true) goto L7;
        com.larus.audio.call.util.e.a.i(t(), "audio play createPlayEngine, audioTrack is not null");
        return;
    L7:
        com.larus.audio.call.util.e r13 = com.larus.audio.call.util.e.a;
        r13.i(t(), "audio play createPlayEngine");
        this.r = r();     // Catch: Exception -> L17
        r13.i(t(), "createPlayEngine, minBufferSize=" + this.r);     // Catch: Exception -> L17
        this.n = new AudioTrack(l().a, l().c, l().d, l().e, this.r * p(), 1, 0);     // Catch: Exception -> L17
        if (this.i == true) goto L23;
    L20:
        return;
    L23:
        AudioTrack r14 = this.n;     // Catch: Throwable -> L14
        if (r14 == null) goto L20;
        r14.setVolume(0.0f);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        com.larus.audio.call.util.e.a.e(t(), "createPlayEngine reapply mute error: " + th.getMessage(), th);     // Catch: Exception -> L17
    L17:
        e = move-exception;
        com.larus.audio.call.util.e.a.e(t(), e.getMessage(), e);
    }

    @Override // u68.b
    public void g(h r6) {
        Intrinsics.checkNotNullParameter(r6, "data");
        com.larus.audio.call.util.e r0 = com.larus.audio.call.util.e.a;
        String r1 = t();
        StringBuilder r2 = new StringBuilder("audio play enqueue: ");
        r2.append(this.l.size());
        r2.append(", data type is play= ");
        boolean r3 = r6 instanceof h.a;
        r2.append(r3);
        r2.append(", data:");
        String r4 = null;
        if (r3 == false) goto L5;
        h.a r5 = (h.a) r6;
    L6:
        if (r5 == null) goto L8;
        r4 = r5.b;
    L8:
        r2.append(r4);
        r2.append(' ');
        r0.i(r1, r2.toString());
        this.l.offer(r6);
        return;
    L5:
        r5 = null;
        goto L6
    }

    @Override // u68.a
    public void pause(String r5) {
        Intrinsics.checkNotNullParameter(r5, "caller");
        com.larus.audio.call.util.e.a.i(t(), "audio play pause, caller: " + r5);
        this.e.onPaused();
        w(AbsAudioPlayManager.Wait.PAUSED);
        AudioTrack r6 = this.n;     // Catch: IllegalStateException -> L7
        if (r6 == null) goto L12;
        m(r6);     // Catch: IllegalStateException -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        com.larus.audio.call.util.e.a.e(t(), "AudioTrack error while pause.", e);
    }

    @Override // u68.a
    public void release(boolean r5) {
        com.larus.audio.call.util.e.a.i(t(), "audio play release " + r5);
        d(true, true, "stop_session");
        ((CopyOnWriteArraySet) this.e.b).clear();
        this.w = r5;     // Catch: Exception -> L7
        b r6 = this.m;     // Catch: Exception -> L7
        if (r6 == null) goto L12;
        r6.interrupt();     // Catch: Exception -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        com.larus.audio.call.util.e.a.e(t(), "release error", e);
    }

    @Override // u68.a
    public void resume(String r5) {
        Intrinsics.checkNotNullParameter(r5, "caller");
        com.larus.audio.call.util.e.a.i(t(), "audio play resume, caller: " + r5);
        u68.a.C0130a.a(this, false, "resume -> " + r5, 3);
        w(AbsAudioPlayManager.Wait.RESUME);
        this.e.onResume();
    }

    public byte[] s(byte[] r11) {
        if (r11 != null) goto L6;
        return null;
    L6:
        if (this.a == true) goto L8;
    L20:
        return r11;
    L8:
        if (this.b == false) goto L20;
        byte[] r0 = new byte[r11.length * 2];
        int r2 = ProgressionUtilKt.getProgressionLastElement(0, r11.length - 1, 2);
        if (r2 < 0) goto L19;
        int r4 = 0;
        int r5 = 0;
    L12:
        int r7 = r4 + 1;
        short r6 = (short) ((r11[r4] & 255) | ((r11[r7] & 255) << 8));
        if (com.larus.audio.call.f.c().e() == true) goto L16;
        r6 = (short) (r6 >> 1);
    L16:
        byte[] r9 = {(byte) (r6 & 255), (byte) (r6 >> 8)};
        r0[r5] = r11[r4];
        r0[r5 + 1] = r11[r7];
        r0[r5 + 2] = r9[0];
        r0[r5 + 3] = r9[1];
        r5 = r5 + 4;
        if (r4 == r2) goto L19;
        r4 = r4 + 2;
    L19:
        return r0;
    }

    @Override // u68.a
    public void setVolume(float r5) {
        com.larus.audio.call.util.e.a.i(t(), "setVolume (), gain: " + r5 + ", isMuted: " + this.i);     // Catch: Throwable -> L9
        this.j = r5;     // Catch: Throwable -> L9
        if (this.i == true) goto L14;
        AudioTrack r0 = this.n;     // Catch: Throwable -> L9
        if (r0 == null) goto L15;
        r0.setVolume(r5);     // Catch: Throwable -> L9
        return;
    L15:
        return;
    L14:
        return;
    L9:
        th = move-exception;
        com.larus.audio.call.util.e.a.e(t(), th.getMessage(), th);
    }

    public final void u(h r6) {
        if ((r6 instanceof h.d) == false) goto L6;
        com.larus.audio.call.util.e.a.i(t(), "audio play poll: Warmup");
        v(((h.d) r6).a);
        return;
    L6:
        if ((r6 instanceof h.c) == false) goto L32;
        com.larus.audio.call.util.e r0 = com.larus.audio.call.util.e.a;
        r0.i(t(), "audio play poll: TtsStart");
        boolean r1 = false;
        this.u = false;
        AudioTrack r2 = this.n;
        if (r2 != null) goto L10;
    L12:
        if (r1 == false) goto L25;
        AudioTrack r3 = this.n;
        if (r3 == null) goto L16;
        n(r3);
    L16:
        AudioTrack r4 = this.n;
        if (r4 == null) goto L19;
        r4.flush();
    L19:
        AudioTrack r5 = this.n;
        if (r5 == null) goto L25;
        if (fna.g.d() == true) goto L24;
        r5.play();
        goto L25
    L24:
        r5.play();
        gna.a.c(r5.hashCode());
    L25:
        AudioTrack r7 = this.n;
        if (r7 == null) goto L30;
        r0.i(t(), "[tts_start]:setPositionNotification");
        r7.setPositionNotificationPeriod(this.g);
        r7.setNotificationMarkerPosition(r7.getPlaybackHeadPosition() + 1);
        long r8 = System.currentTimeMillis();
        AudioTrack r9 = this.n;
        if (r9 == null) goto L30;
        r9.setPlaybackPositionUpdateListener(new d(this, r8));
    L30:
        w(AbsAudioPlayManager.Wait.WAIT);
        this.e.b(((h.c) r6).a);
        return;
    L10:
        if (r2.getPlayState() != 3) goto L12;
        r1 = true;
        goto L12
    L32:
        if ((r6 instanceof h.a) == false) goto L38;
        com.larus.audio.call.util.e r10 = com.larus.audio.call.util.e.a;
        r10.i(t(), "audio play poll: Play");
        if (q() == false) goto L36;
        h.a r11 = (h.a) r6;
        this.e.d(r11);
        v(r11.a);
        return;
    L36:
        r10.i(t(), "playData, waitPCM == " + this.p);
        return;
    L38:
        if ((r6 instanceof h.b) == false) goto L40;
        com.larus.audio.call.util.e.a.i(t(), "audio play poll: TtsEnd");
        w(AbsAudioPlayManager.Wait.DATA_END);
        this.e.a();
        return;
    L40:
        Thread.sleep(100);
    }

    public final void v(byte[] r10) {
        byte[] r0 = s(r10);
        if (r0 != null) goto L5;
        return;
    L5:
        this.o = true;
        com.larus.audio.call.util.e r2 = com.larus.audio.call.util.e.a;
        String r3 = t();
        StringBuilder r4 = new StringBuilder("[playData] playData, data size: ");
        r4.append(r0.length);
        r4.append(", origin size: ");
        if (r10 == null) goto L8;
        Integer r11 = Integer.valueOf(r10.length);
    L9:
        r4.append(r11);
        r2.i(r3, r4.toString());
        int r5 = 0;
    L11:
        if (r5 >= r0.length) goto L63;
        if (this.n == null) goto L42;
        if (this.q == true) goto L42;
        AudioTrack r6 = this.n;
        if (r6 == null) goto L64;
        int r7 = RangesKt.coerceAtMost(this.r, r0.length - r5);
        int r8 = (r5 + r7) - 1;
        if (r8 <= r5) goto L24;
        this.e.g(ArraysKt.copyOfRange(r0, r5, r8));
    L24:
        if (q() == false) goto L25;
        if (r0.length != 0) goto L29;
        boolean r9 = true;
    L31:
        if ((!r9) == false) goto L11;
        if (r7 <= 0) goto L11;
        int r12 = r6.write(r0, r5, r7);     // Catch: Exception -> L35
    L37:
        if (r12 < 0) goto L38;
        if (r12 == 0) goto L40;
        com.larus.audio.call.util.e.a.i(t(), "[playData] AudioTrack write data normal, writeSize is: " + r12);
        int r13 = r12 + r5;
        this.e.i(ArraysKt.copyOfRange(r0, r5, r13));
        this.s = 0;
        r5 = r13;
        goto L11
    L40:
        Thread.sleep(10);
        com.larus.audio.call.util.e.a.e(t(), "[playData] AudioTrack write data zero.");
        goto L11
    L38:
        Thread.sleep(50);
        com.larus.audio.call.util.e.a.e(t(), "[playData] AudioTrack write data error, errorCode: " + r12 + '.');
    L35:
        e = move-exception;
        com.larus.audio.call.util.e.a.e(t(), "[playData] AudioTrack write data error.", e);
        this.q = true;
        r12 = -1;
        goto L37
    L29:
        r9 = false;
        goto L31
    L25:
        com.larus.audio.call.util.e.a.i(t(), "[playData] break. waitPCM:" + this.p);
        return;
    L64:
        return;
    L42:
        Thread.sleep(50);
        com.larus.audio.call.util.e.a.e(t(), "[playData] AudioTrack null break. needBreak:" + this.q);
        return;
    L63:
        return;
    L8:
        r11 = null;
        goto L9
    }

    public final void w(AbsAudioPlayManager.Wait r5) {
        Intrinsics.checkNotNullParameter(r5, "value");
        if (this.p == r5) goto L5;
        com.larus.audio.call.util.e.a.i(t(), "waitPCM change, from: " + this.p + " to " + r5);
    L5:
        this.p = r5;
    }

    public c(RealtimeCallParam r8, boolean r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r8, "realtimeCallParam");
        this(r8, r9, r10, null, 0);
    }

    @Override // u68.a
    public void d(boolean r5, boolean r6, String r7) {
        Intrinsics.checkNotNullParameter(r7, "endType");
        com.larus.audio.call.util.e.a.i(t(), "audio play stop, immediate: " + r5 + ", release: " + r6 + ", " + r7 + '.');
        w(AbsAudioPlayManager.Wait.STOPPED);
        this.l.clear();     // Catch: IllegalStateException -> L21
        if (r5 == false) goto L14;
        AudioTrack r8 = this.n;     // Catch: IllegalStateException -> L21
        if (r8 == null) goto L8;
        m(r8);     // Catch: IllegalStateException -> L21
    L8:
        AudioTrack r9 = this.n;     // Catch: IllegalStateException -> L21
        if (r9 == null) goto L11;
        r9.flush();     // Catch: IllegalStateException -> L21
    L11:
        AudioTrack r10 = this.n;     // Catch: IllegalStateException -> L21
        if (r10 == null) goto L23;
        n(r10);     // Catch: IllegalStateException -> L21
    L23:
        if (r6 == true) goto L39;
        return;
    L39:
        AudioTrack r11 = this.n;     // Catch: Throwable -> L30 IllegalStateException -> L32
        if (r11 == null) goto L28;
        r11.release();     // Catch: Throwable -> L30 IllegalStateException -> L32
    L28:
        this.n = null;     // Catch: Throwable -> L30 IllegalStateException -> L32
    L34:
        this.n = null;
        return;
    L30:
        th = move-exception;
        this.n = null;
        throw th;
    L32:
        e = move-exception;
        com.larus.audio.call.util.e.a.e(t(), "AudioTrack release while stop.", e);     // Catch: Throwable -> L30
        goto L34
    L14:
        AudioTrack r12 = this.n;     // Catch: IllegalStateException -> L21
        if (r12 == null) goto L17;
        n(r12);     // Catch: IllegalStateException -> L21
    L17:
        AudioTrack r13 = this.n;     // Catch: IllegalStateException -> L21
        if (r13 == null) goto L23;
        r13.flush();     // Catch: IllegalStateException -> L21
    L21:
        e = move-exception;
        com.larus.audio.call.util.e.a.e(t(), "AudioTrack error while stop.", e);
        goto L23
    }

    @Override // u68.a
    public void k(boolean r6, boolean r7, String r8) {
        Intrinsics.checkNotNullParameter(r8, "caller");
        if (Intrinsics.areEqual(this.f.k.o, "dora_si") == true) goto L5;
    L8:
        com.larus.audio.call.util.e r0 = com.larus.audio.call.util.e.a;
        String r2 = t();
        StringBuilder r3 = new StringBuilder("audio play, playState: ");
        AudioTrack r4 = this.n;
        if (r4 == null) goto L11;
        Integer r5 = Integer.valueOf(r4.getPlayState());
    L12:
        r3.append(r5);
        r3.append(", earphone: ");
        r3.append(com.larus.audio.call.f.c().e());
        r3.append(", flush: ");
        r3.append(r6);
        r3.append(", create: ");
        r3.append(r7);
        r3.append(", caller: ");
        r3.append(r8);
        r0.i(r2, r3.toString());
        if (this.n == null) goto L22;
        AudioTrack r9 = this.n;
        if (r9 != null) goto L17;
    L19:
        boolean r10 = false;
    L20:
        if (r10 == true) goto L22;
        r0.e(t(), "audio play, init error");
        e(true);
        goto L22
    L17:
        if (r9.getState() != 1) goto L19;
        r10 = true;
    L22:
        if (r7 == true) goto L24;
    L26:
        if (r6 == true) goto L45;
    L33:
        AudioTrack r11 = this.n;     // Catch: Exception -> L40 IllegalStateException -> L42
        if (r11 != null) goto L36;
        return;
    L36:
        if (fna.g.d() == true) goto L38;
        r11.play();     // Catch: Exception -> L40 IllegalStateException -> L42
        return;
    L38:
        r11.play();     // Catch: Exception -> L40 IllegalStateException -> L42
        gna.a.c(r11.hashCode());     // Catch: Exception -> L40 IllegalStateException -> L42
        return;
    L45:
        AudioTrack r12 = this.n;     // Catch: Exception -> L40 IllegalStateException -> L42
        if (r12 == null) goto L30;
        m(r12);     // Catch: Exception -> L40 IllegalStateException -> L42
    L30:
        AudioTrack r13 = this.n;     // Catch: Exception -> L40 IllegalStateException -> L42
        if (r13 == null) goto L33;
        r13.flush();     // Catch: Exception -> L40 IllegalStateException -> L42
    L42:
        e = move-exception;
        com.larus.audio.call.util.e.a.e(t(), "AudioTrack error while play.", e);
        return;
    L40:
        e = move-exception;
        com.larus.audio.call.util.e.a.e(t(), e.getMessage(), e);
        return;
    L24:
        if (this.n != null) goto L26;
        e(false);
        goto L26
    L11:
        r5 = null;
        goto L12
    L5:
        if (this.h != 1) goto L8;
        com.larus.audio.call.util.e.a.i(t(), "no play in Lite si");
    }

    public c(RealtimeCallParam r2, boolean r3, boolean r4, Integer r5, int r6) {
        Intrinsics.checkNotNullParameter(r2, "realtimeCallParam");
        super(r3, r4, r5);
        this.f = r2;
        this.g = 10;
        this.h = r6;
        this.j = 1.0f;
        this.k = "AudioPlayManager" + hashCode();
        this.l = new LinkedBlockingQueue();
        this.p = AbsAudioPlayManager.Wait.INVALID;
        this.r = 1280;
        this.t = 100;
        this.v = "flow-audio-play-manager";
    }
}
