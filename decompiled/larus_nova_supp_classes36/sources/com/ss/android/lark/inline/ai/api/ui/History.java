package com.ss.android.lark.inline.ai.api.ui;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.monitor.traffic.TrafficMetrics;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0019\u001a\u00020\u001aH\u0016J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J;\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010!\u001a\u00020\u00032\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000eR\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\f\"\u0004\b\u0018\u0010\u000e¨\u0006%"}, d2 = {"Lcom/ss/android/lark/inline/ai/api/ui/History;", "Ljava/io/Serializable;", "show", "", TrafficMetrics.FROM_TOTAL, "", "curNum", "leftArrowEnabled", "rightArrowEnabled", "<init>", "(ZIIZZ)V", "getShow", "()Z", "setShow", "(Z)V", "getTotal", "()I", "setTotal", "(I)V", "getCurNum", "setCurNum", "getLeftArrowEnabled", "setLeftArrowEnabled", "getRightArrowEnabled", "setRightArrowEnabled", "toString", "", "component1", "component2", "component3", "component4", "component5", "copy", "equals", INotificationHitPoint.NoticeType.OTHER, "", "hashCode", "inline-ai-api_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class History implements Serializable {
    private int curNum;
    private boolean leftArrowEnabled;
    private boolean rightArrowEnabled;
    private boolean show;
    private int total;

    public static /* synthetic */ History copy$default(History r3, boolean r4, int r5, int r6, boolean r7, boolean r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.show;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.total;
    L8:
        int r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.curNum;
    L11:
        int r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.leftArrowEnabled;
    L14:
        boolean r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.rightArrowEnabled;
    L17:
        boolean r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final boolean component1() {
        return this.show;
    }

    public final int component2() {
        return this.total;
    }

    public final int component3() {
        return this.curNum;
    }

    public final boolean component4() {
        return this.leftArrowEnabled;
    }

    public final boolean component5() {
        return this.rightArrowEnabled;
    }

    public final History copy(boolean r8, int r9, int r10, boolean r11, boolean r12) {
        return new History(r8, r9, r10, r11, r12);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof History) == true) goto L8;
        return false;
    L8:
        History r6 = (History) r5;
        if (this.show == r6.show) goto L12;
        return false;
    L12:
        if (this.total == r6.total) goto L15;
        return false;
    L15:
        if (this.curNum == r6.curNum) goto L18;
        return false;
    L18:
        if (this.leftArrowEnabled == r6.leftArrowEnabled) goto L21;
        return false;
    L21:
        if (this.rightArrowEnabled == r6.rightArrowEnabled) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r1 = 1231;
        if (this.show == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = ((((r0 * 31) + this.total) * 31) + this.curNum) * 31;
        if (this.leftArrowEnabled == false) goto L9;
        int r3 = 1231;
    L10:
        int r4 = (r2 + r3) * 31;
        if (this.rightArrowEnabled == true) goto L15;
        r1 = 1237;
    L15:
        return r4 + r1;
    L9:
        r3 = 1237;
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public String toString() {
        return "History(show=" + this.show + ", total=" + this.total + ", curNum=" + this.curNum + ", leftArrowEnabled=" + this.leftArrowEnabled + ", rightArrowEnabled=" + this.rightArrowEnabled + ')';
    }

    public final int getCurNum() {
        return this.curNum;
    }

    public final boolean getLeftArrowEnabled() {
        return this.leftArrowEnabled;
    }

    public final boolean getRightArrowEnabled() {
        return this.rightArrowEnabled;
    }

    public final boolean getShow() {
        return this.show;
    }

    public final int getTotal() {
        return this.total;
    }

    public final void setCurNum(int r1) {
        this.curNum = r1;
    }

    public final void setLeftArrowEnabled(boolean r1) {
        this.leftArrowEnabled = r1;
    }

    public final void setRightArrowEnabled(boolean r1) {
        this.rightArrowEnabled = r1;
    }

    public final void setShow(boolean r1) {
        this.show = r1;
    }

    public final void setTotal(int r1) {
        this.total = r1;
    }

    public History(boolean r1, int r2, int r3, boolean r4, boolean r5) {
        this.show = r1;
        this.total = r2;
        this.curNum = r3;
        this.leftArrowEnabled = r4;
        this.rightArrowEnabled = r5;
    }

    public /* synthetic */ History(boolean r8, int r9, int r10, boolean r11, boolean r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 8) == 0) goto L5;
        boolean r5 = false;
    L7:
        if ((r13 & 16) == 0) goto L9;
        boolean r6 = false;
    L10:
        this(r8, r9, r10, r5, r6);
        return;
    L9:
        r6 = r12;
        goto L10
    L5:
        r5 = r11;
        goto L7
    }
}
