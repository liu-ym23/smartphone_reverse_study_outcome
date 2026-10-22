package com.bytedance.android.livesdk.interactivity.asr;

import android.os.Handler;
import android.os.Message;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.monitor.LiveMonitor;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.interactivity.api.asr.UserActionType;
import com.bytedance.android.livesdk.interactivity.api.asr.utils.AnchorAsrUtils;
import com.bytedance.android.livesdk.interactivity.api.monitor.InteractivityMonitor;
import com.bytedance.android.livesdk.interactivity.asr.widget.AnchorAsrHintWidget;
import com.bytedance.android.livesdk.live.extension.plugin.api.livepusher.ILiveWrappedLivePusher;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.utils.z5;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.speech.speechengine.SpeechEngine;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.disposables.Disposable;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import u52.i;
import u52.j;
import u52.k;
import uf2.d0;
import uf2.h0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class AnchorAsrManager implements l22.c, Handler.Callback, h0.a.a {
    public final Lazy A;
    public final ms1.a B;
    public boolean a;
    public d0 b;
    public h0.a c;
    public j d;
    public u52.b e;
    public final com.bytedance.android.livesdk.interactivity.asr.d f;
    public int g;
    public l22.h h;
    public long i;
    public Disposable j;
    public final Map<String, l22.f> k;
    public final Queue<l22.f> l;
    public int m;
    public boolean n;
    public com.bytedance.android.livesdk.interactivity.asr.e o;
    public boolean p;
    public boolean q;
    public final int r;
    public int s;
    public int t;
    public long u;
    public volatile boolean v;
    public volatile z5 w;
    public volatile Handler x;
    public final CopyOnWriteArrayList<l22.b> y;
    public final Lazy z;

    public static final class a {
        public final String a;
        public final String b;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof a) == false) goto L10;
            a r4 = (a) r3;
            if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r4.b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            String r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            String r4 = this.b;
            if (r4 == null) goto L10;
            r1 = r4.hashCode();
        L10:
            return r3 + r1;
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "AsrResult(reqId=" + this.a + ", result=" + this.b + ")";
        }

        public a(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "reqId");
            Intrinsics.checkNotNullParameter(r3, "result");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class b {
        public final byte[] a;
        public final int b;
        public final long c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L4;
            return true;
        L4:
            if ((r5 instanceof b) == false) goto L12;
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L8;
            return false;
        L8:
            if (this.b == r6.b) goto L10;
            return false;
        L10:
            if (this.c == r6.c) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public final int hashCode() {
            byte[] r0 = this.a;
            if (r0 == null) goto L5;
            int r1 = Arrays.hashCode(r0);
        L6:
            int r2 = ((r1 * 31) + this.b) * 31;
            long r3 = this.c;
            return r2 + ((int) (r3 ^ (r3 >>> 32)));
        L5:
            r1 = 0;
            goto L6
        }

        public final String toString() {
            return "AudioData(data=" + Arrays.toString(this.a) + ", length=" + this.b + ", timestamp=" + this.c + ")";
        }

        public b(byte[] r2, int r3, long r4) {
            Intrinsics.checkNotNullParameter(r2, "data");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public static final class c {
    }

    public static final class d {
        public final String a;
        public final long b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L4;
            return true;
        L4:
            if ((r5 instanceof d) == false) goto L10;
            d r6 = (d) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L8;
            return false;
        L8:
            if (this.b == r6.b) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            String r0 = this.a;
            if (r0 == null) goto L5;
            int r1 = r0.hashCode();
        L6:
            long r2 = this.b;
            return (r1 * 31) + ((int) (r2 ^ (r2 >>> 32)));
        L5:
            r1 = 0;
            goto L6
        }

        public final String toString() {
            return "KwsResult(keyword=" + this.a + ", traceback=" + this.b + ")";
        }

        public d(String r2, long r3) {
            Intrinsics.checkNotNullParameter(r2, "keyword");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class e implements Runnable {
        public final /* synthetic */ l22.b a;
        public final /* synthetic */ Function1 b;

        public e(l22.b r1, Function1 r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.b.invoke(this.a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class f implements Runnable {
        public final /* synthetic */ l22.f a;

        public f(l22.f r1) {
            this.a = r1;
        }

        public final void a() {
            int r0 = com.bytedance.android.livesdk.interactivity.api.asr.utils.b.a;
            String r1 = this.a.i;
            Intrinsics.checkNotNullParameter(r1, "triggerType");
            HashMap r2 = new HashMap();
            r2.put("room_id", com.bytedance.android.livesdk.interactivity.api.asr.utils.b.a());
            r2.put("trigger_type", r1);
            u.l().sendLog("livesdk_anchor_voice_recognition_trigger", r2, new Object[0]);
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class g implements Runnable {
        public final /* synthetic */ l22.f a;

        public g(l22.f r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            int r0 = com.bytedance.android.livesdk.interactivity.api.asr.utils.b.a;     // Catch: Throwable -> L4
            com.bytedance.android.livesdk.interactivity.api.asr.utils.b.b(this.a.i);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class h implements z5.a {
        public final /* synthetic */ AnchorAsrManager a;

        public final void onQuit() {
            AnchorAsrManager r0 = this.a;
            r0.getClass();
            com.bytedance.android.livesdk.interactivity.api.asr.utils.c.c("AnchorAsrWorker quit");
            r0.f.a();
            j r1 = r0.d;
            if (r1 != null) goto L5;
        L7:
            r0.d = null;
            u52.b r4 = r0.e;
            if (r4 == null) goto L26;
            File r5 = u52.d.c(r4.m.a);
            if (r5 == null) goto L26;
        L24:
            e = move-exception;
            SafetyGuard.a("AnchorAsr delete anchor_asr_audio dir failed", e, null);
            goto L26
        L13:
            if (r5.exists() == true) goto L16;
            r5 = null;
        L16:
            if (r5 == null) goto L18;
            Boolean r6 = Boolean.valueOf(FilesKt.deleteRecursively(r5));     // Catch: Exception -> L24
        L20:
            if ((!Intrinsics.areEqual(r6, Boolean.FALSE)) == false) goto L22;
            r4.e("delete anchor_asr_audio success");     // Catch: Exception -> L24
            goto L26
        L22:
            r4.f("delete anchor_asr_audio failed");     // Catch: Exception -> L24
            goto L26
        L18:
            r6 = null;
        L26:
            u52.b r7 = r0.e;
            if (r7 != null) goto L29;
        L31:
            r0.e = null;
            Disposable r2 = r0.j;
            if (r2 == null) goto L34;
            r2.dispose();
        L34:
            r0.j = null;
            r0.h = null;
            r0.i = -1;
            r0.g = 0;
            ((HashMap) r0.k).clear();
            ((LinkedList) r0.l).clear();
            r0.m = 0;
            r0.n = false;
            r0.o = null;
            return;
        L29:
            if (r7.d == false) goto L31;
            r7.e(BuildConfig.BUILD_TYPE);
            r7.d = false;
            r7.c.destroyEngine();
            r7.a.set(0);
            goto L31
        L5:
            if (r1.d == false) goto L7;
            r1.e(BuildConfig.BUILD_TYPE);
            r1.d = false;
            r1.c.destroyEngine();
            r1.a.set(0);
            goto L7
        }

        public h(AnchorAsrManager r1) {
            this.a = r1;
        }

        public final void a(z5 r4) {
            Intrinsics.checkNotNullParameter(r4, "thread");
            final AnchorAsrManager r0 = this.a;
            if (r0.B.m() == true) goto L5;
        L7:
            r0.x = new Handler(r4.getLooper(), r0);
            if (r0.c != null) goto L14;
            ILiveWrappedLivePusher.Companion.getClass();
            ILiveWrappedLivePusher r5 = ILiveWrappedLivePusher.a.b();
            if (r5 == null) goto L12;
            h0.a r6 = r5.newAudioFrameAvailableListener(r0);
        L13:
            r0.c = r6;
            goto L14
        L12:
            r6 = null;
        L14:
            d0 r7 = r0.b;
            if (r7 == null) goto L17;
            r7.F();
        L17:
            r0.j = com.bytedance.android.livesdk.interactivity.api.asr.utils.e.c(false, new AnchorAsrManager$handleWorkerThreadStart$1(r0));
            return;
        L5:
            if (r0.B.n() <= 0) goto L7;
            r0.o = new com.bytedance.android.livesdk.interactivity.asr.e(r0.B.n());
            goto L7
        }
    }

    static {
    }

    @Override // l22.c
    public final void release() {
        if (this.a == true) goto L5;
        return;
    L5:
        com.bytedance.android.livesdk.interactivity.api.asr.utils.c.c("AnchorAsrManager release");
        this.a = false;
        d0 r1 = this.b;
        if (r1 == null) goto L8;
        r1.q();
    L8:
        this.b = null;
        z5 r2 = this.w;
        if (r2 == null) goto L11;
        r2.quit();
    L11:
        this.w = null;
        this.x = null;
        this.v = false;
    }

    public AnchorAsrManager(ms1.a r3) {
        Intrinsics.checkNotNullParameter(r3, "config");
        this.B = r3;
        this.f = new com.bytedance.android.livesdk.interactivity.asr.d(r3.g());
        this.i = -1;
        this.k = new HashMap();
        this.l = new LinkedList();
        int r4 = r3.f();
        this.m = r4;
        if (r4 <= 0) goto L5;
        boolean r5 = true;
    L6:
        this.n = r5;
        this.r = 2;
        this.y = new CopyOnWriteArrayList();
        this.z = LazyKt.lazy(new AnchorAsrManager$kwsListener$2(this));
        this.A = LazyKt.lazy(new AnchorAsrManager$asrListener$2(this));
        return;
    L5:
        r5 = false;
        goto L6
    }

    @Override // l22.c
    public final void a(d0 r4) {
        if (r4 != null) goto L6;
        com.bytedance.android.livesdk.interactivity.api.asr.utils.c.a("LiveCore is null");
        return;
    L6:
        if (this.a == false) goto L8;
        return;
    L8:
        com.bytedance.android.livesdk.interactivity.api.asr.utils.c.c("AnchorAsrManager init");
        this.a = true;
        this.b = r4;
        this.w = new z5("AnchorAsrWorker", -2, new h(this));
        z5 r5 = this.w;
        if (r5 == null) goto L12;
        ThreadMethodProxy.start(r5);
        return;
    }

    @Override // l22.c
    public final void b(l22.h r3) {
        Intrinsics.checkNotNullParameter(r3, "userAction");
        if (this.v == false) goto L8;
        Handler r0 = this.x;
        if (r0 == null) goto L9;
        r0.sendMessage(r0.obtainMessage(1, r3));
        return;
    L9:
        return;
    }

    @Override // l22.c
    public final void c(l22.b r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.y.remove(r2);
    }

    @Override // l22.c
    public final void d(AnchorAsrHintWidget r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.y.add(r2);
    }

    public final void e(Function1<? super l22.b, Unit> r4) {
        Iterator<l22.b> r0 = this.y.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        MainThreadPostUtils.b(new e(r0.next(), r4));
        goto L4
    }

    public final void f(final a r10) {
        final l22.f r0 = (l22.f) ((HashMap) this.k).get(r10.a);
        if (r0 == null) goto L38;
        String r1 = r10.b;
        Intrinsics.checkNotNullParameter(r1, "result");
        int r2 = r0.a;
        if (r2 == 1) goto L9;
        if (r2 == 3) goto L9;
    L19:
        boolean r3 = false;
    L20:
        if (r3 == true) goto L22;
        return;
    L22:
        if (this.p == false) goto L24;
        e(new AnchorAsrManager$handleAsrPartialResult$1(r10));
        return;
    L24:
        final String r4 = r10.b;
        if (StringsKt.contains$default(r4, r0.i, false, 2, null) == false) goto L31;
        if (r0.h != 0) goto L29;
        r0.h = System.currentTimeMillis() - r0.d;
    L29:
        com.bytedance.android.livesdk.interactivity.api.asr.utils.c.c("check keyword success. cost=" + r0.h);
        this.p = true;
        e(new AnchorAsrManager$handleAsrPartialResult$2(r10, r0));
        e(new AnchorAsrManager$handleAsrPartialResult$3(r10, r4));
        return;
    L31:
        if (r4.length() >= this.m) goto L33;
        return;
    L33:
        if (r0.h != 0) goto L35;
        r0.h = System.currentTimeMillis() - r0.d;
    L35:
        com.bytedance.android.livesdk.interactivity.api.asr.utils.c.a("check keyword failed. cost=" + r0.h + " keyword=" + r0.i + " asrResult=" + r4);
        this.q = true;
        u52.b r11 = this.e;
        if (r11 == null) goto L44;
        r11.i();
        return;
    L44:
        return;
    L9:
        if (r0.e != null) goto L17;
        if (r1.length() <= 0) goto L13;
        boolean r5 = true;
    L14:
        if (r5 == false) goto L17;
        r0.e = Long.valueOf(System.currentTimeMillis() - r0.d);
        goto L17
    L13:
        r5 = false;
    L17:
        if (r1.length() < r0.i.length()) goto L19;
        r0.c = r1;
        r3 = true;
        goto L20
    L38:
        com.bytedance.android.livesdk.interactivity.api.asr.utils.c.a("handleAsrPartialResult info is null");
    }

    public final void g(final String r14) {
        com.bytedance.android.livesdk.interactivity.api.asr.utils.c.c("handleAsrStart reqId=" + r14 + " needCheckKwsResult=" + this.n);
        final l22.f r0 = (l22.f) ((LinkedList) this.l).poll();
        if (r0 != null) goto L5;
        return;
    L5:
        ((HashMap) this.k).put(r14, r0);
        r0.b = r14;
        u52.b r1 = this.e;
        if (r1 == null) goto L9;
        r1.i = true;
    L9:
        if (r0.a != 0) goto L11;
        r0.a = 1;
    L11:
        this.q = false;
        if (this.n == false) goto L14;
        this.p = false;
    L15:
        l22.e r15 = AnchorAsrUtils.b();
        if (r15 == null) goto L33;
        long r3 = r0.d;
        List<String> r16 = r15.a(r3 - 5000, r3);
        if (r16 == null) goto L33;
        u52.b r4 = this.e;
        if (r4 == null) goto L33;
        Intrinsics.checkNotNullParameter(r16, "words");
        if (r4.d == false) goto L33;
        if ((!r16.isEmpty()) == false) goto L33;
        List<String> r17 = r16;
        ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r17, 10));
        Iterator<T> r18 = r17.iterator();
    L28:
        if (r18.hasNext() == false) goto L30;
        r5.add(new v52.a((String) r18.next()));
        goto L28
    L30:
        int r19 = r4.c.sendDirective(1610, GsonProtectorUtils.toJson(GsonHelper.get(), new v52.b(r5)));
        if (r19 == 0) goto L33;
        r4.f("set hot words failed. ret=" + r19);
    L33:
        long r6 = System.currentTimeMillis();
        com.bytedance.android.livesdk.interactivity.asr.d r110 = this.f;
        long r7 = r0.j;
        r110.getClass();
        if (r7 > 0) goto L85;
        Queue r111 = new LinkedList();
    L46:
        int r8 = r111.size();
        if (r8 > 0) goto L49;
        com.bytedance.android.livesdk.interactivity.api.asr.utils.c.a("no audio data");
    L83:
        MainThreadPostUtils.b(new f(r0));
        return;
    L49:
        if (this.B.i() == false) goto L74;
        com.bytedance.android.livesdk.interactivity.asr.d r9 = this.f;
        r9.getClass();
        Intrinsics.checkNotNullParameter(r111, "audioData");
        if (r111.isEmpty() == false) goto L87;
        Pair r112 = TuplesKt.to(new byte[0], 0);
    L70:
        byte[] r2 = (byte[]) r112.component1();
        int r113 = ((Number) r112.component2()).intValue();
        u52.b r10 = this.e;
        if (r10 == null) goto L73;
        r10.b(r2, Integer.valueOf(r113));
    L73:
        int r114 = 1;
    L81:
        long r11 = System.currentTimeMillis() - r6;
        this.u += r11;
        this.t++;
        this.s += r114;
        com.bytedance.android.livesdk.interactivity.api.asr.utils.c.c("audioArrCnt=" + r8 + " feedTimes=" + r114 + ". cost=" + r11 + " asrStartCnt=" + this.t + " avgDuration=" + (this.u / ((long) this.t)) + " avgFeedCnt=" + (this.s / this.t));
        goto L83
    L87:
        Iterator r13 = r111.iterator();     // Catch: Exception -> L68
        int r115 = 0;
    L55:
        if (r13.hasNext() == false) goto L57;
        r115 = r115 + ((byte[]) r13.next()).length;     // Catch: Exception -> L68
        goto L55
    L57:
        byte[] r20 = r9.c;     // Catch: Exception -> L68
        if (r20 != null) goto L60;
    L61:
        r20 = new byte[RangesKt.coerceAtLeast(r9.d, r115)];     // Catch: Exception -> L68
        r9.c = r20;     // Catch: Exception -> L68
    L62:
        Iterator r116 = r111.iterator();     // Catch: Exception -> L68
        int r21 = 0;
    L64:
        if (r116.hasNext() == false) goto L66;
        byte[] r117 = (byte[]) r116.next();     // Catch: Exception -> L68
        System.arraycopy(r117, 0, r20, r21, r117.length);     // Catch: Exception -> L68
        r21 = r21 + r117.length;     // Catch: Exception -> L68
        goto L64
    L66:
        r112 = TuplesKt.to(r20, Integer.valueOf(r115));     // Catch: Exception -> L68
        goto L70
    L60:
        if (r20.length >= r115) goto L62;
    L68:
        e = move-exception;
        SafetyGuard.a("AudioDataCollector getAudioDataV2 error", e, null);
        r112 = TuplesKt.to(new byte[0], 0);
        goto L70
    L74:
        Iterator r23 = r111.iterator();
    L76:
        if (r23.hasNext() == false) goto L80;
        byte[] r24 = (byte[]) r23.next();
        u52.b r25 = this.e;
        if (r25 == null) goto L76;
        int r26 = u52.d.g;
        r25.b(r24, null);
        goto L76
    L80:
        r114 = r111.size();
        goto L81
    L85:
    L44:
        e = move-exception;
        com.bytedance.android.livesdk.interactivity.api.asr.utils.c.b("getMergedData error", e);
        r111 = new LinkedList();
        goto L46
    L37:
        if ((!r110.a.isEmpty()) == false) goto L42;
        Long r27 = (Long) CollectionsKt.last(r110.b);     // Catch: Exception -> L44
    L40:
        if ((r27.longValue() - ((Number) CollectionsKt.first(r110.b)).longValue()) <= r7) goto L42;
        ((LinkedList) r110.a).poll();     // Catch: Exception -> L44
        ((LinkedList) r110.b).poll();     // Catch: Exception -> L44
    L42:
        r111 = r110.a;     // Catch: Exception -> L44
        goto L46
    L14:
        this.p = true;
        e(new AnchorAsrManager$handleAsrStart$1(r14, r0));
        goto L15
    }

    public final void h(final String r17) {
        u52.b r2 = this.e;
        if (r2 == null) goto L5;
        r2.i = false;
    L5:
        final l22.f r3 = (l22.f) ((HashMap) this.k).remove(r17);
        if (r3 == null) goto L55;
        com.bytedance.android.livesdk.interactivity.api.asr.utils.c.c("handleAsrStop reqId=" + r17 + ". curState=" + r3.b());
        if (this.q == false) goto L10;
        int r4 = com.bytedance.android.livesdk.interactivity.api.asr.utils.d.a;
    L10:
        int r5 = r3.a;
        long r6 = 0;
        String r8 = null;
        boolean r9 = true;
        if (r5 == 1) goto L28;
        if (r5 != 3) goto L14;
        u52.b r1 = this.e;
        if (r1 == null) goto L25;
        PolarisFileWrapper r7 = r1.k();
        if (r7 == null) goto L25;
        r8 = r7.getPath();
    L25:
        r3.a(r8);
        if (this.p == false) goto L46;
        e(new AnchorAsrManager$handleAsrStop$3(r3));
    L46:
        if (r9 == false) goto L57;
        int r10 = com.bytedance.android.livesdk.interactivity.api.asr.utils.b.a;
        String r11 = r3.b;
        String r13 = r3.c;
        String r14 = r3.i;
        long r15 = r3.j;
        long r16 = r3.f;
        Long r18 = r3.e;
        if (r18 == null) goto L50;
        r6 = r18.longValue();
    L50:
        long r19 = r3.h;
        Intrinsics.checkNotNullParameter(r13, "result");
        Intrinsics.checkNotNullParameter(r14, "keyword");
        if (r11 == null) goto L57;
        HashMap r110 = new HashMap();
        r110.put("room_id", com.bytedance.android.livesdk.interactivity.api.asr.utils.b.a());
        r110.put("req_id", r11);
        r110.put("keyword", r14);
        r110.put("traceback", String.valueOf(r15));
        r110.put("result", r13);
        r110.put("duration", String.valueOf(r16));
        r110.put("asr_first_result_delay", String.valueOf(r6));
        r110.put("check_keyword_duration", String.valueOf(r19));
        u.l().sendLog("livesdk_anchor_asr_duration", r110, new Object[0]);
    L57:
        return;
    L14:
        if (r5 == 4) goto L18;
        com.bytedance.android.livesdk.interactivity.api.asr.utils.c.a("handleAsrStop unknown error. reqId=".concat(r17));
        return;
    L18:
        if (this.p == false) goto L46;
        e(new AnchorAsrManager$handleAsrStop$4(r3));
        goto L46
    L28:
        if (r5 != 1) goto L31;
        r3.a = 2;
        r3.f = (System.currentTimeMillis() - r3.d) + r3.j;
    L31:
        if (this.p == false) goto L33;
        e(new AnchorAsrManager$handleAsrStop$1(r17));
    L33:
        String r20 = r3.b;
        String r21 = r3.c;
        int r111 = w52.a.a;
        Intrinsics.checkNotNullParameter(r21, "result");
        RoomContext r23 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r23 == null) goto L38;
        m r24 = r23.getRoom();
        if (r24 == null) goto L38;
        Room r25 = (Room) r24.getValue();
    L39:
        LiveMonitor.a r26 = InteractivityMonitor.a(InteractivityMonitor.Event.AnchorAsrInterrupted, r25, null);
        if (r20 != null) goto L42;
        r20 = BuildConfig.FLAVOR;
    L42:
        r26.i("reqId", r20);
        r26.i("result", r21);
        r26.a().report();
        MainThreadPostUtils.b(new g(r3));
        if ((r3.f - r3.j) >= 500) goto L46;
        r9 = false;
    L38:
        r25 = null;
        goto L39
    L55:
        ((LinkedList) this.l).poll();
        com.bytedance.android.livesdk.interactivity.api.asr.utils.c.a("handleAsrStop info is null. reqId=".concat(r17));
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message r35) {
        AnchorAsrManager r1 = this;
        Intrinsics.checkNotNullParameter(r35, "msg");
        int r2 = r35.what;
        if (r2 != 1) goto L5;
        Object r0 = r35.obj;
        if ((r0 instanceof l22.h) == true) goto L323;
        Object r7 = null;
    L324:
        l22.h r8 = (l22.h) r7;
        if (r8 == null) goto L358;
        int r3 = com.bytedance.android.livesdk.interactivity.api.asr.utils.d.a;
        com.bytedance.android.livesdk.interactivity.asr.e r4 = r1.o;
        if (r4 == null) goto L329;
        Intrinsics.checkNotNullParameter(r8, "userAction");
        r4.a.add(r8);
    L329:
        r1.g = RangesKt.coerceAtMost(r1.g + 2, 10);
        r1.h = r8;
        j r5 = r1.d;
        if (r5 != null) goto L332;
    L334:
        boolean r6 = false;
    L335:
        if (r6 == false) goto L337;
        r1.i = r8.b + 5000;
    L337:
        com.bytedance.android.livesdk.interactivity.api.asr.utils.c.c("handleUserAction type=" + r8.getType() + " availCnt=" + r1.g + " kwsStarted=" + r6);
        return true;
    L332:
        if (r5.d() != true) goto L334;
        r6 = true;
        goto L335
    L358:
        return true;
    L323:
        r7 = r0;
        goto L324
    L5:
        if (r2 != 2) goto L7;
        l22.h r14 = r1.h;
        j r13 = r1.d;
        if (r13 == null) goto L268;
        String r23 = "channel";
        if (r13.d() != true) goto L269;
    L267:
        String r19 = "custom_sample_rate";
        String r28 = "custom_channel";
    L275:
        boolean r9 = false;
    L276:
        if (r9 == false) goto L353;
        j r10 = r1.d;
        if (r10 != null) goto L313;
        k r11 = new k(r1.r);
        if (v.a() == false) goto L282;
        r11.a = "anchor_kws_debug";
    L282:
        r11.b = r1.B.k();
        j r15 = new j(r11);
        if (r15.d == false) goto L285;
        boolean r16 = true;
        j r17 = null;
    L310:
        if (r16 == false) goto L312;
        r15.e = (u52.h) r1.z.getValue();
        r1.d = r15;
        j r18 = r15;
    L314:
        if (r18 != null) goto L316;
        return true;
    L316:
        if (r18.h() == false) goto L355;
        l22.h r20 = r1.h;
        if (r20 == null) goto L356;
        r1.i = r20.b + 5000;
        return true;
    L356:
        return true;
    L355:
        return true;
    L312:
        r18 = r17;
        goto L314
    L285:
        long r110 = System.currentTimeMillis();
        SpeechEngine r21 = r15.c;     // Catch: Exception -> L307
        r15.e("start create " + r15.f);     // Catch: Exception -> L307
        r15.c.setContext(jc1.a.b());     // Catch: Exception -> L307
        r21.createEngine();     // Catch: Exception -> L307
        r15.e("create " + r15.f + " done");     // Catch: Exception -> L307
        r21.setOptionString("engine_name", "kws");     // Catch: Exception -> L307
        String r24 = r15.h.b;     // Catch: Exception -> L307
        if (r24 != null) goto L289;
    L292:
        boolean r111 = true;
    L294:
        if ((!r111) == true) goto L297;
        r24 = null;
    L297:
        if (r24 != null) goto L299;
        r24 = "{\"array_type\": 0,\"radius\":0.0,\"total_channels\":1,\"mic_offset\":0,\"mic_num\":1,\"ref_offset\":0,\"ref_num\":0}";
    L299:
        r21.setOptionString("kws_user_param", r24);     // Catch: Exception -> L307
        PolarisFileWrapper r25 = u52.d.c(r15.h.a);     // Catch: Exception -> L307
        if (r25 == null) goto L302;
        r15.h.getClass();     // Catch: Exception -> L307
        r21.setOptionString("log_level", "TRACE");     // Catch: Exception -> L307
        r21.setOptionString("debug_path", r25.getPath());     // Catch: Exception -> L307
    L302:
        r21.setOptionString("recorder_data_source_type", "Stream");     // Catch: Exception -> L307
        r21.setOptionBoolean("enable_resampler", true);     // Catch: Exception -> L307
        r21.setOptionInt(r28, r15.h.c);     // Catch: Exception -> L307
        r15.h.getClass();     // Catch: Exception -> L307
        r21.setOptionInt(r19, 0);     // Catch: Exception -> L307
        r21.setOptionInt(r23, 1);     // Catch: Exception -> L307
        r21.setOptionInt("sample_rate", 16000);     // Catch: Exception -> L307
        r15.e("start init " + r15.f);     // Catch: Exception -> L307
        int r26 = r15.c.initEngine();     // Catch: Exception -> L307
        long r27 = System.currentTimeMillis() - r110;     // Catch: Exception -> L307
        r15.h.getClass();     // Catch: Exception -> L307
        r15.e("init engine cost " + r27 + " ms. sampleRate=0");     // Catch: Exception -> L307
        if (r26 != 0) goto L305;
        r15.d = true;     // Catch: Exception -> L307
        r15.a.set(1);     // Catch: Exception -> L307
        r15.c.setListener(new i(r15));     // Catch: Exception -> L307
        w52.a.b(r15.f, r27);     // Catch: Exception -> L307
    L306:
        r17 = null;
    L309:
        r16 = r15.d;
        goto L310
    L305:
        r15.f("init engine failed. code=" + r26);     // Catch: Exception -> L307
        w52.a.a(r15.f, r26, r27);     // Catch: Exception -> L307
        goto L306
    L289:
        if (r24.length() == 0) goto L292;
        r111 = false;
    L307:
        e = move-exception;
        r17 = null;
        SafetyGuard.a("AnchorAsr create " + r15.f + " error", e, null);
        goto L309
    L313:
        r18 = r10;
        goto L314
    L353:
        return true;
    L269:
        if (r14 == null) goto L267;
        if (r1.g <= 0) goto L267;
        r19 = "custom_sample_rate";
        r28 = "custom_channel";
        if ((System.currentTimeMillis() - r14.b) >= 5000) goto L275;
        r9 = true;
        goto L276
    L268:
        r23 = "channel";
        goto L269
    L7:
        if (r2 != 3) goto L9;
        Object r29 = r35.obj;
        if ((r29 instanceof b) == true) goto L234;
        Object r30 = null;
    L235:
        b r31 = (b) r30;
        if (r31 == null) goto L352;
        byte[] r33 = r31.a;
        int r34 = r31.b;
        long r36 = r31.c;
        j r37 = r1.d;
        if (r37 != null) goto L240;
    L254:
        u52.b r38 = r1.e;
        if (r38 == null) goto L352;
        if (r38.a() != true) goto L352;
        u52.b r39 = r1.e;
        if (r39 == null) goto L352;
        r39.b(r33, Integer.valueOf(r34));
        goto L352
    L240:
        if (r37.d() != true) goto L254;
        com.bytedance.android.livesdk.interactivity.asr.d r40 = r1.f;
        r40.getClass();
        Intrinsics.checkNotNullParameter(r33, "data");
        ((LinkedList) r40.a).add(r33);     // Catch: Exception -> L249
        ((LinkedList) r40.b).add(Long.valueOf(r36));     // Catch: Exception -> L249
    L244:
        if ((!r40.a.isEmpty()) == false) goto L251;
        if ((((Number) CollectionsKt.last(r40.b)).longValue() - ((Number) ((LinkedList) r40.b).peek()).longValue()) < 3000) goto L251;
        ((LinkedList) r40.a).poll();     // Catch: Exception -> L249
        ((LinkedList) r40.b).poll();     // Catch: Exception -> L249
    L251:
        j r41 = r1.d;
        if (r41 == null) goto L254;
        r41.b(r33, Integer.valueOf(r34));
    L249:
        e = move-exception;
        com.bytedance.android.livesdk.interactivity.api.asr.utils.c.b("addAudioData failed", e);
    L352:
        return true;
    L234:
        r30 = r29;
        goto L235
    L9:
        if (r2 == 4) goto L213;
        switch(r2) {
            case 10: goto L150;
            case 11: goto L28;
            case 12: goto L20;
            case 13: goto L13;
            default: goto L11;
        };
    L11:
        switch(r2) {
            case 20: goto L206;
            case 21: goto L199;
            case 22: goto L178;
            case 23: goto L171;
            case 24: goto L164;
            case 25: goto L157;
            default: goto L352;
        };
    L157:
        Object r43 = r35.obj;
        if ((r43 instanceof String) == true) goto L160;
        Object r44 = null;
    L161:
        String r45 = (String) r44;
        if (r45 == null) goto L352;
        r1.h(r45);
        goto L352
    L160:
        r44 = r43;
        goto L161
    L164:
        Object r46 = r35.obj;
        if ((r46 instanceof String) == true) goto L167;
        Object r47 = null;
    L168:
        String r48 = (String) r47;
        if (r48 == null) goto L352;
        r1.j(r48);
        goto L352
    L167:
        r47 = r46;
        goto L168
    L171:
        Object r49 = r35.obj;
        if ((r49 instanceof String) == true) goto L174;
        Object r50 = null;
    L175:
        String r51 = (String) r50;
        if (r51 == null) goto L352;
        r1.i(r51);
        goto L352
    L174:
        r50 = r49;
        goto L175
    L178:
        Object r53 = r35.obj;
        if ((r53 instanceof a) == true) goto L181;
        r53 = null;
    L181:
        final a r54 = (a) r53;
        if (r54 == null) goto L352;
        int r55 = com.bytedance.android.livesdk.interactivity.api.asr.utils.d.a;
        l22.f r56 = (l22.f) ((HashMap) r1.k).get(r54.a);
        if (r56 == null) goto L198;
        u52.b r57 = r1.e;
        if (r57 == null) goto L190;
        PolarisFileWrapper r58 = r57.k();
        if (r58 == null) goto L190;
        String r59 = r58.getPath();
    L192:
        if (r56.a(r59) == false) goto L197;
        String r60 = r54.b;
        Intrinsics.checkNotNullParameter(r60, "<set-?>");
        r56.c = r60;
        if (r1.p == false) goto L196;
        r1.e(new AnchorAsrManager$handleAsrCompleteResult$1(r54));
    L196:
        com.bytedance.android.livesdk.interactivity.api.asr.utils.c.c("handleAsrCompleteResult: get final result " + r56);
        goto L352
    L197:
        com.bytedance.android.livesdk.interactivity.api.asr.utils.c.a("handleAsrCompleteResult: complete failed. state=".concat(r56.b()));
    L190:
        r59 = null;
        goto L192
    L198:
        com.bytedance.android.livesdk.interactivity.api.asr.utils.c.a("handleAsrCompleteResult info is null");
        goto L352
    L199:
        Object r61 = r35.obj;
        if ((r61 instanceof a) == true) goto L202;
        Object r63 = null;
    L203:
        a r64 = (a) r63;
        if (r64 == null) goto L352;
        r1.f(r64);
        goto L352
    L202:
        r63 = r61;
        goto L203
    L206:
        Object r65 = r35.obj;
        if ((r65 instanceof String) == true) goto L209;
        Object r66 = null;
    L210:
        String r67 = (String) r66;
        if (r67 == null) goto L352;
        r1.g(r67);
        goto L352
    L209:
        r66 = r65;
        goto L210
    L13:
        Object r68 = r35.obj;
        if ((r68 instanceof String) == true) goto L16;
        Object r69 = null;
    L17:
        String r70 = (String) r69;
        if (r70 == null) goto L352;
        com.bytedance.android.livesdk.interactivity.api.asr.utils.c.c("handleKwsStop reqId=".concat(r70));
        goto L352
    L16:
        r69 = r68;
        goto L17
    L20:
        long r71 = r1.i - System.currentTimeMillis();
        if (r71 > 0) goto L25;
        com.bytedance.android.livesdk.interactivity.api.asr.utils.c.c("kws timeout");
        r1.i = -1;
        j r73 = r1.d;
        if (r73 == null) goto L352;
        r73.i();
        goto L352
    L25:
        com.bytedance.android.livesdk.interactivity.api.asr.utils.c.c("kws timeout in " + r71 + " ms");
        Handler r74 = r1.x;
        if (r74 == null) goto L352;
        r74.sendEmptyMessageDelayed(12, r71);
        goto L352
    L28:
        Object r75 = r35.obj;
        if ((r75 instanceof d) == true) goto L31;
        r75 = null;
    L31:
        d r76 = (d) r75;
        if (r76 == null) goto L352;
        String r77 = r76.a;
        long r112 = r76.b;
        int r78 = com.bytedance.android.livesdk.interactivity.api.asr.utils.d.a;
        com.bytedance.android.livesdk.interactivity.api.asr.utils.c.c("handleKeywordDetected. keyword=" + r77 + " traceback=" + r112);
        if (r1.g > 0) goto L39;
        com.bytedance.android.livesdk.interactivity.api.asr.utils.c.a("no available count. stop kws");
        j r79 = r1.d;
        if (r79 == null) goto L352;
        r79.i();
        goto L352
    L39:
        if (r112 <= 3000) goto L41;
        com.bytedance.android.livesdk.interactivity.api.asr.utils.c.a("invalid traceback " + r112);
        goto L352
    L41:
        u52.b r80 = r1.e;
        if (r80 != null) goto L105;
        u52.c r81 = new u52.c(r1.r);
        r81.a = "anchor_asr_audio";
        if (v.a() == false) goto L46;
        r81.b = "anchor_asr_debug";
    L46:
        String r113 = r1.B.b();
        long r210 = r112;
        String r114 = r1.B.c();
        String r115 = r1.B.h();
        if (r113 != null) goto L49;
    L52:
        boolean r116 = true;
    L53:
        if (r116 == false) goto L56;
        com.bytedance.android.livesdk.interactivity.api.asr.utils.c.a("invalid appId");
    L55:
        String r310 = r77;
    L104:
        r80 = null;
    L106:
        if (r80 == null) goto L352;
        if (r80.d() == false) goto L111;
        int r83 = com.bytedance.android.livesdk.interactivity.api.asr.utils.d.a;
        com.bytedance.android.livesdk.interactivity.api.asr.utils.c.c("discard keyword");
        goto L352
    L111:
        com.bytedance.android.livesdk.interactivity.asr.e r84 = r1.o;
        if (r84 == null) goto L146;
        String r85 = r310;
        Intrinsics.checkNotNullParameter(r85, "keyword");
        switch(r85.hashCode()) {
            case 742984: goto L129;
            case 787151: goto L126;
            case 806627: goto L123;
            case 887020: goto L120;
            case 1147968: goto L117;
            default: goto L143;
        };
    L143:
        boolean r86 = false;
    L144:
        if (r86 == true) goto L148;
        int r87 = com.bytedance.android.livesdk.interactivity.api.asr.utils.d.a;
        com.bytedance.android.livesdk.interactivity.api.asr.utils.c.a("KeywordChecker check keyword " + r85 + " failed");
    L148:
        if (r80.h() == false) goto L352;
        r1.g--;
        ((LinkedList) r1.l).add(new l22.f(r85, r210));
        goto L352
    L117:
        if (r85.equals("谢谢") == false) goto L143;
    L130:
        UserActionType r88 = UserActionType.Thanks;
    L131:
        Iterator<l22.h> r89 = r84.a.iterator();
    L133:
        if (r89.hasNext() == false) goto L140;
        l22.h r90 = r89.next();
        if (r90.getType() != r88) goto L137;
        boolean r91 = true;
    L138:
        if (r91 == false) goto L133;
        l22.h r93 = r90;
    L141:
        if (r93 == null) goto L143;
        r86 = true;
        goto L144
    L137:
        r91 = false;
        goto L138
    L140:
        r93 = null;
        goto L141
    L120:
        if (r85.equals("欢迎") == false) goto L143;
        r88 = UserActionType.Welcome;
        goto L131
    L123:
        if (r85.equals("感谢") == false) goto L143;
    L126:
        if (r85.equals("恭喜") == false) goto L143;
        r88 = UserActionType.Congrats;
        goto L131
    L129:
        if (r85.equals("多谢") == false) goto L143;
    L146:
        r85 = r310;
        goto L148
    L56:
        if (r114 != null) goto L58;
    L61:
        boolean r117 = true;
    L62:
        if (r117 == false) goto L64;
        com.bytedance.android.livesdk.interactivity.api.asr.utils.c.a("invalid appToken");
        goto L55
    L64:
        if (r115 != null) goto L66;
    L69:
        boolean r118 = true;
    L70:
        if (r118 == false) goto L72;
        com.bytedance.android.livesdk.interactivity.api.asr.utils.c.a("invalid cluster");
        goto L55
    L72:
        r310 = r77;
        u52.b r94 = new u52.b(r113, r114, r115, r81);
        if (r94.d == false) goto L75;
        boolean r95 = true;
    L101:
        r1 = this;
        if (r95 == false) goto L104;
        u52.f r96 = (u52.f) r1.A.getValue();
        Intrinsics.checkNotNullParameter(r96, "listener");
        r94.e = r96;
        r1.e = r94;
        r80 = r94;
        goto L106
    L75:
        long r119 = System.currentTimeMillis();
        SpeechEngine r120 = r94.c;     // Catch: Exception -> L98
        r94.e("start create " + r94.f);     // Catch: Exception -> L98
        r94.c.setContext(jc1.a.b());     // Catch: Exception -> L98
        r120.createEngine();     // Catch: Exception -> L98
        r94.e("create " + r94.f + " done");     // Catch: Exception -> L98
        r120.setOptionString("engine_name", "asr");     // Catch: Exception -> L98
        r120.setOptionString("appid", r94.j);     // Catch: Exception -> L98
        r120.setOptionString("token", "Bearer;" + r94.k);     // Catch: Exception -> L98
        r120.setOptionString("asr_address", "wss://speech.bytedance.com");     // Catch: Exception -> L98
        r120.setOptionString("asr_uri", "/api/v2/asr");     // Catch: Exception -> L98
        r120.setOptionString("asr_cluster", r94.l);     // Catch: Exception -> L98
        r120.setOptionString("uid", jc1.k.n(IUserService.class).user().n());     // Catch: Exception -> L98
        String r97 = TTLiveSDK.hostService().appContext().getServerDeviceId();     // Catch: Exception -> L98
        if (r97 != null) goto L79;
    L87:
        r120.setOptionBoolean("asr_auto_stop", true);     // Catch: Exception -> L98
        r120.setOptionBoolean("asr_enable_itn", true);     // Catch: Exception -> L98
        PolarisFileWrapper r98 = u52.d.c(r94.m.b);     // Catch: Exception -> L98
        if (r98 == null) goto L90;
        r94.m.getClass();     // Catch: Exception -> L98
        r120.setOptionString("log_level", "TRACE");     // Catch: Exception -> L98
        r120.setOptionString("debug_path", r98.getPath());     // Catch: Exception -> L98
    L90:
        PolarisFileWrapper r99 = u52.d.c(r94.m.a);     // Catch: Exception -> L98
        if (r99 == null) goto L93;
        r120.setOptionInt("rec_file_type", 1);     // Catch: Exception -> L98
        r120.setOptionString("rec_path", r99.getPath());     // Catch: Exception -> L98
        r99.deleteOnExit();     // Catch: Exception -> L98
    L93:
        r120.setOptionString("recorder_data_source_type", "Stream");     // Catch: Exception -> L98
        r120.setOptionBoolean("enable_resampler", true);     // Catch: Exception -> L98
        r120.setOptionInt("custom_channel", r94.m.c);     // Catch: Exception -> L98
        r94.m.getClass();     // Catch: Exception -> L98
        r120.setOptionInt("custom_sample_rate", 0);     // Catch: Exception -> L98
        r120.setOptionInt("channel", 1);     // Catch: Exception -> L98
        r120.setOptionInt("sample_rate", 16000);     // Catch: Exception -> L98
        r94.e("start init " + r94.f);     // Catch: Exception -> L98
        int r100 = r94.c.initEngine();     // Catch: Exception -> L98
        long r101 = System.currentTimeMillis() - r119;     // Catch: Exception -> L98
        r94.m.getClass();     // Catch: Exception -> L98
        r94.e("init engine cost " + r101 + " ms. sampleRate=0");     // Catch: Exception -> L98
        if (r100 != 0) goto L96;
        r94.d = true;     // Catch: Exception -> L98
        r94.a.set(1);     // Catch: Exception -> L98
        r94.c.setListener(new u52.a(r94));     // Catch: Exception -> L98
        w52.a.b(r94.f, r101);     // Catch: Exception -> L98
    L100:
        r95 = r94.d;
        goto L101
    L96:
        r94.f("init engine failed. code=" + r100);     // Catch: Exception -> L98
        w52.a.a(r94.f, r100, r101);     // Catch: Exception -> L98
        goto L100
    L79:
        if (r97.length() <= 0) goto L81;
        boolean r102 = true;
    L82:
        if (r102 == true) goto L85;
        r97 = null;
    L85:
        if (r97 == null) goto L87;
        r120.setOptionString("device_id", r97);     // Catch: Exception -> L98
        goto L87
    L81:
        r102 = false;
    L98:
        e = move-exception;
        SafetyGuard.a("AnchorAsr create " + r94.f + " error", e, null);
        goto L100
    L66:
        if (r115.length() == 0) goto L69;
        r118 = false;
        goto L70
    L58:
        if (r114.length() == 0) goto L61;
        r117 = false;
        goto L62
    L49:
        if (r113.length() == 0) goto L52;
        r116 = false;
        goto L53
    L105:
        r310 = r77;
        r210 = r112;
        goto L106
    L150:
        Object r103 = r35.obj;
        if ((r103 instanceof String) == true) goto L153;
        Object r104 = null;
    L154:
        String r105 = (String) r104;
        if (r105 == null) goto L352;
        com.bytedance.android.livesdk.interactivity.api.asr.utils.c.c("handleKwsStart. reqId=".concat(r105));
        goto L352
    L153:
        r104 = r103;
        goto L154
    L213:
        Object r106 = r35.obj;
        if ((r106 instanceof m22.b) == true) goto L216;
        r106 = null;
    L216:
        m22.b r107 = (m22.b) r106;
        if (r107 == null) goto L352;
        com.bytedance.android.livesdk.interactivity.api.asr.utils.c.c("onAsrSwitchChange. " + r107);
        r1.v = r107.a;
        if (r1.v == true) goto L352;
        j r108 = r1.d;
        if (r108 == null) goto L223;
        r108.i();
    L223:
        u52.b r109 = r1.e;
        if (r109 != null) goto L226;
    L230:
        r1.h = null;
        r1.f.a();
        goto L352
    L226:
        if (r109.d() != true) goto L230;
        u52.b r121 = r1.e;
        if (r121 == null) goto L230;
        r121.i();
        goto L230
    }

    public final void i(String r3) {
        l22.f r4 = (l22.f) ((HashMap) this.k).get(r3);
        if (r4 != null) goto L6;
        return;
    L6:
        if (r4.c.length() <= r4.i.length()) goto L8;
        boolean r0 = true;
    L9:
        if (r0 == true) goto L15;
        int r1 = com.bytedance.android.livesdk.interactivity.api.asr.utils.d.a;
        u52.b r2 = this.e;
        if (r2 == null) goto L13;
        r2.i();
    L13:
        com.bytedance.android.livesdk.interactivity.api.asr.utils.c.a("asr timeout1. info is " + r4);
        return;
    L15:
        return;
    L8:
        r0 = false;
        goto L9
    }

    public final void j(String r6) {
        int r0 = com.bytedance.android.livesdk.interactivity.api.asr.utils.d.a;
        l22.f r7 = (l22.f) ((HashMap) this.k).get(r6);
        if (r7 != null) goto L6;
        return;
    L6:
        if (r7.a != 1) goto L8;
        r7.a = 3;
    L8:
        u52.b r1 = this.e;
        if (r1 != null) goto L11;
    L16:
        com.bytedance.android.livesdk.interactivity.api.asr.utils.c.c("asr timeout2. info is " + r7);
        return;
    L11:
        if (r1.d() == false) goto L16;
        int r2 = r1.c.sendDirective(1100, BuildConfig.FLAVOR);
        if (r2 != 0) goto L15;
        r1.a.compareAndSet(3, 4);
        goto L16
    L15:
        r1.f("finish talking failed. ret=" + r2);
        goto L16
    }
}
