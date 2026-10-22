package qj8;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.api.q0;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class m {
    public final Integer A;
    public final Function2<View, Message, Boolean> B;
    public final String a;
    public final Message b;
    public final boolean c;
    public final Long d;
    public final int e;
    public final by7.e f;
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

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof m) == true) goto L8;
        return false;
    L8:
        m r6 = (m) r5;
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
        by7.e r13 = this.f;
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
        return "FlowMarkdownCodeViewInput(botId=" + this.a + ", data=" + this.b + ", isImmersive=" + this.c + ", uniqueKey=" + this.d + ", startIndex=" + this.e + ", trackNode=" + this.f + ", recycleView=" + this.g + ", getBotModel=" + this.h + ", getChatParam=" + this.i + ", markdownCodeViewUIConfig=" + this.j + ", eventExtra=" + this.k + ", mobCurrentPage=" + this.l + ", code=" + this.m + ", icon=" + this.n + ", language=" + this.o + ", isFinish=" + this.p + ", isDeepThinkArea=" + this.q + ", backgroundRes=" + this.r + ", expandAllBackgroundResult=" + this.s + ", adapter=" + this.t + ", modelProvider=" + this.u + ", shareMessageListAdapter=" + this.v + ", title=" + this.w + ", enableDynamicCodeFence=" + this.x + ", codeDetailDefaultNoWrap=" + this.y + ", addedLines=" + this.z + ", deletedLines=" + this.A + ", codeSelectionHandler=" + this.B + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public m(String r7, Message r8, boolean r9, Long r10, int r11, by7.e r12, RecyclerView r13, Function0<BotModel> r14, Function0<ChatParam> r15, hh8.a r16, Function0<? extends Map<String, ? extends Object>> r17, String r18, String r19, String r20, String r21, boolean r22, boolean r23, Integer r24, Integer r25, q0 r26, q0.a r27, ry8.d r28, String r29, boolean r30, boolean r31, Integer r32, Integer r33, Function2<? super View, ? super Message, Boolean> r34) {
        Intrinsics.checkNotNullParameter(r14, "getBotModel");
        Intrinsics.checkNotNullParameter(r15, "getChatParam");
        Intrinsics.checkNotNullParameter(r19, "code");
        Intrinsics.checkNotNullParameter(r21, "language");
        this.a = r7;
        this.b = r8;
        this.c = r9;
        this.d = r10;
        this.e = r11;
        this.f = r12;
        this.g = r13;
        this.h = r14;
        this.i = r15;
        this.j = r16;
        this.k = r17;
        this.l = r18;
        this.m = r19;
        this.n = r20;
        this.o = r21;
        this.p = r22;
        this.q = r23;
        this.r = r24;
        this.s = r25;
        this.t = r26;
        this.u = r27;
        this.v = r28;
        this.w = r29;
        this.x = r30;
        this.y = r31;
        this.z = r32;
        this.A = r33;
        this.B = r34;
    }
}
