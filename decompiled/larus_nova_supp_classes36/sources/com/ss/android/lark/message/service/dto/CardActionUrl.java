package com.ss.android.lark.message.service.dto;

import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class CardActionUrl implements Serializable {
    private static final long serialVersionUID = 2530852242548850205L;
    private String android_url;
    private String url;

    public CardActionUrl() {
    }

    public int hashCode() {
        String r0 = this.url;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.android_url;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public String getAndroid_url() {
        return this.android_url;
    }

    public String getUrl() {
        return this.url;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L25:
        return false;
    L8:
        if (getClass() != r5.getClass()) goto L25;
        CardActionUrl r6 = (CardActionUrl) r5;
        String r2 = this.url;
        if (r2 == null) goto L16;
        if (r2.equals(r6.url) == false) goto L17;
    L18:
        String r3 = this.android_url;
        String r7 = r6.android_url;
        if (r3 != null) goto L26;
        if (r7 == null) goto L27;
        return false;
    L27:
        return true;
    L26:
        return r3.equals(r7);
    L17:
        return false;
    L16:
        if (r6.url == null) goto L18;
        goto L17
    }

    public void setAndroid_url(String r1) {
        this.android_url = r1;
    }

    public void setUrl(String r1) {
        this.url = r1;
    }
}
