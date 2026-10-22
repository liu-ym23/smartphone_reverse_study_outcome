package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class UploadMemoryResponse implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public int code;
    public String msg;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public UploadMemoryResponse() {
    }
}
