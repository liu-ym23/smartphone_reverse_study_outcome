package com.ss.android.lark.chameleon.api.pluginapi;

import android.view.View;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&J\b\u0010\n\u001a\u00020\u0005H&¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/chameleon/api/pluginapi/ILoadingPlugin;", BuildConfig.FLAVOR, "getLoadingView", "Landroid/view/View;", "onLoadFail", BuildConfig.FLAVOR, "code", BuildConfig.FLAVOR, "e", BuildConfig.FLAVOR, "onLoadSuccess", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface ILoadingPlugin {
    View getLoadingView();

    void onLoadFail(int r1, Throwable r2);

    void onLoadSuccess();
}
