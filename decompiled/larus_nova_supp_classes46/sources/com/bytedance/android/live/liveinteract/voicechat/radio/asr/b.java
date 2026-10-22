package com.bytedance.android.live.liveinteract.voicechat.radio.asr;

import android.media.AudioRecord;
import android.os.Handler;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b {
    public int a;
    public byte[] b;
    public AudioRecord c;
    public InterfaceC0109b d;
    public final Handler e;
    public volatile int f;
    public final c g;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.voicechat.radio.asr.b$b, reason: collision with other inner class name */
    public interface InterfaceC0109b {
        void onPCMDataReceived(byte[] r1, int r2);
    }

    public static final class c implements Runnable {
        public final /* synthetic */ b a;

        public c(b r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            byte[] r0 = this.a.b;     // Catch: Throwable -> L16
            if (r0 == null) goto L19;
        L4:
            if (this.a.f != 2) goto L31;
            b r1 = this.a;     // Catch: Throwable -> L16
            AudioRecord r2 = r1.c;     // Catch: Throwable -> L16
            if (r2 == null) goto L9;
            int r3 = r2.read(r0, 0, r1.a);     // Catch: Throwable -> L16
        L11:
            if (r3 != r0.length) goto L4;
            InterfaceC0109b r4 = this.a.d;     // Catch: Throwable -> L16
            if (r4 == null) goto L4;
            r4.onPCMDataReceived(r0, r3);     // Catch: Throwable -> L16
            goto L4
        L9:
            r3 = -10086;
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

    public b() {
        this.g = new c(this);
        int r0 = AudioRecord.getMinBufferSize(16000, 16, 2);     // Catch: IllegalArgumentException -> L8
        this.a = r0;     // Catch: IllegalArgumentException -> L8
        if (r0 <= 0) goto L6;
        this.b = new byte[r0];     // Catch: IllegalArgumentException -> L8
        this.c = new AudioRecord(1, 16000, 16, 2, this.a);     // Catch: IllegalArgumentException -> L8
        this.f = 1;     // Catch: IllegalArgumentException -> L8
    L12:
    L10:
        PthreadHandlerThreadV2 r1 = new PthreadHandlerThreadV2("Audio_Recorder");
        ThreadMethodProxy.start(r1);
        this.e = new Handler(r1.getLooper());
        Unit r2 = Unit.INSTANCE;
        return;
    L6:
        this.f = 0;     // Catch: IllegalArgumentException -> L8
    L8:
        e = move-exception;
        f72.a.b("Create Record Exception: " + e.getMessage());
        goto L10
    }
}
