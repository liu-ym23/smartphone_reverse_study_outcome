package ms0;

import android.content.Context;
import com.bytedance.android.live.LiveGsonHelper;
import com.bytedance.android.live.base.sp.TTOpenLiveSettingUtil;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.preinit.setting.LiveSettingManager;
import com.bytedance.android.livehostapi.foundation.IHostContext;
import com.bytedance.android.livehostapi.foundation.IHostNetwork;
import com.bytedance.android.livesdk.config.LiveInitSettingKeysForSaas;
import com.bytedance.android.livesdkapi.util.LiveSDKConstUtil;
import com.bytedance.common.utility.NetworkClient;
import com.bytedance.frameworks.baselib.network.http.util.UrlBuilder;
import com.google.gson.JsonObject;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadAsyncTask;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import jc1.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c extends PthreadAsyncTask<String, Void, JsonObject> {
    public final Context h;

    public c(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.h = r2;
    }

    public final Object doInBackground(Object[] r6) {
        Intrinsics.checkNotNullParameter((String[]) r6, "strings");
        IHostNetwork r7 = k.f(IHostNetwork.class);
        if (r7 == null) goto L33;
        String r8 = r7.getHostDomain();
        if (r8 == null) goto L34;
        UrlBuilder r1 = new UrlBuilder("https://" + r8 + LiveSettingManager.SETTING_PATH);
        IHostContext r9 = k.f(IHostContext.class);
        boolean r2 = false;
        if (r9 == null) goto L9;
        int r10 = r9.appId();
    L10:
        r1.addParam("webcast_app_id", r10);
        String r11 = LiveSDKConstUtil.getSdkVersion();
        if (r11.length() <= 0) goto L13;
        boolean r3 = true;
    L14:
        if (r3 == true) goto L17;
        r11 = null;
    L17:
        if (r11 == null) goto L31;
        r1.addParam("webcast_sdk_version", r11);
    L31:
        String r12 = NetworkClient.getDefault().get(r1.build());     // Catch: Exception -> L28
        if (r12.length() <= 0) goto L22;
        r2 = true;
    L22:
        if (r2 == true) goto L25;
        r12 = null;
    L25:
        if (r12 == null) goto L35;
        LiveInitSettingKeysForSaas.canReadPerformanceSettings = true;     // Catch: Exception -> L28
        return ((a) LiveGsonHelper.get().fromJson(r12, a.class)).a();
    L35:
        return null;
    L28:
        e = move-exception;
        ALogger.e("ttlive_error", e);
        return null;
    L13:
        r3 = false;
        goto L14
    L9:
        r10 = 0;
        goto L10
    L34:
        return null;
    L33:
        return null;
    }

    public final void onPostExecute(Object r3) {
        JsonObject r4 = (JsonObject) r3;
        if (r4 != null) goto L7;
        Function1<Boolean, Unit> r0 = LiveSettingManager.INSTANCE.getSETTING_CALLBACK();
        if (r0 == null) goto L8;
        Unit r1 = (Unit) r0.invoke(Boolean.TRUE);
    L8:
        if (r4 == null) goto L11;
        TTOpenLiveSettingUtil.updateSettings(this.h, r4);
        return;
    L11:
        return;
    L7:
        TTOpenLiveSettingUtil.settingUpdateFinish.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(b.a);
        goto L8
    }
}
