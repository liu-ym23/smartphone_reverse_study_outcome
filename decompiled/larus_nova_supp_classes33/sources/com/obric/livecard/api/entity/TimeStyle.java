package com.obric.livecard.api.entity;

import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0017"}, d2 = {"Lcom/obric/livecard/api/entity/TimeStyle;", "", "textSize", "", "textColor", "", "(ILjava/lang/String;)V", "getTextColor", "()Ljava/lang/String;", "setTextColor", "(Ljava/lang/String;)V", "getTextSize", "()I", "setTextSize", "(I)V", "component1", "component2", "copy", "equals", "", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "hashCode", "toString", "LiveCard-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class TimeStyle {
    private String textColor;
    private int textSize;

    public static /* synthetic */ TimeStyle copy$default(TimeStyle r0, int r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.textSize;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.textColor;
    L9:
        return r0.copy(r1, r2);
    }

    public final int component1() {
        return this.textSize;
    }

    public final String component2() {
        return this.textColor;
    }

    public final TimeStyle copy(int r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "textColor");
        return new TimeStyle(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof TimeStyle) == true) goto L8;
        return false;
    L8:
        TimeStyle r6 = (TimeStyle) r5;
        if (this.textSize == r6.textSize) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.textColor, r6.textColor) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.textSize * 31) + this.textColor.hashCode();
    }

    public String toString() {
        return "TimeStyle(textSize=" + this.textSize + ", textColor=" + this.textColor + ')';
    }

    public final String getTextColor() {
        return this.textColor;
    }

    public final int getTextSize() {
        return this.textSize;
    }

    public final void setTextColor(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.textColor = r2;
    }

    public final void setTextSize(int r1) {
        this.textSize = r1;
    }

    public TimeStyle(int r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "textColor");
        this.textSize = r2;
        this.textColor = r3;
    }
}
