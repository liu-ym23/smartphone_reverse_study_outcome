package com.bytedance.android.live.ktv.common.model.api;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0087\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/ktv/common/model/api/u;", "", "", "content", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "color", "getColor", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class u implements vh7.h {

    @SerializedName("color")
    protected String color;

    @SerializedName("content")
    protected String content;

    public u(String r3) {
        Intrinsics.checkNotNullParameter(r3, "content");
        Intrinsics.checkNotNullParameter("#80FFFFFF", "color");
        this.content = r3;
        this.color = "#80FFFFFF";
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof u) == false) goto L10;
        u r4 = (u) r3;
        if (Intrinsics.areEqual(this.content, r4.content) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.color, r4.color) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r0 = this.content;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.color;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "HotWord(content=" + this.content + ", color=" + this.color + ")";
    }

    public u() {
        this.content = "";
        this.color = "#161823";
    }

    public final String a() {
        return this.content;
    }

    public u(am3.g r5) {
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L12;
        if (r2 != 1) goto L8;
        this.content = am3.h.c(r5);
        goto L3
    L8:
        if (r2 != 2) goto L9;
        this.color = am3.h.c(r5);
        goto L3
    L9:
        am3.h.e(r5);
        goto L3
    L12:
        r5.d(r0);
        if (this.content != null) goto L16;
        this.content = "";
    L16:
        if (this.color != null) goto L28;
        this.color = "#161823";
        return;
    }
}
