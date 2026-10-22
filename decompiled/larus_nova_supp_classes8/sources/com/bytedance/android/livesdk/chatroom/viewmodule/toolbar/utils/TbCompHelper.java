package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.utils;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.room.api.ILiveExperienceProxyService;
import com.bytedance.android.live.room.api.base.alog.SimpleAlogArgsBuilder;
import com.bytedance.android.livesdk.arch.container.AbsTbContainer;
import com.bytedance.android.livesdk.chatroom.utils.VSMediaUIConfigHelper;
import com.bytedance.android.livesdk.chatroom.utils.o1;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.g2;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.x3;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.toolbarservice.utils.ToolbarRuleUtil;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdkapi.room.handler.toolbar.LiveTbArchUtils;
import com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarMatchInterface;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class TbCompHelper implements a {
    public final Map<ToolbarButton, View> a;
    public final CompositeDisposable b;
    public final Lazy c;
    public a.InterfaceC0083a d;
    public List<Integer> e;
    public final ot2.d f;
    public final com.bytedance.android.livesdk.arch.context.a g;
    public final ViewGroup h;

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.utils.a
    public final void onDestroy() {
        this.b.clear();
        ((HashMap) this.a).clear();
    }

    public static ViewGroup d(com.bytedance.android.livesdk.arch.comp.b r2) {
        View r3 = r2.c;
        if ((r3 instanceof ViewGroup) == true) goto L5;
        r3 = null;
    L5:
        ViewGroup r4 = (ViewGroup) r3;
        if (r4 != null) goto L8;
        return null;
    L8:
        if (r4.getTag(2131389889) == null) goto L10;
        boolean r0 = true;
    L11:
        if (r0 == true) goto L13;
        return null;
    L13:
        return r4;
    L10:
        r0 = false;
        goto L11
    }

    public static ToolbarButton e(com.bytedance.android.livesdk.arch.comp.b r4) {
        a0 r0 = r4.c();
        if (r0 == null) goto L10;
        boolean r2 = false;
        boolean r1 = gb2.a.a(r4.f.getDataCenter(), false);
        ToolbarMatchInterface r5 = r4.d();
        if (r5 == null) goto L12;
        if (r5.isInMore() != true) goto L12;
        r2 = true;
    L12:
        return r0.l(r1, r2);
    L10:
        return null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.utils.a
    public final void b(AbsTbContainer.contentHelper.2.a r1) {
        this.d = r1;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.utils.a
    public final void a(com.bytedance.android.livesdk.arch.comp.b r19, ViewGroup r20) {
        Intrinsics.checkNotNullParameter(r19, "comp");
        if (r20 != null) goto L5;
        return;
    L5:
        LiveTbArchUtils r4 = LiveTbArchUtils.INSTANCE;
        if (r4.fixAddViewError() == false) goto L29;
        View r5 = d(r19);
        if (r5 != null) goto L14;
        ToolbarButton r6 = e(r19);
        if (r6 == null) goto L13;
        r5 = (View) ((HashMap) this.a).get(r6);
        goto L14
    L13:
        r5 = null;
    L14:
        if (r5 != null) goto L56;
        com.bytedance.android.livesdk.arch.comp.h r7 = (com.bytedance.android.livesdk.arch.comp.h) r19;
        ie1.c r8 = r7.q();
        if ((r8 instanceof ie1.c) == false) goto L24;
        r5 = (View) r8.a(new ie1.c.a(r20.getContext(), r20));
        if (r5.getParent() == null) goto L56;
        if (v.a() == false) goto L56;
        throw new IllegalStateException("card view must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
    L24:
        ot2.d r9 = this.f;
        if (r9 == null) goto L27;
        LayoutInflater r10 = r9.getLayoutInflate();
    L28:
        r5 = c(r10, r7, r20, r8);
        goto L56
    L27:
        r10 = null;
    L56:
        if (r5 == null) goto L70;
        ViewParent r11 = r5.getParent();
        if (r11 == null) goto L70;
        if ((!Intrinsics.areEqual(r11, r20)) == true) goto L63;
        r11 = null;
    L63:
        if (r11 == null) goto L70;
        if ((r11 instanceof ViewGroup) == true) goto L67;
        r11 = null;
    L67:
        ViewGroup r12 = (ViewGroup) r11;
        if (r12 == null) goto L70;
        r12.clearAnimation();
        r12.removeView(r5);
    L70:
        if (r5 == null) goto L191;
        ToolbarMatchInterface r13 = r19.d();
        if (r13 == null) goto L74;
        Integer r14 = Integer.valueOf(r13.getComponentId());
    L75:
        int r15 = 2131389840;
        r5.setTag(2131389840, Integer.valueOf(r14.intValue()));
        ToolbarMatchInterface r16 = r19.d();
        if (r16 == null) goto L78;
        Integer r17 = Integer.valueOf(r16.getComponentId());
    L79:
        int r18 = r17.intValue();
        if (r5.getParent() == null) goto L82;
        z51.e r21 = (z51.e) this.c.getValue();
        if (r21 == null) goto L174;
        int r22 = ne1.c.d;
        ne1.c r23 = ne1.c.a.a(r19, "view已经在布局中了，不再添加");
        Pair[] r110 = new Pair[4];
        r110[0] = TuplesKt.to("container", ((com.bytedance.android.livesdk.arch.comp.h) r19).p().a);
        ToolbarMatchInterface r111 = r19.d();
        if (r111 == null) goto L168;
        String r112 = r111.compInfo();
    L169:
        r110[1] = TuplesKt.to("comp", r112.toString());
        ToolbarMatchInterface r3 = r19.d();
        if (r3 == null) goto L172;
        Boolean r24 = Boolean.valueOf(r3.isFromMsg());
    L173:
        r110[2] = TuplesKt.to("from_msg", String.valueOf(r24.booleanValue()));
        r110[3] = TuplesKt.to("is_portrait", String.valueOf(gb2.a.c(r19.f.getDataCenter(), true)));
        r23.b(r110);
        Unit r25 = Unit.INSTANCE;
        r21.b(r23);
        goto L174
    L172:
        r24 = null;
        goto L173
    L168:
        r112 = null;
    L174:
        r19.c = r5;
        if (r19.d == true) goto L177;
        r19.d = true;
        r19.j();
    L177:
        ToolbarMatchInterface r26 = null;
        m r27 = bp1.j.a(null, 3).e();
        if (r27 != null) goto L180;
    L188:
        r5.setVisibility(0);
        a.InterfaceC0083a r2 = this.d;
        if (r2 == null) goto L191;
        r2.a(r19, r5);
        goto L191
    L180:
        if (((Boolean) r27.getValue()).booleanValue() != true) goto L188;
        if (r5.getVisibility() == 0) goto L188;
        o1 r28 = o1.d();
        DataCenter r29 = r19.f.getDataCenter();
        int r30 = r20.indexOfChild(r5);
        ToolbarMatchInterface r31 = r19.d();
        if ((r31 instanceof s) == false) goto L187;
        r26 = r31;
    L187:
        r28.getClass();
        o1.e(r29, "livesdk_toolbar_icon_show", r18, r30, (s) r26);
        goto L188
    L82:
        if (r4.enablePrefOpt() == false) goto L86;
        List<Integer> r113 = this.e;
        if (r113 != null) goto L87;
        DataCenter r114 = r19.f.getDataCenter();
        int r115 = ToolbarRuleUtil.a;
        r113 = (List) new ToolbarRuleUtil.Rule(r114).b.getValue();
        this.e = r113;
    L87:
        ToolbarMatchInterface r116 = r19.d();
        if (r116 == null) goto L90;
        Integer r117 = Integer.valueOf(r116.getComponentId());
    L91:
        int r118 = r113.indexOf(r117);
        if (r118 != (-1)) goto L95;
    L119:
        int r32 = -1;
    L123:
        if (r32 == (-1)) goto L148;
        z51.e r119 = (z51.e) this.c.getValue();
        if (r119 == null) goto L135;
        int r120 = ne1.c.d;
        ne1.c r121 = ne1.c.a.a(r19, "添加到布局");
        Pair[] r33 = new Pair[5];
        r33[0] = TuplesKt.to("container", ((com.bytedance.android.livesdk.arch.comp.h) r19).p().a);
        r33[1] = TuplesKt.to("index", Integer.valueOf(r32));
        ToolbarMatchInterface r122 = r19.d();
        if (r122 == null) goto L129;
        String r123 = r122.compInfo();
    L130:
        r33[2] = TuplesKt.to("comp", r123.toString());
        ToolbarMatchInterface r34 = r19.d();
        if (r34 == null) goto L133;
        Boolean r35 = Boolean.valueOf(r34.isFromMsg());
    L134:
        r33[3] = TuplesKt.to("from_msg", String.valueOf(r35.booleanValue()));
        r33[4] = TuplesKt.to("is_portrait", String.valueOf(gb2.a.c(r19.f.getDataCenter(), true)));
        r121.b(r33);
        Unit r36 = Unit.INSTANCE;
        r119.b(r121);
        goto L135
    L133:
        r35 = null;
        goto L134
    L129:
        r123 = null;
    L135:
        r20.addView(r5, r32);
        if (LiveTbArchUtils.INSTANCE.optViewCache() == false) goto L145;
        ToolbarButton r37 = e(r19);
        if (r37 == null) goto L140;
        ((HashMap) this.a).put(r37, r5);
        goto L145
    L140:
        ke1.a.a.getClass();
        ke1.a r38 = ke1.a.a.a();
        if (r38 == null) goto L144;
        SimpleAlogArgsBuilder r39 = new SimpleAlogArgsBuilder();
        r39.c("缓存view失败，getToolbarBtn为空");
        Unit r40 = Unit.INSTANCE;
        r38.c(r39.b());
        ke1.f.a r41 = new ke1.f.a("缓存view失败，getToolbarBtn为空");
        r41.b = true;
        r38.a(new ke1.f(r41));
    L144:
        Unit r42 = Unit.INSTANCE;
    L145:
        ot2.d r43 = this.f;
        if (r43 == null) goto L174;
        r43.onChildViewChanged(true, r18, r5);
        goto L174
    L148:
        z51.e r124 = (z51.e) this.c.getValue();
        if (r124 == null) goto L174;
        int r125 = ne1.c.d;
        ne1.c r126 = ne1.c.a.a(r19, "添加到布局出错");
        Pair[] r127 = new Pair[6];
        r127[0] = TuplesKt.to("container", ((com.bytedance.android.livesdk.arch.comp.h) r19).p().a);
        r127[1] = TuplesKt.to("index", Integer.valueOf(r32));
        if (r5.getParent() == null) goto L153;
        boolean r44 = true;
    L154:
        r127[2] = TuplesKt.to("has_parent", String.valueOf(r44));
        ToolbarMatchInterface r45 = r19.d();
        if (r45 == null) goto L157;
        String r46 = r45.compInfo();
    L158:
        r127[3] = TuplesKt.to("comp", r46.toString());
        ToolbarMatchInterface r47 = r19.d();
        if (r47 == null) goto L161;
        Boolean r48 = Boolean.valueOf(r47.isFromMsg());
    L162:
        r127[4] = TuplesKt.to("from_msg", String.valueOf(r48.booleanValue()));
        r127[5] = TuplesKt.to("is_portrait", String.valueOf(gb2.a.c(r19.f.getDataCenter(), true)));
        r126.b(r127);
        r126.b = true;
        Unit r49 = Unit.INSTANCE;
        r124.b(r126);
        goto L174
    L161:
        r48 = null;
        goto L162
    L157:
        r46 = null;
        goto L158
    L153:
        r44 = false;
        goto L154
    L95:
        if (r4.enablePrefOpt() == false) goto L109;
        int r50 = r20.getChildCount() - 1;
    L97:
        if (r50 < 0) goto L108;
        View r128 = r20.getChildAt(r50);
        if (r128 == null) goto L107;
        Object r129 = r128.getTag(2131389840);
        if ((r129 instanceof Integer) == false) goto L119;
        int r130 = r113.indexOf(r129);
        if (r130 == r118) goto L119;
        if (r130 >= r118) goto L107;
        r32 = r50 + 1;
    L107:
        r50 = r50 - 1;
        goto L97
    L108:
        r32 = 0;
        goto L123
    L109:
        int r51 = r20.getChildCount();
        int r131 = 0;
    L110:
        if (r131 >= r51) goto L121;
        View r132 = r20.getChildAt(r131);
        if (r132 == null) goto L120;
        Object r133 = r132.getTag(r15);
        if ((r133 instanceof Integer) == false) goto L119;
        int r52 = r113.indexOf(r133);
        if (r52 > r118) goto L117;
        if (r52 != r118) goto L120;
    L117:
        r32 = r131;
    L120:
        r131 = r131 + 1;
        r15 = 2131389840;
        goto L110
    L121:
        r32 = r20.getChildCount();
        goto L123
    L90:
        r117 = null;
        goto L91
    L86:
        DataCenter r134 = r19.f.getDataCenter();
        int r135 = ToolbarRuleUtil.a;
        r113 = (List) new ToolbarRuleUtil.Rule(r134).b.getValue();
        goto L87
    L78:
        r17 = null;
        goto L79
    L74:
        r14 = null;
    L191:
        if (r5 != null) goto L208;
        z51.e r53 = (z51.e) this.c.getValue();
        if (r53 == null) goto L209;
        int r54 = ne1.c.d;
        ne1.c r1 = ne1.c.a.a(r19, "toolbar创建的view为空");
        r1.b = true;
        Unit r55 = Unit.INSTANCE;
        r53.b(r1);
        return;
    L209:
        return;
    L208:
        return;
    L29:
        com.bytedance.android.livesdk.arch.comp.h r56 = (com.bytedance.android.livesdk.arch.comp.h) r19;
        ie1.c r57 = r56.q();
        if ((r57 instanceof ie1.c) == false) goto L47;
        ViewGroup r58 = d(r56);
        if (r58 == null) goto L34;
        r5 = r58;
    L38:
        if (r5 != null) goto L56;
        r5 = (View) r57.a(new ie1.c.a(r20.getContext(), r20));
        if (r5.getParent() != null) goto L42;
    L46:
        Unit r59 = Unit.INSTANCE;
        goto L56
    L42:
        if (v.a() == false) goto L46;
        throw new IllegalStateException("card view must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
    L34:
        ToolbarButton r60 = e(r56);
        if (r60 == null) goto L37;
        r5 = (View) ((HashMap) this.a).get(r60);
        goto L38
    L37:
        r5 = null;
        goto L38
    L47:
        ViewGroup r61 = d(r56);
        if (r61 == null) goto L50;
        r5 = r61;
        goto L56
    L50:
        ot2.d r62 = this.f;
        if (r62 == null) goto L53;
        LayoutInflater r63 = r62.getLayoutInflate();
    L54:
        r5 = c(r63, r56, r20, r57);
        goto L56
    L53:
        r63 = null;
        goto L54
    }

    public TbCompHelper(ot2.d r1, com.bytedance.android.livesdk.arch.context.a r2, ViewGroup r3) {
        this.f = r1;
        this.g = r2;
        this.h = r3;
        this.a = new HashMap();
        this.b = new CompositeDisposable();
        this.c = LazyKt.lazy(new TbCompHelper$stateDispatcher$2(this));
    }

    public final View c(LayoutInflater r20, com.bytedance.android.livesdk.arch.comp.b r21, ViewGroup r22, ie1.a r23) {
        Intrinsics.checkNotNullParameter(r21, "comp");
        Intrinsics.checkNotNullParameter(r23, "content");
        ToolbarButton r3 = e(r21);
        if (r3 != null) goto L9;
        ke1.a.a.getClass();
        ke1.a r1 = ke1.a.a.a();
        if (r1 == null) goto L8;
        SimpleAlogArgsBuilder r2 = new SimpleAlogArgsBuilder();
        r2.c("创建view失败，configToView toolbarBtn为空");
        Unit r6 = Unit.INSTANCE;
        r1.c(r2.b());
        ke1.f.a r4 = new ke1.f.a("创建view失败，configToView toolbarBtn为空");
        r4.b = true;
        r1.a(new ke1.f(r4));
    L8:
        return null;
    L9:
        LiveTbArchUtils r7 = LiveTbArchUtils.INSTANCE;
        if (r7.fixAddViewError() == true) goto L12;
        View r8 = (View) ((HashMap) this.a).get(r3);
    L13:
        if (r8 == null) goto L15;
    L17:
        int r5 = ((Number) r23.a(Unit.INSTANCE)).intValue();
        boolean r16 = gb2.a.a(r21.f.getDataCenter(), false);
        boolean r17 = gb2.a.c(r21.f.getDataCenter(), true);
        if (r8 != null) goto L43;
        String r11 = r3.name();
        ILiveExperienceProxyService r9 = k.f(ILiveExperienceProxyService.class);
        if (r9 == null) goto L22;
        int r10 = 2131567861;
        View r12 = r9.tryNitaInflate(r11, r5, r11, ContextUtil.contextToActivity(r21.f.getContext()), r22, false, r20);
    L23:
        int r13 = g2.a;
        if (g2.b(Boolean.valueOf(r16)) == false) goto L37;
        if (r12 == null) goto L37;
        ViewGroup.LayoutParams r14 = r12.getLayoutParams();
        if (r14 == null) goto L37;
        int r15 = r14.width;
        if (r15 == r14.height) goto L31;
    L33:
        boolean r18 = false;
    L34:
        if (r18 != true) goto L37;
        UIUtils.setLayoutParams(r12, s1.f(38.0f), s1.f(38.0f));
        goto L37
    L31:
        if (r15 != s1.f(36.0f)) goto L33;
        r18 = true;
    L37:
        if (r7.optViewCache() == true) goto L42;
        if (r5 != r10) goto L42;
        if (r3 == ToolbarButton.VS_ACTIVITY_ONE) goto L42;
        ((HashMap) this.a).put(r3, r12);
    L42:
        r8 = r12;
    L45:
        if (r5 != r10) goto L52;
        if (r8 == null) goto L48;
        View r19 = r8.findViewById(2131374718);
    L49:
        if (r19 == null) goto L52;
        r19.setBackgroundResource(r3.getDrawableUnfolded());
        goto L52
    L48:
        r19 = null;
    L52:
        if (r3.isPureText() != true) goto L61;
        if (r8 == null) goto L55;
        View r24 = r8.findViewById(2131390392);
    L56:
        String r25 = r3.extended().g();
        if ((r24 instanceof TextView) == false) goto L61;
        if (TextUtils.isEmpty(r25) == true) goto L61;
        a1.p(r24, s1.f(36.0f));
        r24.setPadding(0, 0, 0, 0);
        ((TextView) r24).setText(r25);
        UIUtils.setViewVisibility(r24, 0);
        goto L61
    L55:
        r24 = null;
    L61:
        if (r8 == null) goto L73;
        c0 r26 = y3.m(r21.f.getDataCenter());
        if ((r26 instanceof x3) == true) goto L65;
        c0 r27 = null;
    L66:
        x3 r28 = (x3) r27;
        if (r28 == null) goto L72;
        c0.b r29 = r28.t(r3);
        if ((r29 instanceof c0.a) == false) goto L72;
        c0.a r30 = (c0.a) r29;
        this.b.add(r30.getTitle().observeOn(AndroidSchedulers.mainThread()).subscribe(new h(r8)));
        this.b.add(r30.getIcon().observeOn(AndroidSchedulers.mainThread()).subscribe(new i(r8)));
    L72:
        r8.setTag(r3);
        r8.setVisibility(8);
        goto L73
    L65:
        r27 = r26;
    L73:
        boolean r31 = VSMediaUIConfigHelper.b(r21.f.getDataCenter());
        if (r31 == false) goto L76;
        float r32 = 16.0f;
    L77:
        int r33 = com.bytedance.android.livesdk.utils.landscape.d.a;
        if ((!r17) == false) goto L81;
        if (r16 == true) goto L81;
        UIUtils.updateLayoutMargin(r8, s1.f(r32), -3, 0, -3);
    L86:
        r3.i(r8, r3);
        if (r8 == null) goto L94;
        ot2.d r34 = this.f;
        if (r34 == null) goto L92;
        r34.putView2ToolbarManager(r3, r8);
    L92:
        if (r7.optViewCache() == true) goto L94;
        ((HashMap) this.a).put(r3, r8);
    L94:
        return r8;
    L81:
        if (r31 == false) goto L86;
        if (r8 == null) goto L86;
        if (a1.f(r8) != s1.f(r32)) goto L86;
        UIUtils.updateLayoutMargin(r8, s1.f(8.0f), -3, 0, -3);
        goto L86
    L76:
        r32 = 14.0f;
        goto L77
    L22:
        r10 = 2131567861;
        r12 = null;
        goto L23
    L43:
        r10 = 2131567861;
        goto L45
    L15:
        if (r7.fixAddViewError() == false) goto L17;
        r8 = (View) ((HashMap) this.a).get(r3);
        goto L17
    L12:
        r8 = null;
        goto L13
    }
}
