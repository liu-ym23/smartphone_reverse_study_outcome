package com.ss.android.lark.chameleon.idependency;

import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u001a\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u0007H&¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/chameleon/idependency/INetCallback;", BuildConfig.FLAVOR, "onFailure", BuildConfig.FLAVOR, "errorCode", BuildConfig.FLAVOR, ChameleonOpenTracker.ParamKey.ERRORMSG, BuildConfig.FLAVOR, "onSuccess", "code", ChameleonOpenTracker.ParamKey.RESULT, "chameleon-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface INetCallback {
    void onFailure(int r1, String r2);

    void onSuccess(int r1, String r2);
}
