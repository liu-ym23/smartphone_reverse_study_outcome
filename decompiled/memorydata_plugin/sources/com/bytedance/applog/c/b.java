package com.bytedance.applog.c;

import android.content.Context;
import com.bytedance.bdinstall.IBDInstallApi;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b {
    public static void a(IBDInstallApi r2, Context r3, JSONObject r4) {
        ((IBDInstallApi) ZeusTransformUtils.wrapperContextForParams(r2, IBDInstallApi.class, "com.obric.memorydata.plugin")).addRegisterCustomHeader((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), r4);
    }
}
