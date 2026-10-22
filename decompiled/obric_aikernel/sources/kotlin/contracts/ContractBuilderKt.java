package kotlin.contracts;

import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.internal.ContractsDsl;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class ContractBuilderKt {
    @SinceKotlin(version = "1.3")
    @ContractsDsl
    @InlineOnly
    @ExperimentalContracts
    private static final void contract(Function1<? super ContractBuilder, Unit> r10) {
        Intrinsics.checkNotNullParameter(r10, "builder");
    }
}
