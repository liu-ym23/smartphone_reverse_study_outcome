package com.bytedance.pia.core.worker.bridge;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.pia.core.api.bridge.PiaMethod$Error;
import com.bytedance.pia.core.api.bridge.PiaMethod$UnregisteredError;
import com.bytedance.pia.core.plugins.BridgeDowngradePlugin;
import com.bytedance.pia.core.utils.j;
import com.bytedance.pia.core.utils.m;
import com.bytedance.vmsdk.jsbridge.JSModule;
import com.bytedance.vmsdk.jsbridge.utils.Callback;
import com.bytedance.vmsdk.jsbridge.utils.JavaOnlyMap;
import com.bytedance.vmsdk.jsbridge.utils.ReadableMap;
import com.google.gson.JsonObject;
import fh.a;
import gh.c;
import mh.b;
import mh.g;

/* JADX INFO: loaded from: classes2.dex */
public class BridgeModule extends JSModule {
    private static final String KEY_CODE = "code";
    private static final String KEY_DATA = "data";
    private static final String KEY_MSG = "msg";
    public static final String NAME = "bridge";
    private final c bridge;

    public BridgeModule(Context r5, Object r10) {
        super(r5, r10);
        this.bridge = (c) r10;
    }

    public static /* synthetic */ void a(BridgeModule r5, String r10, ReadableMap r11, Callback r12, PiaMethod$Error r13) {
        r5.lambda$call$0(r10, r11, r12, r13);
    }

    public static JavaOnlyMap invalidParams() {
        JavaOnlyMap r5 = new JavaOnlyMap();
        r5.put("code", -3);
        return r5;
    }

    private void lambda$call$0(String r5, ReadableMap r10, Callback r11, PiaMethod$Error r12) {
        if ((r12 instanceof PiaMethod$UnregisteredError) == false) goto L8;
        nh.c r13 = this.bridge.f17099b.j("bridgeDowngrade");
        if ((r13 instanceof BridgeDowngradePlugin) == false) goto L8;
        BridgeDowngradePlugin r14 = (BridgeDowngradePlugin) r13;
        ReadableMap r15 = r10.getMap("rawData");
        r14.getClass();
        b r16 = new b(r5, r15, r11);
        r14.f7043c.c(r16);
        return;
    L8:
        if (r11 != null) goto L10;
        return;
    L10:
        JavaOnlyMap r17 = new JavaOnlyMap();
        if (r12 == null) goto L13;
        r17.put("code", Integer.valueOf(r12.f6951a));
        r17.put("msg", r12.getMessage());
    L14:
        r11.invoke(new Object[]{r17});
        return;
    L13:
        r17.put("code", 0);
        goto L14
    }

    private void returnResult(Callback r5, JavaOnlyMap r10) {
        if (r5 == null) goto L5;
        r5.invoke(new Object[]{r10});
        return;
    }

    @com.bytedance.vmsdk.jsbridge.b
    public void call(final String r10, final ReadableMap r11, final Callback r12) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
        returnResult(r12, invalidParams());
    L5:
        ReadableMap r5 = r11.getMap("data");
        if (r5 == null) goto L9;
        JsonObject r13 = j.g(r5);
    L8:
        JsonObject r14 = r13;
        c r15 = this.bridge;
        g r16 = new g(r12, 2);
        a r17 = new th.a(this, r10, r11, r12);
        r15.getClass();
        m.b(new com.bytedance.ai.model.widgets.m(r15, r10, r17, r14, r16, 3));
        return;
    L9:
        r13 = null;
        goto L8
    }
}
