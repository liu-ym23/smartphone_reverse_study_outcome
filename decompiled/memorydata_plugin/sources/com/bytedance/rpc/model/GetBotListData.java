package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class GetBotListData implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("BotList")
    public List<BotInfo> botList;

    @SerializedName("PageIndex")
    public long pageIndex;

    @SerializedName("PageSize")
    public long pageSize;

    @SerializedName("Total")
    public long total;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public GetBotListData() {
    }
}
