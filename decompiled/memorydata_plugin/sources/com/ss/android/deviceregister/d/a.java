package com.ss.android.deviceregister.d;

import android.content.Context;
import com.bytedance.bdinstall.Builder;
import com.bytedance.bdinstall.Cdid;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public final class a {
    public static String a(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        return Cdid.get(new Builder().setContext(r3).setAid(com.ss.android.deviceregister.f.j()).setAppName("_").setChannel(com.ss.android.deviceregister.f.c(r3)).setNetworkClient(new AnonymousClass2()).setBDTrackerDepend(new AnonymousClass1()).build());
    }

    public static void b(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        Cdid.clearCdid(r3, new Builder().setAid(com.ss.android.deviceregister.f.j()).setAppName("_").setChannel(com.ss.android.deviceregister.f.c(r3)).setNetworkClient(new AnonymousClass4()).setBDTrackerDepend(new AnonymousClass3()).build());
    }
}
