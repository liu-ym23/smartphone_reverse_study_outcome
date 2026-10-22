package com.bytedance.android.live.revlink.impl.jsb;

import com.bytedance.android.live.saas.middleware.store.FileUtils;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.ss.android.ugc.effectmanager.common.task.ExceptionResult;
import com.ss.android.ugc.effectmanager.effect.listener.IFetchEffectListener;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class y implements IFetchEffectListener {
    public final /* synthetic */ String a;
    public final /* synthetic */ CallContext b;

    public final void onStart(Effect r1) {
    }

    public final void onSuccess(Object r6) {
        Effect r7 = (Effect) r6;
        JSONObject r0 = new JSONObject();
        r0.put("error_code", 0);
        JSONArray r1 = new JSONArray();
        JSONObject r2 = new JSONObject();
        r2.put("effect_id", this.a);
        if (r7 == null) goto L6;
        String r8 = r7.getUnzipPath();
        if (r8 == null) goto L6;
    L7:
        r2.put(FileUtils.TAG, r8);
        Unit r9 = Unit.INSTANCE;
        r1.put(r2);
        r0.put("effect_list", r1);
        this.b.b("H5_revenueDownloadEffectsFinished", r0);
        return;
    L6:
        r8 = "";
        goto L7
    }

    public y(String r1, CallContext r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onFail(Effect r4, ExceptionResult r5) {
        Intrinsics.checkNotNullParameter(r5, "e");
        JSONObject r6 = new JSONObject();
        r6.put("error_code", -1);
        r6.put("error_msg", r5.getMsg());
        JSONArray r7 = new JSONArray();
        JSONObject r0 = new JSONObject();
        r0.put("effect_id", this.a);
        Unit r1 = Unit.INSTANCE;
        r7.put(r0);
        r6.put("effect_list", r7);
        this.b.b("H5_revenueDownloadEffectsFinished", r6);
    }
}
