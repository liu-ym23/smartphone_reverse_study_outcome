package androidx.appcompat.app;

import android.os.LocaleList;
import androidx.annotation.RequiresApi;
import androidx.core.os.LocaleListCompat;
import java.util.LinkedHashSet;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(24)
final class LocaleOverlayHelper {
    private LocaleOverlayHelper() {
    }

    private static LocaleListCompat combineLocales(LocaleListCompat r5, LocaleListCompat r10) {
        LinkedHashSet r11 = new LinkedHashSet();
        int r12 = 0;
    L3:
        int r13 = r5.size();
        if (r12 >= (r10.size() + r13)) goto L13;
        if (r12 >= r5.size()) goto L8;
        Locale r14 = r5.get(r12);
    L9:
        if (r14 == null) goto L11;
        r11.add(r14);
    L11:
        r12 = r12 + 1;
        goto L3
    L8:
        r14 = r10.get(r12 - r5.size());
        goto L9
    L13:
        return LocaleListCompat.create((Locale[]) r11.toArray(new Locale[r11.size()]));
    }

    public static LocaleListCompat combineLocalesIfOverlayExists(LocaleListCompat r5, LocaleListCompat r10) {
        if (r5 == null) goto L9;
        if (r5.isEmpty() == true) goto L9;
        return combineLocales(r5, r10);
    L9:
        return LocaleListCompat.getEmptyLocaleList();
    }

    public static LocaleListCompat combineLocalesIfOverlayExists(LocaleList r5, LocaleList r10) {
        if (r5 == null) goto L9;
        if (r5.isEmpty() == true) goto L9;
        return combineLocales(LocaleListCompat.wrap(r5), LocaleListCompat.wrap(r10));
    L9:
        return LocaleListCompat.getEmptyLocaleList();
    }
}
