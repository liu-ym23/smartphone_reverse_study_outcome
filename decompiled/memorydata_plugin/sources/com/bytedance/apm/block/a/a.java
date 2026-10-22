package com.bytedance.apm.block.a;

import android.app.Activity;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public abstract class a extends com.bytedance.apm.block.a implements c {
    @Override // com.bytedance.services.apm.api.d
    public void a(Activity r2) {
        Activity r1 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin");
    }

    @Override // com.bytedance.services.apm.api.d
    public void a(Activity r1, Bundle r2) {
        Activity r0 = (Activity) ZeusTransformUtils.wrapperContextForParams(r1, Activity.class, "com.obric.memorydata.plugin");
    }

    @Override // com.bytedance.services.apm.api.d
    public void a(Activity r1, Fragment r2) {
        Activity r0 = (Activity) ZeusTransformUtils.wrapperContextForParams(r1, Activity.class, "com.obric.memorydata.plugin");
    }

    @Override // com.bytedance.services.apm.api.d
    public void b(Activity r2) {
        Activity r1 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin");
    }

    @Override // com.bytedance.services.apm.api.d
    public void c(Activity r2) {
        Activity r1 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin");
    }

    @Override // com.bytedance.services.apm.api.d
    public void d(Activity r2) {
        Activity r1 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin");
    }

    @Override // com.bytedance.services.apm.api.d
    public void e(Activity r2) {
        Activity r1 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin");
    }
}
