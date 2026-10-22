package com.bytedance.ug.cloud;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f3351a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f3352b;
    private String c;
    private boolean d;
    private int e;

    public p() {
        this.e = 1;
    }

    public g a() {
        if (this.e != 1) goto L10;
        if (this.f3351a != null) goto L10;
        throw new IllegalArgumentException("context is null");
    L10:
        if (this.f3352b == null) goto L16;
        if (this.c == null) goto L16;
        return new g(this.f3351a, this.f3352b, this.c, this.d, this.e);
    L16:
        throw new IllegalArgumentException("sdkName or sdkVersion is invalid. sdkName = " + this.f3352b + ", sdkVersion = " + this.c);
    }

    public p a(int r1) {
        this.e = r1;
        return this;
    }

    public p a(Context r3) {
        this.f3351a = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        return this;
    }

    public p a(String r1) {
        this.f3352b = r1;
        return this;
    }

    public p a(boolean r1) {
        this.d = r1;
        return this;
    }

    public p b(String r1) {
        this.c = r1;
        return this;
    }
}
