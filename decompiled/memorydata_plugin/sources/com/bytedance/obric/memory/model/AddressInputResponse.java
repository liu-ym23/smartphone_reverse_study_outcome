package com.bytedance.obric.memory.model;

import com.bytedance.rpc.serialize.FieldType;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class AddressInputResponse implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public int code;
    public long count;
    public List<PoiItem> data;
    public String msg;
    public long total;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public AddressInputResponse() {
    }
}
