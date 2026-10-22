package m9;

import org.threeten.bp.DayOfWeek;

/* JADX INFO: loaded from: classes2.dex */
public class a implements h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CharSequence[] f11056b;

    public a(CharSequence[] r10) {
        if (r10 == null) goto L11;
        if (r10.length != 7) goto L9;
        this.f11056b = r10;
        return;
    L9:
        throw new IllegalArgumentException("Array must contain exactly 7 elements");
    L11:
        throw new IllegalArgumentException("Cannot be null");
    }

    @Override // m9.h
    public CharSequence a(DayOfWeek r10) {
        return this.f11056b[r10.getValue() - 1];
    }
}
