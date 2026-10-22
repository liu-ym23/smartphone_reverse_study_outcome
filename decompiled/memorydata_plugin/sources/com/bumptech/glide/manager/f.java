package com.bumptech.glide.manager;

import android.app.Activity;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
final class f implements i {
    f() {
    }

    @Override // com.bumptech.glide.manager.i
    public void a(Activity r2) {
        Activity r1 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin");
    }
}
