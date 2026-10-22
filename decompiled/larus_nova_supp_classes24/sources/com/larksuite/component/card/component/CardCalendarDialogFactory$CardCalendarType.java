package com.larksuite.component.card.component;

import com.larksuite.framework.http.request.HttpHeaders;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final enum CardCalendarDialogFactory$CardCalendarType extends Enum<CardCalendarDialogFactory$CardCalendarType> {
    public static final CardCalendarDialogFactory$CardCalendarType Date = null;
    public static final CardCalendarDialogFactory$CardCalendarType DateTime = null;
    public static final CardCalendarDialogFactory$CardCalendarType Time = null;
    public static final /* synthetic */ CardCalendarDialogFactory$CardCalendarType[] a = null;

    static {
        CardCalendarDialogFactory$CardCalendarType r0 = new CardCalendarDialogFactory$CardCalendarType(HttpHeaders.HEAD_KEY_DATE, 0);
        Date = r0;
        CardCalendarDialogFactory$CardCalendarType r1 = new CardCalendarDialogFactory$CardCalendarType("Time", 1);
        Time = r1;
        CardCalendarDialogFactory$CardCalendarType r3 = new CardCalendarDialogFactory$CardCalendarType("DateTime", 2);
        DateTime = r3;
        a = new CardCalendarDialogFactory$CardCalendarType[]{r0, r1, r3};
    }

    public static CardCalendarDialogFactory$CardCalendarType[] values() {
        return (CardCalendarDialogFactory$CardCalendarType[]) a.clone();
    }

    public static CardCalendarDialogFactory$CardCalendarType valueOf(String r1) {
        return (CardCalendarDialogFactory$CardCalendarType) r27.a.a(CardCalendarDialogFactory$CardCalendarType.class, r1);
    }

    public CardCalendarDialogFactory$CardCalendarType(String r1, int r2) {
        super(r1, r2);
    }
}
