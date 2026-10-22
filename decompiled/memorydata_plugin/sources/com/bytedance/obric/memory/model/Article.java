package com.bytedance.obric.memory.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class Article implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public String content;

    @SerializedName("create_time")
    public long createTime;
    public long id;
    public int source;
    public String title;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public Article() {
    }
}
