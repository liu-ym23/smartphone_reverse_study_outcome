package com.bytedance.android.live.profile.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/profile/model/ActionExtra;", "", "inviteText", "", "sweepCount", "", "(Ljava/lang/String;I)V", "getInviteText", "()Ljava/lang/String;", "getSweepCount", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ActionExtra {

    @SerializedName("invite_text")
    private final String inviteText;

    @SerializedName("effect_show_count")
    private final int sweepCount;

    public ActionExtra() {
        String r2 = null;
        this(r2, 0, 3, r2);
    }

    public static /* synthetic */ ActionExtra copy$default(ActionExtra r0, String r1, int r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.inviteText;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.sweepCount;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.inviteText;
    }

    public final int component2() {
        return this.sweepCount;
    }

    public final ActionExtra copy(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "inviteText");
        return new ActionExtra(r2, r3);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof ActionExtra) == false) goto L10;
        ActionExtra r4 = (ActionExtra) r3;
        if (Intrinsics.areEqual(this.inviteText, r4.inviteText) == true) goto L8;
        return false;
    L8:
        if (this.sweepCount == r4.sweepCount) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        String r0 = this.inviteText;
        if (r0 == null) goto L5;
        int r1 = r0.hashCode();
    L7:
        return (r1 * 31) + this.sweepCount;
    L5:
        r1 = 0;
        goto L7
    }

    public String toString() {
        return "ActionExtra(inviteText=" + this.inviteText + ", sweepCount=" + this.sweepCount + ")";
    }

    public final String getInviteText() {
        return this.inviteText;
    }

    public final int getSweepCount() {
        return this.sweepCount;
    }

    public ActionExtra(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "inviteText");
        this.inviteText = r2;
        this.sweepCount = r3;
    }

    public /* synthetic */ ActionExtra(String r1, int r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = "";
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = 0;
    L8:
        this(r1, r2);
    }
}
