package com.ss.android.lark.profile.entity;

import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public class OrgUnit implements Serializable {
    private static final long serialVersionUID = 3281645349962246767L;
    private String mName;

    public OrgUnit() {
        this.mName = "";
    }

    public String getName() {
        return this.mName;
    }

    public OrgUnit(String r1) {
        this.mName = r1;
    }

    public void setName(String r1) {
        this.mName = r1;
    }
}
