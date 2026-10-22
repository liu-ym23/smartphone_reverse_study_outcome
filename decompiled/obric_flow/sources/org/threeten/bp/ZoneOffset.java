package org.threeten.bp;

import ai.j0;
import androidx.room.writer.DaoWriter;
import com.bytedance.ies.bullet.lynx.impl.LynxErrorCode;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;

/* JADX INFO: loaded from: classes3.dex */
public final class ZoneOffset extends ZoneId implements org.threeten.bp.temporal.d, org.threeten.bp.temporal.e, Comparable<ZoneOffset>, Serializable {
    public static final org.threeten.bp.temporal.i FROM = null;
    public static final ZoneOffset MAX = null;
    public static final ZoneOffset MIN = null;
    public static final ZoneOffset UTC = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap f21129b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap f21130c = null;
    private static final long serialVersionUID = 2357656521762053153L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient String f21131a;
    private final int totalSeconds;

    static {
        FROM = new t9.a();
        f21129b = new ConcurrentHashMap(16, 0.75f, 4);
        f21130c = new ConcurrentHashMap(16, 0.75f, 4);
        UTC = ofTotalSeconds(0);
        MIN = ofTotalSeconds(-64800);
        MAX = ofTotalSeconds(64800);
    }

    public ZoneOffset(int r10) {
        this.totalSeconds = r10;
        if (r10 != 0) goto L5;
        String r11 = "Z";
    L23:
        this.f21131a = r11;
        return;
    L5:
        int r5 = Math.abs(r10);
        StringBuilder r12 = new StringBuilder();
        int r13 = r5 / 3600;
        int r14 = (r5 / 60) % 60;
        if (r10 >= 0) goto L8;
        String r15 = DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD;
    L9:
        r12.append(r15);
        if (r13 >= 10) goto L12;
        String r16 = "0";
    L13:
        r12.append(r16);
        r12.append(r13);
        String r17 = ":";
        if (r14 >= 10) goto L16;
        String r18 = ":0";
    L17:
        r12.append(r18);
        r12.append(r14);
        int r19 = r5 % 60;
        if (r19 == 0) goto L22;
        if (r19 >= 10) goto L21;
        r17 = ":0";
    L21:
        r12.append(r17);
        r12.append(r19);
    L22:
        r11 = r12.toString();
        goto L23
    L16:
        r18 = ":";
        goto L17
    L12:
        r16 = "";
        goto L13
    L8:
        r15 = "+";
        goto L9
    }

    public static int a(int r5, String r10, boolean r11) {
        if (r11 == true) goto L4;
    L8:
        char r12 = r10.charAt(r5);
        char r13 = r10.charAt(r5 + 1);
        if (r12 < '0') goto L17;
        if (r12 > '9') goto L17;
        if (r13 < '0') goto L17;
        if (r13 > '9') goto L17;
        return (r13 - '0') + ((r12 - '0') * 10);
    L17:
        throw new DateTimeException("Invalid ID for ZoneOffset, non numeric characters found: " + r10);
    L4:
        if (r10.charAt(r5 - 1) == ':') goto L8;
        throw new DateTimeException("Invalid ID for ZoneOffset, colon not found when expected: " + r10);
    }

    public static ZoneOffset from(org.threeten.bp.temporal.d r5) {
        ZoneOffset r10 = (ZoneOffset) r5.query(org.threeten.bp.temporal.h.e);
        if (r10 == null) goto L6;
        return r10;
    L6:
        throw new DateTimeException("Unable to obtain ZoneOffset from TemporalAccessor: " + r5 + ", type " + r5.getClass().getName());
    }

    public static ZoneOffset of(String r10) {
        jm.c.p(r10, "offsetId");
        ZoneOffset r5 = (ZoneOffset) f21130c.get(r10);
        if (r5 == null) goto L5;
        return r5;
    L5:
        int r11 = r10.length();
        if (r11 != 2) goto L8;
        r10 = r10.charAt(0) + "0" + r10.charAt(1);
    L25:
        int r12 = a(1, r10, false);
        int r13 = 0;
        int r14 = 0;
    L26:
        char r15 = r10.charAt(0);
        if (r15 == '+') goto L32;
        if (r15 == '-') goto L32;
        throw new DateTimeException("Invalid ID for ZoneOffset, plus/minus not found when expected: ".concat(r10));
    L32:
        if (r15 != '-') goto L36;
        return ofHoursMinutesSeconds(-r12, -r13, -r14);
    L36:
        return ofHoursMinutesSeconds(r12, r13, r14);
    L8:
        if (r11 == 3) goto L25;
        if (r11 != 5) goto L12;
        r12 = a(1, r10, false);
        r13 = a(3, r10, false);
    L22:
        r14 = 0;
        goto L26
    L12:
        if (r11 != 6) goto L14;
        r12 = a(1, r10, false);
        r13 = a(4, r10, true);
        goto L22
    L14:
        if (r11 != 7) goto L16;
        r12 = a(1, r10, false);
        r13 = a(3, r10, false);
        r14 = a(5, r10, false);
        goto L26
    L16:
        if (r11 != 9) goto L19;
        r12 = a(1, r10, false);
        r13 = a(4, r10, true);
        r14 = a(7, r10, true);
        goto L26
    L19:
        throw new DateTimeException("Invalid ID for ZoneOffset, invalid format: ".concat(r10));
    }

    public static ZoneOffset ofHours(int r5) {
        return ofHoursMinutesSeconds(r5, 0, 0);
    }

    public static ZoneOffset ofHoursMinutes(int r5, int r10) {
        return ofHoursMinutesSeconds(r5, r10, 0);
    }

    public static ZoneOffset ofHoursMinutesSeconds(int r5, int r10, int r11) {
        if (r5 < (-18)) goto L45;
        if (r5 > 18) goto L45;
        if (r5 <= 0) goto L12;
        if (r10 < 0) goto L11;
        if (r11 < 0) goto L11;
    L26:
        if (Math.abs(r10) > 59) goto L43;
        if (Math.abs(r11) > 59) goto L41;
        if (Math.abs(r5) != 18) goto L39;
        if (Math.abs(r10) > 0) goto L37;
        if (Math.abs(r11) <= 0) goto L39;
    L37:
        throw new DateTimeException("Zone offset not in valid range: -18:00 to +18:00");
    L39:
        return ofTotalSeconds(((r10 * 60) + (r5 * 3600)) + r11);
    L41:
        throw new DateTimeException("Zone offset seconds not in valid range: abs(value) " + Math.abs(r11) + " is not in the range 0 to 59");
    L43:
        throw new DateTimeException("Zone offset minutes not in valid range: abs(value) " + Math.abs(r10) + " is not in the range 0 to 59");
    L11:
        throw new DateTimeException("Zone offset minutes and seconds must be positive because hours is positive");
    L12:
        if (r5 >= 0) goto L18;
        if (r10 > 0) goto L17;
        if (r11 <= 0) goto L26;
    L17:
        throw new DateTimeException("Zone offset minutes and seconds must be negative because hours is negative");
    L18:
        if (r10 <= 0) goto L20;
        if (r11 >= 0) goto L20;
    L24:
        throw new DateTimeException("Zone offset minutes and seconds must have the same sign");
    L20:
        if (r10 >= 0) goto L26;
        if (r11 > 0) goto L24;
    L45:
        throw new DateTimeException(j0.h(r5, "Zone offset hours not in valid range: value ", " is not in the range -18 to 18"));
    }

    public static ZoneOffset ofTotalSeconds(int r5) {
        if (Math.abs(r5) > 64800) goto L13;
        if ((r5 % LynxErrorCode.LYNX_ERROR_CODE_MODULE_NOT_EXIST) != 0) goto L11;
        Integer r10 = Integer.valueOf(r5);
        ConcurrentHashMap r11 = f21129b;
        ZoneOffset r12 = (ZoneOffset) r11.get(r10);
        if (r12 != null) goto L14;
        r11.putIfAbsent(r10, new ZoneOffset(r5));
        ZoneOffset r13 = (ZoneOffset) r11.get(r10);
        f21130c.putIfAbsent(r13.getId(), r13);
        return r13;
    L14:
        return r12;
    L11:
        return new ZoneOffset(r5);
    L13:
        throw new DateTimeException("Zone offset not in valid range: -18:00 to +18:00");
    }

    public static ZoneOffset readExternal(DataInput r5) throws IOException {
        byte r10 = r5.readByte();
        if (r10 != 127) goto L6;
        return ofTotalSeconds(r5.readInt());
    L6:
        return ofTotalSeconds(r10 * 900);
    }

    private Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new Ser((byte) 8, this);
    }

    @Override // org.threeten.bp.temporal.e
    public org.threeten.bp.temporal.c adjustInto(org.threeten.bp.temporal.c r5) {
        return r5.with(ChronoField.OFFSET_SECONDS, this.totalSeconds);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(ZoneOffset r5) {
        return compareTo2(r5);
    }

    @Override // org.threeten.bp.ZoneId
    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ZoneOffset) == true) goto L8;
        return false;
    L8:
        if (this.totalSeconds != ((ZoneOffset) r5).totalSeconds) goto L11;
        return true;
    L11:
        return false;
    }

    @Override // org.threeten.bp.temporal.d
    public int get(org.threeten.bp.temporal.g r5) {
        if (r5 != ChronoField.OFFSET_SECONDS) goto L7;
        return this.totalSeconds;
    L7:
        if ((r5 instanceof ChronoField) == true) goto L11;
        return range(r5).checkValidIntValue(getLong(r5), r5);
    L11:
        throw new UnsupportedTemporalTypeException(kotlin.collections.a.h("Unsupported field: ", r5));
    }

    @Override // org.threeten.bp.ZoneId
    public String getId() {
        return this.f21131a;
    }

    @Override // org.threeten.bp.temporal.d
    public long getLong(org.threeten.bp.temporal.g r5) {
        if (r5 != ChronoField.OFFSET_SECONDS) goto L7;
        return this.totalSeconds;
    L7:
        if ((r5 instanceof ChronoField) == true) goto L11;
        return r5.getFrom(this);
    L11:
        throw new DateTimeException(kotlin.collections.a.h("Unsupported field: ", r5));
    }

    @Override // org.threeten.bp.ZoneId
    public org.threeten.bp.zone.d getRules() {
        return org.threeten.bp.zone.d.of(this);
    }

    public int getTotalSeconds() {
        return this.totalSeconds;
    }

    @Override // org.threeten.bp.ZoneId
    public int hashCode() {
        return this.totalSeconds;
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
        if (r5 == ChronoField.OFFSET_SECONDS) goto L7;
        return false;
    L7:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.threeten.bp.temporal.d
    public <R> R query(org.threeten.bp.temporal.i r5) {
        if (r5 != org.threeten.bp.temporal.h.e) goto L5;
        return this;
    L5:
        if (r5 != org.threeten.bp.temporal.h.d) goto L8;
        return this;
    L8:
        if (r5 != org.threeten.bp.temporal.h.f) goto L10;
    L20:
        return null;
    L10:
        if (r5 == org.threeten.bp.temporal.h.g) goto L20;
        if (r5 == org.threeten.bp.temporal.h.f21288c) goto L20;
        if (r5 == org.threeten.bp.temporal.h.f21287b) goto L20;
        if (r5 == org.threeten.bp.temporal.h.f21286a) goto L20;
        return (R) r5.d(this);
    }

    @Override // org.threeten.bp.temporal.d
    public ValueRange range(org.threeten.bp.temporal.g r5) {
        if (r5 != ChronoField.OFFSET_SECONDS) goto L7;
        return r5.range();
    L7:
        if ((r5 instanceof ChronoField) == true) goto L11;
        return r5.rangeRefinedBy(this);
    L11:
        throw new UnsupportedTemporalTypeException(kotlin.collections.a.h("Unsupported field: ", r5));
    }

    @Override // org.threeten.bp.ZoneId
    public String toString() {
        return this.f21131a;
    }

    @Override // org.threeten.bp.ZoneId
    public void write(DataOutput r5) throws IOException {
        r5.writeByte(8);
        writeExternal(r5);
    }

    public void writeExternal(DataOutput r5) throws IOException {
        int r10 = this.totalSeconds;
        if ((r10 % LynxErrorCode.LYNX_ERROR_CODE_MODULE_NOT_EXIST) != 0) goto L5;
        int r11 = r10 / LynxErrorCode.LYNX_ERROR_CODE_MODULE_NOT_EXIST;
    L6:
        r5.writeByte(r11);
        if (r11 != 127) goto L10;
        r5.writeInt(r10);
        return;
    L10:
        return;
    L5:
        r11 = 127;
        goto L6
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(ZoneOffset r5) {
        return r5.totalSeconds - this.totalSeconds;
    }
}
