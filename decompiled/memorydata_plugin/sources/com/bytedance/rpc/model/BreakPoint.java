package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class BreakPoint implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public Act act;
    public Stage stage;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public BreakPoint() {
    }
}
