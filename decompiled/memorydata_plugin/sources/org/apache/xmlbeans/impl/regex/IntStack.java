package org.apache.xmlbeans.impl.regex;

/* JADX INFO: loaded from: classes7.dex */
final class IntStack {
    private int[] fData;
    private int fDepth;

    IntStack() {
    }

    private void ensureCapacity(int r4) {
        int[] r0 = this.fData;
        if (r0 != null) goto L6;
        this.fData = new int[32];
        return;
    L6:
        if (r0.length > r4) goto L10;
        int[] r5 = new int[r0.length * 2];
        System.arraycopy(r0, 0, r5, 0, r0.length);
        this.fData = r5;
        return;
    }

    public int pop() {
        int[] r0 = this.fData;
        int r1 = this.fDepth - 1;
        this.fDepth = r1;
        return r0[r1];
    }

    public void push(int r4) {
        ensureCapacity(this.fDepth + 1);
        int[] r0 = this.fData;
        int r1 = this.fDepth;
        this.fDepth = r1 + 1;
        r0[r1] = r4;
    }
}
