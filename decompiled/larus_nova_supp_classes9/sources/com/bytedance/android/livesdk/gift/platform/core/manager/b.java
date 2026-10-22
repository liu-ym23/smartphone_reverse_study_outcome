package com.bytedance.android.livesdk.gift.platform.core.manager;

import androidx.lifecycle.Observer;
import com.bytedance.android.livesdk.gift.configmodel.z1;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b<T> implements Observer {
    public static final b a = null;

    static {
        a = new b();
    }

    public b() {
    }

    public final void onChanged(Object r4) {
        KVData r5 = (KVData) r4;
        if (((z1) com.bytedance.android.livesdk.gift.platform.core.g.c.getValue(null, com.bytedance.android.livesdk.gift.platform.core.g.a[1])).a() == true) goto L5;
        ay1.d.d.setValue(null, ay1.d.a[5], Boolean.TRUE);
    L5:
        WeakReference<DataCenter> r6 = GiftEffectManager.b;
        if (r6 == null) goto L11;
        DataCenter r7 = r6.get();
        if (r7 == null) goto L12;
        r7.put("cmd_toggle_gift_video_view", Boolean.valueOf(ay1.d.b()));
        return;
    L12:
        return;
    }
}
