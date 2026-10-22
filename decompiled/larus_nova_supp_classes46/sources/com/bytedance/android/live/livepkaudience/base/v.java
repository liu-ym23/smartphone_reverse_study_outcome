package com.bytedance.android.live.livepkaudience.base;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.multianchor.model.AnchorLinkUser;
import com.bytedance.android.livesdk.config.k9;
import com.bytedance.android.livesdk.config.z01;
import com.bytedance.android.livesdk.utils.d5;
import com.bytedance.android.livesdkapi.depend.model.live.linker.CPositionModeUtil;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class v {
    public final int a;
    public int b;
    public final boolean c;
    public long d;

    public static final class a {
    }

    static {
    }

    public v() {
        z01 r0 = (z01) k9.a.getValue();
        this.a = r0.fatalRollbackLimit;
        this.c = r0.monitorVersionRollback;
        this.d = System.currentTimeMillis();
    }

    public static String a(AnchorLinkUser r3) {
        StringBuilder r0 = new StringBuilder("AnchorLinkUser{uid=");
        IBaseUser r1 = r3.getUser();
        if (r1 == null) goto L7;
        String r2 = r1.getIdString();
        if (r2 == null) goto L7;
        Long r4 = Long.valueOf(d5.c(r2));
    L8:
        r0.append(r4);
        r0.append(",linkId=");
        r0.append(r3.getLinkMicIdStr());
        r0.append(",linkType=");
        r0.append(r3.getLinkType());
        r0.append(",silence=");
        r0.append(r3.getSilenceStatus());
        r0.append(",userPos=");
        r0.append(r3.getUserPosition());
        r0.append(",mc=");
        r0.append(r3.getMcStatus());
        r0.append(",isBg=");
        r0.append(r3.isBackground());
        r0.append(", isCPos=");
        r0.append(CPositionModeUtil.isCPositionUser(r3));
        r0.append('}');
        return r0.toString();
    L7:
        r4 = null;
        goto L8
    }
}
