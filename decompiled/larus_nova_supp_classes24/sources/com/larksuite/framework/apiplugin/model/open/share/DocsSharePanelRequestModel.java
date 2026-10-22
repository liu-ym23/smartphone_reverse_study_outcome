package com.larksuite.framework.apiplugin.model.open.share;

import com.alibaba.fastjson.annotation.JSONField;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.framework.apiplugin.annotation.LKRequiredParam;
import com.larksuite.framework.apiplugin.common.LKBaseRequestModel;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\tR\"\u0010\u0014\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u0014\u0010\u0016\"\u0004\b\u0017\u0010\u0018R \u0010\u001a\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0007\"\u0004\b\u001c\u0010\tR\"\u0010\u001d\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u0018¨\u0006\u001f"}, d2 = {"Lcom/larksuite/framework/apiplugin/model/open/share/DocsSharePanelRequestModel;", "Lcom/larksuite/framework/apiplugin/common/LKBaseRequestModel;", "<init>", "()V", "token", "", "getToken", "()Ljava/lang/String;", "setToken", "(Ljava/lang/String;)V", "type", "", "getType", "()Ljava/lang/Integer;", "setType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "shareUrl", "getShareUrl", "setShareUrl", "isOwner", "", "()Ljava/lang/Boolean;", "setOwner", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "title", "getTitle", "setTitle", "isWiki", "setWiki", "open-plugin-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class DocsSharePanelRequestModel extends LKBaseRequestModel {

    @JSONField(name = "isOwner")
    private Boolean isOwner;

    @JSONField(name = "isWiki")
    private Boolean isWiki;

    @JSONField(name = "shareUrl")
    private String shareUrl;

    @JSONField(name = "title")
    private String title;

    @JSONField(name = "token")
    @LKRequiredParam
    private String token;

    @JSONField(name = "type")
    @LKRequiredParam
    private Integer type;

    public DocsSharePanelRequestModel() {
    }

    public final String getShareUrl() {
        return this.shareUrl;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getToken() {
        return this.token;
    }

    public final Integer getType() {
        return this.type;
    }

    public final Boolean isOwner() {
        return this.isOwner;
    }

    public final Boolean isWiki() {
        return this.isWiki;
    }

    public final void setOwner(Boolean r1) {
        this.isOwner = r1;
    }

    public final void setShareUrl(String r1) {
        this.shareUrl = r1;
    }

    public final void setTitle(String r1) {
        this.title = r1;
    }

    public final void setToken(String r1) {
        this.token = r1;
    }

    public final void setType(Integer r1) {
        this.type = r1;
    }

    public final void setWiki(Boolean r1) {
        this.isWiki = r1;
    }
}
