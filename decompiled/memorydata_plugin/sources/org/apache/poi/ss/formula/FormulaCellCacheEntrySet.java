package org.apache.poi.ss.formula;

/* JADX INFO: loaded from: classes7.dex */
final class FormulaCellCacheEntrySet {
    private static final FormulaCellCacheEntry[] EMPTY_ARRAY = null;
    private FormulaCellCacheEntry[] _arr;
    private int _size;

    static {
        EMPTY_ARRAY = new FormulaCellCacheEntry[0];
    }

    public FormulaCellCacheEntrySet() {
        this._arr = EMPTY_ARRAY;
    }

    private static boolean addInternal(CellCacheEntry[] r5, CellCacheEntry r6) {
        int r0 = Math.abs(r6.hashCode() % r5.length);
        int r1 = r0;
    L4:
        if (r1 >= r5.length) goto L12;
        CellCacheEntry r2 = r5[r1];
        if (r2 == r6) goto L7;
        if (r2 == null) goto L9;
        r1 = r1 + 1;
        goto L4
    L9:
        r5[r1] = r6;
        return true;
    L7:
        return false;
    L12:
        int r3 = 0;
    L13:
        if (r3 >= r0) goto L22;
        CellCacheEntry r4 = r5[r3];
        if (r4 == r6) goto L16;
        if (r4 == null) goto L18;
        r3 = r3 + 1;
        goto L13
    L18:
        r5[r3] = r6;
        return true;
    L16:
        return false;
    L22:
        throw new IllegalStateException("No empty space found");
    }

    public void add(CellCacheEntry r5) {
        int r0 = this._size * 3;
        FormulaCellCacheEntry[] r1 = this._arr;
        if (r0 < (r1.length * 2)) goto L13;
        FormulaCellCacheEntry[] r2 = new FormulaCellCacheEntry[((r1.length * 3) / 2) + 4];
        int r3 = 0;
    L6:
        if (r3 >= r1.length) goto L11;
        FormulaCellCacheEntry r4 = this._arr[r3];
        if (r4 == null) goto L10;
        addInternal(r2, r4);
    L10:
        r3 = r3 + 1;
        goto L6
    L11:
        this._arr = r2;
    L13:
        if (addInternal(this._arr, r5) == false) goto L19;
        this._size++;
        return;
    }

    public boolean remove(CellCacheEntry r8) {
        FormulaCellCacheEntry[] r0 = this._arr;
        int r3 = 0;
        if ((this._size * 3) < r0.length) goto L5;
    L17:
        int r1 = Math.abs(r8.hashCode() % r0.length);
        int r2 = r1;
    L19:
        if (r2 >= r0.length) goto L26;
        if (r0[r2] == r8) goto L22;
        r2 = r2 + 1;
        goto L19
    L22:
        r0[r2] = null;
    L23:
        this._size--;
        return true;
    L26:
        int r4 = 0;
    L27:
        if (r4 >= r1) goto L32;
        if (r0[r4] == r8) goto L30;
        r4 = r4 + 1;
        goto L27
    L30:
        r0[r4] = null;
        goto L23
    L32:
        return false;
    L5:
        if (r0.length <= 8) goto L17;
        FormulaCellCacheEntry[] r5 = new FormulaCellCacheEntry[r0.length / 2];
        boolean r6 = false;
    L8:
        if (r3 >= r0.length) goto L15;
        FormulaCellCacheEntry r7 = this._arr[r3];
        if (r7 == null) goto L14;
        if (r7 != r8) goto L13;
        this._size--;
        r6 = true;
        goto L14
    L13:
        addInternal(r5, r7);
    L14:
        r3 = r3 + 1;
        goto L8
    L15:
        this._arr = r5;
        return r6;
    }
}
