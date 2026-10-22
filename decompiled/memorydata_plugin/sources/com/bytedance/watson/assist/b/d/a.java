package com.bytedance.watson.assist.b.d;

import android.content.Context;
import android.os.Build;
import android.os.PowerManager;
import com.bytedance.watson.assist.a.c;
import com.bytedance.watson.assist.b.b;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class a extends b {
    private PowerManager c;

    public a(Context r3, c r4) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), (c) ZeusTransformUtils.wrapperContextForParams(r4, c.class, "com.obric.memorydata.plugin"));
        this.c = (PowerManager) ZeusTransformUtils.preCheckCast(this.f3369a.getSystemService("power"), PowerManager.class, "com.obric.memorydata.plugin");
    }

    public int c() {
        if (Build.VERSION.SDK_INT < 29) goto L8;
        PowerManager r2 = this.c;
        if (r2 != null) goto L7;
        return -1;
    L7:
        return r2.getCurrentThermalStatus();
    L8:
        return -1;
    }
}
