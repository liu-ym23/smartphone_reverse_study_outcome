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
        int r12 = -1;
    L6:
        if (r11 != null) goto L8;
        int r13 = -1;
    L10:
        if (r10 != null) goto L12;
        int r14 = -1;
    L13:
        if (r11 != null) goto L15;
        int r15 = -1;
    L16:
        int r16 = Integer.MAX_VALUE;
        if (r12 == (-1)) goto L21;
        if (r14 == (-1)) goto L21;
        int r17 = r12 * r14;
        int r18 = (r14 + r17) - 1;
    L22:
        if (r13 == (-1)) goto L26;
        if (r15 == (-1)) goto L26;
        int r19 = r13 * r15;
        r16 = (r15 + r19) - 1;
    L27:
        if (r18 < r19) goto L31;
        if (r16 < r17) goto L31;
        return true;
    L31:
        return false;
    L26:
        r19 = 0;
    L21:
        r18 = Integer.MAX_VALUE;
        r17 = 0;
        goto L22
    L15:
        r15 = r11.getInt("android.media.browse.extra.PAGE_SIZE", -1);
        goto L16
    L12:
        r14 = r10.getInt("android.media.browse.extra.PAGE_SIZE", -1);
        goto L13
    L8:
        r13 = r11.getInt("android.media.browse.extra.PAGE", -1);
        goto L10
    L5:
        r12 = r10.getInt("android.media.browse.extra.PAGE", -1);
        goto L6
    }
}
