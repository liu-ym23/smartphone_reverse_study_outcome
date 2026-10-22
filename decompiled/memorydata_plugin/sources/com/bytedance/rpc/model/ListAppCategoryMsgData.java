package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ListAppCategoryMsgData implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("category_msg_list")
    public List<AppCategoryMsg> categoryMsgList;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public ListAppCategoryMsgData() {
    }
}
