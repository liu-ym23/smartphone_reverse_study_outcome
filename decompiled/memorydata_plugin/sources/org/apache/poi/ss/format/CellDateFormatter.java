package org.apache.poi.ss.format;

import com.bytedance.apm.util.f;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.text.AttributedCharacterIterator;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;
import java.util.Locale;
import java.util.regex.Matcher;
import org.apache.poi.util.LocaleUtil;
import org.apache.poi.util.StringUtil;

/* JADX INFO: loaded from: classes7.dex */
public class CellDateFormatter extends CellFormatter {
    private static final Calendar EXCEL_EPOCH_CAL = null;
    private static CellDateFormatter SIMPLE_DATE_FORMATTER;
    private boolean amPmUpper;
    private final DateFormat dateFmt;
    private String sFmt;
    private boolean showAmPm;
    private boolean showM;

    class DatePartHandler implements CellFormatPart.PartHandler {
        private int hLen;
        private int hStart;
        private int mLen;
        private int mStart;
        final /* synthetic */ CellDateFormatter this$0;

        DatePartHandler(CellDateFormatter r1) {
            this.this$0 = r1;
            this.mStart = -1;
            this.hStart = -1;
        }

        public void finish(StringBuffer r4) {
            if (this.hStart >= 0) goto L5;
            return;
        L5:
            if (CellDateFormatter.access$100(this.this$0) == true) goto L12;
            int r0 = 0;
        L8:
            if (r0 >= this.hLen) goto L13;
            r4.setCharAt(this.hStart + r0, 'H');
            r0 = r0 + 1;
            goto L8
        L13:
            return;
        }

        @Override // org.apache.poi.ss.format.CellFormatPart.PartHandler
        public String handlePart(Matcher r4, String r5, CellFormatType r6, StringBuffer r7) {
            int r8 = r7.length();
            boolean r9 = false;
            int r10 = 0;
            switch(r5.charAt(0)) {
                case 48: goto L44;
                case 65: goto L36;
                case 68: goto L29;
                case 72: goto L27;
                case 77: goto L21;
                case 80: goto L36;
                case 83: goto L14;
                case 89: goto L5;
                case 97: goto L36;
                case 100: goto L29;
                case 104: goto L27;
                case 109: goto L21;
                case 112: goto L36;
                case 115: goto L14;
                case 121: goto L5;
                default: goto L49;
            };
        L5:
            this.mStart = -1;
            if (r5.length() != 1) goto L9;
            r5 = "yy";
        L12:
            return r5.toLowerCase(Locale.ROOT);
        L9:
            if (r5.length() != 3) goto L12;
            r5 = "yyyy";
            goto L12
        L21:
            this.mStart = r8;
            this.mLen = r5.length();
            if (this.hStart < 0) goto L26;
            return r5.toLowerCase(Locale.ROOT);
        L26:
            return r5.toUpperCase(Locale.ROOT);
        L27:
            this.mStart = -1;
            this.hStart = r8;
            this.hLen = r5.length();
            return r5.toLowerCase(Locale.ROOT);
        L29:
            this.mStart = -1;
            if (r5.length() > 2) goto L34;
            return r5.toLowerCase(Locale.ROOT);
        L34:
            return r5.toLowerCase(Locale.ROOT).replace('d', 'E');
        L44:
            this.mStart = -1;
            int r11 = r5.length();
            CellDateFormatter.access$002(this.this$0, "%0" + (r11 + 2) + "." + r11 + f.f1488a);
            return r5.replace('0', 'S');
        L49:
            return null;
        L14:
            if (this.mStart < 0) goto L20;
        L16:
            if (r10 >= this.mLen) goto L18;
            r7.setCharAt(this.mStart + r10, 'm');
            r10 = r10 + 1;
            goto L16
        L18:
            this.mStart = -1;
        L20:
            return r5.toLowerCase(Locale.ROOT);
        L36:
            if (r5.length() <= 1) goto L46;
            this.mStart = -1;
            CellDateFormatter.access$102(this.this$0, true);
            CellDateFormatter.access$202(this.this$0, StringUtil.toLowerCase(r5.charAt(1)).equals("m"));
            CellDateFormatter r3 = this.this$0;
            if (CellDateFormatter.access$200(r3) == false) goto L40;
        L41:
            r9 = true;
        L42:
            CellDateFormatter.access$302(r3, r9);
            return "a";
        L40:
            if (StringUtil.isUpperCase(r5.charAt(0)) == false) goto L42;
        L46:
            return null;
        }

        public void updatePositions(int r2, int r3) {
            int r0 = this.hStart;
            if (r2 >= r0) goto L5;
            this.hStart = r0 + r3;
        L5:
            int r1 = this.mStart;
            if (r2 >= r1) goto L9;
            this.mStart = r1 + r3;
            return;
        }
    }

    static {
        EXCEL_EPOCH_CAL = LocaleUtil.getLocaleCalendar(1904, 0, 1);
    }

    public CellDateFormatter(String r2) {
        this(LocaleUtil.getUserLocale(), r2);
    }

    public CellDateFormatter(Locale r3, String r4) {
        super(r4);
        DatePartHandler r0 = new DatePartHandler(this);
        StringBuffer r5 = CellFormatPart.parseFormat(r4, CellFormatType.DATE, r0);
        r0.finish(r5);
        SimpleDateFormat r1 = new SimpleDateFormat(r5.toString(), r3);
        this.dateFmt = r1;
        r1.setTimeZone(LocaleUtil.getUserTimeZone());
    }

    static /* synthetic */ String access$002(CellDateFormatter r0, String r1) {
        r0.sFmt = r1;
        return r1;
    }

    static /* synthetic */ boolean access$100(CellDateFormatter r0) {
        return r0.showAmPm;
    }

    static /* synthetic */ boolean access$102(CellDateFormatter r0, boolean r1) {
        r0.showAmPm = r1;
        return r1;
    }

    static /* synthetic */ boolean access$200(CellDateFormatter r0) {
        return r0.showM;
    }

    static /* synthetic */ boolean access$202(CellDateFormatter r0, boolean r1) {
        r0.showM = r1;
        return r1;
    }

    static /* synthetic */ boolean access$302(CellDateFormatter r0, boolean r1) {
        r0.amPmUpper = r1;
        return r1;
    }

    @Override // org.apache.poi.ss.format.CellFormatter
    public synchronized void formatValue(StringBuffer r19, Object r20) {
        monitor-enter(this);
        if (r20 == null) goto L67;
        Object r4 = r20;
    L9:
        if (ZeusTransformUtils.instanceOf(r4, Number.class) == false) goto L19;
        double r5 = Math.round(((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.memorydata.plugin")).doubleValue() * 8.64E7d);     // Catch: Throwable -> L62
        if (r5 != 0.0d) goto L14;
        Calendar r2 = EXCEL_EPOCH_CAL;     // Catch: Throwable -> L62
    L13:
        r4 = r2.getTime();     // Catch: Throwable -> L62
        goto L19
    L14:
        r2 = (Calendar) ZeusTransformUtils.preCheckCast(EXCEL_EPOCH_CAL.clone(), Calendar.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L62
        if (this.sFmt != null) goto L17;
        double r8 = Math.round(r5 / 1000.0d);     // Catch: Throwable -> L62
    L18:
        r2.add(13, (int) r8);     // Catch: Throwable -> L62
        r2.add(14, (int) (r5 % 1000.0d));     // Catch: Throwable -> L62
        goto L13
    L17:
        r8 = r5 / 1000.0d;     // Catch: Throwable -> L62
    L19:
        AttributedCharacterIterator r3 = this.dateFmt.formatToCharacterIterator(r4);     // Catch: Throwable -> L62
        char r6 = r3.first();     // Catch: Throwable -> L62
        boolean r9 = false;
        boolean r10 = false;
    L21:
        if (r6 == 65535) goto L60;
        if (r3.getAttribute(DateFormat.Field.MILLISECOND) == null) goto L44;
        if (r9 == true) goto L58;
        Date r7 = (Date) ZeusTransformUtils.preCheckCast(r4, Date.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L62
        int r11 = r19.length();     // Catch: Throwable -> L62
        Formatter r12 = new Formatter(r19, Locale.ROOT);     // Catch: Throwable -> L62
        long r13 = r7.getTime() % 1000;     // Catch: Throwable -> L32
        if (r13 >= 0) goto L29;
        r13 = r13 + 1000;     // Catch: Throwable -> L32
    L29:
        r12.format(this.locale, this.sFmt, new Object[]{Double.valueOf(r13 / 1000.0d)});     // Catch: Throwable -> L32
        r12.close();     // Catch: Throwable -> L62
        r19.delete(r11, r11 + 2);     // Catch: Throwable -> L62
        r9 = true;
        goto L58
    L32:
        th = move-exception;
        throw th;     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        r12.close();     // Catch: Throwable -> L39
    L78:
        throw th;     // Catch: Throwable -> L62
    L39:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L62
        throw th;     // Catch: Throwable -> L62
    L62:
        th = move-exception;
        throw th;
    L58:
        r6 = r3.next();     // Catch: Throwable -> L62
        goto L21
    L44:
        if (r3.getAttribute(DateFormat.Field.AM_PM) == null) goto L57;
        if (r10 == true) goto L58;
        if (this.showAmPm == true) goto L49;
    L56:
        r10 = true;
        goto L58
    L49:
        if (this.amPmUpper == false) goto L53;
        r19.append(StringUtil.toUpperCase(r6));     // Catch: Throwable -> L62
        if (this.showM == false) goto L56;
        r19.append('M');     // Catch: Throwable -> L62
        goto L56
    L53:
        r19.append(StringUtil.toLowerCase(r6));     // Catch: Throwable -> L62
        if (this.showM == false) goto L56;
        r19.append('m');     // Catch: Throwable -> L62
        goto L56
    L57:
        r19.append(r6);     // Catch: Throwable -> L62
        goto L58
    L60:
        monitor-exit(this);
        return;
    L67:
        r4 = Double.valueOf(0.0d);     // Catch: Throwable -> L62
        goto L9
    }

    @Override // org.apache.poi.ss.format.CellFormatter
    public void simpleValue(StringBuffer r3, Object r4) {
        CellDateFormatter r2 = SIMPLE_DATE_FORMATTER;
        if (r2 == null) goto L5;
    L14:
        r2.formatValue(r3, r4);
        return;
    L5:
        monitor-enter(CellDateFormatter.class);
        r2 = SIMPLE_DATE_FORMATTER;     // Catch: Throwable -> L11
        if (r2 != null) goto L9;
        r2 = new CellDateFormatter("mm/d/y");     // Catch: Throwable -> L11
        SIMPLE_DATE_FORMATTER = r2;     // Catch: Throwable -> L11
    L9:
        monitor-exit(CellDateFormatter.class);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }
}
