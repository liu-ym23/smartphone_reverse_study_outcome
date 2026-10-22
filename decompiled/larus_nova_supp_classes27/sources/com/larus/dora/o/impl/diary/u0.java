package com.larus.dora.o.impl.diary;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0013\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0003J.\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR \u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/larus/dora/o/impl/diary/ODiaryStyleListData;", "", "maxCount", "", "styleList", "", "Lcom/larus/dora/o/impl/diary/ODiaryStyleInfo;", "<init>", "(Ljava/lang/Integer;Ljava/util/List;)V", "getMaxCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getStyleList", "()Ljava/util/List;", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/util/List;)Lcom/larus/dora/o/impl/diary/ODiaryStyleListData;", "equals", "", "other", "hashCode", "toString", "", "dora_o_impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class u0 {

    @SerializedName("max_count")
    private final Integer maxCount;

    @SerializedName("style_list")
    private final List<t0> styleList;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof u0) == true) goto L8;
        return false;
    L8:
        u0 r6 = (u0) r5;
        if (Intrinsics.areEqual(this.maxCount, r6.maxCount) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.styleList, r6.styleList) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        Integer r0 = this.maxCount;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        List<t0> r4 = this.styleList;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "ODiaryStyleListData(maxCount=" + this.maxCount + ", styleList=" + this.styleList + ')';
    }

    public u0() {
        this.maxCount = 30;
        this.styleList = null;
    }

    public final Integer a() {
        return this.maxCount;
    }

    public final List<t0> b() {
        return this.styleList;
    }
}
