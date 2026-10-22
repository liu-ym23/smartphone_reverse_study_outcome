package fk8;

import android.R;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.block.base.config.ToolBlockInitStatus;
import com.larus.bmhome.chat.block.base.config.ToolBlockInteractType;
import com.larus.bmhome.chat.deepresearch.view.j;
import com.larus.bmhome.chat.markdown.reference.ToolType;
import com.larus.bmhome.chat.markdown.view.DeepThinkCommonToolHeader;
import com.larus.bmhome.chat.monitor.IMessageImageLoaderService;
import com.larus.bmhome.chat.monitor.MessageImageLoader;
import com.larus.bmhome.chat.monitor.MessageImageType;
import com.larus.bmhome.chat.standarduikit.coderenderandinterceptor.view.FlowMarkdownCodeView;
import com.larus.bmhome.chat.standarduikit.computerusetool.api.CuaApi;
import com.larus.bmhome.chat.standarduikit.computerusetool.view.ComputerUseToolResultView;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.CuaCodeBlock;
import com.larus.im.bean.message.block.CuaCodeBlockImage;
import com.larus.im.bean.message.block.DisplayHeader;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.utils.e1;
import gk8.g;
import jc8.e;
import jc8.f;
import kc8.i0;
import kc8.w0;
import kc8.y;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class d extends jc8.b<fk8.a> {
    public ek8.d d;

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

    public final String c() {
        return "ComputerUseToolResultBlockHolder";
    }

    public final void i() {
        ek8.d r0 = this.d;
        if (r0 == null) goto L8;
        oj8.c r1 = r0.d;
        if (r1 == null) goto L9;
        r1.c();
        return;
    L9:
        return;
    }

    public d() {
    }

    public final jc8.d f(jc8.a r2) {
        fk8.a r3 = (fk8.a) r2;
        Intrinsics.checkNotNullParameter(r3, "blockModel");
        return e.d(r3);
    }

    public final /* bridge */ /* synthetic */ void g(jc8.a r1) {
        j((fk8.a) r1);
    }

    public final View h(ViewGroup r6) {
        Intrinsics.checkNotNullParameter(r6, "viewGroup");
        ek8.d r0 = new ek8.d(r6.getContext());
        this.d = r0;
        r0.c = new ComputerUseToolResultView(r0.a, null, 6, 0);
        oj8.c r7 = new oj8.c(r0.a);
        r0.d = r7;
        ComputerUseToolResultView r1 = r0.c;
        if (r1 == null) goto L8;
        FlowMarkdownCodeView r8 = r7.b();
        if (r8 == null) goto L8;
        r1.a.c.addView(r8);
    L8:
        ConstraintLayout r9 = r0.c;
        if (r9 == null) goto L12;
        return r9;
    L12:
        return new ComputerUseToolResultView(r0.a, null, 6, 0);
    }

    /* JADX WARN: Type inference failed for: r3v6, types: [fk8.c] */
    /* JADX WARN: Type inference failed for: r7v0, types: [fk8.b] */
    public final void j(final fk8.a r56) {
        Intrinsics.checkNotNullParameter(r56, "blockModel");
        ek8.d r2 = this.d;
        if (r2 == null) goto L262;
        BlockContent r3 = ((jc8.a) r56).a.getContent();
        if (r3 == null) goto L7;
        CuaCodeBlock r4 = r3.getCuaCodeBlock();
    L8:
        kc8.b r5 = jc8.c.a(this, kc8.b.class);
        if (r5 == null) goto L11;
        final w0 r6 = r5.v;
    L12:
        jc8.a r7 = r56.k();
        int r12 = 0;
    L13:
        if (r7 == null) goto L15;
        r12 = r12 + 1;
        r7 = r7.k();
        goto L13
    L15:
        String r8 = ((jc8.a) r56).a.getBlockId();
        if (r8 != null) goto L18;
        String r9 = "";
    L19:
        Message r10 = r56.j();
        kc8.b r11 = jc8.c.a(this, kc8.b.class);
        if (r11 == null) goto L22;
        y r13 = r11.a;
    L23:
        if (r4 == null) goto L27;
        DisplayHeader r14 = r4.getHeader();
        if (r14 == null) goto L27;
        String r15 = r14.getSummary();
    L28:
        if (r15 != null) goto L30;
        String r16 = "";
    L31:
        if (r4 == null) goto L33;
        String r17 = r4.getContent();
    L34:
        if (r17 != null) goto L36;
        String r18 = "";
    L37:
        if (r4 == null) goto L41;
        CuaCodeBlockImage r19 = r4.getImage();
        if (r19 == null) goto L41;
        String r20 = r19.getUri();
    L42:
        if (r20 != null) goto L44;
        String r110 = "";
    L45:
        if (r4 == null) goto L49;
        CuaCodeBlockImage r21 = r4.getImage();
        if (r21 == null) goto L49;
        String r22 = r21.getUrl();
    L50:
        if (r22 != null) goto L52;
        String r111 = "";
    L53:
        if (r4 == null) goto L57;
        Integer r23 = r4.getStatus();
        if (r23 == null) goto L57;
        int r112 = r23.intValue();
    L58:
        f r24 = ((jc8.a) r56).d;
        if (r24 == null) goto L79;
        jc8.a r25 = r24.c;
        if (r25 != null) goto L63;
    L65:
        boolean r26 = false;
    L66:
        if (r26 == true) goto L76;
        i0 r27 = r24.e;
        if (r27 != null) goto L70;
    L72:
        boolean r28 = false;
    L73:
        if (r28 == true) goto L76;
        boolean r29 = false;
    L77:
        if (r29 != true) goto L79;
        boolean r113 = true;
    L80:
        if (r4 == null) goto L84;
        DisplayHeader r30 = r4.getHeader();
        if (r30 == null) goto L84;
        String r31 = r30.getIconUrlDark();
    L85:
        if (r31 != null) goto L87;
        String r114 = "";
    L88:
        if (r4 == null) goto L92;
        DisplayHeader r32 = r4.getHeader();
        if (r32 == null) goto L92;
        String r33 = r32.getIconUrl();
    L93:
        if (r33 != null) goto L95;
        String r210 = "";
    L96:
        ?? r34 = new c(r6, this, r56);
        if (r6 == null) goto L99;
        ToolBlockInteractType r35 = r6.a;
    L101:
        if (r35 != ToolBlockInteractType.DisableHeaderInteract) goto L103;
        boolean r211 = true;
    L104:
        if (r6 == null) goto L106;
        ToolBlockInitStatus r36 = r6.b;
    L108:
        if (r36 != null) goto L110;
        int r37 = -1;
    L112:
        if (r37 == (-1)) goto L123;
        if (r37 == 1) goto L121;
        if (r37 != 2) goto L116;
        Boolean r38 = Boolean.FALSE;
    L122:
        Boolean r212 = r38;
    L124:
        hk8.a r39 = new hk8.a(r9, r10, r13, r12, r16, r18, r110, r111, r112, r113, r114, r210, r34, r211, r212);
        hk8.c r40 = new hk8.c(new b(this, r56));
        Intrinsics.checkNotNullParameter(r39, "vmData");
        hk8.e r41 = (hk8.e) r2.b.getValue();
        r41.getClass();
        Intrinsics.checkNotNullParameter(r39, "vmData");
        r41.b = r39;
        r41.c = r40;
        if (Intrinsics.areEqual(r41.d, r39.a) == true) goto L131;
        Boolean r1 = r39.o;
        if (r1 == null) goto L129;
        boolean r42 = r1.booleanValue();
    L130:
        r41.a = r42;
        r41.d = r39.a;
        goto L131
    L129:
        r42 = false;
    L131:
        final ComputerUseToolResultView r43 = r2.c;
        if (r43 == null) goto L212;
        hk8.e r44 = (hk8.e) r2.b.getValue();
        r44.getClass();
        boolean r45 = r44.a;
        hk8.a r46 = r44.b;
        if (r46 != null) goto L136;
    L138:
        boolean r47 = false;
    L139:
        if (r46 != null) goto L141;
    L143:
        boolean r115 = false;
    L144:
        if (r46 == null) goto L146;
        String r48 = r46.e;
    L147:
        if (r48 != null) goto L149;
        String r116 = "";
    L150:
        if (r46 == null) goto L152;
        String r49 = r46.g;
    L153:
        if (r49 != null) goto L155;
        String r117 = "";
    L156:
        if (r46 == null) goto L158;
        String r50 = r46.h;
    L159:
        if (r50 != null) goto L161;
        String r118 = "";
    L162:
        if (r46 != null) goto L164;
    L166:
        boolean r119 = false;
    L167:
        if (r46 == null) goto L169;
        String r51 = r46.k;
    L170:
        if (r51 != null) goto L172;
        String r120 = "";
    L173:
        if (r46 == null) goto L175;
        String r52 = r46.l;
    L176:
        if (r52 != null) goto L178;
        r52 = "";
    L178:
        final gk8.a r121 = new gk8.a(r45, r47, r115, r116, r117, r118, r119, r120, r52);
        final hk8.e.a r53 = (hk8.e.a) ((hk8.e) r2.b.getValue()).e.getValue();
        Intrinsics.checkNotNullParameter(r121, "input");
        Intrinsics.checkNotNullParameter(r53, "output");
        DeepThinkCommonToolHeader r54 = r43.a.b;
        ToolType r55 = ToolType.BrowserControl;
        r54.b(r55, r121.b, r121.i, r121.h);
        DeepThinkCommonToolHeader r57 = r43.a.b;
        String r122 = r121.d;
        boolean r123 = r121.a;
        Boolean r58 = Boolean.valueOf(r121.b);
        if (r58.booleanValue() == false) goto L181;
        Boolean r124 = r58;
    L183:
        if (r121.c == false) goto L185;
        Function0 r125 = null;
    L186:
        r57.d(r55, r122, r123, r124, r125);
        r43.a.b.setBackgroundResource(R.color.transparent);
        final String r59 = r121.f;
        final int r60 = r43.b + 1;
        r43.b = r60;
        if (r59.length() <= 0) goto L189;
        boolean r61 = true;
    L190:
        if (r61 == true) goto L192;
    L194:
        final boolean r126 = false;
    L195:
        if (r61 == false) goto L197;
        IMessageImageLoaderService.a.b(MessageImageLoader.a, null, MessageImageType.IMAGE, r43.a.d, r59, "ComputerUseToolResultCover", null, null, new gk8.d(r43, r60, r121), new gk8.e(r43, r60, r126), new gk8.f(r43, r60, r121), false, 1120);
    L199:
        if (r121.g == false) goto L202;
        if (r126 == false) goto L202;
        e1.x(r43.a.e);
        r43.a.e.c();
    L205:
        if (r121.a == false) goto L207;
        e1.o(r43.a.c);
        e1.o(r43.a.d);
        e1.o(r43.a.f);
        e1.o(r43.a.e);
        r43.a.e.a();
    L211:
        e1.d(r43.a.d, new g(r121, r59, r53));
        goto L212
    L207:
        e1.x(r43.a.c);
        if (r61 == false) goto L210;
        e1.x(r43.a.d);
        e1.x(r43.a.f);
        goto L211
    L210:
        e1.o(r43.a.d);
        e1.o(r43.a.f);
    L202:
        if (r126 == true) goto L205;
        e1.o(r43.a.e);
        r43.a.e.a();
        goto L205
    L197:
        ImageLoaderKt.u(r43.a.d, r59, null);
        goto L199
    L192:
        if (r121.a == true) goto L194;
        r126 = true;
        goto L195
    L189:
        r61 = false;
        goto L190
    L185:
        r125 = new gk8.c(r53);
        goto L186
    L181:
        r124 = null;
        goto L183
    L175:
        r52 = null;
        goto L176
    L172:
        r120 = r51;
        goto L173
    L169:
        r51 = null;
        goto L170
    L164:
        if (r46.i != 1) goto L166;
        r119 = true;
        goto L167
    L161:
        r118 = r50;
        goto L162
    L158:
        r50 = null;
        goto L159
    L155:
        r117 = r49;
        goto L156
    L152:
        r49 = null;
        goto L153
    L149:
        r116 = r48;
        goto L150
    L146:
        r48 = null;
        goto L147
    L141:
        if (r46.n != true) goto L143;
        r115 = true;
        goto L144
    L136:
        if (r46.n != true) goto L138;
        r47 = true;
    L212:
        final y r62 = r39.c;
        oj8.c r63 = r2.d;
        if (r63 != null) goto L215;
        return;
    L215:
        if (r62 == null) goto L222;
        Function0 r64 = r62.l;
        if (r64 == null) goto L222;
        BotModel r65 = (BotModel) r64.invoke();
        if (r65 == null) goto L222;
        String r66 = r65.getBotId();
        if (r66 == null) goto L222;
    L223:
        String r213 = r66;
        Message r67 = r39.b;
        if (r62 == null) goto L226;
        boolean r214 = r62.a();
    L227:
        if (r62 == null) goto L229;
        Long r215 = r62.b;
    L230:
        int r68 = r39.d;
        if (r62 == null) goto L233;
        by7.e r310 = r62.c;
    L234:
        if (r62 == null) goto L236;
        RecyclerView r311 = r62.d;
    L237:
        Function0 r69 = new ek8.b(r62);
        Function0 r127 = new ek8.c(r62);
        Context r128 = r2.a;
        int r129 = ContextCompat.getColor(r128, v19.c.b(2130972087, r128, 2131103162));
        float r70 = r2.a.getResources().getDimension(v19.c.b(2130971163, r2.a, 2131166696));
        hh8.a r130 = new hh8.a(true, false, true, Integer.valueOf(r129), Float.valueOf(r70), true, 2);
        if (r62 == null) goto L240;
        Function0 r312 = r62.s;
    L241:
        if (r62 == null) goto L247;
        Function0 r71 = r62.m;
        if (r71 == null) goto L247;
        ChatParam r72 = (ChatParam) r71.invoke();
        if (r72 == null) goto L247;
        String r313 = r72.d;
    L248:
        String r73 = r39.f;
        String r410 = CuaApi.a.a();
        if (r39.i != 2) goto L251;
        boolean r411 = true;
    L252:
        boolean r74 = r39.j;
        if (r62 == null) goto L255;
        q0 r412 = r62.x;
    L256:
        if (r62 == null) goto L258;
        q0.a r413 = r62.u;
    L259:
        r63.a(new rj8.a(r213, r67, r214, r215, r68, r310, r311, r69, r127, r130, r312, r313, r73, null, r410, r411, r74, null, null, r412, r413, null, null, false, false, null, null, null, 266731520), null);
        return;
    L258:
        r413 = null;
        goto L259
    L255:
        r412 = null;
        goto L256
    L251:
        r411 = false;
    L247:
        r313 = null;
        goto L248
    L240:
        r312 = null;
        goto L241
    L236:
        r311 = null;
        goto L237
    L233:
        r310 = null;
        goto L234
    L229:
        r215 = null;
        goto L230
    L226:
        r214 = false;
    L222:
        r66 = r39.b.getSenderId();
        goto L223
    L116:
        if (r37 == 3) goto L123;
        throw new NoWhenBranchMatchedException();
    L121:
        r38 = Boolean.TRUE;
    L123:
        r212 = null;
        goto L124
    L110:
        r37 = a.a[r36.ordinal()];
        goto L112
    L106:
        r36 = null;
        goto L108
    L103:
        r211 = false;
        goto L104
    L99:
        r35 = null;
        goto L101
    L95:
        r210 = r33;
    L92:
        r33 = null;
        goto L93
    L87:
        r114 = r31;
    L84:
        r31 = null;
        goto L85
    L70:
        if (r27.b != j.A) goto L72;
        r28 = true;
    L76:
        r29 = true;
        goto L77
    L63:
        if (r25.l() != j.A) goto L65;
        r26 = true;
    L79:
        r113 = false;
    L57:
        r112 = 0;
        goto L58
    L52:
        r111 = r22;
    L49:
        r22 = null;
        goto L50
    L44:
        r110 = r20;
    L41:
        r20 = null;
        goto L42
    L36:
        r18 = r17;
        goto L37
    L33:
        r17 = null;
        goto L34
    L30:
        r16 = r15;
    L27:
        r15 = null;
        goto L28
    L22:
        r13 = null;
        goto L23
    L18:
        r9 = r8;
        goto L19
    L11:
        r6 = null;
        goto L12
    L7:
        r4 = null;
        goto L8
    }
}
