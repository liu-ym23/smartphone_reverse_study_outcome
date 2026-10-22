package kotlinx.coroutines.internal;

import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.g2;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nMainDispatchers.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MainDispatchers.kt\nkotlinx/coroutines/internal/MainDispatchersKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,134:1\n1#2:135\n*E\n"})
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final boolean f10598a = true;

    static {
    }

    private static final a0 a(Throwable r10, String r11) {
        if (f10598a == true) goto L5;
        if (r10 == null) goto L8;
        throw r10;
    L8:
        d();
        throw new KotlinNothingValueException();
    L5:
        return new a0(r10, r11);
    }

    static /* synthetic */ a0 b(Throwable r10, String r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r10 = null;
    L6:
        if ((r12 & 2) == 0) goto L9;
        r11 = null;
    L9:
        return a(r10, r11);
    }

    public static final boolean c(g2 r10) {
        return r10.c0() instanceof a0;
    }

    public static final Void d() {
        throw new IllegalStateException("Module with the Main dispatcher is missing. Add dependency providing the Main dispatcher, e.g. 'kotlinx-coroutines-android' and ensure it has the same version as 'kotlinx-coroutines-core'");
    }

    public static final g2 e(w r10, List<? extends w> r11) {
        return r10.b(r11);
    L4:
        th = move-exception;
        return a(th, r10.a());
    }
}
