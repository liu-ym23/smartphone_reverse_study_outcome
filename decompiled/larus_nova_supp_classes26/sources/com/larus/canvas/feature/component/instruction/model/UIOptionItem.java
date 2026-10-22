package com.larus.canvas.feature.component.instruction.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J3\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001e"}, d2 = {"Lcom/larus/canvas/feature/component/instruction/model/UIOptionItem;", "", "id", "", "name", "", "visible", "", "uiStatus", "Lcom/larus/canvas/feature/component/instruction/model/UIOptionStatus;", "<init>", "(JLjava/lang/String;ZLcom/larus/canvas/feature/component/instruction/model/UIOptionStatus;)V", "getId", "()J", "getName", "()Ljava/lang/String;", "getVisible", "()Z", "getUiStatus", "()Lcom/larus/canvas/feature/component/instruction/model/UIOptionStatus;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UIOptionItem {
    private final long id;
    private final String name;
    private final UIOptionStatus uiStatus;
    private final boolean visible;

    public static /* synthetic */ UIOptionItem copy$default(UIOptionItem r6, long r7, String r9, boolean r10, UIOptionStatus r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L5;
        r7 = r6.id;
    L5:
        long r1 = r7;
        if ((r12 & 2) == 0) goto L8;
        r9 = r6.name;
    L8:
        String r3 = r9;
        if ((r12 & 4) == 0) goto L11;
        r10 = r6.visible;
    L11:
        boolean r4 = r10;
        if ((r12 & 8) == 0) goto L15;
        r11 = r6.uiStatus;
    L15:
        return r6.copy(r1, r3, r4, r11);
    }

    public final long component1() {
        return this.id;
    }

    public final String component2() {
        return this.name;
    }

    public final boolean component3() {
        return this.visible;
    }

    public final UIOptionStatus component4() {
        return this.uiStatus;
    }

    public final UIOptionItem copy(long r8, String r10, boolean r11, UIOptionStatus r12) {
        Intrinsics.checkNotNullParameter(r12, "uiStatus");
        return new UIOptionItem(r8, r10, r11, r12);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof UIOptionItem) == true) goto L8;
        return false;
    L8:
        UIOptionItem r9 = (UIOptionItem) r8;
        if (this.id == r9.id) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.name, r9.name) == true) goto L15;
        return false;
    L15:
        if (this.visible == r9.visible) goto L18;
        return false;
    L18:
        if (this.uiStatus == r9.uiStatus) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        long r0 = this.id;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        String r2 = this.name;
        if (r2 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r1 + r3) * 31;
        if (this.visible == false) goto L9;
        int r5 = 1231;
    L11:
        return ((r4 + r5) * 31) + this.uiStatus.hashCode();
    L9:
        r5 = 1237;
        goto L11
    L5:
        r3 = r2.hashCode();
        goto L6
    }

    public String toString() {
        return "UIOptionItem(id=" + this.id + ", name=" + this.name + ", visible=" + this.visible + ", uiStatus=" + this.uiStatus + ')';
    }

    public final long getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final UIOptionStatus getUiStatus() {
        return this.uiStatus;
    }

    public final boolean getVisible() {
        return this.visible;
    }

    public UIOptionItem(long r2, String r4, boolean r5, UIOptionStatus r6) {
        Intrinsics.checkNotNullParameter(r6, "uiStatus");
        this.id = r2;
        this.name = r4;
        this.visible = r5;
        this.uiStatus = r6;
    }

    public /* synthetic */ UIOptionItem(long r7, String r9, boolean r10, UIOptionStatus r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r9 = "";
    L5:
        String r3 = r9;
        if ((r12 & 4) == 0) goto L8;
        boolean r4 = true;
    L10:
        if ((r12 & 8) == 0) goto L12;
        r11 = UIOptionStatus.NORMAL;
    L12:
        this(r7, r3, r4, r11);
        return;
    L8:
        r4 = r10;
        goto L10
    }
}
