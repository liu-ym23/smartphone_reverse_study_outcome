package com.bytedance.bdinstall.storage;

import android.content.Context;
import com.bytedance.bdinstall.Env;
import com.bytedance.bdinstall.InstallOptions;
import com.bytedance.bdinstall.util.LocalConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
class CommonDeviceParamProviderCreator {
    public static final String FILE_NAME = "device_parameters";
    private static final String I18N_FILE_NAME = "dp";

    CommonDeviceParamProviderCreator() {
    }

    static StorageSettings createSettings(Context r2, Env r3, InstallOptions r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (r3.isI18n() == false) goto L7;
        String r6 = I18N_FILE_NAME;
    L5:
        String r7 = LocalConstants.wrapEnvSuffix(r6, r3);
        if (r4.isLocalTest() == false) goto L13;
        r7 = r7 + "_local";
    L13:
        StorageSettings r0 = new StorageSettings();
        r0.setFileName(r7 + ".dat");
        r0.setSp(r3.getEnvIsolateSp(r4));
        r0.setAnonymous(r4.isAnonymous());
        r0.setLocalTest(r4.isLocalTest());
        r0.setAccount(r4.getAccount(), LocalConstants.wrapEnvSuffix("", r3));
        r0.setNeedSharedStorage(r4.isNeedSharedStorage());
        r0.setOptions(r4);
        return r0;
    L7:
        if (r4.isMainInstance() == false) goto L9;
        r6 = FILE_NAME;
        goto L5
    L9:
        r6 = "device_parameters_" + r4.getAid();
        goto L5
    }
}
