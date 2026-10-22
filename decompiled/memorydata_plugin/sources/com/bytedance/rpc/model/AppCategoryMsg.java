package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class AppCategoryMsg implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public AppCategory category;

    @SerializedName("package_name")
    public String packageName;

    @SerializedName("sub_category")
    public AppCategory subCategory;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public AppCategoryMsg() {
    }
}
