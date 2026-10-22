package com.bytedance.bdinstall.loader;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.BuildConfig;
import com.bytedance.bdinstall.DrLog;
import com.bytedance.bdinstall.Env;
import com.bytedance.bdinstall.InstallOptions;
import com.bytedance.bdinstall.PreInstallChannelCallback;
import com.bytedance.bdinstall.event.ActivateMonitor;
import com.bytedance.bdinstall.event.RegisterMonitor;
import com.bytedance.bdinstall.migrate.MigrateDetector;
import com.bytedance.bdinstall.service.INewUserModeService;
import com.bytedance.bdinstall.service.ServiceManager;
import com.bytedance.bdinstall.util.EventUtils;
import com.bytedance.bdinstall.util.RequestIdGenerator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class DRSpecialLoader {
    private static final String KEY_FIRST_INSTALL_TIME = "apk_first_install_time";
    private static final String KEY_GIT_HASH = "git_hash";
    private static final String KEY_IS_SYSTEM_APP = "is_system_app";
    private static final String KEY_PRE_INSTALL_CHANNEL = "pre_installed_channel";
    private final InstallOptions mOptions;

    DRSpecialLoader(InstallOptions r10) {
        this.mOptions = r10;
    }

    private void addPreInstallInfo(JSONObject r10) {
        Context r11 = this.mOptions.getContext();
        PreInstallChannelCallback r12 = this.mOptions.getPreInstallChannelCallback();
        if (r12 == null) goto L19;
        r10.put(KEY_PRE_INSTALL_CHANNEL, r12.getChannel(r11));
    L19:
        int r13 = 0;
        PackageInfo r14 = r11.getPackageManager().getPackageInfo(r11.getPackageName(), 0);     // Catch: Throwable -> L16
        if (r14 == null) goto L21;
        r10.put(KEY_FIRST_INSTALL_TIME, r14.firstInstallTime);     // Catch: Throwable -> L16
        if ((r14.applicationInfo.flags & 1) != 1) goto L10;
        boolean r15 = true;
    L12:
        if (r15 == false) goto L14;
        r13 = 1;
    L14:
        r10.put(KEY_IS_SYSTEM_APP, r13);     // Catch: Throwable -> L16
        return;
    L10:
        r15 = false;
        goto L12
    L21:
        return;
    L16:
        th = move-exception;
        th.printStackTrace();
    }

    private void setScene(InstallOptions r10, Env r11, INewUserModeService r12) {
        RegisterMonitor r13 = EventUtils.getInstance().getRegisterMonitor(r10.getAid());
        ActivateMonitor r14 = EventUtils.getInstance().getActivateMonitor(r10.getAid());
        if (r11.isChildMode() == false) goto L7;
        int r15 = 2;
    L5:
        r13.setScene(r15);
        r14.setScene(r15);
        if (r12 == null) goto L13;
        r13.setNewUserMode(r12.isNewUserMode() ? 1 : 0);
        r14.setNewUserMode(r12.isNewUserMode() ? 1 : 0);
        return;
    L13:
        return;
    L7:
        if (r10.isTouristMode() == false) goto L9;
        r15 = 1;
        goto L5
    L9:
        r15 = 0;
        goto L5
    }

    protected boolean doLoad(JSONObject r10, Env r11) {
        if (r11.isChildMode() == false) goto L5;
        r10.put("scene", 2);
    L5:
        r10.put("device_platform", "android");
        new HarmonyLoader().doLoad(r10);
        r10.put(KEY_GIT_HASH, BuildConfig.GIT_HASH);
        r10.put(Api.KEY_SDK_VERSION_CODE, DrLog.SDK_VERSION_CODE);
        r10.put(Api.KEY_SDK_TARGET_VERSION, 30);
        r10.put("req_id", RequestIdGenerator.getRequestId());
        r10.put("sdk_version", BuildConfig.BDINSTALL_VERSION_NAME);
        r10.put("guest_mode", this.mOptions.isTouristMode() ? 1 : 0);
        r10.put("sdk_flavor", BuildConfig.FLAVOR);
        if (MigrateDetector.isThisDeviceMigrate(this.mOptions.getContext(), this.mOptions) == false) goto L14;
        String r12 = MigrateDetector.getOldDid(this.mOptions.getContext(), this.mOptions);
        if (TextUtils.isEmpty(r12) == false) goto L19;
        r12 = "";
    L19:
        r10.put("old_did", r12);     // Catch: JSONException -> L12
    L12:
        e = move-exception;
        e.printStackTrace();
    L14:
        addPreInstallInfo(r10);
        INewUserModeService r13 = (INewUserModeService) ServiceManager.getService(INewUserModeService.class, String.valueOf(this.mOptions.getAid()));
        if (r13 == null) goto L17;
        r13.addNewUserModeExtra(r10);
    L17:
        setScene(this.mOptions, r11, r13);
        return true;
    }
}
