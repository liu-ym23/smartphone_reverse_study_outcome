package com.bytedance.android.livesdk.interactivity.im;

import am2.x;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.im.ConsultInfo;
import com.bytedance.android.livesdkapi.depend.model.live.im.IMIndustryServiceInfo;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(DataCenter r5) {
        HashMap r0 = new HashMap();
        if (r5 != null) goto L5;
    L7:
        if (r5 == null) goto L17;
        Room r6 = z.o(r5);
        if (r6 == null) goto L17;
        IMIndustryServiceInfo r7 = r6.imIndustryServiceInfo;
        if (r7 == null) goto L17;
        ConsultInfo r8 = r7.get_consultInfo();
        if (r8 == null) goto L17;
        if (r8.get_roles() != 2) goto L17;
        String r9 = "manager";
    L18:
        r0.put("user_role", r9);
        u.l().sendLog("livesdk_im_entrance_click", new HashMap(), new Object[]{x.class, Room.class});
        return;
    L17:
        r9 = "audience";
        goto L18
    L5:
        if (z.e(r5, false) != true) goto L7;
        r9 = "anchor";
        goto L18
    }

    public static void b(DataCenter r5) {
        HashMap r0 = new HashMap();
        if (r5 != null) goto L5;
    L7:
        if (r5 == null) goto L17;
        Room r6 = z.o(r5);
        if (r6 == null) goto L17;
        IMIndustryServiceInfo r7 = r6.imIndustryServiceInfo;
        if (r7 == null) goto L17;
        ConsultInfo r8 = r7.get_consultInfo();
        if (r8 == null) goto L17;
        if (r8.get_roles() != 2) goto L17;
        String r9 = "manager";
    L18:
        r0.put("user_role", r9);
        u.l().sendLog("livesdk_im_entrance_show", new HashMap(), new Object[]{x.class, Room.class});
        return;
    L17:
        r9 = "audience";
        goto L18
    L5:
        if (z.e(r5, false) != true) goto L7;
        r9 = "anchor";
        goto L18
    }
}
