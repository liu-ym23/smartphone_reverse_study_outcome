package r1;

import androidx.work.impl.WorkDatabase;

/* JADX INFO: loaded from: classes.dex */
public final class f extends androidx.room.f<d> {
    public f(WorkDatabase r8) {
        super(r8);
    }

    @Override // androidx.room.f
    public final void bind(a1.f r8, d r10) {
        d r11 = r10;
        if (r11.a() != null) goto L5;
        r8.g0(1);
    L7:
        if (r11.b() != null) goto L9;
        r8.g0(2);
        return;
    L9:
        r8.W(2, r11.b().longValue());
        return;
    L5:
        r8.R(1, r11.a());
        goto L7
    }

    @Override // androidx.room.x
    public final String createQuery() {
        return "INSERT OR REPLACE INTO `Preference` (`key`,`long_value`) VALUES (?,?)";
    }
}
