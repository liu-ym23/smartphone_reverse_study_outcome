package com.bytedance.bdinstall.oaid;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.bdinstall.DrLog;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
final class NubiaOaidImpl implements OaidApi {
    NubiaOaidImpl() {
    }

    @Override // com.bytedance.bdinstall.oaid.OaidApi
    public String getName() {
        return "Nubia";
    }

    @Override // com.bytedance.bdinstall.oaid.OaidApi
    public OaidApi.Result getOaid(Context r7) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Uri r1 = Uri.parse("content://cn.nubia.identity/identity");
    L23:
        e = move-exception;
        e.printStackTrace();
        return null;
    L4:
        if (Build.VERSION.SDK_INT <= 17) goto L12;
        ContentProviderClient r8 = r6.getContentResolver().acquireContentProviderClient(r1);     // Catch: Exception -> L23
        if (r8 != null) goto L8;
        return null;
    L8:
        Bundle r0 = r8.call("getOAID", null, null);     // Catch: Exception -> L23
        if (Build.VERSION.SDK_INT < 24) goto L11;
        r8.close();     // Catch: Exception -> L23
    L13:
        if (r0 != null) goto L16;
        return null;
    L16:
        if (r0.getInt("code", -1) != 0) goto L19;
        OaidApi.Result r9 = new OaidApi.Result();     // Catch: Exception -> L23
        r9.oaid = r0.getString(OaidModel.KEY_ID);     // Catch: Exception -> L23
        return r9;
    L19:
        String r10 = r0.getString("message");     // Catch: Exception -> L23
        if (TextUtils.isEmpty(r10) == true) goto L22;
        DrLog.e(r10);     // Catch: Exception -> L23
    L22:
        return null;
    L11:
        r8.release();     // Catch: Exception -> L23
        goto L13
    L12:
        r0 = ZeusProviderTransform.call(r6.getContentResolver(), r1, "getOAID", null, null, "com.obric.memorydata.plugin");     // Catch: Exception -> L23
        goto L13
    }

    @Override // com.bytedance.bdinstall.oaid.OaidApi
    public boolean support(Context r2) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT <= 28) goto L5;
        return true;
    L5:
        return false;
    }
}
