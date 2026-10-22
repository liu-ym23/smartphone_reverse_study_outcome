package com.bytedance.bdinstall.dtrait;

import com.bytedance.bdinstall.dtrait.constant.DTraitRiskType;
import com.bytedance.bdinstall.dtrait.manager.DTraitServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class DTraitApi {
    public DTraitApi() {
    }

    public static Map<String, String> getDTrait(String r3, DTraitRiskType r4, int r5) {
        DTraitService r0 = (DTraitService) ZeusTransformUtils.preCheckCast(DTraitServiceManager.getService(DTraitService.class), DTraitService.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L7;
        return r0.getDTraitManager().getDTrait(r3, r4, r5);
    L7:
        return new HashMap();
    }
}
