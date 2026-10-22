package com.bytedance.apm6.frequency;

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
        ArrayList<RecordItem> r10 = listCache.get();
        int r11 = 0;
        if (r10.get(0).isUsing() == false) goto L5;
        r11 = 1;
        if (r10.get(1).isUsing() == false) goto L5;
        return null;
    L5:
        return r10.get(r11);
    }
}
