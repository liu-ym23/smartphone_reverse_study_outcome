package rj8;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import by7.e;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.api.q0;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public final Integer A;
    public final Function2<View, Message, Boolean> B;
    public final String a;
    public final Message b;
    public final boolean c;
    public final Long d;
    public final int e;
    public final e f;
    public final RecyclerView g;
    public final Function0<BotModel> h;
    public final Function0<ChatParam> i;
    public final hh8.a j;
    public final Function0<Map<String, Object>> k;
    public final String l;
    public final String m;
    public final String n;
    public final String o;
    public final boolean p;
    public final boolean q;
    public final Integer r;
    public final Integer s;
    public final q0 t;
    public final q0.a u;
    public final ry8.d v;
    public final String w;
    public final boolean x;
    public final boolean y;
    public final Integer z;

    public a() {
        throw null;
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
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r6.j) == true) goto L39;
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
        if (Intrinsics.areEqual(this.o, r6.o) == true) goto L54;
        return false;
    L54:
        if (this.p == r6.p) goto L57;
        return false;
    L57:
        if (this.q == r6.q) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.r, r6.r) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.s, r6.s) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.t, r6.t) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.u, r6.u) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.v, r6.v) == true) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.w, r6.w) == true) goto L78;
        return false;
    L78:
        if (this.x == r6.x) goto L81;
        return false;
    L81:
        if (this.y == r6.y) goto L84;
        return false;
    L84:
        if (Intrinsics.areEqual(this.z, r6.z) == true) goto L87;
        return false;
    L87:
        if (Intrinsics.areEqual(this.A, r6.A) == true) goto L90;
        return false;
    L90:
        if (Intrinsics.areEqual(this.B, r6.B) == true) goto L92;
        return false;
    L92:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Message r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        int r7 = 1231;
        if (this.c == false) goto L13;
        int r8 = 1231;
    L14:
        int r9 = (r6 + r8) * 31;
        Long r10 = this.d;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (((r9 + r11) * 31) + this.e) * 31;
        e r13 = this.f;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        RecyclerView r16 = this.g;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (((((r15 + r17) * 31) + this.h.hashCode()) * 31) + this.i.hashCode()) * 31;
        hh8.a r19 = this.j;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        Function0<Map<String, Object>> r22 = this.k;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        String r25 = this.l;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (((r24 + r26) * 31) + this.m.hashCode()) * 31;
        String r28 = this.n;
        if (r28 != null) goto L41;
        int r29 = 0;
    L42:
        int r30 = (((r27 + r29) * 31) + this.o.hashCode()) * 31;
        if (this.p == false) goto L45;
        int r31 = 1231;
    L46:
        int r32 = (r30 + r31) * 31;
        if (this.q == false) goto L49;
        int r33 = 1231;
    L50:
        int r34 = (r32 + r33) * 31;
        Integer r35 = this.r;
        if (r35 != null) goto L53;
        int r36 = 0;
    L54:
        int r37 = (r34 + r36) * 31;
        Integer r38 = this.s;
        if (r38 != null) goto L57;
        int r39 = 0;
    L58:
        int r40 = (r37 + r39) * 31;
        q0 r41 = this.t;
        if (r41 != null) goto L61;
        int r42 = 0;
    L62:
        int r43 = (r40 + r42) * 31;
        q0.a r44 = this.u;
        if (r44 != null) goto L65;
        int r45 = 0;
    L66:
        int r46 = (r43 + r45) * 31;
        ry8.d r47 = this.v;
        if (r47 != null) goto L69;
        int r48 = 0;
    L70:
        int r49 = (r46 + r48) * 31;
        String r50 = this.w;
        if (r50 != null) goto L73;
        int r51 = 0;
    L74:
        int r52 = (r49 + r51) * 31;
        if (this.x == false) goto L77;
        int r53 = 1231;
    L78:
        int r54 = (r52 + r53) * 31;
        if (this.y == true) goto L82;
        r7 = 1237;
    L82:
        int r55 = (r54 + r7) * 31;
        Integer r56 = this.z;
        if (r56 != null) goto L85;
        int r57 = 0;
    L86:
        int r58 = (r55 + r57) * 31;
        Integer r59 = this.A;
        if (r59 != null) goto L89;
        int r60 = 0;
    L90:
        int r61 = (r58 + r60) * 31;
        Function2<View, Message, Boolean> r62 = this.B;
        if (r62 == null) goto L95;
        r1 = r62.hashCode();
    L95:
        return r61 + r1;
    L89:
        r60 = r59.hashCode();
        goto L90
    L85:
        r57 = r56.hashCode();
        goto L86
    L77:
        r53 = 1237;
        goto L78
    L73:
        r51 = r50.hashCode();
        goto L74
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
        r33 = 1237;
        goto L50
    L45:
        r31 = 1237;
        goto L46
    L41:
        r29 = r28.hashCode();
        goto L42
    L37:
        r26 = r25.hashCode();
        goto L38
    L33:
        r23 = r22.hashCode();
        goto L34
    L29:
        r20 = r19.hashCode();
        goto L30
    L25:
        r17 = r16.hashCode();
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = 1237;
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "FlowMarkdownCodeVMData(botId=" + this.a + ", data=" + this.b + ", isImmersive=" + this.c + ", uniqueKey=" + this.d + ", startIndex=" + this.e + ", trackNode=" + this.f + ", recycleView=" + this.g + ", getBotModel=" + this.h + ", getChatParam=" + this.i + ", markdownCodeViewUIConfig=" + this.j + ", eventExtra=" + this.k + ", mobCurrentPage=" + this.l + ", code=" + this.m + ", icon=" + this.n + ", language=" + this.o + ", isFinish=" + this.p + ", isDeepThinkArea=" + this.q + ", backgroundRes=" + this.r + ", expandAllBackgroundResult=" + this.s + ", adapter=" + this.t + ", modelProvider=" + this.u + ", shareMessageListAdapter=" + this.v + ", title=" + this.w + ", enableDynamicCodeFence=" + this.x + ", codeDetailDefaultNoWrap=" + this.y + ", addedLines=" + this.z + ", deletedLines=" + this.A + ", codeSelectionHandler=" + this.B + ')';
    }

    public a(String r25, Message r26, boolean r27, Long r28, int r29, e r30, RecyclerView r31, Function0 r32, Function0 r33, hh8.a r34, Function0 r35, String r36, String r37, String r38, String r39, boolean r40, boolean r41, Integer r42, Integer r43, q0 r44, q0.a r45, ry8.d r46, String r47, boolean r48, boolean r49, Integer r50, Integer r51, Function2 r52, int r53) {
        if ((r53 & 4) == 0) goto L5;
        boolean r6 = false;
    L7:
        if ((r53 & 8) == 0) goto L9;
        Long r8 = null;
    L11:
        if ((r53 & 32) == 0) goto L13;
        e r10 = null;
    L15:
        if ((r53 & 512) == 0) goto L17;
        hh8.a r11 = null;
    L19:
        if ((r53 & 1024) == 0) goto L21;
        Function0 r12 = null;
    L23:
        if ((r53 & 2048) == 0) goto L25;
        String r13 = null;
    L27:
        if ((131072 & r53) == 0) goto L29;
        Integer r14 = null;
    L31:
        if ((262144 & r53) == 0) goto L33;
        Integer r15 = null;
    L35:
        if ((r53 & 524288) == 0) goto L37;
        q0 r7 = null;
    L39:
        if ((r53 & 1048576) == 0) goto L41;
        q0.a r9 = null;
    L43:
        if ((r53 & 2097152) == 0) goto L45;
        ry8.d r18 = null;
    L47:
        if ((r53 & 4194304) == 0) goto L49;
        String r19 = null;
    L51:
        if ((r53 & 8388608) == 0) goto L53;
        boolean r20 = false;
    L55:
        if ((r53 & 16777216) == 0) goto L57;
        boolean r21 = false;
    L59:
        if ((r53 & 33554432) == 0) goto L61;
        Integer r22 = null;
    L63:
        if ((r53 & 67108864) == 0) goto L65;
        Integer r23 = null;
    L67:
        if ((r53 & 134217728) == 0) goto L69;
        Function2 r16 = null;
    L70:
        Intrinsics.checkNotNullParameter(r32, "getBotModel");
        Intrinsics.checkNotNullParameter(r33, "getChatParam");
        Intrinsics.checkNotNullParameter(r37, "code");
        Intrinsics.checkNotNullParameter(r39, "language");
        this.a = r25;
        this.b = r26;
        this.c = r6;
        this.d = r8;
        this.e = r29;
        this.f = r10;
        this.g = r31;
        this.h = r32;
        this.i = r33;
        this.j = r11;
        this.k = r12;
        this.l = r13;
        this.m = r37;
        this.n = r38;
        this.o = r39;
        this.p = r40;
        this.q = r41;
        this.r = r14;
        this.s = r15;
        this.t = r7;
        this.u = r9;
        this.v = r18;
        this.w = r19;
        this.x = r20;
        this.y = r21;
        this.z = r22;
        this.A = r23;
        this.B = r16;
        return;
    L69:
        r16 = r52;
        goto L70
    L65:
        r23 = r51;
        goto L67
    L61:
        r22 = r50;
        goto L63
    L57:
        r21 = r49;
        goto L59
    L53:
        r20 = r48;
        goto L55
    L49:
        r19 = r47;
        goto L51
    L45:
        r18 = r46;
        goto L47
    L41:
        r9 = r45;
        goto L43
    L37:
        r7 = r44;
        goto L39
    L33:
        r15 = r43;
        goto L35
    L29:
        r14 = r42;
        goto L31
    L25:
        r13 = r36;
        goto L27
    L21:
        r12 = r35;
        goto L23
    L17:
        r11 = r34;
        goto L19
    L13:
        r10 = r30;
        goto L15
    L9:
        r8 = r28;
        goto L11
    L5:
        r6 = r27;
        goto L7
    }
}
