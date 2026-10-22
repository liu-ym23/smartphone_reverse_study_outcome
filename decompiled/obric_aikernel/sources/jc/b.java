package jc;

import java.util.Arrays;
import java.util.logging.Logger;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public static final /* synthetic */ void a(a r10, d r11, String r12) {
        c(r10, r11, r12);
    }

    public static final String b(long r12) {
        if (r12 > (-999500000)) goto L8;
        StringBuilder r10 = new StringBuilder();
        long r13 = r12 - ((long) 500000000);
    L5:
        r10.append(r13 / ((long) 1000000000));
        r10.append(" s ");
    L6:
        String r14 = r10.toString();
        StringCompanionObject r15 = StringCompanionObject.INSTANCE;
        String r16 = String.format("%6s", Arrays.copyOf(new Object[]{r14}, 1));
        Intrinsics.checkNotNullExpressionValue(r16, "format(format, *args)");
        return r16;
    L8:
        if (r12 > (-999500)) goto L12;
        r10 = new StringBuilder();
        long r17 = r12 - ((long) 500000);
    L10:
        r10.append(r17 / ((long) 1000000));
        r10.append(" ms");
        goto L6
    L12:
        if (r12 > 0) goto L16;
        r10 = new StringBuilder();
        long r18 = r12 - ((long) 500);
    L14:
        r10.append(r18 / ((long) 1000));
        r10.append(" µs");
        goto L6
    L16:
        if (r12 >= 999500) goto L19;
        r10 = new StringBuilder();
        r18 = r12 + ((long) 500);
        goto L14
    L19:
        if (r12 >= 999500000) goto L21;
        r10 = new StringBuilder();
        r17 = r12 + ((long) 500000);
        goto L10
    L21:
        r10 = new StringBuilder();
        r13 = r12 + ((long) 500000000);
        goto L5
    }

    private static final void c(a r10, d r11, String r12) {
        Logger r13 = e.f9925h.a();
        StringBuilder r14 = new StringBuilder();
        r14.append(r11.f());
        r14.append(' ');
        StringCompanionObject r15 = StringCompanionObject.INSTANCE;
        String r16 = String.format("%-22s", Arrays.copyOf(new Object[]{r12}, 1));
        Intrinsics.checkNotNullExpressionValue(r16, "format(format, *args)");
        r14.append(r16);
        r14.append(": ");
        r14.append(r10.b());
        r13.fine(r14.toString());
    }
}
