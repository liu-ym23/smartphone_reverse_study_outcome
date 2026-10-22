package com.ss.android.lark.profile.entity;

import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public class Position implements Serializable {
    private static final long serialVersionUID = 7031608951635821547L;
    private String mName;

    public Position() {
        this.mName = "";
    }

    public String getName() {
        return this.mName;
    }

    public Position(String r1) {
        this.mName = r1;
    }

    public void setName(String r1) {
        this.mName = r1;
    }
}
