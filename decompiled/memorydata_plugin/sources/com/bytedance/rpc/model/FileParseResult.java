package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class FileParseResult implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("result_list")
    public List<FileParseInfo> resultList;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public FileParseResult() {
    }
}
