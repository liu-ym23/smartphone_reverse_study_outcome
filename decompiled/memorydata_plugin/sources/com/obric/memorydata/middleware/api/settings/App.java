package com.obric.memorydata.middleware.api.settings;

import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\tHÆ\u0003J9\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/obric/memorydata/middleware/api/settings/App;", "", "appName", "", ObricMemoryConstants.KEY_PACKAGE_NAME, "versions", "", "Lcom/obric/memorydata/middleware/api/settings/Version;", "extras", "Lcom/obric/memorydata/middleware/api/settings/Extras;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/obric/memorydata/middleware/api/settings/Extras;)V", "getAppName", "()Ljava/lang/String;", "getPackageName", "getVersions", "()Ljava/util/List;", "getExtras", "()Lcom/obric/memorydata/middleware/api/settings/Extras;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class App {
    private final String appName;
    private final Extras extras;
    private final String packageName;
    private final List<Version> versions;

    public App(String r3, String r4, List<Version> r5, Extras r6) {
        List<Version> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "appName");
        Intrinsics.checkNotNullParameter(r4, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r7, "versions");
        this.appName = r3;
        this.packageName = r4;
        this.versions = r7;
        this.extras = r6;
    }

    public static /* synthetic */ App copy$default(App r1, String r2, String r3, List r4, Extras r5, int r6, Object r7) {
        List<Version> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        if ((r6 & 1) == 0) goto L6;
        r2 = r1.appName;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = r1.packageName;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r8 = r1.versions;
    L12:
        if ((r6 & 8) == 0) goto L15;
        r5 = r1.extras;
    L15:
        return r1.copy(r2, r3, r8, r5);
    }

    public final String component1() {
        return this.appName;
    }

    public final String component2() {
        return this.packageName;
    }

    public final List<Version> component3() {
        return this.versions;
    }

    public final Extras component4() {
        return this.extras;
    }

    public final App copy(String r2, String r3, List<Version> r4, Extras r5) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "appName");
        Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r1, "versions");
        return new App(r2, r3, r1, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, App.class) == true) goto L8;
        return false;
    L8:
        App r6 = (App) ZeusTransformUtils.preCheckCast(r5, App.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.appName, r6.appName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.packageName, r6.packageName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.versions, r6.versions) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.extras, r6.extras) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final String getAppName() {
        return this.appName;
    }

    public final Extras getExtras() {
        return this.extras;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final List<Version> getVersions() {
        return this.versions;
    }

    public int hashCode() {
        int r0 = ((((this.appName.hashCode() * 31) + this.packageName.hashCode()) * 31) + this.versions.hashCode()) * 31;
        Extras r2 = this.extras;
        if (r2 != null) goto L5;
        int r3 = 0;
    L7:
        return r0 + r3;
    L5:
        r3 = r2.hashCode();
        goto L7
    }

    public String toString() {
        return "App(appName=" + this.appName + ", packageName=" + this.packageName + ", versions=" + this.versions + ", extras=" + this.extras + ')';
    }
}
