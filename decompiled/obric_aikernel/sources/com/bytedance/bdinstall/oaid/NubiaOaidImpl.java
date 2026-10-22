package com.bytedance.bdinstall.oaid;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.bdinstall.DrLog;

/* JADX INFO: loaded from: classes.dex */
final class NubiaOaidImpl implements OaidApi {
    NubiaOaidImpl() {
    }

    @Override // com.bytedance.bdinstall.oaid.OaidApi
    public String getName() {
        return "Nubia";
    }

    @Override // com.bytedance.bdinstall.oaid.OaidApi
    public OaidApi.Result getOaid(Context r10) {
        Uri r11 = Uri.parse("content://cn.nubia.identity/identity");
        int r12 = Build.VERSION.SDK_INT;     // Catch: Exception -> L24
        if (r12 <= 17) goto L13;
        ContentProviderClient r13 = r10.getContentResolver().acquireContentProviderClient(r11);     // Catch: Exception -> L24
        if (r13 != null) goto L9;
        return null;
    L9:
        Bundle r14 = r13.call("getOAID", null, null);     // Catch: Exception -> L24
        if (r12 < 24) goto L12;
        r13.close();     // Catch: Exception -> L24
    L14:
        if (r14 != null) goto L17;
        return null;
    L17:
        if (r14.getInt("code", -1) != 0) goto L20;
        OaidApi.Result r15 = new OaidApi.Result();     // Catch: Exception -> L24
        r15.oaid = r14.getString(OaidModel.KEY_ID);     // Catch: Exception -> L24
        return r15;
    L20:
        String r16 = r14.getString("message");     // Catch: Exception -> L24
        if (TextUtils.isEmpty(r16) == true) goto L23;
        DrLog.e(r16);     // Catch: Exception -> L24
    L23:
        return null;
    L12:
        r13.release();     // Catch: Exception -> L24
        goto L14
    L13:
        r14 = r10.getContentResolver().call(r11, "getOAID", null, null);     // Catch: Exception -> L24
    L24:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @Override // com.bytedance.bdinstall.oaid.OaidApi
    public boolean support(Context r10) {
        if (Build.VERSION.SDK_INT <= 28) goto L5;
        return true;
    L5:
        return false;
    }
}
