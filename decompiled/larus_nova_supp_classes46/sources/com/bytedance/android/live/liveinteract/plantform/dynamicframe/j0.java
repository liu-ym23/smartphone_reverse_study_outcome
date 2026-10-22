package com.bytedance.android.live.liveinteract.plantform.dynamicframe;

import com.bytedance.android.live.liveinteract.jsbridge.method.DynamicRegisterMessageMethod;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class j0 implements com.bytedance.ies.web.jsbridge2.f.b {
    public final /* synthetic */ e0 a;

    public j0(e0 r1) {
        this.a = r1;
    }

    public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
        return new DynamicRegisterMessageMethod(this.a.b);
    }
}
