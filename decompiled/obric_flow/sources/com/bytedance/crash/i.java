package com.bytedance.crash;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class i implements ICommonParams {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j f4052a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MonitorCrash f4053b;

    public i(j r5, MonitorCrash r10) {
        this.f4052a = r5;
        this.f4053b = r10;
    }

    @Override // com.bytedance.crash.ICommonParams
    public final Map getCommonParams() {
        JSONObject r5 = this.f4052a.c();
        HashMap r10 = new HashMap();
        Iterator<String> r11 = r5.keys();
    L4:
        if (r11.hasNext() == false) goto L6;
        String r12 = r11.next();
        r10.put(r12, r5.opt(r12));
        goto L4
    L6:
        return r10;
    }

    @Override // com.bytedance.crash.ICommonParams
    public final String getDeviceId() {
        return this.f4053b.mConfig.mDeviceId;
    }

    @Override // com.bytedance.crash.ICommonParams
    public final List getPatchInfo() {
        return null;
    }

    @Override // com.bytedance.crash.ICommonParams
    public final Map getPluginInfo() {
        return null;
    }

    @Override // com.bytedance.crash.ICommonParams
    public final String getSessionId() {
        return null;
    }

    @Override // com.bytedance.crash.ICommonParams
    public final long getUserId() {
        return this.f4053b.mConfig.mUID;
    }
}
