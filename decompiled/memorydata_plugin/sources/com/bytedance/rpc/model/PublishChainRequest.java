package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class PublishChainRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("chain_info")
    public String chainInfo;

    @SerializedName("chain_name")
    public String chainName;

    @SerializedName("creator_id")
    public long creatorId;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public PublishChainRequest() {
    }
}
