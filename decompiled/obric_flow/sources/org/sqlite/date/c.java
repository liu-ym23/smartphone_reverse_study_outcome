package org.sqlite.date;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f21081a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Locale f21082b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap f21083c;

    public c(int r5, Calendar r10, Locale r11) {
        this.f21081a = r5;
        this.f21082b = r11;
        Map r12 = FastDateParser.access$200(r5, r10, r11);
        this.f21083c = new HashMap();
        Iterator r13 = r12.entrySet().iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        Map.Entry r14 = (Map.Entry) r13.next();
        this.f21083c.put(((String) r14.getKey()).toLowerCase(r11), r14.getValue());
        goto L4
    }

    @Override // org.sqlite.date.f
    public final boolean a(FastDateParser r5, StringBuilder r10) {
        r10.append("((?iu)");
        Iterator r11 = this.f21083c.keySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        FastDateParser.access$100(r10, (String) r11.next(), false).append('|');
        goto L4
    L6:
        r10.setCharAt(r10.length() - 1, ')');
        return true;
    }

    @Override // org.sqlite.date.f
    public final void c(FastDateParser r5, Calendar r10, String r11) {
        HashMap r12 = this.f21083c;
        Integer r13 = (Integer) r12.get(r11.toLowerCase(this.f21082b));
        if (r13 != null) goto L10;
        StringBuilder r14 = new StringBuilder(r11);
        r14.append(" not in (");
        Iterator r15 = r12.keySet().iterator();
    L6:
        if (r15.hasNext() == false) goto L8;
        r14.append((String) r15.next());
        r14.append(' ');
        goto L6
    L8:
        r14.setCharAt(r14.length() - 1, ')');
        throw new IllegalArgumentException(r14.toString());
    L10:
        r10.set(this.f21081a, r13.intValue());
    }
}
