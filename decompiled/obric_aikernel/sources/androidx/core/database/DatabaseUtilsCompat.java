package androidx.core.database;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class DatabaseUtilsCompat {
    private DatabaseUtilsCompat() {
    }

    @Deprecated
    public static String[] appendSelectionArgs(String[] r10, String[] r11) {
        if (r10 != null) goto L4;
    L8:
        return r11;
    L4:
        if (r10.length == 0) goto L8;
        String[] r12 = new String[r10.length + r11.length];
        System.arraycopy(r10, 0, r12, 0, r10.length);
        System.arraycopy(r11, 0, r12, r10.length, r11.length);
        return r12;
    }

    @Deprecated
    public static String concatenateWhere(String r10, String r11) {
        if (TextUtils.isEmpty(r10) == false) goto L6;
        return r11;
    L6:
        if (TextUtils.isEmpty(r11) == false) goto L9;
        return r10;
    L9:
        return "(" + r10 + ") AND (" + r11 + ")";
    }
}
