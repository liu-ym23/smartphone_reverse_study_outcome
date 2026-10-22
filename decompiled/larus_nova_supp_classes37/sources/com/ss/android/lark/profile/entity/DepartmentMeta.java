package com.ss.android.lark.profile.entity;

import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public class DepartmentMeta implements Serializable {
    private static final long serialVersionUID = 5756135315854813874L;
    private String mId;
    private String mName;

    public DepartmentMeta() {
        this.mId = "";
        this.mName = "";
    }

    public String getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public void setId(String r1) {
        this.mId = r1;
    }

    public void setName(String r1) {
        this.mName = r1;
    }

    public DepartmentMeta(String r1, String r2) {
        this.mId = r1;
        this.mName = r2;
    }
}
