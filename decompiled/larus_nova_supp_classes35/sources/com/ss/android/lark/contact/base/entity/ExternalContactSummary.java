package com.ss.android.lark.contact.base.entity;

import com.bytedance.lark.pb.basic.v1.TenantNameStatus;
import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class ExternalContactSummary implements Serializable {
    private String avatarKey;
    private String departmentName;
    private String i18nName;
    private String tenantName;
    private TenantNameStatus tenantNameStatus;
    private String useId;
    private String userEnName;
    private String userName;

    public ExternalContactSummary() {
    }

    public String getAvatarKey() {
        return this.avatarKey;
    }

    public String getDepartmentName() {
        return this.departmentName;
    }

    public String getI18nName() {
        return this.i18nName;
    }

    public String getTenantName() {
        return this.tenantName;
    }

    public TenantNameStatus getTenantNameStatus() {
        return this.tenantNameStatus;
    }

    public String getUseId() {
        return this.useId;
    }

    public String getUserEnName() {
        return this.userEnName;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setAvatarKey(String r1) {
        this.avatarKey = r1;
    }

    public void setDepartmentName(String r1) {
        this.departmentName = r1;
    }

    public void setI18nName(String r1) {
        this.i18nName = r1;
    }

    public void setTenantName(String r1) {
        this.tenantName = r1;
    }

    public void setTenantNameStatus(TenantNameStatus r1) {
        this.tenantNameStatus = r1;
    }

    public void setUseId(String r1) {
        this.useId = r1;
    }

    public void setUserEnName(String r1) {
        this.userEnName = r1;
    }

    public void setUserName(String r1) {
        this.userName = r1;
    }
}
