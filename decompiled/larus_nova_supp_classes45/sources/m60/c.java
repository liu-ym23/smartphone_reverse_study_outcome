package m60;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import androidx.collection.SimpleArrayMap;
import androidx.core.app.ActivityCompat;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.livehostapi.platform.IMiddlewareHostAction;
import com.bytedance.bpea.cert.token.TokenCert;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jc1.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c {
    public static final Map<String, Integer> a = null;

    static {
        HashMap r0 = new HashMap();
        a = r0;
        r0.put("android.permission.READ_CALENDAR", 2131921331);
        r0.put("android.permission.WRITE_CALENDAR", 2131921331);
        r0.put("android.permission.CAMERA", 2131921334);
        r0.put("android.permission.ACCESS_COARSE_LOCATION", 2131921340);
        r0.put("android.permission.ACCESS_FINE_LOCATION", 2131921340);
        r0.put("android.permission.RECORD_AUDIO", 2131921345);
        r0.put("android.permission.READ_PHONE_STATE", 2131921344);
        r0.put("android.permission.CALL_PHONE", 2131921332);
        r0.put("android.permission.READ_CALL_LOG", 2131921333);
        r0.put("android.permission.WRITE_CALL_LOG", 2131921333);
        r0.put("com.android.voicemail.permission.ADD_VOICEMAIL", 2131921332);
        r0.put("android.permission.USE_SIP", 2131921332);
        r0.put("android.permission.PROCESS_OUTGOING_CALLS", 2131921332);
        r0.put("android.permission.BODY_SENSORS", 2131921346);
        int r2 = Build.VERSION.SDK_INT;
        if (r2 < 33) goto L5;
        r0.put("android.permission.BODY_SENSORS_BACKGROUND", 2131921346);
    L5:
        r0.put("android.permission.SEND_SMS", 2131921347);
        r0.put("android.permission.RECEIVE_SMS", 2131921347);
        r0.put("android.permission.READ_SMS", 2131921347);
        r0.put("android.permission.RECEIVE_WAP_PUSH", 2131921347);
        r0.put("android.permission.RECEIVE_MMS", 2131921347);
        r0.put("android.permission.READ_EXTERNAL_STORAGE", 2131921339);
        if (r2 < 33) goto L9;
        r0.put("android.permission.READ_MEDIA_IMAGES", 2131921339);
        r0.put("android.permission.READ_MEDIA_VIDEO", 2131921339);
        r0.put("android.permission.READ_MEDIA_AUDIO", 2131921339);
    L9:
        if (r2 < 34) goto L11;
        r0.put("android.permission.READ_MEDIA_VISUAL_USER_SELECTED", 2131921339);
    L11:
        r0.put("android.permission.BLUETOOTH_CONNECT", 2131921330);
    }

    public static String[] a(Activity r6, String... r7) {
        ArrayList r0 = new ArrayList();
        int r1 = r7.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L9;
        String r4 = r7[r3];
        if (d(r6, new String[]{r4}) == true) goto L7;
        r0.add(r4);
    L7:
        r3 = r3 + 1;
        goto L3
    L9:
        return (String[]) r0.toArray(new String[r0.size()]);
    }

    public static boolean b(Context r3, TokenCert r4) {
        if (LiveInfraSettingKeys.LIVE_EZPERMISSION_QUERY.getValue().booleanValue() == false) goto L9;
        if (jc1.a.c() == true) goto L9;
        return k.f(IMiddlewareHostAction.class).isGranted(r3, new String[]{"android.permission.RECORD_AUDIO"});
    L9:
        if (Build.VERSION.SDK_INT < 23) goto L15;
        Map<String, p60.c> r0 = p60.e.b;
        if (p60.e.a.a.b() == true) goto L15;
        return b.a(r3, new String[]{"android.permission.RECORD_AUDIO"});
    L15:
        return n60.a.b(r4);
    }

    public static boolean c(Context r1, List<String> r2) {
        if (r2 != null) goto L6;
        return true;
    L6:
        return d(r1, (String[]) r2.toArray(new String[r2.size()]));
    }

    public static boolean d(Context r2, String... r3) {
        if (r3 != null) goto L6;
        return true;
    L6:
        if (LiveInfraSettingKeys.LIVE_EZPERMISSION_QUERY.getValue().booleanValue() == false) goto L12;
        if (jc1.a.c() == true) goto L12;
        return k.f(IMiddlewareHostAction.class).isGranted(r2, r3);
    L12:
        if (Build.VERSION.SDK_INT < 23) goto L18;
        Map<String, p60.c> r0 = p60.e.b;
        if (p60.e.a.a.b() == true) goto L18;
        return b.a(r2, r3);
    L18:
        return n60.e.a.a.b(r2, r3);
    }

    public static boolean e(Activity r4, String... r5) {
        if (r5 != null) goto L5;
        return false;
    L5:
        SimpleArrayMap<String, Integer> r1 = b.a;
        int r2 = r5.length;
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L14;
        if (ActivityCompat.shouldShowRequestPermissionRationale(r4, r5[r3]) == true) goto L9;
        r3 = r3 + 1;
        goto L6
    L9:
        return true;
    L14:
        return false;
    }

    public static boolean f(Activity r4, String[] r5, int[] r6) {
        if (r6.length != 0) goto L5;
        return false;
    L5:
        int r0 = r6.length;
        int r2 = 0;
    L6:
        if (r2 >= r0) goto L11;
        if (r6[r2] != 0) goto L9;
        r2 = r2 + 1;
        goto L6
    L9:
        return false;
    L11:
        Map<String, p60.c> r7 = p60.e.b;
        if (p60.e.a.a.b() == true) goto L14;
        return true;
    L14:
        return d(r4, r5);
    }
}
