package com.bytedance.map.api.utils;

import androidx.room.vo.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class CommonUtil {
    public static int[] a(HashMap r5) {
        ArrayList r10 = new ArrayList(r5.entrySet());
        Collections.sort(r10, new a(3));
        return new int[]{((Integer) ((Map.Entry) r10.get(0)).getKey()).intValue(), ((Integer) ((Map.Entry) r10.get(0)).getValue()).intValue()};
    }

    public static /* synthetic */ int a(Map.Entry r5, Map.Entry r10) {
        return ((Integer) r5.getValue()).intValue() - ((Integer) r10.getValue()).intValue();
    }
}
