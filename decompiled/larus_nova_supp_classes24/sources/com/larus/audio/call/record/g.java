package com.larus.audio.call.record;

import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.audio.record.AudioRecordType;
import com.larus.audio.record.factory.IAudioRecorderFactory;
import com.larus.common.apphost.AppHost;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class g extends c {
    public volatile r58.c e;
    public final Integer f;
    public volatile b g;
    public boolean h;
    public final buc.a i;
    public long j;
    public long k;
    public int l;
    public String m;
    public Function2<? super String, ? super Long, Unit> n;
    public Function2<? super Boolean, ? super String, Unit> o;

    public static final class a {
    }

    public static final class b extends PthreadThreadV2 {
        public final /* synthetic */ g v;
        public final /* synthetic */ Function2<r58.d, byte[], Unit> w;

        public final void run() {
            super.run();     // Catch: Throwable -> L6
            r58.c r0 = this.v.e;     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            r0.k(this.w);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(g r1, Function2<? super r58.d, ? super byte[], Unit> r2) {
            this.v = r1;
            this.w = r2;
            super("flow-audio-recorder");
        }
    }

    static {
    }

    public g() {
        super(true);
        this.e = null;
        this.f = null;
        this.i = buc.b.a(false);
        this.l = -1;
    }

    @Override // v68.a
    public final void release() {
        com.larus.audio.call.util.e r0 = com.larus.audio.call.util.e.a;
        r0.i("BackTraceAudioRecorderWrapper", "release");
        stopRecord();
        b r2 = this.g;
        if (r2 == null) goto L5;
        r2.interrupt();
    L5:
        StringBuilder r3 = new StringBuilder("audioRecordThread name is >>>");
        PthreadThreadV2 r4 = this.g;
        if (r4 == null) goto L8;
        String r5 = r4.getName();
    L9:
        r3.append(r5);
        r3.append(", id is >>>");
        PthreadThreadV2 r6 = this.g;
        if (r6 == null) goto L12;
        Long r7 = Long.valueOf(r6.getId());
    L13:
        r3.append(r7);
        r3.append(", interrupted status is >>>");
        b r8 = this.g;
        if (r8 == null) goto L16;
        Boolean r9 = Boolean.valueOf(r8.isInterrupted());
    L17:
        r3.append(r9);
        r0.i("BackTraceAudioRecorderWrapper", r3.toString());
        r58.c r1 = this.e;
        if (r1 == null) goto L20;
        r1.release();
    L20:
        this.e = null;
        this.h = false;
        this.i.d(true);
        this.d.a();
        return;
    L16:
        r9 = null;
        goto L17
    L12:
        r7 = null;
        goto L13
    L8:
        r5 = null;
        goto L9
    }

    @Override // v68.a
    public final void stopRecord() {
        com.larus.audio.call.util.e.a.i("BackTraceAudioRecorderWrapper", "stop record");
        this.a = false;
        r58.c r0 = this.e;     // Catch: Exception -> L7
        if (r0 == null) goto L12;
        r0.stop();     // Catch: Exception -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        com.larus.audio.call.util.e.a.e("BackTraceAudioRecorderWrapper", "audioRecord stop failed.", e);
    }

    @Override // com.larus.audio.call.record.c, v68.a
    public final void a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        this.m = r2;
        r58.c r0 = this.e;
        if (r0 == null) goto L6;
        r0.a(r2);
        return;
    }

    @Override // com.larus.audio.call.record.c, v68.a
    public final void b(int r1) {
        this.l = r1;
    }

    @Override // v68.a
    public final void e(Function0<Unit> r2) {
        r58.c r0 = this.e;
        if (r0 == null) goto L6;
        r0.e(r2);
        return;
    }

    @Override // com.larus.audio.call.record.c, v68.a
    public final void f(Function2<? super String, ? super Long, Unit> r2) {
        this.n = r2;
        r58.c r0 = this.e;
        if (r0 == null) goto L6;
        r0.f(r2);
        return;
    }

    @Override // com.larus.audio.call.record.c, v68.a
    public final void g(Function2<? super Boolean, ? super String, Unit> r1) {
        this.o = r1;
    }

    @Override // v68.a
    public final boolean start(Function1<? super Exception, Unit> r6) {
        com.larus.audio.call.util.e.a.i("BackTraceAudioRecorderWrapper", "start record " + this.a);
        boolean r1 = true;
        if (this.a == false) goto L5;
        return true;
    L5:
        this.a = true;
        r58.c r0 = this.e;     // Catch: Exception -> L10
        if (r0 == null) goto L21;
        r0.start();     // Catch: Exception -> L10
    L21:
        return r1;
    L10:
        stopRecord();     // Catch: Exception -> L14
        r58.c r2 = this.e;     // Catch: Exception -> L14
        if (r2 == null) goto L21;
        r2.start();     // Catch: Exception -> L14
    L14:
        e = move-exception;
        com.larus.audio.call.util.e.a.e("BackTraceAudioRecorderWrapper", "audioRecord start failed.", e);
        r1 = false;
        this.a = false;
        if (r6 == null) goto L18;
        r6.invoke(e);
    L18:
        Function2<? super Boolean, ? super String, Unit> r7 = this.o;
        if (r7 == null) goto L21;
        r7.invoke(Boolean.FALSE, "audioRecord start failed: " + e.getMessage());
        goto L21
    }

    @Override // com.larus.audio.call.record.c, v68.a
    public final void c(long r1, Long r3) {
        this.j = r1;
        if (r3 == null) goto L5;
        long r2 = r3.longValue();
    L6:
        this.k = r2;
        return;
    L5:
        r2 = 0;
        goto L6
    }

    @Override // v68.a
    public final void d(v58.a r9, Function2<? super r58.d, ? super byte[], Unit> r10) {
        Intrinsics.checkNotNullParameter(r10, "onAudioDataReceived");
        com.larus.audio.call.util.e r0 = com.larus.audio.call.util.e.a;
        r0.i("BackTraceAudioRecorderWrapper", "init() audioRecorderConfig: " + r9 + ", initialized: " + this.h + ", released: " + this.i.c());
        if (this.h == false) goto L5;
        return;
    L5:
        if (this.i.c() == true) goto L60;
        boolean r11 = true;
        this.h = true;
        if (this.e != null) goto L17;
        IAudioRecorderFactory r2 = (IAudioRecorderFactory) ServiceManager.get().getService(IAudioRecorderFactory.class);
        if (r2 == null) goto L15;
        AudioRecordType r4 = AudioRecordType.BackTraceRecord;
        Pair[] r5 = new Pair[3];
        r5[0] = TuplesKt.to("context", AppHost.a.getApplication());
        Integer r6 = this.f;
        if (r6 == null) goto L13;
        int r7 = r6.intValue();
    L14:
        r5[1] = TuplesKt.to("bufferSize", Integer.valueOf(r7));
        r5[2] = TuplesKt.to("sessionId", Integer.valueOf(this.l));
        r58.c r3 = r2.a(r4, MapsKt.mapOf(r5));
    L16:
        this.e = r3;
        goto L17
    L13:
        r7 = -1;
        goto L14
    L15:
        r3 = null;
    L17:
        r58.c r8 = this.e;
        if (r8 == null) goto L20;
        r8.b(this.j, this.k);
    L20:
        String r12 = this.m;
        if (r12 == null) goto L25;
        r58.c r13 = this.e;
        if (r13 == null) goto L25;
        r13.a(r12);
    L25:
        Function2<? super String, ? super Long, Unit> r14 = this.n;
        if (r14 == null) goto L30;
        r58.c r15 = this.e;
        if (r15 == null) goto L30;
        r15.f(r14);
    L30:
        r58.c r16 = this.e;
        if (r16 == null) goto L33;
        r16.g(this.o);
    L33:
        PthreadThreadV2 r17 = this.g;
        if (r17 != null) goto L36;
    L38:
        r11 = false;
    L39:
        if (r11 == false) goto L44;
        r0.w("BackTraceAudioRecorderWrapper", "AudioRecorder thread is alive, interrupt it start");
        b r19 = this.g;
        if (r19 == null) goto L43;
        r19.interrupt();
    L43:
        r0.w("BackTraceAudioRecorderWrapper", "AudioRecorder thread is alive, interrupt it end");
    L44:
        this.g = new b(this, r10);
    L54:
        e = move-exception;
        com.larus.audio.call.util.e.a.e("BackTraceAudioRecorderWrapper", "AudioRecorder start thread failed.", e);
        return;
    L46:
        if (com.larus.audio.call.f.d().k == false) goto L50;
        PthreadThreadV2 r20 = this.g;     // Catch: Exception -> L54
        if (r20 == null) goto L50;
        ThreadMethodProxy.setPriority(r20, 10);     // Catch: Exception -> L54
    L50:
        PthreadThreadV2 r21 = this.g;     // Catch: Exception -> L54
        if (r21 == null) goto L61;
        ThreadMethodProxy.start(r21);     // Catch: Exception -> L54
        return;
    L61:
        return;
    L36:
        if (ThreadMethodProxy.isAlive(r17) != true) goto L38;
    }
}
