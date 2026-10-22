package com.bytedance.android.livesdk.jsbridge.methods.dto;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import sz1.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class Anchor implements Serializable {

    @SerializedName("anchor_content")
    public String content;

    @SerializedName("anchor_icon")
    public Icon icon;

    @SerializedName("anchor_id")
    public String id;

    @SerializedName("source")
    public int source;

    @SerializedName("anchor_tag")
    public String tag;

    @SerializedName("anchor_title")
    public String title;

    @SerializedName("anchor_business_type")
    public int type;

    public static class Icon implements Serializable {

        @SerializedName("file_hash")
        private String fileHash;

        @SerializedName(a.KEY_HEIGHT)
        private int height;

        @SerializedName("data_size")
        private long size;

        @SerializedName("uri")
        protected String uri;

        @SerializedName("url_key")
        private String urlKey;

        @SerializedName("url_list")
        protected List<String> urls;

        @SerializedName(a.KEY_WIDTH)
        private int width;

        public Icon() {
        }
    }

    public Anchor() {
    }
}
