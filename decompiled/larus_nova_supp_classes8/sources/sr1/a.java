package sr1;

import com.bytedance.android.live.core.cache.LruCache;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.BubbleId;
import com.bytedance.android.livesdk.chatroom.vs_base.base.setting.VSSettingKeys;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.android.livesdkapi.depend.model.live.vs.BusinessConfigure;
import com.bytedance.android.livesdkapi.depend.model.live.vs.BusinessResourceConfigure;
import j40.f4;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import xs1.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String b(Long r5) {
        long r0 = BusinessConfigure.BusinessType.WEAK_BARRAGE;
        if (r5 != null) goto L6;
    L8:
        long r1 = BusinessConfigure.BusinessType.STRONG_BARRAGE;
        if (r5 != null) goto L12;
    L14:
        long r2 = BusinessConfigure.BusinessType.SCREEN_BAR;
        if (r5 != null) goto L18;
    L20:
        return "";
    L18:
        if (r5.longValue() != r2) goto L20;
        return "pic";
    L12:
        if (r5.longValue() != r1) goto L14;
    L13:
        return "logo";
    L6:
        if (r5.longValue() != r0) goto L8;
        goto L8
    }

    public static boolean d(BusinessConfigure r5) {
        long r0 = System.currentTimeMillis() - r5.expectedShowTS;
        StringBuilder r2 = new StringBuilder("shouldDiscard expected show time ");
        r2.append(Long.valueOf(r5.expectedShowTS));
        r2.append(", current time ");
        r2.append(System.currentTimeMillis());
        r2.append(", waiting time ");
        r2.append(r0);
        r2.append(" discard duration ");
        SettingKey<e> r6 = VSSettingKeys.LIVE_BUSINESS_INFORMATION_CONFIG;
        r2.append(((e) r6.getValue()).a());
        ALogger.i("BusinessConfigure", r2.toString());
        if (r0 <= (((e) r6.getValue()).a() * BubbleId.PadCast)) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean a(String r6, BusinessConfigure r7) {
        if (v.a() == true) goto L5;
    L7:
        StringBuilder r0 = new StringBuilder();
        r0.append(String.valueOf(r6));
        r0.append("_");
        BusinessResourceConfigure r2 = r7.resourceConfig;
        if (r2 == null) goto L10;
        Long r3 = Long.valueOf(r2.resourceId);
    L11:
        r0.append(String.valueOf(r3));
        String r1 = r0.toString();
        if (r7.deliveryType == BusinessConfigure.DeliveryType.ENTER) goto L14;
    L25:
        return true;
    L14:
        if (r6 != null) goto L16;
    L19:
        boolean r8 = true;
    L20:
        if (r8 == true) goto L25;
        if (((LruCache) f4.u.getValue()).get(r1) == null) goto L25;
        ALogger.i("BusinessConfigure", "business resource already show, userid_resourceId is " + r1);
        return false;
    L16:
        if (r6.length() == 0) goto L19;
        r8 = false;
        goto L20
    L10:
        r3 = null;
        goto L11
    L5:
        if (((e) VSSettingKeys.LIVE_BUSINESS_INFORMATION_CONFIG.getValue()).d() == true) goto L7;
        return true;
    }

    public static void c(String r7, String r8, BusinessConfigure r9, Map r10) {
        Intrinsics.checkNotNullParameter(r7, "eventName");
        Intrinsics.checkNotNullParameter(r8, "pagePosition");
        LinkedHashMap r3 = new LinkedHashMap();
        r3.put("position", "live");
        r3.put("position_page", r8);
        if (r10 == null) goto L5;
        r3.putAll(r10);
    L5:
        if (r9 == null) goto L12;
        r3.put("business_id", String.valueOf(r9.businessId));
        BusinessResourceConfigure r11 = r9.resourceConfig;
        if (r11 == null) goto L10;
        String r12 = String.valueOf(r11.resourceId);
        if (r12 == null) goto L10;
    L11:
        r3.put("resource_id", r12);
        r3.put("resource_scene", b(Long.valueOf(r9.businessType)));
    L10:
        r12 = "";
    L12:
        r.l().s(r7, r3, "", "", "");
    }
}
