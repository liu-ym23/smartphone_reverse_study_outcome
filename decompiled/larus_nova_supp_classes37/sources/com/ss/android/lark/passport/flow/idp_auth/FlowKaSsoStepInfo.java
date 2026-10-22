package com.ss.android.lark.passport.flow.idp_auth;

import com.alibaba.fastjson.annotation.JSONField;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b$\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0000\u0018\u0000 32\u00020\u0001:\u00013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR \u0010\u0013\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR \u0010\u0016\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR \u0010\u001c\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\r\"\u0004\b\u001e\u0010\u000fR \u0010\u001f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\r\"\u0004\b!\u0010\u000fR \u0010\"\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\r\"\u0004\b$\u0010\u000fR \u0010%\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\r\"\u0004\b'\u0010\u000fR\u001c\u0010(\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\r\"\u0004\b*\u0010\u000fR\u0011\u0010+\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b,\u0010\rR\u0013\u0010-\u001a\u0004\u0018\u00010\u000b8F¢\u0006\u0006\u001a\u0004\b.\u0010\rR\u0011\u0010/\u001a\u0002008F¢\u0006\u0006\u001a\u0004\b1\u00102¨\u00064"}, d2 = {"Lcom/ss/android/lark/passport/flow/idp_auth/FlowKaSsoStepInfo;", "Ljava/io/Serializable;", "<init>", "()V", "preConfig", "Lcom/ss/android/lark/passport/flow/idp_auth/FlowKaConfig;", "getPreConfig", "()Lcom/ss/android/lark/passport/flow/idp_auth/FlowKaConfig;", "setPreConfig", "(Lcom/ss/android/lark/passport/flow/idp_auth/FlowKaConfig;)V", "url", "", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "authUrl", "getAuthUrl", "setAuthUrl", "webUrl", "getWebUrl", "setWebUrl", "redirectUrl", "getRedirectUrl", "setRedirectUrl", "uri", "getUri", "setUri", "landUrl", "getLandUrl", "setLandUrl", "securityId", "getSecurityId", "setSecurityId", "openWith", "getOpenWith", "setOpenWith", "flowType", "getFlowType", "setFlowType", "channel", "getChannel", "setChannel", "userAgent", "getUserAgent", "primaryUrl", "getPrimaryUrl", "shouldOpenWithBrowser", "", "getShouldOpenWithBrowser", "()Z", "Companion", "flow-passport-mfa_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class FlowKaSsoStepInfo implements Serializable {
    public static final a Companion = null;

    @JSONField(name = "auth_url")
    private String authUrl;
    private String channel;

    @JSONField(name = "flow_type")
    private String flowType;

    @JSONField(name = "land_url")
    private String landUrl;

    @JSONField(name = "open_with")
    private String openWith;

    @JSONField(name = "pre_config")
    private FlowKaConfig preConfig;

    @JSONField(name = "redirect_url")
    private String redirectUrl;

    @JSONField(name = "security_id")
    private String securityId;
    private String uri;
    private String url;

    @JSONField(name = "web_url")
    private String webUrl;

    public static final class a {
        public a() {
        }
    }

    public FlowKaSsoStepInfo() {
    }

    static {
        Companion = new a();
    }

    public final String getPrimaryUrl() {
        a r0 = Companion;
        String[] r2 = {this.url, this.authUrl, this.webUrl, this.redirectUrl, this.uri};
        r0.getClass();
        int r1 = 0;
    L3:
        if (r1 >= 5) goto L15;
        String r3 = r2[r1];
        if (r3 != null) goto L7;
    L10:
        boolean r6 = true;
    L12:
        if ((!r6) == true) goto L19;
        r1 = r1 + 1;
        goto L3
    L19:
        return r3;
    L7:
        if (StringsKt.isBlank(r3) == true) goto L10;
        r6 = false;
        goto L12
    L15:
        return null;
    }

    public final boolean getShouldOpenWithBrowser() {
        if (StringsKt.equals(this.openWith, "browser", true) == false) goto L13;
        String r0 = this.landUrl;
        if (r0 != null) goto L7;
    L10:
        boolean r1 = true;
    L11:
        if (r1 == true) goto L13;
        return true;
    L7:
        if (StringsKt.isBlank(r0) == true) goto L10;
        r1 = false;
    L13:
        return false;
    }

    public final String getUserAgent() {
        FlowKaConfig r0 = this.preConfig;
        if (r0 == null) goto L7;
        FlowKaInternalData r1 = r0.getInternal();
        if (r1 == null) goto L7;
        String r2 = r1.getUserAgent();
    L8:
        if (r2 != null) goto L11;
        return "";
    L11:
        return r2;
    L7:
        r2 = null;
        goto L8
    }

    public final String getAuthUrl() {
        return this.authUrl;
    }

    public final String getChannel() {
        return this.channel;
    }

    public final String getFlowType() {
        return this.flowType;
    }

    public final String getLandUrl() {
        return this.landUrl;
    }

    public final String getOpenWith() {
        return this.openWith;
    }

    public final FlowKaConfig getPreConfig() {
        return this.preConfig;
    }

    public final String getRedirectUrl() {
        return this.redirectUrl;
    }

    public final String getSecurityId() {
        return this.securityId;
    }

    public final String getUri() {
        return this.uri;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getWebUrl() {
        return this.webUrl;
    }

    public final void setAuthUrl(String r1) {
        this.authUrl = r1;
    }

    public final void setChannel(String r1) {
        this.channel = r1;
    }

    public final void setFlowType(String r1) {
        this.flowType = r1;
    }

    public final void setLandUrl(String r1) {
        this.landUrl = r1;
    }

    public final void setOpenWith(String r1) {
        this.openWith = r1;
    }

    public final void setPreConfig(FlowKaConfig r1) {
        this.preConfig = r1;
    }

    public final void setRedirectUrl(String r1) {
        this.redirectUrl = r1;
    }

    public final void setSecurityId(String r1) {
        this.securityId = r1;
    }

    public final void setUri(String r1) {
        this.uri = r1;
    }

    public final void setUrl(String r1) {
        this.url = r1;
    }

    public final void setWebUrl(String r1) {
        this.webUrl = r1;
    }
}
