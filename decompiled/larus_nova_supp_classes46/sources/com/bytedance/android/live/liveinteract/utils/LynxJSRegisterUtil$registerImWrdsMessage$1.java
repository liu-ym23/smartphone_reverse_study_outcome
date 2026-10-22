package com.bytedance.android.live.liveinteract.utils;

import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class LynxJSRegisterUtil$registerImWrdsMessage$1 implements com.bytedance.ies.web.jsbridge2.f.b {
    public final Lazy a;
    public final /* synthetic */ DataCenter b;
    public final /* synthetic */ com.bytedance.android.live.liveinteract.plantform.dynamicframe.b c;

    public final com.bytedance.ies.web.jsbridge2.f<?, ?> a() {
        return (com.bytedance.android.live.liveinteract.jsbridge.method.y) this.a.getValue();
    }

    public LynxJSRegisterUtil$registerImWrdsMessage$1(DataCenter r1, com.bytedance.android.live.liveinteract.plantform.dynamicframe.b r2) {
        this.b = r1;
        this.c = r2;
        this.a = LazyKt.lazy(LazyThreadSafetyMode.NONE, new LynxJSRegisterUtil$registerImWrdsMessage$1$registerMethod$2(this));
    }
}
