package com.bytedance.android.anniex.ability;

import com.bytedance.android.anniex.web.AnnieXWebKit;
import com.bytedance.android.anniex.web.model.AnnieXWebModel;
import com.bytedance.ies.bullet.core.kit.bridge.Callback;
import com.bytedance.ies.bullet.core.kit.bridge.IBridge3Registry;
import com.bytedance.sdk.xbridge.cn.platform.web.WebBDXBridge;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class l implements IBridge3Registry {
    public final /* synthetic */ AnnieXWebModel a;
    public final /* synthetic */ AnnieXWebKit b;
    public final /* synthetic */ WebBDXBridge c;

    public static final class a extends com.bytedance.sdk.xbridge.cn.protocol.d<JSONObject> {
        public JSONObject c;
        public final /* synthetic */ Callback d;

        public final JSONObject a() {
            JSONObject r0 = this.c;
            if (r0 == null) goto L5;
            return r0;
        L5:
            return new JSONObject();
        }

        public final void b(Object r10) {
            JSONObject r11 = (JSONObject) r10;
            Intrinsics.checkNotNullParameter(r11, "data");
            this.c = r11;
            Callback r0 = this.d;
            if (r0 == null) goto L6;
            r0.invoke(new Object[]{r11});
            return;
        }

        public a(com.bytedance.sdk.xbridge.cn.platform.web.b r1, Callback r10) {
            this.d = r10;
            super(r1);
        }
    }

    public final void release() {
    }

    public l(AnnieXWebModel r1, AnnieXWebKit r10, WebBDXBridge r11) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
    }

    public final void handle(String r10, JSONObject r11, Callback r12) {
        Intrinsics.checkNotNullParameter(r10, "methodName");
        if (r11 != null) goto L5;
        r11 = new JSONObject();
    L5:
        com.bytedance.sdk.xbridge.cn.platform.web.b r0 = new com.bytedance.sdk.xbridge.cn.platform.web.b(r10, r11, this.a.b);
        int r13 = t.a;
        String r14 = t.a(this.b, this.a.b);
        if (r14 == null) goto L8;
        Intrinsics.checkNotNullParameter(r14, "<set-?>");
        r0.S = r14;
    L8:
        a r15 = new a(r0, r12);
        this.c.o(r0, r15);
    }
}
