package com.bytedance.bdinstall.loader;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.DrLog;
import com.bytedance.bdinstall.util.DigestUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class SigHashLoader extends BaseLoader {
    private final Context mApp;

    SigHashLoader(Context r10) {
        super(true, false);
        this.mApp = r10;
    }

    @Override // com.bytedance.bdinstall.loader.BaseLoader
    protected boolean doLoad(JSONObject r10) {
        String r11 = null;
        PackageInfo r12 = this.mApp.getPackageManager().getPackageInfo(this.mApp.getPackageName(), 64);     // Catch: PackageManager.NameNotFoundException -> L5
    L7:
        if (r12 == null) goto L15;
        Signature[] r13 = r12.signatures;
        if (r13 == null) goto L15;
        if (r13.length <= 0) goto L15;
        Signature r14 = r13[0];
        if (r14 == null) goto L15;
        r11 = DigestUtils.md5Hex(r14.toByteArray());
    L15:
        if (r11 == null) goto L21;
        r10.put(Api.KEY_SIG_HASH, r11);
        return true;
    L21:
        return true;
    L5:
        e = move-exception;
        DrLog.ysnp(e);
        r12 = null;
        goto L7
    }
}
