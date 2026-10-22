package com.ss.android.lark.location.dto;

import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class POIConfig implements Serializable {
    private static final long serialVersionUID = 6805193021257208981L;
    private boolean disallowLatLngTransformation;
    private String mActionText;
    private boolean mNeedWGSLatLng;
    private boolean mSelfDefine;
    private boolean mSnapshot;

    public POIConfig() {
    }

    public void disallowLatLngTransformation() {
        this.disallowLatLngTransformation = true;
    }

    public String getActionText() {
        return this.mActionText;
    }

    public boolean isLatLngTransformationDisallowed() {
        return this.disallowLatLngTransformation;
    }

    public boolean isNeedWGSLatLng() {
        return this.mNeedWGSLatLng;
    }

    public boolean isSelfDefine() {
        return this.mSelfDefine;
    }

    public boolean isSnapshot() {
        return this.mSnapshot;
    }

    public void setActionText(String r1) {
        this.mActionText = r1;
    }

    public void setNeedWGSLatLng(boolean r1) {
        this.mNeedWGSLatLng = r1;
    }

    public void setSelfDefine(boolean r1) {
        this.mSelfDefine = r1;
    }

    public void setSnapshot(boolean r1) {
        this.mSnapshot = r1;
    }
}
