package com.loc;

import android.net.Uri;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes3.dex */
public abstract class fs extends bo {
    public fs() {
    }

    @Override // com.loc.bo
    public String p() {
        boolean r0 = TextUtils.isEmpty(c());
        String r3 = c();
        if (r0 == false) goto L5;
        return r3;
    L5:
        Uri r1 = Uri.parse(r3);
        if (r1.getAuthority().startsWith("dualstack-") == false) goto L9;
        return r3;
    L9:
        if (r1.getAuthority().startsWith("restsdk.amap.com") == false) goto L13;
        Uri.Builder r4 = r1.buildUpon();
        String r2 = "dualstack-arestapi.amap.com";
    L12:
        return r4.authority(r2).build().toString();
    L13:
        r4 = r1.buildUpon();
        r2 = "dualstack-" + r1.getAuthority();
        goto L12
    }
}
