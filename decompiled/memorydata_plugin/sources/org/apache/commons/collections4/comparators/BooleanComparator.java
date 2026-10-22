package org.apache.commons.collections4.comparators;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Comparator;

/* JADX INFO: loaded from: classes6.dex */
public final class BooleanComparator implements Serializable, Comparator<Boolean> {
    private static final BooleanComparator FALSE_FIRST = null;
    private static final BooleanComparator TRUE_FIRST = null;
    private static final long serialVersionUID = 1830042991606340609L;
    private boolean trueFirst;

    static {
        TRUE_FIRST = new BooleanComparator(true);
        FALSE_FIRST = new BooleanComparator(false);
    }

    public BooleanComparator() {
        this(false);
    }

    public BooleanComparator(boolean r2) {
        this.trueFirst = false;
        this.trueFirst = r2;
    }

    public static BooleanComparator booleanComparator(boolean r0) {
        if (r0 == false) goto L5;
        return TRUE_FIRST;
    L5:
        return FALSE_FIRST;
    }

    public static BooleanComparator getFalseFirstComparator() {
        return FALSE_FIRST;
    }

    public static BooleanComparator getTrueFirstComparator() {
        return TRUE_FIRST;
    }

    /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
    public int compare2(Boolean r1, Boolean r2) {
        boolean r3 = r1.booleanValue();
        if ((r2.booleanValue() ^ r3) == true) goto L5;
        return 0;
    L5:
        if ((this.trueFirst ^ r3) == false) goto L7;
        return 1;
    L7:
        return -1;
    }

    @Override // java.util.Comparator
    public /* synthetic */ int compare(Boolean r3, Boolean r4) {
        return compare2((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.memorydata.plugin"), (Boolean) ZeusTransformUtils.preCheckCast(r4, Boolean.class, "com.obric.memorydata.plugin"));
    }

    @Override // java.util.Comparator
    public boolean equals(Object r3) {
        if (this != r3) goto L5;
    L10:
        return true;
    L5:
        if (ZeusTransformUtils.instanceOf(r3, BooleanComparator.class) == true) goto L7;
    L9:
        return false;
    L7:
        if (this.trueFirst != ((BooleanComparator) ZeusTransformUtils.preCheckCast(r3, BooleanComparator.class, "com.obric.memorydata.plugin")).trueFirst) goto L9;
        goto L9
    }

    public int hashCode() {
        if (this.trueFirst == false) goto L5;
        return -478003966;
    L5:
        return 478003966;
    }

    public boolean sortsTrueFirst() {
        return this.trueFirst;
    }
}
