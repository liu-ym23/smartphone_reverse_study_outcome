package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class LoadOMNISkillResponse implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public int code;
    public String message;
    public List<OmniSkillLoadResult> results;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public LoadOMNISkillResponse() {
    }
}
