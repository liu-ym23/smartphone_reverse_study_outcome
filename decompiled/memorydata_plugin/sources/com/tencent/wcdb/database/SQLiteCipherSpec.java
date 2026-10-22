package com.tencent.wcdb.database;

/* JADX INFO: loaded from: classes6.dex */
public class SQLiteCipherSpec {
    public static final int HMAC_DEFAULT = -1;
    public static final int HMAC_SHA1 = 0;
    public static final int HMAC_SHA256 = 1;
    public static final int HMAC_SHA512 = 2;
    public int hmacAlgorithm;
    public boolean hmacEnabled;
    public int kdfAlgorithm;
    public int kdfIteration;
    public int pageSize;

    public SQLiteCipherSpec() {
        this.hmacEnabled = true;
        this.hmacAlgorithm = -1;
        this.kdfAlgorithm = -1;
        this.pageSize = SQLiteGlobal.f15849a;
    }

    public SQLiteCipherSpec(SQLiteCipherSpec r2) {
        this.hmacEnabled = true;
        this.hmacAlgorithm = -1;
        this.kdfAlgorithm = -1;
        this.pageSize = SQLiteGlobal.f15849a;
        this.kdfIteration = r2.kdfIteration;
        this.hmacEnabled = r2.hmacEnabled;
        this.pageSize = r2.pageSize;
    }

    public SQLiteCipherSpec a(int r1) {
        this.kdfIteration = r1;
        return this;
    }

    public SQLiteCipherSpec a(boolean r1) {
        this.hmacEnabled = r1;
        return this;
    }

    public SQLiteCipherSpec b(int r1) {
        this.hmacAlgorithm = r1;
        return this;
    }

    public SQLiteCipherSpec c(int r1) {
        this.kdfAlgorithm = r1;
        return this;
    }

    public SQLiteCipherSpec d(int r1) {
        this.pageSize = r1;
        return this;
    }
}
