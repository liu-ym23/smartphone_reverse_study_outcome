package com.larksuite.component.card.component;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class a {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;

    static {
        int[] r0 = new int[CardCalendarDialogFactory$CardCalendarDialogStyle.values().length];
        b = r0;
        r0[CardCalendarDialogFactory$CardCalendarDialogStyle.BottomSheet.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
    L16:
        b[CardCalendarDialogFactory$CardCalendarDialogStyle.Modal.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
    L6:
        int[] r2 = new int[CardCalendarDialogFactory$CardCalendarType.values().length];
        a = r2;
        r2[CardCalendarDialogFactory$CardCalendarType.Date.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
    L20:
        a[CardCalendarDialogFactory$CardCalendarType.Time.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
    L24:
        a[CardCalendarDialogFactory$CardCalendarType.DateTime.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        return;
    }
}
