package kotlin.contracts;

import kotlin.Function;
import kotlin.SinceKotlin;
import kotlin.internal.ContractsDsl;

/* JADX INFO: loaded from: classes2.dex */
@SinceKotlin(version = "1.3")
@ContractsDsl
@ExperimentalContracts
public interface ContractBuilder {

    public static final class DefaultImpls {
        public static /* synthetic */ CallsInPlace callsInPlace$default(ContractBuilder r10, Function r11, InvocationKind r12, int r13, Object r14) {
            if (r14 != null) goto L9;
            if ((r13 & 2) == 0) goto L7;
            r12 = InvocationKind.UNKNOWN;
        L7:
            return r10.callsInPlace(r11, r12);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: callsInPlace");
        }
    }

    @ContractsDsl
    <R> CallsInPlace callsInPlace(Function<? extends R> r10, InvocationKind r11);

    @ContractsDsl
    Returns returns();

    @ContractsDsl
    Returns returns(Object r10);

    @ContractsDsl
    ReturnsNotNull returnsNotNull();
}
