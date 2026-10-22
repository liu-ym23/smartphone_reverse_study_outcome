package com.bytedance.bdinstall.loader;

import android.content.Context;
import com.bytedance.bdinstall.BDInstall;
import com.bytedance.bdinstall.DrLog;
import com.bytedance.bdinstall.Env;
import com.bytedance.bdinstall.ExecutorUtil;
import com.bytedance.bdinstall.InstallOptions;
import com.bytedance.bdinstall.intf.IAdIdConfig;
import com.bytedance.bdinstall.oaid.Oaid;
import com.bytedance.bdinstall.util.RomUtils;

/* JADX INFO: loaded from: classes.dex */
public class LocaleDeviceManager extends DeviceManager {
    public LocaleDeviceManager(Context r10, InstallOptions r11, Env r12) {
        super(r10, r11, r12);
    }

    @Override // com.bytedance.bdinstall.loader.DeviceManager
    protected void migrate() {
        super.migrate();
        if (this.mOptions.isMainInstance() == false) goto L5;
        IAdIdConfig r10 = BDInstall.getAdIdConfig();
    L7:
        if (r10.enablePrefetchAdId() == false) goto L10;
        Oaid.instance(this.mApp).init();
        return;
    L10:
        return;
    L5:
        r10 = BDInstall.getInstance(String.valueOf(this.mOptions.getAid())).getAdIdConfig();
        goto L7
    }

    @Override // com.bytedance.bdinstall.loader.DeviceManager
    public void start() {
        super.start();
        if (this.mOptions.isNeedSharedStorage() == false) goto L5;
        return;
    L5:
        if (this.mOptions.deleteSharedStorage() == true) goto L7;
        return;
    L7:
        if (RomUtils.isAndroidROrHigher() == true) goto L9;
    L12:
        ExecutorUtil.runOnIOExecutor(this.mOptions.getAidString(), new DeprecatedFileCleaner(this.mOptions));
        return;
    L9:
        if (RomUtils.isTargetROrHigher(this.mApp) == false) goto L12;
        DrLog.d("target r, not clean");
    }
}
