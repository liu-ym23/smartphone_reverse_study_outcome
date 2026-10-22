package org.apache.commons.collections4.comparators;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes6.dex */
public class FixedOrderComparator<T> implements Serializable, Comparator<T> {
    private static final long serialVersionUID = 82794675842863201L;
    private int counter;
    private boolean isLocked;
    private final Map<T, Integer> map;
    private UnknownObjectBehavior unknownObjectBehavior;

    /* JADX INFO: renamed from: org.apache.commons.collections4.comparators.FixedOrderComparator$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$collections4$comparators$FixedOrderComparator$UnknownObjectBehavior = null;

        static {
            int[] r0 = new int[UnknownObjectBehavior.values().length];
            $SwitchMap$org$apache$commons$collections4$comparators$FixedOrderComparator$UnknownObjectBehavior = r0;
            r0[UnknownObjectBehavior.BEFORE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$org$apache$commons$collections4$comparators$FixedOrderComparator$UnknownObjectBehavior[UnknownObjectBehavior.AFTER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$org$apache$commons$collections4$comparators$FixedOrderComparator$UnknownObjectBehavior[UnknownObjectBehavior.EXCEPTION.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public static final enum UnknownObjectBehavior extends Enum<UnknownObjectBehavior> {
        private static final /* synthetic */ UnknownObjectBehavior[] $VALUES = null;
        public static final UnknownObjectBehavior AFTER = null;
        public static final UnknownObjectBehavior BEFORE = null;
        public static final UnknownObjectBehavior EXCEPTION = null;

        static {
            UnknownObjectBehavior r0 = new UnknownObjectBehavior("BEFORE", 0);
            BEFORE = r0;
            UnknownObjectBehavior r1 = new UnknownObjectBehavior("AFTER", 1);
            AFTER = r1;
            UnknownObjectBehavior r3 = new UnknownObjectBehavior("EXCEPTION", 2);
            EXCEPTION = r3;
            $VALUES = new UnknownObjectBehavior[]{r0, r1, r3};
        }

        private UnknownObjectBehavior(String r1, int r2) {
            super(r1, r2);
        }

        public static UnknownObjectBehavior valueOf(String r2) {
            return (UnknownObjectBehavior) ZeusTransformUtils.preCheckCast(Enum.valueOf(UnknownObjectBehavior.class, r2), UnknownObjectBehavior.class, "com.obric.memorydata.plugin");
        }

        public static UnknownObjectBehavior[] values() {
            return (UnknownObjectBehavior[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), UnknownObjectBehavior[].class, "com.obric.memorydata.plugin");
        }
    }

    public FixedOrderComparator() {
        this.map = new HashMap();
        this.counter = 0;
        this.isLocked = false;
        this.unknownObjectBehavior = UnknownObjectBehavior.EXCEPTION;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FixedOrderComparator(List<T> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.map = new HashMap();
        this.counter = 0;
        this.isLocked = false;
        this.unknownObjectBehavior = UnknownObjectBehavior.EXCEPTION;
        Objects.requireNonNull(r4, "The list of items must not be null");
        Iterator r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        add(r5.next());
        goto L4
    }

    public FixedOrderComparator(T... r4) {
        this.map = new HashMap();
        int r0 = 0;
        this.counter = 0;
        this.isLocked = false;
        this.unknownObjectBehavior = UnknownObjectBehavior.EXCEPTION;
        Objects.requireNonNull(r4, "The list of items must not be null");
        int r1 = r4.length;
    L3:
        if (r0 >= r1) goto L5;
        add(r4[r0]);
        r0 = r0 + 1;
        goto L3
    }

    public boolean add(T r4) {
        checkLocked();
        Map<T, Integer> r0 = this.map;
        int r1 = this.counter;
        this.counter = r1 + 1;
        if (((Integer) ZeusTransformUtils.preCheckCast(r0.put(r4, Integer.valueOf(r1)), Integer.class, "com.obric.memorydata.plugin")) != null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean addAsEqual(T r4, T r5) {
        checkLocked();
        Integer r0 = (Integer) ZeusTransformUtils.preCheckCast(this.map.get(r4), Integer.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L10;
        if (((Integer) ZeusTransformUtils.preCheckCast(this.map.put(r5, r0), Integer.class, "com.obric.memorydata.plugin")) != null) goto L7;
        return true;
    L7:
        return false;
    L10:
        throw new IllegalArgumentException(r4 + " not known to " + this);
    }

    public void checkLocked() {
        if (isLocked() == true) goto L6;
        return;
    L6:
        throw new UnsupportedOperationException("Cannot modify a FixedOrderComparator after a comparison");
    }

    @Override // java.util.Comparator
    public int compare(T r8, T r9) {
        this.isLocked = true;
        Integer r1 = (Integer) ZeusTransformUtils.preCheckCast(this.map.get(r8), Integer.class, "com.obric.memorydata.plugin");
        Integer r2 = (Integer) ZeusTransformUtils.preCheckCast(this.map.get(r9), Integer.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L8;
        if (r2 == null) goto L8;
        return r1.compareTo(r2);
    L8:
        int r3 = AnonymousClass1.$SwitchMap$org$apache$commons$collections4$comparators$FixedOrderComparator$UnknownObjectBehavior[this.unknownObjectBehavior.ordinal()];
        if (r3 != 1) goto L11;
        if (r1 != null) goto L33;
        if (r2 != null) goto L30;
        return 0;
    L30:
        return -1;
    L33:
        return 1;
    L11:
        if (r3 != 2) goto L13;
        if (r1 != null) goto L25;
        if (r2 == null) goto L32;
        return 1;
    L32:
        return 0;
    L25:
        return -1;
    L13:
        if (r3 != 3) goto L20;
        if (r1 == null) goto L18;
        r8 = r9;
    L18:
        throw new IllegalArgumentException("Attempting to compare unknown object " + r8);
    L20:
        throw new UnsupportedOperationException("Unknown unknownObjectBehavior: " + this.unknownObjectBehavior);
    }

    @Override // java.util.Comparator
    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (r7 != null) goto L9;
        return false;
    L9:
        if (r7.getClass().equals(getClass()) == false) goto L32;
        FixedOrderComparator r8 = (FixedOrderComparator) ZeusTransformUtils.preCheckCast(r7, FixedOrderComparator.class, "com.obric.memorydata.plugin");
        Map<T, Integer> r2 = this.map;
        if (r2 != null) goto L16;
        if (r8.map != null) goto L31;
    L17:
        UnknownObjectBehavior r3 = this.unknownObjectBehavior;
        if (r3 == null) goto L20;
        UnknownObjectBehavior r4 = r8.unknownObjectBehavior;
        if (r3 != r4) goto L31;
        if (this.counter != r8.counter) goto L31;
        if (this.isLocked != r8.isLocked) goto L31;
        if (r3 != r4) goto L31;
        return true;
    L20:
        if (r8.unknownObjectBehavior != null) goto L31;
        return true;
    L31:
        return false;
    L16:
        if (r2.equals(r8.map) == false) goto L31;
    L32:
        return false;
    }

    public UnknownObjectBehavior getUnknownObjectBehavior() {
        return this.unknownObjectBehavior;
    }

    public int hashCode() {
        int r1 = (629 + this.map.hashCode()) * 37;
        UnknownObjectBehavior r0 = this.unknownObjectBehavior;
        if (r0 != null) goto L5;
        int r2 = 0;
    L7:
        return ((((r1 + r2) * 37) + this.counter) * 37) + (!this.isLocked ? 1 : 0);
    L5:
        r2 = r0.hashCode();
        goto L7
    }

    public boolean isLocked() {
        return this.isLocked;
    }

    public void setUnknownObjectBehavior(UnknownObjectBehavior r2) {
        checkLocked();
        Objects.requireNonNull(r2, "Unknown object behavior must not be null");
        this.unknownObjectBehavior = r2;
    }
}
