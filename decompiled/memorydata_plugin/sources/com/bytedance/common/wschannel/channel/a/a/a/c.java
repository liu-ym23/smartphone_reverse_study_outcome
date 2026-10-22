package com.bytedance.common.wschannel.channel.a.a.a;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class c extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f2027a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f2028b;

    public c(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), 4);
    }

    c(Context r3, int r4) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"));
        if (r4 >= 0) goto L5;
        r4 = 4;
    L5:
        this.f2027a = r4;
    }

    @Override // com.bytedance.common.wschannel.channel.a.a.a.a
    public long a() {
        if (this.f2028b >= this.f2027a) goto L5;
        long r0 = super.a();
    L7:
        if (r0 == (-1)) goto L9;
        this.f2028b++;
    L9:
        return r0;
    L5:
        r0 = -1;
        goto L7
    }

    @Override // com.bytedance.common.wschannel.channel.a.a.a.a, com.bytedance.common.wschannel.channel.a.a.a.b
    public void c() {
        super.c();
        this.f2028b = 0;
    }

    public String toString() {
        return "RetryTimesPolicy{mMaxRetryTime=" + this.f2027a + ", mCurrRetryTime=" + this.f2028b + '}';
    }
}
