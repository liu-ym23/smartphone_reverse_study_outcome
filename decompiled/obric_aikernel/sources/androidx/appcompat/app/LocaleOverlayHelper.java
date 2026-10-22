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

    private static LocaleListCompat combineLocales(LocaleListCompat r10, LocaleListCompat r11) {
        LinkedHashSet r12 = new LinkedHashSet();
        int r13 = 0;
    L4:
        if (r13 >= (r10.size() + r11.size())) goto L13;
        if (r13 >= r10.size()) goto L8;
        Locale r14 = r10.get(r13);
    L9:
        if (r14 == null) goto L11;
        r12.add(r14);
    L11:
        r13 = r13 + 1;
        goto L4
    L8:
        r14 = r11.get(r13 - r10.size());
        goto L9
    L13:
        return LocaleListCompat.create((Locale[]) r12.toArray(new Locale[r12.size()]));
    }

    static LocaleListCompat combineLocalesIfOverlayExists(LocaleList r10, LocaleList r11) {
        if (r10 == null) goto L9;
        if (r10.isEmpty() == true) goto L9;
        return combineLocales(LocaleListCompat.wrap(r10), LocaleListCompat.wrap(r11));
    L9:
        return LocaleListCompat.getEmptyLocaleList();
    }

    static LocaleListCompat combineLocalesIfOverlayExists(LocaleListCompat r10, LocaleListCompat r11) {
        if (r10 == null) goto L9;
        if (r10.isEmpty() == true) goto L9;
        return combineLocales(r10, r11);
    L9:
        return LocaleListCompat.getEmptyLocaleList();
    }
}
