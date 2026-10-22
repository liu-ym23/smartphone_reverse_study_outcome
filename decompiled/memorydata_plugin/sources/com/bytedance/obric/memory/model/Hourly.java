package com.bytedance.obric.memory.model;

import com.bytedance.rpc.serialize.FieldType;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class Hourly implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public List<Precipitation__1> precipitation;
    public List<Skycon> skycon;
    public List<Temperature> temperature;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public Hourly() {
    }
}
