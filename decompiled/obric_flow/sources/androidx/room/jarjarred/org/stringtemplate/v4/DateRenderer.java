package androidx.room.jarjarred.org.stringtemplate.v4;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class DateRenderer implements AttributeRenderer {
    public static final Map<String, Integer> formatToInt = null;

    static {
        formatToInt = new AnonymousClass1();
    }

    public DateRenderer() {
    }

    @Override // androidx.room.jarjarred.org.stringtemplate.v4.AttributeRenderer
    public String toString(Object r5, String r10, Locale r11) {
        if (r10 != null) goto L5;
        r10 = "short";
    L5:
        if ((r5 instanceof Calendar) == false) goto L7;
        Date r12 = ((Calendar) r5).getTime();
    L8:
        Integer r13 = formatToInt.get(r10);
        if (r13 != null) goto L11;
        DateFormat r14 = new SimpleDateFormat(r10, r11);
    L19:
        return r14.format(r12);
    L11:
        int r15 = r13.intValue();
        if (r10.startsWith("date:") == false) goto L15;
        r14 = DateFormat.getDateInstance(r15, r11);
        goto L19
    L15:
        if (r10.startsWith("time:") == false) goto L17;
        r14 = DateFormat.getTimeInstance(r15, r11);
        goto L19
    L17:
        r14 = DateFormat.getDateTimeInstance(r15, r15, r11);
        goto L19
    L7:
        r12 = (Date) r5;
        goto L8
    }
}
