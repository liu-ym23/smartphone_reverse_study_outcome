package androidx.core.database;

import ai.j0;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class DatabaseUtilsCompat {
    private DatabaseUtilsCompat() {
    }

    @Deprecated
    public static String[] appendSelectionArgs(String[] r5, String[] r10) {
        if (r5 != null) goto L4;
    L8:
        return r10;
    L4:
        if (r5.length == 0) goto L8;
        String[] r11 = new String[r5.length + r10.length];
        System.arraycopy(r5, 0, r11, 0, r5.length);
        System.arraycopy(r10, 0, r11, r5.length, r10.length);
        return r11;
    }

    @Deprecated
    public static String concatenateWhere(String r5, String r10) {
        if (TextUtils.isEmpty(r5) == false) goto L6;
        return r10;
    L6:
        if (TextUtils.isEmpty(r10) == false) goto L9;
        return r5;
    L9:
        return j0.l("(", r5, ") AND (", r10, ")");
    }
}
