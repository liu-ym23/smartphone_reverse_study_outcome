package kotlin;

import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class DeepRecursiveKt {
    private static final Object UNDEFINED_RESULT = null;

    static {
        Result.Companion r10 = Result.Companion;
        UNDEFINED_RESULT = Result.m32constructorimpl(IntrinsicsKt.getCOROUTINE_SUSPENDED());
    }

    public static final /* synthetic */ Object access$getUNDEFINED_RESULT$p() {
        return UNDEFINED_RESULT;
    }

    private static /* synthetic */ void getUNDEFINED_RESULT$annotations() {
    }

    @SinceKotlin(version = "1.7")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final <T, R> R invoke(DeepRecursiveFunction<T, R> r10, T r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return (R) new DeepRecursiveScopeImpl(r10.getBlock$kotlin_stdlib(), r11).runCallLoop();
    }
}
