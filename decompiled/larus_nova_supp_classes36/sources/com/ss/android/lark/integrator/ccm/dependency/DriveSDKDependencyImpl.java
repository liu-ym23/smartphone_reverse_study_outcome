package com.ss.android.lark.integrator.ccm.dependency;

import cmb.f;
import com.bytedance.ee.bear.drive.sdk.service.e;
import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.ss.android.lark.integrator.ccm.spacekit.SpacekitSdkWrapper;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@ClaymoreImpl(e.class)
public class DriveSDKDependencyImpl implements e {
    public DriveSDKDependencyImpl() {
    }

    public void checkAndInitSpaceKitSdk() {
        f.a().getClass();
        SpacekitSdkWrapper.b.a.c();
    }
}
