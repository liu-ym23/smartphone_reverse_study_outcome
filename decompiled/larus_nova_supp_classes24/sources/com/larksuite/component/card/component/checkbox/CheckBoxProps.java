package com.larksuite.component.card.component.checkbox;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\tHÆ\u0003JJ\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u00032\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0007HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u000f\u0010\rR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0010\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006!"}, d2 = {"Lcom/larksuite/component/card/component/checkbox/CheckBoxProps;", "", "multiSelect", "", "actionEnable", "squareShape", "size", "", "styles", "Lcom/larksuite/component/card/component/checkbox/CheckBoxStyles;", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Lcom/larksuite/component/card/component/checkbox/CheckBoxStyles;)V", "getMultiSelect", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getActionEnable", "getSquareShape", "getSize", "()Ljava/lang/String;", "getStyles", "()Lcom/larksuite/component/card/component/checkbox/CheckBoxStyles;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Lcom/larksuite/component/card/component/checkbox/CheckBoxStyles;)Lcom/larksuite/component/card/component/checkbox/CheckBoxProps;", "equals", "other", "hashCode", "", "toString", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class CheckBoxProps {
    private final Boolean actionEnable;
    private final Boolean multiSelect;
    private final String size;
    private final Boolean squareShape;
    private final CheckBoxStyles styles;

    public static /* synthetic */ CheckBoxProps copy$default(CheckBoxProps r3, Boolean r4, Boolean r5, Boolean r6, String r7, CheckBoxStyles r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.multiSelect;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.actionEnable;
    L8:
        Boolean r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.squareShape;
    L11:
        Boolean r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.size;
    L14:
        String r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.styles;
    L17:
        Boolean r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final Boolean component1() {
        return this.multiSelect;
    }

    public final Boolean component2() {
        return this.actionEnable;
    }

    public final Boolean component3() {
        return this.squareShape;
    }

    public final String component4() {
        return this.size;
    }

    public final CheckBoxStyles component5() {
        return this.styles;
    }

    public final CheckBoxProps copy(Boolean r8, Boolean r9, Boolean r10, String r11, CheckBoxStyles r12) {
        return new CheckBoxProps(r8, r9, r10, r11, r12);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof CheckBoxProps) == true) goto L8;
        return false;
    L8:
        CheckBoxProps r6 = (CheckBoxProps) r5;
        if (Intrinsics.areEqual(this.multiSelect, r6.multiSelect) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.actionEnable, r6.actionEnable) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.squareShape, r6.squareShape) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.size, r6.size) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.styles, r6.styles) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        Boolean r0 = this.multiSelect;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Boolean r4 = this.actionEnable;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Boolean r7 = this.squareShape;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.size;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        CheckBoxStyles r13 = this.styles;
        if (r13 == null) goto L23;
        r1 = r13.hashCode();
    L23:
        return r12 + r1;
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "CheckBoxProps(multiSelect=" + this.multiSelect + ", actionEnable=" + this.actionEnable + ", squareShape=" + this.squareShape + ", size=" + this.size + ", styles=" + this.styles + ')';
    }

    public final Boolean getActionEnable() {
        return this.actionEnable;
    }

    public final Boolean getMultiSelect() {
        return this.multiSelect;
    }

    public final String getSize() {
        return this.size;
    }

    public final Boolean getSquareShape() {
        return this.squareShape;
    }

    public final CheckBoxStyles getStyles() {
        return this.styles;
    }

    public CheckBoxProps(Boolean r1, Boolean r2, Boolean r3, String r4, CheckBoxStyles r5) {
        this.multiSelect = r1;
        this.actionEnable = r2;
        this.squareShape = r3;
        this.size = r4;
        this.styles = r5;
    }
}
