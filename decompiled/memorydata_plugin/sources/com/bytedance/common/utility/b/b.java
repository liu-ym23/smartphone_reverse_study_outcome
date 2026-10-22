package com.bytedance.common.utility.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public final class b {
    b() {
    }

    public String a(String r6) {
        return (String) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.forName("android.os.SystemProperties", "com.obric.memorydata.plugin").getMethod("get", new Class[]{String.class}).invoke(null, new Object[]{r6}), String.class, "com.obric.memorydata.plugin");
    }
}
