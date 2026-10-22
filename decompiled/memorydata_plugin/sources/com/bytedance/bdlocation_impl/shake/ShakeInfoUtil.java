package com.bytedance.bdlocation_impl.shake;

import com.bytedance.bdlocation.scan.bluetooth.BDBleInfo;
import com.bytedance.bdlocation.utils.json.JsonUtil;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ShakeInfoUtil {
    public ShakeInfoUtil() {
    }

    public static JsonArray getBleInfoArray(List<BDBleInfo> r2) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L5;
        return null;
    L5:
        JsonElement r4 = JsonUtil.toJsonTreeSafely(r3, new AnonymousClass1().getType());
        if (r4 != null) goto L8;
    L12:
        return null;
    L8:
        if (r4.isJsonArray() == false) goto L12;
        return r4.getAsJsonArray();
    }
}
