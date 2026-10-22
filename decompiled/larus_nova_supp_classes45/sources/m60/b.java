package m60;

import android.content.Context;
import android.os.Build;
import androidx.collection.SimpleArrayMap;
import androidx.core.content.PermissionChecker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b {
    public static final SimpleArrayMap<String, Integer> a = null;

    static {
        SimpleArrayMap<String, Integer> r0 = new SimpleArrayMap(8);
        a = r0;
        r0.put("com.android.voicemail.permission.ADD_VOICEMAIL", 14);
        r0.put("android.permission.BODY_SENSORS", 20);
        r0.put("android.permission.BODY_SENSORS_BACKGROUND", 33);
        r0.put("android.permission.READ_CALL_LOG", 16);
        r0.put("android.permission.READ_EXTERNAL_STORAGE", 16);
        r0.put("android.permission.USE_SIP", 9);
        r0.put("android.permission.WRITE_CALL_LOG", 16);
        r0.put("android.permission.SYSTEM_ALERT_WINDOW", 23);
        r0.put("android.permission.WRITE_SETTINGS", 23);
        r0.put("android.permission.READ_MEDIA_IMAGES", 33);
        r0.put("android.permission.READ_MEDIA_VIDEO", 33);
        r0.put("android.permission.READ_MEDIA_AUDIO", 33);
        r0.put("android.permission.READ_MEDIA_VISUAL_USER_SELECTED", 34);
        r0.put("android.permission.ACCESS_MEDIA_LOCATION", 29);
    }

    public static boolean a(Context r7, String... r8) {
        int r0 = r8.length;
        int r2 = 0;
    L3:
        boolean r3 = true;
        if (r2 >= r0) goto L20;
        String r4 = r8[r2];
        Integer r5 = (Integer) a.get(r4);
        if (r5 != null) goto L8;
    L11:
        boolean r6 = true;
    L12:
        if (r6 == false) goto L19;
        if (PermissionChecker.checkSelfPermission(r7, r4) != 0) goto L16;
    L17:
        if (r3 == true) goto L19;
        return false;
    L16:
        r3 = false;
    L19:
        r2 = r2 + 1;
        goto L3
    L8:
        if (Build.VERSION.SDK_INT >= r5.intValue()) goto L11;
        r6 = false;
        goto L12
    L20:
        return true;
    }
}
