package com.bytedance.obric.memory.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class MemoryData implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("app_names")
    public String appNames;
    public int category;
    public String content;

    @SerializedName("created_time")
    public long createdTime;
    public Map<String, String> ext;
    public String extra;
    public long id;

    @SerializedName("like_reason")
    public String likeReason;

    @SerializedName("like_status")
    public int likeStatus;
    public String observation;

    @SerializedName("profile_type")
    public int profileType;
    public long score;
    public int status;
    public String summary;
    public String tag;

    @SerializedName("tag_other")
    public String tagOther;

    @SerializedName("update_time")
    public long updateTime;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public MemoryData() {
    }
}
