package com.ivy.ivykit.api.bridge.inject;

import androidx.annotation.Keep;
import kotlin.Metadata;
import nl.g;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/ivy/ivykit/api/bridge/inject/IChooseMediaResultCallback;", "", "Lnl/g;", "result", "", "msg", "", "onSuccess", "(Lnl/g;Ljava/lang/String;)V", "", "code", "onFailure", "(ILjava/lang/String;)V", "ivy_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface IChooseMediaResultCallback {
    void onFailure(int r5, String r10);

    void onSuccess(g r5, String r10);
}
