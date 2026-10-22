package com.bytedance.bdinstall.loader;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.DrLog;
import com.bytedance.bdinstall.Env;
import com.bytedance.bdinstall.InstallOptions;
import com.bytedance.bdinstall.Utils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class ConfigLoader extends BaseLoader {
    private final Context mApp;
    private final InstallOptions mConfig;
    private final Env mEnv;

    ConfigLoader(Context r4, InstallOptions r5, Env r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        super(false, true);
        this.mApp = ZeusTransformUtils.wrapperContext(r7, "com.obric.memorydata.plugin");
        this.mConfig = r5;
        this.mEnv = r6;
    }

    @Override // com.bytedance.bdinstall.loader.BaseLoader
    public boolean doLoad(JSONObject r8) {
        r8.put("channel", this.mConfig.getChannel());
        r8.put(Api.KEY_NOT_REQUEST_SENDER, 1);
        r8.put("aid", this.mConfig.getAid());
        String r0 = this.mConfig.getReleaseBuild();
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        r8.put("release_build", r0);
        Utils.putStringIfNotEmpty(r8, Api.KEY_USER_AGENT, this.mConfig.getUserAgent());
        Utils.putStringIfNotEmpty(r8, Api.KEY_AB_VERSION, this.mConfig.getAbVersion());
        String r1 = this.mConfig.getAppLanguage();
        if (TextUtils.isEmpty(r1) == false) goto L8;
        r1 = this.mConfig.getAppLanguageFromSp();
    L8:
        Utils.putStringIfNotEmpty(r8, Api.KEY_APP_LANGUAGE, r1);
        String r2 = this.mConfig.getAppRegion();
        if (TextUtils.isEmpty(r2) == false) goto L11;
        r2 = this.mConfig.getAppRegionFromSp();
    L11:
        Utils.putStringIfNotEmpty(r8, Api.KEY_APP_REGION, r2);
        JSONObject r3 = this.mConfig.getAppTrack();
        if (r3 != null) goto L38;
    L17:
        JSONObject r4 = r8.optJSONObject("custom");
        if (r4 != null) goto L21;
        r4 = new JSONObject();
    L21:
        if (TextUtils.isEmpty(this.mConfig.getZijiePackage()) == true) goto L36;
        r4.put(Api.KEY_REAL_PACKAGE_NAME, ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.mConfig.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getPackageName());
    L36:
        Map<String, Object> r7 = this.mConfig.getCustomHeader();     // Catch: Throwable -> L32
        if (r7 != null) goto L26;
    L34:
        r8.put("custom", r4);
        return true;
    L26:
        if (r7.size() <= 0) goto L34;
        Iterator<String> r5 = r7.keySet().iterator();     // Catch: Throwable -> L32
    L29:
        if (r5.hasNext() == false) goto L34;
        String r6 = (String) ZeusTransformUtils.preCheckCast(r5.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L32
        r4.put(r6, r7.get(r6));     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        th.printStackTrace();
        goto L34
    L38:
        r8.put(Api.KEY_APP_TRACK, r3);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        DrLog.ysnp(th);
        goto L17
    }

    @Override // com.bytedance.bdinstall.loader.BaseLoader
    public void remove(JSONObject r1) {
        super.remove(r1);
        r1.remove("channel");
        r1.remove(Api.KEY_NOT_REQUEST_SENDER);
        r1.remove("aid");
        r1.remove("release_build");
        r1.remove(Api.KEY_USER_AGENT);
        r1.remove(Api.KEY_AB_VERSION);
        r1.remove(Api.KEY_APP_LANGUAGE);
        r1.remove(Api.KEY_APP_REGION);
        r1.remove(Api.KEY_APP_TRACK);
        r1.remove("custom");
    }
}
