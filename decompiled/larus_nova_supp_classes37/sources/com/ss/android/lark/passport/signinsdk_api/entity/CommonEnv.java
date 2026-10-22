package com.ss.android.lark.passport.signinsdk_api.entity;

import java.io.Serializable;
import java.util.Locale;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public class CommonEnv implements Serializable {
    private boolean isOverSea;
    private LanguageEnv languageEnv;

    public static class LanguageEnv implements Serializable {
        private a languageChangeListener;
        private Locale locale;

        public a getLanguageChangeListener() {
            return null;
        }

        public Locale getLocale() {
            return this.locale;
        }

        public LanguageEnv(Locale r1, a r2) {
            this.locale = r1;
        }
    }

    public interface a {
    }

    public LanguageEnv getLanguageEnv() {
        return this.languageEnv;
    }

    public boolean isOverSea() {
        return this.isOverSea;
    }

    public CommonEnv(LanguageEnv r1) {
        this.languageEnv = r1;
    }

    public void setOverSea(boolean r1) {
        this.isOverSea = r1;
    }
}
