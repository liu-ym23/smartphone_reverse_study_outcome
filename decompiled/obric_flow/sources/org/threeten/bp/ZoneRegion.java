package org.threeten.bp;

import androidx.room.writer.DaoWriter;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.regex.Pattern;
import org.threeten.bp.zone.ZoneRulesException;

/* JADX INFO: loaded from: classes3.dex */
final class ZoneRegion extends ZoneId implements Serializable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Pattern f21132b = null;
    private static final long serialVersionUID = 8386373296231747096L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient org.threeten.bp.zone.d f21133a;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final String f21134id;

    static {
        f21132b = Pattern.compile("[A-Za-z][A-Za-z0-9~/._+-]+");
    }

    public ZoneRegion(String r5, org.threeten.bp.zone.d r10) {
        this.f21134id = r5;
        this.f21133a = r10;
    }

    public static ZoneRegion ofId(String r5, boolean r10) {
        jm.c.p(r5, "zoneId");
        if (r5.length() < 2) goto L19;
        if (f21132b.matcher(r5).matches() == false) goto L19;
        org.threeten.bp.zone.d r11 = org.threeten.bp.zone.b.a(r5, true);     // Catch: ZoneRulesException -> L9
    L16:
        return new ZoneRegion(r5, r11);
    L9:
        e = move-exception;
        if (r5.equals("GMT0") == false) goto L13;
        r11 = ZoneOffset.UTC.getRules();
        goto L16
    L13:
        if (r10 == true) goto L17;
        r11 = null;
        goto L16
    L17:
        throw e;
    L19:
        throw new DateTimeException("Invalid ID for region-based ZoneId, invalid format: ".concat(r5));
    }

    public static ZoneId readExternal(DataInput r5) throws IOException {
        String r10 = r5.readUTF();
        if (r10.equals("Z") == true) goto L43;
        if (r10.startsWith("+") == true) goto L43;
        if (r10.startsWith(DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD) == true) goto L43;
        if (r10.equals("UTC") == true) goto L41;
        if (r10.equals("GMT") == true) goto L41;
        if (r10.equals("UT") == true) goto L41;
        if (r10.startsWith("UTC+") == false) goto L18;
    L35:
        ZoneOffset r11 = ZoneOffset.of(r10.substring(3));
        if (r11.getTotalSeconds() != 0) goto L39;
        ZoneRegion r12 = new ZoneRegion(r10.substring(0, 3), r11.getRules());
    L46:
        return r12;
    L39:
        r12 = new ZoneRegion(r10.substring(0, 3) + r11.getId(), r11.getRules());
        goto L46
    L18:
        if (r10.startsWith("GMT+") == true) goto L35;
        if (r10.startsWith("UTC-") == true) goto L35;
        if (r10.startsWith("GMT-") == true) goto L35;
        if (r10.startsWith("UT+") == false) goto L27;
    L30:
        ZoneOffset r13 = ZoneOffset.of(r10.substring(2));
        if (r13.getTotalSeconds() != 0) goto L34;
        ZoneRegion r14 = new ZoneRegion("UT", r13.getRules());
    L45:
        return r14;
    L34:
        r14 = new ZoneRegion("UT" + r13.getId(), r13.getRules());
        goto L45
    L27:
        if (r10.startsWith("UT-") == true) goto L30;
        return ofId(r10, false);
    L41:
        return new ZoneRegion(r10, ZoneOffset.UTC.getRules());
    L43:
        throw new DateTimeException("Invalid ID for region-based ZoneId, invalid format: ".concat(r10));
    }

    private Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new Ser((byte) 7, this);
    }

    @Override // org.threeten.bp.ZoneId
    public String getId() {
        return this.f21134id;
    }

    @Override // org.threeten.bp.ZoneId
    public org.threeten.bp.zone.d getRules() {
        org.threeten.bp.zone.d r5 = this.f21133a;
        if (r5 == null) goto L6;
        return r5;
    L6:
        return org.threeten.bp.zone.b.a(this.f21134id, false);
    }

    @Override // org.threeten.bp.ZoneId
    public void write(DataOutput r5) throws IOException {
        r5.writeByte(7);
        writeExternal(r5);
    }

    public void writeExternal(DataOutput r5) throws IOException {
        r5.writeUTF(this.f21134id);
    }
}
