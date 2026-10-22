package com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog;

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
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.multianchor.model.LinkmicPositionItem;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApi;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.revenue.adventure.AdventureContext;
import com.bytedance.android.live.liveinteract.revenue.fight.TeamFightContext;
import com.bytedance.android.live.liveinteract.videotalk.themecompetition.ThemedCompetitionContext;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class m extends com.bytedance.android.livesdk.common.b implements View.OnClickListener {
    public TextView b;
    public TextView c;
    public TextView d;
    public TextView e;
    public TextView f;
    public TextView g;
    public TextView h;
    public TextView i;
    public TextView j;
    public String k;
    public int l;
    public int m;
    public final CompositeDisposable n;
    public boolean o;
    public int p;
    public final com.bytedance.android.live.liveinteract.plantform.core.y q;
    public final boolean r;
    public int s;
    public final IRoom t;
    public final boolean u;
    public final Boolean v;
    public final Boolean w;

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        super/*android.app.Dialog*/.onDetachedFromWindow();
        CompositeDisposable r0 = this.n;
        if (r0 == null) goto L6;
        r0.dispose();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(m r3) {
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
    public final void onClick(View r26) {
        Intrinsics.checkNotNullParameter(r26, "v");
        boolean r0 = je0.d.Y();
        int r1 = r26.getId();
        String r12 = "";
        if (r1 != 2131365462) goto L37;
        if (this.p != LinkmicPositionItem.LinkmicPositionStatus.LOCKED.ordinal()) goto L13;
        if (this.r == false) goto L9;
        int r2 = 2131918926;
    L10:
        f2.b(r2, 0);
        return;
    L9:
        r2 = 2131918925;
        goto L10
    L13:
        if (je0.d.w() == false) goto L15;
    L27:
        rj0.k.m2.getClass();
        rj0.k r3 = rj0.k.a.a();
        if (r3 == null) goto L30;
        r3.j3(this.s);
    L30:
        a(this);
    L31:
        HashMap r4 = new HashMap();
        r4.put("live_type", "video_live");
        TalkRoomLogUtils.B0(r4, null, null, 6);
        TalkRoomLogUtils.Q0(r4);
        r4.put("seat_num", String.valueOf(this.s + 1));
        String r5 = this.k;
        if (r5 == null) goto L35;
        r12 = r5;
    L35:
        r4.put("seat_name", r12);
        r4.put("setting_page", "edit_seat_setting");
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_anchor_audience_connection_seat_setting_click", r4, new Object[]{IRoom.class});
        return;
    L15:
        if (je0.d.M() == true) goto L27;
        if (com.bytedance.android.livesdk.chatroom.interact.model.d0.h(this.t) == false) goto L20;
    L21:
        ALogger.d("EditLinkmicPositionDialog", "updateLinkedPosition toPosition  : " + this.s);
        if (this.o == true) goto L31;
        if (this.t == null) goto L31;
        this.o = true;
        long r6 = System.currentTimeMillis();
        this.n.add(((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).updateLinkerPosition(this.t.getId(), this.t.getId(), this.s, 5).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new k(this, r6), new l(this, r6)));
        goto L31
    L20:
        if (je0.d.s() == false) goto L31;
    L37:
        if (r1 != 2131385960) goto L45;
        InputPositionNameDialog r7 = new InputPositionNameDialog(getContext(), this.s, this.t, null, this.u, true, 8);
        if (DialogLancet.shouldBlockDialogShow(r7) == false) goto L154;
        DialogLancet.handleBlockedDialogShow(r7);
    L43:
        a(this);
        jf0.a r8 = jf0.a.a;
        jf0.a.a(this.s, this.u, true, "name", r0);
        return;
    L154:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L151
    L42:
        DialogLancet.beforeDialogShow(r7);
        r7.show();
        DialogLancet.afterDialogShow(r7);
        goto L43
    L45:
        if (r1 != 2131371431) goto L53;
        InputPositionNameDialog r9 = new InputPositionNameDialog(getContext(), this.s, this.t, this.k, this.u, false, 32);
        if (DialogLancet.shouldBlockDialogShow(r9) == false) goto L158;
        DialogLancet.handleBlockedDialogShow(r9);
    L51:
        a(this);
        jf0.a r10 = jf0.a.a;
        jf0.a.b(this.s, this.u, "name", r0);
        return;
    L158:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L152
    L50:
        DialogLancet.beforeDialogShow(r9);
        r9.show();
        DialogLancet.afterDialogShow(r9);
        goto L51
    L53:
        if (r1 != 2131368795) goto L110;
        if (this.t == null) goto L173;
        boolean r11 = jc1.k.n(IMiddlewareUserService.class).user().isAdmin();
        if (ThemedCompetitionContext.Companion.g() == false) goto L64;
        int r13 = this.s;
        com.bytedance.android.live.liveinteract.plantform.core.y r14 = this.q;
        if (r14 == null) goto L64;
        if (r13 != r14.q()) goto L64;
    L99:
        boolean r15 = true;
    L101:
        if (r15 == true) goto L105;
        com.bytedance.android.live.liveinteract.plantform.core.y r16 = this.q;
        if (r16 == null) goto L105;
        r16.M(this.s);
    L105:
        jf0.a r17 = jf0.a.a;
        String r18 = this.k;
        if (r18 != null) goto L108;
        r18 = "";
    L108:
        r17.delete(r18, this.s, this.u, r11);
        long r19 = System.currentTimeMillis();
        this.n.add(((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).setPositionAttribute(this.t.getId(), this.s, "").compose(RxUtil.rxSchedulerHelper()).subscribe(new g(this, r19), new h(this, r19)));
        return;
    L64:
        com.bytedance.android.live.liveinteract.plantform.core.y r20 = this.q;
        if (r20 == null) goto L79;
        CopyOnWriteArrayList<ILinkPlayerInfoBridge> r21 = r20.c;
        if (r21 == null) goto L79;
        Iterator<ILinkPlayerInfoBridge> r22 = r21.iterator();
    L70:
        if (r22.hasNext() == false) goto L77;
        ILinkPlayerInfoBridge r23 = r22.next();
        if (r23.getUserPositionFlex() != this.s) goto L74;
        boolean r24 = true;
    L75:
        if (r24 == false) goto L70;
    L78:
        ILinkPlayerInfoBridge r25 = r23;
    L80:
        if (r25 == null) goto L84;
        IBaseUser r27 = r25.getUser();
        if (r27 == null) goto L84;
        String r28 = r27.getIdString();
    L85:
        IRoom r29 = this.t;
        if (r29 == null) goto L88;
        String r30 = r29.getOwnerUserIdString();
    L89:
        boolean r31 = Intrinsics.areEqual(r28, r30);
        if (ThemedCompetitionContext.Companion.g() == false) goto L94;
        if (r25 == null) goto L94;
        if (r31 == false) goto L99;
    L94:
        Integer r32 = je0.d.h();
        if (r32 != null) goto L98;
    L100:
        r15 = false;
        goto L101
    L98:
        if (r32.intValue() != 66) goto L100;
    L88:
        r30 = null;
    L84:
        r28 = null;
        goto L85
    L74:
        r24 = false;
        goto L75
    L77:
        r23 = null;
    L79:
        r25 = null;
        goto L80
    L173:
        return;
    L110:
        if (r1 != 2131391903) goto L128;
        int r110 = this.s;
        int r33 = this.p;
        LinkmicPositionItem.LinkmicPositionStatus r34 = LinkmicPositionItem.LinkmicPositionStatus.LOCKED;
        if (r33 != r34.ordinal()) goto L114;
        int r35 = LinkmicPositionItem.LinkmicPositionStatus.NORMAL.ordinal();
    L115:
        int r111 = r35;
        if (this.t == null) goto L174;
        HashMap r36 = new HashMap();
        r36.put("live_type", "video_live");
        TalkRoomLogUtils.B0(r36, null, null, 6);
        TalkRoomLogUtils.Q0(r36);
        if (this.p != LinkmicPositionItem.LinkmicPositionStatus.NORMAL.ordinal()) goto L121;
        String r37 = "on";
    L122:
        r36.put("button_type", r37);
        r36.put("seat_num", String.valueOf(this.s));
        String r38 = this.k;
        if (r38 == null) goto L126;
        r12 = r38;
    L126:
        r36.put("seat_name", r12);
        r36.put("setting_page", "edit_seat_setting");
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_anchor_audience_connection_seat_lock_click", r36, new Object[]{IRoom.class});
        long r39 = System.currentTimeMillis();
        int r40 = eg0.a.a;
        this.n.add(eg0.a.c(this.t.getId(), r110, r111).compose(RxUtil.rxSchedulerHelper()).subscribe(new i(this, r111, r110, r39), new j(this, r110, r111, r39)));
        return;
    L121:
        r37 = "off";
        goto L122
    L174:
        return;
    L114:
        r35 = r34.ordinal();
        goto L115
    L128:
        if (r1 != 2131365114) goto L131;
        a(this);
        return;
    L131:
        if (r1 != 2131362284) goto L142;
        Integer r41 = je0.d.h();
        if (r41 == null) goto L140;
        AdjustGuestPositionDialog r42 = new AdjustGuestPositionDialog(getContext(), je0.d.f(), r41.intValue(), this.t, this.s);
        if (DialogLancet.shouldBlockDialogShow(r42) == false) goto L156;
        DialogLancet.handleBlockedDialogShow(r42);
    L139:
        a(this);
        goto L140
    L156:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L153
    L138:
        DialogLancet.beforeDialogShow(r42);
        r42.show();
        DialogLancet.afterDialogShow(r42);
    L140:
        jf0.a r43 = jf0.a.a;
        jf0.a.a(this.s, true, true, "order", r0);
        return;
    L142:
        if (r1 != 2131362287) goto L172;
        TeamFightContext.a r44 = TeamFightContext.Companion;
        if (r44.d() == false) goto L148;
        com.bytedance.android.live.liveinteract.revenue.fight.c r45 = r44.c();
        if (r45 == null) goto L149;
        r45.e5(this.m, this.l, this.s, null);
    L149:
        a(this);
        return;
    L148:
        f2.c(s1.B(2131915773), 0);
        goto L149
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r20) {
        super/*android.app.Dialog*/.onCreate(r20);
        Long r3 = null;
        setContentView(LayoutInflater.from(getContext()).inflate(2131565456, null));
        Window r1 = getWindow();
        if (r1 == null) goto L5;
        r1.setGravity(80);
        r1.setLayout(-1, -2);
    L5:
        this.b = (TextView) findViewById(2131365114);
        this.c = (TextView) findViewById(2131374360);
        this.d = (TextView) findViewById(2131365462);
        this.e = (TextView) findViewById(2131385960);
        this.f = (TextView) findViewById(2131371431);
        this.g = (TextView) findViewById(2131368795);
        this.h = (TextView) findViewById(2131391903);
        this.j = (TextView) findViewById(2131362284);
        this.i = (TextView) findViewById(2131362287);
        TextView r10 = this.j;
        if (r10 == null) goto L8;
        r10.setOnClickListener(this);
    L8:
        TextView r11 = this.i;
        if (r11 == null) goto L11;
        r11.setOnClickListener(this);
    L11:
        TextView r12 = this.b;
        if (r12 == null) goto L14;
        r12.setOnClickListener(this);
    L14:
        TextView r13 = this.d;
        if (r13 == null) goto L17;
        r13.setOnClickListener(this);
    L17:
        TextView r14 = this.e;
        if (r14 == null) goto L20;
        r14.setOnClickListener(this);
    L20:
        TextView r15 = this.f;
        if (r15 == null) goto L23;
        r15.setOnClickListener(this);
    L23:
        TextView r16 = this.g;
        if (r16 == null) goto L26;
        r16.setOnClickListener(this);
    L26:
        TextView r17 = this.h;
        if (r17 == null) goto L29;
        r17.setOnClickListener(this);
    L29:
        int r18 = 0;
        if (je0.d.N() == false) goto L35;
        if (je0.d.w() == true) goto L35;
    L67:
        boolean r19 = true;
    L70:
        if (r19 == false) goto L73;
        UtilityKotlinExtentionsKt.t(findViewById(2131377912));
        UtilityKotlinExtentionsKt.t(findViewById(2131365462));
    L73:
        if (this.u == false) goto L76;
        UtilityKotlinExtentionsKt.t(findViewById(2131377912));
        UtilityKotlinExtentionsKt.t(findViewById(2131365462));
        UtilityKotlinExtentionsKt.t(findViewById(2131377929));
        UtilityKotlinExtentionsKt.t(findViewById(2131391903));
    L76:
        if (je0.d.N() == false) goto L81;
        if (je0.d.w() == true) goto L81;
        UtilityKotlinExtentionsKt.t(findViewById(2131377929));
        UtilityKotlinExtentionsKt.t(findViewById(2131391903));
    L81:
        if (je0.d.u() == false) goto L88;
        if (com.bytedance.android.livesdk.chatroom.interact.model.d0.h(this.t) == false) goto L88;
        boolean r110 = com.bytedance.android.live.liveinteract.chatroom.chatroom.util.a.a;
        if (vm2.d.c() == true) goto L88;
        UtilityKotlinExtentionsKt.t(findViewById(2131377912));
        UtilityKotlinExtentionsKt.t(findViewById(2131365462));
    L88:
        if (li0.d.g(null) == false) goto L93;
        if (TeamFightContext.Companion.d() == false) goto L93;
        UtilityKotlinExtentionsKt.w(findViewById(2131377910));
        UtilityKotlinExtentionsKt.w(findViewById(2131362287));
    L93:
        if (this.s == (-1)) goto L95;
    L104:
        com.bytedance.android.live.liveinteract.plantform.core.y r9 = this.q;
        if (r9 == null) goto L121;
        Iterator<LinkmicPositionItem> r21 = r9.e.iterator();
    L108:
        if (r21.hasNext() == false) goto L116;
        LinkmicPositionItem r111 = r21.next();
        Iterator<LinkmicPositionItem> r112 = r21;
        if (r111.getPosition() != this.s) goto L112;
        boolean r2 = true;
    L113:
        if (r2 == true) goto L117;
        r21 = r112;
    L117:
        LinkmicPositionItem r113 = r111;
        if (r113 == null) goto L121;
        this.k = r113.getActiveName();
        goto L121
    L112:
        r2 = false;
        goto L113
    L116:
        r111 = null;
    L121:
        if (TextUtils.isEmpty(this.k) == true) goto L124;
        UtilityKotlinExtentionsKt.t(findViewById(2131385960));
        UtilityKotlinExtentionsKt.t(findViewById(2131377927));
        UtilityKotlinExtentionsKt.w(findViewById(2131371431));
        UtilityKotlinExtentionsKt.w(findViewById(2131377916));
        UtilityKotlinExtentionsKt.w(findViewById(2131368795));
        UtilityKotlinExtentionsKt.w(findViewById(2131377913));
    L124:
        if (TeamFightContext.Companion.h() == false) goto L129;
        if (li0.d.g(null) == true) goto L129;
        UtilityKotlinExtentionsKt.t(findViewById(2131385960));
        UtilityKotlinExtentionsKt.t(findViewById(2131377927));
        UtilityKotlinExtentionsKt.t(findViewById(2131371431));
        UtilityKotlinExtentionsKt.t(findViewById(2131377916));
        UtilityKotlinExtentionsKt.t(findViewById(2131368795));
        UtilityKotlinExtentionsKt.t(findViewById(2131377913));
    L129:
        if (je0.d.M() == false) goto L131;
    L132:
        UtilityKotlinExtentionsKt.w(findViewById(2131377912));
        UtilityKotlinExtentionsKt.w(findViewById(2131365462));
        UtilityKotlinExtentionsKt.w(findViewById(2131391903));
        UtilityKotlinExtentionsKt.w(findViewById(2131377929));
        UtilityKotlinExtentionsKt.t(findViewById(2131385960));
        UtilityKotlinExtentionsKt.t(findViewById(2131377927));
        UtilityKotlinExtentionsKt.t(findViewById(2131371431));
        UtilityKotlinExtentionsKt.t(findViewById(2131377916));
        UtilityKotlinExtentionsKt.t(findViewById(2131368795));
        UtilityKotlinExtentionsKt.t(findViewById(2131377913));
    L134:
        if (gh0.a.d() == true) goto L141;
        com.bytedance.android.livesdk.user.e r4 = jc1.k.n(IMiddlewareUserService.class).user();
        IRoom r5 = this.t;
        if (r5 == null) goto L139;
        r3 = Long.valueOf(r5.getRoomId());
    L139:
        if (r4.t(r3) == true) goto L141;
        UtilityKotlinExtentionsKt.t(findViewById(2131385960));
        UtilityKotlinExtentionsKt.t(findViewById(2131377927));
        UtilityKotlinExtentionsKt.t(findViewById(2131371431));
        UtilityKotlinExtentionsKt.t(findViewById(2131377916));
        UtilityKotlinExtentionsKt.t(findViewById(2131368795));
        UtilityKotlinExtentionsKt.t(findViewById(2131377913));
    L141:
        Integer r6 = je0.d.h();
        if (r6 == null) goto L148;
        if (r6.intValue() != 24) goto L148;
        UtilityKotlinExtentionsKt.t(findViewById(2131385960));
        UtilityKotlinExtentionsKt.t(findViewById(2131377927));
        UtilityKotlinExtentionsKt.t(findViewById(2131371431));
        UtilityKotlinExtentionsKt.t(findViewById(2131377916));
        UtilityKotlinExtentionsKt.t(findViewById(2131368795));
        UtilityKotlinExtentionsKt.t(findViewById(2131377913));
    L148:
        if (je0.d.f() != 12) goto L160;
        Integer r7 = je0.d.h();
        if (r7 != null) goto L153;
    L154:
        Integer r8 = je0.d.h();
        if (r8 == null) goto L160;
        if (r8.intValue() != 6) goto L160;
    L159:
        UtilityKotlinExtentionsKt.t(findViewById(2131391903));
        UtilityKotlinExtentionsKt.t(findViewById(2131377929));
        goto L160
    L153:
        if (r7.intValue() == 112) goto L159;
    L160:
        Integer r22 = je0.d.h();
        if (r22 == null) goto L167;
        if (r22.intValue() != 43) goto L167;
        UtilityKotlinExtentionsKt.t(findViewById(2131391903));
        UtilityKotlinExtentionsKt.t(findViewById(2131377929));
    L167:
        if (d.e() == true) goto L229;
        Boolean r23 = this.v;
        Boolean r114 = Boolean.TRUE;
        if (Intrinsics.areEqual(r23, r114) == true) goto L229;
        if (d.b(this.s) == true) goto L229;
        AdventureContext.Companion.getClass();
        if (AdventureContext.a.a() == true) goto L229;
        if (Intrinsics.areEqual(this.w, r114) == false) goto L214;
        if (d.a() == false) goto L214;
        IRoom r24 = this.t;
        if (r24 == null) goto L200;
        if (r24.isLiveTypeAudio() != true) goto L200;
        if (vm2.d.c() == true) goto L186;
    L193:
        TextView r115 = (TextView) findViewById(2131362284);
        if (r115 == null) goto L196;
        r115.setVisibility(8);
    L196:
        View r25 = findViewById(2131377909);
        if (r25 == null) goto L235;
        r25.setVisibility(8);
    L235:
        Integer r26 = je0.d.h();
        if (r26 != null) goto L239;
    L240:
        Integer r27 = je0.d.h();
        if (r27 != null) goto L244;
    L260:
        if (je0.d.P() == false) goto L265;
        View r28 = findViewById(2131377909);
        if (r28 == null) goto L265;
        UtilityKotlinExtentionsKt.t(r28);
    L265:
        if (je0.d.N() == false) goto L269;
        if (je0.d.w() == true) goto L269;
    L272:
        int r29 = this.s;
    L274:
        TextView r30 = this.c;
        if (r30 == null) goto L277;
        r30.setText(s1.C(2131919009, new Object[]{String.valueOf(r29)}));
    L277:
        IInteractService r31 = (IInteractService) jc1.k.n(IInteractService.class);
        Integer r32 = je0.d.h();
        if (r32 == null) goto L280;
        r18 = r32.intValue();
    L280:
        int r33 = this.s;
        if (r33 != (-1)) goto L284;
        r33 = r33 + 1;
    L284:
        if (r31.isVoiceMultiEnlargeSeat(r18, r33) == false) goto L288;
        TextView r34 = this.c;
        if (r34 == null) goto L288;
        r34.setText(s1.B(2131919008));
    L288:
        com.bytedance.android.live.liveinteract.plantform.core.y r35 = this.q;
        if (r35 == null) goto L291;
        int r36 = r35.P4(this.s);
    L292:
        this.p = r36;
        TextView r37 = (TextView) findViewById(2131391903);
        if (this.p != LinkmicPositionItem.LinkmicPositionStatus.LOCKED.ordinal()) goto L295;
        int r38 = 2131919006;
    L296:
        r37.setText(s1.B(r38));
        int r39 = li0.d.b(this.s);
        if (r39 != 1) goto L299;
        int r40 = 2;
    L300:
        this.l = r40;
        this.m = 2;
        TextView r41 = (TextView) findViewById(2131362287);
        if (r39 != 1) goto L303;
        String r42 = s1.B(2131915771);
    L304:
        r41.setText(r42);
        return;
    L303:
        r42 = s1.B(2131915772);
        goto L304
    L299:
        r40 = 1;
        goto L300
    L295:
        r38 = 2131918998;
        goto L296
    L291:
        r36 = LinkmicPositionItem.LinkmicPositionStatus.NORMAL.ordinal();
    L269:
        if (((IInteractService) jc1.k.n(IInteractService.class)).getLinkPanelTransitService() != null) goto L271;
    L273:
        r29 = this.s + 1;
        goto L274
    L271:
        if (com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.f.d() != true) goto L273;
    L244:
        if (r27.intValue() != 30) goto L260;
    L245:
        UtilityKotlinExtentionsKt.w(findViewById(2131362284));
        UtilityKotlinExtentionsKt.w(findViewById(2131377909));
        UtilityKotlinExtentionsKt.t(findViewById(2131385960));
        UtilityKotlinExtentionsKt.t(findViewById(2131377927));
        UtilityKotlinExtentionsKt.t(findViewById(2131371431));
        UtilityKotlinExtentionsKt.t(findViewById(2131377916));
        UtilityKotlinExtentionsKt.t(findViewById(2131368795));
        UtilityKotlinExtentionsKt.t(findViewById(2131377913));
        if (d.b(this.s) == true) goto L253;
        TextView r43 = (TextView) findViewById(2131362284);
        if (r43 == null) goto L250;
        UtilityKotlinExtentionsKt.w(r43);
    L250:
        View r44 = findViewById(2131377909);
        if (r44 == null) goto L260;
        UtilityKotlinExtentionsKt.w(r44);
        goto L260
    L253:
        TextView r45 = (TextView) findViewById(2131362284);
        if (r45 == null) goto L256;
        UtilityKotlinExtentionsKt.t(r45);
    L256:
        View r46 = findViewById(2131377909);
        if (r46 == null) goto L260;
        UtilityKotlinExtentionsKt.t(r46);
        goto L260
    L239:
        if (r26.intValue() == 28) goto L245;
    L186:
        if (d.h() == false) goto L193;
        TextView r47 = (TextView) findViewById(2131362284);
        if (r47 == null) goto L190;
        r47.setVisibility(0);
    L190:
        View r48 = findViewById(2131377909);
        if (r48 == null) goto L235;
        r48.setVisibility(0);
    L200:
        if (d.c() == false) goto L207;
        TextView r116 = (TextView) findViewById(2131362284);
        if (r116 == null) goto L204;
        r116.setVisibility(8);
    L204:
        View r117 = findViewById(2131377909);
        if (r117 == null) goto L235;
        r117.setVisibility(8);
        goto L235
    L207:
        TextView r49 = (TextView) findViewById(2131362284);
        if (r49 == null) goto L210;
        r49.setVisibility(0);
    L210:
        View r50 = findViewById(2131377909);
        if (r50 == null) goto L235;
        r50.setVisibility(0);
    L214:
        if (je0.d.Y() == true) goto L216;
    L223:
        TextView r51 = (TextView) findViewById(2131362284);
        if (r51 == null) goto L226;
        r51.setVisibility(0);
    L226:
        View r52 = findViewById(2131377909);
        if (r52 == null) goto L235;
        r52.setVisibility(0);
        goto L235
    L216:
        if (Intrinsics.areEqual(this.w, r114) == false) goto L223;
        TextView r118 = (TextView) findViewById(2131362284);
        if (r118 == null) goto L220;
        r118.setVisibility(8);
    L220:
        View r53 = findViewById(2131377909);
        if (r53 == null) goto L235;
        r53.setVisibility(8);
    L229:
        TextView r119 = (TextView) findViewById(2131362284);
        if (r119 == null) goto L232;
        r119.setVisibility(8);
    L232:
        View r54 = findViewById(2131377909);
        if (r54 == null) goto L235;
        r54.setVisibility(8);
        goto L235
    L131:
        if (je0.d.s() == false) goto L134;
    L95:
        if (je0.d.f() != 5) goto L104;
        Integer r55 = je0.d.h();
        if (r55 == null) goto L104;
        if (r55.intValue() != 21) goto L104;
        if (d.a() == false) goto L104;
        this.s++;
    L35:
        if (je0.d.N() == false) goto L58;
        if (je0.d.w() == false) goto L58;
        com.bytedance.live.datacontext.j r120 = com.bytedance.android.live.liveinteract.api.utils.m.d().getVideoTalkRoomSubScene();
        if (r120 == null) goto L52;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r121 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r120.getValue();
        if (r121 == null) goto L52;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r122 = r121.t();
        if (r122 == null) goto L52;
        List r123 = r122.b;
        if (r123 == null) goto L52;
        if (r123.contains(14) == true) goto L50;
        r123 = null;
    L50:
        if (r123 == null) goto L52;
        boolean r124 = true;
    L53:
        if (r124 == false) goto L58;
        if (li0.d.g(null) == true) goto L58;
    L52:
        r124 = false;
    L58:
        if (je0.d.u() == true) goto L60;
    L62:
        Integer r125 = je0.d.h();
        if (r125 != null) goto L66;
    L68:
        r19 = false;
        goto L70
    L66:
        if (r125.intValue() != 24) goto L68;
    L60:
        if (com.bytedance.android.livesdk.chatroom.interact.model.d0.h(this.t) == true) goto L62;
        goto L62
    }

    public m(Context r2, boolean r3, int r4, IRoom r5, boolean r6, Boolean r7, Boolean r8) {
        Intrinsics.checkNotNullParameter(r2, "mContext");
        super(r2, true);
        this.r = r3;
        this.s = r4;
        this.t = r5;
        this.u = r6;
        this.v = r7;
        this.w = r8;
        this.k = "";
        this.l = -1;
        this.n = new CompositeDisposable();
        this.p = LinkmicPositionItem.LinkmicPositionStatus.NORMAL.ordinal();
        this.q = (com.bytedance.android.live.liveinteract.plantform.core.y) ((IInteractService) jc1.k.n(IInteractService.class)).getLinkUserInfoCenter();
    }

    public /* synthetic */ m(Context r9, boolean r10, int r11, IRoom r12, boolean r13, Boolean r14, int r15) {
        if ((r15 & 16) == 0) goto L5;
        boolean r5 = false;
    L7:
        if ((r15 & 32) == 0) goto L9;
        Boolean r16 = Boolean.FALSE;
    L10:
        Boolean r6 = r16;
        if ((r15 & 64) == 0) goto L13;
        r14 = Boolean.FALSE;
    L13:
        this(r9, r10, r11, r12, r5, r6, r14);
        return;
    L9:
        r16 = null;
        goto L10
    L5:
        r5 = r13;
        goto L7
    }
}
