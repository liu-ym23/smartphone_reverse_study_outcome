package hf8;

import android.view.View;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.layout.widget.ThreeLoadingIndicator;
import com.larus.bmhome.chat.layout.widget.handler.q;
import com.larus.bmhome.chat.layout.widget.v0;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import fh8.f;
import fh8.r;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import lw8.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a {
    public final r A;
    public final Function0<Map<String, Object>> B;
    public final Integer C;
    public final View D;
    public final boolean E;
    public final String F;
    public final ConcurrentHashMap<String, CharSequence> a;
    public final Message b;
    public final BotModel c;
    public final ChatParam d;
    public final f e;
    public final q0 f;
    public final Boolean g;
    public final d h;
    public final q0.a i;
    public final AttachReceiver j;
    public final v0 k;
    public final ThreeLoadingIndicator l;
    public final Function2<CustomMarkdownTextView, Long, Unit> m;
    public final Function2<CustomMarkdownTextView, st8.a, Unit> n;
    public final Integer o;
    public final boolean p;
    public final String q;
    public final boolean r;
    public final boolean s;
    public final boolean t;
    public final q u;
    public final Function1<CustomMarkdownTextView, Unit> v;
    public final Function1<CustomMarkdownTextView, Unit> w;
    public final boolean x;
    public final Map<String, Object> y;
    public final Block z;

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
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
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
        if (Intrinsics.areEqual(this.q, r6.q) == true) goto L60;
        return false;
    L60:
        if (this.r == r6.r) goto L63;
        return false;
    L63:
        if (this.s == r6.s) goto L66;
        return false;
    L66:
        if (this.t == r6.t) goto L69;
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
        if (Intrinsics.areEqual(this.y, r6.y) == true) goto L84;
        return false;
    L84:
        if (Intrinsics.areEqual(this.z, r6.z) == true) goto L87;
        return false;
    L87:
        if (Intrinsics.areEqual(this.A, r6.A) == true) goto L90;
        return false;
    L90:
        if (Intrinsics.areEqual(this.B, r6.B) == true) goto L93;
        return false;
    L93:
        if (Intrinsics.areEqual(this.C, r6.C) == true) goto L96;
        return false;
    L96:
        if (Intrinsics.areEqual(this.D, r6.D) == true) goto L99;
        return false;
    L99:
        if (this.E == r6.E) goto L102;
        return false;
    L102:
        if (Intrinsics.areEqual(this.F, r6.F) == true) goto L104;
        return false;
    L104:
        return true;
    }

    public final int hashCode() {
        ConcurrentHashMap<String, CharSequence> r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = ((((((r2 * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31;
        f r4 = this.e;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        q0 r7 = this.f;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Boolean r10 = this.g;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (((r9 + r11) * 31) + this.h.hashCode()) * 31;
        q0.a r13 = this.i;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        AttachReceiver r16 = this.j;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        v0 r19 = this.k;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        ThreeLoadingIndicator r22 = this.l;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        Function2<CustomMarkdownTextView, Long, Unit> r25 = this.m;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        Function2<CustomMarkdownTextView, st8.a, Unit> r28 = this.n;
        if (r28 != null) goto L41;
        int r29 = 0;
    L42:
        int r30 = (r27 + r29) * 31;
        Integer r31 = this.o;
        if (r31 != null) goto L45;
        int r32 = 0;
    L46:
        int r33 = (r30 + r32) * 31;
        int r34 = 1231;
        if (this.p == false) goto L49;
        int r35 = 1231;
    L50:
        int r36 = (((r33 + r35) * 31) + this.q.hashCode()) * 31;
        if (this.r == false) goto L53;
        int r37 = 1231;
    L54:
        int r38 = (r36 + r37) * 31;
        if (this.s == false) goto L57;
        int r39 = 1231;
    L58:
        int r40 = (r38 + r39) * 31;
        if (this.t == false) goto L61;
        int r41 = 1231;
    L62:
        int r42 = (r40 + r41) * 31;
        q r43 = this.u;
        if (r43 != null) goto L65;
        int r44 = 0;
    L66:
        int r45 = (r42 + r44) * 31;
        Function1<CustomMarkdownTextView, Unit> r46 = this.v;
        if (r46 != null) goto L69;
        int r47 = 0;
    L70:
        int r48 = (r45 + r47) * 31;
        Function1<CustomMarkdownTextView, Unit> r49 = this.w;
        if (r49 != null) goto L73;
        int r50 = 0;
    L74:
        int r51 = (r48 + r50) * 31;
        if (this.x == false) goto L77;
        int r52 = 1231;
    L78:
        int r53 = (r51 + r52) * 31;
        Map<String, Object> r54 = this.y;
        if (r54 != null) goto L81;
        int r55 = 0;
    L82:
        int r56 = (r53 + r55) * 31;
        Block r57 = this.z;
        if (r57 != null) goto L85;
        int r58 = 0;
    L86:
        int r59 = (r56 + r58) * 31;
        r r60 = this.A;
        if (r60 != null) goto L89;
        int r61 = 0;
    L90:
        int r62 = (r59 + r61) * 31;
        Function0<Map<String, Object>> r63 = this.B;
        if (r63 != null) goto L93;
        int r64 = 0;
    L94:
        int r65 = (r62 + r64) * 31;
        Integer r66 = this.C;
        if (r66 != null) goto L97;
        int r67 = 0;
    L98:
        int r68 = (r65 + r67) * 31;
        View r69 = this.D;
        if (r69 != null) goto L101;
        int r70 = 0;
    L102:
        int r71 = (r68 + r70) * 31;
        if (this.E == true) goto L106;
        r34 = 1237;
    L106:
        int r72 = (r71 + r34) * 31;
        String r73 = this.F;
        if (r73 == null) goto L111;
        r1 = r73.hashCode();
    L111:
        return r72 + r1;
    L101:
        r70 = r69.hashCode();
        goto L102
    L97:
        r67 = r66.hashCode();
        goto L98
    L93:
        r64 = r63.hashCode();
        goto L94
    L89:
        r61 = r60.hashCode();
        goto L90
    L85:
        r58 = r57.hashCode();
        goto L86
    L81:
        r55 = r54.hashCode();
        goto L82
    L77:
        r52 = 1237;
        goto L78
    L73:
        r50 = r49.hashCode();
        goto L74
    L69:
        r47 = r46.hashCode();
        goto L70
    L65:
        r44 = r43.hashCode();
        goto L66
    L61:
        r41 = 1237;
        goto L62
    L57:
        r39 = 1237;
        goto L58
    L53:
        r37 = 1237;
        goto L54
    L49:
        r35 = 1237;
        goto L50
    L45:
        r32 = r31.hashCode();
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
        return "MarkdownTextViewWidgetHandlerParams(cacheReuseReference=" + this.a + ", data=" + this.b + ", bot=" + this.c + ", chatParam=" + this.d + ", markdownCommonInputData=" + this.e + ", adapter=" + this.f + ", isImmersive=" + this.g + ", customMarkDownInfo=" + this.h + ", modelProvider=" + this.i + ", attachReceiver=" + this.j + ", singleLoadingSpan=" + this.k + ", multiLoadingSpan=" + this.l + ", clickAction=" + this.m + ", longClickAction=" + this.n + ", position=" + this.o + ", isDeepThinkArea=" + this.p + ", viewTag=" + this.q + ", isStreaming=" + this.r + ", failOrInterrupt=" + this.s + ", isLoading=" + this.t + ", textViewConfig=" + this.u + ", onGenerate=" + this.v + ", afterSetMarkdownAction=" + this.w + ", isLastBlock=" + this.x + ", extra=" + this.y + ", block=" + this.z + ", markdownTextWidgetEventDelegator=" + this.A + ", eventExtra=" + this.B + ", maxContentWidth=" + this.C + ", viewGroup=" + this.D + ", incrementalConditionMet=" + this.E + ", incrementalText=" + this.F + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(ConcurrentHashMap<String, CharSequence> r8, Message r9, BotModel r10, ChatParam r11, f r12, q0 r13, Boolean r14, d r15, q0.a r16, AttachReceiver r17, v0 r18, ThreeLoadingIndicator r19, Function2<? super CustomMarkdownTextView, ? super Long, Unit> r20, Function2<? super CustomMarkdownTextView, ? super st8.a, Unit> r21, Integer r22, boolean r23, String r24, boolean r25, boolean r26, boolean r27, q r28, Function1<? super CustomMarkdownTextView, Unit> r29, Function1<? super CustomMarkdownTextView, Unit> r30, boolean r31, Map<String, ? extends Object> r32, Block r33, r r34, Function0<? extends Map<String, ? extends Object>> r35, Integer r36, View r37, boolean r38, String r39) {
        Intrinsics.checkNotNullParameter(r9, "data");
        Intrinsics.checkNotNullParameter(r10, "bot");
        Intrinsics.checkNotNullParameter(r11, "chatParam");
        Intrinsics.checkNotNullParameter(r15, "customMarkDownInfo");
        Intrinsics.checkNotNullParameter(r24, "viewTag");
        this.a = r8;
        this.b = r9;
        this.c = r10;
        this.d = r11;
        this.e = r12;
        this.f = r13;
        this.g = r14;
        this.h = r15;
        this.i = r16;
        this.j = r17;
        this.k = r18;
        this.l = r19;
        this.m = r20;
        this.n = r21;
        this.o = r22;
        this.p = r23;
        this.q = r24;
        this.r = r25;
        this.s = r26;
        this.t = r27;
        this.u = r28;
        this.v = r29;
        this.w = r30;
        this.x = r31;
        this.y = r32;
        this.z = r33;
        this.A = r34;
        this.B = r35;
        this.C = r36;
        this.D = r37;
        this.E = r38;
        this.F = r39;
    }
}
