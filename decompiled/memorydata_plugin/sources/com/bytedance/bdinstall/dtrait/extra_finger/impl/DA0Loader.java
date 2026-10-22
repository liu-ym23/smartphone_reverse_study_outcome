package com.bytedance.bdinstall.dtrait.extra_finger.impl;

import android.content.Context;
import com.bytedance.bdinstall.dtrait.constant.DTraitConstant;
import com.bytedance.bdinstall.dtrait.extra_finger.BaseExtraLoader;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class DA0Loader extends BaseExtraLoader {
    public DA0Loader(Context r3, JSONObject r4) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.bytedance.bdinstall.dtrait.extra_finger.BaseExtraLoader
    public String getName() {
        return DTraitConstant.D_A0;
    }

    @Override // com.bytedance.bdinstall.dtrait.extra_finger.BaseExtraLoader
    public String load() {
        JSONArray r0 = this.configData.optJSONArray("path");
        if (r0 != null) goto L6;
        return "";
    L6:
        JSONObject r1 = new JSONObject();
        int r2 = 0;
    L8:
        if (r2 >= r0.length()) goto L19;
        String r3 = r0.getString(r2);     // Catch: Exception -> L11
        r1.put(r3, this.dTraitNativeManager.getA0Result(r3));     // Catch: Exception -> L11
    L17:
        r2 = r2 + 1;
    L11:
        e = move-exception;
        if (e.getCause() == null) goto L15;
        String r4 = e.getCause().getMessage();
    L16:
        this.errorMsg = r4;
        goto L17
    L15:
        r4 = e.getMessage();
        goto L16
    L19:
        return r1.toString();
    }
}
