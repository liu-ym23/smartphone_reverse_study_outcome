package com.ss.android.lark.passport.flow.auth_type;

import com.alibaba.fastjson.annotation.JSONField;
import com.ss.android.lark.passport.flow.core.model.ButtonInfo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public class AuthTypeStepInfo implements Serializable {

    @JSONField(name = "auth_type_list")
    public ArrayList<ButtonInfo> authTypeList;

    @JSONField(name = "bottom_button")
    public ButtonInfo bottomButton;

    @JSONField(name = "subtitle")
    public String subTitle;

    @JSONField(name = "target_tenant_icon")
    public String targetTenantIcon;
    public String title;

    public AuthTypeStepInfo() {
    }

    public ButtonInfo getBottomButton() {
        return this.bottomButton;
    }

    public String getSubTitle() {
        return this.subTitle;
    }

    public String getTitle() {
        return this.title;
    }

    public List<ButtonInfo> getTypeList() {
        return this.authTypeList;
    }

    public void setBottomButton(ButtonInfo r1) {
        this.bottomButton = r1;
    }

    public void setSubTitle(String r1) {
        this.subTitle = r1;
    }

    public void setTitle(String r1) {
        this.title = r1;
    }

    public void setTypeList(ArrayList<ButtonInfo> r1) {
        this.authTypeList = r1;
    }
}
