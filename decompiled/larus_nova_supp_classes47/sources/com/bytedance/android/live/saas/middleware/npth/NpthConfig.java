package com.bytedance.android.live.saas.middleware.npth;

import com.bytedance.badger.collect.impl.constants.Constants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\b¢\u0006\u0002\u0010\tJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0017\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\bHÆ\u0003JA\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0006HÖ\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\fR(\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/live/saas/middleware/npth/NpthConfig;", "", "standalone", "", "isToBVersion", Constants.OperatorKey.KEY_APP_ID, "", "params", "", "(ZZLjava/lang/String;Ljava/util/Map;)V", "getAppId", "()Ljava/lang/String;", "()Z", "getParams", "()Ljava/util/Map;", "setParams", "(Ljava/util/Map;)V", "getStandalone", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "middleware_release"}, k = 1, mv = {1, 4, 3})
public final class NpthConfig {
    private final String appId;
    private final boolean isToBVersion;
    private Map<String, ? extends Object> params;
    private final boolean standalone;

    public NpthConfig() {
        this(false, false, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ NpthConfig copy$default(NpthConfig r0, boolean r1, boolean r2, String r3, Map r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.standalone;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.isToBVersion;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.appId;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.params;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final boolean component1() {
        return this.standalone;
    }

    public final boolean component2() {
        return this.isToBVersion;
    }

    public final String component3() {
        return this.appId;
    }

    public final Map<String, Object> component4() {
        return this.params;
    }

    public final NpthConfig copy(boolean r2, boolean r3, String r4, Map<String, ? extends Object> r5) {
        Intrinsics.checkNotNullParameter(r5, "params");
        return new NpthConfig(r2, r3, r4, r5);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof NpthConfig) == false) goto L14;
        NpthConfig r4 = (NpthConfig) r3;
        if (this.standalone == r4.standalone) goto L8;
        return false;
    L8:
        if (this.isToBVersion == r4.isToBVersion) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.appId, r4.appId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.params, r4.params) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7 */
    public int hashCode() {
        boolean r0 = this.standalone;
        ?? r1 = 1;
        ?? r2 = r0;
        if (r0 == false) goto L5;
        r2 = 1;
    L5:
        int r3 = r2 * 31;
        boolean r4 = this.isToBVersion;
        if (r4 == true) goto L9;
        r1 = r4;
    L9:
        int r5 = (r3 + r1) * 31;
        String r6 = this.appId;
        int r7 = 0;
        if (r6 == null) goto L12;
        int r8 = r6.hashCode();
    L13:
        int r9 = (r5 + r8) * 31;
        Map<String, ? extends Object> r10 = this.params;
        if (r10 == null) goto L17;
        r7 = r10.hashCode();
    L17:
        return r9 + r7;
    L12:
        r8 = 0;
        goto L13
    }

    public String toString() {
        return "NpthConfig(standalone=" + this.standalone + ", isToBVersion=" + this.isToBVersion + ", appId=" + this.appId + ", params=" + this.params + ")";
    }

    public final String getAppId() {
        return this.appId;
    }

    public final Map<String, Object> getParams() {
        return this.params;
    }

    public final boolean getStandalone() {
        return this.standalone;
    }

    public final boolean isToBVersion() {
        return this.isToBVersion;
    }

    public final void setParams(Map<String, ? extends Object> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.params = r2;
    }

    public NpthConfig(boolean r2, boolean r3, String r4, Map<String, ? extends Object> r5) {
        Intrinsics.checkNotNullParameter(r5, "params");
        this.standalone = r2;
        this.isToBVersion = r3;
        this.appId = r4;
        this.params = r5;
    }

    public /* synthetic */ NpthConfig(boolean r2, boolean r3, String r4, Map r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = false;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = false;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = MapsKt.emptyMap();
    L14:
        this(r2, r3, r4, r5);
    }
}
