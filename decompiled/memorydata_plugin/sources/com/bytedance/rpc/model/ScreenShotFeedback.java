package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ScreenShotFeedback implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public String content;
    public String score;
    public List<String> tags;
    public String type;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public ScreenShotFeedback() {
    }
}
