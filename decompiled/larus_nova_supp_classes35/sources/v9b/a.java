package v9b;

import com.ss.android.lark.chameleon.container.webcontainer.util.ChameleonContainerUtils;
import com.ss.android.lark.chat.entity.message.Message;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public final String a;
    public final List<String> b;
    public final List<String> c;
    public final boolean d;
    public final boolean e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final boolean i;
    public final List<String> j;
    public final int k;
    public boolean l;
    public final String m;
    public final Message.Type n;
    public final List<Integer> o;
    public final List<String> p;
    public final String q;
    public final boolean r;
    public final boolean s;
    public final boolean t;

    public a() {
        this(null, null, null, false, false, false, false, false, false, null, 0, null, null, null, null, null, false, false, false, 1048575);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (this.g == r6.g) goto L30;
        return false;
    L30:
        if (this.h == r6.h) goto L33;
        return false;
    L33:
        if (this.i == r6.i) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r6.j) == true) goto L39;
        return false;
    L39:
        if (this.k == r6.k) goto L42;
        return false;
    L42:
        if (this.l == r6.l) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.m, r6.m) == true) goto L48;
        return false;
    L48:
        if (this.n == r6.n) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.o, r6.o) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.p, r6.p) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.q, r6.q) == true) goto L60;
        return false;
    L60:
        if (this.r == r6.r) goto L63;
        return false;
    L63:
        if (this.s == r6.s) goto L66;
        return false;
    L66:
        if (this.t == r6.t) goto L68;
        return false;
    L68:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        int r2 = 1231;
        if (this.d == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (r0 + r1) * 31;
        if (this.e == false) goto L9;
        int r4 = 1231;
    L10:
        int r5 = (r3 + r4) * 31;
        if (this.f == false) goto L13;
        int r6 = 1231;
    L14:
        int r7 = (r5 + r6) * 31;
        if (this.g == false) goto L17;
        int r8 = 1231;
    L18:
        int r9 = (r7 + r8) * 31;
        if (this.h == false) goto L21;
        int r10 = 1231;
    L22:
        int r11 = (r9 + r10) * 31;
        if (this.i == false) goto L25;
        int r12 = 1231;
    L26:
        int r13 = (((((r11 + r12) * 31) + this.j.hashCode()) * 31) + this.k) * 31;
        if (this.l == false) goto L29;
        int r14 = 1231;
    L30:
        int r15 = (((((((r13 + r14) * 31) + this.m.hashCode()) * 31) + this.n.hashCode()) * 31) + this.o.hashCode()) * 31;
        List<String> r16 = this.p;
        int r17 = 0;
        if (r16 != null) goto L33;
        int r18 = 0;
    L34:
        int r19 = (r15 + r18) * 31;
        String r20 = this.q;
        if (r20 == null) goto L38;
        r17 = r20.hashCode();
    L38:
        int r21 = (r19 + r17) * 31;
        if (this.r == false) goto L41;
        int r22 = 1231;
    L42:
        int r23 = (r21 + r22) * 31;
        if (this.s == false) goto L45;
        int r24 = 1231;
    L46:
        int r25 = (r23 + r24) * 31;
        if (this.t == true) goto L51;
        r2 = 1237;
    L51:
        return r25 + r2;
    L45:
        r24 = 1237;
        goto L46
    L41:
        r22 = 1237;
        goto L42
    L33:
        r18 = r16.hashCode();
        goto L34
    L29:
        r14 = 1237;
        goto L30
    L25:
        r12 = 1237;
        goto L26
    L21:
        r10 = 1237;
        goto L22
    L17:
        r8 = 1237;
        goto L18
    L13:
        r6 = 1237;
        goto L14
    L9:
        r4 = 1237;
        goto L10
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "MessageContextData(messageId=" + this.a + ", botIdList=" + this.b + ", atReadUserList=" + this.c + ", isFromMe=" + this.d + ", isEdit=" + this.e + ", isGroupAnnouncement=" + this.f + ", isPreMessage=" + this.g + ", isSecretMessage=" + this.h + ", isSteamTransporting=" + this.i + ", myAIRunningToolsIds=" + this.j + ", contentCharacterLen=" + this.k + ", isContentTranslated=" + this.l + ", fromChatterTenantId=" + this.m + ", messageType=" + this.n + ", readStateList=" + this.o + ", allAtChatterIds=" + this.p + ", chatId=" + this.q + ", isDing=" + this.r + ", isTranslatedOnlyWithTranslation=" + this.s + ", isLatestMessageFromAndFromMe=" + this.t + ')';
    }

    public a(String r23, List r24, List r25, boolean r26, boolean r27, boolean r28, boolean r29, boolean r30, boolean r31, List r32, int r33, String r34, Message.Type r35, List r36, List r37, String r38, boolean r39, boolean r40, boolean r41, int r42) {
        int r2 = r42 & 1;
        String r3 = BuildConfig.FLAVOR;
        if (r2 == 0) goto L5;
        String r4 = BuildConfig.FLAVOR;
    L7:
        if ((r42 & 2) == 0) goto L9;
        List r5 = CollectionsKt.emptyList();
    L11:
        if ((r42 & 4) == 0) goto L13;
        List r6 = CollectionsKt.emptyList();
    L15:
        if ((r42 & 8) == 0) goto L17;
        boolean r7 = false;
    L19:
        if ((r42 & 16) == 0) goto L21;
        boolean r8 = false;
    L23:
        if ((r42 & 32) == 0) goto L25;
        boolean r9 = false;
    L27:
        if ((r42 & 64) == 0) goto L29;
        boolean r10 = false;
    L31:
        if ((r42 & 128) == 0) goto L33;
        boolean r11 = false;
    L35:
        if ((r42 & 256) == 0) goto L37;
        boolean r12 = false;
    L39:
        if ((r42 & 512) == 0) goto L41;
        List r13 = CollectionsKt.emptyList();
    L43:
        if ((r42 & ChameleonContainerUtils.MAX_URL_LENGTH) == 0) goto L45;
        int r14 = 0;
    L47:
        if ((r42 & 4096) != 0) goto L51;
        r3 = r34;
    L51:
        if ((r42 & 8192) == 0) goto L53;
        Message.Type r15 = Message.Type.UNKNOWN;
    L55:
        if ((r42 & 16384) == 0) goto L57;
        List r16 = CollectionsKt.emptyList();
    L59:
        if ((r42 & 32768) == 0) goto L61;
        List r18 = null;
    L63:
        if ((r42 & 65536) == 0) goto L65;
        String r19 = null;
    L67:
        if ((r42 & 131072) == 0) goto L69;
        boolean r20 = false;
    L71:
        if ((r42 & 262144) == 0) goto L73;
        boolean r21 = false;
    L75:
        if ((r42 & 524288) == 0) goto L77;
        boolean r17 = false;
    L78:
        Intrinsics.checkNotNullParameter(r4, "messageId");
        Intrinsics.checkNotNullParameter(r5, "botIdList");
        Intrinsics.checkNotNullParameter(r6, "atReadUserList");
        Intrinsics.checkNotNullParameter(r13, "myAIRunningToolsIds");
        Intrinsics.checkNotNullParameter(r3, "fromChatterTenantId");
        Intrinsics.checkNotNullParameter(r15, "messageType");
        Intrinsics.checkNotNullParameter(r16, "readStateList");
        this.a = r4;
        this.b = r5;
        this.c = r6;
        this.d = r7;
        this.e = r8;
        this.f = r9;
        this.g = r10;
        this.h = r11;
        this.i = r12;
        this.j = r13;
        this.k = r14;
        this.l = false;
        this.m = r3;
        this.n = r15;
        this.o = r16;
        this.p = r18;
        this.q = r19;
        this.r = r20;
        this.s = r21;
        this.t = r17;
        return;
    L77:
        r17 = r41;
        goto L78
    L73:
        r21 = r40;
        goto L75
    L69:
        r20 = r39;
        goto L71
    L65:
        r19 = r38;
        goto L67
    L61:
        r18 = r37;
        goto L63
    L57:
        r16 = r36;
        goto L59
    L53:
        r15 = r35;
        goto L55
    L45:
        r14 = r33;
        goto L47
    L41:
        r13 = r32;
        goto L43
    L37:
        r12 = r31;
        goto L39
    L33:
        r11 = r30;
        goto L35
    L29:
        r10 = r29;
        goto L31
    L25:
        r9 = r28;
        goto L27
    L21:
        r8 = r27;
        goto L23
    L17:
        r7 = r26;
        goto L19
    L13:
        r6 = r25;
        goto L15
    L9:
        r5 = r24;
        goto L11
    L5:
        r4 = r23;
        goto L7
    }
}
