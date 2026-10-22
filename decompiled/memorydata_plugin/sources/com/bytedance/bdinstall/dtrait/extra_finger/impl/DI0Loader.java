package com.bytedance.bdinstall.dtrait.extra_finger.impl;

import android.content.Context;
import com.bytedance.bdinstall.dtrait.DTLog;
import com.bytedance.bdinstall.dtrait.constant.DTraitConstant;
import com.bytedance.bdinstall.dtrait.extra_finger.BaseExtraLoader;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class DI0Loader extends BaseExtraLoader {
    public DI0Loader(Context r3, JSONObject r4) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.bytedance.bdinstall.dtrait.extra_finger.BaseExtraLoader
    public String getName() {
        return DTraitConstant.D_I0;
    }

    @Override // com.bytedance.bdinstall.dtrait.extra_finger.BaseExtraLoader
    public String load() {
        JSONArray r0 = this.configData.optJSONArray("path");
        if (r0 != null) goto L6;
        return "";
    L6:
        if (r0.length() > 0) goto L8;
        return "";
    L8:
        int r2 = r0.length();
        String[] r3 = new String[r2];
        int r4 = 0;
    L10:
        if (r4 >= r0.length()) goto L17;
        r3[r4] = r0.getString(r4);     // Catch: JSONException -> L13
    L15:
        r4 = r4 + 1;
    L13:
        e = move-exception;
        DTLog.e(DTraitConstant.TAG_DTRAIT + getName() + "jsonArray parse error " + e.getMessage());
        goto L15
    L17:
        if (DTLog.debug() == false) goto L34;
        DTLog.d(DTraitConstant.TAG_DTRAIT + getName() + " plist size: " + r2);
    L34:
    L25:
        e = move-exception;
        if (e.getCause() == null) goto L29;
        String r1 = e.getCause().getMessage();
    L30:
        this.errorMsg = r1;
        return "";
    L29:
        r1 = e.getMessage();
        goto L30
    L20:
        if (this.dTraitNativeManager != null) goto L24;
        DTLog.d(DTraitConstant.TAG_DTRAIT + getName() + "dTraitNativeManager is null, return empty ");     // Catch: Exception -> L25
        return "";
    L24:
        return this.dTraitNativeManager.getDI0Result(r3);
    }
}
