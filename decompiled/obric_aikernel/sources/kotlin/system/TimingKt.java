package kotlin.system;

import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@JvmName(name = "TimingKt")
public final class TimingKt {
    public static final long measureNanoTime(Function0<Unit> r10) {
        Intrinsics.checkNotNullParameter(r10, "block");
        long r11 = System.nanoTime();
        r10.invoke();
        return System.nanoTime() - r11;
    }

    public static final long measureTimeMillis(Function0<Unit> r10) {
        Intrinsics.checkNotNullParameter(r10, "block");
        long r11 = System.currentTimeMillis();
        r10.invoke();
        return System.currentTimeMillis() - r11;
    }
}
