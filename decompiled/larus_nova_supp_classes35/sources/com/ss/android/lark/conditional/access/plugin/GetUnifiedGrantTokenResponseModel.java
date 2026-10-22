package com.ss.android.lark.conditional.access.plugin;

import com.alibaba.fastjson.annotation.JSONField;
import com.larksuite.framework.apiplugin.annotation.LKRequiredParam;
import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/conditional/access/plugin/GetUnifiedGrantTokenResponseModel;", "Lcom/larksuite/framework/apiplugin/common/LKBaseResponseModel;", "<init>", "()V", "unifiedGrantToken", BuildConfig.FLAVOR, "getUnifiedGrantToken", "()Ljava/lang/String;", "setUnifiedGrantToken", "(Ljava/lang/String;)V", "conditional-access_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GetUnifiedGrantTokenResponseModel extends LKBaseResponseModel {

    @JSONField(name = "unifiedGrantToken")
    @LKRequiredParam
    private String unifiedGrantToken;

    public GetUnifiedGrantTokenResponseModel() {
        this.unifiedGrantToken = BuildConfig.FLAVOR;
    }

    public final String getUnifiedGrantToken() {
        return this.unifiedGrantToken;
    }

    public final void setUnifiedGrantToken(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.unifiedGrantToken = r2;
    }
}
