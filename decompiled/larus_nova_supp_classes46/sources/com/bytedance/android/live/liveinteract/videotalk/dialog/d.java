package com.bytedance.android.live.liveinteract.videotalk.dialog;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.AdjustGuestPositionDialog;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.InputPositionNameDialog;
import com.bytedance.android.live.liveinteract.multianchor.model.LinkmicPositionItem;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApi;
import com.bytedance.android.live.liveinteract.plantform.core.y;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.revenue.adventure.AdventureContext;
import com.bytedance.android.live.liveinteract.revenue.fight.TeamFightContext;
import com.bytedance.android.live.liveinteract.revenuebase.MultiRevenueDataContext;
import com.bytedance.android.live.liveinteract.videotalk.themecompetition.ThemedCompetitionContext;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.chatroom.interact.model.d0;
import com.bytedance.android.livesdk.multilink.base.model.c0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d extends com.bytedance.android.livesdk.common.b implements View.OnClickListener {
    public TextView b;
    public TextView c;
    public TextView d;
    public TextView e;
    public TextView f;
    public TextView g;
    public TextView h;
    public TextView i;
    public String j;
    public TextView k;
    public boolean l;
    public final CompositeDisposable m;
    public final y n;
    public final IRoom o;
    public int p;
    public int q;
    public final int r;
    public final ILinkPlayerInfoBridge s;
    public final DataCenter t;

    public final boolean b() {
        if (je0.d.N() == false) goto L7;
        if (je0.d.w() == true) goto L7;
    L10:
        return true;
    L7:
        if (je0.d.u() == true) goto L9;
    L11:
        return false;
    L9:
        if (d0.h(this.o) == true) goto L11;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        super/*android.app.Dialog*/.onDetachedFromWindow();
        CompositeDisposable r0 = this.m;
        if (r0 == null) goto L6;
        r0.dispose();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(d r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L10;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public final void onClick(View r15) {
        Intrinsics.checkNotNullParameter(r15, "v");
        int r0 = r15.getId();
        boolean r2 = true;
        if (r0 != 2131386397) goto L6;
        a(this);
        xs2.b.a().post(new UserProfileEvent(this.s.getUser()).setClickUserPosition("pk_linked_audience").setReportSource("audience_audio").setReportType("data_card_linked_audience").setShowSendGift(true));
        return;
    L6:
        if (r0 != 2131365114) goto L9;
        a(this);
        return;
    L9:
        if (r0 != 2131362284) goto L26;
        int r16 = this.r;
        if (r16 != (-1)) goto L15;
        r16 = this.s.getUserPosition();
    L15:
        if (b() == false) goto L17;
        r16 = r16 - 1;
    L17:
        Integer r1 = je0.d.h();
        if (r1 == null) goto L25;
        AdjustGuestPositionDialog r3 = new AdjustGuestPositionDialog(getContext(), je0.d.f(), r1.intValue(), this.o, r16);
        if (DialogLancet.shouldBlockDialogShow(r3) == false) goto L174;
        DialogLancet.handleBlockedDialogShow(r3);
    L24:
        a(this);
        goto L25
    L174:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L171
    L23:
        DialogLancet.beforeDialogShow(r3);
        r3.show();
        DialogLancet.afterDialogShow(r3);
    L25:
        jf0.a r4 = jf0.a.a;
        jf0.a.b(r16, true, "order", this.l);
        return;
    L26:
        boolean r5 = false;
        String r6 = null;
        String r7 = null;
        String r8 = null;
        String r9 = null;
        Object r10 = null;
        if (r0 != 2131385960) goto L61;
        a(this);
        if (this.r != (-1)) goto L37;
        ILinkPlayerInfoBridge r17 = this.s;
        if (r17 == null) goto L34;
        Integer r18 = Integer.valueOf(r17.getUserPosition());
    L35:
        r18.intValue();
        goto L37
    L34:
        r18 = null;
    L37:
        if (je0.d.s() == true) goto L42;
        if (je0.d.M() == true) goto L42;
        UtilityKotlinExtentionsKt.w(findViewById(2131385960));
    L42:
        if (TeamFightContext.Companion.h() == false) goto L45;
        f2.b(2131922781, 0);
        return;
    L45:
        if (this.s.isEnlarged() == true) goto L54;
        ArrayList<c0> r19 = com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.d.a;
        IBaseUser r110 = this.s.getUser();
        if (r110 == null) goto L50;
        r7 = r110.getIdString();
    L50:
        if (com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.d.g(r7) == false) goto L54;
        if (com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.d.d() == false) goto L54;
        f2.b(2131919001, 0);
        return;
    L54:
        InputPositionNameDialog r111 = new InputPositionNameDialog(getContext(), this.s.getUserPosition(), this.o, null, true, true, 8);
        if (DialogLancet.shouldBlockDialogShow(r111) == false) goto L178;
        DialogLancet.handleBlockedDialogShow(r111);
    L59:
        a(this);
        return;
    L178:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L172
    L58:
        DialogLancet.beforeDialogShow(r111);
        r111.show();
        DialogLancet.afterDialogShow(r111);
        goto L59
    L61:
        if (r0 != 2131371431) goto L83;
        if (this.s.isEnlarged() == true) goto L73;
        ArrayList<c0> r112 = com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.d.a;
        IBaseUser r113 = this.s.getUser();
        if (r113 == null) goto L68;
        r8 = r113.getIdString();
    L68:
        if (com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.d.g(r8) == false) goto L73;
        if (com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.d.d() == false) goto L73;
        f2.b(2131919001, 0);
        return;
    L73:
        if (this.r != (-1)) goto L76;
        this.s.getUserPosition();
    L76:
        b();
        InputPositionNameDialog r114 = new InputPositionNameDialog(getContext(), this.s.getUserPosition(), this.o, this.j, true, false, 32);
        if (DialogLancet.shouldBlockDialogShow(r114) == false) goto L176;
        DialogLancet.handleBlockedDialogShow(r114);
    L81:
        a(this);
        jf0.a r115 = jf0.a.a;
        jf0.a.b(this.s.getUserPosition(), true, "name", this.l);
        return;
    L176:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L173
    L80:
        DialogLancet.beforeDialogShow(r114);
        r114.show();
        DialogLancet.afterDialogShow(r114);
        goto L81
    L83:
        if (r0 != 2131368795) goto L129;
        if (this.o != null) goto L88;
        return;
    L88:
        if (this.s.isEnlarged() == true) goto L98;
        ArrayList<c0> r116 = com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.d.a;
        IBaseUser r117 = this.s.getUser();
        if (r117 == null) goto L92;
        String r118 = r117.getIdString();
    L94:
        if (com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.d.g(r118) == false) goto L98;
        if (com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.d.d() == false) goto L98;
        f2.b(2131919001, 0);
        return;
    L92:
        r118 = null;
    L98:
        ThemedCompetitionContext.a r119 = ThemedCompetitionContext.Companion;
        if (r119.g() == false) goto L109;
        ILinkPlayerInfoBridge r11 = this.s;
        if (r11 == null) goto L103;
        Integer r12 = Integer.valueOf(r11.getUserPosition());
    L104:
        int r13 = r12.intValue();
        y r14 = this.n;
        if (r14 == null) goto L109;
        if (r13 != r14.q()) goto L109;
    L123:
        if (r2 == true) goto L127;
        y r120 = this.n;
        if (r120 == null) goto L127;
        r120.M(this.s.getUserPosition());
    L127:
        long r20 = System.currentTimeMillis();
        this.m.add(((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).setPositionAttribute(this.o.getId(), this.s.getUserPosition(), "").compose(RxUtil.rxSchedulerHelper()).subscribe(new b(this, r20), new c(this, r20)));
        return;
    L103:
        r12 = null;
    L109:
        ILinkPlayerInfoBridge r21 = this.s;
        if (r21 == null) goto L114;
        IBaseUser r22 = r21.getUser();
        if (r22 == null) goto L114;
        String r23 = r22.getIdString();
    L115:
        IRoom r24 = this.o;
        if (r24 == null) goto L118;
        r9 = r24.getOwnerUserIdString();
    L118:
        boolean r25 = Intrinsics.areEqual(r23, r9);
        if (r119.g() == false) goto L122;
        if (r25 == false) goto L123;
    L122:
        r2 = false;
    L114:
        r23 = null;
        goto L115
    L129:
        if (r0 != 2131385955) goto L159;
        MultiRevenueDataContext.Companion.getClass();
        com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.a r26 = MultiRevenueDataContext.a.d();
        if (r26 == null) goto L136;
        if (r26.n(3) == true) goto L136;
        return;
    L136:
        if (je0.d.M() == false) goto L139;
        f2.b(2131918756, 0);
        return;
    L139:
        if (fj0.e.l() == true) goto L141;
    L143:
        IBaseUser r27 = this.s.getUser();
        if (r27 == null) goto L157;
        Object r121 = r15.getTag();
        if ((r121 instanceof Boolean) == false) goto L149;
        r10 = r121;
    L149:
        Boolean r28 = (Boolean) r10;
        if (r28 == null) goto L152;
        r5 = r28.booleanValue();
    L152:
        boolean r29 = !r5;
        String r30 = r27.getIdString();
        com.bytedance.live.datacontext.m r122 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r122 == null) goto L157;
        IRoom r123 = (IRoom) r122.getValue();
        if (r123 == null) goto L157;
        oe0.d.c(r29, r30, r123.getRoomId(), getContext(), this.t);
    L157:
        a(this);
        return;
    L141:
        if (fj0.c.a() == true) goto L143;
        f2.b(2131919053, 0);
        return;
    L159:
        if (r0 != 2131362287) goto L193;
        TeamFightContext.a r124 = TeamFightContext.Companion;
        if (r124.d() == false) goto L168;
        com.bytedance.android.live.liveinteract.revenue.fight.c r31 = r124.c();
        if (r31 == null) goto L169;
        int r32 = this.q;
        int r33 = this.p;
        long r125 = this.r;
        IBaseUser r126 = this.s.getUser();
        if (r126 == null) goto L167;
        r6 = r126.getIdString();
    L167:
        r31.e5(r32, r33, r125, r6);
    L169:
        a(this);
        return;
    L168:
        f2.c(s1.B(2131915773), 0);
        goto L169
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r13) {
        super/*android.app.Dialog*/.onCreate(r13);
        setContentView(LayoutInflater.from(getContext()).inflate(2131565794, null));
        Window r14 = getWindow();
        if (r14 == null) goto L5;
        r14.setGravity(80);
        r14.setLayout(-1, -2);
    L5:
        this.l = je0.d.Y();
        this.b = (TextView) findViewById(2131386397);
        this.c = (TextView) findViewById(2131365114);
        this.d = (TextView) findViewById(2131374360);
        this.e = (TextView) findViewById(2131385955);
        this.f = (TextView) findViewById(2131385960);
        this.g = (TextView) findViewById(2131371431);
        this.h = (TextView) findViewById(2131368795);
        this.k = (TextView) findViewById(2131362284);
        this.i = (TextView) findViewById(2131362287);
        TextView r6 = this.k;
        if (r6 == null) goto L8;
        r6.setOnClickListener(this);
    L8:
        TextView r7 = this.b;
        if (r7 == null) goto L11;
        r7.setOnClickListener(this);
    L11:
        TextView r8 = this.c;
        if (r8 == null) goto L14;
        r8.setOnClickListener(this);
    L14:
        TextView r9 = this.e;
        if (r9 == null) goto L17;
        r9.setOnClickListener(this);
    L17:
        TextView r10 = this.f;
        if (r10 == null) goto L20;
        r10.setOnClickListener(this);
    L20:
        TextView r11 = this.g;
        if (r11 == null) goto L23;
        r11.setOnClickListener(this);
    L23:
        TextView r12 = this.h;
        if (r12 == null) goto L26;
        r12.setOnClickListener(this);
    L26:
        TextView r15 = this.i;
        if (r15 == null) goto L29;
        r15.setOnClickListener(this);
    L29:
        TextView r16 = this.d;
        if (r16 == null) goto L36;
        Object[] r17 = new Object[1];
        IBaseUser r18 = this.s.getUser();
        if (r18 == null) goto L34;
        String r19 = r18.getNickName();
    L35:
        r17[0] = r19;
        r16.setText(s1.C(2131920072, r17));
        goto L36
    L34:
        r19 = null;
    L36:
        y r20 = this.n;
        if (r20 == null) goto L54;
        Iterator<LinkmicPositionItem> r21 = r20.e.iterator();
    L40:
        if (r21.hasNext() == false) goto L49;
        LinkmicPositionItem r22 = r21.next();
        int r110 = (int) r22.getPosition();
        ILinkPlayerInfoBridge r111 = this.s;
        if (r111 != null) goto L44;
    L46:
        boolean r112 = false;
    L47:
        if (r112 == false) goto L40;
    L50:
        LinkmicPositionItem r23 = r22;
        if (r23 == null) goto L54;
        this.j = r23.getActiveName();
        goto L54
    L44:
        if (r110 != r111.getUserPosition()) goto L46;
        r112 = true;
        goto L47
    L49:
        r22 = null;
    L54:
        if (TextUtils.isEmpty(this.j) == true) goto L56;
        UtilityKotlinExtentionsKt.t(findViewById(2131385960));
        UtilityKotlinExtentionsKt.t(findViewById(2131377927));
        UtilityKotlinExtentionsKt.w(findViewById(2131371431));
        UtilityKotlinExtentionsKt.w(findViewById(2131377916));
        UtilityKotlinExtentionsKt.w(findViewById(2131368795));
        UtilityKotlinExtentionsKt.w(findViewById(2131377913));
    L56:
        TeamFightContext.a r24 = TeamFightContext.Companion;
        if (r24.h() == false) goto L60;
        UtilityKotlinExtentionsKt.t(findViewById(2131385960));
        UtilityKotlinExtentionsKt.t(findViewById(2131377927));
        UtilityKotlinExtentionsKt.t(findViewById(2131371431));
        UtilityKotlinExtentionsKt.t(findViewById(2131377916));
        UtilityKotlinExtentionsKt.t(findViewById(2131368795));
        UtilityKotlinExtentionsKt.t(findViewById(2131377913));
    L60:
        if (je0.d.M() == false) goto L62;
    L63:
        UtilityKotlinExtentionsKt.t(findViewById(2131385960));
        UtilityKotlinExtentionsKt.t(findViewById(2131377927));
        UtilityKotlinExtentionsKt.t(findViewById(2131371431));
        UtilityKotlinExtentionsKt.t(findViewById(2131377916));
        UtilityKotlinExtentionsKt.t(findViewById(2131368795));
        UtilityKotlinExtentionsKt.t(findViewById(2131377913));
    L65:
        if (com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.d.f() == false) goto L67;
        UtilityKotlinExtentionsKt.t(findViewById(2131385960));
        UtilityKotlinExtentionsKt.t(findViewById(2131377927));
        UtilityKotlinExtentionsKt.t(findViewById(2131371431));
        UtilityKotlinExtentionsKt.t(findViewById(2131377916));
        UtilityKotlinExtentionsKt.t(findViewById(2131368795));
        UtilityKotlinExtentionsKt.t(findViewById(2131377913));
    L67:
        IBaseUser r113 = this.s.getUser();
        if (r113 == null) goto L70;
        String r114 = r113.getIdString();
    L71:
        com.bytedance.live.datacontext.m r2 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r2 == null) goto L76;
        IRoom r3 = (IRoom) r2.getValue();
        if (r3 == null) goto L76;
        String r4 = r3.getOwnerUserIdString();
    L77:
        Intrinsics.areEqual(r114, r4);
        if (com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.d.e() == false) goto L80;
    L85:
        TextView r115 = (TextView) findViewById(2131362284);
        if (r115 == null) goto L88;
        r115.setVisibility(8);
    L88:
        View r116 = findViewById(2131377909);
        if (r116 == null) goto L91;
        r116.setVisibility(8);
    L91:
        TextView r117 = this.e;
        if (r117 == null) goto L94;
        UtilityKotlinExtentionsKt.w(r117);
    L94:
        TextView r118 = this.e;
        if (r118 == null) goto L98;
        r118.setTag(Boolean.valueOf(this.s.isEnlarged()));
    L98:
        if (this.s.isEnlarged() == false) goto L102;
        TextView r119 = this.e;
        if (r119 == null) goto L105;
        r119.setText(2131922760);
    L105:
        String r5 = "";
        if (r24.d() == true) goto L108;
    L122:
        IBaseUser r120 = this.s.getUser();
        if (r120 == null) goto L128;
        String r121 = r120.getIdString();
        if (r121 == null) goto L128;
        r5 = r121;
    L128:
        int r122 = li0.d.c(r5);
        if (r122 != 1) goto L131;
        int r0 = 2;
    L132:
        this.p = r0;
        this.q = 1;
        TextView r1 = (TextView) findViewById(2131362287);
        if (r122 != 1) goto L135;
        String r123 = s1.B(2131915771);
    L136:
        r1.setText(r123);
        return;
    L135:
        r123 = s1.B(2131915772);
        goto L136
    L131:
        r0 = 1;
        goto L132
    L108:
        if (li0.d.g(null) == false) goto L122;
        IBaseUser r124 = this.s.getUser();
        if (r124 == null) goto L113;
        String r125 = r124.getIdString();
        if (r125 == null) goto L113;
    L115:
        if (li0.d.c(r125) == (-1)) goto L122;
        TextView r126 = (TextView) findViewById(2131362287);
        if (r126 == null) goto L119;
        UtilityKotlinExtentionsKt.w(r126);
    L119:
        View r127 = findViewById(2131377910);
        if (r127 == null) goto L122;
        UtilityKotlinExtentionsKt.w(r127);
    L113:
        r125 = "";
        goto L115
    L102:
        TextView r128 = this.e;
        if (r128 == null) goto L105;
        r128.setText(2131922758);
        goto L105
    L80:
        if (this.s.isEnlarged() == true) goto L85;
        if (com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.d.b(this.r) == true) goto L85;
        AdventureContext.Companion.getClass();
        if (AdventureContext.a.a() == false) goto L91;
    L76:
        r4 = null;
        goto L77
    L70:
        r114 = null;
        goto L71
    L62:
        if (je0.d.s() == false) goto L65;
        goto L63
    }

    public d(Context r2, ILinkPlayerInfoBridge r3, DataCenter r4) {
        Intrinsics.checkNotNullParameter(r2, "mContext");
        Intrinsics.checkNotNullParameter(r3, "targetUser");
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        super(r2, true);
        this.s = r3;
        this.t = r4;
        this.j = "";
        this.m = new CompositeDisposable();
        this.n = (y) ((IInteractService) jc1.k.n(IInteractService.class)).getLinkUserInfoCenter();
        this.o = a0.n(r4);
        this.p = -1;
        this.r = -1;
    }
}
