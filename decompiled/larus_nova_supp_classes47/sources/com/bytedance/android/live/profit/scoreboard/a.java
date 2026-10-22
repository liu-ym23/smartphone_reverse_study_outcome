package com.bytedance.android.live.profit.scoreboard;

import com.bytedance.badger.collect.impl.constants.Constants;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\r\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0005\u001a\u0004\b\u0013\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/live/profit/scoreboard/a;", "", "", "", Constants.Keys.duration, "Ljava/util/List;", "getDuration", "()Ljava/util/List;", "linkState", "I", "getLinkState", "()I", "", "other_room_id", "J", "getOther_room_id", "()J", "Lcom/bytedance/android/live/profit/scoreboard/n;", "rules", "getRules", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class a {

    @SerializedName("duration_choices")
    private final List<Integer> duration;

    @SerializedName("link_state")
    private final int linkState;

    @SerializedName("other_room_id")
    private final long other_room_id;

    @SerializedName("rules")
    private final List<n> rules;

    public a() {
        this(null, 0, null, 15);
    }

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof a) == false) goto L14;
        a r7 = (a) r6;
        if (Intrinsics.areEqual(this.duration, r7.duration) == true) goto L8;
        return false;
    L8:
        if (this.linkState == r7.linkState) goto L10;
        return false;
    L10:
        if (this.other_room_id == r7.other_room_id) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.rules, r7.rules) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        List<Integer> r0 = this.duration;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = ((r2 * 31) + this.linkState) * 31;
        long r4 = this.other_room_id;
        int r5 = (r3 + ((int) (r4 ^ (r4 >>> 32)))) * 31;
        List<n> r6 = this.rules;
        if (r6 == null) goto L10;
        r1 = r6.hashCode();
    L10:
        return r5 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "Config(duration=" + this.duration + ", linkState=" + this.linkState + ", other_room_id=" + this.other_room_id + ", rules=" + this.rules + ")";
    }

    public a(List r2, int r3, List r4, int r5) {
        if ((r5 & 1) == 0) goto L6;
        r2 = CollectionsKt.emptyList();
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = 1;
    L9:
        if ((r5 & 8) == 0) goto L11;
        r4 = CollectionsKt.emptyList();
    L11:
        Intrinsics.checkNotNullParameter(r2, Constants.Keys.duration);
        Intrinsics.checkNotNullParameter(r4, "rules");
        this.duration = r2;
        this.linkState = r3;
        this.other_room_id = 0;
        this.rules = r4;
    }
}
