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
public class f extends c {
    public volatile r58.c e;
    public final int f;
    public final boolean g;
    public volatile b h;
    public boolean i;

    public static final class a {
    }

    public static final class b extends PthreadThreadV2 {
        public final /* synthetic */ f v;
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
        public b(f r1, Function2<? super r58.d, ? super byte[], Unit> r2) {
            this.v = r1;
            this.w = r2;
            super("flow-audio-recorder");
        }
    }

    static {
    }

    @Override // v68.a
    public void release() {
        com.larus.audio.call.util.e r0 = com.larus.audio.call.util.e.a;
        r0.i("AudioRecorderWrapper", "release");
        stopRecord();
        b r2 = this.h;
        if (r2 == null) goto L5;
        r2.interrupt();
    L5:
        StringBuilder r3 = new StringBuilder("audioRecordThread name is >>>");
        PthreadThreadV2 r4 = this.h;
        if (r4 == null) goto L8;
        String r5 = r4.getName();
    L9:
        r3.append(r5);
        r3.append(", id is >>>");
        PthreadThreadV2 r6 = this.h;
        if (r6 == null) goto L12;
        Long r7 = Long.valueOf(r6.getId());
    L13:
        r3.append(r7);
        r3.append(", interrupted status is >>>");
        b r8 = this.h;
        if (r8 == null) goto L16;
        Boolean r9 = Boolean.valueOf(r8.isInterrupted());
    L17:
        r3.append(r9);
        r0.i("AudioRecorderWrapper", r3.toString());
        r58.c r1 = this.e;
        if (r1 == null) goto L20;
        r1.release();
    L20:
        this.e = null;
        this.i = false;
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
    public void stopRecord() {
        com.larus.audio.call.util.e.a.i("AudioRecorderWrapper", "stop record");
        this.a = false;
        r58.c r0 = this.e;     // Catch: Exception -> L7
        if (r0 == null) goto L12;
        r0.stop();     // Catch: Exception -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        com.larus.audio.call.util.e.a.e("AudioRecorderWrapper", "audioRecord stop failed.", e);
    }

    @Override // v68.a
    public final void e(Function0<Unit> r2) {
        r58.c r0 = this.e;
        if (r0 == null) goto L6;
        r0.e(r2);
        return;
    }

    @Override // v68.a
    public boolean start(Function1<? super Exception, Unit> r5) {
        com.larus.audio.call.util.e.a.i("AudioRecorderWrapper", "start record " + this.a);
        boolean r1 = true;
        if (this.a == false) goto L5;
        return true;
    L5:
        this.a = true;
        r58.c r0 = this.e;     // Catch: Exception -> L10
        if (r0 == null) goto L18;
        r0.start();     // Catch: Exception -> L10
    L18:
        return r1;
    L10:
        stopRecord();     // Catch: Exception -> L14
        r58.c r2 = this.e;     // Catch: Exception -> L14
        if (r2 == null) goto L18;
        r2.start();     // Catch: Exception -> L14
    L14:
        e = move-exception;
        com.larus.audio.call.util.e.a.e("AudioRecorderWrapper", "audioRecord start failed.", e);
        r1 = false;
        this.a = false;
        if (r5 == null) goto L18;
        r5.invoke(e);
        goto L18
    }

    @Override // v68.a
    public void d(v58.a r10, Function2<? super r58.d, ? super byte[], Unit> r11) {
        Intrinsics.checkNotNullParameter(r11, "onAudioDataReceived");
        com.larus.audio.call.util.e r0 = com.larus.audio.call.util.e.a;
        r0.i("AudioRecorderWrapper", "init() audioRecorderConfig: " + r10);
        if (this.i == true) goto L38;
        boolean r1 = true;
        this.i = true;
        if (this.e != null) goto L12;
        this.e = ((IAudioRecorderFactory) ServiceManager.get().getService(IAudioRecorderFactory.class)).a(AudioRecordType.AudioRecord, MapsKt.mapOf(new Pair[]{TuplesKt.to("context", AppHost.a.getApplication()), TuplesKt.to("bufferSize", Integer.valueOf(this.f))}));
        if (r10 != null) goto L9;
        com.larus.audio.call.g r12 = com.larus.audio.call.f.a;
        r10 = com.larus.audio.call.f.b(this.g);
    L9:
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.b = r10;
        r58.c r13 = this.e;
        if (r13 == null) goto L12;
        r13.h(this.b);
    L12:
        PthreadThreadV2 r14 = this.h;
        if (r14 != null) goto L15;
    L17:
        r1 = false;
    L18:
        if (r1 == false) goto L23;
        r0.w("AudioRecorderWrapper", "AudioRecorder thread is alive, interrupt it start");
        b r15 = this.h;
        if (r15 == null) goto L22;
        r15.interrupt();
    L22:
        r0.w("AudioRecorderWrapper", "AudioRecorder thread is alive, interrupt it end");
    L23:
        this.h = new b(this, r11);
    L33:
        e = move-exception;
        com.larus.audio.call.util.e.a.e("AudioRecorderWrapper", "AudioRecorder start thread failed.", e);
        return;
    L25:
        if (com.larus.audio.call.f.d().k == false) goto L29;
        PthreadThreadV2 r16 = this.h;     // Catch: Exception -> L33
        if (r16 == null) goto L29;
        ThreadMethodProxy.setPriority(r16, 10);     // Catch: Exception -> L33
    L29:
        PthreadThreadV2 r17 = this.h;     // Catch: Exception -> L33
        if (r17 == null) goto L39;
        ThreadMethodProxy.start(r17);     // Catch: Exception -> L33
        return;
    L39:
        return;
    L15:
        if (ThreadMethodProxy.isAlive(r14) != true) goto L17;
    }

    public f(r58.c r1, int r2, boolean r3) {
        super(r3);
        this.e = r1;
        this.f = r2;
        this.g = r3;
    }

    public /* synthetic */ f(r58.c r2, int r3, boolean r4, int r5) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L8;
        r3 = -1;
    L8:
        this(r2, r3, r4);
    }
}
