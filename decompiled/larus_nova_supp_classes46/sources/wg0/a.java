package wg0;

import com.bytedance.android.livesdk.chatroom.model.interact.EnlargeGuestInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public final boolean a;
    public final EnlargeGuestInfo.EnlargeGuestType b;
    public final boolean c;

    public a() {
        this(0);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof a) == false) goto L12;
        a r4 = (a) r3;
        if (this.a == r4.a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (this.c == r4.c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    public final int hashCode() {
        boolean r0 = this.a;
        ?? r1 = 1;
        ?? r2 = r0;
        if (r0 == false) goto L5;
        r2 = 1;
    L5:
        int r3 = r2 * 31;
        EnlargeGuestInfo.EnlargeGuestType r4 = this.b;
        if (r4 == null) goto L8;
        int r5 = r4.hashCode();
    L9:
        int r6 = (r3 + r5) * 31;
        boolean r7 = this.c;
        if (r7 == true) goto L14;
        r1 = r7;
    L14:
        return r6 + r1;
    L8:
        r5 = 0;
        goto L9
    }

    public final String toString() {
        return "PlayModeStateItem(isCPositionOpen=" + this.a + ", enlargeGuestType=" + this.b + ", isInteractiveSongOpen=" + this.c + ")";
    }

    public /* synthetic */ a(int r2) {
        this(false, EnlargeGuestInfo.EnlargeGuestType.EnlargeGuestType_Unkown, false);
    }

    public a(boolean r2, EnlargeGuestInfo.EnlargeGuestType r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "enlargeGuestType");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }

    public static a a(a r1, boolean r2, EnlargeGuestInfo.EnlargeGuestType r3, boolean r4, int r5) {
        if ((r5 & 1) == 0) goto L6;
        r2 = r1.a;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = r1.b;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = r1.c;
    L11:
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "enlargeGuestType");
        return new a(r2, r3, r4);
    }
}
