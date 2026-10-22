package com.bytedance.android.livesdk.gift.platform.business.tray2.manager.dispatcher;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.gift.platform.business.normal.model.NormalGiftMessage;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {
    public static final void b(List r5, NormalGiftMessage r6) {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("sender_user_id", r6.getFromUserId());
        r0.put("send_time", Long.valueOf(r6.G));
        IBaseUser r1 = r6.e;
        String r2 = BuildConfig.FLAVOR;
        if (r1 == null) goto L18;
        k r3 = r1.getAvatarThumbKt();
        if (r3 == null) goto L18;
        List r4 = r3.getUrls();
        if (r4 == null) goto L18;
        if (r4.size() <= 0) goto L11;
        boolean r7 = true;
    L12:
        if (r7 == true) goto L15;
        r4 = null;
    L15:
        if (r4 == null) goto L18;
        String r8 = (String) ListProtector.get(r4, 0);
        if (r8 == null) goto L18;
    L19:
        r0.put("sender_avatar", r8);
        IBaseUser r9 = r6.e;
        if (r9 == null) goto L24;
        String r10 = r9.getNickName();
        if (r10 == null) goto L24;
        r2 = r10;
    L24:
        r0.put("sender_name", r2);
        ((ArrayList) r5).add(r0);
        return;
    L11:
        r7 = false;
    L18:
        r8 = BuildConfig.FLAVOR;
        goto L19
    }

    public static final void a(Map r2, long r3, int r5, long r6) {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("gift_id", Long.valueOf(r3));
        r0.put("money", Integer.valueOf(r5));
        r2.put(String.valueOf(r6), r0);
    }
}
