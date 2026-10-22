package com.bytedance.obric.memory.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class MemorySearchData implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("memory_data_list")
    public List<MemoryData> memoryDataList;

    @SerializedName("user_profile_list")
    public List<MemoryData> userProfileList;

    @SerializedName("user_todo_list")
    public List<UserTodo> userTodoList;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public MemorySearchData() {
    }
}
