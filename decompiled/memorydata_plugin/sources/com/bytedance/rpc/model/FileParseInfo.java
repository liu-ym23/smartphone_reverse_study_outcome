package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class FileParseInfo implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("file_info")
    public FileInfo fileInfo;

    @SerializedName("parse_success")
    public boolean parseSuccess;

    @SerializedName("read_tokens")
    public int readTokens;

    @SerializedName("total_tokens")
    public int totalTokens;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public FileParseInfo() {
    }
}
