package com.monitor.cloudmessage.f.b;

import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public class b {
    protected long h;
    protected boolean i;
    protected String j;
    protected int k;
    protected String l;
    protected long m;
    protected HashMap<String, String> n;

    public b(long r3, boolean r5, String r6, HashMap<String, String> r7) {
        this.k = 2;
        this.l = "no error";
        this.m = 0;
        this.n = null;
        this.h = r3;
        this.i = r5;
        this.j = r6;
        this.m = System.currentTimeMillis();
        this.n = r7;
    }

    public void a(int r1) {
        this.k = r1;
    }

    public void a(String r1) {
        this.l = r1;
    }

    public long i() {
        return this.h;
    }

    public boolean j() {
        return this.i;
    }

    public String k() {
        return this.j;
    }

    public int l() {
        return this.k;
    }

    public String m() {
        return this.l;
    }

    public long n() {
        return this.m;
    }

    public HashMap<String, String> o() {
        return this.n;
    }

    public String toString() {
        return "UploadInfo{lastUploadTime=" + this.h + ", isUploading=" + this.i + ", commandId='" + this.j + "', cloudMsgResponseCode=" + this.k + ", errorMsg='" + this.l + "', operateTime=" + this.m + ", specificParams=" + this.n + '}';
    }
}
