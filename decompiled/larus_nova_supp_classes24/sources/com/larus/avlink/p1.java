package com.larus.avlink;

import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.audio.audiov3.audio.record.AudioRecordState;
import com.larus.avlink.plugins.n4;
import com.larus.platform.api.IDoraAutoTestPlatform;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.BufferedInputStream;
import java.io.File;
import java.util.Arrays;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class p1 implements r58.c {
    public static volatile p1 o;
    public final Function0<Unit> a;
    public final n4 b;
    public final int c;
    public AudioRecordState d;
    public PolarisFileInputStreamWrapper e;
    public BufferedInputStream f;
    public final ConcurrentLinkedQueue<String> g;
    public String h;
    public final BlockingQueue<byte[]> i;
    public final com.larus.audio.call.util.o j;
    public final AtomicBoolean k;
    public boolean l;
    public boolean m;
    public Function0<Unit> n;

    public static final class a {
    }

    static {
    }

    @Override // r58.c
    public final void b(long r1, long r3) {
    }

    @Override // r58.c
    public final long d(long r1) {
        return 0;
    }

    @Override // r58.c
    public final void f(Function2<? super String, ? super Long, Unit> r1) {
    }

    @Override // r58.c
    public final void g(Function2<? super Boolean, ? super String, Unit> r1) {
    }

    @Override // r58.c
    public final void j() {
    }

    public final void m() {
        BufferedInputStream r1 = this.f;     // Catch: Throwable -> L10 Exception -> L12
        if (r1 == null) goto L6;
        r1.close();     // Catch: Throwable -> L10 Exception -> L12
    L6:
        PolarisFileInputStreamWrapper r2 = this.e;     // Catch: Throwable -> L10 Exception -> L12
        if (r2 == null) goto L14;
        r2.close();     // Catch: Throwable -> L10 Exception -> L12
    L14:
        this.f = null;
        this.e = null;
        return;
    L10:
        th = move-exception;
        this.f = null;
        this.e = null;
        throw th;
    L12:
        e = move-exception;
        n1.c("MockAudioRecorder", "Failed to close streams", e);     // Catch: Throwable -> L10
        goto L14
    }

    public final boolean p() {
        String r0 = this.g.poll();
        if (r0 == null) goto L32;
        n1.a("MockAudioRecorder", "tryNextFile: switching to ".concat(r0));
        n1.a("MockAudioRecorder", "switchToFile: ".concat(r0));
        m();
        String r1 = new PolarisFileWrapper(r0).getCanonicalPath();
        this.h = r1;
        PolarisFileWrapper r12 = new PolarisFileWrapper(r1);     // Catch: Exception -> L29
        n1.a("MockAudioRecorder", "File exists: " + r12.exists() + ", isFile: " + r12.isFile() + ", canRead: " + r12.canRead());     // Catch: Exception -> L29
        StringBuilder r10 = new StringBuilder("File size: ");     // Catch: Exception -> L29
        if (r12.exists() == false) goto L8;
        Object r9 = Long.valueOf(r12.length());     // Catch: Exception -> L29
    L9:
        r10.append(r9);     // Catch: Exception -> L29
        r10.append(" bytes");     // Catch: Exception -> L29
        n1.a("MockAudioRecorder", r10.toString());     // Catch: Exception -> L29
        if (r12.exists() == true) goto L12;
    L16:
        n1.b("MockAudioRecorder", "File does not exist, is not a file, or cannot be read: " + r1);     // Catch: Exception -> L29
        n1.b("MockAudioRecorder", "  - exists: " + r12.exists());     // Catch: Exception -> L29
        n1.b("MockAudioRecorder", "  - isFile: " + r12.isFile());     // Catch: Exception -> L29
        n1.b("MockAudioRecorder", "  - canRead: " + r12.canRead());     // Catch: Exception -> L29
        if (r12.exists() == false) goto L27;
        StringBuilder r4 = new StringBuilder("  - parent exists: ");     // Catch: Exception -> L29
        File r3 = r12.getParentFile();     // Catch: Exception -> L29
        if (r3 == null) goto L21;
        Boolean r5 = Boolean.valueOf(r3.exists());     // Catch: Exception -> L29
    L22:
        r4.append(r5);     // Catch: Exception -> L29
        n1.b("MockAudioRecorder", r4.toString());     // Catch: Exception -> L29
        StringBuilder r6 = new StringBuilder("  - parent canRead: ");     // Catch: Exception -> L29
        File r2 = r12.getParentFile();     // Catch: Exception -> L29
        if (r2 == null) goto L25;
        Boolean r7 = Boolean.valueOf(r2.canRead());     // Catch: Exception -> L29
    L26:
        r6.append(r7);     // Catch: Exception -> L29
        n1.b("MockAudioRecorder", r6.toString());     // Catch: Exception -> L29
        goto L27
    L25:
        r7 = null;
        goto L26
    L21:
        r5 = null;
    L27:
        this.h = null;     // Catch: Exception -> L29
    L31:
        return true;
    L12:
        if (r12.isFile() == false) goto L16;
        if (r12.canRead() == false) goto L16;
        this.e = new PolarisFileInputStreamWrapper(r12);     // Catch: Exception -> L29
        this.f = new BufferedInputStream(this.e, 800000);     // Catch: Exception -> L29
        n1.a("MockAudioRecorder", "Successfully opened file: " + r1);     // Catch: Exception -> L29
        goto L31
    L8:
        r9 = "N/A";
    L29:
        e = move-exception;
        n1.c("MockAudioRecorder", "Failed to open file: " + r1, e);
        this.h = null;
        goto L31
    L32:
        return false;
    }

    @Override // r58.c
    public final void prepare() {
        n1.a("MockAudioRecorder", "prepare");
        n(AudioRecordState.INITIALIZED);
    }

    @Override // r58.c
    public final void release() {
        n1.a("MockAudioRecorder", "release");
        this.k.set(true);
        m();     // Catch: Exception -> L5
        ((LinkedBlockingQueue) this.i).clear();     // Catch: Exception -> L5
        n1.a("MockAudioRecorder", "clearAllAudioFiles");     // Catch: Exception -> L5
        this.g.clear();     // Catch: Exception -> L5
        m();     // Catch: Exception -> L5
        this.h = null;     // Catch: Exception -> L5
    L7:
        n(AudioRecordState.UNINITIALIZED);
        n1.b("MockAudioRecorder", "unRegisterDoraVoiceCallback");
        if (Intrinsics.areEqual(o, this) == false) goto L13;
        o = null;
        return;
    L13:
        return;
    L5:
        e = move-exception;
        n1.c("MockAudioRecorder", "stream release exception", e);
        goto L7
    }

    @Override // r58.c
    public final void start() {
        n1.a("MockAudioRecorder", "start, queue size: " + this.g.size());
        n(AudioRecordState.STARTED);
    }

    @Override // r58.c
    public final void stop() {
        n1.a("MockAudioRecorder", "stop");
        n(AudioRecordState.STOPPED);
    }

    @Override // r58.c
    public final int c() {
        return this.c;
    }

    @Override // r58.c
    public final AudioRecordState l() {
        return this.d;
    }

    public p1(n4 r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this.a = null;
        this.b = r3;
        this.c = 80;
        this.d = AudioRecordState.UNINITIALIZED;
        this.g = new ConcurrentLinkedQueue();
        this.i = new LinkedBlockingQueue();
        this.j = new com.larus.audio.call.util.o(300);
        this.k = new AtomicBoolean(false);
        this.l = true;
        o = this;
        n1.b("MockAudioRecorder", "registerDoraVoiceCallback");
        n(AudioRecordState.INITIALIZED);
    }

    @Override // r58.c
    public final void a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "scene");
    }

    @Override // r58.c
    public final void e(Function0<Unit> r4) {
        n1.a("MockAudioRecorder", "pendingStop called");     // Catch: Exception -> L5
    L7:
        this.n = r4;
        this.m = true;
        return;
    L5:
        e = move-exception;
        n1.c("MockAudioRecorder", "pendingStop failed", e);
        goto L7
    }

    @Override // r58.c
    public final void h(v58.a r2) {
        Intrinsics.checkNotNullParameter(r2, "audioRecordConfig");
        n1.a("MockAudioRecorder", "config");
    }

    @Override // r58.c
    public final void k(Function2<? super r58.d, ? super byte[], Unit> r11) {
        Intrinsics.checkNotNullParameter(r11, "onAudioDataReceived");
        int r0 = this.c;
        byte[] r1 = new byte[r0];
        n1.a("MockAudioRecorder", "startLoop started with buffer size: " + r0);
    L4:
        if (ThreadMethodProxy.currentThread().isInterrupted() == true) goto L26;
        if (this.k.get() == true) goto L26;
        byte[] r2 = new byte[256];     // Catch: Exception -> L24
        Pair r6 = o(r1, r0, r2);     // Catch: Exception -> L24
        int r7 = ((Number) r6.component1()).intValue();     // Catch: Exception -> L24
        int r8 = ((Number) r6.component2()).intValue();     // Catch: Exception -> L24
        if (r0 == 0) goto L10;
        if (r7 == 0) goto L12;
        if (r7 > 0) goto L14;
        if (this.h != null) goto L21;
        if (this.g.isEmpty() == false) goto L21;
        Thread.sleep(10);     // Catch: Exception -> L24
    L21:
        if (this.f != null) goto L4;
        n1.e("MockAudioRecorder", "File path set but stream is null, waiting for file to be opened...");     // Catch: Exception -> L24
        Thread.sleep(100);     // Catch: Exception -> L24
        goto L4
    L14:
        r11.invoke(new r58.d(r7, Arrays.copyOf(r1, r7)), Arrays.copyOf(r2, r8));     // Catch: Exception -> L24
        goto L4
    L12:
        Thread.sleep(10);     // Catch: Exception -> L24
        goto L4
    L10:
        n1.e("MockAudioRecorder", "Buffer size is 0, continuing...");     // Catch: Exception -> L24
        Thread.sleep(10);     // Catch: Exception -> L24
    L24:
        e = move-exception;
        FLogger.a.i("MockAudioRecorder", "mockAudioRecorder: " + e);
        Thread.sleep(10);
    L26:
        n1.a("MockAudioRecorder", "startLoop ended");
    }

    public final void n(AudioRecordState r3) {
        Intrinsics.checkNotNullParameter(r3, "state");
        n1.a("MockAudioRecorder", "#onStateChange state:" + r3);
        this.d = r3;
    }

    @Override // r58.c
    public final int i(byte[] r7, int r8) {
        Intrinsics.checkNotNullParameter(r7, "buffer");
        if (this.l == false) goto L7;
        this.l = false;
        Function0<Unit> r2 = this.a;
        if (r2 == null) goto L7;
        r2.invoke();
    L7:
        final Ref.IntRef r3 = new Ref.IntRef();
        BufferedInputStream r5 = this.f;     // Catch: Exception -> L39
        if (r5 == null) goto L30;
        int r6 = r5.read(r7, 0, r8);     // Catch: Exception -> L39
        r3.element = r6;     // Catch: Exception -> L39
        if (r6 != (-1)) goto L41;
        n1.a("MockAudioRecorder", "Reached end of current file: " + this.h);     // Catch: Exception -> L39
        m();     // Catch: Exception -> L39
        this.h = null;     // Catch: Exception -> L39
        if (p() == false) goto L20;
        BufferedInputStream r1 = this.f;     // Catch: Exception -> L39
        if (r1 == null) goto L19;
        int r9 = r1.read(r7, 0, r8);     // Catch: Exception -> L39
        r3.element = r9;     // Catch: Exception -> L39
        if (r9 != (-1)) goto L41;
        n1.a("MockAudioRecorder", "New file also ended immediately");     // Catch: Exception -> L39
        r3.element = 0;     // Catch: Exception -> L39
        goto L41
    L19:
        n1.e("MockAudioRecorder", "Failed to switch to new file");     // Catch: Exception -> L39
        r3.element = 0;     // Catch: Exception -> L39
        goto L41
    L20:
        n1.a("MockAudioRecorder", "No more files in queue");     // Catch: Exception -> L39
        if (this.b.q() != 2) goto L23;
        boolean r10 = true;
    L24:
        if (r10 == false) goto L28;
        IDoraAutoTestPlatform r11 = (IDoraAutoTestPlatform) ServiceManager.get().getService(IDoraAutoTestPlatform.class);     // Catch: Exception -> L39
        if (r11 == null) goto L28;
        new JSONObject().put("scene", "queryEnd");     // Catch: Exception -> L39
        r11.a();     // Catch: Exception -> L39
    L28:
        r3.element = -1;     // Catch: Exception -> L39
        goto L41
    L23:
        r10 = false;
    L41:
        int r12 = r3.element;
        if (r12 == this.c) goto L46;
        if (r12 == (-1)) goto L46;
        if (r12 == 0) goto L46;
        n1.b("MockAudioRecorder", "read: " + r3.element + ", pendingStop:" + this.m + ", currentFile: " + this.h + ", queueSize: " + this.g.size());
    L49:
        if (r3.element != (-1)) goto L57;
        if (this.m == false) goto L57;
        this.m = false;
        Function0<Unit> r13 = this.n;
        if (r13 == null) goto L55;
        r13.invoke();
    L55:
        stop();
    L57:
        return r3.element;
    L46:
        if (r12 <= 0) goto L49;
        this.j.a(new o1(r3, this));
        goto L49
    L30:
        if (p() == false) goto L37;
        BufferedInputStream r4 = this.f;     // Catch: Exception -> L39
        if (r4 == null) goto L36;
        int r14 = r4.read(r7, 0, r8);     // Catch: Exception -> L39
        r3.element = r14;     // Catch: Exception -> L39
        if (r14 != (-1)) goto L41;
        n1.a("MockAudioRecorder", "New file from queue ended immediately");     // Catch: Exception -> L39
        r3.element = -1;     // Catch: Exception -> L39
        goto L41
    L36:
        n1.e("MockAudioRecorder", "Failed to open file from queue");     // Catch: Exception -> L39
        r3.element = 0;     // Catch: Exception -> L39
        goto L41
    L37:
        r3.element = 0;     // Catch: Exception -> L39
    L39:
        e = move-exception;
        n1.c("MockAudioRecorder", "read failed: " + r3.element, e);
        r3.element = -1;
        goto L41
    }

    public final Pair o(byte[] r7, int r8, byte[] r9) {
        Intrinsics.checkNotNullParameter(r7, "buffer");
        int r10 = i(r7, r8);
        int r11 = 0;
        if (r10 <= 0) goto L21;
    L16:
        th = move-exception;
        Throwable th = th;
        int r3 = 0;
    L18:
        n1.a("MockAudioRecorder", "vad read " + com.larus.utils.u0.a(th));
    L19:
        r11 = r3;
        goto L21
    L5:
        if (((LinkedBlockingQueue) this.i).size() <= 0) goto L21;
        byte[] r2 = (byte[]) ((LinkedBlockingQueue) this.i).poll(0, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L16
        if (r2 == null) goto L10;
        r3 = r2.length;     // Catch: Throwable -> L16
    L11:
        if (r3 <= 0) goto L19;
        System.arraycopy(r2, 0, r9, 0, r2.length);     // Catch: Throwable -> L14
        n1.a("MockAudioRecorder", "vad read: " + r2.length);     // Catch: Throwable -> L14
    L14:
        th = th;
        goto L18
    L10:
        r3 = 0;
    L21:
        return new Pair(Integer.valueOf(r10), Integer.valueOf(r11));
    }
}
