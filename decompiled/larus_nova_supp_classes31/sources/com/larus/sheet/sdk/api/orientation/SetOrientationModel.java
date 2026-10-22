package com.larus.sheet.sdk.api.orientation;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bR \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/larus/sheet/sdk/api/orientation/SetOrientationModel;", "", "orientation", "", "option", "Lcom/larus/sheet/sdk/api/orientation/OrientationOption;", "srcOrientation", "<init>", "(Ljava/lang/String;Lcom/larus/sheet/sdk/api/orientation/OrientationOption;Ljava/lang/String;)V", "getOrientation", "()Ljava/lang/String;", "setOrientation", "(Ljava/lang/String;)V", "getOption", "()Lcom/larus/sheet/sdk/api/orientation/OrientationOption;", "setOption", "(Lcom/larus/sheet/sdk/api/orientation/OrientationOption;)V", "getSrcOrientation", "setSrcOrientation", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class SetOrientationModel {

    @SerializedName("option")
    private OrientationOption option;

    @SerializedName("orientation")
    private String orientation;

    @SerializedName("srcOrientation")
    private String srcOrientation;

    public SetOrientationModel() {
        this(null, null, null, 7, null);
    }

    public final OrientationOption getOption() {
        return this.option;
    }

    public final String getOrientation() {
        return this.orientation;
    }

    public final String getSrcOrientation() {
        return this.srcOrientation;
    }

    public final void setOption(OrientationOption r1) {
        this.option = r1;
    }

    public final void setOrientation(String r1) {
        this.orientation = r1;
    }

    public final void setSrcOrientation(String r1) {
        this.srcOrientation = r1;
    }

    public SetOrientationModel(String r1, OrientationOption r2, String r3) {
        this.orientation = r1;
        this.option = r2;
        this.srcOrientation = r3;
    }

    public /* synthetic */ SetOrientationModel(String r1, OrientationOption r2, String r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = OrientationMode.PORTRAIT.getMode();
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = null;
    L9:
        if ((r4 & 4) == 0) goto L11;
        r3 = r1;
    L11:
        this(r1, r2, r3);
    }
}
