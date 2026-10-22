package kotlin;

import com.bytedance.apm6.util.constant.CommonConsts;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import kotlin.internal.HidesMembers;
import kotlin.internal.InlineOnly;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
class ExceptionsKt__ExceptionsKt {
    public ExceptionsKt__ExceptionsKt() {
    }

    @SinceKotlin(version = "1.1")
    @HidesMembers
    public static void addSuppressed(Throwable r10, Throwable r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, CommonConsts.LOG_REPORT_TYPE_EXCEPTION);
        if (r10 == r11) goto L6;
        PlatformImplementationsKt.IMPLEMENTATIONS.addSuppressed(r10, r11);
        return;
    }

    public static final StackTraceElement[] getStackTrace(Throwable r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        StackTraceElement[] r11 = r10.getStackTrace();
        Intrinsics.checkNotNull(r11);
        return r11;
    }

    public static /* synthetic */ void getStackTrace$annotations(Throwable r10) {
    }

    public static final List<Throwable> getSuppressedExceptions(Throwable r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return PlatformImplementationsKt.IMPLEMENTATIONS.getSuppressed(r10);
    }

    @SinceKotlin(version = "1.4")
    public static /* synthetic */ void getSuppressedExceptions$annotations(Throwable r10) {
    }

    @InlineOnly
    private static final void printStackTrace(Throwable r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        r10.printStackTrace();
    }

    @InlineOnly
    private static final void printStackTrace(Throwable r10, PrintStream r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "stream");
        r10.printStackTrace(r11);
    }

    @InlineOnly
    private static final void printStackTrace(Throwable r10, PrintWriter r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "writer");
        r10.printStackTrace(r11);
    }

    @SinceKotlin(version = "1.4")
    public static String stackTraceToString(Throwable r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        StringWriter r11 = new StringWriter();
        PrintWriter r12 = new PrintWriter(r11);
        r10.printStackTrace(r12);
        r12.flush();
        String r13 = r11.toString();
        Intrinsics.checkNotNullExpressionValue(r13, "sw.toString()");
        return r13;
    }
}
