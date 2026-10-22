package org.apache.poi.ss.format;

import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Formatter;
import java.util.Locale;
import org.apache.poi.util.LocaleUtil;

/* JADX INFO: loaded from: classes7.dex */
public class CellGeneralFormatter extends CellFormatter {
    public CellGeneralFormatter() {
        this(LocaleUtil.getUserLocale());
    }

    public CellGeneralFormatter(Locale r2) {
        super(r2, "General");
    }

    @Override // org.apache.poi.ss.format.CellFormatter
    public void formatValue(StringBuffer r11, Object r12) {
        if (ZeusTransformUtils.instanceOf(r12, Number.class) == false) goto L43;
        double r0 = ((Number) ZeusTransformUtils.preCheckCast(r12, Number.class, "com.obric.memorydata.plugin")).doubleValue();
        if (r0 != 0.0d) goto L8;
        r11.append('0');
        return;
    L8:
        double r4 = Math.log10(Math.abs(r0));
        if (r4 <= 10.0d) goto L11;
    L17:
        String r1 = "%1.5E";
    L18:
        boolean r2 = true;
    L19:
        Formatter r3 = new Formatter(r11, this.locale);
        r3.format(this.locale, r1, new Object[]{r12});     // Catch: Throwable -> L34
        r3.close();
        if (r2 == true) goto L24;
        return;
    L24:
        if (r1.endsWith(ExifInterface.LONGITUDE_EAST) == false) goto L26;
        int r10 = r11.lastIndexOf(ExifInterface.LONGITUDE_EAST);
    L27:
        int r13 = r10 - 1;
    L29:
        if (r11.charAt(r13) != '0') goto L32;
        r11.deleteCharAt(r13);
        r13 = r13 - 1;
        goto L29
    L32:
        if (r11.charAt(r13) != '.') goto L55;
        r11.deleteCharAt(r13);
        return;
    L55:
        return;
    L26:
        r10 = r11.length();
    L34:
        th = move-exception;
        throw th;     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        r3.close();     // Catch: Throwable -> L39
    L41:
        throw th;
    L39:
        th = move-exception;
        th.addSuppressed(th);
        goto L41
    L11:
        if (r4 < (-9.0d)) goto L17;
        if (((long) r0) == r0) goto L16;
        r1 = "%1.9f";
        goto L18
    L16:
        r1 = "%1.0f";
        r2 = false;
        goto L19
    L43:
        if (ZeusTransformUtils.instanceOf(r12, Boolean.class) == false) goto L45;
        r11.append(r12.toString().toUpperCase(Locale.ROOT));
        return;
    L45:
        r11.append(r12);
    }

    @Override // org.apache.poi.ss.format.CellFormatter
    public void simpleValue(StringBuffer r1, Object r2) {
        formatValue(r1, r2);
    }
}
