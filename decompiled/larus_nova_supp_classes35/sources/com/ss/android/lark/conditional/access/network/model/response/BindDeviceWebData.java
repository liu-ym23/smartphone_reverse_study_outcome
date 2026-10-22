package com.ss.android.lark.conditional.access.network.model.response;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/conditional/access/network/model/response/BindDeviceWebData;", "Ljava/io/Serializable;", "<init>", "()V", ChameleonOpenTracker.OpenResult.SUCCESS, BuildConfig.FLAVOR, "getSuccess", "()Z", "setSuccess", "(Z)V", "conditional-access_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BindDeviceWebData implements Serializable {

    @SerializedName(ChameleonOpenTracker.OpenResult.SUCCESS)
    private boolean success;

    public BindDeviceWebData() {
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public final void setSuccess(boolean r1) {
        this.success = r1;
    }
}
