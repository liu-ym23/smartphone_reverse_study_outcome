package com.bytedance.bdinstall.dtrait;

import android.content.Context;
import com.bytedance.bdinstall.dtrait.interfaces.IDTraitService;
import com.bytedance.bdinstall.dtrait.manager.DTraitManager;
import com.bytedance.bdinstall.dtrait.manager.DTraitNativeManager;
import com.bytedance.bdinstall.dtrait.manager.DTraitServiceManager;
import com.bytedance.bdinstall.dtrait.model.DTraitTimeMonitorEvent;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class DTraitService implements IDTraitService {
    private final DTraitManager dTraitManager;
    private final DTraitNativeManager dTraitNativeManager;

    public DTraitService(Context r3, boolean r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        DTraitTimeMonitorEvent.setSdkInitStart();
        DTraitNativeManager r0 = new DTraitNativeManager();
        this.dTraitNativeManager = r0;
        this.dTraitManager = new DTraitManager(r5, r0, r4);
        DTraitServiceManager.registerService(DTraitService.class, this);
    }

    @Override // com.bytedance.bdinstall.dtrait.interfaces.IDTraitService
    public DTraitManager getDTraitManager() {
        return this.dTraitManager;
    }

    @Override // com.bytedance.bdinstall.dtrait.interfaces.IDTraitService
    public DTraitNativeManager getDTraitNativeManager() {
        return this.dTraitNativeManager;
    }
}
