package kotlin.reflect.full;

import kotlin.SinceKotlin;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@SinceKotlin(version = "1.1")
public final class IllegalCallableAccessException extends Exception {
    public IllegalCallableAccessException(IllegalAccessException r10) {
        Intrinsics.checkNotNullParameter(r10, "cause");
        super(r10);
    }
}
