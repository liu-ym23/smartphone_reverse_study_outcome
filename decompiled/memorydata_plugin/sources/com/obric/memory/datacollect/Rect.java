package com.obric.memory.datacollect;

import com.bytedance.rpc.serialize.FieldType;
import java.io.Serializable;

/* JADX INFO: loaded from: classes4.dex */
public class Rect implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public int bottom;
    public int left;
    public int right;
    public int top;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public Rect() {
    }
}
