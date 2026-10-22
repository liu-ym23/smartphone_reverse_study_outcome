package grb;

import com.ss.android.lark.message.card.component.CardCalendarDialogFactory$CardCalendarType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final /* synthetic */ class a {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[CardCalendarDialogFactory$CardCalendarType.values().length];
        a = r0;
        r0[CardCalendarDialogFactory$CardCalendarType.Date.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
    L10:
        a[CardCalendarDialogFactory$CardCalendarType.Time.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
    L12:
        a[CardCalendarDialogFactory$CardCalendarType.DateTime.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
        return;
    }
}
