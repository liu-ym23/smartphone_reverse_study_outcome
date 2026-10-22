package com.bytedance.android.live.core.feature;

import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b<T> implements Consumer {
    public b() {
    }

    public final void accept(Object r7) {
        Map<String, DynamicDataRespItem> r8 = ((DynamicDataResp) ((BaseResponse) ((Response) r7)).data).getAnchorInfos();
        long r0 = System.currentTimeMillis();
        if (r8 == null) goto L10;
        Set<Map.Entry<String, DynamicDataRespItem>> r9 = r8.entrySet();
        if (r9 == null) goto L12;
        Iterator<T> r11 = r9.iterator();
    L8:
        if (r11.hasNext() == false) goto L13;
        Map.Entry r2 = (Map.Entry) r11.next();
        ((DynamicDataRespItem) r2.getValue()).setTimeStrap(r0);
        a<String, DynamicDataRespItem> r3 = RoomFeatureUtils.b;
        Object r4 = r2.getKey();
        r3.a((String) r4, (DynamicDataRespItem) r2.getValue());
        ((DynamicDataRespItem) r2.getValue()).getRoomId();
        goto L8
    L13:
        return;
    L12:
        return;
    }
}
