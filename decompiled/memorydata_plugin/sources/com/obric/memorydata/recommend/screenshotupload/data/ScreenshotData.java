package com.obric.memorydata.recommend.screenshotupload.data;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/obric/memorydata/recommend/screenshotupload/data/ScreenshotData;", "", "inputData", "Lcom/obric/memorydata/recommend/screenshotupload/data/ScreenshotInputData;", "outputData", "Lcom/obric/memorydata/recommend/screenshotupload/data/ScreenshotOutputData;", "<init>", "(Lcom/obric/memorydata/recommend/screenshotupload/data/ScreenshotInputData;Lcom/obric/memorydata/recommend/screenshotupload/data/ScreenshotOutputData;)V", "getInputData", "()Lcom/obric/memorydata/recommend/screenshotupload/data/ScreenshotInputData;", "getOutputData", "()Lcom/obric/memorydata/recommend/screenshotupload/data/ScreenshotOutputData;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ScreenshotData {
    private final ScreenshotInputData inputData;
    private final ScreenshotOutputData outputData;

    public ScreenshotData(ScreenshotInputData r2, ScreenshotOutputData r3) {
        Intrinsics.checkNotNullParameter(r2, "inputData");
        Intrinsics.checkNotNullParameter(r3, "outputData");
        this.inputData = r2;
        this.outputData = r3;
    }

    public static /* synthetic */ ScreenshotData copy$default(ScreenshotData r0, ScreenshotInputData r1, ScreenshotOutputData r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.inputData;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.outputData;
    L9:
        return r0.copy(r1, r2);
    }

    public final ScreenshotInputData component1() {
        return this.inputData;
    }

    public final ScreenshotOutputData component2() {
        return this.outputData;
    }

    public final ScreenshotData copy(ScreenshotInputData r1, ScreenshotOutputData r2) {
        Intrinsics.checkNotNullParameter(r1, "inputData");
        Intrinsics.checkNotNullParameter(r2, "outputData");
        return new ScreenshotData(r1, r2);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ScreenshotData.class) == true) goto L8;
        return false;
    L8:
        ScreenshotData r6 = (ScreenshotData) ZeusTransformUtils.preCheckCast(r5, ScreenshotData.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.inputData, r6.inputData) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.outputData, r6.outputData) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final ScreenshotInputData getInputData() {
        return this.inputData;
    }

    public final ScreenshotOutputData getOutputData() {
        return this.outputData;
    }

    public int hashCode() {
        return (this.inputData.hashCode() * 31) + this.outputData.hashCode();
    }

    public String toString() {
        return "ScreenshotData(inputData=" + this.inputData + ", outputData=" + this.outputData + ')';
    }
}
