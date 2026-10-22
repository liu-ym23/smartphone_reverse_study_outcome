package androidx.core.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public interface Predicate<T> {
    static <T> Predicate<T> isEqual(final Object r1) {
        if (r1 != null) goto L5;
        return $$Lambda$Predicate$c1xpOSQv97DVgcNkcl2YqANiPCE.INSTANCE;
    L5:
        return new $$Lambda$Predicate$58553dH4VPuMtoknK4XN56zTEI(r1);
    }

    static /* synthetic */ boolean lambda$and$0(Predicate r2, Predicate r3, Object r4) {
        Predicate r5 = (Predicate) ZeusTransformUtils.wrapperContextForParams(r3, Predicate.class, "com.obric.memorydata.plugin");
        if (r2.test(r4) == true) goto L5;
    L7:
        return false;
    L5:
        if (r5.test(r4) == false) goto L7;
        return true;
    }

    static /* synthetic */ boolean lambda$isEqual$3(Object r0) {
        return Objects.isNull(r0);
    }

    static /* synthetic */ boolean lambda$isEqual$4(Object r0, Object r1) {
        return r0.equals(r1);
    }

    static /* synthetic */ boolean lambda$negate$1(Predicate r0, Object r1) {
        return !r0.test(r1);
    }

    static /* synthetic */ boolean lambda$or$2(Predicate r2, Predicate r3, Object r4) {
        Predicate r5 = (Predicate) ZeusTransformUtils.wrapperContextForParams(r3, Predicate.class, "com.obric.memorydata.plugin");
        if (r2.test(r4) == false) goto L5;
    L8:
        return true;
    L5:
        if (r5.test(r4) == true) goto L8;
        return false;
    }

    static <T> Predicate<T> not(Predicate<? super T> r2) {
        Predicate r3 = (Predicate) ZeusTransformUtils.wrapperContextForParams(r2, Predicate.class, "com.obric.memorydata.plugin");
        Objects.requireNonNull(r3);
        return r3.negate();
    }

    default Predicate<T> and(Predicate<? super T> r3) {
        final Predicate r4 = (Predicate) ZeusTransformUtils.wrapperContextForParams(r3, Predicate.class, "com.obric.memorydata.plugin");
        Objects.requireNonNull(r4);
        return new $$Lambda$Predicate$Z_mQR2qf4hU7w6X77mkLCF8SWU(this, r4);
    }

    default Predicate<T> negate() {
        return new $$Lambda$Predicate$W9Q6JQjW4dIqgo2g8GAADcVFiE(this);
    }

    default Predicate<T> or(Predicate<? super T> r3) {
        final Predicate r4 = (Predicate) ZeusTransformUtils.wrapperContextForParams(r3, Predicate.class, "com.obric.memorydata.plugin");
        Objects.requireNonNull(r4);
        return new $$Lambda$Predicate$twsP9GttRLcEwZFiG7gzeeDgsmI(this, r4);
    }

    boolean test(T r1);
}
