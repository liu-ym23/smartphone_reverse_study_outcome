package com.bytedance.android.live.livepullstream.service;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.SettingUtil;
import com.bytedance.android.live.network.api.INetworkService;
import com.bytedance.android.livehostapi.TTMiddlewareLiveSDK;
import com.bytedance.android.livesdk.i2;
import com.ss.videoarch.strategy.IAppInfoBundle;
import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a implements IAppInfoBundle {
    public final Boolean a;
    public final ConcurrentHashMap<String, Object> b;

    public final /* synthetic */ void onStrategyResult(String r1, JSONObject r2) {
        IAppInfoBundle.-CC.$default$onStrategyResult(this, r1, r2);
    }

    public a() {
        this.a = (Boolean) i2.a.getValue();
        this.b = new ConcurrentHashMap();
    }

    public final <T> T getAppInfoForKey(String r4, T r5) {
        Intrinsics.checkNotNullParameter(r5, "defaultValue");
        Object r1 = null;
        if (Intrinsics.areEqual(r4, "TTNet_NQE_INFO") == false) goto L13;
        String r6 = ao0.g.a().toString();
        if ((r6 instanceof Object) == false) goto L8;
        r1 = r6;
    L8:
        if (r1 != null) goto L11;
        return r5;
    L11:
        return (T) r1;
    L13:
        if (Intrinsics.areEqual(r4, "live_stream_strategy_sr_kernal_bin_path") == false) goto L28;
        File r7 = TTMiddlewareLiveSDK.getContext().getExternalCacheDir();     // Catch: Exception -> L24
        if (r7 == null) goto L26;
        String r8 = r7.getAbsolutePath();     // Catch: Exception -> L24
        if ((r8 instanceof Object) == false) goto L20;
        r1 = r8;
    L20:
        if (r1 != null) goto L23;
        return r5;
    L23:
        return (T) r1;
    L26:
        return r5;
    L24:
        e = move-exception;
        ALogger.d("LiveStreamManager", e.toString());
        goto L26
    L28:
        if (Intrinsics.areEqual(r4, "url_common_params") == false) goto L37;
        INetworkService r0 = (INetworkService) k.f(INetworkService.class);
        if (r0 == null) goto L32;
        Map<String, String> r2 = r0.getCommonParams();
    L33:
        if (r2 == null) goto L37;
        return (T) new JSONObject(r2);
    L32:
        r2 = null;
    L37:
        if (this.a.booleanValue() == false) goto L55;
        ConcurrentHashMap<String, Object> r3 = this.b;
        if (r3 == null) goto L53;
        if (r3.containsKey(r4) == false) goto L49;
        Object r9 = this.b.get(r4);
        if ((r9 instanceof Object) == false) goto L46;
        r1 = r9;
    L46:
        if (r1 != null) goto L60;
        return r5;
    L60:
        return (T) r1;
    L49:
        T r10 = (T) SettingUtil.getValue("key_ttlive_sdk_setting", r4, r5.getClass(), r5);
        if (r4 == null) goto L61;
        this.b.put(r4, r10);
        return r10;
    L61:
        return r10;
    L53:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
    L55:
        return (T) SettingUtil.getValue("key_ttlive_sdk_setting", r4, r5.getClass(), r5);
    }
}
