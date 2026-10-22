package com.larus.platform.model;

import com.google.gson.annotations.SerializedName;
import com.larus.common.apphost.AppHost;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/larus/platform/model/MarkDownSelectorSettings;", "", "doubleClickStrategy", "", "longPressStrategy", "tripleClickStrategy", "doubleClickShiftStrategy", "enableMarkedTextFirst", "", "<init>", "(IIIIZ)V", "getDoubleClickStrategy", "()I", "getLongPressStrategy", "getTripleClickStrategy", "getDoubleClickShiftStrategy", "getEnableMarkedTextFirst", "()Z", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class MarkDownSelectorSettings {

    @SerializedName("double_click_shift_strategy")
    private final int doubleClickShiftStrategy;

    @SerializedName("double_click_strategy")
    private final int doubleClickStrategy;

    @SerializedName("enable_marked_text_first")
    private final boolean enableMarkedTextFirst;

    @SerializedName("long_press_strategy")
    private final int longPressStrategy;

    @SerializedName("triple_click_strategy")
    private final int tripleClickStrategy;

    public MarkDownSelectorSettings() {
        this(0, 0, 0, 0, false, 31, null);
    }

    public static /* synthetic */ MarkDownSelectorSettings copy$default(MarkDownSelectorSettings r3, int r4, int r5, int r6, int r7, boolean r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.doubleClickStrategy;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.longPressStrategy;
    L8:
        int r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.tripleClickStrategy;
    L11:
        int r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.doubleClickShiftStrategy;
    L14:
        int r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.enableMarkedTextFirst;
    L17:
        int r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final int component1() {
        return this.doubleClickStrategy;
    }

    public final int component2() {
        return this.longPressStrategy;
    }

    public final int component3() {
        return this.tripleClickStrategy;
    }

    public final int component4() {
        return this.doubleClickShiftStrategy;
    }

    public final boolean component5() {
        return this.enableMarkedTextFirst;
    }

    public final MarkDownSelectorSettings copy(int r8, int r9, int r10, int r11, boolean r12) {
        return new MarkDownSelectorSettings(r8, r9, r10, r11, r12);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof MarkDownSelectorSettings) == true) goto L8;
        return false;
    L8:
        MarkDownSelectorSettings r6 = (MarkDownSelectorSettings) r5;
        if (this.doubleClickStrategy == r6.doubleClickStrategy) goto L12;
        return false;
    L12:
        if (this.longPressStrategy == r6.longPressStrategy) goto L15;
        return false;
    L15:
        if (this.tripleClickStrategy == r6.tripleClickStrategy) goto L18;
        return false;
    L18:
        if (this.doubleClickShiftStrategy == r6.doubleClickShiftStrategy) goto L21;
        return false;
    L21:
        if (this.enableMarkedTextFirst == r6.enableMarkedTextFirst) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r0 = ((((((this.doubleClickStrategy * 31) + this.longPressStrategy) * 31) + this.tripleClickStrategy) * 31) + this.doubleClickShiftStrategy) * 31;
        if (this.enableMarkedTextFirst == false) goto L5;
        int r1 = 1231;
    L7:
        return r0 + r1;
    L5:
        r1 = 1237;
        goto L7
    }

    public String toString() {
        return "MarkDownSelectorSettings(doubleClickStrategy=" + this.doubleClickStrategy + ", longPressStrategy=" + this.longPressStrategy + ", tripleClickStrategy=" + this.tripleClickStrategy + ", doubleClickShiftStrategy=" + this.doubleClickShiftStrategy + ", enableMarkedTextFirst=" + this.enableMarkedTextFirst + ')';
    }

    public final int getDoubleClickShiftStrategy() {
        return this.doubleClickShiftStrategy;
    }

    public final int getDoubleClickStrategy() {
        return this.doubleClickStrategy;
    }

    public final boolean getEnableMarkedTextFirst() {
        return this.enableMarkedTextFirst;
    }

    public final int getLongPressStrategy() {
        return this.longPressStrategy;
    }

    public final int getTripleClickStrategy() {
        return this.tripleClickStrategy;
    }

    public MarkDownSelectorSettings(int r1, int r2, int r3, int r4, boolean r5) {
        this.doubleClickStrategy = r1;
        this.longPressStrategy = r2;
        this.tripleClickStrategy = r3;
        this.doubleClickShiftStrategy = r4;
        this.enableMarkedTextFirst = r5;
    }

    public /* synthetic */ MarkDownSelectorSettings(int r4, int r5, int r6, int r7, boolean r8, int r9, DefaultConstructorMarker r10) {
        int r0 = 3;
        if ((r9 & 1) == 0) goto L5;
        int r11 = 3;
    L7:
        if ((r9 & 2) != 0) goto L11;
        r0 = r5;
    L11:
        if ((r9 & 4) == 0) goto L13;
        int r1 = 5;
    L15:
        if ((r9 & 8) == 0) goto L17;
        r7 = !AppHost.a.isOversea() ? 1 : 0;
    L17:
        int r2 = r7;
        if ((r9 & 16) == 0) goto L20;
        r8 = !AppHost.a.isOversea();
    L20:
        this(r11, r0, r1, r2, r8);
        return;
    L13:
        r1 = r6;
        goto L15
    L5:
        r11 = r4;
        goto L7
    }
}
