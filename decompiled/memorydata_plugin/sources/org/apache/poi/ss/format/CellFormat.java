package org.apache.poi.ss.format;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.poi.ss.usermodel.DateUtil;

/* JADX INFO: loaded from: classes7.dex */
public class CellFormat {
    private static final c LOG = null;
    private static final Pattern ONE_PART = null;
    private static final Map<Locale, Map<String, CellFormat>> formatCache = null;
    private final String format;
    private final int formatPartCount;
    private final Locale locale;
    private final CellFormatPart negNumFmt;
    private final CellFormatPart posNumFmt;
    private final CellFormatPart textFmt;
    private final CellFormatPart zeroNumFmt;

    static {
        LOG = b.a(CellFormat.class);
        ONE_PART = Pattern.compile(CellFormatPart.FORMAT_PAT.pattern() + "(;|$)", 6);
        formatCache = new WeakHashMap();
    }

    private CellFormat(Locale r9, String r10) {
        this.locale = r9;
        this.format = r10;
        CellFormatPart r0 = new CellFormatPart(r9, "@");
        Matcher r11 = ONE_PART.matcher(r10);
        ArrayList r1 = new ArrayList();
    L4:
        if (r11.find() == false) goto L12;
        String r2 = r11.group();     // Catch: RuntimeException -> L10
        if (r2.endsWith(";") == false) goto L8;
        r2 = r2.substring(0, r2.length() - 1);     // Catch: RuntimeException -> L10
    L8:
        r1.add(new CellFormatPart(r9, r2));     // Catch: RuntimeException -> L10
    L10:
        e = move-exception;
        LOG.log(Level.WARN, "Invalid format: " + CellFormatter.quote(r11.group()), e);
        r1.add(null);
        goto L4
    L12:
        int r12 = r1.size();
        this.formatPartCount = r12;
        if (r12 != 1) goto L15;
        this.posNumFmt = (CellFormatPart) ZeusTransformUtils.preCheckCast(r1.get(0), CellFormatPart.class, "com.obric.memorydata.plugin");
        this.negNumFmt = null;
    L22:
        this.zeroNumFmt = null;
    L23:
        this.textFmt = r0;
        return;
    L15:
        if (r12 != 2) goto L17;
        this.posNumFmt = (CellFormatPart) ZeusTransformUtils.preCheckCast(r1.get(0), CellFormatPart.class, "com.obric.memorydata.plugin");
        this.negNumFmt = (CellFormatPart) ZeusTransformUtils.preCheckCast(r1.get(1), CellFormatPart.class, "com.obric.memorydata.plugin");
        goto L22
    L17:
        if (r12 == 3) goto L19;
        this.posNumFmt = (CellFormatPart) ZeusTransformUtils.preCheckCast(r1.get(0), CellFormatPart.class, "com.obric.memorydata.plugin");
        this.negNumFmt = (CellFormatPart) ZeusTransformUtils.preCheckCast(r1.get(1), CellFormatPart.class, "com.obric.memorydata.plugin");
        this.zeroNumFmt = (CellFormatPart) ZeusTransformUtils.preCheckCast(r1.get(2), CellFormatPart.class, "com.obric.memorydata.plugin");
        this.textFmt = (CellFormatPart) ZeusTransformUtils.preCheckCast(r1.get(3), CellFormatPart.class, "com.obric.memorydata.plugin");
        return;
    L19:
        this.posNumFmt = (CellFormatPart) ZeusTransformUtils.preCheckCast(r1.get(0), CellFormatPart.class, "com.obric.memorydata.plugin");
        this.negNumFmt = (CellFormatPart) ZeusTransformUtils.preCheckCast(r1.get(1), CellFormatPart.class, "com.obric.memorydata.plugin");
        this.zeroNumFmt = (CellFormatPart) ZeusTransformUtils.preCheckCast(r1.get(2), CellFormatPart.class, "com.obric.memorydata.plugin");
        goto L23
    }

    /* synthetic */ CellFormat(Locale r1, String r2, AnonymousClass1 r3) {
        this(r1, r2);
    }

    private static CellFormat createGeneralFormat(final Locale r2) {
        final String r1 = "General";
        return new AnonymousClass1(r2, r1, r2);
    }

    private CellFormatPart getApplicableFormatPart(Object r6) {
        if (ZeusTransformUtils.instanceOf(r6, Number.class) == false) goto L63;
        double r0 = ((Number) ZeusTransformUtils.preCheckCast(r6, Number.class, "com.obric.memorydata.plugin")).doubleValue();
        int r7 = this.formatPartCount;
        if (r7 != 1) goto L18;
        if (this.posNumFmt.hasCondition() == false) goto L16;
        if (this.posNumFmt.hasCondition() == false) goto L14;
        if (this.posNumFmt.applies(Double.valueOf(r0)) == true) goto L16;
    L14:
        return new CellFormatPart(this.locale, "General");
    L16:
        return this.posNumFmt;
    L18:
        if (r7 != 2) goto L41;
        if (this.posNumFmt.hasCondition() == true) goto L24;
        if (r0 < 0.0d) goto L24;
    L28:
        return this.posNumFmt;
    L24:
        if (this.posNumFmt.hasCondition() == false) goto L30;
        if (this.posNumFmt.applies(Double.valueOf(r0)) == true) goto L28;
    L30:
        if (this.negNumFmt.hasCondition() == false) goto L39;
        if (this.negNumFmt.hasCondition() == false) goto L37;
        if (this.negNumFmt.applies(Double.valueOf(r0)) == true) goto L39;
    L37:
        return new CellFormatPart("\"###############################################################################################################################################################################################################################################################\"");
    L39:
        return this.negNumFmt;
    L41:
        if (this.posNumFmt.hasCondition() == true) goto L45;
        if (r0 <= 0.0d) goto L45;
    L49:
        return this.posNumFmt;
    L45:
        if (this.posNumFmt.hasCondition() == false) goto L51;
        if (this.posNumFmt.applies(Double.valueOf(r0)) == true) goto L49;
    L51:
        if (this.negNumFmt.hasCondition() == true) goto L55;
        if (r0 >= 0.0d) goto L55;
    L59:
        return this.negNumFmt;
    L55:
        if (this.negNumFmt.hasCondition() == false) goto L61;
        if (this.negNumFmt.applies(Double.valueOf(r0)) == true) goto L59;
    L61:
        return this.zeroNumFmt;
    L63:
        throw new IllegalArgumentException("value must be a Number");
    }

    public static synchronized CellFormat getInstance(Locale r4, String r5) {
        monitor-enter(CellFormat.class);
        Map r1 = (Map) ZeusTransformUtils.preCheckCast(formatCache.computeIfAbsent(r4, $$Lambda$CellFormat$3v1RXRe9RleceTBtfGb3Zx8Zg.INSTANCE), Map.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        CellFormat r2 = (CellFormat) ZeusTransformUtils.preCheckCast(r1.get(r5), CellFormat.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        if (r2 == null) goto L7;
    L14:
        monitor-exit(CellFormat.class);
        return r2;
    L7:
        if (r5.equals("General") == false) goto L9;
    L12:
        r2 = createGeneralFormat(r4);     // Catch: Throwable -> L16
    L13:
        r1.put(r5, r2);     // Catch: Throwable -> L16
        goto L14
    L9:
        if (r5.equals("@") == true) goto L12;
        r2 = new CellFormat(r4, r5);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    }

    static /* synthetic */ Map lambda$getInstance$0(Locale r0) {
        return new WeakHashMap();
    }

    public CellFormatResult apply(Object r5) {
        if (ZeusTransformUtils.instanceOf(r5, Number.class) == false) goto L26;
        double r0 = ((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.memorydata.plugin")).doubleValue();
        if (r0 < 0.0d) goto L7;
    L24:
        CellFormatPart r4 = getApplicableFormatPart(Double.valueOf(r0));
    L21:
        r5 = Double.valueOf(r0);
    L23:
        return r4.apply(r5);
    L7:
        if (this.formatPartCount != 2) goto L13;
        if (this.posNumFmt.hasCondition() == true) goto L13;
        if (this.negNumFmt.hasCondition() == true) goto L13;
    L20:
        r4 = this.negNumFmt;
        r0 = -r0;
    L13:
        if (this.formatPartCount != 3) goto L17;
        if (this.negNumFmt.hasCondition() == false) goto L20;
    L17:
        if (this.formatPartCount != 4) goto L24;
        if (this.negNumFmt.hasCondition() == true) goto L24;
    L26:
        if (ZeusTransformUtils.instanceOf(r5, Date.class) == false) goto L32;
        double r1 = DateUtil.getExcelDate((Date) ZeusTransformUtils.preCheckCast(r5, Date.class, "com.obric.memorydata.plugin"));
        if (DateUtil.isValidExcelDate(r1) == false) goto L31;
        r4 = getApplicableFormatPart(Double.valueOf(r1));
        goto L23
    L31:
        throw new IllegalArgumentException("value " + r1 + " of date " + r5 + " is not a valid Excel date");
    L32:
        r4 = this.textFmt;
        goto L23
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L7;
        return true;
    L7:
        if (ZeusTransformUtils.instanceOf(r3, CellFormat.class) == false) goto L10;
        CellFormat r4 = (CellFormat) ZeusTransformUtils.preCheckCast(r3, CellFormat.class, "com.obric.memorydata.plugin");
        return this.format.equals(r4.format);
    L10:
        return false;
    }

    public int hashCode() {
        return this.format.hashCode();
    }
}
