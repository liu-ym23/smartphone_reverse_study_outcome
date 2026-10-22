package com.ss.android.lark.contact.base.entity;

import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class ExternalContact implements Serializable {
    private static final long serialVersionUID = -1576990577080993273L;
    private String chatterId;
    private String id;
    private boolean isDeleted;

    public ExternalContact() {
    }

    public String getChatterId() {
        return this.chatterId;
    }

    public String getId() {
        return this.id;
    }

    public boolean isDeleted() {
        return this.isDeleted;
    }

    public void setChatterId(String r1) {
        this.chatterId = r1;
    }

    public void setDeleted(boolean r1) {
        this.isDeleted = r1;
    }

    public void setId(String r1) {
        this.id = r1;
    }
}
