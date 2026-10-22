package com.bytedance.obric.memory.model;

import com.bytedance.rpc.serialize.FieldType;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class Astro implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public String date;
    public Sunrise sunrise;
    public Sunset sunset;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public Astro() {
    }
}
