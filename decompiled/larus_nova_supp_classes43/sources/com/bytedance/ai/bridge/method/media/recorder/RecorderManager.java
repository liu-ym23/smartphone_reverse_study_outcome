package com.bytedance.ai.bridge.method.media.recorder;

import android.app.Activity;
import android.content.Context;
import android.media.AudioRecord;
import android.media.MediaRecorder;
import android.os.Build;
import android.util.Base64;
import androidx.core.content.PermissionChecker;
import com.bytedance.ai.bridge.doubao.recorder.AbsOperateRecorderMethodIDL;
import com.bytedance.ai.event.MessageIndication;
import com.bytedance.ai.file.AppletFileManager;
import com.bytedance.ai.utils.g;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.google.gson.JsonObject;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.RandomAccessFile;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class RecorderManager implements e3.b {
    public final WeakReference<e3.d> a;
    public final Object b;
    public State c;
    public boolean d;
    public long e;
    public MediaRecorder f;
    public String g;
    public String h;
    public AudioRecord i;
    public PthreadThreadV2 j;
    public int k;
    public int l;
    public int m;
    public long n;
    public volatile Function0<Unit> o;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/ai/bridge/method/media/recorder/RecorderManager$State;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "STARTING", "STARTED", "PAUSED", "STOPPING", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum State extends Enum<State> {
        public static final State IDLE = null;
        public static final State PAUSED = null;
        public static final State STARTED = null;
        public static final State STARTING = null;
        public static final State STOPPING = null;
        public static final /* synthetic */ State[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<State> getEntries() {
            return b;
        }

        static {
            State r0 = new State("IDLE", 0);
            IDLE = r0;
            State r1 = new State("STARTING", 1);
            STARTING = r1;
            State r10 = new State("STARTED", 2);
            STARTED = r10;
            State r11 = new State("PAUSED", 3);
            PAUSED = r11;
            State r12 = new State("STOPPING", 4);
            STOPPING = r12;
            State[] r13 = {r0, r1, r10, r11, r12};
            a = r13;
            b = EnumEntriesKt.enumEntries(r13);
        }

        public static State[] values() {
            return (State[]) a.clone();
        }

        public static State valueOf(String r1) {
            return (State) r27.a.a(State.class, r1);
        }

        public State(String r1, int r10) {
            super(r1, r10);
        }
    }

    public static final class a {
    }

    static {
    }

    @Override // e3.b
    public final void a() {
        g.a.i("AISDK_JSB_RecorderManager", "context released, cleaning up recorder");
        Object r0 = this.b;
        monitor-enter(r0);
        this.d = true;     // Catch: Throwable -> L9
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L9
        monitor-exit(r0);
        q();
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public final f3.a k() {
        g r10 = g.a;
        r10.i("AISDK_JSB_RecorderManager", "pause called");
        if (this.k == 0) goto L5;
    L8:
        Object r11 = this.b;
        monitor-enter(r11);
    L36:
        th = move-exception;
        throw th;
    L11:
        if (this.c == State.STARTED) goto L40;
        StringBuilder r12 = new StringBuilder("pause failed, errNo=");     // Catch: Throwable -> L36
        f3.a.C0156a r1 = f3.a.c;     // Catch: Throwable -> L36
        f3.a r13 = f3.b.a;     // Catch: Throwable -> L36
        Intrinsics.checkNotNullParameter(r1, "<this>");     // Catch: Throwable -> L36
        f3.a r14 = f3.b.p;     // Catch: Throwable -> L36
        r12.append(r14.a);     // Catch: Throwable -> L36
        r12.append(", msg=recorder not started");     // Catch: Throwable -> L36
        r10.e("AISDK_JSB_RecorderManager", r12.toString());     // Catch: Throwable -> L36
        Intrinsics.checkNotNullParameter(r1, "<this>");     // Catch: Throwable -> L36
        monitor-exit(r11);
        return r14;
    L40:
    L22:
        e = move-exception;
        g r15 = g.a;     // Catch: Throwable -> L36
        StringBuilder r16 = new StringBuilder("pause failed, errNo=");     // Catch: Throwable -> L36
        f3.a r0 = f3.a.f;     // Catch: Throwable -> L36
        r16.append(r0.a);     // Catch: Throwable -> L36
        r16.append(", msg=");     // Catch: Throwable -> L36
        r16.append(e.getMessage());     // Catch: Throwable -> L36
        r15.e("AISDK_JSB_RecorderManager", r16.toString());     // Catch: Throwable -> L36
        return r0;
    L16:
        if (this.k <= 0) goto L25;
        AudioRecord r17 = this.i;     // Catch: Exception -> L22 Throwable -> L36
        if (r17 != null) goto L20;
    L28:
        this.c = State.PAUSED;     // Catch: Exception -> L22 Throwable -> L36
        Unit r18 = Unit.INSTANCE;     // Catch: Throwable -> L36
        monitor-exit(r11);
        r10.i("AISDK_JSB_RecorderManager", "recorder paused successfully");
        JsonObject r19 = new JsonObject();
        r19.addProperty("state", "pause");
        l(r19);
        return null;
    L20:
        if (fna.g.d() == true) goto L24;
        e(r17);     // Catch: Exception -> L22 Throwable -> L36
        goto L28
    L24:
        e(r17);     // Catch: Exception -> L22 Throwable -> L36
        hna.a.c(r17.hashCode());     // Catch: Exception -> L22 Throwable -> L36
        goto L28
    L25:
        MediaRecorder r20 = this.f;     // Catch: Exception -> L22 Throwable -> L36
        if (r20 == null) goto L28;
        r20.pause();     // Catch: Exception -> L22 Throwable -> L36
        goto L28
    L5:
        if (Build.VERSION.SDK_INT >= 24) goto L8;
        StringBuilder r21 = new StringBuilder("pause failed, errNo=");
        f3.a r22 = f3.a.g;
        r21.append(r22.a);
        r21.append(", msg=pause not supported below Android N");
        r10.e("AISDK_JSB_RecorderManager", r21.toString());
        return r22;
    }

    public final f3.a p() {
        g r0 = g.a;
        r0.i("AISDK_JSB_RecorderManager", "stop called");
        Object r1 = this.b;
        monitor-enter(r1);
        State r10 = this.c;     // Catch: Throwable -> L17
        if (r10 == State.STARTED) goto L10;
        if (r10 == State.PAUSED) goto L10;
        boolean r11 = false;
    L11:
        monitor-exit(r1);
        if (r11 == true) goto L15;
        StringBuilder r12 = new StringBuilder("stop failed, errNo=");
        f3.a.C0156a r13 = f3.a.c;
        f3.a r14 = f3.b.a;
        Intrinsics.checkNotNullParameter(r13, "<this>");
        f3.a r15 = f3.b.p;
        r12.append(r15.a);
        r12.append(", msg=recorder not started");
        r0.e("AISDK_JSB_RecorderManager", r12.toString());
        Intrinsics.checkNotNullParameter(r13, "<this>");
        return r15;
    L15:
        q();
        return null;
    L10:
        r11 = true;
    L17:
        th = move-exception;
        throw th;
    }

    public final void q() {
        final Ref.ObjectRef r10 = new Ref.ObjectRef();
        final Ref.ObjectRef r11 = new Ref.ObjectRef();
        final Ref.LongRef r12 = new Ref.LongRef();
        Object r13 = this.b;
        monitor-enter(r13);
        State r0 = this.c;     // Catch: Throwable -> L102
        State r14 = State.IDLE;     // Catch: Throwable -> L102
        if (r0 == r14) goto L100;
        State r15 = State.STOPPING;     // Catch: Throwable -> L102
        if (r0 == r15) goto L100;
        String r1 = this.g;     // Catch: Throwable -> L102
        if (r1 != null) goto L14;
        this.c = r14;     // Catch: Throwable -> L102
        monitor-exit(r13);
        return;
    L14:
        r10.element = r1;     // Catch: Throwable -> L102
        this.c = r15;     // Catch: Throwable -> L102
        r11.element = this.h;     // Catch: Throwable -> L102
        if (this.e <= 0) goto L17;
        long r16 = System.currentTimeMillis() - this.e;     // Catch: Throwable -> L102
    L18:
        r12.element = r16;     // Catch: Throwable -> L102
        boolean r17 = true;
        if (this.k <= 0) goto L21;
        boolean r18 = true;
    L22:
        MediaRecorder r19 = this.f;     // Catch: Throwable -> L102
        this.f = null;     // Catch: Throwable -> L102
        AudioRecord r110 = this.i;     // Catch: Throwable -> L102
        this.i = null;     // Catch: Throwable -> L102
        Thread r111 = this.j;     // Catch: Throwable -> L102
        this.j = null;     // Catch: Throwable -> L102
        if (ThreadMethodProxy.currentThread() != r111) goto L25;
        boolean r112 = true;
    L26:
        this.g = null;     // Catch: Throwable -> L102
        this.h = null;     // Catch: Throwable -> L102
        this.k = 0;     // Catch: Throwable -> L102
        Unit r113 = Unit.INSTANCE;     // Catch: Throwable -> L102
        monitor-exit(r13);
        if (r18 == false) goto L61;
        if (r110 != null) goto L106;
    L43:
        if (r110 == null) goto L45;
    L44:
        c(r110);
    L45:
        if (r112 == false) goto L48;
        this.o = new d(r10, r12, this, r11);
        return;
    L48:
        if (r111 != null) goto L110;
    L53:
        if (r111 != null) goto L55;
    L57:
        boolean r20 = false;
    L58:
        if (r20 == false) goto L74;
        g.a.w("AISDK_JSB_RecorderManager", "frame thread did not exit within 5s join timeout; deferring stop event + IDLE transition");
        this.o = new e(r10, r12, this, r11);
        return;
    L74:
        if (r111 != null) goto L76;
    L78:
        r17 = false;
    L79:
        if (r17 == true) goto L91;
        Object r21 = this.b;
        monitor-enter(r21);
    L88:
        th = move-exception;
        throw th;
    L83:
        if (this.c != State.STOPPING) goto L85;
        this.c = State.IDLE;     // Catch: Throwable -> L88
    L85:
        Unit r22 = Unit.INSTANCE;     // Catch: Throwable -> L88
        monitor-exit(r21);
    L91:
        PolarisFileWrapper r23 = new PolarisFileWrapper((String) r10.element);
        if (r23.exists() == false) goto L94;
        long r114 = r23.length();
    L95:
        g.a.i("AISDK_JSB_RecorderManager", "recorder stopped, filePath=" + ((String) r10.element) + ", duration=" + r12.element + " ms, fileSize=" + r114 + " B");
        JsonObject r24 = new JsonObject();
        r24.addProperty("state", "stop");
        String r25 = (String) r11.element;
        if (r25 != null) goto L98;
        r25 = (String) r10.element;
    L98:
        r24.addProperty("tempFilePath", r25);
        r24.addProperty(com.bytedance.android.ec.core.event.a.KEY_DURATION, Long.valueOf(r12.element));
        r24.addProperty("fileSize", Long.valueOf(r114));
        l(r24);
        return;
    L94:
        r114 = 0;
        goto L95
    L76:
        if (ThreadMethodProxy.isAlive(r111) != true) goto L78;
    L55:
        if (ThreadMethodProxy.isAlive(r111) != true) goto L57;
        r20 = true;
        goto L58
    L110:
        ThreadMethodProxy.join(r111, 5000);     // Catch: InterruptedException -> L52
    L52:
        ThreadMethodProxy.currentThread().interrupt();
        goto L53
    L106:
    L35:
        e = move-exception;
        g.a.e("AISDK_JSB_RecorderManager", "AudioRecord stop threw: " + e.getMessage());     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        c(r110);
        throw th;
    L31:
        if (fna.g.d() == true) goto L37;
        e(r110);     // Catch: Throwable -> L33 Exception -> L35
    L105:
    L37:
        e(r110);     // Catch: Throwable -> L33 Exception -> L35
        hna.a.c(r110.hashCode());     // Catch: Throwable -> L33 Exception -> L35
        goto L105
    L61:
        if (r19 != null) goto L108;
    L72:
        if (r19 == null) goto L74;
    L73:
        g(r19);
        goto L74
    L108:
        i(r19);     // Catch: Throwable -> L64 Exception -> L66
    L66:
        e = move-exception;
        g.a.e("AISDK_JSB_RecorderManager", "mediaRecorder stop threw: " + e.getMessage());     // Catch: Throwable -> L64
        Unit r26 = Unit.INSTANCE;     // Catch: Throwable -> L64
    L64:
        th = move-exception;
        g(r19);
        throw th;
    L25:
        r112 = false;
        goto L26
    L21:
        r18 = false;
        goto L22
    L17:
        r16 = 0;
    L100:
        monitor-exit(r13);
        return;
    L102:
        th = move-exception;
        throw th;
    }

    public RecorderManager(e3.d r10) {
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        this.a = new WeakReference(r10);
        this.b = new Object();
        this.c = State.IDLE;
        this.l = 44100;
        this.m = 1;
    }

    public static void c(AudioRecord r12) {
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

    public static void d(AudioRecord r12) {
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

    public static void e(AudioRecord r12) {
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

    public static void f(MediaRecorder r12) {
        f06.c r10 = new f06.c();
        Object[] r11 = new Object[0];
        f06.b r13 = new f06.b();
        if (r10.b(100500, "android/media/MediaRecorder", MessageIndication.STATUS_PREPARE, r12, r11, "void", r13).a == false) goto L6;
        r10.a(100500, "android/media/MediaRecorder", MessageIndication.STATUS_PREPARE, r12, r11, null, r13, false);
        return;
    L6:
        r12.prepare();
        r10.a(100500, "android/media/MediaRecorder", MessageIndication.STATUS_PREPARE, r12, r11, null, r13, true);
    }

    public static void g(MediaRecorder r12) {
        f06.c r10 = new f06.c();
        Object[] r11 = new Object[0];
        f06.b r13 = new f06.b();
        if (r10.b(100501, "android/media/MediaRecorder", "release", r12, r11, "void", r13).a == false) goto L6;
        r10.a(100501, "android/media/MediaRecorder", "release", r12, r11, null, r13, false);
        return;
    L6:
        r12.release();
        r10.a(100501, "android/media/MediaRecorder", "release", r12, r11, null, r13, true);
    }

    public static void h(MediaRecorder r12) {
        f06.c r10 = new f06.c();
        Object[] r11 = new Object[0];
        f06.b r13 = new f06.b();
        if (r10.b(100502, "android/media/MediaRecorder", "start", r12, r11, "void", r13).a == false) goto L6;
        r10.a(100502, "android/media/MediaRecorder", "start", r12, r11, null, r13, false);
        return;
    L6:
        r12.start();
        r10.a(100502, "android/media/MediaRecorder", "start", r12, r11, null, r13, true);
    }

    public static void i(MediaRecorder r12) {
        f06.c r10 = new f06.c();
        Object[] r11 = new Object[0];
        f06.b r13 = new f06.b();
        if (r10.b(100503, "android/media/MediaRecorder", "stop", r12, r11, "void", r13).a == false) goto L6;
        r10.a(100503, "android/media/MediaRecorder", "stop", r12, r11, null, r13, false);
        return;
    L6:
        r12.stop();
        r10.a(100503, "android/media/MediaRecorder", "stop", r12, r11, null, r13, true);
    }

    public final void l(JsonObject r10) {
        e3.d r0 = this.a.get();
        if (r0 == null) goto L6;
        r0.a("doubao.onRecorderStateChange", r10);
        return;
    }

    public final f3.a m(AbsOperateRecorderMethodIDL.b r10) {
        Intrinsics.checkNotNullParameter(r10, "params");
        g r1 = g.a;
        r1.i("AISDK_JSB_RecorderManager", "start called, format=" + r10.getFormat() + ", sampleRate=" + r10.getSampleRate() + ", frameSize=" + r10.getFrameSize());
        Object r11 = this.b;
        monitor-enter(r11);
    L75:
        th = move-exception;
        throw th;
    L5:
        if (this.d == false) goto L9;
        r1.e("AISDK_JSB_RecorderManager", "start failed, context already released");     // Catch: Throwable -> L75
        f3.a r12 = f3.a.f;     // Catch: Throwable -> L75
        monitor-exit(r11);
        return r12;
    L9:
        State r13 = this.c;     // Catch: Throwable -> L75
        State r14 = State.IDLE;     // Catch: Throwable -> L75
        if (r13 == r14) goto L14;
        StringBuilder r15 = new StringBuilder("start failed, errNo=");     // Catch: Throwable -> L75
        f3.a.C0156a r0 = f3.a.c;     // Catch: Throwable -> L75
        f3.a r16 = f3.b.a;     // Catch: Throwable -> L75
        Intrinsics.checkNotNullParameter(r0, "<this>");     // Catch: Throwable -> L75
        f3.a r17 = f3.b.o;     // Catch: Throwable -> L75
        r15.append(r17.a);     // Catch: Throwable -> L75
        r15.append(", msg=recorder already recording");     // Catch: Throwable -> L75
        r1.e("AISDK_JSB_RecorderManager", r15.toString());     // Catch: Throwable -> L75
        Intrinsics.checkNotNullParameter(r0, "<this>");     // Catch: Throwable -> L75
        monitor-exit(r11);
        return r17;
    L14:
        State r18 = State.STARTING;     // Catch: Throwable -> L75
        this.c = r18;     // Catch: Throwable -> L75
        Unit r19 = Unit.INSTANCE;     // Catch: Throwable -> L75
        monitor-exit(r11);
        e3.d r20 = this.a.get();
        if (r20 == null) goto L21;
        Activity r21 = r20.getOwnerActivity();
        if (r21 == null) goto L21;
        Context r22 = r21.getApplicationContext();
    L22:
        if (r22 != null) goto L33;
        StringBuilder r23 = new StringBuilder("start failed, errNo=");
        f3.a r24 = f3.a.f;
        r23.append(r24.a);
        r23.append(", msg=context is null");
        r1.e("AISDK_JSB_RecorderManager", r23.toString());
        Object r25 = this.b;
        monitor-enter(r25);
    L30:
        th = move-exception;
        throw th;
    L26:
        if (this.c != r18) goto L28;
        this.c = r14;     // Catch: Throwable -> L30
    L28:
        monitor-exit(r25);
        return r24;
    L33:
        int r26 = 0;
        if (PermissionChecker.checkSelfPermission(r22, "android.permission.RECORD_AUDIO") != 0) goto L36;
        boolean r27 = true;
    L37:
        if (r27 == true) goto L48;
        StringBuilder r28 = new StringBuilder("start failed, errNo=");
        f3.a r29 = f3.a.j;
        r28.append(r29.a);
        r28.append(", msg=RECORD_AUDIO permission denied");
        r1.e("AISDK_JSB_RecorderManager", r28.toString());
        Object r30 = this.b;
        monitor-enter(r30);
    L45:
        th = move-exception;
        throw th;
    L41:
        if (this.c != r18) goto L43;
        this.c = r14;     // Catch: Throwable -> L45
    L43:
        monitor-exit(r30);
        return r29;
    L48:
        Integer r31 = r10.getFrameSize();
        if (r31 == null) goto L51;
        r26 = r31.intValue();
    L51:
        String r32 = r10.getFormat();
        if (r32 != null) goto L54;
        r32 = "aac";
    L54:
        if (r26 <= 0) goto L57;
        f3.a r33 = n(r10, r22, r26);
    L63:
        if (r33 == null) goto L74;
        Object r34 = this.b;
        monitor-enter(r34);
    L71:
        th = move-exception;
        throw th;
    L67:
        if (this.c != r18) goto L69;
        this.c = r14;     // Catch: Throwable -> L71
    L69:
        monitor-exit(r34);
    L74:
        return r33;
    L57:
        if (Intrinsics.areEqual(r32, "pcm") == false) goto L59;
    L62:
        StringBuilder r35 = new StringBuilder("start failed, errNo=");
        f3.a r36 = f3.a.g;
        r35.append(r36.a);
        r35.append(", msg=format=");
        r35.append(r32);
        r35.append(" requires frameSize on Android");
        r1.e("AISDK_JSB_RecorderManager", r35.toString());
        r33 = r36;
        goto L63
    L59:
        if (Intrinsics.areEqual(r32, "wav") == true) goto L62;
        r33 = o(r10, r22);
        goto L63
    L36:
        r27 = false;
    L21:
        r22 = null;
        goto L22
    }

    public final void b(MediaRecorder r10, PolarisFileWrapper r11) {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L9
        if (r10 == null) goto L6;
        g(r10);     // Catch: Throwable -> L9
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L9
    L7:
        Result.constructor-impl(r12);     // Catch: Throwable -> L9
    L11:
        Object r13 = this.b;
        monitor-enter(r13);
    L26:
        th = move-exception;
        throw th;
    L14:
        if (this.f != r10) goto L16;
        this.f = null;     // Catch: Throwable -> L26
    L16:
        this.c = State.IDLE;     // Catch: Throwable -> L26
        this.g = null;     // Catch: Throwable -> L26
        this.h = null;     // Catch: Throwable -> L26
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L26
        monitor-exit(r13);
    L23:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return;
    L19:
        if (r11.exists() == false) goto L21;
        r11.delete();     // Catch: Throwable -> L23
    L21:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L23
        return;
    L6:
        r12 = null;
    L9:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }

    public final f3.a o(AbsOperateRecorderMethodIDL.b r20, Context r21) {
        Integer r0 = r20.getSampleRate();
        if (r0 == null) goto L5;
        int r10 = r0.intValue();
    L6:
        Integer r1 = r20.getNumberOfChannels();
        boolean r11 = true;
        if (r1 == null) goto L9;
        int r12 = r1.intValue();
    L10:
        Integer r13 = r20.getEncodeBitRate();
        if (r13 == null) goto L13;
        int r14 = r13.intValue();
    L14:
        Integer r15 = r20.getDuration();
        if (r15 == null) goto L17;
        int r16 = r15.intValue();
    L18:
        e3.d r17 = this.a.get();
        MediaRecorder r18 = null;
        if (r17 == null) goto L21;
        AppletFileManager r19 = x3.a.d(r17);
    L22:
        if (r19 == null) goto L27;
        PolarisFileWrapper r110 = r19.e;
        if (r110.exists() == true) goto L26;
        r110.mkdirs();
    L26:
        PolarisFileWrapper r111 = new PolarisFileWrapper(r110, "recorder_" + System.currentTimeMillis() + ".m4a");
    L31:
        this.g = r111.getAbsolutePath();
        if (r19 != null) goto L102;
        String r22 = null;
    L42:
        this.h = r22;
    L97:
        e = e;
    L98:
        b(r18, r111);
        g r23 = g.a;
        StringBuilder r24 = new StringBuilder("start failed, errNo=");
        f3.a r25 = f3.a.j;
        r24.append(r25.a);
        r24.append(", msg=");
        r24.append(e.getMessage());
        r23.e("AISDK_JSB_RecorderManager", r24.toString());
        return r25;
    L88:
        e = e;
    L89:
        b(r18, r111);
        if (PermissionChecker.checkSelfPermission(r21, "android.permission.RECORD_AUDIO") == 0) goto L93;
        r11 = false;
    L93:
        if (r11 == true) goto L95;
        f3.a r26 = f3.a.j;
    L96:
        f3.a r27 = r26;
        g.a.e("AISDK_JSB_RecorderManager", "start failed, errNo=" + r27.a + ", msg=" + e.getMessage());
        return r27;
    L95:
        f3.a.C0156a r28 = f3.a.c;
        f3.a r29 = f3.b.a;
        Intrinsics.checkNotNullParameter(r28, "<this>");
        r26 = f3.b.n;
    L86:
        e = e;
    L87:
        b(r18, r111);
        g r30 = g.a;
        StringBuilder r31 = new StringBuilder("start failed, errNo=");
        f3.a.C0156a r32 = f3.a.c;
        f3.a r33 = f3.b.a;
        Intrinsics.checkNotNullParameter(r32, "<this>");
        f3.a r34 = f3.b.n;
        r31.append(r34.a);
        r31.append(", msg=");
        r31.append(e.getMessage());
        r30.e("AISDK_JSB_RecorderManager", r31.toString());
        Intrinsics.checkNotNullParameter(r32, "<this>");
        return r34;
    L44:
        if (Build.VERSION.SDK_INT < 31) goto L46;
        MediaRecorder r35 = new MediaRecorder(r21);     // Catch: Exception -> L86 RuntimeException -> L88 SecurityException -> L97
    L47:
        MediaRecorder r112 = r35;
        r112.setAudioSource(1);     // Catch: Exception -> L80 RuntimeException -> L82 SecurityException -> L84
        r112.setOutputFormat(2);     // Catch: Exception -> L80 RuntimeException -> L82 SecurityException -> L84
        r112.setAudioEncoder(3);     // Catch: Exception -> L80 RuntimeException -> L82 SecurityException -> L84
        r112.setAudioSamplingRate(r10);     // Catch: Exception -> L80 RuntimeException -> L82 SecurityException -> L84
        r112.setAudioChannels(r12);     // Catch: Exception -> L80 RuntimeException -> L82 SecurityException -> L84
        r112.setAudioEncodingBitRate(r14);     // Catch: Exception -> L80 RuntimeException -> L82 SecurityException -> L84
        r112.setOutputFile(this.g);     // Catch: Exception -> L80 RuntimeException -> L82 SecurityException -> L84
        if (r16 <= 0) goto L51;
        r112.setMaxDuration(r16);     // Catch: Exception -> L80 RuntimeException -> L82 SecurityException -> L84
    L51:
        r112.setOnInfoListener(new b(this));     // Catch: Exception -> L80 RuntimeException -> L82 SecurityException -> L84
        r112.setOnErrorListener(new c(this));     // Catch: Exception -> L80 RuntimeException -> L82 SecurityException -> L84
        f(r112);     // Catch: Exception -> L80 RuntimeException -> L82 SecurityException -> L84
        h(r112);     // Catch: Exception -> L80 RuntimeException -> L82 SecurityException -> L84
        Object r36 = this.b;     // Catch: Exception -> L80 RuntimeException -> L82 SecurityException -> L84
        monitor-enter(r36);     // Catch: Exception -> L80 RuntimeException -> L82 SecurityException -> L84
    L77:
        th = move-exception;
        throw th;     // Catch: Exception -> L80 RuntimeException -> L82 SecurityException -> L84
    L54:
        if (this.c != State.STARTING) goto L56;
        this.f = r112;     // Catch: Throwable -> L77
        this.c = State.STARTED;     // Catch: Throwable -> L77
        this.e = System.currentTimeMillis();     // Catch: Throwable -> L77
        boolean r37 = false;
    L57:
        Unit r38 = Unit.INSTANCE;     // Catch: Throwable -> L77
        monitor-exit(r36);     // Catch: Exception -> L80 RuntimeException -> L82 SecurityException -> L84
        if (r37 == true) goto L104;
        g.a.i("AISDK_JSB_RecorderManager", "recorder started successfully (MediaRecorder), filePath=" + this.g);     // Catch: Exception -> L80 RuntimeException -> L82 SecurityException -> L84
        JsonObject r39 = new JsonObject();     // Catch: Exception -> L80 RuntimeException -> L82 SecurityException -> L84
        r39.addProperty("state", "start");     // Catch: Exception -> L80 RuntimeException -> L82 SecurityException -> L84
        l(r39);     // Catch: Exception -> L80 RuntimeException -> L82 SecurityException -> L84
        return null;
    L104:
        Result.Companion r40 = Result.Companion;     // Catch: Throwable -> L62
        g(r112);     // Catch: Throwable -> L62
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L62
    L64:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(com.bytedance.ai.infra.thread_pool.b.a), null, null, new RecorderManager$startWithMediaRecorder$6(r111, null), 3, null);     // Catch: Exception -> L80 RuntimeException -> L82 SecurityException -> L84
        Object r41 = this.b;     // Catch: Exception -> L80 RuntimeException -> L82 SecurityException -> L84
        monitor-enter(r41);     // Catch: Exception -> L80 RuntimeException -> L82 SecurityException -> L84
    L73:
        th = move-exception;
        throw th;     // Catch: Exception -> L80 RuntimeException -> L82 SecurityException -> L84
    L67:
        if (this.c != State.STOPPING) goto L69;
        this.c = State.IDLE;     // Catch: Throwable -> L73
    L69:
        this.g = null;     // Catch: Throwable -> L73
        this.h = null;     // Catch: Throwable -> L73
        Unit r42 = Unit.INSTANCE;     // Catch: Throwable -> L73
        monitor-exit(r41);     // Catch: Exception -> L80 RuntimeException -> L82 SecurityException -> L84
        g.a.w("AISDK_JSB_RecorderManager", "start aborted by concurrent stop during initialization (MediaRecorder)");     // Catch: Exception -> L80 RuntimeException -> L82 SecurityException -> L84
        f3.a.C0156a r43 = f3.a.c;     // Catch: Exception -> L80 RuntimeException -> L82 SecurityException -> L84
        f3.a r44 = f3.b.a;     // Catch: Exception -> L80 RuntimeException -> L82 SecurityException -> L84
        Intrinsics.checkNotNullParameter(r43, "<this>");     // Catch: Exception -> L80 RuntimeException -> L82 SecurityException -> L84
        return f3.b.n;
    L62:
        th = move-exception;
        Result.Companion r45 = Result.Companion;     // Catch: Exception -> L80 RuntimeException -> L82 SecurityException -> L84
        Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Exception -> L80 RuntimeException -> L82 SecurityException -> L84
        goto L64
    L56:
        r37 = true;
    L84:
        e = e;
        r18 = r112;
    L82:
        e = e;
        r18 = r112;
    L80:
        e = e;
        r18 = r112;
        goto L87
    L46:
        r35 = new MediaRecorder();     // Catch: Exception -> L86 RuntimeException -> L88 SecurityException -> L97
        goto L47
    L102:
        Result.Companion r113 = Result.Companion;     // Catch: Throwable -> L35
        Object r46 = Result.constructor-impl(r19.e(r111).a());     // Catch: Throwable -> L35
    L38:
        if (Result.isFailure-impl(r46) == false) goto L40;
        r46 = null;
    L40:
        r22 = (String) r46;
    L35:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r46 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L38
    L27:
        File r115 = r21.getExternalCacheDir();
        if (r115 != null) goto L30;
        r115 = r21.getCacheDir();
    L30:
        r111 = new PolarisFileWrapper(r115, "recorder_" + System.currentTimeMillis() + ".m4a");
        goto L31
    L21:
        r19 = null;
        goto L22
    L17:
        r16 = 60000;
        goto L18
    L13:
        r14 = 128000;
        goto L14
    L9:
        r12 = 1;
        goto L10
    L5:
        r10 = 44100;
        goto L6
    }

    public final void j(ByteArrayOutputStream r10, int r11, RandomAccessFile r12) {
    L3:
        if (r10.size() < r11) goto L19;
        byte[] r0 = r10.toByteArray();
        Intrinsics.checkNotNull(r0);
        byte[] r1 = Arrays.copyOf(r0, r11);
        byte[] r13 = ArraysKt.copyOfRange(r0, r11, r0.length);
        r10.reset();
        if (r13.length != 0) goto L7;
        boolean r14 = true;
    L9:
        if ((!r14) == false) goto L11;
        r10.write(r13);
    L11:
        Object r15 = this.b;
        monitor-enter(r15);
        r12.write(r1);     // Catch: Throwable -> L16
        this.n += (long) r1.length;     // Catch: Throwable -> L16
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L16
        monitor-exit(r15);
        String r17 = Base64.encodeToString(r1, 2);
        JsonObject r18 = new JsonObject();
        r18.addProperty("state", "frameRecorded");
        r18.addProperty("frameBuffer", r17);
        r18.addProperty("isLastFrame", false);
        l(r18);
    L16:
        th = move-exception;
        throw th;
    L7:
        r14 = false;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v1, types: [int] */
    /* JADX WARN: Type inference failed for: r14v10, types: [android.media.AudioRecord] */
    /* JADX WARN: Type inference failed for: r14v12 */
    /* JADX WARN: Type inference failed for: r14v13 */
    /* JADX WARN: Type inference failed for: r14v2 */
    /* JADX WARN: Type inference failed for: r14v3, types: [android.media.AudioRecord] */
    /* JADX WARN: Type inference failed for: r14v4 */
    /* JADX WARN: Type inference failed for: r14v5 */
    /* JADX WARN: Type inference failed for: r14v6 */
    /* JADX WARN: Type inference failed for: r14v9 */
    /* JADX WARN: Type inference failed for: r3v8, types: [android.media.AudioRecord] */
    public final f3.a n(AbsOperateRecorderMethodIDL.b r17, Context r18, int r19) {
        Integer r10 = r17.getSampleRate();
        if (r10 == null) goto L5;
        int r11 = r10.intValue();
    L6:
        Integer r12 = r17.getNumberOfChannels();
        if (r12 == null) goto L9;
        int r13 = r12.intValue();
    L10:
        Integer r14 = r17.getDuration();
        if (r14 == null) goto L13;
        final int r15 = r14.intValue();
    L15:
        if (r19 <= 4096) goto L18;
        g.a.e("AISDK_JSB_RecorderManager", "start failed, frameSize=" + r19 + " KB exceeds maximum 4096 KB");
        f3.a.C0156a r0 = f3.a.c;
        f3.a r1 = f3.b.a;
        Intrinsics.checkNotNullParameter(r0, "<this>");
        return f3.b.n;
    L18:
        final int r16 = r19 * 1024;
        if (r13 < 2) goto L21;
        int r110 = 12;
    L22:
        if (r110 != 12) goto L24;
        int r20 = 2;
    L25:
        int r21 = AudioRecord.getMinBufferSize(r11, r110, 2);
        if (r21 != (-2)) goto L28;
    L131:
        g.a.e("AISDK_JSB_RecorderManager", "start failed, AudioRecord.getMinBufferSize returned error=" + r21);
        f3.a.C0156a r22 = f3.a.c;
        f3.a r23 = f3.b.a;
        Intrinsics.checkNotNullParameter(r22, "<this>");
        return f3.b.n;
    L28:
        if (r21 == (-1)) goto L131;
        final int r111 = Math.max(r21, r16);
        ?? r112 = r111;
        AudioRecord r113 = new AudioRecord(1, r11, r110, 2, r112);
        if (r113.getState() == 1) goto L33;
        c(r113);
        g.a.e("AISDK_JSB_RecorderManager", "start failed, AudioRecord failed to initialize");
        f3.a.C0156a r24 = f3.a.c;
        f3.a r25 = f3.b.a;
        Intrinsics.checkNotNullParameter(r24, "<this>");
        return f3.b.n;
    L33:
        e3.d r26 = this.a.get();
        Unit r27 = null;
        if (r26 == null) goto L36;
        AppletFileManager r28 = x3.a.d(r26);
    L37:
        if (r28 == null) goto L42;
        PolarisFileWrapper r114 = r28.e;
        if (r114.exists() == true) goto L41;
        r114.mkdirs();
    L41:
        PolarisFileWrapper r115 = new PolarisFileWrapper(r114, "recorder_" + System.currentTimeMillis() + ".wav");
    L46:
        if (r28 != null) goto L156;
        String r29 = null;
    L150:
        final RandomAccessFile r116 = new RandomAccessFile(r115, "rw");     // Catch: Exception -> L112
        r(r116, 44100, 1, 0);     // Catch: Exception -> L109
        if (fna.g.d() == true) goto L61;
        d(r113);     // Catch: Exception -> L109
    L62:
        Object r30 = this.b;     // Catch: Exception -> L109
        monitor-enter(r30);     // Catch: Exception -> L109
        if (this.c != State.STARTING) goto L70;
        AudioRecord r117 = r113;
        this.i = r117;     // Catch: Throwable -> L68
        this.k = r16;     // Catch: Throwable -> L68
        this.l = r11;     // Catch: Throwable -> L68
        this.m = r20;     // Catch: Throwable -> L68
        this.g = r115.getAbsolutePath();     // Catch: Throwable -> L68
        this.h = r29;     // Catch: Throwable -> L68
        this.n = 0;     // Catch: Throwable -> L68
        this.c = State.STARTED;     // Catch: Throwable -> L68
        this.e = System.currentTimeMillis();     // Catch: Throwable -> L68
        boolean r31 = false;
        r112 = r117;
    L71:
        Unit r32 = Unit.INSTANCE;     // Catch: Throwable -> L68
        monitor-exit(r30);     // Catch: Exception -> L107
        if (r31 == true) goto L148;
        g.a.i("AISDK_JSB_RecorderManager", "recorder started successfully (AudioRecord), filePath=" + r115.getAbsolutePath());     // Catch: Exception -> L107
        JsonObject r33 = new JsonObject();     // Catch: Exception -> L107
        r33.addProperty("state", "start");     // Catch: Exception -> L107
        l(r33);     // Catch: Exception -> L107
        final ?? r34 = r112;
        PthreadThreadV2 r35 = new PthreadThreadV2(null, new com.bytedance.ai.bridge.method.media.recorder.a(this, r34, r116, r16, r111, r15), "RecorderFrameThread");     // Catch: Exception -> L107
        Object r36 = this.b;     // Catch: Exception -> L107
        monitor-enter(r36);     // Catch: Exception -> L107
        this.j = r35;     // Catch: Throwable -> L99
        monitor-exit(r36);     // Catch: Exception -> L107
        ThreadMethodProxy.start(r35);     // Catch: Exception -> L107
        return null;
    L99:
        th = move-exception;
        throw th;     // Catch: Exception -> L107
    L148:
        Result.Companion r37 = Result.Companion;     // Catch: Throwable -> L76
        r116.close();     // Catch: Throwable -> L76
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L76
    L135:
        c(r112);     // Catch: Throwable -> L80
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L80
    L82:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(com.bytedance.ai.infra.thread_pool.b.a), null, null, new RecorderManager$startWithAudioRecord$4(r115, null), 3, null);     // Catch: Exception -> L107
        Object r38 = this.b;     // Catch: Exception -> L107
        monitor-enter(r38);     // Catch: Exception -> L107
    L91:
        th = move-exception;
        throw th;     // Catch: Exception -> L107
    L85:
        if (this.c != State.STOPPING) goto L87;
        this.c = State.IDLE;     // Catch: Throwable -> L91
    L87:
        Unit r39 = Unit.INSTANCE;     // Catch: Throwable -> L91
        monitor-exit(r38);     // Catch: Exception -> L107
        g.a.w("AISDK_JSB_RecorderManager", "start aborted by concurrent stop during initialization (AudioRecord)");     // Catch: Exception -> L107
        f3.a.C0156a r40 = f3.a.c;     // Catch: Exception -> L107
        f3.a r41 = f3.b.a;     // Catch: Exception -> L107
        Intrinsics.checkNotNullParameter(r40, "<this>");     // Catch: Exception -> L107
        return f3.b.n;
    L80:
        th = move-exception;
        Result.Companion r42 = Result.Companion;     // Catch: Exception -> L107
        Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Exception -> L107
        goto L82
    L76:
        th = move-exception;
        Result.Companion r43 = Result.Companion;     // Catch: Exception -> L107
        Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Exception -> L107
    L68:
        th = th;
    L105:
        monitor-exit(r30);     // Catch: Exception -> L107
        throw th;     // Catch: Exception -> L107
    L70:
        r112 = r113;
        r31 = true;
    L103:
        th = th;
    L107:
        e = e;
    L111:
        Exception r44 = e;
        ?? r118 = r112;
    L144:
        Result.Companion r45 = Result.Companion;     // Catch: Throwable -> L119
        if (r116 == null) goto L117;
        r116.close();     // Catch: Throwable -> L119
        r27 = Unit.INSTANCE;     // Catch: Throwable -> L119
    L117:
        Result.constructor-impl(r27);     // Catch: Throwable -> L119
    L133:
        c(r118);     // Catch: Throwable -> L123
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L123
    L152:
        Result.constructor-impl(Boolean.valueOf(r115.delete()));     // Catch: Throwable -> L127
    L129:
        g r46 = g.a;
        StringBuilder r47 = new StringBuilder("start failed (AudioRecord), errNo=");
        f3.a.C0156a r48 = f3.a.c;
        f3.a r49 = f3.b.a;
        Intrinsics.checkNotNullParameter(r48, "<this>");
        f3.a r50 = f3.b.n;
        r47.append(r50.a);
        r47.append(", msg=");
        r47.append(r44.getMessage());
        r46.e("AISDK_JSB_RecorderManager", r47.toString());
        Intrinsics.checkNotNullParameter(r48, "<this>");
        return r50;
    L127:
        th = move-exception;
        Result.Companion r51 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L123:
        th = move-exception;
        Result.Companion r52 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L119:
        th = move-exception;
        Result.Companion r53 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L133
    L61:
        d(r113);     // Catch: Exception -> L109
        hna.a.b(r113.hashCode());     // Catch: Exception -> L109
    L109:
        e = e;
        r112 = r113;
    L112:
        e = move-exception;
        r118 = r113;
        r44 = e;
        r116 = null;
        goto L144
    L156:
        Result.Companion r119 = Result.Companion;     // Catch: Throwable -> L49
        Object r54 = Result.constructor-impl(r28.e(r115).a());     // Catch: Throwable -> L49
    L52:
        if (Result.isFailure-impl(r54) == false) goto L54;
        r54 = null;
    L54:
        r29 = (String) r54;
    L49:
        th = move-exception;
        Result.Companion r120 = Result.Companion;
        r54 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L52
    L42:
        File r121 = r18.getExternalCacheDir();
        if (r121 != null) goto L45;
        r121 = r18.getCacheDir();
    L45:
        r115 = new PolarisFileWrapper(r121, "recorder_" + System.currentTimeMillis() + ".wav");
        goto L46
    L36:
        r28 = null;
        goto L37
    L24:
        r20 = 1;
        goto L25
    L21:
        r110 = 16;
        goto L22
    L13:
        r15 = 60000;
        goto L15
    L9:
        r13 = 1;
        goto L10
    L5:
        r11 = 44100;
        goto L6
    }

    public static void r(RandomAccessFile r10, int r11, int r12, long r13) {
        long r0 = ((long) (r11 * r12)) * 2;
        short r14 = (short) (r12 * 2);
        ByteBuffer r15 = ByteBuffer.allocate(44).order(ByteOrder.LITTLE_ENDIAN);
        Charset r16 = Charsets.US_ASCII;
        r15.put("RIFF".getBytes(r16));
        r15.putInt((int) RangesKt.coerceAtMost(((long) 36) + r13, 2147483647L));
        r15.put("WAVE".getBytes(r16));
        r15.put("fmt ".getBytes(r16));
        r15.putInt(16);
        r15.putShort(1);
        r15.putShort((short) r12);
        r15.putInt(r11);
        r15.putInt((int) RangesKt.coerceAtMost(r0, 2147483647L));
        r15.putShort(r14);
        r15.putShort(16);
        r15.put("data".getBytes(r16));
        r15.putInt((int) RangesKt.coerceAtMost(r13, 2147483647L));
        r10.write(r15.array());
    }
}
