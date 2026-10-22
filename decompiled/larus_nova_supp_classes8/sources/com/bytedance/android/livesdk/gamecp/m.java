package com.bytedance.android.livesdk.gamecp;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.android.live.saas.middleware.BDLiveSdk;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livehostapi.foundation.IHostContext;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class m implements bw.d {
    public m() {
    }

    public final void L1() {
    }

    public final boolean c() {
        return true;
    }

    public final void getAppIcon() {
    }

    public final String M() {
        return jc1.k.n(IHostContext.class).getServerDeviceId();
    }

    public final int getAppId() {
        return jc1.k.n(IHostContext.class).appId();
    }

    public final String getAppName() {
        return jc1.k.n(IHostContext.class).appName();
    }

    public final String getChannel() {
        return jc1.k.n(IHostContext.class).getChannel();
    }

    public final String getPackageName() {
        return jc1.k.n(IHostContext.class).getPackageName();
    }

    public final int getUpdateVersionCode() {
        return jc1.k.n(IHostContext.class).getUpdateVersionCode();
    }

    public final long getVersionCode() {
        String r0 = jc1.k.n(IHostContext.class).getVersionCode();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return CastLongProtector.parseLong(r0);
    }

    public final String getVersionName() {
        return jc1.k.n(IHostContext.class).getVersionName();
    }

    public final int hostAppId() {
        return jc1.k.n(IHostContext.class).hostAppId();
    }

    public final boolean isBoe() {
        return jc1.k.n(IHostContext.class).isBoe();
    }

    public final HashMap<String, String> o1() {
        HashMap<String, String> r0 = new HashMap();
        com.bytedance.android.dy.saas.utuid.d r1 = BDLiveSdk.getUtUid();
        if (r1 != null) goto L5;
    L7:
        od1.a r2 = jc1.k.n(od1.a.class);
        String r3 = r2.getAccessToken();
        if (r3 == null) goto L10;
        r0.put("Authorization", "Bearer ".concat(r3));
        r0.put("bd-ticket-guard-target", r3);
    L10:
        String r4 = r2.getOpenId();
        if (r4 == null) goto L13;
        r0.put("OpenId", r4);
    L13:
        r0.put("ClientKey", BDLiveSdk.getAppInfo().clientKey());
        nn2.a r5 = nn2.a.d;
        String r6 = nn2.a.a.a().c;
        if (TextUtils.isEmpty(r6) == true) goto L16;
        r0.put("id-sign", r6);
    L16:
        return r0;
    L5:
        if (r1.a() == false) goto L7;
        r0.put("csuu", r1.getSalt() + "#" + r1.c() + "#" + r1.getSecUid());
        goto L7
    }

    public final Context getAppContext() {
        return jc1.a.b();
    }

    public final Application getApplication() {
        return jc1.a.b();
    }

    public final String getDeviceId() {
        return jta.g.d();
    }

    public final String getDevicePlatform() {
        if (PadConfigUtils.c() == false) goto L5;
        return "Android_Pad";
    L5:
        return "Android";
    }

    public final boolean isLocalTest() {
        return com.bytedance.android.live.core.utils.v.a();
    }

    public final String l() {
        String r0 = TTLiveSDK.hostService().user().hostUserIdentifier();
        if (mz.c.b(r0) == true) goto L5;
        return r0;
    L5:
        return "";
    }
}
