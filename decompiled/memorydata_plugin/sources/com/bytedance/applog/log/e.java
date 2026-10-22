package com.bytedance.applog.log;

import com.bytedance.bdinstall.ILogger;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class e implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ILogger f1629a;

    public e(ILogger r3) {
        this.f1629a = (ILogger) ZeusTransformUtils.wrapperContextForParams(r3, ILogger.class, "com.obric.memorydata.plugin");
    }

    @Override // com.bytedance.applog.log.k
    public void a(l r3) {
        if (this.f1629a == null) goto L18;
        int r0 = r3.b();
        if (r0 != 1) goto L7;
        this.f1629a.d(r3.i(), r3.c());
        return;
    L7:
        if (r0 != 2) goto L9;
        this.f1629a.i(r3.i(), r3.c());
        return;
    L9:
        if (r0 == 3) goto L14;
        ILogger r2 = this.f1629a;
        if (r0 == 4) goto L13;
        r2.v(r3.i(), r3.c());
        return;
    L13:
        r2.e(r3.i(), r3.c());
        return;
    L14:
        this.f1629a.w(r3.i(), r3.c());
        return;
    }
}
