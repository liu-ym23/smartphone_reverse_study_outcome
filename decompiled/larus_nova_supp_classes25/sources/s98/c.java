package s98;

import android.os.SystemClock;
import android.os.Trace;
import com.larus.avlink.gallery.power.policy.AlbumPowerLevel;
import com.larus.avlink.gallery.power.policy.AlbumThermalLevel;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import t98.d;
import t98.e;
import t98.f;
import t98.g;
import t98.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class c {
    public final f a;
    public final Function0<Integer> b;

    public static final class a {
    }

    static {
    }

    public final int a() {
        boolean r2 = true;
        if (((Number) this.b.invoke()).intValue() == 1) goto L6;
        return 8;
    L6:
        f r0 = this.a;
        g r3 = r0.a.o();
        ((e) r0.d).getClass();
        long r9 = SystemClock.elapsedRealtime();
        t98.c r4 = r0.c;
        d r1 = r0.b;
        r4.getClass();
        Intrinsics.checkNotNullParameter(r3, "snapshot");
        Intrinsics.checkNotNullParameter(r1, "config");
        ArrayList r5 = new ArrayList();
        if (r3.b == false) goto L9;
        AlbumThermalLevel r6 = r3.a;
    L11:
        switch(t98.c.C0085c.a[r6.ordinal()]) {
            case 1: goto L19;
            case 2: goto L19;
            case 3: goto L19;
            case 4: goto L18;
            case 5: goto L17;
            case 6: goto L16;
            case 7: goto L15;
            case 8: goto L14;
            default: goto L13;
        };
    L14:
        t98.c.b r7 = new t98.c.b(AlbumPowerLevel.UNKNOWN, r1.a, "thermal_unknown_keep_legacy_8");
    L20:
        r5.add(r7.c);
        AlbumPowerLevel r8 = r7.a;
        int r10 = r7.b;
        Integer r11 = r3.j;
        if (r11 != null) goto L23;
    L31:
        int r12 = r10;
    L32:
        t98.a r13 = new t98.a(r8, r12, CollectionsKt.distinct(r5), r9);
        int r14 = s98.a.a;
        Intrinsics.checkNotNullParameter(r13, "decision");
        StringBuilder r15 = new StringBuilder("DoraAlbum#decision_");
        r15.append(r13.a);
        r15.append('_');
        r15.append(r13.b);
        r15.append('_');
        String r16 = (String) CollectionsKt.firstOrNull(r13.c);
        if (r16 != null) goto L35;
        r16 = "unspecified";
    L35:
        r15.append(r16);
        Trace.beginSection(StringsKt.take(r15.toString(), 120));
        Unit r17 = Unit.INSTANCE;     // Catch: Throwable -> L39
        Trace.endSection();
        FLogger.a.i("AlbumVideoThreadController", "Video thread decision: level=" + r13.a + ", threads=" + r13.b + ", reasons=" + CollectionsKt.joinToString$default(r13.c, "|", null, null, 0, null, null, 62, null));
        return r13.b;
    L39:
        th = move-exception;
        Trace.endSection();
        throw th;
    L23:
        if (r11.intValue() > 0) goto L26;
        r2 = false;
    L26:
        if (r2 == true) goto L29;
        r11 = null;
    L29:
        if (r11 == null) goto L31;
        int r18 = r11.intValue();
        r12 = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(r10, r18), RangesKt.coerceAtMost(r1.d, r18));
        goto L32
    L15:
        r7 = new t98.c.b(AlbumPowerLevel.LOW, r1.a, "thermal_none");
        goto L20
    L16:
        r7 = new t98.c.b(AlbumPowerLevel.LOW, r1.a, "thermal_light");
        goto L20
    L17:
        r7 = new t98.c.b(AlbumPowerLevel.MEDIUM, r1.b, "thermal_moderate");
        goto L20
    L18:
        r7 = new t98.c.b(AlbumPowerLevel.HIGH, r1.c, "thermal_severe");
        goto L20
    L19:
        r7 = new t98.c.b(AlbumPowerLevel.CRITICAL, r1.c, "thermal_critical_or_higher");
        goto L20
    L13:
        throw new NoWhenBranchMatchedException();
    L9:
        r5.add("thermal_unknown");
        r6 = AlbumThermalLevel.UNKNOWN;
        goto L11
    }

    public c(int r3) {
        f r4 = new f(new i());
        Function0<Integer> r0 = new b();
        Intrinsics.checkNotNullParameter(r4, "policyController");
        Intrinsics.checkNotNullParameter(r0, "modeProvider");
        this.a = r4;
        this.b = r0;
    }
}
