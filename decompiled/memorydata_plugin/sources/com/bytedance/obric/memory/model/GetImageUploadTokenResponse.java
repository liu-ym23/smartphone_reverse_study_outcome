package com.bytedance.obric.memory.model;

import com.bytedance.rpc.serialize.FieldType;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class GetImageUploadTokenResponse implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public int code;
    public ImageXToken data;
    public String msg;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public GetImageUploadTokenResponse() {
    }
}
