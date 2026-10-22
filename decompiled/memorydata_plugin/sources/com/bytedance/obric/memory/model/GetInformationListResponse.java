package com.bytedance.obric.memory.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class GetInformationListResponse implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public int code;
    public List<Information> data;
    public String msg;

    @SerializedName("next_id")
    public long nextId;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public GetInformationListResponse() {
    }
}
