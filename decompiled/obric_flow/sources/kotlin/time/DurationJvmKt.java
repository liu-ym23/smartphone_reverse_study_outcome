package kotlin.time;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0000\u001a\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0002\u001a\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000bH\u0000\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u001c\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\b¨\u0006\u0010"}, d2 = {"durationAssertionsEnabled", "", "getDurationAssertionsEnabled", "()Z", "precisionFormats", "", "Ljava/lang/ThreadLocal;", "Ljava/text/DecimalFormat;", "[Ljava/lang/ThreadLocal;", "createFormatForDecimals", "decimals", "", "formatToExactDecimals", "", "value", "", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nDurationJvm.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DurationJvm.kt\nkotlin/time/DurationJvmKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,28:1\n1#2:29\n*E\n"})
public final class DurationJvmKt {
    private static final boolean durationAssertionsEnabled = false;
    private static final ThreadLocal<DecimalFormat>[] precisionFormats = null;

    static {
        ThreadLocal<DecimalFormat>[] r5 = new ThreadLocal[4];
        int r10 = 0;
    L3:
        if (r10 >= 4) goto L5;
        r5[r10] = new ThreadLocal();
        r10 = r10 + 1;
        goto L3
    L5:
        precisionFormats = r5;
    }

    private static final DecimalFormat createFormatForDecimals(int r5) {
        DecimalFormat r10 = new DecimalFormat("0");
        if (r5 <= 0) goto L5;
        r10.setMinimumFractionDigits(r5);
    L5:
        r10.setRoundingMode(RoundingMode.HALF_UP);
        return r10;
    }

    public static final String formatToExactDecimals(double r5, int r10) {
        ThreadLocal<DecimalFormat>[] r11 = precisionFormats;
        if (r10 >= r11.length) goto L9;
        ThreadLocal<DecimalFormat> r12 = r11[r10];
        DecimalFormat r13 = r12.get();
        if (r13 != null) goto L7;
        r13 = createFormatForDecimals(r10);
        r12.set(r13);
    L8:
        DecimalFormat r14 = r13;
    L11:
        return r14.format(r5);
    L7:
        Intrinsics.checkNotNull(r13);
        goto L8
    L9:
        r14 = createFormatForDecimals(r10);
        goto L11
    }

    public static final boolean getDurationAssertionsEnabled() {
        return durationAssertionsEnabled;
    }
}
