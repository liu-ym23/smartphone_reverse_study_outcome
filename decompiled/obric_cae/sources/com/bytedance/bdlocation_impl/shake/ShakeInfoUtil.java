package com.bytedance.bdlocation_impl.shake;

import com.bytedance.bdlocation.scan.bluetooth.BDBleInfo;
import com.bytedance.bdlocation.utils.json.JsonUtil;
import ha.m;
import ha.p;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ShakeInfoUtil {
    public ShakeInfoUtil() {
    }

    public static m getBleInfoArray(List<BDBleInfo> r8) {
        if (r8 != null) goto L5;
        return null;
    L5:
        p r10 = JsonUtil.toJsonTreeSafely(r8, new AnonymousClass1().getType());
        if (r10 != null) goto L8;
    L12:
        return null;
    L8:
        if ((r10 instanceof m) == false) goto L12;
        return r10.e();
    }
}
