package com.larus.bmhome.chat.list.cell.text.components.top.searchheader.components;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.collection.LruCache;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.cell.BaseMessageListCell;
import com.larus.bmhome.chat.component.share.IChatMessageShareAbility;
import com.larus.bmhome.chat.layout.widget.AtMostHeightLinearLayout;
import com.larus.bmhome.chat.list.cell.text.cells.base.CellComponentType;
import com.larus.bmhome.chat.search.LruSet;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.mainbot.impl.databinding.LarusDeepSearchContentBinding;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class l extends bd8.b implements hg8.z {
    public final Lazy l;
    public final wg8.c m;
    public Message n;
    public Integer o;
    public final Lazy p;
    public final wg8.f q;
    public final Lazy r;
    public final Lazy s;
    public final Lazy t;
    public AtMostHeightLinearLayout u;
    public LarusDeepSearchContentBinding v;
    public String w;
    public final Lazy x;

    public l() {
        super(false, -1);
        this.l = LazyKt.lazy(new a());
        this.m = new wg8.c();
        this.p = LazyKt.lazy(new c(this));
        this.q = new wg8.f();
        this.r = LazyKt.lazy(new d(this));
        this.s = LazyKt.lazy(new e(this));
        this.t = LazyKt.lazy(new f(this));
        this.x = LazyKt.lazy(new g(this));
    }

    @Override // bd8.b
    public final void A() {
    }

    @Override // hg8.z
    public final void j() {
    }

    @Override // bd8.b
    public final void B() {
        this.m.e();
        CoroutineScope r0 = com.larus.bmhome.chat.layout.widget.handler.p.a;
        Message r1 = this.n;
        if (r1 == null) goto L5;
        String r2 = r1.getMessageId();
    L6:
        String r3 = "";
        if (r2 != null) goto L9;
        r2 = "";
    L9:
        String r4 = this.w;
        if (r4 == null) goto L13;
        r3 = r4;
    L13:
        com.larus.bmhome.chat.layout.widget.handler.p.d(r2, r3);
        return;
    L5:
        r2 = null;
        goto L6
    }

    @Override // bd8.b
    public final void C() {
        Message r0 = this.n;
        if (r0 == null) goto L7;
        boolean r2 = true;
        if (com.larus.im.bean.message.a.f0(r0) != true) goto L7;
    L8:
        View r1 = null;
        if (r2 == false) goto L33;
        AtMostHeightLinearLayout r3 = this.u;
        if (r3 == null) goto L29;
        int r4 = r3.getChildCount();
        int r5 = 0;
    L13:
        if (r5 >= r4) goto L29;
        View r6 = r3.getChildAt(r5);
        if ((r6 instanceof FrameLayout) == false) goto L17;
        FrameLayout r7 = (FrameLayout) r6;
    L18:
        if (r7 == null) goto L28;
        int r8 = r7.getChildCount();
        int r9 = 0;
    L20:
        if (r9 >= r8) goto L28;
        CustomMarkdownTextView r10 = r7.getChildAt(r9);
        if ((r10 instanceof CustomMarkdownTextView) == false) goto L24;
        CustomMarkdownTextView r11 = r10;
    L25:
        if (r11 == null) goto L27;
        com.larus.utils.l.a(r11);
        r11.a();
    L27:
        r9 = r9 + 1;
        goto L20
    L24:
        r11 = null;
    L28:
        r5 = r5 + 1;
        goto L13
    L17:
        r7 = null;
    L29:
        AtMostHeightLinearLayout r12 = this.u;
        if (r12 == null) goto L32;
        r12.removeAllViews();
    L32:
        ((vg8.m) this.l.getValue()).d(this.u);
    L33:
        com.larus.bmhome.chat.layout.item.i r13 = this.d;
        if (r13 == null) goto L36;
        Object r14 = r13.getParent();
    L38:
        if ((r14 instanceof View) == false) goto L40;
        View r15 = (View) r14;
    L41:
        if (r15 == null) goto L43;
        ViewGroup.LayoutParams r16 = r15.getLayoutParams();
        r16.height = -2;
        r15.setLayoutParams(r16);
    L43:
        com.larus.bmhome.chat.layout.item.i r17 = this.d;
        if (r17 == null) goto L46;
        ViewParent r18 = r17.getParent();
    L48:
        if ((r18 instanceof View) == false) goto L50;
        r1 = (View) r18;
    L50:
        if (r1 == null) goto L52;
        e1.o(r1);
    L52:
        AtMostHeightLinearLayout r19 = this.u;
        if (r19 == null) goto L55;
        e1.o(r19);
    L55:
        LarusDeepSearchContentBinding r20 = this.v;
        if (r20 == null) goto L66;
        LinearLayout r21 = r20.a;
        if (r21 == null) goto L67;
        e1.o(r21);
        return;
    L67:
        return;
    L66:
        return;
    L46:
        r18 = null;
        goto L48
    L40:
        r15 = null;
        goto L41
    L36:
        r14 = null;
    L7:
        r2 = false;
        goto L8
    }

    @Override // bd8.b
    public final void z() {
        wg8.c r0 = this.m;
        r0.j.a = 0;
        r0.d = false;
    }

    @Override // bd8.b
    public final boolean H(xc8.b r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
        r2.getMessage();
        return true;
    }

    @Override // hg8.z
    public final void i(int r4) {
        com.larus.bmhome.chat.layout.item.i r0 = this.d;
        View r1 = null;
        if (r0 == null) goto L5;
        ViewParent r2 = r0.getParent();
    L7:
        if ((r2 instanceof View) == false) goto L10;
        r1 = (View) r2;
    L10:
        if (r1 == null) goto L12;
        ViewGroup.LayoutParams r3 = r1.getLayoutParams();
        r3.height = -2;
        r1.setLayoutParams(r3);
        r1.setVisibility(r4);
    L12:
        LarusDeepSearchContentBinding r5 = this.v;
        if (r5 == null) goto L18;
        LinearLayout r6 = r5.a;
        if (r6 == null) goto L19;
        ViewGroup.LayoutParams r7 = r6.getLayoutParams();
        r7.height = -2;
        r6.setLayoutParams(r7);
        r6.setVisibility(r4);
        return;
    L19:
        return;
    L18:
        return;
    L5:
        r2 = null;
        goto L7
    }

    @Override // bd8.b
    public final void w(final Message r27, final int r28, final ec8.b r29) {
        Intrinsics.checkNotNullParameter(r27, "message");
        this.n = r27;
        this.o = Integer.valueOf(r28);
        if (com.larus.im.bean.message.a.f0(r27) == false) goto L9;
        LarusDeepSearchContentBinding r3 = this.v;
        if (r3 == null) goto L14;
        View r4 = r3.b;
        if (r4 == null) goto L14;
        e1.x(r4);
    L14:
        StringBuilder r5 = new StringBuilder("deep_thinking_content_");
        com.larus.bmhome.chat.list.cell.text.cells.base.c r6 = this.h;
        if (r6 == null) goto L17;
        CellComponentType r7 = r6.a;
    L18:
        r5.append(r7);
        r5.append('_');
        com.larus.bmhome.chat.list.cell.text.cells.base.c r8 = this.h;
        if (r8 == null) goto L21;
        Integer r9 = Integer.valueOf(r8.b);
    L22:
        r5.append(r9);
        this.w = r5.toString();
        Context r10 = getContext();
        if (r10 != null) goto L25;
        return;
    L25:
        com.larus.bmhome.chat.layout.item.i r11 = this.d;
        if (r11 == null) goto L28;
        Object r12 = r11.getParent();
    L30:
        if ((r12 instanceof View) == false) goto L32;
        View r13 = (View) r12;
    L33:
        if (r13 == null) goto L35;
        e1.x(r13);
    L35:
        AtMostHeightLinearLayout r14 = this.u;
        if (r14 == null) goto L38;
        e1.x(r14);
    L38:
        LarusDeepSearchContentBinding r15 = this.v;
        if (r15 == null) goto L43;
        LinearLayout r16 = r15.a;
        if (r16 == null) goto L43;
        e1.x(r16);
    L43:
        AtMostHeightLinearLayout r17 = this.u;
        if (r17 != null) goto L46;
        return;
    L46:
        boolean r18 = com.larus.bmhome.chat.bean.d.f0(r27);
        IChatMessageShareAbility r19 = (IChatMessageShareAbility) this.r.getValue();
        if (r19 == null) goto L49;
        boolean r20 = r19.H1();
    L50:
        de8.c r21 = (de8.c) this.s.getValue();
        if (r21 == null) goto L53;
        Integer r22 = r21.m();
    L55:
        if (r22 == null) goto L57;
        boolean r23 = true;
    L58:
        fh8.t.a r24 = new fh8.t.a();
        r24.a = ContextCompat.getColor(r10, v19.c.b(2130972082, r10, 2131103146));
        r24.b = i5.o();
        r24.c = i5.E();
        r24.d = r23;
        r24.e = r20;
        com.larus.bmhome.chat.layout.item.i r25 = this.d;
        if (r25 == null) goto L61;
        Integer r26 = Integer.valueOf(r25.getBoxType());
    L62:
        r24.f = r26;
        if (r18 == false) goto L65;
    L79:
        boolean r30 = false;
    L80:
        r24.g = r30;
        fh8.t r210 = r24.a();
        fh8.g r31 = new fh8.g();
        r31.b = this.n;
        LruCache r32 = ko8.a.a;
        de8.c r33 = (de8.c) this.s.getValue();
        if (r33 == null) goto L83;
        long r34 = r33.n;
    L84:
        r31.a = ko8.a.e(r34);
        ChatParam r35 = (ChatParam) this.t.getValue();
        if (r35 == null) goto L87;
        String r36 = r35.d;
    L88:
        r31.e = r36;
        ChatParam r37 = (ChatParam) this.t.getValue();
        if (r37 == null) goto L91;
        String r38 = r37.c;
    L92:
        r31.f = r38;
        q0 r39 = this.e;
        if (r39 == null) goto L95;
        LruSet<String> r40 = r39.E7();
    L96:
        r31.g = r40;
        com.larus.bmhome.chat.component.collection.o r41 = bd8.c.a(this, com.larus.bmhome.chat.component.collection.o.class);
        if (r41 == null) goto L99;
        Boolean r42 = Boolean.valueOf(r41.i0());
    L100:
        r31.h = r42;
        r31.l = new b(this);
        q0 r43 = this.e;
        if (r43 == null) goto L103;
        q0.a r44 = r43.getProvider();
    L104:
        r31.m = r44;
        r31.n = (AttachReceiver) this.i.getValue();
        r31.o = (RecyclerView.Adapter) this.p.getValue();
        r31.k = this.o;
        com.larus.bmhome.chat.component.cvs.y r45 = (com.larus.bmhome.chat.component.cvs.y) this.x.getValue();
        if (r45 == null) goto L108;
        String r46 = r45.Y1();
        if (r46 == null) goto L108;
    L109:
        r31.c = r46;
        com.larus.bmhome.chat.component.cvs.y r47 = (com.larus.bmhome.chat.component.cvs.y) this.x.getValue();
        if (r47 == null) goto L114;
        BotModel r48 = r47.j0();
        if (r48 == null) goto L114;
        String r49 = r48.getBotId();
    L115:
        if (r49 != null) goto L117;
        r49 = "";
    L117:
        r31.d = r49;
        r31.q = this.e;
        fh8.g r50 = fh8.h.a(r31.a());
        r50.i = new h(this, r27, r28, r29);
        fh8.f r211 = r50.a();
        vg8.m r212 = (vg8.m) this.l.getValue();
        if (com.larus.bmhome.chat.bean.d.e0(r27) == false) goto L120;
    L124:
        boolean r51 = false;
    L125:
        String r52 = this.w;
        if (r52 != null) goto L128;
        String r53 = "";
    L129:
        StringBuilder r54 = new StringBuilder();
        r54.append(r27.getMessageId());
        r54.append('-');
        com.larus.bmhome.chat.list.cell.text.cells.base.c r55 = this.h;
        if (r55 == null) goto L132;
        Integer r56 = Integer.valueOf(r55.d);
    L133:
        r54.append(r56);
        fh8.e.a(r212, r17, null, r210, new fh8.l(r51, r18, r53, true, r54.toString(), false, false, false, false, null, null, 4064), new i(this, r27), new j(r27, this), new k(), MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("cellComponentInfo", this.h), TuplesKt.to("componentContext", r29), TuplesKt.to("isDeepThink", Boolean.TRUE)}), r211, null, null, 1538);
        com.larus.bmhome.chat.list.cell.text.cells.base.c r2 = this.h;
        if (r2 == null) goto L136;
        int r57 = r2.c;
    L137:
        if (r2 == null) goto L139;
        int r58 = r2.b;
    L140:
        String r1 = com.larus.im.bean.message.a.K(r27);
        if (r1 != null) goto L143;
    L146:
        boolean r59 = true;
    L147:
        int r60 = i5.h();
        int r61 = i5.h();
        if ((r58 + 1) != r57) goto L152;
        if (r59 == false) goto L151;
        r61 = 0;
        goto L152
    L151:
        r61 = i5.h();
    L152:
        int r62 = r17.getChildCount();
        int r63 = 0;
    L153:
        if (r63 >= r62) goto L169;
        View r64 = r17.getChildAt(r63);
        if ((r64 instanceof FrameLayout) == false) goto L157;
        FrameLayout r65 = (FrameLayout) r64;
    L158:
        if (r65 == null) goto L168;
        int r66 = r65.getChildCount();
        int r67 = 0;
    L160:
        if (r67 >= r66) goto L168;
        CustomMarkdownTextView r110 = r65.getChildAt(r67);
        if ((r110 instanceof CustomMarkdownTextView) == false) goto L164;
        CustomMarkdownTextView r111 = r110;
    L165:
        if (r111 == null) goto L167;
        CustomMarkdownTextView r112 = r110;
        int r113 = r112.getPaddingStart();
        int r114 = r112.getPaddingEnd();
        FLogger.a.i("updatePaddingRelative", "view:CustomMarkdownTextView,source:,start:" + r113 + ",top:" + r60 + ",end:" + r114 + ",bottom:" + r61);
        r112.setPaddingRelative(r113, r60, r114, r61);
    L167:
        r67 = r67 + 1;
        goto L160
    L164:
        r111 = null;
    L168:
        r63 = r63 + 1;
        goto L153
    L157:
        r65 = null;
        goto L158
    L169:
        return;
    L143:
        if (r1.length() == 0) goto L146;
        r59 = false;
        goto L147
    L139:
        r58 = 0;
        goto L140
    L136:
        r57 = 0;
        goto L137
    L132:
        r56 = null;
        goto L133
    L128:
        r53 = r52;
        goto L129
    L120:
        if (r27.getMessageStatusLocal() != 23) goto L122;
    L123:
        r51 = true;
        goto L125
    L122:
        if (r27.getMessageStatusLocal() != 22) goto L124;
    L114:
        r49 = null;
    L108:
        r46 = "";
        goto L109
    L103:
        r44 = null;
        goto L104
    L99:
        r42 = null;
        goto L100
    L95:
        r40 = null;
        goto L96
    L91:
        r38 = null;
        goto L92
    L87:
        r36 = null;
        goto L88
    L83:
        r34 = 0;
        goto L84
    L65:
        if (com.larus.bmhome.chat.bean.d.e0(r27) == false) goto L67;
    L70:
        String r68 = com.larus.im.bean.message.a.O(r27);
        if (r68 != null) goto L73;
    L76:
        boolean r69 = true;
    L77:
        if (r69 == true) goto L79;
        r30 = true;
        goto L80
    L73:
        if (StringsKt.isBlank(r68) == true) goto L76;
        r69 = false;
        goto L77
    L67:
        if (r27.getMessageStatusLocal() == 23) goto L79;
        if (r27.getMessageStatusLocal() == 22) goto L79;
    L61:
        r26 = null;
        goto L62
    L57:
        r23 = false;
        goto L58
    L53:
        r22 = null;
        goto L55
    L49:
        r20 = false;
        goto L50
    L32:
        r13 = null;
        goto L33
    L28:
        r12 = null;
        goto L30
    L21:
        r9 = null;
        goto L22
    L17:
        r7 = null;
        goto L18
    L9:
        LarusDeepSearchContentBinding r70 = this.v;
        if (r70 == null) goto L14;
        View r71 = r70.b;
        if (r71 == null) goto L14;
        e1.o(r71);
        goto L14
    }

    @Override // bd8.b
    public final List<View> x(int r3, Context r4, BaseMessageListCell<?> r5, com.larus.bmhome.chat.layout.item.i r6, q0 r7, Fragment r8) {
        Intrinsics.checkNotNullParameter(r4, "context");
        View r9 = LayoutInflater.from(r4).inflate(2131562021, r6, false);
        int r10 = 2131388570;
        AtMostHeightLinearLayout r11 = (AtMostHeightLinearLayout) ViewBindings.findChildViewById(r9, 2131388570);
        if (r11 == null) goto L15;
        r10 = 2131392215;
        View r12 = ViewBindings.findChildViewById(r9, 2131392215);
        if (r12 == null) goto L15;
        LinearLayout r13 = (LinearLayout) r9;
        LarusDeepSearchContentBinding r14 = new LarusDeepSearchContentBinding(r13, r11, r12);
        if (r6 == null) goto L9;
        r6.addView(r13, new LinearLayout.LayoutParams(-1, -2));
    L9:
        this.u = r11;
        this.v = r14;
        if (r13 == null) goto L12;
        e1.o(r13);
    L12:
        this.q.a = r5;
        wg8.c r15 = this.m;
        r15.a = r5;
        r15.b = r6;
        return CollectionsKt.listOf(r13);
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r9.getResources().getResourceName(r10)));
    }
}
