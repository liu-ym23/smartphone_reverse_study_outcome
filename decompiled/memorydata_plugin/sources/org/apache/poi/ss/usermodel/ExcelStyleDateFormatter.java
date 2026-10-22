package org.apache.poi.ss.usermodel;

import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.RoundingMode;
import java.text.DateFormatSymbols;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.FieldPosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.apache.poi.util.LocaleUtil;

/* JADX INFO: loaded from: classes7.dex */
public class ExcelStyleDateFormatter extends SimpleDateFormat {
    public static final char HH_BRACKET_SYMBOL = 57361;
    public static final char H_BRACKET_SYMBOL = 57360;
    public static final char LL_BRACKET_SYMBOL = 57367;
    public static final char L_BRACKET_SYMBOL = 57366;
    public static final char MMMMM_START_SYMBOL = 57345;
    public static final char MMMMM_TRUNCATE_SYMBOL = 57346;
    public static final char MM_BRACKET_SYMBOL = 57363;
    public static final char M_BRACKET_SYMBOL = 57362;
    public static final char SS_BRACKET_SYMBOL = 57365;
    public static final char S_BRACKET_SYMBOL = 57364;
    private static final DecimalFormat format1digit = null;
    private static final DecimalFormat format2digits = null;
    private static final DecimalFormat format3digit = null;
    private static final DecimalFormat format4digits = null;
    private double dateToBeFormatted;

    static {
        DecimalFormatSymbols r0 = DecimalFormatSymbols.getInstance(Locale.ROOT);
        DecimalFormat r1 = new DecimalFormat("0", r0);
        format1digit = r1;
        DecimalFormat r3 = new DecimalFormat("00", r0);
        format2digits = r3;
        DecimalFormat r5 = new DecimalFormat("0", r0);
        format3digit = r5;
        DecimalFormat r2 = new DecimalFormat("00", r0);
        format4digits = r2;
        DataFormatter.setExcelStyleRoundingMode(r1, RoundingMode.DOWN);
        DataFormatter.setExcelStyleRoundingMode(r3, RoundingMode.DOWN);
        DataFormatter.setExcelStyleRoundingMode(r5);
        DataFormatter.setExcelStyleRoundingMode(r2);
    }

    public ExcelStyleDateFormatter(String r2) {
        super(processFormatPattern(r2), LocaleUtil.getUserLocale());
        setTimeZone(LocaleUtil.getUserTimeZone());
    }

    public ExcelStyleDateFormatter(String r1, DateFormatSymbols r2) {
        super(processFormatPattern(r1), r2);
        setTimeZone(LocaleUtil.getUserTimeZone());
    }

    public ExcelStyleDateFormatter(String r1, Locale r2) {
        super(processFormatPattern(r1), r2);
        setTimeZone(LocaleUtil.getUserTimeZone());
    }

    private static String processFormatPattern(String r2) {
        return r2.replace("MMMMM", "\ue001MMM\ue002").replace("[H]", String.valueOf(H_BRACKET_SYMBOL)).replace("[HH]", String.valueOf(HH_BRACKET_SYMBOL)).replace("[m]", String.valueOf(M_BRACKET_SYMBOL)).replace("[mm]", String.valueOf(MM_BRACKET_SYMBOL)).replace("[s]", String.valueOf(S_BRACKET_SYMBOL)).replace("[ss]", String.valueOf(SS_BRACKET_SYMBOL)).replace(ExifInterface.GPS_DIRECTION_TRUE, "'T'").replace("''T''", "'T'").replaceAll("s.000", "s.SSS").replaceAll("s.00", "s.\ue017").replaceAll("s.0", "s.\ue016");
    }

    @Override // java.text.SimpleDateFormat, java.text.DateFormat
    public boolean equals(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, ExcelStyleDateFormatter.class) == true) goto L5;
        return false;
    L5:
        ExcelStyleDateFormatter r5 = (ExcelStyleDateFormatter) ZeusTransformUtils.preCheckCast(r4, ExcelStyleDateFormatter.class, "com.obric.memorydata.plugin");
        if (this.dateToBeFormatted != r5.dateToBeFormatted) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // java.text.SimpleDateFormat, java.text.DateFormat
    public StringBuffer format(Date r11, StringBuffer r12, FieldPosition r13) {
        String r14 = super.format(r11, r12, r13).toString();
        if (r14.indexOf(57345) == (-1)) goto L6;
        r14 = r14.replaceAll("\ue001(\\p{L}|\\p{P})[\\p{L}\\p{P}]+\ue002", "$1");
    L6:
        if (r14.indexOf(57360) == (-1)) goto L8;
    L9:
        double r4 = ((float) this.dateToBeFormatted) * 24.0f;
        r14 = r14.replaceAll(String.valueOf(H_BRACKET_SYMBOL), format1digit.format(r4)).replaceAll(String.valueOf(HH_BRACKET_SYMBOL), format2digits.format(r4));
    L11:
        if (r14.indexOf(57362) == (-1)) goto L13;
    L14:
        double r3 = (((float) this.dateToBeFormatted) * 24.0f) * 60.0f;
        r14 = r14.replaceAll(String.valueOf(M_BRACKET_SYMBOL), format1digit.format(r3)).replaceAll(String.valueOf(MM_BRACKET_SYMBOL), format2digits.format(r3));
    L16:
        if (r14.indexOf(57364) == (-1)) goto L18;
    L19:
        double r7 = (float) (((this.dateToBeFormatted * 24.0d) * 60.0d) * 60.0d);
        r14 = r14.replaceAll(String.valueOf(S_BRACKET_SYMBOL), format1digit.format(r7)).replaceAll(String.valueOf(SS_BRACKET_SYMBOL), format2digits.format(r7));
    L21:
        if (r14.indexOf(57366) == (-1)) goto L23;
    L24:
        double r6 = this.dateToBeFormatted;
        float r10 = (float) ((((r6 - Math.floor(r6)) * 24.0d) * 60.0d) * 60.0d);
        double r2 = r10 - ((int) r10);
        r14 = r14.replaceAll(String.valueOf(L_BRACKET_SYMBOL), format3digit.format(10.0d * r2)).replaceAll(String.valueOf(LL_BRACKET_SYMBOL), format4digits.format(r2 * 100.0d));
    L26:
        return new StringBuffer(r14);
    L23:
        if (r14.indexOf(57367) == (-1)) goto L26;
    L18:
        if (r14.indexOf(57365) == (-1)) goto L21;
    L13:
        if (r14.indexOf(57363) == (-1)) goto L16;
    L8:
        if (r14.indexOf(57361) == (-1)) goto L11;
        goto L9
    }

    @Override // java.text.SimpleDateFormat, java.text.DateFormat
    public int hashCode() {
        return Double.valueOf(this.dateToBeFormatted).hashCode();
    }

    public void setDateToBeFormatted(double r1) {
        this.dateToBeFormatted = r1;
    }
}
