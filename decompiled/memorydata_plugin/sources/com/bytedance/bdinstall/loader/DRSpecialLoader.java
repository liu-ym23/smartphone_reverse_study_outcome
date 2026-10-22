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
import com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class DRSpecialLoader {
    private static final String KEY_FIRST_INSTALL_TIME = "apk_first_install_time";
    private static final String KEY_GIT_HASH = "git_hash";
    private static final String KEY_IS_SYSTEM_APP = "is_system_app";
    private static final String KEY_PRE_INSTALL_CHANNEL = "pre_installed_channel";
    private final InstallOptions mOptions;

    DRSpecialLoader(InstallOptions r1) {
        this.mOptions = r1;
    }

    private void addPreInstallInfo(JSONObject r5) {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.mOptions.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        PreInstallChannelCallback r4 = this.mOptions.getPreInstallChannelCallback();
        if (r4 == null) goto L19;
        r5.put(KEY_PRE_INSTALL_CHANNEL, r4.getChannel(r0));
    L19:
        int r1 = 0;
        PackageInfo r6 = r0.getPackageManager().getPackageInfo(r0.getPackageName(), 0);     // Catch: Throwable -> L16
        if (r6 == null) goto L21;
        r5.put(KEY_FIRST_INSTALL_TIME, r6.firstInstallTime);     // Catch: Throwable -> L16
        if ((r6.applicationInfo.flags & 1) != 1) goto L10;
        boolean r7 = true;
    L12:
        if (r7 == false) goto L14;
        r1 = 1;
    L14:
        r5.put(KEY_IS_SYSTEM_APP, r1);     // Catch: Throwable -> L16
        return;
    L10:
        r7 = false;
        goto L12
    L21:
        return;
    L16:
        th = move-exception;
        th.printStackTrace();
    }

    private void setScene(InstallOptions r3, Env r4, INewUserModeService r5) {
        INewUserModeService r2 = (INewUserModeService) ZeusTransformUtils.wrapperContextForParams(r5, INewUserModeService.class, "com.obric.memorydata.plugin");
        RegisterMonitor r6 = EventUtils.getInstance().getRegisterMonitor(r3.getAid());
        ActivateMonitor r0 = EventUtils.getInstance().getActivateMonitor(r3.getAid());
        if (r4.isChildMode() == false) goto L7;
        int r7 = 2;
    L5:
        r6.setScene(r7);
        r0.setScene(r7);
        if (r2 == null) goto L13;
        r6.setNewUserMode(r2.isNewUserMode() ? 1 : 0);
        r0.setNewUserMode(r2.isNewUserMode() ? 1 : 0);
        return;
    L13:
        return;
    L7:
        if (r3.isTouristMode() == false) goto L9;
        r7 = 1;
        goto L5
    L9:
        r7 = 0;
        goto L5
    }

    public boolean doLoad(JSONObject r4, Env r5) {
        if (r5.isChildMode() == false) goto L5;
        r4.put(MemoryInfoSectionEditActivity.KIND_SCENE, 2);
    L5:
        r4.put("device_platform", "android");
        new HarmonyLoader().doLoad(r4);
        r4.put(KEY_GIT_HASH, BuildConfig.GIT_HASH);
        r4.put(Api.KEY_SDK_VERSION_CODE, DrLog.SDK_VERSION_CODE);
        r4.put(Api.KEY_SDK_TARGET_VERSION, 30);
        r4.put("req_id", RequestIdGenerator.getRequestId());
        r4.put("sdk_version", BuildConfig.BDINSTALL_VERSION_NAME);
        r4.put("guest_mode", this.mOptions.isTouristMode() ? 1 : 0);
        r4.put("sdk_flavor", BuildConfig.FLAVOR);
        if (MigrateDetector.isThisDeviceMigrate((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.mOptions.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), this.mOptions) == false) goto L14;
        String r0 = MigrateDetector.getOldDid((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.mOptions.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), this.mOptions);
        if (TextUtils.isEmpty(r0) == false) goto L19;
        r0 = "";
    L19:
        r4.put("old_did", r0);     // Catch: JSONException -> L12
    L12:
        e = move-exception;
        e.printStackTrace();
    L14:
        addPreInstallInfo(r4);
        INewUserModeService r1 = (INewUserModeService) ZeusTransformUtils.preCheckCast(ServiceManager.getService(INewUserModeService.class, String.valueOf(this.mOptions.getAid())), INewUserModeService.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L17;
        r1.addNewUserModeExtra(r4);
    L17:
        setScene(this.mOptions, r5, r1);
        return true;
    }
}
