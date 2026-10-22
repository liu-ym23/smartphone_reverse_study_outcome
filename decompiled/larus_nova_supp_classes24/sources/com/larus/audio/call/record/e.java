package com.larus.audio.call.record;

import android.os.Handler;
import android.os.Looper;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class e extends f {
    public final PthreadHandlerThreadV2 j;
    public Handler k;
    public volatile boolean l;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.audio.call.record.f, v68.a
    public final void release() {
        Handler r0 = this.k;
        if (r0 == null) goto L5;
        r0.removeCallbacksAndMessages(null);
    L5:
        this.l = true;
        this.j.quit();
        this.k = null;
        super.release();
    }

    @Override // com.larus.audio.call.record.f, v68.a
    public final void stopRecord() {
        Handler r0 = this.k;
        if (r0 == null) goto L5;
        r0.removeCallbacksAndMessages(null);
    L5:
        super.stopRecord();
    }

    public e(boolean r3) {
        super(null, -1, r3);
        this.j = new PthreadHandlerThreadV2("audio_record_operator_thread");
    }

    @Override // com.larus.audio.call.record.f, v68.a
    public final boolean start(final Function1<? super Exception, Unit> r5) {
        Runnable r0 = new d(this, r5);
        Thread r1 = null;
        if (ThreadMethodProxy.isAlive(this.j) == false) goto L5;
        PthreadHandlerThreadV2 r6 = this.j;
    L6:
        Handler r2 = this.k;
        if (r2 != null) goto L13;
        if (r6 == null) goto L12;
        Looper r3 = r6.getLooper();
        if (r3 == null) goto L12;
        r2 = new Handler(r3);
    L12:
        r2 = null;
    L13:
        if (r2 != null) goto L15;
    L25:
        r0.run();
        return true;
    L15:
        if (this.l == true) goto L25;
        Thread r4 = ThreadMethodProxy.currentThread();
        if (r6 == null) goto L22;
        Looper r7 = r6.getLooper();
        if (r7 == null) goto L22;
        r1 = ThreadMethodProxy.getLooperThread(r7);
    L22:
        if (Intrinsics.areEqual(r4, r1) == true) goto L25;
        r2.post(r0);
        return true;
    L5:
        r6 = null;
        goto L6
    }

    public static void i(e r0, Function1 r1) {
        super.start(r1);
    }

    @Override // com.larus.audio.call.record.f, v68.a
    public final void d(v58.a r3, Function2<? super r58.d, ? super byte[], Unit> r4) {
        Intrinsics.checkNotNullParameter(r4, "onAudioDataReceived");
        if (this.l == false) goto L5;
    L7:
        Handler r1 = null;
        if (ThreadMethodProxy.isAlive(this.j) == false) goto L10;
        PthreadHandlerThreadV2 r0 = this.j;
    L11:
        if (r0 == null) goto L13;
        r1 = new Handler(r0.getLooper());
    L13:
        this.k = r1;
        super.d(r3, r4);
        return;
    L10:
        r0 = null;
        goto L11
    L5:
        if (ThreadMethodProxy.isAlive(this.j) == true) goto L7;
        ThreadMethodProxy.start(this.j);
        goto L7
    }
}
