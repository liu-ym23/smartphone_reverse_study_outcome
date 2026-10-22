package eb8;

import android.content.Context;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import com.larus.bmhome.chat.standarduikit.markdowncontainer.view.MarkdownContainerView;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.block.Block;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kc8.v0;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class j0 extends jc8.b<fb8.m> {
    public dm8.c d;
    public final boolean e;

    @Override // jc8.b
    public final String c() {
        return "TextBlockHolderV2";
    }

    @Override // jc8.b
    public final void i() {
        dm8.c r0 = this.d;
        if (r0 == null) goto L9;
        LinearLayout r1 = (MarkdownContainerView) r0.b.getValue();
        vg8.m r2 = ((MarkdownContainerView) r1).a;
        if (r2 == null) goto L7;
        r2.d(r1);
    L7:
        ((MarkdownContainerView) r1).b = null;
        return;
    }

    public j0() {
        boolean r0 = com.larus.platform.exp.h.a;
        if (com.larus.platform.exp.h.a == true) goto L5;
    L7:
        boolean r1 = false;
    L8:
        this.e = r1;
        return;
    L5:
        if (z2.a.enableMarkdownContainerAppletLastBlockInset() == false) goto L7;
        r1 = true;
        goto L8
    }

    @Override // jc8.b
    public final jc8.d f(jc8.a r2) {
        Intrinsics.checkNotNullParameter((fb8.m) r2, "blockModel");
        return new jc8.d(0, 0, 0, 0);
    }

    @Override // jc8.b
    public final void g(jc8.a r50) {
        fb8.m r2 = (fb8.m) r50;
        Intrinsics.checkNotNullParameter(r2, "blockModel");
        Block r4 = r2.a;
        boolean r1 = r2.k;
        dm8.c r3 = this.d;
        if (r3 == null) goto L8;
        MarkdownContainerView r5 = (MarkdownContainerView) r3.b.getValue();
        if (r5 == null) goto L8;
        Context r6 = r5.getContext();
        if (r6 == null) goto L8;
    L9:
        if (r1 == false) goto L11;
        int r7 = v19.c.b(2130972082, r6, 2131103146);
    L12:
        if (r1 == false) goto L14;
        int r8 = i5.o();
    L15:
        if (r1 == false) goto L17;
        int r9 = i5.E();
    L18:
        kc8.b r10 = (kc8.b) jc8.c.a(this, kc8.b.class);
        Integer r23 = null;
        if (r10 == null) goto L21;
        v0 r11 = r10.c;
    L23:
        if (r11 == null) goto L25;
        boolean r12 = Intrinsics.areEqual(r11.n, Boolean.TRUE);
    L26:
        boolean r13 = r2.p(r12);
        FLogger.a.d("shirley_test", "TextBlockHolderV2 onBindBlockView, finished = " + r13 + "====blockId：" + r4.getBlockId() + "===parentId:" + r4.getParentId() + "===messageStatusLocal:" + r2.j().getMessageStatusLocal());
        List<jc8.a> r14 = r2.i();
        ArrayList r15 = new ArrayList();
        Iterator<T> r16 = r14.iterator();
    L28:
        if (r16.hasNext() == false) goto L32;
        Object r17 = r16.next();
        if ((r17 instanceof fb8.h) == false) goto L28;
        r15.add(r17);
        goto L28
    L32:
        ArrayList r18 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r15, 10));
        Iterator r19 = r15.iterator();
    L34:
        if (r19.hasNext() == false) goto L36;
        r18.add(((fb8.h) r19.next()).a);
        goto L34
    L36:
        String r20 = qf8.a.b(r2.a, r2.j(), r18);
        if (r20 != null) goto L39;
        r20 = "";
    L39:
        String r110 = r20;
        boolean r111 = r2.n();
        if (r2.k == false) goto L49;
        if (com.larus.bmhome.chat.bean.d.e0(r2.j()) == false) goto L44;
    L55:
        boolean r112 = false;
    L56:
        int r21 = ContextCompat.getColor(r6, r7);
        if (r11 == null) goto L59;
        Integer r113 = r11.b;
    L60:
        if (r11 == null) goto L62;
        Boolean r114 = r11.a;
    L63:
        if (r11 == null) goto L65;
        Boolean r115 = Boolean.valueOf(r11.c);
    L66:
        if (r11 == null) goto L68;
        Boolean r116 = Boolean.valueOf(r11.d);
    L69:
        if (r11 == null) goto L71;
        Boolean r22 = r11.e;
    L72:
        String r117 = r2.i.a;
        String r24 = r4.getBlockId();
        if (r11 == null) goto L75;
        RectF r25 = r11.g;
    L76:
        if (r25 != null) goto L78;
        jc8.d r26 = jc8.e.d(r2);
        String r27 = r117;
        boolean r51 = r1;
        RectF r28 = new RectF(r26.a, r26.b, r26.c, j(r2, r26.d));
        boolean r29 = r13;
    L82:
        RectF r30 = r28;
        boolean r210 = r112;
    L89:
        if (r11 == null) goto L91;
        lw8.d r211 = r11.m;
    L92:
        gm8.a r118 = new gm8.a(r4, r110, r111, r210, r29, Integer.valueOf(r21), Integer.valueOf(r8), Integer.valueOf(r9), r113, r114, r115, r116, r22, r27, r24, r51, r30, r211, 262144);
        kc8.b r31 = (kc8.b) jc8.c.a(this, kc8.b.class);
        if (r31 == null) goto L95;
        kc8.y r32 = r31.a;
    L96:
        if (r31 == null) goto L98;
        v0 r33 = r31.c;
    L99:
        em8.e r34 = new em8.e(r2, r51, r32, r33, r31);
        dm8.c r35 = this.d;
        if (r35 == null) goto L175;
        Intrinsics.checkNotNullParameter(r118, "vmData");
        gm8.b r36 = (gm8.b) r35.c.getValue();
        r36.getClass();
        Intrinsics.checkNotNullParameter(r118, "vmData");
        r36.a = r118;
        r36.b = r34;
        gm8.b r37 = (gm8.b) r35.c.getValue();
        gm8.a r38 = r37.a;
        if (r38 != null) goto L104;
        r38 = new gm8.a(null, null, false, false, false, null, null, null, null, null, null, null, null, null, null, false, null, null, 524287);
    L104:
        String r39 = r38.n;
        String r40 = "default";
        if (r39 != null) goto L107;
        r39 = "default";
    L107:
        String r41 = r38.o;
        if (r41 != null) goto L115;
        Block r42 = r38.a;
        if (r42 == null) goto L112;
        r41 = r42.getBlockId();
    L113:
        if (r41 != null) goto L115;
        r41 = "default";
        goto L115
    L112:
        r41 = null;
    L115:
        String r310 = "text_block_msgId_" + r39 + "_blockId_" + r41;
        String r43 = r38.n;
        if (r43 != null) goto L118;
        r43 = "default";
    L118:
        String r44 = r38.o;
        if (r44 != null) goto L126;
        Block r45 = r38.a;
        if (r45 == null) goto L123;
        r44 = r45.getBlockId();
    L124:
        if (r44 != null) goto L126;
    L127:
        String r311 = "msgId:" + r43 + "-blockId:" + r40;
        Integer r46 = r38.f;
        if (r46 == null) goto L130;
        int r212 = r46.intValue();
    L131:
        Integer r47 = r38.g;
        if (r47 == null) goto L134;
        int r48 = r47.intValue();
    L135:
        int r213 = r48;
        Integer r49 = r38.h;
        if (r49 == null) goto L138;
        int r52 = r49.intValue();
    L139:
        int r214 = r52;
        em8.a r53 = r37.b;
        if (r53 == null) goto L142;
        r23 = r53.getBoxType();
    L142:
        Integer r312 = r23;
        em8.a r54 = r37.b;
        if (r54 == null) goto L145;
        boolean r313 = r54.p();
    L146:
        em8.a r55 = r37.b;
        if (r55 == null) goto L149;
        boolean r314 = r55.H1();
    L150:
        em8.a r56 = r37.b;
        if (r56 == null) goto L153;
        boolean r410 = r56.r();
    L154:
        em8.a r57 = r37.b;
        if (r57 == null) goto L158;
        fh8.f r58 = r57.q();
        if (r58 == null) goto L158;
    L159:
        fh8.f r411 = r58;
        Integer r59 = r38.i;
        if (r59 == null) goto L162;
        int r315 = r59.intValue();
    L163:
        Boolean r60 = r38.j;
        Boolean r61 = Boolean.TRUE;
        if (Intrinsics.areEqual(r60, r61) == false) goto L166;
        int r316 = 0;
    L167:
        fm8.q r62 = new fm8.q(r212, r213, r214, r313, r314, r312, r315, r316, r38.d, !r38.e, r310, r311, r38.p, r410, Intrinsics.areEqual(r38.k, r61), Intrinsics.areEqual(r38.l, r61), r38.m, r38.b, r38.a, r38.r, r411, r38.q);
        gm8.b r63 = (gm8.b) r35.c.getValue();
        r63.getClass();
        ((MarkdownContainerView) r35.b.getValue()).a(r62, new gm8.c(r63));
        return;
    L166:
        r316 = -1;
        goto L167
    L162:
        r315 = 0;
    L158:
        r58 = r38.s;
        goto L159
    L153:
        r410 = false;
        goto L154
    L149:
        r314 = false;
        goto L150
    L145:
        r313 = false;
        goto L146
    L138:
        r52 = i5.H();
        goto L139
    L134:
        r48 = i5.t();
        goto L135
    L130:
        r212 = 0;
        goto L131
    L123:
        r44 = null;
    L126:
        r40 = r44;
        goto L127
    L175:
        return;
    L98:
        r33 = null;
        goto L99
    L95:
        r32 = null;
        goto L96
    L91:
        r211 = null;
        goto L92
    L78:
        r51 = r1;
        r27 = r117;
        boolean r64 = r2.m();
        boolean r65 = r2.n();
        float r119 = r25.top;
        float r120 = r25.bottom;
        r29 = r13;
        float r121 = r25.left;
        float r66 = r25.right;
        if (r64 == false) goto L83;
        if (r65 == false) goto L83;
        r28 = new RectF(r121, r119, r66, j(r2, r120));
    L83:
        r210 = r112;
        if (r64 == false) goto L86;
        r30 = new RectF(r121, r119, r66, r120 / 2);
        goto L89
    L86:
        if (r65 == false) goto L88;
        r30 = new RectF(r121, r119 / 2, r66, j(r2, r120));
        goto L89
    L88:
        float r67 = 2;
        r30 = new RectF(r121, r119 / r67, r66, r120 / r67);
        goto L89
    L75:
        r25 = null;
        goto L76
    L71:
        r22 = null;
        goto L72
    L68:
        r116 = null;
        goto L69
    L65:
        r115 = null;
        goto L66
    L62:
        r114 = null;
        goto L63
    L59:
        r113 = null;
        goto L60
    L44:
        if (r2.j().getMessageStatusLocal() != 23) goto L46;
    L54:
        r112 = true;
        goto L56
    L46:
        if (r2.j().getMessageStatusLocal() != 22) goto L55;
    L49:
        if (r2.j().getMessageStatusLocal() == 23) goto L53;
        if (r2.j().getMessageStatusLocal() != 22) goto L55;
    L53:
        if (r2.n() == false) goto L55;
    L25:
        r12 = false;
        goto L26
    L21:
        r11 = null;
        goto L23
    L17:
        r9 = i5.H();
        goto L18
    L14:
        r8 = i5.t();
        goto L15
    L11:
        r7 = v19.c.b(2130972079, r6, 2131103136);
    L8:
        r6 = AppHost.a.getApplication();
        goto L9
    }

    @Override // jc8.b
    public final View h(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "viewGroup");
        dm8.c r0 = new dm8.c(r2.getContext());
        MarkdownContainerView r3 = (MarkdownContainerView) r0.b.getValue();
        this.d = r0;
        return r3;
    }

    public final float j(fb8.m r2, float r3) {
        if (r2.n() == true) goto L6;
        return r3;
    L6:
        if (com.larus.platform.exp.h.a == false) goto L8;
        boolean r0 = this.e;
    L9:
        if (r0 == true) goto L11;
        return r3;
    L11:
        if (h0.a(r2) == true) goto L13;
        return r3;
    L13:
        return ((Number) h0.a.getValue()).intValue();
    L8:
        r0 = z2.a.enableMarkdownContainerAppletLastBlockInset();
        goto L9
    }
}
