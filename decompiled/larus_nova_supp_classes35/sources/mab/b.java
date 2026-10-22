package mab;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b implements a<Integer> {
    @Override // mab.a
    public final int getItemsCount() {
        return 99;
    }

    @Override // mab.a
    public final String a() {
        return String.valueOf(99);
    }

    public b() {
    }

    public final Integer b(int r2) {
        if (r2 < 0) goto L8;
        if (r2 >= 99) goto L8;
        return Integer.valueOf(1 + (r2 * 1));
    L8:
        return 0;
    }

    @Override // mab.a
    public final /* bridge */ /* synthetic */ Integer getItem(int r1) {
        return b(r1);
    }

    @Override // mab.a
    public final int indexOf(Integer r1) {
        return (r1.intValue() - 1) / 1;
    }
}
