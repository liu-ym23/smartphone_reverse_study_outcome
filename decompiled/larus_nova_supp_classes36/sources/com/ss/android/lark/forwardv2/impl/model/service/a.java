package com.ss.android.lark.forwardv2.impl.model.service;

import com.bytedance.lark.pb.feed.v1.GetRecentTransmitTargetsResponseV2;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.sdk.SdkSender;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a<T> implements SdkSender.IParser {
    public final /* synthetic */ boolean a;

    public a(boolean r1) {
        this.a = r1;
    }

    public final Object parse(byte[] r3) {
        GetRecentTransmitTargetsResponseV2 r4 = (GetRecentTransmitTargetsResponseV2) GetRecentTransmitTargetsResponseV2.ADAPTER.decode(r3);
        StringBuilder r0 = new StringBuilder("from local: ");
        r0.append(this.a);
        r0.append(", GetRecentTransmitTargetsResponseV2: ");
        if (r4 == null) goto L7;
        List r1 = r4.targets;
        if (r1 == null) goto L7;
        int r2 = r1.size();
    L8:
        r0.append(r2);
        r0.append(' ');
        Log.d("Android_Recent_Forward_V2", r0.toString());
        return r4;
    L7:
        r2 = 0;
        goto L8
    }
}
