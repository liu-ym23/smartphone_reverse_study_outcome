package a;

import com.bytedance.crash.tracker.ActivityLifecycle;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\u001a\u0014\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0001H\u0002\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080D¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\b"}, d2 = {"ARTIFICIAL_FRAME_PACKAGE_NAME", "", "getARTIFICIAL_FRAME_PACKAGE_NAME", "()Ljava/lang/String;", "artificialFrame", "Ljava/lang/StackTraceElement;", "", ActivityLifecycle.NAME, "kotlinx-coroutines-core"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f9a = "_COROUTINE";

    static {
    }

    public static final /* synthetic */ StackTraceElement a(Throwable r0, String r1) {
        return b(r0, r1);
    }

    public static final String a() {
        return f9a;
    }

    private static final StackTraceElement b(Throwable r3, String r4) {
        StackTraceElement r5 = r3.getStackTrace()[0];
        return new StackTraceElement(f9a + '.' + r4, "_", r5.getFileName(), r5.getLineNumber());
    }
}
