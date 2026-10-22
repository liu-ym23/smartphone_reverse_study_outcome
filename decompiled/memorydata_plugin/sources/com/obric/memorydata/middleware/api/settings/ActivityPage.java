package com.obric.memorydata.middleware.api.settings;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/obric/memorydata/middleware/api/settings/ActivityPage;", "", "pageName", "", "activity", "rules", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getPageName", "()Ljava/lang/String;", "getActivity", "getRules", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ActivityPage {
    private final String activity;
    private final String pageName;
    private final String rules;

    public ActivityPage(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "pageName");
        Intrinsics.checkNotNullParameter(r3, "activity");
        Intrinsics.checkNotNullParameter(r4, "rules");
        this.pageName = r2;
        this.activity = r3;
        this.rules = r4;
    }

    public static /* synthetic */ ActivityPage copy$default(ActivityPage r0, String r1, String r2, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.pageName;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.activity;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.rules;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.pageName;
    }

    public final String component2() {
        return this.activity;
    }

    public final String component3() {
        return this.rules;
    }

    public final ActivityPage copy(String r1, String r2, String r3) {
        Intrinsics.checkNotNullParameter(r1, "pageName");
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "rules");
        return new ActivityPage(r1, r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ActivityPage.class) == true) goto L8;
        return false;
    L8:
        ActivityPage r6 = (ActivityPage) ZeusTransformUtils.preCheckCast(r5, ActivityPage.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.pageName, r6.pageName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.activity, r6.activity) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.rules, r6.rules) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final String getActivity() {
        return this.activity;
    }

    public final String getPageName() {
        return this.pageName;
    }

    public final String getRules() {
        return this.rules;
    }

    public int hashCode() {
        return (((this.pageName.hashCode() * 31) + this.activity.hashCode()) * 31) + this.rules.hashCode();
    }

    public String toString() {
        return "ActivityPage(pageName=" + this.pageName + ", activity=" + this.activity + ", rules=" + this.rules + ')';
    }
}
