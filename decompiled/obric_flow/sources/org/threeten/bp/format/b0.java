package org.threeten.bp.format;

import java.text.DateFormatSymbols;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.threeten.bp.temporal.ChronoField;

/* JADX INFO: loaded from: classes3.dex */
public final class b0 extends y {
    public static final c d = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f21207b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f21208c;

    static {
        d = new c(2);
    }

    public b0() {
        this.f21207b = 0;
        this.f21208c = new ConcurrentHashMap(16, 0.75f, 2);
    }

    public static a0 c(HashMap r5) {
        r5.put(TextStyle.FULL_STANDALONE, r5.get(TextStyle.FULL));
        r5.put(TextStyle.SHORT_STANDALONE, r5.get(TextStyle.SHORT));
        TextStyle r10 = TextStyle.NARROW;
        if (r5.containsKey(r10) == false) goto L8;
        TextStyle r11 = TextStyle.NARROW_STANDALONE;
        if (r5.containsKey(r11) == true) goto L8;
        r5.put(r11, r5.get(r10));
    L8:
        return new a0(r5);
    }

    @Override // org.threeten.bp.format.y
    public final String a(org.threeten.bp.temporal.g r5, long r10, TextStyle r11, Locale r12) {
        switch(this.f21207b) {
            case 0: goto L9;
            default: goto L4;
        };
    L4:
        Map r13 = (Map) ((a0) this.f21208c).f21197a.get(r11);
        if (r13 != null) goto L15;
        return null;
    L15:
        return (String) r13.get(Long.valueOf(r10));
    L9:
        Object r14 = d(r5, r12);
        if ((r14 instanceof a0) == false) goto L16;
        Map r15 = (Map) ((a0) r14).f21197a.get(r11);
        if (r15 != null) goto L14;
        return null;
    L14:
        return (String) r15.get(Long.valueOf(r10));
    L16:
        return null;
    }

    @Override // org.threeten.bp.format.y
    public final Iterator b(org.threeten.bp.temporal.g r5, TextStyle r10, Locale r11) {
        switch(this.f21207b) {
            case 0: goto L9;
            default: goto L4;
        };
    L4:
        List r12 = (List) ((a0) this.f21208c).f21198b.get(r10);
        if (r12 != null) goto L15;
        return null;
    L15:
        return r12.iterator();
    L9:
        Object r13 = d(r5, r11);
        if ((r13 instanceof a0) == false) goto L16;
        List r14 = (List) ((a0) r13).f21198b.get(r10);
        if (r14 != null) goto L14;
        return null;
    L14:
        return r14.iterator();
    L16:
        return null;
    }

    public Object d(org.threeten.bp.temporal.g r25, Locale r26) {
        AbstractMap.SimpleImmutableEntry r5 = new AbstractMap.SimpleImmutableEntry(r25, r26);
        ConcurrentHashMap r10 = (ConcurrentHashMap) this.f21208c;
        Object r11 = r10.get(r5);
        if (r11 == null) goto L5;
        return r11;
    L5:
        if (r25 != ChronoField.MONTH_OF_YEAR) goto L8;
        DateFormatSymbols r12 = DateFormatSymbols.getInstance(r26);
        HashMap r13 = new HashMap();
        String[] r18 = r12.getMonths();
        AbstractMap.SimpleImmutableEntry r19 = r5;
        HashMap r14 = new HashMap();
        ConcurrentHashMap r21 = r10;
        r14.put(1L, r18[0]);
        r14.put(2L, r18[1]);
        r14.put(3L, r18[2]);
        r14.put(4L, r18[3]);
        r14.put(5L, r18[4]);
        r14.put(6L, r18[5]);
        r14.put(7L, r18[6]);
        r14.put(8L, r18[7]);
        r14.put(9L, r18[8]);
        r14.put(10L, r18[9]);
        r14.put(11L, r18[10]);
        r14.put(12L, r18[11]);
        r13.put(TextStyle.FULL, r14);
        HashMap r15 = new HashMap();
        r15.put(1L, r18[0].substring(0, 1));
        r15.put(2L, r18[1].substring(0, 1));
        r15.put(3L, r18[2].substring(0, 1));
        r15.put(4L, r18[3].substring(0, 1));
        r15.put(5L, r18[4].substring(0, 1));
        r15.put(6L, r18[5].substring(0, 1));
        r15.put(7L, r18[6].substring(0, 1));
        r15.put(8L, r18[7].substring(0, 1));
        r15.put(9L, r18[8].substring(0, 1));
        r15.put(10L, r18[9].substring(0, 1));
        r15.put(11L, r18[10].substring(0, 1));
        r15.put(12L, r18[11].substring(0, 1));
        r13.put(TextStyle.NARROW, r15);
        String[] r16 = r12.getShortMonths();
        HashMap r17 = new HashMap();
        r17.put(1L, r16[0]);
        r17.put(2L, r16[1]);
        r17.put(3L, r16[2]);
        r17.put(4L, r16[3]);
        r17.put(5L, r16[4]);
        r17.put(6L, r16[5]);
        r17.put(7L, r16[6]);
        r17.put(8L, r16[7]);
        r17.put(9L, r16[8]);
        r17.put(10L, r16[9]);
        r17.put(11L, r16[10]);
        r17.put(12L, r16[11]);
        r13.put(TextStyle.SHORT, r17);
        Object r20 = c(r13);
    L7:
        AbstractMap.SimpleImmutableEntry r22 = r19;
        ConcurrentHashMap r23 = r21;
        r23.putIfAbsent(r22, r20);
        return r23.get(r22);
    L8:
        r19 = r5;
        r21 = r10;
        if (r25 != ChronoField.DAY_OF_WEEK) goto L12;
        DateFormatSymbols r24 = DateFormatSymbols.getInstance(r26);
        HashMap r27 = new HashMap();
        String[] r28 = r24.getWeekdays();
        HashMap r29 = new HashMap();
        r29.put(1L, r28[2]);
        r29.put(2L, r28[3]);
        r29.put(3L, r28[4]);
        r29.put(4L, r28[5]);
        r29.put(5L, r28[6]);
        r29.put(6L, r28[7]);
        r29.put(7L, r28[1]);
        r27.put(TextStyle.FULL, r29);
        HashMap r30 = new HashMap();
        r30.put(1L, r28[2].substring(0, 1));
        r30.put(2L, r28[3].substring(0, 1));
        r30.put(3L, r28[4].substring(0, 1));
        r30.put(4L, r28[5].substring(0, 1));
        r30.put(5L, r28[6].substring(0, 1));
        r30.put(6L, r28[7].substring(0, 1));
        r30.put(7L, r28[1].substring(0, 1));
        r27.put(TextStyle.NARROW, r30);
        String[] r31 = r24.getShortWeekdays();
        HashMap r32 = new HashMap();
        r32.put(1L, r31[2]);
        r32.put(2L, r31[3]);
        r32.put(3L, r31[4]);
        r32.put(4L, r31[5]);
        r32.put(5L, r31[6]);
        r32.put(6L, r31[7]);
        r32.put(7L, r31[1]);
        r27.put(TextStyle.SHORT, r32);
        r20 = c(r27);
        goto L7
    L12:
        if (r25 != ChronoField.AMPM_OF_DAY) goto L15;
        DateFormatSymbols r33 = DateFormatSymbols.getInstance(r26);
        HashMap r34 = new HashMap();
        String[] r35 = r33.getAmPmStrings();
        HashMap r36 = new HashMap();
        r36.put(0L, r35[0]);
        r36.put(1L, r35[1]);
        r34.put(TextStyle.FULL, r36);
        r34.put(TextStyle.SHORT, r36);
        r20 = c(r34);
        goto L7
    L15:
        if (r25 != ChronoField.ERA) goto L22;
        DateFormatSymbols r37 = DateFormatSymbols.getInstance(r26);
        HashMap r38 = new HashMap();
        String[] r39 = r37.getEras();
        HashMap r40 = new HashMap();
        r40.put(0L, r39[0]);
        r40.put(1L, r39[1]);
        r38.put(TextStyle.SHORT, r40);
        if (r26.getLanguage().equals(Locale.ENGLISH.getLanguage()) == false) goto L19;
        HashMap r41 = new HashMap();
        r41.put(0L, "Before Christ");
        r41.put(1L, "Anno Domini");
        r38.put(TextStyle.FULL, r41);
    L20:
        HashMap r42 = new HashMap();
        r42.put(0L, r39[0].substring(0, 1));
        r42.put(1L, r39[1].substring(0, 1));
        r38.put(TextStyle.NARROW, r42);
        r20 = c(r38);
        goto L7
    L19:
        r38.put(TextStyle.FULL, r40);
        goto L20
    L22:
        if (r25 != org.threeten.bp.temporal.b.f21283a) goto L24;
        HashMap r43 = new HashMap();
        HashMap r44 = new HashMap();
        r44.put(1L, "Q1");
        r44.put(2L, "Q2");
        r44.put(3L, "Q3");
        r44.put(4L, "Q4");
        r43.put(TextStyle.SHORT, r44);
        HashMap r45 = new HashMap();
        r45.put(1L, "1st quarter");
        r45.put(2L, "2nd quarter");
        r45.put(3L, "3rd quarter");
        r45.put(4L, "4th quarter");
        r43.put(TextStyle.FULL, r45);
        r20 = c(r43);
        goto L7
    L24:
        r20 = "";
        goto L7
    }

    public b0(a0 r5) {
        this.f21207b = 1;
        this.f21208c = r5;
    }
}
