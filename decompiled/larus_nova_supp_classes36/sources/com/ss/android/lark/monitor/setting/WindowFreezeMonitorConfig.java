package com.ss.android.lark.monitor.setting;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@AppConfig(key = "window_freeze_monitor_config")
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b \n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001Bk\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003Jm\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\"\u001a\u00020\u00032\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\u0005HÖ\u0001J\t\u0010%\u001a\u00020&HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0010R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0016\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0010R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0010R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0010R\u001e\u0010\u000b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0010\"\u0004\b\u0015\u0010\u0016R\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0010R\u0016\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0010¨\u0006'"}, d2 = {"Lcom/ss/android/lark/monitor/setting/WindowFreezeMonitorConfig;", "", "isMonitorEnabled", "", "inValidTouchThreshold", "", "inValidWindowWidth", "inValidWindowHeight", "isVisibleDetectEnabled", "isElementCountDetectEnabled", "isWindowWidthHeightDetectEnabled", "isActivityDetectEnabled", "isDialogDetectEnabled", "isPopupWindowDetectEnabled", "<init>", "(ZIIIZZZZZZ)V", "()Z", "getInValidTouchThreshold", "()I", "getInValidWindowWidth", "getInValidWindowHeight", "setActivityDetectEnabled", "(Z)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", INotificationHitPoint.NoticeType.OTHER, "hashCode", "toString", "", "monitor_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class WindowFreezeMonitorConfig {

    @SerializedName("invalid_touch_threshold")
    private final int inValidTouchThreshold;

    @SerializedName("invalid_window_width")
    private final int inValidWindowHeight;

    @SerializedName("invalid_window_width")
    private final int inValidWindowWidth;

    @SerializedName("is_activity_detect_enabled")
    private boolean isActivityDetectEnabled;

    @SerializedName("is_dialog_detect_enabled")
    private final boolean isDialogDetectEnabled;

    @SerializedName("is_element_count_detect_enabled")
    private final boolean isElementCountDetectEnabled;

    @SerializedName("is_monitor_enabled")
    private final boolean isMonitorEnabled;

    @SerializedName("is_popup_window_detect_enabled")
    private final boolean isPopupWindowDetectEnabled;

    @SerializedName("is_visible_detect_enabled")
    private final boolean isVisibleDetectEnabled;

    @SerializedName("is_window_width_height_detect_enabled")
    private final boolean isWindowWidthHeightDetectEnabled;

    public WindowFreezeMonitorConfig() {
        this(false, 0, 0, 0, false, false, false, false, false, false, 1023, null);
    }

    public static /* synthetic */ WindowFreezeMonitorConfig copy$default(WindowFreezeMonitorConfig r11, boolean r12, int r13, int r14, int r15, boolean r16, boolean r17, boolean r18, boolean r19, boolean r20, boolean r21, int r22, Object r23) {
        if ((r22 & 1) == 0) goto L5;
        boolean r2 = r11.isMonitorEnabled;
    L7:
        if ((r22 & 2) == 0) goto L9;
        int r3 = r11.inValidTouchThreshold;
    L11:
        if ((r22 & 4) == 0) goto L13;
        int r4 = r11.inValidWindowWidth;
    L15:
        if ((r22 & 8) == 0) goto L17;
        int r5 = r11.inValidWindowHeight;
    L19:
        if ((r22 & 16) == 0) goto L21;
        boolean r6 = r11.isVisibleDetectEnabled;
    L23:
        if ((r22 & 32) == 0) goto L25;
        boolean r7 = r11.isElementCountDetectEnabled;
    L27:
        if ((r22 & 64) == 0) goto L29;
        boolean r8 = r11.isWindowWidthHeightDetectEnabled;
    L31:
        if ((r22 & 128) == 0) goto L33;
        boolean r9 = r11.isActivityDetectEnabled;
    L35:
        if ((r22 & 256) == 0) goto L37;
        boolean r10 = r11.isDialogDetectEnabled;
    L39:
        if ((r22 & 512) == 0) goto L41;
        boolean r1 = r11.isPopupWindowDetectEnabled;
    L43:
        return r11.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r1);
    L41:
        r1 = r21;
        goto L43
    L37:
        r10 = r20;
        goto L39
    L33:
        r9 = r19;
        goto L35
    L29:
        r8 = r18;
        goto L31
    L25:
        r7 = r17;
        goto L27
    L21:
        r6 = r16;
        goto L23
    L17:
        r5 = r15;
        goto L19
    L13:
        r4 = r14;
        goto L15
    L9:
        r3 = r13;
        goto L11
    L5:
        r2 = r12;
        goto L7
    }

    public final boolean component1() {
        return this.isMonitorEnabled;
    }

    public final boolean component10() {
        return this.isPopupWindowDetectEnabled;
    }

    public final int component2() {
        return this.inValidTouchThreshold;
    }

    public final int component3() {
        return this.inValidWindowWidth;
    }

    public final int component4() {
        return this.inValidWindowHeight;
    }

    public final boolean component5() {
        return this.isVisibleDetectEnabled;
    }

    public final boolean component6() {
        return this.isElementCountDetectEnabled;
    }

    public final boolean component7() {
        return this.isWindowWidthHeightDetectEnabled;
    }

    public final boolean component8() {
        return this.isActivityDetectEnabled;
    }

    public final boolean component9() {
        return this.isDialogDetectEnabled;
    }

    public final WindowFreezeMonitorConfig copy(boolean r13, int r14, int r15, int r16, boolean r17, boolean r18, boolean r19, boolean r20, boolean r21, boolean r22) {
        return new WindowFreezeMonitorConfig(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof WindowFreezeMonitorConfig) == true) goto L8;
        return false;
    L8:
        WindowFreezeMonitorConfig r6 = (WindowFreezeMonitorConfig) r5;
        if (this.isMonitorEnabled == r6.isMonitorEnabled) goto L12;
        return false;
    L12:
        if (this.inValidTouchThreshold == r6.inValidTouchThreshold) goto L15;
        return false;
    L15:
        if (this.inValidWindowWidth == r6.inValidWindowWidth) goto L18;
        return false;
    L18:
        if (this.inValidWindowHeight == r6.inValidWindowHeight) goto L21;
        return false;
    L21:
        if (this.isVisibleDetectEnabled == r6.isVisibleDetectEnabled) goto L24;
        return false;
    L24:
        if (this.isElementCountDetectEnabled == r6.isElementCountDetectEnabled) goto L27;
        return false;
    L27:
        if (this.isWindowWidthHeightDetectEnabled == r6.isWindowWidthHeightDetectEnabled) goto L30;
        return false;
    L30:
        if (this.isActivityDetectEnabled == r6.isActivityDetectEnabled) goto L33;
        return false;
    L33:
        if (this.isDialogDetectEnabled == r6.isDialogDetectEnabled) goto L36;
        return false;
    L36:
        if (this.isPopupWindowDetectEnabled == r6.isPopupWindowDetectEnabled) goto L38;
        return false;
    L38:
        return true;
    }

    public int hashCode() {
        int r1 = 1231;
        if (this.isMonitorEnabled == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = ((((((r0 * 31) + this.inValidTouchThreshold) * 31) + this.inValidWindowWidth) * 31) + this.inValidWindowHeight) * 31;
        if (this.isVisibleDetectEnabled == false) goto L9;
        int r3 = 1231;
    L10:
        int r4 = (r2 + r3) * 31;
        if (this.isElementCountDetectEnabled == false) goto L13;
        int r5 = 1231;
    L14:
        int r6 = (r4 + r5) * 31;
        if (this.isWindowWidthHeightDetectEnabled == false) goto L17;
        int r7 = 1231;
    L18:
        int r8 = (r6 + r7) * 31;
        if (this.isActivityDetectEnabled == false) goto L21;
        int r9 = 1231;
    L22:
        int r10 = (r8 + r9) * 31;
        if (this.isDialogDetectEnabled == false) goto L25;
        int r11 = 1231;
    L26:
        int r12 = (r10 + r11) * 31;
        if (this.isPopupWindowDetectEnabled == true) goto L31;
        r1 = 1237;
    L31:
        return r12 + r1;
    L25:
        r11 = 1237;
        goto L26
    L21:
        r9 = 1237;
        goto L22
    L17:
        r7 = 1237;
        goto L18
    L13:
        r5 = 1237;
        goto L14
    L9:
        r3 = 1237;
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public String toString() {
        return "WindowFreezeMonitorConfig(isMonitorEnabled=" + this.isMonitorEnabled + ", inValidTouchThreshold=" + this.inValidTouchThreshold + ", inValidWindowWidth=" + this.inValidWindowWidth + ", inValidWindowHeight=" + this.inValidWindowHeight + ", isVisibleDetectEnabled=" + this.isVisibleDetectEnabled + ", isElementCountDetectEnabled=" + this.isElementCountDetectEnabled + ", isWindowWidthHeightDetectEnabled=" + this.isWindowWidthHeightDetectEnabled + ", isActivityDetectEnabled=" + this.isActivityDetectEnabled + ", isDialogDetectEnabled=" + this.isDialogDetectEnabled + ", isPopupWindowDetectEnabled=" + this.isPopupWindowDetectEnabled + ')';
    }

    public final int getInValidTouchThreshold() {
        return this.inValidTouchThreshold;
    }

    public final int getInValidWindowHeight() {
        return this.inValidWindowHeight;
    }

    public final int getInValidWindowWidth() {
        return this.inValidWindowWidth;
    }

    public final boolean isActivityDetectEnabled() {
        return this.isActivityDetectEnabled;
    }

    public final boolean isDialogDetectEnabled() {
        return this.isDialogDetectEnabled;
    }

    public final boolean isElementCountDetectEnabled() {
        return this.isElementCountDetectEnabled;
    }

    public final boolean isMonitorEnabled() {
        return this.isMonitorEnabled;
    }

    public final boolean isPopupWindowDetectEnabled() {
        return this.isPopupWindowDetectEnabled;
    }

    public final boolean isVisibleDetectEnabled() {
        return this.isVisibleDetectEnabled;
    }

    public final boolean isWindowWidthHeightDetectEnabled() {
        return this.isWindowWidthHeightDetectEnabled;
    }

    public final void setActivityDetectEnabled(boolean r1) {
        this.isActivityDetectEnabled = r1;
    }

    public WindowFreezeMonitorConfig(boolean r1, int r2, int r3, int r4, boolean r5, boolean r6, boolean r7, boolean r8, boolean r9, boolean r10) {
        this.isMonitorEnabled = r1;
        this.inValidTouchThreshold = r2;
        this.inValidWindowWidth = r3;
        this.inValidWindowHeight = r4;
        this.isVisibleDetectEnabled = r5;
        this.isElementCountDetectEnabled = r6;
        this.isWindowWidthHeightDetectEnabled = r7;
        this.isActivityDetectEnabled = r8;
        this.isDialogDetectEnabled = r9;
        this.isPopupWindowDetectEnabled = r10;
    }

    public /* synthetic */ WindowFreezeMonitorConfig(boolean r12, int r13, int r14, int r15, boolean r16, boolean r17, boolean r18, boolean r19, boolean r20, boolean r21, int r22, DefaultConstructorMarker r23) {
        boolean r2 = true;
        if ((r22 & 1) == 0) goto L5;
        boolean r1 = true;
    L7:
        if ((r22 & 2) == 0) goto L9;
        int r3 = 3;
    L10:
        int r5 = 5;
        if ((r22 & 4) == 0) goto L13;
        int r4 = 5;
    L15:
        if ((r22 & 8) != 0) goto L19;
        r5 = r15;
    L19:
        if ((r22 & 16) == 0) goto L21;
        boolean r6 = true;
    L23:
        if ((r22 & 32) == 0) goto L25;
        boolean r7 = true;
    L27:
        if ((r22 & 64) == 0) goto L29;
        boolean r8 = true;
    L31:
        if ((r22 & 128) == 0) goto L33;
        boolean r9 = true;
    L35:
        if ((r22 & 256) == 0) goto L37;
        boolean r10 = true;
    L39:
        if ((r22 & 512) != 0) goto L42;
        r2 = r21;
    L42:
        this(r1, r3, r4, r5, r6, r7, r8, r9, r10, r2);
        return;
    L37:
        r10 = r20;
        goto L39
    L33:
        r9 = r19;
        goto L35
    L29:
        r8 = r18;
        goto L31
    L25:
        r7 = r17;
        goto L27
    L21:
        r6 = r16;
        goto L23
    L13:
        r4 = r14;
        goto L15
    L9:
        r3 = r13;
        goto L10
    L5:
        r1 = r12;
        goto L7
    }
}
