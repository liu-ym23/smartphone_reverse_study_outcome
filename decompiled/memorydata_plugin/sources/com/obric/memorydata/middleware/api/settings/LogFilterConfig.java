package com.obric.memorydata.middleware.api.settings;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/obric/memorydata/middleware/api/settings/LogFilterConfig;", "", LocationMonitorConst.TAG, "", "regexFilter", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getTag", "()Ljava/lang/String;", "getRegexFilter", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LogFilterConfig {

    @SerializedName("regex_filter")
    private final String regexFilter;

    @SerializedName(LocationMonitorConst.TAG)
    private final String tag;

    public LogFilterConfig(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TAG);
        this.tag = r2;
        this.regexFilter = r3;
    }

    public /* synthetic */ LogFilterConfig(String r1, String r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }

    public static /* synthetic */ LogFilterConfig copy$default(LogFilterConfig r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.tag;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.regexFilter;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.tag;
    }

    public final String component2() {
        return this.regexFilter;
    }

    public final LogFilterConfig copy(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, LocationMonitorConst.TAG);
        return new LogFilterConfig(r1, r2);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, LogFilterConfig.class) == true) goto L8;
        return false;
    L8:
        LogFilterConfig r6 = (LogFilterConfig) ZeusTransformUtils.preCheckCast(r5, LogFilterConfig.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.tag, r6.tag) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.regexFilter, r6.regexFilter) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final String getRegexFilter() {
        return this.regexFilter;
    }

    public final String getTag() {
        return this.tag;
    }

    public int hashCode() {
        int r0 = this.tag.hashCode() * 31;
        String r1 = this.regexFilter;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "LogFilterConfig(tag=" + this.tag + ", regexFilter=" + this.regexFilter + ')';
    }
}
