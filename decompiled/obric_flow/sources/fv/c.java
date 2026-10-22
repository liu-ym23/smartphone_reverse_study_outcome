package fv;

import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;
import org.threeten.bp.temporal.d;
import org.threeten.bp.temporal.g;
import org.threeten.bp.temporal.h;
import org.threeten.bp.temporal.i;

/* JADX INFO: loaded from: classes3.dex */
public abstract class c implements d {
    public c() {
    }

    @Override // org.threeten.bp.temporal.d
    public int get(g r5) {
        return range(r5).checkValidIntValue(getLong(r5), r5);
    }

    @Override // org.threeten.bp.temporal.d
    public Object query(i r5) {
        if (r5 != h.f21286a) goto L5;
        return null;
    L5:
        if (r5 != h.f21287b) goto L7;
        return null;
    L7:
        if (r5 != h.f21288c) goto L10;
        return null;
    L10:
        return r5.d(this);
    }

    @Override // org.threeten.bp.temporal.d
    public ValueRange range(g r5) {
        if ((r5 instanceof ChronoField) == false) goto L11;
        if (isSupported(r5) == false) goto L9;
        return r5.range();
    L9:
        throw new UnsupportedTemporalTypeException(kotlin.collections.a.h("Unsupported field: ", r5));
    L11:
        return r5.rangeRefinedBy(this);
    }
}
