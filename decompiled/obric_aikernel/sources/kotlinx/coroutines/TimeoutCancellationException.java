package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nTimeout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Timeout.kt\nkotlinx/coroutines/TimeoutCancellationException\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,193:1\n1#2:194\n*E\n"})
public final class TimeoutCancellationException extends CancellationException implements g0<TimeoutCancellationException> {

    @JvmField
    public final transient v1 coroutine;

    public TimeoutCancellationException(String r10) {
        this(r10, null);
    }

    public TimeoutCancellationException(String r10, v1 r11) {
        super(r10);
        this.coroutine = r11;
    }

    @Override // kotlinx.coroutines.g0
    public /* bridge */ /* synthetic */ Throwable createCopy() {
        return createCopy();
    }

    @Override // kotlinx.coroutines.g0
    public TimeoutCancellationException createCopy() {
        String r10 = getMessage();
        if (r10 != null) goto L5;
        r10 = "";
    L5:
        TimeoutCancellationException r11 = new TimeoutCancellationException(r10, this.coroutine);
        r11.initCause(this);
        return r11;
    }
}
