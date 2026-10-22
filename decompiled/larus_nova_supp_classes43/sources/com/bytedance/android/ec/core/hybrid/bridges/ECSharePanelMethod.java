package com.bytedance.android.ec.core.hybrid.bridges;

import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import com.bytedance.android.ec.sdk.ECSdk;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import ti.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/ec/core/hybrid/bridges/ECSharePanelMethod;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "<init>", "()V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECSharePanelMethod extends ECBaseBridgeMethod {
    public final a e;

    public static final class a implements n {
        public a() {
        }
    }

    public final String getName() {
        return "ecSharePanel";
    }

    public ECSharePanelMethod() {
        this.e = new a();
    }

    public final void c(JSONObject r10, ECBaseBridgeMethod.a r11) {
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r11, "iReturn");
        JSONObject r0 = new JSONObject();
        boolean r12 = true;
        r0.put("code", 1);
        r11.a(r0);
        if (r10.optString("bcmChain").length() == 0) goto L6;
        r12 = false;
    L6:
        if (r12 == false) goto L14;
        kc.a r1 = BtmSDK.getBcmChainByFinder$default(BtmSDK.INSTANCE, PageFinder.via(b().a), 0, false, 6, null);
        if (r1 == null) goto L10;
        JSONObject r13 = r1.a();
    L11:
        if (r13 == null) goto L14;
        r10.put("bcmChain", r13.toString());
        goto L14
    L10:
        r13 = null;
    L14:
        if (getContext() == null) goto L26;
        int r14 = ECSdk.a;
        s83.g r15 = (s83.g) ECSdk.a(s83.g.class);
        if (r15 == null) goto L20;
        s83.e r16 = r15.W();
        if (r16 == null) goto L20;
        r16.d(r10, "click", r10.optString("enterFrom"));
    L20:
        s83.g r17 = (s83.g) ECSdk.a(s83.g.class);
        if (r17 == null) goto L27;
        s83.e r18 = r17.W();
        if (r18 == null) goto L28;
        r18.f(r10, this.e);
        return;
    L28:
        return;
    L27:
        return;
    }
}
