package com.google.common.collect;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b8 implements y7 {
    public b8() {
    }

    public boolean equals(Object r5) {
        if ((r5 instanceof y7) == false) goto L10;
        y7 r10 = (y7) r5;
        if (getCount() == r10.getCount()) goto L7;
        return false;
    L7:
        if (com.google.common.base.b0.w(getElement(), r10.getElement()) == false) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    public int hashCode() {
        Object r5 = getElement();
        if (r5 != null) goto L5;
        int r10 = 0;
    L7:
        return getCount() ^ r10;
    L5:
        r10 = r5.hashCode();
        goto L7
    }

    @Override // com.google.common.collect.y7
    public String toString() {
        String r5 = String.valueOf(getElement());
        int r10 = getCount();
        if (r10 == 1) goto L7;
        StringBuilder r11 = new StringBuilder(r5.length() + 14);
        r11.append(r5);
        r11.append(" x ");
        r11.append(r10);
        return r11.toString();
    L7:
        return r5;
    }
}
