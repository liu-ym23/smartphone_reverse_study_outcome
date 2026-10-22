package com.obric.memory.datacollect;

import com.bytedance.rpc.serialize.FieldType;
import java.io.Serializable;

/* JADX INFO: loaded from: classes4.dex */
public class OperateNodeInfo implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public String className;
    public String desc;
    public String hintText;
    public int id;
    public boolean isClickable;
    public int parentId;
    public Rect rect;
    public String text;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public OperateNodeInfo() {
    }
}
