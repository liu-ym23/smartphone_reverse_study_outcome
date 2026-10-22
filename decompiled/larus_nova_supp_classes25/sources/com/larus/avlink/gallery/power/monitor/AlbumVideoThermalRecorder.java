package com.larus.avlink.gallery.power.monitor;

import com.larus.avlink.gallery.processor.k;
import com.larus.avlink.gallery.view.mob.GalleryMobHelper;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.power.state.api.PowerMetricAvailability;
import com.larus.power.state.api.PowerMetricSource;
import com.larus.power.state.api.ThermalLevel;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.JobKt;
import wr9.i;
import wr9.j;
import wr9.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class AlbumVideoThermalRecorder {
    public final Function0<i> a;
    public final wr9.e b;
    public final Function1<com.larus.avlink.gallery.power.monitor.a, Unit> c;
    public final Function1<Throwable, Unit> d;
    public final Object e;
    public i f;
    public Long g;
    public boolean h;
    public long i;
    public long j;
    public ThermalLevel k;
    public PowerMetricSource l;
    public long m;
    public long n;
    public boolean o;
    public final e p;

    /* JADX INFO: renamed from: com.larus.avlink.gallery.power.monitor.AlbumVideoThermalRecorder$3, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    final /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function1<com.larus.avlink.gallery.power.monitor.a, Unit> {
        public AnonymousClass3(Object r8) {
            super(1, r8, GalleryMobHelper.class, "mobVideoThermalInfo", "mobVideoThermalInfo$dora_avlink_impl_release(Lcom/larus/avlink/gallery/power/monitor/AlbumVideoThermalMetrics;)V", 0);
        }

        public final void invoke(com.larus.avlink.gallery.power.monitor.a r4) {
            Intrinsics.checkNotNullParameter(r4, "p0");
            ((GalleryMobHelper) ((CallableReference) this).receiver).getClass();
            Intrinsics.checkNotNullParameter(r4, "metrics");
            r4.getClass();
            GalleryMobHelper.i("flow_biz_thermal_info", MapsKt.mapOf(new Pair[]{TuplesKt.to("scene", "gallery_video"), TuplesKt.to("duration", Long.valueOf(r4.a)), TuplesKt.to("moderate_duration", Long.valueOf(r4.b)), TuplesKt.to("severe_duration", Long.valueOf(r4.c)), TuplesKt.to("thermal_valid", Integer.valueOf(r4.d ? 1 : 0)), TuplesKt.to("result", r4.e)}));
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((com.larus.avlink.gallery.power.monitor.a) r1);
            return Unit.INSTANCE;
        }
    }

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ThermalLevel.values().length];
            r0[ThermalLevel.MODERATE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L23:
            r0[ThermalLevel.SEVERE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L35:
            r0[ThermalLevel.CRITICAL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L25:
            r0[ThermalLevel.EMERGENCY.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L27:
            r0[ThermalLevel.SHUTDOWN.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L21:
            r0[ThermalLevel.NONE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L29:
            r0[ThermalLevel.LIGHT.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L31:
            r0[ThermalLevel.UNKNOWN.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L11:
            a = r0;
        }
    }

    public final void e() {
        i r0 = this.f;
        if (r0 != null) goto L5;
        return;
    L5:
        this.f = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L8
        r0.G8(this.p);     // Catch: Throwable -> L8
        Object r2 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r3 = Result.exceptionOrNull-impl(r2);
        if (r3 == null) goto L21;
        b(r3);
    L21:
        r0.close();     // Catch: Throwable -> L15
        Object r4 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L15
    L17:
        Throwable r5 = Result.exceptionOrNull-impl(r4);
        if (r5 == null) goto L25;
        b(r5);
        return;
    L25:
        return;
    L15:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
    L8:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }

    /* JADX WARN: Type inference failed for: r5v5, types: [com.larus.avlink.gallery.power.monitor.e] */
    public AlbumVideoThermalRecorder(Object r5) {
        Function0<i> r6 = new b();
        wr9.e r0 = new c();
        AnonymousClass3 r1 = new AnonymousClass3(GalleryMobHelper.a);
        Function1<Throwable, Unit> r2 = new d();
        Intrinsics.checkNotNullParameter(r6, "openSession");
        Intrinsics.checkNotNullParameter(r0, "clock");
        Intrinsics.checkNotNullParameter(r1, "report");
        Intrinsics.checkNotNullParameter(r2, "onError");
        this.a = r6;
        this.b = r0;
        this.c = r1;
        this.d = r2;
        this.e = new Object();
        this.j = Long.MIN_VALUE;
        this.k = ThermalLevel.UNKNOWN;
        this.o = true;
        this.p = new e(this);
    }

    public final void b(Throwable r2) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        this.d.invoke(r2);     // Catch: Throwable -> L4
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public final void c(String r12) {
        Intrinsics.checkNotNullParameter(r12, "result");
        Object r10 = this.e;
        monitor-enter(r10);
        Long r0 = this.g;     // Catch: Throwable -> L37
        if (r0 == null) goto L35;
        long r1 = r0.longValue();     // Catch: Throwable -> L37
        if (this.h == false) goto L10;
        monitor-exit(r10);
        return;
    L10:
        long r3 = RangesKt.coerceAtLeast(this.b.a(), this.i);     // Catch: Throwable -> L37
        i r2 = this.f;     // Catch: Throwable -> L21
        if (r2 == null) goto L24;
        j r4 = r2.o();     // Catch: Throwable -> L21
        if (r4 == null) goto L24;
        l r5 = r4.b;     // Catch: Throwable -> L21
        if (r5 == null) goto L24;
        wr9.d<ThermalLevel> r6 = r5.a;     // Catch: Throwable -> L21
        if (r6 == null) goto L24;
        a(r6, r3);     // Catch: Throwable -> L21
    L24:
        f(r3);     // Catch: Throwable -> L37
        this.h = true;     // Catch: Throwable -> L37
        com.larus.avlink.gallery.power.monitor.a r7 = new com.larus.avlink.gallery.power.monitor.a(r3 - r1, this.m, this.n, this.o, r12);     // Catch: Throwable -> L37
        monitor-exit(r10);
        e();
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L29
        this.c.invoke(r7);     // Catch: Throwable -> L29
        Object r9 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L29
    L31:
        Throwable r11 = Result.exceptionOrNull-impl(r9);
        if (r11 == null) goto L46;
        b(r11);
        return;
    L46:
        return;
    L29:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
    L21:
        th = move-exception;
        this.o = false;     // Catch: Throwable -> L37
        b(th);     // Catch: Throwable -> L37
        goto L24
    L35:
        monitor-exit(r10);
        return;
    L37:
        th = move-exception;
        throw th;
    }

    public final void f(long r5) {
        long r0 = r5 - this.i;
        switch(a.a[this.k.ordinal()]) {
            case 1: goto L7;
            case 2: goto L6;
            case 3: goto L6;
            case 4: goto L6;
            case 5: goto L6;
            case 6: goto L8;
            case 7: goto L8;
            case 8: goto L8;
            default: goto L5;
        };
    L6:
        this.n += r0;
        goto L8
    L7:
        this.m += r0;
    L8:
        this.i = r5;
        return;
    L5:
        throw new NoWhenBranchMatchedException();
    }

    public final void a(wr9.d<ThermalLevel> r11, long r12) {
        Object r0 = r11.a;
        ThermalLevel r1 = (ThermalLevel) r0;
        boolean r2 = true;
        if (r1 != null) goto L5;
    L13:
        r1 = ThermalLevel.UNKNOWN;
    L14:
        long r4 = r11.d;
        long r6 = this.j;
        if (r4 >= r6) goto L23;
        if (r1 == this.k) goto L19;
    L20:
        this.o = false;
        return;
    L19:
        if (r11.c != this.l) goto L20;
        return;
    L23:
        if (r6 == Long.MIN_VALUE) goto L26;
        r2 = false;
    L26:
        if (r2 == true) goto L31;
        if (this.l == r11.c) goto L31;
        this.o = false;
    L31:
        if (r1 != ThermalLevel.UNKNOWN) goto L34;
        this.o = false;
    L34:
        if (r4 <= r12) goto L36;
        this.o = false;
    L36:
        if (r2 == false) goto L38;
    L42:
        this.j = r4;
        this.l = r11.c;
        if (r2 == false) goto L46;
        this.k = r1;
        return;
    L46:
        if (r1 == this.k) goto L51;
        f(RangesKt.coerceIn(r4, this.i, r12));
        this.k = r1;
        return;
    L51:
        return;
    L38:
        if (r4 != r6) goto L42;
        if (r1 == this.k) goto L42;
        this.o = false;
        goto L42
    L5:
        if (r11.b != PowerMetricAvailability.AVAILABLE) goto L8;
        if (r0 == null) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == true) goto L12;
        r1 = null;
    L12:
        if (r1 != null) goto L14;
    L8:
        r3 = false;
        goto L9
    }

    public final Object d(Function1<? super Continuation<? super k>, ? extends Object> r10, Continuation<? super k> r11) {
        if ((r11 instanceof AlbumVideoThermalRecorder$record$1) == false) goto L7;
        AlbumVideoThermalRecorder$record$1 r0 = (AlbumVideoThermalRecorder$record$1) r11;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r12 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L20;
        if (r3 != 1) goto L19;
        Ref.ObjectRef r13 = (Ref.ObjectRef) r0.L$0;
        ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L14 CancellationException -> L16
    L56:
        k r4 = (k) r12;     // Catch: Throwable -> L14 CancellationException -> L16
        if (JobKt.isActive(r0.getContext()) == true) goto L60;
        String r5 = "cancelled";
    L66:
        r13.element = r5;     // Catch: Throwable -> L14 CancellationException -> L16
        c(r5);
        return r12;
    L60:
        if (r4.a == true) goto L63;
        r5 = "failed";
        goto L66
    L63:
        if (r4.f == false) goto L65;
        r5 = "fallback";
        goto L66
    L65:
        r5 = "success";
    L16:
        CancellationException e = e;
    L73:
        r13.element = "cancelled";     // Catch: Throwable -> L14
        throw e;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        Ref.ObjectRef r14 = r13;
        th = th;
    L76:
        c((String) r14.element);
        throw th;
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        ResultKt.throwOnFailure(r12);
        Object r15 = this.e;
        monitor-enter(r15);
    L78:
        th = move-exception;
        throw th;
    L23:
        if (this.g == null) goto L25;
    L50:
        monitor-exit(r15);
    L51:
        r14 = new Ref.ObjectRef();
        r14.element = "failed";
        r0.L$0 = r14;     // Catch: Throwable -> L69 CancellationException -> L71
        r0.label = 1;     // Catch: Throwable -> L69 CancellationException -> L71
        Object r16 = r10.invoke(r0);     // Catch: Throwable -> L69 CancellationException -> L71
        if (r16 != r2) goto L55;
        return r2;
    L55:
        r12 = r16;
        r13 = r14;
        goto L56
    L71:
        e = move-exception;
        e = e;
        r13 = r14;
    L69:
        th = th;
        goto L76
    L25:
        if (this.h == true) goto L50;
        Function0<i> r6 = this.a;     // Catch: Throwable -> L78
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L30
        Object r8 = Result.constructor-impl(r6.invoke());     // Catch: Throwable -> L30
    L32:
        Throwable r9 = Result.exceptionOrNull-impl(r8);     // Catch: Throwable -> L78
        if (r9 == null) goto L36;
        b(r9);     // Catch: Throwable -> L78
    L36:
        if (Result.isFailure-impl(r8) == false) goto L38;
        r8 = null;
    L38:
        this.f = (i) r8;     // Catch: Throwable -> L78
        long r17 = this.b.a();     // Catch: Throwable -> L78
        this.g = Long.valueOf(r17);     // Catch: Throwable -> L78
        this.i = r17;     // Catch: Throwable -> L78
        i r18 = this.f;     // Catch: Throwable -> L78
        if (r18 != null) goto L81;
        this.o = false;     // Catch: Throwable -> L78
        monitor-exit(r15);
        goto L51
    L81:
        a(r18.o().b.a, r17);     // Catch: Throwable -> L45
        r18.Gb(this.p);     // Catch: Throwable -> L45
        r18.start();     // Catch: Throwable -> L45
    L47:
        Unit r19 = Unit.INSTANCE;     // Catch: Throwable -> L78
        monitor-exit(r15);
        goto L51
    L45:
        th = move-exception;
        this.o = false;     // Catch: Throwable -> L78
        this.k = ThermalLevel.UNKNOWN;     // Catch: Throwable -> L78
        e();     // Catch: Throwable -> L78
        b(th);     // Catch: Throwable -> L78
        goto L47
    L30:
        th = move-exception;
        Result.Companion r20 = Result.Companion;     // Catch: Throwable -> L78
        r8 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L78
    L7:
        r0 = new AlbumVideoThermalRecorder$record$1(this, r11);
        goto L8
    }
}
