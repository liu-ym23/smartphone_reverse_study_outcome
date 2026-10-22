package yb;

import org.threeten.bp.DayOfWeek;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CharSequence[] f14106b;

    public a(CharSequence[] r8) {
        if (r8 == null) goto L11;
        if (r8.length != 7) goto L9;
        this.f14106b = r8;
        return;
    L9:
        throw new IllegalArgumentException("Array must contain exactly 7 elements");
    L11:
        throw new IllegalArgumentException("Cannot be null");
    }

    @Override // yb.g
    public final CharSequence a(DayOfWeek r8) {
        return this.f14106b[r8.getValue() - 1];
    }
}
