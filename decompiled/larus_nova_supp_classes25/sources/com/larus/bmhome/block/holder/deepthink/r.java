package com.larus.bmhome.block.holder.deepthink;

import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.block.base.config.ToolBlockInitStatus;
import com.larus.bmhome.chat.block.base.config.ToolBlockInteractType;
import com.larus.bmhome.chat.deepresearch.view.ExpandTitleCodeBlockView;
import com.larus.bmhome.chat.markdown.code.ClickableMarkdownCodeView;
import com.larus.bmhome.chat.markdown.view.DeepThinkCommonToolHeader;
import com.larus.bmhome.utils.z3;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.CodeBlock;
import com.larus.list.exposex.ExposeXTrackerExtKt;
import kc8.v0;
import kc8.w0;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class r extends jc8.b<gb8.c> {
    public kc8.b d;
    public final Lazy e;
    public final Lazy f;
    public ExpandTitleCodeBlockView g;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ToolBlockInitStatus.values().length];
            r0[ToolBlockInitStatus.Fold.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[ToolBlockInitStatus.Expand.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[ToolBlockInitStatus.Default.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    @Override // jc8.b
    public final String c() {
        return "DeepThinkCodeBlockHolder";
    }

    @Override // jc8.b
    public final void i() {
        ExpandTitleCodeBlockView r0 = this.g;
        if (r0 == null) goto L9;
        po8.z r1 = r0.a.c;
        if (r1 == null) goto L7;
        r1.b();
    L7:
        r0.b.p();
        r0.i = false;
        r0.j = null;
        return;
    }

    public r() {
        this.e = LazyKt.lazy(new p(this));
        this.f = LazyKt.lazy(new q(this));
    }

    @Override // jc8.b
    public final jc8.d f(jc8.a r2) {
        gb8.c r3 = (gb8.c) r2;
        Intrinsics.checkNotNullParameter(r3, "blockModel");
        return j0.a(this.a, r3);
    }

    /* JADX WARN: Type inference failed for: r11v1, types: [com.larus.bmhome.block.holder.deepthink.n] */
    /* JADX WARN: Type inference failed for: r11v2, types: [com.larus.bmhome.block.holder.deepthink.o] */
    @Override // jc8.b
    public final void g(jc8.a r31) {
        final gb8.c r1 = (gb8.c) r31;
        Intrinsics.checkNotNullParameter(r1, "blockModel");
        this.d = (kc8.b) jc8.c.a(this, kc8.b.class);
        Intrinsics.checkNotNullParameter(r1, "blockModel");
        final ExpandTitleCodeBlockView r2 = this.g;
        if (r2 == null) goto L172;
        tb8.a r3 = (tb8.a) jc8.c.a(this, tb8.a.class);
        Block r12 = r1.a;
        kc8.b r4 = this.d;
        if (r4 == null) goto L8;
        final w0 r5 = r4.v;
    L9:
        String r6 = r1.j().getSenderId();
        if (r6 != null) goto L12;
        String r7 = "";
    L13:
        kc8.b r8 = this.d;
        if (r8 == null) goto L22;
        kc8.y r9 = r8.a;
        if (r9 == null) goto L22;
        Function0<wc9.e> r10 = r9.e;
        if (r10 == null) goto L22;
        wc9.e r11 = (wc9.e) r10.invoke();
        if (r11 == null) goto L22;
        String r13 = ic8.n.f(r11);
    L23:
        ChatParam r14 = (ChatParam) this.e.getValue();
        if (r14 != null) goto L26;
        r14 = new ChatParam(null, null, null, null, null, 255);
    L26:
        ChatParam r15 = r14;
        Message r16 = r1.j();
        de8.c r17 = (de8.c) this.f.getValue();
        if (r17 == null) goto L29;
        Integer r18 = r17.m();
    L31:
        if (r18 == null) goto L33;
        boolean r19 = true;
    L34:
        long r110 = de8.d.a((de8.c) this.f.getValue());
        kc8.b r20 = this.d;
        if (r20 == null) goto L39;
        kc8.y r111 = r20.a;
        if (r111 == null) goto L39;
        by7.e r21 = r111.c;
    L40:
        if (r20 == null) goto L44;
        kc8.y r112 = r20.a;
        if (r112 == null) goto L44;
        RecyclerView r22 = r112.d;
    L45:
        int r113 = com.larus.bmhome.chat.markdown.imagetool.f.a;
        if (r20 == null) goto L48;
        fh8.f r23 = z3.a(r20, r1.j()).a();
    L49:
        fh8.f r24 = com.larus.bmhome.chat.markdown.imagetool.f.b(r3, r23, new com.larus.bmhome.chat.markdown.imagetool.e());
        kc8.b r25 = this.d;
        if (r25 == null) goto L54;
        kc8.p r26 = r25.e;
        if (r26 == null) goto L54;
        Integer r27 = Integer.valueOf(r26.a);
    L55:
        kc8.b r28 = this.d;
        if (r28 == null) goto L62;
        v0 r114 = r28.c;
        if (r114 == null) goto L62;
        jh8.b r115 = r114.l;
        if (r115 == null) goto L62;
        Integer r29 = r115.a;
    L63:
        if (r28 == null) goto L69;
        v0 r30 = r28.c;
        if (r30 == null) goto L69;
        jh8.b r32 = r30.l;
        if (r32 == null) goto L69;
        Integer r210 = r32.b;
    L70:
        if (r5 == null) goto L72;
        ToolBlockInteractType r33 = r5.a;
    L74:
        if (r33 != ToolBlockInteractType.DisableHeaderInteract) goto L76;
        boolean r211 = true;
    L77:
        if (r5 == null) goto L79;
        ToolBlockInitStatus r34 = r5.b;
    L81:
        if (r34 != null) goto L83;
        int r35 = -1;
    L84:
        if (r35 == (-1)) goto L96;
        if (r35 != 1) goto L87;
        Boolean r36 = Boolean.TRUE;
    L95:
        Boolean r212 = r36;
    L97:
        kc8.b r37 = this.d;
        if (r37 == null) goto L102;
        kc8.l r38 = r37.x;
        if (r38 == null) goto L102;
        Function2<View, Message, Boolean> r213 = r38.a;
    L103:
        final com.larus.bmhome.chat.deepresearch.view.l r116 = new com.larus.bmhome.chat.deepresearch.view.l(r7, r13, r15, r16, r19, Long.valueOf(r110), r21, r12, r24, r22, new n(this), r27, r29, r210, new o(r5, this, r1), r211, r212, r213);
        Intrinsics.checkNotNullParameter(r116, "config");
        r2.h = r116;
        if (r2.i == false) goto L111;
        String r39 = r2.j;
        Block r40 = r116.h;
        if (r40 == null) goto L108;
        String r117 = r40.getBlockId();
    L110:
        if (Intrinsics.areEqual(r39, r117) == false) goto L111;
    L120:
        fh8.f r41 = r116.i;
        if (r41 == null) goto L127;
        fh8.c r42 = r41.k;
        if (r42 == null) goto L127;
        fh8.d r43 = r42.a;
        if (r43 == null) goto L127;
        r43.a();
    L127:
        Block r44 = r116.h;
        if (r44 != null) goto L130;
    L132:
        boolean r118 = false;
    L133:
        r2.e = r118;
        Block r45 = r116.h;
        if (r45 == null) goto L138;
        BlockContent r46 = r45.getContent();
        if (r46 == null) goto L138;
        CodeBlock r119 = r46.getCodeBlock();
    L139:
        r2.f = r119;
        DeepThinkCommonToolHeader r47 = r2.a;
        if (r119 == null) goto L142;
        String r120 = r119.code;
    L143:
        if (r120 != null) goto L145;
    L148:
        boolean r121 = true;
    L149:
        if (r121 == false) goto L151;
    L153:
        boolean r122 = false;
    L154:
        r47.setClickable(r122);
        CodeBlock r48 = r2.f;
        if (r48 == null) goto L173;
        int r49 = oe8.a.a;
        String r50 = r48.code;
        if (r50 != null) goto L160;
        r50 = "";
    L160:
        r2.g = oe8.a.a(r50, false);
        ClickableMarkdownCodeView.n(r2.b, r116.a, r116.d, r116.e, r116.f, r116.g, r116.j, new com.larus.bmhome.chat.deepresearch.view.n(r2), r116.k, new com.larus.bmhome.chat.deepresearch.view.o(r116), null, null, null, null, null, null, null, null, null, null, r116.r, false, 1572352);
        r2.b(false);
        int r51 = v19.c.b(2130972042, null, 2131242981);
        com.larus.bmhome.chat.deepresearch.view.l r52 = r2.h;
        if (r52 == null) goto L165;
        Integer r53 = r52.m;
        if (r53 == null) goto L165;
        r2.b.setupMarkdownCodeLinearLayoutRes(Integer.valueOf(r53.intValue()));
    L166:
        ClickableMarkdownCodeView r54 = r2.b;
        com.larus.bmhome.chat.deepresearch.view.l r55 = r2.h;
        if (r55 == null) goto L169;
        Integer r123 = r55.n;
    L170:
        r54.setupCodeViewSeparatorColor(r123);
        ExposeXTrackerExtKt.b(r2.a, new com.larus.bmhome.chat.deepresearch.view.p(r2));
        ExposeXTrackerExtKt.b(r2.b, new com.larus.bmhome.chat.deepresearch.view.q(r2));
        return;
    L169:
        r123 = null;
    L165:
        r2.b.setBackgroundResource(r51);
        goto L166
    L173:
        return;
    L151:
        if (r116.p == true) goto L153;
        r122 = true;
        goto L154
    L145:
        if (r120.length() == 0) goto L148;
        r121 = false;
        goto L149
    L142:
        r120 = null;
    L138:
        r119 = null;
        goto L139
    L130:
        if (r44.isFinish() != true) goto L132;
        r118 = true;
        goto L133
    L108:
        r117 = null;
    L111:
        Boolean r56 = r116.q;
        if (r56 == null) goto L114;
        boolean r124 = r56.booleanValue();
    L115:
        r2.d = r124;
        Block r57 = r116.h;
        if (r57 == null) goto L118;
        String r125 = r57.getBlockId();
    L119:
        r2.j = r125;
        r2.i = true;
        goto L120
    L118:
        r125 = null;
        goto L119
    L114:
        r124 = true;
    L102:
        r213 = null;
        goto L103
    L87:
        if (r35 != 2) goto L89;
        r36 = Boolean.FALSE;
        goto L95
    L89:
        if (r35 == 3) goto L96;
        throw new NoWhenBranchMatchedException();
    L96:
        r212 = null;
        goto L97
    L83:
        r35 = a.a[r34.ordinal()];
        goto L84
    L79:
        r34 = null;
        goto L81
    L76:
        r211 = false;
        goto L77
    L72:
        r33 = null;
    L69:
        r210 = null;
    L62:
        r29 = null;
    L54:
        r27 = null;
        goto L55
    L48:
        r23 = new fh8.f(0);
    L44:
        r22 = null;
    L39:
        r21 = null;
        goto L40
    L33:
        r19 = false;
        goto L34
    L29:
        r18 = null;
    L22:
        r13 = null;
        goto L23
    L12:
        r7 = r6;
        goto L13
    L8:
        r5 = null;
        goto L9
    }

    @Override // jc8.b
    public final View h(ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r5, "viewGroup");
        AttributeSet r3 = null;
        ExpandTitleCodeBlockView r0 = new ExpandTitleCodeBlockView(r5.getContext(), r3, 6, 0);
        this.g = r0;
        return r0;
    }
}
