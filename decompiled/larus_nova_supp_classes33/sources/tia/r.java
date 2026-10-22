package tia;

import com.larus.audio.audiov3.audio.record.AudioRecordState;
import com.larus.audio.record.AudioRecordType;
import com.larus.audio.record.factory.IAudioRecorderFactory;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import com.obric.assistant.spi.audio.ObricWakeupTruthUploadDelegate;
import com.obric.assistant.spi.audio.WakeupAudioCaptureReadScene;
import com.obric.assistant.spi.audio.WakeupAudioCaptureTriggerType;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class r {
    public final hga.f a;
    public final Function1<r, Unit> b;
    public final f c;
    public final Object d;
    public final AtomicBoolean e;
    public final CopyOnWriteArraySet<e> f;
    public final ConcurrentHashMap<Integer, Long> g;
    public int h;
    public int i;
    public final c j;

    public static final class a {
    }

    static {
    }

    public final boolean b() {
        if (this.e.get() == false) goto L5;
    L7:
        return false;
    L5:
        if (this.j.c.get() == false) goto L7;
        return true;
    }

    public final boolean d() {
        final c r0 = this.j;
        boolean r4 = false;
        if (r0.c.compareAndSet(false, true) == true) goto L21;
    L15:
        r4 = true;
    L18:
        if (r4 == false) goto L20;
        a(this.a);
    L20:
        return r4;
    L21:
        IAudioRecorderFactory r3 = (IAudioRecorderFactory) ServiceManager.get().getService(IAudioRecorderFactory.class);     // Catch: Throwable -> L16
        if (r3 == null) goto L8;
        final r58.c r5 = r3.a(AudioRecordType.BackTraceRecord, MapsKt.mapOf(new Pair[]{TuplesKt.to("context", AppHost.a.getApplication()), TuplesKt.to("bufferSize", -1)}));     // Catch: Throwable -> L16
    L9:
        if (r5 != null) goto L11;
        r0.c.set(false);     // Catch: Throwable -> L16
        goto L18
    L11:
        r0.d = r5;     // Catch: Throwable -> L16
        r5.b(5000, 0);     // Catch: Throwable -> L16
        r5.start();     // Catch: Throwable -> L16
        if (r5.l() == AudioRecordState.STARTED) goto L14;
        FLogger.a.w("WakeupCaptureProducer", "producer start failed: state=" + r5.l());     // Catch: Throwable -> L16
        r0.a();     // Catch: Throwable -> L16
        goto L18
    L14:
        final long r6 = System.currentTimeMillis();     // Catch: Throwable -> L16
        r0.f = r6;     // Catch: Throwable -> L16
        PthreadThreadV2 r2 = new PthreadThreadV2(new b(r0, r5, r6), "wakeup-capture-producer");     // Catch: Throwable -> L16
        ThreadMethodProxy.start(r2);     // Catch: Throwable -> L16
        r0.e = r2;     // Catch: Throwable -> L16
        goto L15
    L8:
        r5 = null;
    L16:
        th = move-exception;
        FLogger.a.e("WakeupCaptureProducer", "producer start failed", th);
        r0.a();
        goto L18
    }

    public final void a(final hga.f r14) {
        Intrinsics.checkNotNullParameter(r14, WindowEvent.Params.TRIGGER);
        int r0 = r14.d;
        long r1 = r14.e;
        if (r0 > 0) goto L5;
    L8:
        WakeupAudioCaptureTriggerType r2 = r14.b;
        WakeupAudioCaptureTriggerType r3 = WakeupAudioCaptureTriggerType.VOICE_WAKEUP;
        if (r2 == r3) goto L12;
        FLogger.a.i("WakeupCaptureSession", "record interaction start only trigger=" + r14);
        return;
    L12:
        Object r4 = this.d;
        monitor-enter(r4);
    L60:
        th = move-exception;
        throw th;
    L15:
        if (this.e.get() == false) goto L18;
        monitor-exit(r4);
        return;
    L18:
        boolean r5 = true;
        this.h++;     // Catch: Throwable -> L60
        int r6 = this.i;     // Catch: Throwable -> L60
        this.i = r6 + 1;     // Catch: Throwable -> L60
        monitor-exit(r4);
        Long r7 = null;
        if (r6 != 0) goto L40;
        Long r8 = Long.valueOf(r14.f);
        if (r8.longValue() <= 0) goto L25;
        boolean r9 = true;
    L26:
        if (r9 == true) goto L29;
        r8 = null;
    L29:
        if (r8 == null) goto L31;
        long r10 = r8.longValue();
    L49:
        final long r11 = r10;
        long r12 = r11 - 4800;
        final long r13 = r11 + 8200;
        FLogger.a.i("WakeupCaptureSession", "add upload window trigger=" + r14 + " windowIndex=" + r6 + " uploadAnchorTimeMs=" + r11 + " uploadStartTimeMs=" + r12 + " uploadEndTimeMs=" + r13);
        if (r14.b == r3) goto L63;
    L58:
        final e r15 = new e(this.c, new hga.e(WakeupAudioCaptureReadScene.UPLOAD, r12, r14.b.name()), new l(this), new m(this));
        ThreadMethodProxy.start(new PthreadThreadV2(new n(this, r14, r15, r13, r11), "wakeup-capture-upload-window"));
        return;
    L63:
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L53
        ObricWakeupTruthUploadDelegate.b.b();     // Catch: Throwable -> L53
        Object r17 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L53
    L55:
        Throwable r18 = Result.exceptionOrNull-impl(r17);
        if (r18 == null) goto L58;
        FLogger.a.e("WakeupCaptureSession", "truth upload start dispatch failed", r18);
    L53:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r17 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L55
    L31:
        Long r20 = Long.valueOf(this.j.f);
        if (r20.longValue() > 0) goto L35;
        r5 = false;
    L35:
        if (r5 == false) goto L37;
        r7 = r20;
    L37:
        if (r7 == null) goto L39;
        r10 = r7.longValue();
        goto L49
    L39:
        r10 = r14.a;
        goto L49
    L25:
        r9 = false;
        goto L26
    L40:
        Long r21 = Long.valueOf(r14.f);
        if (r21.longValue() > 0) goto L44;
        r5 = false;
    L44:
        if (r5 == false) goto L46;
        r7 = r21;
    L46:
        if (r7 == null) goto L48;
        r10 = r7.longValue();
        goto L49
    L48:
        r10 = r14.a;
        goto L49
    L5:
        if (r1 <= 0) goto L8;
        this.g.put(Integer.valueOf(r0), Long.valueOf(r1));
        goto L8
    }

    public final void e(String r5) {
        Object r0 = this.d;
        monitor-enter(r0);
    L19:
        th = move-exception;
        throw th;
    L5:
        if ((!this.f.isEmpty()) == false) goto L7;
    L17:
        monitor-exit(r0);
        return;
    L7:
        if (this.h > 0) goto L17;
        if (this.e.compareAndSet(false, true) == true) goto L13;
        monitor-exit(r0);
        return;
    L13:
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L19
        monitor-exit(r0);
        FLogger.a.i("WakeupCaptureSession", "release session reason=".concat(r5));
        this.j.a();
        this.b.invoke(this);
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [tia.o] */
    public r(hga.f r2, g r3) {
        Intrinsics.checkNotNullParameter(r2, "firstTrigger");
        Intrinsics.checkNotNullParameter(r3, "onSessionReleased");
        this.a = r2;
        this.b = r3;
        f r4 = new f();
        this.c = r4;
        this.d = new Object();
        this.e = new AtomicBoolean(false);
        this.f = new CopyOnWriteArraySet();
        this.g = new ConcurrentHashMap();
        this.j = new c(r4, new o(this));
    }

    public static void c(hga.f r34, byte[] r35, long r36, long r38, long r40) {
        if (r34.b == WakeupAudioCaptureTriggerType.VOICE_WAKEUP) goto L6;
        return;
    L6:
        if (r35.length != 0) goto L8;
        boolean r2 = true;
    L10:
        if (r2 == false) goto L25;
        FLogger.a.i("WakeupCaptureSession", "truth upload dispatch empty audio trigger=" + r34);
    L25:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L18
        ObricWakeupTruthUploadDelegate r4 = ObricWakeupTruthUploadDelegate.b;     // Catch: Throwable -> L18
        String r33 = "WakeupCaptureSession";
        r4.e(new hga.g(r34.d, r34.a, r38, r38 - 4800, r40, r35, tia.a.a(r36), r34.k, r34.l, r34.m, r34.n, r34.g, r34.h, r34.i, r34.j, r34.o, r34.p, r34.q, r34.r, r4.g(r34.d), r34.s, r34.t));     // Catch: Throwable -> L16
        Object r0 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L16
    L21:
        Throwable r1 = Result.exceptionOrNull-impl(r0);
        if (r1 == null) goto L29;
        FLogger.a.e(r33, "truth upload dispatch failed", r1);
        return;
    L29:
        return;
    L16:
        th = th;
    L20:
        Result.Companion r5 = Result.Companion;
        r0 = Result.constructor-impl(ResultKt.createFailure(th));
    L18:
        th = th;
        r33 = "WakeupCaptureSession";
        goto L20
    L8:
        r2 = false;
        goto L10
    }
}
