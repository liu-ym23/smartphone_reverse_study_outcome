package d18;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b implements e18.a<Integer> {
    public final int a;
    public final int b;
    public final int c;

    @Override // e18.a
    public final int getItemsCount() {
        return ((this.b - this.a) / this.c) + 1;
    }

    @Override // e18.a
    public final int a(Object r1) {
        return e18.a.C0102a.a(this, r1);
    }

    @Override // e18.a
    public final Integer getItem(int r3) {
        int r0 = 0;
        if (r3 >= 0) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L11;
        r0 = this.a + (r3 * this.c);
    L11:
        return Integer.valueOf(r0);
    L5:
        if (r3 >= getItemsCount()) goto L7;
        r1 = true;
        goto L8
    }

    @Override // e18.a
    public final int indexOf(Integer r2) {
        return (r2.intValue() - this.a) / this.c;
    }

    public b(int r1, int r2) {
        this.a = r1;
        this.b = r2;
        this.c = 1;
    }

    public b(int r1, int r2, int r3) {
        this.a = 0;
        this.b = r1;
        this.c = r2;
    }
}
