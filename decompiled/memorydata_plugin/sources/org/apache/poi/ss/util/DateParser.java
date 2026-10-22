package org.apache.poi.ss.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.text.DateFormatSymbols;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.util.LocaleUtil;

/* JADX INFO: loaded from: classes7.dex */
public class DateParser {

    private static final enum Format extends Enum<Format> {
        private static final /* synthetic */ Format[] $VALUES = null;
        public static final Format DMY_DASHES = null;
        public static final Format MDY_SLASHES = null;
        public static final Format MD_DASHES = null;
        public static final Format MD_SLASHES = null;
        public static final Format YMD_DASHES = null;
        public static final Format YMD_SLASHES = null;
        private int dayIndex;
        private boolean hasYear;
        private int monthIndex;
        private Pattern pattern;
        private int yearIndex;

        static {
            Format r0 = new Format("YMD_DASHES", 0, "^(\\d{4})-(\\w+)-(\\d{1,2})( .*)?$", "ymd");
            YMD_DASHES = r0;
            Format r1 = new Format("DMY_DASHES", 1, "^(\\d{1,2})-(\\w+)-(\\d{4})( .*)?$", "dmy");
            DMY_DASHES = r1;
            Format r3 = new Format("MD_DASHES", 2, "^(\\w+)-(\\d{1,2})( .*)?$", "md");
            MD_DASHES = r3;
            Format r6 = new Format("MDY_SLASHES", 3, "^(\\w+)/(\\d{1,2})/(\\d{4})( .*)?$", "mdy");
            MDY_SLASHES = r6;
            Format r8 = new Format("YMD_SLASHES", 4, "^(\\d{4})/(\\w+)/(\\d{1,2})( .*)?$", "ymd");
            YMD_SLASHES = r8;
            Format r4 = new Format("MD_SLASHES", 5, "^(\\w+)/(\\d{1,2})( .*)?$", "md");
            MD_SLASHES = r4;
            $VALUES = new Format[]{r0, r1, r3, r6, r8, r4};
        }

        private Format(String r1, int r2, String r3, String r4) {
            super(r1, r2);
            this.pattern = Pattern.compile(r3);
            boolean r5 = r4.contains("y");
            this.hasYear = r5;
            if (r5 == false) goto L5;
            this.yearIndex = r4.indexOf("y");
        L5:
            this.monthIndex = r4.indexOf("m");
            this.dayIndex = r4.indexOf("d");
        }

        static /* synthetic */ Pattern access$000(Format r0) {
            return r0.pattern;
        }

        static /* synthetic */ boolean access$100(Format r0) {
            return r0.hasYear;
        }

        static /* synthetic */ int access$200(Format r0) {
            return r0.yearIndex;
        }

        static /* synthetic */ int access$300(Format r0) {
            return r0.monthIndex;
        }

        static /* synthetic */ int access$400(Format r0) {
            return r0.dayIndex;
        }

        public static Format valueOf(String r2) {
            return (Format) ZeusTransformUtils.preCheckCast(Enum.valueOf(Format.class, r2), Format.class, "com.obric.memorydata.plugin");
        }

        public static Format[] values() {
            return (Format[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Format[].class, "com.obric.memorydata.plugin");
        }
    }

    public static LocalDate parseLocalDate(String r6) {
        Format[] r0 = Format.values();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L21;
        Format r3 = r0[r2];
        Matcher r4 = Format.access$000(r3).matcher(r6);
        if (r4.find() == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        MatchResult r5 = r4.toMatchResult();
        ArrayList r7 = new ArrayList();
        int r8 = 1;
    L8:
        if (r8 > r5.groupCount()) goto L11;
        r7.add(r5.group(r8));
        r8 = r8 + 1;
        goto L8
    L11:
        if (Format.access$100(r3) == false) goto L13;
        int r9 = Integer.parseInt((String) ZeusTransformUtils.preCheckCast(r7.get(Format.access$200(r3)), String.class, "com.obric.memorydata.plugin"));
    L22:
        return LocalDate.of(r9, parseMonth((String) ZeusTransformUtils.preCheckCast(r7.get(Format.access$300(r3)), String.class, "com.obric.memorydata.plugin")), Integer.parseInt((String) ZeusTransformUtils.preCheckCast(r7.get(Format.access$400(r3)), String.class, "com.obric.memorydata.plugin")));
    L18:
        throw new DateTimeException("Failed to parse date-string " + r6);
    L13:
        r9 = LocalDate.now(LocaleUtil.getUserTimeZone().toZoneId()).getYear();
        goto L22
    L21:
        throw new EvaluationException(ErrorEval.VALUE_INVALID);
    }

    private static int parseMonth(String r4) {
        return Integer.parseInt(r4);
    L4:
        String[] r0 = DateFormatSymbols.getInstance(LocaleUtil.getUserLocale()).getMonths();
        int r1 = 0;
    L6:
        if (r1 >= r0.length) goto L10;
        boolean r2 = r0[r1].toLowerCase(LocaleUtil.getUserLocale()).startsWith(r4.toLowerCase(LocaleUtil.getUserLocale()));
        r1 = r1 + 1;
        if (r2 == false) goto L6;
        return r1;
    L10:
        return -1;
    }
}
