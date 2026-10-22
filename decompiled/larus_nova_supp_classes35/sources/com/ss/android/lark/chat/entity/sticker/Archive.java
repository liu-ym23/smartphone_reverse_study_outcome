package com.ss.android.lark.chat.entity.sticker;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class Archive implements Serializable {
    private String mCheckSum;
    private String mKey;
    private String mMime;
    private Map<String, String> mParams;
    private long mSize;
    private List<String> mUrls;

    public Archive() {
    }

    public String getCheckSum() {
        return this.mCheckSum;
    }

    public String getKey() {
        return this.mKey;
    }

    public String getMime() {
        return this.mMime;
    }

    public Map<String, String> getParams() {
        return this.mParams;
    }

    public long getSize() {
        return this.mSize;
    }

    public List<String> getUrls() {
        return this.mUrls;
    }

    public void setCheckSum(String r1) {
        this.mCheckSum = r1;
    }

    public void setKey(String r1) {
        this.mKey = r1;
    }

    public void setMime(String r1) {
        this.mMime = r1;
    }

    public void setParams(Map<String, String> r1) {
        this.mParams = r1;
    }

    public void setSize(long r1) {
        this.mSize = r1;
    }

    public void setUrls(List<String> r1) {
        this.mUrls = r1;
    }
}
