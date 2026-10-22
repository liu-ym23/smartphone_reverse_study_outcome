package com.alibaba.excel.d;

import com.alibaba.excel.i.j;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static short f146a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f147b = null;
    public static final String[] c = null;
    public static final Map<String, Short> d = null;
    public static final Map<String, Short> e = null;

    static {
        String[] r0 = {"General", "0", "0.00", "#,##0", "#,##0.00", "\"￥\"#,##0_);(\"￥\"#,##0)", "\"￥\"#,##0_);[Red](\"￥\"#,##0)", "\"￥\"#,##0.00_);(\"￥\"#,##0.00)", "\"￥\"#,##0.00_);[Red](\"￥\"#,##0.00)", "0%", "0.00%", "0.00E+00", "# ?/?", "# ??/??", "yyyy/m/d", "d-mmm-yy", "d-mmm", "mmm-yy", "h:mm AM/PM", "h:mm:ss AM/PM", "h:mm", "h:mm:ss", "yyyy-m-d h:mm", null, null, null, null, "yyyy\"年\"m\"月\"", "m\"月\"d\"日\"", "m\"月\"d\"日\"", "m-d-yy", "yyyy\"年\"m\"月\"d\"日\"", "h\"时\"mm\"分\"", "h\"时\"mm\"分\"ss\"秒\"", "上午/下午h\"时\"mm\"分\"", "上午/下午h\"时\"mm\"分\"ss\"秒\"", "yyyy\"年\"m\"月\"", "#,##0_);(#,##0)", "#,##0_);[Red](#,##0)", "#,##0.00_);(#,##0.00)", "#,##0.00_);[Red](#,##0.00)", "_(* #,##0_);_(* (#,##0);_(* \"-\"_);_(@_)", "_(\"￥\"* #,##0_);_(\"￥\"* (#,##0);_(\"￥\"* \"-\"_);_(@_)", "_(* #,##0.00_);_(* (#,##0.00);_(* \"-\"??_);_(@_)", "_(\"￥\"* #,##0.00_);_(\"￥\"* (#,##0.00);_(\"￥\"* \"-\"??_);_(@_)", "mm:ss", "[h]:mm:ss", "mm:ss.0", "##0.0E+0", "@", "yyyy\"年\"m\"月\"", "m\"月\"d\"日\"", "yyyy\"年\"m\"月\"", "m\"月\"d\"日\"", "m\"月\"d\"日\"", "上午/下午h\"时\"mm\"分\"", "上午/下午h\"时\"mm\"分\"ss\"秒\"", "yyyy\"年\"m\"月\"", "m\"月\"d\"日\"", "t0", "t0.00", "t#,##0", "t#,##0.00", null, null, null, null, "t0%", "t0.00%", "t# ?/?", "t# ??/??", "ว/ด/ปปปป", "ว-ดดด-ปป", "ว-ดดด", "ดดด-ปป", "ช:นน", "ช:นน:ทท", "ว/ด/ปปปป ช:นน", "นน:ทท", "[ช]:นน:ทท", "นน:ทท.0", "d/m/bb"};
        f147b = r0;
        String[] r1 = {"General", "0", "0.00", "#,##0", "#,##0.00", "\"$\"#,##0_);(\"$\"#,##0)", "\"$\"#,##0_);[Red](\"$\"#,##0)", "\"$\"#,##0.00_);(\"$\"#,##0.00)", "\"$\"#,##0.00_);[Red](\"$\"#,##0.00)", "0%", "0.00%", "0.00E+00", "# ?/?", "# ??/??", "yyyy/m/d", "d-mmm-yy", "d-mmm", "mmm-yy", "h:mm AM/PM", "h:mm:ss AM/PM", "h:mm", "h:mm:ss", "yyyy-m-d h:mm", null, null, null, null, "yyyy\"年\"m\"月\"", "m\"月\"d\"日\"", "m\"月\"d\"日\"", "m-d-yy", "yyyy\"年\"m\"月\"d\"日\"", "h\"时\"mm\"分\"", "h\"时\"mm\"分\"ss\"秒\"", "上午/下午h\"时\"mm\"分\"", "上午/下午h\"时\"mm\"分\"ss\"秒\"", "yyyy\"年\"m\"月\"", "#,##0_);(#,##0)", "#,##0_);[Red](#,##0)", "#,##0.00_);(#,##0.00)", "#,##0.00_);[Red](#,##0.00)", "_(* #,##0_);_(* (#,##0);_(* \"-\"_);_(@_)", "_(\"$\"* #,##0_);_(\"$\"* (#,##0);_(\"$\"* \"-\"_);_(@_)", "_(* #,##0.00_);_(* (#,##0.00);_(* \"-\"??_);_(@_)", "_(\"$\"* #,##0.00_);_(\"$\"* (#,##0.00);_(\"$\"* \"-\"??_);_(@_)", "mm:ss", "[h]:mm:ss", "mm:ss.0", "##0.0E+0", "@", "yyyy\"年\"m\"月\"", "m\"月\"d\"日\"", "yyyy\"年\"m\"月\"", "m\"月\"d\"日\"", "m\"月\"d\"日\"", "上午/下午h\"时\"mm\"分\"", "上午/下午h\"时\"mm\"分\"ss\"秒\"", "yyyy\"年\"m\"月\"", "m\"月\"d\"日\"", "t0", "t0.00", "t#,##0", "t#,##0.00", null, null, null, null, "t0%", "t0.00%", "t# ?/?", "t# ??/??", "ว/ด/ปปปป", "ว-ดดด-ปป", "ว-ดดด", "ดดด-ปป", "ช:นน", "ช:นน:ทท", "ว/ด/ปปปป ช:นน", "นน:ทท", "[ช]:นน:ทท", "นน:ทท.0", "d/m/bb"};
        c = r1;
        d = a(r0);
        e = a(r1);
    }

    public static String a(Short r2, String r3, Locale r4) {
        String[] r5 = a(r4);
        if (r2 != null) goto L5;
    L11:
        return r3;
    L5:
        if (r2.shortValue() < 0) goto L11;
        if (r2.shortValue() >= r5.length) goto L11;
        return r5[r2.shortValue()];
    }

    private static Map<String, Short> a(String[] r4) {
        HashMap r0 = j.a(r4.length);
        int r1 = 0;
    L4:
        if (r1 >= r4.length) goto L6;
        r0.put(r4[r1], Short.valueOf((short) r1));
        r1 = r1 + 1;
        goto L4
    L6:
        return r0;
    }

    public static String[] a(Locale r1) {
        if (r1 == null) goto L8;
        if (Locale.US.getCountry().equals(r1.getCountry()) == false) goto L8;
        return c;
    L8:
        return f147b;
    }
}
