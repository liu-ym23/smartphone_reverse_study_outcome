package com.bytedance.android.live.revlink.impl.pk.feedview;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import com.bytedance.android.live.revlink.impl.settings.dynamic.LinkMultiDynamicSettingsKt;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class l<T> implements Observer {
    public final /* synthetic */ MediatorLiveData a;
    public final /* synthetic */ com.bytedance.android.live.revlink.impl.pk.feedview.bridge.c b;

    public l(MediatorLiveData r1, com.bytedance.android.live.revlink.impl.pk.feedview.bridge.c r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onChanged(Object r4) {
        Integer r5 = (Integer) r4;
        if (LinkMultiDynamicSettingsKt.a() <= 0) goto L9;
        if (r5 == null) goto L6;
        int r0 = r5.intValue();
    L8:
        if ((r0 % LinkMultiDynamicSettingsKt.a()) == 0) goto L9;
        return;
    L6:
        r0 = 0;
    L9:
        MediatorLiveData r1 = this.a;
        JSONObject r2 = new JSONObject();
        r2.put("remain_time", r5.intValue());
        com.bytedance.android.live.revlink.impl.pk.feedview.machine.l r6 = (com.bytedance.android.live.revlink.impl.pk.feedview.machine.l) this.b.e.getValue();
        if (r6 == null) goto L12;
        Integer r7 = Integer.valueOf(r6.b);
    L13:
        r2.put("state", r7);
        Unit r8 = Unit.INSTANCE;
        r1.setValue(r2);
        return;
    L12:
        r7 = null;
        goto L13
    }
}
