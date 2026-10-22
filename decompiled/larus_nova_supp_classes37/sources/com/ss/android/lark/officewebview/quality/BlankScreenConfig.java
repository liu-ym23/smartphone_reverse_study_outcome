package com.ss.android.lark.officewebview.quality;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b6\b\u0087\b\u0018\u00002\u00020\u0001B\u008d\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\r\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0012¢\u0006\u0004\b\u0015\u0010\u0016J\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\u0003HÆ\u0003J\t\u0010;\u001a\u00020\u0006HÆ\u0003J\t\u0010<\u001a\u00020\u0006HÆ\u0003J\t\u0010=\u001a\u00020\tHÆ\u0003J\t\u0010>\u001a\u00020\u0003HÆ\u0003J\t\u0010?\u001a\u00020\u0003HÆ\u0003J\t\u0010@\u001a\u00020\rHÆ\u0003J\t\u0010A\u001a\u00020\u0003HÆ\u0003J\t\u0010B\u001a\u00020\rHÆ\u0003J\t\u0010C\u001a\u00020\u0003HÆ\u0003J\u0017\u0010D\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0012HÆ\u0003J\u008f\u0001\u0010E\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u00032\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0012HÆ\u0001J\u0013\u0010F\u001a\u00020\u00032\b\u0010G\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010H\u001a\u00020\rHÖ\u0001J\t\u0010I\u001a\u00020\u0013HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0018\"\u0004\b\u001c\u0010\u001aR\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001e\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001e\"\u0004\b\"\u0010 R\u001e\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001e\u0010\n\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0018\"\u0004\b(\u0010\u001aR\u001e\u0010\u000b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0018\"\u0004\b*\u0010\u001aR\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001e\u0010\u000e\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0018\"\u0004\b0\u0010\u001aR\u001e\u0010\u000f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010,\"\u0004\b2\u0010.R\u001e\u0010\u0010\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0018\"\u0004\b4\u0010\u001aR,\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108¨\u0006J"}, d2 = {"Lcom/ss/android/lark/officewebview/quality/BlankScreenConfig;", "", "enableDetection", "", "enableDetectionWhenAppear", "minCheckInterval", "", "minCheckIntervalWhenAppear", "blankThreshold", "", "replaceWebview", "dropOnFastEntry", "checkEnterTimeWindow", "", "enableNearBlankPixelNormalize", "nearBlankPixelColorThreshold", "enablePixelCopyBlankCapture", "pixelCopyCropRectByBiz", "", "", "Lcom/ss/android/lark/officewebview/quality/PixelCopyCropRectConfig;", "<init>", "(ZZJJFZZIZIZLjava/util/Map;)V", "getEnableDetection", "()Z", "setEnableDetection", "(Z)V", "getEnableDetectionWhenAppear", "setEnableDetectionWhenAppear", "getMinCheckInterval", "()J", "setMinCheckInterval", "(J)V", "getMinCheckIntervalWhenAppear", "setMinCheckIntervalWhenAppear", "getBlankThreshold", "()F", "setBlankThreshold", "(F)V", "getReplaceWebview", "setReplaceWebview", "getDropOnFastEntry", "setDropOnFastEntry", "getCheckEnterTimeWindow", "()I", "setCheckEnterTimeWindow", "(I)V", "getEnableNearBlankPixelNormalize", "setEnableNearBlankPixelNormalize", "getNearBlankPixelColorThreshold", "setNearBlankPixelColorThreshold", "getEnablePixelCopyBlankCapture", "setEnablePixelCopyBlankCapture", "getPixelCopyCropRectByBiz", "()Ljava/util/Map;", "setPixelCopyCropRectByBiz", "(Ljava/util/Map;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "equals", "other", "hashCode", "toString", "webview_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class BlankScreenConfig {

    @SerializedName("min_blank_pixel_rate")
    private float blankThreshold;

    @SerializedName("check_enter_time_window")
    private int checkEnterTimeWindow;

    @SerializedName("dispose_by_enter_frequency")
    private boolean dropOnFastEntry;

    @SerializedName("enable_snapshot_detection")
    private boolean enableDetection;

    @SerializedName("enable_detection_when_appear")
    private boolean enableDetectionWhenAppear;

    @SerializedName("enable_near_blank_pixel_normalize")
    private boolean enableNearBlankPixelNormalize;

    @SerializedName("enable_pixel_copy_blank_capture")
    private boolean enablePixelCopyBlankCapture;

    @SerializedName("minimum_check_time_interval")
    private long minCheckInterval;

    @SerializedName("minimum_check_time_interval_when_appear")
    private long minCheckIntervalWhenAppear;

    @SerializedName("near_blank_pixel_color_threshold")
    private int nearBlankPixelColorThreshold;

    @SerializedName("pixel_copy_crop_rect_by_biz")
    private Map<String, PixelCopyCropRectConfig> pixelCopyCropRectByBiz;

    @SerializedName("replace_webview_when_display")
    private boolean replaceWebview;

    public BlankScreenConfig() {
        this(false, false, 0, 0, 0.0f, false, false, 0, false, 0, false, null, 4095, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BlankScreenConfig copy$default(BlankScreenConfig r15, boolean r16, boolean r17, long r18, long r20, float r22, boolean r23, boolean r24, int r25, boolean r26, int r27, boolean r28, Map r29, int r30, Object r31) {
        if ((r30 & 1) == 0) goto L5;
        boolean r2 = r15.enableDetection;
    L7:
        if ((r30 & 2) == 0) goto L9;
        boolean r3 = r15.enableDetectionWhenAppear;
    L11:
        if ((r30 & 4) == 0) goto L13;
        long r4 = r15.minCheckInterval;
    L15:
        if ((r30 & 8) == 0) goto L17;
        long r6 = r15.minCheckIntervalWhenAppear;
    L19:
        if ((r30 & 16) == 0) goto L21;
        float r8 = r15.blankThreshold;
    L23:
        if ((r30 & 32) == 0) goto L25;
        boolean r9 = r15.replaceWebview;
    L27:
        if ((r30 & 64) == 0) goto L29;
        boolean r10 = r15.dropOnFastEntry;
    L31:
        if ((r30 & 128) == 0) goto L33;
        int r11 = r15.checkEnterTimeWindow;
    L35:
        if ((r30 & 256) == 0) goto L37;
        boolean r12 = r15.enableNearBlankPixelNormalize;
    L39:
        if ((r30 & 512) == 0) goto L41;
        int r13 = r15.nearBlankPixelColorThreshold;
    L43:
        if ((r30 & 1024) == 0) goto L45;
        boolean r14 = r15.enablePixelCopyBlankCapture;
    L47:
        if ((r30 & 2048) == 0) goto L49;
        Map r1 = r15.pixelCopyCropRectByBiz;
    L51:
        return r15.copy(r2, r3, r4, r6, r8, r9, r10, r11, r12, r13, r14, r1);
    L49:
        r1 = r29;
        goto L51
    L45:
        r14 = r28;
        goto L47
    L41:
        r13 = r27;
        goto L43
    L37:
        r12 = r26;
        goto L39
    L33:
        r11 = r25;
        goto L35
    L29:
        r10 = r24;
        goto L31
    L25:
        r9 = r23;
        goto L27
    L21:
        r8 = r22;
        goto L23
    L17:
        r6 = r20;
        goto L19
    L13:
        r4 = r18;
        goto L15
    L9:
        r3 = r17;
        goto L11
    L5:
        r2 = r16;
        goto L7
    }

    public final boolean component1() {
        return this.enableDetection;
    }

    public final int component10() {
        return this.nearBlankPixelColorThreshold;
    }

    public final boolean component11() {
        return this.enablePixelCopyBlankCapture;
    }

    public final Map<String, PixelCopyCropRectConfig> component12() {
        return this.pixelCopyCropRectByBiz;
    }

    public final boolean component2() {
        return this.enableDetectionWhenAppear;
    }

    public final long component3() {
        return this.minCheckInterval;
    }

    public final long component4() {
        return this.minCheckIntervalWhenAppear;
    }

    public final float component5() {
        return this.blankThreshold;
    }

    public final boolean component6() {
        return this.replaceWebview;
    }

    public final boolean component7() {
        return this.dropOnFastEntry;
    }

    public final int component8() {
        return this.checkEnterTimeWindow;
    }

    public final boolean component9() {
        return this.enableNearBlankPixelNormalize;
    }

    public final BlankScreenConfig copy(boolean r17, boolean r18, long r19, long r21, float r23, boolean r24, boolean r25, int r26, boolean r27, int r28, boolean r29, Map<String, PixelCopyCropRectConfig> r30) {
        return new BlankScreenConfig(r17, r18, r19, r21, r23, r24, r25, r26, r27, r28, r29, r30);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof BlankScreenConfig) == true) goto L8;
        return false;
    L8:
        BlankScreenConfig r9 = (BlankScreenConfig) r8;
        if (this.enableDetection == r9.enableDetection) goto L12;
        return false;
    L12:
        if (this.enableDetectionWhenAppear == r9.enableDetectionWhenAppear) goto L15;
        return false;
    L15:
        if (this.minCheckInterval == r9.minCheckInterval) goto L18;
        return false;
    L18:
        if (this.minCheckIntervalWhenAppear == r9.minCheckIntervalWhenAppear) goto L21;
        return false;
    L21:
        if (Float.compare(this.blankThreshold, r9.blankThreshold) == 0) goto L24;
        return false;
    L24:
        if (this.replaceWebview == r9.replaceWebview) goto L27;
        return false;
    L27:
        if (this.dropOnFastEntry == r9.dropOnFastEntry) goto L30;
        return false;
    L30:
        if (this.checkEnterTimeWindow == r9.checkEnterTimeWindow) goto L33;
        return false;
    L33:
        if (this.enableNearBlankPixelNormalize == r9.enableNearBlankPixelNormalize) goto L36;
        return false;
    L36:
        if (this.nearBlankPixelColorThreshold == r9.nearBlankPixelColorThreshold) goto L39;
        return false;
    L39:
        if (this.enablePixelCopyBlankCapture == r9.enablePixelCopyBlankCapture) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.pixelCopyCropRectByBiz, r9.pixelCopyCropRectByBiz) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public int hashCode() {
        int r1 = 1231;
        if (this.enableDetection == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        if (this.enableDetectionWhenAppear == false) goto L9;
        int r3 = 1231;
    L10:
        int r4 = (r2 + r3) * 31;
        long r5 = this.minCheckInterval;
        int r6 = (r4 + ((int) (r5 ^ (r5 >>> 32)))) * 31;
        long r7 = this.minCheckIntervalWhenAppear;
        int r8 = (((r6 + ((int) (r7 ^ (r7 >>> 32)))) * 31) + Float.floatToIntBits(this.blankThreshold)) * 31;
        if (this.replaceWebview == false) goto L13;
        int r9 = 1231;
    L14:
        int r10 = (r8 + r9) * 31;
        if (this.dropOnFastEntry == false) goto L17;
        int r11 = 1231;
    L18:
        int r12 = (((r10 + r11) * 31) + this.checkEnterTimeWindow) * 31;
        if (this.enableNearBlankPixelNormalize == false) goto L21;
        int r13 = 1231;
    L22:
        int r14 = (((r12 + r13) * 31) + this.nearBlankPixelColorThreshold) * 31;
        if (this.enablePixelCopyBlankCapture == true) goto L26;
        r1 = 1237;
    L26:
        int r15 = (r14 + r1) * 31;
        Map<String, PixelCopyCropRectConfig> r16 = this.pixelCopyCropRectByBiz;
        if (r16 != null) goto L29;
        int r17 = 0;
    L31:
        return r15 + r17;
    L29:
        r17 = r16.hashCode();
        goto L31
    L21:
        r13 = 1237;
        goto L22
    L17:
        r11 = 1237;
        goto L18
    L13:
        r9 = 1237;
        goto L14
    L9:
        r3 = 1237;
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public String toString() {
        return "BlankScreenConfig(enableDetection=" + this.enableDetection + ", enableDetectionWhenAppear=" + this.enableDetectionWhenAppear + ", minCheckInterval=" + this.minCheckInterval + ", minCheckIntervalWhenAppear=" + this.minCheckIntervalWhenAppear + ", blankThreshold=" + this.blankThreshold + ", replaceWebview=" + this.replaceWebview + ", dropOnFastEntry=" + this.dropOnFastEntry + ", checkEnterTimeWindow=" + this.checkEnterTimeWindow + ", enableNearBlankPixelNormalize=" + this.enableNearBlankPixelNormalize + ", nearBlankPixelColorThreshold=" + this.nearBlankPixelColorThreshold + ", enablePixelCopyBlankCapture=" + this.enablePixelCopyBlankCapture + ", pixelCopyCropRectByBiz=" + this.pixelCopyCropRectByBiz + ')';
    }

    public final float getBlankThreshold() {
        return this.blankThreshold;
    }

    public final int getCheckEnterTimeWindow() {
        return this.checkEnterTimeWindow;
    }

    public final boolean getDropOnFastEntry() {
        return this.dropOnFastEntry;
    }

    public final boolean getEnableDetection() {
        return this.enableDetection;
    }

    public final boolean getEnableDetectionWhenAppear() {
        return this.enableDetectionWhenAppear;
    }

    public final boolean getEnableNearBlankPixelNormalize() {
        return this.enableNearBlankPixelNormalize;
    }

    public final boolean getEnablePixelCopyBlankCapture() {
        return this.enablePixelCopyBlankCapture;
    }

    public final long getMinCheckInterval() {
        return this.minCheckInterval;
    }

    public final long getMinCheckIntervalWhenAppear() {
        return this.minCheckIntervalWhenAppear;
    }

    public final int getNearBlankPixelColorThreshold() {
        return this.nearBlankPixelColorThreshold;
    }

    public final Map<String, PixelCopyCropRectConfig> getPixelCopyCropRectByBiz() {
        return this.pixelCopyCropRectByBiz;
    }

    public final boolean getReplaceWebview() {
        return this.replaceWebview;
    }

    public final void setBlankThreshold(float r1) {
        this.blankThreshold = r1;
    }

    public final void setCheckEnterTimeWindow(int r1) {
        this.checkEnterTimeWindow = r1;
    }

    public final void setDropOnFastEntry(boolean r1) {
        this.dropOnFastEntry = r1;
    }

    public final void setEnableDetection(boolean r1) {
        this.enableDetection = r1;
    }

    public final void setEnableDetectionWhenAppear(boolean r1) {
        this.enableDetectionWhenAppear = r1;
    }

    public final void setEnableNearBlankPixelNormalize(boolean r1) {
        this.enableNearBlankPixelNormalize = r1;
    }

    public final void setEnablePixelCopyBlankCapture(boolean r1) {
        this.enablePixelCopyBlankCapture = r1;
    }

    public final void setMinCheckInterval(long r1) {
        this.minCheckInterval = r1;
    }

    public final void setMinCheckIntervalWhenAppear(long r1) {
        this.minCheckIntervalWhenAppear = r1;
    }

    public final void setNearBlankPixelColorThreshold(int r1) {
        this.nearBlankPixelColorThreshold = r1;
    }

    public final void setPixelCopyCropRectByBiz(Map<String, PixelCopyCropRectConfig> r1) {
        this.pixelCopyCropRectByBiz = r1;
    }

    public final void setReplaceWebview(boolean r1) {
        this.replaceWebview = r1;
    }

    public BlankScreenConfig(boolean r1, boolean r2, long r3, long r5, float r7, boolean r8, boolean r9, int r10, boolean r11, int r12, boolean r13, Map<String, PixelCopyCropRectConfig> r14) {
        this.enableDetection = r1;
        this.enableDetectionWhenAppear = r2;
        this.minCheckInterval = r3;
        this.minCheckIntervalWhenAppear = r5;
        this.blankThreshold = r7;
        this.replaceWebview = r8;
        this.dropOnFastEntry = r9;
        this.checkEnterTimeWindow = r10;
        this.enableNearBlankPixelNormalize = r11;
        this.nearBlankPixelColorThreshold = r12;
        this.enablePixelCopyBlankCapture = r13;
        this.pixelCopyCropRectByBiz = r14;
    }

    public /* synthetic */ BlankScreenConfig(boolean r16, boolean r17, long r18, long r20, float r22, boolean r23, boolean r24, int r25, boolean r26, int r27, boolean r28, Map r29, int r30, DefaultConstructorMarker r31) {
        boolean r2 = false;
        if ((r30 & 1) == 0) goto L5;
        boolean r1 = false;
    L7:
        if ((r30 & 2) == 0) goto L9;
        boolean r3 = true;
    L11:
        if ((r30 & 4) == 0) goto L13;
        long r4 = 2;
    L15:
        if ((r30 & 8) == 0) goto L17;
        long r6 = 3;
    L19:
        if ((r30 & 16) == 0) goto L21;
        float r8 = 0.99f;
    L23:
        if ((r30 & 32) == 0) goto L25;
        boolean r9 = false;
    L27:
        if ((r30 & 64) == 0) goto L29;
        boolean r10 = false;
    L31:
        if ((r30 & 128) == 0) goto L33;
        int r11 = 30;
    L35:
        if ((r30 & 256) == 0) goto L37;
        boolean r12 = false;
    L39:
        if ((r30 & 512) == 0) goto L41;
        int r13 = 15;
    L43:
        if ((r30 & 1024) != 0) goto L47;
        r2 = r28;
    L47:
        if ((r30 & 2048) == 0) goto L49;
        Map r0 = null;
    L50:
        this(r1, r3, r4, r6, r8, r9, r10, r11, r12, r13, r2, r0);
        return;
    L49:
        r0 = r29;
        goto L50
    L41:
        r13 = r27;
        goto L43
    L37:
        r12 = r26;
        goto L39
    L33:
        r11 = r25;
        goto L35
    L29:
        r10 = r24;
        goto L31
    L25:
        r9 = r23;
        goto L27
    L21:
        r8 = r22;
        goto L23
    L17:
        r6 = r20;
        goto L19
    L13:
        r4 = r18;
        goto L15
    L9:
        r3 = r17;
        goto L11
    L5:
        r1 = r16;
        goto L7
    }
}
