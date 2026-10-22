package com.ss.android.lark.passport.signinsdk_api.country;

import com.alibaba.fastjson.annotation.JSONField;
import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public class CountryBean implements Serializable {
    private String code;

    @JSONField(name = "full_pinyin")
    private String fullPinyin;

    @JSONField(name = "head_index")
    private String headIndex;

    @JSONField(name = "head_pinyin")
    private String headPinyin;
    private String key;
    private String name;
    private String pattern;

    @JSONField(name = "roma_word")
    private String romaWord;

    public CountryBean() {
    }

    public String getCode() {
        return this.code;
    }

    public String getFullPinyin() {
        return this.fullPinyin;
    }

    public String getHeadIndex() {
        return this.headIndex;
    }

    public String getHeadPinyin() {
        return this.headPinyin;
    }

    public String getKey() {
        return this.key;
    }

    public String getName() {
        return this.name;
    }

    public String getPattern() {
        return this.pattern;
    }

    public String getRomaWord() {
        return this.romaWord;
    }

    public CountryBean(CountryBean r2) {
        this.key = r2.key;
        this.name = r2.name;
        this.code = r2.code;
        this.fullPinyin = r2.fullPinyin;
        this.headPinyin = r2.headPinyin;
        this.headIndex = r2.headIndex;
        this.romaWord = r2.romaWord;
        this.pattern = r2.pattern;
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L5;
        return true;
    L5:
        if (r3 != null) goto L7;
        return false;
    L7:
        if (getClass() == r3.getClass()) goto L10;
        return false;
    L10:
        return Objects.equals(this.key, ((CountryBean) r3).key);
    }

    public void setCode(String r1) {
        this.code = r1;
    }

    public void setFullPinyin(String r1) {
        this.fullPinyin = r1;
    }

    public void setHeadIndex(String r1) {
        this.headIndex = r1;
    }

    public void setHeadPinyin(String r1) {
        this.headPinyin = r1;
    }

    public void setKey(String r1) {
        this.key = r1;
    }

    public void setName(String r1) {
        this.name = r1;
    }

    public void setPattern(String r1) {
        this.pattern = r1;
    }

    public void setRomaWord(String r1) {
        this.romaWord = r1;
    }
}
