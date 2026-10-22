package com.bytedance.applog.log;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class i extends q {
    public i() {
    }

    @Override // com.bytedance.applog.log.c
    public void a(int r3, int r4, List<String> r5, Throwable r6, String r7, Object... r8) {
        List<String> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        if (o.a() == false) goto L5;
        return;
    L5:
        l r2 = l.a().b(r3).a(r4).b(Thread.currentThread().getName()).a(r6).a(a(r9)).c(a(r7, r8)).a();
        o.a(r2);
        Iterator<k> r10 = o.c();
    L7:
        if (r10.hasNext() == false) goto L9;
        ((k) ZeusTransformUtils.preCheckCast(r10.next(), k.class, "com.obric.memorydata.plugin")).a(r2);
        goto L7
    }

    @Override // com.bytedance.applog.log.c, com.bytedance.applog.log.j
    public void a(String r2) {
        d("You should not set appId on global logger instance", new Object[0]);
    }
}
