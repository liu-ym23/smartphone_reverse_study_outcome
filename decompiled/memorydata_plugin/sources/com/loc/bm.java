package com.loc;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class bm extends bl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f5359a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f5360b;

    public bm(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        this.f5360b = false;
        this.f5359a = ZeusTransformUtils.wrapperContext(r4, "com.obric.memorydata.plugin");
        this.f5360b = false;
    }

    @Override // com.loc.bl
    public final boolean a() {
        if (fp.j(this.f5359a) != 1) goto L5;
    L9:
        return true;
    L5:
        if (this.f5360b == true) goto L9;
        return false;
    }
}
