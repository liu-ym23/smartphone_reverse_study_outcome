package com.bytedance.news.common.settings.a;

import android.content.Context;
import com.bytedance.news.common.settings.api.i;
import com.bytedance.news.common.settings.api.j;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class c implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ConcurrentHashMap<String, d> f2913a = null;

    static {
        f2913a = new ConcurrentHashMap();
    }

    public c() {
    }

    @Override // com.bytedance.news.common.settings.api.j
    public i a(String r2) {
        return a(r2, false);
    }

    @Override // com.bytedance.news.common.settings.api.j
    public i a(String r5, boolean r6) {
        ConcurrentHashMap<String, d> r4 = f2913a;
        d r0 = (d) ZeusTransformUtils.preCheckCast(r4.get(r5), d.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L5;
        return r0;
    L5:
        d r1 = new d((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.news.common.settings.internal.b.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r5, r6);
        r4.put(r5, r1);
        return r1;
    }
}
