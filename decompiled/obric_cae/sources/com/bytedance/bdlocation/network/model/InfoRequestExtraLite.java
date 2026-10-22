package com.bytedance.bdlocation.network.model;

import ia.b;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class InfoRequestExtraLite {

    @b("scene_permission_enable")
    public final boolean scenePermissionEnable;

    @b("scenes")
    public final Map<String, Boolean> scenes;

    public InfoRequestExtraLite(boolean r8, Map<String, Boolean> r10) {
        this.scenePermissionEnable = r8;
        this.scenes = r10;
    }

    public String toString() {
        return "scenePermissionEnable: " + this.scenePermissionEnable + ", scenes: " + this.scenes;
    }
}
