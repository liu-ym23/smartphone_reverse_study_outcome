package com.bytedance.obric.memory.model;

import com.bytedance.rpc.serialize.FieldType;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class Onboarding implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public String content;
    public String prologue;
    public List<String> suggests;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public Onboarding() {
    }
}
