package c21;

import com.bytedance.android.live.revlink.impl.mergepk.params.LinkmicBizType;
import com.bytedance.android.live.revlink.impl.mergepk.params.ReplyType;
import com.bytedance.android.livesdk.link.model.ILinkMicBizInviteMessage;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h {
    public final int a;
    public final LinkmicBizType b;
    public final String c;
    public final ReplyType d;
    public final boolean e;
    public final boolean f;

    public h() {
        this(0, null, null, false, 63);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof h) == false) goto L18;
        h r4 = (h) r3;
        if (this.a == r4.a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r4.d) == true) goto L14;
        return false;
    L14:
        if (this.e == r4.e) goto L16;
        return false;
    L16:
        if (this.f == r4.f) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v8, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v4 */
    public final int hashCode() {
        int r0 = this.a * 31;
        LinkmicBizType r1 = this.b;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.hashCode();
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.c;
        if (r5 == null) goto L9;
        int r6 = r5.hashCode();
    L10:
        int r7 = (r4 + r6) * 31;
        ReplyType r8 = this.d;
        if (r8 == null) goto L13;
        r2 = r8.hashCode();
    L13:
        int r9 = (r7 + r2) * 31;
        boolean r10 = this.e;
        ?? r12 = 1;
        ?? r13 = r10;
        if (r10 == false) goto L16;
        r13 = 1;
    L16:
        int r14 = (r9 + r13) * 31;
        boolean r15 = this.f;
        if (r15 == true) goto L21;
        r12 = r15;
    L21:
        return r14 + r12;
    L9:
        r6 = 0;
        goto L10
    L5:
        r3 = 0;
        goto L6
    }

    public final String toString() {
        return "BizCommonParams(inviteType=" + this.a + ", bizType=" + this.b + ", gameAppId=" + this.c + ", replyStatus=" + this.d + ", limitedByStreamMixType=" + this.e + ", isOnceMore=" + this.f + ")";
    }

    public h(int r3, LinkmicBizType r4, String r5, boolean r6, int r7) {
        if ((r7 & 1) == 0) goto L6;
        r3 = ILinkMicBizInviteMessage.BizInviteType.BizInviteDefault.ordinal();
    L6:
        if ((r7 & 2) == 0) goto L9;
        r4 = LinkmicBizType.LinkmicBizTypeUnknown;
    L9:
        if ((r7 & 4) == 0) goto L12;
        r5 = "";
    L12:
        if ((r7 & 8) == 0) goto L14;
        ReplyType r0 = ReplyType.Undefined;
    L16:
        if ((r7 & 16) == 0) goto L18;
        r6 = false;
    L18:
        Intrinsics.checkNotNullParameter(r4, "bizType");
        Intrinsics.checkNotNullParameter(r5, "gameAppId");
        Intrinsics.checkNotNullParameter(r0, "replyStatus");
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r0;
        this.e = r6;
        this.f = false;
        return;
    L14:
        r0 = null;
        goto L16
    }
}
