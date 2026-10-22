package com.obric.memorydata.middleware.api.settings;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J%\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/obric/memorydata/middleware/api/settings/ActionRecommendSceneVersion;", "", "minVersion", "", "activities", "", "Lcom/obric/memorydata/middleware/api/settings/ActionRecommendSceneActivity;", "<init>", "(JLjava/util/List;)V", "getMinVersion", "()J", "getActivities", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ActionRecommendSceneVersion {
    private final List<ActionRecommendSceneActivity> activities;
    private final long minVersion;

    public ActionRecommendSceneVersion(long r3, List<ActionRecommendSceneActivity> r5) {
        List<ActionRecommendSceneActivity> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        this.minVersion = r3;
        this.activities = r6;
    }

    public /* synthetic */ ActionRecommendSceneVersion(long r2, List r4, int r5, DefaultConstructorMarker r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L5;
        r7 = null;
    L5:
        this(r2, r7);
    }

    public static /* synthetic */ ActionRecommendSceneVersion copy$default(ActionRecommendSceneVersion r1, long r2, List r4, int r5, Object r6) {
        List<ActionRecommendSceneActivity> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        if ((r5 & 1) == 0) goto L6;
        r2 = r1.minVersion;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r7 = r1.activities;
    L9:
        return r1.copy(r2, r7);
    }

    public final long component1() {
        return this.minVersion;
    }

    public final List<ActionRecommendSceneActivity> component2() {
        return this.activities;
    }

    public final ActionRecommendSceneVersion copy(long r2, List<ActionRecommendSceneActivity> r4) {
        return new ActionRecommendSceneVersion(r2, (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin"));
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, ActionRecommendSceneVersion.class) == true) goto L8;
        return false;
    L8:
        ActionRecommendSceneVersion r10 = (ActionRecommendSceneVersion) ZeusTransformUtils.preCheckCast(r9, ActionRecommendSceneVersion.class, "com.obric.memorydata.plugin");
        if (this.minVersion == r10.minVersion) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.activities, r10.activities) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final List<ActionRecommendSceneActivity> getActivities() {
        return this.activities;
    }

    public final long getMinVersion() {
        return this.minVersion;
    }

    public int hashCode() {
        int r0 = Long.hashCode(this.minVersion) * 31;
        List<ActionRecommendSceneActivity> r2 = this.activities;
        if (r2 != null) goto L5;
        int r3 = 0;
    L7:
        return r0 + r3;
    L5:
        r3 = r2.hashCode();
        goto L7
    }

    public String toString() {
        return "ActionRecommendSceneVersion(minVersion=" + this.minVersion + ", activities=" + this.activities + ')';
    }
}
