package sg8;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import androidx.collection.LruCache;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.bean.DeepThinkFoldStatus;
import com.larus.bmhome.chat.cell.BaseMessageListCell;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.bmhome.chat.component.share.IChatMessageShareAbility;
import com.larus.bmhome.chat.search.LruSet;
import com.larus.chat.gallery.api.PreviewScene;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MultiReference;
import com.larus.im.bean.message.Reference;
import com.larus.im.bean.message.TextCard;
import com.larus.im.bean.message.VLMMixerSearchResult;
import com.larus.im.bean.message.VideoCard;
import com.larus.list.exposex.ExposeXTrackerExtKt;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.utils.e1;
import com.larus.utils.l0;
import ib8.d0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class b0 extends bd8.b {
    public static final /* synthetic */ int z = 0;
    public ib8.f l;
    public Message m;
    public final Lazy n;
    public final wg8.c o;
    public final wg8.f p;
    public final Lazy q;
    public final Lazy r;
    public final Lazy s;
    public boolean t;
    public final Lazy u;
    public final Lazy v;
    public final Lazy w;
    public final Lazy x;
    public final Lazy y;

    public static final class a {
    }

    static {
    }

    @Override // bd8.b
    public final void C() {
        this.t = true;
        ib8.f r0 = this.l;
        if (r0 == null) goto L5;
        r0.f();
    L5:
        ib8.f r1 = this.l;
        if (r1 == null) goto L10;
        st8.a r2 = r1.b();
        if (r2 == null) goto L10;
        ExposeXTrackerExtKt.e(r2);
    L10:
        ib8.f r3 = this.l;
        if (r3 == null) goto L16;
        st8.a r4 = r3.b();
        if (r4 == null) goto L17;
        e1.o(r4);
        return;
    L17:
        return;
    }

    public b0() {
        super(true, 30);
        this.n = LazyKt.lazy(new b(this));
        this.o = new wg8.c();
        this.p = new wg8.f();
        this.q = LazyKt.lazy(new m(this));
        this.r = LazyKt.lazy(new t(this));
        this.s = LazyKt.lazy(new u(this));
        this.t = true;
        this.u = LazyKt.lazy(new v(this));
        this.v = LazyKt.lazy(new w(this));
        this.w = LazyKt.lazy(new x(this));
        this.x = LazyKt.lazy(new y(this));
        this.y = LazyKt.lazy(new z(this));
    }

    @Override // bd8.b
    public final void B() {
        this.o.e();
        CoroutineScope r0 = com.larus.bmhome.chat.layout.widget.handler.p.a;
        Message r1 = this.m;
        if (r1 == null) goto L5;
        String r2 = r1.getMessageId();
    L6:
        if (r2 != null) goto L8;
        r2 = "";
    L8:
        com.larus.bmhome.chat.layout.widget.handler.p.d(r2, "deep_thinking_header");
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final de8.c K() {
        return (de8.c) this.v.getValue();
    }

    public final com.larus.bmhome.chat.component.cvs.y L() {
        return (com.larus.bmhome.chat.component.cvs.y) this.r.getValue();
    }

    @Override // bd8.b
    public final void z() {
        wg8.c r0 = this.o;
        r0.j.a = 0;
        r0.d = false;
    }

    public static boolean N(Message r4) {
        if ((!com.larus.im.bean.message.a.G(r4).isEmpty()) == false) goto L5;
        return true;
    L5:
        MultiReference r5 = com.larus.im.bean.message.a.C(r4);
        List r0 = null;
        if (r5 == null) goto L8;
        VLMMixerSearchResult r6 = r5.getVlmMixerResult();
    L9:
        if (r6 == null) goto L11;
        List r2 = r6.getVlmImages();
    L12:
        List r3 = r2;
        if (r3 != null) goto L15;
    L18:
        boolean r7 = true;
    L19:
        if (r7 == false) goto L33;
        if (r6 == null) goto L22;
        r0 = r6.getMixerMedias();
    L22:
        List r1 = r0;
        if (r1 != null) goto L25;
    L28:
        boolean r8 = true;
    L29:
        if (r8 == false) goto L34;
        return false;
    L34:
        return true;
    L25:
        if (r1.isEmpty() == true) goto L28;
        r8 = false;
        goto L29
    L33:
        return true;
    L15:
        if (r3.isEmpty() == true) goto L18;
        r7 = false;
        goto L19
    L11:
        r2 = null;
        goto L12
    L8:
        r6 = null;
        goto L9
    }

    @Override // bd8.b
    public final boolean G(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
        if (com.larus.bmhome.chat.bean.d.I0(r2) == false) goto L5;
    L9:
        return false;
    L5:
        if (com.larus.im.bean.message.a.f0(r2) == false) goto L7;
    L8:
        return true;
    L7:
        if (N(r2) == false) goto L9;
        goto L8
    }

    public final BotModel M(Message r70) {
        com.larus.bmhome.chat.component.cvs.y r0 = L();
        if (r0 == null) goto L7;
        BotModel r1 = r0.j0();
        if (r1 == null) goto L7;
    L12:
        return r1;
    L7:
        if (r70 == null) goto L10;
        String r2 = r70.getSenderId();
        if (r2 == null) goto L10;
    L11:
        r1 = new BotModel(r2, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -2, Integer.MAX_VALUE, null);
    L10:
        r2 = "unknown";
        goto L11
    }

    public final void J(final Message r32, boolean r33, d0 r34) {
        if (com.larus.bmhome.chat.bean.d.A0(r32) == false) goto L6;
    L17:
        boolean r1 = false;
    L18:
        if (r1 == false) goto L207;
        ib8.f r2 = this.l;
        if (r2 == null) goto L24;
        st8.a r3 = r2.b();
        if (r3 == null) goto L24;
        e1.x(r3);
    L24:
        ib8.f r7 = this.l;
        if (r7 == null) goto L221;
        Lazy r4 = qg8.b.a;
        Message r5 = this.m;
        q0 r6 = this.e;
        IChatMessageShareAbility r8 = (IChatMessageShareAbility) this.q.getValue();
        u7 r9 = (u7) this.w.getValue();
        com.larus.bmhome.chat.component.collection.o r10 = bd8.c.a(this, com.larus.bmhome.chat.component.collection.o.class);
        if (r10 != null) goto L29;
    L31:
        boolean r11 = false;
    L32:
        DeepThinkFoldStatus r21 = qg8.b.d(r5, r6, r8, r9, r11);
        Function1 r12 = new e();
        Function1 r13 = new f(this, r32);
        ArrayList r14 = new ArrayList();
        if (com.larus.im.bean.message.a.v(r32) == true) goto L44;
        Iterator r15 = com.larus.im.bean.message.a.G(r32).iterator();
    L37:
        if (r15.hasNext() == false) goto L44;
        Reference r16 = (Reference) r15.next();
        TextCard r17 = r16.getTextCard();
        if (r17 == null) goto L41;
        r14.add(r17);
    L41:
        VideoCard r18 = r16.getVideoCard();
        if (r18 == null) goto L37;
        r14.add(r18);
    L44:
        ib8.m r19 = new ib8.m(r12, r13, String.valueOf(r14.size()));
        boolean r20 = com.larus.bmhome.chat.bean.d.f0(r32);
        String r22 = r32.getThinkingContent();
        if (r22 == null) goto L47;
        boolean r24 = StringsKt.isBlank(r22);
    L48:
        String r23 = com.larus.im.bean.message.a.K(r32);
        if (r23 != null) goto L51;
    L54:
        boolean r25 = true;
    L55:
        if (r25 == true) goto L66;
        String r26 = com.larus.im.bean.message.a.O(r32);
        if (r26 != null) goto L59;
    L62:
        boolean r27 = true;
    L63:
        if (r27 == true) goto L66;
        boolean r28 = false;
    L67:
        com.larus.bmhome.chat.component.collection.o r29 = bd8.c.a(this, com.larus.bmhome.chat.component.collection.o.class);
        if (r29 != null) goto L70;
    L72:
        boolean r210 = false;
    L73:
        ib8.c0 r211 = new ib8.c0(null, r34, r19, r32, r20, r21, null, false, r24, r28, false, new g(this), false, false, false, null, null, null, true, r210, 1042819);
        if (com.larus.im.bean.message.a.G(r32).isEmpty() == false) goto L77;
    L78:
        kb8.a r110 = null;
    L104:
        ib8.f r30 = this.l;
        if (r30 == null) goto L130;
        Context r31 = r30.getContext();
        if (r31 == null) goto L130;
        com.larus.bmhome.chat.layout.item.i r35 = this.d;
        if (r35 == null) goto L112;
        Integer r36 = Integer.valueOf(r35.getBoxType());
    L113:
        MultiReference r37 = com.larus.im.bean.message.a.C(r32);
        if (r37 == null) goto L130;
        VLMMixerSearchResult r111 = r37.getVlmMixerResult();
        if (r111 == null) goto L130;
        com.larus.bmhome.chat.layout.widget.handler.w r38 = com.larus.bmhome.chat.layout.widget.handler.w.a;
        de8.c r39 = K();
        if (r39 == null) goto L121;
        Integer r40 = r39.m();
    L122:
        if (r40 == null) goto L124;
        boolean r112 = true;
    L125:
        Boolean r41 = Boolean.valueOf(r112);
        IChatMessageShareAbility r42 = (IChatMessageShareAbility) this.q.getValue();
        if (r42 == null) goto L128;
        boolean r43 = r42.H1();
    L129:
        do8.k r113 = new do8.k(com.larus.bmhome.chat.layout.widget.handler.w.c(r38, r31, r32, r36, r41, r43, true, null, this.d, 64), null, r32, r111, 1, false, null, null, null, null, PreviewScene.SEARCH_IMAGE, null, null, 15330);
    L132:
        if (com.larus.im.bean.message.a.f0(r32) == true) goto L134;
        nb8.m r114 = null;
    L206:
        r7.a(new ib8.b(r211, r110, null, r114, r113, null, 36), (c0) this.y.getValue());
        return;
    L134:
        String r44 = (String) l0.a("", new h(r32));
        boolean r45 = com.larus.bmhome.chat.bean.d.f0(r32);
        fh8.g r46 = new fh8.g();
        r46.b = this.m;
        LruCache r47 = ko8.a.a;
        de8.c r48 = K();
        if (r48 == null) goto L137;
        long r49 = r48.n;
    L138:
        r46.a = ko8.a.e(r49);
        ChatParam r50 = (ChatParam) this.s.getValue();
        if (r50 == null) goto L141;
        String r115 = r50.d;
    L142:
        r46.e = r115;
        ChatParam r51 = (ChatParam) this.s.getValue();
        if (r51 == null) goto L145;
        String r116 = r51.c;
    L146:
        r46.f = r116;
        q0 r52 = this.e;
        if (r52 == null) goto L149;
        LruSet<String> r117 = r52.E7();
    L150:
        r46.g = r117;
        com.larus.bmhome.chat.component.collection.o r53 = bd8.c.a(this, com.larus.bmhome.chat.component.collection.o.class);
        if (r53 == null) goto L153;
        Boolean r118 = Boolean.valueOf(r53.i0());
    L154:
        r46.h = r118;
        r46.l = new s(this);
        q0 r54 = this.e;
        if (r54 == null) goto L157;
        q0.a r119 = r54.getProvider();
    L158:
        r46.m = r119;
        r46.n = (AttachReceiver) this.i.getValue();
        r46.o = (RecyclerView.Adapter) this.n.getValue();
        r46.k = null;
        com.larus.bmhome.chat.component.cvs.y r55 = L();
        if (r55 == null) goto L162;
        String r120 = r55.Y1();
        if (r120 == null) goto L162;
    L163:
        r46.c = r120;
        com.larus.bmhome.chat.component.cvs.y r56 = L();
        if (r56 == null) goto L168;
        BotModel r57 = r56.j0();
        if (r57 == null) goto L168;
        String r121 = r57.getBotId();
    L169:
        if (r121 != null) goto L171;
        String r122 = "";
    L172:
        r46.d = r122;
        r46.q = this.e;
        fh8.f r58 = r46.a();
        if (getContext() != null) goto L177;
        fh8.t.a r59 = new fh8.t.a();
    L205:
        r114 = new nb8.m(r58, r32, r44, r59, r45, r33, false, null);
        goto L206
    L177:
        if (com.larus.bmhome.chat.bean.d.f0(r32) == false) goto L179;
    L185:
        boolean r123 = false;
    L186:
        r59 = new fh8.t.a();
        Context r60 = getContext();
        if (r60 != null) goto L189;
        r60 = AppHost.a.getApplication();
    L189:
        r59.a = ContextCompat.getColor(r60, v19.c.b(2130972082, null, 2131103146));
        r59.b = i5.o();
        r59.c = i5.E();
        de8.c r61 = K();
        if (r61 == null) goto L192;
        Integer r124 = r61.m();
    L193:
        if (r124 == null) goto L195;
        boolean r62 = true;
    L196:
        r59.d = r62;
        IChatMessageShareAbility r63 = (IChatMessageShareAbility) this.q.getValue();
        if (r63 == null) goto L199;
        boolean r64 = r63.H1();
    L200:
        r59.e = r64;
        com.larus.bmhome.chat.layout.item.i r65 = this.d;
        if (r65 == null) goto L203;
        Integer r125 = Integer.valueOf(r65.getBoxType());
    L204:
        r59.f = r125;
        r59.g = r123;
        goto L205
    L203:
        r125 = null;
        goto L204
    L199:
        r64 = false;
        goto L200
    L195:
        r62 = false;
        goto L196
    L192:
        r124 = null;
        goto L193
    L179:
        if (com.larus.bmhome.chat.bean.d.e0(r32) == false) goto L181;
    L184:
        r123 = true;
        goto L186
    L181:
        if (r32.getMessageStatusLocal() == 23) goto L185;
        if (r32.getMessageStatusLocal() == 22) goto L185;
    L171:
        r122 = r121;
    L168:
        r121 = null;
    L162:
        r120 = "";
        goto L163
    L157:
        r119 = null;
        goto L158
    L153:
        r118 = null;
        goto L154
    L149:
        r117 = null;
        goto L150
    L145:
        r116 = null;
        goto L146
    L141:
        r115 = null;
        goto L142
    L137:
        r49 = 0;
        goto L138
    L128:
        r43 = false;
        goto L129
    L124:
        r112 = false;
        goto L125
    L121:
        r40 = null;
        goto L122
    L112:
        r36 = null;
    L130:
        r113 = null;
        goto L132
    L77:
        if (com.larus.im.bean.message.a.v(r32) == true) goto L78;
        String r66 = r32.getMessageId();
        if (r66 != null) goto L82;
        String r67 = "";
    L83:
        MultiReference r68 = com.larus.im.bean.message.a.C(r32);
        if (r68 == null) goto L86;
        List r69 = r68.getSearchQueries();
    L87:
        boolean r70 = com.larus.bmhome.chat.bean.d.f0(r32);
        List r71 = com.larus.im.bean.message.a.G(r32);
        String r72 = r32.getMessageId();
        if (r72 != null) goto L90;
        String r73 = "";
    L91:
        String r74 = r32.getConversationId();
        if (r74 != null) goto L94;
        String r126 = "";
    L95:
        String r75 = M(r32).getBotId();
        if (r75 != null) goto L98;
        String r127 = "";
    L99:
        boolean r128 = com.larus.im.bean.message.a.f0(r32);
        String r76 = (String) this.u.getValue();
        if (r76 != null) goto L102;
        String r129 = "";
    L103:
        r110 = new kb8.a(r32, r67, r69, r71, new kb8.o(r73, r126, r127, r128, r129), r70, 192);
        goto L104
    L102:
        r129 = r76;
        goto L103
    L98:
        r127 = r75;
        goto L99
    L94:
        r126 = r74;
        goto L95
    L90:
        r73 = r72;
        goto L91
    L86:
        r69 = null;
        goto L87
    L82:
        r67 = r66;
        goto L83
    L70:
        if (r29.i0() != true) goto L72;
        r210 = true;
        goto L73
    L59:
        if (StringsKt.isBlank(r26) == true) goto L62;
        r27 = false;
    L66:
        r28 = true;
        goto L67
    L51:
        if (r23.length() == 0) goto L54;
        r25 = false;
        goto L55
    L47:
        r24 = true;
        goto L48
    L29:
        if (r10.i0() != true) goto L31;
        r11 = true;
        goto L32
    L221:
        return;
    L207:
        ib8.f r77 = this.l;
        if (r77 == null) goto L210;
        r77.f();
    L210:
        ib8.f r78 = this.l;
        if (r78 == null) goto L223;
        st8.a r79 = r78.b();
        if (r79 == null) goto L224;
        e1.o(r79);
        return;
    L224:
        return;
    L223:
        return;
    L6:
        if (com.larus.bmhome.chat.bean.d.I0(r32) == true) goto L17;
        if (com.larus.im.bean.message.a.v(r32) == false) goto L10;
    L12:
        boolean r80 = false;
    L13:
        if (r80 == false) goto L15;
    L16:
        r1 = true;
        goto L18
    L15:
        if (com.larus.im.bean.message.a.f0(r32) == false) goto L17;
    L10:
        if (N(r32) == false) goto L12;
        r80 = true;
        goto L13
    }

    @Override // bd8.b
    public final void w(final Message r1, int r2, ec8.b r3) {
        Intrinsics.checkNotNullParameter(r1, "message");
        Intrinsics.checkNotNullParameter(r1, "message");
        this.m = r1;
        c0 r4 = (c0) this.y.getValue();
        r4.h = new a0(this, r1);
        nb8.c r5 = (nb8.c) this.x.getValue();
        r5.d = new c(this, r1);
        J(r1, false, null);
    }

    @Override // bd8.b
    public final List<View> x(int r2, Context r3, BaseMessageListCell<?> r4, com.larus.bmhome.chat.layout.item.i r5, q0 r6, Fragment r7) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super.x(r2, r3, r4, r5, r6, r7);
        ib8.f r8 = new ib8.f(r3);
        this.l = r8;
        st8.a r9 = r8.b();
        if (r5 == null) goto L5;
        r5.addView(r9, r2, new LinearLayout.LayoutParams(-2, -2));
    L5:
        ExposeXTrackerExtKt.b(r9, new d(this));
        this.p.a = r4;
        wg8.c r10 = this.o;
        r10.a = r4;
        r10.b = r5;
        return CollectionsKt.listOf(r9);
    }
}
