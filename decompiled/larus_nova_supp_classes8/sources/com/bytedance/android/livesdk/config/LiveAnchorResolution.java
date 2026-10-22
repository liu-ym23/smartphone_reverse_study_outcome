package com.bytedance.android.livesdk.config;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdk/config/LiveAnchorResolution;", "", "live_anchor_clarity_open", "", "live_anchor_guide_clarity_open", "live_anchor_clarity_frozen_duration", "", "live_anchor_clarity_alert_duration", "live_anchor_support_media", "(ZZIIZ)V", "getLive_anchor_clarity_alert_duration", "()I", "getLive_anchor_clarity_frozen_duration", "getLive_anchor_clarity_open", "()Z", "getLive_anchor_guide_clarity_open", "getLive_anchor_support_media", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveAnchorResolution {
    private final int live_anchor_clarity_alert_duration;
    private final int live_anchor_clarity_frozen_duration;
    private final boolean live_anchor_clarity_open;
    private final boolean live_anchor_guide_clarity_open;
    private final boolean live_anchor_support_media;

    public LiveAnchorResolution() {
        this(false, false, 0, 0, false, 31, null);
    }

    public static /* synthetic */ LiveAnchorResolution copy$default(LiveAnchorResolution r3, boolean r4, boolean r5, int r6, int r7, boolean r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.live_anchor_clarity_open;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.live_anchor_guide_clarity_open;
    L8:
        boolean r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.live_anchor_clarity_frozen_duration;
    L11:
        int r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.live_anchor_clarity_alert_duration;
    L14:
        int r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.live_anchor_support_media;
    L17:
        boolean r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final boolean component1() {
        return this.live_anchor_clarity_open;
    }

    public final boolean component2() {
        return this.live_anchor_guide_clarity_open;
    }

    public final int component3() {
        return this.live_anchor_clarity_frozen_duration;
    }

    public final int component4() {
        return this.live_anchor_clarity_alert_duration;
    }

    public final boolean component5() {
        return this.live_anchor_support_media;
    }

    public final LiveAnchorResolution copy(boolean r8, boolean r9, int r10, int r11, boolean r12) {
        return new LiveAnchorResolution(r8, r9, r10, r11, r12);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof LiveAnchorResolution) == false) goto L16;
        LiveAnchorResolution r4 = (LiveAnchorResolution) r3;
        if (this.live_anchor_clarity_open == r4.live_anchor_clarity_open) goto L8;
        return false;
    L8:
        if (this.live_anchor_guide_clarity_open == r4.live_anchor_guide_clarity_open) goto L10;
        return false;
    L10:
        if (this.live_anchor_clarity_frozen_duration == r4.live_anchor_clarity_frozen_duration) goto L12;
        return false;
    L12:
        if (this.live_anchor_clarity_alert_duration == r4.live_anchor_clarity_alert_duration) goto L14;
        return false;
    L14:
        if (this.live_anchor_support_media == r4.live_anchor_support_media) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    public int hashCode() {
        boolean r0 = this.live_anchor_clarity_open;
        ?? r1 = 1;
        ?? r2 = r0;
        if (r0 == false) goto L5;
        r2 = 1;
    L5:
        int r3 = r2 * 31;
        boolean r4 = this.live_anchor_guide_clarity_open;
        ?? r5 = r4;
        if (r4 == false) goto L8;
        r5 = 1;
    L8:
        int r6 = (((((r3 + r5) * 31) + this.live_anchor_clarity_frozen_duration) * 31) + this.live_anchor_clarity_alert_duration) * 31;
        boolean r7 = this.live_anchor_support_media;
        if (r7 == true) goto L13;
        r1 = r7;
    L13:
        return r6 + r1;
    }

    public String toString() {
        return "LiveAnchorResolution(live_anchor_clarity_open=" + this.live_anchor_clarity_open + ", live_anchor_guide_clarity_open=" + this.live_anchor_guide_clarity_open + ", live_anchor_clarity_frozen_duration=" + this.live_anchor_clarity_frozen_duration + ", live_anchor_clarity_alert_duration=" + this.live_anchor_clarity_alert_duration + ", live_anchor_support_media=" + this.live_anchor_support_media + ")";
    }

    public final int getLive_anchor_clarity_alert_duration() {
        return this.live_anchor_clarity_alert_duration;
    }

    public final int getLive_anchor_clarity_frozen_duration() {
        return this.live_anchor_clarity_frozen_duration;
    }

    public final boolean getLive_anchor_clarity_open() {
        return this.live_anchor_clarity_open;
    }

    public final boolean getLive_anchor_guide_clarity_open() {
        return this.live_anchor_guide_clarity_open;
    }

    public final boolean getLive_anchor_support_media() {
        return this.live_anchor_support_media;
    }

    public LiveAnchorResolution(boolean r1, boolean r2, int r3, int r4, boolean r5) {
        this.live_anchor_clarity_open = r1;
        this.live_anchor_guide_clarity_open = r2;
        this.live_anchor_clarity_frozen_duration = r3;
        this.live_anchor_clarity_alert_duration = r4;
        this.live_anchor_support_media = r5;
    }

    public /* synthetic */ LiveAnchorResolution(boolean r5, boolean r6, int r7, int r8, boolean r9, int r10, DefaultConstructorMarker r11) {
        if ((r10 & 1) == 0) goto L5;
        boolean r12 = true;
    L7:
        if ((r10 & 2) == 0) goto L9;
        boolean r1 = true;
    L11:
        if ((r10 & 4) == 0) goto L13;
        int r2 = 15;
    L15:
        if ((r10 & 8) == 0) goto L17;
        int r3 = 5;
    L19:
        if ((r10 & 16) == 0) goto L21;
        boolean r13 = true;
    L22:
        this(r12, r1, r2, r3, r13);
        return;
    L21:
        r13 = r9;
        goto L22
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
        r12 = r5;
        goto L7
    }
}
