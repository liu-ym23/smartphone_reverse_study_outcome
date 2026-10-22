package com.bytedance.bdinstall.storage;

import android.annotation.SuppressLint;
import android.content.Context;
import com.bytedance.bdinstall.Env;
import com.bytedance.bdinstall.InstallOptions;
import com.bytedance.bdinstall.service.IInstallParameters;
import com.bytedance.bdinstall.service.INewUserModeService;
import com.bytedance.bdinstall.service.ServiceManager;

/* JADX INFO: loaded from: classes.dex */
public class DeviceParamProviderCreator extends CommonDeviceParamProviderCreator {
    public DeviceParamProviderCreator() {
    }

    @SuppressLint({"VisibleForTests"})
    public static void registerInstallParameterProvider(Context r10, Env r11, InstallOptions r12) {
        StorageSettings r13 = CommonDeviceParamProviderCreator.createSettings(r10, r11, r12);
        if (r11.isI18n() == true) goto L5;
        IInstallParameters r14 = new CNDeviceParamsProvider(r10, r13);
    L6:
        INewUserModeService r15 = (INewUserModeService) ServiceManager.getService(INewUserModeService.class, r12.getAidString());
        if (r15 == null) goto L9;
        r14 = (IInstallParameters) r15.tryReplaceService(IInstallParameters.class, r14);
    L9:
        ServiceManager.registerService(IInstallParameters.class, r14, r12.getAidString());
        return;
    L5:
        r14 = new DeviceParamsProvider(r10, r13);
        goto L6
    }
}
