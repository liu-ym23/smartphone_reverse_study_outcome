package com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.empty;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.base.MicSeatScene;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.m;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.f;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkNormalEmptyViewBinder;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.plantform.utils.i0;
import com.bytedance.android.live.liveinteract.playmode.SceneType;
import com.bytedance.android.live.liveinteract.pre.VerticalNitaInflate;
import com.bytedance.android.live.liveinteract.revenuebase.MultiRevenueDataContext;
import com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.SelfDisciplineContext;
import com.bytedance.android.live.liveinteract.videotalk.themecompetition.ThemedCompetitionContext;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.android.livesdkapi.interact.data.LinkFeedTypeConstant;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import hd0.c;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import vm2.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class MultiLinkCommonEmptyMicSeatBasicLayer extends b {
    public final int q;
    public final int r;
    public final int s;
    public final int t;
    public final m u;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ MultiLinkCommonEmptyMicSeatBasicLayer a;

        public a(MultiLinkCommonEmptyMicSeatBasicLayer r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Long r3 = (Long) r2;
            this.a.C(true);
        }
    }

    @Override // jg0.c
    public final int o() {
        return 2131566594;
    }

    public final void B() {
        View r0 = this.k;
        if (r0 != null) goto L5;
    L7:
        UIUtils.setViewVisibility(this.k, 0);
        c.f().getClass();
    L8:
        MultiLinkNormalEmptyViewBinder.a r1 = this.e;
        if (r1 != null) goto L11;
    L30:
        CompositeDisposable r2 = this.o;
        if (r2 == null) goto L34;
        r2.add(Observable.timer(((long) d.T()) * 1000, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this)));
        return;
    L34:
        return;
    L11:
        if (r1.g() == true) goto L30;
        if (ThemedCompetitionContext.Companion.g() == true) goto L30;
        MultiRevenueDataContext.Companion.getClass();
        com.bytedance.android.live.liveinteract.revenuebase.b r3 = MultiRevenueDataContext.a.b();
        if (r3 == null) goto L19;
        if (r3.isFightShowing() == true) goto L30;
    L19:
        if (A() == false) goto L21;
        int r4 = this.q;
    L22:
        String r5 = s1.B(r4);
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b r6 = this.i;
        if (r6 == null) goto L25;
        r6.g(r5);
    L25:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b r7 = this.i;
        if (r7 == null) goto L30;
        String r8 = r7.c();
        if (r8 == null) goto L30;
        r3.c(q(), r8, true);
        goto L30
    L21:
        r4 = this.r;
        goto L22
    L5:
        if (r0.getVisibility() != 0) goto L7;
        goto L7
    }

    @Override // jg0.c
    public final String p() {
        return VerticalNitaInflate.Tag.MultiLinkCommonEmptyMicSeatBasicLayer.name();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.empty.b
    public final void v() {
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b r0 = this.i;
        if (r0 == null) goto L9;
        int r1 = ColorProtector.parseColor("#1AFFFFFF");
        r0.g = r1;
        if (r0.a() == false) goto L9;
        ImageView r2 = r0.l;
        if (r2 == null) goto L9;
        r2.setBackgroundColor(r1);
    L9:
        View r3 = this.g;
        IVoiceLiveTheme r4 = null;
        if (r3 == null) goto L12;
        r3.setBackground(null);
    L12:
        MultiLinkNormalEmptyViewBinder.a r5 = this.e;
        if (r5 == null) goto L15;
        r4 = r5.c;
    L15:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b r6 = this.i;
        if (r6 == null) goto L18;
        r6.d(2131251693);
    L18:
        if (r4 == null) goto L22;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b r7 = this.i;
        if (r7 == null) goto L22;
        r7.f(r4);
    L22:
        if (r4 == null) goto L35;
        String r8 = r4.getColorMicText();
        if (r8 == null) goto L35;
        if (r8.length() <= 0) goto L28;
        boolean r9 = true;
    L29:
        if (r9 != true) goto L35;
        TextView r10 = this.h;     // Catch: Exception -> L34
        if (r10 == null) goto L41;
        r10.setTextColor(Color.parseColor(r4.getColorMicText()));     // Catch: Exception -> L34
        return;
    L41:
        return;
    L34:
        ALogger.e("CommonEmptyMultiLinkMicSeatBasicLayer", "set color mic failed, color is " + r4.getColorMicText());
        return;
    L28:
        r9 = false;
    L35:
        TextView r11 = this.h;
        if (r11 == null) goto L43;
        r11.setTextColor(ColorProtector.parseColor("#87FFFFFF"));
        return;
    }

    public final m z() {
        xg0.a r0 = this.c;
        if (r0 == null) goto L7;
        m r1 = r0.getLinkWindowLayoutConfig();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return this.u;
    }

    public final boolean A() {
        return Intrinsics.areEqual(com.bytedance.android.live.liveinteract.api.utils.m.i().isAnchor(), Boolean.TRUE);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.empty.b
    public final void r() {
        if (n() != 1) goto L5;
    L27:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b r0 = this.i;
        if (r0 == null) goto L30;
        r0.k.setTextSize(2, 6.0f);
    L30:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b r1 = this.i;
        if (r1 == null) goto L39;
        int r2 = s1.f(16.0f);
        int r3 = s1.f(16.0f);
        ViewGroup.LayoutParams r4 = r1.j.getLayoutParams();
        r4.width = r2;
        r4.height = r3;
        return;
    L39:
        return;
    L5:
        if (n() == 9) goto L27;
        if (LinkFeedTypeConstant.Companion.isHotsoonFollowAndCity(n()) == true) goto L27;
        if (n() != 5) goto L34;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b r5 = this.i;
        if (r5 == null) goto L14;
        r5.k.setTextSize(1, 8.0f);
    L14:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b r6 = this.i;
        if (r6 == null) goto L18;
        int r7 = s1.f(16.0f);
        int r8 = s1.f(16.0f);
        ViewGroup.LayoutParams r9 = r6.j.getLayoutParams();
        r9.width = r7;
        r9.height = r8;
    L18:
        if (z().getUiLayout() != 112) goto L35;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b r10 = this.i;
        if (r10 == null) goto L36;
        ViewGroup.LayoutParams r11 = r10.k.getLayoutParams();
        if ((r11 instanceof ViewGroup.MarginLayoutParams) == true) goto L24;
        r11 = null;
    L24:
        ViewGroup.MarginLayoutParams r12 = (ViewGroup.MarginLayoutParams) r11;
        if (r12 == null) goto L37;
        r12.topMargin = 0;
        r10.k.setLayoutParams(r12);
        return;
    L37:
        return;
    L36:
        return;
    L35:
        return;
    }

    public final void C(boolean r3) {
        UIUtils.setViewVisibility(this.k, 4);
        MultiLinkNormalEmptyViewBinder.a r4 = this.e;
        if (r4 != null) goto L5;
        return;
    L5:
        if (r4.g() == false) goto L7;
        return;
    L7:
        if (ThemedCompetitionContext.Companion.g() == true) goto L23;
        MultiRevenueDataContext.Companion.getClass();
        com.bytedance.android.live.liveinteract.revenuebase.b r5 = MultiRevenueDataContext.a.b();
        if (r5 != null) goto L11;
    L12:
        A();
        String r6 = s1.B(this.q);
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b r1 = this.i;
        if (r1 == null) goto L15;
        r1.g(r6);
    L15:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b r7 = this.i;
        if (r7 == null) goto L25;
        String r8 = r7.c();
        if (r8 == null) goto L26;
        r3.c(q(), r8, true);
        return;
    L26:
        return;
    L25:
        return;
    L11:
        if (r5.isFightShowing() != true) goto L12;
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.empty.b, jg0.c, jg0.f
    public final void a(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super.a(r2);
        if (A() == false) goto L5;
        return;
    L5:
        if (z().getUiLayout() != 7) goto L9;
        i0 r3 = TalkRoomLogUtils.a;
        TalkRoomLogUtils.M(-1);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.empty.b, jg0.f
    public final /* bridge */ /* synthetic */ void d(Object r1, int r2) {
        w((MultiLinkNormalEmptyViewBinder.a) r1, r2);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.empty.b
    public final void w(MultiLinkNormalEmptyViewBinder.a r6, int r7) {
        Intrinsics.checkNotNullParameter(r6, "itemData");
        super.w(r6, r7);
        if (n() != 0) goto L6;
        q().setOnClickListener(x0.a(new MultiLinkCommonEmptyMicSeatBasicLayer$onBind$1(this)));
    L6:
        if (A() == true) goto L8;
        TextView r0 = this.h;
        if (r0 == null) goto L69;
        r0.setVisibility(8);
    L69:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b r1 = this.i;
        if (r1 == null) goto L72;
        r1.d(2131251693);
    L72:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b r2 = this.i;
        if (r2 == null) goto L76;
        r2.e(0);
    L76:
        if (aj0.b.c(z().getUiLayout()) == false) goto L88;
        int r3 = com.bytedance.android.live.liveinteract.revenue.linkroomfight.ui.a.a;
        if (com.bytedance.android.live.liveinteract.revenue.linkroomfight.ui.a.C0094a.c(Integer.valueOf(r7), z().getUiLayout()) == true) goto L88;
        TextView r4 = this.h;
        if (r4 == null) goto L82;
        r4.setText(String.valueOf(r6.b()));
    L82:
        TextView r5 = this.h;
        if (r5 == null) goto L85;
        r5.setVisibility(0);
    L85:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b r8 = this.i;
        if (r8 == null) goto L88;
        r8.e(8);
    L88:
        Integer r9 = (Integer) ((ge1.a) c.f()).b;
        if (r9 != null) goto L92;
    L94:
        int r10 = this.s;
    L95:
        String r11 = s1.B(r10);
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b r12 = this.i;
        if (r12 == null) goto L99;
        r12.g(r11);
    L99:
        if (A() == false) goto L101;
    L105:
        y();
        if (A() == true) goto L124;
        SelfDisciplineContext.a r13 = SelfDisciplineContext.Companion;
        if (r13.e() == false) goto L124;
        SelfDisciplineContext r14 = r13.getContext();
        if (r14 == null) goto L124;
        com.bytedance.live.datacontext.m<String> r15 = r14.getCurrentTarget();
        if (r15 == null) goto L124;
        String r16 = (String) r15.getValue();
        if (r16 == null) goto L124;
        if ((!StringsKt.isBlank(r16)) == true) goto L119;
        r16 = null;
    L119:
        if (r16 == null) goto L124;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b r17 = this.i;
        if (r17 == null) goto L124;
        r17.g(r16);
    L124:
        if (r6.i() == false) goto L137;
        if (A() == false) goto L128;
    L133:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b r18 = this.i;
        if (r18 == null) goto L137;
        r18.g(s1.B(2131922884));
        goto L137
    L128:
        if (r6.h() == true) goto L133;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b r19 = this.i;
        if (r19 == null) goto L137;
        r19.g(s1.B(2131922885));
    L137:
        if (r6.f() == false) goto L139;
        B();
    L139:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b r20 = this.i;
        if (r20 == null) goto L144;
        String r21 = r20.c();
        if (r21 == null) goto L144;
        r3.c(q(), r7 + s1.B(2131920341) + r21, true);
    L144:
        v();
        u(false);
        com.bytedance.android.live.liveinteract.revenue.fight.b r22 = ((IInteractService) k.n(IInteractService.class)).teamFightService();
        if (r22 == null) goto L148;
        r22.F1(this, SceneType.SCENE_VIDEO_TALKROOM);
    L148:
        if (aj0.b.c(z().getUiLayout()) == false) goto L151;
        int r23 = com.bytedance.android.live.liveinteract.revenue.linkroomfight.ui.a.a;
        com.bytedance.android.live.liveinteract.revenue.linkroomfight.ui.a.C0094a.g(this, r7);
    L151:
        if (aj0.b.c(z().getUiLayout()) == true) goto L153;
        return;
    L153:
        if (n() == 0) goto L177;
        int r24 = com.bytedance.android.live.liveinteract.revenue.linkroomfight.ui.a.a;
        if (com.bytedance.android.live.liveinteract.revenue.linkroomfight.ui.a.C0094a.c(Integer.valueOf(r7), z().getUiLayout()) == false) goto L164;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b r25 = this.i;
        if (r25 == null) goto L161;
        r25.h = 2131253256;
        ImageView r26 = r25.l;
        if (r26 == null) goto L161;
        r26.setBackgroundResource(2131253256);
    L161:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b r27 = this.i;
        if (r27 == null) goto L178;
        r27.g(s1.B(2131918755));
        return;
    L178:
        return;
    L164:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b r28 = this.i;
        if (r28 == null) goto L169;
        r28.h = 2131253255;
        ImageView r29 = r28.l;
        if (r29 == null) goto L169;
        r29.setBackgroundResource(2131253255);
    L169:
        TextView r30 = this.h;
        if (r30 == null) goto L172;
        r30.setText(String.valueOf(com.bytedance.android.live.liveinteract.revenue.linkroomfight.ui.a.C0094a.a(r7, z().getUiLayout()) + 1));
    L172:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b r31 = this.i;
        if (r31 == null) goto L180;
        r31.g(s1.B(2131918757));
        return;
    L180:
        return;
    L177:
        return;
    L101:
        if (r6.g() == false) goto L105;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b r32 = this.i;
        if (r32 == null) goto L105;
        r32.g(s1.B(this.t));
        goto L105
    L92:
        if (2 != r9.intValue()) goto L94;
        r10 = this.r;
        goto L95
    L8:
        if (f.d() == false) goto L16;
        TextView r33 = this.h;
        if (r33 == null) goto L12;
        r33.setVisibility(8);
    L12:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b r34 = this.i;
        if (r34 == null) goto L63;
        r34.e(0);
    L63:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b r35 = this.i;
        if (r35 == null) goto L99;
        r35.g(s1.B(this.q));
        goto L99
    L16:
        if (z().getUiLayout() != 15) goto L23;
        TextView r36 = this.h;
        if (r36 == null) goto L20;
        r36.setVisibility(8);
    L20:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b r37 = this.i;
        if (r37 == null) goto L63;
        r37.e(0);
        goto L63
    L23:
        int r38 = z().getUiLayout();
        if (r38 == 9) goto L30;
        if (r38 == 1) goto L30;
        if (r38 == 6) goto L30;
        boolean r39 = false;
    L31:
        if (r39 == false) goto L33;
    L54:
        TextView r40 = this.h;
        if (r40 == null) goto L57;
        r40.setText(String.valueOf(r6.b()));
    L57:
        TextView r41 = this.h;
        if (r41 == null) goto L60;
        r41.setVisibility(0);
    L60:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b r42 = this.i;
        if (r42 == null) goto L63;
        r42.e(8);
        goto L63
    L33:
        if (z().getUiLayout() == 112) goto L54;
        if (z().getUiLayout() == 29) goto L54;
        if (aj0.b.c(z().getUiLayout()) == false) goto L45;
        TextView r43 = this.h;
        if (r43 == null) goto L42;
        r43.setVisibility(0);
    L42:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b r44 = this.i;
        if (r44 == null) goto L63;
        r44.e(8);
        goto L63
    L45:
        TextView r45 = this.h;
        if (r45 == null) goto L48;
        r45.setText(String.valueOf(r6.b() + 1));
    L48:
        TextView r46 = this.h;
        if (r46 == null) goto L51;
        r46.setVisibility(0);
    L51:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b r47 = this.i;
        if (r47 == null) goto L63;
        r47.e(8);
    L30:
        r39 = true;
        goto L31
    }

    public MultiLinkCommonEmptyMicSeatBasicLayer(MicSeatScene r2, m r3, xg0.a r4) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        Intrinsics.checkNotNullParameter(r3, "layoutConfig");
        Intrinsics.checkNotNullParameter(r4, "linkSeatAbilityProvider");
        super(r2, r4);
        this.u = r3;
        this.q = 2131919823;
        this.r = 2131919822;
        this.s = 2131919833;
        this.t = 2131919824;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.empty.b, jg0.f
    public final /* bridge */ /* synthetic */ void k(Object r1, int r2, Bundle r3) {
        x((MultiLinkNormalEmptyViewBinder.a) r1, r2, r3);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.empty.b
    public final void x(MultiLinkNormalEmptyViewBinder.a r5, int r6, Bundle r7) {
        Intrinsics.checkNotNullParameter(r5, "itemData");
        Intrinsics.checkNotNullParameter(r7, "payload");
        super.x(r5, r6, r7);
        Iterator<String> r8 = r7.keySet().iterator();
    L4:
        if (r8.hasNext() == false) goto L114;
        String r9 = r8.next();
        if (r9 == null) goto L4;
        String r1 = null;
        switch(r9.hashCode()) {
            case 223389637: goto L68;
            case 817798352: goto L65;
            case 1052690544: goto L62;
            case 1074297423: goto L22;
            case 1486084776: goto L17;
            case 1926167357: goto L12;
            default: goto L4;
        };
    L12:
        if (r9.equals("payload_key_position_invite_guide_update") == false) goto L4;
        if (r5.f() == false) goto L4;
        B();
        goto L4
    L17:
        if (r9.equals("payload_key_dynamic_data_update_for_empty_info") == false) goto L4;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b r10 = this.i;
        if (r10 == null) goto L4;
        r10.a = this.e;
        r10.h();
        goto L4
    L22:
        if (r9.equals("payload_key_interact_state_update") == false) goto L4;
        if (A() == true) goto L46;
        SelfDisciplineContext.a r11 = SelfDisciplineContext.Companion;
        if (r11.e() == false) goto L46;
        Integer r3 = (Integer) ((ge1.a) c.f()).b;
        if (r3 == null) goto L32;
        if (2 == r3.intValue()) goto L46;
    L32:
        SelfDisciplineContext r12 = r11.getContext();
        if (r12 == null) goto L4;
        com.bytedance.live.datacontext.m<String> r13 = r12.getCurrentTarget();
        if (r13 == null) goto L4;
        String r14 = (String) r13.getValue();
        if (r14 == null) goto L4;
        if ((!StringsKt.isBlank(r14)) == false) goto L41;
        r1 = r14;
    L41:
        if (r1 == null) goto L4;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b r15 = this.i;
        if (r15 == null) goto L4;
        r15.g(r1);
    L46:
        if (A() == false) goto L49;
        int r16 = this.q;
    L58:
        String r17 = s1.B(r16);
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b r0 = this.i;
        if (r0 == null) goto L4;
        r0.g(r17);
        goto L4
    L49:
        if (r5.g() == false) goto L51;
        r16 = this.t;
        goto L58
    L51:
        Integer r18 = (Integer) ((ge1.a) c.f()).b;
        if (r18 != null) goto L55;
    L57:
        r16 = this.s;
        goto L58
    L55:
        if (r18.intValue() != 2) goto L57;
        r16 = this.r;
        goto L58
    L62:
        if (r9.equals("payload_key_theme_update") == false) goto L4;
        v();
        goto L4
    L65:
        if (r9.equals("payload_key_position_item_update") == false) goto L4;
        y();
        goto L4
    L68:
        if (r9.equals("payload_key_friend_online_update") == false) goto L4;
        ch0.b r19 = r5.a();
        if (r19 == null) goto L4;
        if (r19.a == null) goto L4;
        Integer r20 = je0.d.h();
        if (r20 != null) goto L77;
    L79:
        if (r20 != null) goto L82;
    L84:
        if (r20 != null) goto L87;
    L89:
        if (r20 != null) goto L92;
    L94:
        if (r20 != null) goto L97;
    L99:
        if (r20 != null) goto L102;
    L104:
        if (r20 == null) goto L4;
        if (r20.intValue() != 3) goto L4;
    L108:
        ch0.b r21 = r5.a();
        Intrinsics.checkNotNull(r21);
        Intrinsics.checkNotNullParameter(r21, "friendOnlineInviteeInfo");
        ImageView r2 = this.l;
        IBaseUser r4 = r21.a;
        if (r4 == null) goto L111;
        r1 = r4.getAvatarThumbKt();
    L111:
        ImageUtil.loadRoundImage(r2, r1);
        this.f = r21;
        com.bytedance.android.live.liveinteract.a r22 = this.m;
        if (r22 == null) goto L4;
        r22.c();
        goto L4
    L102:
        if (r20.intValue() != 12) goto L104;
    L97:
        if (r20.intValue() != 11) goto L99;
    L92:
        if (r20.intValue() != 43) goto L94;
    L87:
        if (r20.intValue() != 102) goto L89;
    L82:
        if (r20.intValue() != 1) goto L84;
    L77:
        if (r20.intValue() != 5) goto L79;
    L114:
        u(false);
    }
}
