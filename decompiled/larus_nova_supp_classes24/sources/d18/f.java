package d18;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class f implements e18.a<Integer> {
    public f() {
    }

    @Override // e18.a
    public final int getItemsCount() {
        return 12;
    }

    @Override // e18.a
    public final int a(Object r1) {
        return e18.a.C0102a.a(this, r1);
    }

    @Override // e18.a
    public final Integer getItem(int r3) {
        if (r3 != 0) goto L6;
        r3 = 12;
    L14:
        return Integer.valueOf(r3);
    L6:
        if (r3 < 0) goto L9;
        if (r3 >= 12) goto L9;
        boolean r0 = true;
    L10:
        if (r0 == true) goto L14;
        r3 = 0;
    L9:
        r0 = false;
        goto L10
    }

    @Override // e18.a
    public final int indexOf(Integer r2) {
        int r3 = r2.intValue();
        if (r3 != 12) goto L6;
        return 0;
    L6:
        return r3;
    }
}
