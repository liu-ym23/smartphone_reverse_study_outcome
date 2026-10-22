package e4;

import com.bytedance.ai.applet.app.foundation.performance.AppletPerformanceNavigationType;
import com.bytedance.ai.applet.app.foundation.performance.f;
import com.bytedance.ai.applet.app.foundation.performance.g;
import com.bytedance.ai.applet.app.foundation.performance.i;
import com.bytedance.ai.bridge.performance.AbsGetPerformanceEntriesMethodIDL;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public static final AbsGetPerformanceEntriesMethodIDL.PerformanceEntry b(f r14) {
        Intrinsics.checkNotNullParameter(r14, "<this>");
        String r10 = null;
        if ((r14 instanceof f.a) == false) goto L10;
        f.a r1 = (f.a) r14;
        Long r11 = Long.valueOf(r1.b);
        String r12 = r1.c.b;
        Long r13 = r1.d;
        AppletPerformanceNavigationType r15 = r1.e;
        if (r15 == null) goto L7;
        String r16 = r15.getValue();
    L54:
        return a(r14, r11, r12, r13, r16, null, null, null, null, null, null, 1008);
    L7:
        r16 = null;
        goto L54
    L10:
        if ((r14 instanceof f.h) == false) goto L16;
        f.h r17 = (f.h) r14;
        Long r18 = Long.valueOf(r17.b);
        String r19 = r17.c.b;
        Long r20 = r17.f;
        AppletPerformanceNavigationType r21 = r17.g;
        if (r21 == null) goto L55;
        r10 = r21.getValue();
    L55:
        return a(r14, r18, r19, r20, r10, null, null, null, null, r17.d, r17.e, 240);
    L16:
        if ((r14 instanceof f.C0016f) == false) goto L25;
        f.C0016f r22 = (f.C0016f) r14;
        Long r23 = Long.valueOf(r22.b);
        i r24 = r22.c;
        if ((r24 instanceof g.a) == false) goto L20;
        g.a r25 = (g.a) r24;
    L21:
        if (r25 == null) goto L56;
        r10 = r25.b;
    L56:
        return a(r14, r23, r10, null, null, null, r22.d, r22.e, r22.f, null, null, 796);
    L20:
        r25 = null;
        goto L21
    L25:
        if ((r14 instanceof f.e) == false) goto L34;
        i r26 = ((f.e) r14).b;
        if ((r26 instanceof g.a) == false) goto L29;
        g.a r27 = (g.a) r26;
    L30:
        if (r27 == null) goto L57;
        r10 = r27.b;
    L57:
        return a(r14, null, r10, null, null, null, null, null, null, null, null, 1021);
    L29:
        r27 = null;
        goto L30
    L34:
        if ((r14 instanceof f.d) == false) goto L43;
        i r28 = ((f.d) r14).b;
        if ((r28 instanceof g.a) == false) goto L38;
        g.a r29 = (g.a) r28;
    L39:
        if (r29 == null) goto L58;
        r10 = r29.b;
    L58:
        return a(r14, null, r10, null, null, null, null, null, null, null, null, 1021);
    L38:
        r29 = null;
        goto L39
    L43:
        if ((r14 instanceof f.c) == false) goto L46;
        f.c r30 = (f.c) r14;
        return a(r14, Long.valueOf(r30.b), null, null, null, r30.d, null, null, null, null, null, 1006);
    L46:
        if ((r14 instanceof f.b) == false) goto L49;
        ((f.b) r14).getClass();
        return a(r14, 0L, null, null, null, null, null, null, null, null, null, 1022);
    L49:
        if ((r14 instanceof f.g) == false) goto L53;
        ((f.g) r14).getClass();
        return a(r14, 0L, null, null, null, null, null, null, null, null, null, 1022);
    L53:
        throw new NoWhenBranchMatchedException();
    }

    public static AbsGetPerformanceEntriesMethodIDL.PerformanceEntry a(f r23, Long r24, String r25, Long r26, String r27, String r28, Long r29, Long r30, Long r31, String r32, Long r33, int r34) {
        if ((r34 & 1) == 0) goto L5;
        Long r10 = null;
    L7:
        if ((r34 & 2) == 0) goto L9;
        String r11 = null;
    L11:
        if ((r34 & 4) == 0) goto L13;
        Long r12 = null;
    L15:
        if ((r34 & 8) == 0) goto L17;
        String r13 = null;
    L19:
        if ((r34 & 16) == 0) goto L21;
        String r14 = null;
    L23:
        if ((r34 & 32) == 0) goto L25;
        Long r18 = null;
    L27:
        if ((r34 & 64) == 0) goto L29;
        Long r15 = null;
    L31:
        if ((r34 & 128) == 0) goto L33;
        Long r16 = null;
    L35:
        if ((r34 & 256) == 0) goto L37;
        String r17 = null;
    L39:
        if ((r34 & 512) == 0) goto L41;
        Long r19 = null;
    L42:
        g r0 = r23.b();
        if ((r0 instanceof g.a) == false) goto L45;
        g.a r1 = (g.a) r0;
    L46:
        g r20 = r23.b();
        if ((r20 instanceof g.c) == false) goto L49;
        g.c r21 = (g.c) r20;
    L50:
        String r22 = r23.a().getEntryType().getValue();
        String r35 = r23.a().getValue();
        long r36 = r23.c();
        if (r1 == null) goto L53;
        Long r37 = Long.valueOf(r1.a);
    L54:
        if (r21 == null) goto L56;
        String r110 = r21.b;
    L57:
        if (r21 == null) goto L59;
        String r210 = r21.c;
    L60:
        if (r21 == null) goto L62;
        Boolean r211 = Boolean.valueOf(r21.d);
    L64:
        return new AbsGetPerformanceEntriesMethodIDL.PerformanceEntry(r22, r35, r36, r10, r11, r12, r13, r14, r15, r16, r37, r17, r19, r18, r110, r210, r211);
    L62:
        r211 = null;
        goto L64
    L59:
        r210 = null;
        goto L60
    L56:
        r110 = null;
        goto L57
    L53:
        r37 = null;
        goto L54
    L49:
        r21 = null;
        goto L50
    L45:
        r1 = null;
        goto L46
    L41:
        r19 = r33;
        goto L42
    L37:
        r17 = r32;
        goto L39
    L33:
        r16 = r31;
        goto L35
    L29:
        r15 = r30;
        goto L31
    L25:
        r18 = r29;
        goto L27
    L21:
        r14 = r28;
        goto L23
    L17:
        r13 = r27;
        goto L19
    L13:
        r12 = r26;
        goto L15
    L9:
        r11 = r25;
        goto L11
    L5:
        r10 = r24;
        goto L7
    }
}
