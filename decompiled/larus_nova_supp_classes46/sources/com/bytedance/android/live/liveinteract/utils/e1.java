package com.bytedance.android.live.liveinteract.utils;

import android.text.TextUtils;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.network.response.Response;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e1<T> implements Consumer {
    public final /* synthetic */ boolean a;

    public e1(boolean r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        Response r4 = (Response) r3;
        com.bytedance.android.livesdk.sharedpref.e r0 = com.bytedance.android.livesdk.sharedpref.c.e1;
        if (this.a == false) goto L5;
        int r1 = 1;
    L6:
        Integer r2 = Integer.valueOf(r1);
        r0.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r0, r2);
        if (TextUtils.isEmpty(((com.bytedance.android.live.liveinteract.plantform.model.z0) r4.data).a()) == true) goto L10;
        f2.c(((com.bytedance.android.live.liveinteract.plantform.model.z0) r4.data).a(), 0);
    L10:
        if (this.a == false) goto L13;
        com.bytedance.android.live.liveinteract.linkpanel.util.w.d();
        return;
    L13:
        return;
    L5:
        r1 = 2;
        goto L6
    }
}
