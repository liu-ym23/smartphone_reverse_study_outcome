package org.threeten.bp.chrono;

import ai.j0;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Locale;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.format.TextStyle;
import org.threeten.bp.format.s;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;

/* JADX INFO: loaded from: classes3.dex */
public final enum MinguoEra extends Enum<MinguoEra> implements j {
    public static final MinguoEra BEFORE_ROC = null;
    public static final MinguoEra ROC = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MinguoEra[] f21165a = null;

    static {
        MinguoEra r5 = new MinguoEra("BEFORE_ROC", 0);
        BEFORE_ROC = r5;
        MinguoEra r10 = new MinguoEra("ROC", 1);
        ROC = r10;
        f21165a = new MinguoEra[]{r5, r10};
    }

    public static MinguoEra of(int r5) {
        if (r5 == 0) goto L10;
        if (r5 != 1) goto L8;
        return ROC;
    L8:
        throw new DateTimeException(j0.g(r5, "Invalid era: "));
    L10:
        return BEFORE_ROC;
    }

    public static MinguoEra readExternal(DataInput r5) throws IOException {
        return of(r5.readByte());
    }

    public static MinguoEra valueOf(String r5) {
        return (MinguoEra) Enum.valueOf(MinguoEra.class, r5);
    }

    public static MinguoEra[] values() {
        return (MinguoEra[]) f21165a.clone();
    }

    private Object writeReplace() {
        return new Ser((byte) 6, this);
    }

    @Override // org.threeten.bp.temporal.e
    public org.threeten.bp.temporal.c adjustInto(org.threeten.bp.temporal.c r5) {
        return r5.with(ChronoField.ERA, getValue());
    }

    @Override // org.threeten.bp.temporal.d
    public int get(org.threeten.bp.temporal.g r5) {
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
    public long getLong(org.threeten.bp.temporal.g r5) {
        if (r5 != ChronoField.ERA) goto L7;
        return getValue();
    L7:
        if ((r5 instanceof ChronoField) == true) goto L11;
        return r5.getFrom(this);
    L11:
        throw new UnsupportedTemporalTypeException(kotlin.collections.a.h("Unsupported field: ", r5));
    }

    @Override // org.threeten.bp.chrono.j
    public int getValue() {
        return ordinal();
    }

    @Override // org.threeten.bp.temporal.d
    public boolean isSupported(org.threeten.bp.temporal.g r5) {
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

    @Override // org.threeten.bp.temporal.d
    public <R> R query(org.threeten.bp.temporal.i r5) {
        if (r5 != org.threeten.bp.temporal.h.f21288c) goto L7;
        return (R) ChronoUnit.ERAS;
    L7:
        if (r5 != org.threeten.bp.temporal.h.f21287b) goto L9;
        return null;
    L9:
        if (r5 != org.threeten.bp.temporal.h.d) goto L11;
        return null;
    L11:
        if (r5 != org.threeten.bp.temporal.h.f21286a) goto L13;
        return null;
    L13:
        if (r5 != org.threeten.bp.temporal.h.e) goto L15;
        return null;
    L15:
        if (r5 != org.threeten.bp.temporal.h.f) goto L17;
        return null;
    L17:
        if (r5 != org.threeten.bp.temporal.h.g) goto L20;
        return null;
    L20:
        return (R) r5.d(this);
    }

    @Override // org.threeten.bp.temporal.d
    public ValueRange range(org.threeten.bp.temporal.g r5) {
        if (r5 != ChronoField.ERA) goto L7;
        return r5.range();
    L7:
        if ((r5 instanceof ChronoField) == true) goto L11;
        return r5.rangeRefinedBy(this);
    L11:
        throw new UnsupportedTemporalTypeException(kotlin.collections.a.h("Unsupported field: ", r5));
    }

    public void writeExternal(DataOutput r5) throws IOException {
        r5.writeByte(getValue());
    }
}
