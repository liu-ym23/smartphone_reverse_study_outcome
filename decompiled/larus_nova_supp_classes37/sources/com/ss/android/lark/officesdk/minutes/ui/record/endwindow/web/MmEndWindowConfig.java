package com.ss.android.lark.officesdk.minutes.ui.record.endwindow.web;

import com.ss.android.lark.picker.base.view.ItemViewType;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/record/endwindow/web/MmEndWindowConfig;", "Ljava/io/Serializable;", "showFooter", "", "<init>", "(Z)V", "getShowFooter", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class MmEndWindowConfig implements Serializable {
    private final boolean showFooter;

    public MmEndWindowConfig() {
        boolean r2 = false;
        this(r2, 1, null);
    }

    public static /* synthetic */ MmEndWindowConfig copy$default(MmEndWindowConfig r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.showFooter;
    L6:
        return r0.copy(r1);
    }

    public final boolean component1() {
        return this.showFooter;
    }

    public final MmEndWindowConfig copy(boolean r2) {
        return new MmEndWindowConfig(r2);
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof MmEndWindowConfig) == true) goto L9;
        return false;
    L9:
        if (this.showFooter == ((MmEndWindowConfig) r4).showFooter) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        if (this.showFooter == false) goto L5;
        return 1231;
    L5:
        return 1237;
    }

    public String toString() {
        return "MmEndWindowConfig(showFooter=" + this.showFooter + ')';
    }

    public final boolean getShowFooter() {
        return this.showFooter;
    }

    public MmEndWindowConfig(boolean r1) {
        this.showFooter = r1;
    }

    public /* synthetic */ MmEndWindowConfig(boolean r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = false;
    L5:
        this(r1);
    }
}
