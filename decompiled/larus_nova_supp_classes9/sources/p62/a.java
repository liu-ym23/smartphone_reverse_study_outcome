package p62;

import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.livesdkapi.depend.model.live.roomchannel.SecretChatInfo;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {
    public boolean a;
    public final SecretChatInfo b;
    public final long c;
    public List<? extends User> d;
    public User e;
    public String f;
    public List<? extends k> g;
    public long h;
    public int i;
    public long j;
    public boolean k;
    public boolean l;

    public a() {
        throw null;
    }

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof a) == false) goto L30;
        a r7 = (a) r6;
        if (this.a == r7.a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r7.b) == true) goto L10;
        return false;
    L10:
        if (this.c == r7.c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r7.d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r7.e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f, r7.f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.g, r7.g) == true) goto L20;
        return false;
    L20:
        if (this.h == r7.h) goto L22;
        return false;
    L22:
        if (this.i == r7.i) goto L24;
        return false;
    L24:
        if (this.j == r7.j) goto L26;
        return false;
    L26:
        if (this.k == r7.k) goto L28;
        return false;
    L28:
        if (this.l == r7.l) goto L46;
        return false;
    L46:
        return true;
    L30:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v21, types: [int] */
    /* JADX WARN: Type inference failed for: r0v23, types: [int] */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v25 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v8 */
    public final int hashCode() {
        boolean r0 = this.a;
        ?? r1 = 1;
        ?? r2 = r0;
        if (r0 == false) goto L5;
        r2 = 1;
    L5:
        int r3 = r2 * 31;
        SecretChatInfo r4 = this.b;
        int r5 = 0;
        if (r4 == null) goto L8;
        int r6 = r4.hashCode();
    L9:
        long r7 = this.c;
        int r8 = (((r3 + r6) * 31) + ((int) (r7 ^ (r7 >>> 32)))) * 31;
        List<? extends User> r9 = this.d;
        if (r9 == null) goto L12;
        int r10 = r9.hashCode();
    L13:
        int r11 = (r8 + r10) * 31;
        User r13 = this.e;
        if (r13 == null) goto L16;
        int r14 = r13.hashCode();
    L17:
        int r15 = (r11 + r14) * 31;
        String r16 = this.f;
        if (r16 == null) goto L20;
        int r17 = r16.hashCode();
    L21:
        int r18 = (r15 + r17) * 31;
        List<? extends k> r19 = this.g;
        if (r19 == null) goto L24;
        r5 = r19.hashCode();
    L24:
        int r20 = (r18 + r5) * 31;
        long r21 = this.h;
        int r23 = (((r20 + ((int) (r21 ^ (r21 >>> 32)))) * 31) + this.i) * 31;
        long r24 = this.j;
        int r25 = (r23 + ((int) (r24 ^ (r24 >>> 32)))) * 31;
        boolean r26 = this.k;
        ?? r27 = r26;
        if (r26 == false) goto L27;
        r27 = 1;
    L27:
        int r28 = (r25 + r27) * 31;
        boolean r29 = this.l;
        if (r29 == true) goto L32;
        r1 = r29;
    L32:
        return r28 + r1;
    L20:
        r17 = 0;
        goto L21
    L16:
        r14 = 0;
        goto L17
    L12:
        r10 = 0;
        goto L13
    L8:
        r6 = 0;
        goto L9
    }

    public final String toString() {
        return "ChatChannelTrayInfo(isp2pStatus=" + this.a + ", secretChatInfo=" + this.b + ", channelId=" + this.c + ", topUserList=" + this.d + ", owner=" + this.e + ", channelName=" + this.f + ", channelAvatarThumb=" + this.g + ", memberCount=" + this.h + ", unreadCount=" + this.i + ", lastChangeTimestamp=" + this.j + ", isSelected=" + this.k + ", isShowingReddot=" + this.l + ")";
    }

    public a(boolean r2, SecretChatInfo r3, long r4, List r6, User r7, String r8, List r9, long r10, long r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r6, "topUserList");
        Intrinsics.checkNotNullParameter(r7, "owner");
        Intrinsics.checkNotNullParameter(r8, "channelName");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        this.i = 0;
        this.j = r13;
        this.k = r14;
        this.l = false;
    }
}
