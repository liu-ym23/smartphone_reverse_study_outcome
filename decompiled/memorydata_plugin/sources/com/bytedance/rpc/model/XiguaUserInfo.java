package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class XiguaUserInfo implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("recent_xigua_gid")
    public List<Long> recentXiguaGid;

    @SerializedName("recent_xigua_video_play_time")
    public List<Long> recentXiguaVideoPlayTime;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public XiguaUserInfo() {
    }
}
