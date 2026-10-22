package com.obric.assistant.interaction.impl.window;

import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\tHÆ\u0003JE\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0012¨\u0006\u001f"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/WindowHostLayoutSpec;", "", "width", "", "height", "gravity", "x", "y", "isLandscapeWindow", "", "<init>", "(IIIIIZ)V", "getWidth", "()I", "getHeight", "getGravity", "getX", "getY", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "hashCode", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WindowHostLayoutSpec {
    private final int gravity;
    private final int height;
    private final boolean isLandscapeWindow;
    private final int width;
    private final int x;
    private final int y;

    public static /* synthetic */ WindowHostLayoutSpec copy$default(WindowHostLayoutSpec r4, int r5, int r6, int r7, int r8, int r9, boolean r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.width;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.height;
    L8:
        int r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.gravity;
    L11:
        int r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.x;
    L14:
        int r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.y;
    L17:
        int r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.isLandscapeWindow;
    L20:
        int r14 = r5;
        return r4.copy(r14, r13, r0, r1, r2, r10);
    }

    public final int component1() {
        return this.width;
    }

    public final int component2() {
        return this.height;
    }

    public final int component3() {
        return this.gravity;
    }

    public final int component4() {
        return this.x;
    }

    public final int component5() {
        return this.y;
    }

    public final boolean component6() {
        return this.isLandscapeWindow;
    }

    public final WindowHostLayoutSpec copy(int r9, int r10, int r11, int r12, int r13, boolean r14) {
        return new WindowHostLayoutSpec(r9, r10, r11, r12, r13, r14);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof WindowHostLayoutSpec) == true) goto L8;
        return false;
    L8:
        WindowHostLayoutSpec r6 = (WindowHostLayoutSpec) r5;
        if (this.width == r6.width) goto L12;
        return false;
    L12:
        if (this.height == r6.height) goto L15;
        return false;
    L15:
        if (this.gravity == r6.gravity) goto L18;
        return false;
    L18:
        if (this.x == r6.x) goto L21;
        return false;
    L21:
        if (this.y == r6.y) goto L24;
        return false;
    L24:
        if (this.isLandscapeWindow == r6.isLandscapeWindow) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        int r0 = ((((((((this.width * 31) + this.height) * 31) + this.gravity) * 31) + this.x) * 31) + this.y) * 31;
        if (this.isLandscapeWindow == false) goto L5;
        int r1 = 1231;
    L7:
        return r0 + r1;
    L5:
        r1 = 1237;
        goto L7
    }

    public String toString() {
        return "WindowHostLayoutSpec(width=" + this.width + ", height=" + this.height + ", gravity=" + this.gravity + ", x=" + this.x + ", y=" + this.y + ", isLandscapeWindow=" + this.isLandscapeWindow + ')';
    }

    public final int getGravity() {
        return this.gravity;
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getWidth() {
        return this.width;
    }

    public final int getX() {
        return this.x;
    }

    public final int getY() {
        return this.y;
    }

    public final boolean isLandscapeWindow() {
        return this.isLandscapeWindow;
    }

    public WindowHostLayoutSpec(int r1, int r2, int r3, int r4, int r5, boolean r6) {
        this.width = r1;
        this.height = r2;
        this.gravity = r3;
        this.x = r4;
        this.y = r5;
        this.isLandscapeWindow = r6;
    }

    public /* synthetic */ WindowHostLayoutSpec(int r8, int r9, int r10, int r11, int r12, boolean r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 32) == 0) goto L5;
        boolean r6 = false;
    L6:
        this(r8, r9, r10, r11, r12, r6);
        return;
    L5:
        r6 = r13;
        goto L6
    }
}
