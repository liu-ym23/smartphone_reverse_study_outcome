package kotlin.contracts;

import kotlin.SinceKotlin;
import kotlin.internal.ContractsDsl;

/* JADX INFO: loaded from: classes2.dex */
@SinceKotlin(version = "1.3")
@ContractsDsl
@ExperimentalContracts
public interface SimpleEffect extends Effect {
    @ContractsDsl
    @ExperimentalContracts
    ConditionalEffect implies(boolean r10);
}
