package com.ss.android.common.applog;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.loader.SstLoader;
import com.bytedance.bdinstall.oaid.Oaid;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static String[] f15071a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static String[] f15072b;

    static {
        f15071a = new String[]{SstLoader.KEY_MC, "build_serial", Api.KEY_ALIYUN_UUID, SstLoader.KEY_UDID, "serial_number", "sim_serial_number"};
        f15072b = new String[AppLog.d.length + 6];
        System.arraycopy(AppLog.d, 0, f15072b, 0, AppLog.d.length);
        System.arraycopy(f15071a, 0, f15072b, AppLog.d.length + 0, f15071a.length);
    }

    public static void a(Context r2, JSONObject r3) {
        String r4 = com.ss.android.deviceregister.a.m.a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).a();
        if (TextUtils.isEmpty(r4) == true) goto L6;
        r3.put(Oaid.KEY_OAID_ID, r4);
        return;
    }

    public static JSONObject b(Context r2, JSONObject r3) {
        String r4 = com.ss.android.deviceregister.a.m.a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).a();
        if (TextUtils.isEmpty(r4) == true) goto L14;
        JSONObject r0 = new JSONObject(r3, f15072b);     // Catch: JSONException -> L9
        r0.put(Oaid.KEY_OAID_ID, r4);     // Catch: JSONException -> L8
    L7:
        return r0;
    L15:
        return r3;
    L14:
        return r3;
    }
}
