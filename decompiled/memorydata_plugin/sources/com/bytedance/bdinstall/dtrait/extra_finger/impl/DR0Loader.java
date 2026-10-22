package com.bytedance.bdinstall.dtrait.extra_finger.impl;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.bdinstall.dtrait.DTLog;
import com.bytedance.bdinstall.dtrait.constant.DTraitConstant;
import com.bytedance.bdinstall.dtrait.extra_finger.BaseExtraLoader;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class DR0Loader extends BaseExtraLoader {
    public DR0Loader(Context r3, JSONObject r4) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.bytedance.bdinstall.dtrait.extra_finger.BaseExtraLoader
    public String getName() {
        return DTraitConstant.D_R0;
    }

    @Override // com.bytedance.bdinstall.dtrait.extra_finger.BaseExtraLoader
    public String load() {
        JSONArray r0 = this.configData.optJSONArray("path");
        if (r0 != null) goto L5;
        return "";
    L5:
        int r2 = 0;
        String r3 = "";
    L27:
    L10:
        e = move-exception;
        DTLog.e(DTraitConstant.TAG_DTRAIT + getName() + "jsonArray# error " + e.getMessage());
    L29:
    L20:
        e = move-exception;
        if (e.getCause() == null) goto L24;
        String r1 = e.getCause().getMessage();
    L25:
        this.errorMsg = r1;
    L26:
        return "";
    L24:
        r1 = e.getMessage();
        goto L25
    L13:
        if (this.dTraitNativeManager != null) goto L16;
        DTLog.d("[dt] dTraitNativeManager is null, return empty ");     // Catch: Exception -> L20
        return "";
    L16:
        String r4 = this.dTraitNativeManager.getM0Result(r3);     // Catch: Exception -> L20
        if (TextUtils.isEmpty(r4) == true) goto L26;
        DTLog.d("[dt] modify_time: " + r4);     // Catch: Exception -> L20
        return r4;
    L7:
        if (r2 >= r0.length()) goto L29;
        r3 = r0.optString(r2);     // Catch: Exception -> L10
        r2 = r2 + 1;
        goto L27
    }
}
