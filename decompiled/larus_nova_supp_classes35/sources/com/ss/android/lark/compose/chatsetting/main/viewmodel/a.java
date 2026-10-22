package com.ss.android.lark.compose.chatsetting.main.viewmodel;

import com.lark.kmp.pb.basic.v1.Chat;
import com.ss.android.lark.chameleon.container.webcontainer.util.ChameleonContainerUtils;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public final Chat.Type a;
    public final String b;
    public final String c;
    public final String d;
    public final int e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final boolean i;
    public final boolean j;
    public final com.ss.android.lark.compose.foundation.widget.a k;
    public final com.ss.android.lark.compose.foundation.widget.a l;
    public final com.ss.android.lark.compose.foundation.widget.a m;
    public final com.ss.android.lark.compose.foundation.widget.a n;
    public final boolean o;
    public final String p;
    public final boolean q;
    public final boolean r;

    public a() {
        this(false, 262143);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
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
        if (this.j == r6.j) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r6.k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.l, r6.l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.m, r6.m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.n, r6.n) == true) goto L51;
        return false;
    L51:
        if (this.o == r6.o) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.p, r6.p) == true) goto L57;
        return false;
    L57:
        if (this.q == r6.q) goto L60;
        return false;
    L60:
        if (this.r == r6.r) goto L62;
        return false;
    L62:
        return true;
    }

    public final int hashCode() {
        Chat.Type r0 = this.a;
        if (r0 != null) goto L5;
        int r1 = 0;
    L6:
        int r2 = ((((((((r1 * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e) * 31;
        int r3 = 1231;
        if (this.f == false) goto L9;
        int r4 = 1231;
    L10:
        int r5 = (r2 + r4) * 31;
        if (this.g == false) goto L13;
        int r6 = 1231;
    L14:
        int r7 = (r5 + r6) * 31;
        if (this.h == false) goto L17;
        int r8 = 1231;
    L18:
        int r9 = (r7 + r8) * 31;
        if (this.i == false) goto L21;
        int r10 = 1231;
    L22:
        int r11 = (r9 + r10) * 31;
        if (this.j == false) goto L25;
        int r12 = 1231;
    L26:
        int r13 = (((((((((r11 + r12) * 31) + this.k.hashCode()) * 31) + this.l.hashCode()) * 31) + this.m.hashCode()) * 31) + this.n.hashCode()) * 31;
        if (this.o == false) goto L29;
        int r14 = 1231;
    L30:
        int r15 = (((r13 + r14) * 31) + this.p.hashCode()) * 31;
        if (this.q == false) goto L33;
        int r16 = 1231;
    L34:
        int r17 = (r15 + r16) * 31;
        if (this.r == true) goto L39;
        r3 = 1237;
    L39:
        return r17 + r3;
    L33:
        r16 = 1237;
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
        r1 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "ChatSettingState(chatType=" + this.a + ", avatarKey=" + this.b + ", chatName=" + this.c + ", p2pChatterId=" + this.d + ", userCount=" + this.e + ", isOwner=" + this.f + ", isAdmin=" + this.g + ", offEditGroupChatInfo=" + this.h + ", allCanShare=" + this.i + ", allCanAddMember=" + this.j + ", muteState=" + this.k + ", pinState=" + this.l + ", useDoubaoInChatState=" + this.m + ", doubaoProactiveReplyState=" + this.n + ", isEnterpriseAccount=" + this.o + ", ownerId=" + this.p + ", isQuit=" + this.q + ", isTopicGroup=" + this.r + ')';
    }

    public /* synthetic */ a(boolean r24, int r25) {
        if ((r25 & 2) == 0) goto L5;
        String r2 = BuildConfig.FLAVOR;
    L7:
        if ((r25 & 4) == 0) goto L9;
        String r5 = BuildConfig.FLAVOR;
    L11:
        if ((r25 & 8) == 0) goto L13;
        String r6 = BuildConfig.FLAVOR;
    L15:
        if ((r25 & 128) == 0) goto L17;
        boolean r10 = true;
    L19:
        if ((r25 & 256) == 0) goto L21;
        boolean r13 = true;
    L23:
        if ((r25 & 512) == 0) goto L25;
        boolean r14 = true;
    L27:
        if ((r25 & ChameleonContainerUtils.MAX_URL_LENGTH) == 0) goto L29;
        com.ss.android.lark.compose.foundation.widget.a r15 = new com.ss.android.lark.compose.foundation.widget.a(false, false);
    L31:
        if ((r25 & 2048) == 0) goto L33;
        com.ss.android.lark.compose.foundation.widget.a r17 = new com.ss.android.lark.compose.foundation.widget.a(false, false);
    L35:
        if ((r25 & 4096) == 0) goto L37;
        com.ss.android.lark.compose.foundation.widget.a r19 = new com.ss.android.lark.compose.foundation.widget.a(true, false);
    L39:
        if ((r25 & 8192) == 0) goto L41;
        com.ss.android.lark.compose.foundation.widget.a r20 = new com.ss.android.lark.compose.foundation.widget.a(false, false);
    L43:
        if ((r25 & 16384) == 0) goto L45;
        boolean r21 = false;
    L47:
        if ((r25 & 32768) == 0) goto L49;
        String r16 = BuildConfig.FLAVOR;
    L50:
        this(null, r2, r5, r6, 0, false, false, r10, r13, r14, r15, r17, r19, r20, r21, r16, false, false);
        return;
    L49:
        r16 = null;
        goto L50
    L45:
        r21 = r24;
        goto L47
    L41:
        r20 = null;
        goto L43
    L37:
        r19 = null;
        goto L39
    L33:
        r17 = null;
        goto L35
    L29:
        r15 = null;
        goto L31
    L25:
        r14 = false;
        goto L27
    L21:
        r13 = false;
        goto L23
    L17:
        r10 = false;
        goto L19
    L13:
        r6 = null;
        goto L15
    L9:
        r5 = null;
        goto L11
    L5:
        r2 = null;
        goto L7
    }

    public a(Chat.Type r11, String r12, String r13, String r14, int r15, boolean r16, boolean r17, boolean r18, boolean r19, boolean r20, com.ss.android.lark.compose.foundation.widget.a r21, com.ss.android.lark.compose.foundation.widget.a r22, com.ss.android.lark.compose.foundation.widget.a r23, com.ss.android.lark.compose.foundation.widget.a r24, boolean r25, String r26, boolean r27, boolean r28) {
        Intrinsics.checkNotNullParameter(r12, "avatarKey");
        Intrinsics.checkNotNullParameter(r13, "chatName");
        Intrinsics.checkNotNullParameter(r14, "p2pChatterId");
        Intrinsics.checkNotNullParameter(r21, "muteState");
        Intrinsics.checkNotNullParameter(r22, "pinState");
        Intrinsics.checkNotNullParameter(r23, "useDoubaoInChatState");
        Intrinsics.checkNotNullParameter(r24, "doubaoProactiveReplyState");
        Intrinsics.checkNotNullParameter(r26, "ownerId");
        this.a = r11;
        this.b = r12;
        this.c = r13;
        this.d = r14;
        this.e = r15;
        this.f = r16;
        this.g = r17;
        this.h = r18;
        this.i = r19;
        this.j = r20;
        this.k = r21;
        this.l = r22;
        this.m = r23;
        this.n = r24;
        this.o = r25;
        this.p = r26;
        this.q = r27;
        this.r = r28;
    }

    public static a a(a r18, Chat.Type r19, String r20, String r21, String r22, int r23, boolean r24, boolean r25, boolean r26, boolean r27, boolean r28, com.ss.android.lark.compose.foundation.widget.a r29, com.ss.android.lark.compose.foundation.widget.a r30, com.ss.android.lark.compose.foundation.widget.a r31, com.ss.android.lark.compose.foundation.widget.a r32, String r33, boolean r34, boolean r35, int r36) {
        if ((r36 & 1) == 0) goto L5;
        Chat.Type r2 = r18.a;
    L7:
        if ((r36 & 2) == 0) goto L9;
        String r3 = r18.b;
    L11:
        if ((r36 & 4) == 0) goto L13;
        String r4 = r18.c;
    L15:
        if ((r36 & 8) == 0) goto L17;
        String r5 = r18.d;
    L19:
        if ((r36 & 16) == 0) goto L21;
        int r6 = r18.e;
    L23:
        if ((r36 & 32) == 0) goto L25;
        boolean r7 = r18.f;
    L27:
        if ((r36 & 64) == 0) goto L29;
        boolean r8 = r18.g;
    L31:
        if ((r36 & 128) == 0) goto L33;
        boolean r9 = r18.h;
    L35:
        if ((r36 & 256) == 0) goto L37;
        boolean r10 = r18.i;
    L39:
        if ((r36 & 512) == 0) goto L41;
        boolean r11 = r18.j;
    L43:
        if ((r36 & ChameleonContainerUtils.MAX_URL_LENGTH) == 0) goto L45;
        com.ss.android.lark.compose.foundation.widget.a r12 = r18.k;
    L47:
        if ((r36 & 2048) == 0) goto L49;
        com.ss.android.lark.compose.foundation.widget.a r13 = r18.l;
    L51:
        if ((r36 & 4096) == 0) goto L53;
        com.ss.android.lark.compose.foundation.widget.a r14 = r18.m;
    L55:
        if ((r36 & 8192) == 0) goto L57;
        com.ss.android.lark.compose.foundation.widget.a r15 = r18.n;
    L58:
        boolean r210 = r11;
        if ((r36 & 16384) == 0) goto L61;
        boolean r16 = r18.o;
    L63:
        if ((r36 & 32768) == 0) goto L65;
        String r17 = r18.p;
    L66:
        boolean r211 = r10;
        if ((r36 & 65536) == 0) goto L69;
        boolean r110 = r18.q;
    L71:
        if ((r36 & 131072) == 0) goto L73;
        boolean r1 = r18.r;
    L74:
        r18.getClass();
        Intrinsics.checkNotNullParameter(r3, "avatarKey");
        Intrinsics.checkNotNullParameter(r4, "chatName");
        Intrinsics.checkNotNullParameter(r5, "p2pChatterId");
        Intrinsics.checkNotNullParameter(r12, "muteState");
        Intrinsics.checkNotNullParameter(r13, "pinState");
        Intrinsics.checkNotNullParameter(r14, "useDoubaoInChatState");
        Intrinsics.checkNotNullParameter(r15, "doubaoProactiveReplyState");
        Intrinsics.checkNotNullParameter(r17, "ownerId");
        return new a(r2, r3, r4, r5, r6, r7, r8, r9, r211, r210, r12, r13, r14, r15, r16, r17, r110, r1);
    L73:
        r1 = r35;
        goto L74
    L69:
        r110 = r34;
        goto L71
    L65:
        r17 = r33;
        goto L66
    L61:
        r16 = false;
        goto L63
    L57:
        r15 = r32;
        goto L58
    L53:
        r14 = r31;
        goto L55
    L49:
        r13 = r30;
        goto L51
    L45:
        r12 = r29;
        goto L47
    L41:
        r11 = r28;
        goto L43
    L37:
        r10 = r27;
        goto L39
    L33:
        r9 = r26;
        goto L35
    L29:
        r8 = r25;
        goto L31
    L25:
        r7 = r24;
        goto L27
    L21:
        r6 = r23;
        goto L23
    L17:
        r5 = r22;
        goto L19
    L13:
        r4 = r21;
        goto L15
    L9:
        r3 = r20;
        goto L11
    L5:
        r2 = r19;
        goto L7
    }
}
