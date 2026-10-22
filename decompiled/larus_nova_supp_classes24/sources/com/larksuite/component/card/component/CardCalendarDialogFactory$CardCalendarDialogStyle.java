package com.larksuite.component.card.component;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final enum CardCalendarDialogFactory$CardCalendarDialogStyle extends Enum<CardCalendarDialogFactory$CardCalendarDialogStyle> {
    public static final CardCalendarDialogFactory$CardCalendarDialogStyle BottomSheet = null;
    public static final CardCalendarDialogFactory$CardCalendarDialogStyle Modal = null;
    public static final /* synthetic */ CardCalendarDialogFactory$CardCalendarDialogStyle[] a = null;

    static {
        CardCalendarDialogFactory$CardCalendarDialogStyle r0 = new CardCalendarDialogFactory$CardCalendarDialogStyle("BottomSheet", 0);
        BottomSheet = r0;
        CardCalendarDialogFactory$CardCalendarDialogStyle r1 = new CardCalendarDialogFactory$CardCalendarDialogStyle("Modal", 1);
        Modal = r1;
        a = new CardCalendarDialogFactory$CardCalendarDialogStyle[]{r0, r1};
    }

    public static CardCalendarDialogFactory$CardCalendarDialogStyle[] values() {
        return (CardCalendarDialogFactory$CardCalendarDialogStyle[]) a.clone();
    }

    public static CardCalendarDialogFactory$CardCalendarDialogStyle valueOf(String r1) {
        return (CardCalendarDialogFactory$CardCalendarDialogStyle) r27.a.a(CardCalendarDialogFactory$CardCalendarDialogStyle.class, r1);
    }

    public CardCalendarDialogFactory$CardCalendarDialogStyle(String r1, int r2) {
        super(r1, r2);
    }
}
