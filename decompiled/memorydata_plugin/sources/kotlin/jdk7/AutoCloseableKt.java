package kotlin.jdk7;

import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a \u0010\u0000\u001a\u00060\u0001j\u0002`\u00022\u000e\b\u0004\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0087\bø\u0001\u0000\u001a\u0018\u0010\u0006\u001a\u00020\u0005*\u0004\u0018\u00010\u00012\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0001\u001aH\u0010\t\u001a\u0002H\n\"\n\b\u0000\u0010\u000b*\u0004\u0018\u00010\u0001\"\u0004\b\u0001\u0010\n*\u0002H\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u000b\u0012\u0004\u0012\u0002H\n0\rH\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u000e*\u001a\b\u0007\u0010\u0000\"\u00020\u00012\u00020\u0001B\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0012"}, d2 = {"AutoCloseable", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "closeAction", "Lkotlin/Function0;", "", "closeFinally", "cause", "", "use", "R", ExifInterface.GPS_DIRECTION_TRUE, "block", "Lkotlin/Function1;", "(Ljava/lang/AutoCloseable;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Lkotlin/SinceKotlin;", "version", "2.0", "kotlin-stdlib-jdk7"}, k = 2, mv = {1, 9, 0}, pn = "kotlin", xi = 48)
public final class AutoCloseableKt {
    private static final AutoCloseable AutoCloseable(Function0<Unit> r2) {
        final Function0 r3 = (Function0) ZeusTransformUtils.wrapperContextForParams(r2, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "closeAction");
        return (AutoCloseable) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r3), AutoCloseable.class, "com.obric.memorydata.plugin");
    }

    public static /* synthetic */ void AutoCloseable$annotations() {
    }

    public static final void closeFinally(AutoCloseable r2, Throwable r3) {
        AutoCloseable r4 = (AutoCloseable) ZeusTransformUtils.wrapperContextForParams(r2, AutoCloseable.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L13;
        if (r3 != null) goto L11;
        r4.close();
        return;
    L11:
        r4.close();     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        ExceptionsKt.addSuppressed(r3, th);
        return;
    }

    private static final <T extends AutoCloseable, R> R use(T r2, Function1<? super T, ? extends R> r3) {
        AutoCloseable r4 = (AutoCloseable) ZeusTransformUtils.wrapperContextForParams(r2, AutoCloseable.class, "com.obric.memorydata.plugin");
        Function1 r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "block");
        R r6 = (R) r5.invoke(r4);
        InlineMarker.finallyStart(1);
        closeFinally(r4, null);
        InlineMarker.finallyEnd(1);
        return r6;
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        InlineMarker.finallyStart(1);
        closeFinally(r4, th);
        InlineMarker.finallyEnd(1);
        throw th;
    }
}
