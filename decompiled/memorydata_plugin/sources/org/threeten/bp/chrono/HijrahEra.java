package org.threeten.bp.chrono;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.DataInput;
import java.io.DataOutput;
import java.util.Locale;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.format.DateTimeFormatterBuilder;
import org.threeten.bp.format.TextStyle;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.temporal.TemporalUnit;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;

/* JADX INFO: loaded from: classes8.dex */
public final enum HijrahEra extends Enum<HijrahEra> implements Era {
    private static final /* synthetic */ HijrahEra[] $VALUES = null;
    public static final HijrahEra AH = null;
    public static final HijrahEra BEFORE_AH = null;

    static {
        HijrahEra r0 = new HijrahEra("BEFORE_AH", 0);
        BEFORE_AH = r0;
        HijrahEra r1 = new HijrahEra("AH", 1);
        AH = r1;
        $VALUES = new HijrahEra[]{r0, r1};
    }

    private HijrahEra(String r1, int r2) {
        super(r1, r2);
    }

    public static HijrahEra of(int r1) {
        if (r1 == 0) goto L10;
        if (r1 != 1) goto L8;
        return AH;
    L8:
        throw new DateTimeException("HijrahEra not valid");
    L10:
        return BEFORE_AH;
    }

    static HijrahEra readExternal(DataInput r2) {
        return of(((DataInput) ZeusTransformUtils.wrapperContextForParams(r2, DataInput.class, "com.obric.memorydata.plugin")).readByte());
    }

    public static HijrahEra valueOf(String r2) {
        return (HijrahEra) ZeusTransformUtils.preCheckCast(Enum.valueOf(HijrahEra.class, r2), HijrahEra.class, "com.obric.memorydata.plugin");
    }

    public static HijrahEra[] values() {
        return (HijrahEra[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), HijrahEra[].class, "com.obric.memorydata.plugin");
    }

    private Object writeReplace() {
        return new Ser((byte) 4, this);
    }

    @Override // org.threeten.bp.temporal.TemporalAdjuster
    public Temporal adjustInto(Temporal r4) {
        return ((Temporal) ZeusTransformUtils.wrapperContextForParams(r4, Temporal.class, "com.obric.memorydata.plugin")).with(ChronoField.ERA, getValue());
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public int get(TemporalField r4) {
        TemporalField r5 = (TemporalField) ZeusTransformUtils.wrapperContextForParams(r4, TemporalField.class, "com.obric.memorydata.plugin");
        if (r5 != ChronoField.ERA) goto L7;
        return getValue();
    L7:
        return range(r5).checkValidIntValue(getLong(r5), r5);
    }

    public String getDisplayName(TextStyle r3, Locale r4) {
        return new DateTimeFormatterBuilder().appendText(ChronoField.ERA, r3).toFormatter(r4).format(this);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public long getLong(TemporalField r3) {
        TemporalField r4 = (TemporalField) ZeusTransformUtils.wrapperContextForParams(r3, TemporalField.class, "com.obric.memorydata.plugin");
        if (r4 != ChronoField.ERA) goto L7;
        return getValue();
    L7:
        if (ZeusTransformUtils.instanceOf(r4, ChronoField.class) == true) goto L11;
        return r4.getFrom(this);
    L11:
        throw new UnsupportedTemporalTypeException("Unsupported field: " + r4);
    }

    @Override // org.threeten.bp.chrono.Era
    public int getValue() {
        return ordinal();
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public boolean isSupported(TemporalField r4) {
        TemporalField r5 = (TemporalField) ZeusTransformUtils.wrapperContextForParams(r4, TemporalField.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r5, ChronoField.class) == true) goto L5;
        if (r5 == null) goto L14;
        if (r5.isSupportedBy(this) == false) goto L14;
        return true;
    L14:
        return false;
    L5:
        if (r5 != ChronoField.ERA) goto L8;
        return true;
    L8:
        return false;
    }

    int prolepticYear(int r2) {
        if (this != AH) goto L6;
        return r2;
    L6:
        return 1 - r2;
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public <R> R query(TemporalQuery<R> r3) {
        TemporalQuery<TemporalUnit> r4 = (TemporalQuery) ZeusTransformUtils.wrapperContextForParams(r3, TemporalQuery.class, "com.obric.memorydata.plugin");
        if (r4 != TemporalQueries.precision()) goto L7;
        return (R) ChronoUnit.ERAS;
    L7:
        if (r4 != TemporalQueries.chronology()) goto L9;
        return null;
    L9:
        if (r4 != TemporalQueries.zone()) goto L11;
        return null;
    L11:
        if (r4 != TemporalQueries.zoneId()) goto L13;
        return null;
    L13:
        if (r4 != TemporalQueries.offset()) goto L15;
        return null;
    L15:
        if (r4 != TemporalQueries.localDate()) goto L17;
        return null;
    L17:
        if (r4 != TemporalQueries.localTime()) goto L20;
        return null;
    L20:
        return (R) r4.queryFrom(this);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public ValueRange range(TemporalField r3) {
        TemporalField r4 = (TemporalField) ZeusTransformUtils.wrapperContextForParams(r3, TemporalField.class, "com.obric.memorydata.plugin");
        if (r4 != ChronoField.ERA) goto L7;
        return ValueRange.of(1, 1);
    L7:
        if (ZeusTransformUtils.instanceOf(r4, ChronoField.class) == true) goto L11;
        return r4.rangeRefinedBy(this);
    L11:
        throw new UnsupportedTemporalTypeException("Unsupported field: " + r4);
    }

    void writeExternal(DataOutput r3) {
        ((DataOutput) ZeusTransformUtils.wrapperContextForParams(r3, DataOutput.class, "com.obric.memorydata.plugin")).writeByte(getValue());
    }
}
