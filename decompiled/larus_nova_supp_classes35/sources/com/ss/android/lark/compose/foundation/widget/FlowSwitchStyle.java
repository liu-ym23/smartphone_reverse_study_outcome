package com.ss.android.lark.compose.foundation.widget;

import androidx.compose.ui.unit.Dp;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001BA\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u000f\u0010\rR\u0016\u0010\u0005\u001a\u00020\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0010\u0010\rR\u0016\u0010\u0006\u001a\u00020\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0011\u0010\rR\u0016\u0010\u0007\u001a\u00020\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0012\u0010\rR\u0016\u0010\b\u001a\u00020\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0013\u0010\rR\u0016\u0010\t\u001a\u00020\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0014\u0010\rj\u0002\b\u0015j\u0002\b\u0016¨\u0006\u0017"}, d2 = {"Lcom/ss/android/lark/compose/foundation/widget/FlowSwitchStyle;", BuildConfig.FLAVOR, "trackWidth", "Landroidx/compose/ui/unit/Dp;", "trackHeight", "thumbSize", "thumbPadding", "trackRadius", "loadingIndicatorSize", "loadingIndicatorStrokeWidth", "<init>", "(Ljava/lang/String;IFFFFFFF)V", "getTrackWidth-D9Ej5fM$flow_ud_release", "()F", "F", "getTrackHeight-D9Ej5fM$flow_ud_release", "getThumbSize-D9Ej5fM$flow_ud_release", "getThumbPadding-D9Ej5fM$flow_ud_release", "getTrackRadius-D9Ej5fM$flow_ud_release", "getLoadingIndicatorSize-D9Ej5fM$flow_ud_release", "getLoadingIndicatorStrokeWidth-D9Ej5fM$flow_ud_release", "NORMAL", "SMALL", "flow-ud_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FlowSwitchStyle extends Enum<FlowSwitchStyle> {
    public static final FlowSwitchStyle NORMAL = null;
    public static final FlowSwitchStyle SMALL = null;
    public static final /* synthetic */ FlowSwitchStyle[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final float loadingIndicatorSize;
    private final float loadingIndicatorStrokeWidth;
    private final float thumbPadding;
    private final float thumbSize;
    private final float trackHeight;
    private final float trackRadius;
    private final float trackWidth;

    public static EnumEntries<FlowSwitchStyle> getEntries() {
        return b;
    }

    static {
        float r12 = 2;
        FlowSwitchStyle r10 = new FlowSwitchStyle("NORMAL", 0, Dp.constructor-impl(51), Dp.constructor-impl(31), Dp.constructor-impl(27), Dp.constructor-impl(r12), Dp.constructor-impl((float) 15.5d), Dp.constructor-impl(16), Dp.constructor-impl(r12));
        NORMAL = r10;
        FlowSwitchStyle r0 = new FlowSwitchStyle("SMALL", 1, Dp.constructor-impl(30), Dp.constructor-impl(18), Dp.constructor-impl(14), Dp.constructor-impl(r12), Dp.constructor-impl(9), Dp.constructor-impl(10), Dp.constructor-impl(1));
        SMALL = r0;
        FlowSwitchStyle[] r2 = {r10, r0};
        a = r2;
        b = EnumEntriesKt.enumEntries(r2);
    }

    public static FlowSwitchStyle[] values() {
        return (FlowSwitchStyle[]) a.clone();
    }

    /* JADX INFO: renamed from: getLoadingIndicatorSize-D9Ej5fM$flow_ud_release, reason: not valid java name */
    public final float m911getLoadingIndicatorSizeD9Ej5fM$flow_ud_release() {
        return this.loadingIndicatorSize;
    }

    /* JADX INFO: renamed from: getLoadingIndicatorStrokeWidth-D9Ej5fM$flow_ud_release, reason: not valid java name */
    public final float m912getLoadingIndicatorStrokeWidthD9Ej5fM$flow_ud_release() {
        return this.loadingIndicatorStrokeWidth;
    }

    /* JADX INFO: renamed from: getThumbPadding-D9Ej5fM$flow_ud_release, reason: not valid java name */
    public final float m913getThumbPaddingD9Ej5fM$flow_ud_release() {
        return this.thumbPadding;
    }

    /* JADX INFO: renamed from: getThumbSize-D9Ej5fM$flow_ud_release, reason: not valid java name */
    public final float m914getThumbSizeD9Ej5fM$flow_ud_release() {
        return this.thumbSize;
    }

    /* JADX INFO: renamed from: getTrackHeight-D9Ej5fM$flow_ud_release, reason: not valid java name */
    public final float m915getTrackHeightD9Ej5fM$flow_ud_release() {
        return this.trackHeight;
    }

    /* JADX INFO: renamed from: getTrackRadius-D9Ej5fM$flow_ud_release, reason: not valid java name */
    public final float m916getTrackRadiusD9Ej5fM$flow_ud_release() {
        return this.trackRadius;
    }

    /* JADX INFO: renamed from: getTrackWidth-D9Ej5fM$flow_ud_release, reason: not valid java name */
    public final float m917getTrackWidthD9Ej5fM$flow_ud_release() {
        return this.trackWidth;
    }

    public static FlowSwitchStyle valueOf(String r1) {
        return (FlowSwitchStyle) r27.a.a(FlowSwitchStyle.class, r1);
    }

    public FlowSwitchStyle(String r1, int r2, float r3, float r4, float r5, float r6, float r7, float r8, float r9) {
        super(r1, r2);
        this.trackWidth = r3;
        this.trackHeight = r4;
        this.thumbSize = r5;
        this.thumbPadding = r6;
        this.trackRadius = r7;
        this.loadingIndicatorSize = r8;
        this.loadingIndicatorStrokeWidth = r9;
    }
}
