package com.obric.memorydata.middleware.api.settings;

import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/obric/memorydata/middleware/api/settings/ActionRecommendSceneApp;", "", "appName", "", ObricMemoryConstants.KEY_PACKAGE_NAME, "versions", "", "Lcom/obric/memorydata/middleware/api/settings/ActionRecommendSceneVersion;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getAppName", "()Ljava/lang/String;", "getPackageName", "getVersions", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ActionRecommendSceneApp {
    private final String appName;
    private final String packageName;
    private final List<ActionRecommendSceneVersion> versions;

    public ActionRecommendSceneApp(String r3, String r4, List<ActionRecommendSceneVersion> r5) {
        List<ActionRecommendSceneVersion> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, ObricMemoryConstants.KEY_PACKAGE_NAME);
        this.appName = r3;
        this.packageName = r4;
        this.versions = r6;
    }

    public /* synthetic */ ActionRecommendSceneApp(String r2, String r3, List r4, int r5, DefaultConstructorMarker r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        if ((r5 & 4) == 0) goto L5;
        r7 = null;
    L5:
        this(r2, r3, r7);
    }

    public static /* synthetic */ ActionRecommendSceneApp copy$default(ActionRecommendSceneApp r1, String r2, String r3, List r4, int r5, Object r6) {
        List<ActionRecommendSceneVersion> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        if ((r5 & 1) == 0) goto L6;
        r2 = r1.appName;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = r1.packageName;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r7 = r1.versions;
    L12:
        return r1.copy(r2, r3, r7);
    }

    public final String component1() {
        return this.appName;
    }

    public final String component2() {
        return this.packageName;
    }

    public final List<ActionRecommendSceneVersion> component3() {
        return this.versions;
    }

    public final ActionRecommendSceneApp copy(String r2, String r3, List<ActionRecommendSceneVersion> r4) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
        return new ActionRecommendSceneApp(r2, r3, r1);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ActionRecommendSceneApp.class) == true) goto L8;
        return false;
    L8:
        ActionRecommendSceneApp r6 = (ActionRecommendSceneApp) ZeusTransformUtils.preCheckCast(r5, ActionRecommendSceneApp.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.appName, r6.appName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.packageName, r6.packageName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.versions, r6.versions) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final String getAppName() {
        return this.appName;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final List<ActionRecommendSceneVersion> getVersions() {
        return this.versions;
    }

    public int hashCode() {
        String r0 = this.appName;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = ((r2 * 31) + this.packageName.hashCode()) * 31;
        List<ActionRecommendSceneVersion> r4 = this.versions;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "ActionRecommendSceneApp(appName=" + this.appName + ", packageName=" + this.packageName + ", versions=" + this.versions + ')';
    }
}
