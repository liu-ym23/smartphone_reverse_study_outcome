package com.ss.android.lark.chat.entity.translate;

import android.text.TextUtils;
import com.bytedance.lark.pb.im.v1.LanguagesConfiguration;
import com.bytedance.lark.pb.im.v1.SrcLanguageConfig;
import com.bytedance.lark.pb.im.v1.TranslateScopeMask;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class TranslateLanguageSetting implements Serializable {
    private Set<String> disAutoTranslateKeySet;
    private Map<String, Integer> displayConfigMap;
    private int globalAutoTranslateScope;
    private int globalAutoTranslateVisibleScope;
    private int globalDisplayConfig;
    private List<LanguageInfo> supportedLanguageList;
    private String targetLanguageKey;

    public String getTargetLanguageDisplayName() {
        List<LanguageInfo> r0 = this.supportedLanguageList;
        if (r0 != null) goto L5;
        return BuildConfig.FLAVOR;
    L5:
        if (this.targetLanguageKey == null) goto L18;
        Iterator<LanguageInfo> r1 = r0.iterator();
    L8:
        if (r1.hasNext() == false) goto L19;
        LanguageInfo r2 = r1.next();
        if (TextUtils.equals(this.targetLanguageKey, r2.getKey()) == false) goto L8;
        return r2.getCurLanguageDisplayName();
    L19:
        return BuildConfig.FLAVOR;
    L18:
        return BuildConfig.FLAVOR;
    }

    public String getTargetLanguageName() {
        List<LanguageInfo> r0 = this.supportedLanguageList;
        if (r0 != null) goto L5;
        return BuildConfig.FLAVOR;
    L5:
        if (this.targetLanguageKey == null) goto L18;
        Iterator<LanguageInfo> r1 = r0.iterator();
    L8:
        if (r1.hasNext() == false) goto L19;
        LanguageInfo r2 = r1.next();
        if (this.targetLanguageKey.equals(r2.getKey()) == false) goto L8;
        return r2.getDisplayName();
    L19:
        return BuildConfig.FLAVOR;
    L18:
        return BuildConfig.FLAVOR;
    }

    public boolean isDocAutoTranslate() {
        if ((this.globalAutoTranslateScope & TranslateScopeMask.DOC_MASK.getValue()) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isGlobalAutoTranslate() {
        if ((this.globalAutoTranslateScope & TranslateScopeMask.LARK_MESSAGE_MASK.getValue()) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public Set<String> getDisAutoTranslateKeySet() {
        return this.disAutoTranslateKeySet;
    }

    public Map<String, Integer> getDisplayConfigMap() {
        return this.displayConfigMap;
    }

    public int getGlobalAutoTranslateScope() {
        return this.globalAutoTranslateScope;
    }

    public int getGlobalAutoTranslateVisibleScope() {
        return this.globalAutoTranslateVisibleScope;
    }

    public int getGlobalDisplayConfig() {
        return this.globalDisplayConfig;
    }

    public List<LanguageInfo> getSupportedLanguageList() {
        return this.supportedLanguageList;
    }

    public String getTargetLanguageKey() {
        return this.targetLanguageKey;
    }

    public int getDisplayRule(String r3) {
        Integer r0 = 0;
        Map<String, Integer> r1 = this.displayConfigMap;
        if (r1 == null) goto L5;
        r0 = r1.get(r3);
    L5:
        if (r0 != null) goto L7;
    L8:
        r0 = Integer.valueOf(this.globalDisplayConfig);
    L10:
        return r0.intValue();
    L7:
        if (r0.intValue() != 0) goto L10;
        goto L8
    }

    public boolean needTranslate(String r2) {
        if (TextUtils.equals(r2, "not_lang") == false) goto L5;
    L9:
        return false;
    L5:
        if (TextUtils.equals(r2, getTargetLanguageKey()) == true) goto L9;
        if (getDisAutoTranslateKeySet().contains(r2) == true) goto L9;
        return true;
    }

    public void setDisAutoTranslateKeySet(Set<String> r1) {
        this.disAutoTranslateKeySet = r1;
    }

    public void setDisplayConfigMap(Map<String, Integer> r1) {
        this.displayConfigMap = r1;
    }

    public void setGlobalAutoTranslateScope(int r1) {
        this.globalAutoTranslateScope = r1;
    }

    public void setGlobalAutoTranslateVisibleScope(int r1) {
        this.globalAutoTranslateVisibleScope = r1;
    }

    public void setGlobalDisplayConfig(int r1) {
        this.globalDisplayConfig = r1;
    }

    public void setSupportedLanguageList(List<LanguageInfo> r1) {
        this.supportedLanguageList = r1;
    }

    public void setTargetLanguageKey(String r1) {
        this.targetLanguageKey = r1;
    }

    public TranslateLanguageSetting(LanguagesConfiguration r1, Map<String, LanguagesConfiguration> r2) {
        setDisplayRule(r1, r2);
    }

    public void setDisplayRule(LanguagesConfiguration r3, Map<String, LanguagesConfiguration> r4) {
        if (r3 == null) goto L4;
        int r5 = r3.rule.getValue();
    L5:
        this.globalDisplayConfig = r5;
        this.displayConfigMap = new HashMap();
        Iterator<Map.Entry<String, LanguagesConfiguration>> r6 = r4.entrySet().iterator();
    L7:
        if (r6.hasNext() == false) goto L9;
        Map.Entry<String, LanguagesConfiguration> r7 = r6.next();
        this.displayConfigMap.put(r7.getKey(), Integer.valueOf(r7.getValue().rule.getValue()));
        goto L7
    L9:
        return;
    L4:
        r5 = 0;
        goto L5
    }

    public TranslateLanguageSetting(String r2, List<String> r3, Map<String, String> r4) {
        this(r2, r3, r4, new HashMap());
    }

    public TranslateLanguageSetting(String r3, List<String> r4, Map<String, String> r5, Map<String, SrcLanguageConfig> r6) {
        this.targetLanguageKey = r3;
        if (r4 == null) goto L11;
        if (r5 == null) goto L17;
        this.supportedLanguageList = new ArrayList();
        Iterator<String> r7 = r4.iterator();
    L7:
        if (r7.hasNext() == false) goto L18;
        String r8 = r7.next();
        if (r5.containsKey(r8) == false) goto L7;
        LanguageInfo r0 = new LanguageInfo(r8, r5.get(r8));
        r0.setCurLanguageDisplayName(r6);
        this.supportedLanguageList.add(r0);
        goto L7
    L18:
        return;
    L17:
        return;
    }

    public TranslateLanguageSetting(Map<Integer, Boolean> r2, String r3, List<String> r4, Map<String, String> r5, List<String> r6, LanguagesConfiguration r7, Map<String, LanguagesConfiguration> r8, Map<String, SrcLanguageConfig> r9) {
        this(r3, r4, r5, r9);
        int r10 = 0;
        if (r2 == null) goto L10;
        Iterator<Map.Entry<Integer, Boolean>> r11 = r2.entrySet().iterator();
        int r12 = 0;
    L6:
        if (r11.hasNext() == false) goto L11;
        Map.Entry<Integer, Boolean> r13 = r11.next();
        if (r13.getValue().booleanValue() == false) goto L6;
        r12 = r12 | r13.getKey().intValue();
    L11:
        this.globalAutoTranslateScope = r12;
        if (r2 == null) goto L17;
        Iterator<Map.Entry<Integer, Boolean>> r14 = r2.entrySet().iterator();
    L15:
        if (r14.hasNext() == false) goto L17;
        r10 = r10 | r14.next().getKey().intValue();
    L17:
        this.globalAutoTranslateVisibleScope = r10;
        this.disAutoTranslateKeySet = new HashSet(r6);
        setDisplayRule(r7, r8);
        return;
    L10:
        r12 = 0;
        goto L11
    }
}
