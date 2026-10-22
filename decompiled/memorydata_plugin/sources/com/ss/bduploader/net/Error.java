package com.ss.bduploader.net;

/* JADX INFO: loaded from: classes6.dex */
public class Error {
    int code;
    public String errStr;
    public String host;
    public String id;

    public Error(int r1, String r2, String r3) {
        this.code = r1;
        this.host = r2;
        this.id = r3;
        this.errStr = null;
    }

    public Error(int r1, String r2, String r3, String r4) {
        this.code = r1;
        this.host = r2;
        this.id = r3;
        this.errStr = r4;
    }
}
