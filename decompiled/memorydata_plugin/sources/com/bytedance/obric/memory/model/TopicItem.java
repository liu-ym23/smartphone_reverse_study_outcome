package com.bytedance.obric.memory.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class TopicItem implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("child_topic_list")
    public List<ChildTopicItem> childTopicList;

    @SerializedName("create_time")
    public long createTime;
    public long id;

    @SerializedName("log_id")
    public String logId;
    public String reason;
    public String title;
    public int type;

    @SerializedName("update_time")
    public long updateTime;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public TopicItem() {
    }
}
