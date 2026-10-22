package com.ss.android.lark.passport.signinsdk_api.entity;

import com.alibaba.fastjson.annotation.JSONField;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public class AuthInfo implements Serializable {

    @JSONField(name = "app_icon")
    public String appIcon;

    @JSONField(name = "app_name")
    public String appName;
    public String button;
    public List<ButtonInfo> buttonList;

    @JSONField(name = "i18n_agreement")
    public I18NAgreement i18NAgreement;

    @JSONField(name = "identity_title")
    public String identityTitle;

    @JSONField(name = "permission_scopes")
    public List<PermissionScope> permissionScopes;

    @JSONField(name = "scope_title")
    public String scopeTitle;

    @JSONField(name = "show_auth_management")
    public boolean showAuthManagement;

    @JSONField(name = "subtitle")
    public String subTitle;

    public AuthInfo() {
        this.showAuthManagement = false;
    }
}
