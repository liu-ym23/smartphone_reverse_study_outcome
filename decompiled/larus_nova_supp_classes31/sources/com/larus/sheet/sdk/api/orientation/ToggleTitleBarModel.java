package com.larus.sheet.sdk.api.orientation;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\n"}, d2 = {"Lcom/larus/sheet/sdk/api/orientation/ToggleTitleBarModel;", "", "states", "", "<init>", "(Ljava/lang/Integer;)V", "getStates", "()Ljava/lang/Integer;", "setStates", "Ljava/lang/Integer;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class ToggleTitleBarModel {

    @SerializedName("states")
    private Integer states;

    public ToggleTitleBarModel() {
        Integer r0 = null;
        this(r0, 1, r0);
    }

    public final Integer getStates() {
        return this.states;
    }

    public ToggleTitleBarModel(Integer r1) {
        this.states = r1;
    }

    public final void setStates(Integer r1) {
        this.states = r1;
    }

    public /* synthetic */ ToggleTitleBarModel(Integer r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = Integer.valueOf(TitleBarStates.VISIBLE.getStates());
    L5:
        this(r1);
    }
}
