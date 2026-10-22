package com.bytedance.android.ec.core.hybrid.bridges;

import android.app.Activity;
import android.app.Application;
import android.app.Service;
import android.content.Context;
import android.content.ContextWrapper;
import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import yj.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/ec/core/hybrid/bridges/ECSaasRequestUserInfo;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "<init>", "()V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECSaasRequestUserInfo extends ECBaseBridgeMethod {
    public final String e;

    public ECSaasRequestUserInfo() {
        this.e = "ec.sass.requestUserInfo";
    }

    public final String getName() {
        return this.e;
    }

    public final void c(JSONObject r10, final ECBaseBridgeMethod.a r11) {
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r11, "iReturn");
        final String r12 = r10.optString("source", "");
        boolean r13 = r10.optBoolean("withAuth", false);
        int r0 = com.bytedance.forest.utils.h.a;
        IHybridHostService r1 = com.bytedance.android.ec.hybrid.a.h();
        Activity r14 = null;
        if (r1 == null) goto L7;
        s r15 = r1.getIHybridHostUserService();
        if (r15 == null) goto L7;
        String r16 = r15.getAccessToken();
    L9:
        if (com.bytedance.forest.utils.h.a(r16) == false) goto L12;
        d(r11, 0, true);
        return;
    L12:
        if (r13 == true) goto L14;
        return;
    L14:
        Context r17 = getContext();
        if (r17 != null) goto L17;
        Activity r18 = null;
    L34:
        if (r18 == null) goto L44;
        IHybridHostService r19 = com.bytedance.android.ec.hybrid.a.h();
        if (r19 == null) goto L45;
        s r20 = r19.getIHybridHostUserService();
        if (r20 == null) goto L46;
        r20.e(r18, r12, "", new ECSaasRequestUserInfo$handle$$inlined$let$lambda$1(this, r12, r11), new ECSaasRequestUserInfo$handle$$inlined$let$lambda$2(this, r12, r11));
        return;
    L46:
        return;
    L45:
        return;
    L44:
        return;
    L17:
        if ((r17 instanceof Activity) == false) goto L20;
        r14 = (Activity) r17;
    L31:
        Activity r21 = r14;
    L32:
        r18 = r21;
        goto L34
    L20:
        if ((r17 instanceof Application) == true) goto L31;
        if ((r17 instanceof Service) == true) goto L31;
    L24:
        if (r17 == null) goto L31;
        if ((r17 instanceof Activity) == true) goto L27;
        if ((r17 instanceof ContextWrapper) == false) goto L31;
        r17 = ((ContextWrapper) r17).getBaseContext();
        goto L24
    L27:
        r21 = (Activity) r17;
    L7:
        r16 = null;
        goto L9
    }

    public static void d(ECBaseBridgeMethod.a r10, int r11, boolean r12) {
        JSONObject r0 = new JSONObject();
        r0.put("isLogin", r12);
        r0.put("authStatus", r11);
        Unit r13 = Unit.INSTANCE;
        r10.onSuccess(r0);
    }
}
