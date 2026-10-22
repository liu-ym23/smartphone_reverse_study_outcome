package org.threeten.bp;

import ai.j0;
import androidx.room.writer.DaoWriter;
import java.io.DataOutput;
import java.io.IOException;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import org.threeten.bp.format.TextStyle;
import org.threeten.bp.format.r;
import org.threeten.bp.format.s;
import org.threeten.bp.zone.ZoneRulesException;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ZoneId implements Serializable {
    public static final org.threeten.bp.temporal.i FROM = null;
    public static final Map<String, String> SHORT_IDS = null;
    private static final long serialVersionUID = 8352817235686L;

    static {
        FROM = new sj.e();
        HashMap r5 = new HashMap();
        r5.put("ACT", "Australia/Darwin");
        r5.put("AET", "Australia/Sydney");
        r5.put("AGT", "America/Argentina/Buenos_Aires");
        r5.put("ART", "Africa/Cairo");
        r5.put("AST", "America/Anchorage");
        r5.put("BET", "America/Sao_Paulo");
        r5.put("BST", "Asia/Dhaka");
        r5.put("CAT", "Africa/Harare");
        r5.put("CNT", "America/St_Johns");
        r5.put("CST", "America/Chicago");
        r5.put("CTT", "Asia/Shanghai");
        r5.put("EAT", "Africa/Addis_Ababa");
        r5.put("ECT", "Europe/Paris");
        r5.put("IET", "America/Indiana/Indianapolis");
        r5.put("IST", "Asia/Kolkata");
        r5.put("JST", "Asia/Tokyo");
        r5.put("MIT", "Pacific/Apia");
        r5.put("NET", "Asia/Yerevan");
        r5.put("NST", "Pacific/Auckland");
        r5.put("PLT", "Asia/Karachi");
        r5.put("PNT", "America/Phoenix");
        r5.put("PRT", "America/Puerto_Rico");
        r5.put("PST", "America/Los_Angeles");
        r5.put("SST", "Pacific/Guadalcanal");
        r5.put("VST", "Asia/Ho_Chi_Minh");
        r5.put("EST", "-05:00");
        r5.put("MST", "-07:00");
        r5.put("HST", "-10:00");
        SHORT_IDS = Collections.unmodifiableMap(r5);
    }

    public ZoneId() {
        if (getClass() != ZoneOffset.class) goto L5;
        return;
    L5:
        if (getClass() != ZoneRegion.class) goto L8;
        return;
    L8:
        throw new AssertionError("Invalid subclass");
    }

    public static ZoneId from(org.threeten.bp.temporal.d r5) {
        ZoneId r10 = (ZoneId) r5.query(org.threeten.bp.temporal.h.d);
        if (r10 == null) goto L6;
        return r10;
    L6:
        throw new DateTimeException("Unable to obtain ZoneId from TemporalAccessor: " + r5 + ", type " + r5.getClass().getName());
    }

    public static Set<String> getAvailableZoneIds() {
        return new HashSet(Collections.unmodifiableSet(org.threeten.bp.zone.b.e.keySet()));
    }

    public static ZoneId of(String r5, Map<String, String> r10) {
        jm.c.p(r5, "zoneId");
        jm.c.p(r10, "aliasMap");
        String r11 = r10.get(r5);
        if (r11 == null) goto L6;
        r5 = r11;
    L6:
        return of(r5);
    }

    public static ZoneId ofOffset(String r5, ZoneOffset r10) {
        jm.c.p(r5, "prefix");
        jm.c.p(r10, "offset");
        if (r5.length() != 0) goto L6;
        return r10;
    L6:
        if (r5.equals("GMT") == true) goto L15;
        if (r5.equals("UTC") == true) goto L15;
        if (r5.equals("UT") == true) goto L15;
        throw new IllegalArgumentException("Invalid prefix, must be GMT, UTC or UT: ".concat(r5));
    L15:
        if (r10.getTotalSeconds() == 0) goto L17;
        StringBuilder r11 = j0.u(r5);
        r11.append(r10.getId());
        return new ZoneRegion(r11.toString(), r10.getRules());
    L17:
        return new ZoneRegion(r5, r10.getRules());
    }

    public static ZoneId systemDefault() {
        return of(TimeZone.getDefault().getID(), SHORT_IDS);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ZoneId) == true) goto L8;
        return false;
    L8:
        return getId().equals(((ZoneId) r5).getId());
    }

    public String getDisplayName(TextStyle r5, Locale r10) {
        s r11 = new s();
        r11.b(new r(r5));
        return r11.q(r10).a(new m(this, 0));
    }

    public abstract String getId();

    public abstract org.threeten.bp.zone.d getRules();

    public int hashCode() {
        return getId().hashCode();
    }

    public ZoneId normalized() {
        org.threeten.bp.zone.d r5 = getRules();     // Catch: ZoneRulesException -> L6
        if (r5.isFixedOffset() == false) goto L9;
        return r5.getOffset(Instant.EPOCH);
    L9:
        return this;
    L10:
        return this;
    }

    public String toString() {
        return getId();
    }

    public abstract void write(DataOutput r5) throws IOException;

    public static ZoneId of(String r5) {
        jm.c.p(r5, "zoneId");
        if (r5.equals("Z") == false) goto L7;
        return ZoneOffset.UTC;
    L7:
        if (r5.length() == 1) goto L53;
        if (r5.startsWith("+") == true) goto L51;
        if (r5.startsWith(DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD) == true) goto L51;
        if (r5.equals("UTC") == true) goto L49;
        if (r5.equals("GMT") == true) goto L49;
        if (r5.equals("UT") == true) goto L49;
        if (r5.startsWith("UTC+") == false) goto L23;
    L42:
        ZoneOffset r10 = ZoneOffset.of(r5.substring(3));
        if (r10.getTotalSeconds() != 0) goto L47;
        return new ZoneRegion(r5.substring(0, 3), r10.getRules());
    L47:
        return new ZoneRegion(r5.substring(0, 3) + r10.getId(), r10.getRules());
    L23:
        if (r5.startsWith("GMT+") == true) goto L42;
        if (r5.startsWith("UTC-") == true) goto L42;
        if (r5.startsWith("GMT-") == true) goto L42;
        if (r5.startsWith("UT+") == false) goto L32;
    L36:
        ZoneOffset r11 = ZoneOffset.of(r5.substring(2));
        if (r11.getTotalSeconds() != 0) goto L41;
        return new ZoneRegion("UT", r11.getRules());
    L41:
        return new ZoneRegion("UT" + r11.getId(), r11.getRules());
    L32:
        if (r5.startsWith("UT-") == true) goto L36;
        return ZoneRegion.ofId(r5, true);
    L49:
        return new ZoneRegion(r5, ZoneOffset.UTC.getRules());
    L51:
        return ZoneOffset.of(r5);
    L53:
        throw new DateTimeException("Invalid zone: ".concat(r5));
    }
}
