package com.obric.assistant.interaction.api;

import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003JE\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0010¨\u0006\u001e"}, d2 = {"Lcom/obric/assistant/interaction/api/WindowLayoutInfo;", "", "visibleY", "", "displayHeight", "windowHeight", "isNoLimitsEnabled", "", "visibleNoLimitsEnabled", "isLandscapeWindowLayout", "<init>", "(IIIZZZ)V", "getVisibleY", "()I", "getDisplayHeight", "getWindowHeight", "()Z", "getVisibleNoLimitsEnabled", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "hashCode", "toString", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WindowLayoutInfo {
    private final int displayHeight;
    private final boolean isLandscapeWindowLayout;
    private final boolean isNoLimitsEnabled;
    private final boolean visibleNoLimitsEnabled;
    private final int visibleY;
    private final int windowHeight;

    public static /* synthetic */ WindowLayoutInfo copy$default(WindowLayoutInfo r4, int r5, int r6, int r7, boolean r8, boolean r9, boolean r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.visibleY;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.displayHeight;
    L8:
        int r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.windowHeight;
    L11:
        int r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.isNoLimitsEnabled;
    L14:
        boolean r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.visibleNoLimitsEnabled;
    L17:
        boolean r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.isLandscapeWindowLayout;
    L20:
        int r14 = r5;
        return r4.copy(r14, r13, r0, r1, r2, r10);
    }

    public final int component1() {
        return this.visibleY;
    }

    public final int component2() {
        return this.displayHeight;
    }

    public final int component3() {
        return this.windowHeight;
    }

    public final boolean component4() {
        return this.isNoLimitsEnabled;
    }

    public final boolean component5() {
        return this.visibleNoLimitsEnabled;
    }

    public final boolean component6() {
        return this.isLandscapeWindowLayout;
    }

    public final WindowLayoutInfo copy(int r9, int r10, int r11, boolean r12, boolean r13, boolean r14) {
        return new WindowLayoutInfo(r9, r10, r11, r12, r13, r14);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof WindowLayoutInfo) == true) goto L8;
        return false;
    L8:
        WindowLayoutInfo r6 = (WindowLayoutInfo) r5;
        if (this.visibleY == r6.visibleY) goto L12;
        return false;
    L12:
        if (this.displayHeight == r6.displayHeight) goto L15;
        return false;
    L15:
        if (this.windowHeight == r6.windowHeight) goto L18;
        return false;
    L18:
        if (this.isNoLimitsEnabled == r6.isNoLimitsEnabled) goto L21;
        return false;
    L21:
        if (this.visibleNoLimitsEnabled == r6.visibleNoLimitsEnabled) goto L24;
        return false;
    L24:
        if (this.isLandscapeWindowLayout == r6.isLandscapeWindowLayout) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        int r0 = ((((this.visibleY * 31) + this.displayHeight) * 31) + this.windowHeight) * 31;
        int r2 = 1231;
        if (this.isNoLimitsEnabled == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (r0 + r1) * 31;
        if (this.visibleNoLimitsEnabled == false) goto L9;
        int r4 = 1231;
    L10:
        int r5 = (r3 + r4) * 31;
        if (this.isLandscapeWindowLayout == true) goto L15;
        r2 = 1237;
    L15:
        return r5 + r2;
    L9:
        r4 = 1237;
        goto L10
    L5:
        r1 = 1237;
        goto L6
    }

    public String toString() {
        return "WindowLayoutInfo(visibleY=" + this.visibleY + ", displayHeight=" + this.displayHeight + ", windowHeight=" + this.windowHeight + ", isNoLimitsEnabled=" + this.isNoLimitsEnabled + ", visibleNoLimitsEnabled=" + this.visibleNoLimitsEnabled + ", isLandscapeWindowLayout=" + this.isLandscapeWindowLayout + ')';
    }

    public final int getDisplayHeight() {
        return this.displayHeight;
    }

    public final boolean getVisibleNoLimitsEnabled() {
        return this.visibleNoLimitsEnabled;
    }

    public final int getVisibleY() {
        return this.visibleY;
    }

    public final int getWindowHeight() {
        return this.windowHeight;
    }

    public final boolean isLandscapeWindowLayout() {
        return this.isLandscapeWindowLayout;
    }

    public final boolean isNoLimitsEnabled() {
        return this.isNoLimitsEnabled;
    }

    public WindowLayoutInfo(int r1, int r2, int r3, boolean r4, boolean r5, boolean r6) {
        this.visibleY = r1;
        this.displayHeight = r2;
        this.windowHeight = r3;
        this.isNoLimitsEnabled = r4;
        this.visibleNoLimitsEnabled = r5;
        this.isLandscapeWindowLayout = r6;
    }

    public /* synthetic */ WindowLayoutInfo(int r10, int r11, int r12, boolean r13, boolean r14, boolean r15, int r16, DefaultConstructorMarker r17) {
        if ((r16 & 8) == 0) goto L5;
        boolean r6 = false;
    L7:
        if ((r16 & 16) == 0) goto L9;
        boolean r7 = false;
    L11:
        if ((r16 & 32) == 0) goto L13;
        boolean r8 = false;
    L14:
        this(r10, r11, r12, r6, r7, r8);
        return;
    L13:
        r8 = r15;
        goto L14
    L9:
        r7 = r14;
        goto L11
    L5:
        r6 = r13;
        goto L7
    }
}
