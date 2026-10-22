package com.ss.android.lark.chat.entity.sticker;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class StickerInfo implements Serializable {
    private String mDescription;
    private boolean mHasPaid;
    private String mTitle;

    public StickerInfo() {
        this.mTitle = BuildConfig.FLAVOR;
        this.mDescription = BuildConfig.FLAVOR;
        this.mHasPaid = true;
    }

    public String getDescription() {
        return this.mDescription;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public boolean isHasPaid() {
        return this.mHasPaid;
    }

    public void setDescription(String r1) {
        this.mDescription = r1;
    }

    public void setHasPaid(boolean r1) {
        this.mHasPaid = r1;
    }

    public void setTitle(String r1) {
        this.mTitle = r1;
    }
}
