package com.bytedance.android.live.revenue.common;

import android.text.TextUtils;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class l0 {
    static {
    }

    public static boolean a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "business");
        String r0 = ((l01.d) com.bytedance.android.live.revenue.core.util.f.a(l01.d.class)).getCurrentUserId();
        yz0.k r1 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r1 == null) goto L7;
        IRoom r2 = r1.getRoom();
        if (r2 == null) goto L7;
        String r4 = r2.getOwnerUserIdString();
    L9:
        if (TextUtils.equals(r0, r4) == false) goto L11;
        return false;
    L11:
        a50.a r5 = (a50.a) LiveInfraSettingKeys.LIVE_ROOM_BACKEND_BUSINESS_SWITCH.getValue();
        if (r5 != null) goto L14;
        return false;
    L14:
        switch(r3.hashCode()) {
            case -1482948886: goto L36;
            case -1354491421: goto L29;
            case 3625706: goto L26;
            case 95849015: goto L23;
            case 354670409: goto L20;
            case 498005562: goto L17;
            default: goto L53;
        };
    L53:
        return false;
    L17:
        if (r3.equals("taskCenter") == true) goto L41;
        return false;
    L41:
        return r5.n();
    L20:
        if (r3.equals("lottery") == true) goto L43;
        return false;
    L43:
        return r5.f();
    L23:
        if (r3.equals("dress") == true) goto L45;
        return false;
    L45:
        return r5.c();
    L26:
        if (r3.equals("vote") == true) goto L47;
        return false;
    L47:
        return r5.o();
    L29:
        if (r3.equals("luckybox") == true) goto L31;
        return false;
    L31:
        if (r5.g() == true) goto L33;
        return false;
    L33:
        if (b0.b().b0() != 0) goto L50;
        return true;
    L50:
        return false;
    L36:
        if (r3.equals("groupUser") == true) goto L38;
        return false;
    L38:
        return r5.d();
    L7:
        r4 = null;
        goto L9
    }
}
