package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class TaskPromptTemplate implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public List<TaskMessageItem> messages;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public TaskPromptTemplate() {
    }
}
