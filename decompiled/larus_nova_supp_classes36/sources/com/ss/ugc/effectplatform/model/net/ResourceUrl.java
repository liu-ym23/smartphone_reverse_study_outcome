package com.ss.ugc.effectplatform.model.net;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000f\b\u0017\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0096\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/ss/ugc/effectplatform/model/net/ResourceUrl;", "", "oid", "", "main_url", "backup_url", "url_expire", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "getBackup_url", "()Ljava/lang/String;", "setBackup_url", "(Ljava/lang/String;)V", "getMain_url", "setMain_url", "getOid", "setOid", "getUrl_expire", "()Ljava/lang/Long;", "setUrl_expire", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "effectplatform_release"}, k = 1, mv = {1, 1, 16})
public class ResourceUrl {
    private String backup_url;
    private String main_url;
    private String oid;
    private Long url_expire;

    public ResourceUrl() {
        this(null, null, null, null, 15, null);
    }

    public String getBackup_url() {
        return this.backup_url;
    }

    public String getMain_url() {
        return this.main_url;
    }

    public String getOid() {
        return this.oid;
    }

    public Long getUrl_expire() {
        return this.url_expire;
    }

    public void setBackup_url(String r1) {
        this.backup_url = r1;
    }

    public void setMain_url(String r1) {
        this.main_url = r1;
    }

    public void setOid(String r1) {
        this.oid = r1;
    }

    public void setUrl_expire(Long r1) {
        this.url_expire = r1;
    }

    public ResourceUrl(String r1, String r2, String r3, Long r4) {
        this.oid = r1;
        this.main_url = r2;
        this.backup_url = r3;
        this.url_expire = r4;
    }

    public /* synthetic */ ResourceUrl(String r2, String r3, String r4, Long r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = null;
    L14:
        this(r2, r3, r4, r5);
    }
}
