package org.threeten.bp;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.DataOutput;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import org.slf4j.Marker;
import org.threeten.bp.format.DateTimeFormatterBuilder;
import org.threeten.bp.format.TextStyle;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.zone.ZoneRules;
import org.threeten.bp.zone.ZoneRulesException;
import org.threeten.bp.zone.ZoneRulesProvider;

/* JADX INFO: loaded from: classes8.dex */
public abstract class ZoneId implements Serializable {
    public static final TemporalQuery<ZoneId> FROM = null;
    public static final Map<String, String> SHORT_IDS = null;
    private static final long serialVersionUID = 8352817235686L;

    static {
        FROM = new AnonymousClass1();
        HashMap r0 = new HashMap();
        r0.put("ACT", "Australia/Darwin");
        r0.put("AET", "Australia/Sydney");
        r0.put("AGT", "America/Argentina/Buenos_Aires");
        r0.put("ART", "Africa/Cairo");
        r0.put("AST", "America/Anchorage");
        r0.put("BET", "America/Sao_Paulo");
        r0.put("BST", "Asia/Dhaka");
        r0.put("CAT", "Africa/Harare");
        r0.put("CNT", "America/St_Johns");
        r0.put("CST", "America/Chicago");
        r0.put("CTT", "Asia/Shanghai");
        r0.put("EAT", "Africa/Addis_Ababa");
        r0.put("ECT", "Europe/Paris");
        r0.put("IET", "America/Indiana/Indianapolis");
        r0.put("IST", "Asia/Kolkata");
        r0.put("JST", "Asia/Tokyo");
        r0.put("MIT", "Pacific/Apia");
        r0.put("NET", "Asia/Yerevan");
        r0.put("NST", "Pacific/Auckland");
        r0.put("PLT", "Asia/Karachi");
        r0.put("PNT", "America/Phoenix");
        r0.put("PRT", "America/Puerto_Rico");
        r0.put("PST", "America/Los_Angeles");
        r0.put("SST", "Pacific/Guadalcanal");
        r0.put("VST", "Asia/Ho_Chi_Minh");
        r0.put("EST", "-05:00");
        r0.put("MST", "-07:00");
        r0.put("HST", "-10:00");
        SHORT_IDS = Collections.unmodifiableMap(r0);
    }

    ZoneId() {
        if (getClass() != ZoneOffset.class) goto L5;
        return;
    L5:
        if (getClass() != ZoneRegion.class) goto L8;
        return;
    L8:
        throw new AssertionError("Invalid subclass");
    }

    public static ZoneId from(TemporalAccessor r3) {
        TemporalAccessor r4 = (TemporalAccessor) ZeusTransformUtils.wrapperContextForParams(r3, TemporalAccessor.class, "com.obric.memorydata.plugin");
        ZoneId r0 = (ZoneId) ZeusTransformUtils.preCheckCast(r4.query(TemporalQueries.zone()), ZoneId.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new DateTimeException("Unable to obtain ZoneId from TemporalAccessor: " + r4 + ", type " + r4.getClass().getName());
    }

    public static Set<String> getAvailableZoneIds() {
        return new HashSet(ZoneRulesProvider.getAvailableZoneIds());
    }

    public static ZoneId of(String r5) {
        Jdk8Methods.requireNonNull(r5, "zoneId");
        if (r5.equals("Z") == false) goto L7;
        return ZoneOffset.UTC;
    L7:
        if (r5.length() == 1) goto L53;
        if (r5.startsWith(Marker.ANY_NON_NULL_MARKER) == true) goto L51;
        if (r5.startsWith("-") == true) goto L51;
        if (r5.equals("UTC") == true) goto L49;
        if (r5.equals("GMT") == true) goto L49;
        if (r5.equals("UT") == true) goto L49;
        if (r5.startsWith("UTC+") == false) goto L23;
    L42:
        ZoneOffset r1 = ZoneOffset.of(r5.substring(3));
        if (r1.getTotalSeconds() != 0) goto L47;
        return new ZoneRegion(r5.substring(0, 3), r1.getRules());
    L47:
        return new ZoneRegion(r5.substring(0, 3) + r1.getId(), r1.getRules());
    L23:
        if (r5.startsWith("GMT+") == true) goto L42;
        if (r5.startsWith("UTC-") == true) goto L42;
        if (r5.startsWith("GMT-") == true) goto L42;
        if (r5.startsWith("UT+") == false) goto L32;
    L36:
        ZoneOffset r6 = ZoneOffset.of(r5.substring(2));
        if (r6.getTotalSeconds() != 0) goto L41;
        return new ZoneRegion("UT", r6.getRules());
    L41:
        return new ZoneRegion("UT" + r6.getId(), r6.getRules());
    L32:
        if (r5.startsWith("UT-") == true) goto L36;
        return ZoneRegion.ofId(r5, true);
    L49:
        return new ZoneRegion(r5, ZoneOffset.UTC.getRules());
    L51:
        return ZoneOffset.of(r5);
    L53:
        throw new DateTimeException("Invalid zone: " + r5);
    }

    public static ZoneId of(String r2, Map<String, String> r3) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        Jdk8Methods.requireNonNull(r2, "zoneId");
        Jdk8Methods.requireNonNull(r4, "aliasMap");
        String r5 = (String) ZeusTransformUtils.preCheckCast(r4.get(r2), String.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L6;
        r2 = r5;
    L6:
        return of(r2);
    }

    public static ZoneId ofOffset(String r2, ZoneOffset r3) {
        Jdk8Methods.requireNonNull(r2, "prefix");
        Jdk8Methods.requireNonNull(r3, TypedValues.CycleType.S_WAVE_OFFSET);
        if (r2.length() != 0) goto L6;
        return r3;
    L6:
        if (r2.equals("GMT") == true) goto L15;
        if (r2.equals("UTC") == true) goto L15;
        if (r2.equals("UT") == true) goto L15;
        throw new IllegalArgumentException("Invalid prefix, must be GMT, UTC or UT: " + r2);
    L15:
        if (r3.getTotalSeconds() != 0) goto L19;
        return new ZoneRegion(r2, r3.getRules());
    L19:
        return new ZoneRegion(r2 + r3.getId(), r3.getRules());
    }

    public static ZoneId systemDefault() {
        return of(TimeZone.getDefault().getID(), SHORT_IDS);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L7;
        return true;
    L7:
        if (ZeusTransformUtils.instanceOf(r3, ZoneId.class) == false) goto L10;
        ZoneId r4 = (ZoneId) ZeusTransformUtils.preCheckCast(r3, ZoneId.class, "com.obric.memorydata.plugin");
        return getId().equals(r4.getId());
    L10:
        return false;
    }

    public String getDisplayName(TextStyle r2, Locale r3) {
        return new DateTimeFormatterBuilder().appendZoneText(r2).toFormatter(r3).format(new AnonymousClass2(this));
    }

    public abstract String getId();

    public abstract ZoneRules getRules();

    public int hashCode() {
        return getId().hashCode();
    }

    public ZoneId normalized() {
        ZoneRules r0 = getRules();     // Catch: ZoneRulesException -> L6
        if (r0.isFixedOffset() == false) goto L9;
        return r0.getOffset(Instant.EPOCH);
    L9:
        return this;
    L10:
        return this;
    }

    public String toString() {
        return getId();
    }

    abstract void write(DataOutput r1);
}
