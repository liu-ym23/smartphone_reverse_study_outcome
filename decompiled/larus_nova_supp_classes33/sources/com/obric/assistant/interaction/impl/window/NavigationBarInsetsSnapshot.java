package com.obric.assistant.interaction.impl.window;

import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0017\b\u0080\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003J\t\u0010\u001b\u001a\u00020\nHÆ\u0003JE\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\t\u0010 \u001a\u00020\nHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006!"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/NavigationBarInsetsSnapshot;", "", "left", "", "top", "right", "bottom", "visible", "", "source", "", "<init>", "(IIIIZLjava/lang/String;)V", "getLeft", "()I", "getTop", "getRight", "getBottom", "getVisible", "()Z", "getSource", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NavigationBarInsetsSnapshot {
    private final int bottom;
    private final int left;
    private final int right;
    private final String source;
    private final int top;
    private final boolean visible;

    public NavigationBarInsetsSnapshot() {
        this(0, 0, 0, 0, false, null, 63, null);
    }

    public static /* synthetic */ NavigationBarInsetsSnapshot copy$default(NavigationBarInsetsSnapshot r4, int r5, int r6, int r7, int r8, boolean r9, String r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.left;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.top;
    L8:
        int r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.right;
    L11:
        int r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.bottom;
    L14:
        int r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.visible;
    L17:
        boolean r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.source;
    L20:
        int r14 = r5;
        return r4.copy(r14, r13, r0, r1, r2, r10);
    }

    public final int component1() {
        return this.left;
    }

    public final int component2() {
        return this.top;
    }

    public final int component3() {
        return this.right;
    }

    public final int component4() {
        return this.bottom;
    }

    public final boolean component5() {
        return this.visible;
    }

    public final String component6() {
        return this.source;
    }

    public final NavigationBarInsetsSnapshot copy(int r9, int r10, int r11, int r12, boolean r13, String r14) {
        Intrinsics.checkNotNullParameter(r14, "source");
        return new NavigationBarInsetsSnapshot(r9, r10, r11, r12, r13, r14);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof NavigationBarInsetsSnapshot) == true) goto L8;
        return false;
    L8:
        NavigationBarInsetsSnapshot r6 = (NavigationBarInsetsSnapshot) r5;
        if (this.left == r6.left) goto L12;
        return false;
    L12:
        if (this.top == r6.top) goto L15;
        return false;
    L15:
        if (this.right == r6.right) goto L18;
        return false;
    L18:
        if (this.bottom == r6.bottom) goto L21;
        return false;
    L21:
        if (this.visible == r6.visible) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.source, r6.source) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        int r0 = ((((((this.left * 31) + this.top) * 31) + this.right) * 31) + this.bottom) * 31;
        if (this.visible == false) goto L5;
        int r1 = 1231;
    L7:
        return ((r0 + r1) * 31) + this.source.hashCode();
    L5:
        r1 = 1237;
        goto L7
    }

    public String toString() {
        return "NavigationBarInsetsSnapshot(left=" + this.left + ", top=" + this.top + ", right=" + this.right + ", bottom=" + this.bottom + ", visible=" + this.visible + ", source=" + this.source + ')';
    }

    public final int getBottom() {
        return this.bottom;
    }

    public final int getLeft() {
        return this.left;
    }

    public final int getRight() {
        return this.right;
    }

    public final String getSource() {
        return this.source;
    }

    public final int getTop() {
        return this.top;
    }

    public final boolean getVisible() {
        return this.visible;
    }

    public NavigationBarInsetsSnapshot(int r2, int r3, int r4, int r5, boolean r6, String r7) {
        Intrinsics.checkNotNullParameter(r7, "source");
        this.left = r2;
        this.top = r3;
        this.right = r4;
        this.bottom = r5;
        this.visible = r6;
        this.source = r7;
    }

    public /* synthetic */ NavigationBarInsetsSnapshot(int r5, int r6, int r7, int r8, boolean r9, String r10, int r11, DefaultConstructorMarker r12) {
        boolean r0 = false;
        if ((r11 & 1) == 0) goto L5;
        int r13 = 0;
    L7:
        if ((r11 & 2) == 0) goto L9;
        int r1 = 0;
    L11:
        if ((r11 & 4) == 0) goto L13;
        int r2 = 0;
    L15:
        if ((r11 & 8) == 0) goto L17;
        int r3 = 0;
    L19:
        if ((r11 & 16) != 0) goto L23;
        r0 = r9;
    L23:
        if ((r11 & 32) == 0) goto L25;
        r10 = "";
    L25:
        String r14 = r10;
        this(r13, r1, r2, r3, r0, r14);
        return;
    L17:
        r3 = r8;
        goto L19
    L13:
        r2 = r7;
        goto L15
    L9:
        r1 = r6;
        goto L11
    L5:
        r13 = r5;
        goto L7
    }
}
