package com.bytedance.android.livesdk.interactivity.api.entity;

import com.bytedance.android.live.base.model.message.j4;
import com.bytedance.android.livesdk.event.r;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class p implements j4 {
    public final String a;
    public final List<com.bytedance.android.livesdk.event.n> b;
    public final List<r> c;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof p) == false) goto L12;
        p r4 = (p) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        List<com.bytedance.android.livesdk.event.n> r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        List<r> r7 = this.c;
        if (r7 == null) goto L14;
        r1 = r7.hashCode();
    L14:
        return r6 + r1;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "SelfRichTextInfo(content=" + this.a + ", selfImageSendInfoList=" + this.b + ", selfMentionSendInfoList=" + this.c + ")";
    }

    public final boolean a() {
        return !this.b.isEmpty();
    }

    public p(String r2, List<com.bytedance.android.livesdk.event.n> r3, List<r> r4) {
        Intrinsics.checkNotNullParameter(r2, "content");
        Intrinsics.checkNotNullParameter(r3, "selfImageSendInfoList");
        Intrinsics.checkNotNullParameter(r4, "selfMentionSendInfoList");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
