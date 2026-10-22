package kotlinx.coroutines.internal;

import java.util.Collection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nCoroutineExceptionHandlerImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoroutineExceptionHandlerImpl.kt\nkotlinx/coroutines/internal/CoroutineExceptionHandlerImplKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,50:1\n1#2:51\n*E\n"})
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Collection<kotlinx.coroutines.h0> f10555a = null;

    static {
        f10555a = SequencesKt.toList(SequencesKt.asSequence(h.a()));
    }

    public static final Collection<kotlinx.coroutines.h0> a() {
        return f10555a;
    }

    public static final void b(Throwable r10) {
        Thread r11 = Thread.currentThread();
        r11.getUncaughtExceptionHandler().uncaughtException(r11, r10);
    }
}
