package androidx.media;

import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public class MediaBrowserCompatUtils {
    private MediaBrowserCompatUtils() {
    }

    public static boolean areSameOptions(Bundle r6, Bundle r7) {
        if (r6 != r7) goto L6;
        return true;
    L6:
        if (r6 == null) goto L8;
        if (r7 != null) goto L23;
        if (r6.getInt("android.media.browse.extra.PAGE", -1) != (-1)) goto L21;
        if (r6.getInt("android.media.browse.extra.PAGE_SIZE", -1) != (-1)) goto L21;
        return true;
    L21:
        return false;
    L23:
        if (r6.getInt("android.media.browse.extra.PAGE", -1) != r7.getInt("android.media.browse.extra.PAGE", -1)) goto L28;
        if (r6.getInt("android.media.browse.extra.PAGE_SIZE", -1) != r7.getInt("android.media.browse.extra.PAGE_SIZE", -1)) goto L28;
        return true;
    L28:
        return false;
    L8:
        if (r7.getInt("android.media.browse.extra.PAGE", -1) != (-1)) goto L13;
        if (r7.getInt("android.media.browse.extra.PAGE_SIZE", -1) != (-1)) goto L13;
        return true;
    L13:
        return false;
    }

    public static boolean hasDuplicatedItems(Bundle r6, Bundle r7) {
        if (r6 != null) goto L5;
        int r2 = -1;
    L6:
        if (r7 != null) goto L8;
        int r0 = -1;
    L10:
        if (r6 != null) goto L12;
        int r8 = -1;
    L13:
        if (r7 != null) goto L15;
        int r9 = -1;
    L16:
        int r3 = Integer.MAX_VALUE;
        if (r2 == (-1)) goto L21;
        if (r8 == (-1)) goto L21;
        int r4 = r2 * r8;
        int r10 = (r8 + r4) - 1;
    L22:
        if (r0 == (-1)) goto L26;
        if (r9 == (-1)) goto L26;
        int r1 = r0 * r9;
        r3 = (r9 + r1) - 1;
    L27:
        if (r10 < r1) goto L31;
        if (r3 < r4) goto L31;
        return true;
    L31:
        return false;
    L26:
        r1 = 0;
    L21:
        r10 = Integer.MAX_VALUE;
        r4 = 0;
        goto L22
    L15:
        r9 = r7.getInt("android.media.browse.extra.PAGE_SIZE", -1);
        goto L16
    L12:
        r8 = r6.getInt("android.media.browse.extra.PAGE_SIZE", -1);
        goto L13
    L8:
        r0 = r7.getInt("android.media.browse.extra.PAGE", -1);
        goto L10
    L5:
        r2 = r6.getInt("android.media.browse.extra.PAGE", -1);
        goto L6
    }
}
