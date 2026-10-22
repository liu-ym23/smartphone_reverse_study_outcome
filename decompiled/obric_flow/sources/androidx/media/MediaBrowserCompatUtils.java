package androidx.media;

import android.os.Bundle;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class MediaBrowserCompatUtils {
    private MediaBrowserCompatUtils() {
    }

    public static boolean areSameOptions(Bundle r10, Bundle r11) {
        if (r10 != r11) goto L6;
        return true;
    L6:
        if (r10 == null) goto L8;
        if (r11 != null) goto L23;
        if (r10.getInt("android.media.browse.extra.PAGE", -1) != (-1)) goto L21;
        if (r10.getInt("android.media.browse.extra.PAGE_SIZE", -1) != (-1)) goto L21;
        return true;
    L21:
        return false;
    L23:
        if (r10.getInt("android.media.browse.extra.PAGE", -1) != r11.getInt("android.media.browse.extra.PAGE", -1)) goto L28;
        if (r10.getInt("android.media.browse.extra.PAGE_SIZE", -1) != r11.getInt("android.media.browse.extra.PAGE_SIZE", -1)) goto L28;
        return true;
    L28:
        return false;
    L8:
        if (r11.getInt("android.media.browse.extra.PAGE", -1) != (-1)) goto L13;
        if (r11.getInt("android.media.browse.extra.PAGE_SIZE", -1) != (-1)) goto L13;
        return true;
    L13:
        return false;
    }

    public static boolean hasDuplicatedItems(Bundle r10, Bundle r11) {
        if (r10 != null) goto L5;
        int r5 = -1;
    L6:
        if (r11 != null) goto L8;
        int r12 = -1;
    L10:
        if (r10 != null) goto L12;
        int r13 = -1;
    L13:
        if (r11 != null) goto L15;
        int r14 = -1;
    L16:
        int r15 = Integer.MAX_VALUE;
        if (r5 == (-1)) goto L21;
        if (r13 == (-1)) goto L21;
        int r16 = r5 * r13;
        int r17 = (r13 + r16) - 1;
    L22:
        if (r12 == (-1)) goto L26;
        if (r14 == (-1)) goto L26;
        int r18 = r12 * r14;
        r15 = (r14 + r18) - 1;
    L27:
        if (r17 < r18) goto L31;
        if (r15 >= r16) goto L30;
        return false;
    L30:
        return true;
    L31:
        return false;
    L26:
        r18 = 0;
    L21:
        r17 = Integer.MAX_VALUE;
        r16 = 0;
        goto L22
    L15:
        r14 = r11.getInt("android.media.browse.extra.PAGE_SIZE", -1);
        goto L16
    L12:
        r13 = r10.getInt("android.media.browse.extra.PAGE_SIZE", -1);
        goto L13
    L8:
        r12 = r11.getInt("android.media.browse.extra.PAGE", -1);
        goto L10
    L5:
        r5 = r10.getInt("android.media.browse.extra.PAGE", -1);
        goto L6
    }
}
