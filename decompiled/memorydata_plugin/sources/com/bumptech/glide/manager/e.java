package com.bumptech.glide.manager;

import android.content.Context;
import android.util.Log;
import androidx.core.content.ContextCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class e implements c {
    public e() {
    }

    @Override // com.bumptech.glide.manager.c
    public b a(Context r3, b.a r4) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        b.a r5 = (b.a) ZeusTransformUtils.wrapperContextForParams(r4, b.a.class, "com.obric.memorydata.plugin");
        if (ContextCompat.checkSelfPermission(r2, "android.permission.ACCESS_NETWORK_STATE") != 0) goto L5;
        boolean r6 = true;
    L7:
        if (Log.isLoggable("ConnectivityMonitor", 3) == false) goto L12;
        if (r6 == false) goto L10;
        String r0 = "ACCESS_NETWORK_STATE permission granted, registering connectivity monitor";
    L11:
        Log.d("ConnectivityMonitor", r0);
        goto L12
    L10:
        r0 = "ACCESS_NETWORK_STATE permission missing, cannot register connectivity monitor";
    L12:
        if (r6 == false) goto L15;
        return new d(r2, r5);
    L15:
        return new m();
    L5:
        r6 = false;
        goto L7
    }
}
