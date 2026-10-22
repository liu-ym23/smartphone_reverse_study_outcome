package com.ss.android.lark.larkconfig.userconfig.api;

import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class ExternalSearchConfig implements Serializable {
    private String iconUrl;
    private String id;
    private String title;

    public String getIconUrl() {
        return this.iconUrl;
    }

    public String getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public ExternalSearchConfig(String r1, String r2, String r3) {
        this.id = r1;
        this.title = r2;
        this.iconUrl = r3;
    }
}
