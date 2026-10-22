package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class VideoTypeInfo implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("album_uri")
    public String albumUri;
    public String gid;
    public int height;
    public int width;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public VideoTypeInfo() {
    }
}
