package com.zte.miboard.cards.express.data;

import ai.j0;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class ExpressRequestBean {
    int limit;
    boolean logoAndStatus;
    int newSF;
    int newSFFirst;
    List<String> phones;
    String pid;
    String version;

    public ExpressRequestBean(List<String> r5, boolean r10, String r11, boolean r12) {
        this.logoAndStatus = true;
        this.newSF = 1;
        this.newSFFirst = r10 ? 1 : 0;
        this.phones = r5;
        this.pid = r11;
        if (r12 == false) goto L6;
        this.limit = 2;
        return;
    }

    public List<String> getPhones() {
        return this.phones;
    }

    public String getVersion() {
        return this.version;
    }

    public void setPhones(List<String> r5) {
        this.phones = r5;
    }

    public void setVersion(String r5) {
        this.version = r5;
    }

    public String toString() {
        StringBuilder r5 = new StringBuilder("ExpressRequestBean{version='");
        r5.append(this.version);
        r5.append("', phones=phones, limit=");
        return j0.n(r5, this.limit, '}');
    }
}
