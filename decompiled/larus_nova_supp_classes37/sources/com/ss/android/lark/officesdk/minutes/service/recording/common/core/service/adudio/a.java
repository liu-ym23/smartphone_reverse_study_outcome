package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio;

import android.media.AudioRecord;
import com.ss.android.lark.officesdk.minutes.api.recording.common.external_audio.ExternalAudioSourceMode;
import fna.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a implements sub.b {
    public AudioRecord a;
    public int b;

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.a$a, reason: collision with other inner class name */
    public static final class C0024a {
    }

    static {
    }

    public a() {
    }

    @Override // sub.b
    public final void a() {
    }

    @Override // sub.b
    public final void c() {
    }

    @Override // sub.b
    public final void close() {
        lvb.a.e("AudioRecordExtSource", "Closing AudioRecord");
        AudioRecord r1 = this.a;     // Catch: Exception -> L10
        if (r1 != null) goto L6;
    L20:
    L23:
        AudioRecord r2 = this.a;     // Catch: Exception -> L16
        if (r2 == null) goto L18;
        e(r2);     // Catch: Exception -> L16
    L18:
        this.a = null;
        this.b = 0;
        return;
    L16:
        e = move-exception;
        lvb.a.b("AudioRecordExtSource", "Error releasing AudioRecord: " + e);
        goto L18
    L6:
        if (g.d() == true) goto L8;
        g(r1);     // Catch: Exception -> L10
        goto L20
    L8:
        g(r1);     // Catch: Exception -> L10
        hna.a.c(r1.hashCode());     // Catch: Exception -> L10
    L10:
        e = move-exception;
        lvb.a.b("AudioRecordExtSource", "Error stopping AudioRecord: " + e);
        goto L23
    }

    @Override // sub.b
    public final void pause() {
        lvb.a.e("AudioRecordExtSource", "pause");
        AudioRecord r1 = this.a;     // Catch: Exception -> L10
        if (r1 != null) goto L6;
    L13:
        return;
    L6:
        if (g.d() == true) goto L8;
        g(r1);     // Catch: Exception -> L10
        goto L13
    L8:
        g(r1);     // Catch: Exception -> L10
        hna.a.c(r1.hashCode());     // Catch: Exception -> L10
    L10:
        e = move-exception;
        lvb.a.b("AudioRecordExtSource", "Error pausing AudioRecord: " + e);
    }

    @Override // sub.b
    public final sub.b.c startCapture() {
        lvb.a.e("AudioRecordExtSource", "startCapture");
        AudioRecord r1 = this.a;
        if (r1 != null) goto L15;
        lvb.a.b("AudioRecordExtSource", "AudioRecord not initialized");
        return new sub.b.c(false, "AudioRecord not initialized");
    L15:
    L12:
        e = move-exception;
        String r2 = "Failed to start AudioRecord: " + e.getMessage();
        lvb.a.b("AudioRecordExtSource", r2);
        return new sub.b.c(false, r2);
    L7:
        if (g.d() == true) goto L9;
        f(r1);     // Catch: Exception -> L12
    L10:
        lvb.a.e("AudioRecordExtSource", "AudioRecord started recording successfully");     // Catch: Exception -> L12
        return new sub.b.c(true, null);
    L9:
        f(r1);     // Catch: Exception -> L12
        hna.a.b(r1.hashCode());     // Catch: Exception -> L12
        goto L10
    }

    @Override // sub.b
    public final ExternalAudioSourceMode b() {
        return ExternalAudioSourceMode.PCM_PULL;
    }

    public static void e(AudioRecord r12) {
        f06.c r8 = new f06.c();
        Object[] r9 = new Object[0];
        f06.b r10 = new f06.b();
        if (r8.b(100403, "android/media/AudioRecord", "release", r12, r9, "void", r10).a == false) goto L6;
        r8.a(100403, "android/media/AudioRecord", "release", r12, r9, null, r10, false);
        return;
    L6:
        r12.release();
        r8.a(100403, "android/media/AudioRecord", "release", r12, r9, null, r10, true);
    }

    public static void f(AudioRecord r12) {
        f06.c r8 = new f06.c();
        Object[] r9 = new Object[0];
        f06.b r10 = new f06.b();
        if (r8.b(100400, "android/media/AudioRecord", "startRecording", r12, r9, "void", r10).a == false) goto L6;
        r8.a(100400, "android/media/AudioRecord", "startRecording", r12, r9, null, r10, false);
        return;
    L6:
        r12.startRecording();
        r8.a(100400, "android/media/AudioRecord", "startRecording", r12, r9, null, r10, true);
    }

    public static void g(AudioRecord r12) {
        f06.c r8 = new f06.c();
        Object[] r9 = new Object[0];
        f06.b r10 = new f06.b();
        if (r8.b(100401, "android/media/AudioRecord", "stop", r12, r9, "void", r10).a == false) goto L6;
        r8.a(100401, "android/media/AudioRecord", "stop", r12, r9, null, r10, false);
        return;
    L6:
        r12.stop();
        r8.a(100401, "android/media/AudioRecord", "stop", r12, r9, null, r10, true);
    }

    @Override // sub.b
    public final sub.b.C0190b d(sub.b.a r15) {
        Intrinsics.checkNotNullParameter(r15, "format");
        if (this.a == null) goto L6;
        lvb.a.h("AudioRecordExtSource", "AudioRecord already initialized");
        return new sub.b.C0190b(false, 0, "AudioRecord already initialized", 2);
    L6:
        int r2 = r15.b;
        if (r2 == 1) goto L11;
        if (r2 != 2) goto L11;
        int r10 = 12;
    L12:
        int r3 = AudioRecord.getMinBufferSize(r15.a, r10, 2);
        if (r3 != (-2)) goto L15;
    L39:
        lvb.a.b("AudioRecordExtSource", "Invalid buffer size for sampleRate=" + r15.a + ", channelConfig=" + r10);
        return new sub.b.C0190b(false, 0, "Invalid buffer size: " + r3, 2);
    L15:
        if (r3 == (-1)) goto L39;
        this.b = Math.max(r3 * 2, 4096);
        AudioRecord r13 = new AudioRecord(1, r15.a, r10, 2, this.b);     // Catch: Exception -> L33
        this.a = r13;     // Catch: Exception -> L33
        if (r13.getState() != 1) goto L20;
        boolean r7 = true;
    L21:
        if (r7 == true) goto L31;
        StringBuilder r16 = new StringBuilder("AudioRecord initialization failed, state=");     // Catch: Exception -> L33
        AudioRecord r0 = this.a;     // Catch: Exception -> L33
        if (r0 == null) goto L25;
        Integer r1 = Integer.valueOf(r0.getState());     // Catch: Exception -> L33
    L26:
        r16.append(r1);     // Catch: Exception -> L33
        String r17 = r16.toString();     // Catch: Exception -> L33
        lvb.a.b("AudioRecordExtSource", r17);     // Catch: Exception -> L33
        AudioRecord r4 = this.a;     // Catch: Exception -> L33
        if (r4 == null) goto L29;
        e(r4);     // Catch: Exception -> L33
    L29:
        this.a = null;     // Catch: Exception -> L33
        return new sub.b.C0190b(false, 0, r17, 2);
    L25:
        r1 = null;
        goto L26
    L31:
        lvb.a.e("AudioRecordExtSource", "AudioRecord initialized successfully, sampleRate=" + r15.a + ", bufferSize=" + this.b + ", channel=" + r15.b);     // Catch: Exception -> L33
        return new sub.b.C0190b(true, this.b, null, 4);
    L20:
        r7 = false;
    L33:
        e = move-exception;
        lvb.a.b("AudioRecordExtSource", "Failed to initialize AudioRecord: " + e);
        AudioRecord r5 = this.a;
        if (r5 == null) goto L37;
        e(r5);
    L37:
        this.a = null;
        return new sub.b.C0190b(false, 0, "Exception: " + e.getMessage(), 2);
    L11:
        r10 = 16;
        goto L12
    }

    @Override // sub.b
    public final int read(byte[] r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "audioData");
        AudioRecord r2 = this.a;     // Catch: Exception -> L9
        if (r2 == null) goto L6;
        int r7 = r2.read(r5, 0, r6);     // Catch: Exception -> L9
    L7:
        lvb.a.g("read: " + r7);     // Catch: Exception -> L9
        return r7;
    L6:
        r7 = -1;
    L9:
        e = move-exception;
        lvb.a.b("AudioRecordExtSource", "Error reading audio data: " + e);
        return -1;
    }
}
