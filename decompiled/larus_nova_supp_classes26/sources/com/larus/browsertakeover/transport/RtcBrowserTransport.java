package com.larus.browsertakeover.transport;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.larus.browsertakeover.signaling.RtcSessionMetaApi;
import com.larus.im.internal.audio.ability.SessionReleaseReason;
import com.larus.im.internal.jni.bean.RoomMeta;
import com.larus.im.service.audio.AudioSessionType;
import com.larus.im.service.audio.AvAecOutputType;
import com.larus.im.service.audio.AvAudioKitMode;
import com.larus.im.service.audio.c1;
import com.larus.im.service.audio.vlm.EncodedVideoCodecType;
import com.larus.im.service.audio.x0;
import com.larus.im.service.audio.z0;
import com.larus.media.MediaLevel;
import com.larus.media.MediaOccupyStrategy;
import com.larus.media.MediaResourceManager;
import com.larus.utils.logger.FLogger;
import java.util.Arrays;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.CharsKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class RtcBrowserTransport implements BrowserTransport {
    public static final /* synthetic */ int o = 0;
    public RoomMeta a;
    public final String b;
    public final Function2<String, Continuation<? super RoomMeta>, Object> c;
    public final Function1<Failure, Unit> d;
    public final BrowserTransport.EndpointMode e;
    public final BrowserTransport.FrameSource f;
    public final Handler g;
    public final Object h;
    public final String i;
    public long j;
    public boolean k;
    public boolean l;
    public BrowserTransport.a m;
    public b n;

    /* JADX INFO: renamed from: com.larus.browsertakeover.transport.RtcBrowserTransport$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/im/internal/jni/bean/RoomMeta;", "it", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.browsertakeover.transport.RtcBrowserTransport$1", f = "RtcBrowserTransport.kt", i = {}, l = {55}, m = "invokeSuspend", n = {}, s = {})
    final class AnonymousClass1 extends SuspendLambda implements Function2<String, Continuation<? super RoomMeta>, Object> {
        /* synthetic */ Object L$0;
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> r2) {
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            AnonymousClass1 r0 = new AnonymousClass1(r3);
            r0.L$0 = r2;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((String) r1, (Continuation) r2);
        }

        public final Object invoke(String r1, Continuation<? super RoomMeta> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r4);
        L11:
            return r4;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            String r5 = (String) this.L$0;
            RtcSessionMetaApi.Companion r2 = RtcSessionMetaApi.a;
            this.label = 1;
            r4 = r2.a(r5, this);
            if (r4 != r0) goto L11;
            return r0;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/browsertakeover/transport/RtcBrowserTransport$Failure;", "", "<init>", "(Ljava/lang/String;I)V", "INVALID_ROOM_META", "MEDIA_BUSY", "CONNECTION_FAILED", "CONNECTION_TIMEOUT", "INVALID_MESSAGE", "MESSAGE_TOO_LARGE", "TOKEN_RENEWAL_FAILED", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Failure extends Enum<Failure> {
        public static final Failure CONNECTION_FAILED = null;
        public static final Failure CONNECTION_TIMEOUT = null;
        public static final Failure INVALID_MESSAGE = null;
        public static final Failure INVALID_ROOM_META = null;
        public static final Failure MEDIA_BUSY = null;
        public static final Failure MESSAGE_TOO_LARGE = null;
        public static final Failure TOKEN_RENEWAL_FAILED = null;
        public static final /* synthetic */ Failure[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<Failure> getEntries() {
            return b;
        }

        static {
            Failure r0 = new Failure("INVALID_ROOM_META", 0);
            INVALID_ROOM_META = r0;
            Failure r1 = new Failure("MEDIA_BUSY", 1);
            MEDIA_BUSY = r1;
            Failure r3 = new Failure("CONNECTION_FAILED", 2);
            CONNECTION_FAILED = r3;
            Failure r5 = new Failure("CONNECTION_TIMEOUT", 3);
            CONNECTION_TIMEOUT = r5;
            Failure r7 = new Failure("INVALID_MESSAGE", 4);
            INVALID_MESSAGE = r7;
            Failure r9 = new Failure("MESSAGE_TOO_LARGE", 5);
            MESSAGE_TOO_LARGE = r9;
            Failure r11 = new Failure("TOKEN_RENEWAL_FAILED", 6);
            TOKEN_RENEWAL_FAILED = r11;
            Failure[] r13 = {r0, r1, r3, r5, r7, r9, r11};
            a = r13;
            b = EnumEntriesKt.enumEntries(r13);
        }

        public static Failure[] values() {
            return (Failure[]) a.clone();
        }

        public static Failure valueOf(String r1) {
            return (Failure) r27.a.a(Failure.class, r1);
        }

        public Failure(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    public final class b {
        public final com.larus.media.model.a A;
        public final C0069b B;
        public final c C;
        public final long a;
        public final long b;
        public final AtomicLong c;
        public final AtomicLong d;
        public final AtomicLong e;
        public final AtomicLong f;
        public final AtomicLong g;
        public final AtomicLong h;
        public final AtomicLong i;
        public final AtomicLong j;
        public final AtomicLong k;
        public final AtomicLong l;
        public final AtomicLong m;
        public final AtomicLong n;
        public volatile id9.e o;
        public RoomMeta p;
        public boolean q;
        public boolean r;
        public final r s;
        public final CoroutineScope t;
        public final d0 u;
        public final Channel<c> v;
        public final CoroutineScope w;
        public final Channel<d> x;
        public final CompletableDeferred<Unit> y;
        public final t z;

        public static final class a implements com.larus.media.v {
            public final /* synthetic */ RtcBrowserTransport a;
            public final /* synthetic */ b b;

            public final boolean b(lk9.g r2) {
                Intrinsics.checkNotNullParameter(r2, "applicant");
                return false;
            }

            public final void e(lk9.g r4) {
                Intrinsics.checkNotNullParameter(r4, "applicant");
                final RtcBrowserTransport r5 = this.a;
                Handler r0 = r5.g;
                final b r1 = this.b;
                r0.post(new u(r5, r1));
            }

            public final void f(MediaResourceManager.a r2) {
                Intrinsics.checkNotNullParameter(r2, "event");
            }

            public a(RtcBrowserTransport r1, b r2) {
                this.a = r1;
                this.b = r2;
            }

            public final void a(lk9.g r1, float r2) {
                com.larus.media.v.a.f(r1, r2);
            }

            public final void d(lk9.g r1, lk9.g r2) {
                com.larus.media.v.a.c(r1, r2);
            }

            public final void g(lk9.g r1, float r2) {
                com.larus.media.v.a.g(r1, r2);
            }

            public final void i(lk9.g r3, lk9.g r4) {
                Intrinsics.checkNotNullParameter(r3, "current");
                Intrinsics.checkNotNullParameter(r4, "applicant");
                final RtcBrowserTransport r5 = this.a;
                Handler r6 = r5.g;
                final b r0 = this.b;
                r6.post(new v(r5, r0));
            }

            public final MediaOccupyStrategy c(lk9.g r1, lk9.g r2, int r3) {
                return com.larus.media.v.a.a(this, r1, r2, r3);
            }

            public final MediaOccupyStrategy h(lk9.g r1, lk9.g r2, int r3) {
                Intrinsics.checkNotNullParameter(r1, "current");
                Intrinsics.checkNotNullParameter(r2, "applicant");
                return MediaOccupyStrategy.INTERRUPT;
            }
        }

        /* JADX INFO: renamed from: com.larus.browsertakeover.transport.RtcBrowserTransport$b$b, reason: collision with other inner class name */
        public static final class C0069b implements com.larus.im.service.audio.v {
            public final /* synthetic */ RtcBrowserTransport a;
            public final /* synthetic */ b b;

            public final String getName() {
                return "BrowserTakeoverConnection";
            }

            public C0069b(RtcBrowserTransport r1, b r2) {
                this.a = r1;
                this.b = r2;
            }

            public final void O1(final jd9.c r5, final jd9.c r6) {
                Intrinsics.checkNotNullParameter(r5, "oldState");
                Intrinsics.checkNotNullParameter(r6, "newState");
                final RtcBrowserTransport r0 = this.a;
                Handler r1 = r0.g;
                final b r2 = this.b;
                r1.post(new w(r0, r2, r6, r5));
            }
        }

        public static final class c extends z0 {
            public final String a;
            public final /* synthetic */ RtcBrowserTransport b;
            public final /* synthetic */ b c;

            public final void p() {
                final RtcBrowserTransport r0 = this.b;
                final b r1 = this.c;
                Function0<Unit> r2 = new z(r0, r1);
                int r3 = RtcBrowserTransport.o;
                r0.p(r2);
            }

            public final String g() {
                return this.a;
            }

            public final void o(tf9.a r19) {
                Intrinsics.checkNotNullParameter(r19, "frame");
                RtcBrowserTransport r2 = this.b;
                long r3 = this.c.a;
                int r5 = RtcBrowserTransport.o;
                if (r2.l(r3) == true) goto L5;
                return;
            L5:
                long r4 = this.c.k.incrementAndGet();
                this.c.l.addAndGet(r19.a.length);
                boolean r6 = false;
                if (r4 != 1) goto L8;
            L9:
                RtcBrowserTransport r12 = this.b;
                long r13 = this.c.a;
                String r16 = "count=" + r4 + " codec=" + r19.g + " bytes=" + r19.a.length + " rotation=" + r19.f + " sdkWidth=" + r19.d + " sdkHeight=" + r19.e;
                if (r4 == 1) goto L12;
                boolean r17 = true;
            L13:
                r12.n(r13, "rtp_frame_received", r16, r17);
            L15:
                if (r19.g == EncodedVideoCodecType.MJPEG) goto L17;
                String r7 = "unsupported_codec";
            L26:
                if (r7 == null) goto L29;
                RtcBrowserTransport.d(this.b, this.c, r7, r19.a.length);
                return;
            L29:
                byte[] r8 = r19.a;
                Object r9 = this.c.x.trySend-JP2dKIU(new d(Arrays.copyOf(r8, r8.length), r19.f, r19.d, r19.e));
                kotlinx.coroutines.channels.g.c r10 = kotlinx.coroutines.channels.g.b;
                if ((!(r9 instanceof kotlinx.coroutines.channels.g.c)) == true) goto L33;
                RtcBrowserTransport.d(this.b, this.c, "queue_unavailable", r19.a.length);
                return;
            L33:
                return;
            L17:
                byte[] r11 = r19.a;
                if (r11.length != 0) goto L20;
                r6 = true;
            L20:
                if (r6 == false) goto L23;
                r7 = "empty";
                goto L26
            L23:
                if (r11.length <= 6291456) goto L25;
                r7 = "too_large";
                goto L26
            L25:
                r7 = null;
                goto L26
            L12:
                r17 = false;
                goto L13
            L8:
                if ((r4 % 30) != 0) goto L15;
                goto L9
            }

            public c(RtcBrowserTransport r1, b r2) {
                this.b = r1;
                this.c = r2;
                this.a = "BrowserTakeoverData";
            }

            public final void m(byte[] r23, long r24) {
                Intrinsics.checkNotNullParameter(r23, "data");
                RtcBrowserTransport r2 = this.b;
                Object r3 = r2.h;
                b r4 = this.c;
                monitor-enter(r3);
            L69:
                th = move-exception;
                throw th;
            L5:
                if (r2.k == false) goto L7;
            L67:
                monitor-exit(r3);
                return;
            L7:
                if (r2.j != r4.a) goto L67;
                if (r2.n != r4) goto L67;
                long r5 = r4.c.incrementAndGet();     // Catch: Throwable -> L69
                r4.d.addAndGet(r23.length);     // Catch: Throwable -> L69
                monitor-exit(r3);
                if (r5 != 1) goto L16;
            L17:
                RtcBrowserTransport r13 = this.b;
                long r14 = this.c.a;
                String r20 = "count=" + r5 + " bytes=" + r23.length + " totalBytes=" + this.c.d.get() + " messageId=" + r24;
                if (r5 == 1) goto L20;
                boolean r21 = true;
            L21:
                r13.n(r14, "rts_data_received", r20, r21);
            L23:
                if (r23.length <= 1048576) goto L27;
                RtcBrowserTransport.o(this.b, this.c.a, "rts_data_rejected", "reason=too_large bytes=" + r23.length, false, 8);
                final RtcBrowserTransport r0 = this.b;
                Handler r6 = r0.g;
                final b r7 = this.c;
                r6.post(new x(r0, r7));
                return;
            L27:
                if (r23.length != 0) goto L29;
                boolean r8 = true;
            L30:
                if (r8 == false) goto L33;
                RtcBrowserTransport.o(this.b, this.c.a, "rts_data_rejected", "reason=empty", false, 8);
                final RtcBrowserTransport r1 = this.b;
                Handler r9 = r1.g;
                final b r10 = this.c;
                r9.post(new y(r1, r10));
                return;
            L33:
                RtcBrowserTransport r11 = this.b;
                Object r12 = r11.h;
                b r15 = this.c;
                monitor-enter(r12);
            L64:
                th = move-exception;
                throw th;
            L36:
                if (r11.k == false) goto L38;
            L62:
                monitor-exit(r12);
                return;
            L38:
                if (r11.j != r15.a) goto L62;
                if (r11.n != r15) goto L62;
                if (r15.u.b(r23.length) == null) goto L45;
                Pair r16 = null;
            L46:
                monitor-exit(r12);
                if (r16 == null) goto L58;
                long r17 = ((Number) r16.component1()).longValue();
                e0 r18 = (e0) r16.component2();
                if (r17 != 1) goto L51;
            L52:
                RtcBrowserTransport r19 = this.b;
                long r22 = this.c.a;
                String r110 = "reason=queue_pressure count=" + r17 + " bytes=" + r23.length + " queuedPackets=" + r18.a + " queuedBytes=" + r18.b;
                if (r17 == 1) goto L55;
                boolean r111 = true;
            L56:
                r19.n(r22, "rts_data_dropped", r110, r111);
                return;
            L55:
                r111 = false;
                goto L56
            L51:
                if ((r17 % 30) == 0) goto L52;
                return;
            L58:
                long r25 = this.c.a;
                c r26 = new c(Arrays.copyOf(r23, r23.length));
                Object r27 = this.c.v.trySend-JP2dKIU(r26);
                kotlinx.coroutines.channels.g.c r28 = kotlinx.coroutines.channels.g.b;
                if ((!(r27 instanceof kotlinx.coroutines.channels.g.c)) == true) goto L77;
                r26.a(this.c.u);
                this.b.n(this.c.a, "rts_data_dropped", "reason=queue_closed bytes=" + r23.length, true);
                return;
            L77:
                return;
            L45:
                long r29 = r15.e.incrementAndGet();     // Catch: Throwable -> L64
                r15.f.addAndGet(r23.length);     // Catch: Throwable -> L64
                r16 = TuplesKt.to(Long.valueOf(r29), r15.u.a());     // Catch: Throwable -> L64
                goto L46
            L29:
                r8 = false;
                goto L30
            L20:
                r21 = false;
                goto L21
            L16:
                if ((r5 % 30) != 0) goto L23;
                goto L17
            }
        }

        /* JADX WARN: Type inference failed for: r2v15, types: [com.larus.browsertakeover.transport.r] */
        /* JADX WARN: Type inference failed for: r2v18, types: [com.larus.browsertakeover.transport.t] */
        public b(final RtcBrowserTransport r18, long r19) {
            this.a = r19;
            this.b = SystemClock.elapsedRealtime();
            this.c = new AtomicLong();
            this.d = new AtomicLong();
            this.e = new AtomicLong();
            this.f = new AtomicLong();
            this.g = new AtomicLong();
            this.h = new AtomicLong();
            this.i = new AtomicLong();
            this.j = new AtomicLong();
            this.k = new AtomicLong();
            this.l = new AtomicLong();
            this.m = new AtomicLong();
            this.n = new AtomicLong();
            this.p = r18.a;
            this.s = new r(this, r18);
            this.t = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getDefault()));
            this.u = new d0();
            this.v = ChannelKt.Channel$default(Integer.MAX_VALUE, null, new s(this), 2, null);
            this.w = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getDefault()));
            this.x = ChannelKt.Channel$default(-1, null, null, 6, null);
            this.y = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
            this.z = new t(r18, this);
            this.A = new com.larus.media.model.a(null, "BROWSER_TAKEOVER", false, 0, 2, true, 0, true, false, MediaLevel.PLAY_LOW.getValue(), false, new a(r18, this), 1101);
            this.B = new C0069b(r18, this);
            this.C = new c(r18, this);
        }
    }

    public static final class c {
        public final byte[] a;
        public final AtomicBoolean b;

        public c(byte[] r2) {
            Intrinsics.checkNotNullParameter(r2, "bytes");
            this.a = r2;
            this.b = new AtomicBoolean();
        }

        public final void a(d0 r6) {
            Intrinsics.checkNotNullParameter(r6, "budget");
            if (this.b.compareAndSet(false, true) == false) goto L12;
            int r0 = this.a.length;
            monitor-enter(r6);
            r6.a = RangesKt.coerceAtLeast(r6.a - 1, 0);     // Catch: Throwable -> L9
            r6.b = RangesKt.coerceAtLeast(r6.b - ((long) RangesKt.coerceAtLeast(r0, 0)), 0);     // Catch: Throwable -> L9
            monitor-exit(r6);
            return;
        L9:
            th = move-exception;
            throw th;
        }
    }

    public static final class d {
        public final byte[] a;
        public final int b;
        public final int c;
        public final int d;

        public d(byte[] r2, int r3, int r4, int r5) {
            Intrinsics.checkNotNullParameter(r2, "bytes");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    static {
    }

    @Override // com.larus.browsertakeover.transport.BrowserTransport
    public final void disconnect() {
        p(new j(this));
    }

    public final void h() {
        Object r0 = this.h;
        monitor-enter(r0);
        this.j++;     // Catch: Throwable -> L17
        this.l = false;     // Catch: Throwable -> L17
        this.m = null;     // Catch: Throwable -> L17
        b r2 = this.n;     // Catch: Throwable -> L17
        this.n = null;     // Catch: Throwable -> L17
        monitor-exit(r0);
        if (r2 != null) goto L8;
        return;
    L8:
        e0 r1 = r2.u.a();
        o(this, r2.a, "lease_release", "elapsedMs=" + (SystemClock.elapsedRealtime() - r2.b) + " received=" + r2.c.get() + " receivedBytes=" + r2.d.get() + " rtsDispatched=" + r2.h.get() + " rtsFiltered=" + r2.g.get() + " rtsDropped=" + r2.e.get() + " rtsDroppedBytes=" + r2.f.get() + " rtsQueued=" + r1.a + " rtsQueuedBytes=" + r1.b + " rtsMaxQueued=" + r1.c + " rtsMaxQueuedBytes=" + r1.d + " submitted=" + r2.i.get() + " submittedBytes=" + r2.j.get() + " rtpReceived=" + r2.k.get() + " rtpReceivedBytes=" + r2.l.get() + " rtpDelivered=" + r2.m.get() + " rtpRejected=" + r2.n.get(), false, 8);
        this.g.removeCallbacks(r2.z);
        this.g.removeCallbacks(r2.s);
        r2.v.cancel(null);
        CoroutineScopeKt.cancel$default(r2.t, null, 1, null);
        r2.x.cancel(null);
        Job.DefaultImpls.cancel$default(r2.y, null, 1, null);
        CoroutineScopeKt.cancel$default(r2.w, null, 1, null);
        id9.e r3 = r2.o;     // Catch: Throwable -> L14
        if (r3 == null) goto L12;
        r3.b(r2.B);     // Catch: Throwable -> L14
        r3.n(r2.C);     // Catch: Throwable -> L14
        o(this, r2.a, "session_release_requested", null, false, 12);     // Catch: Throwable -> L14
        r3.C(SessionReleaseReason.Normal);     // Catch: Throwable -> L14
    L12:
        r2.o = null;
        Lazy r4 = MediaResourceManager.a;
        MediaResourceManager.a(r2.A);
        o(this, r2.a, "media_focus_released", null, false, 12);
        return;
    L14:
        th = move-exception;
        r2.o = null;
        Lazy r5 = MediaResourceManager.a;
        MediaResourceManager.a(r2.A);
        o(this, r2.a, "media_focus_released", null, false, 12);
        throw th;
    L17:
        th = move-exception;
        throw th;
    }

    @Override // com.larus.browsertakeover.transport.BrowserTransport
    public final void release() {
        p(new n(this));
    }

    @Override // com.larus.browsertakeover.transport.BrowserTransport
    public final BrowserTransport.FrameSource a() {
        return this.f;
    }

    @Override // com.larus.browsertakeover.transport.BrowserTransport
    public final BrowserTransport.EndpointMode c() {
        return this.e;
    }

    @Override // com.larus.browsertakeover.transport.BrowserTransport
    public final void b(final com.larus.browsertakeover.cdp.a r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        p(new m(this, r2));
    }

    public final x0 g(c1 r46) {
        AudioSessionType r2 = AudioSessionType.RTC;
        String r9 = this.b;
        com.larus.im.service.audio.c.Companion.getClass();
        com.larus.im.service.audio.c r0 = new com.larus.im.service.audio.c(1, 24000, 1, 16000, 20, AvAudioKitMode.PURE_BIZ, false, "", "", false, AvAecOutputType.AecMono, "");
        AvAudioKitMode r3 = AvAudioKitMode.PURE_RTC;
        int r4 = r0.a;
        int r5 = r0.b;
        int r6 = r0.c;
        int r7 = r0.d;
        int r8 = r0.e;
        boolean r10 = r0.g;
        String r12 = r0.h;
        String r13 = r0.i;
        boolean r14 = r0.j;
        AvAecOutputType r11 = r0.k;
        String r1 = r0.l;
        Intrinsics.checkNotNullParameter(r3, "audioKitMode");
        Intrinsics.checkNotNullParameter(r12, "speechAecModelPath");
        Intrinsics.checkNotNullParameter(r13, "audioxModelPath");
        Intrinsics.checkNotNullParameter(r11, "speechAecOutputType");
        Intrinsics.checkNotNullParameter(r1, "speechAecDumpPath");
        return new x0("browser_takeover", r2, null, null, null, null, null, null, r9, null, new com.larus.im.service.audio.c(r4, r5, r6, r7, r8, r3, r10, r12, r13, r14, r11, r1), false, MapsKt.emptyMap(), null, r46, null, 106496);
    }

    public final boolean l(long r7) {
        Object r0 = this.h;
        monitor-enter(r0);
        boolean r2 = false;
        if (this.k == false) goto L7;
    L17:
        monitor-exit(r0);
        return r2;
    L7:
        if (this.j != r7) goto L17;
        b r1 = this.n;     // Catch: Throwable -> L19
        if (r1 == null) goto L14;
        if (r1.a != r7) goto L14;
        boolean r8 = true;
    L15:
        if (r8 == false) goto L17;
        r2 = true;
    L14:
        r8 = false;
    L19:
        th = move-exception;
        throw th;
    }

    public final void p(final Function0<Unit> r3) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
        r3.invoke();
        return;
    L5:
        this.g.post(new l(r3));
    }

    @Override // com.larus.browsertakeover.transport.BrowserTransport
    public final boolean send(String r17) {
        Intrinsics.checkNotNullParameter(r17, "message");
        boolean r9 = false;
        if (r17.length() != 0) goto L5;
        boolean r3 = true;
    L6:
        if (r3 == false) goto L17;
        Object r1 = this.h;
        monitor-enter(r1);
        long r2 = this.j;     // Catch: Throwable -> L13
        monitor-exit(r1);
        o(this, r2, "rts_send_rejected", "reason=empty", false, 8);
        return false;
    L13:
        th = move-exception;
        throw th;
    L17:
        c0.a.getClass();
        Intrinsics.checkNotNullParameter(r17, "message");
        byte[] r0 = r17.getBytes(Charsets.UTF_8);
        int r4 = r0.length;
        if (1 <= r4) goto L20;
    L22:
        boolean r5 = false;
    L23:
        id9.e r6 = null;
        if (r5 == true) goto L27;
        r0 = null;
    L27:
        if (r0 != null) goto L38;
        Object r7 = this.h;
        monitor-enter(r7);
        final long r10 = this.j;     // Catch: Throwable -> L34
        monitor-exit(r7);
        o(this, r10, "rts_send_rejected", "reason=too_large", false, 8);
        this.g.post(new k(this, r10));
        return false;
    L34:
        th = move-exception;
        throw th;
    L38:
        Object r11 = this.h;
        monitor-enter(r11);
        b r12 = this.n;     // Catch: Throwable -> L73
        if (this.k == false) goto L43;
    L70:
        o(this, this.j, "rts_send_rejected", "reason=not_connected bytes=" + r0.length, false, 8);     // Catch: Throwable -> L73
    L71:
        monitor-exit(r11);
        return r9;
    L43:
        if (this.l == false) goto L70;
        if (r12 == null) goto L46;
        r6 = r12.o;     // Catch: Throwable -> L73
    L46:
        if (r6 == null) goto L70;
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L61
        id9.e r13 = r12.o;     // Catch: Throwable -> L61
        if (r13 == null) goto L51;
        r13.D(r0);     // Catch: Throwable -> L61
    L51:
        long r14 = r12.i.incrementAndGet();     // Catch: Throwable -> L61
        r12.j.addAndGet(r0.length);     // Catch: Throwable -> L61
        if (r14 != 1) goto L54;
    L55:
        long r15 = r12.a;     // Catch: Throwable -> L61
        String r16 = "count=" + r14 + " bytes=" + r0.length + " totalBytes=" + r12.j.get();     // Catch: Throwable -> L61
        if (r14 == 1) goto L58;
        r9 = true;
    L58:
        n(r15, "rts_send_submitted", r16, r9);     // Catch: Throwable -> L61
    L59:
        Object r18 = Result.constructor-impl(Boolean.TRUE);     // Catch: Throwable -> L61
    L63:
        Throwable r19 = Result.exceptionOrNull-impl(r18);     // Catch: Throwable -> L73
        if (r19 == null) goto L66;
        o(this, r12.a, "rts_send_exception", "type=".concat(r19.getClass().getSimpleName()), false, 8);     // Catch: Throwable -> L73
    L66:
        Boolean r20 = Boolean.FALSE;     // Catch: Throwable -> L73
        if (Result.isFailure-impl(r18) == false) goto L69;
        r18 = r20;
    L69:
        r9 = ((Boolean) r18).booleanValue();     // Catch: Throwable -> L73
        goto L71
    L54:
        if ((r14 % 30) != 0) goto L59;
    L61:
        th = move-exception;
        Result.Companion r21 = Result.Companion;     // Catch: Throwable -> L73
        r18 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L73
    L73:
        th = move-exception;
        throw th;
    L20:
        if (r4 >= 47105) goto L22;
        r5 = true;
        goto L23
    L5:
        r3 = false;
        goto L6
    }

    public static final void f(RtcBrowserTransport r19, b r20) {
        r19.getClass();
        if (r19.l(r20.a) == true) goto L6;
        return;
    L6:
        if (r20.r == false) goto L8;
        o(r19, r20.a, "token_renewal_coalesced", null, true, 4);
        return;
    L8:
        id9.e r9 = r20.o;
        if (r9 == null) goto L27;
        r20.q = true;
        if (r19.m(r20, r9) == true) goto L14;
        r19.n(r20.a, "token_renewal_deferred", "reason=session_not_connected", true);
        return;
    L14:
        boolean r1 = false;
        r20.q = false;
        RoomMeta r10 = r20.p;
        String r2 = r10.sessionId;
        if (r2 != null) goto L17;
    L18:
        r1 = true;
    L19:
        if (r1 == false) goto L21;
        r19.j(r20, "missing_session_id", null);
        return;
    L21:
        r20.r = true;
        long r13 = SystemClock.elapsedRealtime() + 20000;
        o(r19, r20.a, "room_token_will_expire", "budgetMs=20000", false, 8);
        r19.g.postDelayed(r20.s, 20000);
        BuildersKt.launch$default(r20.t, Dispatchers.getIO(), null, new RtcBrowserTransport$requestTokenRenewal$1(r19, r20, r9, r10, r13, null), 2, null);
        return;
    L17:
        if (StringsKt.isBlank(r2) == false) goto L19;
    }

    public final void i(long r8, Failure r10) {
        if (l(r8) == true) goto L6;
        n(r8, "failure_ignored", "reason=" + r10 + " stale=true", true);
        return;
    L6:
        o(this, r8, "connection_failed", "reason=" + r10, false, 8);
        BrowserTransport.a r0 = this.m;
        h();
        this.d.invoke(r10);
        if (r0 == null) goto L10;
        r0.onError();
        return;
    }

    public final boolean m(b r9, id9.e r10) {
        Object r0 = this.h;
        monitor-enter(r0);
    L23:
        th = move-exception;
        throw th;
    L5:
        if (this.k == false) goto L7;
    L15:
        boolean r11 = false;
    L16:
        monitor-exit(r0);
        if (r11 == true) goto L19;
    L21:
        return false;
    L19:
        if ((r10.state() instanceof jd9.c.a) == false) goto L21;
        return true;
    L7:
        if (this.l == false) goto L15;
        if (this.j != r9.a) goto L15;
        if (this.n != r9) goto L15;
        if (r9.o != r10) goto L15;
        r11 = true;
        goto L16
    }

    public RtcBrowserTransport(RoomMeta r3, String r4, com.larus.browsertakeover.session.e r5) {
        AnonymousClass1 r0 = new AnonymousClass1(null);
        Intrinsics.checkNotNullParameter(r3, "roomMeta");
        Intrinsics.checkNotNullParameter(r4, "conversationId");
        Intrinsics.checkNotNullParameter(r0, "refreshRoomMeta");
        Intrinsics.checkNotNullParameter(r5, "onFailure");
        this.a = r3;
        this.b = r4;
        this.c = r0;
        this.d = r5;
        this.e = BrowserTransport.EndpointMode.PAGE;
        this.f = BrowserTransport.FrameSource.RTP_CDP;
        this.g = new Handler(Looper.getMainLooper());
        this.h = new Object();
        this.i = Integer.toString(System.identityHashCode(this), CharsKt.checkRadix(16));
    }

    public final void j(final b r2, final String r3, final Integer r4) {
        p(new i(this, r2, r3, r4));
    }

    public static final void d(RtcBrowserTransport r10, b r11, String r12, int r13) {
        r10.getClass();
        if (r10.l(r11.a) == false) goto L16;
        long r1 = r11.n.incrementAndGet();
        if (r1 != 1) goto L8;
    L9:
        long r4 = r11.a;
        String r7 = "count=" + r1 + " reason=" + r12 + " bytes=" + r13;
        if (r1 == 1) goto L12;
        boolean r8 = true;
    L13:
        r10.n(r4, "rtp_frame_rejected", r7, r8);
        return;
    L12:
        r8 = false;
        goto L13
    L8:
        if ((r1 % 30) == 0) goto L9;
        return;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:58:0x018f -> B:59:0x0199). Please report as a decompilation issue!!! */
    public final Object k(b r23, RoomMeta r24, long r25, Continuation<? super RoomMeta> r27) {
        if ((r27 instanceof RtcBrowserTransport$fetchRenewedRoomMeta$1) == false) goto L7;
        RtcBrowserTransport$fetchRenewedRoomMeta$1 r1 = (RtcBrowserTransport$fetchRenewedRoomMeta$1) r27;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
        RtcBrowserTransport r3 = this;
    L8:
        Object r0 = r1.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r1.label;
        Object r6 = null;
        String r8 = "attempt=";
        if (r5 == 0) goto L21;
        if (r5 == 1) goto L15;
        if (r5 != 2) goto L14;
        int r7 = r1.I$1;
        int r9 = r1.I$0;
        long r10 = r1.J$0;
        String r12 = (String) r1.L$1;
        b r13 = (b) r1.L$0;
        ResultKt.throwOnFailure(r0);
        RtcBrowserTransport r14 = r3;
        String r19 = "attempt=";
        b r11 = r13;
        int r15 = 1;
        RtcBrowserTransport$fetchRenewedRoomMeta$1 r16 = r1;
        String r17 = r12;
        int r18 = r9;
        Object r20 = r4;
        int r21 = r7;
    L59:
        int r22 = r21 + r15;
        r6 = null;
        long r26 = r10;
        int r110 = r22;
        long r28 = r26;
        String r111 = r19;
    L30:
        if (r110 >= r18) goto L64;
        JobKt.ensureActive(r16.getContext());
        if (r14.l(r11.a) == true) goto L34;
        return r6;
    L34:
        long r29 = r28 - SystemClock.elapsedRealtime();
        if (r29 > 0) goto L37;
        return r6;
    L37:
        RtcBrowserTransport r30 = r14;
        o(r14, r11.a, "token_refresh_requested", r111 + (r110 + 1), false, 8);
        long r31 = Math.min(10000, r29);     // Catch: CancellationException -> L19 Exception -> L46
        RtcBrowserTransport$fetchRenewedRoomMeta$2$refreshed$1 r112 = new RtcBrowserTransport$fetchRenewedRoomMeta$2$refreshed$1(r30, r17, null);     // Catch: CancellationException -> L19 Exception -> L46
        r16.L$0 = r11;     // Catch: CancellationException -> L19 Exception -> L46
        r16.L$1 = r17;     // Catch: CancellationException -> L19 Exception -> L46
        r16.J$0 = r28;     // Catch: CancellationException -> L19 Exception -> L46
        r16.I$0 = r18;     // Catch: CancellationException -> L19 Exception -> L46
        r16.I$1 = r110;     // Catch: CancellationException -> L19 Exception -> L46
        r16.I$2 = r110;     // Catch: CancellationException -> L19 Exception -> L46
        r16.label = 1;     // Catch: CancellationException -> L19 Exception -> L46
        Object r32 = TimeoutKt.c(r31, r112, r16);     // Catch: CancellationException -> L19 Exception -> L46
        if (r32 != r20) goto L41;
        return r20;
    L41:
        b r113 = r11;
        String r114 = r17;
        r0 = r32;
        r1 = r16;
        r8 = r111;
        long r210 = r28;
        r4 = r20;
        int r33 = r110;
        int r34 = r33;
        int r115 = r18;
        long r116 = r210;
    L71:
        long r35 = r116;
        b r117 = r113;
        RoomMeta r118 = (RoomMeta) r0;     // Catch: CancellationException -> L19 Exception -> L44
        String r36 = r114;
        int r211 = r115;
        r110 = r34;
        int r37 = r211;
    L48:
        JobKt.ensureActive(r1.getContext());
        if (r118 == null) goto L52;
        return r118;
    L52:
        if ((r33 + 1) < 2) goto L54;
        return null;
    L54:
        if ((r35 - SystemClock.elapsedRealtime()) <= 1000) goto L73;
        RtcBrowserTransport r119 = r30;
        RtcBrowserTransport r212 = r30;
        r19 = r8;
        b r38 = r117;
        o(r119, r117.a, "token_refresh_retry", r8 + (r33 + 2), false, 8);
        r1.L$0 = r38;
        r1.L$1 = r36;
        r1.J$0 = r35;
        r1.I$0 = r37;
        r1.I$1 = r110;
        r1.label = 2;
        if (DelayKt.delay(1000, r1) != r4) goto L58;
        return r4;
    L58:
        r14 = r212;
        r16 = r1;
        r18 = r37;
        r17 = r36;
        r20 = r4;
        r11 = r38;
        r21 = r110;
        r10 = r35;
        r15 = 1;
        goto L59
    L73:
        return null;
    L44:
        r11 = r113;
        RtcBrowserTransport r120 = r30;
    L45:
        int r39 = r33;
        String r213 = r8;
        r16 = r1;
        r17 = r114;
        int r214 = r34;
        r20 = r4;
        r28 = r116;
        r111 = r213;
        r18 = r115;
        r110 = r214;
    L47:
        r117 = r11;
        r36 = r17;
        r1 = r16;
        r8 = r111;
        r30 = r120;
        r118 = null;
        r33 = r39;
        r35 = r28;
        r4 = r20;
        r37 = r18;
        goto L48
    L19:
        e = move-exception;
        throw e;
    L46:
        r120 = r30;
        r39 = r110;
        goto L47
    L64:
        return r6;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r33 = r1.I$2;
        r34 = r1.I$1;
        r115 = r1.I$0;
        r116 = r1.J$0;
        r114 = (String) r1.L$1;
        r113 = (b) r1.L$0;
        ResultKt.throwOnFailure(r0);     // Catch: Exception -> L18 CancellationException -> L19
        r30 = r3;
    L18:
        r11 = r113;
        r120 = r3;
        goto L45
    L21:
        ResultKt.throwOnFailure(r0);
        String r40 = r24.sessionId;
        if (r40 == null) goto L66;
        if ((!StringsKt.isBlank(r40)) == true) goto L27;
        r40 = null;
    L27:
        if (r40 == null) goto L66;
        r14 = r3;
        r20 = r4;
        r111 = "attempt=";
        r110 = 0;
        r18 = 2;
        r28 = r25;
        r16 = r1;
        r17 = r40;
        r11 = r23;
    L66:
        return null;
    L7:
        r3 = this;
        r1 = new RtcBrowserTransport$fetchRenewedRoomMeta$1(r3, r27);
        goto L8
    }

    public final void n(long r3, String r5, String r6, boolean r7) {
        String r4 = "transport=" + this.i + " generation=" + r3 + " event=" + r5 + ' ' + r6;
        FLogger r8 = FLogger.a;
        if (r7 == false) goto L5;
        r8.d("RtcBrowserTransport", r4);
        return;
    L5:
        r8.i("RtcBrowserTransport", r4);
    }

    public static final Object e(final RtcBrowserTransport r15, b r16, id9.e r17, RoomMeta r18, long r19, Continuation r21) {
        r15.getClass();
        if ((r21 instanceof RtcBrowserTransport$renewRoomToken$1) == false) goto L7;
        RtcBrowserTransport$renewRoomToken$1 r1 = (RtcBrowserTransport$renewRoomToken$1) r21;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        RtcBrowserTransport$renewRoomToken$1 r0 = r1;
        Object r3 = r0.result;
        Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r0.label;
        if (r4 == 0) goto L19;
        if (r4 != 1) goto L18;
        long r5 = r0.J$0;
        RoomMeta r6 = (RoomMeta) r0.L$2;
        id9.e r8 = (id9.e) r0.L$1;
        b r9 = (b) r0.L$0;
        ResultKt.throwOnFailure(r3);     // Catch: Exception -> L14 CancellationException -> L15
        final RoomMeta r10 = r6;
        final id9.e r11 = r8;
        b r12 = r9;
        final long r13 = r5;
    L56:
        final RoomMeta r14 = (RoomMeta) r3;     // Catch: CancellationException -> L43 Exception -> L53
        JobKt.ensureActive(r0.getContext());     // Catch: CancellationException -> L43 Exception -> L53
        if (r15.m(r12, r11) == false) goto L59;
        if (r14 != null) goto L30;
        r15.j(r12, "refresh_failed", null);     // Catch: CancellationException -> L43 Exception -> L53
        return Unit.INSTANCE;
    L30:
        if (com.larus.browsertakeover.signaling.j.a(r14, r10) == true) goto L33;
        r15.j(r12, "invalid_renewal_metadata", null);     // Catch: CancellationException -> L43 Exception -> L53
        return Unit.INSTANCE;
    L33:
        if (SystemClock.elapsedRealtime() < r13) goto L35;
        r15.j(r12, "deadline_exceeded", null);     // Catch: CancellationException -> L43 Exception -> L53
        return Unit.INSTANCE;
    L35:
        JobKt.ensureActive(r0.getContext());     // Catch: CancellationException -> L43 Exception -> L53
        if (r15.m(r12, r11) == false) goto L63;
        String r20 = r14.token;     // Catch: CancellationException -> L43 Exception -> L53
        if (r20 != null) goto L41;
        r20 = "";
    L41:
        final int r22 = r11.s(r20);     // Catch: CancellationException -> L43 Exception -> L53
        JobKt.ensureActive(r0.getContext());     // Catch: CancellationException -> L43 Exception -> L53
        final b r23 = r12;
        r15.p(new g(r15, r23, r11, r22, r13, r14, r10));     // Catch: CancellationException -> L43 Exception -> L53
    L48:
        return Unit.INSTANCE;
    L63:
        return Unit.INSTANCE;
    L59:
        return Unit.INSTANCE;
    L43:
        e = e;
    L51:
        o(r15, r12.a, "token_renewal_cancelled", null, true, 4);
        throw e;
    L46:
        r15.j(r12, "update_exception", null);
        goto L48
    L15:
        e = e;
        r12 = r9;
    L14:
        r12 = r9;
        goto L46
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        ResultKt.throwOnFailure(r3);
        r0.L$0 = r16;     // Catch: Exception -> L45 CancellationException -> L49
        r0.L$1 = r17;     // Catch: Exception -> L45 CancellationException -> L49
        r0.L$2 = r18;     // Catch: Exception -> L45 CancellationException -> L49
        r0.J$0 = r19;     // Catch: Exception -> L45 CancellationException -> L49
        r0.label = 1;     // Catch: Exception -> L45 CancellationException -> L49
        r3 = r15.k(r16, r18, r19, r0);     // Catch: Exception -> L45 CancellationException -> L49
        if (r3 == r7) goto L64;
        r11 = r17;
        r10 = r18;
        r13 = r19;
        r12 = r16;
        goto L56
    L64:
        return r7;
    L49:
        e = e;
        r12 = r16;
    L45:
        r12 = r16;
    L7:
        r1 = new RtcBrowserTransport$renewRoomToken$1(r15, r21);
        goto L8
    }

    public static /* synthetic */ void o(RtcBrowserTransport r6, long r7, String r9, String r10, boolean r11, int r12) {
        if ((r12 & 4) == 0) goto L5;
        r10 = "";
    L5:
        String r4 = r10;
        if ((r12 & 8) == 0) goto L8;
        boolean r5 = false;
    L9:
        r6.n(r7, r9, r4, r5);
        return;
    L8:
        r5 = r11;
        goto L9
    }
}
