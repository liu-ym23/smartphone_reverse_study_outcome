package androidx.core.database;

import android.database.Cursor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class CursorKt {
    public static final byte[] getBlobOrNull(Cursor r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.isNull(r11) == false) goto L6;
        return null;
    L6:
        return r10.getBlob(r11);
    }

    public static final Double getDoubleOrNull(Cursor r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.isNull(r11) == false) goto L6;
        return null;
    L6:
        return Double.valueOf(r10.getDouble(r11));
    }

    public static final Float getFloatOrNull(Cursor r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.isNull(r11) == false) goto L6;
        return null;
    L6:
        return Float.valueOf(r10.getFloat(r11));
    }

    public static final Integer getIntOrNull(Cursor r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.isNull(r11) == false) goto L6;
        return null;
    L6:
        return Integer.valueOf(r10.getInt(r11));
    }

    public static final Long getLongOrNull(Cursor r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.isNull(r11) == false) goto L6;
        return null;
    L6:
        return Long.valueOf(r10.getLong(r11));
    }

    public static final Short getShortOrNull(Cursor r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.isNull(r11) == false) goto L6;
        return null;
    L6:
        return Short.valueOf(r10.getShort(r11));
    }

    public static final String getStringOrNull(Cursor r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.isNull(r11) == false) goto L6;
        return null;
    L6:
        return r10.getString(r11);
    }
}
