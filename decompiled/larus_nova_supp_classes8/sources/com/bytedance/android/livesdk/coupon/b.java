package com.bytedance.android.livesdk.coupon;

import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class b {

    @SerializedName("coupon_data")
    public c couponData;

    @SerializedName("retain_window_info_v2")
    public C0114b retainWindowInfoV2;

    @SerializedName("window_style")
    public int windowStyle;

    public static class a {

        @SerializedName("discount_price")
        public Long discountPrice;

        @SerializedName("image")
        public ImageModel image;

        @SerializedName("original_price")
        public long originalPrice;

        @SerializedName("product_id")
        public long productId;

        @SerializedName(LiveEndPageData.TAG_TITLE)
        public String title;

        public a() {
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.coupon.b$b, reason: collision with other inner class name */
    public static class C0114b {

        @SerializedName("button_text")
        public String buttonText;

        @SerializedName("cancel_text")
        public String cancelText;

        @SerializedName("countdown_time")
        public long countdownTime;

        @SerializedName("coupon_data")
        public c couponData;

        @SerializedName("expire_suffix_text")
        public String expireSuffixText;

        @SerializedName("kol_user_tag")
        public String kolUserTag;

        @SerializedName("min_watch_time")
        public long minWatchTime;

        @SerializedName("product_infos")
        public List<a> productInfoList;

        @SerializedName("schema")
        public String schema;

        @SerializedName(LiveEndPageData.TAG_TITLE)
        public String title;

        public C0114b() {
        }
    }

    public static class c {

        @SerializedName("coupon_id")
        public String couponId;

        @SerializedName("coupon_meta_id")
        public String couponMetaId;

        @SerializedName("credit")
        public long credit;

        @SerializedName("description")
        public String description;

        @SerializedName("discount_info_desc")
        public String discountInfoDesc;

        @SerializedName("expire_timestamp")
        public long expireTimestamp;

        @SerializedName("icon")
        public String icon;

        @SerializedName("meta_type")
        public int metaType;

        @SerializedName("schema")
        public String schema;

        @SerializedName("start_timestamp")
        public long startTimestamp;

        @SerializedName("threshold")
        public long threshold;

        @SerializedName(LiveEndPageData.TAG_TITLE)
        public String title;

        public c() {
        }
    }

    public b() {
    }
}
