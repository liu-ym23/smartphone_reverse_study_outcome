package com.ss.android.lark.chat.cot.detail.widget;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b {
    public static final b c = null;
    public final String a;
    public final List<c> b;

    public static final class a {
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r6 = (b) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public final String toString() {
        return "FoldButtonConfig(text=" + this.a + ", icons=" + this.b + ')';
    }

    static {
        c = new b(BuildConfig.FLAVOR, CollectionsKt.emptyList());
    }

    public b(String r2, List<c> r3) {
        Intrinsics.checkNotNullParameter(r2, "text");
        Intrinsics.checkNotNullParameter(r3, "icons");
        this.a = r2;
        this.b = r3;
    }
}
