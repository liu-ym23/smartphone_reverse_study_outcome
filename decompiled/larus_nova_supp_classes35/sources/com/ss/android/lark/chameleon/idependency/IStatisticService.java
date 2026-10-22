package com.ss.android.lark.chameleon.idependency;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/chameleon/idependency/IStatisticService;", BuildConfig.FLAVOR, "sendEvent", BuildConfig.FLAVOR, "eventName", BuildConfig.FLAVOR, "param", "Lorg/json/JSONObject;", "chameleon-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface IStatisticService {
    void sendEvent(String r1, JSONObject r2);
}
