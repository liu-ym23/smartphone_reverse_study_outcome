package kotlinx.coroutines.internal;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nFastServiceLoader.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FastServiceLoader.kt\nkotlinx/coroutines/internal/FastServiceLoaderKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,161:1\n1#2:162\n*E\n"})
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final boolean f10568a = false;

    static {
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L4
        Object r11 = Result.m32constructorimpl(Class.forName("android.os.Build"));     // Catch: Throwable -> L4
    L6:
        f10568a = Result.m39isSuccessimpl(r11);
        return;
    L4:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r11 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L6
    }

    public static final boolean a() {
        return f10568a;
    }
}
