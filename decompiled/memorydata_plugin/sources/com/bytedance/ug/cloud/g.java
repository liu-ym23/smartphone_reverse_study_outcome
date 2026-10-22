package com.bytedance.ug.cloud;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Context f3339a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final String f3340b;
    final String c;
    final boolean d;
    int e;

    g(Context r3, String r4, String r5, boolean r6, int r7) {
        this.f3339a = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        this.f3340b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
    }

    public static p a() {
        return new p();
    }
}
