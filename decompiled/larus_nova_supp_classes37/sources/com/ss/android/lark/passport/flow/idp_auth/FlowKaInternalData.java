package com.ss.android.lark.passport.flow.idp_auth;

import com.alibaba.fastjson.annotation.JSONField;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR \u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR \u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/passport/flow/idp_auth/FlowKaInternalData;", "Ljava/io/Serializable;", "<init>", "()V", "userAgent", "", "getUserAgent", "()Ljava/lang/String;", "setUserAgent", "(Ljava/lang/String;)V", "mpwUrl", "getMpwUrl", "setMpwUrl", "refreshApiId", "getRefreshApiId", "setRefreshApiId", "refreshAppId", "getRefreshAppId", "setRefreshAppId", "refreshUrl", "getRefreshUrl", "setRefreshUrl", "flow-passport-mfa_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class FlowKaInternalData implements Serializable {

    @JSONField(name = "mpw_url")
    private String mpwUrl;

    @JSONField(name = "refresh_api_id")
    private String refreshApiId;

    @JSONField(name = "refresh_app_id")
    private String refreshAppId;

    @JSONField(name = "refresh_url")
    private String refreshUrl;

    @JSONField(name = "user_agent")
    private String userAgent;

    public FlowKaInternalData() {
    }

    public final String getMpwUrl() {
        return this.mpwUrl;
    }

    public final String getRefreshApiId() {
        return this.refreshApiId;
    }

    public final String getRefreshAppId() {
        return this.refreshAppId;
    }

    public final String getRefreshUrl() {
        return this.refreshUrl;
    }

    public final String getUserAgent() {
        return this.userAgent;
    }

    public final void setMpwUrl(String r1) {
        this.mpwUrl = r1;
    }

    public final void setRefreshApiId(String r1) {
        this.refreshApiId = r1;
    }

    public final void setRefreshAppId(String r1) {
        this.refreshAppId = r1;
    }

    public final void setRefreshUrl(String r1) {
        this.refreshUrl = r1;
    }

    public final void setUserAgent(String r1) {
        this.userAgent = r1;
    }
}
