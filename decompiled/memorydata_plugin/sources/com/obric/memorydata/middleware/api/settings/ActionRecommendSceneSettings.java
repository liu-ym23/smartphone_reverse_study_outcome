package com.obric.memorydata.middleware.api.settings;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J%\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/obric/memorydata/middleware/api/settings/ActionRecommendSceneSettings;", "", "enabled", "", "scenes", "", "Lcom/obric/memorydata/middleware/api/settings/ActionRecommendScene;", "<init>", "(ZLjava/util/List;)V", "getEnabled", "()Z", "getScenes", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ActionRecommendSceneSettings {
    private final boolean enabled;
    private final List<ActionRecommendScene> scenes;

    /* JADX WARN: Multi-variable type inference failed */
    public ActionRecommendSceneSettings() {
        this(false, null, 3, 0 == true ? 1 : 0);
    }

    public ActionRecommendSceneSettings(boolean r3, List<ActionRecommendScene> r4) {
        List<ActionRecommendScene> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        this.enabled = r3;
        this.scenes = r5;
    }

    public /* synthetic */ ActionRecommendSceneSettings(boolean r2, List r3, int r4, DefaultConstructorMarker r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        if ((r4 & 1) == 0) goto L6;
        r2 = false;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r6 = null;
    L8:
        this(r2, r6);
    }

    public static /* synthetic */ ActionRecommendSceneSettings copy$default(ActionRecommendSceneSettings r1, boolean r2, List r3, int r4, Object r5) {
        List<ActionRecommendScene> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        if ((r4 & 1) == 0) goto L6;
        r2 = r1.enabled;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r6 = r1.scenes;
    L9:
        return r1.copy(r2, r6);
    }

    public final boolean component1() {
        return this.enabled;
    }

    public final List<ActionRecommendScene> component2() {
        return this.scenes;
    }

    public final ActionRecommendSceneSettings copy(boolean r2, List<ActionRecommendScene> r3) {
        return new ActionRecommendSceneSettings(r2, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ActionRecommendSceneSettings.class) == true) goto L8;
        return false;
    L8:
        ActionRecommendSceneSettings r6 = (ActionRecommendSceneSettings) ZeusTransformUtils.preCheckCast(r5, ActionRecommendSceneSettings.class, "com.obric.memorydata.plugin");
        if (this.enabled == r6.enabled) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.scenes, r6.scenes) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final List<ActionRecommendScene> getScenes() {
        return this.scenes;
    }

    public int hashCode() {
        int r0 = Boolean.hashCode(this.enabled) * 31;
        List<ActionRecommendScene> r1 = this.scenes;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "ActionRecommendSceneSettings(enabled=" + this.enabled + ", scenes=" + this.scenes + ')';
    }
}
