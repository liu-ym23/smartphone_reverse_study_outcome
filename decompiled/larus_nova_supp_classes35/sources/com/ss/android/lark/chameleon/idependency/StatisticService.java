package com.ss.android.lark.chameleon.idependency;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007R(\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/ss/android/lark/chameleon/idependency/StatisticService;", BuildConfig.FLAVOR, "()V", "value", "Lcom/ss/android/lark/chameleon/idependency/IStatisticService;", "iStatisticService", "getIStatisticService", "()Lcom/ss/android/lark/chameleon/idependency/IStatisticService;", "setIStatisticService", "(Lcom/ss/android/lark/chameleon/idependency/IStatisticService;)V", "sendEvent", BuildConfig.FLAVOR, "eventName", BuildConfig.FLAVOR, "params", "Lorg/json/JSONObject;", "chameleon-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class StatisticService {
    public static final StatisticService INSTANCE = null;
    private static IStatisticService iStatisticService;

    static {
        INSTANCE = new StatisticService();
    }

    private StatisticService() {
    }

    public final IStatisticService getIStatisticService() {
        return iStatisticService;
    }

    public final void setIStatisticService(IStatisticService r1) {
        iStatisticService = r1;
    }

    @JvmStatic
    public static final void sendEvent(String r1, JSONObject r2) {
        Intrinsics.checkNotNullParameter(r1, "eventName");
        IStatisticService r0 = iStatisticService;
        if (r0 == null) goto L6;
        r0.sendEvent(r1, r2);
        return;
    }
}
