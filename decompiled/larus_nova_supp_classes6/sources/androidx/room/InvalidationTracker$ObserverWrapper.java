package androidx.room;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class InvalidationTracker$ObserverWrapper {
    final InvalidationTracker$Observer mObserver;
    private final Set<String> mSingleTableSet;
    final int[] mTableIds;
    private final String[] mTableNames;

    public void notifyByTableInvalidStatus(Set<Integer> r5) {
        int r0 = this.mTableIds.length;
        Set<String> r1 = null;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L13;
        if (r5.contains(Integer.valueOf(this.mTableIds[r2])) == false) goto L12;
        if (r0 != 1) goto L9;
        r1 = this.mSingleTableSet;
        goto L12
    L9:
        if (r1 != null) goto L11;
        r1 = new HashSet(r0);
    L11:
        r1.add(this.mTableNames[r2]);
    L12:
        r2 = r2 + 1;
        goto L3
    L13:
        if (r1 == null) goto L20;
        this.mObserver.onInvalidated(r1);
        return;
    }

    public void notifyByTableNames(String[] r12) {
        Set<String> r3 = null;
        if (this.mTableNames.length != 1) goto L10;
        int r0 = r12.length;
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L22;
        if (r12[r1].equalsIgnoreCase(this.mTableNames[0]) == true) goto L8;
        r1 = r1 + 1;
        goto L5
    L8:
        r3 = this.mSingleTableSet;
    L22:
        if (r3 == null) goto L31;
        this.mObserver.onInvalidated(r3);
        return;
    L31:
        return;
    L10:
        HashSet r2 = new HashSet();
        int r4 = r12.length;
        int r5 = 0;
    L11:
        if (r5 >= r4) goto L20;
        String r6 = r12[r5];
        String[] r7 = this.mTableNames;
        int r8 = r7.length;
        int r9 = 0;
    L13:
        if (r9 >= r8) goto L18;
        String r10 = r7[r9];
        if (r10.equalsIgnoreCase(r6) == true) goto L16;
        r9 = r9 + 1;
        goto L13
    L16:
        r2.add(r10);
    L18:
        r5 = r5 + 1;
        goto L11
    L20:
        if (r2.size() <= 0) goto L22;
        r3 = r2;
        goto L22
    }

    public InvalidationTracker$ObserverWrapper(InvalidationTracker$Observer r1, int[] r2, String[] r3) {
        this.mObserver = r1;
        this.mTableIds = r2;
        this.mTableNames = r3;
        if (r2.length != 1) goto L5;
        HashSet r4 = new HashSet();
        r4.add(r3[0]);
        this.mSingleTableSet = Collections.unmodifiableSet(r4);
        return;
    L5:
        this.mSingleTableSet = null;
    }
}
