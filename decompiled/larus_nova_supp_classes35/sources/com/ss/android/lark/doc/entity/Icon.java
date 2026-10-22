package com.ss.android.lark.doc.entity;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class Icon implements Serializable {
    private int type;
    private String value;

    public Icon() {
        this.type = 0;
        this.value = BuildConfig.FLAVOR;
    }

    public int getType() {
        return this.type;
    }

    public String getValue() {
        return this.value;
    }

    public void setType(int r1) {
        this.type = r1;
    }

    public void setValue(String r1) {
        this.value = r1;
    }
}
