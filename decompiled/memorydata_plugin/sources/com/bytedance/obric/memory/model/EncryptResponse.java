package com.bytedance.obric.memory.model;

import com.bytedance.rpc.serialize.FieldType;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class EncryptResponse implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public String ciphertext;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public EncryptResponse() {
    }
}
