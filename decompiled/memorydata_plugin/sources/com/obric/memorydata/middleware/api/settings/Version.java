package com.obric.memorydata.middleware.api.settings;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\bHÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/obric/memorydata/middleware/api/settings/Version;", "", "minVersion", "", "activities", "", "Lcom/obric/memorydata/middleware/api/settings/ActivityPage;", "rules", "", "<init>", "(JLjava/util/List;Ljava/lang/String;)V", "getMinVersion", "()J", "getActivities", "()Ljava/util/List;", "getRules", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Version {
    private final List<ActivityPage> activities;
    private final long minVersion;
    private final String rules;

    public Version(long r3, List<ActivityPage> r5, String r6) {
        List<ActivityPage> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        this.minVersion = r3;
        this.activities = r7;
        this.rules = r6;
    }

    public static /* synthetic */ Version copy$default(Version r1, long r2, List r4, String r5, int r6, Object r7) {
        List<ActivityPage> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        if ((r6 & 1) == 0) goto L6;
        r2 = r1.minVersion;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r8 = r1.activities;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r5 = r1.rules;
    L12:
        return r1.copy(r2, r8, r5);
    }

    public final long component1() {
        return this.minVersion;
    }

    public final List<ActivityPage> component2() {
        return this.activities;
    }

    public final String component3() {
        return this.rules;
    }

    public final Version copy(long r2, List<ActivityPage> r4, String r5) {
        return new Version(r2, (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin"), r5);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, Version.class) == true) goto L8;
        return false;
    L8:
        Version r10 = (Version) ZeusTransformUtils.preCheckCast(r9, Version.class, "com.obric.memorydata.plugin");
        if (this.minVersion == r10.minVersion) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.activities, r10.activities) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.rules, r10.rules) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final List<ActivityPage> getActivities() {
        return this.activities;
    }

    public final long getMinVersion() {
        return this.minVersion;
    }

    public final String getRules() {
        return this.rules;
    }

    public int hashCode() {
        int r0 = Long.hashCode(this.minVersion) * 31;
        List<ActivityPage> r1 = this.activities;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.rules;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "Version(minVersion=" + this.minVersion + ", activities=" + this.activities + ", rules=" + this.rules + ')';
    }
}
