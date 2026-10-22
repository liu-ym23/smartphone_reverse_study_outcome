package com.bytedance.bdinstall.storage;

import android.content.Context;
import androidx.annotation.VisibleForTesting;
import com.bytedance.bdinstall.Env;
import com.bytedance.bdinstall.InstallOptions;
import com.bytedance.bdinstall.util.LocalConstants;

/* JADX INFO: loaded from: classes.dex */
class CommonDeviceParamProviderCreator {

    @VisibleForTesting
    public static final String FILE_NAME = "device_parameters";

    @VisibleForTesting
    private static final String I18N_FILE_NAME = "dp";

    CommonDeviceParamProviderCreator() {
    }

    static StorageSettings createSettings(Context r10, Env r11, InstallOptions r12) {
        if (r11.isI18n() == false) goto L7;
        String r13 = I18N_FILE_NAME;
    L5:
        String r14 = LocalConstants.wrapEnvSuffix(r13, r11);
        if (r12.isLocalTest() == false) goto L13;
        r14 = r14 + "_local";
    L13:
        StorageSettings r15 = new StorageSettings();
        r15.setFileName(r14 + ".dat");
        r15.setSp(r11.getEnvIsolateSp(r12));
        r15.setAnonymous(r12.isAnonymous());
        r15.setLocalTest(r12.isLocalTest());
        r15.setAccount(r12.getAccount(), LocalConstants.wrapEnvSuffix("", r11));
        r15.setNeedSharedStorage(r12.isNeedSharedStorage());
        r15.setOptions(r12);
        return r15;
    L7:
        if (r12.isMainInstance() == false) goto L9;
        r13 = FILE_NAME;
        goto L5
    L9:
        r13 = "device_parameters_" + r12.getAid();
        goto L5
    }
}
