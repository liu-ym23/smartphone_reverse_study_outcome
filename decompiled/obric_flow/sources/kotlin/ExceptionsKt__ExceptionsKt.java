package kotlin;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import kotlin.internal.HidesMembers;
import kotlin.internal.InlineOnly;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0014\u0010\r\u001a\u00020\u000e*\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0003H\u0007\u001a\r\u0010\u0010\u001a\u00020\u000e*\u00020\u0003H\u0087\b\u001a\u0015\u0010\u0010\u001a\u00020\u000e*\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H\u0087\b\u001a\u0015\u0010\u0010\u001a\u00020\u000e*\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014H\u0087\b\u001a\f\u0010\u0015\u001a\u00020\u0016*\u00020\u0003H\u0007\"!\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038F¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"$\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"stackTrace", "", "Ljava/lang/StackTraceElement;", "", "getStackTrace$annotations", "(Ljava/lang/Throwable;)V", "getStackTrace", "(Ljava/lang/Throwable;)[Ljava/lang/StackTraceElement;", "suppressedExceptions", "", "getSuppressedExceptions$annotations", "getSuppressedExceptions", "(Ljava/lang/Throwable;)Ljava/util/List;", "addSuppressed", "", "exception", "printStackTrace", "stream", "Ljava/io/PrintStream;", "writer", "Ljava/io/PrintWriter;", "stackTraceToString", "", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/ExceptionsKt")
class ExceptionsKt__ExceptionsKt {
    public ExceptionsKt__ExceptionsKt() {
    }

    @SinceKotlin(version = "1.1")
    @HidesMembers
    public static void addSuppressed(Throwable r5, Throwable r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "exception");
        if (r5 == r10) goto L6;
        PlatformImplementationsKt.IMPLEMENTATIONS.addSuppressed(r5, r10);
        return;
    }

    public static final StackTraceElement[] getStackTrace(Throwable r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        StackTraceElement[] r10 = r5.getStackTrace();
        Intrinsics.checkNotNull(r10);
        return r10;
    }

    public static /* synthetic */ void getStackTrace$annotations(Throwable r5) {
    }

    public static final List<Throwable> getSuppressedExceptions(Throwable r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return PlatformImplementationsKt.IMPLEMENTATIONS.getSuppressed(r5);
    }

    @SinceKotlin(version = "1.4")
    public static /* synthetic */ void getSuppressedExceptions$annotations(Throwable r5) {
    }

    @InlineOnly
    private static final void printStackTrace(Throwable r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        r5.printStackTrace();
    }

    @SinceKotlin(version = "1.4")
    public static String stackTraceToString(Throwable r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        StringWriter r10 = new StringWriter();
        PrintWriter r11 = new PrintWriter(r10);
        r5.printStackTrace(r11);
        r11.flush();
        return r10.toString();
    }

    @InlineOnly
    private static final void printStackTrace(Throwable r5, PrintWriter r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "writer");
        r5.printStackTrace(r10);
    }

    @InlineOnly
    private static final void printStackTrace(Throwable r5, PrintStream r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "stream");
        r5.printStackTrace(r10);
    }
}
