package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.visibility.params;

import com.bytedance.lark.pb.im.v1.AIRecommendQuestionsType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public final int a;
    public final int b;
    public final long c;
    public final AIRecommendQuestionsType d;
    public final String e;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof a) == true) goto L8;
        return false;
    L8:
        a r9 = (a) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L18;
        return false;
    L18:
        if (this.d == r9.d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r9.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a * 31) + this.b) * 31;
        long r1 = this.c;
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        AIRecommendQuestionsType r3 = this.d;
        int r4 = 0;
        if (r3 != null) goto L5;
        int r5 = 0;
    L6:
        int r6 = (r2 + r5) * 31;
        String r7 = this.e;
        if (r7 == null) goto L11;
        r4 = r7.hashCode();
    L11:
        return r6 + r4;
    L5:
        r5 = r3.hashCode();
        goto L6
    }

    public final String toString() {
        return "UnreadSummaryVisibleInfo(startPos=" + this.a + ", endPos=" + this.b + ", queryId=" + this.c + ", aiRecommendType=" + this.d + ", anchorMessageId=" + this.e + ')';
    }

    public a(int r1, int r2, long r3, AIRecommendQuestionsType r5, String r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r5;
        this.e = r6;
    }
}
