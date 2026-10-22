package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class OrcaCustomerParam implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("float_lists")
    public Map<String, List<Double>> floatLists;

    @SerializedName("int_lists")
    public Map<String, List<Long>> intLists;

    @SerializedName("string_arrays")
    public Map<String, List<List<String>>> stringArrays;

    @SerializedName("string_lists")
    public Map<String, List<String>> stringLists;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public OrcaCustomerParam() {
    }
}
