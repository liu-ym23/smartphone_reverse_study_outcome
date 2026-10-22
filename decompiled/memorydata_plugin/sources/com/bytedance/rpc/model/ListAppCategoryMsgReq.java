package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ListAppCategoryMsgReq implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("common_param")
    public TTNetCommonParam commonParam;

    @SerializedName("package_name_list")
    public List<String> packageNameList;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public ListAppCategoryMsgReq() {
    }
}
