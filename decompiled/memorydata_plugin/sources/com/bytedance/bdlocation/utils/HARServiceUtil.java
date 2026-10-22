package com.bytedance.bdlocation.utils;

import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.network.model.HARStatus;
import com.ss.android.har.service.d;
import com.ss.android.har.service.e;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class HARServiceUtil {
    public HARServiceUtil() {
    }

    public static List<HARStatus> getHARStatusList() {
        ArrayList r0 = new ArrayList();
        List<e> r1 = d.a().a(BDLocationConfig.getHARStatusRange(), true);
        if (r1 != null) goto L5;
    L10:
        return r0;
    L5:
        if (r1.size() <= 0) goto L10;
        Iterator<e> r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L10;
        e r3 = (e) ZeusTransformUtils.preCheckCast(r2.next(), e.class, "com.obric.memorydata.plugin");
        HARStatus r4 = new HARStatus();
        r4.predict = r3.d;
        r4.timestamp = r3.e;
        r0.add(r4);
        goto L8
    }

    public static int getMaxHARStatus() {
        return d.a().b(BDLocationConfig.getHARStatusRange(), true);
    }
}
