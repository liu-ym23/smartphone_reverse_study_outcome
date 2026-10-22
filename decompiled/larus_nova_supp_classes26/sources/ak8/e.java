package ak8;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import bk8.f;
import bk8.i;
import cb8.x1;
import ck8.g;
import ck8.h;
import com.larus.bmhome.chat.standarduikit.complextask.blockadapter.view.ComplexTaskColorCapsuleView;
import com.larus.bmhome.chat.standarduikit.floatingthink.view.FloatingThinkView;
import com.larus.bmhome.chat.standarduikit.generictool.view.GenericToolView;
import com.larus.bmhome.chat.standarduikit.generictool.view.GenericToolViewStage;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.ComplexTaskBlock;
import com.larus.im.bean.message.block.ComplexTaskStatus;
import com.larus.im.bean.message.block.DisplayColor;
import com.larus.im.bean.message.block.DisplayHeader;
import com.larus.im.bean.message.block.DisplayOriginIcon;
import com.larus.utils.o0;
import dk8.j;
import dk8.k;
import dk8.l;
import kc8.m;
import kc8.x;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class e extends jc8.b<ak8.a> {
    public FrameLayout d;
    public bk8.c e;
    public f f;
    public i g;
    public GenericToolView h;
    public ComplexTaskColorCapsuleView i;
    public FloatingThinkView j;
    public kc8.b k;
    public ak8.a l;
    public final Lazy m;
    public final Lazy n;

    public static final class a implements kl8.b {
        public final Function0<Unit> a;

        @Override // kl8.b
        public final void b(Message r1, String r2, int r3) {
        }

        @Override // kl8.b
        public final void a() {
            this.a.invoke();
        }

        public a(d r2) {
            Intrinsics.checkNotNullParameter(r2, "onClick");
            this.a = r2;
        }
    }

    public static final class b implements dk8.f {
        public final /* synthetic */ e a;

        @Override // dk8.f
        public final void a() {
            e r0 = this.a;
            r0.j(r0.l);
        }

        public b(e r1) {
            this.a = r1;
        }
    }

    public final String c() {
        return "ComplexTaskBlockHolder";
    }

    public final void i() {
        i r0 = this.g;
        if (r0 == null) goto L5;
        ((FloatingThinkView) r0.b.getValue()).c();
    L5:
        f r1 = this.f;
        if (r1 == null) goto L9;
        ((ComplexTaskColorCapsuleView) r1.b.getValue()).c();
        return;
    }

    public e() {
        this.m = LazyKt.lazy(new ak8.b(this));
        this.n = LazyKt.lazy(new c(this));
    }

    public final jc8.d f(jc8.a r2) {
        ak8.a r3 = (ak8.a) r2;
        Intrinsics.checkNotNullParameter(r3, "blockModel");
        return jc8.e.d(r3);
    }

    public final void g(jc8.a r25) {
        ak8.a r1 = (ak8.a) r25;
        Intrinsics.checkNotNullParameter(r1, "blockModel");
        this.l = r1;
        this.k = jc8.c.a(this, kc8.b.class);
        ((a) this.m.getValue()).getClass();
        FrameLayout r2 = this.d;
        if (r2 == null) goto L278;
        kc8.b r3 = this.k;
        boolean r4 = false;
        if (r3 == null) goto L10;
        m r5 = r3.u;
        if (r5 == null) goto L10;
        boolean r6 = r5.a;
    L11:
        BlockContent r7 = ((jc8.a) r1).a.getContent();
        Function0 r8 = null;
        if (r7 == null) goto L18;
        ComplexTaskBlock r9 = r7.getComplexTaskBlock();
        if (r9 == null) goto L18;
        DisplayHeader r10 = r9.header;
        if (r10 == null) goto L18;
        DisplayOriginIcon r11 = r10.getOriginIcon();
    L20:
        if (r11 == null) goto L114;
        FloatingThinkView r12 = this.j;
        if (r12 != null) goto L24;
    L26:
        GenericToolView r13 = this.h;
        if (r13 != null) goto L29;
    L31:
        f r14 = this.f;
        if (r14 != null) goto L34;
        r14 = new f(r2.getContext());
        this.f = r14;
    L34:
        ComplexTaskColorCapsuleView r15 = this.i;
        if (r15 != null) goto L38;
        r15 = (ComplexTaskColorCapsuleView) r14.b.getValue();
        this.i = r15;
    L38:
        if (r15.getParent() != null) goto L40;
        r2.addView(r15, new FrameLayout.LayoutParams(-1, -2));
    L40:
        Block r16 = ((jc8.a) r1).a;
        int r17 = x1.b(((jc8.b) this).a, r1, ak8.a.class);
        BlockContent r18 = r16.getContent();
        if (r18 == null) goto L43;
        ComplexTaskBlock r19 = r18.getComplexTaskBlock();
    L44:
        Pair r110 = new Pair(0, 0);
        Message r111 = r1.j();
        if (r1.j().getMessageStatusLocal() != 23) goto L47;
        boolean r112 = true;
    L48:
        kc8.b r20 = this.k;
        if (r20 == null) goto L53;
        x r21 = r20.i;
        if (r21 == null) goto L53;
        Integer r113 = r21.a;
    L54:
        if (r19 == null) goto L56;
        String r22 = r19.threadId;
    L57:
        boolean r114 = o0.d(r22);
        if (r19 == null) goto L60;
        String r23 = r19.threadId;
    L61:
        dk8.i r24 = new dk8.i(r110, r111, r19, r112, r17, r113, r114, o0.d(r23));
        a r26 = (a) this.m.getValue();
        Intrinsics.checkNotNullParameter(r24, "vmData");
        dk8.c r27 = (dk8.c) r14.c.getValue();
        r27.getClass();
        Intrinsics.checkNotNullParameter(r24, "vmData");
        r27.b = r24;
        r27.c = r26;
        ComplexTaskColorCapsuleView r28 = (ComplexTaskColorCapsuleView) r14.b.getValue();
        dk8.c r29 = (dk8.c) r14.c.getValue();
        dk8.i r30 = r29.b;
        if (r30 != null) goto L64;
        g r31 = new g(0);
    L106:
        final dk8.c r32 = (dk8.c) r14.c.getValue();
        r32.getClass();
        Function0 r33 = new dk8.a(r32);
        dk8.i r34 = r32.b;
        if (r34 != null) goto L109;
    L111:
        if (r4 == false) goto L113;
        r8 = new dk8.b(r32);
    L113:
        r28.b(r31, new h(r33, r8));
        return;
    L109:
        if (r34.h != true) goto L111;
        r4 = true;
        goto L111
    L64:
        ComplexTaskBlock r35 = r30.c;
        if (r35 != null) goto L67;
        r31 = new g(0);
        goto L106
    L67:
        DisplayHeader r36 = r35.header;
        boolean r115 = v19.h.a;
        boolean r37 = v19.h.a(r29.a);
        if (r36 == null) goto L75;
        DisplayOriginIcon r116 = r36.getOriginIcon();
        if (r116 == null) goto L75;
        if (r37 == false) goto L73;
        String r117 = r116.getIconUrlDark();
    L74:
        String r118 = r117;
    L76:
        if (r36 == null) goto L78;
        String r119 = r36.getName();
    L79:
        if (r36 == null) goto L83;
        DisplayColor r120 = r36.getFontColor();
        if (r120 == null) goto L83;
        Integer r121 = dk8.d.a(r120, r37);
    L84:
        if (r36 == null) goto L88;
        DisplayColor r122 = r36.getBackgroundColor();
        if (r122 == null) goto L88;
        Integer r123 = dk8.d.a(r122, r37);
    L89:
        if (r36 == null) goto L91;
        String r124 = r36.getSummary();
    L92:
        Integer r38 = r35.status;
        int r39 = ComplexTaskStatus.PROCESSING.getValue();
        if (r38 != null) goto L96;
    L100:
        boolean r125 = false;
    L101:
        boolean r40 = r30.g;
        Pair<Integer, Integer> r41 = r30.a;
        Message r42 = r30.b;
        if (r42 == null) goto L104;
        String r210 = r42.getMessageId();
    L105:
        r31 = new g(r118, r119, r121, r123, r124, r125, r40, r41, r210, r30.e, r30.f);
        goto L106
    L104:
        r210 = null;
        goto L105
    L96:
        if (r38.intValue() != r39) goto L100;
        if (r30.d == true) goto L100;
        r125 = true;
        goto L101
    L91:
        r124 = null;
    L88:
        r123 = null;
    L83:
        r121 = null;
        goto L84
    L78:
        r119 = null;
        goto L79
    L73:
        r117 = r116.getIconUrlLight();
    L75:
        r118 = null;
        goto L76
    L60:
        r23 = null;
        goto L61
    L56:
        r22 = null;
    L53:
        r113 = null;
        goto L54
    L47:
        r112 = false;
        goto L48
    L43:
        r19 = null;
        goto L44
    L29:
        if (r13.getParent() != r2) goto L31;
        r2.removeView(r13);
        goto L31
    L24:
        if (r12.getParent() != r2) goto L26;
        r2.removeView(r12);
        goto L26
    L114:
        if (r6 == false) goto L209;
        FloatingThinkView r43 = this.j;
        if (r43 != null) goto L118;
    L120:
        ComplexTaskColorCapsuleView r44 = this.i;
        if (r44 != null) goto L123;
    L125:
        bk8.c r45 = this.e;
        if (r45 != null) goto L128;
        r45 = new bk8.c(r2.getContext());
        this.e = r45;
    L128:
        GenericToolView r46 = this.h;
        if (r46 != null) goto L132;
        r46 = (GenericToolView) r45.b.getValue();
        this.h = r46;
    L132:
        if (r46.getParent() != null) goto L134;
        r2.addView(r46, new FrameLayout.LayoutParams(-1, -2));
    L134:
        Block r47 = ((jc8.a) r1).a;
        int r126 = x1.b(((jc8.b) this).a, r1, ak8.a.class);
        BlockContent r48 = r47.getContent();
        if (r48 == null) goto L137;
        ComplexTaskBlock r127 = r48.getComplexTaskBlock();
    L138:
        Pair r128 = new Pair(0, 0);
        Message r129 = r1.j();
        if (r1.j().getMessageStatusLocal() != 23) goto L141;
        boolean r130 = true;
    L142:
        kc8.b r49 = this.k;
        if (r49 == null) goto L147;
        x r50 = r49.i;
        if (r50 == null) goto L147;
        Integer r131 = r50.a;
    L148:
        if (r127 == null) goto L150;
        String r51 = r127.threadId;
    L151:
        boolean r132 = o0.d(r51);
        if (r127 == null) goto L154;
        String r52 = r127.threadId;
    L155:
        dk8.i r53 = new dk8.i(r128, r129, r127, r130, r126, r131, r132, o0.d(r52));
        a r54 = (a) this.m.getValue();
        Intrinsics.checkNotNullParameter(r53, "vmData");
        l r55 = (l) r45.c.getValue();
        r55.getClass();
        Intrinsics.checkNotNullParameter(r53, "vmData");
        r55.a = r53;
        r55.b = r54;
        dk8.i r56 = ((l) r45.c.getValue()).a;
        if (r56 != null) goto L158;
        jl8.f r57 = new jl8.f(null, null, null, null, null, null, 0, null, false, false, false, 0, 0, 0, 16383);
    L201:
        final l r58 = (l) r45.c.getValue();
        r58.getClass();
        Function0 r59 = new j(r58);
        dk8.i r60 = r58.a;
        if (r60 != null) goto L204;
    L206:
        if (r4 == false) goto L208;
        r8 = new k(r58);
    L208:
        ((GenericToolView) r45.b.getValue()).a(r57, new jl8.g(r59, r8));
        return;
    L204:
        if (r60.h != true) goto L206;
        r4 = true;
        goto L206
    L158:
        ComplexTaskBlock r61 = r56.c;
        if (r61 != null) goto L161;
        r57 = new jl8.f(null, null, null, null, null, null, 0, null, false, false, false, 0, 0, 0, 16383);
        goto L201
    L161:
        Integer r62 = r61.status;
        int r63 = ComplexTaskStatus.PROCESSING.getValue();
        if (r62 != null) goto L165;
    L169:
        boolean r64 = false;
    L170:
        if (r64 == false) goto L172;
        GenericToolViewStage r65 = GenericToolViewStage.LOADING;
    L173:
        GenericToolViewStage r133 = r65;
        boolean r134 = Intrinsics.areEqual(r61.agentType, "aily_partner");
        DisplayHeader r66 = r61.header;
        if (r66 == null) goto L176;
        String r67 = r66.getIconUrl();
    L177:
        DisplayHeader r68 = r61.header;
        if (r68 == null) goto L180;
        String r135 = r68.getIconUrlDark();
    L181:
        DisplayHeader r69 = r61.header;
        if (r69 == null) goto L184;
        String r136 = r69.getSummary();
    L185:
        Pair<Integer, Integer> r137 = r56.a;
        Message r70 = r56.b;
        if (r70 == null) goto L188;
        String r138 = r70.getMessageId();
    L189:
        int r139 = r56.e;
        Integer r71 = r56.f;
        boolean r72 = r56.g;
        if (r134 == false) goto L192;
        int r73 = i5.v();
    L193:
        int r211 = r73;
        if (r134 == false) goto L196;
        int r212 = i5.r0();
    L197:
        if (r134 == false) goto L199;
        int r74 = i5.j0();
    L200:
        r57 = new jl8.f(r67, r135, r136, r133, r137, r138, r139, r71, r72, false, r134, r211, r212, r74, 512);
        goto L201
    L199:
        r74 = i5.Y();
        goto L200
    L196:
        r212 = 0;
        goto L197
    L192:
        r73 = i5.E();
        goto L193
    L188:
        r138 = null;
        goto L189
    L184:
        r136 = null;
        goto L185
    L180:
        r135 = null;
        goto L181
    L176:
        r67 = null;
        goto L177
    L172:
        r65 = GenericToolViewStage.FINISHED;
        goto L173
    L165:
        if (r62.intValue() != r63) goto L169;
        if (r56.d == true) goto L169;
        r64 = true;
        goto L170
    L154:
        r52 = null;
        goto L155
    L150:
        r51 = null;
    L147:
        r131 = null;
        goto L148
    L141:
        r130 = false;
        goto L142
    L137:
        r127 = null;
        goto L138
    L123:
        if (r44.getParent() != r2) goto L125;
        r2.removeView(r44);
        goto L125
    L118:
        if (r43.getParent() != r2) goto L120;
        r2.removeView(r43);
        goto L120
    L209:
        GenericToolView r75 = this.h;
        if (r75 != null) goto L212;
    L214:
        ComplexTaskColorCapsuleView r76 = this.i;
        if (r76 != null) goto L217;
    L219:
        i r77 = this.g;
        if (r77 != null) goto L222;
        r77 = new i(r2.getContext());
        this.g = r77;
    L222:
        FloatingThinkView r78 = this.j;
        if (r78 != null) goto L226;
        r78 = (FloatingThinkView) r77.b.getValue();
        this.j = r78;
    L226:
        if (r78.getParent() != null) goto L228;
        r2.addView(r78, new FrameLayout.LayoutParams(-1, -2));
    L228:
        BlockContent r79 = ((jc8.a) r1).a.getContent();
        if (r79 == null) goto L231;
        ComplexTaskBlock r140 = r79.getComplexTaskBlock();
    L232:
        Message r141 = r1.j();
        if (r1.j().getMessageStatusLocal() != 23) goto L235;
        boolean r142 = true;
    L236:
        if (r140 == null) goto L238;
        String r80 = r140.threadId;
    L239:
        boolean r143 = o0.d(r80);
        if (r140 == null) goto L242;
        String r81 = r140.threadId;
    L243:
        dk8.e r82 = new dk8.e(r141, r140, r142, r143, o0.d(r81));
        b r83 = (b) this.n.getValue();
        Intrinsics.checkNotNullParameter(r82, "vmData");
        dk8.h r84 = (dk8.h) r77.c.getValue();
        r84.getClass();
        Intrinsics.checkNotNullParameter(r82, "vmData");
        r84.a = r82;
        r84.b = r83;
        dk8.e r85 = ((dk8.h) r77.c.getValue()).a;
        if (r85 != null) goto L246;
        fl8.d r86 = new fl8.d(null, false, false, false, null, 63);
    L267:
        final dk8.h r87 = (dk8.h) r77.c.getValue();
        r87.getClass();
        dk8.e r88 = r87.a;
        if (r88 != null) goto L270;
    L272:
        if (r4 == false) goto L274;
        r8 = new dk8.g(r87);
    L274:
        ((FloatingThinkView) r77.b.getValue()).a(r86, new fl8.e(r8));
        return;
    L270:
        if (r88.e != true) goto L272;
        r4 = true;
        goto L272
    L246:
        ComplexTaskBlock r89 = r85.b;
        if (r89 != null) goto L249;
        r86 = new fl8.d(null, false, false, false, null, 63);
        goto L267
    L249:
        Integer r90 = r89.status;
        int r91 = ComplexTaskStatus.PROCESSING.getValue();
        if (r90 != null) goto L253;
    L257:
        boolean r144 = false;
    L258:
        DisplayHeader r92 = r89.header;
        if (r92 == null) goto L261;
        String r93 = r92.getSummary();
    L262:
        boolean r145 = r85.d;
        boolean r146 = r85.e;
        DisplayHeader r94 = r89.header;
        if (r94 == null) goto L265;
        String r147 = r94.getIconUrl();
    L266:
        r86 = new fl8.d(r93, r145, r144, r146, r147, 4);
        goto L267
    L265:
        r147 = null;
        goto L266
    L261:
        r93 = null;
        goto L262
    L253:
        if (r90.intValue() != r91) goto L257;
        if (r85.c == true) goto L257;
        r144 = true;
        goto L258
    L242:
        r81 = null;
        goto L243
    L238:
        r80 = null;
        goto L239
    L235:
        r142 = false;
        goto L236
    L231:
        r140 = null;
        goto L232
    L217:
        if (r76.getParent() != r2) goto L219;
        r2.removeView(r76);
        goto L219
    L212:
        if (r75.getParent() != r2) goto L214;
        r2.removeView(r75);
    L18:
        r11 = null;
    L10:
        r6 = false;
        goto L11
    }

    public final View h(ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r4, "viewGroup");
        FrameLayout r0 = new FrameLayout(r4.getContext());
        r0.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.d = r0;
        return r0;
    }

    public final void j(ak8.a r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        Message r0 = r3.j();
        BlockContent r4 = ((jc8.a) r3).a.getContent();
        if (r4 == null) goto L27;
        ComplexTaskBlock r5 = r4.getComplexTaskBlock();
        if (r5 == null) goto L29;
        String r1 = r5.threadId;
        if (r1 != null) goto L12;
    L15:
        boolean r2 = true;
    L16:
        if (r2 == false) goto L18;
        return;
    L18:
        kc8.b r6 = this.k;
        if (r6 == null) goto L23;
        m r7 = r6.u;
        if (r7 == null) goto L23;
        Function2 r8 = r7.c;
    L24:
        if (r8 == null) goto L28;
        r8.invoke(r0, r5);
        return;
    L28:
        return;
    L23:
        r8 = null;
        goto L24
    L12:
        if (r1.length() == 0) goto L15;
        r2 = false;
        goto L16
    L29:
        return;
    }
}
