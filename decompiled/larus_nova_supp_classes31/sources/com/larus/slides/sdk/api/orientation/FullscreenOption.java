package com.larus.slides.sdk.api.orientation;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0007\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tR\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\"\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\u0011\u0010\u000b\"\u0004\b\u0012\u0010\rR \u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/larus/slides/sdk/api/orientation/FullscreenOption;", "", "hideStatusBar", "", "hideNavigationBar", "immersive", "clickFrom", "", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;)V", "getHideStatusBar", "()Ljava/lang/Boolean;", "setHideStatusBar", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getHideNavigationBar", "setHideNavigationBar", "getImmersive", "setImmersive", "getClickFrom", "()Ljava/lang/String;", "setClickFrom", "(Ljava/lang/String;)V", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class FullscreenOption {

    @SerializedName("clickFrom")
    private String clickFrom;

    @SerializedName("hideNavigationBar")
    private Boolean hideNavigationBar;

    @SerializedName("hideStatusBar")
    private Boolean hideStatusBar;

    @SerializedName("immersive")
    private Boolean immersive;

    public FullscreenOption() {
        this(null, null, null, null, 15, null);
    }

    public final String getClickFrom() {
        return this.clickFrom;
    }

    public final Boolean getHideNavigationBar() {
        return this.hideNavigationBar;
    }

    public final Boolean getHideStatusBar() {
        return this.hideStatusBar;
    }

    public final Boolean getImmersive() {
        return this.immersive;
    }

    public final void setClickFrom(String r1) {
        this.clickFrom = r1;
    }

    public final void setHideNavigationBar(Boolean r1) {
        this.hideNavigationBar = r1;
    }

    public final void setHideStatusBar(Boolean r1) {
        this.hideStatusBar = r1;
    }

    public final void setImmersive(Boolean r1) {
        this.immersive = r1;
    }

    public FullscreenOption(Boolean r1, Boolean r2, Boolean r3, String r4) {
        this.hideStatusBar = r1;
        this.hideNavigationBar = r2;
        this.immersive = r3;
        this.clickFrom = r4;
    }

    public /* synthetic */ FullscreenOption(Boolean r1, Boolean r2, Boolean r3, String r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = Boolean.TRUE;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = Boolean.TRUE;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = Boolean.TRUE;
    L12:
        if ((r5 & 8) == 0) goto L14;
        r4 = null;
    L14:
        this(r1, r2, r3, r4);
    }
}
