package com.bytedance.bdlocation.network.model;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class InfoRequestExtraLite {

    @SerializedName("scene_permission_enable")
    public final boolean scenePermissionEnable;

    @SerializedName("scenes")
    public final Map<String, Boolean> scenes;

    public InfoRequestExtraLite(boolean r3, Map<String, Boolean> r4) {
        Map<String, Boolean> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        this.scenePermissionEnable = r3;
        this.scenes = r5;
    }

    public String toString() {
        return "scenePermissionEnable: " + this.scenePermissionEnable + ", scenes: " + this.scenes;
    }
}
