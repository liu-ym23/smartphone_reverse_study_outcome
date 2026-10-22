package com.bytedance.ies.xbridge.base.runtime.depend;

import ai.j0;
import androidx.annotation.Keep;
import cn.nubia.neopush.commons.Constant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J+\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ies/xbridge/base/runtime/depend/ActionSheetBuilderAction;", "", Constant.TITLE, "", "subtitle", "type", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getSubtitle", "()Ljava/lang/String;", "getTitle", "getType", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class ActionSheetBuilderAction {
    private final String subtitle;
    private final String title;
    private final String type;

    public ActionSheetBuilderAction(String r5, String r10, String r11) {
        Intrinsics.checkNotNullParameter(r11, "type");
        this.title = r5;
        this.subtitle = r10;
        this.type = r11;
    }

    public static /* synthetic */ ActionSheetBuilderAction copy$default(ActionSheetBuilderAction r5, String r10, String r11, String r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r10 = r5.title;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r11 = r5.subtitle;
    L9:
        if ((r13 & 4) == 0) goto L12;
        r12 = r5.type;
    L12:
        return r5.copy(r10, r11, r12);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.subtitle;
    }

    public final String component3() {
        return this.type;
    }

    public final ActionSheetBuilderAction copy(String r5, String r10, String r11) {
        Intrinsics.checkNotNullParameter(r11, "type");
        return new ActionSheetBuilderAction(r5, r10, r11);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ActionSheetBuilderAction) == true) goto L8;
        return false;
    L8:
        ActionSheetBuilderAction r10 = (ActionSheetBuilderAction) r5;
        if (Intrinsics.areEqual(this.title, r10.title) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.subtitle, r10.subtitle) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.type, r10.type) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final String getSubtitle() {
        return this.subtitle;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        String r5 = this.title;
        int r10 = 0;
        if (r5 != null) goto L5;
        int r11 = 0;
    L6:
        int r12 = r11 * 31;
        String r13 = this.subtitle;
        if (r13 == null) goto L11;
        r10 = r13.hashCode();
    L11:
        return this.type.hashCode() + ((r12 + r10) * 31);
    L5:
        r11 = r5.hashCode();
        goto L6
    }

    public String toString() {
        StringBuilder r5 = new StringBuilder("ActionSheetBuilderAction(title=");
        r5.append(this.title);
        r5.append(", subtitle=");
        r5.append(this.subtitle);
        r5.append(", type=");
        return j0.p(r5, this.type, ')');
    }

    public /* synthetic */ ActionSheetBuilderAction(String r5, String r10, String r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L6;
        r5 = null;
    L6:
        if ((r12 & 2) == 0) goto L8;
        r10 = null;
    L8:
        this(r5, r10, r11);
    }
}
