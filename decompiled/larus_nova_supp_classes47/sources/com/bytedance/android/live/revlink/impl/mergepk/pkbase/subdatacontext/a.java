package com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext;

import com.bytedance.android.livesdk.link.model.n3;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u000e\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/subdatacontext/a;", "", "", "Laf2/b;", "scoreList", "Ljava/util/List;", "b", "()Ljava/util/List;", "Lcom/bytedance/android/livesdk/link/model/n3;", "breakthroughInfo", "Lcom/bytedance/android/livesdk/link/model/n3;", "a", "()Lcom/bytedance/android/livesdk/link/model/n3;", "", "source", "I", "c", "()I", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class a {

    @SerializedName("pve_data")
    private final n3 breakthroughInfo;

    @SerializedName("score_list")
    private final List<af2.b> scoreList;

    @SerializedName("source")
    private final int source;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof a) == false) goto L12;
        a r4 = (a) r3;
        if (Intrinsics.areEqual(this.scoreList, r4.scoreList) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.breakthroughInfo, r4.breakthroughInfo) == true) goto L10;
        return false;
    L10:
        if (this.source == r4.source) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        List<af2.b> r0 = this.scoreList;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        n3 r4 = this.breakthroughInfo;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return ((r3 + r1) * 31) + this.source;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "BattleScoreData(scoreList=" + this.scoreList + ", breakthroughInfo=" + this.breakthroughInfo + ", source=" + this.source + ")";
    }

    public final n3 a() {
        return this.breakthroughInfo;
    }

    public final List<af2.b> b() {
        return this.scoreList;
    }

    public final int c() {
        return this.source;
    }

    public a(List<? extends af2.b> r2, n3 r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "scoreList");
        this.scoreList = r2;
        this.breakthroughInfo = r3;
        this.source = r4;
    }
}
