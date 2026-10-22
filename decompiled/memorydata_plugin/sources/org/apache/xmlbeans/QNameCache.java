package org.apache.xmlbeans;

import javax.xml.namespace.QName;

/* JADX INFO: loaded from: classes7.dex */
public final class QNameCache {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private int hashmask;
    private final float loadFactor;
    private int numEntries;
    private QName[] table;
    private int threshold;

    static {
    }

    public QNameCache(int r2) {
        this(r2, 0.7f);
    }

    public QNameCache(int r2, float r3) {
        this.numEntries = 0;
        int r0 = 16;
    L3:
        if (r0 >= r2) goto L5;
        r0 = r0 << 1;
        goto L3
    L5:
        this.loadFactor = r3;
        this.hashmask = r0 - 1;
        this.threshold = (int) (r0 * r3);
        this.table = new QName[r0];
    }

    private static boolean equals(QName r1, String r2, String r3, String r4) {
        if (r1.getLocalPart().equals(r3) == true) goto L5;
    L9:
        return false;
    L5:
        if (r1.getNamespaceURI().equals(r2) == false) goto L9;
        if (r1.getPrefix().equals(r4) == false) goto L9;
        return true;
    }

    private static int hash(String r0, String r1, String r2) {
        return (((r2.hashCode() << 10) + 0) + (r0.hashCode() << 5)) + r1.hashCode();
    }

    private void rehash() {
        int r0 = this.table.length * 2;
        QName[] r1 = new QName[r0];
        int r2 = r0 - 1;
        int r3 = 0;
    L3:
        QName[] r4 = this.table;
        if (r3 >= r4.length) goto L13;
        QName r5 = r4[r3];
        if (r5 == null) goto L12;
        int r6 = hash(r5.getNamespaceURI(), r5.getLocalPart(), r5.getPrefix());
    L8:
        int r7 = r6 & r2;
        if (r1[r7] == null) goto L11;
        r6 = r7 - 1;
        goto L8
    L11:
        r1[r7] = r5;
    L12:
        r3 = r3 + 1;
        goto L3
    L13:
        this.table = r1;
        this.hashmask = r2;
        this.threshold = (int) (r0 * this.loadFactor);
    }

    public QName getName(String r4, String r5, String r6) {
        if (r4 != null) goto L5;
        r4 = "";
    L5:
        if (r6 != null) goto L7;
        r6 = "";
    L7:
        int r0 = hash(r4, r5, r6);
    L8:
        int r1 = r0 & this.hashmask;
        QName r2 = this.table[r1];
        if (r2 == null) goto L10;
        if (equals(r2, r4, r5, r6) == true) goto L17;
        r0 = r1 - 1;
        goto L8
    L17:
        return r2;
    L10:
        int r3 = this.numEntries + 1;
        this.numEntries = r3;
        if (r3 < this.threshold) goto L13;
        rehash();
    L13:
        QName[] r7 = this.table;
        QName r8 = new QName(r4, r5, r6);
        r7[r1] = r8;
        return r8;
    }
}
