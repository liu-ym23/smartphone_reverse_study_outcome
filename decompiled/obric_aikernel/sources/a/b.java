package a;

import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes.dex */
@SourceDebugExtension({"SMAP\nCoroutineDebugging.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoroutineDebugging.kt\n_COROUTINE/CoroutineDebuggingKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,66:1\n1#2:67\n*E\n"})
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f6a = "_COROUTINE";

    static {
    }

    public static final /* synthetic */ StackTraceElement a(Throwable r10, String r11) {
        return b(r10, r11);
    }

    private static final StackTraceElement b(Throwable r10, String r11) {
        StackTraceElement r12 = r10.getStackTrace()[0];
        return new StackTraceElement(f6a + '.' + r11, "_", r12.getFileName(), r12.getLineNumber());
    }

    public static final String c() {
        return f6a;
    }
}
