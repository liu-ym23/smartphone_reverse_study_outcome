package com.ss.android.lark.chameleon.pluginapi;

import android.view.View;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Deprecated;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Deprecated(message = "此接口已废弃，不建议使用")
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0003\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\u001a\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH&¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/chameleon/pluginapi/ILoadingPlugin;", BuildConfig.FLAVOR, "getLoadingView", "Landroid/view/View;", "onLoadSuccess", BuildConfig.FLAVOR, "onLoadFail", "code", BuildConfig.FLAVOR, "e", BuildConfig.FLAVOR, "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ILoadingPlugin {
    View getLoadingView();

    void onLoadFail(int r1, Throwable r2);

    void onLoadSuccess();
}
