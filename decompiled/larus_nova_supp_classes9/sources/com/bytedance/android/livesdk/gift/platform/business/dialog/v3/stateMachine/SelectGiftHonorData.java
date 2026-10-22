package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/SelectGiftHonorData;", BuildConfig.FLAVOR, "selectedText", BuildConfig.FLAVOR, "showScore", BuildConfig.FLAVOR, "(Ljava/lang/String;J)V", "getSelectedText", "()Ljava/lang/String;", "getShowScore", "()J", "component1", "component2", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", BuildConfig.FLAVOR, "toString", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SelectGiftHonorData {
    private final String selectedText;
    private final long showScore;

    public SelectGiftHonorData() {
        this(null, 0, 3, null);
    }

    public static /* synthetic */ SelectGiftHonorData copy$default(SelectGiftHonorData r0, String r1, long r2, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.selectedText;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.showScore;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.selectedText;
    }

    public final long component2() {
        return this.showScore;
    }

    public final SelectGiftHonorData copy(String r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "selectedText");
        return new SelectGiftHonorData(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L4;
        return true;
    L4:
        if ((r5 instanceof SelectGiftHonorData) == false) goto L10;
        SelectGiftHonorData r6 = (SelectGiftHonorData) r5;
        if (Intrinsics.areEqual(this.selectedText, r6.selectedText) == true) goto L8;
        return false;
    L8:
        if (this.showScore == r6.showScore) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        String r0 = this.selectedText;
        if (r0 == null) goto L5;
        int r1 = r0.hashCode();
    L6:
        long r2 = this.showScore;
        return (r1 * 31) + ((int) (r2 ^ (r2 >>> 32)));
    L5:
        r1 = 0;
        goto L6
    }

    public String toString() {
        return "SelectGiftHonorData(selectedText=" + this.selectedText + ", showScore=" + this.showScore + ")";
    }

    public final String getSelectedText() {
        return this.selectedText;
    }

    public final long getShowScore() {
        return this.showScore;
    }

    public SelectGiftHonorData(String r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "selectedText");
        this.selectedText = r2;
        this.showScore = r3;
    }

    public /* synthetic */ SelectGiftHonorData(String r1, long r2, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = BuildConfig.FLAVOR;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r2 = 0;
    L8:
        this(r1, r2);
    }
}
