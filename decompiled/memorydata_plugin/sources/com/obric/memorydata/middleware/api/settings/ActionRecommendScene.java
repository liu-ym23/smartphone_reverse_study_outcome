package com.obric.memorydata.middleware.api.settings;

import com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J%\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/obric/memorydata/middleware/api/settings/ActionRecommendScene;", "", MemoryInfoSectionEditActivity.KIND_SCENE, "", "apps", "", "Lcom/obric/memorydata/middleware/api/settings/ActionRecommendSceneApp;", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "getScene", "()Ljava/lang/String;", "getApps", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ActionRecommendScene {
    private final List<ActionRecommendSceneApp> apps;
    private final String scene;

    public ActionRecommendScene(String r3, List<ActionRecommendSceneApp> r4) {
        List<ActionRecommendSceneApp> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, MemoryInfoSectionEditActivity.KIND_SCENE);
        this.scene = r3;
        this.apps = r5;
    }

    public /* synthetic */ ActionRecommendScene(String r2, List r3, int r4, DefaultConstructorMarker r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L5;
        r6 = null;
    L5:
        this(r2, r6);
    }

    public static /* synthetic */ ActionRecommendScene copy$default(ActionRecommendScene r1, String r2, List r3, int r4, Object r5) {
        List<ActionRecommendSceneApp> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        if ((r4 & 1) == 0) goto L6;
        r2 = r1.scene;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r6 = r1.apps;
    L9:
        return r1.copy(r2, r6);
    }

    public final String component1() {
        return this.scene;
    }

    public final List<ActionRecommendSceneApp> component2() {
        return this.apps;
    }

    public final ActionRecommendScene copy(String r2, List<ActionRecommendSceneApp> r3) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, MemoryInfoSectionEditActivity.KIND_SCENE);
        return new ActionRecommendScene(r2, r1);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ActionRecommendScene.class) == true) goto L8;
        return false;
    L8:
        ActionRecommendScene r6 = (ActionRecommendScene) ZeusTransformUtils.preCheckCast(r5, ActionRecommendScene.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.scene, r6.scene) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.apps, r6.apps) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final List<ActionRecommendSceneApp> getApps() {
        return this.apps;
    }

    public final String getScene() {
        return this.scene;
    }

    public int hashCode() {
        int r0 = this.scene.hashCode() * 31;
        List<ActionRecommendSceneApp> r1 = this.apps;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "ActionRecommendScene(scene=" + this.scene + ", apps=" + this.apps + ')';
    }
}
