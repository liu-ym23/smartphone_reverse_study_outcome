package com.ss.android.lark.chameleonv2.container.webcontainer;

import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.util.io.NonProguard;
import com.ss.android.lark.officewebview.bridge.Status;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class k implements tb5.m {
    public final /* synthetic */ xwb.j a;

    public k(xwb.d r1) {
        this.a = r1;
    }

    public final void a(NonProguard r3) {
        this.a.a(Status.SUCCESS, r3);
    }

    public final void b(JSONObject r3) {
        this.a.a(Status.SUCCESS, r3);
    }

    public final void onCallBack(String r3) {
        this.a.a(Status.SUCCESS, r3);
    }
}
