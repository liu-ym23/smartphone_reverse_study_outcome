package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio;

import com.ss.android.lark.officesdk.minutes.api.recording.common.external_audio.ExternalAudioSourceMode;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MmExternalAudioCapturePipeline {
    public static final /* synthetic */ int x = 0;
    public final f a;
    public final sub.b b;
    public final Function1<ByteBuffer, Unit> c;
    public final Function1<sub.a, Unit> d;
    public final Function1<sub.a, Unit> e;
    public Job f;
    public Job g;
    public final CoroutineScope h;
    public volatile boolean i;
    public boolean j;
    public boolean k;
    public volatile nub.a l;
    public final Object m;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public final Lazy q;
    public byte[] r;
    public final ArrayDeque<sub.a> s;
    public int t;
    public boolean u;
    public long v;
    public int w;

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.MmExternalAudioCapturePipeline$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/external_audio/ExternalEncodedAudioFrame;", "invoke"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    final class AnonymousClass1 extends Lambda implements Function1<sub.a, Unit> {
        public static final AnonymousClass1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass1();
        }

        public AnonymousClass1() {
            super(1);
        }

        public final void invoke(sub.a r2) {
            Intrinsics.checkNotNullParameter(r2, "it");
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((sub.a) r1);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.MmExternalAudioCapturePipeline$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/external_audio/ExternalEncodedAudioFrame;", "invoke"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    final class AnonymousClass2 extends Lambda implements Function1<sub.a, Unit> {
        public static final AnonymousClass2 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass2();
        }

        public AnonymousClass2() {
            super(1);
        }

        public final void invoke(sub.a r2) {
            Intrinsics.checkNotNullParameter(r2, "it");
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((sub.a) r1);
            return Unit.INSTANCE;
        }
    }

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ExternalAudioSourceMode.values().length];
            r0[ExternalAudioSourceMode.PCM_PULL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[ExternalAudioSourceMode.PCM_PUSH.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[ExternalAudioSourceMode.ENCODED_PUSH.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[ExternalAudioSourceMode.ENCODED_PULL.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    static {
    }

    public final int b() {
        return ((Number) this.o.getValue()).intValue();
    }

    public final int c() {
        return ((Number) this.q.getValue()).intValue();
    }

    public final int d() {
        return ((Number) this.p.getValue()).intValue();
    }

    public final int e() {
        return ((Number) this.n.getValue()).intValue();
    }

    public final void g() {
        lvb.a.e("MmExternalAudioCapturePipeline", "Stopping ExternalAudioSource");
        Job r0 = this.f;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.f = null;
        h();
        this.b.a();
        this.b.c();
        Object r1 = this.m;
        monitor-enter(r1);
        this.l = null;     // Catch: Throwable -> L15
        this.r = new byte[0];     // Catch: Throwable -> L15
        this.s.clear();     // Catch: Throwable -> L15
        this.t = 0;     // Catch: Throwable -> L15
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L15
        monitor-exit(r1);
        this.w = 0;
        this.i = false;
        this.j = false;
        this.k = false;
        this.u = false;
        this.b.close();     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        lvb.a.b("MmExternalAudioCapturePipeline", "Error closing ExternalAudioSource: " + e);
        return;
    L15:
        th = move-exception;
        throw th;
    }

    public final void h() {
        Job r0 = this.g;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.g = null;
        Object r1 = this.m;
        monitor-enter(r1);
        this.r = new byte[0];     // Catch: Throwable -> L11
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r1);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public final void f(nub.a r10) {
        StringBuilder r0 = new StringBuilder("setMeetingExternalAudioInput: ");
        if (r10 == null) goto L5;
        Integer r2 = Integer.valueOf(r10.hashCode());
    L6:
        r0.append(r2);
        lvb.a.e("MmExternalAudioCapturePipeline", r0.toString());
        this.l = r10;
        boolean r4 = false;
        if (this.b.b() != ExternalAudioSourceMode.ENCODED_PUSH) goto L21;
        if (r10 == null) goto L20;
        Job r11 = this.g;
        if (r11 != null) goto L12;
    L14:
        if (r4 == false) goto L17;
        return;
    L17:
        if (this.l != null) goto L19;
        lvb.a.e("MmExternalAudioCapturePipeline", "[encoded audio][pacer] skip start, external audio input is null");
        return;
    L19:
        this.g = BuildersKt.launch$default(this.h, null, null, new MmExternalAudioCapturePipeline$startEncodedRtcPushLoop$1(this, null), 3, null);
        return;
    L12:
        if (r11.isActive() != true) goto L14;
        r4 = true;
        goto L14
    L20:
        h();
        return;
    L21:
        if (r10 == null) goto L33;
        Job r12 = this.g;
        if (r12 != null) goto L25;
    L27:
        if (r4 == false) goto L30;
        return;
    L30:
        if (this.l != null) goto L32;
        lvb.a.e("MmExternalAudioCapturePipeline", "skip startRtcPushLoop, external audio input is null");
        return;
    L32:
        this.g = BuildersKt.launch$default(this.h, null, null, new MmExternalAudioCapturePipeline$startRtcPushLoop$1(this, null), 3, null);
        return;
    L25:
        if (r12.isActive() != true) goto L27;
        r4 = true;
        goto L27
    L33:
        h();
        return;
    L5:
        r2 = null;
        goto L6
    }

    public static final void a(MmExternalAudioCapturePipeline r11, ByteBuffer r12, int r13) {
        if (r11.l == null) goto L29;
        if (r13 <= 0) goto L31;
        byte[] r3 = new byte[r13];
        r12.rewind();
        r12.get(r3);
        r12.rewind();
        Object r14 = r11.m;
        monitor-enter(r14);
        int r2 = r11.c() * 200;     // Catch: Throwable -> L26
        if (r2 > 0) goto L13;
        lvb.a.b("MmExternalAudioCapturePipeline", "Invalid maxPendingBytes=" + r2);     // Catch: Throwable -> L26
        monitor-exit(r14);
        return;
    L13:
        int r1 = RangesKt.coerceAtLeast((r11.r.length + r13) - r2, 0);     // Catch: Throwable -> L26
        if (r1 > 0) goto L16;
        byte[] r0 = r11.r;     // Catch: Throwable -> L26
    L23:
        byte[] r15 = new byte[r0.length + r13];     // Catch: Throwable -> L26
        ArraysKt.copyInto$default(r0, r15, 0, 0, r0.length, 6, null);     // Catch: Throwable -> L26
        ArraysKt.copyInto$default(r3, r15, r0.length, 0, 0, 12, null);     // Catch: Throwable -> L26
        r11.r = r15;     // Catch: Throwable -> L26
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L26
        monitor-exit(r14);
        return;
    L16:
        if (r11.u == true) goto L18;
        lvb.a.h("MmExternalAudioCapturePipeline", "RTC pending buffer overflow, pending=" + r11.r.length + ", chunk=" + r13 + ", max=" + r2 + ", drop=" + r1);     // Catch: Throwable -> L26
        r11.u = true;     // Catch: Throwable -> L26
    L18:
        byte[] r4 = r11.r;     // Catch: Throwable -> L26
        if (r1 < r4.length) goto L21;
        r0 = new byte[0];     // Catch: Throwable -> L26
        goto L23
    L21:
        r0 = ArraysKt.copyOfRange(r4, r1, r4.length);     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        throw th;
    L31:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MmExternalAudioCapturePipeline(f r2, sub.b r3, Function1<? super ByteBuffer, Unit> r4, Function1<? super sub.a, Unit> r5, Function1<? super sub.a, Unit> r6) {
        Intrinsics.checkNotNullParameter(r2, "audioFormat");
        Intrinsics.checkNotNullParameter(r3, "externalAudioSource");
        Intrinsics.checkNotNullParameter(r4, "onAudioData");
        Intrinsics.checkNotNullParameter(r5, "onEncodedAudioFrame");
        Intrinsics.checkNotNullParameter(r6, "onEncodedAudioFrameData");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.h = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        this.m = new Object();
        this.n = LazyKt.lazy(new MmExternalAudioCapturePipeline$sampleRate$2(this));
        this.o = LazyKt.lazy(new MmExternalAudioCapturePipeline$channelCount$2(this));
        this.p = LazyKt.lazy(new MmExternalAudioCapturePipeline$rtcFrameSamples$2(this));
        this.q = LazyKt.lazy(new MmExternalAudioCapturePipeline$rtcFrameBytes$2(this));
        this.r = new byte[0];
        this.s = new ArrayDeque();
    }
}
