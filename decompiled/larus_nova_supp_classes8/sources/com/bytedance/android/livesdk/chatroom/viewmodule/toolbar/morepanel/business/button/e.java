package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.business.button;

import am2.j;
import am2.x;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.t;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.ui.RedDotView;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ExtendedToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.b4;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.k;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c4;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.h3;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.business.ext.ChangeIconThemeHelper;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.core.element.ElementType;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.s;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.x3;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.z3;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.ToolbarAnchorBacktrackBehavior;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.ToolbarAnchorRecordBehavior;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.ToolbarAudioCommentBehavior;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.ToolbarShakeMatchBehavior;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.n2;
import com.bytedance.android.livesdk.common.LiveViewStub;
import com.bytedance.android.livesdk.config.setting.o;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.reddot.RedDotDelegate;
import com.bytedance.android.livesdk.room.placeholder.behavior.p;
import com.bytedance.android.livesdk.utils.g3;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.utils.ab.MoreMixSharePanelUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import zg1.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public abstract class e implements s<lp1.a>, View.OnClickListener {
    public final CompositeDisposable a;
    public lp1.a b;
    public final float c;
    public final jp1.b d;

    public final boolean c() {
        return z.e(this.d.getDataCenter(), false);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.s
    public final void j() {
        lp1.a r0 = this.b;
        if (r0 == null) goto L9;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e r1 = r0.getButton();
        if (r1 == null) goto L9;
        s<Object> r2 = r1.k;
        if (r2 == null) goto L9;
        r2.j();
    L9:
        this.a.clear();
    }

    public e(jp1.b r2) {
        Intrinsics.checkNotNullParameter(r2, "session");
        this.d = r2;
        this.a = new CompositeDisposable();
        this.c = 0.64f;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r10) {
        lp1.a r0 = null;
        String r1 = null;
        if (r10 == null) goto L5;
        Object r2 = r10.getTag();
    L7:
        if ((r2 instanceof com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e) == true) goto L9;
        r2 = null;
    L9:
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e r3 = (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e) r2;
        if (r3 == null) goto L12;
        ExtendedToolbarButton r4 = r3.m;
    L13:
        x3 r5 = this.d.getToolbarManager();
        if (r4 == null) goto L143;
        DataCenter r6 = this.d.getDataCenter();
        if (r6 == null) goto L18;
        m r7 = (m) r6.get("data_broadcast_pause_state", null);
    L20:
        if (r7 == null) goto L25;
        int r8 = r7.a;
        if (r8 == 1) goto L24;
        if (r8 != 2) goto L25;
    L24:
        boolean r9 = true;
    L26:
        if (r9 == false) goto L32;
        if (r5 == null) goto L32;
        if (r5.x(r4) != true) goto L32;
        f2.b(2131915411, 0);
        return;
    L32:
        if (r5 == null) goto L34;
        c0.b r11 = r5.s(r4);
    L35:
        if (r5 != null) goto L37;
    L42:
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.h r12 = r3.j;
        if (r12 != null) goto L45;
    L53:
        if (r11 != null) goto L55;
        return;
    L55:
        if (c4.a(c()) == false) goto L62;
        if (r10 == null) goto L58;
        Object r13 = r10.findViewById(2131384095);
    L60:
        if ((r13 instanceof RedDotView) == false) goto L62;
        ((RedDotView) r13).l();
        goto L62
    L58:
        r13 = null;
    L62:
        r11.onClick(r10);
        b4.c.a.b(r4.f());
        h r14 = (h) this;
        Intrinsics.checkNotNullParameter(r4, "config");
        Intrinsics.checkNotNullParameter(r11, "behavior");
        lp1.a r15 = r14.b;
        if (r15 == null) goto L65;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e r16 = r15.getButton();
    L66:
        if (r16 != null) goto L69;
    L97:
        lp1.a r17 = r14.b;
        if (r17 == null) goto L103;
        k r18 = r14.d.b();
        if (r18 == null) goto L103;
        r18.checkClickEffectButton(r17);
    L103:
        if ((r4 instanceof ExtendedToolbarButton.d) == false) goto L106;
        r14.d();
        return;
    L106:
        if ((r11 instanceof ToolbarAnchorBacktrackBehavior) == false) goto L111;
        if (((ToolbarAnchorBacktrackBehavior) r11).d == false) goto L146;
        r14.d();
        return;
    L146:
        return;
    L111:
        if ((r11 instanceof ToolbarAnchorRecordBehavior) == false) goto L116;
        if (((ToolbarAnchorRecordBehavior) r11).e == false) goto L148;
        r14.d();
        return;
    L148:
        return;
    L116:
        if ((r11 instanceof ToolbarShakeMatchBehavior) == false) goto L119;
        ToolbarShakeMatchBehavior r19 = (ToolbarShakeMatchBehavior) r11;
        return;
    L119:
        if ((r11 instanceof n2) == false) goto L122;
        n2 r20 = (n2) r11;
        return;
    L122:
        if ((r11 instanceof p) == false) goto L124;
        return;
    L124:
        if ((r4 instanceof ExtendedToolbarButton.b) == false) goto L138;
        ToolbarButton r21 = ((ExtendedToolbarButton.b) r4).i;
        if (r21 == ToolbarButton.REVERSE_CAMERA) goto L138;
        if (r21 == ToolbarButton.REVERSE_MIRROR) goto L138;
        if (r21 == ToolbarButton.AUDIO_TOGGLE) goto L138;
        if (r21 == ToolbarButton.WATCH_LATER) goto L138;
        if ((r11 instanceof ToolbarAudioCommentBehavior) == true) goto L136;
    L139:
        r14.d();
        return;
    L136:
        if (((ToolbarAudioCommentBehavior) r11).d == true) goto L139;
    L138:
        if ((r4 instanceof ExtendedToolbarButton.c) == true) goto L139;
        return;
    L69:
        if (r16.l.length() <= 0) goto L71;
        boolean r22 = true;
    L72:
        if (r22 == false) goto L74;
        String r23 = r16.l;
    L75:
        HashMap r24 = new HashMap();
        r24.put("icon_type", r23);
        j.c r25 = j.a().b;
        if (r25 != null) goto L78;
        int r26 = -1;
    L79:
        r24.put("net_quality", String.valueOf(r26));
        lp1.a r27 = r14.b;
        if (r27 != null) goto L82;
    L86:
        IUserService r28 = jc1.k.f(IUserService.class);
        if (r28 == null) goto L95;
        com.bytedance.android.livesdk.user.f r29 = r28.user();
        if (r29 == null) goto L95;
        IUser r30 = r29.b();
        if (r30 == null) goto L95;
        py.d r31 = r30.getUserHonor();
        if (r31 == null) goto L95;
        int r32 = r31.getLevel();
    L96:
        r24.put("privilege_level", String.valueOf(r32));
        u.l().sendLog("livesdk_more_function_panel_icon_click", r24, new Object[]{x.class, Room.class});
    L95:
        r32 = 0;
        goto L96
    L82:
        if (r27.a() == false) goto L84;
        r0 = r27;
    L84:
        if (r0 == null) goto L86;
        r24.put("bubble_type", r0.getButton().l);
        goto L86
    L78:
        r26 = r25.getNetQuality();
        goto L79
    L74:
        r23 = r16.f;
        goto L75
    L71:
        r22 = false;
        goto L72
    L65:
        r16 = null;
        goto L66
    L45:
        if (r12.a() != true) goto L53;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.h r110 = r3.j;
        if (r110 == null) goto L50;
        r1 = r110.b;
    L50:
        if (TextUtils.isEmpty(r1) == true) goto L142;
        f2.c(r1, 0);
        return;
    L142:
        return;
    L37:
        if (r5.x(r4) != true) goto L42;
        String r111 = r5.u(r4);
        if (TextUtils.isEmpty(r111) == true) goto L141;
        f2.c(r111, 0);
        return;
    L141:
        return;
    L34:
        r11 = null;
    L25:
        r9 = false;
        goto L26
    L18:
        r7 = null;
        goto L20
    L143:
        return;
    L12:
        r4 = null;
        goto L13
    L5:
        r2 = null;
        goto L7
    }

    public static void a(View r5, lp1.a r6) {
        if (((List) ChangeIconThemeHelper.a.getValue()).contains(Long.valueOf(r6.getButton().g)) == true) goto L5;
        boolean r1 = true;
        if (r6.getButton().i != 1) goto L36;
        Intrinsics.checkNotNullParameter(r6, "buttonModel");
        ExtendedToolbarButton r7 = r6.getButton().m;
        if (r7.e == true) goto L16;
    L26:
        boolean r0 = false;
    L27:
        if (r0 == true) goto L30;
        r7 = null;
    L30:
        if (r7 != null) goto L33;
        r1 = false;
    L33:
        if (r1 == true) goto L36;
        return;
    L16:
        if ((r7 instanceof ExtendedToolbarButton.b) == true) goto L18;
        ExtendedToolbarButton r2 = null;
    L19:
        ExtendedToolbarButton.b r3 = (ExtendedToolbarButton.b) r2;
        if (r3 == null) goto L22;
        ToolbarButton r4 = r3.i;
    L24:
        if (r4 != ToolbarButton.KTV_GROUP) goto L26;
        r0 = true;
        goto L27
    L22:
        r4 = null;
        goto L24
    L18:
        r2 = r7;
    L36:
        if (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.utils.g.b() == false) goto L38;
        int r8 = (int) 4279638051L;
    L39:
        if (r5 == null) goto L49;
        Drawable r9 = r5.getBackground();
        if (r9 == null) goto L50;
        Drawable r10 = r9.mutate();
        if (r10 == null) goto L51;
        r10.setColorFilter(r8, PorterDuff.Mode.SRC_ATOP);
        return;
    L51:
        return;
    L50:
        return;
    L49:
        return;
    L38:
        r8 = -1;
        goto L39
    L5:
        if (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.utils.g.b() == true) goto L7;
        return;
    L7:
        if (r6.getButton().g != ToolbarButton.VS_INTERACTIVE.getId()) goto L47;
        if (r5 == null) goto L48;
        r5.setBackgroundResource(2131251657);
        return;
    L48:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b(final lp1.a r18, View r19, int r20) {
        Intrinsics.checkNotNullParameter(r18, "buttonModel");
        Intrinsics.checkNotNullParameter(r19, "itemView");
        this.b = r18;
        final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e r4 = r18.getButton();
        s<Object> r5 = r4.k;
        if (r5 == null) goto L6;
        r5.o(this.d.c(), r4, r19, r20);
        return;
    L6:
        Context r6 = r19.getContext();
        x3 r7 = this.d.getToolbarManager();
        View r8 = r19.findViewById(2131374718);
        final View r9 = r19.findViewById(2131392095);
        TextView r10 = (TextView) r19.findViewById(2131380593);
        View r11 = r19.findViewById(2131384095);
        View r12 = r19.findViewById(2131362039);
        TextView r13 = (TextView) r19.findViewById(2131374747);
        if (r9 != null) goto L9;
    L13:
        if (r9 != null) goto L15;
    L19:
        if (r8 == null) goto L21;
        r8.setBackgroundResource(r4.b);
    L21:
        ExtendedToolbarButton r14 = r4.m;
        if ((r14 instanceof ExtendedToolbarButton.b) == true) goto L24;
        r14 = null;
    L24:
        ExtendedToolbarButton.b r15 = (ExtendedToolbarButton.b) r14;
        if (r15 == null) goto L27;
        ToolbarButton r16 = r15.i;
    L29:
        if (r16 != ToolbarButton.AUDIENCE_RESOLUTION) goto L31;
        boolean r17 = true;
    L32:
        if (r10 == null) goto L35;
        r10.setText(r4.f);
    L35:
        if (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.utils.g.b() == false) goto L37;
        int r110 = 2132154403;
    L38:
        if (r10 == null) goto L40;
        r10.setTextColor(r110);
    L40:
        if (r10 == null) goto L46;
        if (r17 == false) goto L43;
        b r111 = new b(r4);
    L44:
        r10.setAccessibilityDelegate(r111);
        goto L46
    L43:
        r111 = t.a;
    L46:
        if (o.b() == false) goto L52;
        if (s1.y() >= s1.f(360.0f)) goto L52;
        if (r10 == null) goto L52;
        r10.setTextSize(1, 10.0f);
    L52:
        if (r4.a == false) goto L63;
        List<String> r112 = r4.c;
        if (r112 == null) goto L63;
        if ((!r112.isEmpty()) != true) goto L63;
        CompositeDisposable r113 = this.a;
        List<String> r114 = r4.c;
        if (r114 == null) goto L61;
        String r115 = (String) ListProtector.get(r114, 0);
        if (r115 == null) goto L61;
    L62:
        r113.add(g3.a(r115).toMaybe().observeOn(AndroidSchedulers.mainThread()).doOnError(c.a).onErrorComplete().subscribe(new d(this, r8, r6, r18)));
    L61:
        r115 = "";
    L63:
        if (r13 != null) goto L65;
    L67:
        if (r13 == null) goto L70;
        UtilityKotlinExtentionsKt.t(r13);
    L70:
        if (r4.d == false) goto L79;
        ImageView r21 = new ImageView(r8.getContext());
        if (r4.e == false) goto L74;
        int r116 = 2131251591;
    L75:
        r21.setBackgroundResource(r116);
        LiveViewStub r117 = (LiveViewStub) r19.findViewById(2131374798);
        if (r117 == null) goto L79;
        r117.a(r21);
        goto L79
    L74:
        r116 = 2131251590;
    L79:
        if (r12 == null) goto L81;
        r12.setAlpha(1.0f);
    L81:
        if (r7 == null) goto L85;
        boolean r118 = true;
        if (r7.x(r4.m) != true) goto L86;
    L90:
        if (r8 == null) goto L92;
        r8.setAlpha(this.c);
    L92:
        if (r10 == null) goto L94;
        r10.setAlpha(this.c);
    L94:
        if (r11 == 0) goto L96;
        r11.setAlpha(0.0f);
    L96:
        boolean r119 = true;
    L109:
        if (c4.a(c()) == false) goto L116;
        if ((r11 instanceof RedDotView) == false) goto L116;
        RedDotDelegate r120 = r4.m.c;
        if (r120 == null) goto L116;
        ((RedDotView) r11).n(r120, Boolean.FALSE);
    L116:
        if (r8 == null) goto L146;
        ExtendedToolbarButton r121 = r4.m;
        if (r11 == 0) goto L146;
        if (TextUtils.isEmpty(r121.f()) == true) goto L146;
        if (c4.a(c()) == true) goto L125;
        boolean r122 = b4.c.a.d(r121, this.d.getToolbarManager());
    L129:
        if (r122 == false) goto L131;
        int r22 = 0;
    L132:
        r11.setVisibility(r22);
        if ((r121 instanceof ExtendedToolbarButton.c) == true) goto L135;
    L141:
        DataCenter r23 = this.d.getDataCenter();
        if (r23 == null) goto L146;
        if (z.h(r23) != true) goto L146;
        r11.setVisibility(8);
        goto L146
    L135:
        if (((ExtendedToolbarButton.c) r121).r == true) goto L137;
    L139:
        int r24 = 8;
    L140:
        r11.setVisibility(r24);
        goto L141
    L137:
        if (h3.a(r121.f()) == true) goto L139;
        r24 = 0;
        goto L140
    L131:
        r22 = 8;
        goto L132
    L125:
        if ((r11 instanceof RedDotView) == false) goto L127;
        r122 = ((RedDotView) r11).j();
        goto L129
    L127:
        r122 = false;
    L146:
        r19.setTag(r4);
        if (r7 == null) goto L151;
        Map<ExtendedToolbarButton, View> r25 = r7.c;
        if (r25 == null) goto L151;
        View r26 = (View) ((HashMap) r25).put(r4.m, r19);
    L151:
        if (r7 == null) goto L153;
        r7.D(r4.m, r19);
    L153:
        r19.setOnClickListener(this);
        DataCenter r27 = this.d.getDataCenter();
        if (r27 == null) goto L156;
        Long r28 = (Long) r27.get("data_anchor_current_game_id", -1L);
    L157:
        ExtendedToolbarButton r29 = r4.m;
        if ((r29 instanceof ExtendedToolbarButton.c) == true) goto L160;
        r29 = null;
    L160:
        ExtendedToolbarButton.c r30 = (ExtendedToolbarButton.c) r29;
        if (r30 == null) goto L163;
        Long r31 = Long.valueOf(r30.m);
    L164:
        boolean r32 = Intrinsics.areEqual(r28, r31);
        int r33 = z3.a;
        z3.b(this.d.getDataCenter(), r4, r32, r119, r20);
        a(r8, r18);
        View r2 = r19.findViewById(2131392441);
        MoreMixSharePanelUtils r3 = MoreMixSharePanelUtils.INSTANCE;
        boolean r34 = c();
        DataCenter r35 = this.d.getDataCenter();
        if (r35 == null) goto L167;
        boolean r36 = z.m(r35, true);
    L169:
        if (r3.isMoreMixShareMode(r34, r36) == false) goto L199;
        if (r9 == null) goto L174;
        r9.setBackgroundResource(2131249575);
    L174:
        if (r9 == null) goto L176;
        a1.p(r9, UtilityKotlinExtentionsKt.i(56));
    L176:
        if (r9 == null) goto L178;
        a1.k(r9, UtilityKotlinExtentionsKt.i(56));
    L178:
        if (r2 == null) goto L180;
        a1.p(r2, UtilityKotlinExtentionsKt.i(56));
    L180:
        if (r2 == null) goto L182;
        a1.k(r2, UtilityKotlinExtentionsKt.i(56));
    L182:
        if (r119 == true) goto L186;
        if (r8 == null) goto L186;
        r8.setAlpha(1.0f);
    L186:
        if (r8 == null) goto L188;
        a1.p(r8, UtilityKotlinExtentionsKt.i(36));
    L188:
        if (r8 == null) goto L190;
        a1.k(r8, UtilityKotlinExtentionsKt.i(36));
    L190:
        if (r13 == null) goto L192;
        a1.p(r13, UtilityKotlinExtentionsKt.i(36));
    L192:
        if (r10 == null) goto L194;
        r10.setTextColor(s1.h(2131107010));
    L194:
        if (r10 == null) goto L197;
        r10.setTextSize(1, 12.0f);
    L197:
        if (r10 == null) goto L199;
        a1.o(r10, UtilityKotlinExtentionsKt.i(8));
    L199:
        final k r37 = this.d.b();
        if (r37 != null) goto L202;
        return;
    L202:
        if (r18.b() == true) goto L204;
    L206:
        boolean r123 = false;
    L207:
        if (r123 == true) goto L210;
        r37 = null;
    L210:
        if (r37 == null) goto L214;
        r37.showGuideEffect(400, new ButtonViewBinder$bindData$$inlined$also$lambda$1(r37, r4, r18, r9));
        return;
    L214:
        return;
    L204:
        if (r18.a() == true) goto L206;
        r123 = true;
        goto L207
    L167:
        r36 = true;
        goto L169
    L163:
        r31 = null;
        goto L164
    L156:
        r28 = null;
    L86:
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.h r124 = r4.j;
        if (r124 == null) goto L98;
        if (r124.a() == r118) goto L90;
    L98:
        if (r18.e() != ElementType.Basic) goto L101;
        if (r8 == null) goto L103;
        r8.setAlpha(0.72f);
    L103:
        if (r10 == null) goto L105;
        r10.setAlpha(1.0f);
    L105:
        if (r11 == 0) goto L107;
        r11.setAlpha(1.0f);
    L107:
        r119 = false;
        goto L109
    L101:
        if (r8 == null) goto L103;
        r8.setAlpha(1.0f);
        goto L103
    L85:
        r118 = true;
        goto L86
    L65:
        if (TextUtils.isEmpty(r4.h) == true) goto L67;
        UtilityKotlinExtentionsKt.w(r13);
        r13.setText(r4.h);
        goto L70
    L37:
        r110 = Integer.MAX_VALUE;
        goto L38
    L31:
        r17 = false;
        goto L32
    L27:
        r16 = null;
        goto L29
    L15:
        if (r18.e() != ElementType.Basic) goto L17;
        int r125 = 4;
    L18:
        r9.setVisibility(r125);
        goto L19
    L17:
        r125 = 0;
        goto L18
    L9:
        if (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.utils.g.b() == false) goto L11;
        int r126 = 2131249574;
    L12:
        r9.setBackgroundResource(r126);
        goto L13
    L11:
        r126 = 2131249573;
        goto L12
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.s
    public final /* bridge */ /* synthetic */ void o(WeakReference r1, lp1.a r2, View r3, int r4) {
        b(r2, r3, r4);
    }
}
