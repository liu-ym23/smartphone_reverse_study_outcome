package com.bytedance.obric.memory.model;

import com.bytedance.rpc.serialize.FieldType;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class Content implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public String alertId;
    public String code;
    public String description;
    public int pubtimestamp;
    public String title;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public Content() {
    }
}
