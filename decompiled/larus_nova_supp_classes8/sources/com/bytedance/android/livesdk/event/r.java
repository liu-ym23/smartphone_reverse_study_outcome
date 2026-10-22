package com.bytedance.android.livesdk.event;

import com.bytedance.android.live.base.model.user.IBaseUser;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class r implements l {
    public final int a;
    public final String b;
    public final int c;
    public final int d;
    public final IBaseUser e;
    public final boolean f;

    public final String toString() {
        return "MentionSendInfo(type=" + getType() + ", value=" + this.b + ", start=" + this.c + ", length=" + this.d + ", user=" + this.e + ", isFromMentionList=" + this.f + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v8 */
    public final int hashCode() {
        int r0 = getType() * 31;
        String r1 = this.b;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.hashCode();
    L6:
        int r4 = (((((r0 + r3) * 31) + this.c) * 31) + this.d) * 31;
        IBaseUser r5 = this.e;
        if (r5 == null) goto L9;
        r2 = r5.hashCode();
    L9:
        int r6 = (r4 + r2) * 31;
        boolean r7 = this.f;
        ?? r8 = r7;
        if (r7 == false) goto L13;
        r8 = 1;
    L13:
        return r6 + r8;
    L5:
        r3 = 0;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.event.l
    public final int getLength() {
        return this.d;
    }

    @Override // com.bytedance.android.livesdk.event.l
    public final int getStart() {
        return this.c;
    }

    @Override // com.bytedance.android.livesdk.event.l
    public int getType() {
        return this.a;
    }

    @Override // com.bytedance.android.livesdk.event.l
    public final String getValue() {
        return this.b;
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof r) == false) goto L18;
        r r4 = (r) r3;
        if (getType() == r4.getType()) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (this.c == r4.c) goto L12;
        return false;
    L12:
        if (this.d == r4.d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r4.e) == true) goto L16;
        return false;
    L16:
        if (this.f == r4.f) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public r(int r2, String r3, int r4, int r5, IBaseUser r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r3, "value");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
