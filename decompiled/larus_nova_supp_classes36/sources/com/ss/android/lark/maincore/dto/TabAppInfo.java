package com.ss.android.lark.maincore.dto;

import android.text.TextUtils;
import com.alibaba.fastjson.annotation.JSONField;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class TabAppInfo {
    private String appType;
    private Extra extra;

    @JSONField(name = "ID")
    private String id;
    private String key;
    private Logo logo;
    private Name name;
    private boolean primaryOnly;
    private boolean unmovable;

    public static class Extra {

        @JSONField(name = "app_id")
        private String appID;

        @JSONField(name = "mobile_url")
        private String url;

        public Extra() {
        }

        public String getAppID() {
            return this.appID;
        }

        public String getUrl() {
            return this.url;
        }

        public void setAppID(String r1) {
            this.appID = r1;
        }

        public void setUrl(String r1) {
            this.url = r1;
        }

        public static boolean isEqual(Extra r4, Extra r5) {
            if (r4 != null) goto L7;
            if (r5 != null) goto L7;
            return true;
        L7:
            if (r4 == null) goto L16;
            if (r5 == null) goto L16;
            if (TextUtils.equals(r4.appID, r5.appID) == true) goto L12;
        L14:
            return false;
        L12:
            if (TextUtils.equals(r4.url, r5.url) == false) goto L14;
            return true;
        L16:
            return false;
        }
    }

    public static class Logo {

        @JSONField(name = "mobile_primary_default_png")
        private String mobilePrimaryDefaultPng;

        @JSONField(name = "mobile_primary_selected_png")
        private String mobilePrimarySelectedPng;

        @JSONField(name = "primary_color_png")
        private String primaryColorPng;

        @JSONField(name = "primary_default")
        private String primaryDefault;

        @JSONField(name = "primary_selected")
        private String primarySelected;

        @JSONField(name = "secretary_bgcolor")
        private String secretaryBgColor;

        @JSONField(name = "secretary_default")
        private String secretaryDefault;

        public Logo() {
        }

        public String getMobilePrimaryDefaultPng() {
            return this.mobilePrimaryDefaultPng;
        }

        public String getMobilePrimarySelectedPng() {
            return this.mobilePrimarySelectedPng;
        }

        public String getPrimaryColorPng() {
            return this.primaryColorPng;
        }

        public String getPrimaryDefault() {
            return this.primaryDefault;
        }

        public String getPrimarySelected() {
            return this.primarySelected;
        }

        public String getSecretaryBgColor() {
            return this.secretaryBgColor;
        }

        public String getSecretaryDefault() {
            return this.secretaryDefault;
        }

        public void setMobilePrimaryDefaultPng(String r1) {
            this.mobilePrimaryDefaultPng = r1;
        }

        public void setMobilePrimarySelectedPng(String r1) {
            this.mobilePrimarySelectedPng = r1;
        }

        public void setPrimaryColorPng(String r1) {
            this.primaryColorPng = r1;
        }

        public void setPrimaryDefault(String r1) {
            this.primaryDefault = r1;
        }

        public void setPrimarySelected(String r1) {
            this.primarySelected = r1;
        }

        public void setSecretaryBgColor(String r1) {
            this.secretaryBgColor = r1;
        }

        public void setSecretaryDefault(String r1) {
            this.secretaryDefault = r1;
        }

        public static boolean isEqual(Logo r4, Logo r5) {
            if (r4 != null) goto L7;
            if (r5 != null) goto L7;
            return true;
        L7:
            if (r4 == null) goto L24;
            if (r5 == null) goto L24;
            if (TextUtils.equals(r4.secretaryDefault, r5.secretaryDefault) == true) goto L12;
        L22:
            return false;
        L12:
            if (TextUtils.equals(r4.primaryDefault, r5.primaryDefault) == false) goto L22;
            if (TextUtils.equals(r4.primarySelected, r5.primarySelected) == false) goto L22;
            if (TextUtils.equals(r4.primaryColorPng, r5.primaryColorPng) == false) goto L22;
            if (TextUtils.equals(r4.mobilePrimaryDefaultPng, r5.mobilePrimaryDefaultPng) == false) goto L22;
            if (TextUtils.equals(r4.mobilePrimarySelectedPng, r5.mobilePrimarySelectedPng) == false) goto L22;
            return true;
        L24:
            return false;
        }
    }

    public static class Name {

        @JSONField(name = "zh_cn")
        private String cn;

        @JSONField(name = "ja_jp")
        private String jp;

        @JSONField(name = "en_us")
        private String us;

        public Name() {
        }

        public String getCn() {
            return this.cn;
        }

        public String getJp() {
            return this.jp;
        }

        public String getUs() {
            return this.us;
        }

        public void setCn(String r1) {
            this.cn = r1;
        }

        public void setJp(String r1) {
            this.jp = r1;
        }

        public void setUs(String r1) {
            this.us = r1;
        }

        public static boolean isEqual(Name r4, Name r5) {
            if (r4 != null) goto L7;
            if (r5 != null) goto L7;
            return true;
        L7:
            if (r4 == null) goto L18;
            if (r5 == null) goto L18;
            if (TextUtils.equals(r4.us, r5.us) == true) goto L12;
        L16:
            return false;
        L12:
            if (TextUtils.equals(r4.jp, r5.jp) == false) goto L16;
            if (TextUtils.equals(r4.cn, r5.cn) == false) goto L16;
            return true;
        L18:
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.key, this.appType});
    }

    public TabAppInfo() {
    }

    public String getAppType() {
        return this.appType;
    }

    public Extra getExtra() {
        return this.extra;
    }

    public String getId() {
        return this.id;
    }

    public String getKey() {
        return this.key;
    }

    public Logo getLogo() {
        return this.logo;
    }

    public Name getName() {
        return this.name;
    }

    public boolean isPrimaryOnly() {
        return this.primaryOnly;
    }

    public boolean isUnmovable() {
        return this.unmovable;
    }

    public TabAppInfo(String r1) {
        this.key = r1;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L17:
        return false;
    L8:
        if (getClass() != r5.getClass()) goto L17;
        TabAppInfo r6 = (TabAppInfo) r5;
        if (Objects.equals(this.key, r6.key) == true) goto L13;
    L15:
        return false;
    L13:
        if (Objects.equals(this.appType, r6.appType) == false) goto L15;
        return true;
    }

    public void setAppType(String r1) {
        this.appType = r1;
    }

    public void setExtra(Extra r1) {
        this.extra = r1;
    }

    public void setId(String r1) {
        this.id = r1;
    }

    public void setKey(String r1) {
        this.key = r1;
    }

    public void setLogo(Logo r1) {
        this.logo = r1;
    }

    public void setName(Name r1) {
        this.name = r1;
    }

    public void setPrimaryOnly(boolean r1) {
        this.primaryOnly = r1;
    }

    public void setUnmovable(boolean r1) {
        this.unmovable = r1;
    }

    public static boolean needUpdate(TabAppInfo r4, TabAppInfo r5) {
        if (r5 != null) goto L6;
        return false;
    L6:
        if (r4 != null) goto L9;
        return true;
    L9:
        if (Logo.isEqual(r4.logo, r5.logo) == true) goto L11;
    L14:
        return true;
    L11:
        if (Name.isEqual(r4.name, r5.name) == true) goto L14;
        if (Extra.isEqual(r4.extra, r5.extra) == true) goto L14;
        return false;
    }
}
