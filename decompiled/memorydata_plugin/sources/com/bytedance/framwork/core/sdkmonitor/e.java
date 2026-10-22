package com.bytedance.framwork.core.sdkmonitor;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.logging.log4j.message.ParameterizedMessage;

/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f2648a;

    public static String a(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (f2648a != null) goto L6;
        String r4 = com.bytedance.framwork.core.sdklib.b.d.a(r3).replace(r3.getPackageName(), "p").replace(ParameterizedMessage.ERROR_MSG_SEPARATOR, "_");
        f2648a = r4;
        f2648a = r4.replace(".", "_");
    L6:
        return f2648a;
    }
}
