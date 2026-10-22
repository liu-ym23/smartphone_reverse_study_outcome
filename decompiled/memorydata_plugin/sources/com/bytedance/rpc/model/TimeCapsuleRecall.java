package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class TimeCapsuleRecall implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("wraped_text")
    public String wrapedText;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public TimeCapsuleRecall() {
    }
}
