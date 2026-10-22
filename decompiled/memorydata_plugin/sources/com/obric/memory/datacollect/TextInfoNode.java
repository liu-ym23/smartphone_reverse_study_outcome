package com.obric.memory.datacollect;

import com.bytedance.rpc.serialize.FieldType;
import java.io.Serializable;

/* JADX INFO: loaded from: classes4.dex */
public class TextInfoNode implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public String desc;
    public String hint;
    public int id;
    public String name;
    public String text;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public TextInfoNode() {
    }
}
