package com.bytedance.watson.assist.b;

import android.content.Context;
import com.bytedance.watson.assist.a.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Context f3369a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected c f3370b;

    public b(Context r3, c r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        c r6 = (c) ZeusTransformUtils.wrapperContextForParams(r4, c.class, "com.obric.memorydata.plugin");
        this.f3369a = ZeusTransformUtils.wrapperContext(r5, "com.obric.memorydata.plugin");
        this.f3370b = r6;
    }

    public void a() {
    }

    public void b() {
    }
}
