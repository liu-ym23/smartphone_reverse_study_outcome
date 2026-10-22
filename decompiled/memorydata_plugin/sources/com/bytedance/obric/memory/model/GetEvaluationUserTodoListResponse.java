package com.bytedance.obric.memory.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class GetEvaluationUserTodoListResponse implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public List<UserTodo> data;

    @SerializedName("mark_id")
    public long markId;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public GetEvaluationUserTodoListResponse() {
    }
}
