package com.larus.camera.impl.ui.component.result.general.viewpager;

import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.camera.api.params.OutputParam;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J5\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/larus/camera/impl/ui/component/result/general/viewpager/ResultDisplayParam;", "Ljava/io/Serializable;", MusicAppletPage.KEY_PATH, "", "resultType", "Lcom/larus/camera/api/params/OutputParam$ResultType;", "outputKey", "initPosition", "", "<init>", "(Ljava/lang/String;Lcom/larus/camera/api/params/OutputParam$ResultType;Ljava/lang/String;I)V", "getPath", "()Ljava/lang/String;", "getResultType", "()Lcom/larus/camera/api/params/OutputParam$ResultType;", "getOutputKey", "getInitPosition", "()I", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ResultDisplayParam implements Serializable {
    private final int initPosition;
    private final String outputKey;
    private final String path;
    private final OutputParam.ResultType resultType;

    public static /* synthetic */ ResultDisplayParam copy$default(ResultDisplayParam r0, String r1, OutputParam.ResultType r2, String r3, int r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.path;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.resultType;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.outputKey;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.initPosition;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final String component1() {
        return this.path;
    }

    public final OutputParam.ResultType component2() {
        return this.resultType;
    }

    public final String component3() {
        return this.outputKey;
    }

    public final int component4() {
        return this.initPosition;
    }

    public final ResultDisplayParam copy(String r2, OutputParam.ResultType r3, String r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "resultType");
        return new ResultDisplayParam(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ResultDisplayParam) == true) goto L8;
        return false;
    L8:
        ResultDisplayParam r6 = (ResultDisplayParam) r5;
        if (Intrinsics.areEqual(this.path, r6.path) == true) goto L12;
        return false;
    L12:
        if (this.resultType == r6.resultType) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.outputKey, r6.outputKey) == true) goto L18;
        return false;
    L18:
        if (this.initPosition == r6.initPosition) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r0 = this.path;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = ((r2 * 31) + this.resultType.hashCode()) * 31;
        String r4 = this.outputKey;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return ((r3 + r1) * 31) + this.initPosition;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "ResultDisplayParam(path=" + this.path + ", resultType=" + this.resultType + ", outputKey=" + this.outputKey + ", initPosition=" + this.initPosition + ')';
    }

    public final int getInitPosition() {
        return this.initPosition;
    }

    public final String getOutputKey() {
        return this.outputKey;
    }

    public final String getPath() {
        return this.path;
    }

    public final OutputParam.ResultType getResultType() {
        return this.resultType;
    }

    public ResultDisplayParam(String r2, OutputParam.ResultType r3, String r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "resultType");
        this.path = r2;
        this.resultType = r3;
        this.outputKey = r4;
        this.initPosition = r5;
    }

    public /* synthetic */ ResultDisplayParam(String r2, OutputParam.ResultType r3, String r4, int r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = null;
    L9:
        if ((r6 & 8) == 0) goto L11;
        r5 = 0;
    L11:
        this(r2, r3, r4, r5);
    }
}
