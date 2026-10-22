package org.apache.poi.ss.format;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Locale;
import java.util.regex.Matcher;

/* JADX INFO: loaded from: classes7.dex */
public class CellTextFormatter extends CellFormatter {
    static final CellFormatter SIMPLE_TEXT = null;
    private final String desc;
    private final int[] textPos;

    static {
        SIMPLE_TEXT = new CellTextFormatter("@");
    }

    public CellTextFormatter(String r6) {
        super(r6);
        final int[] r1 = new int[1];
        String r7 = CellFormatPart.parseFormat(r6, CellFormatType.TEXT, new $$Lambda$CellTextFormatter$T82zopuDW7IpWy5S7CTxAZ7U7_c(r1)).toString();
        this.desc = r7;
        this.textPos = new int[r1[0]];
        int r8 = r7.length() - 1;
        int r2 = 0;
    L3:
        int[] r3 = this.textPos;
        if (r2 >= r3.length) goto L6;
        r3[r2] = this.desc.lastIndexOf(0, r8);
        r8 = this.textPos[r2] - 1;
        r2 = r2 + 1;
        goto L3
    }

    static /* synthetic */ String lambda$new$0(int[] r0, Matcher r1, String r2, CellFormatType r3, StringBuffer r4) {
        if (r2.equals("@") == false) goto L6;
        r0[0] = r0[0] + 1;
        return "\u0000";
    L6:
        return null;
    }

    @Override // org.apache.poi.ss.format.CellFormatter
    public void formatValue(StringBuffer r6, Object r7) {
        int r0 = r6.length();
        String r1 = r7.toString();
        if (ZeusTransformUtils.instanceOf(r7, Boolean.class) == false) goto L5;
        r1 = r1.toUpperCase(Locale.ROOT);
    L5:
        r6.append(this.desc);
        int[] r5 = this.textPos;
        int r8 = r5.length;
        int r2 = 0;
    L6:
        if (r2 >= r8) goto L8;
        int r3 = r5[r2] + r0;
        r6.replace(r3, r3 + 1, r1);
        r2 = r2 + 1;
        goto L6
    }

    @Override // org.apache.poi.ss.format.CellFormatter
    public void simpleValue(StringBuffer r1, Object r2) {
        SIMPLE_TEXT.formatValue(r1, r2);
    }
}
