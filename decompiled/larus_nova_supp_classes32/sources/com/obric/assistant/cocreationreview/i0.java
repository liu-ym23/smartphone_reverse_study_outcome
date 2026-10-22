package com.obric.assistant.cocreationreview;

import java.util.Calendar;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class i0 {
    public static final t5 a(l5 r3) {
        Intrinsics.checkNotNullParameter(r3, "moduleMeta");
        return new t5(true, "反馈已回流到" + r3.b);
    }

    public static final long b(long r1) {
        Calendar r0 = Calendar.getInstance();
        r0.setTimeInMillis(r1);
        r0.set(11, 0);
        r0.set(12, 0);
        r0.set(13, 0);
        r0.set(14, 0);
        return r0.getTimeInMillis();
    }

    public static final a5 c(s5 r11) {
        Intrinsics.checkNotNullParameter(r11, "<this>");
        return new a5(r11.b, r11.d, r11.e, r11.f, true, System.currentTimeMillis(), r11.i, r11.j);
    }
}
