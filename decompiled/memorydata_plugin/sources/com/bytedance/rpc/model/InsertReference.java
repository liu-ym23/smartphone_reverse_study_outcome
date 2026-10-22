package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class InsertReference implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public String icon;

    @SerializedName("image_type_info")
    public ImageTypeInfo imageTypeInfo;

    @SerializedName("insert_text")
    public String insertText;
    public List<Integer> pos;
    public InsertReferenceType type;
    public String url;

    @SerializedName("video_type_info")
    public VideoTypeInfo videoTypeInfo;

    @SerializedName("website_name")
    public String websiteName;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public InsertReference() {
    }
}
