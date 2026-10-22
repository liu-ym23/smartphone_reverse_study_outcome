package com.bytedance.ai.applet.render.core.camera;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.Preview;
import androidx.camera.core.UseCase;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.video.Quality;
import androidx.camera.video.QualitySelector;
import androidx.camera.video.Recorder;
import androidx.camera.video.Recording;
import androidx.camera.video.VideoCapture;
import androidx.camera.view.PreviewView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;
import com.byted.cast.sink.api.CastInfo;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyMap;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class u {
    public static int A;
    public static final Object B = null;
    public static volatile u z;
    public final Map<String, x> a;
    public final List<String> b;
    public ProcessCameraProvider c;
    public ImageCapture d;
    public VideoCapture<Recorder> e;
    public Recording f;
    public String g;
    public File h;
    public String i;
    public Callback j;
    public boolean k;
    public boolean l;
    public Callback m;
    public boolean n;
    public int o;
    public String p;
    public String q;
    public boolean r;
    public long s;
    public String t;
    public String u;
    public Callback v;
    public boolean w;
    public final ExecutorService x;
    public final Handler y;

    public static final class a {
        public a() {
        }

        public static final void a(u r10) {
            u r0 = u.z;
            Object r1 = u.B;
            monitor-enter(r1);
        L12:
            th = move-exception;
            throw th;
        L5:
            if (Intrinsics.areEqual(u.z, r10) == true) goto L7;
        L9:
            Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L12
            monitor-exit(r1);
            return;
        L7:
            if (u.A != 0) goto L9;
            u.z = null;     // Catch: Throwable -> L12
            goto L9
        }
    }

    public static final class b {
        public final File a;
        public final String b;
        public final long c;

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof b) == true) goto L8;
            return false;
        L8:
            b r11 = (b) r10;
            if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r11.b) == true) goto L15;
            return false;
        L15:
            if (this.c == r11.c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
            long r1 = this.c;
            return r0 + ((int) (r1 ^ (r1 >>> 32)));
        }

        public final String toString() {
            return "RecordingFileInfo(file=" + this.a + ", virtualPath=" + this.b + ", availableBytes=" + this.c + ')';
        }

        public b(PolarisFileWrapper r10, String r11, long r12) {
            Intrinsics.checkNotNullParameter(r10, "file");
            Intrinsics.checkNotNullParameter(r11, "virtualPath");
            this.a = r10;
            this.b = r11;
            this.c = r12;
        }
    }

    static {
        new a();
        B = new Object();
    }

    public final void g() {
        int r0 = this.o;
        if (r0 <= 0) goto L6;
        this.o = r0 - 1;
    L6:
        if (this.w == true) goto L8;
        return;
    L8:
        if (this.a.isEmpty() == false) goto L12;
        e();
        return;
    }

    public final void j() {
        Set r0 = ((LinkedHashMap) this.a).keySet();
        ArrayList r1 = new ArrayList();
        Iterator r10 = r0.iterator();
    L4:
        if (r10.hasNext() == false) goto L13;
        Object r11 = r10.next();
        x r12 = (x) ((LinkedHashMap) this.a).get((String) r11);
        boolean r13 = false;
        if (r12 == null) goto L11;
        if (r12.a() != true) goto L11;
        r13 = true;
    L11:
        if ((!r13) == false) goto L4;
        r1.add(r11);
        goto L4
    L13:
        Iterator r14 = r1.iterator();
    L15:
        if (r14.hasNext() == false) goto L17;
        String r15 = (String) r14.next();
        this.a.remove(r15);
        ((ArrayList) this.b).remove(r15);
        goto L15
    }

    public u() {
        this.a = new LinkedHashMap();
        this.b = new ArrayList();
        this.q = "front";
        this.x = PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("CameraSessionManager"));
        this.y = new Handler(Looper.getMainLooper());
    }

    public final void c() {
        j();
        String r0 = this.t;
        if (r0 == null) goto L11;
        String r1 = this.u;
        if (r1 != null) goto L7;
        r1 = "front";
    L7:
        Callback r10 = this.v;
        x r11 = (x) ((LinkedHashMap) this.a).get(r0);
        this.t = null;
        this.u = null;
        this.v = null;
        if (r11 == null) goto L11;
        k(r0, r1, r11.c, r10);
    L11:
        if (this.w == false) goto L13;
    L16:
        e();
        return;
    L13:
        if (this.a.isEmpty() == true) goto L16;
        l();
    }

    public final void e() {
        j();
        if ((!this.a.isEmpty()) == true) goto L37;
        Object r0 = B;
        monitor-enter(r0);
    L34:
        th = move-exception;
        throw th;
    L7:
        if (Intrinsics.areEqual(z, this) == false) goto L11;
        if (A <= 0) goto L11;
        boolean r10 = true;
    L12:
        monitor-exit(r0);
        if (r10 == true) goto L37;
        if (this.f == null) goto L18;
    L32:
        this.w = true;
        return;
    L18:
        if (this.k == true) goto L32;
        if (this.n == true) goto L32;
        if (this.o > 0) goto L32;
        this.s++;
        this.w = false;
        this.r = false;
        Callback r1 = this.v;
        if (r1 == null) goto L27;
        r1.invoke(new Object[]{1, f(119, "Camera manager was destroyed")});
    L27:
        this.t = null;
        this.u = null;
        this.v = null;
        ProcessCameraProvider r11 = this.c;
        if (r11 == null) goto L30;
        r11.unbindAll();
    L30:
        this.d = null;
        this.e = null;
        this.c = null;
        this.p = null;
        ((ArrayList) this.b).clear();
        this.x.shutdown();
        a.a(this);
        return;
    L11:
        r10 = false;
    L37:
        this.w = false;
    }

    public final void l() {
        j();
        String r0 = this.p;
        if (r0 == null) goto L5;
        x r1 = (x) ((LinkedHashMap) this.a).get(r0);
    L6:
        if (r1 != null) goto L8;
    L12:
        this.s++;
        String r10 = this.p;
        if (r10 == null) goto L21;
        x r11 = (x) ((LinkedHashMap) this.a).get(r10);
        if (r11 == null) goto L21;
        WeakReference<com.bytedance.ai.applet.render.core.camera.b> r12 = r11.a;
        if (r12 == null) goto L21;
        com.bytedance.ai.applet.render.core.camera.b r13 = r12.get();
        if (r13 == null) goto L21;
        r13.m("Camera page is not in the foreground");
    L21:
        this.p = null;
        this.r = false;
        ProcessCameraProvider r14 = this.c;
        if (r14 == null) goto L24;
        r14.unbindAll();
    L24:
        Iterator r15 = CollectionsKt.reversed(this.b).iterator();
    L26:
        if (r15.hasNext() == false) goto L48;
        String r16 = (String) r15.next();
        x r17 = (x) ((LinkedHashMap) this.a).get(r16);
        if (r17 == null) goto L26;
        if (r17.e == false) goto L26;
        if (r17.d == false) goto L26;
        if (r17.a() == false) goto L26;
        k(r16, r17.b, r17.c, null);
        return;
    L48:
        return;
    L8:
        if (r1.e == false) goto L12;
        if (r1.a() == false) goto L12;
        return;
    L5:
        r1 = null;
        goto L6
    }

    public static void d(File r10) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Object r1 = Result.constructor-impl(Boolean.valueOf(r10.delete()));     // Catch: Throwable -> L4
    L7:
        if (Result.exceptionOrNull-impl(r1) == null) goto L12;
        r10.getName();
        return;
    L12:
        return;
    L4:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public final void b(String r10) {
        if (this.k == true) goto L5;
        return;
    L5:
        if (this.l == true) goto L20;
        this.l = true;
        Callback r1 = this.m;
        Unit r11 = null;
        this.m = null;
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L13
        if (r1 == null) goto L11;
        r1.invoke(new Object[]{1, f(119, r10)});     // Catch: Throwable -> L13
        r11 = Unit.INSTANCE;     // Catch: Throwable -> L13
    L11:
        Object r13 = Result.constructor-impl(r11);     // Catch: Throwable -> L13
    L15:
        Result.exceptionOrNull-impl(r13);
        return;
    L13:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    }

    public static JavaOnlyMap f(int r10, String r11) {
        JavaOnlyMap r0 = new JavaOnlyMap();
        r0.put("errCode", Integer.valueOf(r10));
        r0.put("errMessage", r11);
        return r0;
    }

    public final boolean h(String r10, com.bytedance.ai.applet.render.core.camera.b r11, long r12) {
        x r0 = (x) ((LinkedHashMap) this.a).get(r10);
        if (r0 != null) goto L6;
        return false;
    L6:
        if (r12 == this.s) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.p, r10) == true) goto L10;
        return false;
    L10:
        if (r0.d == true) goto L12;
        return false;
    L12:
        if (r0.e == true) goto L14;
        return false;
    L14:
        if (r0.a.get() != r11) goto L21;
        return true;
    L21:
        return false;
    }

    public final void m(final String r11, final Context r12, Callback r13) {
        Intrinsics.checkNotNullParameter(r11, "identifier");
        Intrinsics.checkNotNullParameter(r12, "context");
        if (Intrinsics.areEqual(this.p, r11) == true) goto L5;
    L53:
        if (r13 == null) goto L60;
        r13.invoke(new Object[]{1, f(119, "Camera does not have focus")});
        return;
    L60:
        return;
    L5:
        if (this.r == false) goto L53;
        if (this.f == null) goto L10;
    L50:
        if (r13 == null) goto L59;
        r13.invoke(new Object[]{1, f(118, "Recording already in progress")});
        return;
    L59:
        return;
    L10:
        if (this.k == true) goto L50;
        if (this.n == true) goto L50;
        if (ContextCompat.checkSelfPermission(r12, "android.permission.RECORD_AUDIO") != 0) goto L17;
        boolean r0 = true;
    L18:
        if (r0 == true) goto L22;
        if (r13 == null) goto L56;
        r13.invoke(new Object[]{1, f(CastInfo.TYPE_DISCONNECT, "Microphone permission was denied")});
        return;
    L56:
        return;
    L22:
        final VideoCapture<Recorder> r10 = this.e;
        if (r10 != null) goto L27;
        if (r13 == null) goto L57;
        r13.invoke(new Object[]{1, f(102, "Camera not initialized")});
        return;
    L57:
        return;
    L27:
        x r14 = (x) ((LinkedHashMap) this.a).get(r11);
        final Function1<File, String> r15 = null;
        if (r14 == null) goto L32;
        WeakReference<com.bytedance.ai.applet.render.core.camera.b> r16 = r14.a;
        if (r16 == null) goto L32;
        com.bytedance.ai.applet.render.core.camera.b r17 = r16.get();
    L33:
        if (r17 == null) goto L35;
        File r18 = r17.G();
    L36:
        if (r17 == null) goto L38;
        Function0<Long> r19 = r17.L();
    L39:
        if (r17 == null) goto L41;
        r15 = r17.F();
    L41:
        if (r18 == null) goto L47;
        if (r19 == null) goto L47;
        if (r15 == null) goto L47;
        this.k = true;
        this.l = false;
        this.m = r13;
        this.g = r11;
        final Function0<Long> r20 = r19;
        final File r21 = r18;
        this.x.execute(new l(this, r20, r21, r15, r11, r12, r10));
        return;
    L47:
        if (r13 == null) goto L58;
        r13.invoke(new Object[]{1, f(102, "Temp file provider not initialized")});
        return;
    L58:
        return;
    L38:
        r19 = null;
        goto L39
    L35:
        r18 = null;
    L32:
        r17 = null;
        goto L33
    L17:
        r0 = false;
        goto L18
    }

    public final void a(final String r15, final com.bytedance.ai.applet.render.core.camera.b r16, final String r17, final int r18) {
        final Context r1 = r16.u();
        if (r1 != null) goto L6;
        r16.s(102, "No context available");
        return;
    L6:
        final LifecycleOwner r10 = r16.w();
        if (r10 != null) goto L10;
        r16.s(102, "No LifecycleOwner found");
        return;
    L10:
        final PreviewView r11 = r16.A();
        if (r11 != null) goto L14;
        r16.s(102, "No PreviewView available");
        return;
    L14:
        this.s++;
        final long r12 = this.s;
        this.r = false;
        if (this.c == null) goto L17;
        i(r15, r12, r10, r11, r17, r18, r16);
        return;
    L17:
        this.x.execute(new m(r1, this, r15, r16, r12, r10, r11, r17, r18));
    }

    public final void k(String r10, String r11, int r12, Callback r13) {
        x r0 = (x) ((LinkedHashMap) this.a).get(r10);
        if (r0 == null) goto L48;
        if (r0.e == false) goto L48;
        if (r0.a() == false) goto L48;
        Intrinsics.checkNotNullParameter(r11, "<set-?>");
        r0.b = r11;
        r0.c = r12;
        boolean r14 = !Intrinsics.areEqual(this.p, r10);
        boolean r15 = !Intrinsics.areEqual(this.q, r11);
        if (r14 == true) goto L13;
        if (r15 == true) goto L13;
    L17:
        String r16 = this.p;
        if (r14 == false) goto L27;
        if (r16 == null) goto L27;
        x r17 = (x) ((LinkedHashMap) this.a).get(r16);
        if (r17 == null) goto L27;
        WeakReference<com.bytedance.ai.applet.render.core.camera.b> r18 = r17.a;
        if (r18 == null) goto L27;
        com.bytedance.ai.applet.render.core.camera.b r19 = r18.get();
        if (r19 == null) goto L27;
        r19.m("Camera focus was taken by another instance");
    L27:
        this.p = r10;
        this.q = r11;
        ((ArrayList) this.b).remove(r10);
        ((ArrayList) this.b).add(r10);
        com.bytedance.ai.applet.render.core.camera.b r1 = r0.a.get();
        if (r1 == null) goto L30;
        a(r10, r1, r11, r12);
    L30:
        if (r13 == null) goto L51;
        r13.invoke(new Object[]{0});
        return;
    L51:
        return;
    L13:
        if (this.f == null) goto L15;
    L33:
        if (r14 == true) goto L37;
        if (r13 == null) goto L52;
        r13.invoke(new Object[]{1, f(119, "Cannot switch camera while recording is starting or in progress")});
        return;
    L52:
        return;
    L37:
        Callback r110 = this.v;
        if (r110 == null) goto L40;
        r110.invoke(new Object[]{1, f(119, "Camera focus request was superseded")});
    L40:
        this.t = r10;
        this.u = r11;
        this.v = r13;
        if (this.k == false) goto L43;
        b("Camera focus changed before recording could start");
        return;
    L43:
        Recording r20 = this.f;
        if (r20 == null) goto L54;
        r20.stop();
        return;
    L54:
        return;
    L15:
        if (this.k == false) goto L17;
    L48:
        if (r13 == null) goto L55;
        r13.invoke(new Object[]{1, f(119, "Camera page is not in the foreground")});
        return;
    }

    public final void i(String r10, long r11, LifecycleOwner r12, PreviewView r13, String r14, int r15, com.bytedance.ai.applet.render.core.camera.b r16) {
        if (h(r10, r16, r11) == true) goto L5;
        return;
    L5:
        ProcessCameraProvider r17 = this.c;
        if (r17 != null) goto L8;
        return;
    L8:
        r17.unbindAll();
        CameraSelector r18 = new CameraSelector.Builder().requireLensFacing(!Intrinsics.areEqual(r14, "front") ? 1 : 0).build();
        UseCase r19 = new Preview.Builder().build();
        r19.setSurfaceProvider(r13.getSurfaceProvider());
        UseCase r20 = new ImageCapture.Builder().setCaptureMode(1).setTargetRotation(r15).build();
        this.d = r20;
        UseCase r21 = VideoCapture.withOutput(new Recorder.Builder().setQualitySelector(QualitySelector.from(Quality.HD)).build());
        this.e = r21;
        r17.bindToLifecycle(r12, r18, new UseCase[]{r19, r20, r21});     // Catch: Exception -> L11
        this.r = true;     // Catch: Exception -> L11
        r16.onSessionReady();     // Catch: Exception -> L11
        return;
    L11:
        e = move-exception;
        e.getMessage();
        this.r = false;
        r16.s(102, "Failed to bind camera: " + e.getMessage());
    }
}
