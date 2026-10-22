package com.ss.android.lark.inline.ai.ui.richtext.selection;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\t\u001a\u00020\nH\u0016J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/inline/ai/ui/richtext/selection/ScrollEnable;", "Ljava/io/Serializable;", "scrollEnable", "", "<init>", "(I)V", "getScrollEnable", "()I", "setScrollEnable", "toString", "", "component1", "copy", "equals", "", INotificationHitPoint.NoticeType.OTHER, "", "hashCode", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class ScrollEnable implements Serializable {
    private int scrollEnable;

    public ScrollEnable() {
        int r2 = 0;
        this(r2, 1, null);
    }

    public static /* synthetic */ ScrollEnable copy$default(ScrollEnable r0, int r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.scrollEnable;
    L6:
        return r0.copy(r1);
    }

    public final int component1() {
        return this.scrollEnable;
    }

    public final ScrollEnable copy(int r2) {
        return new ScrollEnable(r2);
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof ScrollEnable) == true) goto L9;
        return false;
    L9:
        if (this.scrollEnable == ((ScrollEnable) r4).scrollEnable) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.scrollEnable;
    }

    public String toString() {
        return "ScrollEnable(scrollEnable=" + this.scrollEnable + ')';
    }

    public final int getScrollEnable() {
        return this.scrollEnable;
    }

    public ScrollEnable(int r1) {
        this.scrollEnable = r1;
    }

    public final void setScrollEnable(int r1) {
        this.scrollEnable = r1;
    }

    public /* synthetic */ ScrollEnable(int r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = 1;
    L5:
        this(r1);
    }
}
