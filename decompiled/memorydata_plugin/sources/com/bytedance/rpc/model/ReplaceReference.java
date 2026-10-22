package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class ReplaceReference implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("end")
    public int end;

    @SerializedName("replace_text")
    public String replaceText;
    public int start;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public ReplaceReference() {
    }
}
