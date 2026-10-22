package com.bytedance.obric.memory.model;

import com.bytedance.rpc.serialize.FieldType;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class RecommendationItem implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public int confidence;
    public long createTime;
    public long expiredTime;
    public long id;
    public int likeState;
    public String reason;
    public int recommendType;
    public String title;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public RecommendationItem() {
    }
}
