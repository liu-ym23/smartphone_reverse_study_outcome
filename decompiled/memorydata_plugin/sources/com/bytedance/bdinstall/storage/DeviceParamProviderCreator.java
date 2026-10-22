package com.bytedance.bdinstall.storage;

import android.content.Context;
import com.bytedance.bdinstall.Env;
import com.bytedance.bdinstall.InstallOptions;
import com.bytedance.bdinstall.service.IInstallParameters;
import com.bytedance.bdinstall.service.INewUserModeService;
import com.bytedance.bdinstall.service.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class DeviceParamProviderCreator extends CommonDeviceParamProviderCreator {
    public DeviceParamProviderCreator() {
    }

    public static void registerInstallParameterProvider(Context r2, Env r3, InstallOptions r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        StorageSettings r0 = createSettings(r5, r3, r4);
        if (r3.isI18n() == true) goto L5;
        IInstallParameters r6 = new CNDeviceParamsProvider(r5, r0);
    L6:
        INewUserModeService r7 = (INewUserModeService) ZeusTransformUtils.preCheckCast(ServiceManager.getService(INewUserModeService.class, r4.getAidString()), INewUserModeService.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L9;
        r6 = (IInstallParameters) ZeusTransformUtils.preCheckCast(r7.tryReplaceService(IInstallParameters.class, r6), IInstallParameters.class, "com.obric.memorydata.plugin");
    L9:
        ServiceManager.registerService(IInstallParameters.class, r6, r4.getAidString());
        return;
    L5:
        r6 = new DeviceParamsProvider(r5, r0);
        goto L6
    }
}
