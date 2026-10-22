package com.bytedance.android.live.ktv.common.model.api;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/ktv/common/model/api/a0;", "", "", "Lcom/bytedance/android/live/ktv/common/model/api/u;", "hotWords", "Ljava/util/List;", "a", "()Ljava/util/List;", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class a0 implements vh7.h {

    @SerializedName("hots")
    protected List<u> hotWords;

    public final boolean equals(Object r2) {
        if (this != r2) goto L4;
        return true;
    L4:
        if ((r2 instanceof a0) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.hotWords, ((a0) r2).hotWords) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        List<u> r0 = this.hotWords;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public final String toString() {
        return "KtvSearchHotWordsResponse(hotWords=" + this.hotWords + ")";
    }

    public a0() {
        this.hotWords = new ArrayList();
    }

    public final List<u> a() {
        return this.hotWords;
    }

    public a0(am3.g r5) {
        this.hotWords = new ArrayList();
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L9;
        if (r2 != 1) goto L7;
        this.hotWords.add(new u(r5));
        goto L3
    L7:
        am3.h.e(r5);
        goto L3
    L9:
        r5.d(r0);
        if (this.hotWords.isEmpty() == false) goto L19;
        this.hotWords = new ArrayList();
        return;
    }
}
