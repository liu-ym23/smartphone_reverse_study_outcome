package com.ss.android.lark.integrator.ccm.dependency.di;

import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.ss.android.lark.integrator.ccm.spacekit.SpacekitSdkWrapper;
import com.ss.android.lark.utils.LarkContext;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@ClaymoreImpl(com.bytedance.ee.bear.lark.dependency.b0.class)
public class PreloadDependencyImpl implements com.bytedance.ee.bear.lark.dependency.b0 {
    public PreloadDependencyImpl() {
    }

    public void preloadDocSdk(int r2) {
        cmb.f.a().getClass();
        SpacekitSdkWrapper r0 = SpacekitSdkWrapper.b.a;
        if (r0 == null) goto L6;
        LarkContext.getApplication();
        r0.i(r2);
        return;
    }
}
