package com.larus.audio.asr;

import android.media.AudioRecord;
import com.larus.audio.audiov3.audio.record.AudioRecordState;
import com.larus.audio.audiov3.task.asr.AsrDataSourceState;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class r0 implements h68.c {
    public final String a;
    public final y58.a b;
    public final Lazy c;
    public final p58.d d;
    public final AtomicBoolean e;
    public final c f;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[AudioRecordState.values().length];
            r0[AudioRecordState.UNINITIALIZED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[AudioRecordState.INITIALIZED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[AudioRecordState.STARTED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[AudioRecordState.STOPPED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    public static final class c extends q78.f {
        public final /* synthetic */ r0 b;

        public c(r0 r1) {
            this.b = r1;
        }

        @Override // q78.f
        public final void a(List<q78.c> r7) {
            Intrinsics.checkNotNullParameter(r7, "configs");
            p58.d r0 = this.b.d;
            Object r2 = null;
            if ((r0 instanceof p58.d) == true) goto L6;
            r0 = null;
        L6:
            if (r0 == null) goto L10;
            AudioRecord r1 = r0.e;
            if (r1 == null) goto L10;
            Integer r3 = Integer.valueOf(r1.getAudioSessionId());
        L11:
            m58.k r4 = c68.a.c("recording config changed");
            if (r4 == null) goto L32;
            LinkedHashMap r5 = new LinkedHashMap();
            r5.put("configs_size", String.valueOf(((ArrayList) r7).size()));
            r5.put("current_session_id", String.valueOf(r3));
            com.larus.audio.utils.b r6 = (com.larus.audio.utils.b) r4;
            r6.c(r5);
            r6.d("RecorderAsrDataSource.onRecordingConfigChanged");
            y58.a r8 = this.b.b;
            if (r8 == null) goto L18;
            y58.d r9 = r8.z;
            if (r9 == null) goto L18;
            String r10 = r9.a;
        L19:
            String r11 = "";
            if (r10 != null) goto L22;
            r10 = "";
        L22:
            r6.b(CollectionsKt.listOf(r10));
            y58.a r12 = this.b.b;
            if (r12 == null) goto L27;
            y58.d r13 = r12.z;
            if (r13 == null) goto L27;
            String r14 = r13.b;
        L28:
            if (r14 == null) goto L31;
            r11 = r14;
        L31:
            r6.e(r11);
            m58.k.a.a(r6);
        L27:
            r14 = null;
        L18:
            r10 = null;
        L32:
            if (r3 == null) goto L51;
            Iterator<T> r15 = r7.iterator();
        L35:
            if (r15.hasNext() == false) goto L42;
            Object r16 = r15.next();
            if (((q78.c) r16).b != r3.intValue()) goto L39;
            boolean r17 = true;
        L40:
            if (r17 == false) goto L35;
            r2 = r16;
            goto L42
        L39:
            r17 = false;
        L42:
            q78.c r19 = (q78.c) r2;
            if (r19 == null) goto L52;
            int r20 = c68.b.a;
            c68.b.d("RecorderAsrDataSource", "[VoiceQualityChecker]onRecordingConfigChanged isClientSilenced :" + r19.d);
            this.b.e.set(r19.d);
            return;
        L52:
            return;
        L51:
            return;
        L10:
            r3 = null;
            goto L11
        }
    }

    static {
    }

    @Override // h68.c
    public final AsrDataSourceState a() {
        AudioRecordState r0 = this.d.f;
        int r1 = b.a[r0.ordinal()];
        if (r1 == 1) goto L16;
        if (r1 == 2) goto L19;
        if (r1 == 3) goto L18;
        if (r1 != 4) goto L12;
        return AsrDataSourceState.STOPPED;
    L12:
        throw new NoWhenBranchMatchedException();
    L18:
        return AsrDataSourceState.STARTED;
    L19:
        return AsrDataSourceState.INITIALIZED;
    L16:
        return AsrDataSourceState.UNINITIALIZED;
    }

    @Override // h68.c
    public final int b() {
        return this.d.c();
    }

    @Override // h68.c
    public final h68.a prepare() {
        this.d.prepare();
        q78.b.b(this.f, "RecorderAsrDataSource");
        return new h68.a.b(null);
    }

    @Override // h68.c
    public final h68.a release() {
        this.d.release();     // Catch: Exception -> L4
        return new h68.a.b(null);
    L4:
        e = move-exception;
        return new h68.a.C0110a(-2003, "recordReleaseFail", e);
    }

    @Override // h68.c
    public final h68.a start() {
        this.d.start();     // Catch: Exception -> L62
        m58.t r2 = m58.h.m;     // Catch: Exception -> L62
        boolean r3 = false;
        if (r2 == null) goto L8;
        boolean r4 = true;
        if (r2.enableAudioRecordSilencedCheck() != true) goto L8;
    L10:
        if (r4 == false) goto L18;
        p58.d r5 = this.d;     // Catch: Exception -> L62
        if ((r5 instanceof p58.d) == true) goto L16;
        r5 = null;
    L16:
        if (r5 == null) goto L18;
        Intrinsics.checkNotNullParameter("startRecordLoop", "caller");     // Catch: Exception -> L62
        r3 = q78.b.a(r5.e, "startRecordLoop");     // Catch: Exception -> L62
    L18:
        if (r3 == false) goto L67;
        int r1 = c68.b.a;     // Catch: Exception -> L62
        c68.b.d("RecorderAsrDataSource", "[ASR][startRecordLoop] isClientSilenced=true, taskId: " + this.a);     // Catch: Exception -> L62
        m58.k r0 = c68.a.d("AudioRecord isClientSilenced after startRecording");     // Catch: Exception -> L62
        if (r0 == null) goto L66;
        LinkedHashMap r6 = new LinkedHashMap();     // Catch: Exception -> L62
        r6.put("task_id", this.a);     // Catch: Exception -> L62
        y58.a r7 = this.b;     // Catch: Exception -> L62
        if (r7 == null) goto L25;
        String r8 = r7.y;     // Catch: Exception -> L62
    L26:
        String r9 = "";
        if (r8 != null) goto L29;
        r8 = "";
    L29:
        r6.put("bot_id", r8);     // Catch: Exception -> L62
        y58.a r10 = this.b;     // Catch: Exception -> L62
        if (r10 == null) goto L32;
        String r11 = r10.c;     // Catch: Exception -> L62
    L33:
        if (r11 != null) goto L35;
        r11 = "";
    L35:
        r6.put("conversation_id", r11);     // Catch: Exception -> L62
        y58.a r12 = this.b;     // Catch: Exception -> L62
        if (r12 == null) goto L38;
        String r13 = r12.e;     // Catch: Exception -> L62
    L39:
        if (r13 != null) goto L41;
        r13 = "";
    L41:
        r6.put("file_path", r13);     // Catch: Exception -> L62
        com.larus.audio.utils.b r14 = (com.larus.audio.utils.b) r0;     // Catch: Exception -> L62
        r14.c(r6);     // Catch: Exception -> L62
        r14.d("FlowAsrClient.startRecordLoop");     // Catch: Exception -> L62
        y58.a r15 = this.b;     // Catch: Exception -> L62
        if (r15 == null) goto L46;
        y58.d r16 = r15.z;     // Catch: Exception -> L62
        if (r16 == null) goto L46;
        String r17 = r16.a;     // Catch: Exception -> L62
    L47:
        if (r17 != null) goto L49;
        r17 = "";
    L49:
        r14.b(CollectionsKt.listOf(r17));     // Catch: Exception -> L62
        y58.a r19 = this.b;     // Catch: Exception -> L62
        if (r19 == null) goto L54;
        y58.d r20 = r19.z;     // Catch: Exception -> L62
        if (r20 == null) goto L54;
        String r21 = r20.b;     // Catch: Exception -> L62
    L55:
        if (r21 == null) goto L58;
        r9 = r21;
    L58:
        r14.e(r9);     // Catch: Exception -> L62
        m58.k.a.a(r14);     // Catch: Exception -> L62
    L54:
        r21 = null;
    L46:
        r17 = null;
        goto L47
    L38:
        r13 = null;
        goto L39
    L32:
        r11 = null;
        goto L33
    L25:
        r8 = null;
    L66:
        return new h68.a.C0110a(-2001, "AudioRecord isClientSilenced", null);
    L67:
        return new h68.a.b(null);
    L8:
        r4 = false;
    L62:
        e = move-exception;
        return new h68.a.C0110a(-2004, "recordStartFail", e);
    }

    @Override // h68.c
    public final h68.a stop() {
        q78.b.c(this.f, "RecorderAsrDataSource");     // Catch: Exception -> L4
        this.d.stop();     // Catch: Exception -> L4
        return new h68.a.b(null);
    L4:
        e = move-exception;
        return new h68.a.C0110a(-2002, "recordStopFail", e);
    }

    public final String toString() {
        return this.d.toString();
    }

    @Override // h68.c
    public final h68.a read(byte[] r6) {
        Intrinsics.checkNotNullParameter(r6, "buffer");
        if (this.e.get() == false) goto L45;
        m58.k r7 = c68.a.d("AudioRecord isClientSilenced while reading");
        if (r7 == null) goto L44;
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("task_id", this.a);
        y58.a r2 = this.b;
        if (r2 == null) goto L9;
        String r3 = r2.y;
    L10:
        String r4 = "";
        if (r3 != null) goto L13;
        r3 = "";
    L13:
        r0.put("bot_id", r3);
        y58.a r5 = this.b;
        if (r5 == null) goto L16;
        String r8 = r5.c;
    L17:
        if (r8 != null) goto L19;
        r8 = "";
    L19:
        r0.put("conversation_id", r8);
        y58.a r9 = this.b;
        if (r9 == null) goto L22;
        String r10 = r9.e;
    L23:
        if (r10 != null) goto L25;
        r10 = "";
    L25:
        r0.put("file_path", r10);
        com.larus.audio.utils.b r11 = (com.larus.audio.utils.b) r7;
        r11.c(r0);
        r11.d("FlowAsrClient.read");
        y58.a r1 = this.b;
        if (r1 == null) goto L30;
        y58.d r12 = r1.z;
        if (r12 == null) goto L30;
        String r13 = r12.a;
    L31:
        if (r13 != null) goto L33;
        r13 = "";
    L33:
        r11.b(CollectionsKt.listOf(r13));
        y58.a r14 = this.b;
        if (r14 == null) goto L38;
        y58.d r15 = r14.z;
        if (r15 == null) goto L38;
        String r16 = r15.b;
    L39:
        if (r16 == null) goto L42;
        r4 = r16;
    L42:
        r11.e(r4);
        m58.k.a.a(r11);
    L38:
        r16 = null;
    L30:
        r13 = null;
        goto L31
    L22:
        r10 = null;
        goto L23
    L16:
        r8 = null;
        goto L17
    L9:
        r3 = null;
    L44:
        return new h68.a.C0110a(-2001, "AudioRecord isClientSilenced", null);
    L45:
        int r17 = this.d.i(r6, r6.length);
        if (r17 < 0) goto L49;
        return new h68.a.b(Integer.valueOf(r17));
    L49:
        return new h68.a.C0110a(r17, "AudioRecord readInBlocking error", null);
    }

    public r0(String r2, y58.a r3) {
        Intrinsics.checkNotNullParameter(r2, "taskId");
        this.a = r2;
        this.b = r3;
        Lazy r4 = LazyKt.lazy(new q0());
        this.c = r4;
        p58.d r5 = new p58.d(-1);
        r5.h((v58.a) r4.getValue());
        this.d = r5;
        this.e = new AtomicBoolean(false);
        this.f = new c(this);
    }
}
