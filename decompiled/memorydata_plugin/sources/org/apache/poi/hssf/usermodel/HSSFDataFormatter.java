package org.apache.poi.hssf.usermodel;

import java.util.Locale;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.util.LocaleUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class HSSFDataFormatter extends DataFormatter {
    public HSSFDataFormatter() {
        this(LocaleUtil.getUserLocale());
    }

    public HSSFDataFormatter(Locale r1) {
        super(r1);
    }
}
