package com.bytedance.android.livesdk.effect;

import android.content.Context;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livehostapi.foundation.IHostContext;
import com.bytedance.android.livesdk.live.extension.plugin.api.effectsdk.ILiveWrappedEffectSDKService;
import kotlin.Metadata;
import tb1.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00062\u00020\u0001:\u0001\u0007B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/effect/EffectUpdateHelper;", "", "", "initEffect", "<init>", "()V", "Companion", "a", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class EffectUpdateHelper {
    public static final a Companion = null;
    private static final String TAG = "EffectUpdateHelper";

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public EffectUpdateHelper() {
    }

    public final void initEffect() {
        if (c.g == false) goto L15;
        IHostContext r2 = TTLiveSDK.hostService().appContext();
        boolean r9 = v.a();
        String r10 = r2.getServerDeviceId();
        int r11 = r2.appId();
        String r12 = r2.getVersionName();
        Context r8 = r2.context();
        ILiveWrappedEffectSDKService.Companion.getClass();     // Catch: Throwable -> L10
        ILiveWrappedEffectSDKService r3 = ILiveWrappedEffectSDKService.a.a();     // Catch: Throwable -> L10
        if (r3 == null) goto L8;
        r3.buildEffectUpdateRunner(r9, r10, r11, r12, r8);     // Catch: Throwable -> L10
    L8:
        ALogger.d(TAG, "isDebugMode:" + r9 + "  deviceId:" + r10 + "  appId:" + r11 + "  appVersion:" + r12);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
        ALogger.e(TAG, "EffectUpdateRunner error: " + th);
        return;
    }
}
