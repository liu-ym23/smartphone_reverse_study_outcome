package o0c;

import android.app.Application;
import com.bytedance.i18n.claymore.ClaymoreServiceLoader;
import com.larksuite.framework.utils.ICUUtils;
import com.larksuite.framework.utils.UIUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b {
    public static final Map<String, a> a = null;

    public static class a {
        public final String a;
        public final String b;
        public final String c;

        public a(String r1, String r2, String r3, int r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    static {
        HashMap r0 = new HashMap();
        a = r0;
        Application r1 = com.larksuite.framework.utils.b.a;
        if (r1 == null) goto L12;
        r0.put("android.permission.RECORD_AUDIO", new a("Audio", UIUtils.getString(r1, 2131890651), UIUtils.getString(r1, 2131890641), 2131255118));
        r0.put("android.permission.CAMERA", new a("Camera", UIUtils.getString(r1, 2131890647), UIUtils.getString(r1, 2131890637), 2131254023));
        a r2 = new a("Storage", UIUtils.getString(r1, 2131890650), UIUtils.getString(r1, 2131890640), 2131254780);
        r0.put("android.permission.READ_EXTERNAL_STORAGE", r2);
        r0.put("android.permission.WRITE_EXTERNAL_STORAGE", r2);
        r0.put("android.permission.READ_MEDIA_AUDIO", r2);
        r0.put("android.permission.READ_MEDIA_IMAGES", r2);
        r0.put("android.permission.READ_MEDIA_VIDEO", r2);
        r0.put("android.permission.MANAGE_EXTERNAL_STORAGE", r2);
        r0.put("android.permission.READ_MEDIA_VISUAL_USER_SELECTED", r2);
        o0c.a r3 = (o0c.a) ClaymoreServiceLoader.loadFirst(o0c.a.class);
        String r4 = UIUtils.getString(r1, 2131892375);
        if (r3.isLarkPackage() == false) goto L7;
        r4 = UIUtils.getString(r1, 2131890639);
    L7:
        a r5 = new a("Location", UIUtils.getString(r1, 2131890649), r4, 2131255042);
        r0.put("android.permission.ACCESS_FINE_LOCATION", r5);
        r0.put("android.permission.ACCESS_COARSE_LOCATION", r5);
        r0.put("android.permission.ACCESS_BACKGROUND_LOCATION", r5);
        String r6 = UIUtils.getString(r1, 2131890655);
        if (r3.isLarkPackage() == false) goto L10;
        r6 = UIUtils.getString(r1, 2131890635);
    L10:
        a r7 = new a("Bluetooth", UIUtils.getString(r1, 2131890645), r6, 2131253861);
        r0.put("android.permission.BLUETOOTH_SCAN", r7);
        r0.put("android.permission.BLUETOOTH_ADVERTISE", r7);
        r0.put("android.permission.BLUETOOTH_CONNECT", r7);
        String r8 = UIUtils.getString(r1, 2131890638);
        ICUUtils.FormatArgsBuilder r9 = new ICUUtils.FormatArgsBuilder();
        r9.b("APP_DISPLAY_NAME", r3.getAppDisplayName());
        String r10 = ICUUtils.icuFormat(r8, r9.a);
        a r11 = new a("Contact", UIUtils.getString(r1, 2131890648), r10, 2131254159);
        r0.put("android.permission.READ_CONTACTS", r11);
        r0.put("android.permission.WRITE_CONTACTS", r11);
        a r12 = new a("Calendar", UIUtils.getString(r1, 2131890646), UIUtils.getString(r1, 2131890636), 2131253988);
        r0.put("android.permission.READ_CALENDAR", r12);
        r0.put("android.permission.WRITE_CALENDAR", r12);
        a r13 = new a("CallPhone", UIUtils.getString(r1, 2131890652), UIUtils.getString(r1, 2131890642), 2131254014);
        r0.put("android.permission.READ_PHONE_NUMBERS", r13);
        r0.put("android.permission.CALL_PHONE", r13);
        r0.put("android.permission.ANSWER_PHONE_CALLS", r13);
        r0.put("com.android.voicemail.permission.ADD_VOICEMAIL", r13);
        r0.put("android.permission.USE_SIP", r13);
        r0.put("android.permission.READ_PHONE_STATE", new a("PhoneState", UIUtils.getString(r1, 2131890653), UIUtils.getString(r1, 2131890643), 2131254012));
        r0.put("android.permission.ACTIVITY_RECOGNITION", new a("ActivityRecognition", UIUtils.getString(r1, 2131890654), UIUtils.getString(r1, 2131890644), 2131254204));
        return;
    }
}
