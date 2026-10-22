package com.ss.android.deviceregister.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
final class a extends c<com.b.a.a.a> {
    a() {
        super("com.asus.msa.SupplementaryDID");
    }

    @Override // com.ss.android.deviceregister.a.c
    public Intent a(Context r3) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intent r4 = new Intent();
        r4.setAction("com.asus.msa.action.ACCESS_DID");
        r4.setComponent(new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService"));
        return r4;
    }

    @Override // com.ss.android.deviceregister.a.c
    public w.b<com.b.a.a.a, String> a() {
        return new AnonymousClass1(this);
    }
}
