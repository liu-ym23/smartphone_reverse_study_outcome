package m;

import android.util.Log;
import androidx.room.writer.DaoWriter;
import com.google.android.material.timepicker.TimeModel;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public abstract class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f19878a = null;

    static {
        f19878a = "Mi_R_".concat(g.class.getSimpleName());
    }

    public static long a(String r5) {
        String r10 = f19878a;
        if (r5 != null) goto L5;
    L17:
        Log.e(r10, "the time is null, checkout !!!");
        return 0;
    L5:
        if (r5.isEmpty() == true) goto L17;
        String r11 = r5.trim();
        Calendar r12 = Calendar.getInstance();
        if (r11.length() != 5) goto L10;
    L11:
        r11 = r12.get(1) + DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD + r11;
        Log.e(r10, "convertToMillis. add Year!!!");
    L13:
        if (r11.length() != 10) goto L16;
        r11 = r11.concat(" 00:00");
        Log.e(r10, "convertToMillis. add Time!!!");
    L16:
        return new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(r11).getTime();
    L10:
        if (r11.length() != 11) goto L13;
        goto L11
    }

    public static String b(String r5) {
        if (r5 != null) goto L4;
        return "";
    L4:
        if (r5.isEmpty() == true) goto L15;
        Matcher r10 = Pattern.compile("[A-Za-z0-9]+").matcher(r5);
        StringBuilder r11 = new StringBuilder();
    L8:
        if (r10.find() == false) goto L11;
        r11.append(r10.group());
        goto L8
    L11:
        return r11.toString();
    L15:
        return "";
    }

    public static String c(String r5) {
        if (r5 != null) goto L5;
    L13:
        return "";
    L5:
        if (r5.isEmpty() == true) goto L13;
        if (r5.matches(".*:.*") == false) goto L13;
        Matcher r10 = Pattern.compile("(\\d{1,2}):(\\d{1,2})").matcher(r5);
        if (r10.find() == false) goto L13;
        return String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, new Object[]{Integer.valueOf(Integer.parseInt(r10.group(1)))}) + ":" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, new Object[]{Integer.valueOf(Integer.parseInt(r10.group(2)))});
    }

    public static String d(String r13) {
        String r5 = f19878a;
        if (r13 != null) goto L5;
    L64:
        Log.e(r5, "the time is null !!!");
        return "";
    L5:
        if (r13.isEmpty() == true) goto L64;
        if (r13.isEmpty() == false) goto L10;
    L9:
        String r10 = "";
    L23:
        if (r10.isEmpty() == false) goto L26;
        Log.e(r5, "the date is null !!!");
        return "";
    L26:
        int r11 = Calendar.getInstance().get(1);
        if (r10.matches(".*-.*-.*") == false) goto L33;
        Matcher r12 = Pattern.compile("(\\d{4})-(1[0-2]|0?[1-9])-([12]\\d|3[01]|0?[1-9])").matcher(r10);
        if (r12.find() == false) goto L33;
        String r14 = String.format("%04d", new Object[]{Integer.valueOf(Integer.parseInt(r12.group(1)))}) + DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, new Object[]{Integer.valueOf(Integer.parseInt(r12.group(2)))}) + DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, new Object[]{Integer.valueOf(Integer.parseInt(r12.group(3)))});
        Log.d(r5, "parseto_yyyy_mm_dd: (input=yyyy-MM-dd) before date = " + r13 + ", after date = " + r14);
        return r14;
    L33:
        if (r10.matches(".*年.*月.*日") == false) goto L39;
        Matcher r15 = Pattern.compile("(\\d{4})年(1[0-2]|0?[1-9])月([12]\\d|3[01]|0?[1-9])日").matcher(r10);
        if (r15.find() == false) goto L39;
        String r16 = String.format("%04d", new Object[]{Integer.valueOf(Integer.parseInt(r15.group(1)))}) + DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, new Object[]{Integer.valueOf(Integer.parseInt(r15.group(2)))}) + DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, new Object[]{Integer.valueOf(Integer.parseInt(r15.group(3)))});
        Log.d(r5, "parseto_yyyy_mm_dd: (input=yyyy年MM月dd日) before date = " + r13 + ", after date = " + r16);
        return r16;
    L39:
        if (r10.matches(".*年.*月.*") == false) goto L45;
        Matcher r17 = Pattern.compile("(\\d{4})年(1[0-2]|0?[1-9])月([12]\\d|3[01]|0?[1-9])").matcher(r10);
        if (r17.find() == false) goto L45;
        String r18 = String.format("%04d", new Object[]{Integer.valueOf(Integer.parseInt(r17.group(1)))}) + DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, new Object[]{Integer.valueOf(Integer.parseInt(r17.group(2)))}) + DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, new Object[]{Integer.valueOf(Integer.parseInt(r17.group(3)))});
        Log.d(r5, "parseto_yyyy_mm_dd: (input=yyyy年MM月dd) before date = " + r13 + ", after date = " + r18);
        return r18;
    L45:
        if (r10.matches(".*-.*") == false) goto L51;
        Matcher r19 = Pattern.compile("(1[0-2]|0?[1-9])-([12]\\d|3[01]|0?[1-9])").matcher(r10);
        if (r19.find() == false) goto L51;
        String r20 = r11 + DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, new Object[]{Integer.valueOf(Integer.parseInt(r19.group(1)))}) + DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, new Object[]{Integer.valueOf(Integer.parseInt(r19.group(2)))});
        Log.d(r5, "parseto_yyyy_mm_dd: (input=MM-dd) before date = " + r13 + ", after date = " + r20);
        return r20;
    L51:
        if (r10.matches(".*月.*日") == false) goto L57;
        Matcher r21 = Pattern.compile("(1[0-2]|0?[1-9])月([12]\\d|3[01]|0?[1-9])日").matcher(r10);
        if (r21.find() == false) goto L57;
        String r22 = r11 + DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, new Object[]{Integer.valueOf(Integer.parseInt(r21.group(1)))}) + DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, new Object[]{Integer.valueOf(Integer.parseInt(r21.group(2)))});
        Log.d(r5, "parseto_yyyy_mm_dd: (input=MM月dd日) before date = " + r13 + ", after date = " + r22);
        return r22;
    L57:
        if (r10.matches(".*月.*") == false) goto L62;
        Matcher r23 = Pattern.compile("(1[0-2]|0?[1-9])月([12]\\d|3[01]|0?[1-9])").matcher(r10);
        if (r23.find() == false) goto L62;
        String r24 = r11 + DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, new Object[]{Integer.valueOf(Integer.parseInt(r23.group(1)))}) + DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, new Object[]{Integer.valueOf(Integer.parseInt(r23.group(2)))});
        Log.d(r5, "parseto_yyyy_mm_dd: (input=MM月dd) before date = " + r13 + ", after date = " + r24);
        return r24;
    L62:
        Log.w(r5, "无法匹配日期格式: ".concat(r13));
        return "";
    L10:
        String[] r25 = r13.split("\\s+");
        int r26 = r25.length;
        int r27 = 0;
    L11:
        if (r27 >= r26) goto L9;
        r10 = r25[r27];
        if (r10.contains("年") == true) goto L23;
        if (r10.contains("月") == true) goto L23;
        if (r10.contains("日") == true) goto L23;
        if (r10.contains(DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD) == true) goto L23;
        r27 = r27 + 1;
        goto L11
    }
}
