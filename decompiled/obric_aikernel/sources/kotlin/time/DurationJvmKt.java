package kotlin.time;

import com.bytedance.apm6.util.constant.NetConst;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nDurationJvm.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DurationJvm.kt\nkotlin/time/DurationJvmKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,33:1\n1#2:34\n*E\n"})
public final class DurationJvmKt {
    private static final boolean durationAssertionsEnabled = false;
    private static final ThreadLocal<DecimalFormat>[] precisionFormats = null;

    static {
        int r10 = 0;
        durationAssertionsEnabled = false;
        ThreadLocal<DecimalFormat>[] r11 = new ThreadLocal[4];
    L3:
        if (r10 >= 4) goto L5;
        r11[r10] = new ThreadLocal();
        r10 = r10 + 1;
        goto L3
    L5:
        precisionFormats = r11;
    }

    private static final DecimalFormat createFormatForDecimals(int r10) {
        DecimalFormat r11 = new DecimalFormat(NetConst.NOT_ENCRYPT_VERISON_CODE);
        if (r10 <= 0) goto L5;
        r11.setMinimumFractionDigits(r10);
    L5:
        r11.setRoundingMode(RoundingMode.HALF_UP);
        return r11;
    }

    public static final String formatToExactDecimals(double r10, int r11) {
        ThreadLocal<DecimalFormat>[] r12 = precisionFormats;
        if (r11 >= r12.length) goto L9;
        ThreadLocal<DecimalFormat> r13 = r12[r11];
        DecimalFormat r14 = r13.get();
        if (r14 != null) goto L7;
        r14 = createFormatForDecimals(r11);
        r13.set(r14);
    L8:
        DecimalFormat r15 = r14;
    L10:
        String r16 = r15.format(r10);
        Intrinsics.checkNotNullExpressionValue(r16, "format.format(value)");
        return r16;
    L7:
        Intrinsics.checkNotNullExpressionValue(r14, "get() ?: default().also(this::set)");
        goto L8
    L9:
        r15 = createFormatForDecimals(r11);
        goto L10
    }

    public static final String formatUpToDecimals(double r10, int r11) {
        DecimalFormat r12 = createFormatForDecimals(0);
        r12.setMaximumFractionDigits(r11);
        String r13 = r12.format(r10);
        Intrinsics.checkNotNullExpressionValue(r13, "createFormatForDecimals(… }\n        .format(value)");
        return r13;
    }

    public static final boolean getDurationAssertionsEnabled() {
        return durationAssertionsEnabled;
    }
}
