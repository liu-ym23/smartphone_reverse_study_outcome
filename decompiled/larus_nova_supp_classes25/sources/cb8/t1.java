package cb8;

import android.R;
import android.content.Context;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.ixigua.lib.track.FrozenTrackNode;
import com.larus.bmhome.block.holder.content.lynx.IvyPluginViewPool;
import com.larus.bmhome.chat.ChatBubbleParams;
import com.larus.bmhome.chat.api.ILegacyChatUiServiceDelegate;
import com.larus.bmhome.chat.bean.DeepThinkFoldStatus;
import com.larus.bmhome.chat.block.base.config.ToolBlockInitStatus;
import com.larus.bmhome.chat.block.base.config.ToolBlockInteractType;
import com.larus.bmhome.chat.cell.BaseMessageListCell;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.bmhome.chat.component.share.IChatMessageShareAbility;
import com.larus.bmhome.chat.list.cell.text.BaseCompositeTextCell;
import com.larus.bmhome.chat.list.cell.text.interceptor.ErrorEnum;
import com.larus.bmhome.chat.search.LruSet;
import com.larus.bmhome.chat.search.factory.ExpandCardViewMode;
import com.larus.bmhome.utils.z1;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.BlockType;
import com.larus.im.bean.message.block.SearchRichMediaBlock;
import com.larus.list.exposex.ExposeXTrackerExtKt;
import com.larus.platform.api.IFlowThemeConfigProvider;
import com.larus.platform.api.ThemeColorKey;
import com.larus.platform.api.ThemeConfigScene;
import com.larus.platform.model.apptheme.AdaptThemeFeatureKey;
import com.larus.platform.service.z2;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;
import v19.c7;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class t1 extends bd8.b implements bd8.d {
    public final Lazy A;
    public final Lazy B;
    public final Lazy C;
    public final Lazy D;
    public final Lazy E;
    public final Lazy F;
    public final Lazy G;
    public Message H;
    public int I;
    public ExpandCardViewMode J;
    public final of8.l l;
    public boolean m;
    public boolean n;
    public ExpandCardViewMode o;
    public hk9.a p;
    public boolean q;
    public boolean r;
    public boolean s;
    public final Map<Integer, Drawable> t;
    public final Map<Integer, Drawable> u;
    public final Lazy v;
    public final Lazy w;
    public final Lazy x;
    public final com.larus.bmhome.chat.api.a0 y;
    public final Lazy z;

    @Override // bd8.b
    public final void C() {
        this.r = false;
        this.s = false;
        this.H = null;
        this.I = -1;
        this.m = false;
        hk9.a r2 = this.p;
        if (r2 == null) goto L5;
        r2.setBackground(null);
    L5:
        this.o = ExpandCardViewMode.NORMAL;
        ((LinkedHashMap) this.t).clear();
        ((LinkedHashMap) this.u).clear();
        hk9.a r1 = this.p;
        if (r1 == null) goto L8;
        r1.a();
    L8:
        hk9.a r3 = this.p;
        if (r3 == null) goto L11;
        ExposeXTrackerExtKt.e(r3);
    L11:
        this.q = false;
    }

    @Override // bd8.b
    public final void E() {
        z2.a.w3();
    }

    public final de8.c K() {
        return (de8.c) this.B.getValue();
    }

    public final com.larus.bmhome.chat.component.cvs.y L() {
        return (com.larus.bmhome.chat.component.cvs.y) this.z.getValue();
    }

    public final va8.p M() {
        return (va8.p) this.E.getValue();
    }

    public final u7 N() {
        return (u7) this.x.getValue();
    }

    @Override // bd8.b
    public final void z() {
        Message r0 = this.H;
        if (r0 == null) goto L8;
        com.larus.bmhome.chat.api.a0 r1 = this.y;
        if (r1 == null) goto L9;
        r1.a(r0, this.c, this.e);
        return;
    L9:
        return;
    }

    public final Integer O() {
        de8.c r0 = K();
        if (r0 == null) goto L6;
        Integer r1 = r0.m();
        if (r1 == null) goto L6;
        return r1;
    L6:
        ry8.d r2 = (RecyclerView.Adapter) this.v.getValue();
        if ((r2 instanceof ry8.d) == false) goto L9;
        ry8.d r3 = r2;
    L10:
        if (r3 == null) goto L13;
        return r3.r2();
    L13:
        return null;
    L9:
        r3 = null;
        goto L10
    }

    public t1(of8.l r3) {
        Intrinsics.checkNotNullParameter(r3, "blockLongClickHandler");
        super(false, 10);
        this.l = r3;
        ExpandCardViewMode r4 = ExpandCardViewMode.NORMAL;
        this.o = r4;
        this.t = new LinkedHashMap();
        this.u = new LinkedHashMap();
        this.v = LazyKt.lazy(new m0(this));
        this.w = LazyKt.lazy(new o0(this));
        this.x = LazyKt.lazy(new p0(this));
        this.y = ILegacyChatUiServiceDelegate.b.r8();
        this.z = LazyKt.lazy(new q0(this));
        this.A = LazyKt.lazy(new r0(this));
        this.B = LazyKt.lazy(new s0(this));
        this.C = LazyKt.lazy(new t0(this));
        this.D = LazyKt.lazy(new v0(this));
        this.E = LazyKt.lazy(new w0(this));
        this.F = LazyKt.lazy(new x0(this));
        this.G = LazyKt.lazy(new n0(this));
        this.I = -1;
        this.J = r4;
    }

    public final int J(Message r13) {
        Context r1 = getContext();
        int r0 = 0;
        boolean r2 = false;
        r2 = false;
        r0 = 0;
        if (r1 != null) goto L5;
        return 0;
    L5:
        com.larus.bmhome.chat.layout.widget.handler.w r3 = com.larus.bmhome.chat.layout.widget.handler.w.a;
        com.larus.bmhome.chat.layout.item.i r4 = this.d;
        Integer r5 = null;
        if (r4 == null) goto L8;
        Integer r6 = Integer.valueOf(r4.getBoxType());
    L9:
        de8.c r7 = K();
        if (r7 == null) goto L12;
        Integer r8 = r7.m();
    L14:
        if (r8 == null) goto L16;
        boolean r9 = true;
    L17:
        Boolean r10 = Boolean.valueOf(r9);
        IChatMessageShareAbility r11 = (IChatMessageShareAbility) this.w.getValue();
        if (r11 != null) goto L20;
    L22:
        boolean r12 = false;
    L23:
        xe8.a r14 = this.c;
        if ((r14 instanceof xe8.a) == false) goto L26;
        xe8.a r15 = r14;
    L27:
        if (r15 == null) goto L33;
        ChatBubbleParams r16 = r15.Mz();
        if (r16 == null) goto L33;
        if (r16.a != true) goto L33;
        boolean r17 = true;
    L34:
        if (r17 == false) goto L47;
        Lazy r18 = z1.a;
        com.larus.bmhome.chat.layout.item.i r19 = this.d;
        if (r19 == null) goto L47;
        int r20 = r19.getBoxType();
        de8.c r110 = K();
        if (r110 == null) goto L40;
        r5 = r110.m();
    L40:
        IChatMessageShareAbility r111 = (IChatMessageShareAbility) this.w.getValue();
        if (r111 != null) goto L43;
    L45:
        r0 = z1.g(r20, r5, r2, com.larus.bmhome.chat.bean.d.J0(r13), Integer.valueOf(z1.e(this.c)));
        goto L47
    L43:
        if (r111.H1() != true) goto L45;
        r2 = true;
    L47:
        return com.larus.bmhome.chat.layout.widget.handler.w.c(r3, r1, r13, r6, r10, r12, false, Integer.valueOf(r0), this.d, 32);
    L33:
        r17 = false;
        goto L34
    L26:
        r15 = null;
        goto L27
    L20:
        if (r11.H1() != true) goto L22;
        r12 = true;
        goto L23
    L16:
        r9 = false;
        goto L17
    L12:
        r8 = null;
        goto L14
    L8:
        r6 = null;
        goto L9
    }

    public final void P(int r10) {
        boolean r1 = true;
        if (this.r == false) goto L54;
    L35:
        hk9.a r0 = this.p;
        if (r0 == null) goto L57;
        Message r3 = this.H;
        Drawable r4 = null;
        if (r3 == null) goto L46;
        Regex r5 = com.larus.bmhome.chat.bean.d.a;
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Map r6 = r3.getBusinessExt();
        if (r6 == null) goto L42;
        String r7 = (String) r6.get("show_dash_border");
    L44:
        if (Intrinsics.areEqual(r7, "1") != true) goto L46;
    L47:
        if (r1 == true) goto L49;
    L52:
        r0.setBackground(r4);
        return;
    L49:
        if (((LinkedHashMap) this.u).get(Integer.valueOf(r10)) != null) goto L51;
        Map<Integer, Drawable> r2 = this.u;
        Integer r8 = Integer.valueOf(r10);
        GradientDrawable r9 = new GradientDrawable();
        r9.setShape(0);
        r9.setCornerRadius(r10);
        r9.setColor(0);
        r9.setStroke(c7.b(Float.valueOf(1.5f)), ContextCompat.getColor(r0.getContext(), v19.c.b(2130972087, r0.getContext(), 2131103162)), c7.c(3), c7.c(3));
        r2.put(r8, r9);
    L51:
        r4 = (Drawable) ((LinkedHashMap) this.u).get(Integer.valueOf(r10));
        goto L52
    L42:
        r7 = null;
    L46:
        r1 = false;
        goto L47
    L57:
        return;
    L54:
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L12
        BaseCompositeTextCell<?> r12 = this.f;     // Catch: Throwable -> L12
        if (r12 != null) goto L7;
    L9:
        boolean r13 = false;
    L10:
        Object r14 = Result.constructor-impl(Boolean.valueOf(r13));     // Catch: Throwable -> L12
    L14:
        Boolean r15 = Boolean.FALSE;
        if (Result.isFailure-impl(r14) == false) goto L18;
        r14 = r15;
    L18:
        if (((Boolean) r14).booleanValue() == true) goto L20;
    L22:
        boolean r16 = false;
    L23:
        if (r16 == true) goto L35;
        hk9.a r17 = this.p;
        if (r17 != null) goto L28;
        return;
    L28:
        if (((LinkedHashMap) this.t).get(Integer.valueOf(r10)) != null) goto L33;
        Drawable r18 = com.larus.utils.e1.j(r17, c7.c(Integer.valueOf(r10)), v19.c.b(2130970533, r17.getContext(), 2131102542));
        IFlowThemeConfigProvider r19 = (IFlowThemeConfigProvider) ServiceManager.get().getService(IFlowThemeConfigProvider.class);
        if (r19 == null) goto L32;
        ThemeConfigScene r20 = ThemeConfigScene.CHAT;
        ThemeColorKey r21 = ThemeColorKey.MESSAGE_RECEIVE_BUBBLE_COLOR;
        AdaptThemeFeatureKey r22 = AdaptThemeFeatureKey.RECEIVE_MESSAGE_BUBBLE;
        boolean r23 = v19.h.a;
        r19.g(r18, r21, r20, r22, Boolean.valueOf(v19.h.b(r17.getContext())));
    L32:
        this.t.put(Integer.valueOf(r10), r18);
    L33:
        r17.setBackground((Drawable) ((LinkedHashMap) this.t).get(Integer.valueOf(r10)));
        return;
    L20:
        if (z2.a.getObricWindowMessageBubbleConfig().getEnable() == false) goto L22;
        r16 = true;
        goto L23
    L7:
        if (s1a.a.e(r12.e()) != true) goto L9;
        r13 = true;
    L12:
        th = move-exception;
        Result.Companion r24 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    }

    public final boolean Q(Message r6) {
        if (O() == null) goto L43;
        Intrinsics.checkNotNullParameter(r6, "<this>");
        if (com.larus.im.bean.message.a.b0(r6) == true) goto L8;
    L34:
        boolean r7 = false;
    L35:
        if (r7 == false) goto L44;
        return true;
    L44:
        return false;
    L8:
        if (r6.getContentType() == 8) goto L34;
        if (r6.getContentType() == 100) goto L34;
        if ((!((ArrayList) com.larus.im.bean.message.a.R(r6)).isEmpty()) == true) goto L34;
        ArrayList r8 = (ArrayList) com.larus.im.bean.message.a.A(r6);
        if (r8.isEmpty() == true) goto L34;
        if (r8.isEmpty() == true) goto L33;
        Iterator r9 = r8.iterator();
    L23:
        if (r9.hasNext() == false) goto L33;
        Block r0 = (Block) r9.next();
        if (r0.getBlockType() != BlockType.BLOCK_TYPE_TEXT.getValue()) goto L27;
    L30:
        boolean r1 = true;
    L31:
        if (r1 == true) goto L23;
    L27:
        if (r0.getBlockType() == BlockType.BLOCK_TYPE_LOADING.getValue()) goto L30;
        r1 = false;
    L33:
        r7 = true;
        goto L35
    L43:
        return false;
    }

    @Override // bd8.d
    public final JSONObject m(Message r3) {
        Intrinsics.checkNotNullParameter(r3, "message");
        Intrinsics.checkNotNullParameter(this, "<this>");
        Intrinsics.checkNotNullParameter(r3, "message");
        JSONObject r0 = new JSONObject();
        u1.c(r3, r0, this.p);
        return r0;
    }

    /* JADX WARN: Type inference failed for: r10v4, types: [cb8.n] */
    /* JADX WARN: Type inference failed for: r14v4, types: [cb8.a0] */
    /* JADX WARN: Type inference failed for: r15v11, types: [cb8.b0] */
    /* JADX WARN: Type inference failed for: r4v16, types: [cb8.z] */
    /* JADX WARN: Type inference failed for: r5v0, types: [cb8.f] */
    /* JADX WARN: Type inference failed for: r5v24, types: [cb8.z0] */
    /* JADX WARN: Type inference failed for: r6v2, types: [cb8.r] */
    /* JADX WARN: Type inference failed for: r6v8, types: [cb8.a1] */
    @Override // bd8.b
    public final void w(Message r42, int r43, ec8.b r44) {
        Intrinsics.checkNotNullParameter(r42, "message");
        com.larus.bmhome.chat.layout.item.i r3 = this.d;
        if ((r3 instanceof com.larus.bmhome.chat.layout.item.l) == false) goto L5;
        com.larus.bmhome.chat.layout.item.l r4 = (com.larus.bmhome.chat.layout.item.l) r3;
    L6:
        if (r4 == null) goto L8;
        r4.setOnLongClickListener(new y0(this));
    L8:
        Intrinsics.checkNotNullParameter(r42, "message");
        Message r5 = this.H;
        if (r5 == null) goto L11;
        String r6 = r5.getMessageId();
    L13:
        if (Intrinsics.areEqual(r6, r42.getMessageId()) == true) goto L15;
        this.r = false;
        this.s = false;
    L15:
        this.H = r42;
        if (this.q == true) goto L20;
        hk9.a r7 = this.p;
        if (r7 == null) goto L20;
        ExposeXTrackerExtKt.b(r7, new c(this));
        this.q = true;
    L20:
        this.I = r43;
        va8.t r8 = (va8.t) this.A.getValue();
        if (r8 == null) goto L23;
        boolean r9 = r8.H1();
    L24:
        boolean r10 = com.larus.bmhome.chat.bean.d.J0(r42);
        Lazy r11 = z1.a;
        com.larus.bmhome.chat.layout.item.i r12 = this.d;
        if (r12 == null) goto L27;
        int r13 = r12.getBoxType();
    L28:
        com.larus.bmhome.chat.layout.item.i r14 = this.d;
        if (r14 == null) goto L31;
        Integer r15 = r14.getImmerseBgColor();
    L32:
        boolean r16 = z1.b(r13, r15);
        if (r16 != true) goto L41;
        if (r9 == false) goto L37;
        if (r10 == true) goto L37;
        ExpandCardViewMode r17 = ExpandCardViewMode.EXPAND_SHARE;
    L49:
        this.J = r17;
        if (com.larus.bmhome.chat.bean.d.Q0(r42) == false) goto L52;
    L55:
        boolean r18 = true;
    L56:
        Intrinsics.checkNotNullParameter(r42, "<this>");
        if (com.larus.im.bean.message.a.b0(r42) == false) goto L80;
        Intrinsics.checkNotNullParameter(r42, "<this>");
        List r19 = vd9.r.a(r42);
        if ((r19 instanceof Collection) == true) goto L62;
    L64:
        Iterator r20 = r19.iterator();
    L66:
        if (r20.hasNext() == false) goto L80;
        BlockContent r110 = ((Block) r20.next()).getContent();
        if (r110 == null) goto L77;
        SearchRichMediaBlock r111 = r110.getRichMediaBlock();
        if (r111 == null) goto L77;
        Integer r112 = r111.scene;
        if (r112 == null) goto L77;
        if (r112.intValue() != 2) goto L77;
        boolean r113 = true;
    L78:
        if (r113 == false) goto L66;
        boolean r21 = true;
    L81:
        if (r21 == false) goto L98;
        com.larus.bmhome.chat.layout.item.i r22 = this.d;
        if ((r22 instanceof com.larus.bmhome.chat.layout.item.l) == false) goto L85;
        com.larus.bmhome.chat.layout.item.l r23 = (com.larus.bmhome.chat.layout.item.l) r22;
    L86:
        if (r23 == null) goto L88;
        r23.setupDisableBoxBackground(true);
    L88:
        com.larus.bmhome.chat.layout.item.i r24 = this.d;
        if ((r24 instanceof com.larus.bmhome.chat.layout.item.l) == false) goto L91;
        com.larus.bmhome.chat.layout.item.l r25 = (com.larus.bmhome.chat.layout.item.l) r24;
    L92:
        if (r25 == null) goto L94;
        r25.setupDisableUpdateBoxWidth(true);
    L94:
        this.r = true;
        P(0);
        hk9.a r26 = this.p;
        if (r26 == null) goto L139;
        r26.setPadding(0, 0, 0, 0);
    L139:
        hk9.a r27 = this.p;
        if (r27 == null) goto L146;
        int r114 = J(r42);
        com.larus.bmhome.chat.layout.item.i r115 = this.d;
        if (r115 == null) goto L144;
        int r116 = r115.getMaxWidth();
    L145:
        r27.b(cd8.a.class, new cd8.a(r114, r116));
        goto L146
    L144:
        r116 = -1;
    L146:
        ug8.g r28 = ug8.g.a;
        Intrinsics.checkNotNullParameter(r42, "message");
        ug8.h r0 = ug8.g.h;
        if (r0 != null) goto L352;
        Message r117 = r42;
    L160:
        List r1 = com.larus.im.bean.message.a.f(r117);
        ArrayList r29 = new ArrayList();
        Iterator r2 = r1.iterator();
    L162:
        if (r2.hasNext() == false) goto L166;
        Object r118 = r2.next();
        if (com.larus.bmhome.clarification.w.a((Block) r118) == true) goto L162;
        r29.add(r118);
        goto L162
    L166:
        po8.p r30 = u1.a(this);
        if (r30 == null) goto L169;
        DeepThinkFoldStatus r31 = r30.getDeepThinkFoldStatus();
    L170:
        Lazy r119 = qg8.b.a;
        com.larus.bmhome.chat.api.q0 r120 = this.e;
        IChatMessageShareAbility r121 = (IChatMessageShareAbility) this.w.getValue();
        u7 r122 = N();
        com.larus.bmhome.chat.component.collection.o r123 = (com.larus.bmhome.chat.component.collection.o) this.D.getValue();
        if (r123 != null) goto L173;
    L175:
        boolean r124 = false;
    L176:
        DeepThinkFoldStatus r125 = qg8.b.d(r117, r120, r121, r122, r124);
        if (r31 == null) goto L180;
        if (r31 == r125) goto L180;
        boolean r32 = true;
    L181:
        if (r32 == false) goto L184;
    L202:
        boolean r33 = true;
    L204:
        hk9.a r126 = this.p;
        if (r126 == null) goto L338;
        kc8.n0 r127 = new kc8.n0(new kc8.m0(new n(this), new f(this)), new kc8.o0(J(r117), new r(this)));
        boolean r34 = Q(r117);
        int r35 = kc8.v0.p;
        kc8.v0.a r36 = new kc8.v0.a();
        r36.h = new d0(this);
        r36.a = Boolean.valueOf(r34);
        r36.c = false;
        r36.e = Boolean.FALSE;
        r36.j = new f0(this);
        r36.k = new g0(this);
        if (r34 == false) goto L209;
        RectF r37 = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
    L210:
        r36.g = r37;
        r36.l = new jh8.a(new h0(this));
        kc8.v0 r38 = r36.a();
        int r39 = kc8.y.J;
        kc8.y.a r40 = new kc8.y.a();
        r40.h = new i0(this);
        r40.i = new k0(this);
        r40.j = new l0(this);
        r40.k = new y(this);
        r40.l = new j0(this);
        r40.m = new u0(this);
        Message r41 = r117;
        r40.n = new kc8.j(new f1(this), new i1(this), new j1(this), new k1(this), new l1(this), new d(this), new e(this), new g(this), new h(this), new i(this), new j(this), new k(this), new l(this));
        com.larus.bmhome.chat.layout.item.i r45 = this.d;
        if (r45 == null) goto L213;
        Integer r46 = Integer.valueOf(r45.getBoxType());
    L214:
        r40.s = r46;
        va8.p r47 = M();
        if (r47 == null) goto L219;
        Fragment r48 = r47.M();
        if (r48 == null) goto L219;
        FrozenTrackNode r49 = by7.h.d(r48);
    L220:
        r40.f = r49;
        r40.A = this.e;
        va8.p r50 = M();
        if (r50 == null) goto L223;
        RecyclerView r51 = r50.Ly();
    L224:
        r40.g = r51;
        r40.z = (RecyclerView.Adapter) this.v.getValue();
        r40.e = Long.valueOf(de8.d.a(K()));
        r40.u = O();
        com.larus.bmhome.chat.component.collection.o r52 = (com.larus.bmhome.chat.component.collection.o) this.D.getValue();
        if (r52 == null) goto L227;
        Boolean r53 = Boolean.valueOf(r52.i0());
    L228:
        r40.q = r53;
        IChatMessageShareAbility r54 = (IChatMessageShareAbility) this.w.getValue();
        if (r54 == null) goto L231;
        Boolean r55 = Boolean.valueOf(r54.H1());
    L232:
        r40.r = r55;
        r40.o = new m(this);
        r40.p = new o(this);
        r40.w = Integer.valueOf(r43);
        com.larus.bmhome.chat.api.q0 r56 = this.e;
        if (r56 == null) goto L235;
        com.larus.bmhome.chat.api.q0.a r57 = r56.getProvider();
    L236:
        r40.x = r57;
        r40.y = (AttachReceiver) this.i.getValue();
        com.larus.bmhome.chat.api.q0 r58 = this.e;
        if (r58 == null) goto L240;
        LruSet<String> r59 = r58.E7();
        if (r59 == null) goto L240;
    L241:
        r40.B = r59;
        com.larus.bmhome.chat.layout.item.i r60 = this.d;
        if (r60 == null) goto L244;
        Boolean r61 = Boolean.valueOf(r60.getUseSubscribedColor());
    L245:
        r40.t = r61;
        r40.v = new p();
        r40.d = new q(this);
        r40.a = new s(this);
        r40.c = new t(this);
        r40.C = this.c;
        Function2<? super Integer, ? super Integer, Unit> r62 = new u(this);
        Intrinsics.checkNotNullParameter(r62, "value");
        r40.E = r62;
        r40.b = new v(this);
        Function4<? super Integer, ? super Integer, ? super Interpolator, ? super Integer, Unit> r63 = new w(this);
        Intrinsics.checkNotNullParameter(r63, "value");
        r40.F = r63;
        r40.G = new x(this);
        r40.D = this.l;
        final kc8.y r64 = r40.a();
        int r65 = kc8.b.y;
        kc8.b.a r66 = new kc8.b.a();
        r66.b = r64;
        r66.g = new kc8.x(Integer.valueOf(R.color.transparent));
        r66.j = new kc8.p(null);
        IChatMessageShareAbility r67 = (IChatMessageShareAbility) this.w.getValue();
        if (r67 != null) goto L248;
    L250:
        boolean r68 = false;
    L251:
        if (r68 == true) goto L287;
        Regex r69 = com.larus.bmhome.chat.bean.d.a;
        Message r70 = r41;
        Intrinsics.checkNotNullParameter(r70, "<this>");
        Map r71 = r70.getExt();
        if (r71 == null) goto L257;
        String r72 = (String) r71.get("source_share");
        if (r72 == null) goto L257;
        boolean r73 = com.larus.utils.o0.d(r72);
    L258:
        if (r73 == false) goto L261;
    L288:
        boolean r74 = true;
    L289:
        r66.w = new kc8.v(Boolean.valueOf(r74));
        r66.d = r127;
        r66.a = r38;
        r66.e = new kc8.k0(this.J, 14);
        r66.f = new kc8.t0(this.J);
        com.larus.bmhome.chat.api.q0 r75 = this.e;
        if (r75 == null) goto L292;
        final com.larus.bmhome.chat.api.q0.a r76 = r75.getProvider();
    L293:
        if (r76 == null) goto L295;
        com.larus.bmhome.chat.component.cvs.y r77 = r76.u0();
    L296:
        com.larus.bmhome.chat.api.q0 r78 = this.e;
        if (r78 == null) goto L301;
        Function0<Fragment> r79 = r78.getHostFragment();
        if (r79 == null) goto L301;
        Fragment r210 = (Fragment) r79.invoke();
    L303:
        if (r77 == null) goto L305;
        n1 r211 = new n1(r77);
    L306:
        ?? r80 = new z0(r76);
        if (r76 == null) goto L309;
        CoroutineScope r212 = r76.F9();
    L310:
        if (r76 == null) goto L314;
        qd8.b r81 = r76.H9();
        if (r81 == null) goto L314;
        o1 r213 = new o1(r81);
    L315:
        if (r76 == null) goto L319;
        zd8.b r82 = r76.P9();
        if (r82 == null) goto L319;
        p1 r214 = new p1(r82);
    L320:
        ?? r83 = new a1(this);
        if (r76 == null) goto L323;
        q1 r215 = new q1(r76);
    L324:
        if (r76 == null) goto L326;
        r1 r310 = new r1(r76, this);
    L327:
        r66.l = new kc8.q(r210, null, r211, r80, r212, r213, r214, r83, r215, r310, this.e, null, 4102);
        com.larus.bmhome.chat.component.collection.o r84 = (com.larus.bmhome.chat.component.collection.o) this.D.getValue();
        if (r84 == null) goto L332;
        boolean r85 = true;
        if (r84.i0() != true) goto L332;
    L333:
        r66.o = new kc8.u0(Boolean.valueOf(r85), new b1(this));
        eh8.c r86 = bd8.c.a(this, eh8.c.class);
        if (r86 == null) goto L336;
        IvyPluginViewPool r87 = r86.Yy();
    L337:
        r66.q = new kc8.h0(r87, new d1(this));
        r66.r = new kc8.i(new c1(this));
        r66.s = new kc8.l0(new z(this), 2);
        r66.t = new kc8.x0(null, null, null, new a0(this), new b0(this), 7);
        r66.u = new kc8.m(false, new c0(this), 2);
        r66.v = new kc8.w0(ToolBlockInteractType.OpenFloatingPage, ToolBlockInitStatus.Fold, new com.larus.bmhome.block.presentation.a(this.c, new e0(r64)));
        r126.b(kc8.b.class, r66.a());
    L339:
        hk9.a r88 = this.p;
        if (r88 == null) goto L342;
        int r89 = ra8.a.a;
        ra8.a.d(r88, r29, new kc8.f(r70, null, false, true, new s1(this), null, 486), r33);
    L342:
        com.larus.bmhome.chat.api.a0 r90 = this.y;
        if (r90 == null) goto L346;
        r90.a(r42, this.c, this.e);
    L346:
        this.m = r18;
        this.n = com.larus.bmhome.chat.bean.d.j0(r42);
        this.o = this.J;
        return;
    L336:
        r87 = null;
    L332:
        r85 = false;
        goto L333
    L326:
        r310 = null;
        goto L327
    L323:
        r215 = null;
    L319:
        r214 = null;
    L314:
        r213 = null;
        goto L315
    L309:
        r212 = null;
        goto L310
    L305:
        r211 = null;
    L301:
        r210 = null;
        goto L303
    L295:
        r77 = null;
        goto L296
    L292:
        r76 = null;
        goto L293
    L261:
        if (com.larus.platform.service.p1.a.j() == false) goto L288;
        String r91 = r70.getSectionId();
        com.larus.bmhome.chat.component.cvs.y r92 = L();
        if (r92 == null) goto L268;
        wc9.e r93 = r92.h();
        if (r93 == null) goto L268;
        String r94 = r93.B;
    L270:
        if (Intrinsics.areEqual(r91, r94) == false) goto L288;
        u7 r95 = N();
        if (r95 == null) goto L286;
        List r96 = r95.zj();
        if (r96 == null) goto L286;
        Iterator r97 = r96.iterator();
    L279:
        if (r97.hasNext() == false) goto L286;
        Message r99 = (Message) r97.next();
        if (Intrinsics.areEqual(r99.getMessageId(), r70.getMessageId()) == true) goto L286;
        if (com.larus.bmhome.chat.bean.d.G0(r99) == false) goto L279;
    L286:
        r74 = false;
    L268:
        r94 = null;
    L257:
        r73 = false;
        goto L258
    L287:
        r70 = r41;
        goto L288
    L248:
        if (r67.H1() != true) goto L250;
        r68 = true;
        goto L251
    L244:
        r61 = null;
    L240:
        r59 = new LruSet(1);
        goto L241
    L235:
        r57 = null;
        goto L236
    L231:
        r55 = null;
        goto L232
    L227:
        r53 = null;
        goto L228
    L223:
        r51 = null;
    L219:
        r49 = null;
        goto L220
    L213:
        r46 = null;
        goto L214
    L209:
        r37 = new RectF(c7.b(16), c7.b(12), c7.b(16), c7.b(12));
        goto L210
    L338:
        r70 = r117;
        goto L339
    L184:
        if (this.m != r18) goto L202;
        if (this.o != this.J) goto L202;
        if (this.n != com.larus.bmhome.chat.bean.d.j0(r117)) goto L202;
        CopyOnWriteArraySet<String> r100 = com.larus.bmhome.chat.markdown.imagegroup.c.a;
        String r101 = r117.getMessageId();
        String r128 = "";
        if (r101 != null) goto L196;
        r101 = "";
    L196:
        if (com.larus.bmhome.chat.markdown.imagegroup.c.a(r101) == false) goto L203;
        String r102 = r117.getMessageId();
        if (r102 == null) goto L201;
        r128 = r102;
    L201:
        Intrinsics.checkNotNullParameter(r128, "forceRefreshId");
        com.larus.bmhome.chat.markdown.imagegroup.c.a.remove(r128);
        goto L202
    L203:
        r33 = false;
    L180:
        r32 = false;
        goto L181
    L173:
        if (r123.i0() != true) goto L175;
        r124 = true;
        goto L176
    L169:
        r31 = null;
        goto L170
    L352:
        Pair<Message, ErrorEnum> r103 = r0.b(r42);     // Catch: Exception -> L156
        Message r104 = (Message) r103.component1();     // Catch: Exception -> L156
        if (((ErrorEnum) r103.component2()) != null) goto L350;
        r104 = r42;
    L159:
        r117 = r104;
        goto L160
    L350:
        ug8.g.c(r42);     // Catch: Exception -> L153
    L153:
        e = e;
    L158:
        FLogger.a.e("MarkdownRenderInterceptorManager", "render message error, current latest message id : " + ug8.g.i + ' ', e);
    L156:
        e = e;
        r104 = r42;
        goto L158
    L91:
        r25 = null;
        goto L92
    L85:
        r23 = null;
        goto L86
    L98:
        if (of8.j.a(r42) == false) goto L108;
        com.larus.bmhome.chat.layout.item.i r105 = this.d;
        if ((r105 instanceof com.larus.bmhome.chat.layout.item.l) == false) goto L102;
        com.larus.bmhome.chat.layout.item.l r106 = (com.larus.bmhome.chat.layout.item.l) r105;
    L103:
        if (r106 == null) goto L105;
        r106.setupDisableBoxBackground(true);
    L105:
        this.r = true;
        P(0);
        hk9.a r107 = this.p;
        if (r107 == null) goto L139;
        r107.setPadding(0, 0, 0, 0);
        goto L139
    L102:
        r106 = null;
        goto L103
    L108:
        boolean r108 = Q(r42);
        Intrinsics.checkNotNullParameter(r42, "<this>");
        Map r129 = r42.getBusinessExt();
        if (r129 == null) goto L111;
        String r130 = (String) r129.get("show_dash_border");
    L112:
        boolean r131 = Intrinsics.areEqual(r130, "1");
        com.larus.bmhome.chat.layout.item.i r132 = this.d;
        if ((r132 instanceof com.larus.bmhome.chat.layout.item.l) == false) goto L115;
        com.larus.bmhome.chat.layout.item.l r133 = (com.larus.bmhome.chat.layout.item.l) r132;
    L116:
        if (r133 == null) goto L118;
        r133.setupDisableBoxBackground(r131);
    L118:
        if (r108 == true) goto L122;
        if (r131 == true) goto L122;
        boolean r134 = false;
    L123:
        this.r = r134;
        if (r108 == false) goto L126;
        int r135 = 0;
    L127:
        P(r135);
        if (r108 == false) goto L132;
        hk9.a r109 = this.p;
        if (r109 == null) goto L139;
        r109.setPadding(0, 0, 0, 0);
        goto L139
    L132:
        Intrinsics.checkNotNullParameter(r42, "<this>");
        if (vd9.r.a(r42).isEmpty() == false) goto L135;
        int r136 = i5.q();
    L136:
        hk9.a r137 = this.p;
        if (r137 == null) goto L139;
        r137.setPadding(r136, r136, r136, r136);
        goto L139
    L135:
        r136 = 0;
        goto L136
    L126:
        r135 = i5.q();
    L122:
        r134 = true;
        goto L123
    L115:
        r133 = null;
        goto L116
    L111:
        r130 = null;
    L77:
        r113 = false;
        goto L78
    L62:
        if (r19.isEmpty() == false) goto L64;
    L80:
        r21 = false;
        goto L81
    L52:
        if (com.larus.bmhome.chat.bean.d.j0(r42) == false) goto L55;
        r18 = false;
    L37:
        if (r9 == true) goto L40;
        if (r10 == false) goto L40;
        r17 = ExpandCardViewMode.EXPAND_PIC;
    L40:
        r17 = ExpandCardViewMode.EXPAND;
        goto L49
    L41:
        if (r16 == true) goto L349;
        if (r9 == false) goto L45;
        if (r10 == true) goto L45;
        r17 = ExpandCardViewMode.NORMAL_SHARE;
    L45:
        if (r9 == true) goto L48;
        if (r10 == false) goto L48;
        r17 = ExpandCardViewMode.NORMAL_PIC;
    L48:
        r17 = ExpandCardViewMode.NORMAL;
        goto L49
    L349:
        throw new NoWhenBranchMatchedException();
    L31:
        r15 = null;
        goto L32
    L27:
        r13 = 0;
        goto L28
    L23:
        r9 = false;
        goto L24
    L11:
        r6 = null;
        goto L13
    L5:
        r4 = null;
        goto L6
    }

    @Override // bd8.b
    public final List<View> x(int r1, Context r2, BaseMessageListCell<?> r3, com.larus.bmhome.chat.layout.item.i r4, com.larus.bmhome.chat.api.q0 r5, Fragment r6) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.q = false;
        int r7 = ra8.a.a;
        hk9.a r8 = ra8.a.a(r2);
        this.p = r8;
        r8.setOrientation(1);
        if (r4 == null) goto L6;
        r4.addView(r8, r1, new LinearLayout.LayoutParams(-2, -2));
    L6:
        return CollectionsKt.listOf(r8);
    }
}
