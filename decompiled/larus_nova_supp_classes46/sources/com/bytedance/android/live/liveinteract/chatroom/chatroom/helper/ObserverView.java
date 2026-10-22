package com.bytedance.android.live.liveinteract.chatroom.chatroom.helper;

import android.view.View;
import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class ObserverView<V extends View> implements Observer<KVData> {
    public final void onChanged(Object r2) {
        KVData r3 = (KVData) r2;
        if (r3 != null) goto L5;
        return;
    L5:
        if (r3.getKey() != null) goto L7;
        return;
    L7:
        if (r3.getData() == null) goto L13;
        r3.getKey();
        r3.getData();
        throw null;
    }
}
