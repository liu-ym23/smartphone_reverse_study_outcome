package com.bytedance.bdinstall.loader;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.DrLog;
import com.bytedance.bdinstall.Env;
import com.bytedance.bdinstall.InstallOptions;
import com.bytedance.bdinstall.Utils;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class ConfigLoader extends BaseLoader {
    private final Context mApp;
    private final InstallOptions mConfig;
    private final Env mEnv;

    ConfigLoader(Context r10, InstallOptions r11, Env r12) {
        super(false, true);
        this.mApp = r10;
        this.mConfig = r11;
        this.mEnv = r12;
    }

    @Override // com.bytedance.bdinstall.loader.BaseLoader
    protected boolean doLoad(JSONObject r10) {
        r10.put("channel", this.mConfig.getChannel());
        r10.put(Api.KEY_NOT_REQUEST_SENDER, 1);
        r10.put("aid", this.mConfig.getAid());
        String r11 = this.mConfig.getReleaseBuild();
        if (r11 != null) goto L5;
        r11 = "";
    L5:
        r10.put("release_build", r11);
        Utils.putStringIfNotEmpty(r10, Api.KEY_USER_AGENT, this.mConfig.getUserAgent());
        Utils.putStringIfNotEmpty(r10, Api.KEY_AB_VERSION, this.mConfig.getAbVersion());
        String r12 = this.mConfig.getAppLanguage();
        if (TextUtils.isEmpty(r12) == false) goto L8;
        r12 = this.mConfig.getAppLanguageFromSp();
    L8:
        Utils.putStringIfNotEmpty(r10, Api.KEY_APP_LANGUAGE, r12);
        String r13 = this.mConfig.getAppRegion();
        if (TextUtils.isEmpty(r13) == false) goto L11;
        r13 = this.mConfig.getAppRegionFromSp();
    L11:
        Utils.putStringIfNotEmpty(r10, Api.KEY_APP_REGION, r13);
        JSONObject r14 = this.mConfig.getAppTrack();
        if (r14 != null) goto L38;
    L17:
        JSONObject r15 = r10.optJSONObject("custom");
        if (r15 != null) goto L21;
        r15 = new JSONObject();
    L21:
        if (TextUtils.isEmpty(this.mConfig.getZijiePackage()) == true) goto L36;
        r15.put(Api.KEY_REAL_PACKAGE_NAME, this.mConfig.getContext().getPackageName());
    L36:
        Map<String, Object> r16 = this.mConfig.getCustomHeader();     // Catch: Throwable -> L32
        if (r16 != null) goto L26;
    L34:
        r10.put("custom", r15);
        return true;
    L26:
        if (r16.size() <= 0) goto L34;
        Iterator<String> r17 = r16.keySet().iterator();     // Catch: Throwable -> L32
    L29:
        if (r17.hasNext() == false) goto L34;
        String r18 = r17.next();     // Catch: Throwable -> L32
        r15.put(r18, r16.get(r18));     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        th.printStackTrace();
        goto L34
    L38:
        r10.put(Api.KEY_APP_TRACK, r14);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        DrLog.ysnp(th);
        goto L17
    }

    @Override // com.bytedance.bdinstall.loader.BaseLoader
    public void remove(JSONObject r10) {
        super.remove(r10);
        r10.remove("channel");
        r10.remove(Api.KEY_NOT_REQUEST_SENDER);
        r10.remove("aid");
        r10.remove("release_build");
        r10.remove(Api.KEY_USER_AGENT);
        r10.remove(Api.KEY_AB_VERSION);
        r10.remove(Api.KEY_APP_LANGUAGE);
        r10.remove(Api.KEY_APP_REGION);
        r10.remove(Api.KEY_APP_TRACK);
        r10.remove("custom");
    }
}
