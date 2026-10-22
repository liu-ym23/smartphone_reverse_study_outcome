package com.larus.api.serviceimpl;

import com.bytedance.applog.h;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class AoEventServiceImpl$c implements h {
    public final /* synthetic */ AoEventServiceImpl a;

    public final void onIdLoaded(String r1, String r2, String r3) {
    }

    public AoEventServiceImpl$c(AoEventServiceImpl r1) {
        this.a = r1;
    }

    public final void a(boolean r4, JSONObject r5) {
        this.a.G2().d("AppLogIniter", "onRemoteConfigGet: changed = " + r4 + ", config = " + r5);
    }

    public final void onRemoteIdGet(boolean r4, String r5, String r6, String r7, String r8, String r9, String r10) {
        this.a.G2().d("AppLogIniter", "onRemoteIdGet: changed = " + r4 + ", oldDid = " + r5 + ", newDid = " + r6 + ", oldIid = " + r7 + ", newIid = " + r8 + ", oldSsid = " + r9 + ", newSsid = " + r10);
    }
}
