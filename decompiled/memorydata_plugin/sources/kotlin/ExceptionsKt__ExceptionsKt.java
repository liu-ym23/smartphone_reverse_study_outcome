package kotlin;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.aikernel.sdk.ext.CozeCloudExt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.List;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0014\u0010\r\u001a\u00020\u000e*\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0003H\u0007\u001a\r\u0010\u0010\u001a\u00020\u000e*\u00020\u0003H\u0087\b\u001a\u0015\u0010\u0010\u001a\u00020\u000e*\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H\u0087\b\u001a\u0015\u0010\u0010\u001a\u00020\u000e*\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014H\u0087\b\u001a\f\u0010\u0015\u001a\u00020\u0016*\u00020\u0003H\u0007\"!\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038F¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"$\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"stackTrace", "", "Ljava/lang/StackTraceElement;", "", "getStackTrace$annotations", "(Ljava/lang/Throwable;)V", "getStackTrace", "(Ljava/lang/Throwable;)[Ljava/lang/StackTraceElement;", "suppressedExceptions", "", "getSuppressedExceptions$annotations", "getSuppressedExceptions", "(Ljava/lang/Throwable;)Ljava/util/List;", "addSuppressed", "", CommonConsts.LOG_REPORT_TYPE_EXCEPTION, "printStackTrace", CozeCloudExt.API_KEY_HTTP_STREAM_METHOD, "Ljava/io/PrintStream;", "writer", "Ljava/io/PrintWriter;", "stackTraceToString", "", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/ExceptionsKt")
class ExceptionsKt__ExceptionsKt {
    public ExceptionsKt__ExceptionsKt() {
    }

    public static final void addSuppressed(Throwable r1, Throwable r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, CommonConsts.LOG_REPORT_TYPE_EXCEPTION);
        if (r1 == r2) goto L6;
        PlatformImplementationsKt.IMPLEMENTATIONS.addSuppressed(r1, r2);
        return;
    }

    public static final StackTraceElement[] getStackTrace(Throwable r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        StackTraceElement[] r2 = r1.getStackTrace();
        Intrinsics.checkNotNull(r2);
        return r2;
    }

    public static /* synthetic */ void getStackTrace$annotations(Throwable r0) {
    }

    public static final List<Throwable> getSuppressedExceptions(Throwable r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return PlatformImplementationsKt.IMPLEMENTATIONS.getSuppressed(r1);
    }

    public static /* synthetic */ void getSuppressedExceptions$annotations(Throwable r0) {
    }

    private static final void printStackTrace(Throwable r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        r1.printStackTrace();
    }

    private static final void printStackTrace(Throwable r1, PrintStream r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, CozeCloudExt.API_KEY_HTTP_STREAM_METHOD);
        r1.printStackTrace(r2);
    }

    private static final void printStackTrace(Throwable r1, PrintWriter r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "writer");
        r1.printStackTrace(r2);
    }

    public static final String stackTraceToString(Throwable r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        StringWriter r0 = new StringWriter();
        PrintWriter r1 = new PrintWriter((Writer) ZeusTransformUtils.preCheckCast(r0, Writer.class, "com.obric.memorydata.plugin"));
        r4.printStackTrace(r1);
        r1.flush();
        String r5 = r0.toString();
        Intrinsics.checkNotNullExpressionValue(r5, "toString(...)");
        return r5;
    }
}
