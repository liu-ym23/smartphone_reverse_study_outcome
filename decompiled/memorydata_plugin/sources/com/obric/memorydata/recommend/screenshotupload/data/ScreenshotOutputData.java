package com.obric.memorydata.recommend.screenshotupload.data;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J'\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\f¨\u0006\u001b"}, d2 = {"Lcom/obric/memorydata/recommend/screenshotupload/data/ScreenshotOutputData;", "", "screenshotPath", "", "contextData", "Lcom/obric/memorydata/recommend/screenshotupload/data/ScreenshotContextData;", "inAppSignalFlushRequestId", "<init>", "(Ljava/lang/String;Lcom/obric/memorydata/recommend/screenshotupload/data/ScreenshotContextData;Ljava/lang/String;)V", "getScreenshotPath", "()Ljava/lang/String;", "setScreenshotPath", "(Ljava/lang/String;)V", "getContextData", "()Lcom/obric/memorydata/recommend/screenshotupload/data/ScreenshotContextData;", "getInAppSignalFlushRequestId", "setInAppSignalFlushRequestId", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ScreenshotOutputData {
    private final ScreenshotContextData contextData;
    private String inAppSignalFlushRequestId;
    private String screenshotPath;

    public ScreenshotOutputData(String r2, ScreenshotContextData r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "screenshotPath");
        Intrinsics.checkNotNullParameter(r3, "contextData");
        Intrinsics.checkNotNullParameter(r4, "inAppSignalFlushRequestId");
        this.screenshotPath = r2;
        this.contextData = r3;
        this.inAppSignalFlushRequestId = r4;
    }

    public /* synthetic */ ScreenshotOutputData(String r2, ScreenshotContextData r3, String r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = "";
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = "";
    L8:
        this(r2, r3, r4);
    }

    public static /* synthetic */ ScreenshotOutputData copy$default(ScreenshotOutputData r0, String r1, ScreenshotContextData r2, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.screenshotPath;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.contextData;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.inAppSignalFlushRequestId;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.screenshotPath;
    }

    public final ScreenshotContextData component2() {
        return this.contextData;
    }

    public final String component3() {
        return this.inAppSignalFlushRequestId;
    }

    public final ScreenshotOutputData copy(String r1, ScreenshotContextData r2, String r3) {
        Intrinsics.checkNotNullParameter(r1, "screenshotPath");
        Intrinsics.checkNotNullParameter(r2, "contextData");
        Intrinsics.checkNotNullParameter(r3, "inAppSignalFlushRequestId");
        return new ScreenshotOutputData(r1, r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ScreenshotOutputData.class) == true) goto L8;
        return false;
    L8:
        ScreenshotOutputData r6 = (ScreenshotOutputData) ZeusTransformUtils.preCheckCast(r5, ScreenshotOutputData.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.screenshotPath, r6.screenshotPath) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.contextData, r6.contextData) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.inAppSignalFlushRequestId, r6.inAppSignalFlushRequestId) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final ScreenshotContextData getContextData() {
        return this.contextData;
    }

    public final String getInAppSignalFlushRequestId() {
        return this.inAppSignalFlushRequestId;
    }

    public final String getScreenshotPath() {
        return this.screenshotPath;
    }

    public int hashCode() {
        return (((this.screenshotPath.hashCode() * 31) + this.contextData.hashCode()) * 31) + this.inAppSignalFlushRequestId.hashCode();
    }

    public final void setInAppSignalFlushRequestId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.inAppSignalFlushRequestId = r2;
    }

    public final void setScreenshotPath(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.screenshotPath = r2;
    }

    public String toString() {
        return "ScreenshotOutputData(screenshotPath=" + this.screenshotPath + ", contextData=" + this.contextData + ", inAppSignalFlushRequestId=" + this.inAppSignalFlushRequestId + ')';
    }
}
