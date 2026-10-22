package org.apache.poi.ss.format;

import java.util.Locale;
import kotlin.text.Typography;
import org.apache.poi.util.LocaleUtil;

/* JADX INFO: loaded from: classes7.dex */
public abstract class CellFormatter {
    protected final String format;
    protected final Locale locale;

    public CellFormatter(String r2) {
        this(LocaleUtil.getUserLocale(), r2);
    }

    public CellFormatter(Locale r1, String r2) {
        this.locale = r1;
        this.format = r2;
    }

    static String quote(String r2) {
        return Typography.quote + r2 + Typography.quote;
    }

    public String format(Object r2) {
        StringBuffer r0 = new StringBuffer();
        formatValue(r0, r2);
        return r0.toString();
    }

    public abstract void formatValue(StringBuffer r1, Object r2);

    public String simpleFormat(Object r2) {
        StringBuffer r0 = new StringBuffer();
        simpleValue(r0, r2);
        return r0.toString();
    }

    public abstract void simpleValue(StringBuffer r1, Object r2);
}
