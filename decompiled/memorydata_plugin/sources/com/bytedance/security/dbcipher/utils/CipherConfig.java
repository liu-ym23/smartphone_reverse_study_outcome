package com.bytedance.security.dbcipher.utils;

import com.google.gson.Gson;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class CipherConfig {
    private static final int DEFAULT_KDF_ITERATIONS = 10000;
    private static final int DEFAULT_PAGE_SIZE = 4096;
    private String hmacAlgorithm;
    private boolean isPlaintext;
    private String kdfAlgorithm;
    private int kdfIterations;
    private String logLevel;
    private int pageSize;

    public CipherConfig() {
        this(false, CipherConst.PBKDF2_HMAC_SHA256, 10000, CipherConst.HMAC_SHA256, 4096, "NONE");
    }

    public CipherConfig(boolean r1, String r2, int r3, String r4, int r5, String r6) {
        this.isPlaintext = r1;
        this.kdfAlgorithm = r2;
        this.kdfIterations = r3;
        this.hmacAlgorithm = r4;
        this.pageSize = r5;
        this.logLevel = r6;
    }

    public static CipherConfig fromJson(String r2) {
        return (CipherConfig) ZeusTransformUtils.preCheckCast(new Gson().fromJson(r2, CipherConfig.class), CipherConfig.class, "com.obric.memorydata.plugin");
    }

    public String getHmacAlgorithm() {
        return this.hmacAlgorithm;
    }

    public String getKdfAlgorithm() {
        return this.kdfAlgorithm;
    }

    public int getKdfIterations() {
        return this.kdfIterations;
    }

    public String getLogLevel() {
        return this.logLevel;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public boolean isPlaintext() {
        return this.isPlaintext;
    }

    public void setHmacAlgorithm(String r1) {
        this.hmacAlgorithm = r1;
    }

    public void setKdfAlgorithm(String r1) {
        this.kdfAlgorithm = r1;
    }

    public void setKdfIterations(int r1) {
        this.kdfIterations = r1;
    }

    public void setLogLevel(String r1) {
        this.logLevel = r1;
    }

    public void setPageSize(int r1) {
        this.pageSize = r1;
    }

    public void setPlaintext(boolean r1) {
        this.isPlaintext = r1;
    }

    public String toJsonString() {
        return new Gson().toJson(this);
    }
}
