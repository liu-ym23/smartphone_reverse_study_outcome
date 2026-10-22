package q59;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class b {
    public static final a b(Map<String, ? extends Object> r9) {
        String r1 = a(r9, "priority_broadcast_switch");
        String r2 = a(r9, "notification_frequence");
        String r3 = a(r9, "notification_social_private_chat_mode");
        String r4 = a(r9, "notification_social_group_chat_mode");
        String r5 = a(r9, "notification_social_special_chat_mode");
        if (r9 == null) goto L11;
        Object r6 = r9.get("notification_social_special_chat_list");
        if (r6 == null) goto L11;
        if ((r6 instanceof String) == false) goto L10;
        String r7 = (String) r6;
    L12:
        if (r9 == null) goto L21;
        Object r10 = r9.get("notification_service_config_list");
        if (r10 == null) goto L21;
        if ((r10 instanceof String) == false) goto L19;
        String r11 = (String) r10;
    L20:
        String r8 = r11;
    L23:
        return new a(r1, r2, r3, r4, r5, r7, r8);
    L19:
        r11 = GsonProtectorUtils.toJson(new Gson(), r10);
    L21:
        r8 = null;
        goto L23
    L10:
        r7 = GsonProtectorUtils.toJson(new Gson(), r6);
    L11:
        r7 = null;
        goto L12
    }

    public static final String a(Map<String, ? extends Object> r0, String r1) {
        if (r0 == null) goto L8;
        Object r2 = r0.get(r1);
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.toString();
    L8:
        return null;
    }
}
