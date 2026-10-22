package com.bytedance.bdinstall.loader;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.bdinstall.Cdid;
import com.bytedance.bdinstall.Env;
import com.bytedance.bdinstall.InstallOptions;
import com.bytedance.bdinstall.Utils;
import com.bytedance.bdinstall.oaid.Oaid;
import com.bytedance.bdinstall.util.Constants;
import com.bytedance.bdinstall.util.GaidGetter;
import com.bytedance.bdinstall.util.LocalConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
final class MigrateClear {
    MigrateClear() {
    }

    public static void clear(Context r9, InstallOptions r10, Env r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        GaidGetter.clearSp(r12, r10);
        Utils.removeSpValues(r10.getSp(), new String[]{"device_id", "bd_did", "install_id", "device_token"});
        if (r11 == null) goto L13;
        SharedPreferences r13 = r11.getEnvIsolateSp(r10);
        if (r13 == null) goto L13;
        Utils.removeSpValues(r13, new String[]{"device_id", "bd_did", "install_id", "device_token"});
    L13:
        Utils.removeSpValues(r12.getSharedPreferences(Constants.SP_FILE_OPEN_UDID, 0), new String[]{"clientudid", "openudid", "serial_number"});     // Catch: Exception -> L9
    L11:
        Utils.removeSpValues(LocalConstants.getCommonSp(r12, r10), new String[]{"clientudid", "openudid", "serial_number"});
        Cdid.clearCdid(r12, r10);
        Oaid.instance(r12).clear();
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }
}
