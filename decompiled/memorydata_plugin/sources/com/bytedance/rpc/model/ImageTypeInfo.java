package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ImageTypeInfo implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("author_short_id")
    public String authorShortId;

    @SerializedName("aweme_image_id")
    public String awemeImageId;
    public int height;

    @SerializedName("site_name")
    public String siteName;

    @SerializedName("thumbnail_height")
    public int thumbnailHeight;

    @SerializedName("thumbnail_url")
    public String thumbnailUrl;

    @SerializedName("thumbnail_width")
    public int thumbnailWidth;
    public String uri;
    public String url;
    public List<String> urls;
    public int width;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public ImageTypeInfo() {
    }
}
