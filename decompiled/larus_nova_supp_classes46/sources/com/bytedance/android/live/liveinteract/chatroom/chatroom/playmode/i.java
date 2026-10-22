package com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class i<T> implements Observer {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ ne0.c c;
    public final /* synthetic */ ne0.c d;

    public i(String r1, String r2, ne0.c r3, ne0.c r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void onChanged(Object r3) {
        KVData r4 = (KVData) r3;
        ALogger.i("PlayModeService", "childStore state changed sync to parent childKey=" + this.a + ", parentkey=" + this.b);
        ne0.c r0 = this.d;
        String r1 = this.b;
        if (r4 == null) goto L5;
        Object r5 = r4.getData();
    L6:
        r0.b(r1, r5);
        return;
    L5:
        r5 = null;
        goto L6
    }
}
