package com.ss.android.lark.passport.signinsdk_api.entity;

import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public class Tenant implements Serializable {
    private static final long serialVersionUID = -92609727225209513L;
    private String address;
    private String contactEmail;
    private String contactMobile;
    private String contactName;
    private String domain;
    private String iconUrl;
    private String id;
    private String name;
    private String postCode;
    private String remark;
    private String suiteFullDomain;
    private String telephone;
    private String unitLeague;

    public Tenant() {
    }

    public String getSuiteFullDomain() {
        String r0 = this.suiteFullDomain;
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    public String getAddress() {
        return this.address;
    }

    public String getContactEmail() {
        return this.contactEmail;
    }

    public String getContactMobile() {
        return this.contactMobile;
    }

    public String getContactName() {
        return this.contactName;
    }

    public String getDomain() {
        return this.domain;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getPostCode() {
        return this.postCode;
    }

    public String getRemark() {
        return this.remark;
    }

    public String getTelephone() {
        return this.telephone;
    }

    public String getUnitLeague() {
        return this.unitLeague;
    }

    public void setAddress(String r1) {
        this.address = r1;
    }

    public void setContactEmail(String r1) {
        this.contactEmail = r1;
    }

    public void setContactMobile(String r1) {
        this.contactMobile = r1;
    }

    public void setContactName(String r1) {
        this.contactName = r1;
    }

    public void setDomain(String r1) {
        this.domain = r1;
    }

    public void setIconUrl(String r1) {
        this.iconUrl = r1;
    }

    public void setId(String r1) {
        this.id = r1;
    }

    public void setName(String r1) {
        this.name = r1;
    }

    public void setPostCode(String r1) {
        this.postCode = r1;
    }

    public void setRemark(String r1) {
        this.remark = r1;
    }

    public void setSuiteFullDomain(String r1) {
        this.suiteFullDomain = r1;
    }

    public void setTelephone(String r1) {
        this.telephone = r1;
    }

    public void setUnitLeague(String r1) {
        this.unitLeague = r1;
    }
}
