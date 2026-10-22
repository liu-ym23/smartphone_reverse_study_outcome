package com.bytedance.android.livesdk.config;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/config/LiveAnchorOneOffKeys;", "", "dot_preview_used", "", "dot_in_room_used", "popup_in_room_used", "(ZZZ)V", "getDot_in_room_used", "()Z", "getDot_preview_used", "getPopup_in_room_used", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveAnchorOneOffKeys {
    private final boolean dot_in_room_used;
    private final boolean dot_preview_used;
    private final boolean popup_in_room_used;

    public LiveAnchorOneOffKeys() {
        this(false, false, false, 7, null);
    }

    public static /* synthetic */ LiveAnchorOneOffKeys copy$default(LiveAnchorOneOffKeys r0, boolean r1, boolean r2, boolean r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.dot_preview_used;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.dot_in_room_used;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.popup_in_room_used;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final boolean component1() {
        return this.dot_preview_used;
    }

    public final boolean component2() {
        return this.dot_in_room_used;
    }

    public final boolean component3() {
        return this.popup_in_room_used;
    }

    public final LiveAnchorOneOffKeys copy(boolean r2, boolean r3, boolean r4) {
        return new LiveAnchorOneOffKeys(r2, r3, r4);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof LiveAnchorOneOffKeys) == false) goto L12;
        LiveAnchorOneOffKeys r4 = (LiveAnchorOneOffKeys) r3;
        if (this.dot_preview_used == r4.dot_preview_used) goto L8;
        return false;
    L8:
        if (this.dot_in_room_used == r4.dot_in_room_used) goto L10;
        return false;
    L10:
        if (this.popup_in_room_used == r4.popup_in_room_used) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    public int hashCode() {
        boolean r0 = this.dot_preview_used;
        ?? r1 = 1;
        ?? r2 = r0;
        if (r0 == false) goto L5;
        r2 = 1;
    L5:
        int r3 = r2 * 31;
        boolean r4 = this.dot_in_room_used;
        ?? r5 = r4;
        if (r4 == false) goto L8;
        r5 = 1;
    L8:
        int r6 = (r3 + r5) * 31;
        boolean r7 = this.popup_in_room_used;
        if (r7 == true) goto L13;
        r1 = r7;
    L13:
        return r6 + r1;
    }

    public String toString() {
        return "LiveAnchorOneOffKeys(dot_preview_used=" + this.dot_preview_used + ", dot_in_room_used=" + this.dot_in_room_used + ", popup_in_room_used=" + this.popup_in_room_used + ")";
    }

    public final boolean getDot_in_room_used() {
        return this.dot_in_room_used;
    }

    public final boolean getDot_preview_used() {
        return this.dot_preview_used;
    }

    public final boolean getPopup_in_room_used() {
        return this.popup_in_room_used;
    }

    public LiveAnchorOneOffKeys(boolean r1, boolean r2, boolean r3) {
        this.dot_preview_used = r1;
        this.dot_in_room_used = r2;
        this.popup_in_room_used = r3;
    }

    public /* synthetic */ LiveAnchorOneOffKeys(boolean r2, boolean r3, boolean r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = false;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = false;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = false;
    L11:
        this(r2, r3, r4);
    }
}
