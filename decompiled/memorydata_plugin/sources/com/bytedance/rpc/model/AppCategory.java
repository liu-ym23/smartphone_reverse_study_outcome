package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class AppCategory implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public long id;
    public String name;
    public int type;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public AppCategory() {
    }
}
