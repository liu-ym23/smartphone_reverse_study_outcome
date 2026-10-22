package com.bytedance.android.live.profit.scoreboard;

import com.bytedance.android.live.profile.monitor.DataType;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/profit/scoreboard/m;", "", "", "index", "I", "getIndex", "()I", "", "roomId", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "score", "getScore", "", "creator", "Z", "a", "()Z", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class m {

    @SerializedName("creator")
    private final boolean creator;

    @SerializedName("index")
    private final int index;

    @SerializedName("room_id")
    private final String roomId;

    @SerializedName("score")
    private final String score;

    public m() {
        String r0 = null;
        this(r0, r0, 15);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof m) == false) goto L14;
        m r4 = (m) r3;
        if (this.index == r4.index) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.roomId, r4.roomId) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.score, r4.score) == true) goto L12;
        return false;
    L12:
        if (this.creator == r4.creator) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v8 */
    public final int hashCode() {
        int r0 = this.index * 31;
        String r1 = this.roomId;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.hashCode();
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.score;
        if (r5 == null) goto L9;
        r2 = r5.hashCode();
    L9:
        int r6 = (r4 + r2) * 31;
        boolean r7 = this.creator;
        ?? r8 = r7;
        if (r7 == false) goto L13;
        r8 = 1;
    L13:
        return r6 + r8;
    L5:
        r3 = 0;
        goto L6
    }

    public final String toString() {
        return "Point(index=" + this.index + ", roomId=" + this.roomId + ", score=" + this.score + ", creator=" + this.creator + ")";
    }

    public final boolean a() {
        return this.creator;
    }

    public final String b() {
        return this.roomId;
    }

    public /* synthetic */ m(String r2, String r3, int r4) {
        if ((r4 & 2) == 0) goto L6;
        r2 = "";
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = DataType.FALSE;
    L8:
        this(0, r2, r3, false);
    }

    public m(int r2, String r3, String r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r3, "roomId");
        Intrinsics.checkNotNullParameter(r4, "score");
        this.index = r2;
        this.roomId = r3;
        this.score = r4;
        this.creator = r5;
    }
}
