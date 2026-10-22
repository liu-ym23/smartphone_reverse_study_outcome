package com.bytedance.android.live.base.model.user;

import com.bytedance.android.live.broadcastgame.opengame.debug.OpenPlatformBaseDebugger;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class PublicAreaBadgeInfo implements e0 {

    @SerializedName("badge_info_map")
    public Map<Long, py.k> badgeInfoMap;

    @SerializedName("badge_list")
    public List<Long> badgeList;
    private transient List<h0> publicAreaBadgeList;

    @SerializedName("webcast_dsl_badge_list")
    public List<WebcastDslBadgeList> webcastDslBadgeList;

    public static class DslRule implements s {

        @SerializedName("ab_params")
        public Map<String, String> abParams;

        @SerializedName(OpenPlatformBaseDebugger.APP_ID)
        public List<Long> appId;

        @SerializedName("version_code")
        public List<Long> versionCode;

        public DslRule() {
        }

        @Override // com.bytedance.android.live.base.model.user.s
        public Map<String, String> abParams() {
            return this.abParams;
        }

        @Override // com.bytedance.android.live.base.model.user.s
        public List<Long> appId() {
            return this.appId;
        }

        @Override // com.bytedance.android.live.base.model.user.s
        public List<Long> versionCode() {
            return this.versionCode;
        }
    }

    public static class WebcastDslBadgeList implements r {

        @SerializedName("badge_list")
        public List<Long> badgeList;

        @SerializedName("filter_dsl_rule")
        public DslRule filterDslRule;

        @SerializedName("target_dsl_rule")
        public DslRule targetDslRule;

        public WebcastDslBadgeList() {
        }

        @Override // com.bytedance.android.live.base.model.user.r
        public List<Long> badgeList() {
            return this.badgeList;
        }

        @Override // com.bytedance.android.live.base.model.user.r
        public s filterDslRule() {
            return this.filterDslRule;
        }

        @Override // com.bytedance.android.live.base.model.user.r
        public s targetDslRule() {
            return this.targetDslRule;
        }
    }

    public PublicAreaBadgeInfo() {
    }

    @Override // com.bytedance.android.live.base.model.user.e0
    public Map<Long, py.k> badgeInfoMap() {
        return new HashMap(this.badgeInfoMap);
    }

    @Override // com.bytedance.android.live.base.model.user.e0
    public List<r> dslBadgeList() {
        return new ArrayList(this.webcastDslBadgeList);
    }

    @Override // com.bytedance.android.live.base.model.user.e0
    public List<Long> badgeList() {
        return this.badgeList;
    }

    @Override // com.bytedance.android.live.base.model.user.e0
    public List<h0> getPublicAreaBadgeList() {
        return this.publicAreaBadgeList;
    }

    @Override // com.bytedance.android.live.base.model.user.e0
    public void setPublicAreaBadgeList(List<h0> r2) {
        if (r2 == null) goto L4;
        this.publicAreaBadgeList = new ArrayList(r2);
        return;
    L4:
        this.publicAreaBadgeList = null;
    }
}
