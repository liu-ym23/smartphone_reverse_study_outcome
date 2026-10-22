package com.bytedance.obric.memory.model;

import com.bytedance.rpc.serialize.FieldType;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class APPOpenCloseByContent implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public String action;
    public String category;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public APPOpenCloseByContent() {
    }
}
