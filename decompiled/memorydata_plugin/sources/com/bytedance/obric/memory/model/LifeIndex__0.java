package com.bytedance.obric.memory.model;

import com.bytedance.rpc.serialize.FieldType;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class LifeIndex__0 implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public List<Comfort__0> comfort;
    public List<Dressing> dressing;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public LifeIndex__0() {
    }
}
