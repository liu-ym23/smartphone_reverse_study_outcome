package com.bytedance.obric.memory.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class OMemoryFavoriteEvent implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("event_time")
    public long eventTime;
    public int operation;

    @SerializedName("source_app_name")
    public String sourceAppName;
    public String summary;
    public List<String> tags;
    public String title;
    public String uuid;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public OMemoryFavoriteEvent() {
    }
}
