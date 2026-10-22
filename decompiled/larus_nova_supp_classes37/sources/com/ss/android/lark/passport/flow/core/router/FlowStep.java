package com.ss.android.lark.passport.flow.core.router;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J)\u0010\u0011\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/ss/android/lark/passport/flow/core/router/FlowStep;", "Ljava/io/Serializable;", "nextStep", "", "stepInfo", "Lcom/alibaba/fastjson/JSONObject;", "logId", "<init>", "(Ljava/lang/String;Lcom/alibaba/fastjson/JSONObject;Ljava/lang/String;)V", "getNextStep", "()Ljava/lang/String;", "getStepInfo", "()Lcom/alibaba/fastjson/JSONObject;", "getLogId", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "flow-passport-core_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class FlowStep implements Serializable {
    private final String logId;
    private final String nextStep;
    private final JSONObject stepInfo;

    public static /* synthetic */ FlowStep copy$default(FlowStep r0, String r1, JSONObject r2, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.nextStep;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.stepInfo;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.logId;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.nextStep;
    }

    public final JSONObject component2() {
        return this.stepInfo;
    }

    public final String component3() {
        return this.logId;
    }

    public final FlowStep copy(@JSONField(name = "next_step") String r2, @JSONField(name = "step_info") JSONObject r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "nextStep");
        Intrinsics.checkNotNullParameter(r3, "stepInfo");
        return new FlowStep(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof FlowStep) == true) goto L8;
        return false;
    L8:
        FlowStep r6 = (FlowStep) r5;
        if (Intrinsics.areEqual(this.nextStep, r6.nextStep) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.stepInfo, r6.stepInfo) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.logId, r6.logId) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.nextStep.hashCode() * 31) + this.stepInfo.hashCode()) * 31;
        String r1 = this.logId;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "FlowStep(nextStep=" + this.nextStep + ", stepInfo=" + this.stepInfo + ", logId=" + this.logId + ')';
    }

    public final String getLogId() {
        return this.logId;
    }

    public final String getNextStep() {
        return this.nextStep;
    }

    public final JSONObject getStepInfo() {
        return this.stepInfo;
    }

    public FlowStep(@JSONField(name = "next_step") String r2, @JSONField(name = "step_info") JSONObject r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "nextStep");
        Intrinsics.checkNotNullParameter(r3, "stepInfo");
        this.nextStep = r2;
        this.stepInfo = r3;
        this.logId = r4;
    }

    public /* synthetic */ FlowStep(String r1, JSONObject r2, String r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
    L5:
        this(r1, r2, r3);
    }
}
