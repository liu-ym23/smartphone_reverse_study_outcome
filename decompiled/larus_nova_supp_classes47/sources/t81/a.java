package t81;

import android.content.Context;
import android.media.AudioManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public static AudioManager a = null;
    public static int b = -1;

    public static int a(Context r1) {
        if (b(r1) == false) goto L7;
        return -1;
    L7:
        if (b >= 0) goto L10;
        b = a.getStreamMaxVolume(3);
    L10:
        return b;
    }

    public static boolean b(Context r1) {
        if (a != null) goto L8;
        a = (AudioManager) r1.getSystemService("audio");     // Catch: Exception -> L6
    L8:
        if (a != null) goto L10;
        return true;
    L10:
        return false;
    }
}
