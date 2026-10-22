package com.larus.asr.task;

import android.os.SystemClock;
import com.larus.audio.audiov3.task.asr.AsrState;
import com.larus.audio.report.h;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b implements h68.e {
    public final String a;
    public final xa8.d b;
    public final Function0<Integer> c;
    public final Function2<byte[], JSONObject, Unit> d;
    public final Function1<byte[], Unit> e;
    public final Function0<Unit> f;
    public y58.a g;
    public h68.d h;
    public volatile AsrState i;
    public long j;
    public final C0070b k;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.larus.asr.task.b$b, reason: collision with other inner class name */
    public static final class C0070b implements z2a.a {
        public final /* synthetic */ b a;

        public final void c() {
            b r0 = this.a;
            r0.b.gq(((Number) r0.c.invoke()).intValue());
            this.a.f.invoke();
        }

        public C0070b(b r1) {
            this.a = r1;
        }

        public final void a(byte[] r2) {
            Intrinsics.checkNotNullParameter(r2, "data");
            this.a.e.invoke(r2);
            this.a.b.rV();
        }

        public final void b(byte[] r2, JSONObject r3) {
            Intrinsics.checkNotNullParameter(r2, "data");
            this.a.d.invoke(r2, r3);
        }
    }

    static {
    }

    @Override // h68.e
    public final int a(byte[] r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "buffer");
        return 0;
    }

    @Override // h68.e
    public final boolean b() {
        return false;
    }

    @Override // h68.e
    public final void c(String r1, Object r2, Object r3, Object r4) {
        Intrinsics.checkNotNullParameter(r1, "context");
    }

    @Override // h68.e
    public final void g(h r1) {
    }

    @Override // h68.e
    public final void cancel() {
        FLogger.a.i("QuicAsrTask", "cancel quic asr, taskId=" + this.a);
        if (this.b.K70() == true) goto L5;
    L7:
        this.i = AsrState.ASR_STOP;
        return;
    L5:
        if (this.b.Ig() == true) goto L7;
        this.b.gq(((Number) this.c.invoke()).intValue());
        goto L7
    }

    @Override // h68.e
    public final long e() {
        if (this.j != 0) goto L6;
        return 0;
    L6:
        return SystemClock.elapsedRealtime() - this.j;
    }

    @Override // h68.e
    public final void release() {
        FLogger.a.i("QuicAsrTask", "release quic asr, taskId=" + this.a);
        this.b.gq(((Number) this.c.invoke()).intValue());
        this.i = AsrState.ASR_IDLE;
    }

    @Override // h68.e
    public final void start() {
        AsrState r0 = this.i;
        AsrState r1 = AsrState.ASR_STARTED;
        if (r0 != r1) goto L6;
        FLogger.a.w("QuicAsrTask", "start ignored, already started, taskId=" + this.a);
        return;
    L6:
        this.j = SystemClock.elapsedRealtime();
        int r2 = ((Number) this.c.invoke()).intValue();
        FLogger.a.i("QuicAsrTask", "start quic asr, taskId=" + this.a + ", speakerMode=" + r2);
        this.b.gq(r2);
        this.b.VJ(this.k);
        this.b.lw(r2);
        this.i = r1;
        h68.d r3 = this.h;
        if (r3 == null) goto L10;
        r3.e(r1);
        return;
    }

    @Override // h68.e
    public final void stop() {
        if (this.i == AsrState.ASR_STARTED) goto L6;
        FLogger.a.w("QuicAsrTask", "stop ignored, not started, taskId=" + this.a);
        return;
    L6:
        FLogger.a.i("QuicAsrTask", "stop quic asr (submit), taskId=" + this.a);
        this.b.JX();
        AsrState r0 = AsrState.ASR_STOP;
        this.i = r0;
        h68.d r1 = this.h;
        if (r1 == null) goto L10;
        r1.e(r0);
        return;
    }

    @Override // h68.e
    public final AsrState d() {
        return this.i;
    }

    @Override // h68.e
    public final y58.a getConfig() {
        return this.g;
    }

    @Override // h68.e
    public final String getTaskId() {
        return this.a;
    }

    @Override // h68.e
    public final void f(h68.d r1) {
        this.h = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(String r2, xa8.d r3, Function0<Integer> r4, Function2<? super byte[], ? super JSONObject, Unit> r5, Function1<? super byte[], Unit> r6, Function0<Unit> r7) {
        Intrinsics.checkNotNullParameter(r2, "taskId");
        Intrinsics.checkNotNullParameter(r3, "translatorAbility");
        Intrinsics.checkNotNullParameter(r4, "speakerModeProvider");
        Intrinsics.checkNotNullParameter(r5, "onReceiveTranslatedAudio");
        Intrinsics.checkNotNullParameter(r6, "onSendAudioData");
        Intrinsics.checkNotNullParameter(r7, "onTranslatedAudioPlayComplete");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.i = AsrState.ASR_IDLE;
        this.k = new C0070b(this);
    }
}
