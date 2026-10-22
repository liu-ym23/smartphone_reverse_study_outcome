package kotlin;

import kotlin.internal.AccessibleLateinitPropertyLiteral;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty0;

/* JADX INFO: loaded from: classes2.dex */
@JvmName(name = "LateinitKt")
public final class LateinitKt {
    private static final boolean isInitialized(@AccessibleLateinitPropertyLiteral KProperty0<?> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        throw new NotImplementedError("Implementation is intrinsic");
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    public static /* synthetic */ void isInitialized$annotations(KProperty0 r10) {
    }
}
