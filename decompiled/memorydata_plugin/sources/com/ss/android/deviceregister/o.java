package com.ss.android.deviceregister;

import android.content.Context;
import com.bytedance.bdinstall.loader.SstLoader;
import com.ss.android.deviceregister.a.u;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
final class o {
    static void a(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        n r0 = new n(r4);
        if (r0.b() == false) goto L5;
        h.b(r4);
        com.ss.android.deviceregister.b.a.a r1 = g.a(r4);
        u.b(r1.b());
        r1.b("openudid");
        r1.b("clientudid");
        r1.b("serial_number");
        r1.b("sim_serial_number");
        r1.b(SstLoader.KEY_UDID);
        r1.b(SstLoader.KEY_UDID_LIST);
        r1.b("device_id");
        f.a(r4, "clearMigrationInfo");
    L5:
        r0.a();
    }
}
