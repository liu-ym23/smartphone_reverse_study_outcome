package com.larksuite.component.card.protocol.context;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000eJ8\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000e¨\u0006\u001c"}, d2 = {"Lcom/larksuite/component/card/protocol/context/CardStyle;", "Ljava/io/Serializable;", "isWideMode", "", "headerNoPaddingTop", "showTranslateMargin", "bodyMinHeight", "", "<init>", "(ZZZLjava/lang/Integer;)V", "()Z", "getHeaderNoPaddingTop", "getShowTranslateMargin", "getBodyMinHeight", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "copy", "(ZZZLjava/lang/Integer;)Lcom/larksuite/component/card/protocol/context/CardStyle;", "equals", "other", "", "hashCode", "toString", "", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class CardStyle implements Serializable {
    private final Integer bodyMinHeight;
    private final boolean headerNoPaddingTop;
    private final boolean isWideMode;
    private final boolean showTranslateMargin;

    public CardStyle() {
        this(false, false, false, null, 15, null);
    }

    public static /* synthetic */ CardStyle copy$default(CardStyle r0, boolean r1, boolean r2, boolean r3, Integer r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.isWideMode;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.headerNoPaddingTop;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.showTranslateMargin;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.bodyMinHeight;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final boolean component1() {
        return this.isWideMode;
    }

    public final boolean component2() {
        return this.headerNoPaddingTop;
    }

    public final boolean component3() {
        return this.showTranslateMargin;
    }

    public final Integer component4() {
        return this.bodyMinHeight;
    }

    public final CardStyle copy(boolean r2, boolean r3, boolean r4, Integer r5) {
        return new CardStyle(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof CardStyle) == true) goto L8;
        return false;
    L8:
        CardStyle r6 = (CardStyle) r5;
        if (this.isWideMode == r6.isWideMode) goto L12;
        return false;
    L12:
        if (this.headerNoPaddingTop == r6.headerNoPaddingTop) goto L15;
        return false;
    L15:
        if (this.showTranslateMargin == r6.showTranslateMargin) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.bodyMinHeight, r6.bodyMinHeight) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r1 = 1231;
        if (this.isWideMode == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        if (this.headerNoPaddingTop == false) goto L9;
        int r3 = 1231;
    L10:
        int r4 = (r2 + r3) * 31;
        if (this.showTranslateMargin == true) goto L14;
        r1 = 1237;
    L14:
        int r5 = (r4 + r1) * 31;
        Integer r6 = this.bodyMinHeight;
        if (r6 != null) goto L17;
        int r7 = 0;
    L19:
        return r5 + r7;
    L17:
        r7 = r6.hashCode();
        goto L19
    L9:
        r3 = 1237;
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public String toString() {
        return "CardStyle(isWideMode=" + this.isWideMode + ", headerNoPaddingTop=" + this.headerNoPaddingTop + ", showTranslateMargin=" + this.showTranslateMargin + ", bodyMinHeight=" + this.bodyMinHeight + ')';
    }

    public final Integer getBodyMinHeight() {
        return this.bodyMinHeight;
    }

    public final boolean getHeaderNoPaddingTop() {
        return this.headerNoPaddingTop;
    }

    public final boolean getShowTranslateMargin() {
        return this.showTranslateMargin;
    }

    public final boolean isWideMode() {
        return this.isWideMode;
    }

    public CardStyle(boolean r1, boolean r2, boolean r3, Integer r4) {
        this.isWideMode = r1;
        this.headerNoPaddingTop = r2;
        this.showTranslateMargin = r3;
        this.bodyMinHeight = r4;
    }

    public /* synthetic */ CardStyle(boolean r2, boolean r3, boolean r4, Integer r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = false;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = false;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = true;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = null;
    L14:
        this(r2, r3, r4, r5);
    }
}
