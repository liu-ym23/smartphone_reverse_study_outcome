package com.bytedance.common.wschannel.b;

import android.content.Context;
import android.os.Bundle;
import com.ss.android.message.log.PushLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public static void a(Context r2, String r3, Bundle r4) {
        PushLog.onEventV3Bundle((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), r3, r4);     // Catch: Throwable -> L5
        return;
    }
}
