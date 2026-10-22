package com.ss.android.common.applog;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes6.dex */
public class g implements com.bytedance.applog.util.h {
    public g() {
    }

    @Override // com.bytedance.applog.util.h
    public boolean isEnable() {
        return com.bytedance.applog.util.g.a(String.valueOf(com.ss.android.deviceregister.f.j()));
    }

    @Override // com.bytedance.applog.util.h
    public void putEvent(String r1, JSONArray r2) {
        com.bytedance.applog.util.g.a(String.valueOf(com.ss.android.deviceregister.f.j()), r1, r2);
    }

    @Override // com.bytedance.applog.util.h
    public void setEnable(boolean r2, Context r3) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        com.bytedance.applog.util.g.a(String.valueOf(com.ss.android.deviceregister.f.j()), r2, r1);
    }

    @Override // com.bytedance.applog.util.h
    public void setEventVerifyUrl(String r1) {
        com.bytedance.applog.util.g.a(String.valueOf(com.ss.android.deviceregister.f.j()), r1);
    }
}
