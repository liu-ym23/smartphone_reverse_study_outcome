package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class SkillPackage implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public String checksum;

    @SerializedName("download_url")
    public String downloadUrl;
    public List<SkillFile> files;

    @SerializedName("url_expire_at")
    public long urlExpireAt;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public SkillPackage() {
    }
}
