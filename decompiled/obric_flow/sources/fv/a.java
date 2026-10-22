package fv;

import java.util.Locale;
import org.threeten.bp.chrono.j;
import org.threeten.bp.format.TextStyle;
import org.threeten.bp.format.s;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.g;
import org.threeten.bp.temporal.h;
import org.threeten.bp.temporal.i;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a extends c implements j {
    public a() {
    }

    @Override // org.threeten.bp.temporal.e
    public org.threeten.bp.temporal.c adjustInto(org.threeten.bp.temporal.c r5) {
        return r5.with(ChronoField.ERA, getValue());
    }

    @Override // fv.c, org.threeten.bp.temporal.d
    public int get(g r5) {
        if (r5 != ChronoField.ERA) goto L7;
        return getValue();
    L7:
        return range(r5).checkValidIntValue(getLong(r5), r5);
    }

    public String getDisplayName(TextStyle r5, Locale r10) {
        s r11 = new s();
        r11.i(ChronoField.ERA, r5);
        return r11.q(r10).a(this);
    }

    @Override // org.threeten.bp.temporal.d
    public long getLong(g r5) {
        if (r5 != ChronoField.ERA) goto L7;
        return getValue();
    L7:
        if ((r5 instanceof ChronoField) == true) goto L11;
        return r5.getFrom(this);
    L11:
        throw new UnsupportedTemporalTypeException(kotlin.collections.a.h("Unsupported field: ", r5));
    }

    @Override // org.threeten.bp.temporal.d
    public boolean isSupported(g r5) {
        if ((r5 instanceof ChronoField) == true) goto L5;
        if (r5 != null) goto L10;
        return false;
    L10:
        if (r5.isSupportedBy(this) == true) goto L12;
        return false;
    L12:
        return true;
    L5:
        if (r5 == ChronoField.ERA) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // fv.c, org.threeten.bp.temporal.d
    public <R> R query(i r5) {
        if (r5 != h.f21288c) goto L7;
        return (R) ChronoUnit.ERAS;
    L7:
        if (r5 != h.f21287b) goto L9;
        return null;
    L9:
        if (r5 != h.d) goto L11;
        return null;
    L11:
        if (r5 != h.f21286a) goto L13;
        return null;
    L13:
        if (r5 != h.e) goto L15;
        return null;
    L15:
        if (r5 != h.f) goto L17;
        return null;
    L17:
        if (r5 != h.g) goto L20;
        return null;
    L20:
        return (R) r5.d(this);
    }
}
