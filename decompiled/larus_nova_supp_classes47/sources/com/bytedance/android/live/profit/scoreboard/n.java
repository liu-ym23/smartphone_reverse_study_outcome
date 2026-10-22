package com.bytedance.android.live.profit.scoreboard;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/live/profit/scoreboard/n;", "", "", "index", "I", "getIndex", "()I", "", "name", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "description", "getDescription", "", "Lcom/bytedance/android/live/profit/scoreboard/g;", "giftChoices", "Ljava/util/List;", "getGiftChoices", "()Ljava/util/List;", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class n {

    @SerializedName("description")
    private final String description;

    @SerializedName("gift_choices")
    private final List<g> giftChoices;

    @SerializedName("index")
    private final int index;

    @SerializedName("name")
    private final String name;

    public n() {
        this(0);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof n) == false) goto L14;
        n r4 = (n) r3;
        if (this.index == r4.index) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.name, r4.name) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.description, r4.description) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.giftChoices, r4.giftChoices) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        int r0 = this.index * 31;
        String r1 = this.name;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.hashCode();
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.description;
        if (r5 == null) goto L9;
        int r6 = r5.hashCode();
    L10:
        int r7 = (r4 + r6) * 31;
        List<g> r8 = this.giftChoices;
        if (r8 == null) goto L14;
        r2 = r8.hashCode();
    L14:
        return r7 + r2;
    L9:
        r6 = 0;
        goto L10
    L5:
        r3 = 0;
        goto L6
    }

    public final String toString() {
        return "Rule(index=" + this.index + ", name=" + this.name + ", description=" + this.description + ", giftChoices=" + this.giftChoices + ")";
    }

    public /* synthetic */ n(int r3) {
        this(0, "", "", CollectionsKt.emptyList());
    }

    public n(int r2, String r3, String r4, List<g> r5) {
        Intrinsics.checkNotNullParameter(r3, "name");
        Intrinsics.checkNotNullParameter(r4, "description");
        Intrinsics.checkNotNullParameter(r5, "giftChoices");
        this.index = r2;
        this.name = r3;
        this.description = r4;
        this.giftChoices = r5;
    }
}
