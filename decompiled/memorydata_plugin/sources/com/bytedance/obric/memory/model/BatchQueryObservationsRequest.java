package com.bytedance.obric.memory.model;

import com.bytedance.crash.entity.Header;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class BatchQueryObservationsRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public String cursor;
    public int limit;

    @SerializedName(Header.KEY_USER_ID)
    public String userId;

    @SerializedName("window_end")
    public long windowEnd;

    @SerializedName("window_start")
    public long windowStart;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public BatchQueryObservationsRequest() {
    }
}
