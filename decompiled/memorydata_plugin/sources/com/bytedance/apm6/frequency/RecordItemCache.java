package com.bytedance.apm6.frequency;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
class RecordItemCache {
    private static ThreadLocal<ArrayList<RecordItem>> listCache;

    static {
        listCache = new AnonymousClass1();
    }

    RecordItemCache() {
    }

    public static RecordItem getCacheItem() {
        ArrayList r0 = (ArrayList) ZeusTransformUtils.preCheckCast(listCache.get(), ArrayList.class, "com.obric.memorydata.plugin");
        int r1 = 0;
        if (((RecordItem) ZeusTransformUtils.preCheckCast(r0.get(0), RecordItem.class, "com.obric.memorydata.plugin")).isUsing() == false) goto L5;
        r1 = 1;
        if (((RecordItem) ZeusTransformUtils.preCheckCast(r0.get(1), RecordItem.class, "com.obric.memorydata.plugin")).isUsing() == false) goto L5;
        return null;
    L5:
        return (RecordItem) ZeusTransformUtils.preCheckCast(r0.get(r1), RecordItem.class, "com.obric.memorydata.plugin");
    }
}
