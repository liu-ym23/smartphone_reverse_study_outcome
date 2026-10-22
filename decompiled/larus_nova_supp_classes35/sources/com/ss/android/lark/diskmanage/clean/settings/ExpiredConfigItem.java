package com.ss.android.lark.diskmanage.clean.settings;

import com.ss.android.lark.diskmanage.NonProguard;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class ExpiredConfigItem implements NonProguard {
    long expiredTime;
    private List<String> files;

    public String toString() {
        return "ExpiredConfigItem{files=" + this.files + ", expiredTime=" + this.expiredTime + '}';
    }

    public ExpiredConfigItem() {
        this.files = new ArrayList();
        this.expiredTime = -1;
    }

    public long getExpiredTime() {
        return this.expiredTime;
    }

    public List<String> getFiles() {
        return this.files;
    }

    public void setExpiredTime(long r1) {
        this.expiredTime = r1;
    }

    public void setFiles(List<String> r1) {
        this.files = r1;
    }
}
