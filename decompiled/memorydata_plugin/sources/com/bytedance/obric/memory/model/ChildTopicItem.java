package com.bytedance.obric.memory.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class ChildTopicItem implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("btn_action")
    public String btnAction;

    @SerializedName("btn_text")
    public String btnText;

    @SerializedName("btn_type")
    public String btnType;

    @SerializedName("create_time")
    public long createTime;
    public String emoji;
    public String extra;
    public long id;

    @SerializedName("like_status")
    public int likeStatus;

    @SerializedName("parent_id")
    public long parentId;
    public String reason;
    public String subtitle;
    public String title;
    public int type;

    @SerializedName("update_time")
    public long updateTime;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public ChildTopicItem() {
    }
}
