package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001d\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\n¢\u0006\u0004\b%\u0010&J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0007\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010\u000b\u001a\u00020\nHÆ\u0003J=\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\u00062\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u0010\u001a\u00020\nHÆ\u0001J\t\u0010\u0012\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\u0015\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\f\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\r\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\r\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u000e\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0019\u0010\u000f\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001f\u001a\u0004\b \u0010!R\u0017\u0010\u0010\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\"\u001a\u0004\b#\u0010$¨\u0006'"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/RechargeViewParams;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "component1", BuildConfig.FLAVOR, "component2", BuildConfig.FLAVOR, "component3", "Lcom/bytedance/android/live/base/model/message/a5;", "component4", BuildConfig.FLAVOR, "component5", "text", "textColorRes", "textSize", "touchText", "enableAnchorPanelEntrance", "copy", "toString", "hashCode", "other", "equals", "Ljava/lang/String;", "getText", "()Ljava/lang/String;", "I", "getTextColorRes", "()I", "F", "getTextSize", "()F", "Lcom/bytedance/android/live/base/model/message/a5;", "getTouchText", "()Lcom/bytedance/android/live/base/model/message/a5;", "Z", "getEnableAnchorPanelEntrance", "()Z", "<init>", "(Ljava/lang/String;IFLcom/bytedance/android/live/base/model/message/a5;Z)V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RechargeViewParams {
    private final boolean enableAnchorPanelEntrance;
    private final String text;
    private final int textColorRes;
    private final float textSize;
    private final a5 touchText;

    public RechargeViewParams() {
        this(null, 0, 0.0f, null, false, 31, null);
    }

    public static /* synthetic */ RechargeViewParams copy$default(RechargeViewParams r3, String r4, int r5, float r6, a5 r7, boolean r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.text;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.textColorRes;
    L8:
        int r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.textSize;
    L11:
        float r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.touchText;
    L14:
        a5 r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.enableAnchorPanelEntrance;
    L17:
        String r13 = r4;
        return r3.copy(r13, r11, r0, r1, r8);
    }

    public final String component1() {
        return this.text;
    }

    public final int component2() {
        return this.textColorRes;
    }

    public final float component3() {
        return this.textSize;
    }

    public final a5 component4() {
        return this.touchText;
    }

    public final boolean component5() {
        return this.enableAnchorPanelEntrance;
    }

    public final RechargeViewParams copy(String r8, int r9, float r10, a5 r11, boolean r13) {
        Intrinsics.checkNotNullParameter(r8, "text");
        return new RechargeViewParams(r8, r9, r10, r11, r13);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof RechargeViewParams) == false) goto L16;
        RechargeViewParams r4 = (RechargeViewParams) r3;
        if (Intrinsics.areEqual(this.text, r4.text) == true) goto L8;
        return false;
    L8:
        if (this.textColorRes == r4.textColorRes) goto L10;
        return false;
    L10:
        if (Float.compare(this.textSize, r4.textSize) == 0) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.touchText, r4.touchText) == true) goto L14;
        return false;
    L14:
        if (this.enableAnchorPanelEntrance == r4.enableAnchorPanelEntrance) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        String r0 = this.text;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = ((((r2 * 31) + this.textColorRes) * 31) + Float.floatToIntBits(this.textSize)) * 31;
        a5 r4 = this.touchText;
        if (r4 == null) goto L9;
        r1 = r4.hashCode();
    L9:
        int r5 = (r3 + r1) * 31;
        boolean r6 = this.enableAnchorPanelEntrance;
        ?? r7 = r6;
        if (r6 == false) goto L13;
        r7 = 1;
    L13:
        return r5 + r7;
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "RechargeViewParams(text=" + this.text + ", textColorRes=" + this.textColorRes + ", textSize=" + this.textSize + ", touchText=" + this.touchText + ", enableAnchorPanelEntrance=" + this.enableAnchorPanelEntrance + ")";
    }

    public final boolean getEnableAnchorPanelEntrance() {
        return this.enableAnchorPanelEntrance;
    }

    public final String getText() {
        return this.text;
    }

    public final int getTextColorRes() {
        return this.textColorRes;
    }

    public final float getTextSize() {
        return this.textSize;
    }

    public final a5 getTouchText() {
        return this.touchText;
    }

    public RechargeViewParams(String r2, int r3, float r4, a5 r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r2, "text");
        this.text = r2;
        this.textColorRes = r3;
        this.textSize = r4;
        this.touchText = r5;
        this.enableAnchorPanelEntrance = r6;
    }

    public /* synthetic */ RechargeViewParams(String r4, int r5, float r6, a5 r7, boolean r8, int r9, DefaultConstructorMarker r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = BuildConfig.FLAVOR;
    L6:
        if ((r9 & 2) == 0) goto L8;
        int r11 = 2131107550;
    L10:
        if ((r9 & 4) == 0) goto L12;
        float r0 = 0.0f;
    L14:
        if ((r9 & 8) == 0) goto L16;
        r7 = null;
    L16:
        a5 r1 = r7;
        if ((r9 & 16) == 0) goto L19;
        boolean r2 = false;
    L20:
        this(r4, r11, r0, r1, r2);
        return;
    L19:
        r2 = r8;
        goto L20
    L12:
        r0 = r6;
        goto L14
    L8:
        r11 = r5;
        goto L10
    }
}
