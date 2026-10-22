package com.bytedance.obric.memory.model;

import com.bytedance.rpc.serialize.FieldType;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class AddressInputRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public String keyword;
    public String latitude;
    public String longitude;
    public int num;
    public int size;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public AddressInputRequest() {
    }
}
