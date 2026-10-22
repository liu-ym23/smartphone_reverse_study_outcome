package kda;

import com.lynx.jsbridge.LynxAccessibilityModule;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.cocreationreview.ModuleKey;
import hda.b1;
import hda.c1;
import hda.e1;
import hda.o0;
import hda.p0;
import hda.q0;
import hda.r0;
import hda.r1;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class f implements r0<g> {
    public static final f a = null;

    static {
        a = new f();
    }

    public f() {
    }

    @Override // hda.r0
    public final String a(com.obric.assistant.cocreationreview.a r2) {
        g r3 = (g) r2;
        Intrinsics.checkNotNullParameter(r3, "record");
        return r3.i;
    }

    @Override // hda.r0
    public final String b(com.obric.assistant.cocreationreview.a r2) {
        g r3 = (g) r2;
        Intrinsics.checkNotNullParameter(r3, "record");
        return r3.j;
    }

    @Override // hda.r0
    public final com.obric.assistant.cocreationreview.a c(q0 r14) {
        Intrinsics.checkNotNullParameter(r14, "record");
        o0 r0 = new o0(r14);
        r1.a.getClass();
        e1 r9 = r1.f(r14);
        String r1 = r14.d;
        if (r1 != null) goto L7;
        r1 = r0.c(new String[]{"displaySummary", "memoryContent", LynxAccessibilityModule.MSG_CONTENT});
        if (r1 != null) goto L7;
        r1 = NameKeys.UnloadStrategy_No_Strategy;
    L7:
        Intrinsics.checkNotNullParameter(r1, "<this>");
        String r2 = b1.a(r1);
        String r3 = r14.a;
        ModuleKey r4 = ModuleKey.SCREEN_MEMORY;
        String r5 = p0.a(r14);
        Long r6 = r0.b(new String[]{"startTimestamp", "start_time", "startTime"});
        if (r6 == null) goto L28;
        long r7 = r6.longValue();
        if (r7 <= 0) goto L28;
        Long r8 = r0.b(new String[]{"endTimestamp", "end_time", "endTime"});
        if (r8 != null) goto L15;
    L23:
        long r10 = r7;
    L24:
        SimpleDateFormat r11 = new SimpleDateFormat("HH:mm", Locale.getDefault());
        String r12 = r11.format(new Date(r7));
        String r13 = r11.format(new Date(r10));
        if (Intrinsics.areEqual(r12, r13) == false) goto L27;
        Intrinsics.checkNotNull(r12);
    L29:
        String r15 = c1.c(r0.c(new String[]{"screenScene", "profileTag"}));
        String r16 = r9.c;
        String r17 = r9.d;
        if (StringsKt.isBlank(r17) == false) goto L32;
        String r18 = r2;
    L34:
        return new g(r3, r4, r12, r15, r16, r18, r9, r14.e, r14.g);
    L32:
        r18 = r17;
        goto L34
    L27:
        r5 = r12 + '-' + r13;
        goto L28
    L15:
        if (r8.longValue() <= 0) goto L17;
        boolean r19 = true;
    L18:
        if (r19 == true) goto L21;
        r8 = null;
    L21:
        if (r8 == null) goto L23;
        r10 = r8.longValue();
        goto L24
    L17:
        r19 = false;
    L28:
        r12 = r5;
        goto L29
    }
}
