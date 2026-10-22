package com.bytedance.obric.memory.model;

import com.bytedance.crash.entity.Header;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class GetUserTodoListByTimeRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("Head")
    public Head head;

    @SerializedName(Header.KEY_APP_LAST_UPDATE_TIME)
    public long lastUpdateTime;

    @SerializedName("next_id")
    public long nextId;
    public long num;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public GetUserTodoListByTimeRequest() {
    }
}
