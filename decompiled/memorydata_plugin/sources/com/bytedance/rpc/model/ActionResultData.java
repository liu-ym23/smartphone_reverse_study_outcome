package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class ActionResultData implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("card_data")
    public String cardData;
    public int code;

    @SerializedName("entity_data")
    public String entityData;
    public String msg;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public ActionResultData() {
    }
}
