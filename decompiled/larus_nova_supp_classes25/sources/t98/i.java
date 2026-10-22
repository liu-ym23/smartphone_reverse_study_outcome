package t98;

import com.larus.avlink.gallery.power.policy.AlbumThermalLevel;
import com.larus.common.apphost.AppHost;
import com.larus.power.state.api.PowerMetricAvailability;
import com.larus.power.state.api.PowerStateService;
import com.larus.power.state.api.ThermalLevel;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class i implements h {
    public final AtomicBoolean a;

    public static final class a {
    }

    static {
    }

    @Override // t98.h
    public final g o() {
        if (this.a.compareAndSet(false, true) == true) goto L97;
    L95:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L22
        PowerStateService.a.getClass();     // Catch: Throwable -> L22
        PowerStateService r1 = (PowerStateService) ServiceManager.get().getService(PowerStateService.class);     // Catch: Throwable -> L22
        if (r1 == null) goto L19;
        wr9.j r2 = r1.o();     // Catch: Throwable -> L22
    L20:
        Object r3 = Result.constructor-impl(r2);     // Catch: Throwable -> L22
    L24:
        Throwable r6 = Result.exceptionOrNull-impl(r3);
        if (r6 == null) goto L28;
        FLogger.a.e("AlbumPowerState", "Failed to read cached album power state: " + r6.getMessage(), r6);
    L28:
        if (Result.isFailure-impl(r3) == false) goto L30;
        r3 = null;
    L30:
        wr9.j r4 = (wr9.j) r3;
        if (r4 == null) goto L94;
        Intrinsics.checkNotNullParameter(r4, "<this>");
        wr9.d r5 = r4.b.a;
        ThermalLevel r7 = (ThermalLevel) r5.a;
        Boolean r11 = (Boolean) j.a(r4.e.c);
        Integer r12 = (Integer) j.a(r4.e.a);
        Boolean r13 = (Boolean) j.a(r4.e.b);
        Double r14 = (Double) j.a(r4.c.a);
        Double r15 = (Double) j.a(r4.c.b);
        Boolean r16 = (Boolean) j.a(r4.d.d);
        Long r17 = (Long) j.a(r4.d.b);
        Integer r8 = (Integer) j.a(r4.f.a);
        if (r8 != null) goto L35;
    L40:
        Integer r18 = null;
    L41:
        Integer r9 = (Integer) j.a(r4.f.d);
        if (r9 != null) goto L44;
    L49:
        Integer r19 = null;
    L51:
        if (r7 != null) goto L53;
        int r10 = -1;
    L54:
        switch(r10) {
            case -1: goto L64;
            case 0: goto L56;
            case 1: goto L63;
            case 2: goto L62;
            case 3: goto L61;
            case 4: goto L60;
            case 5: goto L59;
            case 6: goto L58;
            case 7: goto L57;
            case 8: goto L64;
            default: goto L56;
        };
    L57:
        AlbumThermalLevel r20 = AlbumThermalLevel.SHUTDOWN;
    L65:
        AlbumThermalLevel r21 = r20;
        if (r5.b == PowerMetricAvailability.AVAILABLE) goto L68;
    L70:
        boolean r110 = false;
    L71:
        if (r14 != null) goto L75;
        if (r15 != null) goto L75;
        boolean r22 = false;
    L76:
        if (r16 != null) goto L80;
        if (r17 != null) goto L80;
        boolean r23 = false;
    L81:
        if (r11 != null) goto L86;
        if (r12 != null) goto L86;
        if (r13 != null) goto L86;
        boolean r24 = false;
    L87:
        if (r18 != null) goto L91;
        if (r19 != null) goto L91;
        boolean r25 = false;
    L99:
        return new g(r21, r110, r11, r12, r13, r14, r15, r16, r17, r18, r19, r22, r23, r24, r25);
    L91:
        r25 = true;
    L86:
        r24 = true;
    L80:
        r23 = true;
    L75:
        r22 = true;
        goto L76
    L68:
        if (r5.a == null) goto L70;
        r110 = true;
        goto L71
    L58:
        r20 = AlbumThermalLevel.EMERGENCY;
        goto L65
    L59:
        r20 = AlbumThermalLevel.CRITICAL;
        goto L65
    L60:
        r20 = AlbumThermalLevel.SEVERE;
        goto L65
    L61:
        r20 = AlbumThermalLevel.MODERATE;
        goto L65
    L62:
        r20 = AlbumThermalLevel.LIGHT;
        goto L65
    L63:
        r20 = AlbumThermalLevel.NONE;
        goto L65
    L64:
        r20 = AlbumThermalLevel.UNKNOWN;
        goto L65
    L56:
        throw new NoWhenBranchMatchedException();
    L53:
        r10 = j.a.a[r7.ordinal()];
        goto L54
    L44:
        if (r9.intValue() < 0) goto L46;
        boolean r26 = true;
    L47:
        if (r26 == false) goto L49;
        r19 = r9;
        goto L51
    L46:
        r26 = false;
        goto L47
    L35:
        if (r8.intValue() <= 0) goto L37;
        boolean r27 = true;
    L38:
        if (r27 == false) goto L40;
        r18 = r8;
        goto L41
    L37:
        r27 = false;
        goto L38
    L94:
        return new g(AlbumThermalLevel.UNKNOWN, false, null, null, null, null, null, null, null, null, null, false, false, false, false);
    L19:
        r2 = null;
    L22:
        th = move-exception;
        Result.Companion r28 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L24
    L97:
        Result.Companion r29 = Result.Companion;     // Catch: Throwable -> L11
        PowerStateService.a.getClass();     // Catch: Throwable -> L11
        PowerStateService r30 = (PowerStateService) ServiceManager.get().getService(PowerStateService.class);     // Catch: Throwable -> L11
        if (r30 == null) goto L8;
        r30.initialize(AppHost.a.getApplication());     // Catch: Throwable -> L11
        Unit r31 = Unit.INSTANCE;     // Catch: Throwable -> L11
    L9:
        Object r32 = Result.constructor-impl(r31);     // Catch: Throwable -> L11
    L13:
        Throwable r33 = Result.exceptionOrNull-impl(r32);
        if (r33 == null) goto L95;
        this.a.set(false);
        FLogger.a.e("AlbumPowerState", "Failed to initialize album power state: " + r33.getMessage(), r33);
        goto L95
    L8:
        r31 = null;
    L11:
        th = move-exception;
        Result.Companion r34 = Result.Companion;
        r32 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    }

    public i() {
        this.a = new AtomicBoolean(false);
    }
}
