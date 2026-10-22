package com.bytedance.android.annie.bridge.method.audio;

import android.media.AudioRecord;
import android.os.Handler;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c {
    public int a;
    public byte[] b;
    public AudioRecord c;
    public b d;
    public final Handler e;
    public volatile int f;
    public final RunnableC0060c g;

    public static final class a {
    }

    public interface b {
        void a(byte[] r1);
    }

    /* JADX INFO: renamed from: com.bytedance.android.annie.bridge.method.audio.c$c, reason: collision with other inner class name */
    public static final class RunnableC0060c implements Runnable {
        public final /* synthetic */ c a;

        public RunnableC0060c(c r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            c r0 = this.a;     // Catch: Throwable -> L16
            byte[] r1 = r0.b;     // Catch: Throwable -> L16
            if (r1 == null) goto L19;
        L4:
            if (r0.f != 2) goto L31;
            AudioRecord r10 = r0.c;     // Catch: Throwable -> L16
            if (r10 == null) goto L9;
            int r11 = r10.read(r1, 0, r0.a);     // Catch: Throwable -> L16
        L11:
            if (r11 != r1.length) goto L4;
            b r12 = r0.d;     // Catch: Throwable -> L16
            if (r12 == null) goto L4;
            r12.a(r1);     // Catch: Throwable -> L16
            goto L4
        L9:
            r11 = -10086;
            goto L11
        L31:
            return;
        L19:
            return;
        L16:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L30;
            throw th;
        }
    }

    static {
    }

    public c() {
        this.g = new RunnableC0060c(this);
        int r0 = AudioRecord.getMinBufferSize(16000, 16, 2);
        this.a = r0;
        if (r0 <= 0) goto L5;
        this.b = new byte[r0];
        this.c = new AudioRecord(1, 16000, 16, 2, this.a);
        this.f = 1;
    L6:
        PthreadHandlerThreadV2 r1 = new PthreadHandlerThreadV2("Audio_Recorder");
        ThreadMethodProxy.start(r1);
        this.e = new Handler(r1.getLooper());
        return;
    L5:
        this.f = 0;
        goto L6
    }

    public static void a(AudioRecord r12) {
        f06.c r10 = new f06.c();
        Object[] r11 = new Object[0];
        f06.b r13 = new f06.b();
        if (r10.b(100403, "android/media/AudioRecord", "release", r12, r11, "void", r13).a == false) goto L6;
        r10.a(100403, "android/media/AudioRecord", "release", r12, r11, null, r13, false);
        return;
    L6:
        r12.release();
        r10.a(100403, "android/media/AudioRecord", "release", r12, r11, null, r13, true);
    }

    public static void b(AudioRecord r12) {
        f06.c r10 = new f06.c();
        Object[] r11 = new Object[0];
        f06.b r13 = new f06.b();
        if (r10.b(100400, "android/media/AudioRecord", "startRecording", r12, r11, "void", r13).a == false) goto L6;
        r10.a(100400, "android/media/AudioRecord", "startRecording", r12, r11, null, r13, false);
        return;
    L6:
        r12.startRecording();
        r10.a(100400, "android/media/AudioRecord", "startRecording", r12, r11, null, r13, true);
    }

    public static void c(AudioRecord r12) {
        f06.c r10 = new f06.c();
        Object[] r11 = new Object[0];
        f06.b r13 = new f06.b();
        if (r10.b(100401, "android/media/AudioRecord", "stop", r12, r11, "void", r13).a == false) goto L6;
        r10.a(100401, "android/media/AudioRecord", "stop", r12, r11, null, r13, false);
        return;
    L6:
        r12.stop();
        r10.a(100401, "android/media/AudioRecord", "stop", r12, r11, null, r13, true);
    }
}
