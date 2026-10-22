package com.ss.android.ugc.effectmanager.link.model.host;

import android.text.TextUtils;
import java.net.URI;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class Host {
    private String host;
    private String path;
    private int port;
    private String schema;
    private long sortTime;
    private long weightTime;

    public String getItemName() {
        String r0 = getSchema() + "://" + getHost();
        if (this.port == (-1)) goto L6;
        r0 = r0 + ":" + this.port;
    L6:
        if (TextUtils.isEmpty(this.path) == false) goto L8;
        return r0;
    L8:
        return r0 + this.path;
    }

    public long getSortTime() {
        return this.sortTime + this.weightTime;
    }

    public String toString() {
        return "Host{weightTime=" + this.weightTime + ", schema='" + this.schema + "', host='" + this.host + "'}";
    }

    public String getHost() {
        return this.host;
    }

    public int getPort() {
        return this.port;
    }

    public String getSchema() {
        return this.schema;
    }

    public long getWeightTime() {
        return this.weightTime;
    }

    public Host(String r2) {
        this.port = -1;
        URI r3 = URI.create(r2);
        this.host = r3.getHost();
        this.schema = r3.getScheme();
        this.port = r3.getPort();
        this.path = r3.getPath();
    }

    public boolean hostEquals(Host r4) {
        if (r4 != null) goto L6;
        return false;
    L6:
        if (r4.getHost().equals(getHost()) == true) goto L8;
        return false;
    L8:
        if (r4.getSchema().equals(getSchema()) == false) goto L12;
        return true;
    L12:
        return false;
    }

    public void setHost(String r1) {
        this.host = r1;
    }

    public void setPort(int r1) {
        this.port = r1;
    }

    public void setSchema(String r1) {
        this.schema = r1;
    }

    public void setSortTime(long r1) {
        this.sortTime = r1;
    }

    public void setWeightTime(long r1) {
        this.weightTime = r1;
    }

    public Host(URI r2) {
        this.port = -1;
        this.host = r2.getHost();
        this.schema = r2.getScheme();
        this.path = r2.getPath();
    }

    public Host(String r2, String r3) {
        this.port = -1;
        this.host = r2;
        this.schema = r3;
    }

    public Host(String r2, String r3, long r4) {
        this.port = -1;
        this.host = r2;
        this.schema = r3;
        this.weightTime = r4;
    }
}
