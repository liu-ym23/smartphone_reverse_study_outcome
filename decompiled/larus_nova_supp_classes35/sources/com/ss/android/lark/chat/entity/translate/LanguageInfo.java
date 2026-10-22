package com.ss.android.lark.chat.entity.translate;

import android.text.TextUtils;
import com.bytedance.lark.pb.im.v1.SrcLanguageConfig;
import com.ss.android.lark.utils.LarkContext;
import java.io.Serializable;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class LanguageInfo implements Serializable {
    private String curLanguageDisplayName;
    private String displayName;
    private String key;

    public int hashCode() {
        return Objects.hash(new Object[]{this.key, this.displayName, this.curLanguageDisplayName});
    }

    public String getCurLanguageDisplayName() {
        if (TextUtils.isEmpty(this.curLanguageDisplayName) == false) goto L7;
        return this.displayName;
    L7:
        return this.curLanguageDisplayName;
    }

    public String toString() {
        return "LanguageInfo { " + this.key + " , " + this.displayName + " , " + this.curLanguageDisplayName + " }";
    }

    private LanguageInfo() {
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public String getKey() {
        return this.key;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L19:
        return false;
    L8:
        if (getClass() != r5.getClass()) goto L19;
        LanguageInfo r6 = (LanguageInfo) r5;
        if (Objects.equals(this.key, r6.key) == true) goto L13;
    L17:
        return false;
    L13:
        if (Objects.equals(this.displayName, r6.displayName) == false) goto L17;
        if (Objects.equals(this.curLanguageDisplayName, r6.curLanguageDisplayName) == false) goto L17;
        return true;
    }

    public void setCurLanguageDisplayName(Map<String, SrcLanguageConfig> r4) {
        SrcLanguageConfig r5 = r4.get(this.key);
        if (r5 == null) goto L6;
        Locale r0 = LarkContext.getApplication().getApplicationContext().getResources().getConfiguration().locale;
        this.curLanguageDisplayName = (String) r5.i18n_language.get((r0.getLanguage() + "_" + r0.getCountry()).toLowerCase());
        return;
    }

    public LanguageInfo(String r1, String r2) {
        this.key = r1;
        this.displayName = r2;
    }
}
