package org.apache.commons.collections4.functors;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Objects;
import org.apache.commons.collections4.Predicate;

/* JADX INFO: loaded from: classes6.dex */
public class ComparatorPredicate<T> implements Serializable, Predicate<T> {
    private static final long serialVersionUID = -1863209236504077399L;
    private final Comparator<T> comparator;
    private final Criterion criterion;
    private final T object;

    /* JADX INFO: renamed from: org.apache.commons.collections4.functors.ComparatorPredicate$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$collections4$functors$ComparatorPredicate$Criterion = null;

        static {
            int[] r0 = new int[Criterion.values().length];
            $SwitchMap$org$apache$commons$collections4$functors$ComparatorPredicate$Criterion = r0;
            r0[Criterion.EQUAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$org$apache$commons$collections4$functors$ComparatorPredicate$Criterion[Criterion.GREATER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$org$apache$commons$collections4$functors$ComparatorPredicate$Criterion[Criterion.LESS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            $SwitchMap$org$apache$commons$collections4$functors$ComparatorPredicate$Criterion[Criterion.GREATER_OR_EQUAL.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            $SwitchMap$org$apache$commons$collections4$functors$ComparatorPredicate$Criterion[Criterion.LESS_OR_EQUAL.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    public static final enum Criterion extends Enum<Criterion> {
        private static final /* synthetic */ Criterion[] $VALUES = null;
        public static final Criterion EQUAL = null;
        public static final Criterion GREATER = null;
        public static final Criterion GREATER_OR_EQUAL = null;
        public static final Criterion LESS = null;
        public static final Criterion LESS_OR_EQUAL = null;

        static {
            Criterion r0 = new Criterion("EQUAL", 0);
            EQUAL = r0;
            Criterion r1 = new Criterion("GREATER", 1);
            GREATER = r1;
            Criterion r3 = new Criterion("LESS", 2);
            LESS = r3;
            Criterion r5 = new Criterion("GREATER_OR_EQUAL", 3);
            GREATER_OR_EQUAL = r5;
            Criterion r7 = new Criterion("LESS_OR_EQUAL", 4);
            LESS_OR_EQUAL = r7;
            $VALUES = new Criterion[]{r0, r1, r3, r5, r7};
        }

        private Criterion(String r1, int r2) {
            super(r1, r2);
        }

        public static Criterion valueOf(String r2) {
            return (Criterion) ZeusTransformUtils.preCheckCast(Enum.valueOf(Criterion.class, r2), Criterion.class, "com.obric.memorydata.plugin");
        }

        public static Criterion[] values() {
            return (Criterion[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Criterion[].class, "com.obric.memorydata.plugin");
        }
    }

    public ComparatorPredicate(T r3, Comparator<T> r4, Criterion r5) {
        Comparator<T> r6 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r4, Comparator.class, "com.obric.memorydata.plugin");
        this.object = r3;
        this.comparator = r6;
        this.criterion = r5;
    }

    public static <T> Predicate<T> comparatorPredicate(T r2, Comparator<T> r3) {
        return comparatorPredicate(r2, (Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.memorydata.plugin"), Criterion.EQUAL);
    }

    public static <T> Predicate<T> comparatorPredicate(T r2, Comparator<T> r3, Criterion r4) {
        Comparator r5 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.memorydata.plugin");
        Objects.requireNonNull(r5, "Comparator must not be null.");
        Objects.requireNonNull(r4, "Criterion must not be null.");
        return new ComparatorPredicate(r2, r5, r4);
    }

    @Override // org.apache.commons.collections4.Predicate
    public boolean evaluate(T r5) {
        int r6 = this.comparator.compare(this.object, r5);
        int r0 = AnonymousClass1.$SwitchMap$org$apache$commons$collections4$functors$ComparatorPredicate$Criterion[this.criterion.ordinal()];
        if (r0 != 1) goto L5;
        if (r6 == 0) goto L25;
        return false;
    L25:
        return true;
    L5:
        if (r0 != 2) goto L7;
        if (r6 > 0) goto L25;
        return false;
    L7:
        if (r0 != 3) goto L9;
        if (r6 < 0) goto L25;
        return false;
    L9:
        if (r0 != 4) goto L11;
        if (r6 >= 0) goto L25;
        return false;
    L11:
        if (r0 != 5) goto L15;
        if (r6 <= 0) goto L25;
        return false;
    L15:
        throw new IllegalStateException("The current criterion '" + this.criterion + "' is invalid.");
    }
}
