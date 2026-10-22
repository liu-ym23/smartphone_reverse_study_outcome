package com.ss.android.lark.chat.cot.detail;

import com.ss.android.lark.chat.entity.message.CotStatus;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class q {
    public static final q d = null;
    public final String a;
    public final List<k> b;
    public final CotStatus c;

    public static final class a {
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof q) == true) goto L8;
        return false;
    L8:
        q r6 = (q) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public final String toString() {
        return "CotDetailUiState(cotId=" + this.a + ", items=" + this.b + ", status=" + this.c + ')';
    }

    static {
        d = new q(BuildConfig.FLAVOR, CollectionsKt.emptyList(), CotStatus.NONE);
    }

    public q(String r2, List<k> r3, CotStatus r4) {
        Intrinsics.checkNotNullParameter(r2, "cotId");
        Intrinsics.checkNotNullParameter(r3, "items");
        Intrinsics.checkNotNullParameter(r4, "status");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
