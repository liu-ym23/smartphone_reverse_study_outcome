package com.bytedance.android.live.base.model.user;

import android.text.TextUtils;
import com.bytedance.android.live.GsonHelper;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class LiveAnchorRankHonor {

    @SerializedName("honor_title")
    public String honorTitle;

    @SerializedName("icon_url")
    public py.k iconUrl;
    private a liveLifeHonorInfo;

    public static class a {

        @SerializedName("life_live_honor_date")
        public String lifeLiveHonorDate;

        @SerializedName("life_live_honor_prefix")
        private String lifeLiveHonorPrefix;

        @SerializedName("life_live_honor_rank")
        public String lifeLiveHonorRank;

        @SerializedName("life_live_honor_text_icon_url")
        public String lifeLiveHonorTestIconUrl;

        public a() {
        }
    }

    public LiveAnchorRankHonor() {
    }

    public a getLiveLifeHonorInfo() {
        a r0 = this.liveLifeHonorInfo;
        if (r0 == null) goto L6;
        return r0;
    L6:
        if (TextUtils.isEmpty(this.honorTitle) == false) goto L11;
        return null;
    L11:
        a r1 = (a) GsonHelper.get().fromJson(this.honorTitle, a.class);     // Catch: Exception -> L10
        this.liveLifeHonorInfo = r1;     // Catch: Exception -> L10
        return r1;
    L10:
        return null;
    }

    public boolean needShow() {
        if (getLiveLifeHonorInfo() != null) goto L5;
    L7:
        return false;
    L5:
        if (this.iconUrl == null) goto L7;
        return true;
    }
}
