package ni8;

import android.os.Bundle;
import com.larus.im.bean.bot.ConversationPage;
import com.larus.platform.model.RecommendFrom;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class e {
    public final String a;
    public final String b;
    public final String c;
    public final boolean d;
    public final boolean e;
    public final boolean f;
    public final int g;
    public final ConversationPage h;
    public final boolean i;
    public final String j;
    public final String k;
    public final Integer l;
    public final List<Integer> m;
    public final Integer n;
    public final long o;
    public final RecommendFrom p;
    public final String q;
    public final String r;
    public final String s;
    public final Bundle t;
    public final String u;
    public final int v;
    public final int w;
    public final long x;

    public e() {
        this(null, null, null, false, false, false, 0, null, null, null, null, null, null, 0, null, null, null, null, null, null, 0, 0, 0, 16777215);
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof e) == true) goto L8;
        return false;
    L8:
        e r9 = (e) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r9.d) goto L21;
        return false;
    L21:
        if (this.e == r9.e) goto L24;
        return false;
    L24:
        if (this.f == r9.f) goto L27;
        return false;
    L27:
        if (this.g == r9.g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r9.h) == true) goto L33;
        return false;
    L33:
        if (this.i == r9.i) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r9.j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r9.k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.l, r9.l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.m, r9.m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.n, r9.n) == true) goto L51;
        return false;
    L51:
        if (this.o == r9.o) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.p, r9.p) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.q, r9.q) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.r, r9.r) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.s, r9.s) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.t, r9.t) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.u, r9.u) == true) goto L72;
        return false;
    L72:
        if (this.v == r9.v) goto L75;
        return false;
    L75:
        if (this.w == r9.w) goto L78;
        return false;
    L78:
        if (this.x == r9.x) goto L80;
        return false;
    L80:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        int r10 = 1231;
        if (this.d == false) goto L17;
        int r11 = 1231;
    L18:
        int r12 = (r9 + r11) * 31;
        if (this.e == false) goto L21;
        int r13 = 1231;
    L22:
        int r14 = (r12 + r13) * 31;
        if (this.f == false) goto L25;
        int r15 = 1231;
    L26:
        int r16 = (((r14 + r15) * 31) + this.g) * 31;
        ConversationPage r17 = this.h;
        if (r17 != null) goto L29;
        int r18 = 0;
    L30:
        int r19 = (r16 + r18) * 31;
        if (this.i == true) goto L34;
        r10 = 1237;
    L34:
        int r20 = (r19 + r10) * 31;
        String r21 = this.j;
        if (r21 != null) goto L37;
        int r22 = 0;
    L38:
        int r23 = (r20 + r22) * 31;
        String r24 = this.k;
        if (r24 != null) goto L41;
        int r25 = 0;
    L42:
        int r26 = (r23 + r25) * 31;
        Integer r27 = this.l;
        if (r27 != null) goto L45;
        int r28 = 0;
    L46:
        int r29 = (((r26 + r28) * 31) + this.m.hashCode()) * 31;
        Integer r30 = this.n;
        if (r30 != null) goto L49;
        int r31 = 0;
    L50:
        int r32 = (r29 + r31) * 31;
        long r33 = this.o;
        int r34 = (r32 + ((int) (r33 ^ (r33 >>> 32)))) * 31;
        RecommendFrom r35 = this.p;
        if (r35 != null) goto L53;
        int r36 = 0;
    L54:
        int r37 = (r34 + r36) * 31;
        String r38 = this.q;
        if (r38 != null) goto L57;
        int r39 = 0;
    L58:
        int r40 = (r37 + r39) * 31;
        String r41 = this.r;
        if (r41 != null) goto L61;
        int r42 = 0;
    L62:
        int r43 = (r40 + r42) * 31;
        String r44 = this.s;
        if (r44 != null) goto L65;
        int r45 = 0;
    L66:
        int r46 = (r43 + r45) * 31;
        Bundle r47 = this.t;
        if (r47 != null) goto L69;
        int r48 = 0;
    L70:
        int r49 = (r46 + r48) * 31;
        String r50 = this.u;
        if (r50 == null) goto L74;
        r1 = r50.hashCode();
    L74:
        int r51 = (((((r49 + r1) * 31) + this.v) * 31) + this.w) * 31;
        long r52 = this.x;
        return r51 + ((int) (r52 ^ (r52 >>> 32)));
    L69:
        r48 = r47.hashCode();
        goto L70
    L65:
        r45 = r44.hashCode();
        goto L66
    L61:
        r42 = r41.hashCode();
        goto L62
    L57:
        r39 = r38.hashCode();
        goto L58
    L53:
        r36 = r35.hashCode();
        goto L54
    L49:
        r31 = r30.hashCode();
        goto L50
    L45:
        r28 = r27.hashCode();
        goto L46
    L41:
        r25 = r24.hashCode();
        goto L42
    L37:
        r22 = r21.hashCode();
        goto L38
    L29:
        r18 = r17.hashCode();
        goto L30
    L25:
        r15 = 1237;
        goto L26
    L21:
        r13 = 1237;
        goto L22
    L17:
        r11 = 1237;
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "SwitchConversationParams(cvsId=" + this.a + ", bgImgUrl=" + this.b + ", bgImgColor=" + this.c + ", bgImgOpen=" + this.d + ", isShowTab=" + this.e + ", isCallBot=" + this.f + ", defaultTab=" + this.g + ", conversationPage=" + this.h + ", isSub=" + this.i + ", botId=" + this.j + ", clickEnterFrom=" + this.k + ", conversationType=" + this.l + ", pageList=" + this.m + ", botType=" + this.n + ", localIndex=" + this.o + ", recommendFrom=" + this.p + ", messageId=" + this.q + ", searchKeyword=" + this.r + ", searchHighlightKeyword=" + this.s + ", callBotParam=" + this.t + ", chatTitle=" + this.u + ", botConversationType=" + this.v + ", redDotEntryUnreadCount=" + this.w + ", redDotEntryReadMessageIndex=" + this.x + ')';
    }

    public /* synthetic */ e(String r32, String r33, String r34, boolean r35, boolean r36, boolean r37, int r38, ConversationPage r39, String r40, String r41, Integer r42, List r43, Integer r44, long r45, RecommendFrom r47, String r48, String r49, String r50, Bundle r51, String r52, int r53, int r54, long r55, int r57) {
        String r2 = null;
        if ((r57 & 1) == 0) goto L5;
        String r4 = null;
    L7:
        if ((r57 & 2) == 0) goto L9;
        String r5 = null;
    L11:
        if ((r57 & 4) == 0) goto L13;
        String r6 = null;
    L15:
        if ((r57 & 8) == 0) goto L17;
        boolean r7 = false;
    L19:
        if ((r57 & 16) == 0) goto L21;
        boolean r8 = false;
    L23:
        if ((r57 & 32) == 0) goto L25;
        boolean r9 = false;
    L27:
        if ((r57 & 64) == 0) goto L29;
        int r10 = 0;
    L31:
        if ((r57 & 128) == 0) goto L33;
        ConversationPage r11 = null;
    L35:
        if ((r57 & 512) == 0) goto L37;
        String r1 = "";
    L39:
        if ((r57 & 1024) == 0) goto L41;
        String r14 = "";
    L43:
        if ((r57 & 2048) == 0) goto L45;
        Integer r15 = null;
    L47:
        if ((r57 & 4096) == 0) goto L49;
        List r16 = CollectionsKt.emptyList();
    L51:
        if ((r57 & 8192) == 0) goto L53;
        Integer r17 = null;
    L55:
        if ((r57 & 16384) == 0) goto L57;
        long r20 = -1;
    L59:
        if ((32768 & r57) == 0) goto L61;
        RecommendFrom r22 = null;
    L63:
        if ((65536 & r57) == 0) goto L65;
        String r23 = null;
    L67:
        if ((131072 & r57) == 0) goto L69;
        String r24 = null;
    L71:
        if ((262144 & r57) == 0) goto L73;
        String r25 = null;
    L75:
        if ((524288 & r57) == 0) goto L77;
        Bundle r26 = null;
    L79:
        if ((1048576 & r57) != 0) goto L83;
        r2 = r52;
    L83:
        if ((2097152 & r57) == 0) goto L85;
        int r27 = 0;
    L87:
        if ((4194304 & r57) == 0) goto L89;
        int r28 = 0;
    L91:
        if ((r57 & 8388608) == 0) goto L93;
        long r29 = -1;
    L94:
        this(r4, r5, r6, r7, r8, r9, r10, r11, false, r1, r14, r15, r16, r17, r20, r22, r23, r24, r25, r26, r2, r27, r28, r29);
        return;
    L93:
        r29 = r55;
        goto L94
    L89:
        r28 = r54;
        goto L91
    L85:
        r27 = r53;
        goto L87
    L77:
        r26 = r51;
        goto L79
    L73:
        r25 = r50;
        goto L75
    L69:
        r24 = r49;
        goto L71
    L65:
        r23 = r48;
        goto L67
    L61:
        r22 = r47;
        goto L63
    L57:
        r20 = r45;
        goto L59
    L53:
        r17 = r44;
        goto L55
    L49:
        r16 = r43;
        goto L51
    L45:
        r15 = r42;
        goto L47
    L41:
        r14 = r41;
        goto L43
    L37:
        r1 = r40;
        goto L39
    L33:
        r11 = r39;
        goto L35
    L29:
        r10 = r38;
        goto L31
    L25:
        r9 = r37;
        goto L27
    L21:
        r8 = r36;
        goto L23
    L17:
        r7 = r35;
        goto L19
    L13:
        r6 = r34;
        goto L15
    L9:
        r5 = r33;
        goto L11
    L5:
        r4 = r32;
        goto L7
    }

    public e(String r4, String r5, String r6, boolean r7, boolean r8, boolean r9, int r10, ConversationPage r11, boolean r12, String r13, String r14, Integer r15, List<Integer> r16, Integer r17, long r18, RecommendFrom r20, String r21, String r22, String r23, Bundle r24, String r25, int r26, int r27, long r28) {
        Intrinsics.checkNotNullParameter(r16, "pageList");
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
        this.l = r15;
        this.m = r16;
        this.n = r17;
        this.o = r18;
        this.p = r20;
        this.q = r21;
        this.r = r22;
        this.s = r23;
        this.t = r24;
        this.u = r25;
        this.v = r26;
        this.w = r27;
        this.x = r28;
    }
}
