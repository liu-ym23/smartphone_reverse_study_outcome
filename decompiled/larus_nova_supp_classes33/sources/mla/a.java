package mla;

import org.threeten.bp.DayOfWeek;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class a implements h {
    public final CharSequence[] b;

    public a(CharSequence[] r3) {
        if (r3 == null) goto L11;
        if (r3.length != 7) goto L9;
        this.b = r3;
        return;
    L9:
        throw new IllegalArgumentException("Array must contain exactly 7 elements");
    L11:
        throw new IllegalArgumentException("Cannot be null");
    }

    @Override // mla.h
    public final CharSequence a(DayOfWeek r2) {
        return this.b[r2.getValue() - 1];
    }
}
