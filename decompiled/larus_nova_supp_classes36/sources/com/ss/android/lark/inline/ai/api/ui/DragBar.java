package com.ss.android.lark.inline.ai.api.ui;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\r\u001a\u00020\u000eH\u0016J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/ss/android/lark/inline/ai/api/ui/DragBar;", "Ljava/io/Serializable;", "show", "", "doubleConfirm", "<init>", "(ZZ)V", "getShow", "()Z", "setShow", "(Z)V", "getDoubleConfirm", "setDoubleConfirm", "toString", "", "component1", "component2", "copy", "equals", INotificationHitPoint.NoticeType.OTHER, "", "hashCode", "", "inline-ai-api_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class DragBar implements Serializable {
    private boolean doubleConfirm;
    private boolean show;

    public static /* synthetic */ DragBar copy$default(DragBar r0, boolean r1, boolean r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.show;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.doubleConfirm;
    L9:
        return r0.copy(r1, r2);
    }

    public final boolean component1() {
        return this.show;
    }

    public final boolean component2() {
        return this.doubleConfirm;
    }

    public final DragBar copy(boolean r2, boolean r3) {
        return new DragBar(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof DragBar) == true) goto L8;
        return false;
    L8:
        DragBar r6 = (DragBar) r5;
        if (this.show == r6.show) goto L12;
        return false;
    L12:
        if (this.doubleConfirm == r6.doubleConfirm) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r1 = 1231;
        if (this.show == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        if (this.doubleConfirm == true) goto L11;
        r1 = 1237;
    L11:
        return r2 + r1;
    L5:
        r0 = 1237;
        goto L6
    }

    public String toString() {
        return "DragBar(show=" + this.show + ", doubleConfirm=" + this.doubleConfirm + ')';
    }

    public final boolean getDoubleConfirm() {
        return this.doubleConfirm;
    }

    public final boolean getShow() {
        return this.show;
    }

    public final void setDoubleConfirm(boolean r1) {
        this.doubleConfirm = r1;
    }

    public final void setShow(boolean r1) {
        this.show = r1;
    }

    public DragBar(boolean r1, boolean r2) {
        this.show = r1;
        this.doubleConfirm = r2;
    }
}
