package com.bytedance.android.live.liveinteract.plantform.utils;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.config.z01;
import com.bytedance.android.livesdkapi.depend.model.live.linker.CPositionModeUtil;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class z {
    public final int a;
    public int b;
    public final boolean c;
    public final int d;
    public int e;
    public boolean f;
    public long g;
    public long h;
    public long i;

    public static final class a {
    }

    static {
    }

    public z() {
        z01 r0 = vm2.d.m();
        this.a = r0.fatalRollbackLimit;
        this.c = r0.monitorVersionRollback;
        this.d = r0.zeroVersionLimit;
        this.f = r0.monitorZeroVersion;
        this.g = System.currentTimeMillis();
        this.h = System.currentTimeMillis();
        this.i = System.currentTimeMillis();
    }

    public static String b(com.bytedance.android.livesdk.link.model.bridge.k r3) {
        StringBuilder r0 = new StringBuilder("AnchorLinkUser{uid=");
        IBaseUser r1 = r3.getUser();
        if (r1 == null) goto L5;
        String r2 = r1.getIdString();
    L6:
        r0.append(r2);
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
    L5:
        r2 = null;
        goto L6
    }

    public static void a(Map r1, String r2, long r3, com.bytedance.android.live.liveinteract.plantform.core.y.a r5) {
        r1.put("from", r2);
        r1.put("current_version", Long.valueOf(r3));
        r1.put("refresh_info", String.valueOf(r5));
    }
}
