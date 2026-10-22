package com.ss.android.lark.lynxkit.host;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\"\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001Bi\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0015J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0015J\t\u0010!\u001a\u00020\u0005HÆ\u0003Jp\u0010\"\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\n\u001a\u00020\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\f\u001a\u00020\u0005HÆ\u0001¢\u0006\u0002\u0010#J\u0013\u0010$\u001a\u00020\u00052\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\u0003HÖ\u0001J\t\u0010'\u001a\u00020(HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0007\u0010\u0015R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0013R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0017\u0010\u0010R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u000b\u0010\u0015R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0013¨\u0006)"}, d2 = {"Lcom/ss/android/lark/lynxkit/host/LarkLynxSystemBarOptions;", "", "statusBarColor", "", "consumeStatusBar", "", "consumeDisplayCutout", "isAppearanceLightStatusBars", "isAutoCalculateLightStatusBars", "navigationBarColor", "consumeNavigationBar", "isAppearanceLightNavigationBars", "isAutoCalculateLightNavigationBars", "<init>", "(Ljava/lang/Integer;ZZLjava/lang/Boolean;ZLjava/lang/Integer;ZLjava/lang/Boolean;Z)V", "getStatusBarColor", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getConsumeStatusBar", "()Z", "getConsumeDisplayCutout", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getNavigationBarColor", "getConsumeNavigationBar", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;ZZLjava/lang/Boolean;ZLjava/lang/Integer;ZLjava/lang/Boolean;Z)Lcom/ss/android/lark/lynxkit/host/LarkLynxSystemBarOptions;", "equals", INotificationHitPoint.NoticeType.OTHER, "hashCode", "toString", "", "lark-lynx-kit_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class LarkLynxSystemBarOptions {
    private final boolean consumeDisplayCutout;
    private final boolean consumeNavigationBar;
    private final boolean consumeStatusBar;
    private final Boolean isAppearanceLightNavigationBars;
    private final Boolean isAppearanceLightStatusBars;
    private final boolean isAutoCalculateLightNavigationBars;
    private final boolean isAutoCalculateLightStatusBars;
    private final Integer navigationBarColor;
    private final Integer statusBarColor;

    public LarkLynxSystemBarOptions() {
        this(null, false, false, null, false, null, false, null, false, 511, null);
    }

    public static /* synthetic */ LarkLynxSystemBarOptions copy$default(LarkLynxSystemBarOptions r10, Integer r11, boolean r12, boolean r13, Boolean r14, boolean r15, Integer r16, boolean r17, Boolean r18, boolean r19, int r20, Object r21) {
        if ((r20 & 1) == 0) goto L5;
        Integer r2 = r10.statusBarColor;
    L7:
        if ((r20 & 2) == 0) goto L9;
        boolean r3 = r10.consumeStatusBar;
    L11:
        if ((r20 & 4) == 0) goto L13;
        boolean r4 = r10.consumeDisplayCutout;
    L15:
        if ((r20 & 8) == 0) goto L17;
        Boolean r5 = r10.isAppearanceLightStatusBars;
    L19:
        if ((r20 & 16) == 0) goto L21;
        boolean r6 = r10.isAutoCalculateLightStatusBars;
    L23:
        if ((r20 & 32) == 0) goto L25;
        Integer r7 = r10.navigationBarColor;
    L27:
        if ((r20 & 64) == 0) goto L29;
        boolean r8 = r10.consumeNavigationBar;
    L31:
        if ((r20 & 128) == 0) goto L33;
        Boolean r9 = r10.isAppearanceLightNavigationBars;
    L35:
        if ((r20 & 256) == 0) goto L37;
        boolean r1 = r10.isAutoCalculateLightNavigationBars;
    L39:
        return r10.copy(r2, r3, r4, r5, r6, r7, r8, r9, r1);
    L37:
        r1 = r19;
        goto L39
    L33:
        r9 = r18;
        goto L35
    L29:
        r8 = r17;
        goto L31
    L25:
        r7 = r16;
        goto L27
    L21:
        r6 = r15;
        goto L23
    L17:
        r5 = r14;
        goto L19
    L13:
        r4 = r13;
        goto L15
    L9:
        r3 = r12;
        goto L11
    L5:
        r2 = r11;
        goto L7
    }

    public final Integer component1() {
        return this.statusBarColor;
    }

    public final boolean component2() {
        return this.consumeStatusBar;
    }

    public final boolean component3() {
        return this.consumeDisplayCutout;
    }

    public final Boolean component4() {
        return this.isAppearanceLightStatusBars;
    }

    public final boolean component5() {
        return this.isAutoCalculateLightStatusBars;
    }

    public final Integer component6() {
        return this.navigationBarColor;
    }

    public final boolean component7() {
        return this.consumeNavigationBar;
    }

    public final Boolean component8() {
        return this.isAppearanceLightNavigationBars;
    }

    public final boolean component9() {
        return this.isAutoCalculateLightNavigationBars;
    }

    public final LarkLynxSystemBarOptions copy(Integer r12, boolean r13, boolean r14, Boolean r15, boolean r16, Integer r17, boolean r18, Boolean r19, boolean r20) {
        return new LarkLynxSystemBarOptions(r12, r13, r14, r15, r16, r17, r18, r19, r20);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof LarkLynxSystemBarOptions) == true) goto L8;
        return false;
    L8:
        LarkLynxSystemBarOptions r6 = (LarkLynxSystemBarOptions) r5;
        if (Intrinsics.areEqual(this.statusBarColor, r6.statusBarColor) == true) goto L12;
        return false;
    L12:
        if (this.consumeStatusBar == r6.consumeStatusBar) goto L15;
        return false;
    L15:
        if (this.consumeDisplayCutout == r6.consumeDisplayCutout) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.isAppearanceLightStatusBars, r6.isAppearanceLightStatusBars) == true) goto L21;
        return false;
    L21:
        if (this.isAutoCalculateLightStatusBars == r6.isAutoCalculateLightStatusBars) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.navigationBarColor, r6.navigationBarColor) == true) goto L27;
        return false;
    L27:
        if (this.consumeNavigationBar == r6.consumeNavigationBar) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.isAppearanceLightNavigationBars, r6.isAppearanceLightNavigationBars) == true) goto L33;
        return false;
    L33:
        if (this.isAutoCalculateLightNavigationBars == r6.isAutoCalculateLightNavigationBars) goto L35;
        return false;
    L35:
        return true;
    }

    public int hashCode() {
        Integer r0 = this.statusBarColor;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        int r4 = 1231;
        if (this.consumeStatusBar == false) goto L9;
        int r5 = 1231;
    L10:
        int r6 = (r3 + r5) * 31;
        if (this.consumeDisplayCutout == false) goto L13;
        int r7 = 1231;
    L14:
        int r8 = (r6 + r7) * 31;
        Boolean r9 = this.isAppearanceLightStatusBars;
        if (r9 != null) goto L17;
        int r10 = 0;
    L18:
        int r11 = (r8 + r10) * 31;
        if (this.isAutoCalculateLightStatusBars == false) goto L21;
        int r12 = 1231;
    L22:
        int r13 = (r11 + r12) * 31;
        Integer r14 = this.navigationBarColor;
        if (r14 != null) goto L25;
        int r15 = 0;
    L26:
        int r16 = (r13 + r15) * 31;
        if (this.consumeNavigationBar == false) goto L29;
        int r17 = 1231;
    L30:
        int r18 = (r16 + r17) * 31;
        Boolean r19 = this.isAppearanceLightNavigationBars;
        if (r19 == null) goto L34;
        r1 = r19.hashCode();
    L34:
        int r20 = (r18 + r1) * 31;
        if (this.isAutoCalculateLightNavigationBars == true) goto L39;
        r4 = 1237;
    L39:
        return r20 + r4;
    L29:
        r17 = 1237;
        goto L30
    L25:
        r15 = r14.hashCode();
        goto L26
    L21:
        r12 = 1237;
        goto L22
    L17:
        r10 = r9.hashCode();
        goto L18
    L13:
        r7 = 1237;
        goto L14
    L9:
        r5 = 1237;
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "LarkLynxSystemBarOptions(statusBarColor=" + this.statusBarColor + ", consumeStatusBar=" + this.consumeStatusBar + ", consumeDisplayCutout=" + this.consumeDisplayCutout + ", isAppearanceLightStatusBars=" + this.isAppearanceLightStatusBars + ", isAutoCalculateLightStatusBars=" + this.isAutoCalculateLightStatusBars + ", navigationBarColor=" + this.navigationBarColor + ", consumeNavigationBar=" + this.consumeNavigationBar + ", isAppearanceLightNavigationBars=" + this.isAppearanceLightNavigationBars + ", isAutoCalculateLightNavigationBars=" + this.isAutoCalculateLightNavigationBars + ')';
    }

    public final boolean getConsumeDisplayCutout() {
        return this.consumeDisplayCutout;
    }

    public final boolean getConsumeNavigationBar() {
        return this.consumeNavigationBar;
    }

    public final boolean getConsumeStatusBar() {
        return this.consumeStatusBar;
    }

    public final Integer getNavigationBarColor() {
        return this.navigationBarColor;
    }

    public final Integer getStatusBarColor() {
        return this.statusBarColor;
    }

    public final Boolean isAppearanceLightNavigationBars() {
        return this.isAppearanceLightNavigationBars;
    }

    public final Boolean isAppearanceLightStatusBars() {
        return this.isAppearanceLightStatusBars;
    }

    public final boolean isAutoCalculateLightNavigationBars() {
        return this.isAutoCalculateLightNavigationBars;
    }

    public final boolean isAutoCalculateLightStatusBars() {
        return this.isAutoCalculateLightStatusBars;
    }

    public LarkLynxSystemBarOptions(Integer r1, boolean r2, boolean r3, Boolean r4, boolean r5, Integer r6, boolean r7, Boolean r8, boolean r9) {
        this.statusBarColor = r1;
        this.consumeStatusBar = r2;
        this.consumeDisplayCutout = r3;
        this.isAppearanceLightStatusBars = r4;
        this.isAutoCalculateLightStatusBars = r5;
        this.navigationBarColor = r6;
        this.consumeNavigationBar = r7;
        this.isAppearanceLightNavigationBars = r8;
        this.isAutoCalculateLightNavigationBars = r9;
    }

    public /* synthetic */ LarkLynxSystemBarOptions(Integer r12, boolean r13, boolean r14, Boolean r15, boolean r16, Integer r17, boolean r18, Boolean r19, boolean r20, int r21, DefaultConstructorMarker r22) {
        Boolean r2 = null;
        if ((r21 & 1) == 0) goto L5;
        Integer r1 = null;
    L6:
        boolean r4 = true;
        if ((r21 & 2) == 0) goto L9;
        boolean r3 = true;
    L11:
        if ((r21 & 4) == 0) goto L13;
        boolean r5 = true;
    L15:
        if ((r21 & 8) == 0) goto L17;
        Boolean r6 = null;
    L19:
        if ((r21 & 16) == 0) goto L21;
        boolean r7 = true;
    L23:
        if ((r21 & 32) == 0) goto L25;
        Integer r8 = null;
    L27:
        if ((r21 & 64) == 0) goto L29;
        boolean r9 = true;
    L31:
        if ((r21 & 128) != 0) goto L35;
        r2 = r19;
    L35:
        if ((r21 & 256) != 0) goto L38;
        r4 = r20;
    L38:
        this(r1, r3, r5, r6, r7, r8, r9, r2, r4);
        return;
    L29:
        r9 = r18;
        goto L31
    L25:
        r8 = r17;
        goto L27
    L21:
        r7 = r16;
        goto L23
    L17:
        r6 = r15;
        goto L19
    L13:
        r5 = r14;
        goto L15
    L9:
        r3 = r13;
        goto L11
    L5:
        r1 = r12;
        goto L6
    }
}
