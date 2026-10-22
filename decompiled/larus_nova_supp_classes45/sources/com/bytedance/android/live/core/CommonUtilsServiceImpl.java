package com.bytedance.android.live.core;

import android.app.Activity;
import ao0.g;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.network.c;
import com.bytedance.android.livehostapi.SDKInitTracer;
import com.bytedance.android.livesdk.utils.z0;
import com.bytedance.android.livesdkapi.api.IUtilsCommonService;
import com.bytedance.android.livesdkapi.brightness.ILiveBrightnessService;
import com.ss.android.ugc.quota.BDNetworkTagContextProviderAdapter;
import com.ss.android.ugc.quota.BDNetworkTagManager;
import jc1.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class CommonUtilsServiceImpl implements IUtilsCommonService {

    public class a extends BDNetworkTagContextProviderAdapter {
        public final int triggerType() {
            return 0;
        }

        public a() {
        }
    }

    public long startTimeOfSDKInitTracer() {
        return SDKInitTracer.INSTANCE.getStartTime();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CommonUtilsServiceImpl() {
        k.l(IUtilsCommonService.class, this);
    }

    public String getBDNetWorkRequestTag() {
        return (String) BDNetworkTagManager.getInstance().buildBDNetworkTag(new a()).second;
    }

    public JSONObject nQECommonParamsBuild() {
        return g.a();
    }

    public float deviceScoreHelperGetScore(boolean r1) {
        return z0.b(r1);
    }

    public int liveBrightnessUtilGetSystemValue(Activity r2) {
        ILiveBrightnessService r0 = k.f(ILiveBrightnessService.class);
        if (r0 != null) goto L7;
        return -1;
    L7:
        return r0.getSystemValue(r2);
    }

    public <T> T liveClientGetService(Class<T> r2) {
        return (T) c.b().e(r2);
    }

    public void runOnUIThread(Function0<Unit> r4) {
        UtilityKotlinExtentionsKt.r(0, false, false, r4);
    }

    public void showCenterToast(String r2) {
        f2.c(r2, 0);
    }

    public void showSystemToast(String r1, int r2) {
        f2.j(r1, r2);
    }
}
