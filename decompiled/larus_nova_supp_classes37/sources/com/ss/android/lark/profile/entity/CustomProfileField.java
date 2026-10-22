package com.ss.android.lark.profile.entity;

import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public class CustomProfileField implements Serializable {
    private static final long serialVersionUID = 849543819999452231L;
    private String herf;
    private boolean isUrl;
    private String key;
    private String name;
    private String value;

    public CustomProfileField() {
        this.key = "";
        this.name = "";
        this.value = "";
        this.herf = "";
    }

    public String getHerf() {
        return this.herf;
    }

    public String getKey() {
        return this.key;
    }

    public String getName() {
        return this.name;
    }

    public String getValue() {
        return this.value;
    }

    public boolean isUrl() {
        return this.isUrl;
    }

    public void setHerf(String r1) {
        this.herf = r1;
    }

    public void setKey(String r1) {
        this.key = r1;
    }

    public void setName(String r1) {
        this.name = r1;
    }

    public void setUrl(boolean r1) {
        this.isUrl = r1;
    }

    public void setValue(String r1) {
        this.value = r1;
    }

    public CustomProfileField(String r1, String r2, String r3) {
        this.key = r1;
        this.value = r2;
        this.herf = r3;
    }
}
