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

/* JADX INFO: loaded from: classes.dex */
final class MigrateClear {
    MigrateClear() {
    }

    public static void clear(Context r10, InstallOptions r11, Env r12) {
        GaidGetter.clearSp(r10, r11);
        Utils.removeSpValues(r11.getSp(), new String[]{"device_id", "bd_did", "install_id", "device_token"});
        if (r12 == null) goto L13;
        SharedPreferences r13 = r12.getEnvIsolateSp(r11);
        if (r13 == null) goto L13;
        Utils.removeSpValues(r13, new String[]{"device_id", "bd_did", "install_id", "device_token"});
    L13:
        Utils.removeSpValues(r10.getSharedPreferences(Constants.SP_FILE_OPEN_UDID, 0), new String[]{"clientudid", "openudid", "serial_number"});     // Catch: Exception -> L9
    L11:
        Utils.removeSpValues(LocalConstants.getCommonSp(r10, r11), new String[]{"clientudid", "openudid", "serial_number"});
        Cdid.clearCdid(r10, r11);
        Oaid.instance(r10).clear();
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }
}
